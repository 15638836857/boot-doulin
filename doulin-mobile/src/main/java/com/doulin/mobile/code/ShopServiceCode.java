package com.doulin.mobile.code;

import cn.hutool.core.util.StrUtil;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.TUser;
import com.doulin.entity.common.ResJson;
import com.doulin.entity.common.UserLoginReq;
import com.doulin.entity.common.UserLoginRes;
import com.doulin.entity.shop.ShopApplicyStatus;
import com.doulin.service.TCommunnityTokenService;
import com.doulin.service.TShopHomeBaseInfoService;
import com.doulin.service.UtilService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
@Service
@Slf4j
public class ShopServiceCode{
	/**
	 * 项目路径
	 */
//	@Value("${filePath}")
//	protected String filePath;
	@Autowired
	private TCommunnityTokenService communnityTokenService;
	@Autowired
	private UtilService utilService;

//	@Autowired
//	private TuserService tuserService;
//	@Autowired
//	private CustomerService customerService;
//	@Autowired
//	private MsgService msgService;
//	@Autowired
//	private UserRechargeService userRechargeService;
//	@Autowired
//	private CommentService commentService;
//	@Autowired
//	private UserOrderService userOrderService;
//	@Autowired
//	private UserOrderlistService userOrderlistService;
//	@Autowired
//	private UserMoneyService usermoneyService;
//	@Autowired
//	private VersionService versionService;
	@Autowired
	private TShopHomeBaseInfoService shopHomeBaseInfoService;
//	@Autowired
//	private TaskService taskService;
//	@Autowired
//	private UserCardService userCardService;
//	@Autowired
//	private GoodsService goodsService;
//	@Autowired
//	private GoodsCommunityService goodsCommunityService;
//	@Autowired
//	private SupplementCarService supplementCarService;
//    @Autowired
//	private CommunityPriceService communityPriceService;
//	@Autowired
//	private ProcurementService procurementService;
//	@Autowired
//	private SystemService systemService;
//	@Autowired
//	private SystemConfigService systemConfig;
	@Autowired
	private CommonServiceCode csc;
//	@Autowired
//	private UserVisitorService us;
//	@Autowired
//	private GoodsCommunityMapper gm;


	/**
	 * 4.1商家登录
	 * 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public ResJson codec1(HttpServletRequest request, UserLoginReq req) throws Exception {
		UserLoginRes res = new UserLoginRes();
		res.setResultNote("登录失败");
		if (StringUtils.isBlank(req.getPhone())) {
			return UserLoginRes.error(SysContent.ERROR_PHONE);
		}
		boolean flag=(SysContent.INTGER_2.toString().equals(req.getLoginType()) || SysContent.INTGER_1.toString().equals(req.getLoginType()));
		//loginType 1,2
		if(StrUtil.isEmpty(req.getLoginType()) || !flag){
			return UserLoginRes.error(SysContent.ERROR_LOGIN_USERID);
		}
		if(SysContent.INTGER_2.toString().equals(req.getLoginType()) &&
				!req.getRandomCode().equals(utilService.getRandomCodesByPhone(req.getPhone(),req.getCodeType()))){
			return UserLoginRes.error(SysContent.ERROR_REDOMCODE);
		}

		TShopHomeBaseInfo c = shopHomeBaseInfoService.getInfoByLoginNo(req.getPhone());
		if (null == c ) {
			res.setObjects(new TShopHomeBaseInfo());
			res.setResultNote(SysContent.SHOP_NO);
			res.setZcState(ShopApplicyStatus.STATUS_6.getCode().toString());
			return res;
		}
		if (SysContent.INTGER_1.toString().equals(req.getLoginType())) {
			if (StringUtils.isBlank(req.getPassword())) {
				return UserLoginRes.error(SysContent.ERROR_PASSORD_EMPTY);
			} else {
				if (!req.getPassword().equals(c.getPassword())) {
					return UserLoginRes.error(SysContent.ERROR_ACCOUNT_OR_PASSWORD);
				}

			}
		}

		 if (SysContent.INTGER_1.equals(c.getStatus())) {
			return  UserLoginRes.error(SysContent.EORROR_ACCOUNT_DJ);
		} else {
			res=UserLoginRes.Ok(SysContent.LOGIN_SUCCESS,c.getId().toString(),c.getRyToken());

		}
		try {
			// 登录成功后修改token
			String token=utilService.getShopLoginSucessToken(request,req,res ,c);
			TUser user = new TUser();
			user.setId(c.getId());
			user.setPassword(c.getPassword());
			res.setToken(token);
			res.setObjects(c);
			res.setZcState(c.getApplyState().toString());
		} catch (Exception e) {
			log.error("请求处理异常：12234" + e.getMessage());
		}
		return res;
	}



//	/**
//	 * 4.2 商家忘记密码
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(FindUserPasswordReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("设置失败");
//		try {
//			if (StringUtils.isBlank(req.getPhone())) {
//				res.setResultNote("手机号不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getPassword())) {
//				res.setResultNote("密码不能为空");
//				return res;
//			}
//			Community c = communityService.findUniqueByProperty("loginname", req.getPhone());
//			if (null == c) {
//				res.setResultNote("该手机号不存在");
//			} else {
//				c.setPassword(req.getPassword());
//				communityService.update(c);
//				res.setResult("0");
//				res.setResultNote("设置成功");
//			}
//		} catch (Exception e) {
//			log.error("请求处理异常：12268" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.3 未完成订单
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(UserOrderListReq req) {
//		CompleteOrderRes res = new CompleteOrderRes();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("商户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserOrder userOrder = new UserOrder();
//			userOrder.setCommunityid(req.getUid());
//
//			if("2".equals(req.getActivityType())) {
//				userOrder.setDataScope(" and a.status in (2,3,4,5,6,7,8)");
//			}else {
//				if ("0".equals(req.getOrderType())) {
//					userOrder.setDataScope(" and a.ordertype in (0,2) and a.status in (2,3,4,5,6,7,8)");
//				} else {
//					userOrder.setDataScope(" and a.ordertype=1 and a.status in (2,3,4,5,6,7,8)");
//				}
//			}
//			userOrder.setActivityType(req.getActivityType());//活动类型
////			Page<UserOrder> page = new Page<UserOrder>();
////			page.setOrderBy("a.adtime desc");
////			page.setPageSize(-1);c
//			List<UserOrder> pageInfo = userOrderService.findList(userOrder);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<UserOrder> list = pageInfo;
//				if (null != list && list.size() > 0) {
//					for (UserOrder order : list) {
//						DecimalFormat df = new DecimalFormat("#0.00");
//						String allprice = df.format(order.getAllprice());
//						String payprice = df.format(order.getPayprice());
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("orderNum", order.getOrdernum());
//						map.put("orderType", order.getOrdertype());
//						map.put("oderAllPrice", allprice);
//						map.put("oderPayPrice", payprice);
//						map.put("orderState", order.getStatus());
//						map.put("adtime",
//								null != order.getAdtime()
//										? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(order.getAdtime())
//										: "");
//						map.put("userId", order.getUid());
//						map.put("userName", order.getUsername());
//						map.put("userPhone", order.getUserphone());
//						map.put("userAddress", order.getUsercity() + order.getUseraddress());
//						UserOrderlist userOrderlist = new UserOrderlist();
//						userOrderlist.setOrdernum(order.getOrdernum());
//						List<UserOrderlist> list2 = userOrderlistService.findList(userOrderlist);
//						List<Map<String, String>> goodsList = new ArrayList<Map<String, String>>();
//						if (null != list2 && list2.size() > 0) {
//							for (UserOrderlist uo : list2) {
//								Map<String, String> orderlistMap = new HashMap<String, String>();
//								orderlistMap.put("commodityid", uo.getGoodsid());
//								orderlistMap.put("commodityPic",
//										StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage()
//												: "");
//								orderlistMap.put("commodityTitle", uo.getGoodstitle());
//								orderlistMap.put("commodityDesc", uo.getGoodsdesc());
//								orderlistMap.put("commodityPrice", uo.getGoodsprice() + "");
//								orderlistMap.put("commodityBuyNum", uo.getGoodsnum() + "");
//								orderlistMap.put("goodsSpecification",StringUtils.isBlank(uo.getGoodsSpecification())?"":uo.getGoodsSpecification());
//								goodsList.add(orderlistMap);
//							}
//						}
//						map.put("orderCommodity", goodsList);
//						dataList.add(map);
//					}
//				}
//
//				if("2".equals(req.getActivityType())) {
//					List<Object> list1 = taskService
//							.executeSelectSql("select count(1) from t_user_order where communityid='" + req.getUid()
//									+ "' and ordertype in (0,2)  and status in (2,3,4,5,6,7,8)");
//					res.setFreshNum(list1.get(0).toString());
//					List<Object> list2 = taskService
//							.executeSelectSql("select count(1) from t_user_order where communityid='" + req.getUid()
//									+ "' and ordertype =1 and status in (2,3,4,5,6,7,8)");
//					res.setClothsNum(list2.get(0).toString());
//					res.setGroupNum(list.size()+"");
//				}else {
//					if ("0".equals(req.getOrderType())) {
//						res.setFreshNum(list.size() + "");
//						List<Object> list1 = taskService
//								.executeSelectSql("select count(1) from t_user_order where communityid='" + req.getUid()
//										+ "' and ordertype=1  and status in (2,3,4,5,6,7,8)");
//						res.setClothsNum(list1.get(0).toString());
//						List<Object> list2 = taskService
//								.executeSelectSql("select count(1) from t_user_order where communityid='" + req.getUid()
//										+ "' and activityType ='2' and status in (2,3,4,5,6,7,8)");
//						res.setGroupNum(list2.get(0).toString());
//					} else {
//						res.setClothsNum(list.size() + "");
//						List<Object> list1 = taskService
//								.executeSelectSql("select count(1) from t_user_order where communityid='" + req.getUid()
//										+ "' and ordertype in (0,2)  and status in (2,3,4,5,6,7,8)");
//						res.setFreshNum(list1.get(0).toString());
//						List<Object> list2 = taskService
//								.executeSelectSql("select count(1) from t_user_order where communityid='" + req.getUid()
//										+ "' and activityType ='2' and status in (2,3,4,5,6,7,8)");
//						res.setGroupNum(list2.get(0).toString());
//					}
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：12399" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.4 退款审核(8退款中)
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2(CancelUserOrderReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("订单状态异常 ");
//		String content = "";
//		String title = "";
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if ("9".equals(userOrder.getStatus())) {
//				res.setResultNote("订单已经退款成功！");
//				return res;
//			} else if (!"8".equals(userOrder.getStatus())) {
//				res.setResultNote("订单状态异常");
//				return res;
//			}else if("2".equals(userOrder.getIsaccount())){//已经结算
//				res.setResultNote("订单结算状态异常");
//				return res;
//			}
//			if ("0".equals(req.getType())) {// 同意
//				userOrder.setStatus("9");
//				title = "退款成功";
//				content = "您的订单：" + userOrder.getOrdernum() + "退款成功，资金已原路返回！";
//				Tuser user = tuserService.get(userOrder.getUid());
//				if ("0".equals(userOrder.getPaytype())) {// 零钱
//					// 退款
//					user.setBalance(user.getBalance() + userOrder.getPayprice());
//					tuserService.updateUser(user);
//					BigDecimal bd = new BigDecimal(userOrder.getPayprice());
//					double getMoney = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//					bd = new BigDecimal(user.getBalance());
//					double getBalance = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//					// 插入零钱明细
//					UserMoney sd = new UserMoney();
//					sd.setId(IdGen.uuid());
//					sd.setUid(userOrder.getUid());
//					sd.setTitle("退款");
//					sd.setMoney("+" + getMoney);
//					sd.setBalance(getBalance + "");
//					sd.setTransactionId(userOrder.getOrdernum());
//					sd.setSign(Base64Utils.byte2Base64(AESUtils.encryptAES((user.getBalance() + "").getBytes(), AESUtils.loadKeyAES(KeyUtil.AES_KEY), AESUtils.loadIvAES(KeyUtil.AES_KEY))));
//					sd.setType("0");
//					sd.setHtype("0");
//					sd.setAdtime(new Date());
//					usermoneyService.addUserMoney(sd);
//				} else {
//
//					if ("1".equals(userOrder.getPaytype())) {
//						AlipayClient alipayClient = new DefaultAlipayClient(AlipayCg.QUERYURL, AlipayCg.APPID,
//								AlipayCg.RSA_PRIVATE_KEY, AlipayCg.FORMAT, AlipayCg.CHARSET, AlipayCg.ALIPAY_PUBLIC_KEY,
//								AlipayCg.SIGNTYPE);
//						AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
//						SortedMap<String, String> aliMap = new TreeMap<String, String>();
//						aliMap.put("out_trade_no", userOrder.getOrdernum());
//						request.setBizContent(JsonMapper.toJsonString(aliMap));
//						AlipayTradeQueryResponse response = alipayClient.execute(request);
//						if (response.isSuccess() && response.getCode().equals("10000")) {
//							new AlipayConfig().refundAlipay(userOrder);
//						} else {
//							String ordernum = StringUtil.getOrderNo();// 退款单号
//							int mm = (int) Math.round(userOrder.getPayprice() * 100);
//							BeeCloud.registerApp("03feacbf-5f79-4f2c-83de-92910cc6e7b4",
//									"4d059a72-1d58-4294-8489-aeefb77a7c23", "78cb9f6f-2021-4e56-b66e-f9c6cbb31e0b",
//									"a95faa3a-cd9d-448c-b557-10869331979b");
//							Map<String, Object> pa = new HashMap<String, Object>();
//							pa.put("backordernum", ordernum);
//							BCRefund param = new BCRefund(userOrder.getOrdernum(), ordernum, mm);
//							param.setOptional(pa);// optional 可选业务参数
//							BCRefund refund = BCPay.startBCRefund(param);
//							if (refund.getAliRefundUrl() != null) {
//								// response.sendRedirect(refund.getAliRefundUrl());
//							} else {
//								// out.println("退款成功！易宝、百度、快钱渠道还需要定期查询退款结果！");
//								// out.println(refund.getObjectId());
//							}
//						}
//					} else if ("2".equals(userOrder.getPaytype())) {// 微信退款
//						Map<String, String> map = new HashMap<>();
//						List<Map<String, String>> param1 = new ArrayList<>();
//						map.put("appid", WXpayCg.APP_ID);
//						map.put("mch_id", WXpayCg.MCH_ID);// 商户id号
//						// 随机字符串==随机字符串，不长于32位
//						map.put("nonce_str", RandomStringUtils.randomAlphabetic(32));
//						// 商户订单号==商户系统内部的订单号,32个字符内、可包含字母
//						map.put("out_trade_no", req.getOrderNum());
//						map = MD5.sortMapByKey(map);// 排序
//						param1.add(map);
//						StringBuilder sb = new StringBuilder();
//						// 主动创建document对象.
//						Document document = DocumentHelper.createDocument();
//						Element root = document.addElement("xml");
//						for (int i = 0; i < param1.size(); i++) {
//							Map<String, String> pair = param1.get(i);
//							for (Entry<String, String> vo : pair.entrySet()) {
//								sb.append(vo.getKey()).append("=").append(vo.getValue()).append("&");
//								root.addElement(vo.getKey()).addText(vo.getValue());
//							}
//						}
//						sb.append("key=").append(WXpayCg.KEY);
//						// map.put("sign", DigestUtils.md5Hex(sb.toString()).toUpperCase());
//						root.addElement("sign").addText(DigestUtils.md5Hex(sb.toString()).toUpperCase());
//						// String aa = root.asXML();
//						String tenR = HttpPostXML.post(WXpayCg.QUERYURL, root.asXML());
//						Document doc = DocumentHelper.parseText(tenR);
//						Element root$ten = doc.getRootElement();
//						Element returnCode = root$ten.element("return_code");
//						if (returnCode.getText().equals("SUCCESS")) {
//							WXConfig.wxRefundPay(userOrder);
//						} else if (returnCode.getText().equals("FAIL")) {
//							String ordernum = StringUtil.getOrderNo();// 退款单号
//							int mm = (int) Math.round(userOrder.getPayprice() * 100);
//							BeeCloud.registerApp("03feacbf-5f79-4f2c-83de-92910cc6e7b4",
//									"4d059a72-1d58-4294-8489-aeefb77a7c23", "78cb9f6f-2021-4e56-b66e-f9c6cbb31e0b",
//									"a95faa3a-cd9d-448c-b557-10869331979b");
//							Map<String, Object> pa = new HashMap<String, Object>();
//							pa.put("backordernum", ordernum);
//							BCRefund param = new BCRefund(userOrder.getOrdernum(), ordernum, mm);
//							param.setOptional(pa);// optional 可选业务参数
//							BCRefund refund = BCPay.startBCRefund(param);
//							if (refund.getAliRefundUrl() != null) {
//								// response.sendRedirect(refund.getAliRefundUrl());
//							} else {
//								// out.println("退款成功！易宝、百度、快钱渠道还需要定期查询退款结果！");
//								// out.println(refund.getObjectId());
//							}
//						}
//					}
//				}
//			} else {
//				userOrder.setStatus(userOrder.getState());
//				title = "退款拒绝";
//				content = "您的订单：" + userOrder.getOrdernum() + "退款被拒绝，您可重新提交或联系客服！";
//			}
//			userOrder.setRefundshentime(new Date());
//			userOrder.setUpdatetime(new Date());
//			userOrderService.update(userOrder);
//			try {// 给用户推送
//				Tuser u = tuserService.get(userOrder.getUid());
//
//				if (u.getToken() != null && !"".equals(u.getToken())) {
//					PushResult result = new PushExample().registerTitle(title, content, u.getToken(),null);
//					 System.out.println("p===" + result);
//				}
//				// 库存退回,销量减去
//				List<UserOrderlist> list1 = userOrder.getUserOrderlist();
//				if (list1 != null && list1.size() > 0) {
//					for (UserOrderlist od : list1) {
//						GoodsCommunity g = goodsCommunityService.getGoodsStock(userOrder.getCommunityid(),
//								od.getGoodsid());
//						if (!"1".equals(g.getType())) {
//							g.setStock(g.getStock() + od.getGoodsnum());
//						}
//						g.setSallnum(g.getSallnum() - od.getGoodsnum());
//						goodsCommunityService.save(g);
//					}
//				}
//				Msg m = new Msg();
//				m.setId(IdGen.uuid());
//				m.setType("1");
//				m.setHtype("1");
//				m.setUid(u.getId());
//				m.setTitle(title);
//				m.setContent(content);
//				m.setUrl(userOrder.getOrdernum());
//				m.setStatus("");
//				m.setAdtime(new Date());
//				msgService.addMsg(m);
//			} catch (Exception e) {
//				log.error("请求处理异常：590" );
//				e.printStackTrace();
//			}
//			res.setOrderState(userOrder.getState());
//			res.setResult("0");
//			res.setResultNote("退款审核成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：597" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.41 退款审核(8退款中)，商家端是否同意退款
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2Refund(CancelUserOrderReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("订单状态异常 ");
//		String content = "";
//		String title = "";
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if (!"8".equals(userOrder.getStatus())) {
//				res.setResultNote("订单状态异常");
//				return res;
//			}
//			if ("0".equals(req.getType())) {// 同意
//				userOrder.setStatus("9");
//				title = "退款成功";
//				content = "您的订单：" + userOrder.getOrdernum() + "退款成功，资金已原路返回！";
//				Tuser user = tuserService.get(userOrder.getUid());
//				if ("0".equals(userOrder.getPaytype())) {// 零钱
//					// 退款
//					user.setBalance(user.getBalance() + userOrder.getPayprice());
//					tuserService.updateUser(user);
//					BigDecimal bd = new BigDecimal(userOrder.getPayprice());
//					double getMoney = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//					bd = new BigDecimal(user.getBalance());
//					double getBalance = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//					// 插入零钱明细
//					UserMoney sd = new UserMoney();
//					sd.setId(IdGen.uuid());
//					sd.setUid(userOrder.getUid());
//					sd.setTitle("退款");
//					sd.setMoney("+" + getMoney);
//					sd.setBalance(getBalance + "");
//					sd.setTransactionId(userOrder.getOrdernum());
//					sd.setSign(Base64Utils.byte2Base64(AESUtils.encryptAES((user.getBalance() + "").getBytes(), AESUtils.loadKeyAES(KeyUtil.AES_KEY), AESUtils.loadIvAES(KeyUtil.AES_KEY))));
//					sd.setType("0");
//					sd.setHtype("0");
//					sd.setAdtime(new Date());
//					usermoneyService.addUserMoney(sd);
//				} else {
//					if ("1".equals(userOrder.getPaytype())) {
//						new AlipayConfig().refundAlipay(userOrder);
//
//					} else if ("2".equals(userOrder.getPaytype())) {// 微信退款
//						WXConfig.wxRefundPay(userOrder);
//					}
//				}
//			} else {
//				userOrder.setStatus(userOrder.getState());
//				title = "退款拒绝";
//				content = "您的订单：" + userOrder.getOrdernum() + "退款被拒绝，您可重新提交或联系客服！";
//			}
//			userOrder.setRefundshentime(new Date());
//			userOrder.setUpdatetime(new Date());
//			userOrderService.update(userOrder);
//			try {// 给用户推送
//				Tuser u = tuserService.get(userOrder.getUid());
//
//				if (u.getToken() != null && !"".equals(u.getToken())) {
//					PushResult result = new PushExample().registerTitle(title, content, u.getToken(),null);
//					 System.out.println("p===" + result);
//				}
//				// 库存退回,销量减去
//				List<UserOrderlist> list1 = userOrder.getUserOrderlist();
//				if (list1 != null && list1.size() > 0) {
//					for (UserOrderlist od : list1) {
//						GoodsCommunity g = goodsCommunityService.getGoodsStock(userOrder.getCommunityid(),
//								od.getGoodsid());
//						if (!"1".equals(g.getType())) {
//							g.setStock(g.getStock() + od.getGoodsnum());
//						}
//						g.setSallnum(g.getSallnum() - od.getGoodsnum());
//						goodsCommunityService.save(g);
//					}
//				}
//				Msg m = new Msg();
//				m.setId(IdGen.uuid());
//				m.setType("1");
//				m.setHtype("1");
//				m.setUid(u.getId());
//				m.setTitle(title);
//				m.setContent(content);
//				m.setUrl(userOrder.getOrdernum());
//				m.setStatus("");
//				m.setAdtime(new Date());
//				msgService.addMsg(m);
//			} catch (Exception e) {
//				log.error("请求处理异常：714" );
//				e.printStackTrace();
//			}
//			res.setOrderState(userOrder.getState());
//			res.setResult("0");
//			res.setResultNote("退款审核成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：721" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.5 确认发货/确认上门(2待送货4待取货)
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec3(CancelUserOrderReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("操作失败");
//		String content = "";
//		String title = "";
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if (!"2".equals(userOrder.getStatus()) && !"4".equals(userOrder.getStatus())) {
//				// res.setResultNote("订单状态异常");
//				res.setResultNote("订单已修改");
//				res.setResult("0");
//				return res;
//			} else if ("8".equals(userOrder.getStatus())) {
//				res.setResultNote("用户已提交退款申请，请稍后操作");
//				return res;
//			}
//			if ("0".equals(req.getType())) {// 发货
//				userOrder.setStatus("3");
//				userOrder.setSendtime(new Date());
//				content = "您的订单已经发货,订单号为：" + userOrder.getOrdernum() + ",快去看看吧！";
//				title = "订单发货";
//				res.setResultNote("发货成功");
//			} else {// 取货
//				userOrder.setStatus("5");
//				userOrder.setGettime(new Date());
//				content = "您的订单已完成取件,订单号为：" + userOrder.getOrdernum() + ",快去看看吧！";
//				title = "订单取件";
//				res.setResultNote("取件成功");
//			}
//			userOrder.setUpdatetime(new Date());
//			userOrderService.update(userOrder);
//			try {// 给用户推送
//				Tuser u = tuserService.get(userOrder.getUid());
//				if (u.getToken() != null && !"".equals(u.getToken())) {
//					PushResult result = new PushExample().registerTitle(title, content, u.getToken(),null);
//					 System.out.println("p===" + result);
//				}
//				Msg m = new Msg();
//				m.setId(IdGen.uuid());
//				m.setType("1");
//				m.setHtype("1");
//				m.setUid(u.getId());
//				m.setTitle(title);
//				m.setContent(content);
//				m.setUrl(userOrder.getOrdernum());
//				m.setStatus("");
//				m.setAdtime(new Date());
//				msgService.addMsg(m);
//			} catch (Exception e) {
//				log.error("请求处理异常：12809" );
//				e.printStackTrace();
//			}
//			res.setResult("0");
//
//		} catch (Exception e) {
//			log.error("请求处理异常：12815" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.6 清洗完成(5清洗中)
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec4(CancelUserOrderReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("操作失败");
//		String content = "";
//		String title = "";
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if (!"5".equals(userOrder.getStatus())) {
//				res.setResultNote("订单状态异常");
//				return res;
//			}
//			// userOrder.setStatus("7");
//			userOrder.setStatus("6");
//			userOrder.setCleantime(new Date());
//			userOrder.setUpdatetime(new Date());
//			userOrderService.update(userOrder);
//			content = "您的订单已经清洗完成,订单号为：" + userOrder.getOrdernum() + ",快去看看吧！";
//			title = "清洗完成";
//			try {// 给用户推送
//				Tuser u = tuserService.get(userOrder.getUid());
//				if (u.getToken() != null && !"".equals(u.getToken())) {
//					PushResult result = new PushExample().registerTitle(title, content, u.getToken(),null);
//					 System.out.println("p===" + result);
//				}
//				Msg m = new Msg();
//				m.setId(IdGen.uuid());
//				m.setType("1");
//				m.setHtype("1");
//				m.setUid(u.getId());
//				m.setTitle(title);
//				m.setContent(content);
//				m.setUrl(userOrder.getOrdernum());
//				m.setStatus("");
//				m.setAdtime(new Date());
//				msgService.addMsg(m);
//			} catch (Exception e) {
//				log.error("请求处理异常：12883" );
//				e.printStackTrace();
//			}
//			res.setResult("0");
//			res.setResultNote("操作成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：12889" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.61清洗完成(5清洗中) 1.03本版
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec41(CancelUserOrderReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("操作失败");
//		String content = "";
//		String title = "";
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if (!"5".equals(userOrder.getStatus())) {
//				res.setResultNote("订单状态异常");
//				return res;
//			}
//			userOrder.setStatus("6");
//			userOrder.setCleantime(new Date());
//			userOrder.setUpdatetime(new Date());
//			userOrderService.update(userOrder);
//			content = "您的订单已经清洗完成,订单号为：" + userOrder.getOrdernum() + ",快去看看吧！";
//			title = "清洗完成";
//			try {// 给用户推送
//				Tuser u = tuserService.get(userOrder.getUid());
//				if (u.getToken() != null && !"".equals(u.getToken())) {
//					PushResult result = new PushExample().registerTitle(title, content, u.getToken(),null);
//					System.out.println("p===" + result);
//				}
//				Msg m = new Msg();
//				m.setId(IdGen.uuid());
//				m.setType("1");
//				m.setHtype("1");
//				m.setUid(u.getId());
//				m.setTitle(title);
//				m.setContent(content);
//				m.setUrl(userOrder.getOrdernum());
//				m.setStatus("");
//				m.setAdtime(new Date());
//				msgService.addMsg(m);
//			} catch (Exception e) {
//				log.error("请求处理异常：12956" );
//				e.printStackTrace();
//			}
//			res.setResult("0");
//			res.setResultNote("操作成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：12962" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.7 查询分类下商品
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec23(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			String type = "0";
//			if ("0".equals(req.getType())) {
//				type = "2";
//			} else if ("1".equals(req.getType())) {
//				type = "1";
//			} else {
//				type = "0";
//			}
//
//			String sql = null;
//			String sqlSum = null;
//			if ("-1".equals(req.getType())) {
//				sql = "SELECT g.id as 'goodsId', g.title as 'goodsName', g.goodsdesc as 'goodsdesc', CONCAT('"
//						+ filePath + "',g.image) as 'goodsImg', IFNULL(c.price,g.price) as 'goodsPrice',"
//						+ "	IFNULL(p.goodscuprice,g.cuprice) as 'goodsCuprice',g.specification as 'goodsSpecification',g.type as 'goodsType',IFNULL(c.shelves,'1') as 'goodState',"
//						+ "	IFNULL(c.sallnum,0) as 'goodsSallnum',  IF(g.type=1,0,IFNULL(c.stock,0)) as 'goodsStock',IFNULL(al.activityType,0) AS 'activityType' ,g.flag AS 'priceFlag'"
//						+ " FROM t_goods g LEFT JOIN t_goods_community c on c.goodsid = g.id AND c.communityid = '"
//						+ req.getUid() + "' "
//						+ " LEFT JOIN t_goods_community_price p on p.goodsid = g.id and p.communityid = c.communityid and now()>p.startdate and p.enddate>NOW() AND p.state='2'"
//						+ " LEFT JOIN t_goods_activity_list al ON c.goodsid = al.goodsid AND c.communityid = al.communityid AND al.state='0' WHERE g.state = 0";
//				sqlSum = "select COUNT(g.id) from t_goods g where g.state=0 ";
//			} else {
//				sql = "SELECT g.id as 'goodsId', g.title as 'goodsName', g.goodsdesc as 'goodsdesc', CONCAT('"
//						+ filePath + "',g.image) as 'goodsImg',	IFNULL(c.price,g.price) as 'goodsPrice',"
//						+ "	IFNULL(p.goodscuprice,g.cuprice) as 'goodsCuprice',g.specification as 'goodsSpecification',g.type as 'goodsType',IFNULL(c.shelves,'1') as 'goodState',"
//						+ "	IFNULL(c.sallnum,0) as 'goodsSallnum',  IF(g.type=1,0,IFNULL(c.stock,0)) as 'goodsStock',IFNULL(al.activityType,0) AS 'activityType' ,g.flag AS 'priceFlag'"
//						+ " FROM t_goods g LEFT JOIN t_goods_community c on c.goodsid = g.id AND c.communityid = '"
//						+ req.getUid() + "' "
//						+ " LEFT JOIN t_goods_community_price p on p.goodsid = g.id and p.communityid = c.communityid and now()>p.startdate and p.enddate>NOW() AND p.state='2'"
//						+ " LEFT JOIN t_goods_activity_list al ON c.goodsid = al.goodsid AND c.communityid = al.communityid AND al.state='0' WHERE g.state = 0  AND g.type=" + type;
//				sqlSum = "select COUNT(g.id) from t_goods g where g.state=0 and g.type=" + type;
//			}
//			if (!StringUtils.isBlank(req.getCategoryId())) {
//				sql += " and g.categoryid='" + req.getCategoryId() + "'";
//				sqlSum += " and g.categoryid='" + req.getCategoryId() + "'";
//			}
//			if ("1".equals(req.getState()) && !"1".equals(req.getType())) {// 已添加商品
//				sql += " and (SELECT COUNT(1) from t_goods_community c where c.goodsid=g.id and c.communityid='"
//						+ req.getUid() + "' and c.shelves = '0')=1 ";
//				sqlSum += " and (SELECT COUNT(1) from t_goods_community c where c.goodsid=g.id and c.communityid='"
//						+ req.getUid() + "' and c.shelves = '0')=1 ";
//			} else if ("2".equals(req.getState()) && !"1".equals(req.getType())) {// 未添加商品
//				sql += " and (SELECT COUNT(1) from t_goods_community c where c.goodsid=g.id and c.communityid='"
//						+ req.getUid() + "' and c.shelves = '0')=0 ";
//				sqlSum += " and (SELECT COUNT(1) from t_goods_community c where c.goodsid=g.id and c.communityid='"
//						+ req.getUid() + "' and c.shelves = '0')=0 ";
//			} else if ("3".equals(req.getState())) {// 本周上新
//				sql += " and g.adtime>DATE(DATE_ADD(CURDATE(),INTERVAL -7 DAY))";
//				sqlSum += " and g.adtime>DATE(DATE_ADD(CURDATE(),INTERVAL -7 DAY))";
//			}
//			if (!StringUtils.isBlank(req.getContent())) {
//
//				String searchKey1 = "";
//				List<Keyword> kwl = systemConfig.getKeyword();
//				Set<String> dict = Sets.newHashSet();
//				for(Keyword kw:kwl){
//					dict.add(kw.getKeyword());
//				}
//				searchKey1 = MMSegmentUtils.getKeyword(dict,req.getContent());
//
//				String searchKey = Chinese2PYUtils.getStringPinYin(req.getContent());
//				sql += " and  MATCH (keyword, pinyin) AGAINST ('" + searchKey1 + "' IN BOOLEAN MODE)"
//						+ " ORDER BY  g.title like '%"+req.getContent()+"%' desc, g.pinyin like '%" + searchKey + "%' desc, MATCH (keyword, pinyin) AGAINST ('"
//						+ searchKey + "') desc";
//				sqlSum += " and MATCH (keyword, pinyin) AGAINST ('" + searchKey1 + "' IN BOOLEAN MODE)";
//			}
//			List<Object> listCount = goodsCommunityService.executeSelectSql(sqlSum);
//			Integer totalPages = 0;
//			if (null != listCount && listCount.size() > 0) {
//				totalPages = Integer.valueOf(listCount.get(0).toString());
//			}
//			Integer totalPage = 0;
//			Integer nowPage  = 0;
//			if(StringUtils.isBlank(req.getPageCount()+"")) {
//				if (totalPages % 15 != 0) {
//					totalPage = totalPages / 15 + 1;
//				} else {
//					totalPage = totalPages / 15;
//				}
//			}else {
//				if (totalPages % req.getPageCount() != 0) {
//					totalPage = totalPages / req.getPageCount() + 1;
//				} else {
//					totalPage = totalPages / req.getPageCount();
//				}
//				 nowPage = (req.getNowPage() - 1) * req.getPageCount();
//			}
//
//			sql += " LIMIT " + nowPage + "," + req.getPageCount();
//			List<Map<String, String>> list = goodsCommunityService.execSelectSqlMap(sql);
//			sql = "select count(1) from t_goods where type=0 and state=0 and  adtime>DATE(DATE_ADD(CURDATE(),INTERVAL -7 DAY))";
//			List<Object> list1 = goodsCommunityService.executeSelectSql(sql);
//			sql = "select count(1) from t_goods where type=1 and state=0 and adtime>DATE(DATE_ADD(CURDATE(),INTERVAL -7 DAY))";
//			List<Object> list2 = goodsCommunityService.executeSelectSql(sql);
//			sql = "select count(1) from t_goods where type=2 and state=0 and adtime>DATE(DATE_ADD(CURDATE(),INTERVAL -7 DAY))";
//			List<Object> list3 = goodsCommunityService.executeSelectSql(sql);
//			res.setNewnum(list3.get(0).toString());
//			res.setClothesnum(list2.get(0).toString());
//			res.setSupernum(list1.get(0).toString());
//			// res.setDataList(dataList);
//			res.setDataList(list);
//			res.setTotalPage(totalPage);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：13078" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.7 查询分类下商品
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec23New(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//
//			String type = "0";
//			if ("0".equals(req.getType())) {
//				type = "2";
//			} else if ("2".equals(req.getType())) {
//				type = "0";
//			} else {
//				type = req.getType();
//			}
//
//			GoodsCommunity2 gc = new GoodsCommunity2();
//			gc.setFilePath(filePath);
//			gc.setGoodsType(type);
//			gc.setCommunityid(req.getUid());
//			gc.setCategoryid(req.getCategoryId());
//			gc.setGoodsState(req.getState());
//			if(null!=req.getContent()&&!"".equals(req.getContent())){
//				String searchKey = Chinese2PYUtils.getStringPinYin(req.getContent());
//				gc.setGoodsName(searchKey);
//				gc.setGoodsdesc(req.getContent());
//			}
//			Page<GoodsCommunity2> page = new Page<GoodsCommunity2>();
//			page.setPageNo(req.getNowPage());
//			page.setPageSize(req.getPageCount());
//			Page<GoodsCommunity2> pagelist = goodsCommunityService.findShopCategoryGoods(page,gc);
//			List<Map<String,Object>> dataList = Lists.newArrayList();
//			for(int i=0;i<pagelist.getList().size();i++){
//				GoodsCommunity2 gc2 = pagelist.getList().get(i);
//				Map<String,Object> map = Maps.newHashMap();
//				map.put("goodsId", gc2.getGoodsId());
//				map.put("goodsName", gc2.getGoodsName());
//				map.put("goodsdesc", gc2.getGoodsdesc());
//				map.put("goodsImg", gc2.getGoodsImg());
//				map.put("goodsPrice", gc2.getGoodsPrice());
//				map.put("goodsCuprice", gc2.getGoodsCuprice());
//				map.put("goodsSpecification", gc2.getGoodsSpecification());
//				map.put("goodState", gc2.getGoodsState());
//				map.put("goodsSallnum", gc2.getGoodsSallnum());
//				map.put("goodsStock", gc2.getGoodsStock());
//				map.put("activityType", gc2.getActivityType());
//				map.put("priceFlag", gc2.getPriceFlag());
//				map.put("shopManager", gc2.getShopManager());
//				if(Integer.valueOf(gc2.getIds())>1){
//					GoodsCommunity gcc = new GoodsCommunity();
//					gcc.setCommunityid(req.getUid());
//					gcc.setUnifierid(gc2.getGoodsId());
//					gcc.setFilePath(filePath);
//					List<Map<String,String>> goods = goodsCommunityService.findGoodsListByUnState(gcc);
//					map.put("subGoods",goods);
//				}
//				dataList.add(map);
//			}
//			String sql = "SELECT IFNULL(SUM(IF(type=0,1,0)),0) as supernum,IFNULL(SUM(IF(type=1,1,0)),0) as clothesnum,IFNULL(SUM(IF(type=2,1,0)),0) as newnum from t_goods where state=0 and adtime>DATE(DATE_ADD(CURDATE(),INTERVAL -7 DAY))";
//			Map<String,Object> map = goodsCommunityService.execSelectSqlEntityObjMap(sql);
//			res.setSupernum(map.get("supernum").toString());
//			res.setClothesnum(map.get("clothesnum").toString());
//			res.setNewnum(map.get("newnum").toString());
//			res.setDataList(dataList);
//			res.setTotalPage(pagelist.getTotalPage());
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：14141" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 店长推荐
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson shopManagerrecommended (AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("修改推荐失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if(StringUtils.isBlank(req.getGoodsId())) {
//				res.setResultNote("商品id不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//
//			if ("1".equals(req.getSelectType())) {//添加店长推荐
//				communityService.executeUpdateSql("UPDATE t_goods_community c,t_goods g SET shopManager='1' WHERE c.goodsid=g.id AND c.communityid='"+c.getId()+"' "
//						+ "AND (g.id='"+req.getGoodsId()+"' OR g.unifierid='"+req.getGoodsId()+"')");
//			} else {//取消店长推荐
//				communityService.executeUpdateSql("UPDATE t_goods_community c,t_goods g SET shopManager=null WHERE c.goodsid=g.id AND c.communityid='"+c.getId()+"' "
//						+ "AND (g.id='"+req.getGoodsId()+"' OR g.unifierid='"+req.getGoodsId()+"')");
//			}
//			res.setResult("0");
//			res.setResultNote("修改推荐成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：商家端修改库存1209" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 修改库存
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson updateModifyInventory(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("修改库存失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			if (null == req.getCount()) {
//				res.setResultNote("库存数量不能为空");
//				return res;
//			}
//			// 查询是否已经有该商品
//			GoodsCommunity gc = goodsCommunityService.gets(req.getUid(), req.getGoodsId());
//			if (gc != null && gc.getId().length() > 0) {
//				if (req.getCount() > 0) {
//					goodsCommunityService.executeUpdateSql("UPDATE t_goods_community g SET g.stock='"+req.getCount()+"',g.shelves='0' "
//							+ "WHERE g.goodsid='" + req.getGoodsId() + "' and g.communityid = '"+req.getUid()+"'");
//				}else {
//					if(req.getCount()==0) {
//						goodsCommunityService.executeUpdateSql("UPDATE t_goods_community g SET g.stock='"+req.getCount()+"', g.shelves='1' "
//								+ "WHERE g.goodsid='" + req.getGoodsId() + "' and g.communityid = '"+req.getUid()+"'");
//					}else {
//						res.setResultNote("提交的数量不规范，请重新输入");
//						return res;
//					}
//				}
//			} else {
//				gc = new GoodsCommunity();
//				gc.setCommunityid(req.getUid());
//				gc.setGoodsid(req.getGoodsId());
//				if (req.getCount() <= 0) {
//					gc.setStock(0);
//				} else {
//					gc.setStock(req.getCount());
//				}
//				gc.setSallnum(0);
//				gc.setState("0");
//				gc.setAdtime(new Date());
//				goodsCommunityService.save(gc);
//			}
//
//		/*	String sallnum = goodsCommunityService.execSelectSqlString("SELECT IFNULL(gc.sallnum,0)+IFNULL(gs.sallnum,0) AS sallnum FROM t_goods_community gc LEFT JOIN t_goods_community_sallnum gs ON gc.communityid = gs.communityid AND gc.goodsid = gs.goodsid "
//					+ "WHERE gc.communityid = '"+req.getUid()+"' AND gc.goodsid = '"+sc.getGoodsid()+"'");
//			if(null !=sallnum && "0".equals(sallnum)) {
//				String goodsSallnum = goodsCommunityService.execSelectSqlString("SELECT * FROM t_goods_community_sallnum WHERE communityid ='"+req.getUid()+"' AND goodsid='"+sc.getGoodsid()+"'");
//				if(null !=goodsSallnum && goodsSallnum.length()>0) {
//					goodsCommunityService.execSelectSqlString("UPDATE t_goods_community_sallnum SET sallnum=FLOOR(10+(RAND() * 20)) WHERE communityid ='"+req.getUid()+"' AND goodsid='"+sc.getGoodsid()+"'");
//				}else {
//					goodsCommunityService.executeInsertSql("INSERT INTO t_goods_community_sallnum VALUES('"+IdGen.uuid()+"',FLOOR(10+(RAND() * 20)),'"+req.getUid()+"','"+sc.getGoodsid()+"',NOW())");
//				}
//			}*/
//			res.setResult("0");
//			res.setResultNote("修改库存成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：商家端修改库存1281" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 商家端设置秒杀商品
//	 * @param req
//	 * @return
//	 */
//	public ResJson merchantSetSeckillGoods(GetApprovalOfPriceReq req) {
//	  ResJson res = new ResJson();
//	  res.setResultNote("设置失败");
//	  if(StringUtils.isBlank(req.getGoodsId())) {
//		  res.setResultNote("商品id为空");
//		  return res;
//	  }
//	  if(StringUtils.isBlank(req.getCommunityId())) {
//		  res.setResultNote("社区id为空");
//		  return res;
//	  }
//
//	  String id = goodsCommunityService.execSelectSqlString("SELECT id FROM t_goods_activity_list WHERE communityid='"+req.getCommunityId()+"' AND goodsid='"+req.getGoodsId()+"'");
//	  if(null != id && !"".equals(id)) {
//		  goodsCommunityService.execUpdateValueSql("UPDATE t_goods_activity_list SET enddate='',state='0' WHERE id='"+id+"'");
//	  }else {
//		  goodsCommunityService.executeInsertSql("INSERT INTO t_goods_activity_list(id,communityid,goodsid,copygoodsid,activityid,activityType,endtime,state,adtime)VALUES(" +
//		  		"'"+IdGen.uuid()+"','"+req.getCommunityId()+"','"+req.getGoodsId()+"','"+req.getGoodsId()+"',(SELECT id FROM t_goods_activity WHERE type='1'),'1','"+req.getEndTime()+"','0',NOW()" +
//		  		")");
//	  }
//	  res.setResult("0");
//	  res.setResultNote("设置成功");
//	  return res;
//  }
//
//  /**
//    * 删除采购商品
//    * @param req
//    * @return
//    */
//	public ResJson deleteProcurementGoods(GetProcurementGoodsReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("删除失败");
//		if(StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区id为空");
//			return res;
//		}
//		if(StringUtils.isBlank(req.getGoodsName())) {
//			res.setResultNote("商品名为空");
//			return res;
//		}
//
//		try {
//			if(StringUtils.isBlank(req.getGoodsId())) {
//
//			}else {
//			  procurementService.executeDeleteSql("DELETE FROM t_procurement_list WHERE communityid='"+req.getCommunityId()+"' "
//						+ "AND goodsid='"+req.getGoodsId()+"' AND state='2' AND DATE(adtime)='"+req.getDateTime()+"'");
//			}
//			res.setResult("0");
//			res.setResultNote("删除成功");
//		}catch (Exception e) {
//			log.error("请求处理异常：删除采购商品");
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 盘点确认
//	 * @param req
//	 * @return
//	 */
//	public ResJson clickConfirmCompleted(GetProcurementGoodsReq req) {
//			ResJson res = new ResJson();
//			res.setResultNote("确认完成失败");
//			if(StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区id为空");
//				return res;
//			}
//
//			try {
//				if(!StringUtils.isBlank(req.getGoodsId())) {
//					procurementService.executeUpdateSql("UPDATE t_procurement_list SET actualcount = '"+req.getActualCount()+"',state='1' WHERE communityid='"+req.getCommunityId()+"'\r\n" +
//							"AND goodsid='"+req.getGoodsId()+"' AND state='0'");
//					String goodId=goodsCommunityService.execSelectSqlString("SELECT id FROM t_goods_community WHERE communityid='"+req.getCommunityId()+"' AND goodsid='"+req.getGoodsId()+"'");
//					if(null == goodId || "".equals(goodId)) {
//						goodsCommunityService.executeInsertSql("INSERT INTO t_goods_community(id,communityid,goodsid,stock,price,shelves,adtime) VALUES('"+IdGen.uuid()+"',"
//								+ "'"+req.getCommunityId()+"','"+req.getGoodsId()+"','"+req.getActualCount()+"','"+req.getGoodsPrice()+"','0',NOW())");
//					}else {
//						goodsCommunityService.executeUpdateSql("UPDATE t_goods_community a INNER JOIN (SELECT communityid,goodsid,stock FROM t_goods_community \r\n" +
//								"WHERE communityid ='"+req.getCommunityId()+"' AND goodsid ='"+req.getGoodsId()+"') b ON a.communityid=b.communityid AND a.goodsid=b.goodsid\r\n" +
//								"SET a.stock = IFNULL(b.stock,0)+'"+req.getActualCount()+"',a.shelves='0'");
//					}
//			      }else {
//			    	procurementService.executeUpdateSql("UPDATE t_procurement_list SET actualcount = '"+req.getActualCount()+"',state='1' WHERE communityid='"+req.getCommunityId()+"'\r\n" +
//								" AND state='3' AND goodsname='"+req.getGoodsName()+"'");
//			      }
//				res.setResult("0");
//				res.setResultNote("确认完成成功");
//			}catch (Exception e) {
//				log.error("请求处理异常：确认完成");
//				e.printStackTrace();
//			}
//			return res;
//		}
//
//    /**
//     * 下单补货商品展示
//	 * @param req
//	 * @return
//	*/
//    public ResJson getProcurementGoodsShow(GetProcurementGoodsReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("补货商品展示失败");
//		if(StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区id为空");
//			return res;
//		}
//		if(StringUtils.isBlank(req.getState())) {
//			res.setResultNote("补货状态为空");
//			return res;
//		}
//		try {
//			Procurement procurement = new Procurement();
//			procurement.setCommunityId(req.getCommunityId());
//			List<Procurement> pro = procurementService.findList(procurement);
//			List<Map<String,String>> proList = new ArrayList<>();
//			for (Procurement p : pro) {
//				Map<String,String> map = new HashMap<>();
//				map.put("adtime", p.getAdtime()+"");
//				map.put("goodsCount", p.getCount()+"");
//				proList.add(map);
//			}
//			res.setDataList(proList);
//			res.setResult("0");
//			res.setResultNote("补货商品展示成功");
//		}catch (Exception e) {
//			log.error("请求处理异常：补货商品展示");
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//    /**
//	 * 4.8 加入补货单
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("添加失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getGoodsId())) {
//				supplementCarService.executeInsertSql("INSERT INTO t_supplement_car(id,communityid,goodsname,count,adtime)"
//						+ "VALUES('"+IdGen.uuid()+"','"+req.getCommunityid()+"','"+req.getGoodsName()+"','"+req.getCount()+"',NOW())");
//				res.setResult("0");
//			    res.setResultNote("新增商品添加成功");
//			    return res;
//		    }
//			SupplementCar sc = new SupplementCar();
//			sc.setCommunityid(req.getUid());
//			sc.setGoodsid(req.getGoodsId());
//			// 查询该商品是否已存在购物车内
//			List<SupplementCar> cartList = supplementCarService.findList(sc);
//			if (null != cartList && !cartList.isEmpty()) {// 存在就进行数量相加
//				SupplementCar cart = cartList.get(0);
//				cart.setCount(cart.getCount() + req.getCount());
//				// cart.setCount(req.getCount());
//				cart.setAdtime(new Date());
//				supplementCarService.save(cart);
//				res.setResult("0");
//				res.setResultNote("添加成功");
//			} else {// 不存在，进行添加操作
//				SupplementCar cart = new SupplementCar();
//				cart.setCommunityid(req.getUid());
//				cart.setGoodsid(req.getGoodsId());
//				cart.setCount(req.getCount());
//				cart.setGoodsname(req.getGoodsName());
//				cart.setAdtime(new Date());
//				supplementCarService.save(cart);
//				res.setResult("0");
//				res.setResultNote("添加成功");
//			}
//		} catch (Exception e) {
//			log.error("请求处理异常：13136" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.9 补货单列表
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取补货单列表失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			SupplementCar sc = new SupplementCar();
//			sc.setCommunityid(req.getUid());
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if("1".equals(req.getSelectType())) {
//				List<SupplementCar> cartList = supplementCarService.findList(sc);
//				if (null != cartList && !cartList.isEmpty()) {// 存在就进行数量相加
//					for (SupplementCar s : cartList) {
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("replenishId", s.getId());
//						map.put("goodsId", s.getGoodsid());
//						map.put("goodsName", s.getGoodsname());
//						map.put("goodsSpecification", s.getGoodsSpecification());
//						map.put("goodsPurchaseprice", s.getGoodsPurchaseprice());
//						if(null != s.getGoodsid()) {
//							map.put("goodsImg", filePath + s.getGoodsimg().replace("/images/", "/_thumbs/images/"));
//						}
//						map.put("goodsPrice", s.getGoodsprice());
//						map.put("goodsNum", s.getCount() + "");
//						dataList.add(map);
//					}
//				}
//			}else if("0".equals(req.getSelectType())) {
//				dataList=procurementService.execSelectSqlMap("SELECT g.id AS goodsId,IFNULL(p.goodsname,g.title) AS goodsName,CONCAT('"+filePath+"',g.image) AS goodsImg,g.price AS goodsPrice,p.state AS goodsState,"
//						+ "g.purchaseprice AS goodsPurchaseprice,g.specification AS goodsSpecification,gc.stock AS goodsStock,gc.sallnum AS goodsSallnum,p.putcount AS goodsPutCount,DATE(p.adtime) AS dateTime "
//						+ "FROM t_procurement_list p LEFT JOIN t_goods_community gc ON p.goodsid=gc.goodsid " +
//						"AND p.communityid=gc.communityid LEFT JOIN t_goods g ON p.goodsid=g.id WHERE p.communityid = '"+c.getId()+"' AND p.state != '1' ORDER BY p.adtime DESC");
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取补货单列表成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：13185" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.10 删除补货单
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec3(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("删除补货单失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			if (req.getReplenishIdArr() != null && req.getReplenishIdArr().length > 0) {
//				for (String s : req.getReplenishIdArr()) {
//					String sql = "delete from t_supplement_car where id='" + s + "'";
//					supplementCarService.executeDeleteSql(sql);
//				}
//			}
//			res.setResult("0");
//			res.setResultNote("删除补货单成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：13223" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.11 编辑补货单
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec4(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("编辑补货单失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getReplenishId())) {
//				res.setResultNote("补货单ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			SupplementCar sc = supplementCarService.get(req.getReplenishId());
//			if (sc != null && sc.getId().length() > 0) {
//				sc.setCount(req.getCount());
//				supplementCarService.save(sc);
//			}
//			res.setResult("0");
//			res.setResultNote("编辑补货单成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：13264" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.12 提交补货单
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec5(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("提交补货单失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			Map<String,Object> checkMoment = procurementService.execSelectSqlEntityObjMap("SELECT TIME(endTime)>CURRENT_TIME() AS endTime,"
//					+ "TIME(startTime)<CURRENT_TIME() AS startTime FROM t_merchant_rest WHERE state = '1'");
//				if(null != checkMoment && !"1".equals(checkMoment.get("endTime").toString()) && !"1".equals(checkMoment.get("startTime").toString())) {
//					res.setResultNote("请在规定时间段内提交");
//					return res;
//				}
//
//			String proId=procurementService.execSelectSqlString("SELECT id FROM t_procurement WHERE communityid = '"+c.getId()+"' AND DATE(adtime)=CURDATE()");
//			String state = "0";
//			if (req.getReplenishIdArr() != null && req.getReplenishIdArr().length > 0) {
//				Procurement sm = new Procurement();
//				if(null != proId && !"".equals(proId)) {//当日已提交
//
//					for (String s : req.getReplenishIdArr()) {
//						SupplementCar sc = supplementCarService.get(s);
//						if(null == sc.getGoodsid()) {
//							state="3";//新商品
//						}
//						int index=procurementService.execUpdateValueSql("UPDATE t_procurement_list u INNER JOIN (SELECT IFNULL(putcount,0) AS putcount FROM t_procurement_list s "+
//								"WHERE s.communityid ='"+c.getId()+"'AND s.goodsid ='"+sc.getGoodsid()+"' AND DATE(adtime) = CURDATE()) b "+
//								"SET u.putcount = b.putcount+'"+sc.getCount()+"' ,u.adtime=NOW() WHERE u.communityid ='"+c.getId()+"'AND u.goodsid ='"+sc.getGoodsid()+"' AND DATE(adtime) = CURDATE()");
//						if(0==index) {
//							procurementService.executeInsertSql("INSERT INTO t_procurement_list(id,goodsname,goodsid,communityid,putcount,state,procurementid,adtime)\r\n" +
//									"VALUES('"+IdGen.uuid()+"','"+sc.getGoodsname()+"','"+sc.getGoodsid()+"','"+c.getId()+"','"+sc.getCount()+"','"+state+"','"+proId+"',NOW())");
//						}
//						supplementCarService.delete(sc);
//					}
//					if (req.getReplenishIdArr().length <= 0) {
//						sm.setCount(0);
//					} else {
//						sm.setCount(req.getReplenishIdArr().length);
//					}
//					procurementService.executeUpdateSql("UPDATE t_procurement u INNER JOIN (SELECT  IFNULL(count,0) AS count FROM t_procurement s " +
//							"WHERE s.communityid ='"+c.getId()+"'AND s.adtime =CURDATE() ) b " +
//							"SET u.count = b.count+'"+sm.getCount()+"' WHERE u.communityid ='"+c.getId()+"'AND u.adtime =CURDATE()");
//				} else {//当日未提交
//
//				sm.setId(IdGen.uuid());
//				for (String s : req.getReplenishIdArr()) {
//					SupplementCar sc = supplementCarService.get(s);
//					if(null == sc.getGoodsid()) {
//						state="3";//新商品
//					}
//				    procurementService.executeInsertSql("INSERT INTO t_procurement_list(id,goodsname,goodsid,communityid,putcount,state,procurementid,adtime)\r\n" +
//								"VALUES('"+IdGen.uuid()+"','"+sc.getGoodsname()+"','"+sc.getGoodsid()+"','"+c.getId()+"','"+sc.getCount()+"','"+state+"','"+sm.getId()+"',NOW())");
//					supplementCarService.delete(sc);
//				}
//				if (req.getReplenishIdArr().length <= 0) {
//					sm.setCount(0);
//				} else {
//					sm.setCount(req.getReplenishIdArr().length);
//				}
//				procurementService.executeInsertSql("INSERT INTO t_procurement (id,communityid,count,adtime) VALUES('"+sm.getId()+"','"+req.getUid()+"','"+sm.getCount()+"',NOW())");
//			  }
//			}
//			res.setResult("0");
//			res.setResultNote("提交补货单成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：13356" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.13 个人中心
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec6(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取信息失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			//TODO 商家余额验证
////			Tuser user = new Tuser();
////			user.setId(c.getId());
////			user.setBalance(Double.valueOf(c.getBalance()));
////			if(!csc.validateBalance(user,"1")){
////				csc.updateBalance(user,"1");
////			}
//
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("communityName", c.getName1());
//			map.put("nickname", c.getNickname());
//			map.put("icon", filePath + c.getShopicon());
//			map.put("loginname", c.getLoginname());
//			map.put("balance", c.getBalance() + "");
//			map.put("address", c.getAddress());
//
//
//			//支付宝待结算订单金额
//			String sql = "select ifnull(sum(payprice),0) from t_user_order where communityid='" + req.getUid()
//			+ "' and isaccount=1 and status in (2,3,4,5,6,7,8,10,11) and paytype = 1";
//			List<Object> list = communityService.executeSelectSql(sql);
//			//加上逗邻币待结算订单金额(支付宝充值)
//			String sql2 = "SELECT ifnull(sum(payprice), 0) FROM t_user_order b,"
//					+ "(SELECT a.uid,a.type FROM t_user_money a WHERE a.title = '充值' AND a.type != 0 AND a.htype = 0 GROUP BY a.uid ORDER BY a.adtime DESC	) c"
//					+ " WHERE b.uid = c.uid AND	b.communityid = '" + req.getUid()
//					+"' AND b.isaccount = 1 AND b.STATUS IN (2, 3, 4, 5, 6, 7, 8, 10, 11) AND b.paytype = 0 and c.type = 1 ";
//			List<Object> list2 = communityService.executeSelectSql(sql2);
//			map.put("alipaymoney", new BigDecimal(list.get(0).toString()).add(new BigDecimal(list2.get(0).toString())).toString());
//			//微信待结算订单金额
//			sql = "select ifnull(sum(payprice),0) from t_user_order where communityid='" + req.getUid()
//			+ "' and isaccount=1 and status in (2,3,4,5,6,7,8,10,11) and paytype = 2";
//			list = communityService.executeSelectSql(sql);
//
//			//加上逗邻币待结算订单金额(微信充值)
//			sql2 = "SELECT ifnull(sum(payprice), 0) FROM t_user_order b,"
//					+ "(SELECT a.uid,a.type FROM t_user_money a WHERE a.title = '充值' AND a.type != 0 AND a.htype = 0 GROUP BY a.uid ORDER BY a.adtime DESC	) c"
//					+ " WHERE b.uid = c.uid AND	b.communityid = '" + req.getUid()
//					+"' AND b.isaccount = 1 AND b.STATUS IN (2, 3, 4, 5, 6, 7, 8, 10, 11) AND b.paytype = 0 and c.type = 2 ";
//			list2 = communityService.executeSelectSql(sql2);
//
//			map.put("wxpaymoney", new BigDecimal(list.get(0).toString()).add(new BigDecimal(list2.get(0).toString())).toString());
//			//未确认订单金额
//			sql = "select ifnull(sum(payprice),0) from t_user_order where communityid='" + req.getUid()
//			+ "' and isaccount=0 and status in (2,3,4,5,6,7,8,10,11)";
//			list = communityService.executeSelectSql(sql);
//			map.put("accountmoney", list.get(0).toString());
//			//今日营业额
//			sql = "select ifnull(sum(payprice),0) from t_user_order where communityid='" + req.getUid()
//					+ "' and status in (2,3,4,5,6,7,8,10,11) and adtime>CURDATE()";
//			list = communityService.executeSelectSql(sql);
//			map.put("dayordermoney", list.get(0).toString());
//			//今日订单量
//			sql = "select count(1) from t_user_order where communityid='" + req.getUid()
//					+ "' and status in (2,3,4,5,6,7,8,10,11) and adtime>CURDATE()";
//			list = communityService.executeSelectSql(sql);
//			map.put("dayordernum", list.get(0).toString());
//			//未读消息数
//			sql = "select count(1) from t_msg where type=2 and FIND_IN_SET('" + req.getUid()
//					+ "',uid) and !FIND_IN_SET('" + req.getUid() + "',status)";
//			list = communityService.executeSelectSql(sql);
//			map.put("messagenum", list.get(0).toString());
////			//
////			sql = "SELECT SUM(o.payprice) FROM t_user_order o WHERE o.status in(2,3,4,5,6,7,8,10,11)AND o.communityid='"
////					+ c.getId() + "'";
////			list = communityService.executeSelectSql(sql);
////			if (list != null && list.size() > 0 && null != list.get(0)) {
////				map.put("allnum", list.get(0).toString());
////			} else {
////				map.put("allnum", "0");
////			}
//			map.put("openid", StringUtils.isBlank(c.getOpenid())?"0":"1");
//			map.put("alipayid", StringUtils.isBlank(c.getAlipayid())?"0":"1");
//			map.put("realname", StringUtils.isBlank(c.getRealname())?"0":"1");
//			res.setObject(map);
//			res.setResult("0");
//			res.setResultNote("获取信息成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：13423" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//	/**
//	 * 7.03 个人中心
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec6New(UserStatisticsReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取信息失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			Map<String, Object> map = new HashMap<String, Object>();
//			/*map=userOrderService.selectDetails(req.getUid());*/
//			map.put("communityName", c.getName1());
//			map.put("nickname", c.getNickname());
//			map.put("icon", filePath + c.getShopicon());
//			map.put("loginname", c.getLoginname());
//			map.put("balance", c.getBalance() + "");
//			map.put("address", c.getAddress());
//			//今日营业额
//			SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");
//		    String tiem = sformat.format(new Date());
//			UserVisitor uv=new UserVisitor();
//			uv.setAdtime(tiem);
//			uv.setTimeType("1");
//			uv.setCommunityId(req.getUid());
//			String visitorNum=us.selectUserVisitorNum(uv);
//			// 访客人数
//			map.put("visitorNum", visitorNum);
//			Map<String,String>statisticsInfo= userOrderService.selectStatisticsInfo(uv);
//			//支付人数
//			map.put("payUsers",statisticsInfo.get("payUsers") );
//			//取消订单人数
//			map.put("calloffUser", statisticsInfo.get("calloffUser"));
//			// 支付金额
//			map.put("dayordermoney", statisticsInfo.get("allGmv"));
//			//今日订单量
//			map.put("dayordernum", statisticsInfo.get("allUsers"));
//			//可操作订单数量
//			map.put("operabilityOrder",statisticsInfo.get("operabilityOrder"));
//			//未读消息数
//			String msgNum= msgService.communityMsgNum(req.getUid());
//			Calendar cal=Calendar.getInstance();
//			cal.add(Calendar.DATE,-1);
//			Date time=cal.getTime();
//			uv.setAdtime(sformat.format(time));
//			Map<String,String>statisticsInfo2= userOrderService.selectStatisticsInfo(uv);
//			Object t=statisticsInfo.get("turnoverGmv");
//			Object z=statisticsInfo2.get("turnoverGmv");
//			Double jT=Double.valueOf(t.toString());
//			Double zT=Double.valueOf(z.toString());
//			double bl = 0;
//			if(jT>0){
//				 bl=Math.round(((jT-zT)/jT*100));
//			}
//			map.put("percent",bl+"%");
//			if(req.getPageCount()!=null&&req.getNowPage()!=null){
//				int size= req.getPageCount();
//				int num= req.getNowPage();
//				uv.setStart((num-1)*size);
//				uv.setSize(size);
//			 }
////			List<Map<String,String>>settlement=userOrderService.selectSettlement(uv);
////			List<Map<String,String>>settlementInfo=userOrderService.selectSettlementInfo(uv);
////			map.put("settlementInfo", settlementInfo);
////			map.put("settlement", settlement);
//			map.put("messagenum", msgNum);
//			map.put("openid", StringUtils.isBlank(c.getOpenid())?"0":"1");
//			map.put("alipayid", StringUtils.isBlank(c.getAlipayid())?"0":"1");
//			map.put("realname", StringUtils.isBlank(c.getRealname())?"0":"1");
//			res.setObject(map);
//			res.setResult("0");
//			res.setResultNote("获取信息成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：13423" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.132 今日订单量详情
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecTreeDetails(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取信息失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//
//			Integer nowPage = (req.getNowPage() - 1) * req.getPageCount();
//			List<Object> totalPages = null;
//			List<UserOrder> userOrderList = null;
//			UserOrder user = new UserOrder();
//			user.setCommunityid(c.getId());
//			user.setPageCount(req.getPageCount());
//			user.setNowPage(nowPage);
//			if (req.getIsaccount() != null && !"".equals(req.getIsaccount())) {
//				user.setIsaccount("0");
//				userOrderList = userOrderService.selectTurnoverTodayList(user);
//				totalPages = userOrderService.executeSelectSql(
//						"SELECT COUNT(id) from t_user_order WHERE  isaccount = '" + req.getIsaccount() + "'");
//			} else {
//				user.setPaytime(req.getAdtime());
//				userOrderList = userOrderService.selectTurnoverTodayList(user);
//				if (null != req.getAdtime()) {
//					totalPages = userOrderService
//							.executeSelectSql("SELECT COUNT(id) from t_user_order WHERE  DATE(paytime) = DATE('"
//									+ req.getAdtime() + "')");
//				} else {
//					totalPages = userOrderService.executeSelectSql("SELECT COUNT(id) from t_user_order");
//				}
//
//			}
//			Integer totalPage = Integer
//					.parseInt(StringUtils.isBlank(totalPages + "") ? "0" : totalPages.get(0).toString());
//			if (totalPage % req.getPageCount() == 0) {
//				totalPage = totalPage / req.getPageCount();
//			} else {
//				totalPage = totalPage / req.getPageCount() + 1;
//			}
//			List<Map<String, String>> dataList = new ArrayList<>();
//			if (userOrderList != null && !userOrderList.isEmpty()) {
//				for (UserOrder userOrder : userOrderList) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("username", userOrder.getUsername());
//					map.put("userphone", userOrder.getUserphone());
//					map.put("orderType", userOrder.getOrdertype());
//					map.put("ordernum", userOrder.getOrdernum());
//					map.put("allprice", userOrder.getAllprice() + "");
//					map.put("payprice", userOrder.getPayprice() + "");
//					map.put("status", userOrder.getStatus());
//					map.put("paytype", userOrder.getPaytype());
//					map.put("paytime",
//							null != userOrder.getPaytime()
//									? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getPaytime())
//									: "");
//					dataList.add(map);
//
//				}
//
//			}
//			res.setTotalPage(totalPage);
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取信息成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：13510" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.133 查一段的营业额
//	 */
//	public ResJson codePeriodTimeTreeVersion(GetPeriodTimeReq req) {
//		ResJson res = new ResJson();
//
//		if (StringUtils.isBlank(req.getCommunityid())) {
//			res.setResult("社区id不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getStartTime() + "")) {
//			res.setResult("开始时间为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getEndTime() + "")) {
//			res.setResult("结束时间为空");
//			return res;
//		}
//		try {
//			List<Date> dates = csc.findDates(req.getStartTime(), req.getEndTime());
//			List<Map<String, String>> addList = new ArrayList<Map<String, String>>();
//			if (dates.size() != 0) {
//				for (Date date : dates) {
//					Map<String, String> map = new HashMap<>();
//					List<Object> payPrice = userOrderService
//							.executeSelectSql("SELECT SUM(o.payprice) FROM t_user_order o "
//									+ "WHERE o.status in(2,3,4,5,6,7,8,10,11) AND o.communityid='"
//									+ req.getCommunityid() + "'  AND DATE(o.paytime) = DATE('" + date + "')");
//					if (payPrice.size() != 0) {
//						map.put("payPrice", payPrice.get(0).toString());
//						map.put("date", date + "");
//						addList.add(map);
//					}
//				}
//				res.setDataList(addList);
//				res.setResult("0");
//				res.setResultNote("获取成功");
//
//			}
//		} catch (Exception e) {
//			log.error("请求处理异常：13556" );
//			e.printStackTrace();
//		}
//
//		return res;
//	}
//
//	/**
//	 * 提交促销价申请
//	 *
//	 * @return
//	 */
//	public ResJson getApprovalOfPromotionPrice(GetApprovalOfPriceReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("商品促销价申请失败");
//		if(StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区id不能为空");
//			return res;
//		}
//		if(StringUtils.isBlank(req.getGoodsId())) {
//			res.setResultNote("社区商品id不能为空");
//			return res;
//		}
//		if(StringUtils.isBlank(req.getCuprice())) {
//			res.setResultNote("促销价不可为空");
//			return res;
//		}
//		if(Double.valueOf(req.getCuprice())==0) {
//			res.setResultNote("促销价不可为0");
//			return res;
//		}
//		if(StringUtils.isBlank(req.getStartTime())) {
//			res.setResultNote("开始时间不可为空");
//			return res;
//		}
//		if(StringUtils.isBlank(req.getEndTime())) {
//			res.setResultNote("结束时间不可为空");
//			return res;
//		}
//		GoodsCommunity gc1=goodsCommunityService.gets(req.getCommunityId(), req.getGoodsId());
//		if(null==gc1||"1".equals(gc1.getShelves())){
//			res.setResultNote("该商品未上架，请先上架再修改");
//			return res;
//		}
//		if(Double.valueOf(req.getCuprice())>=Double.valueOf(gc1.getGoodsprice())){
//			res.setResultNote("促销价不能大于或等于售价");
//			return res;
//		}
//		try {
//			Goods g = goodsService.get(req.getGoodsId());
//			if(null !=g && "1".equals(g.getFlag())){
//				res.setResultNote("商品售价已被锁定，不允许修改");
//			}else{
//				CommunityPrice cp = new CommunityPrice();
//				cp.setId(IdGen.uuid());
//				cp.setCommunityId(req.getCommunityId());
//				cp.setGoodsId(req.getGoodsId());
//				cp.setGoodsName(req.getGoodsName());
//				cp.setOptimizationid(req.getOptimizationId());
//				cp.setCuprice(req.getCuprice());
//				cp.setStartTime(req.getStartTime());
//				cp.setEndTime(req.getEndTime());
//				cp.setState("2");//取消价格审核
//				communityPriceService.save(cp);
//
//				res.setResult("0");
//				res.setResultNote("商品促销价成功");
//			}
//		} catch (Exception e) {
//			log.error("请求处理异常：13606" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.14 修改头像
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec7(HttpServletRequest request, AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("修改头像失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getImage())) {
//				res.setResultNote("头像不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			String userIcon = req.getImage().replaceAll(" ", "+");
//			String realPath = request.getSession().getServletContext().getRealPath("userfiles/1/files/user/icon");
//			String[] split = DateTimeUtil.dateConvtoFmt(new Date(), "yyyy-MM").split("-"); // 按日期存放上传的文件
//			String dateDir = split[0] + "/" + split[1];
//			File path = new File(realPath + File.separator + dateDir);
//			if (!path.exists()) {
//				path.mkdirs();
//			}
//			String image = Base64ToImageUtil.GenerateImage(userIcon, path.getPath() + File.separator);
//			c.setShopicon("/wisdom/userfiles/1/files/user/icon/" + dateDir + "/" + image); // 头像
//			communityService.save(c);
////			try {// 修改网易云信息
////				Wangyiyunxin.updateuser(c.getId(), c.getName1(), filePath + c.getShopicon());
////			} catch (Exception e) {
////				log.error("请求处理异常：13672" );
////				e.printStackTrace();
////			}
//			res.setObject(filePath + c.getShopicon());
//			res.setResult("0");
//			res.setResultNote("修改头像成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：13679" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.15 我的消息
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec8(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取我的消息失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			Msg m = new Msg();
//			m.setType("2");
//			m.setHtype(req.getHtype());
//			m.setDataScope("and FIND_IN_SET('" + req.getUid() + "',a.uid)");
//			Page<Msg> page = new Page<Msg>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			Page<Msg> pageList = msgService.findPage(page, m);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			List<Msg> list = pageList.getList();
//			if (null != list && list.size() > 0) {
//				for (Msg msg : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("messageId", msg.getId());
//					map.put("messageType", msg.getHtype());
//					map.put("orderNum", msg.getUrl());
//					if ("0".equals(msg.getHtype())&&StringUtils.isNotBlank(msg.getUrl())) {
//						String orderNum = userOrderService.execSelectSqlString(
//								"SELECT url FROM t_msg WHERE type=2 AND  htype =0 AND id='" + msg.getId() + "'");
//						map.put("goodsId", StringUtils.isBlank(orderNum)?"":orderNum);
//					}else{
//						map.put("goodsId", "");
//					}
//					map.put("messageTitle", msg.getTitle());
//					map.put("messageContent", msg.getContent());
//					map.put("messageTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(msg.getAdtime()));
//					dataList.add(map);
//				}
//			}
//			String sql = "update t_msg set status=ifnull(CONCAT(status,'," + req.getUid() + "'),'," + req.getUid()
//					+ "')" + "WHERE type=2 and FIND_IN_SET('" + req.getUid() + "',uid) AND !FIND_IN_SET('"
//					+ req.getUid() + "',status)";
//			msgService.executeUpdateSql(sql);
//			res.setTotalPage(pageList.getTotalPage());
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取我的消息成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：13743" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.16 余额提现
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(UserTixianReq req) {
//		AddGoodsOrderRes res = new AddGoodsOrderRes();
//		res.setResultNote("申请失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCardId())) {
//				res.setResultNote("请选择银行卡");
//				return res;
//			}
//			if (0d >= req.getAmount()) {
//				res.setResultNote("提现金额有误");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			if (req.getAmount() > c.getBalance()) {
//				res.setResultNote("余额不足");
//				return res;
//			}
//			Customer cc = customerService.get("1");
//			double ratemoney = Double.valueOf(cc.getShopcash()) * req.getAmount() * 0.01;
//			UserRecharge ur = new UserRecharge();
//			ur.setId(IdGen.uuid());
//			ur.setUid(req.getUid());
//			ur.setMoney(req.getAmount());
//			ur.setRatemoney(ratemoney);
//			ur.setRealmoney(req.getAmount() - ratemoney);
//			ur.setWay("3");
//			ur.setType("2");// 1充值 2提现
//			ur.setHtype("1");
//			ur.setStatus("4");
//			ur.setAdtime(new Date());
//			UserCard bankcard = userCardService.get(req.getCardId());
//			if (null == bankcard) {
//				res.setResultNote("银行卡不存在");
//				return res;
//			} else if (!req.getUid().equals(bankcard.getUid())) {
//				res.setResultNote("银行卡不存在");
//				return res;
//			} else {
//				ur.setUsername(bankcard.getCardusername());
//				ur.setBankname(bankcard.getCardname());
//				ur.setAccount(bankcard.getCardnum());
//			}
//			String b = userRechargeService.addUserRecharge1(ur);
//			res.setBalance(b);
//			res.setResult("0");
//			res.setResultNote("申请成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：13814" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.17 零钱明细
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2(UserTixianReq req) {
//		UserScoreListRes res = new UserScoreListRes();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//
//			UserMoney sd = new UserMoney();
//			sd.setUid(req.getUid());
//			sd.setHtype("1");
//			if (!StringUtils.isBlank(req.getMonth())) {
//				sd.setDataScope(" and a.adtime like '" + req.getMonth() + "%'");
//			}
//			Page<UserMoney> page = new Page<UserMoney>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			Page<UserMoney> sdPage = null;
//			sdPage = usermoneyService.findPage(page, sd);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (null != sdPage) {
//				List<UserMoney> list = sdPage.getList();
//				if (null != list && list.size() > 0) {
//					for (UserMoney um : list) {
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("title", um.getTitle());
//						map.put("money", um.getMoney());
//						map.put("orderNum", um.getTransactionId());
//						map.put("balance", um.getBalance());
//						map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(um.getAdtime()));
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(sdPage.getTotalPage());
//			}
//			String sql = "SELECT 0-convert(ifnull(sum(money),0),decimal(10,2)) from t_user_money WHERE uid='" + req.getUid()
//					+ "' and htype=1 and money<0";
//			if (!StringUtils.isBlank(req.getMonth())) {
//				sql += " and adtime like '" + req.getMonth() + "%'";
//			}
//			List<Object> list = usermoneyService.executeSelectSql(sql);
//			res.setWithdrawcomey(list.get(0).toString());
//			sql = "SELECT convert(ifnull(sum(money),0),decimal(10,2)) from t_user_money WHERE uid='" + req.getUid()
//					+ "' and htype=1 and money>0";
//			if (!StringUtils.isBlank(req.getMonth())) {
//				sql += " and adtime like '" + req.getMonth() + "%'";
//			}
//			list = usermoneyService.executeSelectSql(sql);
//			res.setIncomemoney(list.get(0).toString());
//			res.setBalance(c.getBalance() + "");
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：13890" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 *  打账明细
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2RemittanceDetails(UserTixianReq req) {
//		UserScoreListRes res = new UserScoreListRes();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
//
//		try {
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//
//			Community c = communityService.get(req.getCommunityId());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//
//			List<Map<String,String>> ListEntity = null;
//			Map <String,Object> dateMap = new HashMap<>();
//			List<Object> dateList = new ArrayList<>();
//			if(StringUtils.isBlank(req.getDate())) {
//				List<Object> data=communityService.executeSelectSql("SELECT DATE(adtime) FROM t_shop_settle WHERE communityid='"+c.getId()+"' GROUP BY DATE(adtime)");
//				for (Object object : data) {
//					ListEntity = communityService.execSelectSqlMap("SELECT unsettleorderpay AS unsettleorderpay,poundage AS poundage,arraccount AS arraccount,adtime AS adtime," +
//							"CASE paytype  WHEN  '1' THEN '支付宝打款' WHEN '2' THEN '微信打款' ELSE '银行转账' END  AS payType " +
//							" FROM t_shop_settle WHERE communityid = '"+c.getId()+"' AND DATE(adtime) = '"+object.toString()+"' ORDER BY adtime DESC");
//					dateMap.put("date", object.toString());
//					dateMap.put("dataList", ListEntity);
//				}
//			}else {
//				ListEntity = communityService.execSelectSqlMap("SELECT unsettleorderpay AS unsettleorderpay,poundage AS poundage,arraccount AS arraccount,adtime AS adtime," +
//						"CASE paytype  WHEN  '1' THEN '支付宝打款' WHEN '2' THEN '微信打款' ELSE '银行转账' END  AS payType " +
//						" FROM t_shop_settle WHERE communityid = '"+c.getId()+"' AND DATE(adtime) = '"+req.getDate()+"' ORDER BY adtime DESC");
//				dateMap.put("date", req.getDate());
//				dateMap.put("dataList", ListEntity);
//			}
//
//			String sumMoney = communityService.execSelectSqlString("SELECT SUM(arraccount) FROM t_shop_settle WHERE communityid = '"+c.getId()+"' GROUP BY communityid");
//			dateList.add(dateMap);
//			res.setDataList(dateList);
//			res.setObject(sumMoney);
//		}catch (Exception e) {
//			log.error("请求处理异常：13948" );
//			e.printStackTrace();
//		}
//		 res.setResult("0");
//		 res.setResultNote("获取成功");
//		return res;
//	}
//
//	/**
//	 * 4.182 我的订单 升级版
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec3order(UserTixianReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("商家ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserOrder userOrder = new UserOrder();
//			userOrder.setCommunityid(req.getUid());
//			if (null != req.getDatetime() && !"".equals(req.getDatetime())) {
//				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//				userOrder.setAdtime(formatter.parse(req.getDatetime()));
//			}
//
//			if ("1".equals(req.getOrderType())) {
//				userOrder.setOrdertype(req.getOrderType());
//				userOrder.setDataScope("and a.status!=12");
//			} else {
//				userOrder.setDataScope("and a.status!=12 and ordertype !=1");
//			}
//
//			if (!StringUtils.isBlank(req.getOrderNum())) {
//				userOrder.setOrdernum(req.getOrderNum());
//			}
//
//			Page<UserOrder> page = new Page<UserOrder>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			Page<UserOrder> pageInfo = userOrderService.findPage(page, userOrder);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<UserOrder> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (UserOrder order : list) {
//						DecimalFormat df = new DecimalFormat("#0.00");
//						String allprice = df.format(order.getAllprice());
//						String payprice = df.format(order.getPayprice());
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("orderNum", order.getOrdernum());
//						map.put("orderType", order.getOrdertype());
//						map.put("oderAllPrice", allprice);
//						map.put("oderPayPrice", payprice);
//						map.put("orderState", order.getStatus());
//						map.put("userId", order.getUid());
//						map.put("userName", order.getUsername());
//						map.put("userPhone", order.getUserphone());
//						map.put("userAddress", order.getUsercity() + order.getUseraddress());
//						map.put("adtime",
//								null != order.getAdtime()
//										? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(order.getAdtime())
//										: "");
//						UserOrderlist userOrderlist = new UserOrderlist();
//						userOrderlist.setCommunityid(c.getId());
//						userOrderlist.setOrdernum(order.getOrdernum());
//						List<UserOrderlist> list2 = userOrderlistService.findList(userOrderlist);
//						List<Map<String, String>> goodsList = new ArrayList<Map<String, String>>();
//						if (null != list2 && list2.size() > 0) {
//							for (UserOrderlist uo : list2) {
//								Map<String, String> orderlistMap = new HashMap<String, String>();
//								orderlistMap.put("commodityid", uo.getGoodsid());
//								orderlistMap.put("commodityPic",
//										StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage()
//												: "");
//								orderlistMap.put("commodityTitle", uo.getGoodstitle());
//								orderlistMap.put("commodityDesc", uo.getGoodsdesc());
//								orderlistMap.put("commodityPrice", uo.getGoodsprice() + "");
//								orderlistMap.put("commodityBuyNum", uo.getGoodsnum() + "");
//								orderlistMap.put("goodsSpecification",StringUtils.isBlank(uo.getGoodsSpecification())?"":uo.getGoodsSpecification());
//								goodsList.add(orderlistMap);
//							}
//						}
//						map.put("orderCommodity", goodsList);
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：14054" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.18 我的订单
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec3(UserTixianReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("商家ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserOrder userOrder = new UserOrder();
//			userOrder.setCommunityid(req.getUid());
//			if ("1".equals(req.getOrderType())) {
//				userOrder.setOrdertype(req.getOrderType());
//				userOrder.setDataScope("and a.status!=12 ");
//			} else if ("-1".equals(req.getOrderType())) {
//				userOrder.setDataScope("and a.status!=12 ");
//			} else {
//				userOrder.setDataScope("and a.status!=12 and ordertype !=1");
//			}
//
//			if (!StringUtils.isBlank(req.getOrderNum())) {
//				userOrder.setOrdernum(req.getOrderNum());
//			}
//
//			Page<UserOrder> page = new Page<UserOrder>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			Page<UserOrder> pageInfo = userOrderService.selectUserOrder(page, userOrder);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<UserOrder> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (UserOrder order : list) {
//						DecimalFormat df = new DecimalFormat("#0.00");
//						String allprice = df.format(order.getAllprice());
//						String payprice = df.format(order.getPayprice());
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("orderNum", order.getOrdernum());
//						map.put("orderType", order.getOrdertype());
//						map.put("oderAllPrice", allprice);
//						map.put("oderPayPrice", payprice);
//						map.put("orderState", order.getStatus());
//						map.put("userId", order.getUid());
//						map.put("userName", order.getUsername());
//						map.put("userPhone", order.getUserphone());
//						map.put("userAddress", order.getUsercity() + order.getUseraddress());
//						map.put("adtime",
//								null != order.getAdtime()
//										? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(order.getAdtime())
//										: "");
//						UserOrderlist userOrderlist = new UserOrderlist();
//						userOrderlist.setOrdernum(order.getOrdernum());
//						List<UserOrderlist> list2 = userOrderlistService.findList(userOrderlist);
//						List<Map<String, String>> goodsList = new ArrayList<Map<String, String>>();
//						if (null != list2 && list2.size() > 0) {
//							for (UserOrderlist uo : list2) {
//								Map<String, String> orderlistMap = new HashMap<String, String>();
//								orderlistMap.put("commodityid", uo.getGoodsid());
//								orderlistMap.put("commodityPic",
//										StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage()
//												: "");
//								orderlistMap.put("commodityTitle", uo.getGoodstitle());
//								orderlistMap.put("commodityDesc", uo.getGoodsdesc());
//								orderlistMap.put("commodityPrice", uo.getGoodsprice() + "");
//								orderlistMap.put("commodityBuyNum", uo.getGoodsnum() + "");
//								orderlistMap.put("goodsSpecification",StringUtils.isBlank(uo.getGoodsSpecification())?"":uo.getGoodsSpecification());
//								goodsList.add(orderlistMap);
//							}
//						}
//						map.put("orderCommodity", goodsList);
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：14153" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.181 商家端的商品详情
//	 */
//	public ResJson codeGoodsDetails(GetGoodsDetailsReq req) {
//		ResJson res = new ResJson();
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("程序在开小车");
//			return res;
//		}
//
//		if (StringUtils.isBlank(req.getCommunityid())) {
//			res.setResultNote("社区的id为空");
//			return res;
//		}
//
//		if (StringUtils.isBlank(req.getGoodsid())) {
//			res.setResultNote("商品的id为空");
//			return res;
//		}
//
//		try {
//			GoodsCommunity goodsCommunity = goodsCommunityService.gets(req.getCommunityid(), req.getGoodsid());
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("goodsId", goodsCommunity.getGoodsid());
//			map.put("goodsName", goodsCommunity.getGoodsname());
//			map.put("goodsImg", filePath + goodsCommunity.getGoodsimg());
//			map.put("goodsPrice", goodsCommunity.getGoodsprice());
//			map.put("goodsCuprice", goodsCommunity.getGoodscuprice());
//			map.put("goodsDesc", goodsCommunity.getGoodsdesc());
//			map.put("goodsSallnum", goodsCommunity.getSallnum() + "");
//			map.put("optimizationid", goodsCommunity.getOptimizationid());
//			map.put("goodState", goodsCommunity.getShelves());
//			map.put("goodsStock", "1".equals(goodsCommunity.getType()) ? "0" : goodsCommunity.getStock() + "");
//			if ("0".equals(goodsCommunity.getType())) {
//				map.put("goodsType", "2");
//			} else if ("2".equals(goodsCommunity.getType())) {
//				map.put("goodsType", "0");
//			} else {
//				map.put("goodsType", "1");
//			}
//
//			dataList.add(map);
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：14207" );
//			e.printStackTrace();
//		}
//
//		return res;
//	}
//
//	/**
//	 * 4.19 补充库存记录
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec4(UserTixianReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("商家ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			Procurement procurement = new Procurement();
//			procurement.setCommunityId(req.getUid());
//			procurement.setType(1);
//			Page<Procurement> page = new Page<Procurement>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			Page<Procurement> pageInfo = procurementService.findPage(page, procurement);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<Procurement> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (Procurement s : list) {
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("procurementSum", s.getId());
//						map.put("procurementNum", s.getCount());
//						map.put("procurementTime",null != s.getAdtime() ?s.getAdtime(): "");
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：14263" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.20 补充库存记录详情
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec5(UserTixianReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("商家ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getSupplementId())) {
//				res.setResultNote("补货单ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			/*SupplementList supplementList = new SupplementList();
//			supplementList.setSupplementid(req.getSupplementId());
//			List<SupplementList> list = supplementListMapper.findList(supplementList);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (null != list && list.size() > 0) {
//				for (SupplementList s : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("goodsId", s.getGoodsid());
//					map.put("goodsName", s.getGoodsname());
//					map.put("goodsImg", s.getGoodsimg());
//					map.put("goodsPrice", s.getGoodsprice());
//					map.put("goodsNum", s.getCount()+"");
//					dataList.add(map);
//				}
//			}*/
//			List<Map<String, String>> dataList=procurementService.execSelectSqlMap("SELECT g.id AS goodsId,g.title AS goodsName,CONCAT('"+filePath+"',g.image) AS goodsImg,g.price AS goodsPrice,"
//					+ "g.purchaseprice AS goodsPurchaseprice,g.specification AS goodsSpecification,gc.stock AS goodsStock,gc.sallnum AS goodsSallnum,p.putcount AS goodsPutCount,p.state AS goodsState "
//					+ "FROM t_procurement_list p LEFT JOIN t_goods_community gc ON p.goodsid=gc.goodsid " +
//					"AND p.communityid=gc.communityid LEFT JOIN t_goods g ON p.goodsid=g.id WHERE p.communityid = '"+c.getId()+"' AND DATE(p.adtime) ='"+req.getDatetime()+"'");
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：14316" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.21 店铺详情
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec6(UserTixianReq req) {
//		CommunityShopDetailRes res = new CommunityShopDetailRes();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("商家ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderType())) {
//				res.setResultNote("类型不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			if ("0".equals(req.getOrderType())) {// 新鲜果蔬
//				res.setShopname(c.getShopname1());
//				res.setShopphone(c.getShopphone1());
//				res.setShoptime1(c.getShoptime1());
//				res.setShoptime2(c.getShoptime11());
//			} else if ("1".equals(req.getOrderType())) {// 洗衣洗鞋
//				res.setShopname(c.getShopname2());
//				res.setShopphone(c.getShopphone2());
//				res.setShoptime1(c.getShoptime2());
//				res.setShoptime2(c.getShoptime22());
//			} else if ("2".equals(req.getOrderType())) {// 超市便利
//				res.setShopname(c.getShopname3());
//				res.setShopphone(c.getShopphone3());
//				res.setShoptime1(c.getShoptime3());
//				res.setShoptime2(c.getShoptime33());
//			}
//
//			List<Object> startobject = communityService
//					.executeSelectSql("SELECT m.startTime FROM t_merchant_rest m WHERE m.communityid='" + req.getUid()
//							+ "' AND m.state='0'");
//			List<Object> endObject = communityService
//					.executeSelectSql("SELECT m.endTime FROM t_merchant_rest m WHERE m.communityid='" + req.getUid()
//							+ "' AND m.state='0'");
//			if (null != startobject && startobject.size() > 0) {
//				res.setStartTime(startobject.get(0).toString());
//				res.setEndTime(endObject.get(0).toString());
//			}
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：14380" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.22 编辑店铺信息
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec7(UserTixianReq req) {
//		CommunityShopDetailRes res = new CommunityShopDetailRes();
//		res.setResultNote("编辑失败");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("商家ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderType())) {
//				res.setResultNote("类型不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			if ("0".equals(req.getOrderType())) {// 新鲜果蔬
//				c.setShopname1(req.getShopname());
//				c.setShopphone1(req.getShopphone());
//				c.setShoptime1(req.getShoptime1());
//				c.setShoptime11(req.getShoptime2());
//			} else if ("1".equals(req.getOrderType())) {// 洗衣洗鞋
//				c.setShopname2(req.getShopname());
//				c.setShopphone2(req.getShopphone());
//				c.setShoptime2(req.getShoptime1());
//				c.setShoptime22(req.getShoptime2());
//			} else if ("2".equals(req.getOrderType())) {// 超市便利
//				c.setShopname3(req.getShopname());
//				c.setShopphone3(req.getShopphone());
//				c.setShoptime3(req.getShoptime1());
//				c.setShoptime33(req.getShoptime2());
//			}
//			communityService.save(c);
//			res.setResult("0");
//			res.setResultNote("编辑成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：14434" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.23 获取店铺评价
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec8(UserTixianReq req) {
//		CommunityShopDetailRes res = new CommunityShopDetailRes();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("商家ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderType())) {
//				res.setResultNote("类型不能为空");
//				return res;
//			}
//			Community ccc = communityService.get(req.getUid());
//			if (null == ccc) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(ccc.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			// 获取评论
//			Page<Comment> page = new Page<Comment>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			Comment c = new Comment();
//			c.setType("2");
//			c.setCommunityid(req.getUid());
//			if (!"-1".equals(req.getOrderType())) {
//				c.setHtype(req.getOrderType());
//			}
//			c.setState("0");
//			Page<Comment> pageInfo = commentService.findPage(page, c);
//			List<Comment> list = pageInfo.getList();
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				for (Comment cc : list) {
//					// 获取一级评论
//					Map<String, Object> map1 = new HashMap<String, Object>();
//					map1.put("commentId", cc.getId());
//					map1.put("commentUid", cc.getUid());
//					map1.put("commentIcon",
//							StringUtils.isNotBlank(cc.getCommenticon()) && cc.getCommenticon().indexOf("http://") == -1
//									&& cc.getCommenticon().indexOf("https://") == -1 ? filePath + cc.getCommenticon()
//											: cc.getCommenticon());
//					map1.put("commentName", cc.getCommentname());
//					map1.put("commentObjid", cc.getObjid());
//					map1.put("commentContent", cc.getContent());
//					map1.put("commentTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(cc.getAdtime()));
//					map1.put("commentStar", cc.getStar());
//					// 获取二级评论
//					List<Comment> secondList = commentService.selectSecondaryComments(cc.getId());
//					if (null != secondList && secondList.size() > 0) {
//						for (Comment comment : secondList) {
//							Map<String, Object> map2 = new HashMap<String, Object>();
//							map2.put("commentId", comment.getPid());
//							map2.put("commentUid", comment.getUid());
//							map2.put("commentIcon",
//									StringUtils.isNotBlank(comment.getCommenticon())
//											&& comment.getCommenticon().indexOf("http://") == -1
//											&& comment.getCommenticon().indexOf("https://") == -1
//													? filePath + comment.getCommenticon()
//													: comment.getCommenticon());
//							map2.put("commentName", comment.getCommentname());
//							map2.put("commentObjid", comment.getObjid());
//							map2.put("commentContent", comment.getContent());
//							map2.put("commentTime",
//									DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(comment.getAdtime()));
//							map2.put("commentStar", comment.getStar());
//							map1.put("secondComment", map2);
//						}
//
//					}
//
//					dataList.add(map1);
//				}
//			}
//			String sql = "select ROUND(ifnull(avg(a.star),0),1) from t_comment a left join t_user_order o on o.ordernum = a.objid "
//					+ "where a.type=2 and o.ordertype=" + req.getOrderType() + " and o.communityid='" + req.getUid()
//					+ "'";
//			List<Object> score = communityService.executeSelectSql(sql);
//			res.setTotalPage(pageInfo.getTotalPage());
//			res.setShopStar(score.get(0).toString());
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：14535" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 订单评论
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson addCommentCodec(EvaluateOrder1Req req) {
//		ResJson res = new ResJson();
//		res.setResultNote("评价订单失败");
//
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户ID不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getOrderNum())) {
//			res.setResultNote("订单号不能为空");
//			return res;
//		}
//
//		UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//		if (null == userOrder || !req.getUid().equals(userOrder.getCommunityid())) {
//			res.setResultNote("订单不存在");
//			return res;
//		}
//		// 保存二级评论
//		Comment c = new Comment();
//		String id = IdGen.uuid();
//		c.setId(id);
//		c.setUid(req.getUid());
//		c.setType("2");
//		c.setState("1");
//		c.setObjid(req.getOrderNum());
//		c.setPid(req.getCommentId());
//		c.setZannum(0);
//		c.setCommentnum(0);
//		c.setContent(req.getContent());
//		c.setAdtime(new Date());
//		commentService.insert(c);
//		Comment d = commentService.get(req.getCommentId());
//		Msg m = new Msg();
//		m.setUid(d.getUid());
//		m.setType("2");
//		m.setHtype("2");
//		m.setTitle("评论消息");
//		m.setContent(req.getContent());
//		m.setUrl(id);
//		m.setStatus("");
//		m.setAdtime(new Date());
//		msgService.save(m);
//		res.setResult("0");
//		res.setResultNote("评价订单成功");
//		return res;
//	}
//
//	/**
//	 * 订单评论删除
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson deleteCodec(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("删除失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Tuser user = tuserService.get(req.getUid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			Comment c = commentService.get(req.getCommentId());
//			if (c != null) {
//				// 一级评论
//				// 删除下面二级评论的消息
//				commentService.executeDeleteSql(
//						"delete from t_msg where htype=2 and url in (SELECT id from  t_comment where  pid='" + c.getId()
//								+ "')");
//				// 删除一级评论的消息
//				commentService.executeDeleteSql("delete from t_msg where htype=2 and url='" + c.getId() + "'");
//				// 删除下面的二级评论
//				commentService.executeDeleteSql("delete from t_comment where state=1 and pid='" + c.getId() + "'");
//				commentService.delete(c);
//			}
//			res.setResult("0");
//			res.setResultNote("删除成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：14632" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 4.24 商家休息时间
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecRest(GetMerchantRestReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("系统繁忙");
//		if (StringUtils.isBlank(req.getCommunityid())) {
//			res.setResultNote("社区id为空");
//			return res;
//		}
//
//		if (StringUtils.isBlank(req.getStartTime() + "")) {
//			res.setResultNote("开始时间不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getEndTime() + "")) {
//			res.setResultNote("结束时间不能为空");
//			return res;
//		}
//
//		try {
//			String id= communityService.execSelectSqlString("SELECT id FROM t_merchant_rest WHERE communityid = '"+req.getCommunityid()+"' AND state='0'");
//			if(null != id && !"".equals(id)) {
//				communityService.executeUpdateSql("UPDATE t_merchant_rest SET startTime='"+req.getStartTime()+"', endTime='"+req.getEndTime()+"',adtime=NOW() WHERE id='"+id+"'");
//			}else {
//				String date = DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(new Date());
//				communityService.executeInsertSql(
//						"INSERT INTO t_merchant_rest(id,communityid,startTime,endTime,state,adtime) VALUE('" + IdGen.uuid()
//								+ "','" + req.getCommunityid() + "','" + req.getStartTime() + "','" + req.getEndTime()
//								+ "','0','" + date + "')");
//			}
//			res.setResult("0");
//			res.setResultNote("操作完成");
//
//		} catch (Exception e) {
//			log.error("请求处理异常：14671" );
//			e.printStackTrace();
//		}
//
//		return res;
//	}
//
//	/**
//	 * 4.25 社区商品上下架
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codeMerchantsShelves(GetMerchantsShelvesReq req) {
//		ResJson res = new ResJson();
//		if (StringUtils.isBlank(req.getCommunityid())) {
//			res.setResultNote("社区id不能为空");
//			return res;
//		}
//
//		if (StringUtils.isBlank(req.getGoodsid())) {
//			res.setResultNote("商品id不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getState())) {
//			res.setResultNote("状态不能为空");
//			return res;
//		}
//		try {
//			if ("1".equals(req.getState())) {
//				goodsCommunityService.executeUpdateSql("UPDATE t_goods_community g SET g.shelves='" + req.getState()
//						+ "',g.stock =0 WHERE g.communityid='" + req.getCommunityid() + "' and g.goodsid='"	+ req.getGoodsid() + "'");
//				res.setResultNote("下架成功");
//			} else if ("0".equals(req.getState())) {
//				goodsCommunityService.executeUpdateSql(
//						"UPDATE t_goods_community g SET g.shelves='" + req.getState() + "' " + "WHERE g.communityid='"
//								+ req.getCommunityid() + "' and g.goodsid='" + req.getGoodsid() + "'");
//				res.setResultNote("上架成功");
//			}
//			res.setResult("0");
//
//		} catch (Exception e) {
//			log.error("请求处理异常：14714" );
//			e.printStackTrace();
//		}
//
//		return res;
//	}
//
//	/**
//	 * 5.0  社区商品价格修改
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codeCommunityPrice(GetCommunityPrice req) {
//		ResJson res = new ResJson();
//		if (StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区id不能为空");
//			return res;
//		}
//
//		if (StringUtils.isBlank(req.getGoodsId())) {
//			res.setResultNote("商品id不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getPrice())) {
//			res.setResultNote("价格不能为空");
//			return res;
//		}
//		if(!com.jeeplus.common.utils.StringUtils.isNumber(req.getPrice())){
//			res.setResultNote("非法请求");
//			return res;
//		}
//		if (Double.valueOf(req.getPrice())==0) {
//			res.setResultNote("价格不能为0");
//			return res;
//		}
//		GoodsCommunity gc1=goodsCommunityService.gets(req.getCommunityId(), req.getGoodsId());
//		if(null==gc1||"1".equals(gc1.getShelves())){
//			res.setResultNote("该商品未上架，请先上架再修改");
//			return res;
//		}
//		if(StringUtils.isNotBlank(gc1.getGoodscuprice())&&Double.valueOf(req.getPrice())<=Double.valueOf(gc1.getGoodscuprice())){
//			res.setResultNote("售价不能小于促销价");
//			return res;
//		}
//		try {
//			Goods g = goodsService.get(req.getGoodsId());
//			if("1".equals(g.getFlag())){
//				res.setResultNote("商品售价已被锁定，不允许修改");
//			}else{
//				GoodsCommunity gc = new GoodsCommunity();
//				gc.setCommunityid(req.getCommunityId());
//				gc.setGoodsid(req.getGoodsId());
//				gc.setGoodsprice(req.getPrice());
//				goodsCommunityService.updateCommunityGoodsPrice(gc);
//				res.setResultNote("商品售价修改成功");
//				res.setResult("0");
//			}
//		} catch (Exception e) {
//			log.error("请求处理异常：15066" );
//			e.printStackTrace();
//		}
//
//		return res;
//	}
//
//	/**
//	 * 4.26 商家端版本是否强制跟新
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecMerchantVersion(GetMerchantVersionReq req) {
//		GetMerchanVersionRes res = new GetMerchanVersionRes();
//		res.setResultNote("更新版本失败");
//		if ("2".equals(req.getType())) {
//			res.setResultNote("类型不能为空");
//			return res;
//		}
//
//		try {
//
//			List<Object> object = versionService.executeSelectSql("SELECT type FROM t_version WHERE type = 2");
//			if (object.size() > 0 || object != null) {
//				res.setHtype(object.get(0).toString());
//				res.setResult("0");
//				res.setResultNote("获取成功");
//			}
//
//		} catch (Exception e) {
//			log.error("请求处理异常：14746" );
//			e.printStackTrace();
//		}
//
//		return res;
//
//	}
//
//	/**
//	 * 4.27 商家端退出
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codeQuit(UserLoginReq req) {
//
//		ResJson res = new ResJson();
//		res.setResultNote("退出失败");
//		if (StringUtils.isBlank(req.getToken())) {
//			res.setResultNote("token为空");
//			return res;
//		}
//		try {
//			communityService.executeDeleteSql("DELETE FROM t_communnity_token WHERE token ='" + req.getToken() + "'");
//			res.setResult("0");
//			res.setResultNote("退出成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：14773" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 社区商品绑定微信
//	 *
//	 * @param req
//	 * @return
//	 * @throws Exception
//	 */
//	public ResJson communityBindWX(HttpServletRequest request, UserRegisterReq req) throws Exception {
//		UserLoginRes res = new UserLoginRes();
//		res.setResultNote("登录失败");
//		if (StringUtils.isBlank(req.getPhone())) {
//			res.setResultNote("手机号不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getOpenId())) {
//			res.setResultNote("微信id不能为空");
//			return res;
//		}
//		String ip = request.getRemoteAddr();// 获取客户端ip
//		String randomCodes = (String) CacheUtils.get("code" + req.getPhone(), "5");
//		if(null != randomCodes && randomCodes.length()>0) {
//			String[] randomCode = randomCodes.split(",");
//		if (null != randomCodes && Arrays.asList(randomCode).contains(req.getCode())==true) {// 验证验证码是否正确
//			User tuser = systemService.getCommunityByPhone(req.getPhone());// 查看是否已存在社区商户
//			if (null == tuser) {
//				res.setResultNote("非法的绑定！");
//				return res;
//			} else {
//				Community community = new Community();
//				community.setId(tuser.getCommunityid());
//				community.setOpenid(req.getOpenId());
//				communityService.bindOpenId(community);
//				res.setResult("0");
//			}
//			if ("0".equals(res.getResult())) {
//				CacheUtils.remove("code" + req.getPhone(), "5");
//				CacheUtils.remove("ip" + ip);
//				CacheUtils.remove("dateTime" + ip);
//			}
//		} else {
//			res.setResultNote("验证码不正确");
//			return res;
//		}
//	}else {
//		res.setResultNote("验证码不能为空");
//		return res;
//	}
//		res.setResultNote("商户微信绑定成功！");
//		return res;
//	}
//
//	/**
//	 * 社区商品绑定支付宝
//	 *
//	 * @param req
//	 * @return
//	 * @throws Exception
//	 */
//	public ResJson communityBindAliPay(HttpServletRequest request, UserRegisterReq req) throws Exception {
//		UserLoginRes res = new UserLoginRes();
//		res.setResultNote("登录失败");
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户ID不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getAlipayId())) {
//			res.setResultNote("支付宝id不能为空");
//			return res;
//		}
//		String ip = request.getRemoteAddr();// 获取客户端ip
//		Community community = communityService.get(req.getUid());// 查看是否已存在社区商户
//		if (null == community) {
//			res.setResultNote("非法的绑定！");
//			return res;
//		} else {
//			community.setId(req.getUid());
//			community.setAlipayid(req.getAlipayId());
//			communityService.bindAliPayId(community);
//			res.setResult("0");
//		}
//		if ("0".equals(res.getResult())) {
//			CacheUtils.remove("code" + req.getPhone(), "5");
//			CacheUtils.remove("ip" + ip);
//			CacheUtils.remove("dateTime" + ip);
//		}
//		res.setResultNote("商户支付宝绑定成功！");
//		return res;
//	}
//	/**
//	 * 经营统计
//	 * @param req
//	 * @return
//	 */
//	public ResJson operatingStatistics(UserStatisticsReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取信息失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			Map<String,String> map = new HashMap<String,String>();
//			UserVisitor uv=new UserVisitor();
//				uv.setCommunityId(req.getUid());
//				uv.setUid(req.getUid());
//				uv.setTimeType(req.getTimeType());
//			if (StringUtils.isNotBlank(req.getTimeType())) {
//				if(req.getTimeType().equals("1")||req.getTimeType().equals("3")){
//					uv.setAdtime(req.getAdtime());
//				}else if(req.getTimeType().equals("2")){
//					uv.setBeginTime(req.getBeginTime());
//					uv.setEndTime(req.getEndTime());
//				}
//			}else{
//				res.setResultNote("时间选项不能为空");
//				return res;
//			}
//			if(req.getPageCount()!=null&&req.getNowPage()!=null){
//				int size= req.getPageCount();
//				int num= req.getNowPage();
//				uv.setStart((num-1)*size);
//				uv.setSize(size);
//			 }
//			String visitorNum=us.selectUserVisitorNum(uv);
//			map=userOrderService.selectStatisticsInfo(uv);
//			map.put("visitorNum", visitorNum);
//			String newUser=userOrderService.selectNewUserOrder(uv);
//			String repurchaseNum=userOrderService.selectRepurchaseNum(uv);
//			String avgMoney=userOrderService.selectAvgMoney(uv);
//			List<Map<String,String>> categoryRanking=userOrderService.selectCategoryRanking(uv);
//			map.put("newUser", newUser);
//			map.put("repurchaseNum", repurchaseNum);
//			map.put("avgMoney", avgMoney);
//			res.setObject(map);
//			Map<String,Object> map2 = new HashMap<String,Object>();
//			if(categoryRanking!=null&&categoryRanking.size()>0){
//				res.setDataList(categoryRanking);
//				//map2.put("categoryRanking", categoryRanking);
//				res.setObjects(map2);
//			}
//			res.setResult("0");
//			res.setResultNote("获取信息成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：13423" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//	public ResJson categoryGoodsRanking(UserStatisticsReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取信息失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserVisitor uv=new UserVisitor();
//				uv.setCommunityId(req.getUid());
//				uv.setUid(req.getUid());
//				uv.setTimeType(req.getTimeType());
//				uv.setCategoryId(req.getCategoryId());
//			if (StringUtils.isNotBlank(req.getTimeType())) {
//				if(req.getTimeType().equals("1")||req.getTimeType().equals("3")){
//					uv.setAdtime(req.getAdtime());
//				}else if(req.getTimeType().equals("2")){
//					uv.setBeginTime(req.getBeginTime());
//					uv.setEndTime(req.getEndTime());
//				}
//			}else{
//				res.setResultNote("时间选项不能为空");
//				return res;
//			}
//			if(req.getPageCount()!=null&&req.getNowPage()!=null){
//				int size= req.getPageCount();
//				int num= req.getNowPage();
//				uv.setStart((num-1)*size);
//				uv.setSize(size);
//			 }
//			List<Map<String,String>> categoryGoodsRanking=userOrderService.selectCategoryGoodsRanking(uv);
//			Map<String,Object> map2 = new HashMap<String,Object>();
//			if(categoryGoodsRanking!=null&&categoryGoodsRanking.size()>0){
////				map2.put("categoryGoodsRanking", categoryGoodsRanking);
////				res.setObjects(map2);
//				res.setDataList(categoryGoodsRanking);
//				res.setResult("0");
//				res.setResultNote("获取信息成功");
//			}
//		} catch (Exception e) {
//			log.error("请求处理异常：13423" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//	public ResJson selectPayList(UserStatisticsReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取信息失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserVisitor uv=new UserVisitor();
//				uv.setCommunityId(req.getUid());
//				uv.setUid(req.getUid());
//				uv.setTimeType(req.getTimeType());
//			if (StringUtils.isNotBlank(req.getTimeType())) {
//				if(req.getTimeType().equals("1")||req.getTimeType().equals("3")){
//					uv.setAdtime(req.getAdtime());
//				}else if(req.getTimeType().equals("2")){
//					uv.setBeginTime(req.getBeginTime());
//					uv.setEndTime(req.getEndTime());
//				}
//			}else{
//				res.setResultNote("时间选项不能为空");
//				return res;
//			}
//			if(req.getPageCount()!=null&&req.getNowPage()!=null){
//				int size= req.getPageCount();
//				int num= req.getNowPage();
//				uv.setStart((num-1)*size);
//				uv.setSize(size);
//			 }
//			Map<String,Object> map2 = new HashMap<String,Object>();
//			List<Map<String,String>> selectPayList=userOrderService.selectPayList(uv);
//			if(selectPayList!=null&&selectPayList.size()>0){
//				res.setDataList(selectPayList);
//
//				//map2.put("selectPayList", selectPayList);
//				res.setObjects(map2);
//				res.setResult("0");
//				res.setResultNote("获取信息成功");
//			}
//		} catch (Exception e) {
//			log.error("请求处理异常：13423" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//	public ResJson goodsInfoModification(GoodsModificationReq req) {
//		ResJson res = new ResJson();
//		if (StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区id不能为空");
//			return res;
//		}
//		Community c = communityService.get(req.getUid());
//		if (null == c) {
//			res.setResultNote("商家不存在");
//			return res;
//		}
//		if (!"0".equals(c.getState())) {
//			res.setResultNote("该账号已被冻结");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getGoodsId())) {
//			res.setResultNote("商品id不能为空");
//			return res;
//		}
//		if (null == req.getCount()) {
//			res.setResultNote("库存数量不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getPrice())) {
//			res.setResultNote("价格不能为空");
//			return res;
//		}
//		if(!com.jeeplus.common.utils.StringUtils.isNumber(req.getPrice())){
//			res.setResultNote("非法请求");
//			return res;
//		}
//		if (Double.valueOf(req.getPrice())==0) {
//			res.setResultNote("价格不能为0");
//			return res;
//		}
//		GoodsCommunity gc = goodsCommunityService.gets(req.getUid(), req.getGoodsId());
//		if(req.getCuType()!=null&&req.getCuType().equals("1")){
//			if(StringUtils.isBlank(req.getCuprice())) {
//				res.setResultNote("促销价不可为空");
//				return res;
//			}
//			if(Double.valueOf(req.getCuprice())==0) {
//				res.setResultNote("促销价不可为0");
//				return res;
//			}
//			if(StringUtils.isBlank(req.getStartTime())) {
//				res.setResultNote("开始时间不可为空");
//				return res;
//			}
//			if(StringUtils.isBlank(req.getEndTime())) {
//				res.setResultNote("结束时间不可为空");
//				return res;
//			}
//			if(StringUtils.isNotBlank(gc.getGoodscuprice())&&Double.valueOf(req.getPrice())<=Double.valueOf(gc.getGoodscuprice())){
//				res.setResultNote("售价不能小于促销价");
//				return res;
//			}
//		}
// 		int m=0;
// 		String mess=null;
// 		Goods g = goodsService.get(req.getGoodsId());
//		if(null !=g && "1".equals(g.getFlag())){
//			mess="商品售价已被锁定，不允许修改";
//			req.setPrice(null);
//		}
//		GoodsCommunity gg=new GoodsCommunity();
//		if (gc != null && gc.getId().length() > 0) {
//			if (req.getCount() > 0) {
//				gg.setCommunityid(req.getUid());
//				gg.setStock(req.getCount());
//				gg.setGoodsprice(req.getPrice());
//				gg.setGoodsid(req.getGoodsId());
//				gg.setShelves("0");
//				m=goodsCommunityService.updateGoodsInfo(gg);
//			}else {
//				if(req.getCount()==0) {
//					gg.setStock(req.getCount());
//					gg.setCommunityid(req.getUid());
//					gg.setGoodsid(req.getGoodsId());
//					int t =goodsCommunityService.updateXj(gg);
//					if(t>0){
//						res.setResultNote("商品已下架！！");
//						return res;
//					}
//				}else {
//					res.setResultNote("提交的数量不规范，请重新输入");
//					return res;
//				}
//			}
//		}else{
//			gc = new GoodsCommunity();
//			gc.setCommunityid(req.getUid());
//			gc.setGoodsid(req.getGoodsId());
//			if (req.getCount() <= 0) {
//				gc.setStock(0);
//			} else {
//				gc.setStock(req.getCount());
//			}
//			gc.setGoodsprice(req.getPrice());
//			gc.setSallnum(0);
//			gc.setState("0");
//			gc.setAdtime(new Date());
//			gc.setId(IdGen.uuid());
//			m=gm.insert(gc);
//		}
//		if(req.getCuType()!=null&&req.getCuType().equals("1")){
//			if(m>0){
//				CommunityPrice cp = new CommunityPrice();
//				cp.setId(IdGen.uuid());
//				cp.setCommunityId(req.getCommunityId());
//				cp.setGoodsId(req.getGoodsId());
//				cp.setGoodsName(req.getGoodsName());
//				cp.setOptimizationid(req.getOptimizationId());
//				cp.setCuprice(req.getCuprice());
//				cp.setStartTime(req.getStartTime());
//				cp.setEndTime(req.getEndTime());
//				cp.setState("2");//取消价格审核
//				communityPriceService.save(cp);
//				res.setResult("0");
//				if(mess!=null){
//					res.setResultNote("商品库存和促销价格已修改成功，其中"+mess);
//				}else{
//					res.setResultNote("修改成功");
//				}
//			}else{
//				res.setResult("1");
//				res.setResultNote("修改失败，请于管理员联系！！");
//			}
//		}else{
//			if(m>0){
//				res.setResult("0");
//				if(mess!=null){
//					res.setResultNote("商品库存已修改成功，其中"+mess);
//				}else{
//					res.setResultNote("修改成功");
//				}
//			}else{
//				res.setResult("1");
//				res.setResultNote("修改失败，请于管理员联系！！");
//			}
//		}
//		return res;
//	}
//	/**
//	 * 结算详情1
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec6NewJs(UserStatisticsReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取信息失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			Map<String, Object> map = new HashMap<String, Object>();
//	/*		//支付宝待结算订单金额
//			String alMoney= userOrderService.selectAlMoney(req.getUid());
//			//加上逗邻币待结算订单金额(支付宝充值)
//			String alMoney2= userOrderService.selectAlMoney2(req.getUid());
//			map.put("alipaymoney", new BigDecimal(alMoney).add(new BigDecimal(alMoney2)).toString());
//			//微信待结算订单金额
//			String wxMoney= userOrderService.selectWxMoney(req.getUid());
//			//加上逗邻币待结算订单金额(微信充值)
//			String wxMoney2= userOrderService.selectWxMoney2(req.getUid());
//			map.put("wxpaymoney", new BigDecimal(wxMoney).add(new BigDecimal(wxMoney2)).toString());
//			//未确认订单金额
//			String unMoney= userOrderService.selectUnconfirmedMoney(req.getUid());
//			map.put("accountmoney", unMoney);*/
//			map=userOrderService.selectDetails(req.getUid());
//			//已结算金额
//			String sumMoney=userOrderService.selectSumMoney(req.getUid());
//			map.put("sumMoney", sumMoney);
//			/*UserVisitor uv=new UserVisitor();
//			uv.setCommunityId(req.getUid());
//			if(req.getPageCount()!=null&&req.getNowPage()!=null){
//				int size= req.getPageCount();
//				int num= req.getNowPage();
//				uv.setStart((num-1)*size);
//				uv.setSize(size);
//			 }
//			uv.setCommunityId(req.getUid());
//			uv.setAdtime(req.getAdtime());
//			uv.setTimeType(req.getTimeType());
//			uv.setUid(req.getUid());
//			if(StringUtils.isNotBlank(req.getType())&&req.getType().equals("1")){
//				List<Map<String,String>>settlement=userOrderService.selectSettlement(uv);
//				res.setDataList(settlement);
//			}else if (StringUtils.isNotBlank(req.getType())&&req.getType().equals("2")){
//				List<Map<String,String>>settlement=userOrderService.selectSettlementInfo(uv);
//				res.setDataList(settlement);
//			}*/
//			res.setObject(map);
//			res.setResult("0");
//			res.setResultNote("获取信息成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：3837" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//	//结算详情2
//	public ResJson codec6Detail(UserStatisticsReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取信息失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			Map<String, Object> map = new HashMap<String, Object>();
//			String sumMoney=userOrderService.selectSumMoney(req.getUid());
//			map.put("sumMoney", sumMoney);
//			UserVisitor uv=new UserVisitor();
//			uv.setCommunityId(req.getUid());
//			if(req.getPageCount()!=null&&req.getNowPage()!=null){
//				int size= req.getPageCount();
//				int num= req.getNowPage();
//				uv.setStart((num-1)*size);
//				uv.setSize(size);
//			 }
//			uv.setCommunityId(req.getUid());
//			uv.setAdtime(req.getAdtime());
//			uv.setTimeType(req.getTimeType());
//			uv.setUid(req.getUid());
//			if(StringUtils.isNotBlank(req.getType())&&req.getType().equals("1")){
//				List<Map<String,Object>>settlement=userOrderService.selectSettlement(uv);
//				res.setDataList(settlement);
//			}else if (StringUtils.isNotBlank(req.getType())&&req.getType().equals("2")){
//				List<Map<String,Object>>settlement=userOrderService.selectSettlementInfo(uv);
//				if(settlement!=null&&settlement.size()>0){
//					for(int i=0;i<settlement.size();i++){
//						if(settlement.get(i).get("ifIC").toString().equals("0")){
//							settlement.get(i).put("icon", filePath+settlement.get(i).get("icon"));
//						}
//					}
//				}
//				res.setDataList(settlement);
//			}
//			res.setObject(map);
//			res.setResult("0");
//			res.setResultNote("获取信息成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：3837" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//	/**
//	 * 4.3 未完成订单
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecNew(OrderListReq req) {
//		CompleteOrderRes res = new CompleteOrderRes();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("商户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserOrder userOrder = new UserOrder();
//			userOrder.setCommunityid(req.getUid());
//			userOrder.setCuType(req.getCuType());
//			userOrder.setType(req.getType());
//			userOrder.setOrdernum(req.getOrderNum());
//			if(req.getPageCount()!=null&&req.getNowPage()!=null){
//				int size= req.getPageCount();
//				int num= req.getNowPage();
//				userOrder.setStart((num-1)*size);
//				userOrder.setSize(size);
//			 }
//			List<UserOrder> pageInfo = userOrderService.selectOrderListNew(userOrder);
//			String sumOrder=userOrderService.selectCountOrderList(userOrder);
//			int totalPage=(int) Math.ceil(Double.valueOf(sumOrder)/req.getPageCount());
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<UserOrder> list = pageInfo;
//				if (null != list && list.size() > 0) {
//					for (UserOrder order : list) {
//						DecimalFormat df = new DecimalFormat("#0.00");
//						String allprice = df.format(order.getAllprice());
//						String payprice = df.format(order.getPayprice());
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("orderNum", order.getOrdernum());
//						map.put("orderType", order.getOrdertype());
//						map.put("oderAllPrice", allprice);
//						map.put("oderPayPrice", payprice);
//						map.put("orderState", order.getStatus());
//						map.put("adtime",
//								null != order.getAdtime()
//										? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(order.getAdtime())
//										: "");
//						map.put("userId", order.getUid());
//						map.put("message",order.getMessage());
//						map.put("userName", order.getUsername());
//						map.put("userPhone", order.getUserphone());
//						map.put("userAddress", order.getUsercity() + order.getUseraddress());
//						UserOrderlist userOrderlist = new UserOrderlist();
//						userOrderlist.setOrdernum(order.getOrdernum());
//						List<UserOrderlist> list2 = userOrderlistService.findList(userOrderlist);
//						List<Map<String, String>> goodsList = new ArrayList<Map<String, String>>();
//						if (null != list2 && list2.size() > 0) {
//							for (UserOrderlist uo : list2) {
//								Map<String, String> orderlistMap = new HashMap<String, String>();
//								orderlistMap.put("commodityid", uo.getGoodsid());
//								orderlistMap.put("commodityPic",
//										StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage()
//												: "");
//								orderlistMap.put("commodityTitle", uo.getGoodstitle());
//								orderlistMap.put("commodityDesc", uo.getGoodsdesc());
//								orderlistMap.put("commodityPrice", uo.getGoodsprice() + "");
//								orderlistMap.put("commodityBuyNum", uo.getGoodsnum() + "");
//								orderlistMap.put("goodsSpecification",StringUtils.isBlank(uo.getGoodsSpecification())?"":uo.getGoodsSpecification());
//								goodsList.add(orderlistMap);
//							}
//						}
//						map.put("orderCommodity", goodsList);
//						dataList.add(map);
//					}
//				}
//				List<Map<String, Object>>allOrderNum= userOrderService.selectOrderNumInfo(req.getUid());
//				res.setData(allOrderNum);
//			}
//			res.setDataList(dataList);
//			res.setTotalPage(totalPage);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：12399" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//	public ResJson codecActivityListNew(OrderListReq req) {
//		CompleteOrderRes res = new CompleteOrderRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("商户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserOrderGoods userOrder = new UserOrderGoods();
//			userOrder.setCommunityid(req.getUid());
//			userOrder.setType(req.getType());
//			if(req.getPageCount()!=null&&req.getNowPage()!=null){
//				int size= req.getPageCount();
//				int num= req.getNowPage();
//				userOrder.setStart((num-1)*size);
//				userOrder.setSize(size);
//			 }
//			List<Map<String,Object>> pageInfo = userOrderService.selectActivityListGoods(userOrder);
//			//String sumOrder=userOrderService.selectCountOrderList(userOrder);
//			//int totalPage=(int) Math.ceil(Double.valueOf(sumOrder)/req.getPageCount());
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<Map<String,Object>> list = pageInfo;
//				if (null != list && list.size()>0) {
//					for(int i = 0; i < list.size(); i++){
//						Map<String, Object> map =list.get(i);
//						userOrder.setActivityid(map.get("id").toString());
//						userOrder.setGoodsid(map.get("goodsId").toString());
//						List<UserOrderGoods>activityListOrder= userOrderService.selectActivityListOrder(userOrder);
//						String total= userOrderService.selectCountActivityListOrder(userOrder);
//						List<Map<String, Object>> goodsList = new ArrayList<Map<String, Object>>();
//						if(activityListOrder!=null &&activityListOrder.size()>0){
//							for (UserOrderGoods uo : activityListOrder) {
//								Map<String, Object> orderlistMap = new HashMap<String, Object>();
//								orderlistMap.put("commodityid", uo.getGoodsid());
//								orderlistMap.put("commodityPic",
//										StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage()
//												: "");
//								orderlistMap.put("message", uo.getMessage());
//								orderlistMap.put("commodityTitle", uo.getGoodstitle());
//								orderlistMap.put("commodityDesc", uo.getGoodsdesc());
//								orderlistMap.put("commodityPrice", uo.getGoodsprice() + "");
//								orderlistMap.put("commodityBuyNum", uo.getGoodsnum() + "");
//								orderlistMap.put("goodsSpecification",StringUtils.isBlank(uo.getGoodsSpecification())?"":uo.getGoodsSpecification());
//								DecimalFormat df = new DecimalFormat("#0.00");
//								String allprice = df.format(uo.getAllprice());
//								String payprice = df.format(uo.getPayprice());
//								orderlistMap.put("orderNum", uo.getOrdernum());
//								orderlistMap.put("orderType", uo.getOrdertype());
//								orderlistMap.put("oderAllPrice", allprice);
//								orderlistMap.put("oderPayPrice", payprice);
//								orderlistMap.put("orderState", uo.getStatus());
//								orderlistMap.put("adtime",
//										null != uo.getAdtime()? uo.getAdtime(): "");
//								orderlistMap.put("userId", uo.getUid());
//								orderlistMap.put("userName", uo.getUsername());
//								orderlistMap.put("userPhone", uo.getUserphone());
//								orderlistMap.put("userAddress", uo.getUsercity() + uo.getUseraddress());
//								goodsList.add(orderlistMap);
//							}
//						}else{
//							list.remove(i);
//							continue;
//						}
//						map.put("orderCommodity", goodsList);
//						map.put("TotalNum", total);
//						dataList.add(map);
//					}
//				List<Map<String,Object>> activityOrderNum=userOrderService.selectActivityOrderNum(req.getUid());
//				res.setData(activityOrderNum);
//				}
//				int totalPage=(int) Math.ceil(Double.valueOf(list.size())/req.getPageCount());
//				res.setTotalPage(totalPage);
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：4023" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//	public ResJson codecOrderListInfo(OrderListReq req) {
//		CompleteOrderRes res = new CompleteOrderRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("商户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserOrderGoods userOrder = new UserOrderGoods();
//			userOrder.setCommunityid(req.getUid());
//			userOrder.setType(req.getType());
//			if(req.getPageCount()!=null&&req.getNowPage()!=null){
//				int size= req.getPageCount();
//				int num= req.getNowPage();
//				userOrder.setStart((num-1)*size);
//				userOrder.setSize(size);
//			 }
//				userOrder.setActivityid(req.getActivityId());
//				userOrder.setGoodsid(req.getGoodsId());
//				List<UserOrderGoods>activityListOrder= userOrderService.selectActivityListOrder(userOrder);
//				String total= userOrderService.selectCountActivityListOrder(userOrder);
//				int totalPage=(int) Math.ceil(Double.valueOf(total)/req.getPageCount());
//				List<Map<String, Object>> goodsList = new ArrayList<Map<String, Object>>();
//				if(activityListOrder!=null &&activityListOrder.size()>0){
//					for (UserOrderGoods uo : activityListOrder) {
//						Map<String, Object> orderlistMap = new HashMap<String, Object>();
//						orderlistMap.put("commodityid", uo.getGoodsid());
//						orderlistMap.put("commodityPic",
//								StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage()
//												: "");
//						orderlistMap.put("commodityTitle", uo.getGoodstitle());
//						orderlistMap.put("commodityDesc", uo.getGoodsdesc());
//						orderlistMap.put("commodityPrice", uo.getGoodsprice() + "");
//						orderlistMap.put("commodityBuyNum", uo.getGoodsnum() + "");
//						orderlistMap.put("message", uo.getMessage());
//						orderlistMap.put("goodsSpecification",StringUtils.isBlank(uo.getGoodsSpecification())?"":uo.getGoodsSpecification());
//						DecimalFormat df = new DecimalFormat("#0.00");
//						String allprice = df.format(uo.getAllprice());
//						String payprice = df.format(uo.getPayprice());
//						orderlistMap.put("orderNum", uo.getOrdernum());
//						orderlistMap.put("orderType", uo.getOrdertype());
//						orderlistMap.put("oderAllPrice", allprice);
//						orderlistMap.put("oderPayPrice", payprice);
//						orderlistMap.put("orderState", uo.getStatus());
//						orderlistMap.put("adtime",
//										null != uo.getAdtime()? uo.getAdtime(): "");
//						orderlistMap.put("userId", uo.getUid());
//						orderlistMap.put("userName", uo.getUsername());
//						orderlistMap.put("userPhone", uo.getUserphone());
//						orderlistMap.put("userAddress", uo.getUsercity() + uo.getUseraddress());
//						goodsList.add(orderlistMap);
//				}
//			}
//			res.setDataList(goodsList);
//			res.setTotalPage(totalPage);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：4096" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//	public ResJson codecAog(OrderListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("操作失败");
//		String content = "";
//		String title = "";
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserOrder us=new UserOrder();
//			us.setCommunityid(req.getUid());
//			us.setActivityid(req.getActivityId());
//			us.setUid(req.getUid());
//			us.setGoodsid(req.getGoodsId());
//			List<UserOrder> ud = userOrderService.selectOrderAog(us);
//			if(null!=ud &&ud.size()>0){
//				for(UserOrder userOrder : ud){
////					userOrder.setStatus("3");
////					userOrder.setSendtime(new Date());
//					content = "您的团购订单产品已到货,订单号为：" + userOrder.getOrdernum() + ",快去看看吧！";
//					title = "产品到货";
//					res.setResultNote("产品到货");
////					userOrder.setUpdatetime(new Date());
////					userOrderService.update(userOrder);
//					try {// 给用户推送
//						Tuser u = tuserService.get(userOrder.getUid());
//						if (u.getToken() != null && !"".equals(u.getToken())) {
//							PushResult result = new PushExample().registerTitle(title, content, u.getToken(),null);
//							 System.out.println("p===" + result);
//						}
//						Msg m = new Msg();
//						m.setId(IdGen.uuid());
//						m.setType("1");
//						m.setHtype("1");
//						m.setUid(u.getId());
//						m.setTitle(title);
//						m.setContent(content);
//						m.setUrl(userOrder.getOrdernum());
//						m.setStatus("");
//						m.setAdtime(new Date());
//						msgService.addMsg(m);
//					} catch (Exception e) {
//						log.error("请求处理异常：4170" );
//						e.printStackTrace();
//					}
//					res.setResult("0");
//				}
//			}else{
//				res.setResult("1");
//				res.setResultNote("所有用户都已提货！");
//			}
//		/*	if ("0".equals(req.getType())) {// 发货*/
//			/*	userOrder.setStatus("3");
//				userOrder.setSendtime(new Date());
//				content = "您的订单已经发货,订单号为：" + userOrder.getOrdernum() + ",快去看看吧！";
//				title = "订单发货";
//				res.setResultNote("发货成功");*/
//			/*} else {// 取货
//				userOrder.setStatus("5");
//				userOrder.setGettime(new Date());
//				content = "您的订单已完成取件,订单号为：" + userOrder.getOrdernum() + ",快去看看吧！";
//				title = "订单取件";
//				res.setResultNote("取件成功");
//			}*/
//
//		return res;
//	}
//	public ResJson codec2Difference(CancelUserOrderReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("订单状态异常 ");
//		String content = "";
//		String title = "";
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("订单不存在");
//				return res;
//			}
//			String rs=null;
//			if(userOrder.getDifferenceReason()!=null&&userOrder.getDifferenceReason()!=""){
//				rs=userOrder.getDifferenceReason()+";"+req.getDifferenceReason();
//			}else{
//				rs=req.getDifferenceReason();
//			}
//			double dp;
//			if(userOrder.getDifferencePrice()!=null&&userOrder.getDifferencePrice()>0){
//				 BigDecimal b2 = new BigDecimal(req.getDifferencePrice()+"");
//				BigDecimal b1 = new BigDecimal(userOrder.getDifferencePrice()+"");
//			    dp= b1.add(b2).doubleValue();
//			}else{
//				dp=0.00+req.getDifferencePrice();
//			}
//			  BigDecimal b3 = new BigDecimal(userOrder.getAllprice()+"");
//			  BigDecimal bPay=new BigDecimal(b3.divide(new BigDecimal(2.0),2,BigDecimal.ROUND_HALF_UP).doubleValue()+"");
//			if( bPay.compareTo(new BigDecimal(dp+""))<0){
//				res.setResultNote("退还差价金额不得大于支付金额的50%");
//				return res;
//			}
//				title = "退还差价成功";
//				content = "您的订单：" + userOrder.getOrdernum() + "退还差价成功，资金已原路返回！";
//				Tuser user = tuserService.get(userOrder.getUid());
//				if ("0".equals(userOrder.getPaytype())) {// 零钱
//					// 退款
//					user.setBalance(user.getBalance() +req.getDifferencePrice());
//					tuserService.updateUser(user);
//					BigDecimal bd = new BigDecimal(req.getDifferencePrice());
//					double getMoney = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//					bd = new BigDecimal(user.getBalance());
//					double getBalance = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//					// 插入零钱明细
//					UserMoney sd = new UserMoney();
//					sd.setId(IdGen.uuid());
//					sd.setUid(userOrder.getUid());
//					sd.setTitle("退款差额");
//					sd.setMoney("+" + getMoney);
//					sd.setBalance(getBalance + "");
//					sd.setTransactionId(userOrder.getOrdernum());
//					sd.setSign(Base64Utils.byte2Base64(AESUtils.encryptAES((user.getBalance() + "").getBytes(), AESUtils.loadKeyAES(KeyUtil.AES_KEY), AESUtils.loadIvAES(KeyUtil.AES_KEY))));
//					sd.setType("0");
//					sd.setHtype("0");
//					sd.setAdtime(new Date());
//					usermoneyService.addUserMoney(sd);
//				} else {
//					if ("1".equals(userOrder.getPaytype())) {
//						new AlipayConfig().differenceAlipay(userOrder.getOrdernum(),req.getDifferencePrice());
//
//					} else if ("2".equals(userOrder.getPaytype())) {// 微信退款
//						WXConfig.wxDifferencePay(userOrder.getOrdernum(),req.getDifferencePrice());
//					}
//				}
//			BigDecimal b1 = new BigDecimal(req.getDifferencePrice()+"");
//		    BigDecimal b2 = new BigDecimal(userOrder.getPayprice()+"");
//		    double py= b2.subtract(b1).doubleValue();
//			userOrder.setRefundshentime(new Date());
//			userOrder.setDifferenceReason(rs);
//			userOrder.setUpdatetime(new Date());
//			userOrder.setPayprice(py);
//			userOrder.setDifferencePrice(dp);
//			userOrderService.update(userOrder);
//			try {// 给用户推送
//				Tuser u = tuserService.get(userOrder.getUid());
//
//				if (u.getToken() != null && !"".equals(u.getToken())) {
//					PushResult result = new PushExample().registerTitle(title, content, u.getToken(),null);
//					 System.out.println("p===" + result);
//				}
//				Msg m = new Msg();
//				m.setId(IdGen.uuid());
//				m.setType("1");
//				m.setHtype("1");
//				m.setUid(u.getId());
//				m.setTitle(title);
//				m.setContent(content);
//				m.setUrl(userOrder.getOrdernum());
//				m.setStatus("");
//				m.setAdtime(new Date());
//				msgService.addMsg(m);
//			} catch (Exception e) {
//				log.error("请求处理异常：4263" );
//				e.printStackTrace();
//			}
//			res.setResult("0");
//			res.setResultNote("退还差价成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：4270" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//	/**
//	 * 4.22 编辑店铺信息
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec711(UserTixianReq req) {
//		CommunityShopDetailRes res = new CommunityShopDetailRes();
//		res.setResultNote("编辑失败");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("商家ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderType())) {
//				res.setResultNote("类型不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getStartTime() + "")) {
//				res.setResultNote("开始时间不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getEndTime() + "")) {
//				res.setResultNote("结束时间不能为空");
//				return res;
//			}
//			String id= communityService.execSelectSqlString("SELECT id FROM t_merchant_rest WHERE communityid = '"+req.getUid()+"' AND state='0'");
//			if(null != id && !"".equals(id)) {
//				communityService.executeUpdateSql("UPDATE t_merchant_rest SET startTime='"+req.getStartTime()+"', endTime='"+req.getEndTime()+"',adtime=NOW() WHERE id='"+id+"'");
//			}else {
//				String date = DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(new Date());
//				communityService.executeInsertSql(
//						"INSERT INTO t_merchant_rest(id,communityid,startTime,endTime,state,adtime) VALUE('" + IdGen.uuid()
//								+ "','" + req.getUid() + "','" + req.getStartTime() + "','" + req.getEndTime()
//								+ "','0','" + date + "')");
//			}
//			Community c = communityService.get(req.getUid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该账号已被冻结");
//				return res;
//			}
//			if ("0".equals(req.getOrderType())) {// 新鲜果蔬
//				c.setShopname1(req.getShopname());
//				c.setShopphone1(req.getShopphone());
//				c.setShoptime1(req.getShoptime1());
//				c.setShoptime11(req.getShoptime2());
//			} else if ("1".equals(req.getOrderType())) {// 洗衣洗鞋
//				c.setShopname2(req.getShopname());
//				c.setShopphone2(req.getShopphone());
//				c.setShoptime2(req.getShoptime1());
//				c.setShoptime22(req.getShoptime2());
//			} else if ("2".equals(req.getOrderType())) {// 超市便利
//				c.setShopname3(req.getShopname());
//				c.setShopphone3(req.getShopphone());
//				c.setShoptime3(req.getShoptime1());
//				c.setShoptime33(req.getShoptime2());
//			}
//			communityService.save(c);
//			res.setResult("0");
//			res.setResultNote("编辑成功");
//		} catch (Exception e) {
//			log.error("请求处理异常：14434" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//
}
