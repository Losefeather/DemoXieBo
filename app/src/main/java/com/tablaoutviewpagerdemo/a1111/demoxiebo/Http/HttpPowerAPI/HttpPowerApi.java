package com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.PowerService.HttpPowerService;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle.components.support.RxFragment;
import com.trello.rxlifecycle.components.support.RxFragmentActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.HttpManagerApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextSubListener;

import static android.R.attr.name;
import static android.R.attr.type;

/**
 * Created by a1111 on 17/10/31.
 */

public class HttpPowerApi extends HttpManagerApi {
    public HttpPowerApi(HttpOnNextListener onNextListener, RxAppCompatActivity appCompatActivity) {
        super(onNextListener, appCompatActivity);
        setCache(true);
    }

    public HttpPowerApi(HttpOnNextSubListener onNextSubListener, RxAppCompatActivity appCompatActivity) {
        super(onNextSubListener, appCompatActivity);
        setCache(true);
    }

    public HttpPowerApi(HttpOnNextListener onNextListener, RxFragmentActivity fragmentActivity) {
        super(onNextListener, fragmentActivity);
        setCache(true);
    }

    public HttpPowerApi(HttpOnNextSubListener onNextSubListener, RxFragmentActivity fragmentActivity) {
        super(onNextSubListener, fragmentActivity);
        setCache(true);
    }

    public HttpPowerApi(HttpOnNextListener onNextListener, RxFragment fragment) {
        super(onNextListener, fragment);
        setCache(true);
    }

    public HttpPowerApi(HttpOnNextSubListener onNextSubListener, RxFragment fragment) {
        super(onNextSubListener, fragment);
        setCache(true);
    }

    /**
     * post请求演示
     * api-1
     *
     * @param
     */
    public void getLogin(boolean isFragment,String methodName,final String busiName,final String name,final String password) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getLogin(busiName,name, password));
        }else {
            doHttpDeal(httpService.getLogin(busiName,name, password));
        }
    }

    public void getStationList(boolean isFragment,String methodName,final String busiName,final String secretKey,final String stationId,final String stationName,final int page,final int count) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getStationList(busiName,secretKey,stationId,stationName,page,count));
        }else {
            doHttpDeal(httpService.getStationList(busiName,secretKey,stationId,stationName,page,count));
        }
    }
    public void getPowerList(boolean isFragment,String methodName,final String busiName,final String secretKey,final String starttime,final String endtime) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getPowerList(busiName,secretKey,starttime,endtime));
        }else {
            doHttpDeal(httpService.getPowerList(busiName,secretKey,starttime,endtime));
        }
    }
    public void getSteadyStatePowerList(boolean isFragment,String methodName,final String busiName,final String secretKey,final String starttime,final String endtime) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getSteadyStatePowerList(busiName,secretKey,starttime,endtime));
        }else {
            doHttpDeal(httpService.getSteadyStatePowerList(busiName,secretKey,starttime,endtime));
        }
    }
    public void getSteadyStateInfoList(boolean isFragment,String methodName,final String busiName,final String secretKey,final String stationName,final int page,final int conut ,final String type,final String startTime,final  String endTime) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getSteadyStateInfoList(busiName,secretKey,stationName,page,conut,type,startTime,endTime));
        }else {
            doHttpDeal(httpService.getSteadyStateInfoList(busiName,secretKey,stationName,page,conut,type,startTime,endTime));
        }
    }
    public void getTransientStatePowerList(boolean isFragment,String methodName,final String busiName,final String secretKey,final String Ts) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getTransientStatePowerList(busiName,secretKey,Ts));
        }else {
            doHttpDeal(httpService.getTransientStatePowerList(busiName,secretKey,Ts));
        }
    }
    public void getTransientStateInfoList(boolean isFragment,String methodName,final String busiName,final String secretKey,final String stationName,int page,String type) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getTransientStateInfoList(busiName,secretKey,stationName,page,type));
        }else {
            doHttpDeal(httpService.getTransientStateInfoList(busiName,secretKey,stationName,page,type));
        }
    }
    public void getStationIdList(boolean isFragment,String methodName,final String busiName,final String secretKey) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getStationIdList(busiName,secretKey));
        }else {
            doHttpDeal(httpService.getStationIdList(busiName,secretKey));
        }
    }
}
