package com.itc.iblog.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.itc.iblog.R;
import com.itc.iblog.models.DataModel;

import java.util.List;

public class listAdapter extends RecyclerView.Adapter<listAdapter.MyViewHolder> {

    private List<DataModel> cardList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView userName;
        public TextView userSurname;
        public TextView postTime;
        public ImageView userImage;
        public ImageView postImage;
        public TextView postTitle;
        public TextView postText;
        public TextView likeCount;
        public TextView commentCount;

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
             commentCount =  (TextView) view.findViewById(R.id.comment_count);
        }
    }


    public listAdapter(List<DataModel> cardList) {
        this.cardList = cardList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        DataModel post = cardList.get(position);
        holder.userName.setText(post.getUserName());
        holder.userSurname.setText(post.getUserSurname());
        holder.postTime.setText(post.getPostTime());
        holder.userImage.setImageResource(post.getUserImage());
        holder.postTitle.setText(post.getPostTitle());
        holder.postText.setText(post.getPostText());

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

        String path = post.getPostImagePath();
        if (path != null) {
            StorageReference pathReference = storageRef.child("Posts").child(post.getPostImagePath()).child("image");

            final long ONE_MEGABYTE = 1024 * 1024;
            pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    if (bmp.equals(null)) {

                    }

                    holder.postImage.setImageBitmap(Bitmap.createScaledBitmap(bmp, 500, 500, false));

                    holder.postImage.setVisibility(View.VISIBLE);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    System.out.println("Image not found.");
                }
            });
        }

        holder.likeCount.setText(post.getLikeCount() + "");
        holder.commentCount.setText(post.getCommentCount() + "");
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }


}
