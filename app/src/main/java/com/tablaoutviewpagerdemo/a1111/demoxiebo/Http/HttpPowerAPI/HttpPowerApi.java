package com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.PowerService.HttpPowerService;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle.components.support.RxFragment;
import com.trello.rxlifecycle.components.support.RxFragmentActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.HttpManagerApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextSubListener;

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
    public void getLogin(boolean isFragment,String methodName,final String name,final String password) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getLogin(name, password));
        }else {
            doHttpDeal(httpService.getLogin(name, password));
        }
    }
    public void getStationList(boolean isFragment,String methodName,final String secretKey,final String stationName) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getStationList(secretKey,stationName));
        }else {
            doHttpDeal(httpService.getStationList(secretKey,stationName));
        }
    }
    public void getPowerList(boolean isFragment,String methodName,final String secretKey) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getPowerList(secretKey));
        }else {
            doHttpDeal(httpService.getPowerList(secretKey));
        }
    }
    public void getSteadyStatePowerList(boolean isFragment,String methodName,final String secretKey,final String Ts) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getSteadyStatePowerList(secretKey,Ts));
        }else {
            doHttpDeal(httpService.getSteadyStatePowerList(secretKey,Ts));
        }
    }
    public void getSteadyStatePowerList(boolean isFragment,String methodName,final String secretKey,final String stationName,int page,String type) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getSteadyStateInfoList(secretKey,stationName,page,type));
        }else {
            doHttpDeal(httpService.getSteadyStateInfoList(secretKey,stationName,page,type));
        }
    }
    public void getTransientStatePowerList(boolean isFragment,String methodName,final String secretKey,final String Ts) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getTransientStatePowerList(secretKey,Ts));
        }else {
            doHttpDeal(httpService.getTransientStatePowerList(secretKey,Ts));
        }
    }
    public void getTransientStateInfoList(boolean isFragment,String methodName,final String secretKey,final String stationName,int page,String type) {
        /*也可单独设置请求，会覆盖统一设置*/
        setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if(isFragment){
            doHttpDealForFragment(httpService.getTransientStateInfoList(secretKey,stationName,page,type));
        }else {
            doHttpDeal(httpService.getTransientStateInfoList(secretKey,stationName,page,type));
        }
    }
}
