package com.doulin.entity.common;

public class FindUserPasswordReq extends ReqJson {
	private String phone;
	private String password;
	private String codeType;
    private String code;
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public FindUserPasswordReq(){
		super();
	}
   
}
