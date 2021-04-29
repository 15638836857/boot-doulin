package com.doulin.entity.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @className EntityDateUtil
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/27 17:54
 * @Version 1.0
 */
public class EntityDateUtil {
    /**
     * 判断是否在某个时间范围内
     * @param startTime 范围开始时间  格式为"xx:xx"
     * @param endTime   范围结束时间  格式为"xx:xx"
     * @param -- nowHour   当前小时
     * @param --nowMinute 当前分钟
     * @return  true/false
     */
    public static boolean isTimeRange(String startTime, String endTime){
        Date now=new Date();
        int nowHour=getHour(now),  nowMinute=getMinute(now);
        LocalTime nowTime = LocalTime.of(nowHour,nowMinute);
        int startHour = getHourOrMinute(startTime,true);
        int startMinute = getHourOrMinute(startTime,false);
        LocalTime startTimeLocal = LocalTime.of(startHour,startMinute);
        int endHour = getHourOrMinute(endTime,true);
        int endMinute = getHourOrMinute(endTime,false);
        LocalTime endTimeLocal = LocalTime.of(endHour,endMinute);
        if (nowTime.isAfter(startTimeLocal)&&endTimeLocal.isAfter(nowTime)){
            return true;
        }else if (nowTime.equals(startTimeLocal)||endTimeLocal.equals(nowTime)){
            return true;
        }
        return false;
    }
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        return calendar.get(Calendar.HOUR_OF_DAY);

    }

    /**

     * 功能描述：返回分

     *

     * @param date

     * 日期

     * @return 返回分钟

     */

    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        return calendar.get(Calendar.MINUTE);

    }

    /**
     * 针对str格式的时间做转换 格式为"xx:xx"
     * @param time  传入的时间
     * @param hour  true：返回小时；false：返回分钟
     * @return  当前小时或分钟
     */
    public static int getHourOrMinute(String time,boolean hour){
        if (hour){
            return Integer.parseInt(time.substring(0,time.indexOf(":")));
        }else{
            return  Integer.parseInt(time.substring(time.indexOf(":")+1));
        }
    }
    /**
     *  比较指定日期
     * @param date
     * @param compareDate
     * @return  compareDate日期在date日期之间  返回true
     */
    public static boolean isInDate(Date date, Date compareDate) {
        if (compareDate.after(getStartDate(date))
                && compareDate.before(getFinallyDate(date))) {
            return true;
        } else {
            return false;
        }

    }
    public static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat format1 = new SimpleDateFormat(
            "yyyyMMdd HH:mm:ss");
    private static Date getStartDate(Date date) {
        String temp = format1.format(date);

        try {
            return format1.parse(temp);
        } catch (Exception e) {
            return null;
        }
    }
    public static Date getFinallyDate(Date date) {
        String temp = format1.format(date);

        try {
            return format1.parse(temp);
        } catch (ParseException e) {
            return null;
        }
    }
//    public static void main(String[] args) {
//        String str="20210429 22:00:00";
//
//
//        System.out.println(isInDate(new Date(), DateUtil.parse(str,format1)));
//    }
}
