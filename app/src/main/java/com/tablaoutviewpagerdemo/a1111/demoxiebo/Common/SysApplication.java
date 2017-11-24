package com.tablaoutviewpagerdemo.a1111.demoxiebo.Common;

import android.app.Activity;
import android.app.Application;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.Crash.CrashHandler;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.RxRetrofitApp;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by a1111 on 17/9/29.
 */

public class SysApplication extends Application {
    private List<Activity> mList = new LinkedList();
    private static SysApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        RxRetrofitApp.init(this,Boolean.parseBoolean("true"));
        CrashHandler.getInstance().init(this);
    }
    public SysApplication() {

    }
}
