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
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FragmentFactory;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpMessageEntity.BaseResultEntity;
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
/**
 * Created by a1111 on 17/9/28.
 */

public class FragmentItem1 extends BaseRxFragment {
    public static final String TAG="FragmentItem1";
    private View view;
    private SuperRecyclerView rcv;
    private List<Power> powerList= new ArrayList<Power>();;
    private SuperRecyclerViewAdapter srva;
    private  String[] ss;
    private boolean isUp=true;
    private Spinner spinner;
    private ArrayAdapter<String> spinnerAdapter;
    private int searchPage=0;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        FeagmentActivity.Num=0;
        setButton();
        ss= new String[]{getString(R.string.tianjin),getString(R.string.wuqing),getString(R.string.baodi),getString(R.string.binhai),getString(R.string.chengdong),
                getString(R.string.chengxi),getString(R.string.jianxiu)};
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
        rcv.setLoadMoreEnabled(true);//可以定制是否开启加载更多
        rcv.setLoadingListener(new SuperRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Handler  handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        reFreash(isUp);
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
                        rcv.completeLoadMore();
                        super.handleMessage(msg);
                    }
                };
            }
        });//下拉刷新，上拉加载的监听
        rcv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//下拉刷新的样式
        rcv.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);//上拉加载的样式
        rcv.setArrowImageView(R.mipmap.ic_pulltorefresh_arrow);//设置下拉箭头
        rcv.setAdapter(srva);
        dada();
        return view;
    }
    public void dada(){
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject1 = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();

        jsonObject.addProperty("Result","100");
        jsonObject.addProperty("ResultMsg","100");

        JsonArray jsonArray = new JsonArray();
        jsonObject1.addProperty("areaName","天津");
        jsonObject1.addProperty("areaNumber","12");
        jsonObject1.addProperty("completeRate","99");
        jsonObject1.addProperty("onlineRate1","99");
        jsonObject1.addProperty("onlineRate2","89");
        jsonObject2.addProperty("areaName","城东");
        jsonObject2.addProperty("areaNumber","12");
        jsonObject2.addProperty("completeRate","99");
        jsonObject2.addProperty("onlineRate1","99");
        jsonObject2.addProperty("onlineRate2","89");
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        jsonObject.add("ReturnValue",jsonArray);
 //       Log.e(TAG,""+jsonObject.toString());
        Gson gson = new Gson();
        Type type = new TypeToken<BaseResultEntity<List<AreaTotal>>>(){}.getType();
        BaseResultEntity<List<AreaTotal>> baseInfo=gson.fromJson(jsonObject,type);
        for(int i=0;i<baseInfo.getData().size();i++){
            Log.e(TAG,""+baseInfo.getData().get(i).getName());
        }






    }
    public void initData(boolean isUp){
        powerList.clear();
        Random random = new Random(100);
        for(int i =0;i< ss.length;i++){
            Power power = new Power();
            power.setName(ss[i]);
            power.setDuanshizhongduan(getString(R.string.duanshizhongduan)+":"+String.valueOf(random.nextInt(10)));
            power.setZanjiangdianya(getString(R.string.dianyazanjiang)+":"+String.valueOf(random.nextInt(10)));
            power.setZanshengdianya(getString(R.string.dianyazansheng)+":"+String.valueOf(random.nextInt(10)));
            power.setNum(random.nextInt(100));
            powerList.add(power);
        }
        CollectionsList(powerList,isUp);
    }
    public void reFreash(boolean isUp){
        powerList.clear();
        Random random = new Random(new Random().nextInt(10));
        for(int i =0;i< ss.length;i++){
            Power power = new Power();
            power.setName(ss[i]);
            power.setDuanshizhongduan(getString(R.string.duanshizhongduan)+":"+String.valueOf(random.nextInt(10)));
            power.setZanjiangdianya(getString(R.string.dianyazanjiang)+":"+String.valueOf(random.nextInt(10)));
            power.setZanshengdianya(getString(R.string.dianyazansheng)+":"+String.valueOf(random.nextInt(10)));
            power.setNum(random.nextInt(100));
            powerList.add(power);
        }
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
        if(method.equals(CommonPowerList.GET_LONGIN)){




        }
        super.onNext(resulte, method);
    }

    @Override
    public void onError(ApiException e, String method) {
        super.onError(e, method);
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
    protected void convert(final BaseViewHolder holder, Power item, int position) {
        holder.setText(R.id.tv_recycler_name,item.getName());
        holder.setText(R.id.tv_recycler_item1,item.getZanjiangdianya());
        holder.setText(R.id.tv_recycler_item2,item.getZanshengdianya());
        holder.setText(R.id.tv_recycler_item3,item.getDuanshizhongduan());
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
        holder.getView(R.id.ll_recyclerview_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
