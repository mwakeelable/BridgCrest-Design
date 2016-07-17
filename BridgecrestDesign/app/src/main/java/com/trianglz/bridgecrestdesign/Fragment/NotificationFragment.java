package com.trianglz.bridgecrestdesign.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kingfisherphuoc.quickactiondialog.QuickActionDialogFragment;
import com.trianglz.bridgecrestdesign.R;

/**
 * Created by wakeel on 03/07/16.
 */
public class NotificationFragment extends QuickActionDialogFragment {
    @Override
    protected int getArrowImageViewId() {
        return R.id.btn_notifications; //return 0; that mean you do not have an up arrow icon
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_notification;
    }

    @Override
    protected boolean isStatusBarVisible() {
        return true; //optional: if status bar is visible in your app
    }

    @Override
    protected boolean isCanceledOnTouchOutside() {
        return true; //optional
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        // Set listener, view, data for your dialog fragment
        view.findViewById(R.id.clear_notifications_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Button inside Dialog!!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
