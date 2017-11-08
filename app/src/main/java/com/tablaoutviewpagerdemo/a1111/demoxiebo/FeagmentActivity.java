package com.tablaoutviewpagerdemo.a1111.demoxiebo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.ActivityManager;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.SysApplication;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem1;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem2;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem3;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem4;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentUserInfo;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.ui.CircleImageView.CircleImageView;
import com.trello.rxlifecycle.components.support.RxFragmentActivity;

/**
 * Creed by a1111 on 17/9/28.
 */

public class FeagmentActivity extends RxFragmentActivity {
    public static final String TAG = " FeagmentActivity";
    public static int Num=0;
    private TextView tv1,tv2,tv3,tv4,tv_title;
    private CircleImageView civ;
    private FrameLayout fl;
    private static Button bt_back;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        ActivityManager.getInstance().addActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_menu);
        tv_title = this.findViewById(R.id.tv_menu_title);
        tv1=this.findViewById(R.id.tv_item1);
        tv2=this.findViewById(R.id.tv_item2);
        tv3=this.findViewById(R.id.tv_item3);
        tv4=this.findViewById(R.id.tv_item4);;
        fl =this.findViewById(R.id.content);
        civ=this.findViewById(R.id.civ);
        bt_back = this.findViewById(R.id.bt_back);
        if(Num==0){
            bt_back.setVisibility(View.INVISIBLE);
        }else{
            bt_back.setVisibility(View.VISIBLE);
        }
        setMainView(1);
        FragmentFactory.getFragmentInstance(getSupportFragmentManager(), FragmentItem4.TAG);
        civ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentFactory.getFragmentInstance(getSupportFragmentManager(), FragmentUserInfo.TAG);
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMainView(1);
                FragmentFactory.getFragmentInstance(getSupportFragmentManager(), FragmentItem4.TAG);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMainView(2);
                FragmentFactory.getFragmentInstance(getSupportFragmentManager(), FragmentItem2.TAG);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMainView(3);
                FragmentFactory.getFragmentInstance(getSupportFragmentManager(), FragmentItem3.TAG);
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMainView(4);
                FragmentFactory.getFragmentInstance(getSupportFragmentManager(),FragmentItem1.TAG);
            }
        });
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Num==1){
                    setMainView(1);
                    FragmentFactory.getFragmentInstance(getSupportFragmentManager(), FragmentItem4.TAG);
                }
                if(Num==2){
                    setMainView(2);
                    FragmentFactory.getFragmentInstance(getSupportFragmentManager(), FragmentItem2.TAG);
                }
                if(Num==3){
                    setMainView(3);
                    FragmentFactory.getFragmentInstance(getSupportFragmentManager(), FragmentItem3.TAG);
                }
                if(Num==4){
                    setMainView(4);
                    FragmentFactory.getFragmentInstance(getSupportFragmentManager(),FragmentItem1.TAG);
                }
            }
        });
    }

    public  void setMainView(int index){
        switch (index) {
            case 1: {
                tv_title.setText(R.string.zhibiaogailan);
            }break;
            case 2:{
                tv_title.setText(R.string.jiancedianzonglan);
            }break;
            case 3:{
                tv_title.setText(R.string.wentaigaojing);
            }break;
            case 4:{
                tv_title.setText(R.string.zantaigaojing);
            }break;
        }
        reSetButtom(index);
    }
    public void reSetButtom(int index){
        tv1.setBackgroundColor(Color.parseColor("#F5F5F5"));
        tv2.setBackgroundColor(Color.parseColor("#F5F5F5"));
        tv3.setBackgroundColor(Color.parseColor("#F5F5F5"));
        tv4.setBackgroundColor(Color.parseColor("#F5F5F5"));
        switch(index){
            case 1:{
                tv1.setBackgroundColor(Color.parseColor("#8C8C8C"));
            }break;
            case 2:{
                tv2.setBackgroundColor(Color.parseColor("#8C8C8C"));
            }break;
            case 3:{
                tv3.setBackgroundColor(Color.parseColor("#8C8C8C"));
            }break;
            case 4:{
                tv4.setBackgroundColor(Color.parseColor("#8C8C8C"));
            }break;
        }
    }
    public static void setButton(){
        if(Num==0){
            bt_back.setVisibility(View.INVISIBLE);
        }else{
            bt_back.setVisibility(View.VISIBLE);
        }
    }
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
//            SysApplication.getInstance().exit();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
