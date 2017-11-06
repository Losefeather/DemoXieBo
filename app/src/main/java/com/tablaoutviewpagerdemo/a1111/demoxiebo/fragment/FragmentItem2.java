package com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.FuzzyQuery.SearchAdapter;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FragmentFactory;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.MainActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.SubstationInfo;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import superlibrary.adapter.BaseViewHolder;
import superlibrary.adapter.SuperBaseAdapter;
import superlibrary.recycleview.ProgressStyle;
import superlibrary.recycleview.SuperRecyclerView;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity.setButton;
import static java.security.AccessController.getContext;

/**
 * Created by a1111 on 17/9/30.
 */

public class FragmentItem2 extends BaseRxFragment {
    public static String TAG="FragmentItem2";
    private View view;
    private SearchView sv;
    private SuperRecyclerView srv;
    private AutoCompleteTextView search;
    private Spinner spinner;
    private List<SubstationInfo> powerList;
    private SearchAdapter searchAdapter;
    private ArrayAdapter<String> spinnerAdapter;
    private String[] str = {"东丽","南开","武清", "城东", "城西","检修","欢喜庄"};
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        FeagmentActivity.Num=0;
        setButton();
        view = inflater.inflate(R.layout.fragment_item2,container,false);
        sv=view.findViewById(R.id.sv_item2);
        srv=view.findViewById(R.id.srv_item2);
        search=view.findViewById(R.id.search);
        searchAdapter=new SearchAdapter(getContext(), android.R.layout.simple_list_item_1,str,SearchAdapter.ALL);
        search.setAdapter(searchAdapter);
        initData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        srv.setLayoutManager(layoutManager);
        srv.setRefreshEnabled(true);//可以定制是否开启下拉刷新
        srv.setLoadMoreEnabled(true);//可以定制是否开启加载更多
        srv.setLoadingListener(new SuperRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        srv.completeRefresh();
                        super.handleMessage(msg);
                    }
                };
                //handler.postDelayed(new Runnable().run();,2000);
            }

            @Override
            public void onLoadMore() {
                Handler  handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        srv.completeLoadMore();
                        super.handleMessage(msg);
                    }
                };
            }
        });//下拉刷新，上拉加载的监听
        srv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//下拉刷新的样式
        srv.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);//上拉加载的样式
        srv.setArrowImageView(R.mipmap.ic_pulltorefresh_arrow);//设置下拉箭头
        srv.setAdapter(new SuperRecyclerViewAdapter2(this.getContext(),powerList,this.getFragmentManager()));

        return view;
    }
    private void initData(){
        powerList=new ArrayList<SubstationInfo>();
        for(int i=0;i<5;i++){
            SubstationInfo si = new SubstationInfo();
            si.setXianlumingcheng("35kV受总" + new Random(3000).nextInt()+"");
            si.setBiandianzhanmingcheng("欢喜庄110kV变电站");
            si.setCTbianbi("1");
            si.setDianyadengji("110kV");
            si.setGongdianshebeirongliang("1(MVA)");
            si.setJianceduixiangleixing("电气化铁路");
            si.setJianceduixiangmingcheng("名称");
            si.setJizhunrongliang("1(MVA)");
            si.setPowerSataus(true);
            si.setPowerSatausInfo(false);
            si.setPTbianbi("1");
            si.setZuixiaoduanlurongliang("1(MVA)");
            si.setZhongduanxinghao("1");
            si.setZhongduanchangjia("天津国家电网");
            si.setYonghuxieyirongliang("1(MVA)");
            powerList.add(si);
        }
    }
}

class SuperRecyclerViewAdapter2 extends SuperBaseAdapter<SubstationInfo> {
    private FragmentManager fragmentManager;
    private Context context;
    public SuperRecyclerViewAdapter2(Context context) {

        super(context);
    }

    public SuperRecyclerViewAdapter2(Context context, List<SubstationInfo> data,FragmentManager fragmentManager) {
        super(context, data);
        this.context=context;
        this.fragmentManager=fragmentManager;
    }


    @Override
    protected void convert( BaseViewHolder holder, final SubstationInfo item, int position) {
        holder.setText(R.id.tv_recycler_item2_name, item.getBiandianzhanmingcheng());
        holder.setText(R.id.tv_recycler_item2_name2, item.getXianlumingcheng());
        if(item.isPowerSataus()){
            holder.setText(R.id.tv_recycler_item2_staus2, context.getString(R.string.zaiyun));
            holder.setBackgroundColor(R.id.tv_recycler_item2_staus2, Color.parseColor("#99cc33"));
        }else{
            holder.setText(R.id.tv_recycler_item2_staus2, context.getString(R.string.tingyun));
            holder.setBackgroundColor(R.id.tv_recycler_item2_staus2, Color.parseColor("#FF0000"));
        }
        if(item.isPowerSatausInfo()){
            holder.setText(R.id.tv_recycler_item2_staus1, context.getString(R.string.zhengchang));
            holder.setBackgroundColor(R.id.tv_recycler_item2_staus1, Color.parseColor("#99cc33"));
        }else{
            holder.setText(R.id.tv_recycler_item2_staus1, context.getString(R.string.yichang));
            holder.setBackgroundColor(R.id.tv_recycler_item2_staus1, Color.parseColor("#FF0000"));
        }
        holder.getView(R.id.rl_recyc_item2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentFactory.getFragmentInstance(fragmentManager,FragmentItem2Info.TAG);
                FragmentItem2Info.si=item;
            }
        });
    }


    @Override
    protected int getItemViewLayoutId(int position, SubstationInfo item) {
        return R.layout.recycler_item2;
    }
}