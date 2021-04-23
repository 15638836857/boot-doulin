package com.doulin.entity.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
public class UserLoginReq extends ReqJson {
	private String phone;
	private String password;
	private String loginType;// 1密码登录，2短信登录
	private String token;
	private String openId;//微信openId
	private String uid;

    public UserLoginReq(){
	super();
    }


}
