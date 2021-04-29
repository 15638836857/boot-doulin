package com.doulin.entity.shop;

public enum ApplyFlagUtil {
    STATUS_Y("Y","审核通过"),
    STATUS_Z("Z","审核中"),
    STATUS_N("N","审核失败");
    private String code;
    private String name;
    private ApplyFlagUtil(String code,String name){
        this.code=code;
        this.name=name;
    }
    public static String getNameByCode(String code){
        for (ApplyFlagUtil st : ApplyFlagUtil.values()) {
            if(st.code.equals(code)){
                return st.getName();
            }
        }
        return null;
    }
    public static String getCodeByName(String value){
        for (ApplyFlagUtil st : ApplyFlagUtil.values()) {
            if(st.name.equals(value)){
                return st.getCode();
            }
        }
        return null;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
