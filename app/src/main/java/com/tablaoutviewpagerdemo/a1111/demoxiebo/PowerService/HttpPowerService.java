package com.tablaoutviewpagerdemo.a1111.demoxiebo.PowerService;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

import static android.R.attr.name;
import static android.R.attr.type;

/**
 * Created by a1111 on 17/10/31.
 */


public interface HttpPowerService {
    //登录接口
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getLogin(@Field("BUSI_NAME") String businame,@Field("loginid") String name, @Field("pwd") String password);
    //指标概览接口
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getPowerList(@Field("BUSI_NAME") String businame,@Field("secretKey") String secretKey,@Field("startTime") String starttime,@Field("endTime") String endtime);
    //监测点总览接口
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getStationList(@Field("BUSI_NAME") String businame,@Field("secretKey") String secretKey,@Field("line_index") String stationId,@Field("line_name") String stationName,@Field("page") int page,@Field("pageSize") int count);
    //暂态告警接口
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getTransientStatePowerList(@Field("BUSI_NAME") String businame,@Field("secretKey") String secretKey,@Field("startTime") String startTime,@Field("endTime") String endTime);
    //暂态告警详情接口
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getTransientStateInfoList(@Field("BUSI_NAME") String businame,@Field("secretKey") String secretKey,@Field("line_index") String stationName,@Field("gd_index") String gdName,@Field("page") int page,@Field("pageSize") int count,@Field("type")String type,@Field("startTime") String starttime,@Field("endTime") String endtime);
    //稳态告警接口
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getSteadyStatePowerList(@Field("BUSI_NAME") String businame,@Field("secretKey") String secretKey,@Field("startTime") String starttime,@Field("endTime") String endtime);
    //稳态告警详情接口
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getSteadyStateInfoList(@Field("BUSI_NAME") String businame,@Field("secretKey") String secretKey,@Field("line_index") String stationName,@Field("page") int page,@Field("pageSize") int count,@Field("type")String type,@Field("startTime") String starttime,@Field("endTime") String endtime);
    //获取监测点名称及id
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getStationIdList(@Field("BUSI_NAME") String businame,@Field("secretKey") String secretKey);
}
