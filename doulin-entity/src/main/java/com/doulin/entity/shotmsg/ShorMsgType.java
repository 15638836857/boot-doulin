package com.doulin.entity.shotmsg;

/**
 * 短信类型
 */
public enum ShorMsgType {
    //您正在绑定手机
    BDSJ("1","118198"),//短信模板ID，请参考个人中心短信模板设置
    //您正在找回密码
    ZHMI("2","117801"),
    //您正在进行身份认证
    SFYZ("3","117794"),
    //您正在修改密码
    XGMA("4","117793"),
    //您正在注册
    ZC("5","117792"),
    //您正在登录
    DL("6","117791"),
    //老版本
    LBB("0","99242") ;

    private String code;
    private String value;

    public static String getVlaueByCode(String code){
        for (ShorMsgType st : ShorMsgType.values()) {
            if(st.code.equals(code)){
                return st.getValue();
            }
        }
        return null;
    }
    public static String getCodeByValue(String value){
        for (ShorMsgType st : ShorMsgType.values()) {
            if(st.value.equals(value)){
                return st.getCode();
            }
        }
        return null;
    }

    private ShorMsgType(String code,String value){
        this.code=code;
        this.value=value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
//       if("1".equals(type)) {//您正在绑定手机
//        params.put("tpl_id","118198");//短信模板ID，请参考个人中心短信模板设置
//    }else if("2".equals(type)) {//您正在找回密码
//        params.put("tpl_id","117801");
//    }else if("3".equals(type)) {//您正在进行身份认证
//        params.put("tpl_id","117794");
//    }else if("4".equals(type)) {//您正在修改密码
//        params.put("tpl_id","117793");
//    }else if("5".equals(type)) {//您正在注册
//        params.put("tpl_id","117792");
//    }else if("6".equals(type)) {//您正在登录
//        params.put("tpl_id","117791");
//    }else {//老版本
//        params.put("tpl_id","99242");
//}
