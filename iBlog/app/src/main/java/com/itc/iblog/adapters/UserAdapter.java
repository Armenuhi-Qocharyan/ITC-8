package com.itc.iblog.adapters;


import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.itc.iblog.R;
import com.itc.iblog.models.UserModel;
import com.itc.iblog.models.UsersModel;

import java.util.ArrayList;

import static com.itc.iblog.R.id.image;
import static com.itc.iblog.R.id.imageView;
import static com.itc.iblog.R.id.parent;

public class UserAdapter extends FirebaseRecyclerAdapter<UserAdapter.ViewHolder, UsersModel> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewAge;
        TextView textViewEmail;
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            textViewName = (TextView) view.findViewById(R.id.textview_name);
            textViewAge = (TextView) view.findViewById(R.id.textview_age);
            imageView = (ImageView) view.findViewById(R.id.user_image);
            textViewEmail = (TextView) view.findViewById(R.id.textview_email);
        }
    }

    public UserAdapter(Query query, @Nullable ArrayList<UsersModel> items,
                       @Nullable ArrayList<String> keys) {
        super(query, items, keys);
    }

    @Override public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_card, parent, false);

        return new ViewHolder(view);
    }


    @Override public void onBindViewHolder(final UserAdapter.ViewHolder holder, int position) {
        UsersModel item = getItem(position);
        holder.textViewName.setText(item.getUserName());
        holder.textViewAge.setText(String.valueOf(item.getAge()) + " years old");
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        if (item.getUrl() != null) {
            firebaseStorage.getReference().child(item.getUrl()).getDownloadUrl().addOnSuccessListener
                    (new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Picasso.with(holder.imageView.getContext()).load(uri.toString()).into(holder
                                    .imageView);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                }

            });
        } else {
            holder.imageView.setImageResource(R.drawable.user);
        }

        holder.textViewEmail.setText(item.getEmail());
    }

    @Override protected void itemAdded(UsersModel item, String key, int position) {

        Log.d("UserAdapter", "added");
    }

    @Override protected void itemChanged(UsersModel oldItem, UsersModel newItem, String key, int
            position) {
        Log.d("UserAdapter", "Changed an item.");
    }

    @Override protected void itemRemoved(UsersModel item, String key, int position) {
        Log.d("UserAdapter", "Removed an item from the adapter.");
    }

    @Override protected void itemMoved(UsersModel item, String key, int oldPosition, int
            newPosition) {
        Log.d("UserAdapter", "Moved an item.");
    }
}
