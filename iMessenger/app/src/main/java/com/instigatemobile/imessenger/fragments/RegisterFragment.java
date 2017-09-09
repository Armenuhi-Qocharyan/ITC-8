package com.instigatemobile.imessenger.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.instigatemobile.imessenger.R;

public class RegisterFragment extends Fragment {
    private View view;
    private Button register;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;

    private LoginFragment.AuthUtils mAuthUtils;

    public RegisterFragment() {

    }

    public void setAuthUtils(LoginFragment.AuthUtils authUtils) {
        mAuthUtils = authUtils;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        register = (Button) view.findViewById(R.id.btnRegister);
        initViews();

        //awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //awesomeValidation.addValidation(getActivity(), R.id.editTextName, NAME_PATTERN, R.string.nameerror);
        //awesomeValidation.addValidation(getActivity(), R.id.editTextEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        //awesomeValidation.addValidation(getActivity(), R.id.editTextPassword, PASSWORD_PATTERN, R.string.passworderror);
        setListeners();
        return view;
    }

    private void initViews() {
        editTextEmail = (EditText) view.findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);
        editTextName = (EditText) view.findViewById(R.id.editTextName);
        register = (Button) view.findViewById(R.id.btnRegister);
    }

    private void setListeners() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuthUtils.createUser(editTextName.getText().toString(), editTextEmail.getText().toString(), editTextPassword.getText().toString());
            }
        });
    }

}