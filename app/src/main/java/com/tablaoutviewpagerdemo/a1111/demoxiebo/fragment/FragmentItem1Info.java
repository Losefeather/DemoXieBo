package com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.FuzzyQuery.SearchAdapter;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.GetDateMethod.GetDateMethod;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.HttpPageCount;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.HttpPowerApi;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.PowerResultEntity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.PowerMonitorId;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.PowerMonitorPoint;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.SteadyStateAlarm;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.R;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import superlibrary.adapter.BaseViewHolder;
import superlibrary.adapter.SuperBaseAdapter;
import superlibrary.recycleview.ProgressStyle;
import superlibrary.recycleview.SuperRecyclerView;

import static android.R.id.list;
import static android.util.Log.e;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity.setButton;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList.powerMonitorIdArrayList;

/**
 * Created by a1111 on 17/9/30.
 */

public class FragmentItem1Info extends BaseRxFragment  {

    public static final String TAG="FragmentItem1Info";
    public static  String key;
    public static  String gdName;
    private View view;
    private SuperRecyclerView srv;
    private List<PowerMonitorPoint> powerList=new ArrayList<PowerMonitorPoint>();
    private SuperRecyclerViewAdapter1 srva;
    private AutoCompleteTextView search;
    private SearchAdapter searchAdapter;
    private ImageView imageView;
    private int totalPage=100;
    private int page =1;
    private int count=5;
    private HttpPowerApi httpPowerApi=new HttpPowerApi(this,this);
    private boolean isRefresh=false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"init---------"+TAG);
        FeagmentActivity.Num=4;
        setButton();
        view= inflater.inflate(R.layout.fragment_item1_info,container,false);
        srv= view.findViewById(R.id.srv_item1_info);
        search=view.findViewById(R.id.actv_itenm1_search);
        imageView=view.findViewById(R.id.iv_item1_search);
        httpPowerApi=new HttpPowerApi(this,this);
        doWithStation(page);
        srva=new SuperRecyclerViewAdapter1(this.getContext(),powerList);
        searchAdapter=new SearchAdapter(getContext(), android.R.layout.simple_list_item_1,PowerMonitorId.getPowerMonitorListByCompany(FragmentItem1Info.gdName),SearchAdapter.ALL);
        search.setAdapter(searchAdapter);
        Log.e(TAG,"length:"+PowerMonitorId.getPowerMonitorListByCompany(FragmentItem1Info.gdName).length);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        srv.setLayoutManager(layoutManager);
        srv.setRefreshEnabled(true);//可以定制是否开启下拉刷新
        srv.setLoadMoreEnabled(true);//可以定制是否开启加载更多
        srv.setLoadingListener(new SuperRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                onRefreshData();
            }

            @Override
            public void onLoadMore() {
                onLodMoreData();
            }
        });//下拉刷新，上拉加载的监听
        srv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//下拉刷新的样式
        srv.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);//上拉加载的样式
        srv.setArrowImageView(R.mipmap.ic_pulltorefresh_arrow);//设置下拉箭头
        srv.setAdapter(srva);
        onClick();
        return view;
    }
    private void  doWithStation(int page){
        String stationName="";
        if(!search.getText().equals("")){
            stationName=getStationName(search.getText().toString());
        }
        Log.e(TAG,"stationName"+stationName);
        Log.e(TAG,"gdName"+FragmentItem1Info.gdName);
        Log.e(TAG,"key"+FragmentItem1Info.key);
        httpPowerApi.getTransientStateInfoList(true,CommonPowerList.GET_TRANSIENTSTATEINFOLIST,CommonPowerList.BUSI_ZTXQ,CommonPowerList.sercetKey,stationName,FragmentItem1Info.gdName,page,count,FragmentItem1Info.key, GetDateMethod.getCurrentDate()+" 00:00:00",GetDateMethod.getBeforHour());

    }
    private String getStationName(String name){
        String id="";
        if(powerMonitorIdArrayList.size()>0){
            for(PowerMonitorId powerMonitorId:powerMonitorIdArrayList){
                if(powerMonitorId.getPowerMonitorName().equals(name)){
                    id= powerMonitorId.getGetPowerMonitorId();
                }
            }
            return id;
        }else{
            return id;
        }
    }
    private void onClick(){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search.setText("");
            }
        });
        search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (KeyEvent.KEYCODE_ENTER == i && KeyEvent.ACTION_DOWN == keyEvent.getAction()) {
                    //处理事件
                    page=1;
                    isRefresh=true;
                    doWithStation(page);
                    return true;
                }
                return false;
            }
        });
    }
    private void onRefreshData(){
        page=1;
        isRefresh=true;
        doWithStation(page);
    }
    private void onLodMoreData(){
        if(totalPage-page*count>count) {
            page += 1;
            isRefresh = false;
            doWithStation(page);
        }else{
            srv.completeLoadMore();
        }
    }

    @Override
    public void onNext(String resulte, String method) {
        if (method.equals(CommonPowerList.GET_TRANSIENTSTATEINFOLIST)) {
            if(isRefresh){
                e(TAG,"onNextup");
                powerList.clear();
                Gson gson = new Gson();
                Type type = new TypeToken<PowerResultEntity<HttpPageCount<PowerMonitorPoint>>>(){}.getType();
                PowerResultEntity<HttpPageCount<PowerMonitorPoint>> baseInfo=gson.fromJson(resulte,type);
                for(int i=0;i<baseInfo.getData().getList().size();i++) {
                    powerList.add(baseInfo.getData().getList().get(i));
                }
                srva.notifyDataSetChanged();
                srv.completeRefresh();
            }else{
                e(TAG,"onNextdown");
                Gson gson = new Gson();
                Type type = new TypeToken<PowerResultEntity<HttpPageCount<PowerMonitorPoint>>>(){}.getType();
                PowerResultEntity<HttpPageCount<PowerMonitorPoint>> baseInfo=gson.fromJson(resulte,type);
                for(int i=0;i<baseInfo.getData().getList().size();i++) {
                    powerList.add(baseInfo.getData().getList().get(i));
                }
                srva.notifyDataSetChanged();
                srv.completeLoadMore();
            }
        }
        super.onNext(resulte, method);
    }

    @Override
    public void onError(ApiException e, String method) {
        e(TAG,"method:"+method);
        e(TAG,"ApiException:"+e.toString());
        if(isRefresh){
            srv.completeRefresh();
        }else{
            if(page>2){
                page--;
            }
            srv.completeLoadMore();
        }
        super.onError(e, method);
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