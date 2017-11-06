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

import com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.FragmentFactory;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.AreaTotal;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.Power;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import superlibrary.adapter.BaseViewHolder;
import superlibrary.adapter.SuperBaseAdapter;
import superlibrary.recycleview.ProgressStyle;
import superlibrary.recycleview.SuperRecyclerView;
import java.text.DecimalFormat;

import static com.tablaoutviewpagerdemo.a1111.demoxiebo.FeagmentActivity.setButton;

/**
 * Created by a1111 on 17/9/30.
 */

public class FragmentItem4 extends BaseRxFragment {
    public static String TAG="FragmentItem4";
    private View view;
    private SuperRecyclerView rcv;
    private List<AreaTotal> list= new ArrayList<AreaTotal>();
    private SuperRecyclerViewAdapter srva;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        FeagmentActivity.Num=0;
        setButton();
        view =inflater.inflate(R.layout.fragment_item4,container,false);
        rcv = view.findViewById(R.id.srv_item4);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        initData();
        srva=new SuperRecyclerViewAdapter(this.getContext(),list,this.getFragmentManager());
        rcv.setLayoutManager(layoutManager);
        rcv.setAdapter(srva);
        rcv.setRefreshEnabled(true);//可以定制是否开启下拉刷新
        rcv.setLoadMoreEnabled(false);//可以定制是否开启加载更多
        rcv.setLoadingListener(new SuperRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        reFreshData();
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


        return view;
    }
    private void initData(){
        list.clear();
        String[] ss= new String[]{getString(R.string.tianjin),getString(R.string.wuqing),getString(R.string.baodi),getString(R.string.binhai),getString(R.string.chengdong),
        getString(R.string.chengxi),getString(R.string.jianxiu)};
        Random random = new Random(100);

        for(int i=0;i<ss.length;i++){
            AreaTotal areaTotal = new AreaTotal();
            areaTotal.setName(ss[i]);
            areaTotal.setNum(random.nextInt(100));
            areaTotal.setOnline1(random.nextFloat()*100);
            areaTotal.setOnline2(random.nextFloat()*100);
            areaTotal.setIntegrity(random.nextFloat()*100);
            list.add(areaTotal);
        }
    }
    private void reFreshData(){
        list.clear();
        String[] ss= new String[]{getString(R.string.tianjin),getString(R.string.wuqing),getString(R.string.baodi),getString(R.string.binhai),getString(R.string.chengdong),
                getString(R.string.chengxi),getString(R.string.jianxiu)};


        Random random = new Random(new Random().nextInt(100));
        for(int i=0;i<ss.length;i++){
            AreaTotal areaTotal = new AreaTotal();
            areaTotal.setName(ss[i]);
            areaTotal.setNum(random.nextInt(100));
            areaTotal.setOnline1(random.nextFloat()*100);
            areaTotal.setOnline2(random.nextFloat()*100);
            areaTotal.setIntegrity(random.nextFloat()*100);
            list.add(areaTotal);
        }
        srva.notifyDataSetChanged();
        rcv.invalidate();
        rcv.completeRefresh();
    }
    class SuperRecyclerViewAdapter extends SuperBaseAdapter<AreaTotal>{
        public boolean isClick=false;

        public FragmentManager fragmentManager;
        public Context context;
        public SuperRecyclerViewAdapter(Context context) {
            super(context);
        }

        public SuperRecyclerViewAdapter(Context context, List<AreaTotal> data) {

            super(context, data);
        }
        public SuperRecyclerViewAdapter(Context context, List<AreaTotal> data, FragmentManager fragmentManager) {
            super(context, data);
            this.fragmentManager=fragmentManager;
            this.context=context;
        }


        @Override
        protected void convert(final BaseViewHolder holder, AreaTotal item, int position) {
            DecimalFormat   fnum  =   new  DecimalFormat("##0.00");
            holder.setText(R.id.tv_recycler_item4_name,item.getName());
            holder.setText(R.id.tv_recycler_item4_num,""+item.getNum());
            holder.setText(R.id.tv_recycler_item4_1,context.getString(R.string.wanzhenglv)+":"+fnum.format(item.getIntegrity())+"%");
            holder.setText(R.id.tv_recycler_item4_2,context.getString(R.string.zaixianlv_one)+":"+fnum.format(item.getOnline1())+"%");
            holder.setText(R.id.tv_recycler_item4_3,context.getString(R.string.zaixianlv_two)+":"+fnum.format(item.getOnline2())+"%");
            holder.setTag(R.id.tv_recycler_item4_name,"false");
            holder.getView(R.id.bt_recycler_item4_name).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(holder.getView(R.id.tv_recycler_item4_name).getTag().equals("true")){
                        holder.setTag(R.id.tv_recycler_item4_name,"false");
                        holder.getView(R.id.ll_recyclerview_item4).setVisibility(View.GONE);
                    }else{
                        holder.setTag(R.id.tv_recycler_item4_name,"true");
                        holder.getView(R.id.ll_recyclerview_item4).setVisibility(View.VISIBLE);

                    }
                }
            });


        }
        @Override
        protected int getItemViewLayoutId(int position, AreaTotal item) {
            return R.layout.recycler_item4;
        }


    }
}
