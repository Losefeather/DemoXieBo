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
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.FuzzyQuery.SearchAdapter;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.MD5.SecretUtils;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FragmentFactory;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.HttpPageCount;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.HttpPowerApi;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.PowerResultEntity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.MainActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.PowerGson;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.PowerMonitorId;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.SubstationInfo;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.R;
import com.trello.rxlifecycle.components.support.RxFragment;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import superlibrary.adapter.BaseViewHolder;
import superlibrary.adapter.SuperBaseAdapter;
import superlibrary.recycleview.ProgressStyle;
import superlibrary.recycleview.SuperRecyclerView;

import static android.R.attr.onClick;
import static android.R.id.list;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity.setButton;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList.isFirstIntoFragment2;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList.powerMonitorIdArrayList;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList.substationInfoArrayList;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentItem3Info.type;
import static java.security.AccessController.getContext;
import static junit.runner.Version.id;
import static org.greenrobot.greendao.DaoLog.e;

/**
 * Created by a1111 on 17/9/30.
 */

public class FragmentItem2 extends BaseRxFragment{
    public static String TAG="FragmentItem2";
    private View view;
    private SuperRecyclerView srv;
    private AutoCompleteTextView search;
    private ImageView imageView;
    private ArrayList<SubstationInfo> powerList=new ArrayList<SubstationInfo>();
    private SearchAdapter searchAdapter;
    private int totalPage=100;
    private int page=1;
    private int count=13;
    private HttpPowerApi httpPowerApi= new HttpPowerApi(this,this);
    private boolean isRefresh=false;
    private String[] str =new String[]{"天津","天津"};
    private SuperRecyclerViewAdapter2 superRecyclerViewAdapter2;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG,"init---------"+TAG);
        FeagmentActivity.Num=0;
        setButton();
        view = inflater.inflate(R.layout.fragment_item2,container,false);
        srv=view.findViewById(R.id.srv_item2);
        search=view.findViewById(R.id.search);
        imageView=view.findViewById(R.id.iv_item2_search);
        if(isFirstIntoFragment2){
            doWithStation(page);
        }
        if(CommonPowerList.substationInfoArrayList.size()>0){
            powerList=CommonPowerList.substationInfoArrayList;
        }

        searchAdapter=new SearchAdapter(getContext(),android.R.layout.simple_list_item_1,inloadngString(), SearchAdapter.ALL);
        search.setAdapter(searchAdapter);
        onClick();
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
        superRecyclerViewAdapter2=new SuperRecyclerViewAdapter2(this.getContext(),powerList,this.getFragmentManager());
        srv.setAdapter(superRecyclerViewAdapter2);

        return view;
    }
    private String[] inloadngString(){
        List<String> stringArrayList = new ArrayList<String>();
        if (CommonPowerList.powerMonitorIdArrayList.size() > 0) {
            for(int i=0;i<CommonPowerList.powerMonitorIdArrayList.size();i++) {
                stringArrayList.add(powerMonitorIdArrayList.get(i).getPowerMonitorName());
            }
             return stringArrayList.toArray(str);
        }else{

           return str;
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
        if(totalPage-page*count>count){
            page+=1;
            isRefresh=false;
            doWithStation(page);
        }else{
            srv.completeLoadMore();
        }
    }
    private void  doWithStation(int page){
        String stationName="";
        String stationId="";
        if(!search.getText().toString().equals("")){
            stationId=getStationName(search.getText().toString());
            stationName=search.getText().toString();
        }
        Log.e(TAG,"stationId"+stationId);
        Log.e(TAG,"stationName"+stationName);
       // httpPowerApi.getStationList(CommonPowerList.isFragment,CommonPowerList.GET_STSATIONLIST,CommonPowerList.BUSI_JCDZL,CommonPowerList.sercetKey,stationId,stationName,page,count);
        httpPowerApi.getObj(CommonPowerList.isFragment,CommonPowerList.GET_STSATIONLIST, SecretUtils.encrypt(httpPowerApi.getStationList(CommonPowerList.BUSI_JCDZL,stationId,stationName,page,count)));
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
    @Override
    public void onNext(String resulte, String method) {
        if (method.equals(CommonPowerList.GET_STSATIONLIST)) {
            if(isFirstIntoFragment2){
                isFirstIntoFragment2=false;
            }
            if(isRefresh){
                Log.e(TAG,"onNextup");
                powerList.clear();
                Gson gson = new Gson();
                Type type = new TypeToken<PowerResultEntity<HttpPageCount<SubstationInfo>>>(){}.getType();
                PowerResultEntity<HttpPageCount<SubstationInfo>> baseInfo=gson.fromJson(resulte,type);
                totalPage=Integer.valueOf(baseInfo.getData().getTotal());
                for(int i=0;i<baseInfo.getData().getList().size();i++) {
                    powerList.add(baseInfo.getData().getList().get(i));
                }
                superRecyclerViewAdapter2.notifyDataSetChanged();
                srv.completeRefresh();
            }else{
                Log.e(TAG,"onNextdown");
                Gson gson = new Gson();
                Type type = new TypeToken<PowerResultEntity<HttpPageCount<SubstationInfo>>>(){}.getType();
                PowerResultEntity<HttpPageCount<SubstationInfo>> baseInfo=gson.fromJson(resulte,type);
                totalPage=Integer.valueOf(baseInfo.getData().getTotal());
                for(int i=0;i<baseInfo.getData().getList().size();i++) {
                    powerList.add(baseInfo.getData().getList().get(i));
                }
                superRecyclerViewAdapter2.notifyDataSetChanged();
                srv.completeLoadMore();
            }
        }

        super.onNext(resulte, method);
    }

    @Override
    public void onError(ApiException e, String method) {
        if(method.equals(CommonPowerList.GET_STSATIONLIST)){
            if(isFirstIntoFragment2){
                isFirstIntoFragment2=false;
            }
            if(isRefresh){
                srv.completeRefresh();
            }else{
                if(page>2){
                    page--;
                }
                srv.completeLoadMore();
            }
        }
        super.onError(e, method);
    }

    @Override
    public void onDestroyView() {
        CommonPowerList.substationInfoArrayList=powerList;
        super.onDestroyView();
    }
}

class SuperRecyclerViewAdapter2 extends SuperBaseAdapter<SubstationInfo> {
    private FragmentManager fragmentManager;
    private Context context;
    public SuperRecyclerViewAdapter2(Context context) {

        super(context);
    }

    public SuperRecyclerViewAdapter2(Context context, ArrayList<SubstationInfo> data,FragmentManager fragmentManager) {
        super(context, data);
        this.context=context;
        this.fragmentManager=fragmentManager;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    @Override
    protected void convert( BaseViewHolder holder, final SubstationInfo item, int position) {
        holder.setText(R.id.tv_recycler_item2_name, item.getBiandianzhanmingcheng());
        holder.setText(R.id.tv_recycler_item2_name2, item.getXianlumingcheng());
        if(item.getPowerSataus().equalsIgnoreCase("01")){
            holder.setText(R.id.tv_recycler_item2_staus2, context.getString(R.string.zaiyun));
            holder.setBackgroundColor(R.id.tv_recycler_item2_staus2, Color.parseColor("#99cc33"));
        }else{
            holder.setText(R.id.tv_recycler_item2_staus2, context.getString(R.string.tingyun));
            holder.setBackgroundColor(R.id.tv_recycler_item2_staus2, Color.parseColor("#FF0000"));
        }

         if(item.getPowerSatausInfo()==0){
            holder.setText(R.id.tv_recycler_item2_staus1, context.getString(R.string.yichang));
            holder.setBackgroundColor(R.id.tv_recycler_item2_staus1, Color.parseColor("#FF0000"));
        }else if(item.getPowerSatausInfo()==1){
            holder.setText(R.id.tv_recycler_item2_staus1, context.getString(R.string.zhengchang));
            holder.setBackgroundColor(R.id.tv_recycler_item2_staus1, Color.parseColor("#99cc33"));
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