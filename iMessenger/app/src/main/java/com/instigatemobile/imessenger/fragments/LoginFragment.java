package com.instigatemobile.imessenger.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.instigatemobile.imessenger.R;
import com.instigatemobile.imessenger.activities.MainActivity;
import com.instigatemobile.imessenger.controllers.LoginRegister;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button login;
    private TextView register;
    private TextView forgot;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private ImageView chat_icon;
    private LinearLayout loginLayout;
    private FragmentManager fragmentManager;
    //private LoginFragment loginFragment;
    private RegisterFragment registerFragment;
    private Pattern pattern;
    private Matcher matcher;
    private ProgressBar bar;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        bar = (ProgressBar) view.findViewById(R.id.progressBar);
        login = (Button) view.findViewById(R.id.btn_login);
        initViews();
        setListeners();
        return view;
    }

    private void initViews() {
        //loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();
        fragmentManager = getActivity().getSupportFragmentManager();
        editTextEmail = (EditText) view.findViewById(R.id.input_email);
        editTextPassword = (EditText) view.findViewById(R.id.input_password);
        login = (Button) view.findViewById(R.id.btn_login);
        register = (TextView) view.findViewById(R.id.link_signup);
        forgot = (TextView) view.findViewById(R.id.link_forgot_pass);
        loginLayout = (LinearLayout) view.findViewById(R.id.login_layout);
    }

    private void setListeners() {
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        forgot.setOnClickListener(this);
    }

    private void goRegisterPage() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, registerFragment);
        fragmentTransaction.addToBackStack("Register");
        fragmentTransaction.commit();
    }

    public void onClick(final View view) {
        new ProgressTask().execute();
        if (view == register) {
            goRegisterPage();
        } else if (view == login) {
            if (validateEmail() &&  validatePassword()) {
                    LoginRegister loginRegister = LoginRegister.initLoginRegister();
                    loginRegister.signIn(editTextEmail.getText().toString(), editTextPassword.getText().toString(), this);
            }
        } else if (view == forgot) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseAuth.getInstance().sendPasswordResetEmail(user.getEmail())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Snackbar snackbar = Snackbar
                                        .make(view, "Email sent", Snackbar.LENGTH_LONG);
                                snackbar.show();
                            }
                        }
                    });
        }
    }

    private boolean validateEmail() {
        String email = editTextEmail.getText().toString().trim();
        final String EMAIL_PATERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";;

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

        if ((editTextPassword.getText().toString().equals(""))  || (editTextPassword.getText().length() < 6)) {
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



    public void redirect() {
        Intent redirect = new Intent(getActivity().getApplicationContext(), MainActivity.class);
        getActivity().finish();
        getActivity().startActivity(redirect);
    }

    public void progressBarVisibility() {
        bar.setVisibility(ProgressBar.VISIBLE);
    }

    public void progressBarInvisibility() {
        bar.setVisibility(ProgressBar.INVISIBLE);
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