package com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI;

import com.google.gson.annotations.SerializedName;

/**
 * Created by a1111 on 17/11/10.
 */

public class PowerResultEntity<T> {

    //  判断标示
    @SerializedName("resCode")
    private String resCode;
    //    提示信息
    @SerializedName("resCodeStr")
    private String resCodeStr;
    //
    @SerializedName("resDesc")
    private String resDesc;
    //显示数据（用户需要关心的数据）
    @SerializedName("resObject")
    private T data;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResCodeStr() {
        return resCodeStr;
    }

    public void setResCodeStr(String resCodeStr) {
        this.resCodeStr = resCodeStr;
    }

    public String getResDesc() {
        return resDesc;
    }

    public void setResDesc(String resDesc) {
        this.resDesc = resDesc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
