package com.doulin.common;

/**
 * 异常工具类型
 */
public class ExceptionUtils extends  Exception{
    public static String getExceptionAllinformation(Exception ex) {
        String sOut = "";
        StackTraceElement[] trace = ex.getStackTrace();
        for (StackTraceElement s : trace) {
            sOut += "\tat " + s + "\r\n";
        }
        return sOut;
    }
}
