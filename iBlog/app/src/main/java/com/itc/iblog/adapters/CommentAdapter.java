package com.itc.iblog.adapters;

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
import android.widget.Toast;

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
import com.itc.iblog.activities.MainActivity;
import com.itc.iblog.interfaces.ImageLoaderInterface;
import com.itc.iblog.models.CommentModel;
import com.itc.iblog.models.PostModel;

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

import de.hdodenhof.circleimageview.CircleImageView;

import static com.google.android.gms.internal.zzs.TAG;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {

    private final ImageLoaderInterface listener;
    private List<CommentModel> cardList;
    private String email;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView userName;
        public TextView userSurname;
        public TextView commentTime;
        public ImageView userImage;
        public TextView commentText;

        public MyViewHolder(View view) {
            super(view);
            userName = (TextView) view.findViewById(R.id.com_user_name);
            userSurname = (TextView) view.findViewById(R.id.com_user_email);
            userImage = (ImageView) view.findViewById(R.id.com_user_image);
            commentTime = (TextView) view.findViewById(R.id.comment_time);
            commentText =  (TextView) view.findViewById(R.id.comment_text);
        }
    }

    public CommentAdapter(List<CommentModel> cardList, ImageLoaderInterface listener) {
        this.cardList = cardList;
        this.listener = listener;
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference dbRef = mDatabase.child("Users");
        dbRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                email = (String) dataSnapshot.child("email").getValue();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_single_comment, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final CommentModel post = cardList.get(position);
        holder.userName.setText(post.getUserName());
        holder.userSurname.setText(post.getUserEmail());
        holder.commentTime.setText(post.getCommentTime().toString().substring(0,19));
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

        StorageReference pathReference = storageRef.child(post.getUserImage());

        final long ONE_MEGABYTE = 1024 * 1024;
        pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                if (bmp.equals(null)) {

                }
                holder.userImage.setImageBitmap(Bitmap.createScaledBitmap(bmp, 120, 120, false));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                System.out.println("Image not found.");
            }
        });
        holder.commentText.setText(post.getCommentText());

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }



}
