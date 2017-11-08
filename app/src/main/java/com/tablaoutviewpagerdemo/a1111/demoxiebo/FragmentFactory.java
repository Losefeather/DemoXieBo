package com.tablaoutviewpagerdemo.a1111.demoxiebo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem1;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem1Info;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem2;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem2Info;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem3;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem3Info;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem4;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentPowerShowAll;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentUserInfo;

import static com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem1.TAG;

/**
 * Created by a1111 on 17/9/28.
 */

public class FragmentFactory {
    public static Fragment fragment;

    public static Fragment getFragmentInstance(FragmentManager fragmentManager, String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment != null) {
            fragmentTransaction.hide(fragment);
        }
        if (tag.equals(FragmentPowerShowAll.TAG)) {
            fragment = new FragmentPowerShowAll();
            fragmentTransaction.replace(R.id.content,fragment);
        }
        if(tag.equals(FragmentItem1.TAG)){
            fragment = new FragmentItem1();
            fragmentTransaction.replace(R.id.content,fragment);
        }
        if(tag.equals(FragmentUserInfo.TAG)){
            fragment = new FragmentUserInfo();
            fragmentTransaction.replace(R.id.content,fragment);
        }
        if(tag.equals(FragmentItem1Info.TAG)){
            fragment = new FragmentItem1Info();
            fragmentTransaction.replace(R.id.content,fragment);
        }
        if(tag.equals(FragmentItem2.TAG)){
            fragment = new FragmentItem2();
            fragmentTransaction.replace(R.id.content,fragment);
        }
        if(tag.equals(FragmentItem2Info.TAG)){
            fragment = new FragmentItem2Info();
            fragmentTransaction.replace(R.id.content,fragment);
        }
        if(tag.equals(FragmentItem3.TAG)){
            fragment = new FragmentItem3();
            fragmentTransaction.replace(R.id.content,fragment);
        }
        if(tag.equals(FragmentItem3Info.TAG)){
            fragment = new FragmentItem3Info();
            fragmentTransaction.replace(R.id.content,fragment);
        }
        if(tag.equals(FragmentItem4.TAG)){
            fragment = new FragmentItem4();
            fragmentTransaction.replace(R.id.content,fragment);
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
        return fragment;
    }
}