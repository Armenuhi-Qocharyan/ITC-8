package com.itc.iblog.fragments;


import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.itc.iblog.R;

public class loginFragment extends Fragment {
    private Activity login;
    public loginFragment() {
    }

    public loginFragment(Activity login) {
        this.login = login;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Animation scale = AnimationUtils.loadAnimation(super.getContext(), R.anim.scale);
        view.setAnimation(scale);
        Button register = (Button) view.findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new registerFragment(login);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.contentFragment, fragment);
                transaction.addToBackStack(null).commit();
            }
        });

        Button login = (Button) view.findViewById(R.id.buttonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("login");
            }
        });
        return view;
    }
}
