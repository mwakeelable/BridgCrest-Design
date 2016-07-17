package com.trianglz.bridgecrestdesign.UI;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.trianglz.bridgecrestdesign.R;

/**
 * Created by wakeel on 04/07/16.
 */
public class LoginActivity extends AppCompatActivity {
    ImageView img_Logo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        img_Logo = (ImageView) findViewById(R.id.imgLogo);
        Drawable icon = ContextCompat.getDrawable(this, R.drawable.logo);
        icon.setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.SRC_ATOP);
        img_Logo.setImageDrawable(icon);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
