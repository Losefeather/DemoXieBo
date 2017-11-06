package com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.Bind;

/**
 * Created by a1111 on 17/9/28.
 */

public class FragmentPowerShowAll extends BaseRxFragment {
    public static final String TAG="FragmentPowerShowAll";
    @Bind(R.layout.fragment_menu)
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return view;
    }
}
