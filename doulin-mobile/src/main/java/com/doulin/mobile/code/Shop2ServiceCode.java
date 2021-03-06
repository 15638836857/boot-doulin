//package com.doulin.mobile.code;
//
//import java.io.File;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import com.jeeplus.common.utils.CacheUtils;
//import com.jeeplus.common.utils.Chinese2PYUtils;
//import com.jeeplus.common.utils.DateUtils;
//import com.jeeplus.common.utils.IdGen;
//import com.jeeplus.common.utils.encryalgo.AESUtils;
//import com.jeeplus.common.utils.encryalgo.Base64Utils;
//import com.jeeplus.common.utils.encryalgo.KeyUtil;
//import com.jeeplus.common.utils.time.DateFormatUtil;
//import com.jeeplus.core.persistence.Page;
//import com.jeeplus.core.security.token.JwtToken;
//import com.jeeplus.modules.comment.entity.Comment;
//import com.jeeplus.modules.comment.service.CommentService;
//import com.jeeplus.modules.community.entity.Community;
//import com.jeeplus.modules.community.service.CommunityService;
//import com.jeeplus.modules.communityshop.entity.CommunityShop;
//import com.jeeplus.modules.communityshop.entity.CommunityShopGoods;
//import com.jeeplus.modules.communityshop.service.CommunityShopService;
//import com.jeeplus.modules.msg.entity.Msg;
//import com.jeeplus.modules.msg.service.MsgService;
//import com.jeeplus.modules.req.AddUserCartReq;
//import com.jeeplus.modules.req.CancelUserOrderReq;
//import com.jeeplus.modules.req.EvaluateOrder1Req;
//import com.jeeplus.modules.req.FindUserPasswordReq;
//import com.jeeplus.modules.req.GetCommunityPrice;
//import com.jeeplus.modules.req.GetCommunityReq;
//import com.jeeplus.modules.req.GetMerchantVersionReq;
//import com.jeeplus.modules.req.GetMerchantsShelvesReq;
//import com.jeeplus.modules.req.GetPeriodTimeReq;
//import com.jeeplus.modules.req.UserLoginReq;
//import com.jeeplus.modules.req.UserOrderDetailReq;
//import com.jeeplus.modules.req.UserOrderListReq;
//import com.jeeplus.modules.req.UserTixianReq;
//import com.jeeplus.modules.res.CommunityShopDetailRes;
//import com.jeeplus.modules.res.CompleteOrderRes;
//import com.jeeplus.modules.res.FindListeRes;
//import com.jeeplus.modules.res.GetMerchanVersionRes;
//import com.jeeplus.modules.res.ResJson;
//import com.jeeplus.modules.res.UserLoginRes;
//import com.jeeplus.modules.res.UserOrderDetailRes;
//import com.jeeplus.modules.res.UserScoreListRes;
//import com.jeeplus.modules.shoporder.entity.ShopOrder;
//import com.jeeplus.modules.shoporder.entity.ShopOrderlist;
//import com.jeeplus.modules.shoporder.service.ShopOrderService;
//import com.jeeplus.modules.sys.service.SystemService;
//import com.jeeplus.modules.user.entity.Tuser;
//import com.jeeplus.modules.user.service.TuserService;
//import com.jeeplus.modules.usermoney.entity.UserMoney;
//import com.jeeplus.modules.usermoney.service.UserMoneyService;
//import com.jeeplus.modules.userorder.entity.UserOrder;
//import com.jeeplus.modules.version.service.VersionService;
//import com.jeeplus.modules.webhook.AlipayConfig;
//import com.jeeplus.modules.webhook.WXConfig;
//import com.jeeplus.push.PushExample;
//import com.jeeplus.utils.Base64ToImageUtil;
//import com.jeeplus.utils.DateTimeUtil;
//
//import cn.jpush.api.push.PushResult;
//
///**
// * ?????????????????????
// * @author Administrator
// * @date: 2019???4???15???
// */
//@Service
//public class Shop2ServiceCode{
//
//	/**
//	 * ????????????
//	 */
//	protected Logger logger = LoggerFactory.getLogger(getClass());
//	/**
//	 * ????????????
//	 */
//	@Value("${filePath}")
//	protected String filePath;
//	@Autowired
//	private TuserService tuserService;
//	@Autowired
//	private MsgService msgService;
//	@Autowired
//	private CommentService commentService;
//	@Autowired
//	private ShopOrderService shopOrderService;
//	@Autowired
//	private UserMoneyService usermoneyService;
//	@Autowired
//	private VersionService versionService;
//	@Autowired
//	private CommunityShopService communityShopService;
//	@Autowired
//	private CommonServiceCode csc;
//	@Autowired
//	private CommunityService communityservice;
//	/**
//	 * 5.1????????????
//	 *
//	 * @param req
//	 * @return
//	 * @throws Exception
//	 */
//	public ResJson codec1(HttpServletRequest request, UserLoginReq req) throws Exception {
//		UserLoginRes res = new UserLoginRes();
//		res.setResultNote("????????????");
//		if (StringUtils.isBlank(req.getPhone())) {
//			res.setResultNote("?????????????????????");
//			return res;
//		}
//		CommunityShop c = communityShopService.findUniqueByProperty("phone", req.getPhone());
//		if (StringUtils.isBlank(req.getPassword())) {
//			res.setResultNote("??????????????????");
//			return res;
//		}
//		if (null == c){
//			res.setResultNote("????????????????????????????????????");
//			return res;
//		}
//		if (null == c || !SystemService.validatePassword(req.getPassword(), c.getPassword())) {
//			res.setResultNote("????????????????????????");
//			return res;
//		} else if (!"0".equals(c.getState())) {
//			res.setResultNote("?????????????????????");
//			return res;
//		}
//		res.setResult("0");
//		res.setResultNote("????????????");
//		Tuser tuser = new Tuser();
//		tuser.setId(c.getId());
//		tuser.setPassword(c.getPassword());
//		res.setToken(JwtToken.createToken(request, tuser));
//		res.setUid(c.getId());
//		return res;
//	}
//
//	/**
//	 * 5.2 ??????????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(FindUserPasswordReq req, HttpServletRequest request) {
//		ResJson res = new ResJson();
//		res.setResultNote("????????????");
//		try {
//			if (StringUtils.isBlank(req.getPhone())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getPassword())) {
//				res.setResultNote("??????????????????");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCodeType())) {
//				res.setResultNote("???????????????????????????");
//				return res;
//			}
//			String ip = request.getRemoteAddr();
//
////			String authCode = csc.codeBoolean(req.getPhone(), req.getCodeType(), req.getCode(), ip);
////			if ("1".equals(authCode)) {
////				res.setResultNote("??????????????????");
////				return res;
////			} else if ("2".equals(authCode)) {
////				res.setResultNote("???????????????");
////				return res;
////			}
//			CommunityShop c = communityShopService.findUniqueByProperty("phone", req.getPhone());
//			if (null == c) {
//				res.setResultNote("?????????????????????");
//			} else if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//			} else {
//				c.setPassword(SystemService.entryptPassword(req.getPassword()));
//				communityShopService.update(c);
//				res.setResult("0");
//				res.setResultNote("????????????");
//				CacheUtils.remove("code" + req.getPhone(), req.getCodeType());
//				CacheUtils.remove("ip" + ip, req.getCodeType());
//				CacheUtils.remove("dateTime" + ip, req.getCodeType());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.3 ????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(UserOrderListReq req) {
//		CompleteOrderRes res = new CompleteOrderRes();
//		res.setResultNote("????????????");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			CommunityShop c = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == c) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			ShopOrder userOrder = new ShopOrder();
//			userOrder.setShopId(req.getUid());
//			if("0".equals(req.getOrderState())){
//				userOrder.setDataScope(" and a.status in (2,3,4)");
//			}else if("2".equals(req.getOrderState())){
//				userOrder.setDataScope(" and a.status = 2 ");
//			}else if("3".equals(req.getOrderState())){
//				userOrder.setDataScope(" and a.status = 3 ");
//			}else if("7".equals(req.getOrderState())){
//				userOrder.setDataScope(" and a.status in (4,7) ");
//			}
//			List<ShopOrder> pageInfo = shopOrderService.findList(userOrder);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<ShopOrder> list = pageInfo;
//				if (null != list && list.size() > 0) {
//					for (ShopOrder order : list) {
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("orderNum", order.getOrderNum());
//						map.put("oderPayPrice", order.getPayPrice());
//						map.put("orderState", order.getStatus());
//						map.put("adtime",null != order.getAdtime()? DateUtils.formatDateTime(order.getAdtime()): "");
//						map.put("userId", order.getUid());
//						map.put("userName", order.getUserName());
//						map.put("userPhone", order.getUserPhone());
//						map.put("userAddress", order.getUserCity() + order.getUserAddress());
//						map.put("message", order.getMessage());
//						map.put("atHomeTime", null != order.getAtHomeTime()? DateUtils.formatDateTime(order.getAtHomeTime()): "");
//						ShopOrderlist shopOrderlist = new ShopOrderlist();
//						shopOrderlist.setOrdernum(order.getOrderNum());
//						List<ShopOrderlist> list2 = shopOrderService.findOrderList(shopOrderlist);
//						List<Map<String, String>> goodsList = new ArrayList<Map<String, String>>();
//						if (null != list2 && list2.size() > 0) {
//							for (ShopOrderlist uo : list2) {
//								Map<String, String> orderlistMap = new HashMap<String, String>();
//								orderlistMap.put("goodsId", uo.getGoodsid());
//								orderlistMap.put("goodsPic", StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage(): "");
//								orderlistMap.put("goodsTitle", uo.getGoodstitle());
//								orderlistMap.put("goodsPrice", uo.getGoodsprice() + "");
//								orderlistMap.put("goodsNum", uo.getGoodsnum() + "");
////								orderlistMap.put("goodsSpecification",StringUtils.isBlank(uo.getGoodsSpecification())?"":uo.getGoodsSpecification());
//								goodsList.add(orderlistMap);
//							}
//						}
//						map.put("orderCommodity", goodsList);
//						dataList.add(map);
//					}
//				}
//
//				List<Object> list1 = shopOrderService.executeSelectSql("select count(1) from t_shop_order where shopid='" + req.getUid()
//								+ "' and status in (2,3,4)");
//				res.setFreshNum(list1.get(0).toString());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????320" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.4 ????????????(8?????????)??????????????????????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2Refund(CancelUserOrderReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("?????????????????? ");
//		String content = "";
//		String title = "";
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			CommunityShop c = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == c) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			ShopOrder userOrder = shopOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("???????????????");
//				return res;
//			} else if (!"7".equals(userOrder.getStatus())) {
//				res.setResultNote("??????????????????");
//				return res;
//			}
//			if ("0".equals(req.getType())) {// ??????
//				userOrder.setStatus("4");
//				title = "????????????";
//				content = "???????????????" + userOrder.getOrderNum() + "???????????????????????????????????????";
//				Tuser user = tuserService.get(userOrder.getUid());
//				if ("0".equals(userOrder.getPayType())) {// ??????
//					// ??????
//					user.setBalance(user.getBalance() + new BigDecimal(userOrder.getPayPrice()).setScale(2, BigDecimal.ROUND_UP).doubleValue());
//					tuserService.updateUser(user);
//					BigDecimal bd = new BigDecimal(userOrder.getPayPrice());
//					double getMoney = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//					bd = new BigDecimal(user.getBalance());
//					double getBalance = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//					// ??????????????????
//					UserMoney sd = new UserMoney();
//					sd.setId(IdGen.uuid());
//					sd.setUid(userOrder.getUid());
//					sd.setTitle("??????");
//					sd.setMoney("+" + getMoney);
//					sd.setBalance(getBalance + "");
//					sd.setTransactionId(userOrder.getOrderNum());
//					sd.setSign(Base64Utils.byte2Base64(AESUtils.encryptAES((user.getBalance() + "").getBytes(), AESUtils.loadKeyAES(KeyUtil.AES_KEY), AESUtils.loadIvAES(KeyUtil.AES_KEY))));
//					sd.setType("0");
//					sd.setHtype("0");
//					sd.setAdtime(new Date());
//					usermoneyService.addUserMoney(sd);
//				} else {
//					if ("1".equals(userOrder.getPayType())) {
//						UserOrder uo = new UserOrder();
//						uo.setOrdernum(userOrder.getOrderNum());
//						uo.setPayprice(new BigDecimal(userOrder.getPayPrice()).setScale(2, BigDecimal.ROUND_UP).doubleValue());
//						new AlipayConfig().refundAlipay(uo);
//
//					} else if ("2".equals(userOrder.getPayType())) {// ????????????
//						UserOrder uo = new UserOrder();
//						uo.setOrdernum(userOrder.getOrderNum());
//						uo.setPayprice(new BigDecimal(userOrder.getPayPrice()).setScale(2, BigDecimal.ROUND_UP).doubleValue());
//						WXConfig.wxRefundPay(uo);
//					}
//				}
//			} else {
//				userOrder.setStatus("3");
//				title = "????????????";
//				content = "???????????????" + userOrder.getOrderNum() + "??????????????????????????????????????????????????????";
//			}
//			userOrder.setRefundshentime(new Date());
//			userOrder.setUpdateTime(new Date());
//			shopOrderService.update(userOrder);
//			try {// ???????????????
//				Tuser u = tuserService.get(userOrder.getUid());
//				if (u.getToken() != null && !"".equals(u.getToken())) {
//					PushResult result = new PushExample().registerTitle(title, content, u.getToken(),null);
//					 System.out.println("p===" + result);
//				}
//				//TODO ????????????????????? ????????????,????????????
////				List<ShopOrderlist> list1 = userOrder.getShopOrderlist();
////				if (list1 != null && list1.size() > 0) {
////					for (ShopOrderlist od : list1) {
////						GoodsCommunity g = goodsCommunityService.getGoodsStock(userOrder.getShopId(), od.getGoodsid());
////						if (!"1".equals(g.getType())) {
////							g.setStock(g.getStock() + od.getGoodsnum());
////						}
////						g.setSallnum(g.getSallnum() - od.getGoodsnum());
////						goodsCommunityService.save(g);
////					}
////				}
//				Msg m = new Msg();
//				m.setId(IdGen.uuid());
//				m.setType("3");
//				m.setHtype("1");
//				m.setUid(u.getId());
//				m.setTitle(title);
//				m.setContent(content);
//				m.setUrl(userOrder.getOrderNum());
//				m.setStatus("");
//				m.setAdtime(new Date());
//				msgService.addMsg(m);
//			} catch (Exception e) {
//				logger.error("?????????????????????388" );
//				e.printStackTrace();
//			}
////			res.setOrderState(userOrder.getState());
//			res.setResult("0");
//			res.setResultNote("??????????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????395" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.5 ????????????/????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec3(CancelUserOrderReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("????????????");
//		String content = "";
//		String title = "";
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			CommunityShop c = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == c) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			ShopOrder userOrder = shopOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("???????????????");
//				return res;
//			} else if (!"2".equals(userOrder.getStatus()) && !"4".equals(userOrder.getStatus())) {
//				// res.setResultNote("??????????????????");
//				res.setResultNote("???????????????");
//				res.setResult("0");
//				return res;
//			} else if ("8".equals(userOrder.getStatus())) {
//				res.setResultNote("?????????????????????????????????????????????");
//				return res;
//			}
//			userOrder.setStatus("3");
//			userOrder.setUpdateTime(new Date());
////			userOrder.setSendtime(new Date());
//			content = "????????????????????????????????????,???????????????" + userOrder.getOrderNum() + ",??????????????????";
//			title = "??????????????????";
//			shopOrderService.update(userOrder);
//			try {// ???????????????
//				Tuser u = tuserService.get(userOrder.getUid());
//				if (u.getToken() != null && !"".equals(u.getToken())) {
//					PushResult result = new PushExample().registerTitle(title, content, u.getToken(),null);
//					 System.out.println("p===" + result);
//				}
//				Msg m = new Msg();
//				m.setId(IdGen.uuid());
//				m.setType("3");
//				m.setHtype("1");
//				m.setUid(u.getId());
//				m.setTitle(title);
//				m.setContent(content);
//				m.setUrl(userOrder.getOrderNum());
//				m.setStatus("");
//				m.setAdtime(new Date());
//				msgService.addMsg(m);
//			} catch (Exception e) {
//				logger.error("?????????????????????467" );
//				e.printStackTrace();
//			}
//			res.setResult("0");
//			res.setResultNote("??????????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????473" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.6 ????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(CancelUserOrderReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("??????????????????");
//
//		try {
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			ShopOrder userOrder = new ShopOrder();
//			synchronized(this){
//				userOrder = shopOrderService.gets(req.getOrderNum());
//				if (null == userOrder) {
//					res.setResultNote("???????????????");
//					return res;
//				} else if (!"3".equals(userOrder.getStatus())) {
//					res.setResultNote("??????????????????");
//					return res;
//				}else if("5".equals(userOrder.getStatus())){
//					res.setResultNote("??????????????????");
//					return res;
//				}
//				/**
//				 * ??????????????????????????????????????????2019-01-10
//				 */
//				userOrder.setStatus("5");
//				userOrder.setIsaccount("1");//???????????????
//				userOrder.setUpdateTime(new Date());
//				shopOrderService.update(userOrder);
//				// ??????????????????
//				communityShopService.executeUpdateSql(" update t_community_shop set balance=balance+" + userOrder.getPayPrice()
//						+ " where id='" + userOrder.getShopId() + "'");
//				// ??????????????????
//				CommunityShop cs = communityShopService.findUniqueByProperty("id", userOrder.getShopId());
//				UserMoney sd = new UserMoney();
//				sd.setId(IdGen.uuid());
//				sd.setUid(userOrder.getShopId());
//				sd.setTitle("????????????");
//				sd.setMoney("+" + userOrder.getPayPrice());
//				sd.setTransactionId(userOrder.getOrderNum());
//				sd.setBalance(cs.getBalance());
//				sd.setType("0");
//				sd.setHtype("2");
//				sd.setSign(Base64Utils.byte2Base64(AESUtils.encryptAES(cs.getBalance().getBytes(),
//						AESUtils.loadKeyAES(KeyUtil.AES_KEY), AESUtils.loadIvAES(KeyUtil.AES_KEY))));
//				sd.setAdtime(new Date());
//				usermoneyService.addUserMoney(sd);
//			}
//			try {// ???????????????????????????
//				CommunityShop c = communityShopService.findUniqueByProperty("id", userOrder.getShopId());
//				String title = "????????????";
//				String content = "????????????????????????????????????,???????????????" + userOrder.getOrderNum() + ",??????????????????";
//				Msg m = new Msg();
//				m.setId(IdGen.uuid());
//				m.setType("2");
//				m.setHtype("1");
//				m.setUid(c.getId());
//				m.setTitle(title);
//				m.setContent(content);
//				m.setUrl(userOrder.getOrderNum());
//				m.setStatus("");
//				m.setAdtime(new Date());
//				msgService.addMsg(m);
//			} catch (Exception e) {
//				logger.error("?????????????????????542" );
//				e.printStackTrace();
//			}
//			res.setResult("0");
//			res.setResultNote("??????????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????548" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.7 ????????????
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec23New(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("????????????");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			CommunityShop c = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == c) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			CommunityShopGoods gc = new CommunityShopGoods();
//			gc.setFilePath(filePath);
//			gc.setShopid(req.getUid());
//			gc.setState(req.getState());
////			gc.setDataScope(" and a.state = 0");
//			if(null!=req.getContent()&&!"".equals(req.getContent())){
//				String searchKey = Chinese2PYUtils.getStringPinYin(req.getContent());
//				gc.setName(searchKey);
//			}
////			Page<CommunityShopGoods> page = new Page<CommunityShopGoods>();
////			page.setPageNo(req.getNowPage());
////			page.setPageSize(req.getPageCount());
//			List<CommunityShopGoods> list = communityShopService.findShopGoods(gc);
//			List<Map<String,Object>> dataList = Lists.newArrayList();
//			for(int i=0;i<list.size();i++){
//				CommunityShopGoods gc2 = list.get(i);
//				Map<String,Object> map = Maps.newHashMap();
//				map.put("goodsId", gc2.getId());
//				map.put("goodsName", gc2.getName());
//				map.put("goodsdesc", gc2.getGoodsdesc());
//				map.put("goodsImg", filePath + gc2.getImage());
//				map.put("goodsPrice", gc2.getPrice());
//				map.put("goodsSpec", gc2.getSpec());
//				map.put("goodsSallnum", gc2.getSallnum());
//				map.put("goodState", gc2.getState());
//				map.put("isAtHome", gc2.getIsathome());
//				dataList.add(map);
//			}
//			res.setDataList(dataList);
////			res.setTotalPage(pagelist.getTotalPage());
//			res.setResult("0");
//			res.setResultNote("????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????622" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.13 ????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec6(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("??????????????????");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			CommunityShop c = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == c) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			//TODO ??????????????????????????????
////			Tuser user = new Tuser();
////			user.setId(c.getId());
////			user.setBalance(Double.valueOf(c.getBalance()));
////			if(!csc.validateBalance(user,"2")){
////				csc.updateBalance(user,"2");
////			}
//
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("communityName", c.getName1());
//			map.put("nickname", c.getName());
//			map.put("icon", filePath + c.getImage());
//			map.put("phone", c.getPhone());
//
//			map.put("balance", c.getBalance());
//			map.put("address", c.getAddress());
//			String sql = "select ifnull(sum(payprice),0) from t_shop_order where shopid='" + req.getUid()
//					+ "' and isaccount=0 and status in (2,3,4,5)";
//			List<Object> list = communityShopService.executeSelectSql(sql);
//			map.put("accountmoney", list.get(0).toString());
//			sql = "select ifnull(sum(payprice),0) from t_shop_order where shopid='" + req.getUid()
//					+ "' and status in (2,3,4,5) and adtime>CURDATE()";
//			list = communityShopService.executeSelectSql(sql);
//			map.put("dayordermoney", list.get(0).toString());
//			sql = "select count(1) from t_shop_order where shopid='" + req.getUid()
//					+ "' and status in (2,3,4,5) and adtime>CURDATE()";
//			list = communityShopService.executeSelectSql(sql);
//			map.put("dayordernum", list.get(0).toString());
//			sql = "select count(1) from t_msg where type=3 and FIND_IN_SET('" + req.getUid()
//					+ "',uid) and !FIND_IN_SET('" + req.getUid() + "',status)";
//			list = communityShopService.executeSelectSql(sql);
//			map.put("messagenum", list.get(0).toString());
//			sql = "SELECT SUM(o.payprice) FROM t_shop_order o WHERE o.status in(2,3,4,5)AND o.shopid='"
//					+ c.getId() + "'";
//			list = communityShopService.executeSelectSql(sql);
//			if (list != null && list.size() > 0 && null != list.get(0)) {
//				map.put("allnum", list.get(0).toString());
//			} else {
//				map.put("allnum", "0");
//			}
////			map.put("openid", StringUtils.isBlank(c.getOpenid())?"0":"1");
////			map.put("alipayid", StringUtils.isBlank(c.getAlipayid())?"0":"1");
////			map.put("realname", StringUtils.isBlank(c.getRealname())?"0":"1");
//			res.setObject(map);
//			res.setResult("0");
//			res.setResultNote("??????????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????689" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.132 ?????????????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecTreeDetails(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("??????????????????");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			CommunityShop c = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == c) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//
////			Integer nowPage = (req.getNowPage() - 1) * req.getPageCount();
//			List<Object> totalPages = null;
//			List<ShopOrder> userOrderList = null;
//			ShopOrder user = new ShopOrder();
//			user.setShopId(c.getId());
////			user.setPageCount(req.getPageCount());
////			user.setNowPage(nowPage);
//			if (req.getIsaccount() != null && !"".equals(req.getIsaccount())) {
//				user.setIsaccount("0");
//				userOrderList = shopOrderService.selectTurnoverTodayList(user);
//				totalPages = shopOrderService.executeSelectSql(
//						"SELECT COUNT(id) from t_shop_order WHERE isaccount = '" + req.getIsaccount() + "'");
//			} else {
//				user.setPayTime(req.getAdtime());
//				userOrderList = shopOrderService.selectTurnoverTodayList(user);
//				if (null != req.getAdtime()) {
//					totalPages = shopOrderService
//							.executeSelectSql("SELECT COUNT(id) from t_shop_order WHERE  DATE(paytime) = DATE('"
//									+ req.getAdtime() + "')");
//				} else {
//					totalPages = shopOrderService.executeSelectSql("SELECT COUNT(id) from t_shop_order");
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
//				for (ShopOrder userOrder : userOrderList) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("username", userOrder.getUserName());
//					map.put("userphone", userOrder.getUserPhone());
//					map.put("ordernum", userOrder.getOrderNum());
//					map.put("payprice", userOrder.getPayPrice() + "");
//					map.put("status", userOrder.getStatus());
//					map.put("paytype", userOrder.getPayType());
//					map.put("paytime",
//							null != userOrder.getPayTime()
//									? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getPayTime())
//									: "");
//					dataList.add(map);
//
//				}
//
//			}
//			res.setTotalPage(totalPage);
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("??????????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????776" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.133 ?????????????????????
//	 */
//	public ResJson codePeriodTimeTreeVersion(GetPeriodTimeReq req) {
//		ResJson res = new ResJson();
//
//		if (StringUtils.isBlank(req.getCommunityid())) {
//			res.setResult("??????id????????????");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getStartTime() + "")) {
//			res.setResult("??????????????????");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getEndTime() + "")) {
//			res.setResult("??????????????????");
//			return res;
//		}
//		try {
//			List<Date> dates = csc.findDates(req.getStartTime(), req.getEndTime());
//			List<Map<String, String>> addList = new ArrayList<Map<String, String>>();
//			if (dates.size() != 0) {
//				for (Date date : dates) {
//					Map<String, String> map = new HashMap<>();
//					List<Object> payPrice = shopOrderService
//							.executeSelectSql("SELECT SUM(o.payprice) FROM t_shop_order o "
//									+ "WHERE o.status in(2,3,4,5) AND o.shopid='"
//									+ req.getUid() + "' AND DATE(o.paytime) = DATE('" + date + "')");
//					if (payPrice.size() != 0) {
//						map.put("payPrice", payPrice.get(0).toString());
//						map.put("date", date + "");
//						addList.add(map);
//					}
//				}
//				res.setDataList(addList);
//				res.setResult("0");
//				res.setResultNote("????????????");
//
//			}
//		} catch (Exception e) {
//			logger.error("?????????????????????821" );
//			e.printStackTrace();
//		}
//
//		return res;
//	}
//
//	/**
//	 * 5.14 ????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec7(HttpServletRequest request, AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("??????????????????");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getImage())) {
//				res.setResultNote("??????????????????");
//				return res;
//			}
//			CommunityShop c = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == c) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			String userIcon = req.getImage().replaceAll(" ", "+");
//			String realPath = request.getSession().getServletContext().getRealPath("userfiles/1/files/user/icon");
//			String[] split = DateTimeUtil.dateConvtoFmt(new Date(), "yyyy-MM").split("-"); // ??????????????????????????????
//			String dateDir = split[0] + "/" + split[1];
//			File path = new File(realPath + File.separator + dateDir);
//			if (!path.exists()) {
//				path.mkdirs();
//			}
//			String image = Base64ToImageUtil.GenerateImage(userIcon, path.getPath() + File.separator);
//			c.setImage("/wisdom/userfiles/1/files/user/icon/" + dateDir + "/" + image); // ??????
//			communityShopService.save(c);
////			try {// ?????????????????????
////				Wangyiyunxin.updateuser(c.getId(), c.getName1(), filePath + c.getImage());
////			} catch (Exception e) {
////				logger.error("?????????????????????869" );
////				e.printStackTrace();
////			}
//			res.setObject(filePath + c.getImage());
//			res.setResult("0");
//			res.setResultNote("??????????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????876" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.15 ????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec8(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("????????????????????????");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			CommunityShop c = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == c) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			Msg m = new Msg();
//			m.setType("3");
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
//						String orderNum = shopOrderService.execSelectSqlString(
//								"SELECT url FROM t_msg WHERE type=3 AND  htype =0 AND id='" + msg.getId() + "'");
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
//					+ "')" + "WHERE type=3 and FIND_IN_SET('" + req.getUid() + "',uid) AND !FIND_IN_SET('"
//					+ req.getUid() + "',status)";
//			msgService.executeUpdateSql(sql);
//			res.setTotalPage(pageList.getTotalPage());
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("????????????????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????942" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.17 ????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2(UserTixianReq req) {
//		UserScoreListRes res = new UserScoreListRes();
//		res.setResultNote("????????????");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			CommunityShop c = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == c) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//
//			UserMoney sd = new UserMoney();
//			sd.setUid(req.getUid());
//			sd.setHtype("2");
//			if (!StringUtils.isBlank(req.getMonth())) {
//				sd.setDataScope(" and a.adtime like '" + req.getMonth() + "%'");
//			}
//			Page<UserMoney> page = new Page<UserMoney>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			Page<UserMoney> sdPage = null;
//			sdPage = usermoneyService.findPage(page, sd);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			BigDecimal totle = new BigDecimal("0");
//			if (null != sdPage) {
//				List<UserMoney> list = sdPage.getList();
//				if (null != list && list.size() > 0) {
//					for (UserMoney um : list) {
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("title", um.getTitle());
//						map.put("money", um.getMoney());
//						totle = totle.add(new BigDecimal(um.getMoney()));
//						map.put("orderNum", um.getTransactionId());
//						map.put("balance", um.getBalance());
//						map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(um.getAdtime()));
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(sdPage.getTotalPage());
//			}
//			String sql = "SELECT 0-convert(ifnull(sum(money),0),decimal(10,2)) from t_user_money WHERE uid='" + req.getUid()
//					+ "' and htype=2 and money<0";
//			if (!StringUtils.isBlank(req.getMonth())) {
//				sql += " and adtime like '" + req.getMonth() + "%'";
//			}
//			List<Object> list = usermoneyService.executeSelectSql(sql);
//			res.setWithdrawcomey(list.get(0).toString());
////			sql = "SELECT convert(ifnull(sum(money),0),decimal(10,2)) from t_user_money WHERE uid='" + req.getUid()
////					+ "' and htype=2 and money>0";
////			if (!StringUtils.isBlank(req.getMonth())) {
////				sql += " and adtime like '" + req.getMonth() + "%'";
////			}
////			list = usermoneyService.executeSelectSql(sql);
//			res.setIncomemoney(totle.toString());
//			res.setBalance(c.getBalance() + "");
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????1018" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.19 ????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2RemittanceDetails(UserTixianReq req) {
//		UserScoreListRes res = new UserScoreListRes();
//		res.setResultNote("????????????");
//		res.setTotalPage(1);
//
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//
//			CommunityShop c = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == c) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//
//			List<Map<String,String>> ListEntity = null;
//			Map <String,Object> dateMap = new HashMap<>();
//			List<Object> dateList = new ArrayList<>();
//			if(StringUtils.isBlank(req.getDate())) {
//				List<Object> data=communityShopService.executeSelectSql("SELECT DATE(adtime) FROM t_shop1_settle WHERE shopid='"+c.getId()+"' GROUP BY DATE(adtime)");
//				for (Object object : data) {
//					ListEntity = communityShopService.execSelectSqlMap("SELECT unsettleorderpay AS unsettleorderpay,poundage AS poundage,arraccount AS arraccount,adtime AS adtime," +
//							"CASE paytype  WHEN  '1' THEN '???????????????' WHEN '2' THEN '????????????' ELSE '????????????' END  AS payType " +
//							" FROM t_shop1_settle WHERE shopid = '"+c.getId()+"' AND DATE(adtime) = '"+object.toString()+"' ORDER BY adtime DESC");
//					dateMap.put("date", object.toString());
//					dateMap.put("dataList", ListEntity);
//				}
//			}else {
//				ListEntity = communityShopService.execSelectSqlMap("SELECT unsettleorderpay AS unsettleorderpay,poundage AS poundage,arraccount AS arraccount,adtime AS adtime," +
//						"CASE paytype  WHEN  '1' THEN '???????????????' WHEN '2' THEN '????????????' ELSE '????????????' END  AS payType " +
//						" FROM t_shop1_settle WHERE shopid = '"+c.getId()+"' AND DATE(adtime) = '"+req.getDate()+"' ORDER BY adtime DESC");
//				dateMap.put("date", req.getDate());
//				dateMap.put("dataList", ListEntity);
//			}
//
//			String sumMoney = communityShopService.execSelectSqlString("SELECT IFNULL(SUM(arraccount),0) FROM t_shop1_settle WHERE shopid = '"+c.getId()+"' GROUP BY shopid");
//			dateList.add(dateMap);
//			res.setDataList(dateList);
//			res.setObject(sumMoney);
//		}catch (Exception e) {
//			logger.error("?????????????????????1076" );
//			e.printStackTrace();
//		}
//		 res.setResult("0");
//		 res.setResultNote("????????????");
//		return res;
//	}
//
//	/**
//	 * 5.18 ???????????? ?????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec3order(UserTixianReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("????????????");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			CommunityShop c = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == c) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			ShopOrder userOrder = new ShopOrder();
//			userOrder.setShopId(req.getUid());
//			if ("-1".equals(req.getOrderType())) {
//				userOrder.setDataScope("and a.status!=1");
//			} else {
//				userOrder.setDataScope("and a.status=5");
//			}
//
//			if (!StringUtils.isBlank(req.getOrderNum())) {
//				userOrder.setOrderNum(req.getOrderNum());
//			}
//
//			Page<ShopOrder> page = new Page<ShopOrder>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			Page<ShopOrder> pageInfo = shopOrderService.findPage(page, userOrder);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<ShopOrder> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (ShopOrder order : list) {
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("orderNum", order.getOrderNum());
//						map.put("oderPayPrice", order.getPayPrice());
//						map.put("orderState", order.getStatus());
//						map.put("userId", order.getUid());
//						map.put("userName", order.getUserName());
//						map.put("userPhone", order.getUserPhone());
//						map.put("userAddress", order.getUserCity() + order.getUserAddress());
//						map.put("message", order.getMessage());
//						map.put("atHomeTime", null != order.getAtHomeTime() ? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(order.getAtHomeTime()): "");
//						map.put("adtime", null != order.getAdtime() ? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(order.getAdtime()): "");
//						ShopOrderlist userOrderlist = new ShopOrderlist();
//						userOrderlist.setShopid(c.getId());
//						userOrderlist.setOrdernum(order.getOrderNum());
//						List<ShopOrderlist> list2 = shopOrderService.findOrderList(userOrderlist);
//						List<Map<String, String>> goodsList = new ArrayList<Map<String, String>>();
//						if (null != list2 && list2.size() > 0) {
//							for (ShopOrderlist uo : list2) {
//								Map<String, String> orderlistMap = new HashMap<String, String>();
//								orderlistMap.put("goodsId", uo.getGoodsid());
//								orderlistMap.put("goodsPic",
//										StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage()
//												: "");
//								orderlistMap.put("goodsTitle", uo.getGoodstitle());
//								orderlistMap.put("goodsDesc", uo.getGoodsdesc());
//								orderlistMap.put("goodsPrice", uo.getGoodsprice() + "");
//								orderlistMap.put("goodsNum", uo.getGoodsnum() + "");
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
//			res.setResultNote("????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????1168" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.21 ????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec6(UserTixianReq req) {
//		CommunityShopDetailRes res = new CommunityShopDetailRes();
//		res.setResultNote("????????????");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderType())) {
//				res.setResultNote("??????????????????");
//				return res;
//			}
//			CommunityShop c = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == c) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			res.setShopname(c.getName());
//			res.setShopphone(c.getPhone());
////			res.setShoptime1(c.getShoptime1());
////			res.setShoptime2(c.getShoptime11());
//
//			List<Object> startobject = communityShopService
//					.executeSelectSql("SELECT m.startTime FROM t_merchant_rest m WHERE m.communityid='" + req.getUid()
//							+ "' AND m.state='0'");
//			List<Object> endObject = communityShopService
//					.executeSelectSql("SELECT m.endTime FROM t_merchant_rest m WHERE m.communityid='" + req.getUid()
//							+ "' AND m.state='0'");
//			if (null != startobject && startobject.size() > 0) {
//				res.setStartTime(startobject.get(0).toString());
//				res.setEndTime(endObject.get(0).toString());
//			}
//			res.setResult("0");
//			res.setResultNote("????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????14380" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.22 ??????????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec7(UserTixianReq req) {
//		CommunityShopDetailRes res = new CommunityShopDetailRes();
//		res.setResultNote("????????????");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderType())) {
//				res.setResultNote("??????????????????");
//				return res;
//			}
//			CommunityShop c = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == c) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			c.setName(req.getShopname());
//			c.setPhone(req.getShopphone());
////			c.setShoptime1(req.getShoptime1());
////			c.setShoptime11(req.getShoptime2());
//
//			communityShopService.save(c);
//			res.setResult("0");
//			res.setResultNote("????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????1256" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.23 ??????????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec8(UserTixianReq req) {
//		CommunityShopDetailRes res = new CommunityShopDetailRes();
//		res.setResultNote("????????????");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderType())) {
//				res.setResultNote("??????????????????");
//				return res;
//			}
//			CommunityShop ccc = communityShopService.findUniqueByProperty("id", req.getUid());
//			if (null == ccc) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			if (!"0".equals(ccc.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			// ????????????
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
//					// ??????????????????
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
//					// ??????????????????
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
//			String sql = "select ROUND(ifnull(avg(a.star),0),1) from t_comment a left join t_shop_order o on o.ordernum = a.objid "
//					+ "where a.type=2 and o.shopid='" + req.getUid() + "'";
//			List<Object> score = communityShopService.executeSelectSql(sql);
//			res.setTotalPage(pageInfo.getTotalPage());
//			res.setShopStar(score.get(0).toString());
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????14535" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.50 ????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(UserOrderDetailReq req) {
//		UserOrderDetailRes res = new UserOrderDetailRes();
//		res.setResultNote("????????????");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//			ShopOrder userOrder = shopOrderService.gets(req.getOrderNum());
//			res.setUsername(userOrder.getUserName());
//			res.setUserPhone(userOrder.getUserPhone());
//			res.setCity(userOrder.getUserCity());
//			List<Object> communityName = shopOrderService.executeSelectSql(
//					"SELECT name1 FROM t_community WHERE id=(SELECT communityid FROM t_user WHERE id='" + req.getUid()
//							+ "')");
//			if (null != communityName && communityName.size() > 0 && null != communityName.get(0)) {
//				res.setCommunityName(communityName.get(0).toString());
//			}
//			res.setAddress(userOrder.getUserAddress());
//			res.setOderPayPrice(userOrder.getPayPrice() + "");
//			res.setOrderState(userOrder.getStatus());
//			res.setPayType(userOrder.getPayType());
//			res.setMessage(userOrder.getMessage());
//			res.setShopmessage(userOrder.getMessage());
//			res.setOrderNum(userOrder.getOrderNum());
//			res.setAtHomeTime(null != userOrder.getAtHomeTime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getAtHomeTime())	: "");
//			res.setAdtime(null != userOrder.getAdtime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getAdtime())	: "");
//			res.setPayTime(null != userOrder.getPayTime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getPayTime()) : "");
////			res.setRefundTime(null != userOrder.getRefundTime()
////					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getRefundTime())
////					: "");
////			res.setRefundShenTime(null != userOrder.getRefundshenTime()
////					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getRefundshenTime())
////					: "");
////			List<String> l = new ArrayList<>();
////			if (userOrder.getImg1() != null && userOrder.getImg1().length() > 0) {
////				l.add(StringUtils.isNotBlank(userOrder.getImg1()) && userOrder.getImg1().indexOf("http://") == -1
////						&& userOrder.getImg1().indexOf("https://") == -1 ? filePath + userOrder.getImg1()
////								: userOrder.getImg1());
////			}
////			if (userOrder.getImg2() != null && userOrder.getImg2().length() > 0) {
////				l.add(StringUtils.isNotBlank(userOrder.getImg2()) && userOrder.getImg2().indexOf("http://") == -1
////						&& userOrder.getImg2().indexOf("https://") == -1 ? filePath + userOrder.getImg2()
////								: userOrder.getImg2());
////			}
////			if (userOrder.getImg3() != null && userOrder.getImg3().length() > 0) {
////				l.add(StringUtils.isNotBlank(userOrder.getImg3()) && userOrder.getImg3().indexOf("http://") == -1
////						&& userOrder.getImg3().indexOf("https://") == -1 ? filePath + userOrder.getImg3()
////								: userOrder.getImg3());
////			}
////			res.setRefundPics(l);
//
//			List<Map<String, String>> commoditys = new ArrayList<Map<String, String>>();
//			ShopOrderlist userOrderlist = new ShopOrderlist();
//			userOrderlist.setOrdernum(userOrder.getOrderNum());
//			List<ShopOrderlist> list = shopOrderService.findOrderList(userOrderlist);
//			if (null != list && list.size() > 0) {
//				for (ShopOrderlist uo : list) {
//					Map<String, String> map = new HashMap<String, String>();
////					CommunityShopGoods goods = communityShopService.gets(uo.getGoodsid());
//					map.put("goodsId", uo.getGoodsid());
//					map.put("goodsPic", StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage() : "");
//					map.put("goodsTitle", uo.getGoodstitle());
//					map.put("goodsDesc", uo.getGoodsdesc());
//					map.put("goodsPrice", uo.getGoodsprice() + "");
//					map.put("goodsNum", uo.getGoodsnum() + "");
//					map.put("goodsSpec",StringUtils.isBlank(uo.getGoodsSpecification())?"":uo.getGoodsSpecification());
//					commoditys.add(map);
//				}
//			}
//
//			String sql = "update t_msg set status=CONCAT(IFNULL(status,''),'," + req.getUid() + "') WHERE type=3 and htype=1 and FIND_IN_SET('" + req.getUid() + "',uid) AND url = '" + req.getOrderNum() + "'";
//			msgService.executeUpdateSql(sql);
//			res.setOrderCommodity(commoditys);
//			res.setResult("0");
//			res.setResultNote("????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????5212" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.24????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson addCommentCodec(EvaluateOrder1Req req) {
//		ResJson res = new ResJson();
//		res.setResultNote("??????????????????");
//
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("??????ID????????????");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getOrderNum())) {
//			res.setResultNote("?????????????????????");
//			return res;
//		}
//
//		ShopOrder userOrder = shopOrderService.gets(req.getOrderNum());
//		if (null == userOrder || !req.getUid().equals(userOrder.getShopId())) {
//			res.setResultNote("???????????????");
//			return res;
//		}
//		// ??????????????????
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
//		m.setType("3");
//		m.setHtype("2");
//		m.setTitle("????????????");
//		m.setContent(req.getContent());
//		m.setUrl(id);
//		m.setStatus("");
//		m.setAdtime(new Date());
//		msgService.save(m);
//		res.setResult("0");
//		res.setResultNote("??????????????????");
//		return res;
//	}
//
//	/**
//	 * 5.27??????????????????
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson deleteCodec(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("????????????");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			Tuser user = tuserService.get(req.getUid());
//			if (null == user) {
//				res.setResultNote("???????????????");
//				return res;
//			} else if (!"0".equals(user.getStatus())) {
//				res.setResultNote("???????????????");
//				return res;
//			}
//			Comment c = commentService.get(req.getCommentId());
//			if (c != null) {
//				// ????????????
//				// ?????????????????????????????????
//				commentService.executeDeleteSql(
//						"delete from t_msg where htype=2 and url in (SELECT id from t_comment where pid='" + c.getId()
//								+ "')");
//				// ???????????????????????????
//				commentService.executeDeleteSql("delete from t_msg where htype=2 and url='" + c.getId() + "'");
//				// ???????????????????????????
//				commentService.executeDeleteSql("delete from t_comment where state=1 and pid='" + c.getId() + "'");
//				commentService.delete(c);
//			}
//			res.setResult("0");
//			res.setResultNote("????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????14632" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 5.25 ?????????????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codeMerchantsShelves(GetMerchantsShelvesReq req) {
//		ResJson res = new ResJson();
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("??????id????????????");
//			return res;
//		}
//
//		if (StringUtils.isBlank(req.getGoodsid())) {
//			res.setResultNote("??????id????????????");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getState())) {
//			res.setResultNote("??????????????????");
//			return res;
//		}
//		try {
//			if ("1".equals(req.getState())) {
//				communityShopService.executeUpdateSql("UPDATE t_community_shop_goods g SET g.state='" + req.getState()
//						+ "' WHERE shopid = '"+req.getUid()+"' and g.id='"	+ req.getGoodsid() + "'");
//				res.setResultNote("????????????");
//			} else if ("0".equals(req.getState())) {
//				communityShopService.executeUpdateSql("UPDATE t_community_shop_goods g SET g.state='" + req.getState()
//						+ "' WHERE shopid = '"+req.getUid()+"' and g.id='" + req.getGoodsid() + "'");
//				res.setResultNote("????????????");
//			}
//			res.setResult("0");
//
//		} catch (Exception e) {
//			logger.error("?????????????????????1493" );
//			e.printStackTrace();
//		}
//
//		return res;
//	}
//
//	/**
//	 * 5.28  ????????????????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codeCommunityPrice(GetCommunityPrice req) {
//		ResJson res = new ResJson();
//		if (StringUtils.isBlank(req.getShopId())) {
//			res.setResultNote("??????id????????????");
//			return res;
//		}
//
//		if (StringUtils.isBlank(req.getGoodsId())) {
//			res.setResultNote("??????id????????????");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getPrice())) {
//			res.setResultNote("??????????????????");
//			return res;
//		}
//		if(!com.jeeplus.common.utils.StringUtils.isNumber(req.getPrice())){
//			res.setResultNote("????????????");
//			return res;
//		}
//		try {
//			CommunityShopGoods gc = new CommunityShopGoods();
//			gc.setShopid(req.getShopId());
//			gc.setId(req.getGoodsId());
//			gc.setPrice(req.getPrice());
//			communityShopService.updateGoodsPrice(gc);
//			res.setResultNote("????????????????????????");
//			res.setResult("0");
//		} catch (Exception e) {
//			logger.error("?????????????????????15066" );
//			e.printStackTrace();
//		}
//
//		return res;
//	}
//
//	/**
//	 * 5.26 ?????????????????????????????????
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecMerchantVersion(GetMerchantVersionReq req) {
//		GetMerchanVersionRes res = new GetMerchanVersionRes();
//		res.setResultNote("??????????????????");
//		if (!"3".equals(req.getType())) {
//			res.setResultNote("????????????");
//			return res;
//		}
//		try {
//			List<Object> object = versionService.executeSelectSql("SELECT ptype FROM t_version WHERE type = 3 and version>"+req.getVersion()+" order by ptype desc,adtime desc");
//			if (object.size() > 0 && object != null) {
//				res.setHtype(object.get(0).toString());
//				res.setResult("0");
//				res.setResultNote("????????????");
//			}
//		} catch (Exception e) {
//			logger.error("?????????????????????1647" );
//			e.printStackTrace();
//		}
//		res.setResultNote("???????????????");
//		return res;
//	}
//	public ResJson codec3orderNew(UserTixianReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("????????????");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("??????ID????????????");
//				return res;
//			}
//			Community c = communityservice.get(req.getUid());
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("?????????????????????");
//				return res;
//			}
//	/*		ShopOrder userOrder = new ShopOrder();
//			userOrder.setShopId(req.getUid());
//			if ("-1".equals(req.getOrderType())) {
//				userOrder.setDataScope("and a.status!=1");
//			} else {
//				userOrder.setDataScope("and a.status=5");
//			}*/
//
//	/*		if (!StringUtils.isBlank(req.getOrderNum())) {
//				userOrder.setOrderNum(req.getOrderNum());
//			}*/
//			CommunityShop cs =new CommunityShop();
//			if(req.getPageCount()!=null&&req.getNowPage()!=null){
//				int size= req.getPageCount();
//				int num= req.getNowPage();
//				cs.setStart((num-1)*size);
//				cs.setSize(size);
//			 }
//			cs.setFilePath(filePath);
//			cs.setCommunityId(req.getUid());
//			List<Map<String, Object>> pageInfo=	communityShopService.selectShopOrderList(cs);
//			if (null != pageInfo) {
//				if (null != pageInfo && pageInfo.size() > 0) {
//					res.setTotalPage((int) Math.ceil(Double.valueOf(pageInfo.size())/req.getPageCount()));
//				}
//			}
//			res.setDataList(pageInfo);
//			res.setResult("0");
//			res.setResultNote("????????????");
//		} catch (Exception e) {
//			logger.error("?????????????????????1742" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//}