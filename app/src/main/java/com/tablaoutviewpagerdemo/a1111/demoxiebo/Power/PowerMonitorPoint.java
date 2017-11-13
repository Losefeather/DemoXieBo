package com.tablaoutviewpagerdemo.a1111.demoxiebo.Power;

import com.google.gson.annotations.SerializedName;

/**
 * Created by a1111 on 17/9/30.
 */

public class PowerMonitorPoint {
    //供电单位
    @SerializedName("gd_name")
    private String Gongdiandanwei;
    //电站名称
    @SerializedName("sub_name")
    private String Dianzhanmingcheng;
    //母线名称
    @SerializedName("subv_name")
    private String Muxianmingcheng;
    //线路名称
    @SerializedName("line_name")
    private String Xianlumingcheng;
    //事件类型
    @SerializedName("type_name")
    private String Shijianleixing;
    //相别
    @SerializedName("ccm_phasic_type")
    private String Xiangbie;
    //发生时间
    @SerializedName("timeid")
    private String Fashengshijian;
    //残余电压
    @SerializedName("eventvaule")
    private String Canyudianya;
    //持续时间
    @SerializedName("persisttime")
    private String Chixushijian;

    @Override
    public String toString() {
        return super.toString();
    }

    public String getGongdiandanwei() {
        return Gongdiandanwei;
    }

    public void setGongdiandanwei(String gongdiandanwei) {
        Gongdiandanwei = gongdiandanwei;
    }

    public String getDianzhanmingcheng() {
        return Dianzhanmingcheng;
    }

    public void setDianzhanmingcheng(String dianzhanmingcheng) {
        Dianzhanmingcheng = dianzhanmingcheng;
    }

    public String getMuxianmingcheng() {
        return Muxianmingcheng;
    }

    public void setMuxianmingcheng(String muxianmingcheng) {
        Muxianmingcheng = muxianmingcheng;
    }

    public String getXianlumingcheng() {
        return Xianlumingcheng;
    }

    public void setXianlumingcheng(String xianlumingcheng) {
        Xianlumingcheng = xianlumingcheng;
    }

    public String getShijianleixing() {
        return Shijianleixing;
    }

    public void setShijianleixing(String shijianleixing) {
        Shijianleixing = shijianleixing;
    }

    public String getXiangbie() {
        return Xiangbie;
    }

    public void setXiangbie(String xiangbie) {
        Xiangbie = xiangbie;
    }

    public String getFashengshijian() {
        return Fashengshijian;
    }

    public void setFashengshijian(String fashengshijian) {
        Fashengshijian = fashengshijian;
    }

    public String getCanyudianya() {
        return Canyudianya;
    }

    public void setCanyudianya(String canyudianya) {
        Canyudianya = canyudianya;
    }

    public String getChixushijian() {
        return Chixushijian;
    }

    public void setChixushijian(String chixushijian) {
        Chixushijian = chixushijian;
    }
}
