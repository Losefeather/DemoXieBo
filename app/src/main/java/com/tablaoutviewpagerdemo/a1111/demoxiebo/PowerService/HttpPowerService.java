package com.tablaoutviewpagerdemo.a1111.demoxiebo.PowerService;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by a1111 on 17/10/31.
 */


public interface HttpPowerService {
    //登录接口
    @FormUrlEncoded
    @POST("login/")
    Observable<String> getLogin(@Field("name") String name, @Field("password") String password);
    //指标概览接口
    @FormUrlEncoded
    @POST("login/")
    Observable<String> getPowerList(@Field("secretKey") String secretKey);
    //监测点总览接口
    @FormUrlEncoded
    @POST("login/")
    Observable<String> getStationList(@Field("secretKey") String secretKey,@Field("stationName") String stationName);
    //暂态告警接口
    @FormUrlEncoded
    @POST("login/")
    Observable<String> getTransientStatePowerList(@Field("secretKey") String secretKey,@Field("Ts") String ts);
    //暂态告警详情接口
    @FormUrlEncoded
    @POST("login/")
    Observable<String> getTransientStateInfoList(@Field("secretKey") String secretKey,@Field("stationName") String stationName,@Field("pageNum") int page,@Field("Type") String type);
    //稳态告警接口
    @FormUrlEncoded
    @POST("login/")
    Observable<String> getSteadyStatePowerList(@Field("secretKey") String secretKey,@Field("Ts") String ts);
    //稳态告警详情接口
    @FormUrlEncoded
    @POST("login/")
    Observable<String> getSteadyStateInfoList(@Field("secretKey") String secretKey,@Field("stationName") String stationName,@Field("pageNum") int page,@Field("Type") String type);


}
