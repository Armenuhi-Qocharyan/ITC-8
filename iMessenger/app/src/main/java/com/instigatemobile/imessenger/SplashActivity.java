package com.instigatemobile.imessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.instigatemobile.imessenger.controllers.LoginRegister;

public class SplashActivity extends Activity {
    private static int SPLASH_TIME_OUT = 2500;
    private TextView textView;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Animation performAnimationText = AnimationUtils.loadAnimation(this, R.anim.splash_anim_text);
        Animation performAnimationImage = AnimationUtils.loadAnimation(this, R.anim.splash_anim_image);
        performAnimationImage.setRepeatCount(1);
        performAnimationText.setRepeatCount(1);

        imageView = (ImageView) findViewById(R.id.splashImageView);
        textView = (TextView) findViewById(R.id.splashImageText);
        imageView.startAnimation(performAnimationImage);
        textView.startAnimation(performAnimationText);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, LoginRegisterActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}