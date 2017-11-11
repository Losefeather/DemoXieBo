package com.tablaoutviewpagerdemo.a1111.demoxiebo.Power;


import com.google.gson.annotations.SerializedName;

/**
 * Created by a1111 on 17/10/9.
 */

public class AreaTotal {

    //名称
    @SerializedName("gd_name")
    private String name;
    //在线率1
    @SerializedName("online_rate")
    private String Online1;
    //在线率2
    @SerializedName("gw_online_rate")
    private String Online2;
    //完整率
    @SerializedName("data_rate")
    private String integrity;
    //数量
    @SerializedName("monitor_count")
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

    public String getOnline1() {
        return Online1;
    }

    public void setOnline1(String online1) {
        Online1 = online1;
    }

    public String getOnline2() {
        return Online2;
    }

    public void setOnline2(String online2) {
        Online2 = online2;
    }

    public String getIntegrity() {
        return integrity;
    }

    public void setIntegrity(String integrity) {
        this.integrity = integrity;
    }
}
