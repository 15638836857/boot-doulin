package com.doulin.common;

/**
 * @className 自定义异常类
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/12 11:04
 * @Version 1.0
 */
public class MyException extends Exception {
    private static final long serialVersionUID=1L;
    public MyException(){

    }

    /**
     * 参数异常
     * @param msg
     */
    public MyException(String msg){
        super(msg);
    }
}
