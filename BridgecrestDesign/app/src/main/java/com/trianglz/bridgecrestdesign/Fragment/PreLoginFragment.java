package com.trianglz.bridgecrestdesign.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trianglz.bridgecrestdesign.R;

/**
 * Created by wakeel on 04/07/16.
 */
public class PreLoginFragment extends Fragment {
    public static final String ARG_PAGE = "page";
    private int mPageNumber;

    public static PreLoginFragment create(int pageNumber) {
        PreLoginFragment fragment = new PreLoginFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PreLoginFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        switch (mPageNumber) {
            case 0:
                return (ViewGroup) inflater.inflate(
                        R.layout.prelogin_all_in_one_place, container, false);

            case 1:
                return (ViewGroup) inflater.inflate(
                        R.layout.prelogin_security_privacy, container, false);

//            case 2:
//                return (ViewGroup) inflater.inflate(
//                        R.layout.login_activity, container, false);

            default:
                return (ViewGroup) inflater.inflate(
                        R.layout.prelogin_all_in_one_place, container, false);
        }
    }

    public int getPageNumber() {
        return mPageNumber;
    }

}
