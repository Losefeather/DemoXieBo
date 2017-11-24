package com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.HttpPowerApi;
import com.trello.rxlifecycle.components.support.RxFragment;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

/**
 * Created by a1111 on 17/10/27.
 */

public class BaseRxFragment extends RxFragment implements HttpOnNextListener{

    @Override
    public void onNext(String resulte, String method) {

    }

    @Override
    public void onError(ApiException e, String method) {

    }
}
