package com.itc.iblog.fragments;

import android.content.Intent;
import android.net.Uri;
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

public class AboutUsFragment extends android.support.v4.app.Fragment {
    private AboutUsAdapter mMyAdapter;
    private ArrayList<UsersModel> mAdapterItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        handleInstanceState(savedInstanceState);
        view.findViewById(R.id.itc_tel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+37460445500"));
                startActivity(intent);
            }
        });
        setupRecyclerview(view);
        return view;
    }

    private void handleInstanceState(Bundle savedInstanceState) {
        mAdapterItems = new ArrayList<UsersModel>();
        mAdapterItems.add(new UsersModel("Nelli Melkonyan", R.drawable.developer_nelli, "nelli.melkonyan.im@gmail.com"));
        mAdapterItems.add(new UsersModel("Khachik Ghazaryan", R.drawable.developer_khachik, "khachik.ghazaryan.im@gmail.com"));
        mAdapterItems.add(new UsersModel("Ruben Ghalayan", R.drawable.developer_ruben, "ruben.ghalayan.im@gmail.com"));
        mAdapterItems.add(new UsersModel("Liana Andreasyan", R.drawable.developer_liana, "liana.andreasyan.im@gmail.com"));
        mAdapterItems.add(new UsersModel("Smbat Dallakyan", R.drawable.developer_smbat_d, "smbat.dallakyan.im@gmail.com"));
    }

    private void setupRecyclerview(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.about_us_rv);
        mMyAdapter = new AboutUsAdapter(mAdapterItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(mMyAdapter);
    }
}