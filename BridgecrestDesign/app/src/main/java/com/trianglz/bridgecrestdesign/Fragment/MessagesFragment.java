package com.trianglz.bridgecrestdesign.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trianglz.bridgecrestdesign.R;
import com.trianglz.bridgecrestdesign.UI.MainActivity;

/**
 * Created by wakeel on 10/07/16.
 */
public class MessagesFragment extends Fragment {
    MainActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (MainActivity) getActivity();
        return inflater.inflate(R.layout.messages_fragment, container, false);
    }
}
