package com.tablaoutviewpagerdemo.a1111.demoxiebo.Common;

import android.app.Activity;
import android.app.Application;

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
    }

    public SysApplication() {

    }
    public synchronized static SysApplication getInstance() {
        if (null == instance) {
            instance = new SysApplication();
        }
        return instance;
    }
    // add Activity
    public void addActivity(Activity activity) {
        mList.add(activity);
    }

    public void exit() {
        try {
            for (Activity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }
    /**
     * 销毁单个Activity
     */
    public void removeActivity_(Activity activity) {
    //判断当前集合中存在该Activity
        if (mList.contains(activity)) {
            mList.remove(activity);//从集合中移除
            activity.finish();//销毁当前Activity
        }
    }
    /**
     * 销毁所有的Activity
     */
    public void removeALLActivity_() {
        //通过循环，把集合中的所有Activity销毁
        for (Activity activity : mList) {
            activity.finish();
        }
    }
}
