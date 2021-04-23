package com.doulin.entity.common;

import lombok.Data;

@Data
public class EditUserPasswordReq extends ReqJson {
	private String uid;
	private String oldPassword;
	private String newPassword;
    private String phone;
	
}
