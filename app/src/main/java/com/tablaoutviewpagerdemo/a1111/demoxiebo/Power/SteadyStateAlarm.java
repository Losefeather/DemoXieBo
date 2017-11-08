package com.tablaoutviewpagerdemo.a1111.demoxiebo.Power;

import com.google.gson.annotations.SerializedName;

/**
 * Created by a1111 on 17/10/10.
 */

public class SteadyStateAlarm {

    @SerializedName("supplyUnit")
    private String gongdiandanwei;
    @SerializedName("stationName")
    private String diaanzhanmingcheng;
    @SerializedName("monitoringPoint")
    private String jiancedian;
    @SerializedName("IndicatorType")
    private String zhibiaoleixing;
    @SerializedName("occurrenceTime")
    private String fashengshijian;
    @SerializedName("internationalValue")
    private Double guojizhi;
    @SerializedName("actualValue")
    private Double shijizhi;
    @SerializedName("outValue")
    private Double yuechuzhi;

    public String getGongdiandanwei() {
        return gongdiandanwei;
    }

    public void setGongdiandanwei(String gongdiandanwei) {
        this.gongdiandanwei = gongdiandanwei;
    }

    public String getDiaanzhanmingcheng() {
        return diaanzhanmingcheng;
    }

    public void setDiaanzhanmingcheng(String diaanzhanmingcheng) {
        this.diaanzhanmingcheng = diaanzhanmingcheng;
    }

    public String getJiancedian() {
        return jiancedian;
    }

    public void setJiancedian(String jiancedian) {
        this.jiancedian = jiancedian;
    }

    public String getZhibiaoleixing() {
        return zhibiaoleixing;
    }

    public void setZhibiaoleixing(String zhibiaoleixing) {
        this.zhibiaoleixing = zhibiaoleixing;
    }

    public String getFashengshijian() {
        return fashengshijian;
    }

    public void setFashengshijian(String fashengshijian) {
        this.fashengshijian = fashengshijian;
    }

    public double getGuojizhi() {
        return guojizhi;
    }

    public void setGuojizhi(double guojizhi) {
        this.guojizhi = guojizhi;
    }

    public double getShijizhi() {
        return shijizhi;
    }

    public void setShijizhi(double shijizhi) {
        this.shijizhi = shijizhi;
    }

    public double getYuechuzhi() {
        return yuechuzhi;
    }

    public void setYuechuzhi(double yuechuzhi) {
        this.yuechuzhi = yuechuzhi;
    }
}
