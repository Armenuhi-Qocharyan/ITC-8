package com.itc.iblog.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.itc.iblog.R;
import com.itc.iblog.adapters.listAdapter;
import com.itc.iblog.models.DataModel;

import java.util.ArrayList;
import java.util.List;

public class postsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Activity main;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        List<DataModel> myDataset = new ArrayList<>();
        myDataset.add(new DataModel("Tomas","Smith",R.drawable.man,R.drawable.image,"2 Sep 11:40","Post title","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. ",30,20));
        myDataset.add(new DataModel("Nelli","Melkonyan",R.drawable.user,R.drawable.background_img,"2 Sep 11:40","Post title","Post text",10,13));
        myDataset.add(new DataModel("Nelli","Melkonyan",R.drawable.user,0,"2 Sep 11:40","Post title","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. ",14,0));
        myDataset.add(new DataModel("Nelli","Melkonyan",R.drawable.user,R.drawable.image,"2 Sep 11:40","","",3,2));
        myDataset.add(new DataModel("Nelli","Melkonyan",R.drawable.user,0,"2 Sep 11:40","Post title","",100,80));
        myDataset.add(new DataModel("Nelli","Melkonyan",R.drawable.user,0,"2 Sep 11:40","Post title","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. ",124,130));


        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new listAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }


}