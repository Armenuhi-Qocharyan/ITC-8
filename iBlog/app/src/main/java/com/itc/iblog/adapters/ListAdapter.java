package com.itc.iblog.adapters;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.itc.iblog.R;
import com.itc.iblog.Services.RequestService;
import com.itc.iblog.interfaces.ImageLoaderInterface;
import com.itc.iblog.models.NotificationData;
import com.itc.iblog.models.PostModel;
import com.itc.iblog.models.PostRequestData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import static com.google.android.gms.internal.zzs.TAG;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private final ImageLoaderInterface listener;
    private List<PostModel> cardList;
    private String email;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView userName;
        public TextView userSurname;
        public TextView postTime;
        public ImageView userImage;
        public ImageView postImage;
        public TextView postTitle;
        public TextView postText;
        public TextView likeCount;
        public TextView favCount;
        public CardView cardView;
        public TextView commentCount;
        public ImageView likeButton;
        public ImageView favButton;

        public MyViewHolder(View view) {
            super(view);
             userName = (TextView) view.findViewById(R.id.user_name);
             userSurname = (TextView) view.findViewById(R.id.user_surname);
             userImage = (ImageView) view.findViewById(R.id.user_image);
             postTime = (TextView) view.findViewById(R.id.post_time);
             postImage = (ImageView) view.findViewById(R.id.post_image);
             postTitle = (TextView) view.findViewById(R.id.post_title);
             postText =  (TextView) view.findViewById(R.id.post_text);
             likeCount =  (TextView) view.findViewById(R.id.like_count);
             likeButton = (ImageView) view.findViewById(R.id.like);
             commentCount =  (TextView) view.findViewById(R.id.comment_count);
             cardView = (CardView) view.findViewById(R.id.card_view);
             favButton = (ImageView) view.findViewById(R.id.favorite);
             favCount = (TextView) view.findViewById(R.id.favorite_count);
        }
    }


    public ListAdapter(List<PostModel> cardList, ImageLoaderInterface listener,String email) {
        this.cardList = cardList;
        this.listener = listener;
        this.email = email;
    }

    public ListAdapter(List<PostModel> cardList, ImageLoaderInterface listener) {
        this.cardList = cardList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final PostModel post = cardList.get(position);
        holder.userName.setText(post.getUserName());
        holder.userSurname.setText(post.getUserEmail());
        holder.postTime.setText(post.getPostTime().toString().substring(0,19));
        holder.userImage.setImageResource(post.getUserImage());
        holder.postTitle.setText(post.getPostTitle());
        holder.postText.setText(post.getPostText());

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

        if (post.getPostImagePath() != null) {
            Bitmap bitmap = listener.loadImage(post);
            if (bitmap != null) {
                holder.postImage.setImageBitmap(bitmap);
                holder.postImage.setVisibility(View.VISIBLE);

            } else {
                holder.postImage.setVisibility(View.GONE);
            }
        } else {
            holder.postImage.setVisibility(View.GONE);
        }
        holder.likeCount.setText(post.getLikeCount().toString());



            holder.likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (post.getUsers().indexOf(email) < 0 ) {
                        Integer newLikeCount = Integer.parseInt(String.valueOf(post.getLikeCount())) + 1;
                        final FirebaseDatabase database = FirebaseDatabase.getInstance();
                        final DatabaseReference ref = database.getReference("Posts");
                        ref.child(post.getPostId()).child("likeCount").setValue(newLikeCount);
                        ArrayList<String> users = post.getUsers();
                        users.add(email);
                  //      NotificationData data = new NotificationData();
                    //    data.setTitle("Hello");
                  //      PostRequestData postRequestData = new PostRequestData();
                    //    postRequestData.setTo("/topics/" + email);
                      //  postRequestData.setData(data);
                  //      view.getContext().startService(new Intent(view.getContext(), RequestService.class));
                        ref.child(post.getPostId()).child("users").setValue(users);
                    }
                }
            });

        holder.commentCount.setText(post.getCommentCount().toString());
        holder.favCount.setText(post.getFavCount().toString());

        holder.favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                final DatabaseReference dbRef = mDatabase.child("Users");

                 dbRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                List<String> favPosts;
                                if (dataSnapshot.hasChild("favoritesPosts")) {
                                    favPosts = dataSnapshot.child("favoritesPosts").getValue(new GenericTypeIndicator<ArrayList<String>>() {});
                                } else {
                                    favPosts = new ArrayList<String>();
                                    favPosts.add("");
                                }
                                
                                if (favPosts.indexOf(post.getPostId()) == -1) {
                                    favPosts.add(post.getPostId());
                                    dbRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("favoritesPosts").setValue(favPosts);
                                    Integer newFavCount = Integer.parseInt(String.valueOf(post.getFavCount())) + 1;
                                    final FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    DatabaseReference ref = database.getReference("Posts");
                                    ref.child(post.getPostId()).child("favCount").setValue(newFavCount);
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }



}
