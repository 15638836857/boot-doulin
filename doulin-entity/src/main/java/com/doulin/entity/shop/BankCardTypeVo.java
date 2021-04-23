package com.doulin.entity.shop;

public enum BankCardTypeVo {
//    0:不能识别; 1: 借记卡; 2: 贷记卡（原信用卡大部分为贷记卡）; 3: 准贷记卡; 4: 预付费卡;
    TYPE_0(0,"不能识别"),
    TYPE_1(1,"借记卡"),
    TYPE_2(2,"贷记卡（原信用卡大部分为贷记卡）"),
    TYPE_3(3,"准贷记卡"),
    TYPE_4(4,"预付费卡");
    private Integer code;
    private String name;
    private BankCardTypeVo(Integer code,String name){
        this.code=code;
        this.name=name;
    }
    public static String getNameByCode(Integer code){
        for (BankCardTypeVo st : BankCardTypeVo.values()) {
            if(st.code.equals(code)){
                return st.getName();
            }
        }
        return null;
    }
    public static Integer getCodeByName(String value){
        for (BankCardTypeVo st : BankCardTypeVo.values()) {
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

