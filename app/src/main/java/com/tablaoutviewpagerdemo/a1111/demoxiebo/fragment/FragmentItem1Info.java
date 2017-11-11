package com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.SearchView;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.FuzzyQuery.SearchAdapter;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.HttpPowerApi;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.PowerMonitorPoint;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.R;
import com.trello.rxlifecycle.components.support.RxFragment;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import superlibrary.adapter.BaseViewHolder;
import superlibrary.adapter.SuperBaseAdapter;
import superlibrary.recycleview.ProgressStyle;
import superlibrary.recycleview.SuperRecyclerView;

import static com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity.setButton;


/**
 * Created by a1111 on 17/9/30.
 */

public class FragmentItem1Info extends BaseRxFragment  {

    public static final String TAG="FragmentItem1Info";
    private View view;
    private SearchView sv;
    private SuperRecyclerView srv;
    private List<PowerMonitorPoint> powerList=new ArrayList<PowerMonitorPoint>();
    private SuperRecyclerViewAdapter1 srva;
    private AutoCompleteTextView search;
    private SearchAdapter searchAdapter;
    private ArrayAdapter<String> spinnerAdapter;
    private ImageView imageView;
    private int page =1;
    private int count=5;
    private HttpPowerApi httpPowerApi=new HttpPowerApi(this,this);
    private boolean isRefresh=false;
    private String busiName="",stationName="";
    private String[] str = {"东丽","南开","武清", "城东", "城西","检修","欢喜庄"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FeagmentActivity.Num=4;
        setButton();
        view= inflater.inflate(R.layout.fragment_item1_info,container,false);
        sv=view.findViewById(R.id.sv_item1_info);
        srv= view.findViewById(R.id.srv_item1_info);
        initData();
        srva=new SuperRecyclerViewAdapter1(this.getContext(),powerList);
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
        powerList.clear();
        for(int i =0;i<5;i++){
            PowerMonitorPoint power = new PowerMonitorPoint();
            power.setCanyudianya(""+new Random(1).nextFloat());
            power.setChixushijian("10.0");
            power.setDianzhanmingcheng("蓟县站");
            power.setFashengshijian("2017-08-29 12:23:12");
            power.setGongdiandanwei("检修");
            power.setMuxianmingcheng("110kv |||母");
            power.setShijianleixing(getString(R.string.dianyazansheng));
            power.setXiangbie("A");
            power.setXianlumingcheng("117蓟金");
            powerList.add(power);
        }
    }
    public void reFreash(){
        powerList.clear();
        for(int i=0;i<5;i++){
            PowerMonitorPoint power = new PowerMonitorPoint();
            power.setCanyudianya(""+new Random(1).nextFloat());
            power.setChixushijian("10.0");
            power.setDianzhanmingcheng("蓟县站");
            power.setFashengshijian("2017-08-29 12:23:12");
            power.setGongdiandanwei("检修");
            power.setMuxianmingcheng("110kv |||母");
            power.setShijianleixing(getString(R.string.dianyazansheng));
            power.setXiangbie("A");
            power.setXianlumingcheng("117蓟金");
            powerList.add(power);
        }
        srva.notifyDataSetChanged();
        srv.completeRefresh();
    }
    public void reLoadMore(){
        for(int i=0;i<5;i++){
            PowerMonitorPoint power = new PowerMonitorPoint();
            power.setCanyudianya(""+new Random(1).nextFloat());
            power.setChixushijian("10.0");
            power.setDianzhanmingcheng("蓟县站");
            power.setFashengshijian("2017-08-29 12:23:12");
            power.setGongdiandanwei("检修");
            power.setMuxianmingcheng("110kv |||母");
            power.setShijianleixing(getString(R.string.dianyazansheng));
            power.setXiangbie("A");
            power.setXianlumingcheng("117蓟金");
            powerList.add(power);
        }
        srva.notifyDataSetChanged();
        srv.completeLoadMore();
    }

    @Override
    public void onNext(String resulte, String method) {
        super.onNext(resulte, method);
    }

    @Override
    public void onError(ApiException e, String method) {
        super.onError(e, method);
    }
}
class SuperRecyclerViewAdapter1 extends SuperBaseAdapter<PowerMonitorPoint> {


    public SuperRecyclerViewAdapter1(Context context) {

        super(context);
    }

    public SuperRecyclerViewAdapter1(Context context, List<PowerMonitorPoint> data) {

        super(context, data);
    }


    @Override
    protected void convert(final BaseViewHolder holder, PowerMonitorPoint item, int position) {
        holder.setText(R.id.tv_recyc_item_dianzhanmingcheng, item.getDianzhanmingcheng());
        holder.setText(R.id.tv_recyc_item_fashengshijian, item.getFashengshijian());
        holder.setText(R.id.tv_recyc_item_gongdiandanwei, item.getGongdiandanwei());
        holder.setText(R.id.tv_recyc_item_muxianmingcheng, item.getMuxianmingcheng());
        holder.setText(R.id.tv_recyc_item_shijianleixing, item.getShijianleixing());
        holder.setText(R.id.tv_recyc_item_xiangbie, item.getXiangbie());
        holder.setText(R.id.tv_recyc_item_xianlumingcheng, item.getXianlumingcheng());
        holder.setText(R.id.tv_crcyle_canyudianya, item.getCanyudianya());
        holder.setText(R.id.tv_crcyle_chixushijian, item.getChixushijian());


    }

    @Override
    protected int getItemViewLayoutId(int position, PowerMonitorPoint item) {
        return R.layout.recycler_item_info1;
    }
}