package com.doulin.entity.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 请求父包
 *
 */
@Data
public class ReqJson implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cmd;// 请求 指令
	private Integer nowPage = 1; // 当前页码
	private Integer pageCount = 10; // 每页显示条数

}
