package com.itc.iblog.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.itc.iblog.R;
import com.itc.iblog.models.PostModel;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<PostModel> cardList;

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


    public ListAdapter(List<PostModel> cardList) {
        this.cardList = cardList;
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

        String path = post.getPostImagePath();

        if (path != null) {
            StorageReference pathReference = storageRef.child("Posts").child(post.getPostId()).child("image");
            final long ONE_MEGABYTE = 1024 * 1024;
            pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    int width = holder.cardView.getWidth();
                    holder.postImage.setImageBitmap(Bitmap.createScaledBitmap(bmp, width, 300, false));
                    holder.postImage.setVisibility(View.VISIBLE);


                    /*String file_path = Environment.getExternalStorageDirectory().getAbsolutePath() +
                            "/PostsImages";
                    File dir = new File(file_path);
                    if(!dir.exists())
                        dir.mkdirs();
                    File file = new File(dir, "post" + post.getPostImagePath() + ".png");
                    FileOutputStream fOut = null;
                    try {
                        fOut = new FileOutputStream(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    bmp.compress(Bitmap.CompressFormat.PNG, 85, fOut);
                    try {
                        fOut.flush();
                        System.out.println("Image downloaded");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fOut.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/


                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    System.out.println("Image not found.");
                }
            });
        }

        holder.likeCount.setText(post.getLikeCount().toString());

        if (post.getUsers().indexOf(post.getUserEmail()) == -1) {
            holder.likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Integer newLikeCount = Integer.parseInt(String.valueOf(post.getLikeCount())) + 1;
                    final FirebaseDatabase database = FirebaseDatabase.getInstance();
                    final DatabaseReference ref = database.getReference("Posts");
                    ref.child(post.getPostId()).child("likeCount").setValue(newLikeCount);
                    ArrayList<String> users = post.getUsers();
                    users.add(post.getUserEmail());

                    ref.child(post.getPostId()).child("users").setValue(users);
                }
            });
        } else {
            holder.likeButton.setEnabled(false);
        }
        holder.commentCount.setText(post.getCommentCount().toString());
        holder.favCount.setText(post.getFavCount().toString());

        holder.favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer newFavCount = Integer.parseInt(String.valueOf(post.getFavCount())) + 1;
                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference("Posts");
                ref.child(post.getPostId()).child("favCount").setValue(newFavCount);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }



}
