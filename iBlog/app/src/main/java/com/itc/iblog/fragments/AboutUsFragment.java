package com.itc.iblog.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.itc.iblog.R;

/**
 * Created by student on 9/4/17.
 */

public class AboutUsFragment extends android.support.v4.app.Fragment {
    //private ArrayList<UsersModel> mAdapterItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        handleInstanceState(savedInstanceState);
        return view;
    }

    private void handleInstanceState(Bundle savedInstanceState) {
    }


    private void setupRecyclerview(View view) {
    }
}
