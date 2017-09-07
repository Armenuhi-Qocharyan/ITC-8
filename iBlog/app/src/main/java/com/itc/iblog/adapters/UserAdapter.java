package com.itc.iblog.adapters;


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
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;
import com.itc.iblog.R;
import com.itc.iblog.models.UserModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UserAdapter extends FirebaseRecyclerAdapter<UserAdapter.ViewHolder, UserModel> {
    private DatabaseReference mDatabase;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private TextView textViewAge;
        private TextView textViewEmail;
        private ImageView imageView;
        private ImageView follow;



        public ViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.textview_name);
            textViewAge =  view.findViewById(R.id.textview_age);
            imageView =  view.findViewById(R.id.user_image);
            follow = view.findViewById(R.id.follow);
            textViewEmail =  view.findViewById(R.id.textview_email);
        }
    }

    public UserAdapter(Query query, @Nullable ArrayList<UserModel> items,
                       @Nullable ArrayList<String> keys) {
        super(query, items, keys);
    }

    @Override public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_card, parent, false);

        return new ViewHolder(view);
    }


    @Override public void onBindViewHolder(final UserAdapter.ViewHolder holder, final int position) {
        final UserModel item = getItem(position);
        String key = getKeys().get(position);
        item.setUID(key);
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        holder.textViewAge.setText(String.valueOf(item.getAge()) + " years old");
        if (item.followings == null) {
            item.followings = new HashMap<>();
        }
        if (!item.getFollowings().containsKey(userId)) {
            holder.follow.setImageResource(R.drawable.heart);
        }

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

        holder.follow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addFollower(item, holder.follow);
            }
        });
    }

    private void addFollower(final UserModel item, final ImageView follow) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    mDatabase.child("Users").child(userId).child("followers").child(item.getUID()
                    ).setValue(true);
                    mDatabase.child("Users").child(item.getUID()).child("following").child
                            (userId).setValue(true);
                    item.followings.put(userId,true);
                    follow.setImageResource(0);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override protected void itemAdded(UserModel item, String key, int position) {

        Log.d("UserAdapter", "added");
    }

    @Override protected void itemChanged(UserModel oldItem, UserModel newItem, String key, int
            position) {
        Log.d("UserAdapter", "Changed an item.");
    }

    @Override protected void itemRemoved(UserModel item, String key, int position) {
        Log.d("UserAdapter", "Removed an item from the adapter.");
    }

    @Override protected void itemMoved(UserModel item, String key, int oldPosition, int
            newPosition) {
        Log.d("UserAdapter", "Moved an item.");
    }
}
