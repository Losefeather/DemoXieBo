package com.tablaoutviewpagerdemo.a1111.demoxiebo.Power;

import java.util.ArrayList;

/**
 * Created by a1111 on 17/11/1.
 */

public class CommonPowerList {
    public static String sercetKey="";
    public static String GET_LONGIN="getLogin";
    public static String GET_STSATIONLIST="getStationList";
    public static String GET_POWERLIST="getPowerList";
    public static String GET_STEADYSTATEPOWERLIST="getSteadyStatePowerList";
    public static String GET_STEADYSTATEINFOLIST="getSteadyStateInfoList";
    public static String GET_TRANSIENTSTATEPOWERLIST="getTransientStatePowerList";
    public static String GET_TRANSIENTSTATEINFOLIST="getTransientStateInfoList";
    public static ArrayList<AreaTotal> areaTotalArrayList= new ArrayList<AreaTotal>();
    public static ArrayList<Power> powerArrayList= new ArrayList<Power>();
    public static ArrayList<PowerMonitorPoint> powerMonitorPointArrayList= new ArrayList<PowerMonitorPoint>();
    public static ArrayList<SteadyStateAlarm> steadyStateAlarmsArrayList = new ArrayList<SteadyStateAlarm>();
    public static ArrayList<SubstationInfo> substationInfoArrayList = new ArrayList<SubstationInfo>();

}
