package com.itc.iblog.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;

import android.support.design.widget.FloatingActionButton;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.Button;
import android.widget.EditText;

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

import com.google.firebase.storage.UploadTask;
import com.itc.iblog.activities.MainActivity;
import com.itc.iblog.R;
import com.itc.iblog.adapters.ListAdapter;
import com.itc.iblog.models.PostModel;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Date;

import java.util.List;


public class FavoritesPostsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Activity main;
    private List<PostModel> myDataset;
    private String postId;
    private Bitmap bitmap;
    private Uri file;
    private int IMAGE;
    private DatabaseReference ref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_favorites_posts, container, false);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("favoritesPosts")) {
                    myDataset = new ArrayList<PostModel>();
                    for (DataSnapshot messageSnapshot : dataSnapshot.child("favoritesPosts").getChildren()) {
                        final String postId = messageSnapshot.getValue(new GenericTypeIndicator<String>() {});
                        DatabaseReference postRef = database.getReference("Posts").child(postId);
                        postRef.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                PostModel post = (PostModel) dataSnapshot.getValue(PostModel.class);
                                if (post != null) {
                                    if (post.getPostId() != null && myDataset.indexOf(post) < 0) {
                                        myDataset.add(post);
                                    }
                                    mRecyclerView = (RecyclerView) view.findViewById(R.id.fv_recycler_view);
                                    mRecyclerView.setHasFixedSize(true);
                                    mLayoutManager = new LinearLayoutManager(getActivity());
                                    mRecyclerView.setLayoutManager(mLayoutManager);
                                    mAdapter = new ListAdapter(myDataset, (MainActivity) getActivity());
                                    mRecyclerView.setAdapter(mAdapter);
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        return view;
    }
}