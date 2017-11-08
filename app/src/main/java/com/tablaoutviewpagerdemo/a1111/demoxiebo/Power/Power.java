package com.tablaoutviewpagerdemo.a1111.demoxiebo.Power;

import com.google.gson.annotations.SerializedName;

/**
 * Created by a1111 on 17/9/29.
 */

public class Power {
    @SerializedName("areaName")
    private String Name;
    @SerializedName("powerUp")
    private String Zanshengdianya;
    @SerializedName("powerDown")
    private String Zanjiangdianya;
    @SerializedName("powerPause")
    private String Duanshizhongduan;
    @SerializedName("areaNumber")
    private int Num;

    public int getNum() {
        return Num;
    }
    public void setNum(int num) {
        Num = num;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getZanshengdianya() {
        return Zanshengdianya;
    }

    public void setZanshengdianya(String zanshengdianya) {
        Zanshengdianya = zanshengdianya;
    }

    public String getZanjiangdianya() {
        return Zanjiangdianya;
    }

    public void setZanjiangdianya(String zanjiangdianya) {
        Zanjiangdianya = zanjiangdianya;
    }

    public String getDuanshizhongduan() {
        return Duanshizhongduan;
    }

    public void setDuanshizhongduan(String duanshizhongduan) {
        Duanshizhongduan = duanshizhongduan;
    }
}
