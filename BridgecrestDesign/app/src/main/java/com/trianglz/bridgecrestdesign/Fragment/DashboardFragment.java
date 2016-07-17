package com.trianglz.bridgecrestdesign.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.trianglz.bridgecrestdesign.R;
import com.trianglz.bridgecrestdesign.UI.SleepTracking;
import com.trianglz.bridgecrestdesign.UI.MainActivity;
import com.trianglz.bridgecrestdesign.UI.SleepingHintsActivity;
import com.trianglz.bridgecrestdesign.UI.SleepingHistoryActivity;

/**
 * Created by wakeel on 03/07/16.
 */
public class DashboardFragment extends Fragment {
    MainActivity activity;
    LinearLayout howSleep, nextShift, hints, sleepHistory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (MainActivity) getActivity();
        return inflater.inflate(R.layout.dashboard_activity, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        howSleep = (LinearLayout) view.findViewById(R.id.howSleepLayout);
        howSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(activity,"Showing How did you slept last night",Toast.LENGTH_LONG).show();
                Intent howSleepIntent = new Intent(activity, SleepTracking.class);
                startActivity(howSleepIntent);
            }
        });
        nextShift = (LinearLayout) view.findViewById(R.id.nextShiftLayout);
        nextShift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(activity,"Showing next shift time remaining",Toast.LENGTH_LONG).show();
                activity.mFabMenu.setVisibility(View.VISIBLE);
                ShiftFragment FRAGMENT_SHIFT = new ShiftFragment();
                FragmentTransaction ft  = getFragmentManager().beginTransaction();
                ft.replace(R.id.containerView, FRAGMENT_SHIFT);
                ft.addToBackStack(null);
                ft.commit();
                activity.mBottomNavigation.setSelectedIndex(1,true);
            }
        });
        hints = (LinearLayout) view.findViewById(R.id.hintLayout);
        hints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(activity,"Showing Hints about sleeping",Toast.LENGTH_LONG).show();
                Intent hintsIntent = new Intent(activity, SleepingHintsActivity.class);
                startActivity(hintsIntent);
            }
        });
        sleepHistory = (LinearLayout) view.findViewById(R.id.sleepHistoryLayout);
        sleepHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(activity,"Showing your sleeping history",Toast.LENGTH_LONG).show();
                Intent sleepHistoryIntent = new Intent(activity, SleepingHistoryActivity.class);
                startActivity(sleepHistoryIntent);
            }
        });
    }
}

