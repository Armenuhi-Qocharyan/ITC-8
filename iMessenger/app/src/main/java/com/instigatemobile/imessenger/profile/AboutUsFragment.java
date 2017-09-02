package com.instigatemobile.imessenger.profile;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.instigatemobile.imessenger.Adapters.PersonAdapter;
import com.instigatemobile.imessenger.Persons.Persons;
import com.instigatemobile.imessenger.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AboutUsFragment extends Fragment implements View.OnClickListener {
    private TextView name;
    private Button phoneNumber;
    private ImageView logo;
    private View view;



    private  LinearLayout aboutUsLayout;
    private FragmentManager fragmentManager;

    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_about_us, container, false);
        initViews();
        setListeners();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewPerson);
        recyclerView.setHasFixedSize(true);
        PersonAdapter adapter = new PersonAdapter();
        recyclerView.setAdapter(adapter);
        //recyclerView.setNestedScrollingEnabled(false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);



        return view;
    }

    private void initViews() {
        fragmentManager = getActivity().getSupportFragmentManager();
        phoneNumber = (Button) view.findViewById(R.id.phoneNumberf);
        name = (TextView) view.findViewById(R.id.instigateNamef);
        logo = (ImageView) view.findViewById(R.id.logof);
        aboutUsLayout = (LinearLayout) view.findViewById(R.id.about_us_layout);
    }

    private void setListeners() {
        phoneNumber.setOnClickListener(this);
    }
    private void callNumber() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:+37498898795"));
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 10);
            return;
        } else {
            try {
                startActivity(callIntent);  //call activity and make phone call
            } catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(getActivity().getApplicationContext(),"Your activity is not founded...",Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onClick(View view) {
        if (view == phoneNumber) {
            callNumber();
        }
    }
}
