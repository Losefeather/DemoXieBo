package com.tablaoutviewpagerdemo.a1111.demoxiebo.Power;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.PowerResultEntity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
    public static String GET_STSTIONINFOLIST="getStationIdList";
    public static String GET_LOGOUT="getLogout";
    public static String BUSI_LOGIN="SysLoginBean@loginUser";
    public static String BUSI_ZBGL="HarmonicAppBean@getZBGL";
    public static String BUSI_JCDZL="HarmonicAppBean@getJCDZL";
    public static String BUSI_JCDLB="HarmonicAppBean@getLineList";
    public static String BUSI_WTGJ="HarmonicAppBean@getWTGJ";
    public static String BUSI_WTGJXQ="HarmonicAppBean@getWTGJDetail";
    public static String BUSI_ZT="HarmonicAppBean@getZTCount";
    public static String BUSI_ZTXQ="HarmonicAppBean@getZTDetail";
    public static String BUSI_LOGOUT="SysLoginBean@DestroyUserSession";
    public static ArrayList<AreaTotal> areaTotalArrayList= new ArrayList<AreaTotal>();
    public static ArrayList<Power> powerArrayList= new ArrayList<Power>();
    public static ArrayList<PowerMonitorPoint> powerMonitorPointArrayList= new ArrayList<PowerMonitorPoint>();
    public static ArrayList<SteadyStateAlarm> steadyStateAlarmsArrayList = new ArrayList<SteadyStateAlarm>();
    public static ArrayList<SubstationInfo> substationInfoArrayList = new ArrayList<SubstationInfo>();
    public static ArrayList<PowerMonitorId> powerMonitorIdArrayList = new ArrayList<PowerMonitorId>();
    public static ArrayList<SteadyStatePower> steadyStatePowerArrayList = new ArrayList<SteadyStatePower>();
    public static int isFragment=0;
    public static int isActitvy=1;
    public static int isBackGround=2;
    public static int isRxActitvy=3;
    public static PowerLogin powerLogin = new PowerLogin();
    public static boolean isFirstIntoFragment1=true;
    public static boolean isFirstIntoFragment2=true;
    public static boolean isFirstIntoFragment3=true;
    public static boolean isFirstIntoFragment4=true;
}
