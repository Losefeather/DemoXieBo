package com.tablaoutviewpagerdemo.a1111.demoxiebo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences.Editor;


import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.SysApplication;
import com.trello.rxlifecycle.components.RxActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;


/**
 * Created by a1111 on 17/9/28.
 */

public class LoginActivity extends RxActivity implements HttpOnNextListener{
    private final String TAG ="SharedPreferences";
    private EditText username;
    private EditText userpassword;
    private CheckBox remember;
    private CheckBox autologin;
    private Button login;
    private SharedPreferences sp;
    private String userNameValue,passwordValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SysApplication.getInstance().addActivity(this);
        setContentView(R.layout.login);
        // 初始化用户名、密码、记住密码、自动登录、登录按钮
        username = (EditText) findViewById(R.id.username);
        userpassword = (EditText) findViewById(R.id.userpassword);
        remember = (CheckBox) findViewById(R.id.remember);
        autologin = (CheckBox) findViewById(R.id.autologin);
        login = (Button) findViewById(R.id.login);

        sp = getSharedPreferences("userInfo", 0);
        String name=sp.getString("USER_NAME", "");
        String pass =sp.getString("PASSWORD", "");


        boolean choseRemember =sp.getBoolean("remember", false);
        boolean choseAutoLogin =sp.getBoolean("autologin", false);
        //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        //如果上次选了记住密码，那进入登录页面也自动勾选记住密码，并填上用户名和密码
        if(choseRemember){
            username.setText(name);
            userpassword.setText(pass);
            remember.setChecked(true);
        }
        //如果上次登录选了自动登录，那进入登录页面也自动勾选自动登录
        if(choseAutoLogin){
            autologin.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {

            // 默认可登录帐号tinyphp,密码123
            @Override
            public void onClick(View arg0) {
                userNameValue = username.getText().toString();
                passwordValue = userpassword.getText().toString();
                SharedPreferences.Editor editor =sp.edit();

                // TODO Auto-generated method stub
                if (userNameValue.equals("admin") && passwordValue.equals("admin")) {
                    Toast.makeText(LoginActivity.this, "登录成功",
                            Toast.LENGTH_SHORT).show();
                    //保存用户名和密码
                    editor.putString("USER_NAME", userNameValue);
                    editor.putString("PASSWORD", passwordValue);
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

//        saveUserInfo(this,"jiangkui","123456");
//        SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
//        String Name=preferences.getString("username","");
//        String password = preferences.getString("password","");
//        Log.e(TAG,"name:"+Name+" password"+password);

    }
    public static void saveUserInfo(Context context, String username, String pas){
        /**
         * SharedPreferences将用户的数据存储到该包下的shared_prefs/config.xml文件中，
         * 并且设置该文件的读取方式为私有，即只有该软件自身可以访问该文件
         */
        SharedPreferences sPreferences=context.getSharedPreferences("config", context.MODE_PRIVATE);
        Editor editor=sPreferences.edit();
        //当然sharepreference会对一些特殊的字符进行转义，使得读取的时候更加准确
        editor.putString("username", username);
        editor.putString("password", pas);
        //这里我们输入一些特殊的字符来实验效果
        editor.putString("specialtext", "hajsdh><?//");
        editor.putBoolean("or", true);
        editor.putInt("int", 47);
        //切记最后要使用commit方法将数据写入文件
        editor.commit();
    }


    @Override
    public void onNext(String resulte, String method) {

    }

    @Override
    public void onError(ApiException e, String method) {

    }
}
