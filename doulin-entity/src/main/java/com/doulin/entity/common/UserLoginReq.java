package com.doulin.entity.common;

import lombok.Data;

@Data
public class UserLoginReq extends ReqJson {
	private String phone;
	private String password;
	private String type;// 1密码登录，2短信登录
	private String token;
	private String openId;//微信openId
	private String uid;


	
   
}
