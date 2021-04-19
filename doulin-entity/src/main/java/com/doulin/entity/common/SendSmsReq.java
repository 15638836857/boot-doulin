package com.doulin.entity.common;

import lombok.Data;

@Data
public class SendSmsReq extends ReqJson {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phone;
	private String codeType;



	
}
