package com.tablaoutviewpagerdemo.a1111.demoxiebo.Power;

import com.google.gson.annotations.SerializedName;

/**
 * Created by a1111 on 17/10/9.
 */

public class SubstationInfo {
    //变电站名称
    @SerializedName("SUBNAME")
    private String biandianzhanmingcheng;
    //线路名称
    @SerializedName("LINE_NAME")
    private String xianlumingcheng;
    //监测对象类型
    @SerializedName("FHLX")
    private String jianceduixiangleixing;
    //检测对象名称
    @SerializedName("JCYHMC")
    private String jianceduixiangmingcheng;
    //电压等级
    @SerializedName("SCALE")
    private String dianyadengji;
    //最小短路容量
    @SerializedName("DLCMP")
    private String zuixiaoduanlurongliang;
    //供电设备容量
    @SerializedName("GDSBRL")
    private String gongdianshebeirongliang;
    //用户协议容量
    @SerializedName("XYCMP")
    private String yonghuxieyirongliang;
    //基准容量
    @SerializedName("JZCMP")
    private String jizhunrongliang;
    //PT变比1
    @SerializedName("PT1")
    private String PT1;
    //PT变比2
    @SerializedName("PT2")
    private String PT2;
    //CT变比1
    @SerializedName("CT1")
    private String CT1;
    //CT变比2
    @SerializedName("CT2")
    private String CT2;
    //终端厂家
    @SerializedName("SCCJ")
    private String zhongduanchangjia;
    //终端型号
    @SerializedName("ZZXH")
    private String zhongduanxinghao;
    //在运，停运
    @SerializedName("YXZT")
    private String powerSataus;
    //正常，异常
    @SerializedName("normalStatus")
    private int PowerSatausInfo;

    public String getBiandianzhanmingcheng() {
        return biandianzhanmingcheng;
    }

    public void setBiandianzhanmingcheng(String biandianzhanmingcheng) {
        this.biandianzhanmingcheng = biandianzhanmingcheng;
    }

    public String getXianlumingcheng() {
        return xianlumingcheng;
    }

    public void setXianlumingcheng(String xianlumingcheng) {
        this.xianlumingcheng = xianlumingcheng;
    }

    public String getJianceduixiangleixing() {
        return jianceduixiangleixing;
    }

    public void setJianceduixiangleixing(String jianceduixiangleixing) {
        this.jianceduixiangleixing = jianceduixiangleixing;
    }

    public String getJianceduixiangmingcheng() {
        return jianceduixiangmingcheng;
    }

    public void setJianceduixiangmingcheng(String jianceduixiangmingcheng) {
        this.jianceduixiangmingcheng = jianceduixiangmingcheng;
    }

    public String getDianyadengji() {
        return dianyadengji;
    }

    public void setDianyadengji(String dianyadengji) {
        this.dianyadengji = dianyadengji;
    }

    public String getZuixiaoduanlurongliang() {
        return zuixiaoduanlurongliang;
    }

    public void setZuixiaoduanlurongliang(String zuixiaoduanlurongliang) {
        this.zuixiaoduanlurongliang = zuixiaoduanlurongliang;
    }

    public String getGongdianshebeirongliang() {
        return gongdianshebeirongliang;
    }

    public void setGongdianshebeirongliang(String gongdianshebeirongliang) {
        this.gongdianshebeirongliang = gongdianshebeirongliang;
    }

    public String getYonghuxieyirongliang() {
        return yonghuxieyirongliang;
    }

    public void setYonghuxieyirongliang(String yonghuxieyirongliang) {
        this.yonghuxieyirongliang = yonghuxieyirongliang;
    }

    public String getJizhunrongliang() {
        return jizhunrongliang;
    }

    public void setJizhunrongliang(String jizhunrongliang) {
        this.jizhunrongliang = jizhunrongliang;
    }

    public String getPT1() {
        return PT1;
    }

    public void setPT1(String PT1) {
        this.PT1 = PT1;
    }

    public String getPT2() {
        return PT2;
    }

    public void setPT2(String PT2) {
        this.PT2 = PT2;
    }

    public String getCT1() {
        return CT1;
    }

    public void setCT1(String CT1) {
        this.CT1 = CT1;
    }

    public String getCT2() {
        return CT2;
    }

    public void setCT2(String CT2) {
        this.CT2 = CT2;
    }

    public int getPowerSatausInfo() {
        return PowerSatausInfo;
    }

    public String getZhongduanchangjia() {
        return zhongduanchangjia;
    }

    public void setZhongduanchangjia(String zhongduanchangjia) {
        this.zhongduanchangjia = zhongduanchangjia;
    }

    public String getZhongduanxinghao() {
        return zhongduanxinghao;
    }

    public void setZhongduanxinghao(String zhongduanxinghao) {
        this.zhongduanxinghao = zhongduanxinghao;
    }

    public String getPowerSataus() {
        return powerSataus;
    }

    public void setPowerSataus(String powerSataus) {
        this.powerSataus = powerSataus;
    }

    public int isPowerSatausInfo() {
        return PowerSatausInfo;
    }

    public void setPowerSatausInfo(int powerSatausInfo) {
        PowerSatausInfo = powerSatausInfo;
    }
}
