package com.tablaoutviewpagerdemo.a1111.demoxiebo.Power;

import com.google.gson.annotations.SerializedName;

/**
 * Created by a1111 on 17/10/9.
 */

public class SubstationInfo {
    //变电站名称
    @SerializedName("substationName")
    private String biandianzhanmingcheng;
    //线路名称
    @SerializedName("lineName")
    private String xianlumingcheng;
    //监测对象类型
    @SerializedName("monitorObject")
    private String jianceduixiangleixing;
    //检测对象名称
    @SerializedName("detectObjectNam")
    private String jianceduixiangmingcheng;
    //电压等级
    @SerializedName("voltageLevel")
    private String dianyadengji;
    //最小短路容量
    @SerializedName("minShort")
    private String zuixiaoduanlurongliang;
    //供电设备容量
    @SerializedName("powerSupply")
    private String gongdianshebeirongliang;
    //用户协议容量
    @SerializedName("userProtocol")
    private String yonghuxieyirongliang;
    //基准容量
    @SerializedName("benchmark")
    private String jizhunrongliang;
    //PT变比
    @SerializedName("PTRatio")
    private String PTbianbi;
    //CT变比
    @SerializedName("CTRatio")
    private String CTbianbi;
    //终端厂家
    @SerializedName("terminalManufacturer")
    private String zhongduanchangjia;
    //终端型号
    @SerializedName("terminalModel")
    private String zhongduanxinghao;
    //在运，停运
    @SerializedName("operationStatus")
    private boolean powerSataus;
    //正常，异常
    @SerializedName("normalStatus")
    private boolean PowerSatausInfo;

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

    public String getPTbianbi() {
        return PTbianbi;
    }

    public void setPTbianbi(String PTbianbi) {
        this.PTbianbi = PTbianbi;
    }

    public String getCTbianbi() {
        return CTbianbi;
    }

    public void setCTbianbi(String CTbianbi) {
        this.CTbianbi = CTbianbi;
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

    public boolean isPowerSataus() {
        return powerSataus;
    }

    public void setPowerSataus(boolean powerSataus) {
        this.powerSataus = powerSataus;
    }

    public boolean isPowerSatausInfo() {
        return PowerSatausInfo;
    }

    public void setPowerSatausInfo(boolean powerSatausInfo) {
        PowerSatausInfo = powerSatausInfo;
    }
}
