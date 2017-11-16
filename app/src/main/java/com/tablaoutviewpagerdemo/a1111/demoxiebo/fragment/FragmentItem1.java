package com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import superlibrary.adapter.BaseViewHolder;
import superlibrary.adapter.SuperBaseAdapter;
import superlibrary.recycleview.ProgressStyle;
import superlibrary.recycleview.SuperRecyclerView;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.GetDateMethod.GetDateMethod;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FragmentFactory;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpMessageEntity.BaseResultEntity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.HttpPowerApi;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.PowerResultEntity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.AreaTotal;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.Power;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.R;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity.setButton;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.FragmentFactory.getFragmentInstance;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList.powerArrayList;

/**
 * Created by a1111 on 17/9/28.
 */

public class FragmentItem1 extends BaseRxFragment {
    public static final String TAG="FragmentItem1";
    private View view;
    private SuperRecyclerView rcv;
    private ArrayList<Power> powerList= new ArrayList<Power>();;
    private SuperRecyclerViewAdapter srva;
    private boolean isUp=true;
    private Spinner spinner;
    private ArrayAdapter<String> spinnerAdapter;
    private HttpPowerApi httpPowerApi;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        Log.e(TAG,"init---------"+TAG);
        FeagmentActivity.Num=0;
        setButton();
        httpPowerApi=new HttpPowerApi(this,this);
         if(powerArrayList.size()>0){
             powerList= powerArrayList;
         }
        view=inflater.inflate(R.layout.fragment_item1,container,false);
        rcv = view.findViewById(R.id.rcv);
        initData(isUp);
        spinner=view.findViewById(R.id.sp_item1);
        String[] list = getContext().getResources().getStringArray(R.array.spingarr);
        //适配器
        spinnerAdapter=new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_spinner_item,list);
        //设置样式
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器;
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    if(!isUp){
                        isUp=true;
                        reFreash(isUp);
                    }
                }else{
                    if(isUp){
                        isUp=false;
                        reFreash(isUp);
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        srva=new SuperRecyclerViewAdapter(this.getContext(),powerList,this.getFragmentManager());
        rcv.setLayoutManager(layoutManager);
        rcv.setRefreshEnabled(true);//可以定制是否开启下拉刷新
        rcv.setLoadMoreEnabled(false);//可以定制是否开启加载更多
        rcv.setLoadingListener(new SuperRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                httpPowerApi.getTransientStatePowerList(true,CommonPowerList.GET_TRANSIENTSTATEPOWERLIST,CommonPowerList.BUSI_ZT,CommonPowerList.sercetKey, GetDateMethod.getCurrentDate()+" 00:00:00",GetDateMethod.getBeforHour());
            }

            @Override
            public void onLoadMore() {

            }
        });//下拉刷新，上拉加载的监听
        rcv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//下拉刷新的样式
        rcv.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);//上拉加载的样式
        rcv.setArrowImageView(R.mipmap.ic_pulltorefresh_arrow);//设置下拉箭头
        rcv.setAdapter(srva);

        return view;
    }

    public void initData(boolean isUp){
        CollectionsList(powerList,isUp);
    }
    public void reFreash(boolean isUp){
        CollectionsList(powerList,isUp);
        srva.notifyDataSetChanged();
        rcv.completeRefresh();
    }
    private void CollectionsList(List<Power> powerList, boolean isUp){
        if(isUp){
            Collections.sort(powerList,new Comparator(){
                @Override
                public int compare(Object o1, Object o2) {
                    Power item1=(Power)o1;
                    Power item2=(Power)o2;
                    if(item1.getNum()>item2.getNum()){
                        return 1;
                    }else if(item1.getNum()==item2.getNum()){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            });
        }else{
            Collections.sort(powerList,new Comparator(){
                @Override
                public int compare(Object o1, Object o2) {
                    Power item1=(Power)o1;
                    Power item2=(Power)o2;
                    if(item1.getNum()<item2.getNum()){
                        return 1;
                    }else if(item1.getNum()==item2.getNum()){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            });
        }
    }

    @Override
    public void onNext(String resulte, String method) {
        powerArrayList.clear();
        if(method.equals(CommonPowerList.GET_TRANSIENTSTATEPOWERLIST)){
            Gson gson = new Gson();
            Type type = new TypeToken<PowerResultEntity<List<Power>>>(){}.getType();
            PowerResultEntity<List<Power>> baseInfo=gson.fromJson(resulte,type);
            for(int i=0;i<baseInfo.getData().size();i++) {
                powerArrayList.add(baseInfo.getData().get(i));
            }
            reFreash(isUp);
        }
        super.onNext(resulte, method);
    }

    @Override
    public void onError(ApiException e, String method) {
        super.onError(e, method);
    }

    @Override
    public void onDestroyView() {
        CommonPowerList.powerArrayList=this.powerList;
        super.onDestroyView();
    }
}
class SuperRecyclerViewAdapter extends SuperBaseAdapter<Power>{
    public boolean isClick=false;

    public FragmentManager fragmentManager;
    public SuperRecyclerViewAdapter(Context context) {
        super(context);
    }

    public SuperRecyclerViewAdapter(Context context, List<Power> data) {
        super(context, data);
    }
    public SuperRecyclerViewAdapter(Context context, List<Power> data, FragmentManager fragmentManager) {
        super(context, data);
        this.fragmentManager=fragmentManager;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final Power item, int position) {
        holder.setText(R.id.tv_recycler_name,item.getName());
        holder.setText(R.id.tv_recycler_item1,"电压暂降："+item.getZanjiangdianya());
        holder.setText(R.id.tv_recycler_item2,"电压暂升："+item.getZanshengdianya());
        holder.setText(R.id.tv_recycler_item3,"短时中断："+item.getDuanshizhongduan());
        holder.setText(R.id.tv_recycler_item_num,item.getNum()+"");
        holder.setTag(R.id.rl_recyclerview,"false");
        holder.getView(R.id.bt_recycler_name).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.getView(R.id.rl_recyclerview).getTag().equals("true")){
                    holder.setTag(R.id.rl_recyclerview,"false");
                    holder.getView(R.id.rl_recyclerview).setVisibility(View.GONE);
                }else{
                    holder.setTag(R.id.rl_recyclerview,"true");
                    holder.getView(R.id.rl_recyclerview).setVisibility(View.VISIBLE);

                }
            }
        });

        holder.getView(R.id.tv_recycler_item1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentItem1Info.key="ZJ";
                FragmentItem1Info.gdName=item.getGdName();
                FragmentFactory.getFragmentInstance(fragmentManager,FragmentItem1Info.TAG);
            }
        });
        holder.getView(R.id.tv_recycler_item2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentItem1Info.key="ZS";
                FragmentItem1Info.gdName=item.getGdName();
                FragmentFactory.getFragmentInstance(fragmentManager,FragmentItem1Info.TAG);
            }
        });
        holder.getView(R.id.tv_recycler_item3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentItem1Info.key="ZD";
                FragmentItem1Info.gdName=item.getGdName();
                FragmentFactory.getFragmentInstance(fragmentManager,FragmentItem1Info.TAG);
            }
        });

    }
    @Override
    protected int getItemViewLayoutId(int position, Power item) {
        return R.layout.recycler_item;
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {

        super.setOnItemClickListener(onItemClickListener);
    }
}
