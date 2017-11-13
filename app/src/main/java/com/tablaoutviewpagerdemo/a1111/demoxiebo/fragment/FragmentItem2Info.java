package com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.SubstationInfo;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import static com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity.setButton;

/**
 * Created by a1111 on 17/10/9.
 */

public class FragmentItem2Info extends BaseRxFragment {
    public static String TAG="FragmentItem2Info";
    private View view;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13;
    public static SubstationInfo si;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"init---------"+TAG);
        FeagmentActivity.Num=2;
        setButton();
        view =inflater.inflate(R.layout.fragment_item2_info,container,false);
        tv1=view.findViewById(R.id.tv_item2_info_1);
        tv2=view.findViewById(R.id.tv_item2_info_2);
        tv3=view.findViewById(R.id.tv_item2_info_3);
        tv4=view.findViewById(R.id.tv_item2_info_4);
        tv5=view.findViewById(R.id.tv_item2_info_5);
        tv6=view.findViewById(R.id.tv_item2_info_6);
        tv7=view.findViewById(R.id.tv_item2_info_7);
        tv8=view.findViewById(R.id.tv_item2_info_8);
        tv9=view.findViewById(R.id.tv_item2_info_9);
        tv10=view.findViewById(R.id.tv_item2_info_10);
        tv11=view.findViewById(R.id.tv_item2_info_11);
        tv12=view.findViewById(R.id.tv_item2_info_12);
        tv13=view.findViewById(R.id.tv_item2_info_13);

        tv1.setText(getText(R.string.biandianzhan)+":"+si.getBiandianzhanmingcheng());
        tv2.setText(getText(R.string.xianlumingcheng)+":"+si.getXianlumingcheng());
        tv3.setText(getText(R.string.jianceduixiangleixing)+":"+si.getJianceduixiangleixing());
        tv4.setText(getText(R.string.jianceduixiangmingcheng)+":"+si.getJianceduixiangmingcheng());
        tv5.setText(getText(R.string.dianyadengji)+":"+si.getDianyadengji());
        tv6.setText(getText(R.string.zuixiaoduanlurongliang)+":"+si.getZuixiaoduanlurongliang());
        tv7.setText(getText(R.string.gongdianshebeirongliang)+":"+si.getGongdianshebeirongliang());
        tv8.setText(getText(R.string.yonghuxieyirongliang)+":"+si.getYonghuxieyirongliang());
        tv9.setText(getText(R.string.jizhunrongliang)+":"+si.getJizhunrongliang());
        tv10.setText(getText(R.string.pt)+":"+si.getPT1()+"/"+si.getPT2());
        tv11.setText(getText(R.string.ct)+":"+si.getCT1()+"/"+si.getCT2());
        tv12.setText(getText(R.string.zhongduanchangjia)+":"+si.getZhongduanchangjia());
        tv13.setText(getText(R.string.zhongduanxinghao)+":"+si.getZhongduanxinghao());

        return view;
    }
}
