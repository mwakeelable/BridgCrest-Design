package com.trianglz.bridgecrestdesign.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.trianglz.bridgecrestdesign.R;
import com.trianglz.bridgecrestdesign.UI.MainActivity;

/**
 * Created by wakeel on 03/07/16.
 */
public class MessageFragment extends Fragment {
    MainActivity activity;
    ViewPager viewPager;
    TabLayout tabLayout;
    String[] titles = new String[2];
    MessagesFragment FRAGMENT_MSG;
    AnouncementsFragment FRAGMENT_ANO;
    public MsgAdapter adapter;

    public MessageFragment(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        adapter = new MsgAdapter(getChildFragmentManager());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (MainActivity) getActivity();
        return inflater.inflate(R.layout.message_activity,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ((TextView) tab.getCustomView()).setTextColor(Color.parseColor("#ffa3a3a3"));
                viewPager.setCurrentItem(tabLayout.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ((TextView) tab.getCustomView()).setTextColor(Color.parseColor("#FFFFFF"));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        final TextView tab1_tv = new TextView(activity);
        tab1_tv.setText(activity.getString(R.string.messages));
        tab1_tv.setGravity(Gravity.CENTER);
        tab1_tv.setTextColor(Color.parseColor("#ffa3a3a3"));
        tabLayout.getTabAt(0).setCustomView(tab1_tv);

        TextView tab2_tv = new TextView(activity);
        tab2_tv.setText(activity.getString(R.string.anouncments));
        tab2_tv.setGravity(Gravity.CENTER);
        tab2_tv.setTextColor(Color.parseColor("#FFFFFF"));
        tabLayout.getTabAt(1).setCustomView(tab2_tv);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (tabLayout.getChildAt(position) != null)
                    tabLayout.getChildAt(position).setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        activity.composeFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"New Message",Toast.LENGTH_LONG).show();
            }
        });
    }

    class MsgAdapter extends FragmentStatePagerAdapter {
        public MsgAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                if (FRAGMENT_MSG == null)
                    FRAGMENT_MSG = new MessagesFragment();
                return FRAGMENT_MSG;
            } else {
                if (FRAGMENT_ANO == null)
                    FRAGMENT_ANO = new AnouncementsFragment();
                return FRAGMENT_ANO;
            }
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}
