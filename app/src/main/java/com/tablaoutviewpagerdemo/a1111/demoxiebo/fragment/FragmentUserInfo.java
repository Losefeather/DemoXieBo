package com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.ActivityManager;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.DataCleanManager;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.SysApplication;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.R;

import static com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity.setButton;

/**
 * Created by a1111 on 17/9/29.
 */

public class FragmentUserInfo extends BaseRxFragment {
    private View view;
    private Button cache,exit;

    public static final String TAG="FragmentUserInfo";
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_userinfo,container,false);
        cache = view.findViewById(R.id.cache);
        exit = view.findViewById(R.id.exit);
        FeagmentActivity.Num=1;
        setButton();
        OnClick();

        return view;
    }
    public void OnClick(){

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SysApplication.getInstance().exit();
                ActivityManager.getInstance().appExit(getContext());
            }
        });
        cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               DataCleanManager.clearAllCache(getContext());
            }
        });
    }
}
