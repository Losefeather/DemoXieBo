package com.tablaoutviewpagerdemo.a1111.demoxiebo.Power;


import com.google.gson.annotations.SerializedName;

/**
 * Created by a1111 on 17/10/9.
 */

public class AreaTotal {

    //名称
    @SerializedName("areaName")
    private String name;
    //在线率1
    @SerializedName("onlineRate1")
    private float Online1;
    //在线率2
    @SerializedName("onlineRate2")
    private float Online2;
    //完整率
    @SerializedName("completeRate")
    private float integrity;
    //数量
    @SerializedName("areaNumber")
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getOnline1() {
        return Online1;
    }

    public void setOnline1(float online1) {
        Online1 = online1;
    }

    public float getOnline2() {
        return Online2;
    }

    public void setOnline2(float online2) {
        Online2 = online2;
    }

    public float getIntegrity() {
        return integrity;
    }

    public void setIntegrity(float integrity) {
        this.integrity = integrity;
    }



}
