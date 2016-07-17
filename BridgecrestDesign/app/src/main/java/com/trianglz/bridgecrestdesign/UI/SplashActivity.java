package com.trianglz.bridgecrestdesign.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.trianglz.bridgecrestdesign.R;

import gr.net.maroulis.library.EasySplashScreen;

/**
 * Created by wakeel on 03/07/16.
 */
public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.splash_activity);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent i = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(i);
//                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                finish();
//            }
//        }, SPLASH_TIME_OUT);

        EasySplashScreen config = new EasySplashScreen(SplashActivity.this)
//                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(1000)
                .withBackgroundResource(R.color.background_blue_darker)
                .withLogo(R.drawable.bc_logo);
        //create the view
        View easySplashScreenView = config.create();
        setContentView(easySplashScreenView);
    }
}
