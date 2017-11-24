package com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.ActivityManager;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.DataCleanManager;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.MD5.MD5;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.MD5.SecretUtils;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.SysApplication;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.HttpPowerApi;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.LoginActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.R;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;

import static com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity.setButton;

/**
 * Created by a1111 on 17/9/29.
 */

public class FragmentUserInfo extends BaseRxFragment {
    private View view;
    private Button cache,exit,exit_currentName;
    private boolean isOtherUser=false;
    public static final String TAG="FragmentUserInfo";
    private HttpPowerApi httpPowerApi = new HttpPowerApi(this,this);
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_userinfo,container,false);
        cache = view.findViewById(R.id.cache);
        exit = view.findViewById(R.id.exit);
        exit_currentName = view.findViewById(R.id.exit_currentuser);
        FeagmentActivity.Num=1;
        setButton();
        OnClick();

        return view;
    }
    public void OnClick(){
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOtherUser=false;
                httpPowerApi.getObj(CommonPowerList.isFragment,CommonPowerList.GET_LOGOUT, SecretUtils.encrypt(httpPowerApi.getLogout(CommonPowerList.BUSI_LOGOUT,CommonPowerList.powerLogin.getUserAccount(), MD5.md5(CommonPowerList.powerLogin.getUserPwd()),CommonPowerList.powerLogin.getUserId())));
            }
        });
        cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               DataCleanManager.clearAllCache(getContext());
            }
        });
        exit_currentName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOtherUser=true;
                httpPowerApi.getObj(CommonPowerList.isFragment,CommonPowerList.GET_LOGOUT, SecretUtils.encrypt(httpPowerApi.getLogout(CommonPowerList.BUSI_LOGOUT,CommonPowerList.powerLogin.getUserAccount(), MD5.md5(CommonPowerList.powerLogin.getUserPwd()),CommonPowerList.powerLogin.getUserId())));
            }
        });
    }

    public void saveUserInfo(Context context, String username, String pas, boolean isremember, boolean islogin){
        /**
         * SharedPreferences将用户的数据存储到该包下的shared_prefs/config.xml文件中，
         * 并且设置该文件的读取方式为私有，即只有该软件自身可以访问该文件
         */
        SharedPreferences sPreferences=context.getSharedPreferences("userInfo",context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sPreferences.edit();
        //当然sharepreference会对一些特殊的字符进行转义，使得读取的时候更加准确
        editor.putString("username",username);
        editor.putString("password",pas);
        editor.putBoolean("remember",isremember);
        editor.putBoolean("autologin",islogin);
        //切记最后要使用commit方法将数据写入文件
        editor.commit();
    }

    @Override
    public void onNext(String resulte, String method) {
        if(method.equals(CommonPowerList.GET_LOGOUT)){
            if(isOtherUser){
                saveUserInfo(getContext(),"","",false,false);
                ActivityManager.getInstance().finishAllActivity();
                Intent  intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);

            }else {
                ActivityManager.getInstance().appExit(getContext());
            }
        }
        super.onNext(resulte, method);
    }
    @Override
    public void onError(ApiException e, String method) {
        Toast.makeText(getContext(),getResources().getString(R.string.logout_failed),Toast.LENGTH_SHORT).show();
        super.onError(e, method);
    }
}
