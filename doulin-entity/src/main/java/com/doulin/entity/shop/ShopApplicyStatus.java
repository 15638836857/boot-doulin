package com.doulin.entity.shop;

/**
 * @className ShopApplicyStatus
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/20 16:20
 * @Version 1.0
 */
public enum  ShopApplicyStatus {
    STATUS_0(0,"初始状态"),
    STATUS_1(1,"基础资料"),
    STATUS_2(2,"商家入驻，等待业务员上门"),
    STATUS_3(3,"商家资料审核"),
    STATUS_4(4,"商家资料审核失败"),
    STATUS_5(5,"商家入驻成功"),
    STATUS_6(6,"商家未注册");
    private Integer code;
    private String name;
    private ShopApplicyStatus(Integer code,String name){
        this.code=code;
        this.name=name;
    }
    public static String getNameByCode(String code){
        for (ShopApplicyStatus st : ShopApplicyStatus.values()) {
            if(st.code.equals(code)){
                return st.getName();
            }
        }
        return null;
    }
    public static Integer getCodeByName(String value){
        for (ShopApplicyStatus st : ShopApplicyStatus.values()) {
            if(st.name.equals(value)){
                return st.getCode();
            }
        }
        return null;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
