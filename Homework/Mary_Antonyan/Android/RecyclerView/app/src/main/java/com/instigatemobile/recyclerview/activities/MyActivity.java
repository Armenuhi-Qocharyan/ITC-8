package com.instigatemobile.recyclerview.activities;

import android.app.Activity;
import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.instigatemobile.recyclerview.R;
import com.instigatemobile.recyclerview.adapters.MyAdapter;
import com.instigatemobile.recyclerview.models.Film;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        final List<Film> films = new ArrayList<>();
        final ImageView image = null;
        Glide.with(this)
                .load("http://www.iconsdb.com/icons/preview/deep-pink/video-play-xxl.png")
                .into(image);
        films.add(new Film("Title1", "Description1", image));
        films.add(new Film("Title2", "Description3", image));
        films.add(new Film("Title2", "Description3", image));

        mAdapter = new MyAdapter(films);
        mRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                films.add(new Film("Title", "Description", image));
                mAdapter = new MyAdapter(films);
                mRecyclerView.setAdapter(mAdapter);
            }
        });
    }
}
