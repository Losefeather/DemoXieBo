package com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.SearchView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.FuzzyQuery.SearchAdapter;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.GetDateMethod.GetDateMethod;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.MD5.SecretUtils;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FragmentFactory;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.HttpPageCount;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.HttpPowerApi;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.PowerResultEntity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.Power;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.PowerMonitorId;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.SteadyStateAlarm;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.SubstationInfo;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.R;
import com.trello.rxlifecycle.components.support.RxFragment;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import superlibrary.adapter.BaseViewHolder;
import superlibrary.adapter.SuperBaseAdapter;
import superlibrary.recycleview.ProgressStyle;
import superlibrary.recycleview.SuperRecyclerView;

import static android.R.attr.id;
import static android.R.attr.name;
import static android.R.attr.onClick;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity.setButton;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList.powerMonitorIdArrayList;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.R.id.rcv;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.R.string.ct;

/**
 * Created by a1111 on 17/10/10.
 */

public class FragmentItem3Info extends BaseRxFragment {
    public static String TAG = "FragmentItem3Info";
    private View view;
    private SuperRecyclerView srv;
    private SuperRecyclerViewZAdapter srva;
    private ArrayList<SteadyStateAlarm> list = new ArrayList<SteadyStateAlarm>();
    private AutoCompleteTextView search;
    private SearchAdapter searchAdapter;
    private ImageView imageView;
    public static String type;
    private int totalPage=100;
    private int page =1;
    private int count=5;
    private HttpPowerApi httpPowerApi=new HttpPowerApi(this,this);;
    private boolean isRefresh=false;
    private String[] str = {""};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"init---------"+TAG);
        FeagmentActivity.Num=3;
        setButton();
        view=inflater.inflate(R.layout.fragment_item3_info,container,false);
        srv=view.findViewById(R.id.srv_item3);
        srva=new SuperRecyclerViewZAdapter(this.getContext(),list,this.getFragmentManager());
        search=view.findViewById(R.id.actv_itenm3_search);
        imageView=view.findViewById(R.id.iv_item3_search);
        doWithStation(page);
        searchAdapter=new SearchAdapter(getContext(), android.R.layout.simple_list_item_1,inloadngString(),SearchAdapter.ALL);
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
        srv.setAdapter(srva);

        return view;
    }
    private String[] inloadngString(){
        List<String> stringArrayList = new ArrayList<String>();
        if (powerMonitorIdArrayList.size() > 0) {
            for(int i = 0; i< powerMonitorIdArrayList.size(); i++) {
                stringArrayList.add(powerMonitorIdArrayList.get(i).getPowerMonitorName());
            }
            return stringArrayList.toArray(str);
        }else{
            return stringArrayList.toArray(str);
        }
    }
    private void  doWithStation(int page){
        String stationName="";
        if(!search.getText().toString().equals("")){
            stationName=getStationName(search.getText().toString());
        }
        Log.e(TAG,"stationName:"+stationName);
       // httpPowerApi.getSteadyStateInfoList(CommonPowerList.isFragment, CommonPowerList.GET_STEADYSTATEINFOLIST,CommonPowerList.BUSI_WTGJXQ,CommonPowerList.sercetKey,stationName,page,count,type, GetDateMethod.getCurrentDate()+" 00:00:00",GetDateMethod.getBeforHour());
        httpPowerApi.getObj(CommonPowerList.isFragment, CommonPowerList.GET_STEADYSTATEINFOLIST, SecretUtils.encrypt(httpPowerApi.getSteadyStateInfoList(CommonPowerList.BUSI_WTGJXQ,stationName,page,count,type, GetDateMethod.getCurrentDate()+" 00:00:00",GetDateMethod.getBeforHour())));
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
        if (method.equals(CommonPowerList.GET_STEADYSTATEINFOLIST)) {
            if(isRefresh){
                Log.e(TAG,"onNextup");
                list.clear();
                Gson gson = new Gson();
                Type type = new TypeToken<PowerResultEntity<HttpPageCount<SteadyStateAlarm>>>(){}.getType();
                PowerResultEntity<HttpPageCount<SteadyStateAlarm>> baseInfo=gson.fromJson(resulte,type);
                for(int i=0;i<baseInfo.getData().getList().size();i++) {
                    list.add(baseInfo.getData().getList().get(i));
                }
                srva.notifyDataSetChanged();
                srv.completeRefresh();
            }else{
                Log.e(TAG,"onNextdown");
                Gson gson = new Gson();
                Type type = new TypeToken<PowerResultEntity<HttpPageCount<SteadyStateAlarm>>>(){}.getType();
                PowerResultEntity<HttpPageCount<SteadyStateAlarm>> baseInfo=gson.fromJson(resulte,type);
                for(int i=0;i<baseInfo.getData().getList().size();i++) {
                    list.add(baseInfo.getData().getList().get(i));
                }
                srva.notifyDataSetChanged();
                srv.completeLoadMore();
            }
        }
        super.onNext(resulte, method);
    }

    @Override
    public void onError(ApiException e, String method) {
        Log.e(TAG,"method:"+method);
        Log.e(TAG,"ApiException:"+e.toString());
        if(isRefresh){
            srv.completeRefresh();
        }else{
            if(page>2){
                page--;
            }
            srv.completeLoadMore();
        }
        super.onError(e, method);
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