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
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.instigatemobile.imessenger.R;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button register;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private ImageView chat_icon;
    private LinearLayout registerLayout;
    private FragmentManager fragmentManager;
    private AwesomeValidation awesomeValidation;

    private LoginFragment loginFragment;
    //private RegisterFragment registerFragment;
    public RegisterFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        register = (Button)view.findViewById(R.id.btnRegister);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        initViews();
        //awesomeValidation.addValidation(getActivity(), R.id.editTextName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        //awesomeValidation.addValidation(getActivity(), R.id.editTextEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        //awesomeValidation.addValidation(getActivity(), R.id.editTextPassword, "^(?=.*[0-9])(?=.*[a-z])[a-zA-Z0-9!@#$%^&*]{6,20}$", R.string.passworderror);
        setListeners();
        return view;
    }

    private void initViews() {
        loginFragment = new LoginFragment();
        //registerFragment = new RegisterFragment();
        fragmentManager = getActivity().getSupportFragmentManager();
        editTextEmail = (EditText) view.findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);
        editTextName = (EditText) view.findViewById(R.id.editTextName);
        register = (Button) view.findViewById(R.id.btnRegister);
        registerLayout = (LinearLayout) view.findViewById(R.id.register_layout);
    }

    private void setListeners() {
        register.setOnClickListener(this);
    }
    private void registerForm() {
        //if (awesomeValidation.validate()) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, loginFragment);
        fragmentTransaction.addToBackStack("Login");
        fragmentTransaction.commit();
        //}
    }
    @Override
    public void onClick(View view) {
        if (view == register) {
            registerForm();
        }
    }

}
