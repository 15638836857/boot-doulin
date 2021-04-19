package com.doulin.entity.common;

import lombok.Data;

@Data
public class UserRegisterReq extends ReqJson {
	private String phone;// 手机号
	private String password;// 密码
	private String userInviteCode;// 推荐码
	private String token;// 
	private String username; //微信名
	private String openId; //微信openId
	private String sex;    //性别
    private String icon;   //头像
    private String birthday; //生日
    private String communityId; //社区id
    private String communityName;//社区名
    private String hometown; //家乡
    private String nickname; //昵称
    private String unitNumber;  //单元号
    private String houseNumber; //门牌号
    private String code; //验证码
    private String type;  //0:app类型   1：微信公众号类型
    private String uid;  //微信公众号认证用
    private String codeType;//验证码类型
    private String alipayId;//支付宝ID

   
}
