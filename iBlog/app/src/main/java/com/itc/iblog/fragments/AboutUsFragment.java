package com.itc.iblog.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.itc.iblog.R;
import com.itc.iblog.adapters.AboutUsAdapter;
import com.itc.iblog.models.UsersModel;

import java.util.ArrayList;

/**
 * Created by student on 9/4/17.
 */

public class AboutUsFragment extends android.support.v4.app.Fragment {
    private AboutUsAdapter mMyAdapter;
    private ArrayList<UsersModel> mAdapterItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        handleInstanceState(savedInstanceState);
        setupRecyclerview(view);
        return view;
    }

    private void handleInstanceState(Bundle savedInstanceState) {
        mAdapterItems = new ArrayList<UsersModel>();
        mAdapterItems.add(new UsersModel("Nelli","@drawable/user.png"));
        mAdapterItems.add(new UsersModel("Khachik", "@drawable/user.png"));
        mAdapterItems.add(new UsersModel("Ruben", "@drawable/user.png"));
        mAdapterItems.add(new UsersModel("Liana", "@drawable/user.png"));
        mAdapterItems.add(new UsersModel("Smbat", "@drawable/user.png"));
    }


    private void setupRecyclerview(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.about_us_rv);
        mMyAdapter = new AboutUsAdapter(mAdapterItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(mMyAdapter);
    }
}
