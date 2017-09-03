package com.instigatemobile.imessenger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.instigatemobile.imessenger.profile.AboutUsFragment;
import com.instigatemobile.imessenger.profile.LoginFragment;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    //private RegisterFragment registerFragment;
    private AboutUsFragment aboutUsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("ButtonID", 0);

        if (intValue == 0) {
        } else if (intValue == R.id.action_about) {
            setContentView(R.layout.activity_settings);
            initAboutUsFragment();
        } else if(intValue == R.id.action_settings) {
            //initSettingsFragment();
        } else if (intValue == R.id.action_logout) {

        }
    }

    private void initAboutUsFragment() {
        aboutUsFragment = new AboutUsFragment();
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frgmContainer, aboutUsFragment);
        //fragmentTransaction.addToBackStack("AboutUs");
        fragmentTransaction.commit();
    }
    private void initSettingsFragment() {

    }
    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        System.out.println(fragmentManager.getBackStackEntryCount());
        super.onBackPressed();
    }


    @Override
    public void onClick(View view) {
        onBackPressed();
    }


}
