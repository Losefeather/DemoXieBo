package com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FragmentFactory;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.Power;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.SteadyStateAlarm;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;

import superlibrary.adapter.BaseViewHolder;
import superlibrary.adapter.SuperBaseAdapter;
import superlibrary.recycleview.ProgressStyle;
import superlibrary.recycleview.SuperRecyclerView;

import static android.R.attr.id;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity.setButton;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.R.id.rcv;

/**
 * Created by a1111 on 17/10/10.
 */

public class FragmentItem3Info extends BaseRxFragment {
    public static String TAG = "FragmentItem3Info";
    private View view;
    private SearchView sv;
    private SuperRecyclerView srv;
    private SuperRecyclerViewZAdapter srva;
    private List<SteadyStateAlarm> list = new ArrayList<SteadyStateAlarm>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FeagmentActivity.Num=3;
        setButton();
        view=inflater.inflate(R.layout.fragment_item3_info,container,false);
        sv=view.findViewById(R.id.sv_item3);
        srv=view.findViewById(R.id.srv_item3);
        srva=new SuperRecyclerViewZAdapter(this.getContext(),list,this.getFragmentManager());
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
                        reFreash();
                        super.handleMessage(msg);
                    }
                };
                handler.sendEmptyMessage(123);
            }

            @Override
            public void onLoadMore() {
                Handler  handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        reLoadMore();
                        super.handleMessage(msg);
                    }
                };
                handler.sendEmptyMessage(123);
            }
        });//下拉刷新，上拉加载的监听
        srv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//下拉刷新的样式
        srv.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);//上拉加载的样式
        srv.setArrowImageView(R.mipmap.ic_pulltorefresh_arrow);//设置下拉箭头
        srv.setAdapter(srva);

        return view;
    }
    public void initData(){
        list.clear();
        for(int i=0;i<5;i++){
            SteadyStateAlarm ssa = new SteadyStateAlarm();
            ssa.setDiaanzhanmingcheng("东丽湖110kV变电站");
            ssa.setFashengshijian("2017-11-10 23:23:59");
            ssa.setGongdiandanwei(getString(R.string.dongli));
            ssa.setGuojizhi(1.0);
            ssa.setJiancedian("202受总");
            ssa.setShijizhi(1.74);
            ssa.setYuechuzhi(0.74);
            ssa.setZhibiaoleixing("闪变越限");
            list.add(ssa);
        }
    }
    public void reFreash(){
        list.clear();
        for(int i=0;i<5;i++){
            SteadyStateAlarm ssa = new SteadyStateAlarm();
            ssa.setDiaanzhanmingcheng("东丽湖110kV变电站");
            ssa.setFashengshijian("2017-11-10 23:23:59");
            ssa.setGongdiandanwei(getString(R.string.dongli));
            ssa.setGuojizhi(1.0);
            ssa.setJiancedian("202受总");
            ssa.setShijizhi(1.74);
            ssa.setYuechuzhi(0.74);
            ssa.setZhibiaoleixing("闪变越限");
            list.add(ssa);
        }
        srva.notifyDataSetChanged();
        srv.completeRefresh();
    }
    public void reLoadMore(){
        for(int i=0;i<5;i++){
            SteadyStateAlarm ssa = new SteadyStateAlarm();
            ssa.setDiaanzhanmingcheng("东丽湖110kV变电站");
            ssa.setFashengshijian("2017-11-10 23:23:59");
            ssa.setGongdiandanwei(getString(R.string.dongli));
            ssa.setGuojizhi(1.0);
            ssa.setJiancedian("202受总");
            ssa.setShijizhi(1.74);
            ssa.setYuechuzhi(0.74);
            ssa.setZhibiaoleixing("闪变越限");
            list.add(ssa);
        }
        srva.notifyDataSetChanged();
        srv.completeLoadMore();
    }
}
class SuperRecyclerViewZAdapter extends SuperBaseAdapter<SteadyStateAlarm>{


    public FragmentManager fragmentManager;
    public SuperRecyclerViewZAdapter(Context context) {
        super(context);
    }

    public SuperRecyclerViewZAdapter(Context context, List<SteadyStateAlarm> data) {
        super(context, data);
    }
    public SuperRecyclerViewZAdapter(Context context, List<SteadyStateAlarm> data, FragmentManager fragmentManager) {
        super(context, data);
        this.fragmentManager=fragmentManager;
    }

    @Override
    protected void convert(final BaseViewHolder holder, SteadyStateAlarm item, int position) {
        holder.setText(R.id.tv_recyc_item3_gongdiandanwei,item.getGongdiandanwei());
        holder.setText(R.id.tv_recyc_item3_dianzhanmingcheng,item.getDiaanzhanmingcheng());
        holder.setText(R.id.tv_recyc_item3_jiancedian,item.getJiancedian());
        holder.setText(R.id.tv_recyc_item3_zhibiaoleixing,item.getZhibiaoleixing());
        holder.setText(R.id.tv_recyc_item3_fashengshijian,item.getFashengshijian());

        holder.setText(R.id.tv_recyc_item3_guojizhi,item.getGuojizhi()+"");
        holder.setText(R.id.tv_recyc_item3_shijizhi,item.getShijizhi()+"");
        holder.setText(R.id.tv_recyc_item3_yuechuzhi,item.getYuechuzhi()+"");
    }
    @Override
    protected int getItemViewLayoutId(int position, SteadyStateAlarm item) {
        return R.layout.recycler_item3_info;
    }


}