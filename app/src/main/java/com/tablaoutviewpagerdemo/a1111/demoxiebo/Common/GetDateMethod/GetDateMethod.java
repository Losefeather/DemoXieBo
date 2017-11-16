package com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.GetDateMethod;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Created by a1111 on 17/11/9.
 */

public class GetDateMethod {
    //一天的毫秒;
    public static int dayMaxTime=1000*60*60*24;

    //获取当前日期前一天的日期
    public static String getBeforDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
    public static String getBeforHour(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1); //得到前一小时
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
    public static String getCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,0); //得到前一天
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
    public static String getCurrentDateInfo(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,0); //得到前一天
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
}
