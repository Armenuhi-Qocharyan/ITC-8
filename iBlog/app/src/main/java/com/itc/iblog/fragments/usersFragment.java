package com.itc.iblog.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.parceler.Parcels;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.DatabaseReference;
import com.itc.iblog.R;
import com.itc.iblog.adapters.UserAdapter;
import com.itc.iblog.models.UsersModel;

import java.util.ArrayList;


public class usersFragment extends Fragment {
    private final static String SAVED_ADAPTER_ITEMS = "SAVED_ADAPTER_ITEMS";
    private final static String SAVED_ADAPTER_KEYS = "SAVED_ADAPTER_KEYS";

    private Query mQuery;
    private UserAdapter mMyAdapter;
    private ArrayList<UsersModel> mAdapterItems;
    private ArrayList<String> mAdapterKeys;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        handleInstanceState(savedInstanceState);
        setupFirebase();
        setupRecyclerview(view);
        return view;
    }

    private void handleInstanceState(Bundle savedInstanceState) {
            mAdapterItems = new ArrayList<>();
            mAdapterKeys = new ArrayList<>();
    }

    private void setupFirebase() {

        mQuery = FirebaseDatabase.getInstance().getReference().child("Users");
        String msg = mQuery.toString();
        Log.d("app",msg);
    }

    private void setupRecyclerview(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        mMyAdapter = new UserAdapter(mQuery, mAdapterItems, mAdapterKeys);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(mMyAdapter);
    }
}