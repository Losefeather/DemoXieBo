package com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpMessageEntity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * 回调信息统一封装类
 * Created by WZG on 2016/7/16.
 */
public class BaseResultEntity<T> {
    //  判断标示
    @SerializedName( "Result")
    private int ret;
    //    提示信息
    @SerializedName( "ResultMsg")
    private String msg;
    //显示数据（用户需要关心的数据）
    @SerializedName("ReturnValue")
    private T data;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
