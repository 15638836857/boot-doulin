package com.doulin.mobile.code;

import com.doulin.common.j2cache.CacheUtils;
import com.doulin.entity.common.ResJson;
import com.doulin.entity.common.SendSmsReq;
import com.doulin.service.UtilService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
@Service
public class CommonServiceCode{
	@Autowired
	private UtilService utilService;
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
//	@Autowired
//	private TuserService tuserService;
//	@Autowired
//	private TaskService taskService;
//	@Autowired
//	private DictTypeService dictTypeService;
//	@Autowired
//	private UserMoneyService usermoneyService;
//	@Autowired
//	private CommunityService communityService;
	
	/**
	 * 短信验证码验证
	 * 
	 * @param phone
	 * @param type
	 * @param code
	 * @return
	 */
//	public String codeBoolean(String phone, String codetype, String code, String ip) {
//		if(!Global.isDevelopMode()){
//			String randomCodes = (String) CacheUtils.get("code" + phone, codetype);
//			if(null != randomCodes && randomCodes.length()>0) {
//				String[] randomCode = randomCodes.split(",");
//				System.out.println(randomCode.toString());
//				Object obIp = CacheUtils.get("ip" + ip, codetype);
//				if (null != randomCode && obIp != null && Arrays.asList(randomCode).contains(code)==true && obIp.toString().equals(ip)) {// 验证码是否正确
//					Object obTime = CacheUtils.get("dateTime" + ip, codetype);
//					if (null != obTime) {
//						long beforeTime = Long.valueOf(obTime.toString());
//						long current = System.currentTimeMillis();
//						System.out.println((current - beforeTime) / (1000 * 60));
//						if ((current - beforeTime) / (1000 * 60) > 1) {// 验证码是否过期
//							return "2";
//						}
//					}
//					return "0";
//				}
//			}
//			return "1";
//		}else{
//			return "0";
//		}
//	}
//	/**
//	 * 相册标签数量
//	 * @param uid
//	 * @return
//	 */
//	public int getperfect(String uid) {
//		int num = 20;
//		Tuser user = tuserService.get(uid);
//		// 获取相册数量
//		List<Object> list1 = taskService
//				.executeSelectSql("select count(1) from t_comment_image where commentid='" + uid + "' and type=0");
//		num = num + (Integer.valueOf(list1.get(0).toString())) * 5;
//		// 获取标签数量
//		List<Object> list2 = taskService.executeSelectSql(
//				"SELECT COUNT(1) from ( select count(1) from t_label_user where uid='" + uid + "' GROUP BY typeid) s");
//		num = num + (Integer.valueOf(list2.get(0).toString())) * 5;
//		if (!StringUtils.isBlank(user.getAutograph())) {
//			num = num + 5;
//		}
//		if (!StringUtils.isBlank(user.getOccupation())) {
//			num = num + 5;
//		}
//		return num;
//	}
//	// 发送验证码
//	public void sendSms(String phone, String code) {
//		// 2.发送短信
//		String result = null;
//		String url = SmsCode.SENDURL;// 请求接口地址
//		Map<String, Object> params = new HashMap<String, Object>();// 请求参数
//
//		Map<String, Object> tplMap = new HashMap<String, Object>();
//		tplMap.put("#code#", code);
//		tplMap.put("#m#", 10);
//		String tplValue = SmsCode.urlencode(tplMap);
//
//		params.put("mobile", phone);// 接收短信的手机号码
//		params.put("tpl_id", "71495");// 短信模板ID，请参考个人中心短信模板设置
//		params.put("tpl_value", tplValue);// 变量名和变量值对。如果你的变量名或者变量值中带有#&amp;=中的任意一个特殊符号，请先分别进行urlencode编码后再传递，&lt;a
//											// href=&quot;http://www.juhe.cn/news/index/id/50&quot;
//											// target=&quot;_blank&quot;&gt;详细说明&gt;&lt;/a&gt;
//		params.put("key", SmsCode.APPKEY);// 应用APPKEY(应用详细页查询)
//		params.put("dtype", "json");// 返回数据的格式,xml或json，默认json
//
//		try {
//			result = SmsCode.net(url, params, "GET");
//			net.sf.json.JSONObject object = net.sf.json.JSONObject.fromObject(result);
//			if (object.getInt("error_code") == 0) {
//				logger.info(object.getString("result"));
//			} else {
//				logger.error(object.get("error_code") + ":" + object.get("reason"));
//			}
//		} catch (Exception e) {
//			logger.error("发送短信失败!\n" + e);
//			logger.error("请求处理异常：14882" );
//			e.printStackTrace();
//		}
//	}
	/**
	 * 发送验证码
	 * 
	 * @param req
	 * @return
	 */
	public ResJson sendSMSCode(SendSmsReq req, HttpServletRequest request) {
		ResJson res = new ResJson();
		res.setResultNote("验证码获取失败");
		if (StringUtils.isBlank(req.getPhone())) {
			res.setResultNote("手机号不可为空");
			return res;
		}

		if (StringUtils.isBlank(req.getCodeType())) {
			res.setResultNote("验证码类型不能为空");
			return res;
		}

		try {
			String ip = request.getRemoteAddr();
			Long dateTime = System.currentTimeMillis();// 获取服务器的时间

			String randomCodes = String.valueOf( CacheUtils.get("code" + req.getPhone(),req.getCodeType()));
			if(null != randomCodes && randomCodes.length()>0) {
				String[] randomCode = randomCodes.split(",");
				if(randomCode.length>0&&!"null".equals(randomCode[0])) {
					res.setResult("0");
					res.setResultNote("验证码已发送，敬请耐心等待");
					return res;
				}
			}else {
				utilService.shortMassge(req.getPhone(), req.getCodeType(), ip);
				res.setResult("0");
				res.setResultNote("验证码获取成功");
			}
			
		} catch (Exception e) {
			logger.error("请求处理异常：184" +e.getMessage());
		}

		return res;
	}

//	public String selectDictTypeValue(String dict) {
//		DictType dictType = new DictType();
//		dictType.setType(dict);
//		List<DictType> dictList = dictTypeService.findList(dictType);
//		List<Object> dictValue = dictTypeService.executeSelectSql(
//				"SELECT VALUE FROM sys_dict_value WHERE dict_type_id = '" + dictList.get(0).getId() + "'");
//		if (dictList != null && dictList.size()>0) {
//			return dictValue.get(0).toString();
//		}
//		return "";
//	}
//
//	public List<Date> findDates(Date dBegin, Date dEnd) {
//		List<Date> lDate = new ArrayList<Date>();
//		lDate.add(dBegin);
//		Calendar calBegin = Calendar.getInstance();
//		// 使用给定的 Date 设置此 Calendar 的时间
//		calBegin.setTime(dBegin);
//		Calendar calEnd = Calendar.getInstance();
//		// 使用给定的 Date 设置此 Calendar 的时间
//		calEnd.setTime(dEnd);
//		// 测试此日期是否在指定日期之后
//		while (dEnd.after(calBegin.getTime())) {
//			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
//			calBegin.add(Calendar.DAY_OF_MONTH, 1);
//			lDate.add(calBegin.getTime());
//		}
//		return lDate;
//	}
//
//	public boolean validateBalance(Tuser user,String type)throws Exception{
//		UserMoney um = new UserMoney();
//		um.setUid(user.getId());
//		um = usermoneyService.getLastInfo(um);
//		if(null == um){
//			if("0".equals(type)){//个人
//				user.setBalance(Double.valueOf(0));
//				tuserService.updateBalance(user);
//				return true;
//			}else if("1".equals(type)){//商家
//				tuserService.executeUpdateSql("UPDATE t_community SET balance = 0 WHERE id='"+user.getId()+"'");
//				return true;
//			}else if("2".equals(type)){//逗盟异业
//				tuserService.executeUpdateSql("UPDATE t_community_shop SET balance = 0 WHERE id='"+user.getId()+"'");
//				return true;
//			}
//		}
//		String sign = um.getSign();
//		if(StringUtils.isBlank(sign)){
//			if(null==user.getBalance() || user.getBalance()==0){
//				return true;
//			}else{
//				return false;
//			}
//		}
//		sign = new String(AESUtils.decryptAES(Base64Utils.base642Byte(sign), AESUtils.loadKeyAES(KeyUtil.AES_KEY), AESUtils.loadIvAES(KeyUtil.AES_KEY)));
//		if(StringUtils.isNotBlank(sign)&&(new BigDecimal(user.getBalance())).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(new BigDecimal(sign))==0){
//			return true;
//		}
//		return false;
//	}
//	public void updateBalance(Tuser user,String type)throws Exception{
//		boolean flag = false;
//		UserMoney um = new UserMoney();
//		um.setUid(user.getId());
//		um = usermoneyService.getLastInfo(um);//最后的充值记录
//		if(null == um){
//			if("0".equals(type)){//个人
//				user.setBalance(Double.valueOf(0));
//				tuserService.updateBalance(user);
//				return;
//			}else if("1".equals(type)){//商家
//				tuserService.executeUpdateSql("UPDATE t_community SET balance = 0 WHERE id='"+user.getId()+"'");
//				return;
//			}else if("2".equals(type)){//逗盟异业
//				tuserService.executeUpdateSql("UPDATE t_community_shop SET balance = 0 WHERE id='"+user.getId()+"'");
//				return;
//			}
//		}
//		String sign = um.getSign();
//		if(StringUtils.isBlank(sign)){
//			um.setHtype("0");
//			um = usermoneyService.getLastInfo(um);//最后的充值有验签的数据
//			if(null == um){
//				if("0".equals(type)){//个人
//					user.setBalance(Double.valueOf(0));
//					tuserService.updateBalance(user);
//					return;
//				}else if("1".equals(type)){//商家
//					tuserService.executeUpdateSql("UPDATE t_community SET balance = 0 WHERE id='"+user.getId()+"'");
//					return;
//				}else if("2".equals(type)){//逗盟异业
//					tuserService.executeUpdateSql("UPDATE t_community_shop SET balance = 0 WHERE id='"+user.getId()+"'");
//					return;
//				}
//			}
//			sign = um.getSign();
//			flag = true;
//		}
//		if(StringUtils.isNotBlank(sign) && null!=user.getBalance() && user.getBalance()!=0){
//			sign = new String(AESUtils.decryptAES(Base64Utils.base642Byte(sign), AESUtils.loadKeyAES(KeyUtil.AES_KEY), AESUtils.loadIvAES(KeyUtil.AES_KEY)));
//			if(StringUtils.isNotBlank(sign) && (new BigDecimal(user.getBalance())).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(new BigDecimal(sign))!=0){
//				if("0".equals(type)){//个人
//					user.setBalance(Double.valueOf(sign));
//					tuserService.updateBalance(user);
//				}else if("1".equals(type)){//商家
//					tuserService.executeUpdateSql("UPDATE t_community SET balance = " + sign + " WHERE id='" + user.getId() + "'");
//				}else if("2".equals(type)){//逗盟异业
//					tuserService.executeUpdateSql("UPDATE t_community_shop SET balance = " + sign + " WHERE id='" + user.getId() + "'");
//				}
//				if(flag){//删除无效的充值记录
//					usermoneyService.executeUpdateSql("UPDATE t_user_money SET del_flag = '1' where uid='" + user.getId() + "' and adtime > '" + um.getAdtime() + "'");
//				}
//			}
//		}
//	}
//
//	/**
//	 * 验证版本号
//	 * @param request
//	 * @param ver
//	 * @return
//	 */
//	public boolean validateVersion(HttpServletRequest request,String ver){
//
//		String agent = request.getHeader("user-agent");
//		String version = "1.0.0";
//		if(agent.contains("Android")){
//			version = agent.substring(agent.indexOf(":")+1, agent.indexOf("/"));
//		}else if(agent.contains("iOS")){
//			version = agent.substring(agent.indexOf("/")+1, agent.indexOf(" "));
//		}
//		if(com.jeeplus.common.utils.StringUtils.compareVersion(version,ver)>=0){
//			return true;
//		}else{
//			return false;
//		}
//
//	}
//
//	public String shopRest(){
//		String comeOffWork = communityService.execSelectSqlString("SELECT curtime() >= '00:00:00' and curtime() <= '07:00:00'");
//		if (null !=comeOffWork && comeOffWork.length()>0 && "1".equals(comeOffWork)) {
//			return "凌晨0点至7点商家休息";
//		}else{
//			return "";
//		}
//	}
}
