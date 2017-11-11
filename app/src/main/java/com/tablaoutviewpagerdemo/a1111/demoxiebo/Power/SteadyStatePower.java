package com.tablaoutviewpagerdemo.a1111.demoxiebo.Power;

import com.google.gson.annotations.SerializedName;

import static android.R.attr.name;

/**
 * Created by a1111 on 17/11/10.
 */

public class SteadyStatePower {
    //频率偏差
    @SerializedName("FREQ_RATE")
    private String pinlvpiancha;
    //电压偏差
    @SerializedName("VOLTAGE_RATE")
    private String dianyapiancha;
    //电压不平衡度
    @SerializedName("UBALANCE_RATE")
    private String dianyabupinghengdu;
    //闪变
    @SerializedName("FLICKER_RATE")
    private String shanbian;
    //电压谐波畸变率
    @SerializedName("UABERRANCE_RATE")
    private String dianyaxiebojibianlv;
    //谐波电压含有率
    @SerializedName("UHARM_RATE")
    private String xiebodianyahanyoulv;
    //谐波电流幅值
    @SerializedName("IHARM_RATE")
    private String xiebodianluifuzhi;

    public String getPinlvpiancha() {
        return pinlvpiancha;
    }

    public void setPinlvpiancha(String pinlvpiancha) {
        this.pinlvpiancha = pinlvpiancha;
    }

    public String getDianyapiancha() {
        return dianyapiancha;
    }

    public void setDianyapiancha(String dianyapiancha) {
        this.dianyapiancha = dianyapiancha;
    }

    public String getDianyabupinghengdu() {
        return dianyabupinghengdu;
    }

    public void setDianyabupinghengdu(String dianyabupinghengdu) {
        this.dianyabupinghengdu = dianyabupinghengdu;
    }

    public String getShanbian() {
        return shanbian;
    }

    public void setShanbian(String shanbian) {
        this.shanbian = shanbian;
    }

    public String getDianyaxiebojibianlv() {
        return dianyaxiebojibianlv;
    }

    public void setDianyaxiebojibianlv(String dianyaxiebojibianlv) {
        this.dianyaxiebojibianlv = dianyaxiebojibianlv;
    }

    public String getXiebodianyahanyoulv() {
        return xiebodianyahanyoulv;
    }

    public void setXiebodianyahanyoulv(String xiebodianyahanyoulv) {
        this.xiebodianyahanyoulv = xiebodianyahanyoulv;
    }

    public String getXiebodianluifuzhi() {
        return xiebodianluifuzhi;
    }

    public void setXiebodianluifuzhi(String xiebodianluifuzhi) {
        this.xiebodianluifuzhi = xiebodianluifuzhi;
    }
}
