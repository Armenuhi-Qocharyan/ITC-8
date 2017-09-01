package com.instigatemobile.imessenger.profile;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.instigatemobile.imessenger.MainActivity;
import com.instigatemobile.imessenger.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginFragment extends Fragment implements View.OnClickListener {


    public LoginFragment() {
        // Required empty public constructor
    }
    private  View view;
    private  Button login;
    private  Button register;
    private  EditText editTextEmail;
    private  EditText editTextPassword;
    private  ImageView chat_icon;
    private  LinearLayout loginLayout;
    private  FragmentManager fragmentManager;
    private AwesomeValidation awesomeValidation;

    //private LoginFragment loginFragment;
    private RegisterFragment registerFragment;

    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    private static final String PASSWORD_PATTERN = "^(([^<>()[\\]\\\\.,;:\\s@\\\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\\\"]+)*)|(\\\".+\\\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        login = (Button)view.findViewById(R.id.btn_login);
        initViews();
        //awesomeValidation.addValidation(getActivity(), R.id.editTextEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        //awesomeValidation.addValidation(this.getActivity(), R.id.editTextPassword, "^(?=.*[0-9])(?=.*[a-z])[a-zA-Z0-9!@#$%^&*]{6,20}$", R.string.passworderror);
        setListeners();
        //PasswordValidator();
        return view;
    }

    private void initViews() {
        //loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();
        fragmentManager = getActivity().getSupportFragmentManager();
        editTextEmail = (EditText) view.findViewById(R.id.input_email);
        editTextPassword = (EditText) view.findViewById(R.id.input_password);
        login = (Button) view.findViewById(R.id.btn_login);
        register = (Button) view.findViewById(R.id.link_signup);
        loginLayout = (LinearLayout) view.findViewById(R.id.login_layout);
    }

    private void setListeners() {
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }
    private void goRegisterPage() {
        //if (awesomeValidation.validate()) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, registerFragment);
        fragmentTransaction.addToBackStack("Register");
        fragmentTransaction.commit();
    }
    public void onClick(View view) {
        if (view == register) {
            goRegisterPage();
        } else if (view == login) {
            //if (awesomeValidation.validate()) {
            Intent redirect = new Intent(getActivity(), MainActivity.class);
            getActivity().startActivity(redirect);
            //}
        }
    }

}
