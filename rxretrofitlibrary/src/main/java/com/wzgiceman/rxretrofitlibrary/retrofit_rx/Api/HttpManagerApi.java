package com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle.components.support.RxFragment;
import com.trello.rxlifecycle.components.support.RxFragmentActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextSubListener;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * 请求数据统一封装类
 * Created by WZG on 2016/7/16.
 */
public class HttpManagerApi extends BaseApi {
    private HttpManager manager;

    public HttpManagerApi(HttpOnNextListener onNextListener, RxAppCompatActivity appCompatActivity) {
        manager = new HttpManager(onNextListener, appCompatActivity);
    }

    public HttpManagerApi(HttpOnNextSubListener onNextSubListener, RxAppCompatActivity appCompatActivity) {
        manager = new HttpManager(onNextSubListener, appCompatActivity);
    }
    public HttpManagerApi(HttpOnNextListener onNextListener, RxFragmentActivity fragmentActivity) {
        manager = new HttpManager(onNextListener, fragmentActivity);
    }

    public HttpManagerApi(HttpOnNextSubListener onNextSubListener, RxFragmentActivity fragmentActivity) {
        manager = new HttpManager(onNextSubListener, fragmentActivity);
    }
    public HttpManagerApi(HttpOnNextListener onNextListener, RxFragment fragment) {
        manager = new HttpManager(onNextListener, fragment);
    }

    public HttpManagerApi(HttpOnNextSubListener onNextSubListener, RxFragment fragment) {
        manager = new HttpManager(onNextSubListener, fragment);
    }
    protected Retrofit getRetrofit() {
        return  manager.getReTrofit(getConnectionTime(), getBaseUrl());
    }


    protected void doHttpDeal(Observable observable,boolean setShowprogess) {
        this.setShowProgress(false);
        manager.httpDeal(observable, this);
    }
    protected void doHttpDealForFragmentActivity(Observable observable) {
        manager.httpDealForFragmentActivity(observable, this);
    }
    protected void doHttpDealForFragment(Observable observable) {

        manager.httpDealForFragment(observable, this);
    }
    @Override
    public Observable getObservable(Retrofit retrofit) {
        return null;
    }
}
