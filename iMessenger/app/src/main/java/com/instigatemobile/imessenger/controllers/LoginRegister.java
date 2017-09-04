package com.instigatemobile.imessenger.controllers;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.instigatemobile.imessenger.fragments.LoginFragment;
import com.instigatemobile.imessenger.fragments.RegisterFragment;

public class LoginRegister {
    private FirebaseAuth mAuth;
    static LoginRegister mLoginRegister;
    private RegisterFragment mRegisterFragment;
    private LoginFragment mLoginFragment;


    private LoginRegister() {
        mAuth = FirebaseAuth.getInstance();;
    }

    public static LoginRegister initLoginRegister() {
        if (mLoginRegister == null) {
            mLoginRegister = new LoginRegister();
        }
        return mLoginRegister;
    }

    public void createAccount(String email, String password, RegisterFragment registerFragment) {
        // -> registrationActivity.validateForm();
        // -> registrationActivity.showProgressDialog();
        mRegisterFragment = registerFragment;
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(mRegisterFragment.getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            sendEmailVerification(mRegisterFragment.getActivity());
                        } else {
                            showMessage(mRegisterFragment.getActivity(), "Authentication failed.");
                        }
                            // -> registrationActivity.hideProgressDialog();
                    }
                });
    }


    private void sendEmailVerification(Activity activity) {
        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification().addOnCompleteListener(activity, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    mRegisterFragment.registerForm();
                } else {
                    showMessage(mRegisterFragment.getActivity() ,"Authentication failed.");
                }

            }
        });
    }


    public void signIn(String email, String password, LoginFragment loginFragment) {
        // -> registrationActivity.validateForm();
        // -> registrationActivity.showProgressDialog();
        mLoginFragment = loginFragment;
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(mLoginFragment.getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            mLoginFragment.redirect();
                        } else {
                            showMessage(mLoginFragment.getActivity(), "Authentication failed.");
                        }

                    }
                });
    }

    public void signOut() {
        mAuth.signOut();
    }

    private void showMessage(Activity activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }
}
