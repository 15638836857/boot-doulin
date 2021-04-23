package com.doulin.mobile.common;

/**
 * 接口管理
 */
public enum ApiNameUtil {
    //商家注册
    SHOPREGISTER("shopRegister"),
    //或区验证码
    GETSMSCODE("getSMSCode"),
    //商家登录
    SHOPLOGIN("shopLogin"),
    //商家添加密码
    ADDSHOPPASSWORD("addShopPassword"),
    //商家编辑密码
    EDITSOPPASSWORD("editShopPassword")
    ;

    private String api;



    private ApiNameUtil(String api){
        this.api=api;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}