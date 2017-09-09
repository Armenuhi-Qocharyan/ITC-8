package com.instigatemobile.imessenger.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.instigatemobile.imessenger.R;
import com.instigatemobile.imessenger.controllers.DataBase;
import com.instigatemobile.imessenger.controllers.LoginRegister;
import com.instigatemobile.imessenger.models.Profile;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button register;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private FragmentManager fragmentManager;
    private LoginFragment loginFragment;
    private ProgressBar bar;
    private Profile profile;

    public RegisterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        bar = view.findViewById(R.id.progressBar);
        initViews();
        setListeners();
        return view;
    }

    private void initViews() {
        loginFragment = new LoginFragment();
        fragmentManager = getActivity().getSupportFragmentManager();
        editTextEmail = (EditText) view.findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);
        editTextName = (EditText) view.findViewById(R.id.editTextName);
        register = (Button) view.findViewById(R.id.btnRegister);
        LinearLayout registerLayout = (LinearLayout) view.findViewById(R.id.register_layout);
    }

    private void setListeners() {
        register.setOnClickListener(this);
    }

    public void registerForm() {
        initProfile();
        DataBase dataBase = DataBase.initDataBase();
        dataBase.insertProfile(profile);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, loginFragment);
        fragmentTransaction.addToBackStack("Login");
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        new ProgressTask().execute();
        if (view == register) {
            if (validateName() && validateEmail() && validatePassword()) {
                LoginRegister loginRegister = LoginRegister.initLoginRegister();
                loginRegister.createAccount(editTextEmail.getText().toString(), editTextPassword.getText().toString(), this);
            }
        }
    }

    private boolean validateName() {
        String name = editTextName.getText().toString().trim();
        final String NAME_PATTERN = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
        if (editTextName.getText().toString().equals("")) {
            editTextName.setError("You should specify the name");
            return false;
        }
        return true;
    }

    private boolean validateEmail() {
        String email = editTextEmail.getText().toString().trim();
        final String EMAIL_PATERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        ;

        if (editTextEmail.getText().toString().equals("")) {
            editTextEmail.setError("You should specify the email");
            return false;
        }
        if (!email.matches(EMAIL_PATERN)) {
            editTextEmail.setError("The specified email is not correctly formated");
            return false;
        }
        return true;
    }

    private boolean validatePassword() {
        String password = editTextPassword.getText().toString().trim();
        final String PASSWORD_PATERN = "^(?=.*[0-9])(?=.*[a-z])[a-zA-Z0-9!@#$%^&*]{6,20}$";

        if ((editTextPassword.getText().toString().equals("")) || (editTextPassword.getText().length() < 6)) {
            editTextPassword.setError("You should specify the password");
            return false;
        }
        /*
        if (!password.matches(PASSWORD_PATERN)) {
            editTextPassword.setError("The specified password is not correctly formated (min lenght 6 symbole, at least one symbole and on capital latter and one number)");
            return false;
        }*/
        return true;
    }

    private void initProfile() {
        profile = new Profile(editTextName.getText().toString(), editTextEmail.getText().toString(), "", "", 0, 0);
    }

    interface MyCallbackInterface {
        void onDownloadFinished(String result);
    }

    private class ProgressTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            bar.setVisibility(View.VISIBLE);
        }

        protected void onPostExecute(Void result) {
            bar.setVisibility(View.GONE);
        }
    }
}