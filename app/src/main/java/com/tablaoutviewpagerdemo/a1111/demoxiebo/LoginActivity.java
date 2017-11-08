package com.tablaoutviewpagerdemo.a1111.demoxiebo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.content.SharedPreferences.Editor;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.ActivityManager;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.SysApplication;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpMessageEntity.BaseResultEntity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.HttpPowerApi;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.AreaTotal;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList;
import com.trello.rxlifecycle.components.RxActivity;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

import java.lang.reflect.Type;
import java.util.List;


/**
 * Created by a1111 on 17/9/28.
 */

public class LoginActivity extends RxAppCompatActivity implements HttpOnNextListener{
    private final String TAG ="Login";
    private EditText username;
    private EditText userpassword;
    private CheckBox remember;
    private CheckBox autologin;
    private Button login;
    private ProgressBar progressBar;
    private SharedPreferences sp;
    private String userNameValue,passwordValue;
    private String name,pass;
    private boolean choseRemember,choseAutoLogin;
    private boolean isChanged;
    private HttpPowerApi httpPowerApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.login);
        httpPowerApi=new HttpPowerApi(this,this);
        // 初始化用户名、密码、记住密码、自动登录、登录按钮
        username = (EditText) findViewById(R.id.username);
        userpassword = (EditText) findViewById(R.id.userpassword);
        remember = (CheckBox) findViewById(R.id.remember);
        autologin = (CheckBox) findViewById(R.id.autologin);
        login = (Button) findViewById(R.id.login);
        progressBar=(ProgressBar)findViewById(R.id.login_progressBar);
        sp = getSharedPreferences("userInfo", 0);
        name=sp.getString("username","");
        pass =sp.getString("password","");
        choseRemember =sp.getBoolean("remember", false);
        choseAutoLogin =sp.getBoolean("autologin", false);
        //如果上次选了记住密码，那进入登录页面也自动勾选记住密码，并填上用户名和密码
        if(choseRemember){
            username.setText(name);
            userpassword.setText(pass);
            remember.setChecked(true);
        }
        //如果上次登录选了自动登录，那进入登录页面也自动勾选自动登录
        if(choseAutoLogin){
            autologin.setChecked(true);
            progressBar.setVisibility(View.VISIBLE);
            httpPowerApi.getLogin(false,CommonPowerList.GET_LONGIN,name,pass);
        }

        login.setOnClickListener(new View.OnClickListener() {

            // 默认可登录帐号tinyphp,密码123
            @Override
            public void onClick(View arg0) {
                progressBar.setVisibility(View.VISIBLE);
                userNameValue = username.getText().toString();
                passwordValue = userpassword.getText().toString();
                SharedPreferences.Editor editor =sp.edit();
              //  httpPowerApi.getLogin(false,CommonPowerList.GET_LONGIN,userNameValue,passwordValue);
                // TODO Auto-generated method stub
                if (userNameValue.equals("admin") && passwordValue.equals("admin")) {
//                    Toast.makeText(LoginActivity.this, "登录成功",
//                            Toast.LENGTH_SHORT).show();
                    //保存用户名和密码
                    editor.putString("username", userNameValue);
                    editor.putString("password", passwordValue);
                    //是否记住密码
                    if(remember.isChecked()){
                        editor.putBoolean("remember", true);
                    }else{
                        editor.putBoolean("remember", false);
                    }
                    //是否自动登录
                    if(autologin.isChecked()){
                        editor.putBoolean("autologin", true);
                    }else{
                        editor.putBoolean("autologin", false);
                    }
                    editor.commit();
                    //跳转
                  Intent intent =new Intent(LoginActivity.this,FeagmentActivity.class);
                  startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "用户名或密码错误，请重新登录!",
                            Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
    private void saveUserInfo(Context context, String username, String pas,boolean isremember,boolean islogin){
        /**
         * SharedPreferences将用户的数据存储到该包下的shared_prefs/config.xml文件中，
         * 并且设置该文件的读取方式为私有，即只有该软件自身可以访问该文件
         */
        SharedPreferences sPreferences=context.getSharedPreferences("userInfo", context.MODE_PRIVATE);
        Editor editor=sPreferences.edit();
        //当然sharepreference会对一些特殊的字符进行转义，使得读取的时候更加准确
        editor.putString("username", username);
        editor.putString("password", pas);
        editor.putBoolean("remember",isremember);
        editor.putBoolean("autologin",islogin);
        //切记最后要使用commit方法将数据写入文件
        editor.commit();
    }


    @Override
    public void onNext(String resulte, String method) {
        Log.e(TAG,"next"+method);
        if(method.equals(CommonPowerList.GET_LONGIN)){
           if(true){
               saveUserInfo(getApplicationContext(),username.getText().toString(),userpassword.getText().toString(),remember.isChecked(),autologin.isChecked());
           }
            httpPowerApi.getPowerList(false,CommonPowerList.GET_POWERLIST,CommonPowerList.sercetKey);

        }
        if(method.equals(CommonPowerList.GET_POWERLIST)){
            Intent intent =new Intent(LoginActivity.this,FeagmentActivity.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "登录成功",
                    Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onError(ApiException e, String method) {
        Log.e(TAG,"error"+method);
        if(method.equals(CommonPowerList.GET_LONGIN)){
            if(true){
                saveUserInfo(getApplicationContext(),username.getText().toString(),userpassword.getText().toString(),remember.isChecked(),autologin.isChecked());
            }
            httpPowerApi.getPowerList(false,CommonPowerList.GET_POWERLIST,CommonPowerList.sercetKey);

        }
        if(method.equals(CommonPowerList.GET_POWERLIST)){
            Intent intent =new Intent(LoginActivity.this,FeagmentActivity.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "登录成功",
                    Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}
