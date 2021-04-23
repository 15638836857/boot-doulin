package com.doulin.entity.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class ResJson implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result = "1";// 0 成功 1 失败，2登录失效，3余额不足,4已注册，5未注册
	private String resultNote = "系统繁忙";// 响应结果描述 失败时填写失败原因
	private Integer totalPage; // 总页数
     private Integer code;
     private String msg;
	private String zcState;
	private String token;// apptoken
	private Integer mainShow; // APP主页显示第几栏
	private List dataList; // 返回内容
	private Long totalCount; // 总条数
	private Object object; // 返回对象
	private Object objects; // 返回对象
	private Object model; // 返回对象
	private List data;
	private String allnum; // 返回对象
    private String state; //状态
    private String AllMoney;//购物车商品价合计
    private String orderState;//订单状态
    private String orderNum;//订单状态

	public static ResJson Ok() {
		ResJson resJson=new ResJson();
		resJson.setResult("0");
		resJson.setResultNote("操作成功");
		return resJson;
	}
	public static ResJson Ok( Object objects) {
		ResJson resJson=new ResJson();
		resJson.setResult("0");
		resJson.setResultNote("操作成功");
		resJson.setObjects(objects);
		return resJson;
	}
	public static ResJson Ok(String msg) {
		ResJson resJson=new ResJson();
		resJson.setResult("0");
		resJson.setCode(0);
		resJson.setMsg(msg);
		return resJson;
	}

	@Override
	public String toString() {
		return "ResJson [result=" + result + ", totalPage=" + totalPage + ", resultNote=" + resultNote + ", dataList="
				+ dataList + "]";
	}

	public static ResJson error(String code,String stateCode, String msg) {
		ResJson r = new ResJson();
		r.setResult(code);
		r.setCode(1);
		return r;
	}
	public static ResJson error(Object list, String msg) {
		ResJson r = new ResJson();
		r.setResult("1");
		r.setMsg(msg);
		r.setResultNote(msg);
		r.setCode(1);
		r.setObjects(list);
		return r;
	}
	public static ResJson ZC(String zcState, String msg) {
		ResJson r = new ResJson();
		r.setResult("0");
		r.setZcState(zcState);
		r.setResultNote(msg);
		return r;
	}
	public static ResJson error( String msg) {
		ResJson r = new ResJson();
		r.setResult("1");
		r.setResultNote(msg);
		r.setMsg(msg);
		r.setResultNote("操作失败");
		return r;
	}



}
