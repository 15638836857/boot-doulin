package com.doulin.common;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
     private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public R() {
        put("code", 200);
        put("data", data);
        put("msg", "操作成功");
    }
    public R(Object data) {
        put("code", 200);
        put("data", data);
        put("msg", "操作成功");
    }

    public static R error() {
        return error(1, "操作失败");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok(Object bean) {
        R r = new R(bean);
        r.setData(bean);
        return r;
    }


    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
