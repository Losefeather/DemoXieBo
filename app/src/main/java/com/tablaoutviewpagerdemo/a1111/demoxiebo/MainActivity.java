package com.tablaoutviewpagerdemo.a1111.demoxiebo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.SysApplication;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SysApplication.getInstance().addActivity(this);
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);

    }
}
