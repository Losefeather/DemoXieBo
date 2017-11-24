package com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.GetDateMethod.GetDateMethod;

import com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.MD5.SecretUtils;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.CommonPowerList;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.Power;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.PowerMonitorId;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.SteadyStatePower;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Power.SubstationInfo;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a1111 on 17/11/20.
 */

public class HttpBackgroudApi implements HttpOnNextListener{
    public final String TAG="HttpBackgroudApi";
    private HttpPowerApi httpPowerApi=new HttpPowerApi(this);
    private Gson gson= new Gson();
    private static HttpBackgroudApi httpBackgroudApi = null;

    //静态工厂方法
    public static HttpBackgroudApi getInstance() {
        if (httpBackgroudApi == null) {
            synchronized (HttpBackgroudApi.class) {
                if (httpBackgroudApi == null) {
                    httpBackgroudApi = new HttpBackgroudApi();
                }
            }
        }
        return httpBackgroudApi;
    }
    public void login(){
        getStationIdList();
     //   getStationList();
     //   getSteadyStatePowerList();
     //   getTransientStatePowerList();
    }
    public void getStationIdList(){
        //httpPowerApi.getStationIdList(CommonPowerList.isBackGround, CommonPowerList.GET_STSTIONINFOLIST, CommonPowerList.BUSI_JCDLB, CommonPowerList.sercetKey);
        httpPowerApi.getObj(CommonPowerList.isBackGround, CommonPowerList.GET_STSTIONINFOLIST,SecretUtils.encrypt(httpPowerApi.getStationIdList(CommonPowerList.BUSI_JCDLB)));
    }
    public void getStationList(){
      //  httpPowerApi.getStationList(CommonPowerList.isBackGround,CommonPowerList.GET_STSATIONLIST,CommonPowerList.BUSI_JCDZL,CommonPowerList.sercetKey,"","",1,15);
        httpPowerApi.getObj(CommonPowerList.isBackGround,CommonPowerList.GET_STSATIONLIST, SecretUtils.encrypt(httpPowerApi.getStationList(CommonPowerList.BUSI_JCDZL,"","",1,15)));

    }
    public void getSteadyStatePowerList(){
      // httpPowerApi.getSteadyStatePowerList(CommonPowerList.isBackGround,CommonPowerList.GET_STEADYSTATEPOWERLIST,CommonPowerList.BUSI_WTGJ,CommonPowerList.sercetKey,GetDateMethod.getCurrentDate()+" 00:00:00",GetDateMethod.getCurrentDateInfo());
       httpPowerApi.getObj(CommonPowerList.isBackGround,CommonPowerList.GET_STEADYSTATEPOWERLIST,SecretUtils.encrypt(httpPowerApi.getSteadyStatePowerList(CommonPowerList.BUSI_WTGJ,GetDateMethod.getCurrentDate()+" 00:00:00",GetDateMethod.getCurrentDateInfo())));
    }
    public void getTransientStatePowerList(){
     //  httpPowerApi.getTransientStatePowerList(CommonPowerList.isBackGround,CommonPowerList.GET_TRANSIENTSTATEPOWERLIST,CommonPowerList.BUSI_ZT,CommonPowerList.sercetKey,GetDateMethod.getCurrentDate()+" 00:00:00",GetDateMethod.getBeforHour());
        httpPowerApi.getObj(CommonPowerList.isBackGround ,CommonPowerList.GET_TRANSIENTSTATEPOWERLIST, SecretUtils.encrypt(httpPowerApi.getTransientStatePowerList(CommonPowerList.BUSI_ZT,GetDateMethod.getCurrentDate()+" 00:00:00",GetDateMethod.getBeforHour())));
    }
    @Override
    public void onNext(String resulte, String method) {
        if(method.equals(CommonPowerList.GET_STSTIONINFOLIST)){
            Log.e(TAG,"回复1");
            Type type = new TypeToken<PowerResultEntity<List<PowerMonitorId>>>(){}.getType();
            PowerResultEntity<List<PowerMonitorId>> baseInfo=gson.fromJson(resulte,type);
            ArrayList<PowerMonitorId> powerMonitorIdList=new ArrayList<PowerMonitorId>();
            for(int i=0;i<baseInfo.getData().size();i++) {
                powerMonitorIdList.add(baseInfo.getData().get(i));
            }
            CommonPowerList.powerMonitorIdArrayList=powerMonitorIdList;

        }
        if(method.equals(CommonPowerList.GET_STSATIONLIST)){
            Log.e(TAG,"回复2");
            Type type = new TypeToken<PowerResultEntity<HttpPageCount<SubstationInfo>>>(){}.getType();
            PowerResultEntity<HttpPageCount<SubstationInfo>> baseInfo=gson.fromJson(resulte,type);
            ArrayList<SubstationInfo> substationInfoArrayList=new ArrayList<SubstationInfo>();
            for(int i=0;i<baseInfo.getData().getList().size();i++) {
                substationInfoArrayList.add(baseInfo.getData().getList().get(i));
            }
            CommonPowerList.substationInfoArrayList=substationInfoArrayList;
        }
//        if(method.equals(CommonPowerList.GET_POWERLIST)){
//            Log.e(TAG,"回复3");
//            Type type = new TypeToken<PowerResultEntity<List<AreaTotal>>>(){}.getType();
//            PowerResultEntity<List<AreaTotal>> baseInfo=gson.fromJson(resulte,type);
//            ArrayList<AreaTotal> areaTotalArrayList=new ArrayList<AreaTotal>();
//            for(int i=0;i<baseInfo.getData().size();i++) {
//                areaTotalArrayList.add(baseInfo.getData().get(i));
//            }
//            CommonPowerList.areaTotalArrayList=areaTotalArrayList;
//
//        }
        if(method.equals(CommonPowerList.GET_STEADYSTATEPOWERLIST)){
            Log.e(TAG,"回复4");
            Type type = new TypeToken<PowerResultEntity<List<SteadyStatePower>>>(){}.getType();
            PowerResultEntity<List<SteadyStatePower>> baseInfo=gson.fromJson(resulte,type);
            ArrayList<SteadyStatePower> steadyStatePowerArrayList=new ArrayList<SteadyStatePower>();
            for(int i=0;i<baseInfo.getData().size();i++) {
                steadyStatePowerArrayList.add(baseInfo.getData().get(i));
            }
            CommonPowerList.steadyStatePowerArrayList=steadyStatePowerArrayList;
         }
        if(method.equals(CommonPowerList.GET_TRANSIENTSTATEPOWERLIST)){
            Log.e(TAG,"回复5");
            Type type = new TypeToken<PowerResultEntity<List<Power>>>(){}.getType();
            PowerResultEntity<List<Power>> baseInfo=gson.fromJson(resulte,type);
            ArrayList<Power> powerArrayList=new ArrayList<Power>();
            for(int i=0;i<baseInfo.getData().size();i++) {
                powerArrayList.add(baseInfo.getData().get(i));
            }
            CommonPowerList.powerArrayList=powerArrayList;
        }
    }
    @Override
    public void onError(ApiException e, String method) {

    }
}
