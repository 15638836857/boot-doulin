package com.doulin.entity.common;

import lombok.Data;

@Data
public class UserLoginRes extends ResJson {
	private String uid;// 用户id
	private String communityId;// 社区id
	private String communityName;// 社区名称
	private String nickName;// 社区名称
	private String avatra;// 头像
	private String rytoken;// 网易云token

	private String iswanshan;// 0未完善社区信息 1已完善社区信息
	private String state;     //0绑定手机号  1未绑定手机号
	private String specifiedCoupon; //指定优惠劵 
	private String phone;
	private String openid;//小程序获取openid用于支付
	private String unionid;


	public static UserLoginRes Ok(String resultNote,String uid,String ryToken) {
		UserLoginRes r = new UserLoginRes();
		r.setResult("0");
		r.setResultNote(resultNote);
		r.setUid(uid);
		r.setRytoken(ryToken);
		return r;
	}
   	public static UserLoginRes error(String resultNote) {
		UserLoginRes r = new UserLoginRes();
		r.setResult("1");
		r.setResultNote(resultNote);
		return r;
	}
	public static UserLoginRes error(String code,String resultNote) {
		UserLoginRes r = new UserLoginRes();
		r.setResult(code);
		r.setResultNote(resultNote);
		return r;
	}

}
