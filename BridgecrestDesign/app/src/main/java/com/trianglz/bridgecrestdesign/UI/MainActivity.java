package com.trianglz.bridgecrestdesign.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.kingfisherphuoc.quickactiondialog.AlignmentFlag;
import com.trianglz.bridgecrestdesign.Fragment.DashboardFragment;
import com.trianglz.bridgecrestdesign.Fragment.MessageFragment;
import com.trianglz.bridgecrestdesign.Fragment.NotificationFragment;
import com.trianglz.bridgecrestdesign.Fragment.ShiftFragment;
import com.trianglz.bridgecrestdesign.R;

import it.sephiroth.android.library.bottomnavigation.BottomNavigation;

public class MainActivity extends AppCompatActivity {
    public DrawerLayout mDrawerLayout;
    public Toolbar mToolbar;
    public ActionBar mActionBar;
    public FrameLayout mFrameLayout;
    public FloatingActionMenu mFabMenu;
    public FloatingActionMenu msgFAB;
    public FloatingActionButton fab1;
    public FloatingActionButton fab2;
    public FloatingActionButton composeFAB;
    public BottomNavigation mBottomNavigation;
    private static DashboardFragment FRAGMENT_DASHBOARD;
    private static ShiftFragment FRAGMENT_SHIFT;
    private static MessageFragment FRAGMENT_MESSAGE;
    private static NotificationFragment FRAGMENT_NOTIFICATIONS;
    private static TextView app_name;
    private static ImageView notificationIMG;
    public static boolean isHome = false;
    public static boolean isMyShift = false;
    public static boolean isMessages = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mActionBar = getSupportActionBar();
        initControllers();
        mFabMenu.setVisibility(View.GONE);
        msgFAB.setVisibility(View.GONE);
//        isHome = true;
        drawDashboard();
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Call Manager", Toast.LENGTH_LONG).show();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Message Manager", Toast.LENGTH_LONG).show();
            }
        });
        mBottomNavigation.setOnMenuItemClickListener(new BottomNavigation.OnMenuItemSelectionListener() {
            @Override
            public void onMenuItemSelect(@IdRes int i, int i1) {
                switch (i) {
                    case R.id.item1:
                        app_name.setText(getString(R.string.app_name));
                        mFabMenu.setVisibility(View.GONE);
                        msgFAB.setVisibility(View.GONE);
                        drawDashboard();
                        break;
                    case R.id.item2:
                        app_name.setText(getString(R.string.item2));
                        mFabMenu.setVisibility(View.VISIBLE);
                        msgFAB.setVisibility(View.GONE);
                        drawShift();
                        break;
                    case R.id.item3:
                        app_name.setText(getString(R.string.item3));
                        mFabMenu.setVisibility(View.GONE);
                        msgFAB.setVisibility(View.VISIBLE);
                        drawMessage();
                        break;
                    case R.id.item4:
                        drawSettings();
                        break;
                }
            }

            @Override
            public void onMenuItemReselect(@IdRes int i, int i1) {

            }
        });
        notificationIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FRAGMENT_NOTIFICATIONS = new NotificationFragment();
                FRAGMENT_NOTIFICATIONS.setAnchorView(notificationIMG);
                FRAGMENT_NOTIFICATIONS.setAligmentFlags(AlignmentFlag.ALIGN_ANCHOR_VIEW_LEFT | AlignmentFlag.ALIGN_ANCHOR_VIEW_TOP);
                FRAGMENT_NOTIFICATIONS.show(getSupportFragmentManager(), null);

            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (mFabMenu.isOpened()) {
                mFabMenu.close(true);
            } else if (msgFAB.isOpened())
                msgFAB.close(true);
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        if (mFabMenu.isOpened())
            mFabMenu.close(true);
        else if (msgFAB.isOpened())
            msgFAB.close(true);
        else{
            finishAffinity();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }
    }

    private void initControllers() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mFrameLayout = (FrameLayout) findViewById(R.id.containerView);
        mFabMenu = (FloatingActionMenu) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        mBottomNavigation = (BottomNavigation) findViewById(R.id.bottomNavigation);
        app_name = (TextView) findViewById(R.id.app_name);
        notificationIMG = (ImageView) findViewById(R.id.btn_notifications);
        msgFAB = (FloatingActionMenu) findViewById(R.id.messageFAB);
        composeFAB = (FloatingActionButton) findViewById(R.id.composeFAB);
    }

    private void drawDashboard() {
        isHome = true;
        isMyShift = false;
        isMessages = false;
        FRAGMENT_DASHBOARD = new DashboardFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, FRAGMENT_DASHBOARD);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void drawShift() {
        isMyShift = true;
        isHome = false;
        isMessages = false;
        FRAGMENT_SHIFT = new ShiftFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, FRAGMENT_SHIFT);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void drawMessage() {
        isMessages = true;
        isMyShift = false;
        isHome = false;
        FRAGMENT_MESSAGE = new MessageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, FRAGMENT_MESSAGE);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void drawSettings() {
        isHome = false;
        isMyShift = false;
        isMessages = false;
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

}
