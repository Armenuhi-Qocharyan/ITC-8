package com.instigatemobile.imessenger;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.instigatemobile.imessenger.profile.LoginFragment;
import com.instigatemobile.imessenger.profile.RegisterFragment;

public class LoginRegisterActivity extends AppCompatActivity {
    //private RegisterFragment registerFragment;
    private LoginFragment loginFragment;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //registerFragment = new RegisterFragment();
        loginFragment = new LoginFragment();
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, loginFragment);
        fragmentTransaction.commit();
    }
}