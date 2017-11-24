package com.tablaoutviewpagerdemo.a1111.demoxiebo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.ActivityManager;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.MD5.MD5;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.MD5.SecretUtils;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.SysApplication;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.HttpPowerApi;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem1;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem1Info;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem2;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem2Info;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem3;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem3Info;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem4;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentUserInfo;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.ui.CircleImageView.CircleImageView;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.ui.CustomDialog.CustomDialog;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.ui.KyDialog.KyDialogBuilder;
import com.trello.rxlifecycle.components.support.RxFragmentActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

import static org.greenrobot.greendao.DaoLog.e;

/**
 * Creed by a1111 on 17/9/28.
 */

public class FeagmentActivity extends RxFragmentActivity {
    public  final String TAG ="FeagmentActivity";
    public static int Num=0;
    private TextView tv1,tv2,tv3,tv4,tv_title;
    private CircleImageView civ;
    private FrameLayout fl;
    private static Button bt_back;
    public FeagmentActivity() {
        super();
    }

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
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
              goBack();
            }
        });
    }
    public void goBack(){
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
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Log.e(TAG,""+"执行了"+FragmentFactory.currentFragment);
            if(FragmentFactory.currentFragment.equalsIgnoreCase(FragmentItem1.TAG)||
                    FragmentFactory.currentFragment.equalsIgnoreCase(FragmentItem2.TAG)||
                    FragmentFactory.currentFragment.equalsIgnoreCase(FragmentItem3.TAG)||
                    FragmentFactory.currentFragment.equalsIgnoreCase(FragmentItem4.TAG)){
 //               final KyDialogBuilder builder = new KyDialogBuilder(this);
//                builder.setTitle("查找附近wifi网络");
//                builder.setMessage("确认退出程序吗?");
//                builder.setNegativeButton("取消", new View.OnClickListener(){//添加取消按钮
//                    @Override
//                    public void onClick(View arg0) {
//                        builder.dismiss();//关闭对话框
//                    }
//                });
//                builder.setPositiveButton("确认", new View.OnClickListener(){//添加确认按钮
//                    @Override
//                    public void onClick(View arg0) {
//                        ActivityManager.getInstance().appExit(getApplicationContext());
//                        builder.dismiss();
//                    }
//                });
//                builder.setPositiveNormalTextColor(0xFF48CE3A);//设置确认按钮的字体颜色
//                builder.setPositivePressedTextColor(0xFF48CE3A);//设置确认按钮，当手指按下时的字体颜色
//                builder.setBackgroundAlpha(160);//对话框外区域的透明度
//                builder.show();//打开对话框
            }else if(FragmentFactory.currentFragment.equals(FragmentItem1Info.TAG)){
                goBack();
            }else if(FragmentFactory.currentFragment.equals(FragmentItem2Info.TAG)){
                goBack();
            }else if(FragmentFactory.currentFragment.equals(FragmentItem3Info.TAG)){
                goBack();
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
