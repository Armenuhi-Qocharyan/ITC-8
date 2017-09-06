package com.instigatemobile.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by student on 9/6/17.
 */

public class ButtonsFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button a;
    private Button b;
    private FragmentManager fragmentManager;
    private AFragment aFragment;
    private BFragment bFragment;

    public ButtonsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_a, container, false);
        a = (Button) view.findViewById(R.id.btn_a);
        b = (Button) view.findViewById(R.id.btn_b);
        initViews();
        setListeners();
        return view;
    }

    private void initViews() {
        aFragment = new AFragment();
        bFragment = new BFragment();
        fragmentManager = getActivity().getSupportFragmentManager();
    }

    private void setListeners() {
        a.setOnClickListener(this);
        b.setOnClickListener(this);
    }

    private void goA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, aFragment);
        fragmentTransaction.addToBackStack("Buttons");
        fragmentTransaction.commit();
    }

    private void goB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, bFragment);
        fragmentTransaction.addToBackStack("Buttons");
        fragmentTransaction.commit();
    }

    public void onClick(View view) {
        if (view == a) {
            goA();
        } else if (view == b) {
            goB();
        }
    }
}