package com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI;

import android.util.Log;

import com.google.gson.JsonObject;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.GetPhoneMac.GetPhoneMac;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.MD5.MD5;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.MD5.SecretUtils;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.PowerService.HttpPowerService;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle.components.support.RxFragment;
import com.trello.rxlifecycle.components.support.RxFragmentActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.HttpManagerApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextSubListener;

import java.util.List;

import retrofit2.http.Field;
import rx.Observable;

import static android.R.attr.name;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList.isFragment;
import static com.tablaoutviewpagerdemo.a1111.demoxiebo.fragment.FragmentUserInfo.TAG;


/**
 * Created by a1111 on 17/10/31.
 */

public class HttpPowerApi extends HttpManagerApi {
    public String TAG = "HttpPowerApi";

    public HttpPowerApi(HttpOnNextListener onNextListener, RxAppCompatActivity appCompatActivity) {
        super(onNextListener, appCompatActivity);
        //   setCache(true);
    }

    public HttpPowerApi(HttpOnNextSubListener onNextSubListener, RxAppCompatActivity appCompatActivity) {
        super(onNextSubListener, appCompatActivity);
        //    setCache(true);
    }

    public HttpPowerApi(HttpOnNextListener onNextListener, RxFragmentActivity fragmentActivity) {
        super(onNextListener, fragmentActivity);
        //    setCache(true);
    }

    public HttpPowerApi(HttpOnNextSubListener onNextSubListener, RxFragmentActivity fragmentActivity) {
        super(onNextSubListener, fragmentActivity);
        //     setCache(true);
    }

    public HttpPowerApi(HttpOnNextListener onNextListener, RxFragment fragment) {
        super(onNextListener, fragment);
        //    setCache(true);
    }

    public HttpPowerApi(HttpOnNextSubListener onNextSubListener, RxFragment fragment) {
        super(onNextSubListener, fragment);
        // setCache(true);
    }

    public HttpPowerApi(HttpOnNextSubListener onNextSubListener) {
        super(onNextSubListener);
        // setCache(true);
    }

    public HttpPowerApi(HttpOnNextListener onNextListener) {
        super(onNextListener);
        // setCache(true);
    }

    /**
     * post请求演示
     * api-1
     *
     * @param
     */
    public void getLogin(int isFragment, String methodName, final String busiName, final String name, final String password) {
        /*也可单独设置请求，会覆盖统一设置*/
        //setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);

        if (isFragment == 0) {
            doHttpDealForFragment(httpService.getLogin(busiName, name, password, SecretUtils.getToken()));
        } else if (isFragment == 1) {
            doHttpDeal(httpService.getLogin(busiName, name, password, SecretUtils.getToken()), false);
        } else {
            doHttpDealForBackground(httpService.getLogin(busiName, name, password, SecretUtils.getToken()));
        }
        Log.e(TAG, "" + httpService.getLogin(busiName, name, password, SecretUtils.getToken()).toString());

    }

    public void getStationList(int isFragment, String methodName, final String busiName, final String secretKey, final String stationId, final String stationName, final int page, final int count) {
        /*也可单独设置请求，会覆盖统一设置*/
        //setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if (isFragment == 0) {
            doHttpDealForFragment(httpService.getStationList(busiName, SecretUtils.getToken(), stationId, stationName, page, count));
        } else if (isFragment == 1) {
            doHttpDeal(httpService.getStationList(busiName, SecretUtils.getToken(), stationId, stationName, page, count), true);
        } else {
            doHttpDealForBackground(httpService.getStationList(busiName, SecretUtils.getToken(), stationId, stationName, page, count));
        }
    }

    public void getPowerList(int isFragment, String methodName, final String busiName, final String secretKey, final String starttime, final String endtime) {
        /*也可单独设置请求，会覆盖统一设置*/
        //setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);

        if (isFragment == 0) {
            doHttpDealForFragment(httpService.getPowerList(busiName, SecretUtils.getToken(), starttime, endtime));
        } else if (isFragment == 1) {
            doHttpDeal(httpService.getPowerList(busiName, SecretUtils.getToken(), starttime, endtime), true);
        } else {
            doHttpDealForBackground(httpService.getPowerList(busiName, SecretUtils.getToken(), starttime, endtime));
        }
    }

    public void getSteadyStatePowerList(int isFragment, String methodName, final String busiName, final String secretKey, final String starttime, final String endtime) {
        /*也可单独设置请求，会覆盖统一设置*/
        //setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if (isFragment == 0) {
            doHttpDealForFragment(httpService.getSteadyStatePowerList(busiName, SecretUtils.getToken(), starttime, endtime));
        } else if (isFragment == 1) {
            doHttpDeal(httpService.getSteadyStatePowerList(busiName, SecretUtils.getToken(), starttime, endtime), true);
        } else {
            doHttpDealForBackground(httpService.getSteadyStatePowerList(busiName, SecretUtils.getToken(), starttime, endtime));
        }
    }

    public void getSteadyStateInfoList(int isFragment, String methodName, final String busiName, final String secretKey, final String stationName, final int page, final int conut, final String type, final String startTime, final String endTime) {
        /*也可单独设置请求，会覆盖统一设置*/
        //setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if (isFragment == 0) {
            doHttpDealForFragment(httpService.getSteadyStateInfoList(busiName, SecretUtils.getToken(), stationName, page, conut, type, startTime, endTime));
        } else if (isFragment == 1) {
            doHttpDeal(httpService.getSteadyStateInfoList(busiName, SecretUtils.getToken(), stationName, page, conut, type, startTime, endTime), true);
        } else {
            doHttpDealForBackground(httpService.getSteadyStateInfoList(busiName, SecretUtils.getToken(), stationName, page, conut, type, startTime, endTime));
        }
    }

    public void getTransientStatePowerList(int isFragment, String methodName, final String busiName, final String secretKey, final String st, final String et) {
        /*也可单独设置请求，会覆盖统一设置*/
        //setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if (isFragment == 0) {
            doHttpDealForFragment(httpService.getTransientStatePowerList((busiName), SecretUtils.getToken(), (st), (et)));
        } else if (isFragment == 1) {
            doHttpDeal(httpService.getTransientStatePowerList((busiName), SecretUtils.getToken(), (st), (et)), true);
        } else {
            doHttpDealForBackground(httpService.getTransientStatePowerList((busiName), SecretUtils.getToken(), (st), (et)));
        }
    }

    public void getTransientStateInfoList(int isFragment, String methodName, final String busiName, final String secretKey, final String stationName, final String gdName, int page, final int count, String type, String startTime, String endTime) {
        /*也可单独设置请求，会覆盖统一设置*/
        //setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if (isFragment == 0) {
            doHttpDealForFragment(httpService.getTransientStateInfoList(busiName, SecretUtils.getToken(), stationName, gdName, page, count, type, startTime, endTime));
        } else if (isFragment == 1) {
            doHttpDeal(httpService.getTransientStateInfoList(busiName, SecretUtils.getToken(), stationName, gdName, page, count, type, startTime, endTime), true);
        } else {
            doHttpDealForBackground(httpService.getTransientStateInfoList(busiName, SecretUtils.getToken(), stationName, gdName, page, count, type, startTime, endTime));
        }
    }

    public void getStationIdList(int isFragment, String methodName, final String busiName, final String secretKey) {
        /*也可单独设置请求，会覆盖统一设置*/
        //setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if (isFragment == 0) {
            doHttpDealForFragment(httpService.getStationIdList((busiName), SecretUtils.getToken()));
        } else if (isFragment == 1) {
            doHttpDeal(httpService.getStationIdList(busiName, SecretUtils.getToken()), true);
        } else {
            doHttpDealForBackground(httpService.getStationIdList(busiName, SecretUtils.getToken()));
        }
    }

    public void getObj(int isFragment, String methodName, final String obj) {
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if (isFragment == 0) {
            doHttpDealForFragment(httpService.getObj(obj));
        } else if (isFragment == 1) {
            doHttpDeal(httpService.getObj(obj),true);
        } else {
            doHttpDealForBackground(httpService.getObj(obj));
        }
    }

    public String getLogin(String busiName, String name, String password) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("BUSI_NAME", busiName);
        jsonObject.addProperty("token", SecretUtils.getToken());
        jsonObject.addProperty("loginid",name);
        jsonObject.addProperty("pwd",password);
        jsonObject.addProperty("mac", GetPhoneMac.getMac());
        return jsonObject.toString();
    }

    public String getStationList(String busiName, String stationId, String stationName, int page, int count) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("BUSI_NAME", busiName);
        jsonObject.addProperty("token", SecretUtils.getToken());
        jsonObject.addProperty("line_name", stationName);
        jsonObject.addProperty("line_index", stationId);
        jsonObject.addProperty("page", page);
        jsonObject.addProperty("pageSize", count);
        return jsonObject.toString();
    }

    public String getPowerList(String busiName, String starttime, String endtime) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("BUSI_NAME", busiName);
        jsonObject.addProperty("token", SecretUtils.getToken());
        jsonObject.addProperty("startTime", starttime);
        jsonObject.addProperty("endTime", endtime);
        return jsonObject.toString();
    }

    public String getSteadyStatePowerList(String busiName, String starttime, String endtime) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("BUSI_NAME", busiName);
        jsonObject.addProperty("token", SecretUtils.getToken());
        jsonObject.addProperty("startTime", starttime);
        jsonObject.addProperty("endTime", endtime);
        return jsonObject.toString();
    }

    public String getSteadyStateInfoList(String busiName, String stationName, int page, int conut, String type, String startTime, String endTime) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("BUSI_NAME", busiName);
        jsonObject.addProperty("token", SecretUtils.getToken());
        jsonObject.addProperty("line_index", stationName);
        jsonObject.addProperty("page", page);
        jsonObject.addProperty("pageSize", conut);
        jsonObject.addProperty("type", type);
        jsonObject.addProperty("startTime", startTime);
        jsonObject.addProperty("endTime", endTime);
        return jsonObject.toString();
    }

    public String getTransientStatePowerList(String busiName,String st,String et) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("BUSI_NAME", busiName);
        jsonObject.addProperty("token", SecretUtils.getToken());
        jsonObject.addProperty("startTime", st);
        jsonObject.addProperty("endTime", et);
        return jsonObject.toString();
    }

    public String getTransientStateInfoList( String busiName, String stationName,String gdName,int page, int count, String type, String startTime, String endTime) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("BUSI_NAME", busiName);
        jsonObject.addProperty("token", SecretUtils.getToken());
        jsonObject.addProperty("line_index", stationName);
        jsonObject.addProperty("gd_index", gdName);
        jsonObject.addProperty("page", page);
        jsonObject.addProperty("pageSize", count);
        jsonObject.addProperty("type", type);
        jsonObject.addProperty("startTime", startTime);
        jsonObject.addProperty("endTime", endTime);
        return jsonObject.toString();
    }
    public String getStationIdList(String busiName) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("BUSI_NAME", busiName);
        jsonObject.addProperty("token", SecretUtils.getToken());
        return jsonObject.toString();
    }
    public String getLogout(String busiName,String loginId,String password,String userId){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("BUSI_NAME", busiName);
        jsonObject.addProperty("token", SecretUtils.getToken());
        jsonObject.addProperty("loginid", loginId);
        jsonObject.addProperty("pwd", password);
        jsonObject.addProperty("userid", userId);
        return jsonObject.toString();
    }
}
