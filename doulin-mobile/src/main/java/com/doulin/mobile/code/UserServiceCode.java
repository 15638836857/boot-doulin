package com.doulin.mobile.code;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.doulin.common.content.SysContent;
import com.doulin.common.j2cache.CacheUtils;
import com.doulin.common.token.JwtToken;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.TUser;
import com.doulin.entity.common.*;
import com.doulin.service.TShopHomeBaseInfoService;
import com.doulin.service.TUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceCode{

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private TShopHomeBaseInfoService shopHomeBaseInfoService;
	@Autowired
	private TUserService tUserService;

	/**
	 * 项目路径
	 */
//	@Value("${filePath}")
//	protected String filePath;
//	@Autowired
//	private TuserService tuserService;
//	@Autowired
//	private CustomerService customerService;
//	@Autowired
//	private MsgService msgService;
//	@Autowired
//	private SignService signService;
//	@Autowired
//	private UserCouponService userCouponService;
//	@Autowired
//	private UserRechargeService userRechargeService;
//	@Autowired
//	private AddressService addressService;
//	@Autowired
//	private HelpService helpService;
//	@Autowired
//	private CollectService collectService;
//	@Autowired
//	private FeedbackService feedbackService;
//	@Autowired
//	private CommentService commentService;
//	@Autowired
//	private CommentImageService commentImageService;
//	@Autowired
//	private UserOrderService userOrderService;
//	@Autowired
//	private UserOrderlistService userOrderlistService;
//	@Autowired
//	private UserCartService userCartService;
//	@Autowired
//	private BannerService bannerService;
//	@Autowired
//	private CategoryService categoryService;
//	@Autowired
//	private CouponService couponService;
//	@Autowired
//	private UserMoneyService usermoneyService;
//	@Autowired
//	private VersionService versionService;
//	@Autowired
//	private CommunityService communityService;
//	@Autowired
//	private LabeluserService labeluserService;
//	@Autowired
//	private LabelService labelService;
//	@Autowired
//	private TaskService taskService;
//	@Autowired
//	private ActivityService activityService;
//	@Autowired
//	private DynamicService dynamicService;
//	@Autowired
//	private UserCommunityService userCommunityService;
//	@Autowired
//	private ReportService reportService;
//	@Autowired
//	private DynamicZanService dynamicZanService;
//	@Autowired
//	private UserAttentionService userAttentionService;
//	@Autowired
//	private UserCardService userCardService;
//	@Autowired
//	private GoodsService goodsService;
//	@Autowired
//	private GoodsCommunityService goodsCommunityService;
//	@Autowired
//	private ActivityMemberService activityMemberService;
//	@Autowired
//	private ThemeService themeService;
//	@Autowired
//	private CommunityManService communityManService;
//	@Autowired
//	private CommunityManExperienceService communityManExperienceService;
//	@Autowired
//	private OptimizationService optimizationService;
//	@Autowired
//	private BannerServiceService bannerServiceService;
//	@Autowired
//	private CommunityShopService communityShopService;
//	@Autowired
//	private BankService bankService;
//	@Autowired
//	private CommunityManLabelService communityManLabelService;
//	@Autowired
//	private ScoreDetailService scoreDetailService;
//	@Autowired
//	private UserRemarksService userRemarksService;
//	@Autowired
//	private OrderTypeMapper orderTypeMapper;
//	@Autowired
//	private CommunityMenuMapper communityMenuMapper;
//	@Autowired
//    private GoodsActivityService goodsActivityService;
//	@Autowired
//	private SystemConfigService systemConfig;
//	@Autowired
//	private IconService iconService;
//	@Autowired
//	private LayGroupService layGroupService;
//	@Autowired
//	private CommunityContactService communityContactService;
//	@Autowired
//	private ShopOrderService shopOrderService;
	@Autowired
	private CommonServiceCode csc;
//	@Autowired
//	private ActivitylistMapper activitylistMapper;
//	@Autowired
//	private ActivitylistgoodsMapper goodsMapper;
//	@Autowired
//	private ActivitylistgoodsService activitylistgoodsSerivce;
//	@Autowired
//	private UserMapper userMapper;
//	@Autowired
//	private LayGroupUserMapper layGroupUserMapper;
//	@Autowired
//	private ChatHistoryService chatHistoryService;
//	@Autowired
//	private UserVisitorService userVisitorService;
	/**
	 * 1.0 验证手机号
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public ResJson codec1(UserRegisterReq req, String type) throws Exception {
		ResJson res = new ResJson();
		res.setResultNote("验证失败");
		if (StrUtil.isBlank(req.getPhone())) {
			return ResJson.error(SysContent.ERROR_PHONE);
		}
//		if(SysContent.INTGER_1.toString().equals(type)){
//
//		}
//		// 判断手机号是否已存在
//		Tuser tuser = tuserService.getUserByPhone(req.getPhone());
//		if (null != tuser) {
//			res.setState("0");
//			res.setResult("0");
//			res.setResultNote("该手机号已注册");
//			return res;
//		} else {
//			res.setState("1");
//			res.setResult("0");
//			res.setResultNote("未注册");
//		}
		return res;
	}

	/**
	 * 1.10 验证用户是否已注册（验证码）
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
//	public ResJson codec1(HttpServletRequest request,UserRegisterReq req) throws Exception {
//		UserLoginRes res = new UserLoginRes();
//		res.setResultNote("验证失败");
//
//		if (StringUtils.isBlank(req.getPhone())) {
//			res.setResultNote("手机号不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getPhone())) {
//			res.setResultNote("手机号不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getOpenId())) {
//			res.setResultNote("微信ID不能为空");
//			return res;
//		}
//
//		String ip = request.getRemoteAddr();// 获取ip
//		String authCode = csc.codeBoolean(req.getPhone(), "1", req.getCode(), ip);// 短信验证码验证
//		if ("1".equals(authCode)) {
//			res.setResultNote("验证码不正确");
//			return res;
//		} else if ("2".equals(authCode)) {
//			res.setResultNote("验证码过期");
//			return res;
//		}
//		// 成功后删除存储的验证码
//		CacheUtils.remove("code" + req.getPhone(), req.getCodeType());
//		CacheUtils.remove("ip" + ip, req.getCodeType());
//		CacheUtils.remove("dateTime" + ip, req.getCodeType());
//		// 判断手机号是否已存在
//		Tuser u = tuserService.getUserByPhone(req.getPhone());
//		if (null != u) {
//			// 创建用户
//			if (null == u.getNickname() || "".equals(u.getNickname()))
//				u.setNickname(req.getNickname());// 昵称
//			if (null == u.getSex() || "".equals(u.getSex()))
//				u.setSex(req.getSex());
//			if (null == u.getIcon() || "".equals(u.getIcon()))
//				u.setIcon(req.getIcon());
//			u.setStatus("0");// 状态 0正常 1禁用
//			u.setOpenId(req.getOpenId());
//			u.setAdtime(new Date());
//			tuserService.updateJSAPI(u);
//
//			//添加用户指定的天数
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//			// 查看是否有特定优惠劵
//			List<Coupon> coupon = couponService.selectSpecificCoupon(u.getCommunityid(), "1");
//			List<Map<String, String>> dataList = new ArrayList<>();
//			if (null != coupon && coupon.size() > 0) {
//				for (Coupon coupon2 : coupon) {
//					UserCoupon uc = new UserCoupon();
//					String startDays = DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getStartCouponDay()));
//					String endDays= DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getEndCouponDay())?
//							0:StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getEndCouponDay())+Integer.valueOf(coupon2.getStartCouponDay()));
//					uc.setUid(u.getId());
//					uc.setCouponid(coupon2.getId());
//					List<UserCoupon> list = userCouponService.findList(uc);
//					if (list != null && list.size() > 0) {
//						res.setResultNote("不能重复领取");
//						return res;
//					}
//					uc.setCommunityid(coupon2.getCommunityid());
//					uc.setCommunityname(coupon2.getCommunityname());
//					uc.setAllmoney(coupon2.getAllmoney());
//					uc.setAmount(coupon2.getAmount());
//					uc.setType(coupon2.getType());
//					uc.setStartdate(sf.parse(startDays));
//					uc.setEnddate(sf.parse(endDays));
//					uc.setStatus("0");
//					uc.setAdtime(new Date());
//					userCouponService.save(uc);// 插入到我的优惠劵表
//
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("securitiesid", coupon2.getId());
//					map.put("communityId", coupon2.getCommunityid());
//					map.put("communityName", coupon2.getCommunityname());
//					map.put("securitiesMoney", coupon2.getAllmoney() + "");
//					map.put("securitiesType", coupon2.getType());
//					map.put("securitiesName", coupon2.getName());
//					map.put("securitiesImg", filePath + coupon2.getImage());
//					map.put("securitiesPrice", coupon2.getAmount() + "");
//					map.put("securitiesStartTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(startDays)));
//					map.put("securitiesEndTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(endDays)));
//					dataList.add(map);
//
//				}
//				res.setDataList(dataList);
//			}
//
//			res.setUid(u.getId());
//			res.setCommunityId(u.getCommunityid());
//			res.setCommunityName(u.getCommunityName());
//			res.setNickName(u.getNickname());
//			res.setAvatra(u.getIcon());
//			res.setRytoken(u.getRytoken());
//			res.setPhone(u.getPhone());
//			res.setIswanshan(StringUtils.isBlank(u.getCommunityid()) ? "0" : "1");
//			res.setToken(JwtToken.createToken(request, u));
//
//			res.setResult("4");
//			res.setResultNote("该手机号已注册并登录成功");
//			return res;
//		} else {
//			res.setResult("5");
//			res.setResultNote("未注册");
//		}
//		return res;
//	}

	/**
	 * 1.1用户注册
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
//	public ResJson codec(HttpServletRequest request, UserRegisterReq req) throws Exception {
//		UserLoginRes res = new UserLoginRes();
//		res.setResultNote("注册失败");
//
//		if (StringUtils.isBlank(req.getPhone())) {
//			res.setResultNote("手机号不能为空");
//			return res;
//		}
//		// 判断手机号是否已存在
//		Tuser tuser = tuserService.getUserByPhone(req.getPhone());
//		if (null != tuser) {
//			res.setResultNote("该手机号已注册");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getPassword())) {
//			res.setResultNote("密码不能为空");
//			return res;
//		}
//
//		// 创建用户
//		Tuser u = new Tuser();
//		String id = IdGen.uuid();
//		u.setId(id);// id
//		u.setPhone(req.getPhone());// 手机号
//		u.setPassword(req.getPassword());// 登录密码
//		u.setNickname(
//				req.getPhone().length() > 4 ? "邻友" + req.getPhone().substring(req.getPhone().length() - 4) : "邻友0000");// 昵称
//		u.setSex("1");
//		// u.setIcon("/wisdom/userfiles/1/files/user/icon/default.png"); // 头像
////		u.setIcon("/wisdom/userfiles/1/files/user/icon/default.png");
//		String random = String.valueOf(Math.random());
//		String code = random.substring(random.length() - 8);
//		u.setBalance(0d);
//		u.setToken(req.getToken());
//		u.setInvitenum(code);
//		u.setEffectnum(0);
//		u.setDynamicnum(0);
//		u.setAttennum(0);
//		u.setFansnum(0);
//		u.setReportnum(0);
//		u.setIntegralnum(0);
//		u.setHometown("");
//		u.setAuthentication("0");
//		u.setIsapply("0");
//		u.setIsperfect("0");
//		u.setBinvitenum(req.getUserInviteCode());// 邀请人
//		u.setStatus("0");// 状态 0正常 1禁用
//		u.setAdtime(new Date());
//		int result = tuserService.addUser(u);
//		res.setUid(id);
//		try {
//			if (result > 0) {
//				// 赠送积分
//				if (StringUtils.isNotBlank(req.getUserInviteCode())) {
//					try {
//						Tuser uu = tuserService.findUniqueByProperty("invitenum", req.getUserInviteCode());
//						if(null != uu) {
//							tuserService.updateScore(uu.getId(), 20, 0, "邀请好友");
//						}
//
//					} catch (Exception e) {
//						logger.error("请求处理异常：1060" );
//						e.printStackTrace();
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////		try {// 网易云信添加新用户
////			String token = Wangyiyunxin.getToken(id);
////			// System.out.println("getToken: " + token);
////			u.setRytoken(token);
////			tuserService.updateUser(u);
////			res.setRytoken(token);
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		try {// 网易云信添加客服为好友
////			Wangyiyunxin.addfriend(id, "admin");
////			Wangyiyunxin.updateuser(id, u.getNickname(), filePath + u.getIcon());
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
//		res.setToken(JwtToken.createToken(request, u));
//		res.setResult("0");
//		res.setResultNote("注册成功");
//		return res;
//	}

	/**
	 * 验证登录
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ResJson codec(HttpServletRequest request) throws Exception {
		UserLoginRes res = new UserLoginRes();
		res.setResult(SysContent.INTGER_0.toString());
		res.setResultNote("登录成功");
		TShopHomeBaseInfo tuser = new TShopHomeBaseInfo();
		if (StrUtil.isBlank(request.getHeader("token"))) {
			JSONObject req = JSONUtil.parseObj(request.getParameter("json").toString());
			if(req.containsKey("uid")&&StrUtil.isNotBlank(req.getStr("uid"))){
				tuser = shopHomeBaseInfoService.getById(req.getStr("uid"));
				res.setToken(JwtToken.createToken(request, tuser));
			}else{
				res.setResult("2");//登录已失效专用字CODE
				res.setResultNote("登录已失效，请重新登录！");
			}
		} else if (JwtToken.validateToken(request.getHeader("token"),tuser.getPassword())) {
			tuser = shopHomeBaseInfoService.getById(JwtToken.getAppUID(request.getHeader("token")));
			res.setToken(JwtToken.createToken(request, tuser));
		} else {
			res.setResult("2");//登录已失效专用字CODE
			res.setResultNote("登录已失效，请重新登录！");
		}
//		if(res.getResult().equals("0")){
//			Map<String,Object>ordernum = couponService.execSelectSqlEntityObjMap("SELECT COUNT(1) as num FROM t_user_order a where a.uid='"+tuser.getId()+"' AND a.`status`!='12'");
//			if(Double.valueOf(ordernum.get("num").toString())==0&&StringUtils.isNotBlank(tuser.getCommunityid())){//未购买过的用户
//				//添加用户指定的天数
//				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//				// 查看是否有特定优惠劵
//				List<Coupon> coupon = couponService.selectSpecificCoupon(tuser.getCommunityid(), "1");
//				List<Map<String, String>> dataList = new ArrayList<>();
//				if (null != coupon && coupon.size() > 0) {
//					for (Coupon coupon2 : coupon) {
//						UserCoupon uc = new UserCoupon();
//						String startDays = DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getStartCouponDay()));
//						String endDays= DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getEndCouponDay())?
//								0:StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getEndCouponDay())+Integer.valueOf(coupon2.getStartCouponDay()));
//						uc.setUid(tuser.getId());
//						uc.setCouponid(coupon2.getId());
//						List<UserCoupon> list = userCouponService.findList(uc);
//						if (list != null && list.size() > 0) {
//		//							res.setResultNote("不能重复领取");
//		//							return res;
//							continue;
//						}
//						uc.setCommunityid(coupon2.getCommunityid());
//						uc.setCommunityname(coupon2.getCommunityname());
//						uc.setAllmoney(coupon2.getAllmoney());
//						uc.setAmount(coupon2.getAmount());
//						uc.setType(coupon2.getType());
//						uc.setStartdate(sf.parse(startDays));
//						uc.setEnddate(sf.parse(endDays));
//						uc.setStatus("0");
//						uc.setAdtime(new Date());
//						userCouponService.save(uc);// 插入到我的优惠劵表
//
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("securitiesid", coupon2.getId());
//						map.put("communityId", coupon2.getCommunityid());
//						map.put("communityName", coupon2.getCommunityname());
//						map.put("securitiesMoney", coupon2.getAllmoney() + "");
//						map.put("securitiesType", coupon2.getType());
//						map.put("securitiesName", coupon2.getName());
//						map.put("securitiesImg", filePath + coupon2.getImage());
//						map.put("securitiesPrice", coupon2.getAmount() + "");
//						map.put("securitiesStartTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(startDays)));
//						map.put("securitiesEndTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(endDays)));
//						dataList.add(map);
//
//					}
//					res.setDataList(dataList);
//				}
//			}
//		}
		return res;
	}

	/**
	 * 1.2用户登录
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
//	public ResJson codec(HttpServletRequest request, UserLoginReq req) throws Exception {
//		UserLoginRes res = new UserLoginRes();
//		res.setResultNote("登录失败");
//		if (StringUtils.isBlank(req.getPhone())) {
//			res.setResultNote("手机号不能为空");
//			return res;
//		}
//		Tuser tuser = tuserService.getUserByPhone(req.getPhone());
//		if (StringUtils.isBlank(req.getPassword())) {
//			res.setResultNote("密码不能为空");
//			return res;
//		}
//		if (null == tuser || !req.getPassword().equals(tuser.getPassword())) {
//			res.setResultNote("手机号或密码错误");
//		} else if (!"0".equals(tuser.getStatus())) {
//			res.setResultNote("该用户已被禁用");
//		} else {
//			res.setResult("0");
//			res.setResultNote("登录成功");
//			res.setUid(tuser.getId());
//			res.setCommunityId(tuser.getCommunityid());
//			res.setCommunityName(tuser.getCommunityName());
//			res.setRytoken(tuser.getRytoken());
//			res.setIswanshan(StringUtils.isBlank(tuser.getCommunityid()) ? "0" : "1");
//			res.setToken(JwtToken.createToken(request, tuser));
//		}
//		try {
//			// 登录成功后修改token
//			if (StringUtils.isNotBlank(req.getToken()) && "0".equals(res.getResult())) {
//				tuserService.updateToken(tuser.getId(), req.getToken());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}

	/**
	 * JSAPI公众号获取验证码
	 *
	 * @param request
	 * @param req
	 * @return
	 */
//	public ResJson codeVerification(HttpServletRequest request, UserLoginReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("验证码获取失败");
//		if (StringUtils.isBlank(req.getPhone())) {
//			res.setResultNote("手机号不能为空");
//			return res;
//		}
//		try {
//			// String dateTime = DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(new
//			// Date());//获取服务器的时间
//			Long dateTime = System.currentTimeMillis();// 获取服务器的时间
//			String ip = request.getRemoteAddr();// 获取客户端ip
//			Object obIp = CacheUtils.get("ip" + ip);
//			if (null != obIp && obIp.equals(ip.toString())) {
//				Object obTime = CacheUtils.get("dateTime" + ip);
//				if (null != obTime) {
//					Long beforeTime = Long.valueOf(obTime.toString());
//					if ((System.currentTimeMillis() - beforeTime) / (1000 * 60) <= 1) {
//						res.setResultNote("请求过于频繁，过1分钟再发送验证码！");
//						return res;
//					}
//				}
//			} else {
//				CacheUtils.put("ip" + ip, ip,1800);
//				CacheUtils.put("dateTime" + ip, dateTime,1800);
//			}
//			String random = SMSVerificationCode.getRequest2(req.getPhone(), "5");
//			res.setObject(random);
//			res.setResult("0");
//			res.setResultNote("获取验证码成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}

	/**
	 * 1.21微信公众号登陆
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
//	public ResJson codecOfficialAccounts(HttpServletRequest request, UserRegisterReq req) throws Exception {
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
//		Object lose = CacheUtils.get("code" + req.getPhone(), "5");
//		if (null != lose && lose.toString().equals(req.getCode())) {// 验证验证码是否正确
//			Tuser tuser = tuserService.getUserByPhone(req.getPhone());// 查看是否已存在用户
//			if (null == tuser) {
//				Tuser user = new Tuser();
//				user.setId(IdGen.uuid());// 添加用户id
//				user.setPhone(req.getPhone());
//				user.setOpenId(req.getOpenId());
//				user.setIntegralnum(0);
//				tuserService.addUser(user);
//				res.setResult("0");
//				res.setResultNote("获取成功");
//				res.setToken("");
//			} else {
//
//				if (!"0".equals(tuser.getStatus())) {
//					res.setResultNote("该用户已被禁用");
//				} else {
//					if (null == tuser.getOpenId()
//							|| (null != tuser.getOpenId() && !tuser.getOpenId().equals(req.getOpenId()))) {// 微信openid不一致，修改
//						tuser.setOpenId(req.getOpenId());
//						tuserService.updateUser(tuser);
//					}
//					List<Object> address = addressService
//							.executeSelectSql("SELECT address FROM t_address WHERE uid='" + tuser.getId() + "'");
//					if (null == address || address.size() == 0) {
//						res.setState("1");
//					} else {
//						res.setState("0");
//					}
//					res.setResult("0");
//					res.setResultNote("获取成功");
//					res.setUid(tuser.getId());
//					res.setCommunityId(tuser.getCommunityid());
//					res.setCommunityName(tuser.getCommunityName());
//					res.setRytoken(tuser.getRytoken());
//					res.setIswanshan(StringUtils.isBlank(tuser.getCommunityid()) ? "0" : "1");
//					res.setToken(JwtToken.createToken(request, tuser));
//				}
//			}
//
//			if ("0".equals(res.getResult())) {
//				CacheUtils.remove("code" + req.getPhone(), "5");
//				CacheUtils.remove("ip" + ip);
//				CacheUtils.remove("dateTime" + ip);
//			}
//			Map<String,Object>ordernum = couponService.execSelectSqlEntityObjMap("SELECT COUNT(1) as num FROM t_user_order a where a.uid='"+tuser.getId()+"' AND a.`status`!='12'");
//			if(Double.valueOf(ordernum.get("num").toString())==0&&StringUtils.isNotBlank(tuser.getCommunityid())){//未购买过的用户
//				//添加用户指定的天数
//				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//				// 查看是否有特定优惠劵
//				List<Coupon> coupon = couponService.selectSpecificCoupon(tuser.getCommunityid(), "1");
//				List<Map<String, String>> dataList = new ArrayList<>();
//				if (null != coupon && coupon.size() > 0) {
//					for (Coupon coupon2 : coupon) {
//						UserCoupon uc = new UserCoupon();
//						String startDays = DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getStartCouponDay()));
//						String endDays= DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getEndCouponDay())?
//								0:StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getEndCouponDay())+Integer.valueOf(coupon2.getStartCouponDay()));
//						uc.setUid(tuser.getId());
//						uc.setCouponid(coupon2.getId());
//						List<UserCoupon> list = userCouponService.findList(uc);
//						if (list != null && list.size() > 0) {
//	//								res.setResultNote("不能重复领取");
//	//								return res;
//							continue;
//						}
//						uc.setCommunityid(coupon2.getCommunityid());
//						uc.setCommunityname(coupon2.getCommunityname());
//						uc.setAllmoney(coupon2.getAllmoney());
//						uc.setAmount(coupon2.getAmount());
//						uc.setType(coupon2.getType());
//						uc.setStartdate(sf.parse(startDays));
//						uc.setEnddate(sf.parse(endDays));
//						uc.setStatus("0");
//						uc.setAdtime(new Date());
//						userCouponService.save(uc);// 插入到我的优惠劵表
//
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("securitiesid", coupon2.getId());
//						map.put("communityId", coupon2.getCommunityid());
//						map.put("communityName", coupon2.getCommunityname());
//						map.put("securitiesMoney", coupon2.getAllmoney() + "");
//						map.put("securitiesType", coupon2.getType());
//						map.put("securitiesName", coupon2.getName());
//						map.put("securitiesImg", filePath + coupon2.getImage());
//						map.put("securitiesPrice", coupon2.getAmount() + "");
//						map.put("securitiesStartTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(startDays)));
//						map.put("securitiesEndTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(endDays)));
//						dataList.add(map);
//
//					}
//					res.setDataList(dataList);
//				}
//			}
//		} else {
//			res.setResultNote("验证码不正确");
//			return res;
//		}

		/*
		 * try { // 登录成功后修改token if (StringUtils.isNotBlank(req.getToken()) &&
		 * "0".equals(res.getResult())) { tuserService.updateToken(tuser.getId(),
		 * req.getToken()); } } catch (Exception e) { logger.error(e.getMessage()); }
		 */

//		return res;
//	}

	/**
	 * 1.3 短信登录
	 *
	 * @param req
	 * @return
	 */
//	public ResJson codec(HttpServletRequest request, ThirdLoginReq req) throws Exception {
//		UserLoginRes res = new UserLoginRes();
//		res.setResultNote("登录失败");
//		if (StringUtils.isBlank(req.getPhone())) {
//			res.setResultNote("手机号不能为空");
//			return res;
//		}
//		Tuser tuser = tuserService.getUserByPhone(req.getPhone());
//		if (null == tuser) {
//			// 创建用户
//			res.setResultNote("该手机号还未注册，请注册！");
//			return res;
//		} else if (!"0".equals(tuser.getStatus())) {
//			res.setResultNote("该用户已被禁用");
//			return res;
//		} else {
//			res.setUid(tuser.getId());
//			res.setCommunityId(tuser.getCommunityid());
//			res.setCommunityName(tuser.getCommunityName());
//			res.setRytoken(tuser.getRytoken());
//			res.setIswanshan(StringUtils.isBlank(tuser.getCommunityid()) ? "0" : "1");
//			res.setToken(JwtToken.createToken(request, tuser));
//		}
//		Map<String,Object>ordernum = couponService.execSelectSqlEntityObjMap("SELECT COUNT(1) as num FROM t_user_order a where a.uid='"+tuser.getId()+"' AND a.`status`!='12'");
//		if(Double.valueOf(ordernum.get("num").toString())==0&&StringUtils.isNotBlank(tuser.getCommunityid())){//未购买过的用户
//			//添加用户指定的天数
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//			// 查看是否有特定优惠劵
//			List<Coupon> coupon = couponService.selectSpecificCoupon(tuser.getCommunityid(), "1");
//			List<Map<String, String>> dataList = new ArrayList<>();
//			if (null != coupon && coupon.size() > 0) {
//				for (Coupon coupon2 : coupon) {
//					UserCoupon uc = new UserCoupon();
//					String startDays = DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getStartCouponDay()));
//					String endDays= DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getEndCouponDay())?
//							0:StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getEndCouponDay())+Integer.valueOf(coupon2.getStartCouponDay()));
//					uc.setUid(tuser.getId());
//					uc.setCouponid(coupon2.getId());
//					List<UserCoupon> list = userCouponService.findList(uc);
//					if (list != null && list.size() > 0) {
//	//							res.setResultNote("不能重复领取");
//	//							return res;
//						continue;
//					}
//					uc.setCommunityid(coupon2.getCommunityid());
//					uc.setCommunityname(coupon2.getCommunityname());
//					uc.setAllmoney(coupon2.getAllmoney());
//					uc.setAmount(coupon2.getAmount());
//					uc.setType(coupon2.getType());
//					uc.setStartdate(sf.parse(startDays));
//					uc.setEnddate(sf.parse(endDays));
//					uc.setStatus("0");
//					uc.setAdtime(new Date());
//					userCouponService.save(uc);// 插入到我的优惠劵表
//
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("securitiesid", coupon2.getId());
//					map.put("communityId", coupon2.getCommunityid());
//					map.put("communityName", coupon2.getCommunityname());
//					map.put("securitiesMoney", coupon2.getAllmoney() + "");
//					map.put("securitiesType", coupon2.getType());
//					map.put("securitiesName", coupon2.getName());
//					map.put("securitiesImg", filePath + coupon2.getImage());
//					map.put("securitiesPrice", coupon2.getAmount() + "");
//					map.put("securitiesStartTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(startDays)));
//					map.put("securitiesEndTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(endDays)));
//					dataList.add(map);
//
//				}
//				res.setDataList(dataList);
//			}
//		}
//
////		try {
////			// 登录成功后修改token
////			if (StringUtils.isNotBlank(req.getToken()) && "0".equals(res.getResult()) && req.getToken().length() < 30) {
////				tuserService.updateToken(tuser.getId(), req.getToken());
////			}
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
//		res.setResult("0");
//		res.setResultNote("登录成功");
//		return res;
//	}

	/**
	 * 1.31短信登录 验证升级
	 *
	 * @param req
	 * @return
	 */
//	public ResJson codecVerify(HttpServletRequest request, ThirdLoginReq req) throws Exception {
//		UserLoginRes res = new UserLoginRes();
//		res.setResultNote("登录失败");
//		if (StringUtils.isBlank(req.getPhone())) {
//			res.setResultNote("手机号不能为空");
//			return res;
//		}
//
//		String ip = null;
//		// TODO 测试服务不执行这段代码
//		if(!Global.isDevelopMode()){
//			if("15093081262".equals(req.getPhone()) || "17630766869".equals(req.getPhone())) {
//
//			}else {
//				if (StringUtils.isBlank(req.getCodeType())) {
//					  res.setResultNote("验证码类型不能为空");
//				      return res;
//				  }
//				   ip = request.getRemoteAddr(); String authCode = csc.codeBoolean(req.getPhone(), req.getCodeType(), req.getCode(), ip);
//				  if("1".equals(authCode)) {
//					  res.setResultNote("验证码不正确");
//					  return res;
//				  } else if("2".equals(authCode)) {
//					  res.setResultNote("验证码过期");
//				      return res;
//				  }
//			}
//		}
//		Tuser tuser = tuserService.getUserByPhone(req.getPhone());
//		if (null == tuser) {
//			// 创建用户
//			Tuser u = new Tuser();
//			String id = IdGen.uuid();
//			u.setId(id);// id
//			u.setPhone(req.getPhone());// 手机号
//			u.setPassword(req.getPassword());// 登录密码
//			u.setNickname(req.getPhone().length() > 4 ? "邻友" + req.getPhone().substring(req.getPhone().length() - 4)
//					: "邻友0000");// 昵称
////			u.setIcon("/wisdom/userfiles/1/files/user/icon/default.png");
//			u.setSex("1");
//			String random = String.valueOf(Math.random());
//			String code = random.substring(random.length() - 8);
//			u.setBalance(0d);
//			u.setToken(req.getToken());
//			u.setInvitenum(code);
//			u.setEffectnum(0);
//			u.setDynamicnum(0);
//			u.setAttennum(0);
//			u.setFansnum(0);
//			u.setReportnum(0);
//			u.setIntegralnum(0);
//			u.setHometown("");
//			u.setAuthentication("0");
//			u.setIsapply("0");
//			u.setIsperfect("0");
//			u.setStatus("0");// 状态 0正常 1禁用
//			u.setAdtime(new Date());
//			tuserService.addUser(u);
//			res.setUid(u.getId());
//			res.setToken(JwtToken.createToken(request, u));
////			try {// 网易云信添加新用户
////				String token = Wangyiyunxin.getToken(id);
////				// System.out.println("getToken: " + token);
////				u.setRytoken(token);
////				tuserService.updateUser(u);
////				res.setRytoken(token);
////			} catch (Exception e) {
////				e.printStackTrace();
////			}
////			// 新用户未完善信息
//			res.setIswanshan("0");
////			try {// 网易云信添加客服为好友
////				Wangyiyunxin.addfriend(id, "admin");
////				Wangyiyunxin.updateuser(id, u.getNickname(), filePath + u.getIcon());
////			} catch (Exception e) {
////				e.printStackTrace();
////			}
//			tuser = u;
//		} else if (!"0".equals(tuser.getStatus())) {
//			res.setResultNote("该用户已被禁用");
//			return res;
//		} else {
//			res.setUid(tuser.getId());
//			res.setCommunityId(tuser.getCommunityid());
//			res.setCommunityName(tuser.getCommunityName());
//			res.setRytoken(tuser.getRytoken());
//			res.setIswanshan(StringUtils.isBlank(tuser.getCommunityid()) ? "0" : "1");
//			res.setToken(JwtToken.createToken(request, tuser));
//			// 验证通过删除缓存
//			if("15093081262".equals(req.getPhone()) || "17630766869".equals(req.getPhone())) {
//
//
//			}else {
//				  CacheUtils.remove("code" + req.getPhone(), req.getCodeType());
//				  CacheUtils.remove("ip" + ip, req.getCodeType());
//				  CacheUtils.remove("dateTime" + ip,req.getCodeType());
//			}
//		}
//		try {
//			// 登录成功后修改token
//			if (StringUtils.isNotBlank(req.getToken()) && req.getToken().length() < 30) {
//				tuserService.updateToken(tuser.getId(), req.getToken());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		res.setResult("0");
//		res.setResultNote("登录成功");
//		return res;
//	}

	/**
	 * 1.4用户找回密码
	 *
	 * @param req
	 * @return
	 */
//	public ResJson codec(FindUserPasswordReq req, HttpServletRequest request) {
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
//			Tuser user = tuserService.getUserByPhone(req.getPhone());
//			if (null == user) {
//				res.setResultNote("该手机号不存在");
//			} else if (!"0".equals(user.getStatus())) {
//				res.setResultNote("该手机号被禁用");
//			} else {
//				user.setPassword(req.getPassword());
//				tuserService.updateUser(user);
//				res.setResult("0");
//				res.setResultNote("设置成功");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}

	/**
	 * 1.41用户找回密码 验证码升级
	 *
	 * @param req
	 * @return
	 */
	public ResJson codecVerify(FindUserPasswordReq req, HttpServletRequest request) {

		try {
			if (StrUtil.isBlank(req.getPhone())) {
				return ResJson.error(SysContent.ERROR_PHONE);
			}
			if (StrUtil.isBlank(req.getPassword())) {
				return ResJson.error(SysContent.ERROR_PASSORD_EMPTY);
			}
			if (StrUtil.isBlank(req.getCodeType())) {
				return  ResJson.error(SysContent.ERROR_CODE_TYPE_EMPTY);
			}
			String ip = request.getRemoteAddr();

			String authCode = csc.codeBoolean(req.getPhone(), req.getCodeType(), req.getCode(), ip);
			if (SysContent.INTGER_1.toString().equals(authCode)) {
				return ResJson.error(SysContent.ERROR_REDOMCODE);
			} else if (SysContent.INTGER_2.toString().equals(authCode)) {
				return  ResJson.error(SysContent.ERROR_REDOMCODE_LANGTIME);
			}
			if(SysContent.INTGER_1.toString().equals(req.getType())){
				return setShopPassword( req, ip);
			}else if(SysContent.INTGER_2.toString().equals(req.getType())){
				return  setTuserPassword( req, ip);
			}


		} catch (Exception e) {
			logger.error(SysContent.ERROR_EDIT+e.getMessage());
			return ResJson.error(SysContent.ERROR_EDIT);
		}

		return ResJson.error(SysContent.ERROR_SETTING);
	}

	/**
	 * 用户端修改密码
	 * @param req
	 * @param ip
	 * @return
	 */
	private ResJson setTuserPassword(FindUserPasswordReq req,String ip){
		TUser user = tUserService.getOneByLoginPhone(req.getPhone());
		if (null == user) {
			return ResJson.error(SysContent.ERROR_PHONE_NO_EXSIS);
		} else if (!SysContent.INTGER_1.toString().equals(user.getStatus())) {
			return ResJson.error(SysContent.ERROR_PHONE_JY);
		} else {
			user.setPassword(req.getPassword());
			tUserService.updateById(user);
			findPasswordCache(req.getPhone(),req.getCodeType(),ip);
			return ResJson.Ok(SysContent.OK_OPER);
		}
	}

	/**
	 *
	 * 商户端修改密码
	 * @param req
	 * @param ip
	 * @return
	 */
	private ResJson setShopPassword(FindUserPasswordReq req,String ip){
		TShopHomeBaseInfo user = shopHomeBaseInfoService.getInfoByLoginNo(req.getPhone());
		if (null == user) {
			return ResJson.error(SysContent.ERROR_PHONE_NO_EXSIS);
		} else if (!SysContent.INTGER_1.toString().equals(user.getStatus())) {
			return ResJson.error(SysContent.ERROR_PHONE_JY);
		} else {
			user.setPassword(req.getPassword());
			shopHomeBaseInfoService.updateById(user);
			findPasswordCache(req.getPhone(),req.getCodeType(),ip);
			return ResJson.Ok(SysContent.OK_OPER);
		}
	}
	private void findPasswordCache(String phone,String codetype,String ip){
		CacheUtils.remove("code" + phone,codetype);
		CacheUtils.remove("ip" + ip, codetype);
		CacheUtils.remove("dateTime" + ip, codetype);
	}
	/**
	 * 1.5用户修改登录密码
	 *
	 * @param req
	 * @return
	 */
	public ResJson codec(EditUserPasswordReq req, HttpServletRequest request) {
		ResJson res = new ResJson();
		res.setResultNote("修改失败");
		try {
			if (StrUtil.isBlank(req.getUid())) {
				return	ResJson.error(SysContent.ERROR_SYS);
			}else if (StrUtil.isBlank(req.getOldPassword())) {
				return	ResJson.error(SysContent.ERROR_OLD_PASSORD_EMPTY);
			}else if (StrUtil.isBlank(req.getNewPassword())) {
				return	ResJson.error(SysContent.ERROR_NEW_PASSWORD_EMPTY);
			}
			//商家
            if(SysContent.INTGER_1.toString().equals(req.getType())){
            	res=updateShopPassword(req);
            //用户
			}else if(SysContent.INTGER_2.toString().equals(req.getType())){
				res=updateTuserPassword(req);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	/**
	 * 修改商家密码
	 * @param req
	 * @return
	 */
	private ResJson updateShopPassword(EditUserPasswordReq req){
		TShopHomeBaseInfo tuser=shopHomeBaseInfoService.getById(req.getUid());
		if (null == tuser) {
			return ResJson.error(SysContent.ERROR_SYS);
		} else {
			if (!req.getOldPassword().equals(tuser.getPassword())) {
				return ResJson.error("原密码错误");
			} else {
				tuser.setPassword(req.getNewPassword());
				shopHomeBaseInfoService.updateById(tuser);
				return ResJson.Ok("修改成功");
			}
		}
	}
	/**
	 * 修改商家密码
	 * @param req
	 * @return
	 */
	private ResJson updateTuserPassword(EditUserPasswordReq req){
		TUser tuser=tUserService.getById(req.getUid());
		if (null == tuser) {
			return ResJson.error(SysContent.ERROR_SYS);
		} else {
			if (!req.getOldPassword().equals(tuser.getPassword())) {
				return ResJson.error("原密码错误");
			} else {
				tuser.setPassword(req.getNewPassword());
				tUserService.updateById(tuser);
				return ResJson.Ok("修改成功");
			}
		}
	}

	/**
	 * 密码验证
	 * @param loginNo 登录号
	 * @param password 密码
	 * @return
	 */
	public ResJson validateLoginPassword(String loginNo, String password) {
		TShopHomeBaseInfo tShopHomeBaseInfo=shopHomeBaseInfoService.getInfoByLoginNo(loginNo);
		if (null == tShopHomeBaseInfo) {
			return ResJson.error(SysContent.ERROR_SYS);
		} else {
			if (!tShopHomeBaseInfo.getPassword().equals(password)) {
				return ResJson.error("密码错误");
			} else {
				return ResJson.Ok("密码正确");
			}
		}
	}

	/**
	 * 1.51用户修改登录密码 验证升级
	 *
	 * @param req
	 * @return
	 */
//	public ResJson codecVerify(EditUserPasswordReq req, HttpServletRequest request) {
//		ResJson res = new ResJson();
//		res.setResultNote("修改失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				return ResJson.error(SysContent.ERROR_SYS);
//			}
//			if (StringUtils.isBlank(req.getOldPassword())) {
//               return ResJson.error("原密码不能为空");
//			}
//			if (StringUtils.isBlank(req.getNewPassword())) {
//                return ResJson.error("新密码不能为空");
//			}
//
//			if (StringUtils.isBlank(req.getCodeType())) {
//                return ResJson.error("验证码类型不能为空");
//			}
//			if (StringUtils.isBlank(req.getPhone())) {
//                return ResJson.error("手机号不能为空");
//			}
//			String ip = request.getRemoteAddr();
//			String authCode = csc.codeBoolean(req.getPhone(), req.getCodeType(), req.getCode(), ip);
//			if ("1".equals(authCode)) {
//				res.setResultNote("验证码不正确");
//				return res;
//			} else if ("2".equals(authCode)) {
//				res.setResultNote("验证码过期");
//				return res;
//			}
//			Tuser tuser = tuserService.get(req.getUid());
//			if (null == tuser) {
//				res.setResultNote(SysContent.ERROR_SYS);
//			} else {
//				if (!req.getOldPassword().equals(tuser.getPassword())) {
//					res.setResultNote("原密码错误");
//				} else {
//					tuser.setPassword(req.getNewPassword());
//					tuserService.updateUser(tuser);
//					res.setResult("0");
//					res.setResultNote("修改成功");
//					CacheUtils.remove("code" + req.getPhone(), req.getCodeType());
//					CacheUtils.remove("ip" + ip, req.getCodeType());
//					CacheUtils.remove("dateTime" + ip, req.getCodeType());
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.6 完善社区信息
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(HttpServletRequest request, AddCommunityMessageReq req) {
//		UserLoginRes res = new UserLoginRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote(SysContent.ERROR_SYS);
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//			Tuser user = tuserService.get(req.getUid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//			} else {
//				if (!StringUtils.isBlank(req.getNickname())) {
//					user.setNickname(req.getNickname());
//				}
//				if (!StringUtils.isBlank(req.getIcon())) {
//					String userIcon = req.getIcon().replaceAll(" ", "+");
//					String realPath = request.getSession().getServletContext()
//							.getRealPath("userfiles/1/files/user/icon");
//					String[] split = DateTimeUtil.dateConvtoFmt(new Date(), "yyyy-MM").split("-"); // 按日期存放上传的文件
//					String dateDir = split[0] + "/" + split[1];
//					File path = new File(realPath + File.separator + dateDir);
//					if (!path.exists()) {
//						path.mkdirs();
//					}
//					String image = Base64ToImageUtil.GenerateImage(userIcon, path.getPath() + File.separator);
//					user.setIcon("/wisdom/userfiles/1/files/user/icon/" + dateDir + "/" + image); // 头像
//					// 保存图片
//					CommentImage commentImage = new CommentImage();
//					commentImage.setId(IdGen.uuid());
//					commentImage.setType("0");
//					commentImage.setSeq(1);
//					commentImage.setCommentid(req.getUid());
//					commentImage.setImage("/wisdom/userfiles/1/files/user/icon/" + dateDir + "/" + image);
//					commentImage.setAdtime(new Date());
//					commentImageService.insert(commentImage);
//				}
//				if (!StringUtils.isBlank(req.getSex())) {
//					user.setSex(req.getSex());
//				}
//				if (!StringUtils.isBlank(req.getBirthday())) {
//					try {
//						user.setBirthday(req.getBirthday());
//						int month = Integer.valueOf(req.getBirthday().substring(5, 7));
//						int day = Integer.valueOf(req.getBirthday().substring(8, 10));
//						String constellation = Year.getConstellation(month, day);
//						user.setConstellation(constellation);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//
//				}
//				if (!StringUtils.isBlank(req.getCommunityId())) {
//					user.setCommunityid(req.getCommunityId());
//				}
//				if (!StringUtils.isBlank(req.getUnitId())) {
//					user.setUnitid(req.getUnitId());
//				}
//				if (!StringUtils.isBlank(req.getDoorNumber())) {
//					user.setDoornumber(req.getDoorNumber());
//				}
//				user.setCommunityName(req.getCommunityName());
//				user.setUnitName(req.getUnitName());
//				tuserService.updateUser(user);
//				//TODO 取消默认地址生成
////				Address address = new Address();
////				address.setId(IdGen.uuid());
////				address.setUid(user.getId());
////				address.setUsername(user.getNickname());
////				address.setUserphone(user.getPhone());
////				address.setCity("郑州市");
////				String communityName = StringUtils.isBlank(user.getCommunityName()) ? "" : user.getCommunityName();
////				String doornumber = StringUtils.isBlank(user.getDoornumber()) ? "" : user.getDoornumber();
////				String unitName = StringUtils.isBlank(user.getUnitName()) ? "" : user.getUnitName();
////				address.setCommunityName(communityName);
////				address.setAddress(unitName + doornumber);
////				address.setIsdefault("0");
////				address.setAdtime(new Date());
////				addressService.addAddress(address);
//
//				//添加用户指定的天数
//				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//				// 查看是否有特定优惠劵
//				List<Coupon> coupon = couponService.selectSpecificCoupon(req.getCommunityId(), "1");
//				List<Map<String, String>> dataList = new ArrayList<>();
//				if (null != coupon && coupon.size() > 0) {
//					for (Coupon coupon2 : coupon) {
//						UserCoupon uc = new UserCoupon();
//						String startDays = DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getStartCouponDay()));
//						String endDays= DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getEndCouponDay())?
//								0:StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getEndCouponDay())+Integer.valueOf(coupon2.getStartCouponDay()));
//						//String days = DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getStartCouponDay()));
//						uc.setUid(req.getUid());
//						uc.setCouponid(coupon2.getId());
//						List<UserCoupon> list = userCouponService.findList(uc);
//						if (list != null && list.size() > 0) {
//							res.setResultNote("不能重复领取");
//							return res;
//						}
//						uc.setCommunityid(coupon2.getCommunityid());
//						uc.setCommunityname(coupon2.getCommunityname());
//						uc.setAllmoney(coupon2.getAllmoney());
//						uc.setAmount(coupon2.getAmount());
//						uc.setType(coupon2.getType());
//						/*uc.setStartdate(new Date());
//						uc.setEnddate(sf.parse(days));*/
//						uc.setStartdate(sf.parse(startDays));
//						uc.setEnddate(sf.parse(endDays));
//						uc.setStatus("0");
//						uc.setAdtime(new Date());
//						userCouponService.save(uc);
//
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("securitiesid", coupon2.getId());
//						map.put("communityId", coupon2.getCommunityid());
//						map.put("communityName", coupon2.getCommunityname());
//						map.put("securitiesMoney", coupon2.getAllmoney() + "");
//						map.put("securitiesType", coupon2.getType());
//						map.put("securitiesName", coupon2.getName());
//						map.put("securitiesImg", filePath + coupon2.getImage());
//						map.put("securitiesPrice", coupon2.getAmount() + "");
//						map.put("securitiesStartTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(startDays)));
//						map.put("securitiesEndTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(endDays)));
//						dataList.add(map);
//					}
//					res.setDataList(dataList);
//				}
//
////				try {// 网易云修改个人信息
////					Wangyiyunxin.updateuser(user.getId(), user.getNickname(), filePath + user.getIcon());
////				} catch (Exception e) {
////					e.printStackTrace();
////				}
//				res.setUid(user.getId());
//				res.setNickName(user.getNickname());
//				res.setAvatra(user.getIcon());
//				res.setResult("0");
//				res.setResultNote("完善信息成功");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.7 获取社区
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec3(AddCommunityMessageReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		try {
//			Community community = new Community();
//			community.setState("0");
//			List<Community> list = communityService.findList(community);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (null != list) {
//				if (null != list && !list.isEmpty()) {
//					for (Community g : list) {
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("communityId", g.getId());
//						map.put("communityName", g.getName1());
//						dataList.add(map);
//					}
//				}
//				res.setDataList(dataList);
//				res.setResult("0");
//				res.setResultNote("获取社区成功");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.8 获取社区单元
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(AddCommunityMessageReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		try {
//			CommunityMenu communityMenu = new CommunityMenu();
//			communityMenu.setCommunityid(req.getCommunityId());
//			List<CommunityMenu> list = communityMenuMapper.findList(communityMenu);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (null != list) {
//				if (null != list && !list.isEmpty()) {
//					for (CommunityMenu g : list) {
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("unitId", g.getId());
//						map.put("unitName", g.getName());
//						dataList.add(map);
//					}
//				}
//				res.setDataList(dataList);
//				res.setResult("0");
//				res.setResultNote("获取社区单元成功");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.9用户个人信息
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(UserInfoReq req) {
//		UserInfoRes res = new UserInfoRes();
//		res.setResultNote("获取失败");
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
//			} else {
//				if(!csc.validateBalance(user,"0")){
//					csc.updateBalance(user,"0");
//				}
//				res.setCommunityId(user.getCommunityid());
//				Map<String,String> map = communityService.execSelectSqlEntityMap("SELECT name1,address  FROM t_community WHERE id='"+user.getCommunityid()+"'");
//				res.setCommunityName(map.get("name1"));
//				res.setCommunityAddress(map.get("address"));
//				res.setIcon(StringUtils.isNotBlank(user.getIcon()) && user.getIcon().indexOf("http://") == -1
//						&& user.getIcon().indexOf("https://") == -1 ? filePath + user.getIcon() : user.getIcon());
//				res.setNickname(user.getNickname());
//				res.setPhone(user.getPhone());
//				res.setEffectNum(user.getEffectnum() + "");
//				res.setDynamicNum(user.getDynamicnum() + "");
//				res.setAttenNum(user.getAttennum() + "");
//				res.setFansNum(user.getFansnum() + "");
//				res.setIntegralNum(user.getIntegralnum() + "");
//				Map<String,Object> sign = signService
//						.execSelectSqlEntityObjMap("select count(1) signflag,IFNULL(integral,0) integral from t_sign where uid='" + req.getUid()
//								+ "' and DATE(adtime) = CURDATE()");
//				res.setSignFlag(sign.get("signflag").toString());//1已签到，0未签到
//				res.setSignNum(sign.get("integral").toString());//如果今天已签到应显示明天签到应得积分
//				res.setInviteCode(user.getInvitenum());
//				res.setAuthentication(user.getAuthentication());
//				res.setBalance(user.getBalance() + "");
//				res.setIsApply(user.getIsapply());
//				res.setShareurl("http://url.cn/5qVAx1A");
//
//				Map<String,Object> ordernum = userOrderService.execSelectSqlEntityObjMap("SELECT IFNULL(SUM(IF(a.status=1,1,0)),0) nopaynum,"
//						+ "IFNULL(SUM(IF(a.status in (2,3,4,5,6,7),1,0)),0) nocompletenum,IFNULL(SUM(IF(a.status in (10),1,0)),0) completenum,"
//						+ "IFNULL(SUM(IF(a.status in (8),1,0)),0) refundnum,(SELECT COUNT(1) FROM t_user_coupon c where c.uid='"+user.getId()+"' and c.communityid='"+user.getCommunityid()+"' and c.enddate>NOW()) couponnum,"
//						+ "IFNULL((SELECT SUM(c.count) FROM t_user_cart c,t_goods_community g where c.goodsid = g.goodsid and c.uid='"+user.getId()+"' and g.communityid='"+user.getCommunityid()+"'),0) carnum "
//						+ "FROM t_user_order a WHERE a.uid='"+user.getId()+"'");
//				res.setNoPayNum(ordernum.get("nopaynum").toString());
//				res.setNoCompleteNum(ordernum.get("nocompletenum").toString());
//				res.setCompleteNum(ordernum.get("completenum").toString());
//				res.setRefundNum(ordernum.get("refundnum").toString());
//				res.setCouponNum(ordernum.get("couponnum").toString());
//				res.setCarNum(ordernum.get("carnum").toString());
//				res.setResult("0");
//				res.setResultNote("获取成功");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.10 个人主页
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(UserInfoReq req) {
//		UserInfoRes res = new UserInfoRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getAuid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			//查看用户是否在更换社区
//			List<Object> tid=userCommunityService.executeSelectSql("SELECT state FROM t_user_community WHERE uid='"+req.getAuid()+"' AND state='1'");
//			if(null !=tid && tid.size()>0 && null != tid.get(0)) {
//				res.setState( tid.get(0).toString());//社区更换中
//			}else {
//				res.setState("0");//可移交群主
//			}
//			Tuser user = tuserService.get(req.getAuid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else {
//				CommentImage commentImage = new CommentImage();
//				commentImage.setType("0");
//				commentImage.setCommentid(req.getAuid());
//				List<CommentImage> imageList = commentImageService.findList(commentImage);
//				List<Map<String, String>> list = new ArrayList<Map<String, String>>();
//				if (imageList != null && imageList.size() > 0) {
//					for (CommentImage c : imageList) {
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("imgId", c.getId());
//						map.put("imgUrl", filePath + c.getImage());
//						list.add(map);
//					}
//				}
//				res.setNickname(user.getNickname());
//				res.setAlbumList(list);
//				res.setIcon(StringUtils.isNotBlank(user.getIcon()) && user.getIcon().indexOf("http://") == -1
//						&& user.getIcon().indexOf("https://") == -1 ? filePath + user.getIcon() : user.getIcon());
//				res.setBirthday(user.getBirthday());
//				res.setSex(user.getSex());
//				res.setAge(StringUtils.isBlank(user.getBirthday()) ? ""
//						: Year.getAge(DateTimeUtil.parse(user.getBirthday())) + "");
//				res.setConstellation(user.getConstellation());
//				res.setCommunityId(user.getCommunityid());
//				res.setCommunityName(user.getCommunityName());
//				res.setUnitId(user.getUnitid());
//				res.setUnitName(user.getUnitName());
//				res.setDoorNumber(user.getDoornumber());
//				res.setEffectNum(user.getEffectnum() + "");
//				res.setAutograph(user.getAutograph());
//				res.setInviteCode(user.getInvitenum());
//				res.setOccupation(user.getOccupation());
//				res.setHometown(user.getHometown());
//				res.setAuthentication(user.getAuthentication());
//				UserAttention ua = userAttentionService.isattention(req.getUid(), "0", req.getAuid());
//				res.setIsAttention(ua.getIsattention());
//				UserRemarks ur = userRemarksService.gets(req.getUid(), req.getAuid());
//				if (ur != null) {
//					res.setRemarks(ur.getRemarks());
//				} else {
//					res.setRemarks("");
//				}
//				// 获取标签
//				List<String> list1 = new ArrayList<String>();// 运动
//				List<String> list2 = new ArrayList<String>();// 音乐
//				List<String> list3 = new ArrayList<String>();// 美食
//				List<String> list4 = new ArrayList<String>();// 电影
//				List<String> list5 = new ArrayList<String>();// 图书
//				List<String> list6 = new ArrayList<String>();// 其它
//				Labeluser labeluser = new Labeluser();
//				labeluser.setUid(req.getAuid());
//				List<Labeluser> labelList = labeluserService.findList(labeluser);
//				if (labelList != null && labelList.size() > 0) {
//					for (Labeluser l : labelList) {
//						String name = "";
//						if ("0".equals(l.getType())) {
//							name = l.getLabelname1();
//						} else {
//							name = l.getLabelname();
//						}
//						if ("1".equals(l.getTypeid())) {
//							list1.add(name);
//						} else if ("2".equals(l.getTypeid())) {
//							list2.add(name);
//						} else if ("3".equals(l.getTypeid())) {
//							list3.add(name);
//						} else if ("4".equals(l.getTypeid())) {
//							list4.add(name);
//						} else if ("5".equals(l.getTypeid())) {
//							list5.add(name);
//						} else if ("6".equals(l.getTypeid())) {
//							list6.add(name);
//						}
//					}
//				}
//				res.setSportList(list1);
//				res.setMusicList(list2);
//				res.setFoodsList(list3);
//				res.setMovieList(list4);
//				res.setBooksList(list5);
//				res.setOtherList(list6);
//				res.setResult("0");
//				res.setResultNote("获取成功");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.11 修改用户资料
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(EditUserNicknameReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("修改成功");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Tuser user = tuserService.get(req.getUid());
//			if (user == null) {
//				res.setResultNote("用户不存在");
//				return res;
//			}
//			if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			if (!StringUtils.isBlank(req.getNickname())) {
//				user.setNickname(req.getNickname());
//			}
//			if (!StringUtils.isBlank(req.getSex())) {
//				user.setSex(req.getSex());
//			}
//			if (!StringUtils.isBlank(req.getAutograph())) {
//				user.setAutograph(req.getAutograph());
//			}
//			if (!StringUtils.isBlank(req.getOccupation())) {
//				user.setOccupation(req.getOccupation());
//			}
//			if (!StringUtils.isBlank(req.getHometown())) {
//				user.setHometown(req.getHometown());
//			}
//			if (!StringUtils.isBlank(req.getBirthday())) {
//				// user.setBirthday(req.getBirthday());
//				try {
//					user.setBirthday(req.getBirthday());
//					int month = Integer.valueOf(req.getBirthday().substring(5, 7));
//					int day = Integer.valueOf(req.getBirthday().substring(8, 10));
//					String constellation = Year.getConstellation(month, day);
//					user.setConstellation(constellation);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			tuserService.updateUser(user);
//			if ("0".equals(user.getIsperfect())) {// 未完善
//				int num = csc.getperfect(req.getUid());
//				if (num == 100) {// 完成
//					Task t = taskService.get("5");
//					user.setIsperfect("1");
//					tuserService.updateUser(user);
//					tuserService.updateScore(req.getUid(), t.getEffectnum(),0, "完善资料");
//					if (!StringUtils.isBlank(user.getBinvitenum())) {// 有邀请人
//						try {
//							Tuser uu = tuserService.findUniqueByProperty("invitenum", user.getBinvitenum());
//							tuserService.updateScore(uu.getId(), 30,0, "邀请好友完善资料");
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//
//					}
//				}
//			}
////			try {// 网易云修改个人信息
////				Wangyiyunxin.updateuser(user.getId(), user.getNickname(), filePath + user.getIcon());
////			} catch (Exception e) {
////				e.printStackTrace();
////			}
//			res.setResult("0");
//			res.setResultNote("修改成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.13 删除相册图片
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(EditUserIconReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("修改失败");
//		String sql;
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getImgId())) {
//				res.setResultNote("图片id不能为空");
//				return res;
//			}
//			Tuser user = tuserService.get(req.getUid());
//			if (user == null) {
//				res.setResultNote("用户不存在");
//				return res;
//			}
//			if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			CommentImage c = commentImageService.get(req.getImgId());
//			if (c != null && c.getId().length() > 0) {
//				commentImageService.delete(c);
//				sql = "update t_comment_image set seq=seq-1 where type=0 and commentid='" + req.getUid() + "' and seq>"
//						+ c.getSeq();
//				commentImageService.executeUpdateSql(sql);
//				if (c.getSeq() == 1) {
//					sql = "update t_user set icon=(select image from t_comment_image where type=0 and seq=1 and commentid='"
//							+ req.getUid() + "') where id='" + req.getUid() + "'";
//					commentImageService.executeUpdateSql(sql);
//					// CacheUtils.remove("tuser", req.getUid());
//				}
//			}
//			res.setResult("0");
//			res.setResultNote("删除成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.14 相册图片设为头像(覆盖之前的)
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(EditUserIconReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("修改失败");
//		String sql;
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote(SysContent.ERROR_SYS);
//				return res;
//			}
//			if (StringUtils.isBlank(req.getImgId())) {
//				res.setResultNote("图片id不能为空");
//				return res;
//			}
//			Tuser user = tuserService.get(req.getUid());
//			if (user == null) {
//				res.setResultNote("用户不存在");
//				return res;
//			}
//			if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			CommentImage c = commentImageService.get(req.getImgId());
//			if (c != null && c.getId().length() > 0) {
//				user.setIcon(c.getImage());
//				tuserService.updateUser(user);
//				sql = "update t_comment_image set seq=seq+1 where type=0 and commentid='" + req.getUid() + "' and seq<"
//						+ c.getSeq();
//				commentImageService.executeUpdateSql(sql);
//				c.setSeq(1);
//				commentImageService.save(c);
//
//			}
////			try {// 网易云修改个人信息
////				Wangyiyunxin.updateuser(user.getId(), user.getNickname(), filePath + user.getIcon());
////			} catch (Exception e) {
////				e.printStackTrace();
////			}
//			res.setObject(filePath + c.getImage());
//			res.setResult("0");
//			res.setResultNote("设置成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.15 获取标签
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2(UserScoreListReq req) {
//		GetLabelListRes res = new GetLabelListRes();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
//		try {
//			Label lb = new Label();
//			lb.setType(req.getType());
//			lb.setState("(select count(1) from t_label_user tu where tu.labelid=a.id and tu.uid='" + req.getUid() + "')");
//			List<Label> list = labelService.findList(lb);
//			List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
//			List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				for (Label s : list) {
//					Map<String, Object> map = new HashMap<String, Object>();
//					map.put("labelId", s.getId());
//					map.put("laberName", s.getName());
//					map.put("labelType", s.getType());
//					map.put("state", s.getState());
//					list1.add(map);
//				}
//			}
//			res.setLabelList(list1);
//			Labeluser labeluser = new Labeluser();
//			labeluser.setUid(req.getUid());
//			labeluser.setType("1");
//			labeluser.setTypeid(req.getType());
//			List<Labeluser> labelList = labeluserService.findList(labeluser);
//			if (null != labelList && labelList.size() > 0) {
//				for (Labeluser s : labelList) {
//					Map<String, Object> map = new HashMap<String, Object>();
//					map.put("laberName", s.getLabelname());
//					list2.add(map);
//				}
//			}
//			res.setOtherList(list2);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.16 提交标签
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(AddLabelReq req) {
//		GetLabelListRes res = new GetLabelListRes();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
//		try {
//			Tuser user = tuserService.get(req.getUid());
//			if (user == null) {
//				res.setResultNote("用户不存在");
//				return res;
//			}
//			if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			labeluserService.executeDeleteSql("delete from t_label_user where uid='" + req.getUid() + "'");
//			for(AddLabelReq a : req.getLabelsList()){
//				if (a.getLabelList() != null && a.getLabelList().length > 0) {
//					for (String l : a.getLabelList()) {
//						Labeluser labeluser = new Labeluser();
//						labeluser.setUid(req.getUid());
//						labeluser.setTypeid(a.getType());
//						labeluser.setType("0");
//						labeluser.setLabelid(l);
//						labeluser.setAdtime(new Date());
//						labeluserService.save(labeluser);
//					}
//				}
//			}
//			if (req.getOtherList() != null && req.getOtherList().length > 0) {
//				for (String l : req.getOtherList()) {
//					Labeluser labeluser = new Labeluser();
//					labeluser.setUid(req.getUid());
//					labeluser.setTypeid(req.getType());
//					labeluser.setType("1");
//					labeluser.setLabelname(l);
//					labeluser.setAdtime(new Date());
//					labeluserService.save(labeluser);
//				}
//			}
//			if ("0".equals(user.getIsperfect())) {// 未完善
//				int num = csc.getperfect(req.getUid());
//				if (num == 100) {// 完成
//					Task t = taskService.get("5");
//					user.setIsperfect("1");
//					tuserService.updateUser(user);
//					tuserService.updateScore(req.getUid(), t.getEffectnum(), 0,"完善资料");
//					if (!StringUtils.isBlank(user.getBinvitenum())) {// 有邀请人
//						try {
//							Tuser uu = tuserService.findUniqueByProperty("invitenum", user.getBinvitenum());
//							tuserService.updateScore(uu.getId(), 30, 0,"邀请好友完善资料");
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//
//					}
//				}
//			}
//			res.setResult("0");
//			res.setResultNote("提交成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.17 获取签到
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(UserSignReq req) {
//		GetSignRewardRes res = new GetSignRewardRes();
//		res.setResultNote("获取签到失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//
//			Tuser user = tuserService.get(req.getUid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			} else {
//				Task t = taskService.get("1");
//				Sign s = new Sign();
//				s.setUid(req.getUid());
//				s = signService.isSign(s);
//				res.setTodaySign(s.getUid());
//				List<Object> list = signService
//						.executeSelectSql("select DATE_FORMAT(adtime,'%Y-%m-%d') from t_sign where uid='" + req.getUid()
//								+ "' and adtime like '%" + req.getMonth() + "%'");
//				res.setEffectNum(t.getEffectnum() + "");
//				res.setIntegral("1");
//				res.setDataList(list);
//				res.setResult("0");
//				res.setResultNote("获取成功");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.18用户签到
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(UserSignReq req) {
//		UserSignRes res = new UserSignRes();
//		res.setResultNote("签到失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Tuser user = tuserService.get(req.getUid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//				return res;
//			}
//			if (!"0".equals(user.getStatus())) {
//				res.setResultNote("该用户已被禁用");
//				return res;
//			}
//
//			Sign s = new Sign();
//			s.setUid(req.getUid());
//			s = signService.isSign(s);
//			if (!"0".equals(s.getUid())) {
//				res.setResultNote("您今天已签到");
//				return res;
//			} else {
//				Sign s1 = new Sign();
//				s1.setId(IdGen.uuid());
//				s1.setUid(req.getUid());
//				s1.setAdtime(new Date());
//				s1.setIntegral(1);
//				signService.addSign(s1);
//			}
//			// 增加签到影响力
//			Task t = taskService.get("1");
//			tuserService.updateScore(user.getId(), t.getEffectnum(), 1 , "签到");
//			res.setEffectNum(t.getEffectnum() + "");
//			res.setIntegralnum("1");
//			res.setResultNote("签到成功");
//			res.setResult("0");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.19用户零钱明细
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(UserScoreListReq req) {
//		UserScoreListRes res = new UserScoreListRes();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Tuser user = tuserService.get(req.getUid());
//			// Tuser user = tuserService.selectTuserBalance(req.getUid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			res.setBalance(user.getBalance() + "");
//
//			UserMoney sd = new UserMoney();
//			sd.setUid(req.getUid());
//			sd.setHtype("0");
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
//						map.put("balance", um.getBalance());
//						map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(um.getAdtime()));
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(sdPage.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.20充值订单提交
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(AddUserRechargeReq req) {
//		AddUserRechargeRes res = new AddUserRechargeRes();
//		res.setResultNote("提交失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//
//			Tuser tuser = tuserService.get(req.getUid());
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			}
//			if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
////			String ordernum = StringUtil.getOrderNo();
//			String ordernum = new WXpayCg().RECHARGE_NO;
//			OrderType ot = new OrderType();
//			ot.setId(IdGen.uuid());
//			ot.setType("0");
//			ot.setState("0");
//			ot.setUid(req.getUid());
//			ot.setMoney(req.getAmount() + "");
//			ot.setOrdernum(ordernum);
//			orderTypeMapper.insert(ot);
//
//			res.setResult("0");
//			res.setResultNote("充值获取订单号成功");
//			res.setOrderNum(ordernum);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 微信支付宝充值订单提交
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecPayTopUP(AddUserRechargeReq req, HttpServletRequest request) {
//		AddUserRechargeRes res = new AddUserRechargeRes();
//		res.setResultNote("提交失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//
//			Tuser tuser = tuserService.get(req.getUid());
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			}
//			if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			Map<String, Object> mapOrder = new HashMap<>();
//			BigDecimal orderPay = new BigDecimal(req.getAmount()).setScale(2, BigDecimal.ROUND_HALF_UP);// 传过来的金额
//			String ordernum = StringUtil.getOrderNo();
//			OrderType ot = new OrderType();
//			ot.setId(IdGen.uuid());
//			ot.setType("0");
//			ot.setState("0");
//			ot.setUid(req.getUid());
//			ot.setMoney(orderPay.doubleValue() + "");
//			ot.setOrdernum(ordernum);
//			/*
//			 * Map<String, Object> mapOrder = new HashMap<>(); mapOrder.put("payprice",
//			 * orderPay.doubleValue()); mapOrder.put("ordernum", ordernum);
//			 * mapOrder.put("state", "1");// 0：商品订单 1：充值订单
//			 */ Map<String, String> map = new HashMap<>();
//			if ("1".equals(req.getPayType())) {// 支付宝充值
//
//				// 实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型），为了取得预付订单信息
//				AlipayClient alipayClient = new DefaultAlipayClient(AlipayCg.URL, AlipayCg.APPID,
//						AlipayCg.RSA_PRIVATE_KEY, AlipayCg.FORMAT, AlipayCg.CHARSET, AlipayCg.ALIPAY_PUBLIC_KEY,
//						AlipayCg.SIGNTYPE);
//				// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
//				AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
//
//				// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式
//				AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
//
//				// 业务参数传入,可以传很多，参考API
//				// model.setPassbackParams(URLEncoder.encode(request.getBody().toString()));
//				// //公用参数（附加数据）
//				model.setBody("订单支付"); // 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
//				model.setSubject("充值订单"); // 商品名称
//				model.setOutTradeNo(ordernum); // 商户订单号(自动生成)
//				model.setTimeoutExpress("30m"); // 交易超时时间
//				model.setTotalAmount(orderPay.doubleValue() + ""); // 支付金额
//				model.setProductCode("QUICK_MSECURITY_PAY"); // 销售产品码（固定值）
//				ali_request.setNotifyUrl(AlipayCg.NOTIFYURL);
//				ali_request.setBizModel(model);
//				// 这里和普通的接口调用不同，使用的是sdkExecute
//				AlipayTradeAppPayResponse alipayTradeAppPayResponse = alipayClient.sdkExecute(ali_request); // 返回支付宝订单信息(预处理)
//				String body = alipayTradeAppPayResponse.getBody();// 就是orderString 可以直接给APP请求，无需再做处理。
//				mapOrder.put("body", body);
//				/*
//				 * String body = new AlipayConfig().getAliPayOrderStr(mapOrder, null);
//				 * map.put("body", body);
//				 */
//			} else if ("2".equals(req.getPayType())) {// 微信充值
//				// 获取用户ip
//				String ip = request.getHeader("x-forwarded-for");
//				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//					ip = request.getHeader("Proxy-Client-IP");
//				}
//				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//					ip = request.getHeader("WL-Proxy-Client-IP");
//				}
//				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//					ip = request.getRemoteAddr();
//				}
//				List<Map<String, String>> param = new ArrayList<>();
//				// 交易金额默认为人民币交易，接口中参数支付金额单位为【分】，参数值不能带小数，上面的1000.00指的是元
//				orderPay = orderPay.multiply(new BigDecimal(100));
//				if(null!=req.getType()&&"2".equals(req.getType())){
//					map.put("appid", WXpayCg.MINI_APP_ID);
//					map.put("trade_type", WXpayCg.TRADE_TYPE_JS);
//					map.put("openid", req.getOpenid());
//				}else{
//					map.put("appid", WXpayCg.APP_ID);
//					map.put("trade_type", WXpayCg.TRADE_TYPE_APP);
//				}
//
//				// 商品简单描述，该字段请按照规范传递
//				map.put("body", "逗邻");
//				map.put("mch_id", WXpayCg.MCH_ID);// 商户id号
//				// 随机字符串==随机字符串，不长于32位
//				map.put("nonce_str", RandomStringUtils.randomAlphabetic(32));
//				map.put("notify_url", WXpayCg.NOTIFYURL);
//				// 商户订单号==商户系统内部的订单号,32个字符内、可包含字母
//				map.put("out_trade_no", ordernum);
//				// APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。不是必填项
//				map.put("spbill_create_ip", ip);
//				map.put("total_fee", orderPay.stripTrailingZeros().toPlainString());
//
//				map = MD5.sortMapByKey(map);// 排序
//				param.add(map);
//				StringBuilder sb = new StringBuilder();
//				// 主动创建document对象.
//				Document document = DocumentHelper.createDocument();
//				Element root = document.addElement("xml");
//				for (int i = 0; i < param.size(); i++) {
//					Map<String, String> pair = param.get(i);
//					for (Entry<String, String> vo : pair.entrySet()) {
//						sb.append(vo.getKey()).append("=").append(vo.getValue()).append("&");
//						root.addElement(vo.getKey()).addText(vo.getValue());
//					}
//
//				}
//				sb.append("key=").append(WXpayCg.KEY);
//				// map.put("sign", DigestUtils.md5Hex(sb.toString()).toUpperCase());
//				root.addElement("sign").addText(DigestUtils.md5Hex(sb.toString()).toUpperCase());
//				// String aa = root.asXML();
//				String tenR = HttpPostXML.post(WXpayCg.TENPAYURL, root.asXML());
//				StringBuilder sbclient = new StringBuilder();
//				Map<String, String> map1 = new HashMap<>();
//				try {
//					Document doc = DocumentHelper.parseText(tenR);
//					Element root$ten = doc.getRootElement();
//					Element returnCode = root$ten.element("return_code");
//					if (returnCode.getText().equals("FAIL")) {
//						// log.error(root$ten.element("return_msg").getText());
//					} else if (returnCode.getText().equals("SUCCESS")) {
//						try {
//							// 调用接口提交的公众账号ID
//							// map.put("appid", root$ten.element("appid").getText());
//							// 微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
//							map1.put("timestamp", System.currentTimeMillis() / 1000 + "");
//							map1.put("nonce_str", RandomStringUtils.randomAlphabetic(32));
//							if (null != req.getType() && ("1".equals(req.getType())||"2".equals(req.getType()))) {//小程序，公众号
//								sbclient.append("appId=").append(root$ten.element("appid").getText());
//								sbclient.append("&nonceStr=").append(map1.get("nonce_str"));
//								sbclient.append("&package=")
//										.append("prepay_id=" + root$ten.element("prepay_id").getText());
//								sbclient.append("&signType=").append("MD5");
//								sbclient.append("&timeStamp=").append(map1.get("timestamp"));
//								sbclient.append("&key=").append(WXpayCg.KEY);
//								if ("2".equals(req.getType())) {//小程序支付
//									map1.put("appId", WXpayCg.MINI_APP_ID);
//								}else{//公众号支付
//									map1.put("appId", WXpayCg.MP_APP_ID);
//								}
//								map1.put("nonceStr", map1.get("nonce_str"));
//								map1.put("package", "prepay_id=" + root$ten.element("prepay_id").getText());
//								map1.put("signType", "MD5");
//								map1.put("timeStamp", map1.get("timestamp"));
//								map1.put("paySign", DigestUtils.md5Hex(sbclient.toString()).toUpperCase());
//							} else {//APP
//								sbclient.append("appid=").append(root$ten.element("appid").getText());
//								sbclient.append("&noncestr=").append(map1.get("nonce_str"));
//								sbclient.append("&package=").append("Sign=WXPay");
//								sbclient.append("&partnerid=").append(root$ten.element("mch_id").getText());
//								sbclient.append("&prepayid=").append(root$ten.element("prepay_id").getText());
//								sbclient.append("&timestamp=").append(map1.get("timestamp"));
//								sbclient.append("&key=").append(WXpayCg.KEY);
//								map1.put("appid", WXpayCg.APP_ID);
//								map1.put("mch_id", WXpayCg.MCH_ID);
//								map1.put("prepay_id", root$ten.element("prepay_id").getText());
//								map1.put("sign", DigestUtils.md5Hex(sbclient.toString()).toUpperCase());
//							}
//						} catch (Exception e) {
//							e.printStackTrace();
//							logger.info("获取微信支付参数失败，失败原因：" + e.toString());
//						}
//					}
//				} catch (DocumentException e) {
//					logger.info("获取微信支付参数失败，失败原因：" + e.toString());
//					e.printStackTrace();
//				}
//
//				/* Map<String, String> mapwx = WXConfig.wxprePay(mapOrder, request, null); */
//				mapOrder.put("mapwx", map1);
//			}
//			orderTypeMapper.insert(ot);
//			res.setObject(mapOrder);
//			res.setResult("0");
//			res.setResultNote("充值获取订单号成功");
//			// res.setOrderNum(ordernum);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.21用户提现
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(UserTixianReq req) {
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
//			Tuser user = tuserService.get(req.getUid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//				return res;
//			}
//			if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			if (req.getAmount() > user.getBalance()) {
//				res.setResultNote("余额不足");
//				return res;
//			}
//			Customer c = customerService.get("1");
//			double ratemoney = Double.valueOf(c.getUsercash()) * req.getAmount() * 0.01;
//			UserRecharge ur = new UserRecharge();
//			ur.setId(IdGen.uuid());
//			ur.setUid(req.getUid());
//			ur.setMoney(req.getAmount());
//			ur.setRealmoney(req.getAmount() - ratemoney);
//			ur.setRatemoney(ratemoney);
//			ur.setWay("3");
//			ur.setType("2");// 1充值 2提现
//			ur.setHtype("0");
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
//
//			String b = userRechargeService.addUserRecharge(ur);
//			res.setBalance(b);
//			res.setResult("0");
//			res.setResultNote("申请成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.22 我的优惠券列表
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(SecuritiesListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取我的优惠券列表失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//
//			Tuser user = tuserService.get(req.getUid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			} else {
//				Page<UserCoupon> page = new Page<UserCoupon>(req.getNowPage(), req.getPageCount());
//				page.setOrderBy("a.adtime desc");
//				UserCoupon uc = new UserCoupon();
//				uc.setUid(req.getUid());
//				uc.setCommunityid(user.getCommunityid());
//				if (!StringUtils.isBlank(req.getHtype())) {
//					uc.setType(req.getHtype());
//				}
//				if ("0".equals(req.getType())) {// 未使用
//					uc.setDataScope(" and a.status=0 and CURDATE()<=a.enddate");
//				} else if ("1".equals(req.getType())) {// 已使用
//					uc.setDataScope(" and a.status=1 ");
//				} else {// 已过期
//					uc.setDataScope(" and a.status=0 and CURDATE()>a.enddate");
//				}
//				Page<UserCoupon> pageInfo = userCouponService.findPage(page, uc);
//				List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//				if (null != pageInfo) {
//					List<UserCoupon> list = pageInfo.getList();
//					if (null != list && list.size() > 0) {
//						for (UserCoupon a : list) {
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("securitiesid", a.getId());
//							map.put("communityId", a.getCommunityid());
//							map.put("communityName", a.getCommunityname());
//							map.put("securitiesMoney", a.getAllmoney());
//							map.put("securitiesType", a.getType());
//							map.put("securitiesPrice", a.getAmount());
//							map.put("securitiesName", a.getName());
//							map.put("securitiesImg", filePath + a.getImage());
//							map.put("securitiesStartTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(a.getStartdate()));
//							map.put("securitiesEndTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(a.getEnddate()));
//							if ("0".equals(req.getType())) {
//								String securitiesState= userCouponService.execSelectSqlString("SELECT DATE('"+DateFormatUtil.ISO_ON_DATE_FORMAT.format(a.getStartdate())+"') <= CURDATE()");
//								map.put("securitiesState",securitiesState);//1可用  0暂不可用
//							}
//							dataList.add(map);
//						}
//					}
//					res.setTotalPage(pageInfo.getTotalPage());
//				}
//				res.setDataList(dataList);
//				res.setResult("0");
//				res.setResultNote("获取我的优惠券成功");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.23 我的收藏
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(SecuritiesListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取我的收藏失败");
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
//			} else {
//				Page<Collect> page = new Page<Collect>(req.getNowPage(), req.getPageCount());
//				page.setOrderBy("a.adtime desc");
//				Collect uc = new Collect();
//				uc.setUid(req.getUid());
//				Page<Collect> pageInfo = collectService.findPage(page, uc);
//				List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//				if (null != pageInfo) {
//					List<Collect> list = pageInfo.getList();
//					if (null != list && list.size() > 0) {
//						for (Collect a : list) {
//							Map<String, Object> map = new HashMap<String, Object>();
//							if ("0".equals(a.getType())) {// 动态
//								Dynamic d = dynamicService.get(a.getObjectid());
//								if (null ==d || d.getState() == 1) {
//									continue;
//								}
//								Tuser u = tuserService.get(d.getUid());
//								map.put("bangbangId", a.getObjectid());
//								map.put("bangbangContent", d.getContent());
//								map.put("bangbangImageUrl",
//										!StringUtils.isBlank(d.getImage()) ? filePath + d.getImage() : "");
//								map.put("bangbangVideoUrl",
//										!StringUtils.isBlank(d.getVideourl()) ? filePath + d.getVideourl() : "");
//								map.put("zanNum", d.getZannum());
//								map.put("commentNum", d.getCommentnum());
//								map.put("userId", u.getId());
//								map.put("userName", u.getNickname());
//								map.put("userIcon",
//										StringUtils.isNotBlank(u.getIcon()) && u.getIcon().indexOf("http://") == -1
//												&& u.getIcon().indexOf("https://") == -1 ? filePath + u.getIcon()
//														: u.getIcon());
//								map.put("userEffectNum", u.getEffectnum());
//								map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(d.getAdtime()));
//								if (d.getHtype() == 0) {// 图片动态
//									CommentImage commentImage = new CommentImage();
//									commentImage.setType("1");
//									commentImage.setCommentid(a.getObjectid());
//									List<CommentImage> imageList = commentImageService.findList(commentImage);
//									List<String> list1 = new ArrayList<String>();
//									if (imageList != null && imageList.size() > 0) {
//										for (CommentImage c : imageList) {
//											list1.add(filePath + c.getImage());
//										}
//									}
//									map.put("bangbangImgUrl", list1);
//								}
//
//							} else {// 活动
//								Activity act = activityService.get(a.getObjectid());
//								Tuser u = tuserService.get(act.getUid());
//								CommentImage commentImage = new CommentImage();
//								commentImage.setType("2");
//								commentImage.setCommentid(a.getObjectid());
//								List<CommentImage> imageList = commentImageService.findList(commentImage);
//								map.put("activityId", a.getObjectid());
//								map.put("activityName", act.getName());
//								map.put("activityImg",
//										(imageList != null && imageList.size() > 0)
//												? filePath + imageList.get(0).getImage()
//												: "");
//								map.put("activityAddress", act.getAddress());
//								map.put("activityTime", act.getStarttime() == null ? ""
//										: DateFormatUtil.DEFAULT_ON_SECOND_FORMATS.format(act.getStarttime()));
//								map.put("activityAllnum", act.getAllnum());
//								map.put("activityNownum", act.getNownum());
//								map.put("activityMoney", act.getMoney());
//								if (act.getSigntime().getTime() > new Date().getTime()) {
//									map.put("activityState", "0");
//								} else if (act.getSigntime().getTime() < new Date().getTime()
//										&& act.getEndtime().getTime() > new Date().getTime()) {
//									map.put("activityState", "1");
//								} else {
//									map.put("activityState", "2");
//								}
//								map.put("zanNum", act.getZannum());
//								map.put("commentNum", act.getCommentnum());
//								map.put("userId", u.getId());
//								map.put("userName", u.getNickname());
//								map.put("userIcon",
//										StringUtils.isNotBlank(u.getIcon()) && u.getIcon().indexOf("http://") == -1
//												&& u.getIcon().indexOf("https://") == -1 ? filePath + u.getIcon()
//														: u.getIcon());
//								map.put("userEffectNum", u.getEffectnum());
//								map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(act.getAdtime()));
//								ActivityMember am = activityMemberService.isActivityMember(req.getUid(), a.getId());
//								map.put("issignup", am.getIssignup());
//							}
//
//							map.put("type", a.getType());
//							dataList.add(map);
//						}
//					}
//					res.setTotalPage(pageInfo.getTotalPage());
//				}
//				res.setDataList(dataList);
//				res.setResult("0");
//				res.setResultNote("获取我的收藏成功");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 *
//	 * 1.24 我的购物车
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(GetUserCartReq req) {
//		MyShopCarRes res = new MyShopCarRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户id不能为空");
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
//			UserCart uc = new UserCart();
//			uc.setUid(req.getUid());
//			if (!StringUtils.isBlank(req.getType())) {
//				uc.setType(req.getType());
//			}
//			uc.setCommunityId(user.getCommunityid());
//			List<UserCart> list = userCartService.findList(uc);
//			List<Map<String, Object>> marketList = new ArrayList<Map<String, Object>>();
//			List<Map<String, Object>> clothesList = new ArrayList<Map<String, Object>>();
//			List<Map<String, Object>> fruitsList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				for (UserCart cart : list) {
//					Map<String, Object> map = new HashMap<String, Object>();
////					String flag = goodsActivityService.getGoodsActivityFlag(cart.getGoodsid());
//					map.put("cartId", cart.getId());
//					map.put("goodsId", cart.getGoodsid());
//					map.put("goodsTitle", cart.getGoodstitle());
//					map.put("goodsType", cart.getType());
//					map.put("goodsImage",!StringUtils.isBlank(cart.getGoodsimage()) ? filePath + cart.getGoodsimage() : "");
////					String specification = userCardService.execSelectSqlString("SELECT specification FROM t_goods WHERE id='"+cart.getGoodsid()+"'");
//					map.put("goodsSpecification", cart.getSpecification());
//					map.put("goodsPrice", cart.getGoodsprice());
////					if("0".equals(flag)){
////						map.put("goodsCuprice", null);
////					}else{
//						map.put("goodsCuprice", cart.getCuprice());
////					}
//					map.put("goodsDesc", cart.getGoodsdesc());
//					map.put("optimizationid", cart.getOptimizationid());
//					map.put("count", cart.getCount());
//					if ("0".equals(cart.getType())) {
//						marketList.add(map);
//					} else if ("1".equals(cart.getType())) {
//						clothesList.add(map);
//					} else {
//						fruitsList.add(map);
//					}
//
//				}
//			}
//			res.setMarketList(marketList);
//			res.setClothesList(clothesList);
//			res.setFruitsList(fruitsList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 *
//	 * 1.241我的购物车 版本升级
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(GetUserCartReq req) {
//		MyShopCarRes res = new MyShopCarRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户id不能为空");
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
//			UserCart uc = new UserCart();
//			uc.setUid(req.getUid());
//			if (!StringUtils.isBlank(req.getType())) {
//				if ("1".equals(req.getType())) {
//					uc.setType(req.getType());
//				}
//			}
//			uc.setCommunityId(user.getCommunityid());
//			List<UserCart> list = userCartService.findList(uc);
//			List<Map<String, Object>> marketList = new ArrayList<Map<String, Object>>();
//			List<Map<String, Object>> clothesList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				for (UserCart cart : list) {
//					Map<String, Object> map = new HashMap<String, Object>();
//					map.put("cartId", cart.getId());
//					map.put("goodsId", cart.getGoodsid());
//					map.put("goodsTitle", cart.getGoodstitle());
//					map.put("goodsType", cart.getType());
//					map.put("goodsImage",!StringUtils.isBlank(cart.getGoodsimage()) ? filePath + cart.getGoodsimage().replace("/images/", "/_thumbs/images/") : "");
////					String specification = userCardService.execSelectSqlString("SELECT specification FROM t_goods WHERE id='"+cart.getGoodsid()+"'");
//					map.put("goodsSpecification", cart.getSpecification());
//					map.put("goodsPrice", cart.getGoodsprice());
//					if(StringUtils.isBlank(cart.getActivityid())){
//						map.put("goodsCuprice", cart.getCuprice());
//					}else{
//						map.put("activityprice", cart.getActivityprice());
//					}
//					map.put("goodsDesc", cart.getGoodsdesc());
//					map.put("optimizationid", cart.getOptimizationid());
//					map.put("count", cart.getCount());
//					map.put("categoryId", cart.getCategoryid());
//					map.put("shelves", cart.getShelves());
//					map.put("discountPrice", cart.getDiscountprice());
//					//如果有活动
//					map.put("activityid", cart.getActivityid());
//					map.put("typeName", cart.getTypeName());
//					if (!"1".equals(req.getType())) {
//							map.put("goodsStock", cart.getStock());
//					}
//					if ("1".equals(cart.getType())) {
//						clothesList.add(map);
//					} else {
//						marketList.add(map);
//					}
//				}
//			}
//			res.setMarketList(marketList);
//			res.setClothesList(clothesList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return res;
//	}
//
//	/**
//	 * 1.25删除购物车
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(DelUserCartReq req) {
//		ResJson res = new ResJson();
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
//			if ("2".equals(req.getType())) {// 删除所有
//				userCartService.delete1(req.getUid());
//			} else {
//				if (req.getObjId() != null && req.getObjId().length > 0) {
//					for (String s : req.getObjId()) {
//						userCartService.deleteById(s);
//					}
//				}
//				if(StringUtils.isNotBlank(req.getObjIds())){
//					String[] ids=req.getObjIds().split(",");
//					for(String s :ids){
//						userCartService.deleteById(s);
//					}
//				}
//			}
//			UserCart userCart = new UserCart();
//			userCart.setUid(req.getUid());
//			userCart.setCommunityId(user.getCommunityid());
//			List<UserCart> cartList = userCartService.findList(userCart);
//			Map<String, Object> nowCount = Maps.newHashMap();
//			if (null != cartList && cartList.size() > 0) {
//				nowCount.put("allCount", cartList.get(0).getAllcount());
//			} else {
//				nowCount.put("allCount", 0);
//			}
//			res.setObject(nowCount);
//			res.setResult("0");
//			res.setResultNote("删除成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.26删除购物车失效商品
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec26(DelUserCartReq req) {
//		ResJson res = new ResJson();
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
//			userCartService.executeUpdateSql(" UPDATE t_user_cart a set a.del_flag='1' where EXISTS ( SELECT 1 FROM t_goods_community gc, t_goods g, t_user u"
//					+" WHERE gc.goodsid = a.goodsid AND a.goodsid = g.id AND gc.communityid = u.communityid and u.id = a.uid "
//					+ "AND (gc.shelves = 1 or g.state = 1) AND a.uid = '"+req.getUid()+"')");
//			userCartService.executeDeleteSql("DELETE FROM t_user_cart where del_flag='1' and uid = '"+req.getUid()+"'");
//
//			UserCart userCart = new UserCart();
//			userCart.setUid(req.getUid());
//			userCart.setCommunityId(user.getCommunityid());
//			List<UserCart> cartList = userCartService.findList(userCart);
//			Map<String, Object> nowCount = Maps.newHashMap();
//			if (null != cartList && cartList.size() > 0) {
//				nowCount.put("allCount", cartList.get(0).getAllcount());
//			} else {
//				nowCount.put("allCount", 0);
//			}
//			res.setObject(nowCount);
//			res.setResult("0");
//			res.setResultNote("删除成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.27更换社区信息
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2(AddCommunityMessageReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("更换社区提交申请失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("请选择社区");
//				return res;
//			}
////			if (StringUtils.isBlank(req.getUnitId())) {
////				res.setResultNote("请选择社区单元");
////				return res;
////			}
//			// 判断用户状态
//			Tuser tuser = tuserService.get(req.getUid());
//
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户已被禁用");
//				return res;
//			}
//			String cId = tuser.getCommunityid();//老社区ID
//			UserCommunity uc = new UserCommunity();
//			uc.setUid(req.getUid());
//			uc.setCommunityid(req.getCommunityId());
//			if (!StringUtils.isBlank(req.getUnitId())) {//老版本更换社区
//				uc.setUnitid(req.getUnitId());
//				uc.setDoornumber(req.getDoorNumber());
//				uc.setReason(req.getReason());
//			}
//			uc.setState(2);//直接通过更换申请
//			uc.setAdtime(new Date());
//			userCommunityService.save(uc);
//			//直接执行社区更换通过申请
//			Tuser u=tuserService.get(req.getUid());
//			u.setCommunityid(req.getCommunityId());
//			Community cc = communityService.get(req.getCommunityId());
//			if (!StringUtils.isBlank(req.getUnitId())) {//老版本更换社区
//				u.setUnitid(req.getUnitId());
//				u.setDoornumber(req.getDoorNumber());
//				List<Object> unitName = addressService.executeSelectSql("SELECT name FROM t_community_menu WHERE  id='"+req.getUnitId()+"'AND communityid ='"+req.getCommunityId()+"'");
//				String address;
//				if(null != unitName && unitName.size() >0 && !"".equals(unitName.get(0).toString())) {
//					address = unitName.get(0).toString()+req.getDoorNumber();
//				}else {
//					address = req.getDoorNumber();
//				}
//				addressService.executeUpdateSql("UPDATE t_address SET communityname='"+cc.getName1()+"',address='"+address+"' "
//			        		+ "WHERE uid='"+req.getUid()+"'");
////			}else{
////				addressService.executeUpdateSql("UPDATE t_address SET communityname='"+cc.getName1()+"' "
////		        		+ "WHERE uid='"+req.getUid()+"'");
//			}
//			tuserService.updateUser(u);
//			userCartService.executeDeleteSql("DELETE FROM t_user_cart WHERE uid='"+u.getId()+"'");
//
////			String  title="更换社区成功";
////			String  content="更换社区已成功！";
////			PushResult result = new PushExample().registerTitle(title, content,u.getToken(),"1",req.getCommunityId(),cc.getName1());//推送pushType：1   更换社区同意
////	        System.out.println("p===" + result);
//
//			IMSocketHandler iim = new IMSocketHandler();
//			LayGroupUser layGroupUser = new LayGroupUser();
//			List<LayGroup> gl = layGroupService.getGroupByCommunityIdOnChange(cId);
//			User user = userMapper.getAll(req.getUid());
//			layGroupUser.setUser(user);
//			for(LayGroup g:gl){
//				layGroupUser.setGroup(g);
//				List<LayGroupUser> lgul = layGroupUserMapper.findList(layGroupUser);
//				if(null==lgul||lgul.size()==0){
//					continue;
//				}
//				int i = layGroupUserMapper.delete(lgul.get(0));
//				if(i>0){
//					com.jeeplus.common.websocket.entity.ResJson re = new com.jeeplus.common.websocket.entity.ResJson();
//					ChatHistory chat = new ChatHistory();
//					chat.setSender(Constants.MSG_TYPE_SYS);
//					chat.setReceiver(layGroupUser.getGroup().getId());
//					chat.setMsg(user.getName()+" 因为更换社区退出了群聊");
//					chat.setType(Constants.TYPE_GROUP);
//					chat.setMsgType(Constants.MSG_TYPE_SYS);
//					chat.setCreateDate(new Date());
//					chat.setStatus("1");
//					chatHistoryService.save(chat);
//
//					List<LayGroupUser> layGroupUserlist = Lists.newArrayList();
//					//群主
//					LayGroupUser owner = new LayGroupUser();
//					LayGroup lg = layGroupService.get(layGroupUser.getGroup().getId());
//					owner.setUser(lg.getCreateBy());//如果是群聊就是群组id
//					layGroupUserlist.add(owner);
//					//群成员
//					LayGroupUser lgu = new LayGroupUser();
//					lgu.setGroup(lg);
//					List<LayGroupUser> zlist = layGroupService.getUsersByGroup(lgu);
//					layGroupUserlist.addAll(zlist);
//					re.setType(Constants.TYPE_GROUP);
//					re.setSender(Constants.MSG_TYPE_SYS);
//					re.setSenderName("系统通知");
//					re.setContent(user.getName()+" 因为更换社区退出了群聊");
//					re.setMsgType(Constants.MSG_TYPE_SYS);
//					re.setReceiver(layGroupUser.getGroup().getId());
//					re.setDataTime(chat.getCreateDate());
//
//					Map<String,String> extras = Maps.newHashMap();
//					extras.put("avatar", user.getPhoto());
//					extras.put("userName", user.getName());
//					extras.put("uid", user.getId());
//					extras.put("extrasType", "out");
//					re.setExtras(JSONObject.toJSON(extras).toString());
//					re.setMsgId(chat.getId());
//					for(LayGroupUser l:layGroupUserlist){
//						iim.sendMessageToUser(l.getUser().getId(),JSONObject.toJSON(re).toString());
//					}
//				}
//			}
//			com.jeeplus.common.websocket.entity.ResJson re = new com.jeeplus.common.websocket.entity.ResJson();
//			re.setType(Constants.TYPE_SYS);
//			re.setSender(Constants.MSG_TYPE_SYS);
//			re.setSenderName("系统通知");
//			re.setContent("更换社区");
//			re.setMsgType(Constants.MSG_TYPE_SYS);
//			re.setReceiver(user.getId());
//			re.setDataTime(new Date());
//
//			Map<String,String> extras = Maps.newHashMap();
//			extras.put("avatar", user.getPhoto());
//			extras.put("userName", user.getName());
//			extras.put("uid", user.getId());
//			extras.put("extrasType", "out");
//			re.setExtras(JSONObject.toJSON(extras).toString());
//			iim.sendMessageToUser(req.getUid(),JSONObject.toJSON(re).toString());
//			res.setResult("0");
//			res.setResultNote("更换社区成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.28 常见问题
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(GetHelpReq req) {
//		ContactUsRes res = new ContactUsRes();
//		res.setResultNote("获取失败");
//		try {
//			Customer c = customerService.get("1");
//			List<Object> phone = communityService
//					.executeSelectSql("SELECT shopphone1 FROM t_community WHERE id='" + req.getCommunityid() + "'");
//			String communityPhone = "";
//			if (null != phone && phone.size() > 0) {
//				communityPhone = phone.get(0).toString();
//			}
//			res.setPhone(c.getPhone());
//			Help help = new Help();
//			List<Help> list = helpService.findList(help);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (null != list && list.size() > 0) {
//				for (Help h : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("title", h.getTitle());
//					map.put("content", h.getContent());
//					dataList.add(map);
//				}
//			}
//			res.setCommunityPhone(communityPhone);
//			List<User> page = userMapper.findList(new User(new Role("4300df29602e4405be1ffcfde9d8ce1d")));
//			res.setCuServiceId(page.get(0).getId());
//			res.setJobTime("客服工作时间:周一至周六  早9—18点 ");
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.29 我的违规
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec5(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
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
//			Page<Report> page = new Page<Report>(req.getNowPage(), req.getPageCount());
//			Report report = new Report();
//			report.setAuid(req.getUid());
//			report.setState(1);
//			Page<Report> pageInfo = reportService.findPage(page, report);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (null != pageInfo) {
//				List<Report> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (Report a : list) {
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("larId", a.getId());
//						map.put("larTitle", a.getTitle());
//						map.put("larContent", a.getContent());
//						map.put("time", DateFormatUtil.ISO_ON_DATE_FORMAT.format(a.getAdtime()));
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.30 我的举报
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec6(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
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
//			Page<Report> page = new Page<Report>(req.getNowPage(), req.getPageCount());
//			Report report = new Report();
//			report.setUid(req.getUid());
//			Page<Report> pageInfo = reportService.findPage(page, report);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (null != pageInfo) {
//				List<Report> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (Report a : list) {
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("larId", a.getId());
//						map.put("larTitle", a.getTitle());
//						map.put("larContent", a.getContent());
//						map.put("userId", a.getAuid());
//						map.put("userName", a.getNickname2());
//						map.put("userIcon",
//								StringUtils.isNotBlank(a.getIcon2()) && a.getIcon2().indexOf("http://") == -1
//										&& a.getIcon2().indexOf("https://") == -1 ? filePath + a.getIcon2()
//												: a.getIcon2());
//						map.put("state", a.getState() + "");
//						map.put("time", DateFormatUtil.ISO_ON_DATE_FORMAT.format(a.getAdtime()));
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：3396" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.31 意见反馈
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec5(GetHelpReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("意见反馈失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getContent())) {
//				res.setResultNote("反馈内容不能为空");
//				return res;
//			}
//			Feedback f = new Feedback();
//			if ("0".equals(req.getType())) {
//				Tuser user = tuserService.get(req.getUid());
//				f.setNickname(user.getNickname());
//				f.setPhone(user.getPhone());
//			} else {
//				Community c = communityService.get(req.getUid());
//				f.setNickname(c.getNickname());
//				f.setPhone(c.getLoginname());
//			}
//			f.setType(req.getType());
//			f.setUid(req.getUid());
//			f.setContent(req.getContent());
//			f.setAdtime(new Date());
//			feedbackService.save1(f);
//			res.setResult("0");
//			res.setResultNote("意见反馈成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：3438" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.32 我的动态
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec7(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		String remark = "";
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
//			Page<Dynamic> page = new Page<Dynamic>(req.getNowPage(), req.getPageCount());
//			Dynamic dynamic = new Dynamic();
//			dynamic.setUid(req.getUid());
//			dynamic.setType(0);
//			dynamic.setIsself("1");
//			dynamic.setFilePath(filePath);
//			if (!req.getUid().equals(req.getMyuid())) {// 不是自己
//				dynamic.setState(0);
//				try {
//					UserRemarks ur = userRemarksService.gets(req.getMyuid(), req.getUid());
//					if (ur != null && ur.getRemarks() != null) {
//						remark = ur.getRemarks();
//					}
//				} catch (Exception e) {
//					logger.error("请求处理异常：3480" );
//					e.printStackTrace();
//				}
//			}
//			Page<Dynamic> pageInfo = dynamicService.findPageNew(page, dynamic);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<Dynamic> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (Dynamic a : list) {
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("dynamicId", a.getId());
//						map.put("dynamicUid", a.getUid());
//						if (!StringUtils.isBlank(remark)) {
//							map.put("dynamicName", remark);
//						} else {
//							map.put("dynamicName", a.getDynamicname());
//						}
//						map.put("dynamicIcon",a.getDynamicicon());
//						map.put("dynamicContent", a.getContent());
//						map.put("dynamicAddress", a.getAddress());
//						map.put("userEffectNum", a.getUsereffectnum());
//						map.put("zanNum", a.getZannum());
//						map.put("commentNum", a.getCommentnum());
//						map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getAdtime()));
//						map.put("isZan", a.getIszan());
//						if (a.getHtype() == 0) {// 图片动态
//							List<Object> list1 = commentImageService.executeSelectSql("SELECT concat('"+filePath+"',a.image) as image "
//									+ "FROM t_comment_image a WHERE A.type = '1' and a.commentid = '"+a.getId()+"'");
//							map.put("dynamicImgList", list1);
//						} else {// 视频动态
//							map.put("dynamicImg", a.getImage());
//							map.put("dynamicVideo", a.getVideourl() + "");
//
//						}
//						map.put("height", a.getHeight());
//						map.put("width", a.getWidth());
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：3540" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//	/**
//	 * 1.32 我的动态(新)
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec7New(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		String remark = "";
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
//			Page<DynamicUnion> page = new Page<DynamicUnion>(req.getNowPage(), req.getPageCount());
//			DynamicUnion dynamic = new DynamicUnion();
//			dynamic.setUid(req.getUid());
//			dynamic.setType(req.getType());
//			dynamic.setIsself("1");
//			dynamic.setFilePath(filePath);
//			if (!req.getUid().equals(req.getMyuid())) {// 不是自己
//				dynamic.setState("0");
//				try {
//					UserRemarks ur = userRemarksService.gets(req.getMyuid(), req.getUid());
//					if (ur != null && ur.getRemarks() != null) {
//						remark = ur.getRemarks();
//					}
//				} catch (Exception e) {
//					logger.error("请求处理异常：3480" );
//					e.printStackTrace();
//				}
//			}
//			Page<DynamicUnion> pageInfo = dynamicService.findUnionAllPageNew(page, dynamic);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<DynamicUnion> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (DynamicUnion a : list) {
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("dynamicId", a.getId());
//						map.put("dynamicType", a.getType());
//						map.put("dynamicUid", a.getUid());
//						if (!StringUtils.isBlank(remark)) {
//							map.put("dynamicName", remark);
//						} else {
//							map.put("dynamicName", a.getDynamicname());
//						}
//						map.put("dynamicIcon",a.getDynamicicon());
//						map.put("dynamicContent", a.getContent());
//						map.put("dynamicAddress", a.getAddress());
//						map.put("userEffectNum", a.getUsereffectnum());
//						map.put("zanNum", a.getZannum());
//						map.put("commentNum", a.getCommentnum());
//						map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getAdtime()));
//						map.put("isZan", a.getIszan());
//						if ("0".equals(a.getHtype())) {// 图片动态
//							List<Object> list1 = commentImageService.executeSelectSql("SELECT concat('"+filePath+"',a.image) as image "
//									+ "FROM t_comment_image a WHERE a.commentid = '"+a.getId()+"'");
//							map.put("dynamicImgList", list1);
//						} else {// 视频动态
//							map.put("dynamicImg", a.getImage());
//							map.put("dynamicVideo", a.getVideourl() + "");
//
//						}
//						map.put("height", a.getHeight());
//						map.put("width", a.getWidth());
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：3540" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.33 动态详情
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec8(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
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
//			Dynamic a = dynamicService.get(req.getDynamicId());
//			if (null == a) {
//				res.setResultNote("动态已经删除");
//				return res;
//			}
//			Map<String, Object> map = new HashMap<String, Object>();
//			try {
//				UserRemarks ur = userRemarksService.gets(req.getUid(), a.getUid());
//				if (ur != null && ur.getRemarks() != null) {
//					map.put("dynamicName", ur.getRemarks());
//				} else {
//					map.put("dynamicName", a.getDynamicname());
//				}
//			} catch (Exception e) {
//				logger.error("请求处理异常：3579" );
//				e.printStackTrace();
//			}
//			map.put("dynamicId", a.getId());
//			map.put("dynamicUid", a.getUid());
//			map.put("dynamicIcon",
//					StringUtils.isNotBlank(a.getDynamicicon()) && a.getDynamicicon().indexOf("http://") == -1
//							&& a.getDynamicicon().indexOf("https://") == -1 ? filePath + a.getDynamicicon()
//									: a.getDynamicicon());
//			map.put("dynamicContent", a.getContent());
//			map.put("dynamicAddress", a.getAddress());
//			map.put("userEffectNum", a.getUsereffectnum());
//			map.put("state", a.getState());
//			map.put("type", a.getType());
//			map.put("zanNum", a.getZannum());
//			map.put("commentNum", a.getCommentnum());
//			map.put("communityName", a.getCommunityname());
//			map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getAdtime()));
//			if (a.getHtype() == 0) {// 图片动态
//				CommentImage commentImage = new CommentImage();
//				commentImage.setType("1");
//				commentImage.setCommentid(a.getId());
//				List<CommentImage> imageList = commentImageService.findList(commentImage);
//				List<String> list1 = new ArrayList<String>();
//				if (imageList != null && imageList.size() > 0) {
//					for (CommentImage c : imageList) {
//						list1.add(filePath + c.getImage());
//					}
//				}
//				map.put("dynamicImgList", list1);
//			} else {// 视频动态
//				map.put("dynamicImg", !StringUtils.isBlank(a.getImage()) ? filePath + a.getImage() : "");
//				map.put("dynamicVideo",
//						a.getVideourl().indexOf("http://") != -1 ? a.getVideourl() : filePath + a.getVideourl() + "");
//
//			}
//			map.put("height", a.getHeight());
//			map.put("width", a.getWidth());
//			DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "1", a.getId());
//			map.put("isZan", dz.getIszan());
//			UserAttention ua = userAttentionService.isattention(req.getUid(), "0", a.getUid());
//			map.put("isAttention", ua.getIsattention());
//			Collect coll = new Collect();
//			coll.setUid(req.getUid());
//			coll.setObjectid(a.getId());
//			coll.setType("0");
//			Collect collect = collectService.isCollect(coll);
//			map.put("iscang", collect.getUid());
//			res.setObject(map);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：3670" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.34 获取动态评论
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec9(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
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
//			// 获取评论
//			Page<Comment> page = new Page<Comment>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime asc");
//			Comment c = new Comment();
//			c.setType("1");
//			c.setObjid(req.getDynamicId());
//			c.setState("0");
//			Page<Comment> pageInfo = commentService.findPage(page, c);
//			List<Comment> list = pageInfo.getList();
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				for (Comment cc : list) {
//					Map<String, Object> map1 = new HashMap<String, Object>();
//					map1.put("commentId", cc.getId());
//					map1.put("commentUid", cc.getUid());
//					map1.put("commentIcon",
//							StringUtils.isNotBlank(cc.getCommenticon()) && cc.getCommenticon().indexOf("http://") == -1
//									&& cc.getCommenticon().indexOf("https://") == -1 ? filePath + cc.getCommenticon()
//											: cc.getCommenticon());
//					try {
//						UserRemarks ur = userRemarksService.gets(req.getUid(), cc.getUid());
//						if (ur != null && ur.getRemarks() != null) {
//							map1.put("commentName", ur.getRemarks());
//						} else {
//							map1.put("commentName", cc.getCommentname());
//						}
//					} catch (Exception e) {
//						logger.error("请求处理异常：3726" );
//						e.printStackTrace();
//					}
//					map1.put("commentContent", cc.getContent());
//					map1.put("commentTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(cc.getAdtime()));
//					map1.put("zanNum", cc.getZannum());
//					map1.put("secondNum", cc.getCommentnum());
//					DynamicZan dzz = dynamicZanService.isDynamicZan(req.getUid(), "2", cc.getId());
//					map1.put("isZan", dzz.getIszan());
//
//					// 获取二级评论
//					Comment c2 = new Comment();
//					c2.setPid(cc.getId());
//					c2.setState("1");
//					List<Comment> comment2list = commentService.findList(c2);
//					if (null != comment2list && comment2list.size() > 0) {
//						List<Map<String, Object>> comment2data = Lists.newArrayList();
//						for (Comment cc2 : comment2list) {
//							Map<String, Object> map2 = new HashMap<String, Object>();
//							map2.put("commentId", cc2.getId());
//							map2.put("commentUid", cc2.getUid());
//							map2.put("commentIcon",
//									StringUtils.isNotBlank(cc2.getCommenticon()) && cc2.getCommenticon().indexOf("http://") == -1
//											&& cc2.getCommenticon().indexOf("https://") == -1 ? filePath + cc2.getCommenticon()
//													: cc2.getCommenticon());
//							try {
//								UserRemarks ur = userRemarksService.gets(req.getUid(), cc2.getUid());
//								if (ur != null && ur.getRemarks() != null) {
//									map2.put("commentName", ur.getRemarks());
//								} else {
//									map2.put("commentName", cc2.getCommentname());
//								}
//							} catch (Exception e) {
//								logger.error("请求处理异常：3396" );
//								e.printStackTrace();
//							}
//							map2.put("commentContent", cc2.getContent());
//							map2.put("commentTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(cc2.getAdtime()));
//							comment2data.add(map2);
//						}
//						map1.put("comment2", comment2data);
//					}
//
//					dataList.add(map1);
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：3743" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.35 获取动态二级评论
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec10(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
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
//			// 获取评论
//			Page<Comment> page = new Page<Comment>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime asc");
//			Comment c = new Comment();
//			c.setType("1");
//			c.setPid(req.getCommentId());
//			c.setState("1");
//			Page<Comment> pageInfo = commentService.findPage(page, c);
//			List<Comment> list = pageInfo.getList();
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				for (Comment cc : list) {
//					Map<String, Object> map1 = new HashMap<String, Object>();
//					map1.put("commentId", cc.getId());
//					map1.put("commentUid", cc.getUid());
//					map1.put("commentIcon",
//							StringUtils.isNotBlank(cc.getCommenticon()) && cc.getCommenticon().indexOf("http://") == -1
//									&& cc.getCommenticon().indexOf("https://") == -1 ? filePath + cc.getCommenticon()
//											: cc.getCommenticon());
//					try {
//						UserRemarks ur = userRemarksService.gets(req.getUid(), cc.getUid());
//						if (ur != null && ur.getRemarks() != null) {
//							map1.put("commentName", ur.getRemarks());
//						} else {
//							map1.put("commentName", cc.getCommentname());
//						}
//					} catch (Exception e) {
//						logger.error("请求处理异常：3799" );
//						e.printStackTrace();
//					}
//					map1.put("commentContent", cc.getContent());
//					map1.put("commentTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(cc.getAdtime()));
//					dataList.add(map1);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：3811" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.36 动态点赞
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec11(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("点赞失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getDynamicId())) {
//				res.setResultNote("动态ID不能为空");
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
//			if (StringUtils.isBlank(req.getCommentId())) {// 动态
//				DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "1", req.getDynamicId());
//				if ("0".equals(dz.getIszan())) {// 没赞过，点赞
//					DynamicZan dz1 = new DynamicZan();
//					dz1.setUid(req.getUid());
//					dz1.setType(1);
//					dz1.setObjid(req.getDynamicId());
//					dz1.setAdtime(new Date());
//					dynamicZanService.save(dz1);
//					dynamicService.addDynamicZan(req.getDynamicId());
//					res.setResultNote("点赞成功");
//
//					Dynamic d = dynamicService.get(req.getDynamicId());
//					if(null == d){
//						res.setResultNote("动态已经删除");
//						return res;
//					}
//
//					Msg m = new Msg();
//					m.setUid(d.getUid());
//					m.setType("1");
//					m.setHtype("3");
//					m.setTitle("点赞消息");
//					try {
//						UserRemarks ur = userRemarksService.gets(d.getUid(), req.getUid());
//						if (ur != null && ur.getRemarks() != null) {
//							m.setContent(ur.getRemarks() + "赞了您");
//						} else {
//							m.setContent(user.getNickname() + "赞了您");
//						}
//					} catch (Exception e) {
//						logger.error("请求处理异常：3869" );
//						e.printStackTrace();
//					}
//					m.setUrl(dz1.getId());
//					m.setStatus("");
//					m.setAdtime(new Date());
//					msgService.save(m);
//					// 增值影响力
//					List<Object> obComments = scoreDetailService
//							.executeSelectSql("SELECT SUM(score) FROM t_score_detail WHERE uid='" + user.getId()
//									+ "' AND category='点赞' AND to_days(adtime) = to_days(now())");
//					Task t = taskService.get("8");
//					if (null != obComments.get(0)) {
//						Integer comments = Integer.valueOf(obComments.get(0).toString());
//						if (comments < 50) {
//							scoreDetailService.executeInsertSql("INSERT INTO t_score_detail VALUES('" + IdGen.uuid()
//									+ "','" + user.getId() + "','点赞','" + t.getEffectnum() + "',NOW());");
//						}
//					} else {
//						scoreDetailService.executeInsertSql("INSERT INTO t_score_detail VALUES('" + IdGen.uuid() + "','"
//								+ user.getId() + "','点赞','" + t.getEffectnum() + "',NOW());");
//					}
//
//					user.setEffectnum(user.getEffectnum() + t.getEffectnum());
//					tuserService.executeUpdateSql("UPDATE t_user SET effectnum ='" + user.getEffectnum()
//							+ "' WHERE id='" + user.getId() + "'");
//				} else {// 赞过，取消点赞
//					dynamicZanService.executeDeleteSql(
//							"delete from t_msg where type=1 and htype=3 and url=(select id from t_dynamic_zan where uid='"
//									+ req.getUid() + "' and objid='" + req.getDynamicId() + "')");
//					dynamicZanService.deleteZan(req.getUid(), "1", req.getDynamicId());
//					dynamicService.reduceDynamicZan(req.getDynamicId());
//					res.setResultNote("取消点赞成功");
//				}
//			} else {// 一级评论
//				DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "2", req.getCommentId());
//				if ("0".equals(dz.getIszan())) {// 没赞过，点赞
//					DynamicZan dz1 = new DynamicZan();
//					dz1.setUid(req.getUid());
//					dz1.setType(2);
//					dz1.setObjid(req.getCommentId());
//					dz1.setAdtime(new Date());
//					dynamicZanService.save(dz1);
//					commentService.addCommentZan(req.getCommentId());
//					// 增值影响力
//					List<Object> obComments = scoreDetailService
//							.executeSelectSql("SELECT SUM(score) FROM t_score_detail WHERE uid='" + user.getId()
//									+ "' AND category='点赞' AND to_days(adtime) = to_days(now())");
//					Task t = taskService.get("8");
//					if (null != obComments.get(0)) {
//						Integer comments = Integer.valueOf(obComments.get(0).toString());
//						if (comments < 50) {
//							scoreDetailService.executeInsertSql("INSERT INTO t_score_detail VALUES('" + IdGen.uuid()
//									+ "','" + user.getId() + "','点赞','" + t.getEffectnum() + "',NOW());");
//						}
//					} else {
//						scoreDetailService.executeInsertSql("INSERT INTO t_score_detail VALUES('" + IdGen.uuid() + "','"
//								+ user.getId() + "','点赞','" + t.getEffectnum() + "',NOW());");
//					}
//					user.setEffectnum(user.getEffectnum() + t.getEffectnum());
//					tuserService.executeUpdateSql("UPDATE t_user SET effectnum ='" + user.getEffectnum()
//							+ "' WHERE id='" + user.getId() + "'");
//					res.setResultNote("点赞成功");
//				} else {// 赞过，取消点赞
//					commentService.reduceCommentZan(req.getCommentId());
//					dynamicZanService.deleteZan(req.getUid(), "2", req.getCommentId());
//					res.setResultNote("取消点赞成功");
//				}
//			}
//			res.setResult("0");
//		} catch (Exception e) {
//			logger.error("请求处理异常：3940" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.37 动态评论
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec12(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("评论失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getDynamicId())) {
//				res.setResultNote("动态ID不能为空");
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
//			if (StringUtils.isBlank(req.getCommentId())) {// 一级评论
//				Comment c = new Comment();
//				String id = IdGen.uuid();
//				c.setId(id);
//				c.setUid(req.getUid());
//				c.setType("1");
//				c.setState("0");
//				c.setObjid(req.getDynamicId());
//				c.setZannum(0);
//				c.setCommentnum(0);
//				c.setContent(req.getContent());
//				c.setAdtime(new Date());
//				commentService.insert(c);
//				dynamicService.addDynamicComment(req.getDynamicId());
//				Dynamic d = dynamicService.get(req.getDynamicId());
//				Msg m = new Msg();
//				m.setUid(d.getUid());
//				m.setType("1");
//				m.setHtype("2");
//				m.setTitle("评论消息");
//				m.setContent(req.getContent());
//				m.setUrl(id);
//				m.setStatus("");
//				m.setAdtime(new Date());
//				msgService.save(m);
//				res.setObject(c.getId());
//			} else {// 二级评论
//				Comment c = new Comment();
//				String id = IdGen.uuid();
//				c.setId(id);
//				c.setUid(req.getUid());
//				c.setType("1");
//				c.setState("1");
//				c.setObjid(req.getDynamicId());
//				c.setPid(req.getCommentId());
//				c.setZannum(0);
//				c.setCommentnum(0);
//				c.setContent(req.getContent());
//				c.setAdtime(new Date());
//				commentService.insert(c);
//				commentService.addCommentcomm(req.getCommentId());
//				Comment d = commentService.get(req.getCommentId());
//				Msg m = new Msg();
//				m.setUid(d.getUid());
//				m.setType("1");
//				m.setHtype("2");
//				m.setTitle("评论消息");
//				m.setContent(req.getContent());
//				m.setUrl(id);
//				m.setStatus("");
//				m.setAdtime(new Date());
//				msgService.save(m);
//				res.setObject(c.getId());
//			}
//			// 增值影响力
//			List<Object> obComments = scoreDetailService
//					.executeSelectSql("SELECT SUM(score) FROM t_score_detail WHERE uid='" + user.getId()
//							+ "' AND category='点赞' AND to_days(adtime) = to_days(now())");
//			Task t = taskService.get("7");
//			if (null != obComments.get(0)) {
//				Integer comments = Integer.valueOf(obComments.get(0).toString());
//				if (comments < 50) {
//					scoreDetailService.executeInsertSql("INSERT INTO t_score_detail VALUES('" + IdGen.uuid()
//							+ "','发布评论','" + user.getId() + "','" + t.getEffectnum() + "',NOW());");
//				}
//			} else {
//				scoreDetailService.executeInsertSql("INSERT INTO t_score_detail VALUES('" + IdGen.uuid() + "','"
//						+ user.getId() + "','发布评论','" + t.getEffectnum() + "',NOW());");
//			}
//			user.setEffectnum(user.getEffectnum() + t.getEffectnum());
//			tuserService.executeUpdateSql(
//					"UPDATE t_user SET effectnum ='" + user.getEffectnum() + "' WHERE id='" + user.getId() + "'");
//			res.setResult("0");
//			res.setResultNote("评论成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：4047" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.38 我的关注
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec13(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		String sql;
//		List<Object> lists;
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
//			Page<UserAttention> page = new Page<UserAttention>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			UserAttention u = new UserAttention();
//			u.setDataScope("and a.type=0");
//			u.setUsername(req.getContent());
//			if ("0".equals(req.getType())) {
//				u.setUid(req.getUid());
//				u.setState(1);
//				u.setIsattention("1");
//				sql = "select count(1) from t_user_attention where uid='" + req.getUid() + "' and type=0 and state=1";
//				lists = userAttentionService.executeSelectSql(sql);
//				if (lists != null) {
//					res.setAllnum(lists.get(0).toString());
//				} else {
//					res.setAllnum(0 + "");
//				}
//
//			} else if ("1".equals(req.getType())) {
//				u.setUid(req.getUid());
//				u.setIsattention("1");
//				res.setAllnum(user.getAttennum() + "");
//			} else {
//				u.setAuid(req.getUid());
//				u.setIsattention("(select count(1) from t_user_attention ua where ua.type=0 and ua.uid='" + req.getUid()
//						+ "' and ua.auid=a.uid)");
//				res.setAllnum(user.getFansnum() + "");
//			}
//			Page<UserAttention> pageInfo = userAttentionService.findPage(page, u);
//			List<UserAttention> list = pageInfo.getList();
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				for (UserAttention cc : list) {
//					Map<String, Object> map1 = new HashMap<String, Object>();
//					if ("2".equals(req.getType())) {
//						map1.put("userId", cc.getUid());
//					} else {
//						map1.put("userId", cc.getAuid());
//					}
//					try {
//						UserRemarks ur = userRemarksService.gets(req.getUid(), map1.get("userId").toString());
//						if (ur != null && ur.getRemarks() != null) {
//							map1.put("userName", ur.getRemarks());
//						} else {
//							map1.put("userName", cc.getUsername());
//						}
//					} catch (Exception e) {
//						logger.error("请求处理异常：4124" );
//						e.printStackTrace();
//					}
//					map1.put("userIcon",
//							StringUtils.isNotBlank(cc.getUsericon()) && cc.getUsericon().indexOf("http://") == -1
//									&& cc.getUsericon().indexOf("https://") == -1 ? filePath + cc.getUsericon()
//											: cc.getUsericon());
//					map1.put("userSex", cc.getUsersex());
//					map1.put("userAge", StringUtils.isBlank(cc.getBirthday()) ? ""
//							: Year.getAge(DateTimeUtil.parse(cc.getBirthday())) + "");
//					map1.put("userAutograph", cc.getUserautograph());
//					map1.put("effectNum", cc.getEffectnum());
//					map1.put("constellation", cc.getConstellation());
//					map1.put("isAttention", cc.getIsattention());
//					dataList.add(map1);
//				}
//
//			}
//			res.setTotalPage(pageInfo.getTotalPage());
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：4147" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.39 关注好友
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec14(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("关注失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getAuid())) {
//				res.setResultNote("对方ID不能为空");
//				return res;
//			}
//			if (req.getUid().equals(req.getAuid())) {
//				res.setResultNote("不能关注自己");
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
//			UserAttention ua = userAttentionService.isattention(req.getUid(), "0", req.getAuid());
//			if ("0".equals(ua.getIsattention())) {// 没关注
//				UserAttention ua1 = new UserAttention();
//				ua1.setUid(req.getUid());
//				ua1.setAuid(req.getAuid());
//				ua1.setType(0);
//				ua1.setAdtime(new Date());
//				UserAttention uaa = userAttentionService.isattention(req.getAuid(), "0", req.getUid());
//				if ("1".equals(uaa.getIsattention())) {// 对方已经关注你
//					ua1.setState(1);
//					userAttentionService.executeUpdateSql("update t_user_attention set state=1 where type=0 and uid='"
//							+ req.getAuid() + "' and auid='" + req.getUid() + "'");
//				} else {
//					ua1.setState(0);
//				}
//				userAttentionService.save(ua1);
//				res.setResultNote("关注成功");
//			} else {// 已关注，取消关注
//				userAttentionService.deleteatten(req.getUid(), "0", req.getAuid());
//				res.setResultNote("取消关注成功");
//			}
//			res.setResult("0");
//		} catch (Exception e) {
//			logger.error("请求处理异常：4206" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.40 收获地址列表
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(UserAddressListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
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
//
//			/*
//			 * List<Object> endTimeList = commentService.
//			 * executeSelectSql("SELECT m.endTime FROM t_merchant_rest m WHERE" +
//			 * " m.communityid = '"+req.getCommunityid()+"' AND m.state='0'");
//			 * if(endTimeList.size() ==0|| endTimeList ==null) { res.setState("2"); }else {
//			 * SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			 * Date endTime=formatter.parse(endTimeList.get(0).toString()); Date currentDate
//			 * = new Date(); if(endTime.getTime() < currentDate.getTime()) { commentService.
//			 * executeUpdateSql("UPDATE t_merchant_rest m SET m.state = '1' WHERE m.communityid = '"
//			 * +req.getCommunityid()+"'"); res.setState("1"); }else { res.setState("0");
//			 * res.setResultNote("商家休息,"+endTimeList.get(0).toString()+"后营业"); } }
//			 */
//
//			Page<Address> page = new Page<Address>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.isdefault desc,a.adtime desc");
//			Address address = new Address();
//			address.setUid(req.getUid());
//
//			Page<Address> pageInfo = addressService.findPage(page, address);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//
//			if (null != pageInfo) {
//				List<Address> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (Address a : list) {
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("addressId", a.getId());
//						map.put("username", a.getUsername());
//						map.put("userPhone", a.getUserphone());
//						map.put("city", a.getCity());
//						map.put("communityName", a.getCommunityName());
//						map.put("address", a.getAddress());
//						map.put("isdefault", a.getIsdefault());
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：4278" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.41添加收货地址
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(AddUserAddressReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("添加失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getUsername())) {
//				res.setResultNote("收货人姓名不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getUserPhone())) {
//				res.setResultNote("收货人电话不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCity())) {
//				res.setResultNote("收货省市不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getAddress())) {
//				res.setResultNote("详细地址不能为空");
//				return res;
//			}
//
//			String isdefault = "0";// 不默认
//			if ("1".equals(req.getIsdefault())) {
//				isdefault = "1";// 默认
//			}
//
//			Tuser user = tuserService.get(req.getUid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			} else {
//				Address address = new Address();
//				address.setId(IdGen.uuid());
//				address.setUid(req.getUid());
//				address.setUsername(req.getUsername());
//				address.setUserphone(req.getUserPhone());
//				address.setCity(req.getCity());
//				address.setCommunityName(req.getCommunityName());
//				address.setAddress(req.getAddress());
//				address.setIsdefault(isdefault);
//				address.setAdtime(new Date());
//				addressService.addAddress(address);
//				res.setResult("0");
//				res.setResultNote("添加成功");
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：4343" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.42修改收货地址
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(EditUserAddressReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("编辑失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getAddressId())) {
//				res.setResultNote("地址ID不能为空");
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
//			Address address = addressService.get(req.getAddressId());
//			if (null == address) {
//				res.setResultNote("该地址不存在");
//			} else if (!req.getUid().equals(address.getUid())) {
//				res.setResultNote("该地址不存在");
//			} else {
//				String isdefault = "0";
//				if ("1".equals(req.getIsdefault())) {
//					isdefault = "1";// 默认
//				}
//
//				Address a = new Address();
//				a.setId(req.getAddressId());
//				a.setUid(req.getUid());
//				a.setUsername(req.getUsername());
//				a.setUserphone(req.getUserPhone());
//				a.setCity(req.getCity());
//				a.setCommunityName(req.getCommunityName());
//				a.setAddress(req.getAddress());
//				a.setIsdefault(isdefault);
//				addressService.updateAddress(a);
//				res.setResult("0");
//				res.setResultNote("编辑成功");
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：4400" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.43 删除收获地址
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(DelUserAddressReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("删除失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getAddressId())) {
//				res.setResultNote("地址ID不能为空");
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
//			Address address = addressService.get(req.getAddressId());
//			if (null == address) {
//				res.setResultNote("该地址不存在");
//			} else {
//				if (!req.getUid().equals(address.getUid())) {
//					res.setResultNote("该地址不存在");
//				} else {
//					addressService.delete(address);
//					res.setResult("0");
//					res.setResultNote("删除成功");
//				}
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：4445" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.44 我的订单
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(UserOrderListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
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
//			UserOrder userOrder = new UserOrder();
//			userOrder.setUid(req.getUid());
//			Page<UserOrder> page = new Page<UserOrder>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.updatetime desc");
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
//						if ("6".equals(order.getStatus())) {
//							map.put("orderState", "7");
//						} else {
//							map.put("orderState", order.getStatus());
//						}
//
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
//								GoodsCommunity goods = goodsCommunityService.gets(user.getCommunityid(),
//										uo.getGoodsid());
//								orderlistMap.put("commodityid", uo.getGoodsid());
//								orderlistMap.put("commodityPic",
//										StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage()
//												: "");
//								orderlistMap.put("commodityTitle", uo.getGoodstitle());
//								orderlistMap.put("commodityDesc", uo.getGoodsdesc());
//								orderlistMap.put("commodityPrice", uo.getGoodsprice() + "");
//								orderlistMap.put("commodityBuyNum", uo.getGoodsnum() + "");
//								if (goods == null) {
//									orderlistMap.put("optimizationid", null);
//								} else {
//									orderlistMap.put("optimizationid", goods.getOptimizationid());
//								}
//
//								goodsList.add(orderlistMap);
//							}
//						}
//						map.put("orderCommodity", goodsList);
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：4539" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.441 我的订单 1.03版本
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec03version(UserOrderListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
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
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			UserOrder userOrder = new UserOrder();
//			userOrder.setUid(req.getUid());
//			if (null == req.getType() && "".equals(req.getType())) {
//
//				Page<UserOrder> page = new Page<UserOrder>(req.getNowPage(), req.getPageCount());
//				page.setOrderBy("a.updatetime desc");
//				Page<UserOrder> pageInfo = userOrderService.findPage(page, userOrder);
//				if (null != pageInfo) {
//					List<UserOrder> list = pageInfo.getList();
//					if (null != list && list.size() > 0) {
//						for (UserOrder order : list) {
//							DecimalFormat df = new DecimalFormat("#0.00");
//							String allprice = df.format(order.getAllprice());
//							String payprice = df.format(order.getPayprice());
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("orderNum", order.getOrdernum());
//							map.put("orderActivityType", StringUtils.isBlank(order.getActivityType())?"0":order.getActivityType());
//							map.put("orderType", order.getOrdertype());
//							map.put("oderAllPrice", allprice);
//							map.put("oderPayPrice", payprice);
//							map.put("orderState", order.getStatus());
//							map.put("discountPrice", order.getDiscountprice());
//							map.put("securitiesPrice", order.getCouponmoney());
//							map.put("adtime",
//									null != order.getAdtime()
//											? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(order.getAdtime())
//											: "");
//							UserOrderlist userOrderlist = new UserOrderlist();
//							userOrderlist.setOrdernum(order.getOrdernum());
//							List<UserOrderlist> list2 = userOrderlistService.findList(userOrderlist);
//							List<Map<String, String>> goodsList = new ArrayList<Map<String, String>>();
//							if (null != list2 && list2.size() > 0) {
//								for (UserOrderlist uo : list2) {
//									Map<String, String> orderlistMap = new HashMap<String, String>();
//									GoodsCommunity goods = null;
//									if(StringUtils.isBlank(uo.getActivityid())){
//										goods = goodsCommunityService.gets(user.getCommunityid(), uo.getGoodsid());
//									}else{
//										goods = goodsCommunityService.getsTwo(user.getCommunityid(), uo.getGoodsid(),uo.getActivityid());
//										orderlistMap.put("typeName", goods.getTypeName());
//										orderlistMap.put("activityprice",goods.getActivityprice()+"");
//										orderlistMap.put("activityid", goods.getActivityid());
//									}
////									String specification = goodsService.execSelectSqlString("SELECT specification FROM t_goods WHERE id='"+uo.getGoodsid()+"'");
//									orderlistMap.put("commoditySpecification", uo.getGoodsSpecification());
//									orderlistMap.put("commodityid", uo.getGoodsid());
//									orderlistMap.put("commodityPic",
//											StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage()
//													: "");
//									orderlistMap.put("commodityTitle", uo.getGoodstitle());
//									orderlistMap.put("commodityDesc", uo.getGoodsdesc());
//									orderlistMap.put("commodityPrice", uo.getGoodsprice() + "");
//									orderlistMap.put("commodityBuyNum", uo.getGoodsnum() + "");
//									orderlistMap.put("discountPrice", uo.getDiscountprice());
//									if (goods == null) {
//										orderlistMap.put("optimizationid", null);
//									} else {
//										orderlistMap.put("optimizationid", goods.getOptimizationid());
//									}
//
//									goodsList.add(orderlistMap);
//								}
//							}
//							map.put("orderCommodity", goodsList);
//							dataList.add(map);
//						}
//					}
//					res.setTotalPage(pageInfo.getTotalPage());
//				}
//			} else {
//
//				userOrder.setType(req.getType());
//				Page<UserOrder> page = new Page<UserOrder>(req.getNowPage(), req.getPageCount());
//				page.setOrderBy("a.updatetime desc");
//				Page<UserOrder> pageInfo = userOrderService.findPage(page, userOrder);
//				if (null != pageInfo) {
//					List<UserOrder> list = pageInfo.getList();
//					if (null != list && list.size() > 0) {
//						for (UserOrder order : list) {
//							DecimalFormat df = new DecimalFormat("#0.00");
//							String allprice = df.format(order.getAllprice());
//							String payprice = df.format(order.getPayprice());
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("orderNum", order.getOrdernum());
//							map.put("orderActivityType", StringUtils.isBlank(order.getActivityType())?"0":order.getActivityType());
//							map.put("orderType", order.getOrdertype());
//							map.put("oderAllPrice", allprice);
//							map.put("oderPayPrice", payprice);
//							map.put("orderState", order.getStatus());
//							map.put("discountPrice", order.getDiscountprice());
//							map.put("securitiesPrice", order.getCouponmoney());
//							map.put("adtime",
//									null != order.getAdtime()
//											? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(order.getAdtime())
//											: "");
//							UserOrderlist userOrderlist = new UserOrderlist();
//							userOrderlist.setOrdernum(order.getOrdernum());
//							List<UserOrderlist> list2 = userOrderlistService.findList(userOrderlist);
//							List<Map<String, String>> goodsList = new ArrayList<Map<String, String>>();
//							if (null != list2 && list2.size() > 0) {
//								for (UserOrderlist uo : list2) {
//									Map<String, String> orderlistMap = new HashMap<String, String>();
//									GoodsCommunity goods = null;
//									if(StringUtils.isBlank(uo.getActivityid())){
//										goods = goodsCommunityService.gets(user.getCommunityid(), uo.getGoodsid());
//									}else{
//										goods = goodsCommunityService.getsTwo(user.getCommunityid(), uo.getGoodsid(),uo.getActivityid());
//										orderlistMap.put("typeName", goods.getTypeName());
//										orderlistMap.put("activityprice",goods.getActivityprice()+"");
//										orderlistMap.put("activityid", goods.getActivityid());
//									}
////									String specification = goodsService.execSelectSqlString("SELECT specification FROM t_goods WHERE id='"+uo.getGoodsid()+"'");
//									orderlistMap.put("commoditySpecification", uo.getGoodsSpecification());
//									orderlistMap.put("commodityid", uo.getGoodsid());
//									orderlistMap.put("commodityPic",
//											StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage()
//													: "");
//									orderlistMap.put("commodityTitle", uo.getGoodstitle());
//									orderlistMap.put("commodityDesc", uo.getGoodsdesc());
//									orderlistMap.put("commodityPrice", uo.getGoodsprice() + "");
//									orderlistMap.put("commodityBuyNum", uo.getGoodsnum() + "");
//									orderlistMap.put("discountPrice", uo.getDiscountprice());
//									if (goods == null) {
//										orderlistMap.put("optimizationid", null);
//									} else {
//										orderlistMap.put("optimizationid", goods.getOptimizationid());
//									}
//
//									goodsList.add(orderlistMap);
//								}
//							}
//							map.put("orderCommodity", goodsList);
//							dataList.add(map);
//						}
//					}
//					res.setTotalPage(pageInfo.getTotalPage());
//				}
//
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：4692" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.441 我的订单 状态详情
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2(UserOrderListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		res.setTotalPage(1);
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
//			UserOrder userOrder = new UserOrder();
//			userOrder.setUid(req.getUid());
//			userOrder.setStatus(req.getStatus());
//			userOrder.setStatus(req.getCommunityid());
//			Page<UserOrder> page = new Page<UserOrder>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.updatetime desc");
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
//								GoodsCommunity goods = goodsCommunityService.gets(user.getCommunityid(),
//										uo.getGoodsid());
//								orderlistMap.put("commodityid", uo.getGoodsid());
//								orderlistMap.put("commodityPic",
//										StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage()
//												: "");
//								orderlistMap.put("commodityTitle", uo.getGoodstitle());
//								orderlistMap.put("commodityDesc", uo.getGoodsdesc());
//								orderlistMap.put("commodityPrice", uo.getGoodsprice() + "");
//								orderlistMap.put("commodityBuyNum", uo.getGoodsnum() + "");
//								if (goods == null) {
//									orderlistMap.put("optimizationid", null);
//								} else {
//									orderlistMap.put("optimizationid", goods.getOptimizationid());
//								}
//
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
//			logger.error("请求处理异常：4782" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.45 取消订单(1待付款)
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(CancelUserOrderReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("取消订单失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
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
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if (!req.getUid().equals(userOrder.getUid())) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if (!"1".equals(userOrder.getStatus())) {
//				res.setResultNote("该订单当前不可取消");
//				return res;
//			}
//			// 库存退回,销量减去
//			List<UserOrderlist> list1 = userOrder.getUserOrderlist();
//			if (list1 != null && list1.size() > 0) {
//				for (UserOrderlist od : list1) {
//					GoodsCommunity g = goodsCommunityService.getGoodsStock(userOrder.getCommunityid(), od.getGoodsid());
//					if (!"1".equals(g.getType())) {
//						g.setStock(g.getStock() + od.getGoodsnum());
//					}
//					g.setSallnum(g.getSallnum() - od.getGoodsnum());
//					goodsCommunityService.save(g);
//				}
//			}
//			userOrder.setStatus("12");
//			userOrder.setUpdatetime(new Date());
//			userOrderService.update(userOrder);
//			// userCouponService.executeUpdateSql("UPDATE t_user_coupon SET status = '0'
//			// WHERE couponid =( SELECT o.couponid from t_user_order o WHERE o.ordernum =
//			// '"+req.getOrderNum()+"')");
//			try {// 优惠券返还
//				if (!StringUtils.isBlank(userOrder.getCouponid())) {
//					String sql = "update t_user_coupon set status = 0 where couponid='"+userOrder.getCouponid()+"' AND uid='"+user.getId()+"'";
//					userOrderService.executeUpdateSql(sql);
//				}
//			} catch (Exception e) {
//				logger.error("请求处理异常：4849" );
//				e.printStackTrace();
//			}
//			res.setResult("0");
//			res.setResultNote("取消订单成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：4855" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.46确认收货
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(CancelUserOrderReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("确认收货失败");
//
//		try {
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			UserOrder userOrder = new UserOrder();
//			synchronized(this){
//				userOrder = userOrderService.gets(req.getOrderNum());
//				if(StringUtils.isBlank(req.getAtype())){
//					if (null == userOrder) {
//						res.setResultNote("订单不存在");
//						return res;
//					} else if (!"3".equals(userOrder.getStatus()) && !"7".equals(userOrder.getStatus())
//							&& !"8".equals(userOrder.getStatus()) && !"10".equals(userOrder.getStatus())
//							&& !"6".equals(userOrder.getStatus())) {
//						res.setResultNote("订单状态异常");
//						return res;
//					}else if("10".equals(userOrder.getStatus())){
//						res.setResultNote("订单已经确认收货");
//						return res;
//					}
//				}
//				/**
//				 * 更改订单金额为实时到账到余额2019-01-10
//				 */
//				userOrder.setStatus("10");
//				userOrder.setIsaccount("1");//变成已到账
//				userOrder.setEndtime(new Date());
//				userOrder.setUpdatetime(new Date());
//				userOrderService.update(userOrder);
//				// 给商户加余额
//				communityService.executeUpdateSql(" update t_community set balance=balance+" + userOrder.getPayprice()
//						+ " where id='" + userOrder.getCommunityid() + "'");
//				// 插入零钱明细
//				UserMoney sd = new UserMoney();
//				sd.setId(IdGen.uuid());
//				sd.setUid(userOrder.getCommunityid());
//				sd.setTitle("订单完成");
//				sd.setMoney("+" + userOrder.getPayprice());
//				sd.setTransactionId(userOrder.getOrdernum());
//				sd.setType("0");
//				sd.setHtype("1");
//				sd.setAdtime(new Date());
//				Community c = communityService.findUniqueByProperty("id", userOrder.getCommunityid());
//				sd.setSign(Base64Utils.byte2Base64(AESUtils.encryptAES((c.getBalance() + "").getBytes(), AESUtils.loadKeyAES(KeyUtil.AES_KEY), AESUtils.loadIvAES(KeyUtil.AES_KEY))));
//				sd.setBalance(c.getBalance() + "");
//				usermoneyService.addUserMoney(sd);
//			}
//			try {// 给商户推送订单完成
//				Community c = communityService.get(userOrder.getCommunityid());
//				/*
//				 * if (c.getToken() != null && !"".equals(c.getToken())) { title = "订单完成";
//				 * content = "您的商家订单已经完成,订单号为：" + userOrder.getOrdernum() + ",快去看看吧！";
//				 * PushResult result = new PushExample().registerTitle(title, content,
//				 * c.getToken()); System.out.println("p===" + result); }
//				 */
//				// List<Object> tokenList= communityService.executeDeleteSql("SELECT token from
//				// t_communnity_token where communityid = '"+userOrder.getCommunityid()+"'");
//
//				// 给商户加余额
////				communityService.executeUpdateSql(" update t_community set balance=balance+" + uo.getPayprice()
////						+ " where id='" + uo.getCommunityid() + "'");
//				String title = "订单信息";
//				String content = "您有订单已经完成,订单号为：" + userOrder.getOrdernum() + ",快去看看吧！";
//				Msg m = new Msg();
//				m.setId(IdGen.uuid());
//				m.setType("2");
//				m.setHtype("1");
//				m.setUid(c.getId());
//				m.setTitle(title);
//				m.setContent(content);
//				m.setUrl(userOrder.getOrdernum());
//				m.setStatus("");
//				m.setAdtime(new Date());
//				msgService.addMsg(m);
//			} catch (Exception e) {
//				logger.error("请求处理异常：4942" );
//				e.printStackTrace();
//			}
//			res.setResult("0");
//			res.setResultNote("确认收货成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：4948" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.48 请开始归还(6待归还)
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(UserRefundReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("开始归还失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			// 查询用户
//			Tuser tuser = tuserService.get(req.getUid());
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			// 查询订单
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if (!req.getUid().equals(userOrder.getUid())) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if (!"6".equals(userOrder.getStatus())) {
//				res.setResultNote("该订单当前不能归还");
//				return res;
//			}
//			userOrder.setStatus("7");
//			userOrder.setReturntime(new Date());
//			userOrder.setUpdatetime(new Date());
//			userOrderService.update(userOrder);
//			try {// 给商家发推送
//				Community c = communityService.get(userOrder.getCommunityid());
//				String title = "归还订单";
//				String content = "客户已经确认,赶快归还吧！订单号:" + userOrder.getOrdernum();
//
//				  if (c.getToken() != null && !"".equals(c.getToken())) {
//					 // PushResult result = new PushExample().registerTitle_shop(title, content, userOrder.getCommunityid(),userOrder.getOrdertype(), userOrder.getOrdernum(), null, null);
//				  }
//
//				  XiaoMiPush.sendMessage(title, content, userOrder.getCommunityid(),userOrder.getOrdertype(), userOrder.getOrdernum(), null, null);
//			/*	List<Object> tokens = communityService.executeSelectSql("SELECT token from"
//						+ " t_communnity_token WHERE communityid = '" + userOrder.getCommunityid() + "'");
//				if (tokens != null) {
//					String token[] = (String[])tokens.toArray(new String[0]);
//						PushResult result = new PushExample().registerTitle_shop(title, content, token,
//								userOrder.getOrdertype(), userOrder.getOrdernum(), null, null);
//				}*/
//			} catch (Exception e) {
//				logger.error("请求处理异常：5015" );
//				e.printStackTrace();
//			}
//			res.setResult("0");
//			res.setResultNote("开始归还成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：5021" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.49 评价订单
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(EvaluateOrder1Req req) {
//		ResJson res = new ResJson();
//		res.setResultNote("评价订单失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
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
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder || !req.getUid().equals(userOrder.getUid())) {
//				res.setResultNote("订单不存在");
//				return res;
//			}
//			if (!"10".equals(userOrder.getStatus())) {
//				res.setResultNote("该订单当前不可评价");
//				return res;
//			}
//			// 更改订单状态
//			userOrder.setStatus("11");
//			userOrder.setUpdatetime(new Date());
//			userOrderService.update(userOrder);
//			// 保存评论
//			Comment c = new Comment();
//			c.setUid(req.getUid());
//			c.setType("2");
//			c.setState("0");
//			c.setObjid(req.getOrderNum());
//			c.setStar(req.getStar());
//			c.setContent(req.getContent());
//			c.setZannum(0);
//			c.setCommentnum(0);
//			c.setAdtime(new Date());
//			commentService.save(c);
//			Msg m = new Msg();
//			m.setUid(userOrder.getCommunityid());
//			m.setType("2");
//			m.setHtype("2");
//			m.setTitle("评论消息");
//			m.setContent(req.getContent());
//			m.setStatus("");
//			m.setAdtime(new Date());
//			msgService.save(m);
//			res.setResult("0");
//			res.setResultNote("评价订单成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：5090" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.50 订单详情
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(UserOrderDetailReq req) {
//		UserOrderDetailRes res = new UserOrderDetailRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if(null==userOrder){
//				res.setResultNote("订单不存在，请联系管理员");
//				return res;
//			}
//			String hint = userOrderService.execSelectSqlString("SELECT hint FROM t_goods_activity WHERE type="
//					+ "(SELECT activityType FROM t_user_order WHERE ordernum='"+req.getOrderNum()+"')");
//			res.setUsername(userOrder.getUsername());
//			res.setUserPhone(userOrder.getUserphone());
//			res.setOrderActivityType(userOrder.getActivityType());
//			if("3".equals(userOrder.getActivityType())) {
//				res.setHint("扫码购买的商品暂不支持配送服务，请进店使用此功能");
//			}else {
//				res.setHint(hint);
//			}
//			res.setCity(userOrder.getUsercity());
//			List<Object> communityName = addressService.executeSelectSql(
//					"SELECT name1 FROM t_community WHERE id=(SELECT communityid FROM t_user WHERE id='" + req.getUid()
//							+ "')");
//			if (null != communityName && communityName.size() > 0 && null != communityName.get(0)) {
//				res.setCommunityName(communityName.get(0).toString());
//			}
//			res.setAddress(userOrder.getUseraddress());
//			res.setOrderType(userOrder.getOrdertype());
//			res.setOderAllPrice(userOrder.getAllprice() + "");
//			res.setOderPayPrice(userOrder.getPayprice() + "");
//			res.setDiscountPrice(null==userOrder.getDiscountprice()?"":String.valueOf(userOrder.getDiscountprice()));
//			res.setOrderState(userOrder.getStatus());
//			res.setPayType(userOrder.getPaytype());
//			res.setMessage(userOrder.getMessage());
//			res.setShopmessage(userOrder.getShopmessage());
//			res.setSecuritiesPrice(userOrder.getCouponmoney());
//			res.setOrderNum(userOrder.getOrdernum());
//			res.setReason(userOrder.getReason());
//			res.setAdtime(null != userOrder.getAdtime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getAdtime())
//					: "");
//			res.setPayTime(null != userOrder.getPaytime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getPaytime())
//					: "");
//			res.setSendTime(null != userOrder.getSendtime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getSendtime())
//					: "");
//			res.setGetTime(null != userOrder.getGettime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getGettime())
//					: "");
//			res.setCleanTime(null != userOrder.getCleantime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getCleantime())
//					: "");
//			res.setReturnTime(null != userOrder.getReturntime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getReturntime())
//					: "");
//			res.setEndTime(null != userOrder.getEndtime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getEndtime())
//					: "");
//			res.setRefundTime(null != userOrder.getRefundtime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getRefundtime())
//					: "");
//			res.setRefundShenTime(null != userOrder.getRefundshentime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getRefundshentime())
//					: "");
//			List<String> l = new ArrayList<>();
//			if (userOrder.getImg1() != null && userOrder.getImg1().length() > 0) {
//				l.add(StringUtils.isNotBlank(userOrder.getImg1()) && userOrder.getImg1().indexOf("http://") == -1
//						&& userOrder.getImg1().indexOf("https://") == -1 ? filePath + userOrder.getImg1()
//								: userOrder.getImg1());
//			}
//			if (userOrder.getImg2() != null && userOrder.getImg2().length() > 0) {
//				l.add(StringUtils.isNotBlank(userOrder.getImg2()) && userOrder.getImg2().indexOf("http://") == -1
//						&& userOrder.getImg2().indexOf("https://") == -1 ? filePath + userOrder.getImg2()
//								: userOrder.getImg2());
//			}
//			if (userOrder.getImg3() != null && userOrder.getImg3().length() > 0) {
//				l.add(StringUtils.isNotBlank(userOrder.getImg3()) && userOrder.getImg3().indexOf("http://") == -1
//						&& userOrder.getImg3().indexOf("https://") == -1 ? filePath + userOrder.getImg3()
//								: userOrder.getImg3());
//			}
//			res.setRefundPics(l);
//
//			List<Map<String, String>> commoditys = new ArrayList<Map<String, String>>();
//			UserOrderlist userOrderlist = new UserOrderlist();
//			userOrderlist.setOrdernum(userOrder.getOrdernum());
//			List<UserOrderlist> list = userOrderlistService.findList(userOrderlist);
//			if (null != list && list.size() > 0) {
//				for (UserOrderlist uo : list) {
//					Map<String, String> map = new HashMap<String, String>();
//
//					GoodsCommunity goods =null;
//					if(StringUtils.isBlank(uo.getActivityid())){
//						goods = goodsCommunityService.gets(userOrder.getCommunityid(), uo.getGoodsid());
//					}else{
//						goods = goodsCommunityService.getsTwo(userOrder.getCommunityid(), uo.getGoodsid(),uo.getActivityid());
//						map.put("typeName", goods.getTypeName());
//						map.put("activityprice",goods.getActivityprice()+"");
//						map.put("activityid", goods.getActivityid());
//					}
//
//					map.put("commodityid", uo.getGoodsid());
//					map.put("commodityPic",
//							StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage() : "");
//					map.put("commodityTitle", uo.getGoodstitle());
//					map.put("commodityDesc", uo.getGoodsdesc());
//					map.put("commodityPrice", uo.getGoodsprice() + "");
//					map.put("commodityBuyNum", uo.getGoodsnum() + "");
//					map.put("optimizationid", goods.getOptimizationid());
//					map.put("discountPrice", uo.getDiscountprice());
//					map.put("commoditySpecification",StringUtils.isBlank(uo.getGoodsSpecification())?"":uo.getGoodsSpecification());
//					commoditys.add(map);
//				}
//			}
//			res.setOrderCommodity(commoditys);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：5212" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.501 订单今日订单量详情 1.03版本
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecTreeVersion(UserOrderDetailReq req) {
//		UserOrderDetailRes res = new UserOrderDetailRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("查询时间不能为空");
//				return res;
//			}
//
//			List<UserOrderlist> userOrders = userOrderlistService.selectOrderList(req.getOrderNum());
//			List<Map<String, String>> userOderList = new ArrayList<Map<String, String>>();
//			if (userOrders != null && userOrders.size() > 0) {
//				for (UserOrderlist userOrder : userOrders) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("ordernum", userOrder.getOrdernum());
//					map.put("goodsid", userOrder.getGoodsid());
//					map.put("goodstitle", userOrder.getGoodstitle());
//					map.put("goodsimage", userOrder.getGoodsimage());
//					map.put("goodsnum", userOrder.getGoodsnum() + "");
//					map.put("goodsprice", userOrder.getGoodsprice() + "");
//					map.put("adtime",
//							null != userOrder.getAdtime()
//									? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getAdtime())
//									: "");
//
//					userOderList.add(map);
//				}
//			}
//
//			res.setOrderCommodity(userOderList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：5257" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 订单是否已打印
//	 *
//	 * @param req
//	 * @return
//	 */
//	public synchronized ResJson codecOrderPush(UserOrderDetailReq req) {
//
//		UserOrderDetailRes res = new UserOrderDetailRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null != userOrder.getPrint() && !"".equals(userOrder.getPrint()) && "1".equals(userOrder.getPrint())) {
//				res.setResultNote("订单号已打印");
//				return res;
//			}
//			res.setUsername(userOrder.getUsername());
//			res.setUserPhone(userOrder.getUserphone());
//			res.setCity(userOrder.getUsercity());
//			List<Object> communityName = addressService.executeSelectSql(
//					"SELECT name1 FROM t_community WHERE id=(SELECT communityid FROM t_user WHERE id='" + req.getUid()
//							+ "')");
//			if (null != communityName && communityName.size() > 0 && null != communityName.get(0)) {
//				res.setCommunityName(communityName.get(0).toString());
//			}
//			res.setAddress(userOrder.getUseraddress());
//			res.setOrderType(userOrder.getOrdertype());
//			res.setOderAllPrice(userOrder.getAllprice() + "");
//			res.setOderPayPrice(userOrder.getPayprice() + "");
//			res.setOrderState(userOrder.getStatus());
//			res.setPayType(userOrder.getPaytype());
//			res.setMessage(userOrder.getMessage());
//			res.setShopmessage(userOrder.getShopmessage());
//			res.setSecuritiesPrice(userOrder.getCouponmoney());
//			res.setOrderNum(userOrder.getOrdernum());
//			res.setReason(userOrder.getReason());
//			res.setAdtime(null != userOrder.getAdtime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getAdtime())
//					: "");
//			res.setPayTime(null != userOrder.getPaytime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getPaytime())
//					: "");
//			res.setSendTime(null != userOrder.getSendtime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getSendtime())
//					: "");
//			res.setGetTime(null != userOrder.getGettime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getGettime())
//					: "");
//			res.setCleanTime(null != userOrder.getCleantime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getCleantime())
//					: "");
//			res.setReturnTime(null != userOrder.getReturntime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getReturntime())
//					: "");
//			res.setEndTime(null != userOrder.getEndtime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getEndtime())
//					: "");
//			res.setRefundTime(null != userOrder.getRefundtime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getRefundtime())
//					: "");
//			res.setRefundShenTime(null != userOrder.getRefundshentime()
//					? DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(userOrder.getRefundshentime())
//					: "");
//			List<String> l = new ArrayList<>();
//			if (userOrder.getImg1() != null && userOrder.getImg1().length() > 0) {
//				l.add(StringUtils.isNotBlank(userOrder.getImg1()) && userOrder.getImg1().indexOf("http://") == -1
//						&& userOrder.getImg1().indexOf("https://") == -1 ? filePath + userOrder.getImg1()
//								: userOrder.getImg1());
//			}
//			if (userOrder.getImg2() != null && userOrder.getImg2().length() > 0) {
//				l.add(StringUtils.isNotBlank(userOrder.getImg2()) && userOrder.getImg2().indexOf("http://") == -1
//						&& userOrder.getImg2().indexOf("https://") == -1 ? filePath + userOrder.getImg2()
//								: userOrder.getImg2());
//			}
//			if (userOrder.getImg3() != null && userOrder.getImg3().length() > 0) {
//				l.add(StringUtils.isNotBlank(userOrder.getImg3()) && userOrder.getImg3().indexOf("http://") == -1
//						&& userOrder.getImg3().indexOf("https://") == -1 ? filePath + userOrder.getImg3()
//								: userOrder.getImg3());
//			}
//			res.setRefundPics(l);
//
//			List<Map<String, String>> commoditys = new ArrayList<Map<String, String>>();
//			UserOrderlist userOrderlist = new UserOrderlist();
//			userOrderlist.setOrdernum(userOrder.getOrdernum());
//			List<UserOrderlist> list = userOrderlistService.findList(userOrderlist);
//			if (null != list && list.size() > 0) {
//				for (UserOrderlist uo : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					GoodsCommunity goods = goodsCommunityService.gets(userOrder.getCommunityid(), uo.getGoodsid());
//					map.put("commodityid", uo.getGoodsid());
//					map.put("commodityPic",
//							StringUtils.isNotBlank(uo.getGoodsimage()) ? filePath + uo.getGoodsimage() : "");
//					map.put("commodityTitle", uo.getGoodstitle());
//					map.put("commodityDesc", uo.getGoodsdesc());
//					map.put("commodityPrice", uo.getGoodsprice() + "");
//					map.put("commodityBuyNum", uo.getGoodsnum() + "");
//					map.put("optimizationid", goods.getOptimizationid());
//					commoditys.add(map);
//				}
//			}
//			res.setOrderCommodity(commoditys);
//			userOrderService.executeUpdateSql(
//					"UPDATE t_user_order SET print = '1' WHERE ordernum = '" + req.getOrderNum() + "'");
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：5377" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.51 我的屏蔽
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec15(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
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
//			Page<UserAttention> page = new Page<UserAttention>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			UserAttention u = new UserAttention();
//			u.setDataScope(" and a.type=1");
//			u.setUid(req.getUid());
//			Page<UserAttention> pageInfo = userAttentionService.findPage(page, u);
//			List<UserAttention> list = pageInfo.getList();
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				for (UserAttention cc : list) {
//					Map<String, Object> map1 = new HashMap<String, Object>();
//					map1.put("userId", cc.getAuid());
//					try {
//						UserRemarks ur = userRemarksService.gets(req.getUid(), cc.getAuid());
//						if (ur != null && ur.getRemarks() != null) {
//							map1.put("userName", ur.getRemarks());
//						} else {
//							map1.put("userName", cc.getUsername());
//						}
//					} catch (Exception e) {
//						logger.error("请求处理异常：5426" );
//						e.printStackTrace();
//					}
//					map1.put("userIcon",
//							StringUtils.isNotBlank(cc.getUsericon()) && cc.getUsericon().indexOf("http://") == -1
//									&& cc.getUsericon().indexOf("https://") == -1 ? filePath + cc.getUsericon()
//											: cc.getUsericon());
//					map1.put("userSex", cc.getUsersex());
//					map1.put("userAge", StringUtils.isBlank(cc.getBirthday()) ? ""
//							: Year.getAge(DateTimeUtil.parse(cc.getBirthday())) + "");
//					map1.put("userAutograph", cc.getUserautograph());
//					dataList.add(map1);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：5445" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.52 添加/解除屏蔽
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec16(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("屏蔽失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getAuid())) {
//				res.setResultNote("对方ID不能为空");
//				return res;
//			}
//			if (req.getUid().equals(req.getAuid())) {
//				res.setResultNote("不能屏蔽自己");
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
//			UserAttention ua = userAttentionService.isattention(req.getUid(), "1", req.getAuid());
//			if ("0".equals(ua.getIsattention())) {// 没屏蔽
//				UserAttention ua1 = new UserAttention();
//				ua1.setUid(req.getUid());
//				ua1.setAuid(req.getAuid());
//				ua1.setType(1);
//				ua1.setAdtime(new Date());
//				ua1.setState(0);
//				userAttentionService.save(ua1);
//				// Wangyiyunxin.addblack(req.getUid(), req.getAuid(), "1");
////				if ("0".equals(req.getState())) {
////					Wangyiyunxin.addblack(req.getUid(), req.getAuid(), "1");
////				} else
//				if ("1".equals(req.getState())) {
//					dynamicService.executeUpdateSql(
//							"UPDATE t_dynamic d SET d.state = 1 WHERE d.uid ='" + req.getAuid() + "'");
//				} else if ("".equals(req.getState()) && req.getState() == null) {
//					res.setResultNote("状态为空");
//					return res;
//				}
//
//				// 解除双方好友关系
////				UserAttention uat=userAttentionService.isattention(req.getUid(),"0",req.getAuid());
////				if("1".equals(uat.getIsattention())){//关注了
////					userAttentionService.deleteatten(req.getUid(),"0",req.getAuid());
////				}
////				UserAttention uatt=userAttentionService.isattention(req.getAuid(),"0",req.getUid());
////				if("1".equals(uatt.getIsattention())){//关注了
////					userAttentionService.deleteatten(req.getAuid(),"0",req.getUid());
////				}
//				res.setResultNote("屏蔽成功");
//			} else {// 已屏蔽，取消屏蔽
//				userAttentionService.deleteatten(req.getUid(), "1", req.getAuid());
////				Wangyiyunxin.addblack(req.getUid(), req.getAuid(), "0");
//				dynamicService
//						.executeUpdateSql("UPDATE t_dynamic d SET d.state = 0 WHERE d.uid ='" + req.getAuid() + "'");
//				res.setResultNote("取消屏蔽成功");
//			}
//			res.setResult("0");
//		} catch (Exception e) {
//			logger.error("请求处理异常：5519" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.53 版本更新
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2(GetHelpReq req, HttpServletRequest request) {
//		GetversionRes res = new GetversionRes();
//		res.setResultNote("获取版本更新失败");
//		if (StringUtils.isBlank(req.getVersion())) {
//			res.setResultNote("版本号为空");
//		}
//		String userAgent = request.getHeader("user-agent").toString();
//		try {
//			if (userAgent.contains("iOS")) {
//				List<Object> object = versionService.executeSelectSql("SELECT type FROM t_version WHERE id = 3");
//				res.setType(object.get(0).toString());
//				res.setResult("0");
//				res.setResultNote("获取成功");
//			} else {
//				List<Version> versions = versionService.selectVersionList(req.getVersion());
//				res.setVersionNumber("0");
//				if (versions != null && versions.size() > 0) {
//					for (Version version : versions) {
//						res.setVersionNumber(version.getVersion() + "");
//						res.setVersionName(version.getVersionnum());
//						res.setUpdataAddress(filePath + version.getUrl());
//						res.setType(version.getType());
//						res.setCount("若更新失败，请到应用市场更新");
//						res.setResult("0");
//						res.setResultNote("获取成功");
//					}
//				} else {
//					res.setResultNote("版本已是最高");
//				}
//
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：5563" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.54余额支付
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(PayByBalanceReq req, HttpServletRequest request) {
//		ResJson res = new ResJson();
//		res.setResultNote("支付失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			if (null == req.getAmount()) {
//				res.setResultNote("金额不能为空");
//				return res;
//			}
//			//版本
//	/*		String agent = request.getHeader("user-agent");
//			String version = "1.0.0";
//			if(agent.contains("Android")){
//				version = agent.substring(agent.indexOf(":")+1, agent.indexOf("/"));
//			}else if(agent.contains("iOS")){
//				version = agent.substring(agent.indexOf("/")+1, agent.indexOf(" "));
//			}
//			if((agent.contains("Android")&&com.jeeplus.common.utils.StringUtils.compareVersion(version,"1.4.2")>=0)
//					||(agent.contains("iOS")&&com.jeeplus.common.utils.StringUtils.compareVersion(version,"1.4.3")>=0)){//模糊搜索返回商品列表
//
//			}else{
//				res.setResultNote("请您升级最新版本再进行余额支付");
//				return res;
//			}*/
//
//			Tuser tuser = tuserService.get(req.getUid());
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			} else if (null == tuser.getBalance()) {
//				res.setResult("3");//余额不足
//				res.setResultNote("余额不足，请选择其他支付方式");
//				return res;
//			}else if(null!= tuser.getBalance() && tuser.getBalance()<req.getAmount()) {
//				res.setResult("3");//余额不足
//				res.setResultNote("余额不足，请选择其他支付方式");
//				return res;
//			}
//			OrderType ot = orderTypeMapper.gets(req.getOrderNum());
//			if (ot == null) {
//				res.setResultNote("该订单不存在");
//				return res;
//			}
//			if ("1".equals(ot.getState())) {
//				res.setResultNote("该订单已被处理");
//				return res;
//			}
//			if ("2".equals(ot.getState())) {
//				res.setResultNote("该订单已经在支付中");
//				return res;
//			}
//			if ("0".equals(ot.getType())) {// 充值
//				res.setResultNote("充值不能用余额支付");
//				return res;
//			} else if ("1".equals(ot.getType())) {// 商品订单
//				if(!csc.validateBalance(tuser,"0")){
//					res.setResultNote("个人信息有异常，请联系管理员");
//					return res;
//				}
//
//				// 更改订单状态
//				UserOrder uo = userOrderService.gets(req.getOrderNum());
//				double payprice = 0;
//				if(null!=uo.getDiscountprice()&&uo.getDiscountprice()>0&&uo.getDiscountprice()<uo.getPayprice()){
//					payprice = uo.getDiscountprice();
//					tuser.setBalance(uo.getDiscountprice());
//				}else{
//					payprice = uo.getPayprice();
//					tuser.setBalance(uo.getPayprice());
//				}
//				int i = tuserService.deductBalance(tuser);
//				if(i==0){
//					ot.setState("0");
//					orderTypeMapper.update(ot);
//					res.setResult("3");//余额不足
//					res.setResultNote("余额不足，请选择其他支付方式");
//					return res;
//				}
//				ot.setState("1");
//				orderTypeMapper.update(ot);
//				if (payprice > 0) {
////					BigDecimal bd = new BigDecimal(req.getAmount());
////					Double getMoney = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//					tuser = tuserService.get(req.getUid());
//					BigDecimal bd = new BigDecimal(tuser.getBalance());
//					Double getBalance = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//					// 插入零钱明细
//					UserMoney sd = new UserMoney();
//					sd.setId(IdGen.uuid());
//					sd.setUid(ot.getUid());
//					sd.setTitle("购买商品");
//					sd.setMoney("-" + payprice);
//					sd.setBalance(getBalance + "");
//					sd.setTransactionId(uo.getOrdernum());
//					sd.setHtype("0");
//					sd.setType("0");
//					sd.setAdtime(new Date());
//					try {
//						sd.setSign(Base64Utils.byte2Base64(AESUtils.encryptAES(
//															String.valueOf(tuser.getBalance()).getBytes(),
//															AESUtils.loadKeyAES(KeyUtil.AES_KEY),
//															AESUtils.loadIvAES(KeyUtil.AES_KEY))));
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					usermoneyService.addUserMoney(sd);
//				}
//				if("2".equals(uo.getActivityType())) {
//					   uo.setStatus("3");
//				}else {
//					if ("1".equals(uo.getOrdertype())) {
//						uo.setStatus("4");
//					} else {
//						uo.setStatus("2");
//					}
//				}
//				uo.setPaytime(new Date());
//				uo.setUpdatetime(new Date());
//				uo.setPaytype("0");
//				uo.setPayprice(payprice);//逗邻币支付需要更新支付价格
//				userOrderService.update(uo);
//				userOrderlistService.updateDiscountPriceByOrderNum(uo.getOrdernum());//订单明细也要更新
//
//				try {// 给商家发推送
//
//					Community c = communityService.get(uo.getCommunityid());
//					String title = "来新订单啦！";
//					String content = "您有一个新订单：" + uo.getOrdernum() + "！";
//
//					  if (c.getToken() != null && !"".equals(c.getToken())) {
//						 // PushResult result = new PushExample().registerTitle_shop(title, content, uo.getCommunityid(),uo.getOrdertype(), uo.getOrdernum(), null, "2");
//					  }
//					  XiaoMiPush.sendMessage(title, content, uo.getCommunityid(),uo.getOrdertype(), uo.getOrdernum(), null, "2");
//				/*	List<Object> tokens = communityService.executeSelectSql(
//							"SELECT token from t_communnity_token WHERE communityid = '" + uo.getCommunityid() + "'");
//					// System.out.println(tokens.size());
//					if (tokens != null) {
//						String token[] = (String[])tokens.toArray(new String[0]);
//						PushResult result = new PushExample().registerTitle_shop(title, content, token,
//									uo.getOrdertype(), uo.getOrdernum(), null, "2");
//					}*/
//
//				} catch (Exception e) {
//					logger.error("请求处理异常：5672" );
//					e.printStackTrace();
//				}
//				res.setResult("0");
//				res.setResultNote("支付成功");
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：5679" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.55 我的银行卡
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(UserAddressListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//
//			UserCard userCard = new UserCard();
//			userCard.setUid(req.getUid());
//			userCard.setType(req.getType());
//			List<UserCard> list = userCardService.findList(userCard);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (null != list && list.size() > 0) {
//				for (UserCard a : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("cardId", a.getId());
//					map.put("cardName", a.getCardname());
//					map.put("cardNum", a.getCardnum());
//					map.put("cardUsername", a.getCardusername());
//					dataList.add(map);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：5719" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.56 添加银行卡
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(AddUserAddressReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("添加失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCardNum())) {
//				res.setResultNote("银行卡账号不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCardName())) {
//				res.setResultNote("开户银行不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCardUsername())) {
//				res.setResultNote("开户人名称不能为空");
//				return res;
//			}
//			UserCard userCard = new UserCard();
//			userCard.setUid(req.getUid());
//			userCard.setType(Integer.valueOf(req.getType()));
//			userCard.setCardname(req.getCardName());
//			userCard.setCardnum(req.getCardNum());
//			;
//			userCard.setCardusername(req.getCardUsername());
//			userCard.setAdtime(new Date());
//			userCardService.save(userCard);
//			res.setResult("0");
//			res.setResultNote("添加成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：5763" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.57 编辑银行卡
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(EditUserAddressReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("编辑失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCardId())) {
//				res.setResultNote("银行卡ID不能为空");
//				return res;
//			}
//			UserCard userCard = userCardService.get(req.getCardId());
//			if (null == userCard) {
//				res.setResultNote("该银行卡不存在");
//			} else if (!req.getUid().equals(userCard.getUid())) {
//				res.setResultNote("该银行卡不存在");
//			} else {
//				if (!StringUtils.isBlank(req.getCardName())) {
//					userCard.setCardname(req.getCardName());
//				}
//				if (!StringUtils.isBlank(req.getCardNum())) {
//					userCard.setCardnum(req.getCardNum());
//				}
//				if (!StringUtils.isBlank(req.getCardUsername())) {
//					userCard.setCardusername(req.getCardUsername());
//				}
//				userCardService.save(userCard);
//				res.setResult("0");
//				res.setResultNote("编辑成功");
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：5807" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.58 删除银行卡
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(DelUserAddressReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("删除失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCardId())) {
//				res.setResultNote("银行卡ID不能为空");
//				return res;
//			}
//
//			UserCard userCard = userCardService.get(req.getCardId());
//			if (null == userCard) {
//				res.setResultNote("该银行卡不存在");
//			} else {
//				if (!req.getUid().equals(userCard.getUid())) {
//					res.setResultNote("该银行卡不存在");
//				} else {
//					userCardService.delete(userCard);
//					res.setResult("0");
//					res.setResultNote("删除成功");
//				}
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：5845" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.59 举报用户
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec6(GetHelpReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("举报用户失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getAuid())) {
//				res.setResultNote("请选择要举报的用户");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getContent())) {
//				res.setResultNote("举报内容不能为空");
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
//			Report f = new Report();
//
//			f.setUid(req.getUid());
//			f.setAuid(req.getAuid());
//			f.setTitle(req.getTitle());
//			f.setContent(req.getContent());
//			f.setState(0);
//			f.setAdtime(new Date());
//			reportService.save1(f);
//			res.setResult("0");
//			res.setResultNote("举报用户成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：5893" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.60 确认取货(4待取货)
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(UserRefundReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("确认取货失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			// 查询用户
//			Tuser tuser = tuserService.get(req.getUid());
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			// 查询订单
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if (!req.getUid().equals(userOrder.getUid())) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if (!"4".equals(userOrder.getStatus())) {
//				res.setResultNote("该订单当前不能确认取货");
//				return res;
//			}
//			userOrder.setStatus("5");
//			userOrder.setGettime(new Date());
//			userOrder.setUpdatetime(new Date());
//			userOrderService.update(userOrder);
//			res.setResult("0");
//			res.setResultNote("确认取货成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：5945" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.61 我的互动
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2(SecuritiesListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取我的互动失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			Tuser user = tuserService.get(req.getAuid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			} else {
//				Page<Collect> page = new Page<Collect>(req.getNowPage(), req.getPageCount());
//				page.setOrderBy("a.adtime desc");
//				Collect uc = new Collect();
//				uc.setUid(req.getAuid());
//				Page<Collect> pageInfo = collectService.findPage1(page, uc);
//				List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//				if (null != pageInfo) {
//					List<Collect> list = pageInfo.getList();
//					if (null != list && list.size() > 0) {
//						for (Collect a : list) {
//							Map<String, Object> map = new HashMap<String, Object>();
//							if ("0".equals(a.getType())) {// 动态
//								Dynamic d = dynamicService.get(a.getObjectid());
//								if(null == d){
//									continue;
//								}
//								Tuser u = tuserService.get(d.getUid());
//								map.put("bangbangId", a.getObjectid());
//								map.put("bangbangContent", d.getContent());
//								map.put("bangbangImageUrl",
//										!StringUtils.isBlank(d.getImage()) ? filePath + d.getImage() : "");
//								map.put("bangbangVideoUrl",
//										!StringUtils.isBlank(d.getVideourl()) ? filePath + d.getVideourl() : "");
//								map.put("zanNum", d.getZannum());
//								map.put("commentNum", d.getCommentnum());
//								map.put("userId", u.getId());
//								try {
//									UserRemarks ur = userRemarksService.gets(req.getUid(), u.getId());
//									if (ur != null && ur.getRemarks() != null) {
//										map.put("userName", ur.getRemarks());
//									} else {
//										map.put("userName", u.getNickname());
//									}
//								} catch (Exception e) {
//									logger.error("请求处理异常：6004" );
//									e.printStackTrace();
//								}
//								map.put("userIcon",
//										StringUtils.isNotBlank(u.getIcon()) && u.getIcon().indexOf("http://") == -1
//												&& u.getIcon().indexOf("https://") == -1 ? filePath + u.getIcon()
//														: u.getIcon());
//								map.put("userEffectNum", u.getEffectnum());
//								map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(d.getAdtime()));
//								if (d.getHtype() == 0) {// 图片动态
//									CommentImage commentImage = new CommentImage();
//									commentImage.setType("1");
//									commentImage.setCommentid(a.getObjectid());
//									List<CommentImage> imageList = commentImageService.findList(commentImage);
//									List<String> list1 = new ArrayList<String>();
//									if (imageList != null && imageList.size() > 0) {
//										for (CommentImage c : imageList) {
//											list1.add(filePath + c.getImage());
//										}
//									}
//									map.put("bangbangImgUrl", list1);
//								}
//
//							} else {// 活动
//								Activity act = activityService.get(a.getObjectid());
//								Tuser u = tuserService.get(act.getUid());
//								CommentImage commentImage = new CommentImage();
//								commentImage.setType("2");
//								commentImage.setCommentid(a.getObjectid());
//								List<CommentImage> imageList = commentImageService.findList(commentImage);
//								map.put("activityId", a.getObjectid());
//								map.put("activityName", act.getName());
//								map.put("activityImg", (imageList != null && imageList.size() > 0)
//												? filePath + imageList.get(0).getImage() : "");
//								map.put("activityAddress", act.getAddress());
//								map.put("activityTime", null==act.getStarttime()?"":DateFormatUtil.ISO_ON_DATE_FORMAT.format(act.getStarttime()));
//								map.put("activityAllnum", act.getAllnum());
//								map.put("activityNownum", act.getNownum());
//								map.put("activityMoney", act.getMoney());
//								map.put("zanNum", act.getZannum());
//								map.put("commentNum", act.getCommentnum());
//								map.put("userId", u.getId());
//								try {
//									UserRemarks ur = userRemarksService.gets(req.getUid(), u.getId());
//									if (ur != null && ur.getRemarks() != null) {
//										map.put("userName", ur.getRemarks());
//									} else {
//										map.put("userName", u.getNickname());
//									}
//								} catch (Exception e) {
//									logger.error("请求处理异常：6056" );
//									e.printStackTrace();
//								}
//								map.put("userIcon",
//										StringUtils.isNotBlank(u.getIcon()) && u.getIcon().indexOf("http://") == -1
//												&& u.getIcon().indexOf("https://") == -1 ? filePath + u.getIcon()
//														: u.getIcon());
//								map.put("userEffectNum", u.getEffectnum());
//								map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(act.getAdtime()));
//								ActivityMember am = activityMemberService.isActivityMember(req.getUid(), a.getId());
//								map.put("issignup", am.getIssignup());
//							}
//
//							map.put("type", a.getType());
//							dataList.add(map);
//						}
//					}
//					res.setTotalPage(pageInfo.getTotalPage());
//				}
//				res.setDataList(dataList);
//				res.setResult("0");
//				res.setResultNote("获取我的互动成功");
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：6080" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.62 删除互动
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec3(SecuritiesListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("删除互动失败");
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
//			if ("0".equals(req.getType())||"1".equals(req.getType())) {// 帮帮,动态
//				Dynamic d = dynamicService.get(req.getObjid());
//				if (d != null && d.getId().length() > 0) {
//					dynamicService.deleteByLogic(d);
//				}
//			} else if ("3".equals(req.getType())||"5".equals(req.getType())) {// 活动、闲置
//				Activity act = activityService.get(req.getObjid());
//				if (act != null && act.getId().length() > 0) {
//					activityService.deleteByLogic(act);
//				}
//			} else if ("6".equals(req.getType())) {// 达人经历
//				CommunityManExperience act = communityManExperienceService.get(req.getObjid());
//				if (act != null && act.getId().length() > 0) {
//					communityManExperienceService.deleteByLogic(act);
//				}
//			} else {// 动态
//				Dynamic d = dynamicService.get(req.getObjid());
//				if (d != null && d.getId().length() > 0) {
//					dynamicService.deleteByLogic(d);
//				}
//			}
//			if(user.getDynamicnum()>0)
//				user.setDynamicnum(user.getDynamicnum()-1);
//			tuserService.updateUser(user);
//			res.setResult("0");
//			res.setResultNote("删除互动成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：6127" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.63 动态隐藏
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec4(SecuritiesListReq req) {
//		ResJson res = new ResJson();
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getDynamicId())) {
//				res.setResultNote("动态ID不能为空");
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
//			Dynamic d = dynamicService.get(req.getDynamicId());
//			if (d != null && d.getId().length() > 0) {
//				if (d.getState() == 0) {
//					d.setState(1);
//				} else {
//					d.setState(0);
//				}
//				dynamicService.save(d);
//			}
//			res.setResult("0");
//			res.setResultNote("保存成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：6170" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.64 获取银行
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec5(SecuritiesListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取银行失败");
//		try {
//			Bank b = new Bank();
//			List<Bank> list = bankService.findList(b);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (null != list && list.size() > 0) {
//				for (Bank a : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("bankId", a.getId());
//					map.put("bankName", a.getName());
//					dataList.add(map);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取银行成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：6201" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.65 再来一单
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2(UserRefundReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("再来一单失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			List<String> isYes = communityService.selectid();
//			if ("1".equals(isYes.get(0).toString())) {
//				res.setResultNote("已到休息时间");
//				return res;
//			}
//			// 查询用户
//			Tuser tuser = tuserService.get(req.getUid());
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			// 查询订单
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if (!req.getUid().equals(userOrder.getUid())) {
//				res.setResultNote("订单不存在");
//				return res;
//			}
//			String msg = "";
//			List<String> goodsids = Lists.newArrayList();
//			List<UserOrderlist> list = userOrder.getUserOrderlist();
//			for (UserOrderlist userOrderlist : list) {
//				UserCart userCart = new UserCart();
//				Map<String,String> map=null;
//				if(StringUtils.isBlank(userOrderlist.getActivityid())){
//					map = goodsCommunityService.judgeGoodsSellFlag(tuser.getCommunityid(), userOrderlist.getGoodsid());
//				}else{
//					map = goodsCommunityService.judgeGoodsSellFlagActivity(userOrderlist.getActivityid(),  userOrderlist.getGoodsid());
//				}
//				if(!"0".equals(String.valueOf(map.get("flag")))){//如果商品还可以购买
//					if ("0".equals(userOrder.getOrdertype())) {
//						userCart.setType("2");
//					} else if ("2".equals(userOrder.getOrdertype())) {
//						userCart.setType("0");
//					} else {
//						userCart.setType("1");
//					}
//					userCart.setUid(req.getUid());
//					userCart.setGoodsid(userOrderlist.getGoodsid());
//					userCart.setCommunityId(tuser.getCommunityid());
//					// 查询该商品是否已存在购物车内
//					List<UserCart> cartList = userCartService.findList(userCart);
//					if (null != cartList && cartList.size() > 0) {// 存在就进行数量相加
//						UserCart cart = cartList.get(0);
//						if(!"1".equals(cart.getType())&&(cart.getCount() + userOrderlist.getGoodsnum())>Integer.valueOf(String.valueOf(map.get("stock"))).intValue()){//如果剩余库存小于原订单数量
//							cart.setCount(Integer.valueOf(String.valueOf(map.get("stock"))));
//						}else
//							cart.setCount(cart.getCount() + userOrderlist.getGoodsnum());
//						userCartService.update(cart);
//					} else {// 不存在，进行添加操作
//						UserCart cart = new UserCart();
//						cart.setId(IdGen.uuid());
//						cart.setType(userCart.getType());
//						cart.setUid(req.getUid());
//						cart.setGoodsid(userOrderlist.getGoodsid());
//						if(!"1".equals(cart.getType())&&userOrderlist.getGoodsnum()>Integer.valueOf(String.valueOf(map.get("stock"))).intValue()){//如果剩余库存小于原订单数量
//							cart.setCount(Integer.valueOf(String.valueOf(map.get("stock"))));
//						}else
//							cart.setCount(userOrderlist.getGoodsnum());
//						cart.setAdtime(new Date());
//						userCartService.addUserCart(cart);
//					}
//					goodsids.add(userOrderlist.getGoodsid());
//				}else{
//					userCartService.executeDeleteSql("DELETE FROM t_user_cart WHERE uid='"+req.getUid()+"' and goodsid = '"+userOrderlist.getGoodsid()+"'");
//					msg ="但是存在部分商品已下架无法购买";
//				}
//			}
//			res.setResult("0");
//			res.setResultNote("再来一单成功!"+msg);
//			res.setData(goodsids);
//		} catch (Exception e) {
//			logger.error("请求处理异常：6296" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.66 影响力明细
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec3(UserRefundReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取影响力明细失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			// 查询用户
//			Tuser tuser = tuserService.get(req.getUid());
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			ScoreDetail sd = new ScoreDetail();
//			sd.setUid(req.getUid());
//			Page<ScoreDetail> page = new Page<ScoreDetail>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy(" a.adtime desc");
//			Page<ScoreDetail> pageInfo = scoreDetailService.findPage(page, sd);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (null != pageInfo) {
//				List<ScoreDetail> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (ScoreDetail uu : list) {
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("effectNumId", uu.getId());
//						map.put("effectNum", uu.getScore() + "");
//						map.put("effectNumTitle", uu.getCategory());
//						map.put("effectNumTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(uu.getAdtime()));
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取影响力明细成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：6349" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.67 设置备注
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec4(UserRefundReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("设置备注失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getAuid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (req.getUid().equals(req.getAuid())) {
//				res.setResultNote("不能给自己备注");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getRemarks())) {
//				userRemarksService.executeDeleteSql(
//						"delete from t_user_remarks where uid='" + req.getUid() + "' and auid='" + req.getAuid() + "'");
//				res.setResultNote("取消备注成功");
////				try {// 网易云删除备注
////					Wangyiyunxin.deletefriend(req.getUid(), req.getAuid());
////					UserRemarks ur = userRemarksService.gets(req.getAuid(), req.getUid());
////					if (ur != null && ur.getRemarks() != null) {
////						Wangyiyunxin.addfriend(req.getAuid(), req.getUid());
////						Wangyiyunxin.addremark(req.getAuid(), req.getUid(), ur.getRemarks());
////					}
////				} catch (Exception e) {
////					logger.error("请求处理异常：6389" );
////					e.printStackTrace();
////				}
//				res.setResult("0");
//				return res;
//			}
//			// 查询用户
//			Tuser tuser = tuserService.get(req.getUid());
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			UserRemarks ur = userRemarksService.gets(req.getUid(), req.getAuid());
//			if (ur == null) {
//				ur = new UserRemarks();
//				ur.setUid(req.getUid());
//				ur.setAuid(req.getAuid());
//				ur.setRemarks(req.getRemarks());
//				ur.setAdtime(new Date());
//			} else {
//				ur.setRemarks(req.getRemarks());
//				ur.setAdtime(new Date());
//			}
//			userRemarksService.save(ur);
////			try {// 网易云添加备注
////				Wangyiyunxin.addfriend(req.getUid(), req.getAuid());
////				Wangyiyunxin.addremark(req.getUid(), req.getAuid(), req.getRemarks());
////			} catch (Exception e) {
////				logger.error("请求处理异常：6420" );
////				e.printStackTrace();
////			}
//			res.setResult("0");
//			res.setResultNote("设置备注成功" + req.getRemarks());
//		} catch (Exception e) {
//			logger.error("请求处理异常：6426" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.68 修改留言
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec5(UserRefundReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("修改留言失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getMessage())) {
//				res.setResultNote("备注不能为空");
//				return res;
//			}
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("订单不存在");
//				return res;
//			}
//			userOrder.setShopmessage(req.getMessage());
//			userOrderService.update(userOrder);
//			res.setResult("0");
//			res.setResultNote("修改备注成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：6464" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.69 取消订单删除
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec6(UserRefundReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("删除失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if (!"12".equals(userOrder.getStatus())) {
//				res.setResultNote("当前订单不能删除");
//				return res;
//			}
//			userOrderService.delete(userOrder);
//			res.setResult("0");
//			res.setResultNote("删除成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：6500" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.70 更新订单号
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec7(UserRefundReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("更新失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getOrderNum())) {
//				res.setResultNote("订单号不能为空");
//				return res;
//			}
//			UserOrder userOrder = userOrderService.gets(req.getOrderNum());
//			if (null == userOrder) {
//				res.setResultNote("订单不存在");
//				return res;
//			} else if (!"1".equals(userOrder.getStatus())) {
//				res.setResultNote("当前订单不能更新订单号");
//				return res;
//			}
//			String orderId = StringUtil.getOrderNo();
//			userOrder.setOrdernum(orderId);
//			userOrderService.update(userOrder);
//			userOrderService.executeUpdateSql("update t_user_orderlist set ordernum='" + orderId + "' where ordernum='"
//					+ req.getOrderNum() + "'");
//			OrderType ot = orderTypeMapper.gets(req.getOrderNum());
//			ot.setOrdernum(orderId);
//			orderTypeMapper.update(ot);
//			res.setObject(orderId);
//			res.setResult("0");
//			res.setResultNote("更新成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：6544" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.71 ios开关
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec8(UserRefundReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取成功");
//		try {
//			res.setObject("1");// 0上线用 1上架成功后
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：6564" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 1.72 ios屏蔽
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec9(UserRefundReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("屏蔽成功");
//		try {
//			String sql = "delete from t_dynamic where uid='" + req.getUid() + "'";
//			tuserService.executeDeleteSql(sql);
//			res.setResult("0");
//			res.setResultNote("屏蔽成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：6586" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.0 获取社区用户
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(GetCommunityReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		try {
//			Tuser u = new Tuser();
//			u.setCommunityid(req.getCommunityId());
//			if (!StringUtils.isBlank(req.getSex())) {
//				u.setSex(req.getSex());
//			}
//			if (!StringUtils.isBlank(req.getContent())) {
//				u.setNickname(req.getContent());
//			}
//			if (!StringUtils.isBlank(req.getUid())) {
//				u.setIsattention("(select count(1) from t_user_attention ua where ua.type=0 and ua.uid='" + req.getUid()
//						+ "' and ua.auid=a.id)");
//			}
//			List<Object> l = null;
//			String sql = "select count(1) from t_user where communityid='" + req.getCommunityId() + "'";
//			if ("0".equals(req.getSex()) || "1".equals(req.getSex())) {
//				sql = sql + " and sex='" + req.getSex() + "'";
//			}
//			u.setState("1");//显示优质用户
//			if (req.getContent() != null && !req.getContent().equals("")) {
//				sql = sql + " and nickname like '%%" + req.getContent() + "%%'";
//				u.setState(null);
//			}
//			l = tuserService.executeSelectSql(sql);
//			res.setAllnum(l.get(0).toString());
//			Page<Tuser> page = new Page<Tuser>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy(" a.effectnum desc");
//			Page<Tuser> pageInfo = tuserService.findPage(page, u);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//
//			if (null != pageInfo) {
//				List<Tuser> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (Tuser uu : list) {
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("userId", uu.getId());
//						try {
//							UserRemarks ur = userRemarksService.gets(req.getUid(), uu.getId());
//							if (ur != null && ur.getRemarks() != null) {
//								map.put("userName", ur.getRemarks());
//							} else {
//								map.put("userName", uu.getNickname());
//							}
//						} catch (Exception e) {
//							logger.error("请求处理异常：6650" );
//							e.printStackTrace();
//						}
//						map.put("userIcon",
//								StringUtils.isNotBlank(uu.getIcon()) && uu.getIcon().indexOf("http://") == -1
//										&& uu.getIcon().indexOf("https://") == -1 ? filePath + uu.getIcon()
//												: uu.getIcon());
//						map.put("userSex", uu.getSex());
//						map.put("userAge", StringUtils.isBlank(uu.getBirthday()) ? ""
//								: Year.getAge(DateTimeUtil.parse(uu.getBirthday())) + "");
//						map.put("userAutograph", uu.getAutograph());
//						map.put("effectNum", uu.getEffectnum() + "");
//						map.put("constellation", uu.getConstellation());
//						map.put("isAttention", uu.getIsattention());
//
//						map.put("userType", null==uu.getType()?"":uu.getType());
//						map.put("userlabel", null==uu.getLabel()?"":uu.getLabel());
//
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：6673" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.1 我的消息列表
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(GetMessageReq req) {
//		UserInfoRes res = new UserInfoRes();
//		res.setResultNote("获取失败");
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
//			List<Object> ojToken = communityService.executeSelectSql("SELECT rytoken FROM t_community WHERE id='"+user.getCommunityid()+"'");
//			if(null != ojToken && ojToken.size()>0 && null != ojToken.get(0)) {
//				res.setToken(ojToken.get(0).toString());
//			}
//			res.setCommunityId(user.getCommunityid());
//			res.setCommunityName(user.getCommunityName());
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			// 系统消息
//			List<Object> list = msgService
//					.executeSelectSql("select id from t_msg where type=1 and htype=0 and FIND_IN_SET('" + req.getUid()
//							+ "',uid) order by adtime desc limit 1");
//			if (null != list && list.size() > 0) {
//				Msg m = msgService.get(list.get(0).toString());
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("messageId", m.getId());
//				map.put("messageTitle", m.getTitle());
//				map.put("messageTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(m.getAdtime()));
//				map.put("type", "0");
//				String sql = "select count(1) from t_msg where type=1 and htype=0 and FIND_IN_SET('" + req.getUid()
//						+ "',uid) and !FIND_IN_SET('" + req.getUid() + "',status)";
//				list = communityService.executeSelectSql(sql);
//				map.put("messagenum", list.get(0).toString());
//				dataList.add(map);
//			}
//			// 订单消息
//			List<Object> list1 = msgService.executeSelectSql("select id from t_msg where type=1 and htype=1 and uid='"
//					+ req.getUid() + "' order by adtime desc limit 1");
//			if (null != list1 && list1.size() > 0) {
//				Msg m = msgService.get(list1.get(0).toString());
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("messageId", m.getId());
//				map.put("messageTitle", m.getTitle());
//				map.put("messageTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(m.getAdtime()));
//				map.put("type", "1");
//				String sql = "select count(1) from t_msg where type=1 and htype=1 and FIND_IN_SET('" + req.getUid()
//						+ "',uid) and !FIND_IN_SET('" + req.getUid() + "',status)";
//				list = communityService.executeSelectSql(sql);
//				map.put("messagenum", list.get(0).toString());
//				dataList.add(map);
//			}
//			// 评论消息
//			List<Object> list2 = msgService.executeSelectSql("select id from t_msg where type=1 and htype=2 and uid='"
//					+ req.getUid() + "' order by adtime desc limit 1");
//			if (null != list2 && list2.size() > 0) {
//				Msg m = msgService.get(list2.get(0).toString());
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("messageId", m.getId());
//				map.put("messageTitle", m.getTitle());
//				map.put("messageTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(m.getAdtime()));
//				map.put("type", "2");
//				String sql = "select count(1) from t_msg where type=1 and htype=2 and FIND_IN_SET('" + req.getUid()
//						+ "',uid) and !FIND_IN_SET('" + req.getUid() + "',status)";
//				list = communityService.executeSelectSql(sql);
//				map.put("messagenum", list.get(0).toString());
//				dataList.add(map);
//			}
//			// 点赞消息
//			List<Object> list3 = msgService.executeSelectSql("select id from t_msg where type=1 and htype=3 and uid='"
//					+ req.getUid() + "' order by adtime desc limit 1");
//			if (null != list3 && list3.size() > 0) {
//				Msg m = msgService.get(list3.get(0).toString());
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("messageId", m.getId());
//				map.put("messageTitle", m.getTitle());
//				map.put("messageTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(m.getAdtime()));
//				map.put("type", "3");
//				String sql = "select count(1) from t_msg where type=1 and htype=3 and FIND_IN_SET('" + req.getUid()
//						+ "',uid) and !FIND_IN_SET('" + req.getUid() + "',status)";
//				list = communityService.executeSelectSql(sql);
//				map.put("messagenum", list.get(0).toString());
//				dataList.add(map);
//			}
//			// 查看社区群号
//			List<Object> tid = communityService
//					.executeSelectSql("SELECT flock FROM t_community WHERE id='" + user.getCommunityid() + "'");
//			if (null != tid && tid.size() > 0 && null != tid.get(0)) {
//				res.setTid(tid.get(0).toString());
//			}
//
//			// 用户自己创建的群组和属于的群组
//			List<LayGroup> layGroupList = new ArrayList<LayGroup>();
//			LayGroup layGroup = new LayGroup();
//			User us = new User();
//			us.setId(req.getUid());
//			// 查找我自己创建的群组
//			layGroup.setCreateBy(us);
//			List<LayGroup> ownerLayGroupList = layGroupService.findList(layGroup);
//
//			// 查找我属于的群组
//			User u = new User();
//			u.setId(req.getUid());
//			u.setTradingid(user.getCommunityid());
//			List<LayGroup> memberLayGroupList = layGroupService.findGroupList(u);
//			layGroupList.addAll(ownerLayGroupList);
//			layGroupList.addAll(memberLayGroupList);
//			List<Map<String,String>> data = Lists.newArrayList();
//			for (LayGroup g : layGroupList) {
//				if(null==g)
//					continue;
//				Map<String,String> map = Maps.newHashMap();
//				map.put("groupId", g.getId());
//				map.put("groupName", g.getGroupname());
//				map.put("groupAvatar", filePath + g.getAvatar());
//				map.put("type", "10");
//				map.put("isCommunityGoup", StringUtils.isBlank(g.getCommunityid())?"0":"1");
//				map.put("status", g.getStatus());
//				map.put("num", g.getNum());
//				data.add(map);
//			}
//			res.setData(data);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//			res.setDataList(dataList);
//		} catch (Exception e) {
//			logger.error("请求处理异常：6783" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.2 官方消息列表
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(GetMessageReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
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
//			Msg m = new Msg();
//			m.setType("1");
//			m.setHtype("0");
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
//					map.put("messageTitle", msg.getTitle());
//					map.put("messageImage", !StringUtils.isBlank(msg.getImage()) ? filePath + msg.getImage() : "");
//					map.put("messageUrl", filePath + msg.getUrl());
//					map.put("messageTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(msg.getAdtime()));
//					int a = msg.getStatus().indexOf(req.getUid());
//					if (a > 0) {
//						map.put("isread", "1");
//					} else {
//						map.put("isread", "0");
//					}
//					dataList.add(map);
//				}
//			}
//			String sql = "update t_msg set status=ifnull(CONCAT(status,'," + req.getUid() + "'),'," + req.getUid()
//					+ "')" + "WHERE type=1 and htype=0 and FIND_IN_SET('" + req.getUid() + "',uid) AND !FIND_IN_SET('"
//					+ req.getUid() + "',status)";
//			msgService.executeUpdateSql(sql);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//			res.setDataList(dataList);
//		} catch (Exception e) {
//			logger.error("请求处理异常：6845" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.3 订单消息列表
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2(GetMessageReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
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
//			Msg m = new Msg();
//			m.setType("1");
//			m.setHtype("1");
//			m.setUid(req.getUid());
//			Page<Msg> page = new Page<Msg>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			Page<Msg> pageList = msgService.findPage(page, m);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			List<Msg> list = pageList.getList();
//			if (null != list && list.size() > 0) {
//				for (Msg msg : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("messageId", msg.getId());
//					map.put("messageTitle", msg.getTitle());
//					map.put("messageTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(msg.getAdtime()));
//					map.put("orderNum", msg.getUrl());
//					int a = msg.getStatus().indexOf(req.getUid());
//					if (a > 0) {
//						map.put("isread", "1");
//					} else {
//						map.put("isread", "0");
//					}
//					dataList.add(map);
//				}
//			}
//			String sql = "update t_msg set status=ifnull(CONCAT(status,'," + req.getUid() + "'),'," + req.getUid()
//					+ "')" + "WHERE type=1 and htype=1 and FIND_IN_SET('" + req.getUid() + "',uid) AND !FIND_IN_SET('"
//					+ req.getUid() + "',status)";
//			msgService.executeUpdateSql(sql);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//			res.setDataList(dataList);
//		} catch (Exception e) {
//			logger.error("请求处理异常：6906" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.4 评论消息列表
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec3(GetMessageReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
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
//			Msg m = new Msg();
//			m.setType("1");
//			m.setHtype("2");
//			m.setUid(req.getUid());
//			Page<Msg> page = new Page<Msg>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			Page<Msg> pageList = msgService.findPage(page, m);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			List<Msg> list = pageList.getList();
//			if (null != list && list.size() > 0) {
//				for (Msg msg : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("messageId", msg.getId());
//					map.put("messageTitle", msg.getTitle());
//					map.put("messageContent", msg.getContent());
//					map.put("messageTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(msg.getAdtime()));
//					map.put("userId", msg.getUserid());
//					map.put("userIcon",
//							StringUtils.isNotBlank(msg.getUsericon()) && msg.getUsericon().indexOf("http://") == -1
//									&& msg.getUsericon().indexOf("https://") == -1 ? filePath + msg.getUsericon()
//											: msg.getUsericon());
//					map.put("objid", msg.getObjid());
//					if ("1".equals(msg.getDtype())) {// 动态帮帮
//						map.put("type", "1");
//						Dynamic d = dynamicService.get(msg.getObjid());
//						if (null == d || null == d.getState()) {// 暂时去掉因为删除话题而再取的问题
//							continue;
//						} else
//							map.put("state", d.getState() + "");
//					} else if ("3".equals(msg.getDtype())) {// 活动
//						map.put("type", "2");
//						map.put("state", "0");
//					} else if ("5".equals(msg.getDtype())) {// 闲置
//						map.put("type", "4");
//						map.put("state", "0");
//					} else if ("6".equals(msg.getDtype())) {// 达人
//						map.put("type", "5");
//						map.put("state", "0");
//					} else {// 话题
//						map.put("type", "3");
//						map.put("state", "0");
//					}
//					if ("1".equals(msg.getTtype())) {
//						map.put("commentId", msg.getCommid());
//					} else {
//						map.put("commentId", "");
//					}
//					if (null == msg.getStatus() || "".equals(msg.getStatus())) {
//						map.put("isread", "0");
//					} else {
//						int a = msg.getStatus().indexOf(req.getUid());
//						if (a > 0) {
//							map.put("isread", "1");
//						} else {
//							map.put("isread", "0");
//						}
//					}
//					dataList.add(map);
//				}
//			}
//			String sql = "update t_msg set status=ifnull(CONCAT(status,'," + req.getUid() + "'),'," + req.getUid()
//					+ "')" + "WHERE type=1 and htype=2 and FIND_IN_SET('" + req.getUid() + "',uid) AND !FIND_IN_SET('"
//					+ req.getUid() + "',status)";
//			msgService.executeUpdateSql(sql);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//			res.setDataList(dataList);
//		} catch (Exception e) {
//			logger.error("请求处理异常：6996" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.5 删除消息
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(DeleteMessageReq req) {
//		ResJson res = new ResJson();
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
//			if ("0".equals(req.getType())) {
//				String uid = "replace(uid,'," + req.getUid() + "','')";
//				msgService.deletes(uid, req.getMessageid());
//			} else {
//				Msg msg = new Msg();
//				msg.setId(req.getMessageid());
//				msgService.delete(msg);
//			}
//			res.setResult("0");
//			res.setResultNote("删除成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：7035" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.6 发现
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec1(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
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
//			// 获取轮播
//			Banner b = bannerService.get("1");
//			if (b != null && b.getId().length() > 0) {
//				res.setTopImgUrl(filePath + b.getImage());
//				res.setTopImgDetailUrl(filePath + b.getUrl());
//				res.setTopImgDetailUrlState(b.getStatus());
//			}
//			// 获取日榜
//			List<Map<String, String>> redmanList = new ArrayList<Map<String, String>>();
////			String sql = " SELECT u.id," + " IFNULL((SELECT SUM(d.score) from t_score_detail d where d.uid=u.id "
////					+ " and d.adtime>=DATE(NOW()) GROUP BY d.uid),0) score" + " FROM t_user u"
////					+ " WHERE u.communityid='" + req.getCommunityId() + "'"
////					+ " ORDER BY score desc,u.effectnum desc LIMIT 3";
////			String sql = " SELECT u.id, SUM(d.score) as score FROM t_user u,t_score_detail d"
////					+" WHERE u.id = d.uid and u.communityid='" + req.getCommunityId() + "'"
////					+" and d.adtime>=DATE(NOW())"
////					+" GROUP BY u.id ORDER BY score desc,u.effectnum desc LIMIT 3";
//			String sql = "SELECT u.id, SUM(IFNULL(d.score,0)) as score FROM t_user u "
//					+ "LEFT JOIN t_score_detail d ON u.id = d.uid and d.adtime>=DATE(NOW()) "
//					+ "LEFT JOIN t_score_detail d1 ON u.id = d1.uid and d1.adtime>DATE(DATE_ADD(NOW(),INTERVAL -1 DAY)) "
//					+ "WHERE u.communityid='" + req.getCommunityId() + "'"
//					+ "GROUP BY u.id ORDER BY score desc,u.effectnum desc,SUM(IFNULL(d1.score,0)) desc LIMIT 3";
//			List<Object> listd = tuserService.executeSelectSql(sql);
//			if (null != listd && listd.size() > 0) {
//				for (Object obj : listd) {
//					Tuser u = tuserService.get(obj.toString());
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("userId", u.getId());
//					map.put("userImg", StringUtils.isNotBlank(u.getIcon()) && u.getIcon().indexOf("http://") == -1
//							&& u.getIcon().indexOf("https://") == -1 ? filePath + u.getIcon() : u.getIcon());
//					redmanList.add(map);
//				}
//			}
//			res.setRedmanList(redmanList);
//			// 获取话题
////			List<Object> list = themeService.executeSelectSql("select id from t_theme where communityid='"
////					+ req.getCommunityId() + "' order by adtime desc limit 1");
//			Theme t = new Theme();
//			t.setCommunityid(req.getCommunityId());
//			Page<Theme> page = new Page<Theme>();
//			page.setPageNo(0);
//			page.setPageSize(1);
//			page.setOrderBy("adtime desc");
//
//			page = themeService.findPage(page, t);
//			if (null != page && page.getList().size() > 0) {
////				Theme theme = themeService.get(list.get(0).toString());
//				Theme theme = page.getList().get(0);
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("themeId", theme.getId());
//				map.put("themeTitle", theme.getTitle());
//				map.put("themeDetailUrl", filePath + theme.getUrl());
//				map.put("themeImage", filePath + theme.getImage());
//				map.put("themeTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(theme.getAdtime()));
//				map.put("zanNum", theme.getZannum() + "");
//				map.put("commentNum", theme.getCommentnum() + "");
//				DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "4", theme.getId());
//				map.put("isZan", dz.getIszan());
//				res.setTheme(map);
//			}
//			String i = themeService.execSelectSqlString("select count(1) from t_user_dynamic_renew where uid='"+req.getUid()+"'");
//			if(Integer.valueOf(i)==0)
//				themeService.executeInsertSql("insert into t_user_dynamic_renew (uid,dynamictime,themetime) VALUES ('"+req.getUid()+"',NOW(),NOW())");
//			else
//				themeService.executeUpdateSql("update t_user_dynamic_renew SET dynamictime=NOW(),themetime = NOW() WHERE uid = '"+req.getUid()+"'");
////			SELECT COUNT(a.id),GROUP_CONCAT(DISTINCT a.type) from t_dynamic a
////			where a.adtime > '2019-03-26'-- (SELECT MAX(l.create_date) from t_user_log l where l.create_by = 'e4a563a7b515412fbeb380e1740f0301' and l.cmd = 'findList');
////			SELECT COUNT(a.id) from t_activity a
////			where a.adtime > '2019-03-26'-- (SELECT MAX(l.create_date) from t_user_log l where l.create_by = 'e4a563a7b515412fbeb380e1740f0301' and l.cmd = 'findList');
////			// 获取动态
////			Page<Dynamic> page = new Page<Dynamic>(1, 6);
////			Dynamic dynamic = new Dynamic();
////			dynamic.setType(0);
////			dynamic.setCommunityid(req.getCommunityId());
////			dynamic.setDataScope(" and a.state=0");
////			Page<Dynamic> pageInfo = dynamicService.findPage(page, dynamic);
////			List<Map<String, Object>> danamicList = new ArrayList<Map<String, Object>>();
////			if (null != pageInfo) {
////				List<Dynamic> listt = pageInfo.getList();
////				if (null != listt && listt.size() > 0) {
////					for (Dynamic a : listt) {
////						Map<String, Object> map = new HashMap<String, Object>();
////						map.put("dynamicId", a.getId());
////						map.put("dynamicUid", a.getUid());
////						try {
////							UserRemarks ur = userRemarksService.gets(req.getUid(), a.getUid());
////							if (ur != null && ur.getRemarks() != null) {
////								map.put("dynamicName", ur.getRemarks());
////							} else {
////								map.put("dynamicName", a.getDynamicname());
////							}
////						} catch (Exception e) {
////							logger.error("请求处理异常：7132" );
////							e.printStackTrace();
////						}
////						map.put("dynamicIcon",
////								StringUtils.isNotBlank(a.getDynamicicon())
////										&& a.getDynamicicon().indexOf("http://") == -1
////										&& a.getDynamicicon().indexOf("https://") == -1 ? filePath + a.getDynamicicon()
////												: a.getDynamicicon());
////						map.put("dynamicContent", a.getContent());
////						map.put("dynamicAddress", a.getAddress());
////						map.put("userEffectNum", a.getUsereffectnum());
////						map.put("zanNum", a.getZannum());
////						map.put("commentNum", a.getCommentnum());
////						map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getAdtime()));
////						DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "1", a.getId());
////						map.put("isZan", dz.getIszan());
////						UserAttention ua = userAttentionService.isattention(req.getUid(), "0", a.getUid());
////						map.put("isAttention", ua.getIsattention());
////						if (a.getHtype() == 0) {// 图片动态
////							CommentImage commentImage = new CommentImage();
////							commentImage.setType("1");
////							commentImage.setCommentid(a.getId());
////							List<CommentImage> imageList = commentImageService.findList(commentImage);
////							List<String> list1 = new ArrayList<String>();
////							if (imageList != null && imageList.size() > 0) {
////								for (CommentImage c : imageList) {
////									list1.add(filePath + c.getImage());
////								}
////							}
////							map.put("dynamicImgList", list1);
////						} else {// 视频动态
////							map.put("dynamicImg", !StringUtils.isBlank(a.getImage()) ? filePath + a.getImage() : "");
////							map.put("dynamicVideo", a.getVideourl().indexOf("http://") != -1 ? a.getVideourl()
////									: filePath + a.getVideourl() + "");
////							// map.put("dynamicVideo",
////							// "https://doulinapp.oss-cn-beijing.aliyuncs.com/20181016090822ShP6.mp4");
////
////						}
////						map.put("height", a.getHeight());
////						map.put("width", a.getWidth());
////						danamicList.add(map);
////					}
//////					List<Map<String, Object>> danamicList1 = new ArrayList<Map<String, Object>>();
//////					if(danamicList!=null && danamicList.size()>0){
//////						for (int i = danamicList.size()-1; i >=0; i--) {
//////							danamicList1.add(danamicList.get(i));
//////						}
//////					}
////					res.setDanamicList(danamicList);
////				}
////			}
////			// 获取活动
////			List<Object> lists = activityService.executeSelectSql(
////					"select a.id from t_activity a left join t_user u on u.id=a.uid where u.communityid='"
////							+ req.getCommunityId() + "' order by a.adtime desc limit 1");
////			if (null != lists && lists.size() > 0) {
////				Activity a = activityService.get(lists.get(0).toString());
////				Map<String, Object> map = new HashMap<String, Object>();
////				map.put("activityId", a.getId());
////				map.put("activityName", a.getName());
////				map.put("activityAddress", a.getAddress());
////				map.put("activityTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getAdtime()));
////				map.put("activityAllnum", a.getAllnum());
////				map.put("activityNownum", a.getNownum());
////				map.put("activityMoney", a.getMoney());
////				map.put("userid", a.getUid());
////				try {
////					UserRemarks ur = userRemarksService.gets(req.getUid(), a.getUid());
////					if (ur != null && ur.getRemarks() != null) {
////						map.put("userName", ur.getRemarks());
////					} else {
////						map.put("userName", a.getUsername());
////					}
////				} catch (Exception e) {
////					logger.error("请求处理异常：7206" );
////					e.printStackTrace();
////				}
////				map.put("userIcon",
////						StringUtils.isNotBlank(a.getUsericon()) && a.getUsericon().indexOf("http://") == -1
////								&& a.getUsericon().indexOf("https://") == -1 ? filePath + a.getUsericon()
////										: a.getUsericon());
////				map.put("userEffectNum", a.getUsereffectnum());
////				map.put("zanNum", a.getZannum());
////				map.put("commentNum", a.getCommentnum());
////				map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getAdtime()));
////				if (a.getSigntime().getTime() > new Date().getTime()) {
////					map.put("activityState", "0");
////				} else if (a.getSigntime().getTime() < new Date().getTime()
////						&& a.getEndtime().getTime() > new Date().getTime()) {
////					map.put("activityState", "1");
////				} else {
////					map.put("activityState", "2");
////				}
////				CommentImage commentImage = new CommentImage();
////				commentImage.setType("2");
////				commentImage.setCommentid(a.getId());
////				List<CommentImage> imageList = commentImageService.findList(commentImage);
////				if (imageList != null && imageList.size() > 0) {
////					map.put("activityImg", filePath + imageList.get(0).getImage());
////				}
////				DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "3", a.getId());
////				map.put("isZan", dz.getIszan());
////				UserAttention ua = userAttentionService.isattention(req.getUid(), "0", a.getUid());
////				map.put("isAttention", ua.getIsattention());
////				ActivityMember am = activityMemberService.isActivityMember(req.getUid(), a.getId());
////				map.put("issignup", am.getIssignup());
////				res.setActivity(map);
////			}
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：7243" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.6 发现(新)
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecNew(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
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
//
//			// 获取话题
//			Theme t = new Theme();
//			t.setCommunityid(req.getCommunityId());
//			Page<Theme> page = new Page<Theme>();
//			page.setPageNo(0);
//			page.setPageSize(1);
//			page.setOrderBy("adtime desc");
//			page = themeService.findPage(page, t);
//			if (null != page && page.getList().size() > 0) {
//				Theme theme = page.getList().get(0);
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("themeId", theme.getId());
//				map.put("themeTitle", theme.getTitle());
//				map.put("themeContent", theme.getContent());
//				map.put("themeDetailUrl", filePath + theme.getUrl());
//				map.put("themeImage", filePath + theme.getImage());
//				map.put("themeTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(theme.getAdtime()));
//				if(theme.getZannum()==0&&theme.getOpposenum()==0){
//					map.put("zanNum", "50%");
//					map.put("opposeNum", "50%");
//				}else{
//					if(theme.getZannum()==0){
//						map.put("zanNum", "0%");
//					}else{
//						map.put("zanNum", Math.rint(Double.valueOf(theme.getZannum())/(theme.getZannum()+theme.getOpposenum())*100) + "%");
//					}
//					if(theme.getOpposenum()==0){
//						map.put("opposeNum", "0%");
//					}else{
//						map.put("opposeNum", 100-Math.rint(Double.valueOf(theme.getZannum())/(theme.getZannum()+theme.getOpposenum())*100) + "%");
//					}
//				}
//				map.put("commentNum", theme.getCommentnum()+"");
//				map.put("zanViews", theme.getZanviews());
//				map.put("opposeViews", theme.getOpposeviews());
//				DynamicZan dz = dynamicZanService.isDynamicFlag(req.getUid(), "4", theme.getId());
//				if(null==dz)
//					map.put("flag", "");
//				else
//					map.put("flag", dz.getFlag());//1为正方，0为反方
//				res.setTheme(map);
//			}
//
//			String i = themeService.execSelectSqlString("select count(1) from t_user_dynamic_renew where uid='"+req.getUid()+"'");
//			if(Integer.valueOf(i)==0)
//				themeService.executeInsertSql("insert into t_user_dynamic_renew (uid,dynamictime,themetime) VALUES ('"+req.getUid()+"',NOW(),NOW())");
//			else
//				themeService.executeUpdateSql("update t_user_dynamic_renew SET dynamictime=NOW(),themetime = NOW() WHERE uid = '"+req.getUid()+"'");
//			List<Map<String,String>> type = Lists.newArrayList();
//			Map<String,String> key = Maps.newHashMap();
//			key.put("value", "");
//			key.put("name", "全部");
//			type.add(key);
//			Map<String,String> key0 = Maps.newHashMap();
//			key0.put("value", "0");
//			key0.put("name", "动态");
//			type.add(key0);
//			Map<String,String> key1 = Maps.newHashMap();
//			key1.put("value", "1");
//			key1.put("name", "帮帮");
//			type.add(key1);
//			Map<String,String> key3 = Maps.newHashMap();
//			key3.put("value", "3");
//			key3.put("name", "活动");
//			type.add(key3);
//			Map<String,String> key5 = Maps.newHashMap();
//			key5.put("value", "5");
//			key5.put("name", "闲置");
//			type.add(key5);
//			Map<String,String> key6 = Maps.newHashMap();
//			key6.put("value", "6");
//			key6.put("name", "达人");
//			type.add(key6);
//			res.setType(type);
//
//			List<Map<String,String>> scope = Lists.newArrayList();
//			Map<String,String> key8 = Maps.newHashMap();
//			key8.put("value", "");
//			key8.put("name", "全城");
//			scope.add(key8);
//			Map<String,String> key7 = Maps.newHashMap();
//			key7.put("value", user.getCommunityid());
//			key7.put("name", "本小区");
//			scope.add(key7);
//			res.setScope(scope);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：7243" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.7 获取活动/闲置/达人经历/话题评论
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec99(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
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
//			// 获取评论
//			Page<Comment> page = new Page<Comment>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime asc");
//			Comment c = new Comment();
//			if ("6".equals(req.getType())) {
//				c.setType("6");
//			}else if ("5".equals(req.getType())) {
//				c.setType("5");
//			}else if ("0".equals(req.getType())) {
//				c.setType("3");
//			} else {
//				c.setType("4");
//			}
//			c.setObjid(req.getActivityId());
//			c.setState("0");
//			Page<Comment> pageInfo = commentService.findPage(page, c);
//			List<Comment> list = pageInfo.getList();
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				for (Comment cc : list) {
//					Map<String, Object> map1 = new HashMap<String, Object>();
//					map1.put("commentId", cc.getId());
//					map1.put("commentUid", cc.getUid());
//					map1.put("commentIcon",
//							StringUtils.isNotBlank(cc.getCommenticon()) && cc.getCommenticon().indexOf("http://") == -1
//									&& cc.getCommenticon().indexOf("https://") == -1 ? filePath + cc.getCommenticon()
//											: cc.getCommenticon());
//					try {
//						UserRemarks ur = userRemarksService.gets(req.getUid(), cc.getUid());
//						if (ur != null && ur.getRemarks() != null) {
//							map1.put("commentName", ur.getRemarks());
//						} else {
//							map1.put("commentName", cc.getCommentname());
//						}
//					} catch (Exception e) {
//						logger.error("请求处理异常：7050" );
//						e.printStackTrace();
//					}
//					map1.put("commentContent", cc.getContent());
//					map1.put("commentTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(cc.getAdtime()));
//					map1.put("zanNum", cc.getZannum());
//					map1.put("secondNum", cc.getCommentnum());
//					DynamicZan dzz = dynamicZanService.isDynamicZan(req.getUid(), "2", cc.getId());
//					map1.put("isZan", dzz.getIszan());
//
//					// 获取二级评论
//					Comment c2 = new Comment();
//					c2.setPid(cc.getId());
//					c2.setState("1");
//					List<Comment> comment2list = commentService.findList(c2);
//					if (null != comment2list && comment2list.size() > 0) {
//						List<Map<String, Object>> comment2data = Lists.newArrayList();
//						for (Comment cc2 : comment2list) {
//							Map<String, Object> map2 = new HashMap<String, Object>();
//							map2.put("commentId", cc2.getId());
//							map2.put("commentUid", cc2.getUid());
//							map2.put("commentIcon",
//									StringUtils.isNotBlank(cc2.getCommenticon()) && cc2.getCommenticon().indexOf("http://") == -1
//											&& cc2.getCommenticon().indexOf("https://") == -1 ? filePath + cc2.getCommenticon()
//													: cc2.getCommenticon());
//							try {
//								UserRemarks ur = userRemarksService.gets(req.getUid(), cc2.getUid());
//								if (ur != null && ur.getRemarks() != null) {
//									map2.put("commentName", ur.getRemarks());
//								} else {
//									map2.put("commentName", cc2.getCommentname());
//								}
//							} catch (Exception e) {
//								logger.error("请求处理异常：7082" );
//								e.printStackTrace();
//							}
//							map2.put("commentContent", cc2.getContent());
//							map2.put("commentTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(cc2.getAdtime()));
//							comment2data.add(map2);
//						}
//						map1.put("comment2", comment2data);
//					}
//
//					dataList.add(map1);
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：7099" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.8 活动/话题二级评论
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec100(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
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
//			// 获取评论
//			Page<Comment> page = new Page<Comment>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime asc");
//			Comment c = new Comment();
//			if ("0".equals(req.getType())) {
//				c.setType("3");
//			} else {
//				c.setType("4");
//			}
//			c.setPid(req.getCommentId());
//			c.setState("1");
//			Page<Comment> pageInfo = commentService.findPage(page, c);
//			List<Comment> list = pageInfo.getList();
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				for (Comment cc : list) {
//					Map<String, Object> map1 = new HashMap<String, Object>();
//					map1.put("commentId", cc.getId());
//					map1.put("commentUid", cc.getUid());
//					map1.put("commentIcon",
//							StringUtils.isNotBlank(cc.getCommenticon()) && cc.getCommenticon().indexOf("http://") == -1
//									&& cc.getCommenticon().indexOf("https://") == -1 ? filePath + cc.getCommenticon()
//											: cc.getCommenticon());
//					try {
//						UserRemarks ur = userRemarksService.gets(req.getUid(), cc.getUid());
//						if (ur != null && ur.getRemarks() != null) {
//							map1.put("commentName", ur.getRemarks());
//						} else {
//							map1.put("commentName", cc.getCommentname());
//						}
//					} catch (Exception e) {
//						logger.error("请求处理异常：7380" );
//						e.printStackTrace();
//					}
//					map1.put("commentContent", cc.getContent());
//					map1.put("commentTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(cc.getAdtime()));
//					dataList.add(map1);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：7392" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.9 活动/话题点赞
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec111(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("点赞失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getActivityId())) {
//				res.setResultNote("活动/话题ID不能为空");
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
//			if ("6".equals(req.getType())) {// 达人
//				if (StringUtils.isBlank(req.getCommentId())) {// 达人
//					DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "6", req.getActivityId());
//					if ("0".equals(dz.getIszan())) {// 没赞过，点赞
//						DynamicZan dz1 = new DynamicZan();
//						dz1.setUid(req.getUid());
//						dz1.setType(6);
//						dz1.setObjid(req.getActivityId());
//						dz1.setAdtime(new Date());
//						dynamicZanService.save(dz1);
//						communityManExperienceService.addManExperienceZan(req.getActivityId());
//						res.setResultNote("点赞成功");
//						CommunityManExperience d = communityManExperienceService.get(req.getActivityId());
//						Msg m = new Msg();
//						m.setUid(d.getUid());
//						m.setType("1");
//						m.setHtype("3");
//						m.setTitle("点赞消息");
//						try {
//							UserRemarks ur = userRemarksService.gets(d.getUid(), req.getUid());
//							if (ur != null && ur.getRemarks() != null) {
//								m.setContent(ur.getRemarks() + "赞了您");
//							} else {
//								m.setContent(user.getNickname() + "赞了您");
//							}
//						} catch (Exception e) {
//							logger.error("请求处理异常：7368" );
//							e.printStackTrace();
//						}
//						m.setUrl(dz1.getId());
//						m.setStatus("");
//						m.setAdtime(new Date());
//						msgService.save(m);
//					} else {// 赞过，取消点赞
//						dynamicZanService.executeDeleteSql(
//								"delete from t_msg where type=1 and htype=3 and url=(select id from t_dynamic_zan where uid='"
//										+ req.getUid() + "' and objid='" + req.getActivityId() + "')");
//						dynamicZanService.deleteZan(req.getUid(), "6", req.getActivityId());
//						communityManExperienceService.reduceManExperienceZan(req.getActivityId());
//						res.setResultNote("取消点赞成功");
//					}
//				} else {// 一级评论
//					DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "2", req.getCommentId());
//					if ("0".equals(dz.getIszan())) {// 没赞过，点赞
//						DynamicZan dz1 = new DynamicZan();
//						dz1.setUid(req.getUid());
//						dz1.setType(2);
//						dz1.setObjid(req.getCommentId());
//						dz1.setAdtime(new Date());
//						dynamicZanService.save(dz1);
//						commentService.addCommentZan(req.getCommentId());
//						res.setResultNote("点赞成功");
//					} else {// 赞过，取消点赞
//						commentService.reduceCommentZan(req.getCommentId());
//						dynamicZanService.deleteZan(req.getUid(), "2", req.getCommentId());
//						res.setResultNote("取消点赞成功");
//					}
//				}
//			} else if ("5".equals(req.getType())) {// 闲置为我想要 赞过就是我想要^_^
//				DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "5", req.getActivityId());
//				if ("0".equals(dz.getIszan())) {// 没有想要过
//					DynamicZan dz1 = new DynamicZan();
//					dz1.setUid(req.getUid());
//					dz1.setType(5);
//					dz1.setObjid(req.getActivityId());
//					dz1.setAdtime(new Date());
//					dynamicZanService.save(dz1);
//					activityService.addActivityZan(req.getActivityId());
//					res.setResultNote("我想要");
//					Activity d = activityService.get(req.getActivityId());
//					Msg m = new Msg();
//					m.setUid(d.getUid());
//					m.setType("1");
//					m.setHtype("3");
//					m.setTitle("我想要");
//					try {
//						UserRemarks ur = userRemarksService.gets(d.getUid(), req.getUid());
//						if (ur != null && ur.getRemarks() != null) {
//							m.setContent(ur.getRemarks() + "想要您发布的闲置商品【"+d.getName()+"】");
//						} else {
//							m.setContent(user.getNickname() + "想要您发布的闲置商品【"+d.getName()+"】");
//						}
//					} catch (Exception e) {
//						logger.error("请求处理异常：7426" );
//						e.printStackTrace();
//					}
//					m.setUrl(dz1.getId());
//					m.setStatus("");
//					m.setAdtime(new Date());
//					msgService.save(m);
//				} else {// 想要过
//					res.setResultNote("已经想要过");
//				}
//			} else if ("0".equals(req.getType())) {// 活动
//				if (StringUtils.isBlank(req.getCommentId())) {// 活动
//					DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "3", req.getActivityId());
//					if ("0".equals(dz.getIszan())) {// 没赞过，点赞
//						DynamicZan dz1 = new DynamicZan();
//						dz1.setUid(req.getUid());
//						dz1.setType(3);
//						dz1.setObjid(req.getActivityId());
//						dz1.setAdtime(new Date());
//						dynamicZanService.save(dz1);
//						activityService.addActivityZan(req.getActivityId());
//						res.setResultNote("点赞成功");
//						Activity d = activityService.get(req.getActivityId());
//						Msg m = new Msg();
//						m.setUid(d.getUid());
//						m.setType("1");
//						m.setHtype("3");
//						m.setTitle("点赞消息");
//						try {
//							UserRemarks ur = userRemarksService.gets(d.getUid(), req.getUid());
//							if (ur != null && ur.getRemarks() != null) {
//								m.setContent(ur.getRemarks() + "赞了您");
//							} else {
//								m.setContent(user.getNickname() + "赞了您");
//							}
//						} catch (Exception e) {
//							logger.error("请求处理异常：7450" );
//							e.printStackTrace();
//						}
//						m.setUrl(dz1.getId());
//						m.setStatus("");
//						m.setAdtime(new Date());
//						msgService.save(m);
//					} else {// 赞过，取消点赞
//						dynamicZanService.executeDeleteSql(
//								"delete from t_msg where type=1 and htype=3 and url=(select id from t_dynamic_zan where uid='"
//										+ req.getUid() + "' and objid='" + req.getActivityId() + "')");
//						dynamicZanService.deleteZan(req.getUid(), "3", req.getActivityId());
//						activityService.reduceActivityZan(req.getActivityId());
//						res.setResultNote("取消点赞成功");
//					}
//				} else {// 一级评论
//					DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "2", req.getCommentId());
//					if ("0".equals(dz.getIszan())) {// 没赞过，点赞
//						DynamicZan dz1 = new DynamicZan();
//						dz1.setUid(req.getUid());
//						dz1.setType(2);
//						dz1.setObjid(req.getCommentId());
//						dz1.setAdtime(new Date());
//						dynamicZanService.save(dz1);
//						commentService.addCommentZan(req.getCommentId());
//						res.setResultNote("点赞成功");
//					} else {// 赞过，取消点赞
//						commentService.reduceCommentZan(req.getCommentId());
//						dynamicZanService.deleteZan(req.getUid(), "2", req.getCommentId());
//						res.setResultNote("取消点赞成功");
//					}
//				}
//			} else {// 话题
//				if (StringUtils.isBlank(req.getCommentId())) {// 话题
//					DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "4", req.getActivityId());
//					if ("0".equals(dz.getIszan())) {// 没赞过，点赞
//						DynamicZan dz1 = new DynamicZan();
//						dz1.setUid(req.getUid());
//						dz1.setType(4);
//						dz1.setObjid(req.getActivityId());
//						dz1.setAdtime(new Date());
//						dynamicZanService.save(dz1);
//						themeService.addThemeZan(req.getActivityId());
//						res.setResultNote("点赞成功");
//					} else {// 赞过，取消点赞
//						dynamicZanService.executeDeleteSql(
//								"delete from t_msg where type=1 and htype=3 and url=(select id from t_dynamic_zan where uid='"
//										+ req.getUid() + "' and objid='" + req.getActivityId() + "')");
//						dynamicZanService.deleteZan(req.getUid(), "4", req.getActivityId());
//						themeService.reduceThemeZan(req.getActivityId());
//						res.setResultNote("取消点赞成功");
//					}
//				} else {// 一级评论
//					DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "2", req.getCommentId());
//					if ("0".equals(dz.getIszan())) {// 没赞过，点赞
//						DynamicZan dz1 = new DynamicZan();
//						dz1.setUid(req.getUid());
//						dz1.setType(2);
//						dz1.setObjid(req.getCommentId());
//						dz1.setAdtime(new Date());
//						dynamicZanService.save(dz1);
//						commentService.addCommentZan(req.getCommentId());
//						res.setResultNote("点赞成功");
//					} else {// 赞过，取消点赞
//						commentService.reduceCommentZan(req.getCommentId());
//						dynamicZanService.deleteZan(req.getUid(), "2", req.getCommentId());
//						res.setResultNote("取消点赞成功");
//					}
//				}
//			}
//
//			res.setResult("0");
//		} catch (Exception e) {
//			logger.error("请求处理异常：7523" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.9 话题点赞(新)
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("点赞失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getThemeId())) {
//				res.setResultNote("话题ID不能为空");
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
//			if (!StringUtils.isBlank(req.getThemeId())) {// 话题
//				DynamicZan dz = dynamicZanService.isDynamicFlag(req.getUid(), "4", req.getThemeId());
//				if (null == dz || null == dz.getFlag()) {//没支持过
//					if(null == dz){
//						DynamicZan dz1 = new DynamicZan();
//						dz1.setUid(req.getUid());
//						dz1.setType(4);
//						dz1.setObjid(req.getThemeId());
//						dz1.setFlag(req.getFlag());
//						dz1.setAdtime(new Date());
//						dynamicZanService.save(dz1);
//					}else{
//						dynamicZanService.executeUpdateSql("UPDATE t_dynamic_zan SET flag='"+req.getFlag()+"' WHERE id='"+dz.getId()+"'");
//					}
//					res.setResult("0");
//					if("1".equals(req.getFlag())){
//						themeService.addThemeZan(req.getThemeId());
//						res.setResultNote("支持红方成功");
//					} else{
//						themeService.addThemeOppose(req.getThemeId());
//						res.setResultNote("支持蓝方成功");
//					}
//				} else {
//					res.setResult("1");
//					if("1".equals(dz.getFlag())){
//						res.setResultNote("您已经支持了红方，不能再支持了哦");
//					}else{
//						res.setResultNote("您已经支持了蓝方，不能再支持了哦");
//					}
//				}
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：7523" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//	/**
//	 * 2.9 二手闲置售出处理
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecSHSelled(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("处理失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getActivityId())) {
//				res.setResultNote("闲置ID不能为空");
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
//			if (!StringUtils.isBlank(req.getActivityId())) {
//				Activity ac = activityService.get(req.getActivityId());
//				if("1".equals(req.getState())){
//					activityService.deleteByLogic(ac);
//					res.setResult("0");
//					res.setResultNote("已删除闲置物品");
//					return res;
//				}else{
//					if (null==ac.getStatus() || "0".equals(ac.getStatus())) {//没被售出
//						activityService.secondHandSelled(ac.getId());
//						res.setResult("0");
//						res.setResultNote("已设置成售出");
//						return res;
//					} else {
//						res.setResultNote("请不要重复售出");
//						return res;
//					}
//				}
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：7642" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.10 活动/话题评论
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec122(UserScoreListReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("评论失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getActivityId())) {
//				res.setResultNote("活动/话题ID不能为空");
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
//
//			if (StringUtils.isBlank(req.getCommentId())) {// 一级评论
//				Comment c = new Comment();
//				String id = IdGen.uuid();
//				c.setId(id);
//				c.setUid(req.getUid());
//
//				c.setState("0");
//				c.setObjid(req.getActivityId());
//				c.setZannum(0);
//				c.setCommentnum(0);
//				c.setContent(req.getContent());
//				c.setAdtime(new Date());
//
//				String uid = "";
//				if ("6".equals(req.getType())) {// 达人
//					c.setType("6");//达人
//					commentService.insert(c);
//					communityManExperienceService.addManExperienceComment(req.getActivityId());
//					CommunityManExperience d = communityManExperienceService.get(req.getActivityId());
//					uid = d.getUid();
//				} else if ("0".equals(req.getType())||"5".equals(req.getType())) {//0活动 5闲置
//					if("5".equals(req.getType())){
//						c.setType("5");
//					}else{
//						c.setType("3");
//					}
//					commentService.insert(c);
//					activityService.addActivityComment(req.getActivityId());
//					Activity d = activityService.get(req.getActivityId());
//					uid = d.getUid();
//				} else {// 话题
//					c.setType("4");
//					commentService.insert(c);
//					themeService.addThemeComment(req.getActivityId());
//				}
//
//				if("6".equals(req.getType()) || "0".equals(req.getType())){
//					Msg m = new Msg();
//					m.setUid(uid);
//					m.setType("1");
//					m.setHtype("2");
//					m.setTitle("评论消息");
//					m.setContent(req.getContent());
//					m.setUrl(id);
//					m.setStatus("");
//					m.setAdtime(new Date());
//					msgService.save(m);
//				}
//				res.setObject(c.getId());
//			} else {// 二级评论
//				Comment c = new Comment();
//				String id = IdGen.uuid();
//				c.setId(id);
//				c.setUid(req.getUid());
//				if ("6".equals(req.getType())) {// 达人
//					c.setType("6");//达人
//				} else if ("0".equals(req.getType())) {//0活动
//					c.setType("3");
//				} else if ("5".equals(req.getType())) {// 5闲置
//					c.setType("5");
//				} else {// 话题
//					c.setType("4");
//				}
//				c.setState("1");
//				c.setObjid(req.getActivityId());
//				c.setPid(req.getCommentId());
//				c.setZannum(0);
//				c.setCommentnum(0);
//				c.setContent(req.getContent());
//				c.setAdtime(new Date());
//				commentService.insert(c);
//				commentService.addCommentcomm(req.getCommentId());
//				Comment d = commentService.get(req.getCommentId());
//				Msg m = new Msg();
//				m.setUid(d.getUid());
//				m.setType("1");
//				m.setHtype("2");
//				m.setTitle("评论消息");
//				m.setContent(req.getContent());
//				m.setUrl(id);
//				m.setStatus("");
//				m.setAdtime(new Date());
//				msgService.save(m);
//				res.setObject(c.getId());
//			}
//
//			res.setResult("0");
//			res.setResultNote("评论成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：7659" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.11 红人榜
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec2(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		String sql = "";
////		String sql1 = "";
//		try {
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
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
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if ("0".equals(req.getType())) {// 日榜
////				sql = " SELECT u.id," + " IFNULL((SELECT SUM(d.score) from t_score_detail d where d.uid=u.id "
////						+ " and d.adtime>=CURDATE() GROUP BY d.uid),0) score" + " FROM t_user u"
////						+ " WHERE u.communityid='" + req.getCommunityId() + "'"
////						+ " ORDER BY score desc,u.effectnum desc LIMIT 20";
////				sql1 = " SELECT " + " IFNULL((SELECT SUM(d.score) from t_score_detail d where d.uid=u.id "
////						+ " and d.adtime>=CURDATE() GROUP BY d.uid),0) score" + " FROM t_user u"
////						+ " WHERE u.communityid='" + req.getCommunityId() + "'"
////						+ " ORDER BY score desc,u.effectnum desc LIMIT 20";
//				sql = "SELECT u.id, SUM(d.score) as score FROM t_user u,t_score_detail d"
//						  +" WHERE u.id = d.uid"
//						  	+" and u.communityid='" + req.getCommunityId() + "'"
//						    +" and d.adtime>=CURDATE()"
//						  +" GROUP BY u.id ORDER BY score desc,u.effectnum desc LIMIT 20";
//			} else {// 月榜
////				sql = " SELECT u.id," + " IFNULL((SELECT SUM(d.score) from t_score_detail d where d.uid=u.id "
////						+ " and d.adtime>=DATE(DATE_ADD(CURDATE(),INTERVAL -30 DAY)) GROUP BY d.uid),0) score"
////						+ " FROM t_user u" + " WHERE u.communityid='" + req.getCommunityId() + "'"
////						+ " ORDER BY score desc,u.effectnum desc LIMIT 20";
////				sql1 = " SELECT " + " IFNULL((SELECT SUM(d.score) from t_score_detail d where d.uid=u.id "
////						+ " and d.adtime>=DATE(DATE_ADD(CURDATE(),INTERVAL -30 DAY)) GROUP BY d.uid),0) score"
////						+ " FROM t_user u" + " WHERE u.communityid='" + req.getCommunityId() + "'"
////						+ " ORDER BY score desc,u.effectnum desc LIMIT 20";
//				sql = "SELECT u.id, SUM(d.score) as score FROM t_user u,t_score_detail d"
//						  +" WHERE u.id = d.uid"
//						  	+" and u.communityid='" + req.getCommunityId() + "'"
//						    +" and d.adtime>=DATE(DATE_ADD(CURDATE(),INTERVAL -30 DAY))"
//						  +" GROUP BY u.id ORDER BY score desc,u.effectnum desc LIMIT 20";
//			}
//			List<Map<String,Object>> listd = tuserService.execSelectSqlListMap(sql);
////			List<Object> listdd = tuserService.executeSelectSql(sql1);
//			if (null != listd && listd.size() > 0) {
//				for (int i = 0; i < listd.size(); i++) {
//					Tuser u = tuserService.get(listd.get(i).get("id").toString());
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("userId", u.getId());
//					map.put("userImg", StringUtils.isNotBlank(u.getIcon()) && u.getIcon().indexOf("http://") == -1
//							&& u.getIcon().indexOf("https://") == -1 ? filePath + u.getIcon() : u.getIcon());
//					try {
//						UserRemarks ur = userRemarksService.gets(req.getUid(), u.getId());
//						if (ur != null && ur.getRemarks() != null) {
//							map.put("userName", ur.getRemarks());
//						} else {
//							map.put("userName", u.getNickname());
//						}
//					} catch (Exception e) {
//						logger.error("请求处理异常：7730" );
//						e.printStackTrace();
//					}
////					map.put("userEffectNum", listdd.get(i).toString());
//					map.put("userEffectNum", listd.get(i).get("score").toString());
//					map.put("rankValue", (i + 1) + "");
//					UserAttention ua = userAttentionService.isattention(req.getUid(), "0", u.getId());
//					map.put("isAttention", ua.getIsattention());
//					dataList.add(map);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：7744" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.12 社区达人
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec3(GetCommunityReq req, HttpServletRequest request) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
////			if (StringUtils.isBlank(req.getType())) {
////				res.setResultNote("type不能为空");
////				return res;
////			}
//			Tuser user = tuserService.get(req.getUid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//			res.setIsApply(user.getIsapply());
//			Banner b = bannerService.get("2");
//			if (b != null && b.getId().length() > 0) {
//				res.setTopImgUrl(filePath + b.getImage());
//				res.setTopImgDetailUrl(filePath + b.getUrl());
//				res.setTopImgDetailUrlState(b.getStatus());
//			}
//			// 获取社区达人
//			CommunityMan cm = new CommunityMan();
//			cm.setCommunityid(req.getCommunityId());
//			cm.setState(2);
//			if(!csc.validateVersion(request, "1.5.0")){//版本号为1.5.0之前的版本
//				if(null!=req.getType()&&!"".equals(req.getType()))
//					cm.setType(Integer.valueOf(req.getType()));
//			}
//			Page<CommunityMan> page = new Page<CommunityMan>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("u.effectnum desc");
//			Page<CommunityMan> pageList = communityManService.findPage(page, cm);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			List<CommunityMan> list = pageList.getList();
//			if (list != null && list.size() > 0) {
//				for (CommunityMan c : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("userId", c.getUid());
//					map.put("userImg", StringUtils.isNotBlank(c.getUserimg()) && c.getUserimg().indexOf("http://") == -1
//									&& c.getUserimg().indexOf("https://") == -1 ? filePath + c.getUserimg()	: c.getUserimg());
//					try {
//						UserRemarks ur = userRemarksService.gets(req.getUid(), c.getUid());
//						if (ur != null && ur.getRemarks() != null) {
//							map.put("userName", ur.getRemarks());
//						} else {
//							map.put("userName", c.getUsername());
//						}
//					} catch (Exception e) {
//						logger.error("请求处理异常：7813" );
//						e.printStackTrace();
//					}
//					map.put("userType", c.getType()+"");
//					map.put("userEffectNum", c.getUsereffectnum());
//					map.put("userlabel", c.getName());
//					map.put("userDesc", c.getUserdesc());
//					UserAttention ua = userAttentionService.isattention(req.getUid(), "0", c.getUid());
//					map.put("isAttention", ua.getIsattention());
//					dataList.add(map);
//				}
//			}
//			res.setTotalPage(page.getTotalPage());
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：7829" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.13 社区达人申请
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec4(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("达人申请提交失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getType())) {
//				res.setResultNote("type不能为空");
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
//			if ("1".equals(user.getIsapply())) {
//				res.setResultNote("达人申请正在审核中");
//				return res;
//			}
//			/*
//			 * if ("2".equals(user.getIsapply())) { res.setResultNote("你已经是达人了"); return
//			 * res; }
//			 */
//			CommunityMan cm = new CommunityMan();
//			if ("2".equals(user.getIsapply())) {
//				cm.setUid(req.getUid());
//				cm.setType(Integer.valueOf(req.getType()));
//				cm.setName(req.getUserlabel());
//				cm.setRealname(req.getRealname());
//				cm.setPhone(req.getPhone());
//				cm.setIdcard(req.getIdcard());
//				cm.setUserdesc(req.getUserDesc());
//				cm.setState(2);
//				communityManService.updateMan(cm);
//				res.setResult("0");
//				res.setResultNote("达人修改成功");
//
//			} else {
//
//				cm.setUid(req.getUid());
//				cm.setType(Integer.valueOf(req.getType()));
//				cm.setName(req.getUserlabel());
//				cm.setRealname(req.getRealname());
//				cm.setPhone(req.getPhone());
//				cm.setIdcard(req.getIdcard());
//				cm.setUserdesc(req.getUserDesc());
//				cm.setState(2);
//				cm.setAdtime(new Date());
//				user.setIsapply("2");
//				tuserService.updateUser(user);
//				communityManService.executeDeleteSql("delete from t_community_man where uid='" + req.getUid() + "'");
//				communityManService
//						.executeDeleteSql("delete from t_community_man_experience where uid='" + req.getUid() + "'");
//				communityManService.save(cm);
//				res.setResult("0");
//				res.setResultNote("达人申请提交成功");
//			}
//
//		} catch (Exception e) {
//			logger.error("请求处理异常：7905" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.15 添加达人经历
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec5(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("添加达人经历失败");
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
//			CommunityManExperience cm = new CommunityManExperience();
//			String id = IdGen.uuid();
//			cm.setId(id);
//			cm.setUid(req.getUid());
//			cm.setStarttime(req.getStartTime());
//			cm.setEndtime(req.getEndTime());
//			cm.setTitle(req.getTitle());
//			cm.setContent(req.getContent());
//			cm.setAdtime(new Date());
//			communityManExperienceService.insert(cm);
//			if (req.getFile() != null && req.getFile().length > 0) {
//				String[] arr = req.getFile();
//				int a = 1;
//				for (String s : arr) {
//					CommentImage ci = new CommentImage();
//					ci.setType("3");
//					ci.setCommentid(id);
//					ci.setImage(s);
//					ci.setSeq(a);
//					ci.setAdtime(new Date());
//					commentImageService.save(ci);
//					a++;
//				}
//			}
//			user.setDynamicnum(user.getDynamicnum()+1);
//			tuserService.updateUser(user);
//			res.setResult("0");
//			res.setResultNote("添加达人经历成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：7960" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.16 修改达人经历
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec6(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("修改达人经历失败");
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
//			CommunityManExperience cm = communityManExperienceService.get(req.getExperienceId());
//			if (!StringUtils.isBlank(req.getStartTime())) {
//				cm.setStarttime(req.getStartTime());
//			}
//			if (!StringUtils.isBlank(req.getEndTime())) {
//				cm.setEndtime(req.getEndTime());
//			}
//			if (!StringUtils.isBlank(req.getTitle())) {
//				cm.setTitle(req.getTitle());
//			}
//			if (!StringUtils.isBlank(req.getContent())) {
//				cm.setContent(req.getContent());
//			}
//			communityManExperienceService.save(cm);
//			commentImageService.executeDeleteSql(
//					"delete from t_comment_image where type=3 and commentid='" + req.getExperienceId() + "'");
//			if (req.getFile() != null && req.getFile().length > 0) {
//				String[] arr = req.getFile();
//				for (String s : arr) {
//					CommentImage ci = new CommentImage();
//					ci.setType("3");
//					ci.setCommentid(req.getExperienceId());
//					ci.setImage(s);
//					ci.setAdtime(new Date());
//					commentImageService.save(ci);
//				}
//			}
//			res.setResult("0");
//			res.setResultNote("修改达人经历成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：8018" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.17 删除达人经历
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec7(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("删除达人经历失败");
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
//			communityManExperienceService.executeDeleteSql(
//					"delete from t_community_man_experience where id='" + req.getExperienceId() + "'");
//			commentImageService.executeDeleteSql(
//					"delete from t_comment_image where type=3 and commentid='" + req.getExperienceId() + "'");
//			user.setDynamicnum(user.getDynamicnum()-1);
//			tuserService.updateUser(user);
//			res.setResult("0");
//			res.setResultNote("删除达人经历成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：8053" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.22 达人经历详情
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecED(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getActivityId())) {
//				res.setResultNote("达人经历ID不能为空");
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
//			CommunityManExperience cme = new CommunityManExperience();
//			cme.setUid(user.getId());
//			cme.setId(req.getActivityId());
//			CommunityManExperience a = communityManExperienceService.getInfo(cme);
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("activityId", a.getId());
//			map.put("activityName", a.getTitle());
//			map.put("activityDesc", a.getContent());
//			map.put("isAttention", a.getIsattention());
//			map.put("communityName", a.getCommunityname());
//			map.put("userid", a.getUid());
//			map.put("userIcon", StringUtils.isNotBlank(a.getUsericon()) && a.getUsericon().indexOf("http://") == -1
//							&& a.getUsericon().indexOf("https://") == -1 ? filePath + a.getUsericon() : a.getUsericon());
//			try {
//				UserRemarks ur = userRemarksService.gets(req.getUid(), a.getUid());
//				if (ur != null && ur.getRemarks() != null) {
//					map.put("userName", ur.getRemarks());
//				} else {
//					map.put("userName", a.getUsername());
//				}
//			} catch (Exception e) {
//				logger.error("请求处理异常：8509" );
//				e.printStackTrace();
//			}
//			//图片
//			CommentImage commentImage = new CommentImage();
//			commentImage.setType("3");
//			commentImage.setCommentid(a.getId());
//			List<CommentImage> imageList = commentImageService.findList(commentImage);
//			List<String> images = new ArrayList<String>();
//			if (null != imageList && imageList.size() > 0) {
//				for (CommentImage ci : imageList) {
//					images.add(StringUtils.isNotBlank(ci.getImage()) && ci.getImage().indexOf("http://") == -1
//							&& ci.getImage().indexOf("https://") == -1 ? filePath + ci.getImage() : ci.getImage());
//				}
//			}
//			map.put("activityImgurl", images);
//			map.put("zanNum", a.getZannum());
//			map.put("commentNum", a.getCommentnum());
//			map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getAdtime()));
//			DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "6", a.getId());
//			map.put("isZan", dz.getIszan());
//			// 获取评论
//			Page<Comment> page = new Page<Comment>(1, 10);
//			page.setOrderBy("a.zannum desc");
//			Comment c = new Comment();
//			c.setType("6");
//			c.setObjid(a.getId());
//			c.setState("0");
//			Page<Comment> pageInfo = commentService.findPage(page, c);
//			List<Comment> list = pageInfo.getList();
//			List<Map<String, Object>> commList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				for (Comment cc : list) {
//					Map<String, Object> map1 = new HashMap<String, Object>();
//					map1.put("commentId", cc.getId());
//					map1.put("commentUid", cc.getUid());
//					map1.put("commentIcon",
//							StringUtils.isNotBlank(cc.getCommenticon()) && cc.getCommenticon().indexOf("http://") == -1
//									&& cc.getCommenticon().indexOf("https://") == -1 ? filePath + cc.getCommenticon()
//											: cc.getCommenticon());
//					try {
//						UserRemarks ur = userRemarksService.gets(req.getUid(), cc.getUid());
//						if (ur != null && ur.getRemarks() != null) {
//							map1.put("commentName", ur.getRemarks());
//						} else {
//							map1.put("commentName", cc.getCommentname());
//						}
//					} catch (Exception e) {
//						logger.error("请求处理异常：8573" );
//						e.printStackTrace();
//					}
//					map1.put("commentContent", cc.getContent());
//					map1.put("commentTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(cc.getAdtime()));
//					map1.put("zanNum", cc.getZannum());
//					map1.put("secondNum", cc.getCommentnum());
//					DynamicZan dzz = dynamicZanService.isDynamicZan(req.getUid(), "2", cc.getId());
//					map1.put("isZan", dzz.getIszan());
//					commList.add(map1);
//				}
//			}
//			res.setObject(map);
//			res.setCommList(commList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：8623" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.18 获取达人信息
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec8(GetCommunityReq req) {
//		GetManDetailRes res = new GetManDetailRes();
//		res.setResultNote("当前未认证");
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
//			Tuser user1 = tuserService.get(req.getAuid());
//			if("0".equals(user1.getIsapply())){
//				return res;
//			}
//			res.setIsApply(user1.getIsapply());
//			CommunityMan cm = communityManService.findUniqueByProperty("uid", req.getAuid());
//			res.setType(cm.getType() + "");
//			res.setRealname(cm.getRealname());
//			res.setUserDesc(cm.getUserdesc());
//			res.setPhone(cm.getPhone());
//			res.setIdcard(cm.getIdcard());
//			res.setUserlabel(cm.getName());
//			UserAttention ua = userAttentionService.isattention(req.getUid(), "0", req.getAuid());
//			res.setIsAttention(ua.getIsattention());
//			CommunityManExperience cme = new CommunityManExperience();
//			cme.setUid(req.getAuid());
//			List<CommunityManExperience> list = communityManExperienceService.findList(cme);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (list != null && list.size() > 0) {
//				for (CommunityManExperience cc : list) {
//					Map<String, Object> map = new HashMap<String, Object>();
//					map.put("experienceId", cc.getId());
//					map.put("startTime", cc.getStarttime());
//					map.put("endTime", cc.getEndtime());
//					map.put("title", cc.getTitle());
//					map.put("content", cc.getContent());
//					map.put("zanNum", cc.getZannum());
//					map.put("secondNum", cc.getCommentnum());
//					CommentImage commentImage = new CommentImage();
//					commentImage.setCommentid(cc.getId());
//					commentImage.setType("3");
//					List<CommentImage> imageList = commentImageService.findList(commentImage);
//					List<String> images = new ArrayList<String>();
//					if (null != imageList && imageList.size() > 0) {
//						for (CommentImage ci : imageList) {
//							images.add(StringUtils.isNotBlank(ci.getImage()) && ci.getImage().indexOf("http://") == -1
//									&& ci.getImage().indexOf("https://") == -1 ? filePath + ci.getImage()
//											: ci.getImage());
//						}
//					}
//
//					// 获取评论
//					Comment c = new Comment();
//					c.setState("0");
//					c.setObjid(cc.getId());
//					List<Comment> commentlist = commentService.findList(c);
//					List<Map<String,Object>> commentl = Lists.newArrayList();
//					int i = 0;
//					for (Comment c2 : commentlist) {
//						Map<String, Object> map1 = new HashMap<String, Object>();
//						map1.put("commentId", c2.getId());
//						map1.put("commentUid", c2.getUid());
//						map1.put("commentIcon",
//								StringUtils.isNotBlank(c2.getCommenticon()) && c2.getCommenticon().indexOf("http://") == -1
//										&& c2.getCommenticon().indexOf("https://") == -1 ? filePath + c2.getCommenticon()
//												: c2.getCommenticon());
//						try {
//							UserRemarks ur = userRemarksService.gets(req.getUid(), c2.getUid());
//							if (ur != null && ur.getRemarks() != null) {
//								map1.put("commentName", ur.getRemarks());
//							} else {
//								map1.put("commentName", c2.getCommentname());
//							}
//						} catch (Exception e) {
//							logger.error("请求处理异常：7303" );
//							e.printStackTrace();
//						}
//						map1.put("commentContent", c2.getContent());
//						map1.put("commentTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(c2.getAdtime()));
//						map1.put("zanNum", c2.getZannum());
//						map1.put("secondNum", c2.getCommentnum());
//						DynamicZan dzz = dynamicZanService.isDynamicZan(req.getUid(), "2", c2.getId());
//						map1.put("isZan", dzz.getIszan());
//						commentl.add(map1);
//						if(i++>2){
//							break;
//						}
//					}
//					map.put("commentList", commentl);
//
//					map.put("imgurl", images);
//					dataList.add(map);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取达人信息成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：8124" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.19 发现动态/帮帮
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec9(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
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
//			String tt = "3";
//			if ("1".equals(req.getState())) {
//				tt = "5";
//			}
//			Banner b = bannerService.get(tt);
//			if (b != null && b.getId().length() > 0) {
//				res.setTopImgUrl(filePath + b.getImage());
//				res.setTopImgDetailUrl(filePath + b.getUrl());
//				res.setTopImgDetailUrlState(b.getStatus());
//			}
//			Page<Dynamic> page = new Page<Dynamic>(req.getNowPage(), req.getPageCount());
//			Dynamic dynamic = new Dynamic();
//			dynamic.setType(Integer.valueOf(req.getState()));//state 0动态, 1帮帮
//			dynamic.setState(Integer.valueOf(req.getType()));//type 0全部，1关注
//			dynamic.setFilePath(filePath);
//			dynamic.setUid(req.getUid());
//			if ("0".equals(req.getType())) {// 全部
//				dynamic.setCommunityid(req.getCommunityId());
//			}
//			//更新查看时间
//			String i = themeService.execSelectSqlString("select count(1) from t_user_dynamic_renew where uid='"+req.getUid()+"'");
//			if(null != req.getState()&&"1".equals(req.getState())){//帮帮
//				if(Integer.valueOf(i)==0)
//					themeService.executeInsertSql("insert into t_user_dynamic_renew (uid,bangtime) VALUES ('"+req.getUid()+"',NOW())");
//				else
//					themeService.executeUpdateSql("update t_user_dynamic_renew SET bangtime=NOW() WHERE uid = '"+req.getUid()+"'");
//			}else if(null != req.getState()&&"0".equals(req.getState())){//好友动态
//				if(Integer.valueOf(i)==0)
//					themeService.executeInsertSql("insert into t_user_dynamic_renew (uid,friendtime) VALUES ('"+req.getUid()+"',NOW())");
//				else
//					themeService.executeUpdateSql("update t_user_dynamic_renew SET friendtime=NOW() WHERE uid = '"+req.getUid()+"'");
//			}
//			Page<Dynamic> pageInfo = dynamicService.findPageNew(page, dynamic);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<Dynamic> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (Dynamic a : list) {
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("dynamicId", a.getId());
//						map.put("dynamicUid", a.getUid());
//						map.put("dynamicName", a.getDynamicname());
//						map.put("dynamicIcon", a.getDynamicicon());
//						map.put("dynamicContent", a.getContent());
//						map.put("dynamicAddress", a.getAddress());
//						map.put("userEffectNum", a.getUsereffectnum());
//						map.put("zanNum", a.getZannum());
//						map.put("commentNum", a.getCommentnum());
//						map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getAdtime()));
//						map.put("isZan", a.getIszan());
//						map.put("isAttention", a.getIsAttention());
//						map.put("iscang", a.getIscang());
//						map.put("communityName", a.getCommunityname());
//						if (a.getHtype() == 0) {// 图片动态
//							List<Object> list1 = commentImageService.executeSelectSql("SELECT concat('"+filePath+"',a.image) as image "
//									+ "FROM t_comment_image a WHERE A.type = '1' and a.commentid = '"+a.getId()+"'");
//							map.put("dynamicImgList", list1);
//						} else {// 视频动态
//							map.put("dynamicImg", a.getImage());
//							map.put("dynamicVideo", a.getVideourl() + "");
//						}
//						map.put("height", a.getHeight());
//						map.put("width", a.getWidth());
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：8244" );
//			e.printStackTrace();
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.191 发现首页显示动态
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecDynamic(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			Page<Dynamic> page = new Page<Dynamic>(req.getNowPage(), req.getPageCount());
//			Dynamic dynamic = new Dynamic();
//			dynamic.setType(0);
//			dynamic.setCommunityid(req.getCommunityId());
//			dynamic.setState(0);
//			dynamic.setFilePath(filePath);
//			dynamic.setUid(req.getUid());
////			dynamic.setDataScope(" and a.state=0");
//			Page<Dynamic> pageInfo = dynamicService.findPageNew(page, dynamic);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<Dynamic> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (Dynamic a : list) {
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("dynamicId", a.getId());
//						map.put("dynamicUid", a.getUid());
//						map.put("dynamicName", a.getDynamicname());
//						map.put("dynamicIcon", a.getDynamicicon());
//						map.put("dynamicContent", a.getContent());
//						map.put("dynamicAddress", a.getAddress());
//						map.put("userEffectNum", a.getUsereffectnum());
//						map.put("zanNum", a.getZannum());
//						map.put("commentNum", a.getCommentnum());
//						map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getAdtime()));
//						map.put("isZan", a.getIszan());
//						map.put("isAttention", a.getIsAttention());
//						map.put("iscang", a.getIscang());
//						map.put("communityName", a.getCommunityname());
//						if (a.getHtype() == 0) {// 图片动态
//							List<Object> list1 = commentImageService.executeSelectSql("SELECT concat('"+filePath+"',a.image) as image "
//									+ "FROM t_comment_image a WHERE A.type = '1' and a.commentid = '"+a.getId()+"'");
//							map.put("dynamicImgList", list1);
//						} else {// 视频动态
//							map.put("dynamicImg", a.getImage());
//							map.put("dynamicVideo", a.getVideourl() + "");
//						}
//						map.put("height", a.getHeight());
//						map.put("width", a.getWidth());
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：8335" );
//			e.printStackTrace();
//			e.printStackTrace();
//		}
//		return res;
//	}
//	/**
//	 * 2.191 发现首页显示动态(新)
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecList(FindListReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			Page<DynamicUnion> page = new Page<DynamicUnion>(req.getNowPage(), req.getPageCount());
//			DynamicUnion dynamic = new DynamicUnion();
//			dynamic.setType(req.getType());
//			dynamic.setFilePath(filePath);
//			dynamic.setUid(req.getUid());
//			if(!StringUtils.isBlank(req.getScope())){
//				dynamic.setCommunityid(req.getCommunityId());
//			}
//			Page<DynamicUnion> pageInfo = dynamicService.findUnionAllPageNew(page, dynamic);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<DynamicUnion> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (DynamicUnion a : list) {
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("dynamicId", a.getId());
//						map.put("dynamicUid", a.getUid());
//						map.put("dynamicType", a.getType());
//						map.put("dynamicName", a.getDynamicname());
//						map.put("dynamicIcon", a.getDynamicicon());
//						map.put("dynamicContent", a.getContent());
//						map.put("dynamicTitle", a.getTitle());
//						map.put("dynamicAddress", a.getAddress());
//						map.put("startTime", null!=a.getStarttime()?DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getStarttime()):"");
//						map.put("endTime", null!=a.getEndtime()?DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getEndtime()):"");
//						map.put("signTime", null!=a.getSigntime()?DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getSigntime()):"");
//						map.put("allNum", a.getAllnum());
//						map.put("nowNum", a.getNownum());
//						map.put("money", a.getMoney());
//						map.put("status", a.getStatus());
//						map.put("address", a.getAddress());
//						if(a.getType().equals("3")){
//							ActivityMember am = activityMemberService.isActivityMember(req.getUid(), a.getId());
//							map.put("issignup", am.getIssignup());
//						}else if(a.getType().equals("5")){
//							map.put("state", a.getState());
//						}
//						map.put("userEffectNum", a.getUsereffectnum());
//						map.put("zanNum", a.getZannum());//点赞数量，二手闲置时想要数量
//						map.put("commentNum", a.getCommentnum());
//						map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getAdtime()));
//						map.put("isZan", a.getIszan());
//						map.put("isAttention", a.getIsattention());
//						map.put("isCang", a.getIscang());
//						map.put("communityName", a.getCommunityname());
//						List<Object> list1 = commentImageService.executeSelectSql("SELECT concat('"+filePath+"',a.image) as image "
//								+ "FROM t_comment_image a WHERE a.commentid = '"+a.getId()+"'");
//						if (a.getHtype().equals("0")) {// 图片动态
//							map.put("dynamicImgList", list1);
//						} else {// 视频动态
//							map.put("dynamicImg", a.getImage());
//							map.put("dynamicVideo", a.getVideourl() + "");
//						}
//						map.put("height", a.getHeight());
//						map.put("width", a.getWidth());
//
//						// 获取评论
//						Comment c = new Comment();
//						c.setState("0");
//						c.setObjid(a.getId());
//						List<Comment> commentlist = commentService.findList(c);
//						List<Map<String,Object>> commentl = Lists.newArrayList();
//						int i = 0;
//						for (Comment cc : commentlist) {
//							Map<String, Object> map1 = new HashMap<String, Object>();
//							map1.put("commentId", cc.getId());
//							map1.put("commentUid", cc.getUid());
//							map1.put("commentIcon",
//									StringUtils.isNotBlank(cc.getCommenticon()) && cc.getCommenticon().indexOf("http://") == -1
//											&& cc.getCommenticon().indexOf("https://") == -1 ? filePath + cc.getCommenticon()
//													: cc.getCommenticon());
//							try {
//								UserRemarks ur = userRemarksService.gets(req.getUid(), cc.getUid());
//								if (ur != null && ur.getRemarks() != null) {
//									map1.put("commentName", ur.getRemarks());
//								} else {
//									map1.put("commentName", cc.getCommentname());
//								}
//							} catch (Exception e) {
//								logger.error("请求处理异常：7303" );
//								e.printStackTrace();
//							}
//							map1.put("commentContent", cc.getContent());
//							map1.put("commentTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(cc.getAdtime()));
//							map1.put("zanNum", cc.getZannum());
//							map1.put("secondNum", cc.getCommentnum());
//							DynamicZan dzz = dynamicZanService.isDynamicZan(req.getUid(), "2", cc.getId());
//							map1.put("isZan", dzz.getIszan());
//							commentl.add(map1);
//							if(i++>2){
//								break;
//							}
//						}
//						map.put("commentList", commentl);
//
//						dataList.add(map);
//					}
//				}
//				//更新查看时间
//				String i = themeService.execSelectSqlString("select count(1) from t_user_dynamic_renew where uid='"+req.getUid()+"'");
//				if(Integer.valueOf(i)==0)
//					themeService.executeInsertSql("insert into t_user_dynamic_renew (uid,bangtime,friendtime) VALUES ('"+req.getUid()+"',NOW(),NOW())");
//				else
//					themeService.executeUpdateSql("update t_user_dynamic_renew SET bangtime=NOW(),friendtime=NOW() WHERE uid = '"+req.getUid()+"'");
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：8335" );
//			e.printStackTrace();
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.21 发现活动
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec10(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
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
//			Banner b = bannerService.get("4");
//			if (b != null && b.getId().length() > 0) {
//				res.setTopImgUrl(filePath + b.getImage());
//				res.setTopImgDetailUrl(filePath + b.getUrl());
//				res.setTopImgDetailUrlState(b.getStatus());
//			}
//			Page<Activity> page = new Page<Activity>(req.getNowPage(), req.getPageCount());
//			Activity activity = new Activity();
//			activity.setCommunityid(req.getCommunityId());
//			// activity.setState("case WHEN a.signtime>NOW() then 1 WHEN a.signtime<NOW()
//			// and a.starttime>NOW() then 2 else 3 end ");
//			activity.setDataScope(" and a.endtime>now()");
//			Page<Activity> pageInfo = activityService.findPage(page, activity);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != pageInfo) {
//				List<Activity> list = pageInfo.getList();
//				if (null != list && list.size() > 0) {
//					for (Activity a : list) {
//						Map<String, Object> map = new HashMap<String, Object>();
//						CommentImage commentImage = new CommentImage();
//						commentImage.setType("2");
//						commentImage.setCommentid(a.getId());
//						List<CommentImage> imageList = commentImageService.findList(commentImage);
//						map.put("userid", a.getUid());
//						try {
//							UserRemarks ur = userRemarksService.gets(req.getUid(), a.getUid());
//							if (ur != null && ur.getRemarks() != null) {
//								map.put("userName", ur.getRemarks());
//							} else {
//								map.put("userName", a.getUsername());
//							}
//						} catch (Exception e) {
//							logger.error("请求处理异常：8396" );
//							e.printStackTrace();
//						}
//						map.put("userIcon",
//								StringUtils.isNotBlank(a.getUsericon()) && a.getUsericon().indexOf("http://") == -1
//										&& a.getUsericon().indexOf("https://") == -1 ? filePath + a.getUsericon()
//												: a.getUsericon());
//						map.put("userEffectNum", a.getUsereffectnum());
//						map.put("activityId", a.getId());
//						map.put("activityName", a.getName());
//						map.put("activityImg",
//								(imageList != null && imageList.size() > 0) ? filePath + imageList.get(0).getImage()
//										: "");
//						map.put("activityAddress", a.getAddress());
//						map.put("activityTime", a.getStarttime() == null ? ""
//								: DateFormatUtil.DEFAULT_ON_SECOND_FORMATS.format(a.getStarttime()));
//						map.put("activityAllnum", a.getAllnum());
//						map.put("activityNownum", a.getNownum());
//						map.put("activityMoney", a.getMoney());
//						map.put("communityName", a.getCommunityname());
//						map.put("state", a.getState());
//						if (a.getSigntime().getTime() > new Date().getTime()) {
//							map.put("activityState", "0");
//						} else if (a.getSigntime().getTime() < new Date().getTime()
//								&& a.getEndtime().getTime() > new Date().getTime()) {
//							map.put("activityState", "1");
//						} else {
//							map.put("activityState", "2");
//						}
//						map.put("zanNum", a.getZannum());
//						map.put("commentNum", a.getCommentnum());
//						map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getAdtime()));
//						DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "3", a.getId());
//						map.put("isZan", dz.getIszan());
//						UserAttention ua = userAttentionService.isattention(req.getUid(), "0", a.getUid());
//						map.put("isAttention", ua.getIsattention());
//						ActivityMember am = activityMemberService.isActivityMember(req.getUid(), a.getId());
//						map.put("issignup", am.getIssignup());
//						Collect coll = new Collect();
//						coll.setUid(req.getUid());
//						coll.setObjectid(a.getId());
//						coll.setType("1");
//						Collect collect = collectService.isCollect(coll);
//						map.put("iscang", collect.getUid());
//						dataList.add(map);
//					}
//				}
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//
//			//更新最后查看时间
//			String i = themeService.execSelectSqlString("select count(1) from t_user_dynamic_renew where uid='"+req.getUid()+"'");
//			if(Integer.valueOf(i)==0)
//				themeService.executeInsertSql("insert into t_user_dynamic_renew (uid,activitytime) VALUES ('"+req.getUid()+"',NOW())");
//			else
//				themeService.executeUpdateSql("update t_user_dynamic_renew SET activitytime=NOW() WHERE uid = '"+req.getUid()+"'");
//
//
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：8448" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.22 活动/闲置详情
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec11(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getActivityId())) {
//				res.setResultNote("活动ID不能为空");
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
//			Activity a = activityService.get(req.getActivityId());
//			Map<String, Object> map = new HashMap<String, Object>();
//			CommentImage commentImage = new CommentImage();
//			if(null == req.getType()){
//				commentImage.setType("2");
//			}else{
//				commentImage.setType(req.getType());
//			}
//			commentImage.setCommentid(a.getId());
//			List<CommentImage> imageList = commentImageService.findList(commentImage);
//
//			map.put("activityId", a.getId());
//			map.put("activityName", a.getName());
//			map.put("activityDesc", a.getActdesc());
//
//			map.put("activityAddress", a.getAddress());
//			map.put("activityPhone", a.getPhone());
//
//			map.put("communityName", a.getCommunityname());
//			map.put("userIcon", StringUtils.isNotBlank(a.getUsericon()) && a.getUsericon().indexOf("http://") == -1
//								&& a.getUsericon().indexOf("https://") == -1 ? filePath + a.getUsericon(): a.getUsericon());
//			map.put("userid", a.getUid());
//			try {
//				UserRemarks ur = userRemarksService.gets(req.getUid(), a.getUid());
//				if (ur != null && ur.getRemarks() != null) {
//					map.put("userName", ur.getRemarks());
//				} else {
//					map.put("userName", a.getUsername());
//				}
//			} catch (Exception e) {
//				logger.error("请求处理异常：8509" );
//				e.printStackTrace();
//			}
//			map.put("userName", a.getUsername());
//			map.put("activityAllnum", a.getAllnum());
//			map.put("activityNownum", a.getNownum());
//			map.put("activityMoney", a.getMoney());
//			if(null==a.getType()||"3".equals(a.getType())){
//				map.put("activityStarttime",
//						a.getStarttime() == null ? "" : DateFormatUtil.DEFAULT_ON_SECOND_FORMATS.format(a.getStarttime()));
//				map.put("activityEndtime",
//						a.getEndtime() == null ? "" : DateFormatUtil.DEFAULT_ON_SECOND_FORMATS.format(a.getEndtime()));
//				map.put("activitySignEndtime",
//						a.getSigntime() == null ? "" : DateFormatUtil.DEFAULT_ON_SECOND_FORMATS.format(a.getSigntime()));
//
//				if (a.getSigntime().getTime() > new Date().getTime()) {
//					map.put("activityState", "0");
//				} else if (a.getSigntime().getTime() < new Date().getTime()
//						&& a.getEndtime().getTime() > new Date().getTime()) {
//					map.put("activityState", "1");
//				} else {
//					map.put("activityState", "2");
//				}
//			}else{
//				map.put("activityState", a.getState());
//			}
//			List<String> images = new ArrayList<String>();
//			if (null != imageList && imageList.size() > 0) {
//				for (CommentImage ci : imageList) {
//					images.add(StringUtils.isNotBlank(ci.getImage()) && ci.getImage().indexOf("http://") == -1
//							&& ci.getImage().indexOf("https://") == -1 ? filePath + ci.getImage() : ci.getImage());
//				}
//			}
//			map.put("status", a.getStatus());
//			map.put("activityImgurl", images);
//			map.put("zanNum", a.getZannum());
//			map.put("commentNum", a.getCommentnum());
//			map.put("time", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(a.getAdtime()));
//			DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "3", a.getId());
//			map.put("isZan", dz.getIszan());
//			UserAttention ua = userAttentionService.isattention(req.getUid(), "0", a.getUid());
//			map.put("isAttention", ua.getIsattention());
//			ActivityMember am = activityMemberService.isActivityMember(req.getUid(), a.getId());
//			map.put("issignup", am.getIssignup());
//			Collect coll = new Collect();
//			coll.setUid(req.getUid());
//			coll.setObjectid(a.getId());
//			coll.setType("1");
//			Collect collect = collectService.isCollect(coll);
//			map.put("iscang", collect.getUid());
//			// 获取评论
//			Page<Comment> page = new Page<Comment>(1, 10);
//			page.setOrderBy("a.zannum desc");
//			Comment c = new Comment();
//			c.setType("3");
//			c.setObjid(a.getId());
//			c.setState("0");
//			Page<Comment> pageInfo = commentService.findPage(page, c);
//			List<Comment> list = pageInfo.getList();
//			List<Map<String, Object>> commList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				for (Comment cc : list) {
//					Map<String, Object> map1 = new HashMap<String, Object>();
//					map1.put("commentId", cc.getId());
//					map1.put("commentUid", cc.getUid());
//					map1.put("commentIcon",
//							StringUtils.isNotBlank(cc.getCommenticon()) && cc.getCommenticon().indexOf("http://") == -1
//									&& cc.getCommenticon().indexOf("https://") == -1 ? filePath + cc.getCommenticon()
//											: cc.getCommenticon());
//					try {
//						UserRemarks ur = userRemarksService.gets(req.getUid(), cc.getUid());
//						if (ur != null && ur.getRemarks() != null) {
//							map1.put("commentName", ur.getRemarks());
//						} else {
//							map1.put("commentName", cc.getCommentname());
//						}
//					} catch (Exception e) {
//						logger.error("请求处理异常：8573" );
//						e.printStackTrace();
//					}
//					map1.put("commentContent", cc.getContent());
//					map1.put("commentTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(cc.getAdtime()));
//					map1.put("zanNum", cc.getZannum());
//					map1.put("secondNum", cc.getCommentnum());
//					DynamicZan dzz = dynamicZanService.isDynamicZan(req.getUid(), "2", cc.getId());
//					map1.put("isZan", dzz.getIszan());
//					commList.add(map1);
//				}
//			}
//			// 获取报名信息
//			ActivityMember amm = new ActivityMember();
//			amm.setActivityid(a.getId());
//			List<ActivityMember> list1 = activityMemberService.findList(amm);
//			List<Map<String, Object>> signList = new ArrayList<Map<String, Object>>();
//			if (list1 != null && list1.size() > 0) {
//				for (ActivityMember aa : list1) {
//					Map<String, Object> map1 = new HashMap<String, Object>();
//					map1.put("userId", aa.getUid());
//					map1.put("userImg",
//							StringUtils.isNotBlank(aa.getUserImg()) && aa.getUserImg().indexOf("http://") == -1
//									&& aa.getUserImg().indexOf("https://") == -1 ? filePath + aa.getUserImg()
//											: aa.getUserImg());
//					try {
//						UserRemarks ur = userRemarksService.gets(req.getUid(), aa.getUid());
//						if (ur != null && ur.getRemarks() != null) {
//							map1.put("userName", ur.getRemarks());
//						} else {
//							map1.put("userName", aa.getName());
//						}
//					} catch (Exception e) {
//						logger.error("请求处理异常：8606" );
//						e.printStackTrace();
//					}
//					map1.put("userSex", aa.getUserSex());
//					map1.put("userAge", StringUtils.isBlank(aa.getBirthday()) ? ""
//							: Year.getAge(DateTimeUtil.parse(aa.getBirthday())) + "");
//					map1.put("userPhone", aa.getPhone());
//					map1.put("signNum", aa.getCount());
//					signList.add(map1);
//				}
//			}
//			res.setObject(map);
//			res.setCommList(commList);
//			res.setSignList(signList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：8623" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.23 活动报名
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec12(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("报名失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getActivityId())) {
//				res.setResultNote("活动ID不能为空");
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
//			ActivityMember am = activityMemberService.isActivityMember(req.getUid(), req.getActivityId());
//			if ("1".equals(am.getIssignup())) {
//				res.setResultNote("你已经报过名了");
//				return res;
//			}
//			Activity a = activityService.get(req.getActivityId());
//			if (a.getNownum() + req.getCount() > a.getAllnum()) {
//				res.setResultNote("报名人数达到上限");
//				return res;
//			}
//			a.setNownum(a.getNownum() + req.getCount());
//			activityService.save(a);
//			ActivityMember amm = new ActivityMember();
//			amm.setUid(req.getUid());
//			amm.setActivityid(req.getActivityId());
//			amm.setName(req.getName());
//			amm.setPhone(req.getPhone());
//			amm.setCount(req.getCount());
//			amm.setAdtime(new Date());
//			activityMemberService.save(amm);
//			res.setResult("0");
//			res.setResultNote("报名成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：8679" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.25 获取达人标签
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec24(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取达人标签失败");
//		try {
//			List<Map<String, String>> labelList1 = new ArrayList<Map<String, String>>();
//			List<Map<String, String>> labelList2 = new ArrayList<Map<String, String>>();
//			List<Map<String, String>> labelList3 = new ArrayList<Map<String, String>>();
//			CommunityManLabel cm = new CommunityManLabel();
//			List<CommunityManLabel> list = communityManLabelService.findList(cm);
//			if (list != null && list.size() > 0) {
//				for (CommunityManLabel cml : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("labelId", cml.getId());
//					map.put("labelName", cml.getName());
//					if ("0".equals(cml.getMid())) {
//						map.put("mid", cml.getMid());
//						labelList1.add(map);
//					} else if ("1".equals(cml.getMid())) {
//						labelList2.add(map);
//						map.put("mid", cml.getMid());
//					} else {
//						labelList3.add(map);
//						map.put("mid", cml.getMid());
//					}
//				}
//			}
//			res.setLabelList1(labelList1);
//			res.setLabelList2(labelList2);
//			res.setLabelList3(labelList3);
//			res.setResult("0");
//			res.setResultNote("获取达人标签成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：8724" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.26 收藏
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec25(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("收藏失败");
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
//			Collect coll = new Collect();
//			coll.setUid(req.getUid());
//			coll.setObjectid(req.getObjid());
//			coll.setType(req.getType());
//			Collect collect = collectService.isCollect(coll);
//			if ("0".equals(collect.getUid())) {// 未收藏
//				coll.setAdtime(new Date());
//				collectService.save(coll);
//				res.setResult("0");
//				res.setResultNote("收藏成功");
//			} else {
//				collectService.executeDeleteSql("delete from t_collect where uid='" + req.getUid() + "' and objectid='"
//						+ req.getObjid() + "' and type=" + req.getType());
//				res.setResult("0");
//				res.setResultNote("取消收藏成功");
//			}
//
//		} catch (Exception e) {
//			logger.error("请求处理异常：8771" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.27 评论删除
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec26(GetCommunityReq req) {
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
//				if (!c.getUid().equals(req.getUid())) {
//					res.setResultNote("只能删除自己的评论");
//					return res;
//				} else {
//					if ("0".equals(c.getState())) {// 一级评论
//						// 删除下面二级评论的消息
//						commentService.executeDeleteSql(
//								"delete from t_msg where htype=2 and url in (SELECT id from  t_comment where  pid='"
//										+ c.getId() + "')");
//						// 删除一级评论的消息
//						commentService.executeDeleteSql("delete from t_msg where htype=2 and url='" + c.getId() + "'");
//						// 删除下面的二级评论
//						commentService
//								.executeDeleteSql("delete from t_comment where state=1 and pid='" + c.getId() + "'");
//						String sql = "";
//						if ("1".equals(c.getType())||"0".equals(c.getType())) {// 动态帮帮
//							sql = "update t_dynamic set commentnum=commentnum-1 where id='" + c.getObjid() + "'";
//							commentService.executeUpdateSql(sql);
//						} else if ("2".equals(c.getType())) {// 订单评论
//
//						} else if ("3".equals(c.getType())||"5".equals(c.getType())) {// 活动评论
//							sql = "update t_activity set commentnum=commentnum-1 where id='" + c.getObjid() + "'";
//							commentService.executeUpdateSql(sql);
//						} else if ("4".equals(c.getType())) {// 话题评论
//							sql = "update t_theme set commentnum=commentnum-1 where id='" + c.getObjid() + "'";
//							commentService.executeUpdateSql(sql);
//						} else if ("6".equals(c.getType())) {// 达人评论
//							sql = "update t_community_man_experience set commentnum=commentnum-1 where id='" + c.getObjid() + "'";
//							commentService.executeUpdateSql(sql);
//						}
//					} else {// 二级评论
//							// 删除二级评论的消息
//						commentService.executeDeleteSql("delete from t_msg where htype=2 and url='" + c.getId() + "'");
//						String sql = "update t_comment set commentnum=commentnum-1 where id='" + c.getPid() + "'";
//						commentService.executeUpdateSql(sql);
//					}
//					commentService.delete(c);
//				}
//			}
//			res.setResult("0");
//			res.setResultNote("删除成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：8441" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.28 点赞消息列表
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec4(GetMessageReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
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
//			Msg m = new Msg();
//			m.setType("1");
//			m.setHtype("3");
//			m.setUid(req.getUid());
//			Page<Msg> page = new Page<Msg>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			Page<Msg> pageList = msgService.findPage(page, m);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			List<Msg> list = pageList.getList();
//			if (null != list && list.size() > 0) {
//				for (Msg msg : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("messageId", msg.getId());
//					map.put("messageTitle", msg.getTitle());
//					map.put("messageContent", msg.getContent());
//					map.put("messageTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(msg.getAdtime()));
//					map.put("userId", msg.getUserid());
//					map.put("userIcon",
//							StringUtils.isNotBlank(msg.getUsericon()) && msg.getUsericon().indexOf("http://") == -1
//									&& msg.getUsericon().indexOf("https://") == -1 ? filePath + msg.getUsericon()
//											: msg.getUsericon());
//					map.put("objid", msg.getObjid());
//					if ("1".equals(msg.getDtype())) {// 动态帮帮
//						map.put("type", "1");
//						Dynamic d = dynamicService.get(msg.getObjid());
//						if(null == d){
//							continue;
//						}
//						map.put("state", d.getState() + "");
//					} else if ("3".equals(msg.getDtype())) {// 活动
//						map.put("type", "2");
//						map.put("state", "0");
//					} else if ("5".equals(msg.getDtype())) {// 闲置
//						map.put("type", "4");
//						map.put("state", "0");
//					} else if ("6".equals(msg.getDtype())) {// 达人
//						map.put("type", "5");
//						map.put("state", "0");
//					} else {// 话题
//						map.put("type", "3");
//						map.put("state", "0");
//					}
//					int a = msg.getStatus().indexOf(req.getUid());
//					if (a > 0) {
//						map.put("isread", "1");
//					} else {
//						map.put("isread", "0");
//					}
//					dataList.add(map);
//				}
//			}
//			String sql = "update t_msg set status=ifnull(CONCAT(status,'," + req.getUid() + "'),'," + req.getUid()
//					+ "')" + "WHERE type=1 and htype=3 and FIND_IN_SET('" + req.getUid() + "',uid) AND !FIND_IN_SET('"
//					+ req.getUid() + "',status)";
//			msgService.executeUpdateSql(sql);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//			res.setDataList(dataList);
//		} catch (Exception e) {
//			logger.error("请求处理异常：8919" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.29 获取一级评论详情
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec5(GetMessageReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		try {
//			Comment cc = commentService.get(req.getCommentId());
//			Map<String, Object> map1 = new HashMap<String, Object>();
//			map1.put("commentId", cc.getId());
//			map1.put("commentUid", cc.getUid());
//			map1.put("commentIcon",
//					StringUtils.isNotBlank(cc.getCommenticon()) && cc.getCommenticon().indexOf("http://") == -1
//							&& cc.getCommenticon().indexOf("https://") == -1 ? filePath + cc.getCommenticon()
//									: cc.getCommenticon());
//			try {
//				UserRemarks ur = userRemarksService.gets(req.getUid(), cc.getUid());
//				if (ur != null && ur.getRemarks() != null) {
//					map1.put("commentName", ur.getRemarks());
//				} else {
//					map1.put("commentName", cc.getCommentname());
//				}
//			} catch (Exception e) {
//				logger.error("请求处理异常：8951" );
//				e.printStackTrace();
//			}
//			map1.put("commentContent", cc.getContent());
//			map1.put("commentTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(cc.getAdtime()));
//			map1.put("zanNum", cc.getZannum());
//			map1.put("secondNum", cc.getCommentnum());
//			DynamicZan dzz = dynamicZanService.isDynamicZan(req.getUid(), cc.getType(), cc.getId());
//			map1.put("isZan", dzz.getIszan());
//			res.setObject(map1);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：8964" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.30 获取话题详情
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec6(GetMessageReq req,HttpServletRequest request) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		try {
//			if (!StringUtils.isBlank(req.getThemeId())) {
//				Theme theme = themeService.get(req.getThemeId());
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("themeId", theme.getId());
//				map.put("themeTitle", theme.getTitle());
//				map.put("themeContent", theme.getContent());
//				map.put("themeDetailUrl", filePath + theme.getUrl());
//				map.put("themeImage", filePath + theme.getImage());
//				map.put("themeTime", DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(theme.getAdtime()));
//
//				map.put("commentNum", theme.getCommentnum() + "");
//				DynamicZan dz = dynamicZanService.isDynamicZan(req.getUid(), "4", theme.getId());
//				map.put("isZan", dz.getIszan());
//				if(csc.validateVersion(request, "1.5.0")){//版本号为1.5.0之后的版本
//					if(theme.getZannum()==0&&theme.getOpposenum()==0){
//						map.put("zanNum", "50%");
//						map.put("opposeNum", "50%");
//					}else{
//						if(theme.getZannum()==0){
//							map.put("zanNum", "0%");
//						}else{
//							map.put("zanNum", Math.rint(Double.valueOf(theme.getZannum())/(theme.getZannum()+theme.getOpposenum())*100) + "%");
//						}
//						if(theme.getOpposenum()==0){
//							map.put("opposeNum", "0%");
//						}else{
//							map.put("opposeNum", 100-Math.rint(Double.valueOf(theme.getZannum())/(theme.getZannum()+theme.getOpposenum())*100) + "%");
//						}
//					}
//					map.put("zanViews", theme.getZanviews());
//					map.put("opposeViews", theme.getOpposeviews());
//					dz = dynamicZanService.isDynamicFlag(req.getUid(), "4", theme.getId());
//					if(null==dz)
//						map.put("flag", "");
//					else
//						map.put("flag", dz.getFlag());//1为正方，0为反方
//				}else{
//					map.put("zanNum", theme.getZannum() + "");
//				}
//				res.setObject(map);
//				res.setResult("0");
//				res.setResultNote("获取成功");
//			} else {
//				res.setResultNote("话题不可为空");
//				return res;
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：8969" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 2.31 获取发现是否有更新
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec7(GetMessageReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			//话题
//			Map<String,Object> renew = dynamicService.execSelectSqlEntityObjMap("SELECT "
//					+ "(SELECT count(a.id) FROM t_dynamic a WHERE a.type='0' and a.state='0' and a.adtime > IFNULL(r.dynamictime,'2018-10-01')) as 'dynamic', "//所有动态
//					+ "(SELECT count(a.id) FROM t_activity a WHERE a.adtime > IFNULL(r.activitytime,'2018-10-01')) as 'activity', "//活动
//					+ "(SELECT count(a.id) FROM t_dynamic a WHERE a.type='1' and a.adtime > IFNULL(r.bangtime,'2018-10-01')) as 'bang', "//帮邦
//					+ "(SELECT count(a.id) FROM t_theme a WHERE a.communityid = u.communityid and a.adtime > IFNULL(r.themetime,'2018-10-01')) as 'theme', "//话题
//					+ "(SELECT count(a.id) FROM t_msg a WHERE type=1 AND FIND_IN_SET(u.id,a.uid) AND !FIND_IN_SET(u.id,a.status)) AS 'msg',"//消息
//					+ "(SELECT count(a.id) FROM t_dynamic a,t_user_attention t WHERE a.uid = t.auid and t.uid = u.id AND a.type='0' and a.state='0' "
//					+ "and a.adtime > IFNULL(r.dynamictime,'2018-10-01')) as 'friend' "//好友动态
//					+ "FROM t_user u LEFT JOIN (SELECT a.uid as uid,MAX(a.dynamictime) as 'dynamictime',MAX(a.bangtime) as 'bangtime',MAX(a.activitytime) as 'activitytime', "
//					+ "MAX(a.themetime) as 'themetime',MAX(a.friendtime) as 'friendtime',MAX(a.msgtime) as 'msgtime' "
//					+ "from t_user_dynamic_renew a where a.uid='"+req.getUid()+"' GROUP BY a.uid) r ON u.id = r.uid where u.id = '"+req.getUid()+"'");
//			res.setResult("0");
//			res.setResultNote("获取成功");
//			res.setObject(renew);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.1 获取可领取优惠券
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec13(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
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
//			Coupon c = new Coupon();
//			c.setCommunityid(user.getCommunityid());
//			c.setDataScope(
//					"and CURDATE()<=a.days and couponType !='1' and (SELECT COUNT(1) from t_user_coupon u where u.couponid=a.id and u.uid='"
//							+ req.getUid() + "')=0");
//			List<Coupon> list = couponService.findList(c);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (list != null && list.size() > 0) {
//				for (Coupon cc : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("securitiesid", cc.getId());
//					map.put("communityId", cc.getCommunityid());
//					map.put("communityName", cc.getCommunityname());
//					map.put("securitiesMoney", cc.getAllmoney() + "");
//					map.put("securitiesType", cc.getType());
//					map.put("securitiesName", cc.getName());
//					map.put("securitiesImg", filePath + cc.getImage());
//					map.put("securitiesPrice", cc.getAmount() + "");
//					map.put("securitiesEndTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(cc.getDays()));
//					dataList.add(map);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：9055" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.2 领取优惠券
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec14(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("领取优惠券失败");
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
//			if (req.getSecuritiesid() != null && req.getSecuritiesid().length > 0) {
//				//添加用户指定的天数
//				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//				for (String sid : req.getSecuritiesid()) {
//					UserCoupon uc = new UserCoupon();
//					uc.setUid(req.getUid());
//					uc.setCouponid(sid);
//					List<UserCoupon> list = userCouponService.findList(uc);
//					if (list != null && list.size() > 0) {
//						res.setResultNote("不能重复领取");
//						return res;
//					}
//					Coupon c = couponService.get(sid);
//					uc.setCommunityid(c.getCommunityid());
//					uc.setCommunityname(c.getCommunityname());
//					uc.setAllmoney(c.getAllmoney());
//					uc.setAmount(c.getAmount());
//					uc.setType(c.getType());
//					/*uc.setCategoryid(c.getCategoryid());*/
//					String startDays = DateTimeUtil.addDate(new Date(), StringUtils.isBlank(c.getStartCouponDay())?0:Integer.valueOf(c.getStartCouponDay()));
//					uc.setStartdate(sf.parse(startDays));
//					uc.setEnddate(c.getDays());
//					uc.setStatus("0");
//					uc.setAdtime(new Date());
//					userCouponService.save(uc);
//					res.setResult("0");
//					res.setResultNote("领取优惠券成功");
//				}
//			} else {
//				res.setResult("1");
//				res.setResultNote("优惠券id不能为空");
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：9116" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.3 服务首页
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec15(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取服务首页失败");
//		try {
//
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//			//TODO 本处不再判断用户是否登录
//			if (StringUtils.isNotBlank(req.getUid())) {
//				Tuser user = tuserService.get(req.getUid());
//				if (null == user) {
//					res.setResultNote("用户不存在");
//					return res;
//				} else if (!"0".equals(user.getStatus())) {
//					res.setResultNote("用户被禁用");
//					return res;
//				}
//			}else{
//				req.setUid("");
//			}
//
//			//访客登记 一天一次
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			UserVisitor uv=new UserVisitor();
//				uv.setAdtime( formatter.format(new Date()));
//				uv.setUid(req.getUid());
//				uv.setCommunityId(req.getCommunityId());
//			List<UserVisitor>userVisitor=userVisitorService.selectUserVisitorLog(uv);
//			if(userVisitor==null || userVisitor.size()==0){
//				uv.setType("1");
//				userVisitorService.insertUserVisitor(uv);
//			}
//			// 获取轮播
//			BannerServices bs = new BannerServices();
//			bs.setType(1);
//			// TODO 按社区获取服务banner
//			bs.setCommunityid1(req.getCommunityId());
//			List<BannerServices> list0 = bannerServiceService.findListForCommunity(bs);
////			List<BannerServices> list0 = bannerServiceService.findList(bs);
//			List<Map<String, String>> bannerList = new ArrayList<Map<String, String>>();
//			if (list0 != null && list0.size() > 0) {
//				for (BannerServices bss : list0) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("topImgUrl", filePath + bss.getImage());
//					map.put("topImgDetailUrlState", bss.getStatus());
//					if("3".equals(bss.getUsed())){
//						map.put("topImgDetailUrl", filePath + bss.getUrl()+"&communityId="+req.getCommunityId()+"&uid="+req.getUid());
//					}else if("0".equals(bss.getUsed()))
//						map.put("topImgDetailUrl", filePath + bss.getUrl());
//					else
//						map.put("topImgDetailUrl", bss.getUrl());
//					map.put("usedType", bss.getUsed());
//					bannerList.add(map);
//				}
//			}
//			res.setBannerList(bannerList);
//			res.setProportion(list0.get(0).getRemarks());
//			// 获取优选分类
//			Optimization o = new Optimization();
//			List<Optimization> list = optimizationService.findList(o);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (list != null && list.size() > 0) {
//				for (Optimization op : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("optimizationId", op.getId());
//					map.put("optimizationName", op.getName());
//					map.put("optimizationImg", filePath + op.getImage());
//					map.put("optimizationImgs", filePath + op.getImages());
//					map.put("optimizationDesc", op.getContent());
//					dataList.add(map);
//				}
//			}
//
//			// 社区优惠卷信息展示
//			List<Coupon> couponList = couponService.selectCommunityidCoupon(req.getCommunityId(),req.getUid());
//			List<Map<String, String>> cList = new ArrayList<Map<String, String>>();
//			if (null != couponList && couponList.size() > 0) {
//				for (Coupon coupon : couponList) {
//					Map<String, String> map = new HashMap<String, String>();
//					DecimalFormat decimalFormat = new DecimalFormat("####.##");
//					String allmoney = decimalFormat.format(coupon.getAllmoney());
//					String amount = decimalFormat.format(coupon.getAmount());
//					map.put("allmoney", allmoney);
//					map.put("amount", amount);
//					map.put("type", coupon.getType());
//					cList.add(map);
//				}
//			}
//			res.setCouponList(cList);
//			// 购物车的商品数量
//			List<Object> userCartNum = userCartService.executeSelectSql(
//					"SELECT IFNULL(SUM(if(count>0,count,0)),0) FROM t_user_cart t, t_goods_community gc, t_goods g, t_user u"
//					+ " WHERE gc.goodsid = t.goodsid AND t.goodsid = g.id AND gc.communityid = u.communityid AND u.id = t.uid"
//					+ " AND t.del_flag = '0' AND t.uid = '" + req.getUid() + "'");
////					+ " AND gc.shelves = 0 AND g.state = 0 AND t.del_flag = '0' AND t.uid = '" + req.getUid() + "'");
//			if (userCartNum.get(0) != null) {
//				res.setUsercartSum(StringUtils.isBlank(userCartNum.get(0).toString()) ? "0" : userCartNum.get(0).toString());
//			} else {
//				res.setUsercartSum("0");
//			}
//
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取服务首页成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：9214" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.4 获取店铺详情评价
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec16(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取店铺详情评价失败");
//		try {
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getType())) {
//				res.setResultNote("type不能为空");
//				return res;
//			}
//			//TODO 本处不再判断用户是否登录
//			if (StringUtils.isNotBlank(req.getUid())) {
//				Tuser user = tuserService.get(req.getUid());
//				if (null == user) {
//					res.setResultNote("用户不存在");
//					return res;
//				} else if (!"0".equals(user.getStatus())) {
//					res.setResultNote("用户被禁用");
//					return res;
//				}
//			}
//			// 获取店铺
//			Community c = communityService.get(req.getCommunityId());
//			Map<String, String> map = new HashMap<String, String>();
//			if ("0".equals(req.getType())) {// 新鲜果蔬
//				map.put("shopName", c.getShopname1());
//				map.put("shopTime", c.getShoptime1() + "~" + c.getShoptime11());
//				map.put("shopPhone", c.getShopphone1());
//				String sql = "select ROUND(ifnull(avg(a.star),0),1) from t_comment a left join t_user_order o on o.ordernum = a.objid "
//						+ "where a.type=2 and o.ordertype=0 and o.communityid='" + req.getCommunityId() + "'";
//				List<Object> score = communityService.executeSelectSql(sql);
//				map.put("shopStar", score.get(0).toString());
//			} else if ("1".equals(req.getType())) {// 洗衣洗鞋
//				map.put("shopName", c.getShopname2());
//				map.put("shopTime", c.getShoptime2() + "~" + c.getShoptime22());
//				map.put("shopPhone", c.getShopphone2());
//				String sql = "select ROUND(ifnull(avg(a.star),0),1) from t_comment a left join t_user_order o on o.ordernum = a.objid "
//						+ "where a.type=2 and o.ordertype=1 and o.communityid='" + req.getCommunityId() + "'";
//				List<Object> score = communityService.executeSelectSql(sql);
//				map.put("shopStar", score.get(0).toString());
//			} else {// 超市便利
//				map.put("shopName", c.getShopname3());
//				map.put("shopTime", c.getShoptime3() + "~" + c.getShoptime33());
//				map.put("shopPhone", c.getShopphone3());
//				String sql = "select ROUND(ifnull(avg(a.star),0),1) from t_comment a left join t_user_order o on o.ordernum = a.objid "
//						+ "where a.type=2 and o.ordertype=2 and o.communityid='" + req.getCommunityId() + "'";
//				List<Object> score = communityService.executeSelectSql(sql);
//				map.put("shopStar", score.get(0).toString());
//			}
//			map.put("communityAddress", c.getAddress());
//			// 获取评论
//			Page<Comment> page = new Page<Comment>(req.getNowPage(), req.getPageCount());
//			page.setOrderBy("a.adtime desc");
//			Comment ccc = new Comment();
//			ccc.setType("2");
//			ccc.setState("0");
//			ccc.setHtype(req.getType());
//			ccc.setCommunityid(req.getCommunityId());
//			Page<Comment> pageInfo = commentService.findPage(page, ccc);
//			List<Comment> list = pageInfo.getList();
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				for (Comment cc : list) {
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
//
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
//				res.setTotalPage(pageInfo.getTotalPage());
//			}
//			res.setDataList(dataList);
//			res.setObject(map);
//			res.setResult("0");
//			res.setResultNote("获取店铺详情评价成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：9349" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.5 新鲜果蔬/洗衣洗鞋/超市便利
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec17(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//			// 获取轮播
//			BannerServices bs = new BannerServices();
//			Category c = new Category();
//			c.setCommunityId(req.getCommunityId());
//			c.setStatus("0");
//			if ("0".equals(req.getType())) {// 新鲜果蔬
//				bs.setType(2);
//				c.setHtype("2");
//			} else if ("1".equals(req.getType())) {// 洗衣洗鞋
//				bs.setType(3);
//				c.setHtype("1");
//			} else {// 超市便利
//				bs.setType(4);
//				c.setHtype("0");
//			}
//			List<BannerServices> list0 = bannerServiceService.findList(bs);
//			List<Map<String, String>> bannerList = new ArrayList<Map<String, String>>();
//			if (list0 != null && list0.size() > 0) {
//				for (BannerServices bss : list0) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("topImgUrl", filePath + bss.getImage());
//					map.put("topImgDetailUrlState", bss.getStatus());
//					if("3".equals(bss.getUsed())){
//						map.put("topImgDetailUrl", filePath + bss.getUrl()+"&communityId="+req.getCommunityId()+"&uid="+req.getUid());
//					}else if("0".equals(bss.getUsed()))
//						map.put("topImgDetailUrl", filePath + bss.getUrl());
//					else
//						map.put("topImgDetailUrl", bss.getUrl());
//					map.put("jumpType", bss.getUsed());
//					bannerList.add(map);
//				}
//			}
//			res.setBannerList(bannerList);
//			res.setProportion(list0.get(0).getRemarks());
//			// 获取分类
//			c.setType("1");
//			List<Category> list = categoryService.findList(c);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (list != null && list.size() > 0) {
//				for (Category cc : list) {
//					Map<String, Object> map = new HashMap<String, Object>();
//					map.put("firstCategoryId", cc.getId());
//					map.put("firstCategoryName", cc.getName());
//					if ("1".equals(req.getType())) {// 洗衣洗鞋
//						Category cs = new Category();
//						cs.setHtype("1");
//						cs.setStatus("0");
//						cs.setType("2");
//						cs.setParent(cc);
//						List<Category> list2 = categoryService.findList(cs);
//						List<Map<String, Object>> dataList1 = new ArrayList<Map<String, Object>>();
//						if (list2 != null && list2.size() > 0) {
//							for (Category c2 : list2) {
//								Map<String, Object> map1 = new HashMap<String, Object>();
//								map1.put("secondCategoryId", c2.getId());
//								map1.put("secondCategoryName", c2.getName());
//								dataList1.add(map1);
//							}
//							map.put("secondList", dataList1);
//						} else {
//							continue;
//						}
//					} else {
//
//					}
//					dataList.add(map);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：9436" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.51  服务页图标
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecSPI(GetServicePageIcon req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		if(StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区id为空");
//			return res;
//		}
//		try {
//			Icon icon = new Icon();
//			icon.setIconState("0");
//			icon.setCommunityId(req.getCommunityId());
//            List<Icon> list=iconService.findIconAndCategoryList(icon);
//            List<Map<String,Object>> dataList = new ArrayList<>();
//            if(null != list && list.size()>0) {
//            	for (Icon icon2 : list) {
//					Map<String,Object> map = new HashMap<>();
//					map.put("iconName", icon2.getIconName());
//					map.put("iconImage",filePath +icon2.getIconImage());
//					if(!"0".equals(icon2.getIconType())) {
//						map.put("iconId",icon2.getIconType());
//					}else {
//						map.put("iconId", icon2.getId());
//					}
//					List<Map<String,String>> iconCategoryList = new ArrayList<>();
//					if(null !=icon2.getFirstCategoryId() && icon2.getFirstCategoryId().length()>0 && !"0".equals(icon2.getFirstCategoryId())) {
//						String[] arrayStr = icon2.getFirstCategoryId().split(",");
//						String[] arrayName = icon2.getFirstCategoryName().split(",");
//						for (int i = 0; i < arrayStr.length; i++) {
//							Map<String,String> map1= Maps.newHashMap();
//							map1.put("firstCategoryId", arrayStr[i]);
//							map1.put("firstCategoryName", arrayName[i]);
//							iconCategoryList.add(map1);
//						}
//						map.put("category", iconCategoryList);
//					}
//					BannerServices bann = new BannerServices();
//					bann.setFilePath(filePath);
//					bann.setLabel(icon2.getIconName());
//					List<Map<String,String>> banner = bannerServiceService.findBannerListByType(bann);
//					if(null != banner && banner.size()>0 && null != banner.get(0)) {
//						for(Map<String,String> m:banner){
//							if("3".equals(m.get("usedType"))){
//								m.put("url", filePath + map.get("url")+"&communityId="+req.getCommunityId()+"&uid="+req.getUid());
//							}else if("0".equals(m.get("usedType")))
//								m.put("url", filePath + map.get("url"));
//							else
//								m.put("url", map.get("url")+"");
//						}
//						map.put("bannerList", banner);
//						map.put("proportion", banner.get(0).get("remarks"));
//					}
//					dataList.add(map);
//				}
//            }
//            res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常9563：服务页图标" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.6 查询分类下商品
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec18(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			//TODO 本处不再判断用户是否登录
//			if (StringUtils.isNotBlank(req.getUid())) {
//				Tuser user = tuserService.get(req.getUid());
//				if (null == user) {
//					res.setResultNote("用户不存在");
//					return res;
//				} else if (!"0".equals(user.getStatus())) {
//					res.setResultNote("用户被禁用");
//					return res;
//				}
//			}else{
//				req.setUid("");
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//			String type = "0";
//			if ("0".equals(req.getType())) {
//				type = "2";
//			} else if ("1".equals(req.getType())) {
//				type = "1";
//			} else if("2".equals(req.getType())){
//				type = "0";
//			}
//
//			GoodsCommunity gc = new GoodsCommunity();
//			gc.setCommunityid(req.getCommunityId());
//			gc.setType(type);
//			gc.setDataScope("and g.state=0 AND c.shelves='0'");
//			if (!StringUtils.isBlank(req.getCategoryId())) {
//				gc.setCategoryid(req.getCategoryId());
//			}
//			if (!StringUtils.isBlank(req.getContent())) {
//				String searchKey = Chinese2PYUtils.getStringPinYin(req.getContent());
//
//				String searchKey1 = "";
//				List<Keyword> kwl = systemConfig.getKeyword();
//				Set<String> dict = Sets.newHashSet();
//				for(Keyword kw:kwl){
//					dict.add(kw.getKeyword());
//				}
//				searchKey1 = MMSegmentUtils.getKeyword(dict,req.getContent());
//				gc.setGoodsname(searchKey1);
//
//				StringBuffer searchOrderBy = new StringBuffer(" ORDER BY g.title like '%"+req.getContent()+"%' desc, g.pinyin like '%" + searchKey + "%' desc,");
//				searchOrderBy.append(" MATCH (keyword, pinyin) AGAINST ('" + searchKey + searchKey1 + "') desc");
//				gc.setSearchOrderBy(searchOrderBy.toString());
//				// gc.setGoodsname(req.getContent());
//			}
//			gc.setUid(req.getUid());
//			gc.setFilePath(filePath);
//			List<Map<String, String>> dataList = goodsCommunityService.findListSort(gc);
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：9544" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.6 查询分类下商品NEW
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec18New(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			//TODO 本处不再判断用户是否登录
//			if (StringUtils.isNotBlank(req.getUid())) {
//				Tuser user = tuserService.get(req.getUid());
//				if (null == user) {
//					res.setResultNote("用户不存在");
//					return res;
//				} else if (!"0".equals(user.getStatus())) {
//					res.setResultNote("用户被禁用");
//					return res;
//				}
//			}else{
//				req.setUid("");
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//			String type = "0";
//			if ("0".equals(req.getType())) {
//				type = "2";
//			} else if ("1".equals(req.getType())) {
//				type = "1";
//			} else if("2".equals(req.getType())){
//				type = "0";
//			}
//
//			GoodsCommunity gc = new GoodsCommunity();
//			gc.setCommunityid(req.getCommunityId());
//			gc.setType(type);
//			if (!StringUtils.isBlank(req.getCategoryId())) {
//				gc.setCategoryid(req.getCategoryId());
//			}
//			if (!StringUtils.isBlank(req.getContent())) {
//				String searchKey = Chinese2PYUtils.getStringPinYin(req.getContent());
//				List<Keyword> kwl = systemConfig.getKeyword();
//				Set<String> dict = Sets.newHashSet();
//				for(Keyword kw:kwl){
//					dict.add(kw.getKeyword());
//				}
//				String searchKey1 = MMSegmentUtils.getKeyword(dict,req.getContent());
//				gc.setGoodsname(searchKey1);
////				StringBuffer searchOrderBy = new StringBuffer(" ORDER BY g.title like '%"+req.getContent()+"%' desc, g.pinyin like '%" + searchKey + "%' desc,");
////				searchOrderBy.append(" MATCH (keyword, pinyin) AGAINST ('" + searchKey + "') desc");
//
//				StringBuffer searchOrderBy = new StringBuffer(" ORDER BY IFNULL(u.title,g.title) like '%"+req.getContent()+"%' desc,"
//					+ "IFNULL(u.pinyin,g.pinyin) like '%" + searchKey1 + "%' desc,");
////				searchOrderBy.append(" MATCH (u.keyword, u.pinyin) AGAINST ('" + searchKey + "') desc,");
//				searchOrderBy.append(" MATCH (g.keyword, g.pinyin) AGAINST ('" + searchKey + searchKey1 + "') desc");
//
//				gc.setSearchOrderBy(searchOrderBy.toString());
//				// gc.setGoodsname(req.getContent());
//			}
//			gc.setUid(req.getUid());
//			gc.setFilePath(filePath);
//			List<Map<String, Object>> dataList = null;
//			if(StringUtils.isBlank(req.getXcX())){
//				dataList=goodsCommunityService.findListSortNew(gc);
//			}else if("XcX".equals(req.getXcX())){
//				dataList=goodsCommunityService.findListSortNewXcX(gc);
//			}
//			for(int i=0;i<dataList.size();i++){
//				Map<String,Object> map = dataList.get(i);
//				if(Integer.valueOf(map.get("ids").toString())>1){
//					gc.setUnifierid(map.get("goodsId").toString());
//					gc.setFilePath(filePath);
//					List<Map<String,String>> goods = null;
//					if(StringUtils.isBlank(req.getXcX())){
//						goods=goodsCommunityService.findGoodsListByUnifier(gc);
//					}else if("XcX".equals(req.getXcX())){
//						goods=goodsCommunityService.findGoodsListByUnifierXcX(gc);
//					}
//					map.put("subGoods", goods);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：9544" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 搜索关键字
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecSearch(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//
//			SearchBase searchBase = SearchBase.getSerachBase();
////			String keyid = searchBase.getIds(req.getContent());
//			List<String> objs = searchBase.getKeyWord(req.getContent());
//			if (null == objs || objs.size() == 0 || null == objs.get(0)){
//				res.setResultNote("你的品味好高级，小逗还寻觅不到这个东西！");
//				return res;
//			}
//			res.setDataList(objs);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：9577" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.60 商品介绍详情
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codeGetGoodsDesc(GetCommunityReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		if (StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区id不可为空");
//			return res;
//		}
//
//		if (StringUtils.isBlank(req.getGoodsid())) {
//			res.setResultNote("商品id不可为空");
//			return res;
//		}
//
//		/*String state = goodsActivityService.execSelectSqlString("SELECT NOW() > (SELECT endtime FROM t_goods_activity_list "
//				+ " WHERE communityid='"+req.getCommunityId()+"' AND goodsid='"+req.getGoodsid()+"')");
//		if(null != state && "1".equals(state)) {
//		    res.setResult("团购商品已结束");
//			return res;
//		}*/
//
//		GoodsCommunity goodscontent = goodsCommunityService.getGoodsStock(req.getCommunityId(), req.getGoodsid());
//		Map<String, Object> map = new HashMap<>();
//		Map<String, String> map1 =  goodsActivityService.execSelectSqlEntityMap("SELECT a.hint AS hint,g.activityid AS activityId,a.starttime AS startTime,a.endtime AS endTime,"
//				+ "a.activityname AS activityName,IF(UNIX_TIMESTAMP(a.endTime)-UNIX_TIMESTAMP(NOW())<=0,0,UNIX_TIMESTAMP(a.endTime)-UNIX_TIMESTAMP(NOW())) AS timer,"
//		  		+ "IF(UNIX_TIMESTAMP(starttime)-UNIX_TIMESTAMP(NOW())<=0,0,UNIX_TIMESTAMP(starttime)-UNIX_TIMESTAMP(NOW())) AS unknownTimer "
//		  		+ " FROM t_goods_activity_list g " +
//		  		" LEFT JOIN t_goods_activity a ON g.activityid = a.id " +
//		  		" WHERE g.state = '0' and g.communityid='"+req.getCommunityId()+"' AND g.goodsid='"+req.getGoodsid()+"'");
//		if (null != goodscontent) {
//			String count = userCartService.execSelectSqlString("SELECT count FROM t_user_cart WHERE uid = '"+req.getUid()+"' AND goodsid='"+req.getGoodsid()+"'");
//			if(null != count && count.length()>0) {
//				map.put("count", count);
//			}
//			map.put("goodsName", goodscontent.getGoodsname());
//			map.put("goodsImg", filePath + goodscontent.getGoodsimg());
//			map.put("goodsPrice", goodscontent.getGoodsprice());
//			map.put("goodsCuprice", goodscontent.getGoodscuprice());
//			map.put("goodsSpecification", goodscontent.getSpecification());
//			map.put("goodsSallnum", goodscontent.getSallnum() + "");
//			map.put("goodsType", goodscontent.getType());
//			map.put("goodsStock", goodscontent.getStock());
//			map.put("goodsDesc", goodscontent.getContent());// 老版本
//			map.put("content", goodscontent.getContent());
//			map.put("categoryId", goodscontent.getCategoryid());
//			if (!StringUtils.isBlank(goodscontent.getGoodscuprice())) {
//				BigDecimal bg = new BigDecimal(goodscontent.getGoodsprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品价
//				BigDecimal bg1 = new BigDecimal(goodscontent.getGoodscuprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品促销价
//				BigDecimal bg2 = new BigDecimal(10);// 折扣
//				bg2 = bg1.divide(bg, 2, BigDecimal.ROUND_HALF_UP).multiply(bg2).setScale(1,
//						BigDecimal.ROUND_HALF_UP);
//				if(bg2.compareTo(new BigDecimal(10))<0)
//					map.put("goodsDiscount", bg2.stripTrailingZeros().toPlainString() + "折");
//			}
//			res.setObjects(map);
//			res.setModel(map1);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} else {
//			res.setResult("1");
//			res.setResultNote("该商品已售罄或已下架，请选择其他商品！");
//		}
//
//		return res;
//	}
//
//	/**
//	 * 3.60 商品介绍详情
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codeGetGoodsDescNew(GetCommunityReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		if (StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区id不可为空");
//			return res;
//		}
//
//		if (StringUtils.isBlank(req.getGoodsid())) {
//			res.setResultNote("商品id不可为空");
//			return res;
//		}
//
//		/*String state = goodsActivityService.execSelectSqlString("SELECT NOW() > (SELECT endtime FROM t_goods_activity_list "
//				+ " WHERE communityid='"+req.getCommunityId()+"' AND goodsid='"+req.getGoodsid()+"')");
//		if(null != state && "1".equals(state)) {
//		    res.setResult("团购商品已结束");
//			return res;
//		}*/
//		GoodsCommunity gc = new GoodsCommunity();
//		gc.setUid(req.getUid());
//		gc.setCommunityid(req.getCommunityId());
//		gc.setGoodsid(req.getGoodsid());
//		GoodsCommunity goodscontent = goodsCommunityService.getGoodsStockListByUni(gc);
//		Map<String, Object> map = new HashMap<>();
//		if (null != goodscontent) {
//			Map<String, String> map1 =  Maps.newHashMap();
//			map.put("goodsName", goodscontent.getGoodsname());
//			map.put("goodsImg", filePath + goodscontent.getGoodsimg());
//			map.put("goodsPrice", goodscontent.getGoodsprice());
//			map.put("goodsCuprice", goodscontent.getGoodscuprice());
//			map.put("goodsSpecification", goodscontent.getSpecification());
//			map.put("goodsSallnum", goodscontent.getSallnum() + "");
//			map.put("goodsType", goodscontent.getType());
//			map.put("goodsStock", goodscontent.getStock());
//			map.put("goodsDesc", goodscontent.getContent());// 老版本
//			map.put("content", goodscontent.getContent());
//			map.put("categoryId", goodscontent.getCategoryid());
//			if(Integer.valueOf(goodscontent.getIds())>1){
//				gc.setUnifierid(goodscontent.getGoodsid());
//				gc.setFilePath(filePath);
//				List<Map<String,String>> goods = goodsCommunityService.findGoodsListByUnifier(gc);
//				map.put("subGoods", goods);
//				map1 =  goodsActivityService.execSelectSqlEntityMap("SELECT a.hint AS hint,g.activityid AS activityId,a.starttime AS startTime,a.endtime AS endTime,"
//						+ "a.activityname AS activityName,IF(UNIX_TIMESTAMP(a.endTime)-UNIX_TIMESTAMP(NOW())<=0,0,UNIX_TIMESTAMP(a.endTime)-UNIX_TIMESTAMP(NOW())) AS timer,"
//				  		+ "IF(UNIX_TIMESTAMP(starttime)-UNIX_TIMESTAMP(NOW())<=0,0,UNIX_TIMESTAMP(starttime)-UNIX_TIMESTAMP(NOW())) AS unknownTimer "
//				  		+ " FROM t_goods_activity_list g " +
//				  		" LEFT JOIN t_goods_activity a ON g.activityid = a.id " +
//				  		" WHERE g.state = '0' and g.communityid='"+req.getCommunityId()+"' AND g.goodsid='"+goods.get(0).get("id")+"'");
//			}else{
//				map1 =  goodsActivityService.execSelectSqlEntityMap("SELECT a.hint AS hint,g.activityid AS activityId,a.starttime AS startTime,a.endtime AS endTime,"
//						+ "a.activityname AS activityName,IF(UNIX_TIMESTAMP(a.endTime)-UNIX_TIMESTAMP(NOW())<=0,0,UNIX_TIMESTAMP(a.endTime)-UNIX_TIMESTAMP(NOW())) AS timer,"
//				  		+ "IF(UNIX_TIMESTAMP(starttime)-UNIX_TIMESTAMP(NOW())<=0,0,UNIX_TIMESTAMP(starttime)-UNIX_TIMESTAMP(NOW())) AS unknownTimer "
//				  		+ " FROM t_goods_activity_list g " +
//				  		" LEFT JOIN t_goods_activity a ON g.activityid = a.id " +
//				  		" WHERE g.state = '0' and g.communityid='"+req.getCommunityId()+"' AND g.goodsid='"+req.getGoodsid()+"'");
//				map.put("discountPrice", goodscontent.getDiscountprice());
//			}
//			map.put("count", goodscontent.getCount());
//			res.setObjects(map);
//			res.setModel(map1);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} else {
//			res.setResult("1");
//			res.setResultNote("该商品已售罄或已下架，请选择其他商品！");
//		}
//
//		return res;
//	}
//	public ResJson codeGetGoodsDescNewXcX(GetCommunityReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		if (StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区id不可为空");
//			return res;
//		}
//
//		if (StringUtils.isBlank(req.getGoodsid())) {
//			res.setResultNote("商品id不可为空");
//			return res;
//		}
//
//		/*String state = goodsActivityService.execSelectSqlString("SELECT NOW() > (SELECT endtime FROM t_goods_activity_list "
//				+ " WHERE communityid='"+req.getCommunityId()+"' AND goodsid='"+req.getGoodsid()+"')");
//		if(null != state && "1".equals(state)) {
//		    res.setResult("团购商品已结束");
//			return res;
//		}*/
//		GoodsCommunity gc = new GoodsCommunity();
//		gc.setUid(req.getUid());
//		gc.setCommunityid(req.getCommunityId());
//		gc.setGoodsid(req.getGoodsid());
//		if(StringUtils.isNotBlank(req.getXcxType())&& req.getXcxType().equals("2")){
//			gc.setXcxType(req.getXcxType());
//		}
//		GoodsCommunity goodscontent = goodsCommunityService.selectGoodsInfo(gc);
//		Map<String, Object> map = new HashMap<>();
//		if (null != goodscontent) {
//
//			Map<String, String> map1 =  Maps.newHashMap();
//			map.put("goodsName", goodscontent.getGoodsname());
//			map.put("goodsImg", filePath + goodscontent.getGoodsimg());
//			map.put("goodsPrice", goodscontent.getGoodsprice());
//			map.put("goodsCuprice", goodscontent.getGoodscuprice());
//			map.put("goodsSpecification", goodscontent.getSpecification());
//			map.put("goodsSallnum", goodscontent.getSallnum() + "");
//			map.put("goodsType", goodscontent.getType());
//			map.put("goodsStock", goodscontent.getStock());
//			map.put("goodsDesc", goodscontent.getContent());// 老版本
//			map.put("content", goodscontent.getContent());
//			map.put("categoryId", goodscontent.getCategoryid());
//			map.put("activityprice", goodscontent.getActivityprice());
//			map.put("typeName", goodscontent.getTypeName());
//			map.put("activityid", goodscontent.getActivityid());
//			map.put("goodsId", goodscontent.getGoodsid());
//			map.put("starttime", goodscontent.getStartTime());
//			map.put("endtime", goodscontent.getEndTime());
//			if(Integer.valueOf(goodscontent.getIds())>1){
//				gc.setUnifierid(goodscontent.getGoodsid());
//				gc.setFilePath(filePath);
//				List<Map<String,String>> goods = goodsCommunityService.selectUnifierGoodsInfo(gc);
//				map.put("subGoods", goods);
//				map1 =  goodsActivityService.execSelectSqlEntityMap("SELECT a.hint AS hint,g.activityid AS activityId,a.starttime AS startTime,a.endtime AS endTime,"
//						+ "a.activityname AS activityName,IF(UNIX_TIMESTAMP(a.endTime)-UNIX_TIMESTAMP(NOW())<=0,0,UNIX_TIMESTAMP(a.endTime)-UNIX_TIMESTAMP(NOW())) AS timer,"
//				  		+ "IF(UNIX_TIMESTAMP(starttime)-UNIX_TIMESTAMP(NOW())<=0,0,UNIX_TIMESTAMP(starttime)-UNIX_TIMESTAMP(NOW())) AS unknownTimer "
//				  		+ " FROM t_goods_activity_list g " +
//				  		" LEFT JOIN t_goods_activity a ON g.activityid = a.id " +
//				  		" WHERE g.state = '0' and g.communityid='"+req.getCommunityId()+"' AND g.goodsid='"+goods.get(0).get("id")+"'");
//			}else{
//				List<Map<String,String>> list=new ArrayList<Map<String,String>>();
//				Map<String, String> map2 =  Maps.newHashMap();
//				map2.put("title", goodscontent.getGoodsname());
//				map2.put("image", filePath + goodscontent.getGoodsimg());
//				map2.put("goodsprice", goodscontent.getGoodsprice());
//				map2.put("goodsCuprice", goodscontent.getGoodscuprice());
//				map2.put("goodsSpecification", goodscontent.getSpecification());
//				map2.put("sallnum", goodscontent.getSallnum() + "");
//				map2.put("goodsType", goodscontent.getType());
//				map2.put("stock", goodscontent.getStock().toString());
//				map2.put("goodsdesc", goodscontent.getContent());// 老版本
//				map2.put("categoryId", goodscontent.getCategoryid());
//				map2.put("activityprice", goodscontent.getActivityprice());
//				map2.put("typeName", goodscontent.getTypeName());
//				map2.put("activityid", goodscontent.getActivityid());
//				map2.put("id", goodscontent.getGoodsid());
//				map2.put("starttime", goodscontent.getStartTime());
//				map2.put("endtime", goodscontent.getEndTime());
//				map2.put("discountPrice", goodscontent.getDiscountprice());
//				map2.put("count", goodscontent.getCount());
//				list.add(map2);
//				map.put("subGoods", list);
//				map1 =  goodsActivityService.execSelectSqlEntityMap("SELECT a.hint AS hint,g.activityid AS activityId,a.starttime AS startTime,a.endtime AS endTime,"
//						+ "a.activityname AS activityName,IF(UNIX_TIMESTAMP(a.endTime)-UNIX_TIMESTAMP(NOW())<=0,0,UNIX_TIMESTAMP(a.endTime)-UNIX_TIMESTAMP(NOW())) AS timer,"
//				  		+ "IF(UNIX_TIMESTAMP(starttime)-UNIX_TIMESTAMP(NOW())<=0,0,UNIX_TIMESTAMP(starttime)-UNIX_TIMESTAMP(NOW())) AS unknownTimer "
//				  		+ " FROM t_goods_activity_list g " +
//				  		" LEFT JOIN t_goods_activity a ON g.activityid = a.id " +
//				  		" WHERE g.state = '0' and g.communityid='"+req.getCommunityId()+"' AND g.goodsid='"+req.getGoodsid()+"'");
//				map.put("discountPrice", goodscontent.getDiscountprice());
//			}
//			map.put("count", goodscontent.getCount());
//			res.setObjects(map);
//			res.setModel(map1);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} else {
//			res.setResult("1");
//			res.setResultNote("该商品已售罄或已下架，请选择其他商品！");
//		}
//
//		return res;
//	}
//	/**
//	 * 3.61搜索查询所有商品
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec08(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//
//			GoodsCommunity gc = new GoodsCommunity();
//			gc.setCommunityid(req.getCommunityId());
//			gc.setDataScope(" and g.state=0 AND a.shelves='0'");
//			if (StringUtils.isBlank(req.getContent())) {
//				res.setResultNote("请输入关键字！");
//				return res;
//			}
////			SearchBase searchBase = SearchBase.getSerachBase();
////			String keyid = searchBase.getIds(req.getContent());
////			String searchKey = "";
////			List<Map<String, Map<String,String>>> objs = searchBase.getObjects(keyid);
////			if (objs != null) {
////				for (Map<String, Map<String,String>> obj : objs) {
////					for(String ke : obj.keySet()){
////						if("1".equals(ke)){
//////							searchKey= searchKey +" +" + StringUtils.strip(obj.get(ke).values().toString(),"[]");
////						searchKey= searchKey +" " + StringUtils.strip(obj.get(ke).values().toString(),"[]");
////						}else if("2".equals(ke)){
////							searchKey= searchKey +" >"+StringUtils.strip(obj.get(ke).values().toString(),"[]");
////						}else{
////							searchKey= searchKey +" "+StringUtils.strip(obj.get(ke).values().toString(),"[]");
////						}
////					}
////				}
////				gc.setGoodsname(searchKey);
////			}else{
////				res.setResultNote("你的品味好高级，小逗还寻觅不到这个东西！");
////				return res;
////			}
//
//			String searchKey1 = "";
//			List<Keyword> kwl = systemConfig.getKeyword();
//			Set<String> dict = Sets.newHashSet();
//			for(Keyword kw:kwl){
//				dict.add(kw.getKeyword());
//			}
//			searchKey1 = MMSegmentUtils.getKeyword(dict,req.getContent());
////			//TODO 搜索
//			String searchKey = Chinese2PYUtils.getStringPinYin(req.getContent());
//			gc.setGoodsname(searchKey1);
////			String[] searchKeyArray = searchKey.split(" ");
//			StringBuffer searchOrderBy = new StringBuffer(" ORDER BY g.title like '%"+req.getContent()+"%' desc, g.pinyin like '%" + searchKey1 + "%' desc,");
//			searchOrderBy.append(" MATCH (keyword, pinyin) AGAINST ('" + searchKey + searchKey1+ "') desc");
//			gc.setSearchOrderBy(searchOrderBy.toString());
//			List<GoodsCommunity> list = goodsCommunityService.findSearchList(gc);
//			// gc.setGoodsname(req.getContent());
//			// List<GoodsCommunity> list = goodsCommunityService.findList(gc);
//
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (list != null && list.size() > 0) {
//				List<UserCart> cartList = userCartService.findList1(req.getUid());
//
//				for (GoodsCommunity gcc : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("goodsId", gcc.getGoodsid());
//					map.put("goodsName", gcc.getGoodsname());
//					map.put("goodsImg", filePath + gcc.getGoodsimg().replace("/images/", "/_thumbs/images/"));
//					map.put("goodsPrice", gcc.getGoodsprice());
//					map.put("goodsCuprice", gcc.getGoodscuprice());
//					map.put("goodsDesc", gcc.getGoodsdesc());
//					map.put("goodsContent", gcc.getContent());
//					if (!StringUtils.isBlank(gcc.getGoodscuprice())) {
//						BigDecimal bg = new BigDecimal(gcc.getGoodsprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品价
//						BigDecimal bg1 = new BigDecimal(gcc.getGoodscuprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品促销价
//						BigDecimal bg2 = new BigDecimal(10);// 折扣
//						bg2 = bg1.divide(bg, 2, BigDecimal.ROUND_HALF_UP).multiply(bg2).setScale(1,
//								BigDecimal.ROUND_HALF_UP);
//						if(bg2.compareTo(new BigDecimal(10))<0)
//							map.put("goodsDiscount", bg2.stripTrailingZeros().toPlainString() + "折");
//					}
//					if (!StringUtils.isBlank(gcc.getPurchase()) && !"0".equals(gcc.getPurchase())) {
//						map.put("goodsPurchase", "每单限购" + gcc.getPurchase() + "份优惠商品");
//					}
//					map.put("goodsSpecification", gcc.getSpecification());
//					map.put("goodsSallnum", gcc.getSallnum() + "");
//					map.put("optimizationid", gcc.getOptimizationid());
//					map.put("activityType", gcc.getActivityType());
//					map.put("goodsStock", "1".equals(gcc.getType()) ? "999" : gcc.getStock() + "");
//					if ("0".equals(gcc.getType())) {
//						map.put("goodsType", "2");
//					} else if ("2".equals(gcc.getType())) {
//						map.put("goodsType", "0");
//					} else {
//						map.put("goodsType", "1");
//					}
//                       map.put("categoryId", gcc.getCategoryid());
//					if (null != cartList && !cartList.isEmpty()) {// 存在就进行数量相加
//						for (UserCart userCart : cartList) {
//
//							if (userCart.getGoodsid().equals(gcc.getGoodsid())) {
//								map.put("count", userCart.getCount() + "");
//								break;
//							}
//
//						}
//					}
//					dataList.add(map);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：9742" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.61搜索查询所有商品
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec08New(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//
//			GoodsCommunity gc = new GoodsCommunity();
//			gc.setCommunityid(req.getCommunityId());
//			gc.setDataScope(" and g.state=0 AND a.shelves='0'");
//			if (StringUtils.isBlank(req.getContent())) {
//				res.setResultNote("请输入关键字！");
//				return res;
//			}
//			String searchKey1 = "";
//			List<Keyword> kwl = systemConfig.getKeyword();
//			Set<String> dict = Sets.newHashSet();
//			for(Keyword kw:kwl){
//				dict.add(kw.getKeyword());
//			}
//			searchKey1 = MMSegmentUtils.getKeyword(dict,req.getContent());
////			//TODO 搜索NEW
//			String searchKey = Chinese2PYUtils.getStringPinYin(req.getContent());
//			gc.setGoodsname(searchKey1);
//			gc.setContent(req.getContent());
//			gc.setUid(req.getUid());
////			StringBuffer searchOrderBy = new StringBuffer(" ORDER BY title like '%"+req.getContent()+"%' desc, pinyin like '%" + searchKey + "%' desc,");
////			searchOrderBy.append(" score desc");
//
//			StringBuffer searchOrderBy = new StringBuffer(" ORDER BY IFNULL(u.title,g.title) like '%"+req.getContent()+"%' desc,"
//					+ "IFNULL(u.pinyin,g.pinyin) like '%" + searchKey1 + "%' desc,");
//			searchOrderBy.append(" MATCH (g.keyword, g.pinyin) AGAINST ('" + searchKey + searchKey1+ "') desc");
//
//			gc.setSearchOrderBy(searchOrderBy.toString());
//			List<GoodsCommunity> list=null;
//			if(StringUtils.isNotBlank(req.getXcX())&&"XcX".equals(req.getXcX())){
//				list=goodsCommunityService.findSearchListNewXcX(gc);
//			}else{
//				list = goodsCommunityService.findSearchListNew(gc);
//			}
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (list != null && list.size() > 0) {
//				// 查询该商品是否已存在购物车内
//				for (GoodsCommunity gcc : list) {
//					Map<String, Object> map = new HashMap<String, Object>();
//					map.put("goodsId", gcc.getGoodsid());
//					map.put("goodsName", gcc.getGoodsname());
//					map.put("goodsImg", filePath + gcc.getGoodsimg().replace("/images/", "/_thumbs/images/"));
//					map.put("goodsPrice", gcc.getGoodsprice());
//					map.put("goodsCuprice", gcc.getGoodscuprice());
//					map.put("goodsDesc", gcc.getGoodsdesc());
//					map.put("goodsContent", gcc.getContent());
//					if (!StringUtils.isBlank(gcc.getPurchase()) && !"0".equals(gcc.getPurchase())) {
//						map.put("goodsPurchase", "每单限购" + gcc.getPurchase() + "份优惠商品");
//					}
//					if(StringUtils.isNotBlank(req.getXcX())&&"XcX".equals(req.getXcX())){
//						map.put("activityprice", gcc.getActivityprice());
//						map.put("typeName", gcc.getTypeName());
//						map.put("activityid", gcc.getActivityid());
//						map.put("startTime", gcc.getStartTime());
//						map.put("endTime", gcc.getEndTime());
//					}
//					map.put("goodsSpecification", gcc.getSpecification());
//					map.put("goodsSallnum", gcc.getSallnum() + "");
//					map.put("optimizationid", gcc.getOptimizationid());
//					map.put("activityType", gcc.getActivityType());
//					map.put("discountPrice", gcc.getDiscountprice());
//					map.put("goodsStock", "1".equals(gcc.getType()) ? "999" : gcc.getStock() + "");
//					if ("0".equals(gcc.getType())) {
//						map.put("goodsType", "2");
//					} else if ("2".equals(gcc.getType())) {
//						map.put("goodsType", "0");
//					} else {
//						map.put("goodsType", "1");
//					}
//					map.put("categoryId", gcc.getCategoryid());
//					map.put("count", gcc.getCount() + "");
//					if(Integer.valueOf(gcc.getIds())>1){
//						gc.setUnifierid(gcc.getGoodsid());
//						gc.setFilePath(filePath);
//						List<Map<String,String>> goods = null;
//						if(StringUtils.isNotBlank(req.getXcX())&&"XcX".equals(req.getXcX())){
//							goods = goodsCommunityService.findGoodsListByUnifierXcX(gc);
//						}else{
//							goods = goodsCommunityService.findGoodsListByUnifier(gc);
//						}
//						map.put("subGoods", goods);
//					}
//					dataList.add(map);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：9742" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.62展示热销商品
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec09(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//
//			GoodsCommunity m = new GoodsCommunity();
//			m.setCommunityid(req.getCommunityId());
//			Page<GoodsCommunity> page = new Page<GoodsCommunity>(req.getNowPage(), req.getPageCount());
//			Page<GoodsCommunity> listPage = goodsCommunityService.sellCommuityGoodsPage(page,m);
//			List<GoodsCommunity> list = listPage.getList();
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (null != list && list.size() > 0) {
//				// 查询该商品是否已存在购物车内
//				List<UserCart> cartList = userCartService.findList1(req.getUid());
//				for (GoodsCommunity gcc : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("goodsId", gcc.getGoodsid());
//					map.put("goodsName", gcc.getGoodsname());
//					map.put("goodsImg", filePath + gcc.getGoodsimg().replace("/images/", "/_thumbs/images/"));
//					map.put("goodsPrice", gcc.getGoodsprice());
//					map.put("goodsCuprice", gcc.getGoodscuprice());
//					map.put("goodsDesc", gcc.getGoodsdesc());
//					map.put("goodsContent", gcc.getContent());
//					if (!StringUtils.isBlank(gcc.getGoodscuprice())) {
//						BigDecimal bg = new BigDecimal(gcc.getGoodsprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品价
//						BigDecimal bg1 = new BigDecimal(gcc.getGoodscuprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品促销价
//						BigDecimal bg2 = new BigDecimal(10);// 折扣
//						bg2 = bg1.divide(bg, 2, BigDecimal.ROUND_HALF_UP).multiply(bg2).setScale(1,
//								BigDecimal.ROUND_HALF_UP);
//						if(bg2.compareTo(new BigDecimal(10))<0)
//							map.put("goodsDiscount", bg2.stripTrailingZeros().toPlainString() + "折");
//					}
//					if (!StringUtils.isBlank(gcc.getPurchase()) && !"0".equals(gcc.getPurchase())) {
//						map.put("goodsPurchase", "每单限购" + gcc.getPurchase() + "份优惠商品");
//					}
//					map.put("goodsSpecification", gcc.getSpecification());
//					map.put("goodsSallnum", gcc.getSallnum() + "");
//					map.put("optimizationid", gcc.getOptimizationid());
//					map.put("activityType", gcc.getActivityType());
//					map.put("goodsStock", "1".equals(gcc.getType()) ? "0" : gcc.getStock() + "");
//					if ("0".equals(gcc.getType())) {
//						map.put("goodsType", "2");
//					} else if ("2".equals(gcc.getType())) {
//						map.put("goodsType", "0");
//					} else {
//						map.put("goodsType", "1");
//					}
//                        map.put("categoryId", gcc.getCategoryid());
//					if (null != cartList && !cartList.isEmpty()) {// 存在就进行数量相加
//						for (UserCart userCart : cartList) {
//
//							if (userCart.getGoodsid().equals(gcc.getGoodsid())) {
//								map.put("count", userCart.getCount() + "");// 老版本
//								map.put("goodsNum", userCart.getCount() + "");
//								break;
//							}
//
//						}
//					}
//					dataList.add(map);
//				}
//			}
//			res.setTotalPage(listPage.getTotalPage());
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取我的消息成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：9841" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.63展示热销商品
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec63(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//
//			GoodsCommunity m = new GoodsCommunity();
//			m.setCommunityid(req.getCommunityId());
//			m.setUid(req.getUid());
//			Page<GoodsCommunity> page = new Page<GoodsCommunity>(req.getNowPage(), req.getPageCount());
//			Page<GoodsCommunity> listPage = goodsCommunityService.sellCommuityGoodsNewPage(page,m);
//			List<GoodsCommunity> list = listPage.getList();
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				// 查询该商品是否已存在购物车内
////				List<UserCart> cartList = userCartService.findList1(req.getUid());
//				for (GoodsCommunity gcc : list) {
//					Map<String, Object> map = new HashMap<String, Object>();
//					map.put("goodsId", gcc.getGoodsid());
//					map.put("goodsName", gcc.getGoodsname());
//					map.put("goodsImg", filePath + gcc.getGoodsimg().replace("/images/", "/_thumbs/images/"));
//					map.put("goodsPrice", gcc.getGoodsprice());
//					map.put("goodsCuprice", gcc.getGoodscuprice());
//					map.put("goodsDesc", gcc.getGoodsdesc());
//					map.put("goodsContent", gcc.getContent());
//					if (!StringUtils.isBlank(gcc.getGoodscuprice())&&!gcc.getGoodscuprice().contains("-")) {
//						BigDecimal bg = new BigDecimal(gcc.getGoodsprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品价
//						BigDecimal bg1 = new BigDecimal(gcc.getGoodscuprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品促销价
//						BigDecimal bg2 = new BigDecimal(10);// 折扣
//						bg2 = bg1.divide(bg, 2, BigDecimal.ROUND_HALF_UP).multiply(bg2).setScale(1,
//								BigDecimal.ROUND_HALF_UP);
//						if(bg2.compareTo(new BigDecimal(10))<0)
//							map.put("goodsDiscount", bg2.stripTrailingZeros().toPlainString() + "折");
//					}
//					if (!StringUtils.isBlank(gcc.getPurchase()) && !"0".equals(gcc.getPurchase())) {
//						map.put("goodsPurchase", "每单限购" + gcc.getPurchase() + "份优惠商品");
//					}
//					map.put("goodsSpecification", gcc.getSpecification());
//					map.put("goodsSallnum", gcc.getSallnum() + "");
//					map.put("optimizationid", gcc.getOptimizationid());
//					map.put("activityType", gcc.getActivityType());
//					map.put("goodsStock", "1".equals(gcc.getType()) ? "0" : gcc.getStock() + "");
//					if ("0".equals(gcc.getType())) {
//						map.put("goodsType", "2");
//					} else if ("2".equals(gcc.getType())) {
//						map.put("goodsType", "0");
//					} else {
//						map.put("goodsType", "1");
//					}
//					map.put("categoryId", gcc.getCategoryid());
//					map.put("count", gcc.getCount());
//					if(Integer.valueOf(gcc.getIds())>1){
//						m.setUnifierid(gcc.getGoodsid());
//						m.setFilePath(filePath);
//						List<Map<String,String>> goods = goodsCommunityService.findGoodsListByUnifier(m);
//						map.put("subGoods", goods);
//					}
//					map.put("discountPrice",gcc.getDiscountprice());
//					dataList.add(map);
//				}
//			}
//			res.setTotalPage(listPage.getTotalPage());
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取热销商品成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：10053" );
//			e.printStackTrace();
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 团购钜惠
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecGroupPurchase(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户ID不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区ID不能为空");
//			return res;
//		}
//
//		try {
//			Map<String,String> activityList = goodsActivityService.execSelectSqlEntityMap("SELECT id AS id,activityname AS activityName,remark AS remark,"
//					+ "CONCAT('"+filePath+"',image) AS bannerImage FROM t_goods_activity WHERE activityname='团购钜惠'");
//			if(null != activityList && activityList.size()>0) {
//				GoodsCommunity goodsCommunity = new GoodsCommunity();
//				goodsCommunity.setCommunityid(req.getCommunityId());
//				goodsCommunity.setActivityId(activityList.get("id"));
//				Page<GoodsCommunity> page = new Page<GoodsCommunity>(req.getNowPage(), req.getPageCount());
//				Page<GoodsCommunity> list = goodsActivityService.selectGroupPurchase(page, goodsCommunity);
//				List<Map<String,String>> dataList = new ArrayList<>();
//				for (GoodsCommunity gcc : list.getList()) {
//					Map<String, String> map = new HashMap<String, String>();
//					List<Object> goodsCount = userOrderService
//							.executeSelectSql("SELECT count FROM t_user_cart WHERE uid='" + req.getUid()
//									+ "' AND goodsid='" + gcc.getGoodsid() + "'");
//					if (null != goodsCount && goodsCount.size() > 0) {
//						//map.put("goodsNum", goodsCount.get(0).toString());//
//						map.put("count", goodsCount.get(0).toString());
//					}
//					map.put("goodsId", gcc.getGoodsid());
//					map.put("goodsName", gcc.getGoodsname());
//					map.put("goodsImg", filePath + gcc.getGoodsimg().replace("/images/", "/_thumbs/images/"));
//					map.put("goodsPrice", gcc.getGoodsprice());
//					map.put("goodsCuprice", gcc.getGoodscuprice());
//					map.put("goodsDesc", gcc.getGoodsdesc());
//					map.put("goodsRemark", gcc.getRemark());
//					map.put("activityType",gcc.getActivityType());
//					map.put("goodsContent", gcc.getContent());
//					if (!StringUtils.isBlank(gcc.getGoodscuprice())) {
//						BigDecimal bg = new BigDecimal(gcc.getGoodsprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品价
//						BigDecimal bg1 = new BigDecimal(gcc.getGoodscuprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品促销价
//						BigDecimal bg2 = new BigDecimal(10);// 折扣
//						bg2 = bg1.divide(bg, 2, BigDecimal.ROUND_HALF_UP).multiply(bg2).setScale(1,BigDecimal.ROUND_HALF_UP);
//						if(bg2.compareTo(new BigDecimal(10))<0)
//							map.put("goodsDiscount", bg2.stripTrailingZeros().toPlainString() + "折");
//					}
//					if (!StringUtils.isBlank(gcc.getPurchase()) && !"0".equals(gcc.getPurchase())) {
//						map.put("goodsPurchase", "每单限购" + gcc.getPurchase() + "份优惠商品");
//					}
//					map.put("goodsSpecification", gcc.getSpecification());
//					map.put("goodsSallnum", gcc.getSallnum() + "");
//					map.put("optimizationid", gcc.getOptimizationid());
//					if ("0".equals(gcc.getType())) {
//						map.put("goodsType", "2");
//					} else if ("2".equals(gcc.getType())) {
//						map.put("goodsType", "0");
//					} else {
//						map.put("goodsType", "1");
//					}
//
//					dataList.add(map);
//				}
//				res.setTotalPage(list.getTotalPage());
//			   res.setObject(activityList);
//			   res.setDataList(dataList);
//			}
//
//		} catch (Exception e) {
//			logger.error("请求处理异常：9923" );
//			e.printStackTrace();
//		}
//		res.setResult("0");
//		res.setResultNote("获取成功");
//		return res;
//	}
//
//	/**
//	 * 店长推荐
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecShopManagerRecommend(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户ID不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区ID不能为空");
//			return res;
//		}
//
//		try {
////			List<Map<String,Object>> dataList = goodsActivityService.execSelectSqlListMap("SELECT SUM(IFNULL(c.count,0)) AS count,gc.goodsid AS goodsId,g.title AS goodsName,"
////					+ "CONCAT('"+filePath+"',replace(g.image,\"/images/\",\"/_thumbs/images/\")) AS goodsImg,"
////					+ "IFNULL(gc.price,g.price) AS goodsPrice,g.goodsdesc AS goodsDesc,IF(g.type=1,1,2) AS goodsType,g.specification AS goodsSpecification,gc.stock AS goodsStock,"
////					+ "IF(IFNULL(IFNULL(p.goodscuprice,g.cuprice),'')='','',concat(ROUND(IFNULL(p.goodscuprice,g.cuprice)/IFNULL(gc.price,g.price)*10,1),'折')) AS goodsDiscount,"
////					+ "COUNT(DISTINCT g.id) as 'ids',"
////					+ "IF(IFNULL(g.discountflag,0)= 1 and COUNT(DISTINCT g.id)=1, IFNULL(g.discountprice,ROUND(g.price*(SELECT d.value FROM sys_dict_type t,sys_dict_value d "
////					+ "WHERE t.id = d.dict_type_id and t.type = 'doulindiscount' and d.sort = 1),2)),'') AS 'discountprice', "
////					+ "(SELECT concat('每单限购',count,'份优惠商品') FROM t_goods_community_purchase WHERE communityid='"+req.getCommunityId()+"' AND goodsid=g.id AND state='0' AND enddate >=NOW()) AS goodsPurchase "
////					+ "FROM t_goods g LEFT JOIN t_goods_unifier u ON g.unifierid = u.id,t_goods_community gc "
////					+ "LEFT JOIN t_goods_community_price p on p.communityid=gc.communityid and p.goodsid=gc.goodsid and NOW()>p.startdate and p.enddate>NOW() AND p.state='2' "
////					+ "LEFT JOIN t_user_cart c ON c.goodsid = gc.goodsid and c.uid = '"+req.getUid()+"' "
////					+ "WHERE gc.goodsid = g.id AND g.state='0' AND gc.shelves='0' AND gc.communityid='"+req.getCommunityId()+"' AND gc.shopManager='1' "
////					+ "group by IFNULL(g.unifierid,g.id)"
////					);
//			GoodsCommunity gc = new GoodsCommunity();
//			gc.setCommunityid(req.getCommunityId());
//			gc.setUid(req.getUid());
//			gc.setFilePath(filePath);
//			gc.setShopManager("1");
//			List<Map<String, Object>> dataList = goodsCommunityService.findListSortNew(gc);
//			int size = req.getNowPage()*req.getPageCount()>dataList.size()?dataList.size():req.getNowPage()*req.getPageCount();
//			for(int i=(req.getNowPage()-1)*req.getPageCount();i<size;i++){
//				Map<String,Object> map = dataList.get(i);
//				if(Integer.valueOf(map.get("ids").toString())>1){
//					gc.setUnifierid(map.get("goodsId").toString());
//					gc.setFilePath(filePath);
//					List<Map<String,String>> goods = goodsCommunityService.findGoodsListByUnifier(gc);
//					map.put("subGoods", goods);
//				}
//			}
//			res.setTotalPage((int)Math.ceil((double)dataList.size()/(double)req.getPageCount()));
//			res.setDataList(dataList);
//		} catch (Exception e) {
//			logger.error("请求处理异常：9923" );
//			e.printStackTrace();
//		}
//		res.setResult("0");
//		res.setResultNote("获取成功");
//		return res;
//	}
//
//	/**
//	 * 限时特价
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecTimedSpecials(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户ID不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区ID不能为空");
//			return res;
//		}
//
//		try {
//			Map<String,String> activityList = goodsActivityService.execSelectSqlEntityMap("SELECT id AS id,activityname AS activityName,remark AS remark,starttime AS startTime,"
//					+ "endtime AS endTime,IF(UNIX_TIMESTAMP(endTime)-UNIX_TIMESTAMP(NOW())<=0,0,UNIX_TIMESTAMP(endTime)-UNIX_TIMESTAMP(NOW())) AS timer,"
//					+ "IF(UNIX_TIMESTAMP(starttime)-UNIX_TIMESTAMP(NOW())<=0,0,UNIX_TIMESTAMP(starttime)-UNIX_TIMESTAMP(NOW())) AS unknownTimer "
//					+ " FROM t_goods_activity  WHERE activityname='限时特价'");
//			List<Map<String,Object>>bannerList=goodsActivityService.execSelectSqlListMap("SELECT used AS usedType,url AS url,status AS status,CONCAT('"+filePath+"',image) AS image FROM t_banneractivity_service WHERE status='0' "
//					+ "AND (communityid='"+req.getCommunityId()+"' OR communityid='1') AND typeid='"+activityList.get("id")+"'");
//			 List<Map<String, Object>> dataList = goodsActivityService.execSelectSqlListMap("SELECT a.goodsid AS goodsId,IFNULL(c.count,0) AS count,a.adtime AS adtime," +
//			 		"a.stock AS goodsStock,if(g.type=1,1,2) AS goodsType,g.title AS goodsName,CONCAT('"+filePath+"',replace(g.image,\"/images/\",\"/_thumbs/images/\")) AS goodsImg," +
//			 		"IFNULL(s.sallnum,0)+a.sallnum AS goodsSallnum,g.specification AS goodsSpecification,IFNULL(a.price,g.price) AS goodsPrice," +
//			 		"IF(l.activeCuprice is null OR 0 >=l.activeCuprice,IFNULL(p.goodscuprice,g.cuprice),l.activeCuprice) AS goodsCuprice," +
//			 		"IF(IFNULL(IFNULL(p.goodscuprice,g.cuprice),'')='','',concat(ROUND(IFNULL(p.goodscuprice,g.cuprice)/IFNULL(a.price,g.price)*10,1),'折')) AS goodsDiscount," +
//			 		"(SELECT concat('每单限购',count,'份优惠商品') FROM t_goods_community_purchase WHERE communityid='"+req.getCommunityId()+"' AND goodsid=g.id AND state='0' AND enddate >=NOW()) AS goodsPurchase," +
//			 		"IF(IFNULL(g.discountflag,0)= 1, IFNULL(g.discountprice,ROUND(g.price*(SELECT d.value FROM sys_dict_type t,sys_dict_value d "+
//			 		"WHERE t.id = d.dict_type_id and t.type = 'doulindiscount' and d.sort = 1),2)),'') AS 'discountPrice',"+
//			 		"g.goodsdesc AS goodsDesc,IFNULL(p.optimizationid,g.optimizationid) AS optimizationid,l.remark AS goodsRemark,l.activityType AS activityType " +
//			 		"FROM t_goods_activity_list l LEFT JOIN t_user_cart c ON c.goodsid = l.goodsid and c.uid = '"+req.getUid()+"' " +
//			 		"LEFT JOIN t_goods_community_price p on p.communityid=l.communityid and p.goodsid=l.goodsid and NOW()>=p.startdate and p.enddate>NOW() AND p.state='2' " +
//			 		"LEFT JOIN t_goods_community_sallnum s ON s.goodsid = l.goodsid AND s.communityid = l.communityid," +
//			 		"t_goods_community a ,t_goods g WHERE l.goodsid = a.goodsid " +
//			 		"AND l.communityid = a.communityid AND g.id=l.goodsid " +
//			 		"AND l.activityid='"+activityList.get("id")+"' AND l.communityid='"+req.getCommunityId()+"' " +
//			 		"AND l.state='0' AND g.state='0' AND a.shelves = '0'");
//			 res.setBannerList(bannerList);
//			 res.setDataList(dataList);
//			 res.setObject(activityList);
//		} catch (Exception e) {
//			logger.error("请求处理异常：10014" );
//			e.printStackTrace();
//		}
//		 res.setResult("0");
//		 res.setResultNote("获取成功");
//		return res;
//	}
//
//	/**
//	 * 系列活动
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codeSeriesOfActivities(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户ID不能为空");
//			return res;
//		}
//		if (StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区ID不能为空");
//			return res;
//		}
//
//		try {
//			List<Map<String,Object>> list = new ArrayList<>();
//			List<Map<String,Object>>listMap=goodsActivityService.execSelectSqlListMap("SELECT id FROM t_goods_activityseries WHERE state='0' ORDER BY CONVERT(IFNULL(sort,0),SIGNED)");
//			if(null != listMap && listMap.size()>0 && null != listMap.get(0)) {
//				for (Map<String, Object> seriesMap : listMap) {
//					Map<String, Object> map = new HashMap<String, Object>();
//					List<Map<String,Object>>bannerList=goodsActivityService.execSelectSqlListMap("SELECT used AS usedType,url AS url,status AS status,CONCAT('"+filePath+"',image) AS image FROM t_banneractivity_service WHERE status='0' "
//							+ "AND (communityid='"+req.getCommunityId()+"' OR communityid='1') AND typeid='"+seriesMap.get("id").toString()+"'");
//					if(null==bannerList || bannerList.size()==0){
//						continue;
//					}
//					map.put("bannerList",bannerList);
////					List<Map<String,Object>> dataList = goodsActivityService.execSelectSqlListMap("SELECT c.count AS count,ga.goodsid AS goodsId,g.title AS goodsName,CONCAT('"+filePath+"',replace(g.image,\"/images/\",\"/_thumbs/images/\")) AS goodsImg," +
////					 		" IFNULL(gc.price,g.price) AS goodsPrice,g.goodsdesc AS goodsDesc,IF(g.type=1,1,2) AS goodsType,g.specification AS goodsSpecification,gc.stock AS goodsStock," +
////					 		" IF(IFNULL(IFNULL(p.goodscuprice,g.cuprice),'')='','',concat(ROUND(IFNULL(p.goodscuprice,g.cuprice)/IFNULL(gc.price,g.price)*10,1),'折')) AS goodsDiscount," +
////					 		" (SELECT concat('每单限购',count,'份优惠商品') FROM t_goods_community_purchase WHERE communityid='"+req.getCommunityId()+"' AND goodsid=g.id AND state='0' AND enddate >=NOW()) AS goodsPurchase " +
////					 		" FROM t_goods_activityseries_list ga LEFT JOIN t_goods g ON ga.goodsid = g.id " +
////					 		" LEFT JOIN t_goods_community gc ON gc.communityid = ga.communityid AND gc.goodsid = ga.goodsid " +
////					 		" LEFT JOIN t_goods_community_price p on p.communityid=ga.communityid and p.goodsid=ga.goodsid and NOW()>p.startdate and p.enddate>NOW() AND p.state='2' " +
////					 		" LEFT JOIN t_user_cart c ON c.goodsid = ga.goodsid and c.uid = '"+req.getUid()+"' " +
////					 		" WHERE g.state='0' AND gc.shelves='0' AND ga.communityid='"+req.getCommunityId()+"' AND ga.activityid='"+seriesMap.get("id").toString()+"' AND ga.state='0'");
//
//					GoodsCommunity gc = new GoodsCommunity();
//					gc.setCommunityid(req.getCommunityId());
//					gc.setUid(req.getUid());
//					gc.setFilePath(filePath);
//					gc.setActivityId(seriesMap.get("id").toString());
//					List<Map<String, Object>> dataList = goodsActivityService.getGoodsByActivities(gc);
//					for(int i=0;i<dataList.size();i++){
//						Map<String,Object> map1 = dataList.get(i);
//						if(Integer.valueOf(map1.get("ids").toString())>1){
//							gc.setUnifierid(map1.get("goodsId").toString());
//							gc.setFilePath(filePath);
//							List<Map<String,String>> goods = goodsCommunityService.findGoodsListByUnifier(gc);
//							map1.put("subGoods", goods);
//						}
//					}
//					if(dataList.size()>0){
//						map.put("dataList", dataList);
//						list.add(map);
//					}
//
//				}
//			}
//			 res.setDataList(list);
//		} catch (Exception e) {
//			logger.error("请求处理异常：10004" );
//			e.printStackTrace();
//		}
//		 res.setResult("0");
//		 res.setResultNote("获取成功");
//		return res;
//	}
//
//	/**
//	 * 猜你喜欢
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecRandom(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//
//			GoodsCommunity m = new GoodsCommunity();
//			m.setCommunityid(req.getCommunityId());
//			m.setGoodsid(req.getGoodsid());
//			m.setGoodsType(req.getGoodsType());
//			List<GoodsCommunity> list = goodsCommunityService.selectRandomGoods(m);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (null != list && list.size() > 0) {
//				// 查询该商品是否已存在购物车内
//				List<UserCart> cartList = userCartService.findList1(req.getUid());
//				for (GoodsCommunity gcc : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("goodsId", gcc.getGoodsid());
//					map.put("goodsName", gcc.getGoodsname());
//					map.put("goodsImg", filePath + gcc.getGoodsimg().replace("/images/", "/_thumbs/images/"));
//					map.put("goodsPrice", gcc.getGoodsprice());
//					map.put("goodsCuprice", gcc.getGoodscuprice());
//					map.put("goodsDesc", gcc.getGoodsdesc());
//					map.put("goodsContent", gcc.getContent());
//					if (!StringUtils.isBlank(gcc.getGoodscuprice())) {
//						BigDecimal bg = new BigDecimal(gcc.getGoodsprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品价
//						BigDecimal bg1 = new BigDecimal(gcc.getGoodscuprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品促销价
//						BigDecimal bg2 = new BigDecimal(10);// 折扣
//						bg2 = bg1.divide(bg, 2, BigDecimal.ROUND_HALF_UP).multiply(bg2).setScale(1,
//								BigDecimal.ROUND_HALF_UP);
//						if(bg2.compareTo(new BigDecimal(10))<0)
//							map.put("goodsDiscount", bg2.stripTrailingZeros().toPlainString() + "折");
//					}
//					if (!StringUtils.isBlank(gcc.getPurchase()) && !"0".equals(gcc.getPurchase())) {
//						map.put("goodsPurchase", "每单限购" + gcc.getPurchase() + "份优惠商品");
//					}
//					map.put("goodsSpecification", gcc.getSpecification());
//					map.put("goodsSallnum", gcc.getSallnum() + "");
//					map.put("optimizationid", gcc.getOptimizationid());
//					map.put("goodsStock", "1".equals(gcc.getType()) ? "0" : gcc.getStock() + "");
//					if ("0".equals(gcc.getType())) {
//						map.put("goodsType", "2");
//					} else if ("2".equals(gcc.getType())) {
//						map.put("goodsType", "0");
//					} else {
//						map.put("goodsType", "1");
//					}
//                        map.put("categoryId", gcc.getCategoryid());
//					if (null != cartList && !cartList.isEmpty()) {// 存在就进行数量相加
//						for (UserCart userCart : cartList) {
//
//							if (userCart.getGoodsid().equals(gcc.getGoodsid())) {
//								map.put("count", userCart.getCount() + "");
//								break;
//							}
//
//						}
//					}
//					dataList.add(map);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取我的消息成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：10459" );
//			e.printStackTrace();
//		}
//
//		return res;
//
//	}
//
//	/**
//	 * 猜你喜欢
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecRandomNew(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//
//			GoodsCommunity m = new GoodsCommunity();
//			m.setCommunityid(req.getCommunityId());
//			m.setGoodsid(req.getGoodsid());
//			m.setGoodsType(req.getGoodsType());
//			m.setUid(req.getUid());
//			List<GoodsCommunity> list = goodsCommunityService.selectRandomGoodsNew(m);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				// 查询该商品是否已存在购物车内
//				for (GoodsCommunity gcc : list) {
//					Map<String, Object> map = new HashMap<String, Object>();
//					map.put("goodsId", gcc.getGoodsid());
//					map.put("goodsName", gcc.getGoodsname());
//					map.put("goodsImg", filePath + gcc.getGoodsimg().replace("/images/", "/_thumbs/images/"));
//					map.put("goodsPrice", gcc.getGoodsprice());
//					map.put("goodsCuprice", gcc.getGoodscuprice());
//					map.put("goodsDesc", gcc.getGoodsdesc());
//					map.put("goodsContent", gcc.getContent());
//					if (!StringUtils.isBlank(gcc.getPurchase()) && !"0".equals(gcc.getPurchase())) {
//						map.put("goodsPurchase", "每单限购" + gcc.getPurchase() + "份优惠商品");
//					}
//					map.put("goodsSpecification", gcc.getSpecification());
//					map.put("goodsSallnum", gcc.getSallnum() + "");
//					map.put("optimizationid", gcc.getOptimizationid());
//					map.put("goodsStock", "1".equals(gcc.getType()) ? "0" : gcc.getStock() + "");
//					if ("0".equals(gcc.getType())) {
//						map.put("goodsType", "2");
//					} else if ("2".equals(gcc.getType())) {
//						map.put("goodsType", "0");
//					} else {
//						map.put("goodsType", "1");
//					}
//					map.put("discountPrice", gcc.getDiscountprice());
//					map.put("categoryId", gcc.getCategoryid());
//					map.put("count", gcc.getCount());
//					if(Integer.valueOf(gcc.getIds())>1){
//						m.setUnifierid(gcc.getGoodsid());
//						m.setFilePath(filePath);
//						List<Map<String,String>> goods = goodsCommunityService.findGoodsListByUnifier(m);
//						map.put("subGoods", goods);
//					}
//					dataList.add(map);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取我的消息成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：10530" );
//			e.printStackTrace();
//		}
//
//		return res;
//
//	}
//
//	/**
//	 * 3.7 加入购物车
//	 *
//	 * @param req
//	 * @return
//	 */
///*	public ResJson codec888888(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("添加失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getGoodsId())) {
//				res.setResultNote("商品ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getType())) {
//				res.setResultNote("type不能为空");
//				return res;
//			}
//
//			if(csc.shopRest()){
//				res.setResultNote("凌晨0点至7点商家休息");
//				return res;
//			}
//
//			String type;
//			if ("0".equals(req.getType())||"2".equals(req.getType())) {
//				type = "2";
//			} else {
//				type = req.getType();
//			}
//			Tuser user = tuserService.get(req.getUid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//				return res;
//			}
//			if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户已禁用");
//				return res;
//			}
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//			Map<String, String> merchantRest = communityService.execSelectSqlEntityMap("SELECT startTime AS startTime,endTime AS endTime FROM t_merchant_rest "
//					+ "WHERE NOW() >= startTime AND NOW() <= endTime AND communityid ='"+user.getCommunityid()+"' AND state=0");
//			if(null != merchantRest && merchantRest.size()>0) {
//				res.setResultNote("商家"+sf.format(merchantRest.get("startTime"))+"至"+sf.format(merchantRest.get("endTime"))+"打烊");
//				return res;
//			}
//			GoodsCommunity gc=goodsCommunityService.gets(user.getCommunityid(), req.getGoodsId());
//			if(null==gc||"1".equals(gc.getShelves())){
//				res.setResultNote("该商品未上架，请联系商家");
//				return res;
//			}
//			if(StringUtils.isNotBlank(gc.getGoodscuprice())&&0>=Double.valueOf(gc.getGoodscuprice())||0>=Double.valueOf(gc.getGoodsprice())){
//				res.setResultNote("商品售价存在问题，请联系商家");
//				return res;
//			}
//
//			Map<String, Object> nowCount = Maps.newHashMap();
//			UserCart userCart = new UserCart();
//			// userCart.setType(type);
//			userCart.setUid(req.getUid());
//			userCart.setGoodsid(req.getGoodsId());
//			userCart.setCommunityId(user.getCommunityid());
//			// 查询该商品是否已存在购物车内
//			List<UserCart> cartList = userCartService.findGoodsInfoByUser(userCart);
//			UserCart goodsCartInfo = cartList.get(0);//商品信息包含购物车、购买等信息
//			if (null != cartList && !cartList.isEmpty()&&Integer.valueOf(cartList.get(0).getCount())>0) {// 存在就进行数量相加
//				UserCart cart = cartList.get(0);
//				cart.setAdtime(new Date());
//				cart.setCount(cart.getCount() + req.getCount());
//				if (cart.getCount() == 0) {
//					userCartService.deleteById(cart.getId());
//				} else if (cart.getCount() > 0) {
//					if (!"1".equals(req.getType())) {
//						if (goodsCartInfo.getStock() < cart.getCount()) {
//							cart.setCount(goodsCartInfo.getStock());
//							userCartService.update(cart);
//							nowCount.put("nowCount", cart.getCount());
//							nowCount.put("allCount", cart.getAllcount() - cart.getCount() + goodsCartInfo.getStock());
//							res.setObject(nowCount);
//							res.setResultNote("库存不足");
//							return res;
//						}
//                        if (req.getCount() >= 0) {
//                            if(null != goodsCartInfo.getPurchase()&&!"".equals(goodsCartInfo.getPurchase()+"")) {
//							Integer purchase = goodsCartInfo.getPurchase();
//							if (purchase > 0) {
//								if (goodsCartInfo.getCurbuynum() >= purchase) {
//									res.setResultNote(goodsCartInfo.getGoodstitle() + "限购" + purchase + "件,您已购买"
//											+ goodsCartInfo.getCurbuynum() + "件!");
//									return res;
//								}
//								if (cart.getCount() > purchase) {
//									res.setResultNote(goodsCartInfo.getGoodstitle() + "限购" + purchase + "件");
//									return res;
//								}
//								if((goodsCartInfo.getCurbuynum()+cart.getCount())>purchase) {
//									res.setResultNote("该商品限购" + purchase + "件，您已下单购买过"+goodsCartInfo.getCurbuynum()+"件");
//									return res;
//								}
//							}
//						}
//                      }
//					}
//
//					userCartService.update(cart);
//				} else {
//					cart.setCount(1);
//					userCartService.update(cart);
//					nowCount.put("nowCount", cart.getCount());
//					nowCount.put("allCount", cart.getAllcount() + cart.getCount());
//					res.setObject(nowCount);
//					res.setResultNote("购物车不可为负,请重新操作");
//					return res;
//				}
//
//				nowCount.put("nowCount", cart.getCount());
//				nowCount.put("allCount", cart.getAllcount() + req.getCount());
//				res.setObject(nowCount);
//				res.setResult("0");
//				res.setResultNote("添加成功");
//				return res;
//			} else {// 不存在，进行添加操作
//				UserCart cart = new UserCart();
//				cart.setUid(req.getUid());
//                cart.setGoodsid(req.getGoodsId());
//				cart.setId(IdGen.uuid());
//				cart.setType(type);
//				if (req.getCount() < 0) {//判断请求数量不能为负
//					cart.setCount(1);
//					userCartService.update(cart);
//					nowCount.put("nowCount", cart.getCount());
//					nowCount.put("allCount", goodsCartInfo.getAllcount() == 0 ? 1
//							: goodsCartInfo.getAllcount() - cart.getCount() + 1);
//					res.setObject(nowCount);
//					res.setResultNote("购物车不可为负,请重新操作");
//					return res;
//				}
//				cart.setCount(req.getCount());
//				cart.setAdtime(new Date());
////				cart.setStock(null==cart.getStock()?0:cart.getStock());
//				if (!"1".equals(req.getType())) {//商品分类不为洗衣洗鞋
//					if (goodsCartInfo.getStock() < cart.getCount()) {
//						cart.setCount(goodsCartInfo.getStock());
//						userCartService.update(cart);
//						nowCount.put("nowCount", cart.getCount());
//						nowCount.put("allCount", goodsCartInfo.getAllcount() == 0 ? 1
//								: goodsCartInfo.getAllcount() - cart.getCount() + goodsCartInfo.getStock());
//						res.setObject(nowCount);
//						res.setResultNote("库存不足");
//						return res;
//					}
//				}
//				if(null != goodsCartInfo.getPurchase()&&!"".equals(goodsCartInfo.getPurchase()+"")) {
//					int purchase = Integer.valueOf(goodsCartInfo.getPurchase()).intValue();
//					if (purchase > 0) {//限购
//						int curbuysum = Integer.valueOf(goodsCartInfo.getCurbuynum()).intValue();
//						if (curbuysum >= purchase) {
//							res.setResultNote("该商品限购" + purchase + "件,您已购买" + curbuysum + "件!");
//							return res;
//						}
//						if (cart.getCount() > purchase) {
//							res.setResultNote("该商品限购" + purchase + "件");
//							return res;
//						}
//						if((curbuysum+cart.getCount())>purchase) {
//							res.setResultNote("该商品限购" + purchase + "件，您已下单购买过"+curbuysum+"件");
//							return res;
//						}
//					}
//				}
//				userCartService.addUserCart(cart);
////				List<Object> goodCount = userCartService.executeSelectSql("SELECT count FROM t_user_cart WHERE uid = '"
////						+ req.getUid() + "' " + "AND goodsid='" + req.getGoodsId() + "'");
////				if (null != goodCount && goodCount.size() > 0 && null != goodCount.get(0)&&"0".equals(goodCount.get(0).toString())) {
////					userCartService.delete3(req.getUid(), req.getGoodsId());
////				}
//				res.setResult("0");
//				res.setResultNote("添加成功");
//				nowCount.put("nowCount", cart.getCount());
//				nowCount.put("allCount",
//						goodsCartInfo.getAllcount() == 0 ? 1 : goodsCartInfo.getAllcount() + 1);
//				nowCount.put("cartId", cart.getId());
//				res.setObject(nowCount);
//				return res;
//			}
//
//		} catch (Exception e) {
//			logger.error("请求处理异常：10293" );
//			e.printStackTrace();
//		}
//		return res;
//	}*/
//	/*添加购物车*/
//	public ResJson codec(AddUserCartReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("添加失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getGoodsId())) {
//				res.setResultNote("商品ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getType())) {
//				res.setResultNote("type不能为空");
//				return res;
//			}
//			String note = csc.shopRest();
//			if(StringUtils.isNotBlank(note)){
//				res.setResultNote(note);
//				return res;
//			}
//
//			String type;
//			if ("0".equals(req.getType())||"2".equals(req.getType())) {
//				type = "2";
//			} else {
//				type = req.getType();
//			}
//			Tuser user = tuserService.get(req.getUid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//				return res;
//			}
//			if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户已禁用");
//				return res;
//			}
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//			Map<String, String> merchantRest = communityService.execSelectSqlEntityMap("SELECT startTime AS startTime,endTime AS endTime FROM t_merchant_rest "
//					+ "WHERE NOW() >= startTime AND NOW() <= endTime AND communityid ='"+user.getCommunityid()+"' AND state=0");
//			if(null != merchantRest && merchantRest.size()>0) {
//				res.setResultNote("商家"+sf.format(merchantRest.get("startTime"))+"至"+sf.format(merchantRest.get("endTime"))+"打烊");
//				return res;
//			}
//			GoodsCommunity gc=goodsCommunityService.gets(user.getCommunityid(), req.getGoodsId());
//			if(StringUtils.isBlank(req.getActivityid())){
//				if(null==gc||"1".equals(gc.getShelves())){
//					res.setResultNote("该商品未上架，请联系商家");
//					return res;
//				}
//				if(StringUtils.isNotBlank(gc.getGoodscuprice())&&0>=Double.valueOf(gc.getGoodscuprice())||0>=Double.valueOf(gc.getGoodsprice())){
//					res.setResultNote("商品售价存在问题，请联系商家");
//					return res;
//				}
//			}
//
//			Map<String, Object> nowCount = Maps.newHashMap();
//			UserCart userCart = new UserCart();
//			// userCart.setType(type);
//			userCart.setUid(req.getUid());
//			userCart.setGoodsid(req.getGoodsId());
//			userCart.setCommunityId(user.getCommunityid());
//			List<UserCart> cartList=null;
//			//查询该商品是否已存在购物车内
//			if(StringUtils.isNotBlank(req.getActivityid())){
//				userCart.setActivityid(req.getActivityid());
//				cartList=userCartService.findGoodsInfoByUserTwo(userCart);
//			}else{
//			// 查询该商品是否已存在购物车内
//				cartList = userCartService.findGoodsInfoByUser(userCart);
//			}
//			UserCart goodsCartInfo = cartList.get(0);//商品信息包含购物车、购买等信息
//			if (null != cartList && !cartList.isEmpty()&&Integer.valueOf(cartList.get(0).getCount())>0) {// 存在就进行数量相加
//				UserCart cart = cartList.get(0);
//				cart.setAdtime(new Date());
//				cart.setCount(cart.getCount() + req.getCount());
//				if (cart.getCount() == 0) {
//					userCartService.deleteById(cart.getId());
//				} else if (cart.getCount() > 0) {
//					if (!"1".equals(req.getType())) {
//						if (goodsCartInfo.getStock() < cart.getCount()) {
//							cart.setCount(goodsCartInfo.getStock());
//							userCartService.update(cart);
//							nowCount.put("nowCount", cart.getCount());
//							nowCount.put("allCount", cart.getAllcount() - cart.getCount() + goodsCartInfo.getStock());
//							res.setObject(nowCount);
//							res.setResultNote("库存不足");
//							return res;
//						}
//                        if (req.getCount() >= 0) {
//                            if(null != goodsCartInfo.getPurchase()&&!"".equals(goodsCartInfo.getPurchase()+"")) {
//							Integer purchase = goodsCartInfo.getPurchase();
//							if (purchase > 0) {
//								if (goodsCartInfo.getCurbuynum() >= purchase) {
//									res.setResultNote(goodsCartInfo.getGoodstitle() + "限购" + purchase + "件,您已购买"
//											+ goodsCartInfo.getCurbuynum() + "件!");
//									return res;
//								}
//								if (cart.getCount() > purchase) {
//									res.setResultNote(goodsCartInfo.getGoodstitle() + "限购" + purchase + "件");
//									return res;
//								}
//								if((goodsCartInfo.getCurbuynum()+cart.getCount())>purchase) {
//									res.setResultNote("该商品限购" + purchase + "件，您已下单购买过"+goodsCartInfo.getCurbuynum()+"件");
//									return res;
//								}
//							}
//						}
//                      }
//					}
//
//					userCartService.update(cart);
//				} else {
//					cart.setCount(1);
//					userCartService.update(cart);
//					nowCount.put("nowCount", cart.getCount());
//					nowCount.put("allCount", cart.getAllcount() + cart.getCount());
//					res.setObject(nowCount);
//					res.setResultNote("购物车不可为负,请重新操作");
//					return res;
//				}
//
//				nowCount.put("nowCount", cart.getCount());
//				nowCount.put("allCount", cart.getAllcount() + req.getCount());
//				res.setObject(nowCount);
//				res.setResult("0");
//				res.setResultNote("添加成功");
//				return res;
//			} else {// 不存在，进行添加操作
//				UserCart cart = new UserCart();
//				cart.setUid(req.getUid());
//                cart.setGoodsid(req.getGoodsId());
//				cart.setId(IdGen.uuid());
//				cart.setType(type);
//				if(StringUtils.isNotBlank(req.getActivityid())){
//					cart.setActivityid(req.getActivityid());
//				}
//				if (req.getCount() < 0) {//判断请求数量不能为负
//					cart.setCount(1);
//					userCartService.update(cart);
//					nowCount.put("nowCount", cart.getCount());
//					nowCount.put("allCount", goodsCartInfo.getAllcount() == 0 ? 1
//							: goodsCartInfo.getAllcount() - cart.getCount() + 1);
//					res.setObject(nowCount);
//					res.setResultNote("购物车不可为负,请重新操作");
//					return res;
//				}
//				cart.setCount(req.getCount());
//				cart.setAdtime(new Date());
////				cart.setStock(null==cart.getStock()?0:cart.getStock());
//				if (!"1".equals(req.getType())) {//商品分类不为洗衣洗鞋
//					if (goodsCartInfo.getStock() < cart.getCount()) {
//						cart.setCount(goodsCartInfo.getStock());
//						userCartService.update(cart);
//						nowCount.put("nowCount", cart.getCount());
//						nowCount.put("allCount", goodsCartInfo.getAllcount() == 0 ? 1
//								: goodsCartInfo.getAllcount() - cart.getCount() + goodsCartInfo.getStock());
//						res.setObject(nowCount);
//						res.setResultNote("库存不足");
//						return res;
//					}
//				}
//				if(null != goodsCartInfo.getPurchase()&&!"".equals(goodsCartInfo.getPurchase()+"")) {
//					int purchase = Integer.valueOf(goodsCartInfo.getPurchase()).intValue();
//					if (purchase > 0) {//限购
//						int curbuysum = Integer.valueOf(goodsCartInfo.getCurbuynum()).intValue();
//						if (curbuysum >= purchase) {
//							res.setResultNote("该商品限购" + purchase + "件,您已购买" + curbuysum + "件!");
//							return res;
//						}
//						if (cart.getCount() > purchase) {
//							res.setResultNote("该商品限购" + purchase + "件");
//							return res;
//						}
//						if((curbuysum+cart.getCount())>purchase) {
//							res.setResultNote("该商品限购" + purchase + "件，您已下单购买过"+curbuysum+"件");
//							return res;
//						}
//					}
//				}
//				userCartService.addUserCart(cart);
////				List<Object> goodCount = userCartService.executeSelectSql("SELECT count FROM t_user_cart WHERE uid = '"
////						+ req.getUid() + "' " + "AND goodsid='" + req.getGoodsId() + "'");
////				if (null != goodCount && goodCount.size() > 0 && null != goodCount.get(0)&&"0".equals(goodCount.get(0).toString())) {
////					userCartService.delete3(req.getUid(), req.getGoodsId());
////				}
//				res.setResult("0");
//				res.setResultNote("添加成功");
//				nowCount.put("nowCount", cart.getCount());
//				nowCount.put("allCount",
//						goodsCartInfo.getAllcount() == 0 ? 1 : goodsCartInfo.getAllcount() + 1);
//				nowCount.put("cartId", cart.getId());
//				res.setObject(nowCount);
//				return res;
//			}
//
//		} catch (Exception e) {
//			logger.error("请求处理异常：10293" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//	/**
//	 * 3.8 提交订单
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec(AddCartGoodsOrderReq req) {
//		AddGoodsOrderRes res = new AddGoodsOrderRes();
//		res.setResultNote("提交失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getAddressId())) {
//				res.setResultNote("请选择收货地址");
//				return res;
//			}
//			// 判断用户状态
//			Tuser tuser = tuserService.get(req.getUid());
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户已被禁用");
//				return res;
//			}
//			Community c = communityService.get(tuser.getCommunityid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该商家暂时不能下单");
//				return res;
//			}
//			// 获取收货地址
//			Address address = addressService.get(req.getAddressId());
//			if (null == address) {
//				res.setResultNote("收货地址不存在");
//				return res;
//			}
//			if (req.getGoodsList() == null || req.getGoodsList().size() == 0) {
//				res.setResultNote("请选择要购买的商品");
//				return res;
//			}
//
//			// 查询库存是否足够
//			if (!"1".equals(req.getType())) {
//				List<GoodsListBean> slist = req.getGoodsList();
//				for (GoodsListBean gs : slist) {
//					GoodsCommunity g = goodsCommunityService.gets(tuser.getCommunityid(), gs.getGoodsId());
//					if (g.getShelves().equals("1")||g.getGoodsState().equals("1")){
//						res.setResultNote(g.getGoodsname() + "已下架");
//						return res;
//					}
//					if (gs.getCount() > g.getStock()) {
//						res.setResultNote("库存不足");
//						return res;
//					}
//				}
//			}
//			// 库存足够创建订单
//			try {
//				UserOrder o = new UserOrder();
//				String orderId = StringUtil.getOrderNo();
//				o.setId(IdGen.uuid());
//				o.setUid(req.getUid());
//				o.setCommunityid(tuser.getCommunityid());
//				o.setUsername(address.getUsername());
//				o.setUserphone(address.getUserphone());
//				o.setUsercity(address.getCity());
//				o.setUseraddress(address.getAddress());
//				o.setOrdertype(req.getType());
//				o.setAllprice(req.getAllprice());
//				o.setPayprice(req.getPayprice());
//				o.setStatus("1");
//				o.setIsaccount("0");
//				o.setMessage(req.getMessage());
//				o.setShopmessage("");
//				if (req.getSecuritiesid() != null && !"".equals(req.getSecuritiesid())) {
//					// 使用优惠券
//					UserCoupon uc = userCouponService.get(req.getSecuritiesid());
////					uc.setStatus("1");
////					userCouponService.update1(uc);
//					o.setCouponid(req.getSecuritiesid());
//					o.setCouponmoney(uc.getAmount() + "");
//					BigDecimal b = new BigDecimal(req.getPayprice());
//					BigDecimal payprice = b.setScale(2, BigDecimal.ROUND_HALF_UP);
//					b = new BigDecimal(req.getAllprice());
//					BigDecimal allprice = b.setScale(2, BigDecimal.ROUND_HALF_UP);
//					b = new BigDecimal(uc.getAmount());
//					BigDecimal amount = b.setScale(2, BigDecimal.ROUND_HALF_UP);
//					if (payprice.compareTo(allprice.subtract(amount)) != 0) {
//						res.setResultNote("支付金额出现问题，请查看");
//						return res;
//					}
//				}
//
//				o.setOrdernum(orderId);
//				o.setAdtime(new Date());
//				o.setUpdatetime(new Date());
//				List<GoodsListBean> glist = req.getGoodsList();
//				List<UserOrderlist> orderList = new ArrayList<UserOrderlist>();
//				for (int i = 0; i < glist.size(); i++) {
//					Goods g = new Goods();
//					g.setId(glist.get(i).getGoodsId());
//					g.setCommunityid(tuser.getCommunityid());
//					g = goodsService.gets(g);
//
//					List<Object> goodCount = userCartService.executeSelectSql("SELECT count FROM t_user_cart WHERE uid = '"
//							+ req.getUid() + "' " + "AND goodsid='" + glist.get(i).getGoodsId() + "'");
//					if (null != goodCount && goodCount.size() > 0 && null != goodCount.get(0)&& !"0".equals(goodCount.get(0).toString())) {
//						UserOrderlist userOrderlist = new UserOrderlist();
//						userOrderlist.setId(IdGen.uuid());
//						userOrderlist.setOrdernum(orderId);
//						userOrderlist.setGoodsid(glist.get(i).getGoodsId());
//						userOrderlist.setGoodstitle(g.getTitle());
//						userOrderlist.setGoodsimage(g.getImage());
//						userOrderlist.setGoodsdesc(g.getGoodsdesc());
//						userOrderlist.setGoodsSpecification(g.getSpecification());
//						if (glist.get(i).getCount() < 0) {
//							res.setResultNote("订单异常，请返回查看");
//							return res;
//						}
//						userOrderlist.setGoodsnum(glist.get(i).getCount());
//						if (g.getCuprice() != null && g.getCuprice() > 0) {
//							userOrderlist.setGoodsprice(g.getCuprice());
//						} else {
//							userOrderlist.setGoodsprice(g.getPrice());
//						}
//						userOrderlist.setOriginalprice(g.getPrice());
//						userOrderlist.setPurchaseprice(g.getPurchaseprice());
//						userOrderlist.setAdtime(new Date());
//						orderList.add(userOrderlist);
//					}else {
//						res.setResultNote("您已提交订单，请查看");
//						return res;
//					}
//					// 删除对应购物车
//					userCartService.delete3(req.getUid(), g.getId());
//				}
//				// 生成订单
//				userOrderService.addOrder(o, orderList);
//				// 使用优惠券
//				if (req.getSecuritiesid() != null && !"".equals(req.getSecuritiesid())) {
//					UserCoupon uc = userCouponService.get(req.getSecuritiesid());
//					uc.setStatus("1");
//					userCouponService.update1(uc);
//				}
//				// 生成订单号
//				OrderType ot = new OrderType();
//				ot.setId(IdGen.uuid());
//				ot.setUid(req.getUid());
//				ot.setType("1");
//				ot.setState("0");
//				ot.setOrdernum(orderId);
//				orderTypeMapper.insert(ot);
//				// 减少库存，增加销量
//				UserOrderlist uol = new UserOrderlist();
//				uol.setOrdernum(orderId);
//				List<UserOrderlist> list1 = userOrderlistService.findList(uol);
//				if (list1 != null && list1.size() > 0) {
//					for (UserOrderlist od : list1) {
//						GoodsCommunity g = goodsCommunityService.getGoodsStock(o.getCommunityid(), od.getGoodsid());
//						if (!"1".equals(g.getType())) {
//							g.setStock(g.getStock() - od.getGoodsnum());
//						}
//						g.setSallnum(Integer.valueOf(g.getCount()) + od.getGoodsnum());
//						goodsCommunityService.save(g);
//					}
//				}
//
//				res.setOderNum(orderId);
//				res.setBalance(tuser.getBalance() + "");
//				res.setResult("0");
//				res.setResultNote("提交订单成功");
//			} catch (Exception e) {
//				logger.error("请求处理异常：10474" );
//				e.printStackTrace();
//			}
//
//		} catch (Exception e) {
//			logger.error("请求处理异常：10479" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.8 提交订单 1.03版本更新
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecTreeVersion(AddCartGoodsOrderNewReq req) {
//		AddGoodsOrderRes res = new AddGoodsOrderRes();
//		res.setResultNote("提交失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getAddressId())) {
//				res.setResultNote("请选择收货地址");
//				return res;
//			}
//			// 判断用户状态
//			Tuser tuser = tuserService.get(req.getUid());
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户已被禁用");
//				return res;
//			}
//
//			Community c = communityService.get(tuser.getCommunityid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该商家暂时不能下单");
//				return res;
//			}
//
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//			Map<String, String> merchantRest = communityService.execSelectSqlEntityMap("SELECT startTime AS startTime,endTime AS endTime FROM t_merchant_rest "
//					+ "WHERE NOW() >= startTime AND NOW() <= endTime AND communityid ='"+tuser.getCommunityid()+"' AND state=0");
//			if(null != merchantRest && merchantRest.size()>0) {
//				res.setResultNote("商家"+sf.format(merchantRest.get("startTime"))+"至"+sf.format(merchantRest.get("endTime"))+"打烊");
//				return res;
//			}
//
//			// 获取收货地址
//			Address address = addressService.get(req.getAddressId());
//			if (null == address) {
//				res.setResultNote("收货地址不存在");
//				return res;
//			}
//			if (req.getGoodsList() == null || req.getGoodsList().size() == 0) {
//				res.setResultNote("请选择要购买的商品");
//				return res;
//			}
//
//			// 查询库存是否足够
//			try {
//				if (!"1".equals(req.getType())) {
//					List<GoodsListBean> slist = req.getGoodsList();
//					for (GoodsListBean gs : slist) {
//						GoodsCommunity g = goodsCommunityService.gets(tuser.getCommunityid(), gs.getGoodsId());
//						if (g.getShelves().equals("1")||g.getGoodsState().equals("1")){
//							res.setResultNote(g.getGoodsname() + "已下架");
//							return res;
//						}
//						if (gs.getCount() > g.getStock()) {
//							res.setResultNote("库存不足");
//							return res;
//						}
//						if(StringUtils.isNotBlank(g.getGoodscuprice())&&0>=Double.valueOf(g.getGoodscuprice())||0>=Double.valueOf(g.getGoodsprice())){
//							res.setResultNote("["+g.getGoodsname()+"]商品售价存在问题，请联系商家");
//							return res;
//						}
//					}
//				}
//			} catch (Exception e) {
//				logger.error("请求处理异常：10545" );
//				e.printStackTrace();
//			}
//
//			Map<String, String> mapMD = new HashMap<String, String>();
//			// DecimalFormat df = new DecimalFormat("#.00");
//			String value = csc.selectDictTypeValue("sys_code");
//			mapMD.put("uid", req.getUid());
//			mapMD.put("allprice", req.getAllprice());
//			mapMD.put("payprice", req.getPayprice());
//			mapMD.put("dictvalue", value);
//			if (!MD5.getMD5(mapMD).equals(req.getSign())) {
//				res.setResultNote("支付金额出现问题，请查看");
//				return res;
//			}
//
//			// 库存足够创建订单
//			try {
//				UserOrder o = new UserOrder();
//				String orderId = StringUtil.getOrderNo();
//				o.setId(IdGen.uuid());
//				o.setUid(req.getUid());
//				o.setCommunityid(tuser.getCommunityid());
//				o.setUsername(address.getUsername());
//				o.setUserphone(address.getUserphone());
//				o.setUsercity(address.getCity());
//				o.setUseraddress(address.getAddress());
//				o.setOrdertype(req.getType());
//				o.setAllprice(StringUtils.isBlank(req.getAllprice()) ? 0 : Double.valueOf(req.getAllprice()));
//				o.setPayprice(StringUtils.isBlank(req.getPayprice()) ? 0 : Double.valueOf(req.getPayprice()));
//				o.setStatus("1");
//				o.setIsaccount("0");
//				o.setMessage(req.getMessage());
//				o.setShopmessage("");
//				if (req.getSecuritiesid() != null && !"".equals(req.getSecuritiesid())) {
//					// 使用优惠券
//					UserCoupon uc = userCouponService.get(req.getSecuritiesid());
////					uc.setStatus("1");
////					userCouponService.update1(uc);
//					o.setCouponid(req.getSecuritiesid());
//					o.setCouponmoney(uc.getAmount() + "");
//					BigDecimal b = new BigDecimal(req.getPayprice().replaceAll(",", ""));
//					BigDecimal payprice = b.setScale(2, BigDecimal.ROUND_HALF_UP);
//					b = new BigDecimal(req.getAllprice().replaceAll(",", ""));
//					BigDecimal allprice = b.setScale(2, BigDecimal.ROUND_HALF_UP);
//					b = new BigDecimal(uc.getAmount());
//					BigDecimal amount = b.setScale(2, BigDecimal.ROUND_HALF_UP);
//					if (payprice.compareTo(allprice.subtract(amount)) != 0) {
//						res.setResultNote("支付金额出现问题，请查看");
//						return res;
//					}
//				}
//
//				o.setOrdernum(orderId);
//				o.setAdtime(new Date());
//				o.setUpdatetime(new Date());
//				List<GoodsListBean> glist = req.getGoodsList();
//				List<UserOrderlist> orderList = new ArrayList<UserOrderlist>();
//				for (int i = 0; i < glist.size(); i++) {
//					Goods g = new Goods();
//					g.setId(glist.get(i).getGoodsId());
//					g.setCommunityid(tuser.getCommunityid());
//					g = goodsService.gets(g);
//					List<Object> goodCount = userCartService.executeSelectSql("SELECT count FROM t_user_cart WHERE uid = '"
//							+ req.getUid() + "' " + "AND goodsid='" + glist.get(i).getGoodsId() + "'");
//					if (null != goodCount && goodCount.size() > 0 && null != goodCount.get(0)&& !"0".equals(goodCount.get(0).toString())) {
//						UserOrderlist userOrderlist = new UserOrderlist();
//						userOrderlist.setId(IdGen.uuid());
//						userOrderlist.setOrdernum(orderId);
//						userOrderlist.setGoodsid(glist.get(i).getGoodsId());
//						userOrderlist.setGoodstitle(g.getTitle());
//						userOrderlist.setGoodsimage(g.getImage());
//						userOrderlist.setGoodsdesc(g.getGoodsdesc());
//						userOrderlist.setGoodsSpecification(g.getSpecification());
//						if (glist.get(i).getCount() < 0) {
//							res.setResultNote("订单异常，请返回查看");
//							return res;
//						}
//						userOrderlist.setGoodsnum(glist.get(i).getCount());
//						if (g.getCuprice() != null && g.getCuprice() > 0) {
//							userOrderlist.setGoodsprice(g.getCuprice());
//						} else {
//							userOrderlist.setGoodsprice(g.getPrice());
//						}
//						userOrderlist.setOriginalprice(g.getPrice());
//						userOrderlist.setPurchaseprice(g.getPurchaseprice());
//						userOrderlist.setAdtime(new Date());
//						orderList.add(userOrderlist);
//
//						Map<String,Object> ob = userCartService.execSelectSqlEntityObjMap(
//								"SELECT count,startdate,enddate FROM t_goods_community_purchase WHERE communityid='"+tuser.getCommunityid()+"' AND goodsid='"+g.getId()+"' AND state='0' AND enddate>=NOW()");
//						if (null != ob) {
//							Integer purchase = Integer.valueOf(ob.get("count").toString());
//							if (purchase > 0) {
//
//								String order = userCartService.execSelectSqlString(
//										"SELECT IFNULL(SUM(b.goodsnum),0) from t_user_order a,t_user_orderlist b "
//												+ "where a.ordernum = b.ordernum and a.uid = '" + tuser.getId()
//												+ "' and b.goodsid = '" + userOrderlist.getGoodsid() + "' "
//												+ " and a.status not in (9,12) and a.adtime>='"+ob.get("startdate")+"'");
//								if (null != order && !"".equals(order)) {
//									if (Integer.valueOf(order) >= purchase) {
//										res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已购买"+ order+ "件!");
//										return res;
//									}
//
//									if((userOrderlist.getGoodsnum()+Integer.valueOf(order))>purchase) {
//										res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已下单购买过"+ order+ "件!");
//										return res;
//									}
//								}
//								if (userOrderlist.getGoodsnum() > purchase) {
//									res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件");
//									return res;
//								}
//							}
//						}
//					}else {
//						res.setResultNote("您已提交订单，请查看");
//						return res;
//					}
//					// 删除对应购物车
//					userCartService.delete3(req.getUid(), g.getId());
//				}
//
//				// 生成订单
//				userOrderService.addOrder(o, orderList);
//				// 使用优惠券
//				if (req.getSecuritiesid() != null && !"".equals(req.getSecuritiesid())) {
//					UserCoupon uc = userCouponService.get(req.getSecuritiesid());
//					uc.setStatus("1");
//					userCouponService.update1(uc);
//				}
//				// 生成订单号
//				OrderType ot = new OrderType();
//				ot.setId(IdGen.uuid());
//				ot.setUid(req.getUid());
//				ot.setType("1");
//				ot.setState("0");
//				ot.setOrdernum(orderId);
//				orderTypeMapper.insert(ot);
//				// 减少库存，增加销量
//				UserOrderlist uol = new UserOrderlist();
//				uol.setOrdernum(orderId);
//				List<UserOrderlist> list1 = userOrderlistService.findList(uol);
//				if (list1 != null && list1.size() > 0) {
//					for (UserOrderlist od : list1) {
//						GoodsCommunity g = goodsCommunityService.getGoodsStock(o.getCommunityid(), od.getGoodsid());
//						if (!"1".equals(g.getType())) {
//							g.setStock(g.getStock() - od.getGoodsnum());
//						}
//						g.setSallnum(Integer.valueOf(g.getCount()) + od.getGoodsnum());//只是基础销量增加，不能加入刷量
//						goodsCommunityService.save(g);
//					}
//				}
//
//				res.setOderNum(orderId);
//				res.setBalance(tuser.getBalance() + "");
//				res.setResult("0");
//				res.setResultNote("提交订单成功");
//			} catch (Exception e) {
//				logger.error("请求处理异常：10702" );
//				e.printStackTrace();
//			}
//
//		} catch (Exception e) {
//			logger.error("请求处理异常：10707" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 扫码
//	 * @param req
//	 * @return
//	 */
//	public ResJson getScanQRCode(AddSettleAccountsReq req,HttpServletRequest request) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		if(StringUtils.isBlank(req.getGoodsCode())) {
//			res.setResultNote("条形码为空");
//			return res;
//		}
//
//		if(StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区id为空");
//			return res;
//		}
//		try {
//			List<GoodsCommunity> gcl=goodsCommunityService.selectGoodsCode(req.getCommunityId(),req.getGoodsCode());
//			boolean flag = false;//版本控制 默认为老版本
//			String agent = request.getHeader("user-agent");
//			String version = "1.0.0";
//			if(agent.contains("Android")){
//				version = agent.substring(agent.indexOf(":")+1, agent.indexOf("/"));
//			}else if(agent.contains("iOS")){
//				version = agent.substring(agent.indexOf("/")+1, agent.indexOf(" "));
//			}
//			if((agent.contains("Android")&&com.jeeplus.common.utils.StringUtils.compareVersion(version,"1.3.3")>=0)
//					||(agent.contains("iOS")&&com.jeeplus.common.utils.StringUtils.compareVersion(version,"1.4.0")>=0)){//模糊搜索返回商品列表
//				flag = true;//新版本
//			}
//
//			if(null == gcl|| gcl.size()==0) {//如果精确搜不到
//				if(flag){//模糊搜索返回商品列表
//					String goodscode = req.getGoodsCode();
//					if(goodscode.length()>9){
//						goodscode = req.getGoodsCode().substring(0, 9);
//					}
//					gcl=goodsCommunityService.selectGoodsCode(req.getCommunityId(),goodscode+"%");
//					if(null == gcl|| gcl.size()==0) {//如果搜不到
//						res.setResultNote("商品库目前无商品条码");
//						return res;
//					}
//				}else{
//					res.setResultNote("商品库目前无商品条码");
//					return res;
//				}
//			}
//			List<Map<String,String>> ls = Lists.newArrayList();
//			for(int i = 0;i<gcl.size();i++){
//				Map<String,String> map = new HashMap<>();
//				map.put("goodsId", gcl.get(i).getGoodsid());
//				map.put("goodsName", gcl.get(i).getGoodsname());
//				map.put("goodsImg", filePath + gcl.get(i).getGoodsimg().replace("/images/", "/_thumbs/images/"));
//				map.put("goodsPrice", gcl.get(i).getGoodsprice());
//				map.put("goodsCuprice", gcl.get(i).getGoodscuprice());
//				map.put("goodsDesc", gcl.get(i).getGoodsdesc());
//				map.put("goodsContent", gcl.get(i).getContent());
//				/*if (!StringUtils.isBlank(gcc.getGoodscuprice())) {
//					BigDecimal bg = new BigDecimal(gcc.getGoodsprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品价
//					BigDecimal bg1 = new BigDecimal(gcc.getGoodscuprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);// 商品促销价
//					BigDecimal bg2 = new BigDecimal(10);// 折扣
//					bg2 = bg1.divide(bg, 2, BigDecimal.ROUND_HALF_UP).multiply(bg2).setScale(1,
//							BigDecimal.ROUND_HALF_UP);
//					if(bg2.compareTo(new BigDecimal(10))<0)
//						map.put("goodsDiscount", bg2.stripTrailingZeros().toPlainString() + "折");
//				}
//				if (!StringUtils.isBlank(gcc.getPurchase()) && !"0".equals(gcc.getPurchase())) {
//					map.put("goodsPurchase", "每单限购" + gcc.getPurchase() + "份优惠商品");
//				}*/
//				map.put("discountPrice", gcl.get(i).getDiscountprice());
//				map.put("goodsSpecification", gcl.get(i).getSpecification());
//				map.put("goodsSallnum", gcl.get(i).getSallnum() + "");
//				map.put("goodsStock", gcl.get(i).getStock()+"");
//				map.put("goodsType", gcl.get(i).getType());
//				map.put("goodsShelves", (gcl.get(i).getShelves().equals("0")&&gcl.get(i).getGoodsState().equals("0"))?"0":"1");
//				map.put("categoryId", gcl.get(i).getCategoryid());
//				ls.add(map);
//			}
//			if(flag){//新
//				res.setData(ls);
//			}else{//老
//				res.setObject(ls.get(0));
//			}
//		}catch (Exception e) {
//			logger.error("请求处理异常：10756" );
//			e.printStackTrace();
//		}
//		res.setResult("0");
//		res.setResultNote("获取成功");
//		return res;
//	}
//
//	/**
//	 * 扫码 提交订单
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson getSubmitCodeOrder(AddCartGoodsOrderReq req) {
//		AddGoodsOrderRes res = new AddGoodsOrderRes();
//		res.setResultNote("提交失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			// 判断用户状态
//			Tuser tuser = tuserService.get(req.getUid());
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户已被禁用");
//				return res;
//			}
//			Community c = communityService.get(tuser.getCommunityid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//
//			if (req.getGoodsList() == null || req.getGoodsList().size() == 0) {
//				res.setResultNote("请选择要购买的商品");
//				return res;
//			}
//
//			// 查询库存是否足够
//			try {
//				if (!"1".equals(req.getType())) {
//					List<GoodsListBean> slist = req.getGoodsList();
//					for (GoodsListBean gs : slist) {
//						GoodsCommunity g = goodsCommunityService.gets(tuser.getCommunityid(), gs.getGoodsId());
//						if (gs.getCount() > g.getStock()) {
//							res.setResultNote("库存不足");
//							return res;
//						}
//					}
//				}
//			} catch (Exception e) {
//				logger.error("请求处理异常：10811" );
//				e.printStackTrace();
//			}
//			// 库存足够创建订单
//			try {
//
//				BigDecimal bg = null;// 购买商品价
//				BigDecimal bg1 = null;// 商品购买量
//				BigDecimal bg2 = null;// 支付总金额
//				BigDecimal bg6 = null;// 逗邻币商品价
//				double allPrice = 0;// 支付总金额
//				double payPrice = 0;// 实际支付金额
//				BigDecimal discountPrice = new BigDecimal(0);// 专享价支付总金额
//				List<GoodsListBean> dataList = req.getGoodsList();
//				if (null != dataList && dataList.size() > 0) {
//					for (GoodsListBean goodsBeen : dataList) {
//						GoodsCommunity goods = goodsCommunityService.gets(c.getId(), goodsBeen.getGoodsId());
//						bg1 = new BigDecimal(Double.toString(goodsBeen.getCount())).setScale(2, BigDecimal.ROUND_HALF_UP);
//						if ((null != goods.getGoodscuprice() && !"".equals(goods.getGoodscuprice()))
//								||(null != goods.getDiscountprice() && !"".equals(goods.getDiscountprice()))) {//促销价与 逗邻币专享价
//							if ((null != goods.getGoodscuprice() && !"".equals(goods.getGoodscuprice()))){
//								if (Double.valueOf(goods.getGoodscuprice().replaceAll(",", "")) > 0) {
//									bg = new BigDecimal(goods.getGoodscuprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//									// addReq.setCondition("1");不可使用优惠卷
//								} else {
//									res.setResultNote("促销价为负不可结算，请查看");
//									return res;
//								}
//							}
//							if ((null != goods.getDiscountprice() && !"".equals(goods.getDiscountprice()))){//逗邻币支付价永完是最低的
//								if (Double.valueOf(goods.getDiscountprice()) > 0
//										&&Double.valueOf(goods.getDiscountprice().replaceAll(",", ""))<Double.valueOf(goods.getGoodscuprice().replaceAll(",", ""))) {
//									bg6 = new BigDecimal(goods.getDiscountprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//								}else{
//									bg6 = bg;
//								}
//							}else{
//								bg6 = bg;
//							}
//						} else {
//							bg = new BigDecimal(goods.getGoodsprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//							bg6 = bg;
//						}
//						bg2 = new BigDecimal(allPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//						// 有优惠价商品总支付金额
//						allPrice = bg2.add(bg.multiply(bg1)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//						discountPrice = discountPrice.add(bg6.multiply(bg1));
//					}
//				}
//
//				if(null!=req.getCouponId()&&!"".equals(req.getCouponId())) {
//					String amountStr = couponService.execSelectSqlString("SELECT amount FROM t_coupon WHERE id='"+req.getCouponId()+"'");
//					BigDecimal price = new BigDecimal(allPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//					BigDecimal amount = new BigDecimal(amountStr.replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//					payPrice = price.subtract(amount).doubleValue();
//				}else {
//					payPrice = allPrice;
//				}
//
//				UserOrder o = new UserOrder();
//				String orderId = StringUtil.getOrderNo();
//				o.setId(IdGen.uuid());
//				o.setUid(req.getUid());
//				o.setCommunityid(tuser.getCommunityid());
//				o.setOrdertype(req.getType());
//				o.setAllprice(allPrice);
//				o.setPayprice(payPrice);
//				o.setDiscountprice(discountPrice.doubleValue());
//				o.setStatus("1");
//				o.setIsaccount("0");
//				o.setMessage(req.getMessage());
//				o.setActivityType("3");
//		/*		if (req.getSecuritiesid() != null && !"".equals(req.getSecuritiesid())) {
//					// 使用优惠券
//					UserCoupon uc = userCouponService.get(req.getSecuritiesid());
////					uc.setStatus("1");
////					userCouponService.update1(uc);
//					o.setCouponid(req.getSecuritiesid());
//					o.setCouponmoney(uc.getAmount() + "");
//					BigDecimal b = new BigDecimal(req.getPayprice());
//					BigDecimal payprice = b.setScale(2, BigDecimal.ROUND_HALF_UP);
//					b = new BigDecimal(req.getAllprice());
//					BigDecimal allprice = b.setScale(2, BigDecimal.ROUND_HALF_UP);
//					b = new BigDecimal(uc.getAmount());
//					BigDecimal amount = b.setScale(2, BigDecimal.ROUND_HALF_UP);
//					if (payprice.compareTo(allprice.subtract(amount)) != 0) {
//						res.setResultNote("支付金额出现问题，请查看");
//						return res;
//					}
//				}*/
//
//				o.setOrdernum(orderId);
//				o.setAdtime(new Date());
//				o.setUpdatetime(new Date());
//				List<GoodsListBean> glist = req.getGoodsList();
//				List<UserOrderlist> orderList = new ArrayList<UserOrderlist>();
//				for (int i = 0; i < glist.size(); i++) {
//					Goods g = new Goods();
//					g.setId(glist.get(i).getGoodsId());
//					g.setCommunityid(tuser.getCommunityid());
//					g = goodsService.gets(g);
//					UserOrderlist userOrderlist = new UserOrderlist();
//					userOrderlist.setId(IdGen.uuid());
//					userOrderlist.setOrdernum(orderId);
//					userOrderlist.setGoodsid(glist.get(i).getGoodsId());
//					userOrderlist.setGoodstitle(g.getTitle());
//					userOrderlist.setGoodsimage(g.getImage());
//					userOrderlist.setGoodsdesc(g.getGoodsdesc());
//					userOrderlist.setGoodsSpecification(g.getSpecification());
//					if (glist.get(i).getCount() < 0) {
//						res.setResultNote("订单异常，请返回查看");
//						return res;
//					}
//					userOrderlist.setGoodsnum(glist.get(i).getCount());
//
//					if (null != g.getDiscountprice() && !"".equals(g.getDiscountprice()) && Double.valueOf(g.getDiscountprice())> 0) {//有专享价
//						userOrderlist.setDiscountprice(String.valueOf(g.getDiscountprice()));
//					}
//					if (g.getCuprice() != null && g.getCuprice() > 0) {
//						userOrderlist.setGoodsprice(g.getCuprice());
//						if(null!=userOrderlist.getDiscountprice() && g.getDiscountprice()> g.getCuprice()){
//							userOrderlist.setDiscountprice(String.valueOf(g.getCuprice()));
//						}
//					} else {
//						userOrderlist.setGoodsprice(g.getPrice());
//					}
//					userOrderlist.setOriginalprice(g.getPrice());
//					userOrderlist.setPurchaseprice(g.getPurchaseprice());
//					userOrderlist.setAdtime(new Date());
//					orderList.add(userOrderlist);
//				}
//
//				// 生成订单
//				userOrderService.addOrder(o, orderList);
//				// 使用优惠券
//				if (req.getSecuritiesid() != null && !"".equals(req.getSecuritiesid())) {
//					UserCoupon uc = userCouponService.get(req.getSecuritiesid());
//					uc.setStatus("1");
//					userCouponService.update1(uc);
//				}
//				// 生成订单号
//				OrderType ot = new OrderType();
//				ot.setId(IdGen.uuid());
//				ot.setUid(req.getUid());
//				ot.setType("1");
//				ot.setState("0");
//				ot.setOrdernum(orderId);
//				orderTypeMapper.insert(ot);
//				// 减少库存，增加销量
//				UserOrderlist uol = new UserOrderlist();
//				uol.setOrdernum(orderId);
//				List<UserOrderlist> list1 = userOrderlistService.findList(uol);
//				if (list1 != null && list1.size() > 0) {
//					for (UserOrderlist od : list1) {
//						GoodsCommunity g = goodsCommunityService.getGoodsStock(o.getCommunityid(), od.getGoodsid());
//						if (!"1".equals(g.getType())) {
//							g.setStock(g.getStock() - od.getGoodsnum());
//						}
//						g.setSallnum(g.getSallnum() + od.getGoodsnum());
//						goodsCommunityService.save(g);
//					}
//				}
//
//				res.setOderNum(orderId);
//				res.setBalance(tuser.getBalance() + "");
//				res.setResult("0");
//				res.setResultNote("提交订单成功");
//			} catch (Exception e) {
//				logger.error("请求处理异常：10948" );
//				e.printStackTrace();
//			}
//
//		} catch (Exception e) {
//			logger.error("请求处理异常：10953" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 去结算
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson getPayVersion(AddSettleAccountsReq req) {
//		AddGoodsOrderRes res = new AddGoodsOrderRes();
//		res.setResultNote("提交失败");
//
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户ID不能为空");
//			return res;
//		}
//		// 判断用户状态
//		Tuser tuser = tuserService.get(req.getUid());
//		if (null == tuser) {
//			res.setResultNote("用户不存在");
//			return res;
//		} else if (!"0".equals(tuser.getStatus())) {
//			res.setResultNote("用户已被禁用");
//			return res;
//		}
//
//		if (StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区id为空");
//		}
//
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		Map<String, String> merchantRest = communityService.execSelectSqlEntityMap("SELECT startTime AS startTime,endTime AS endTime FROM t_merchant_rest "
//				+ "WHERE NOW() >= startTime AND NOW() <= endTime AND communityid ='"+tuser.getCommunityid()+"' AND state=0");
//		if(null != merchantRest && merchantRest.size()>0) {
//			res.setResultNote("商家"+sf.format(merchantRest.get("startTime"))+"至"+sf.format(merchantRest.get("endTime"))+"打烊");
//			return res;
//		}
//
//		BigDecimal bg = null;// 购买商品价
//		BigDecimal bg1 = null;// 商品购买量
//		BigDecimal bg2 = null;// 支付总金额
//		BigDecimal bg3 = null;// 参与优惠卷总金额
//		BigDecimal bg4 = null;// 商品原价总金额
//		BigDecimal bg5 = null;
//		BigDecimal bg6 = null; //逗邻币专享购买价
//		double cAllPrice = 0; // 商品原价支付总金额
//		double allPrice = 0;// 支付总金额
//		double cpayPrice = 0;// 无促销价商品的支付总金额
//		BigDecimal dpayPrice = new BigDecimal(0);// 无促销价和无逗邻币专享商品的支付总金额
//		double payPrice = 0;// 实际支付金额
//		BigDecimal discountPrice = new BigDecimal(0);// 专享价支付总金额
//		List<GoodsListBean> dataList = req.getGoodsList();
//		List<Map<String, Object>> data = new ArrayList<>();
//		Map<String, Object> map = new HashMap<>();
//		if (null != dataList && dataList.size() > 0) {
//			List<Object> goodsData = new ArrayList<>();
//			for (GoodsListBean goodsBeen : dataList) {
//				GoodsCommunity goods=null;
////				if(StringUtils.isBlank(goodsBeen.getActivityid())){
////					goods = goodsCommunityService.gets(req.getCommunityId(), goodsBeen.getGoodsId());
////				}else{
//				//此处会造成价格统一，就是购物车显示的价格为最低价
//					goods = goodsCommunityService.getsTwo(req.getCommunityId(), goodsBeen.getGoodsId(),goodsBeen.getActivityid());
////				}
//				if (goods.getShelves().equals("1")||goods.getGoodsState().equals("1")){
//					res.setResultNote(goods.getGoodsname() + "已下架,请不要选择该商品！");
//					return res;
//				}
//				if (!"1".equals(goods.getType())&&goodsBeen.getCount() > goods.getStock()) {
//					res.setResultNote("["+goods.getGoodsname()+"]库存不足");
//					return res;
//				}
//				if (Double.valueOf(goods.getGoodsprice())<=0) {
//					res.setResultNote("["+goods.getGoodsname()+"]价格有问题，请联系商家");
//					return res;
//				}
//				bg1 = new BigDecimal(Double.toString(goodsBeen.getCount())).setScale(2, BigDecimal.ROUND_HALF_UP);
//				if (StringUtils.isNotBlank(goods.getGoodscuprice()) || StringUtils.isNotBlank(goods.getDiscountprice())
//						||StringUtils.isNotBlank(goods.getActivityprice())) {
//					//促销价与 逗邻币专享价
//					if(StringUtils.isBlank(goods.getActivityid())){//goodsBeen.getActivityid()
//						if ((null != goods.getGoodscuprice() && !"".equals(goods.getGoodscuprice()))){
//							if (Double.valueOf(goods.getGoodscuprice()) > 0) {
//								bg = new BigDecimal(goods.getGoodscuprice()).setScale(2, BigDecimal.ROUND_HALF_UP);
//								// addReq.setCondition("1");不可使用优惠卷
//							} else {
//								res.setResultNote("["+goods.getGoodsname()+"]该商品不可结算");
//								return res;
//							}
//						}else{
//							bg = new BigDecimal(goods.getGoodsprice()).setScale(2, BigDecimal.ROUND_HALF_UP);
//						}
//						if (StringUtils.isNotBlank(goods.getDiscountprice())){//逗邻币支付价永远是最低的
//							String cuprice = goods.getGoodscuprice();
//							if(null==goods.getGoodscuprice()||Double.valueOf(goods.getGoodscuprice())==0){
//								cuprice = goods.getGoodsprice();
//							}
//							if (Double.valueOf(goods.getDiscountprice()) > 0 && Double.valueOf(goods.getDiscountprice())<Double.valueOf(cuprice)) {
//								bg6 = new BigDecimal(goods.getDiscountprice()).setScale(2, BigDecimal.ROUND_HALF_UP);
//
//								//优惠券和逗邻币支付要同时计算
////								bg = new BigDecimal(goods.getGoodsprice()).setScale(2, BigDecimal.ROUND_HALF_UP);
//								bg3 = new BigDecimal(cpayPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//								cpayPrice = bg3.add(bg.multiply(bg1)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//
//							}else{
//								bg6 = new BigDecimal(cuprice);
//							}
//						}else{
//							bg6 = bg;
//						}
//					}else{
//						//团购商品
//						if((null != goods.getActivityprice() && !"".equals(goods.getActivityprice()))){
//							if (Double.valueOf(goods.getActivityprice()) > 0) {
//								bg = new BigDecimal(goods.getActivityprice()).setScale(2, BigDecimal.ROUND_HALF_UP);
//								bg6 = new BigDecimal(goods.getActivityprice()).setScale(2, BigDecimal.ROUND_HALF_UP);
//							}else{
//								bg = new BigDecimal(goods.getGoodsprice()).setScale(2, BigDecimal.ROUND_HALF_UP);
//							}
//						}
//					}
//				} else {//优惠券
//					bg = new BigDecimal(goods.getGoodsprice()).setScale(2, BigDecimal.ROUND_HALF_UP);
//					bg3 = new BigDecimal(cpayPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//					cpayPrice = bg3.add(bg.multiply(bg1)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//					dpayPrice = dpayPrice.add(bg.multiply(bg1)).setScale(2, BigDecimal.ROUND_HALF_UP);
//					bg6 = bg;
//				}
//				bg2 = new BigDecimal(allPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//				goodsBeen.setGoodsSumPrice(bg.multiply(bg1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
//				// 返给前端shopcart的id
//				List<Object> cartId = userCardService.executeSelectSql("SELECT id FROM t_user_cart WHERE uid='"
//						+ req.getUid() + "' AND goodsid='" + goodsBeen.getGoodsId() + "'");
//				if (null != cartId && cartId.size() > 0) {
//					goodsBeen.setCartId(cartId.get(0).toString());
//				}
//				// 计算商品原价总金额
//				bg4 = new BigDecimal(cAllPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//				bg5 = new BigDecimal(goods.getGoodsprice()).setScale(2, BigDecimal.ROUND_HALF_UP);
//				cAllPrice = bg4.add(bg1.multiply(bg5)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//				// 有优惠价商品总支付金额
//				allPrice = bg2.add(bg.multiply(bg1)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//				//逗邻币支付价
//				discountPrice = discountPrice.add(bg6.multiply(bg1).setScale(2, BigDecimal.ROUND_HALF_UP));
//				goodsBeen.setGoodsName(goods.getGoodsname());
//				goodsBeen.setGoodsImage(goods.getGoodsimg());
//				goodsBeen.setGoodsPrice(goods.getGoodsprice());
//				goodsBeen.setGoodsCuprice(goods.getGoodscuprice());
//				goodsBeen.setDiscountprice(goods.getDiscountprice());
//				goodsData.add(goodsBeen);
//			}
//			map.put("cAllPrice", cAllPrice);
//			map.put("allPrice", allPrice);
//			map.put("cpayPrice", cpayPrice);
//			map.put("discountPrice", discountPrice.doubleValue());
//			map.put("goods", goodsData);
//		}
//
//		if (null != req.getType() && "3".equals(req.getType())) {// 公众号不参与优惠劵，不参与逗邻币专享
//
//		} else {// APP结算参与优惠劵，与逗邻币专享
//			List<Object> userCouponData = new ArrayList<>();
//			Map<String, String> map1 = new HashMap<>();
//			UserCoupon c = new UserCoupon();
//			c.setUid(req.getUid());
//			c.setCommunityid(req.getCommunityId());
//			if (null != req.getGoodsType() && !"".equals(req.getGoodsType())) {
//				c.setType(req.getGoodsType());
//			} else {
//				c.setType(req.getType());
//			}
//			c.setAllmoney(cpayPrice);
//			if ("1".equals(req.getState())) {
//				if (StringUtils.isNotBlank(req.getCouponId())) {
//					c.setCouponid(req.getCouponId());
//					UserCoupon userCoupon = userCouponService.selectUsableUserCoupon(c);//原计算方式
//					if (null != userCoupon) {
//						map1.put("amount", userCoupon.getAmount() + "");
//						map1.put("uniqueId", userCoupon.getId());// userCoupon唯一标识符
//						map1.put("couponid", userCoupon.getCouponid());
//						BigDecimal price = new BigDecimal(allPrice);
//						BigDecimal amount = new BigDecimal(userCoupon.getAmount());
//						payPrice = price.subtract(amount).doubleValue();
//
//						c.setAllmoney(dpayPrice.doubleValue());
//						UserCoupon userCoupon2 = userCouponService.selectUsableUserCoupon(c);//排除逗邻币专享价后的普通商品是否满足使用优惠券
//						if (null != userCoupon2) {
//							discountPrice = discountPrice.subtract(amount);
//						}
//					}
//				} else {
//					UserCoupon userCoupon = userCouponService.selectUsableUserCoupon(c);
//					if (null != userCoupon) {
//						Integer count = userCouponService.selectUserCouponCount(c);
//						map1.put("count", count + "");
//						map1.put("uniqueId", userCoupon.getId());// userCoupon唯一标识符
//						map1.put("couponid", userCoupon.getCouponid());
//						map1.put("amount", userCoupon.getAmount() + "");
//						BigDecimal price = new BigDecimal(allPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//						BigDecimal amount = new BigDecimal(userCoupon.getAmount()).setScale(2, BigDecimal.ROUND_HALF_UP);
//						payPrice = price.subtract(amount).doubleValue();
//						c.setAllmoney(dpayPrice.doubleValue());
//						UserCoupon userCoupon2 = userCouponService.selectUsableUserCoupon(c);//排除逗邻币专享价后的普通商品是否满足使用优惠券
//						if (null != userCoupon2) {
//							discountPrice = discountPrice.subtract(amount);
//						}
//					}
//				}
//				userCouponData.add(map1);
//				map.put("userCoupon", userCouponData);
//				map.put("discountPrice", discountPrice.doubleValue());
//			} else if ("0".equals(req.getState())) {
//				Integer count = userCouponService.selectUserCouponCount(c);
//				map1.put("count", count + "");
//				userCouponData.add(map1);
//				map.put("userCoupon", userCouponData);
//			}
//		}
//		BigDecimal bgPay = new BigDecimal(payPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//		BigDecimal cbgPay = new BigDecimal(0.0).setScale(2, BigDecimal.ROUND_HALF_UP);
//
//		if (bgPay.compareTo(cbgPay) == 0) {
//			map.put("payPrice", allPrice);
//		} else if (bgPay.compareTo(cbgPay) == 1) {
//			map.put("payPrice", payPrice);
//		} else {
//			res.setResultNote("系统延迟，请重新操作");
//			return res;
//		}
//
//		data.add(map);
//		res.setDataList(data);
//		res.setResult("0");
//		res.setResultNote("获取成功");
//		return res;
//	}
////原版代码
///*	public ResJson getPayVersion(AddSettleAccountsReq req) {
//		AddGoodsOrderRes res = new AddGoodsOrderRes();
//		res.setResultNote("提交失败");
//
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户ID不能为空");
//			return res;
//		}
//		// 判断用户状态
//		Tuser tuser = tuserService.get(req.getUid());
//		if (null == tuser) {
//			res.setResultNote("用户不存在");
//			return res;
//		} else if (!"0".equals(tuser.getStatus())) {
//			res.setResultNote("用户已被禁用");
//			return res;
//		}
//
//		if (StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区id为空");
//		}
//
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		Map<String, String> merchantRest = communityService.execSelectSqlEntityMap("SELECT startTime AS startTime,endTime AS endTime FROM t_merchant_rest "
//				+ "WHERE NOW() >= startTime AND NOW() <= endTime AND communityid ='"+tuser.getCommunityid()+"' AND state=0");
//		if(null != merchantRest && merchantRest.size()>0) {
//			res.setResultNote("商家"+sf.format(merchantRest.get("startTime"))+"至"+sf.format(merchantRest.get("endTime"))+"打烊");
//			return res;
//		}
//
//		BigDecimal bg = null;// 购买商品价
//		BigDecimal bg1 = null;// 商品购买量
//		BigDecimal bg2 = null;// 支付总金额
//		BigDecimal bg3 = null;// 参与优惠卷总金额
//		BigDecimal bg4 = null;// 商品原价总金额
//		BigDecimal bg5 = null;
//		BigDecimal bg6 = null; //逗邻币专享购买价
//		double cAllPrice = 0; // 商品原价支付总金额
//		double allPrice = 0;// 支付总金额
//		double cpayPrice = 0;// 无促销价商品的支付总金额
//		BigDecimal dpayPrice = new BigDecimal(0);// 无促销价和无逗邻币专享商品的支付总金额
//		double payPrice = 0;// 实际支付金额
//		BigDecimal discountPrice = new BigDecimal(0);// 专享价支付总金额
//		List<GoodsListBean> dataList = req.getGoodsList();
//		List<Map<String, Object>> data = new ArrayList<>();
//		Map<String, Object> map = new HashMap<>();
//		if (null != dataList && dataList.size() > 0) {
//			List<Object> goodsData = new ArrayList<>();
//			for (GoodsListBean goodsBeen : dataList) {
//				GoodsCommunity goods = goodsCommunityService.gets(req.getCommunityId(), goodsBeen.getGoodsId());
//				if (goods.getShelves().equals("1")||goods.getGoodsState().equals("1")){
//					res.setResultNote(goods.getGoodsname() + "已下架,请不要选择该商品！");
//					return res;
//				}
//				if (!"1".equals(goods.getType())&&goodsBeen.getCount() > goods.getStock()) {
//					res.setResultNote("["+goods.getGoodsname()+"]库存不足");
//					return res;
//				}
//				if (Double.valueOf(goods.getGoodsprice())<=0) {
//					res.setResultNote("["+goods.getGoodsname()+"]价格有问题，请联系商家");
//					return res;
//				}
//				bg1 = new BigDecimal(Double.toString(goodsBeen.getCount())).setScale(2, BigDecimal.ROUND_HALF_UP);
//				if ((null != goods.getGoodscuprice() && !"".equals(goods.getGoodscuprice()))
//						||(null != goods.getDiscountprice() && !"".equals(goods.getDiscountprice()))) {//促销价与 逗邻币专享价
//					if ((null != goods.getGoodscuprice() && !"".equals(goods.getGoodscuprice()))){
//						if (Double.valueOf(goods.getGoodscuprice().replaceAll(",", "")) > 0) {
//							bg = new BigDecimal(goods.getGoodscuprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//							// addReq.setCondition("1");不可使用优惠卷
//						} else {
//							res.setResultNote("["+goods.getGoodsname()+"]该商品不可结算");
//							return res;
//						}
//					}else{
//						bg = new BigDecimal(goods.getGoodsprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//					}
//					if ((null != goods.getDiscountprice() && !"".equals(goods.getDiscountprice()))){//逗邻币支付价永完是最低的
//						String cuprice = "";
//						if(null==goods.getGoodscuprice()||Double.valueOf(goods.getGoodscuprice().replaceAll(",", ""))==0){//没有活动价
//							cuprice = goods.getGoodsprice().replaceAll(",", "");
//						}else{//有活动价
//							cuprice = goods.getGoodscuprice().replaceAll(",", "");
//						}
//						if (Double.valueOf(goods.getDiscountprice().replaceAll(",", "")) > 0 && Double.valueOf(goods.getDiscountprice().replaceAll(",", ""))<Double.valueOf(cuprice.replaceAll(",", ""))) {
//							bg6 = new BigDecimal(goods.getDiscountprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//
//							//优惠券和逗邻币支付要同时计算
////							bg = new BigDecimal(goods.getGoodsprice()).setScale(2, BigDecimal.ROUND_HALF_UP);
//							bg3 = new BigDecimal(cpayPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//							cpayPrice = bg3.add(bg.multiply(bg1)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//
//						}else{
//							bg6 = new BigDecimal(cuprice);
//						}
//					}else{
//						bg6 = bg;
//					}
//				} else {//优惠券
//					bg = new BigDecimal(goods.getGoodsprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//					bg3 = new BigDecimal(cpayPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//					cpayPrice = bg3.add(bg.multiply(bg1)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//					dpayPrice = dpayPrice.add(bg.multiply(bg1)).setScale(2, BigDecimal.ROUND_HALF_UP);
//					bg6 = bg;
//				}
//				bg2 = new BigDecimal(allPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//				goodsBeen.setGoodsSumPrice(bg.multiply(bg1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
//				// 返给前端shopcart的id
//				List<Object> cartId = userCardService.executeSelectSql("SELECT id FROM t_user_cart WHERE uid='"
//						+ req.getUid() + "' AND goodsid='" + goodsBeen.getGoodsId() + "'");
//				if (null != cartId && cartId.size() > 0) {
//					goodsBeen.setCartId(cartId.get(0).toString());
//				}
//				// 计算商品原价总金额
//				bg4 = new BigDecimal(cAllPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//				bg5 = new BigDecimal(goods.getGoodsprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//				cAllPrice = bg4.add(bg1.multiply(bg5)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//				// 有优惠价商品总支付金额
//				allPrice = bg2.add(bg.multiply(bg1)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//				//逗邻币支付价
//				discountPrice = discountPrice.add(bg6.multiply(bg1).setScale(2, BigDecimal.ROUND_HALF_UP));
//				goodsBeen.setGoodsName(goods.getGoodsname());
//				goodsBeen.setGoodsImage(goods.getGoodsimg());
//				goodsBeen.setGoodsPrice(goods.getGoodsprice());
//				goodsBeen.setGoodsCuprice(goods.getGoodscuprice());
//				goodsBeen.setDiscountprice(goods.getDiscountprice());
//				goodsData.add(goodsBeen);
//			}
//			map.put("cAllPrice", cAllPrice);
//			map.put("allPrice", allPrice);
//			map.put("cpayPrice", cpayPrice);
//			map.put("discountPrice", discountPrice.doubleValue());
//			map.put("goods", goodsData);
//		}
//
//		if (null != req.getType() && "3".equals(req.getType())) {// 公众号不参与优惠劵，不参与逗邻币专享
//
//		} else {// APP结算参与优惠劵，与逗邻币专享
//			List<Object> userCouponData = new ArrayList<>();
//			Map<String, String> map1 = new HashMap<>();
//			UserCoupon c = new UserCoupon();
//			c.setUid(req.getUid());
//			c.setCommunityid(req.getCommunityId());
//			if (null != req.getGoodsType() && !"".equals(req.getGoodsType())) {
//				c.setType(req.getGoodsType());
//			} else {
//				c.setType(req.getType());
//			}
//			c.setAllmoney(cpayPrice);
//			if ("1".equals(req.getState())) {
//				if (StringUtils.isNoneBlank(req.getCouponId())) {
//					c.setCouponid(req.getCouponId());
//					UserCoupon userCoupon = userCouponService.selectUsableUserCoupon(c);//原计算方式
//					if (null != userCoupon) {
//						map1.put("amount", userCoupon.getAmount() + "");
//						map1.put("uniqueId", userCoupon.getId());// userCoupon唯一标识符
//						map1.put("couponid", userCoupon.getCouponid());
//						BigDecimal price = new BigDecimal(allPrice);
//						BigDecimal amount = new BigDecimal(userCoupon.getAmount());
//						payPrice = price.subtract(amount).doubleValue();
//
//						c.setAllmoney(dpayPrice.doubleValue());
//						UserCoupon userCoupon2 = userCouponService.selectUsableUserCoupon(c);//排除逗邻币专享价后的普通商品是否满足使用优惠券
//						if (null != userCoupon2) {
//							discountPrice = discountPrice.subtract(amount);
//						}
//					}
//				} else {
//					UserCoupon userCoupon = userCouponService.selectUsableUserCoupon(c);
//					if (null != userCoupon) {
//						Integer count = userCouponService.selectUserCouponCount(c);
//						map1.put("count", count + "");
//						map1.put("uniqueId", userCoupon.getId());// userCoupon唯一标识符
//						map1.put("couponid", userCoupon.getCouponid());
//						map1.put("amount", userCoupon.getAmount() + "");
//						BigDecimal price = new BigDecimal(allPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//						BigDecimal amount = new BigDecimal(userCoupon.getAmount()).setScale(2, BigDecimal.ROUND_HALF_UP);
//						payPrice = price.subtract(amount).doubleValue();
//						c.setAllmoney(dpayPrice.doubleValue());
//						UserCoupon userCoupon2 = userCouponService.selectUsableUserCoupon(c);//排除逗邻币专享价后的普通商品是否满足使用优惠券
//						if (null != userCoupon2) {
//							discountPrice = discountPrice.subtract(amount);
//						}
//					}
//				}
//				userCouponData.add(map1);
//				map.put("userCoupon", userCouponData);
//				map.put("discountPrice", discountPrice.doubleValue());
//			} else if ("0".equals(req.getState())) {
//				Integer count = userCouponService.selectUserCouponCount(c);
//				map1.put("count", count + "");
//				userCouponData.add(map1);
//				map.put("userCoupon", userCouponData);
//			}
//		}
//		BigDecimal bgPay = new BigDecimal(payPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//		BigDecimal cbgPay = new BigDecimal(0.0).setScale(2, BigDecimal.ROUND_HALF_UP);
//
//		if (bgPay.compareTo(cbgPay) == 0) {
//			map.put("payPrice", allPrice);
//		} else if (bgPay.compareTo(cbgPay) == 1) {
//			map.put("payPrice", payPrice);
//		} else {
//			res.setResultNote("系统延迟，请重新操作");
//			return res;
//		}
//
//		data.add(map);
//		res.setDataList(data);
//		res.setResult("0");
//		res.setResultNote("获取成功");
//		return res;
//	}*/
//
//	/**
//	 * 微信支付宝支付 提交订单
//	 *
//	 * @param req
//	 * @return
//	 */
//	/*@Transactional(readOnly = false,rollbackFor = {RuntimeException.class, Exception.class })
//	public ResJson codeSubmitOrder(AddCartGoodsOrderNewReq req) {
//		AddGoodsOrderRes res = new AddGoodsOrderRes();
//		res.setResultNote("提交失败");
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户ID不能为空");
//			return res;
//		}
//		if(!"2".equals(req.getActivityType())) {
//			if (StringUtils.isBlank(req.getAddressId())) {
//				res.setResultNote("请选择收货地址");
//				return res;
//			}
//		}
//
//		try {
//			// 判断用户状态
//			Tuser tuser = tuserService.get(req.getUid());
//
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户已被禁用");
//				return res;
//			}
//
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//			Map<String, String> merchantRest = communityService.execSelectSqlEntityMap("SELECT startTime AS startTime,endTime AS endTime FROM t_merchant_rest "
//					+ "WHERE NOW() >= startTime AND NOW() <= endTime AND communityid ='"+tuser.getCommunityid()+"' AND state=0");
//			if(null != merchantRest && merchantRest.size()>0) {
//				res.setResultNote("商家"+sf.format(merchantRest.get("startTime"))+"至"+sf.format(merchantRest.get("endTime"))+"打烊");
//				return res;
//			}
//			Community c = communityService.get(tuser.getCommunityid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该商家暂时不能下单");
//				return res;
//			}
//			// 获取收货地址
//			Address address = addressService.get(req.getAddressId());
//			if(!"2".equals(req.getActivityType())) {
//			if (null == address) {
//				res.setResultNote("收货地址不存在");
//				return res;
//			}
//			}
//			if (req.getGoodsList() == null || req.getGoodsList().size() == 0) {
//				res.setResultNote("请选择要购买的商品");
//				return res;
//			}
////			String orderType = userCartService.execSelectSqlString("SELECT DISTINCT if(type=0,2,type) FROM t_user_cart WHERE uid='"+tuser.getId()+"'");
//			// 查询库存是否足够
//			if (!"1".equals(req.getType())) {
//				List<GoodsListBean> slist = req.getGoodsList();
//				for (GoodsListBean gs : slist) {
//					GoodsCommunity g = goodsCommunityService.gets(tuser.getCommunityid(), gs.getGoodsId());
//					if (g.getShelves().equals("1")||g.getGoodsState().equals("1")){
//						res.setResultNote("["+g.getGoodsname()+"]已下架,请不要选择该商品！");
//						return res;
//					}
//					if (gs.getCount() > g.getStock()) {
//						res.setResultNote("["+g.getGoodsname()+"]库存不足");
//						return res;
//					}
//					if (Double.valueOf(g.getGoodsprice())<=0) {
//						res.setResultNote("["+g.getGoodsname()+"]价格有问题，请联系商家");
//						return res;
//					}
//				}
//			}
//
//			BigDecimal bg = null;// 购买商品价
//			BigDecimal bg1 = null;// 商品购买量
//			BigDecimal bg2 = null;// 支付总金额
//			double allPrice = 0;// 支付总金额
//			double payPrice = 0;// 实际支付金额
//			List<GoodsListBean> dataList = req.getGoodsList();
//			if (null != dataList && dataList.size() > 0) {
//				for (GoodsListBean goodsBeen : dataList) {
//					GoodsCommunity goods = goodsCommunityService.gets(c.getId(), goodsBeen.getGoodsId());
//					bg1 = new BigDecimal(Double.toString(goodsBeen.getCount())).setScale(2, BigDecimal.ROUND_HALF_UP);
//					if (null != goods.getGoodscuprice() && !"".equals(goods.getGoodscuprice())) {
//						if (Double.valueOf(goods.getGoodscuprice()) > 0) {
//							bg = new BigDecimal(goods.getGoodscuprice()).setScale(2, BigDecimal.ROUND_HALF_UP);;
//						} else {
//							res.setResultNote("促销价为负不可结算，请查看");
//							return res;
//						}
//					} else {
//						bg = new BigDecimal(goods.getGoodsprice()).setScale(2, BigDecimal.ROUND_HALF_UP);
//					}
//					bg2 = new BigDecimal(allPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//					// 有优惠价商品总支付金额
//					allPrice = bg2.add(bg.multiply(bg1)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//				}
//			}
//
//			if(null!=req.getCouponId()&&!"".equals(req.getCouponId())) {
//			String amountStr = couponService.execSelectSqlString("SELECT amount FROM t_coupon WHERE id='"+req.getCouponId()+"'");
//			BigDecimal price = new BigDecimal(allPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//			BigDecimal amount = new BigDecimal(amountStr).setScale(2, BigDecimal.ROUND_HALF_UP);
//			payPrice = price.subtract(amount).doubleValue();
//			}else {
//				payPrice = allPrice;
//			}
//			// 库存足够创建订单
//			UserOrder o = new UserOrder();
//			String orderId = StringUtil.getOrderNo();
//			o.setId(IdGen.uuid());
//			o.setUid(req.getUid());
//			o.setCommunityid(tuser.getCommunityid());
//			if(!"2".equals(req.getActivityType())) {
//				o.setUsername(address.getUsername());
//				o.setUserphone(address.getUserphone());
//				o.setUsercity(address.getCity());
//				o.setUseraddress(address.getAddress());
//			}
//			o.setOrdertype(req.getType());
//			o.setActivityType(req.getActivityType());//活动类型
//			o.setAllprice(allPrice);
//			o.setPayprice(payPrice);
////            o.setAllprice(StringUtils.isBlank(req.getAllprice()) ? 0 : Double.valueOf(req.getAllprice()));
//			BigDecimal allPrice = new BigDecimal(0);//
//			if (null != req.getPayprice() && !"".equals(req.getPayprice()) && Double.valueOf(req.getPayprice()) != 0) {
//				o.setPayprice(StringUtils.isBlank(req.getPayprice()) ? 0 : Double.valueOf(req.getPayprice()));
//			} else {
//				res.setResultNote("操作有误，请重新下单");
//				return res;
//			}
//			if (null != req.getDiscountprice() && !"".equals(req.getDiscountprice()) && Double.valueOf(req.getDiscountprice()) != 0) {//如果有专享价
//				o.setDiscountprice(StringUtils.isBlank(req.getDiscountprice()) ? 0 : Double.valueOf(req.getDiscountprice()));
//			}
//			o.setStatus("1");
//			o.setIsaccount("0");
//			o.setMessage(req.getMessage());
//			if (req.getSecuritiesid() != null && !"".equals(req.getSecuritiesid())) {
//				// 使用优惠券
//				List<Object> amount = userCouponService.executeSelectSql("SELECT amount FROM t_user_coupon WHERE uid='"
//						+ req.getUid() + "' AND couponid='" + req.getSecuritiesid() + "'");
//				o.setCouponid(req.getSecuritiesid());
//				if (null != amount && amount.size() > 0) {
//					o.setCouponmoney(amount.get(0).toString() + "");
//				}
//			}
//			if (req.getCouponId() != null && !"".equals(req.getCouponId())) {// 暂用版本
//				// 使用优惠券
//				o.setCouponid(req.getCouponId());
//				List<Object> amount = userCouponService.executeSelectSql("SELECT amount FROM t_user_coupon WHERE uid='"
//						+ req.getUid() + "' AND couponid='" + req.getCouponId() + "'");
//				if (null != amount && amount.size() > 0) {
//					o.setCouponmoney(amount.get(0).toString() + "");
//				}
//			}
//			o.setOrdernum(orderId);
//			o.setAdtime(new Date());
//			o.setUpdatetime(new Date());
//			List<GoodsListBean> glist = req.getGoodsList();
//			List<UserOrderlist> orderList = new ArrayList<UserOrderlist>();
//			for (int i = 0; i < glist.size(); i++) {
//				Goods g = new Goods();
//				g.setId(glist.get(i).getGoodsId());
//				g.setCommunityid(tuser.getCommunityid());
//				g = goodsService.gets(g);
//				if(!"2".equals(req.getActivityType())){
//					List<Object> goodCount = userCartService.executeSelectSql("SELECT count FROM t_user_cart WHERE uid = '"
//							+ req.getUid() + "' " + "AND goodsid='" + glist.get(i).getGoodsId() + "'");
//					if (null != goodCount && goodCount.size() > 0 && null != goodCount.get(0)&& !"0".equals(goodCount.get(0).toString())) {
//						UserOrderlist userOrderlist = new UserOrderlist();
//						userOrderlist.setId(IdGen.uuid());
//						userOrderlist.setOrdernum(orderId);
//						userOrderlist.setGoodsid(glist.get(i).getGoodsId());
//						userOrderlist.setGoodstitle(g.getTitle());
//						userOrderlist.setGoodsimage(g.getImage());
//						userOrderlist.setGoodsdesc(g.getGoodsdesc());
//						userOrderlist.setGoodsSpecification(g.getSpecification());
//						if (glist.get(i).getCount() < 0) {
//							res.setResultNote("订单异常，请返回查看");
//							return res;
//						}
//						userOrderlist.setGoodsnum(glist.get(i).getCount());
//
//						if (null != g.getDiscountprice() && !"".equals(g.getDiscountprice()) && Double.valueOf(g.getDiscountprice())> 0) {
//							userOrderlist.setDiscountprice(String.valueOf(g.getDiscountprice()));
//						}
//						if (g.getCuprice() != null && g.getCuprice() > 0) {
//							userOrderlist.setGoodsprice(g.getCuprice());
//							if(null!=userOrderlist.getDiscountprice() && g.getDiscountprice()> g.getCuprice()){
//								userOrderlist.setDiscountprice(String.valueOf(g.getCuprice()));
//							}
//						} else {
//							userOrderlist.setGoodsprice(g.getPrice());
//						}
//						userOrderlist.setOriginalprice(g.getPrice());
//						allPrice = allPrice.add(new BigDecimal(g.getPrice()).multiply(new BigDecimal(userOrderlist.getGoodsnum())));
//						userOrderlist.setPurchaseprice(g.getPurchaseprice());
//						userOrderlist.setAdtime(new Date());
//						orderList.add(userOrderlist);
//
//						Map<String,Object> ob = userCartService.execSelectSqlEntityObjMap(
//								"SELECT count,startdate,enddate FROM t_goods_community_purchase WHERE communityid='"+tuser.getCommunityid()+"' AND goodsid='"+g.getId()+"' AND state='0' AND enddate>=NOW()");
//						if (null != ob) {
//							Integer purchase = Integer.valueOf(ob.get("count").toString());
//							if (purchase > 0) {
//
//								String order = userCartService.execSelectSqlString(
//										"SELECT IFNULL(SUM(b.goodsnum),0) from t_user_order a,t_user_orderlist b "
//												+ "where a.ordernum = b.ordernum and a.uid = '" + tuser.getId()
//												+ "' and b.goodsid = '" + userOrderlist.getGoodsid() + "' "
//												+ " and a.status not in (9,12) and a.adtime>='"+ob.get("startdate")+"'");
//								if (null != order && !"".equals(order)) {
//									if (Integer.valueOf(order) >= purchase) {
//										res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已购买"+ order+ "件!");
//										return res;
//									}
//
//									if((userOrderlist.getGoodsnum()+Integer.valueOf(order))>purchase) {
//										res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已下单购买过"+ order+ "件!");
//										return res;
//									}
//								}
//								if (userOrderlist.getGoodsnum() > purchase) {
//									res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件");
//									return res;
//								}
//							}
//						}
//					}else {
//						res.setResultNote("您已提交订单，请查看");
//						return res;
//					}
//				// 删除对应购物车
//					userCartService.delete3(req.getUid(), g.getId());
//				}else {
//					UserOrderlist userOrderlist = new UserOrderlist();
//					userOrderlist.setId(IdGen.uuid());
//					userOrderlist.setOrdernum(orderId);
//					userOrderlist.setGoodsid(glist.get(i).getGoodsId());
//					userOrderlist.setGoodstitle(g.getTitle());
//					userOrderlist.setGoodsimage(g.getImage());
//					userOrderlist.setGoodsdesc(g.getGoodsdesc());
//					userOrderlist.setGoodsSpecification(g.getSpecification());
//					if (glist.get(i).getCount() < 0) {
//						res.setResultNote("订单异常，请返回查看");
//						return res;
//					}
//						userOrderlist.setGoodsnum(glist.get(i).getCount());
//
//					if (null != g.getDiscountprice() && !"".equals(g.getDiscountprice()) && Double.valueOf(g.getDiscountprice())> 0) {//有专享价
//						userOrderlist.setDiscountprice(String.valueOf(g.getDiscountprice()));
//					}
//					if (g.getCuprice() != null && g.getCuprice() > 0) {
//						userOrderlist.setGoodsprice(g.getCuprice());
//						if(null!=userOrderlist.getDiscountprice() && g.getDiscountprice()> g.getCuprice()){
//							userOrderlist.setDiscountprice(String.valueOf(g.getCuprice()));
//						}
//					} else {
//						userOrderlist.setGoodsprice(g.getPrice());
//					}
//					userOrderlist.setOriginalprice(g.getPrice());
//					allPrice = allPrice.add(new BigDecimal(g.getPrice()));
//					userOrderlist.setPurchaseprice(g.getPurchaseprice());
//					userOrderlist.setAdtime(new Date());
//					orderList.add(userOrderlist);
//				}
//				if(null==req.getType()||"".equals(req.getType())){
//					if(g.getType().equals("1")){
//						o.setOrdertype("1");
//					}else{
//						o.setOrdertype("2");
//					}
//				}
//			}
//			o.setAllprice(allPrice.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
//			// 生成订单
//			userOrderService.addOrder(o, orderList);
//
//			 * // 使用优惠券 if (req.getSecuritiesid() != null &&
//			 * !"".equals(req.getSecuritiesid())) { userCouponService.
//			 * executeUpdateSql("UPDATE t_user_coupon SET status='1' WHERE  uid ='" +
//			 * req.getUid() + "' AND couponid='" + req.getSecuritiesid() + "'"); }
//
//			// 生成订单号
//			OrderType ot = new OrderType();
//			ot.setId(IdGen.uuid());
//			ot.setUid(req.getUid());
//			ot.setType("1");
//			ot.setState("0");
//			ot.setOrdernum(orderId);
//			orderTypeMapper.insert(ot);
//			// 修改userCoupon的是否使用的状态
//			if (null != req.getSecuritiesid() && !"".equals(req.getSecuritiesid())) {
//				userCouponService.executeUpdateSql("UPDATE t_user_coupon SET status='1' WHERE  uid ='" + tuser.getId()
//						+ "' AND couponid='" + req.getSecuritiesid() + "'");
//			}
//			if (null != req.getCouponId() && !"".equals(req.getCouponId())) {
//				userCouponService.executeUpdateSql("UPDATE t_user_coupon SET status='1' WHERE  uid ='" + tuser.getId()
//						+ "' AND couponid='" + req.getCouponId() + "'");
//			}
//			// 减少库存，增加销量
//			UserOrderlist uol = new UserOrderlist();
//			uol.setOrdernum(orderId);
//			List<UserOrderlist> list1 = userOrderlistService.findList(uol);
//			if (list1 != null && list1.size() > 0) {
//				for (UserOrderlist od : list1) {
//					GoodsCommunity g = goodsCommunityService.getGoodsStock(o.getCommunityid(), od.getGoodsid());
//					if (!"1".equals(g.getType())) {
//						g.setStock(g.getStock() - od.getGoodsnum());
//					}
//					g.setSallnum(Integer.valueOf(g.getCount()) + od.getGoodsnum());
//					goodsCommunityService.save(g);
//				}
//			}
//			res.setOderNum(orderId);
//			res.setBalance(tuser.getBalance() + "");
//			res.setResult("0");
//			res.setResultNote("提交订单成功");
//		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			logger.error("请求处理异常：11388" );
//			e.printStackTrace();
//			// throw new RuntimeException(); //事务回滚
//			// 抛异常对执行过的sql回滚
//		}
//
//		return res;
//	}
//*/
//
//	public ResJson codeSubmitOrder(AddCartGoodsOrderNewReq req) {
//		AddGoodsOrderRes res = new AddGoodsOrderRes();
//		res.setResultNote("提交失败");
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户ID不能为空");
//			return res;
//		}
//		if(!"2".equals(req.getActivityType())) {
//			if (StringUtils.isBlank(req.getAddressId())) {
//				res.setResultNote("请选择收货地址");
//				return res;
//			}
//		}
//		try {
//			// 判断用户状态
//			Tuser tuser = tuserService.get(req.getUid());
//
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户已被禁用");
//				return res;
//			}
//
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//			Map<String, String> merchantRest = communityService.execSelectSqlEntityMap("SELECT startTime AS startTime,endTime AS endTime FROM t_merchant_rest "
//					+ "WHERE NOW() >= startTime AND NOW() <= endTime AND communityid ='"+tuser.getCommunityid()+"' AND state=0");
//			if(null != merchantRest && merchantRest.size()>0) {
//				res.setResultNote("商家"+sf.format(merchantRest.get("startTime"))+"至"+sf.format(merchantRest.get("endTime"))+"打烊");
//				return res;
//			}
//			Community c = communityService.get(tuser.getCommunityid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该商家暂时不能下单");
//				return res;
//			}
//			// 获取收货地址
//			Address address = addressService.get(req.getAddressId());
//			if(!"2".equals(req.getActivityType())) {
//				if (null == address) {
//					res.setResultNote("收货地址不存在");
//					return res;
//				}
//				if(StringUtils.isBlank(address.getAddress())||address.getAddress().length()<4){
//					res.setResultNote("请完善收货地址");
//					return res;
//				}
//				if(address.getCommunityName().indexOf(c.getName1())<0 && address.getAddress().indexOf(c.getName1())<0){
//					res.setResultNote("收货地址不在配送范围内，请重新选择！");
//					return res;
//				}
//			}
//			if (req.getGoodsList() == null || req.getGoodsList().size() == 0) {
//				res.setResultNote("请选择要购买的商品");
//				return res;
//			}
////			String orderType = userCartService.execSelectSqlString("SELECT DISTINCT if(type=0,2,type) FROM t_user_cart WHERE uid='"+tuser.getId()+"'");
//			// 查询库存是否足够
//			if (!"1".equals(req.getType())) {
//				List<GoodsListBean> slist = req.getGoodsList();
//				for (GoodsListBean gs : slist) {
////					GoodsCommunity g=null;
////					if(StringUtils.isBlank(gs.getActivityid())){
////						g = goodsCommunityService.gets(tuser.getCommunityid(), gs.getGoodsId());
////					}else{
//					GoodsCommunity g = goodsCommunityService.getsTwo(tuser.getCommunityid(), gs.getGoodsId(),gs.getActivityid());
////					}
//					if (g.getShelves().equals("1")||g.getGoodsState().equals("1")){
//						res.setResultNote("["+g.getGoodsname()+"]已下架,请不要选择该商品！");
//						return res;
//					}
//					if (gs.getCount() > g.getStock()) {
//						res.setResultNote("["+g.getGoodsname()+"]库存不足");
//						return res;
//					}
//					if (Double.valueOf(g.getGoodsprice())<=0) {
//						res.setResultNote("["+g.getGoodsname()+"]价格有问题，请联系商家");
//						return res;
//					}
//				}
//			}
//			// 库存足够创建订单
//			UserOrder o = new UserOrder();
//			String orderId = StringUtil.getOrderNo();
//			o.setId(IdGen.uuid());
//			o.setUid(req.getUid());
//			o.setCommunityid(tuser.getCommunityid());
//			if(!"2".equals(req.getActivityType())) {
//				o.setUsername(address.getUsername());
//				o.setUserphone(address.getUserphone());
//				o.setUsercity(address.getCity());
//				o.setUseraddress(address.getAddress());
//			}
//			o.setOrdertype(req.getType());
//			o.setActivityType(req.getActivityType());//活动类型
//		/*	o.setAllprice(allPrice);
//			o.setPayprice(payPrice);*/
//            o.setAllprice(StringUtils.isBlank(req.getAllprice()) ? 0 : Double.valueOf(req.getAllprice()));
//			if (null != req.getPayprice() && !"".equals(req.getPayprice()) && Double.valueOf(req.getPayprice()) != 0) {
//				o.setPayprice(StringUtils.isBlank(req.getPayprice()) ? 0 : Double.valueOf(req.getPayprice()));
//			} else {
//				res.setResultNote("操作有误，请重新下单");
//				return res;
//			}
//			if (null != req.getDiscountprice() && !"".equals(req.getDiscountprice()) && Double.valueOf(req.getDiscountprice()) != 0) {//如果有专享价
//				o.setDiscountprice(StringUtils.isBlank(req.getDiscountprice()) ? 0 : Double.valueOf(req.getDiscountprice()));
//			}
//			o.setStatus("1");
//			o.setIsaccount("0");
//			o.setMessage(req.getMessage());
//			if (req.getSecuritiesid() != null && !"".equals(req.getSecuritiesid())) {
//				// 使用优惠券
//				List<Object> amount = userCouponService.executeSelectSql("SELECT amount FROM t_user_coupon WHERE uid='"
//						+ req.getUid() + "' AND couponid='" + req.getSecuritiesid() + "'");
//				o.setCouponid(req.getSecuritiesid());
//				if (null != amount && amount.size() > 0) {
//					o.setCouponmoney(amount.get(0).toString() + "");
//				}
//			}
//			if (req.getCouponId() != null && !"".equals(req.getCouponId())) {// 暂用版本
//				// 使用优惠券
//				o.setCouponid(req.getCouponId());
//				List<Object> amount = userCouponService.executeSelectSql("SELECT amount FROM t_user_coupon WHERE uid='"
//						+ req.getUid() + "' AND couponid='" + req.getCouponId() + "'");
//				if (null != amount && amount.size() > 0) {
//					o.setCouponmoney(amount.get(0).toString() + "");
//				}
//			}
//			o.setOrdernum(orderId);
//			o.setAdtime(new Date());
//			o.setUpdatetime(new Date());
//			List<GoodsListBean> glist = req.getGoodsList();
//			List<UserOrderlist> orderList = new ArrayList<UserOrderlist>();
//			for (int i = 0; i < glist.size(); i++) {
//				Goods g = new Goods();
//				g.setId(glist.get(i).getGoodsId());
//				g.setCommunityid(tuser.getCommunityid());
//				g = goodsService.gets(g);
//				if(!"2".equals(req.getActivityType())){
//					List<Object> goodCount = userCartService.executeSelectSql("SELECT count FROM t_user_cart WHERE uid = '"
//							+ req.getUid() + "' " + "AND goodsid='" + glist.get(i).getGoodsId() + "'");
//					if (null != goodCount && goodCount.size() > 0 && null != goodCount.get(0)&& !"0".equals(goodCount.get(0).toString())) {
//						UserOrderlist userOrderlist = new UserOrderlist();
//						userOrderlist.setId(IdGen.uuid());
//						userOrderlist.setOrdernum(orderId);
//						userOrderlist.setGoodsid(glist.get(i).getGoodsId());
//						userOrderlist.setGoodstitle(g.getTitle());
//						userOrderlist.setGoodsimage(g.getImage());
//						userOrderlist.setGoodsdesc(g.getGoodsdesc());
//						userOrderlist.setGoodsSpecification(g.getSpecification());
//						if (glist.get(i).getCount() < 0) {
//							res.setResultNote("订单异常，请返回查看");
//							return res;
//						}
//						userOrderlist.setGoodsnum(glist.get(i).getCount());
//
//						if (null != g.getDiscountprice() && !"".equals(g.getDiscountprice()) && Double.valueOf(g.getDiscountprice())> 0) {
//							userOrderlist.setDiscountprice(String.valueOf(g.getDiscountprice()));
//						}
//						if(StringUtils.isBlank(glist.get(i).getActivityid())){
//							if (g.getCuprice() != null && g.getCuprice() > 0) {
//								userOrderlist.setGoodsprice(g.getCuprice());
//								if(null!=userOrderlist.getDiscountprice() && g.getDiscountprice()> g.getCuprice()){
//									userOrderlist.setDiscountprice(String.valueOf(g.getCuprice()));
//								}
//							} else {
//								userOrderlist.setGoodsprice(g.getPrice());
//							}
//						}else{
//							userOrderlist.setGoodsprice(Double.valueOf(glist.get(i).getActivityprice()));
//							userOrderlist.setActivityid(glist.get(i).getActivityid());
//						}
//						userOrderlist.setOriginalprice(g.getPrice());
//						userOrderlist.setPurchaseprice(g.getPurchaseprice());
//						userOrderlist.setAdtime(new Date());
//						orderList.add(userOrderlist);
//						if(StringUtils.isBlank(glist.get(i).getActivityid())){//判断活动商品的库存
//							Map<String,Object> ob = userCartService.execSelectSqlEntityObjMap(
//								"SELECT count,startdate,enddate FROM t_goods_community_purchase WHERE communityid='"+tuser.getCommunityid()+"' AND goodsid='"+g.getId()+"' AND state='0' AND enddate>=NOW()");
//							if (null != ob) {
//								Integer purchase = Integer.valueOf(ob.get("count").toString());
//								if (purchase > 0) {
//
//									String order = userCartService.execSelectSqlString(
//											"SELECT IFNULL(SUM(b.goodsnum),0) from t_user_order a,t_user_orderlist b "
//													+ "where a.ordernum = b.ordernum and a.uid = '" + tuser.getId()
//													+ "' and b.goodsid = '" + userOrderlist.getGoodsid() + "' "
//													+ " and a.status not in (9,12) and a.adtime>='"+ob.get("startdate")+"'");
//									if (null != order && !"".equals(order)) {
//										if (Integer.valueOf(order) >= purchase) {
//											res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已购买"+ order+ "件!");
//											return res;
//										}
//
//										if((userOrderlist.getGoodsnum()+Integer.valueOf(order))>purchase) {
//											res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已下单购买过"+ order+ "件!");
//											return res;
//										}
//									}
//									if (userOrderlist.getGoodsnum() > purchase) {
//										res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件");
//										return res;
//									}
//								}
//							}
//						}else{
//							Map<String,Object> map=new HashMap<String,Object>();
//							map.put("goodsid", g.getId());
//							map.put("activityid", glist.get(i).getActivityid());
//							Map<String,Object> mapXG= activitylistgoodsSerivce.selectXG(map);
//							if(null!=mapXG){
//								Integer purchase = Integer.valueOf(mapXG.get("restrictionnum").toString());
//								if(purchase>0){
//									map.put("uid", tuser.getId());
//									Map<String,Object> by=activitylistgoodsSerivce.selectBuyNum(map);
//									if(null!=by){
//										Integer buyNum=Integer.valueOf(by.get("buynum").toString());
//										if (buyNum >= purchase) {
//											res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已购买"+ buyNum+ "件!");
//											return res;
//										}
//
//										if((userOrderlist.getGoodsnum()+buyNum)>purchase) {
//											res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已下单购买过"+ buyNum+ "件!");
//											return res;
//										}
//									}
//									if (userOrderlist.getGoodsnum() > purchase) {
//										res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件");
//										return res;
//									}
//								}
//							}
//						}
//						// 删除对应购物车
//						userCartService.delete3(req.getUid(), g.getId());
//						//小程序直接购买
//					}else if(StringUtils.isNotBlank(req.getXcx())&&"XCX".equals(req.getXcx())){
//						UserOrderlist userOrderlist = new UserOrderlist();
//						userOrderlist.setId(IdGen.uuid());
//						userOrderlist.setOrdernum(orderId);
//						userOrderlist.setGoodsid(glist.get(i).getGoodsId());
//						userOrderlist.setGoodstitle(g.getTitle());
//						userOrderlist.setGoodsimage(g.getImage());
//						userOrderlist.setGoodsdesc(g.getGoodsdesc());
//						userOrderlist.setGoodsSpecification(g.getSpecification());
//						if (glist.get(i).getCount() < 0) {
//							res.setResultNote("订单异常，请返回查看");
//							return res;
//						}
//						userOrderlist.setGoodsnum(glist.get(i).getCount());
//
//						if (null != g.getDiscountprice() && !"".equals(g.getDiscountprice()) && Double.valueOf(g.getDiscountprice())> 0) {
//							userOrderlist.setDiscountprice(String.valueOf(g.getDiscountprice()));
//						}
//						if(StringUtils.isBlank(glist.get(i).getActivityid())){
//							if (g.getCuprice() != null && g.getCuprice() > 0) {
//								userOrderlist.setGoodsprice(g.getCuprice());
//								if(null!=userOrderlist.getDiscountprice() && g.getDiscountprice()> g.getCuprice()){
//									userOrderlist.setDiscountprice(String.valueOf(g.getCuprice()));
//								}
//							} else {
//								userOrderlist.setGoodsprice(g.getPrice());
//							}
//						}else{
//							userOrderlist.setGoodsprice(Double.valueOf(glist.get(i).getActivityprice()));
//							userOrderlist.setActivityid(glist.get(i).getActivityid());
//						}
//						userOrderlist.setOriginalprice(g.getPrice());
//						userOrderlist.setPurchaseprice(g.getPurchaseprice());
//						userOrderlist.setAdtime(new Date());
//						orderList.add(userOrderlist);
//						if(StringUtils.isBlank(glist.get(i).getActivityid())){//判断活动商品的库存
//							Map<String,Object> ob = userCartService.execSelectSqlEntityObjMap(
//								"SELECT count,startdate,enddate FROM t_goods_community_purchase WHERE communityid='"+tuser.getCommunityid()+"' AND goodsid='"+g.getId()+"' AND state='0' AND enddate>=NOW()");
//							if (null != ob) {
//								Integer purchase = Integer.valueOf(ob.get("count").toString());
//								if (purchase > 0) {
//
//									String order = userCartService.execSelectSqlString(
//											"SELECT IFNULL(SUM(b.goodsnum),0) from t_user_order a,t_user_orderlist b "
//													+ "where a.ordernum = b.ordernum and a.uid = '" + tuser.getId()
//													+ "' and b.goodsid = '" + userOrderlist.getGoodsid() + "' "
//													+ " and a.status not in (9,12) and a.adtime>='"+ob.get("startdate")+"'");
//									if (null != order && !"".equals(order)) {
//										if (Integer.valueOf(order) >= purchase) {
//											res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已购买"+ order+ "件!");
//											return res;
//										}
//
//										if((userOrderlist.getGoodsnum()+Integer.valueOf(order))>purchase) {
//											res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已下单购买过"+ order+ "件!");
//											return res;
//										}
//									}
//									if (userOrderlist.getGoodsnum() > purchase) {
//										res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件");
//										return res;
//									}
//								}
//							}
//						}else{
//							Map<String,Object> map=new HashMap<String,Object>();
//							map.put("goodsid", g.getId());
//							map.put("activityid", glist.get(i).getActivityid());
//							Map<String,Object> mapXG= activitylistgoodsSerivce.selectXG(map);
//							if(null!=mapXG){
//								Integer purchase = Integer.valueOf(mapXG.get("restrictionnum").toString());
//								if(purchase>0){
//									map.put("uid", tuser.getId());
//									Map<String,Object> by=activitylistgoodsSerivce.selectBuyNum(map);
//									if(null!=by){
//										Integer buyNum=Integer.valueOf(by.get("buynum").toString());
//										if (buyNum >= purchase) {
//											res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已购买"+ buyNum+ "件!");
//											return res;
//										}
//
//										if((userOrderlist.getGoodsnum()+buyNum)>purchase) {
//											res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已下单购买过"+ buyNum+ "件!");
//											return res;
//										}
//									}
//									if (userOrderlist.getGoodsnum() > purchase) {
//										res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件");
//										return res;
//									}
//								}
//							}
//						}
//					}else {
//						res.setResultNote("您已提交订单，请查看");
//						return res;
//					}
//				}else {
//					UserOrderlist userOrderlist = new UserOrderlist();
//					userOrderlist.setId(IdGen.uuid());
//					userOrderlist.setOrdernum(orderId);
//					userOrderlist.setGoodsid(glist.get(i).getGoodsId());
//					userOrderlist.setGoodstitle(g.getTitle());
//					userOrderlist.setGoodsimage(g.getImage());
//					userOrderlist.setGoodsdesc(g.getGoodsdesc());
//					userOrderlist.setGoodsSpecification(g.getSpecification());
//					if (glist.get(i).getCount() < 0) {
//						res.setResultNote("订单异常，请返回查看");
//						return res;
//					}
//						userOrderlist.setGoodsnum(glist.get(i).getCount());
//
//					if (null != g.getDiscountprice() && !"".equals(g.getDiscountprice()) && Double.valueOf(g.getDiscountprice())> 0) {//有专享价
//						userOrderlist.setDiscountprice(String.valueOf(g.getDiscountprice()));
//					}
//					//如果没有活动id
//					if(StringUtils.isBlank(glist.get(i).getActivityid())){
//						if (g.getCuprice() != null && g.getCuprice() > 0) {
//							userOrderlist.setGoodsprice(g.getCuprice());
//							if(null!=userOrderlist.getDiscountprice() && g.getDiscountprice()> g.getCuprice()){
//								userOrderlist.setDiscountprice(String.valueOf(g.getCuprice()));
//							}
//						} else {
//							userOrderlist.setGoodsprice(g.getPrice());
//						}
//					}else{
//						userOrderlist.setGoodsprice(Double.valueOf(glist.get(i).getActivityprice()));
//						userOrderlist.setActivityid(glist.get(i).getActivityid());
//					}
//
//					userOrderlist.setOriginalprice(g.getPrice());
//					userOrderlist.setPurchaseprice(g.getPurchaseprice());
//					userOrderlist.setAdtime(new Date());
//					orderList.add(userOrderlist);
//				}
//				if(null==req.getType()||"".equals(req.getType())){
//					if(g.getType().equals("1")){
//						o.setOrdertype("1");
//					}else{
//						o.setOrdertype("2");
//					}
//				}
//			}
//			// 生成订单
//			userOrderService.addOrder(o, orderList);
//			/*
//			 * // 使用优惠券 if (req.getSecuritiesid() != null &&
//			 * !"".equals(req.getSecuritiesid())) { userCouponService.
//			 * executeUpdateSql("UPDATE t_user_coupon SET status='1' WHERE  uid ='" +
//			 * req.getUid() + "' AND couponid='" + req.getSecuritiesid() + "'"); }
//			 */
//			// 生成订单号
//			OrderType ot = new OrderType();
//			ot.setId(IdGen.uuid());
//			ot.setUid(req.getUid());
//			ot.setType("1");
//			ot.setState("0");
//			ot.setOrdernum(orderId);
//			orderTypeMapper.insert(ot);
//			// 修改userCoupon的是否使用的状态
//			if (null != req.getSecuritiesid() && !"".equals(req.getSecuritiesid())) {
//				userCouponService.executeUpdateSql("UPDATE t_user_coupon SET status='1' WHERE  uid ='" + tuser.getId()
//						+ "' AND couponid='" + req.getSecuritiesid() + "'");
//			}
//			if (null != req.getCouponId() && !"".equals(req.getCouponId())) {
//				userCouponService.executeUpdateSql("UPDATE t_user_coupon SET status='1' WHERE  uid ='" + tuser.getId()
//						+ "' AND couponid='" + req.getCouponId() + "'");
//			}
//			// 减少库存，增加销量
//			UserOrderlist uol = new UserOrderlist();
//			uol.setOrdernum(orderId);
//			List<UserOrderlist> list1 = userOrderlistService.findList(uol);
//			if (list1 != null && list1.size() > 0) {
//				for (UserOrderlist od : list1) {
//					// GoodsCommunity g = goodsCommunityService.getGoodsStock(o.getCommunityid(), od.getGoodsid());
//					GoodsCommunity g=null;
//					if(StringUtils.isBlank(od.getActivityid())){
//						g = goodsCommunityService.getGoodsStock(o.getCommunityid(), od.getGoodsid());
//						if (!"1".equals(g.getType())) {
//							g.setStock(g.getStock() - od.getGoodsnum());
//						}
//						g.setSallnum(Integer.valueOf(g.getCount()) + od.getGoodsnum());
//						goodsCommunityService.save(g);
//					}else{
//						g = goodsCommunityService.getsTwo(o.getCommunityid(), od.getGoodsid(),od.getActivityid());
//						if(!"10000".equals(g.getStock())){
//							int activitynum=g.getStock() - od.getGoodsnum();
//							Map<String,Object> map=new HashMap<String,Object>();
//							map.put("activitynum", activitynum);
//							map.put("goodsid", od.getGoodsid());
//							map.put("activityid", od.getActivityid());
//							activitylistgoodsSerivce.updateActivityNum(map);
//						}
//					}
//
//				}
//			}
//			res.setOderNum(orderId);
//			res.setBalance(tuser.getBalance() + "");
//			res.setResult("0");
//			res.setResultNote("提交订单成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：11388" );
//			e.printStackTrace();
//			// throw new RuntimeException(); //事务回滚
//			// TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//
//			// 抛异常对执行过的sql回滚
//		}
//
//		return res;
//	}
//
//	/**
//	 * 立即支付
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codeImmediatePayment(GetPayDetailReq req, HttpServletRequest request) {
//		ResJson res = new ResJson();
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户的id不可空");
//			return res;
//		}
//
//		if (StringUtils.isBlank(req.getOrdernum())&&StringUtils.isBlank(req.getOrderNum())) {
//			res.setResultNote("订单号不可空");
//			return res;
//		}else{
//			if(StringUtils.isBlank(req.getOrdernum())){
//				req.setOrdernum(req.getOrderNum());
//			}
//		}
//		if (!"1".equals(req.getType())) {
//			if (StringUtils.isBlank(req.getPayprice() + "")) {
//				res.setResultNote("支付金额不可为空");
//				return res;
//			}
//		}
//
//		Tuser tuser = tuserService.get(req.getUid());
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		Map<String, String> merchantRest = communityService.execSelectSqlEntityMap("SELECT startTime AS startTime,endTime AS endTime FROM t_merchant_rest "
//				+ "WHERE NOW() >= startTime AND NOW() <= endTime AND communityid ='"+tuser.getCommunityid()+"' AND state=0");
//		if(null != merchantRest && merchantRest.size()>0) {
//			res.setResultNote("商家"+sf.format(merchantRest.get("startTime"))+"至"+sf.format(merchantRest.get("endTime"))+"打烊");
//			return res;
//		}else{
//			Community c = communityService.get(tuser.getCommunityid());
//			if(c.getState().equals("1")){
//				res.setResultNote("该店已经打烊，请联系商家！");
//				return res;
//			}
//		}
//		String note = csc.shopRest();
//		if(StringUtils.isNotBlank(note)){
//			res.setResultNote(note);
//			return res;
//		}
//
//		try {
//			//TODO 订单已经支付或者正在支付中判断
////			OrderType ordertype = orderTypeMapper.gets(req.getOrdernum());
////			if("2".equals(ordertype.getState())||"1".equals(ordertype.getState())){
////				res.setResultNote("订单已经支付或者正在支付中");
////				return res;
////			}
//
//			Map<String, Object> map = new HashMap<>();
//			if ("1".equals(req.getPaytype())) {// 支付宝支付
//				String userOrder = userOrderService.selectPayPrice(req.getOrdernum());// 订单查询的payPrice
//				if (null != userOrder) {
//					BigDecimal orderPay = new BigDecimal(req.getPayprice()).setScale(2, BigDecimal.ROUND_HALF_UP);// 传过来的payPrice
//					BigDecimal userOrderPay = new BigDecimal(userOrder.replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//					if (orderPay.compareTo(userOrderPay) != 0) {
//						orderTypeMapper.execUpdateSql("UPDATE t_order_type SET money ='" + userOrderPay.doubleValue()
//								+ "',remark='付款的钱和数据库里面存的钱不一致' WHERE ordernum ='" + req.getOrdernum() + "'");
//						logger.error("付款的钱和数据库里面存的钱不一致");
//						res.setResultNote("订单支付有误，请联系管理员");
//						return res;
//					}
//				}else{
//					logger.error(req.getOrdernum()+"付款的钱和数据库里面存的钱不一致");
//					res.setResultNote("订单支付有误，请联系管理员");
//					return res;
//				}
//
//				// 实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型），为了取得预付订单信息
//				AlipayClient alipayClient = new DefaultAlipayClient(AlipayCg.URL, AlipayCg.APPID,
//						AlipayCg.RSA_PRIVATE_KEY, AlipayCg.FORMAT, AlipayCg.CHARSET, AlipayCg.ALIPAY_PUBLIC_KEY,
//						AlipayCg.SIGNTYPE);
//
//				// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
//				AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
//
//				// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式
//				AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
//
//				// 业务参数传入,可以传很多，参考API
//				// model.setPassbackParams(URLEncoder.encode(request.getBody().toString()));
//				// //公用参数（附加数据）
//				model.setBody("订单支付"); // 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
//
//				if ("1".equals(req.getGoodsType())) {
//					model.setSubject("洗衣洗鞋"); // 商品名称
//				} else {
//					model.setSubject("果蔬超市"); // 商品名称
//				}
//				model.setOutTradeNo(req.getOrdernum()); // 商户订单号(自动生成)
//				model.setTimeoutExpress("30m"); // 交易超时时间
//				model.setTotalAmount(userOrder); // 支付金额
//				model.setProductCode("QUICK_MSECURITY_PAY"); // 销售产品码（固定值）
//				ali_request.setNotifyUrl(AlipayCg.NOTIFYURL);
//				ali_request.setBizModel(model);
//				// 这里和普通的接口调用不同，使用的是sdkExecute
//				AlipayTradeAppPayResponse alipayTradeAppPayResponse = alipayClient.sdkExecute(ali_request); // 返回支付宝订单信息(预处理)
//				String body = alipayTradeAppPayResponse.getBody();// 就是orderString 可以直接给APP请求，无需再做处理。
//				map.put("body", body);
//
//			} else if ("2".equals(req.getPaytype())) {// 微信支付
//				// 获取用户ip
//				String ip = request.getHeader("x-forwarded-for");
//				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//					ip = request.getHeader("Proxy-Client-IP");
//				}
//				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//					ip = request.getHeader("WL-Proxy-Client-IP");
//				}
//				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//					ip = request.getRemoteAddr();
//				}
//				if (ip.contains(",")) {
//					ip = ip.split(",")[0];
//				}
//
//				List<Map<String, String>> param = new ArrayList<>();
//				Map<String, String> mapPay = new HashMap<>();
//
//				mapPay.put("appid", WXpayCg.APP_ID);
//				// 商品简单描述，该字段请按照规范传递
//				mapPay.put("body", "逗邻");
//				mapPay.put("mch_id", WXpayCg.MCH_ID);// 商户id号
//				// 随机字符串==随机字符串，不长于32位
//				mapPay.put("nonce_str", RandomStringUtils.randomAlphabetic(32));
//				mapPay.put("notify_url", WXpayCg.NOTIFYURL);
//				if (null != req.getType() && "1".equals(req.getType())) {//公众号 生成订单号 支付
//					mapPay.put("appid", WXpayCg.MP_APP_ID);
//					BigDecimal bg = null;// 购买商品价
//					BigDecimal bg1 = null;// 商品购买量
//					BigDecimal bg2 = null;// 支付总金额
//					double allPrice = 0;// 支付总金额
//					List<GoodsListBean> dataList = req.getGoodsList();
//					String type = null;// 商品类型
//					if (null != dataList && dataList.size() > 0) {
//						for (GoodsListBean goodsBeen : dataList) {
//							GoodsCommunity goods = goodsCommunityService.gets(req.getCommunityid(),
//									goodsBeen.getGoodsId());
//							bg1 = new BigDecimal(Double.toString(goodsBeen.getCount())).setScale(2,
//									BigDecimal.ROUND_HALF_UP);
//							if (null != goods.getGoodscuprice() && !"".equals(goods.getGoodscuprice())) {
//								if (Double.valueOf(goods.getGoodscuprice()) > 0) {
//									bg = new BigDecimal(goods.getGoodscuprice().replaceAll(",", ""));
//								} else {
//									res.setResultNote("促销价为负不可结算，请查看");
//									return res;
//								}
//							} else {
//								bg = new BigDecimal(goods.getGoodsprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//							}
//							bg2 = new BigDecimal(allPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//							goodsBeen.setGoodsSumPrice(
//									bg.multiply(bg1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
//							allPrice = bg2.add(bg.multiply(bg1)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//							if("0".equals(goods.getType())) {
//								type="2";
//							}else if("2".equals(goods.getType())) {
//								type="0";
//							}else{
//								type = goods.getType();
//							}
//						}
//					}
//
//					Address address = new Address();
//					address.setUid(tuser.getId());
//					address = addressService.gets(address);
//					// 查询库存是否足够
//					List<GoodsListBean> slist = req.getGoodsList();
//					for (GoodsListBean gs : slist) {
//						// 查到商品类型
//						List<Object> goodsStock = goodsCommunityService.executeSelectSql(
//								"SELECT gc.stock FROM t_goods_community gc LEFT JOIN t_goods g ON gc.goodsid = g.id  "
//										+ "WHERE gc.communityid ='"+req.getCommunityid()+"' AND gc.goodsid='"+gs.getGoodsId()+"' AND g.type !=1");
//						if (null != goodsStock && goodsStock.size() > 0) {
//							Integer stock = Integer.valueOf(goodsStock.get(0).toString());
//							if (gs.getCount() > stock) {
//								res.setResultNote(stock + "库存不足");
//								return res;
//							}
//						}else {
//							res.setResultNote("商家未补货");
//							return res;
//						}
//					}
//
//					// 库存足够创建订单
//					UserOrder o = new UserOrder();
//					String orderId = StringUtil.getOrderNo();
//					o.setId(IdGen.uuid());
//					o.setUid(req.getUid());
//					o.setCommunityid(tuser.getCommunityid());
//					o.setUsername(address.getUsername());
//					o.setUserphone(address.getUserphone());
//					o.setUsercity(address.getCity());
//					o.setUseraddress(address.getAddress());
//					o.setOrdertype(type);
//					o.setAllprice(allPrice);
//					o.setPayprice(allPrice);
//					o.setStatus("1");
//					o.setIsaccount("0");
//					o.setMessage(req.getMessage());
//					o.setOrdernum(orderId);
//					o.setAdtime(new Date());
//					o.setUpdatetime(new Date());
//					List<GoodsListBean> glist = req.getGoodsList();
//					List<UserOrderlist> orderList = new ArrayList<UserOrderlist>();
//					for (int i = 0; i < glist.size(); i++) {
//						Goods g = new Goods();
//						g.setId(glist.get(i).getGoodsId());
//						g.setCommunityid(tuser.getCommunityid());
//						g = goodsService.gets(g);
//						UserOrderlist userOrderlist = new UserOrderlist();
//						userOrderlist.setId(IdGen.uuid());
//						userOrderlist.setOrdernum(orderId);
//						userOrderlist.setGoodsid(glist.get(i).getGoodsId());
//						userOrderlist.setGoodstitle(g.getTitle());
//						userOrderlist.setGoodsimage(g.getImage());
//						userOrderlist.setGoodsdesc(g.getGoodsdesc());
//						userOrderlist.setGoodsSpecification(g.getSpecification());
//						if (glist.get(i).getCount() < 0) {
//							res.setResultNote("订单异常，请返回查看");
//							return res;
//						}
//						userOrderlist.setGoodsnum(glist.get(i).getCount());
//						if (null != g.getDiscountprice() && !"".equals(g.getDiscountprice()) && Double.valueOf(g.getDiscountprice())> 0) {//有专享价
//							userOrderlist.setDiscountprice(String.valueOf(g.getDiscountprice()));
//						}
//						if (g.getCuprice() != null && g.getCuprice() > 0) {
//							userOrderlist.setGoodsprice(g.getCuprice());
//							if(null!=userOrderlist.getDiscountprice() && g.getDiscountprice()> g.getCuprice()){
//								userOrderlist.setDiscountprice(String.valueOf(g.getCuprice()));
//							}
//						} else {
//							userOrderlist.setGoodsprice(g.getPrice());
//						}
//						userOrderlist.setOriginalprice(g.getPrice());
//						userOrderlist.setPurchaseprice(g.getPurchaseprice());
//						userOrderlist.setAdtime(new Date());
//						orderList.add(userOrderlist);
//
//						Map<String,Object> ob = userCartService.execSelectSqlEntityObjMap(
//								"SELECT count,startdate,enddate FROM t_goods_community_purchase WHERE communityid='"+tuser.getCommunityid()+"' AND goodsid='"+g.getId()+"' AND state='0' AND enddate>=NOW()");
//						if (null != ob) {
//							Integer purchase = Integer.valueOf(ob.get("count").toString());
//							if (purchase > 0) {
//
//								String order = userCartService.execSelectSqlString(
//										"SELECT IFNULL(SUM(b.goodsnum),0) from t_user_order a,t_user_orderlist b "
//												+ "where a.ordernum = b.ordernum and a.uid = '" + tuser.getId()
//												+ "' and b.goodsid = '" + userOrderlist.getGoodsid() + "' "
//												+ " and a.status not in (9,12) and a.adtime>='"+ob.get("startdate")+"'");
//								if (null != order && !"".equals(order)) {
//									if (Integer.valueOf(order) >= purchase) {
//										res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已购买"+ order+ "件!");
//										return res;
//									}
//
//									if((userOrderlist.getGoodsnum()+Integer.valueOf(order))>purchase) {
//										res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件,您已下单购买过"+ order+ "件!");
//										return res;
//									}
//								}
//								if (userOrderlist.getGoodsnum() > purchase) {
//									res.setResultNote(userOrderlist.getGoodstitle() + "限购" + purchase + "件");
//									return res;
//								}
//							}
//						}
//					}
//					// 生成订单
//					userOrderService.addOrder(o, orderList);
//
//					// 生成订单号
//					OrderType ot = new OrderType();
//					ot.setId(IdGen.uuid());
//					ot.setUid(req.getUid());
//					ot.setType("1");
//					ot.setState("0");
//					ot.setOrdernum(orderId);
//					orderTypeMapper.insert(ot);
//					// 减少库存，增加销量
//					UserOrderlist uol = new UserOrderlist();
//					uol.setOrdernum(orderId);
//					List<UserOrderlist> list1 = userOrderlistService.findList(uol);
//					if (list1 != null && list1.size() > 0) {
//						for (UserOrderlist od : list1) {
//							GoodsCommunity g = goodsCommunityService.getGoodsStock(o.getCommunityid(), od.getGoodsid());
//							if (!"1".equals(g.getType())) {
//								g.setStock(g.getStock() - od.getGoodsnum());
//							}
//							g.setSallnum(g.getSallnum() + od.getGoodsnum());
//							goodsCommunityService.save(g);
//						}
//					}
//					mapPay.put("trade_type", "JSAPI");// 公众号支付类型
//					// 交易金额默认为人民币交易，接口中参数支付金额单位为【分】，参数值不能带小数，上面的1000.00指的是元
//					BigDecimal b = new BigDecimal(allPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
//					BigDecimal orderPay = b.multiply(new BigDecimal(100));
//					mapPay.put("total_fee", orderPay.stripTrailingZeros().toPlainString());
//					// 商户订单号==商户系统内部的订单号,32个字符内、可包含字母
//					mapPay.put("out_trade_no", o.getOrdernum());
//					mapPay.put("openid", req.getOpenid());
//				} else {
//					if (null != req.getType() && "2".equals(req.getType())) {//小程序支付
//						mapPay.put("appid", WXpayCg.MINI_APP_ID);
//						mapPay.put("trade_type", WXpayCg.TRADE_TYPE_JS);// 小程序支付类型
//						mapPay.put("openid", req.getOpenid());
//					}else{
//						mapPay.put("trade_type", WXpayCg.TRADE_TYPE_APP);// APP支付类型
//					}
//
//					String userOrder = userOrderService.selectPayPrice(req.getOrdernum());// 订单查询的payPrice金额
//					if (null != userOrder) {
//						// 对钱进行精确计算
//						BigDecimal orderPay = new BigDecimal(req.getPayprice()).setScale(2, BigDecimal.ROUND_HALF_UP);// 传过来的金额
//						BigDecimal userOrderPay = new BigDecimal(userOrder.replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//						if (orderPay.compareTo(userOrderPay) != 0) {
//							orderTypeMapper.execUpdateSql("UPDATE t_order_type SET money ='"
//									+ userOrderPay.doubleValue() + "',remark='付款的钱和数据库里面存的钱不一致' WHERE ordernum ='"
//									+ req.getOrdernum() + "'");
//							logger.error("付款的钱和数据库里面存的钱不一致");
//						}
//					}else{
//						logger.error(req.getOrdernum()+"付款的钱和数据库里面存的钱不一致");
//						res.setResultNote("订单支付有误，请联系管理员");
//						return res;
//					}
//					BigDecimal orderPay = new BigDecimal(userOrder).setScale(2, BigDecimal.ROUND_HALF_UP);
//					// 交易金额默认为人民币交易，接口中参数支付金额单位为【分】，参数值不能带小数，上面的1000.00指的是元
//					orderPay = orderPay.multiply(new BigDecimal(100));
//					mapPay.put("total_fee", orderPay.stripTrailingZeros().toPlainString());
//					// 商户订单号==商户系统内部的订单号,32个字符内、可包含字母
//					mapPay.put("out_trade_no", req.getOrdernum());
//				}
//				// APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。不是必填项
//				mapPay.put("spbill_create_ip", ip);
//				mapPay = MD5.sortMapByKey(mapPay);// 排序
//				param.add(mapPay);
//				StringBuilder sb = new StringBuilder();
//				// 主动创建document对象.
//				Document document = DocumentHelper.createDocument();
//				Element root = document.addElement("xml");
//				for (int i = 0; i < param.size(); i++) {
//					Map<String, String> pair = param.get(i);
//					for (Entry<String, String> vo : pair.entrySet()) {
//						sb.append(vo.getKey()).append("=").append(vo.getValue()).append("&");
//						root.addElement(vo.getKey()).addText(vo.getValue());
//					}
//
//				}
//				sb.append("key=").append(WXpayCg.KEY);
//				// map.put("sign", DigestUtils.md5Hex(sb.toString()).toUpperCase());
//				root.addElement("sign").addText(DigestUtils.md5Hex(sb.toString()).toUpperCase());
//				// String aa = root.asXML();
//				String tenR = HttpPostXML.post(WXpayCg.TENPAYURL, root.asXML());
//				StringBuilder sbclient = new StringBuilder();
//				Map<String, String> map1 = new HashMap<>();
//				try {
//					Document doc = DocumentHelper.parseText(tenR);
//					logger.error(tenR);
//					Element root$ten = doc.getRootElement();
//					Element returnCode = root$ten.element("return_code");
//					Element resultCode = root$ten.element("result_code");
//					if (returnCode.getText().equals("FAIL")) {
//						// log.error(root$ten.element("return_msg").getText());
//					} else if (returnCode.getText().equals("SUCCESS")&&resultCode.getText().equals("SUCCESS")) {
//						try {
//							// 调用接口提交的公众账号ID
//							// map.put("appid", root$ten.element("appid").getText());
//							// 微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
//							map1.put("timestamp", System.currentTimeMillis() / 1000 + "");
//							map1.put("nonce_str", RandomStringUtils.randomAlphabetic(32));
//							if (null != req.getType() && ("1".equals(req.getType())||"2".equals(req.getType()))) {
//								sbclient.append("appId=").append(root$ten.element("appid").getText());
//								sbclient.append("&nonceStr=").append(map1.get("nonce_str"));
//								sbclient.append("&package=")
//										.append("prepay_id=" + root$ten.element("prepay_id").getText());
//								sbclient.append("&signType=").append("MD5");
//								sbclient.append("&timeStamp=").append(map1.get("timestamp"));
//								sbclient.append("&key=").append(WXpayCg.KEY);
//								if ("2".equals(req.getType())) {//小程序支付
//									map1.put("appId", WXpayCg.MINI_APP_ID);
//								}else{//公众号支付
//									map1.put("appId", WXpayCg.MP_APP_ID);
//								}
//								map1.put("nonceStr", map1.get("nonce_str"));
//								map1.put("package", "prepay_id=" + root$ten.element("prepay_id").getText());
//								map1.put("signType", "MD5");
//								map1.put("timeStamp", map1.get("timestamp"));
//								map1.put("paySign", DigestUtils.md5Hex(sbclient.toString()).toUpperCase());
//							} else {
//								sbclient.append("appid=").append(root$ten.element("appid").getText());
//								sbclient.append("&noncestr=").append(map1.get("nonce_str"));
//								sbclient.append("&package=").append("Sign=WXPay");
//								sbclient.append("&partnerid=").append(root$ten.element("mch_id").getText());
//								sbclient.append("&prepayid=").append(root$ten.element("prepay_id").getText());
//								sbclient.append("&timestamp=").append(map1.get("timestamp"));
//								sbclient.append("&key=").append(WXpayCg.KEY);
//								map1.put("appid", WXpayCg.APP_ID);
//								map1.put("mch_id", WXpayCg.MCH_ID);
//								map1.put("prepay_id", root$ten.element("prepay_id").getText());
//								map1.put("sign", DigestUtils.md5Hex(sbclient.toString()).toUpperCase());
//							}
//							map.put("mapwx", map1);
//						} catch (Exception e) {
//							logger.error("请求处理异常：11751" );
//							e.printStackTrace();
//							logger.error("获取微信支付参数失败，失败原因：" + e.getMessage());
//							return res;
//						}
//					}else{
//						Element errdes = root$ten.element("err_code_des");
//						logger.error("支付失败++++++++++++++++++"+errdes);
//						res.setResult("1");
//						res.setResultNote("发起支付失败:"+errdes+"，请联系技术人员！");
//						return res;
//					}
//				} catch (DocumentException e) {
//					logger.error("请求处理异常：11758" );
//					e.printStackTrace();
//					logger.error("获取微信支付参数失败，失败原因：" + e.getMessage());
//					return res;
//				}
//			}
//			if(!"2".equals(req.getType())&&csc.validateVersion(request,"1.5.0")){//从1.5版开始计算
//				orderTypeMapper.execUpdateSql("UPDATE t_order_type SET state ='2' WHERE ordernum ='" + req.getOrdernum() + "'");//逻辑锁定订单
//			}
//			res.setObject(map);
//			res.setResult("0");
//			res.setResultNote("立即支付");
//		} catch (Exception e) {
//			logger.error("请求处理异常：11769" );
//			e.printStackTrace();
//			// TransactionAspectSupport.currentTransactionStatus().createSavepoint();// 事务回滚
//		}
//		return res;
//	}
//
//	/**
//	 * 微信线下扫码支付
//	 * @param amount
//	 * @param communityId
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	public ResJson createWXScanPay(GetPayDetailReq req, HttpServletRequest request){
//		ResJson res = new ResJson();
//
//		if(new BigDecimal(req.getAmount()).compareTo(new BigDecimal("0"))<=0){
//			res.setResultNote("发起线下支付失败，支付金额有问题！");
//			return res;
//		}
//
//		Community c = communityService.get(req.getCommunityid());
//		// 生成订单号
//		String ordernum = new WXpayCg().UNLINE_ORDER_NO;
//		OrderType ot = new OrderType();
//		ot.setId(IdGen.uuid());
//		ot.setUid(req.getUid());
//		ot.setType("3");
//		ot.setState("0");
//		ot.setCommunityid(req.getCommunityid());
//		ot.setMoney(req.getAmount());
//		ot.setOrdernum(ordernum);
//		orderTypeMapper.insert(ot);
//		List<Map<String, String>> param = new ArrayList<>();
//		Map<String, String> mapPay = new HashMap<>();
//		//公众号 生成订单号 支付
//		mapPay.put("appid", WXpayCg.MP_APP_ID);
//		mapPay.put("mch_id", WXpayCg.MCH_ID);// 商户id号
//		// 随机字符串==随机字符串，不长于32位
//		mapPay.put("nonce_str", RandomStringUtils.randomAlphabetic(32));
//		mapPay.put("notify_url", WXpayCg.NOTIFYURL);
//		mapPay.put("trade_type", "JSAPI");// 公众号支付类型
//		mapPay.put("openid", req.getOpenid());
//		// 交易金额默认为人民币交易，接口中参数支付金额单位为【分】，参数值不能带小数，上面的1000.00指的是元
//		BigDecimal b = new BigDecimal(req.getAmount()).setScale(2, BigDecimal.ROUND_HALF_UP);
//		BigDecimal orderPay = b.multiply(new BigDecimal(100));
//		mapPay.put("total_fee", orderPay.stripTrailingZeros().toPlainString());
//		// 商户订单号==商户系统内部的订单号,32个字符内、可包含字母
//		mapPay.put("out_trade_no", ordernum);
//		mapPay.put("spbill_create_ip", IPUtil.getLocalIp());
//		// 商品简单描述，该字段请按照规范传递
//		mapPay.put("body", "逗邻线下支付--"+c.getShopname1());
//		mapPay = MD5.sortMapByKey(mapPay);// 排序
//		param.add(mapPay);
//		StringBuilder sb = new StringBuilder();
//		// 主动创建document对象.
//		Document document = DocumentHelper.createDocument();
//		Element root = document.addElement("xml");
//		for (int i = 0; i < param.size(); i++) {
//			Map<String, String> pair = param.get(i);
//			for (Entry<String, String> vo : pair.entrySet()) {
//				sb.append(vo.getKey()).append("=").append(vo.getValue()).append("&");
//				root.addElement(vo.getKey()).addText(vo.getValue());
//			}
//		}
//		sb.append("key=").append(WXpayCg.KEY);
//		root.addElement("sign").addText(DigestUtils.md5Hex(sb.toString()).toUpperCase());
//		String tenR = HttpPostXML.post(WXpayCg.TENPAYURL, root.asXML());
//		StringBuilder sbclient = new StringBuilder();
//		Map<String, String> map1 = new HashMap<>();
//		try {
//			Document doc = DocumentHelper.parseText(tenR);
//			Element root$ten = doc.getRootElement();
//			Element returnCode = root$ten.element("return_code");
//			Element resultCode = root$ten.element("result_code");
//			if (returnCode.getText().equals("SUCCESS")&&resultCode.getText().equals("SUCCESS")) {
//				try {
//					// 调用接口提交的公众账号ID
//					// map.put("appid", root$ten.element("appid").getText());
//					// 微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
//					map1.put("timestamp", System.currentTimeMillis() / 1000 + "");
//					map1.put("nonce_str", RandomStringUtils.randomAlphabetic(32));
//					sbclient.append("appId=").append(root$ten.element("appid").getText());
//					sbclient.append("&nonceStr=").append(map1.get("nonce_str"));
//					sbclient.append("&package=")
//							.append("prepay_id=" + root$ten.element("prepay_id").getText());
//					sbclient.append("&signType=").append("MD5");
//					sbclient.append("&timeStamp=").append(map1.get("timestamp"));
//					sbclient.append("&key=").append(WXpayCg.KEY);
//					map1.put("appId", WXpayCg.MP_APP_ID);
//					map1.put("nonceStr", map1.get("nonce_str"));
//					map1.put("package", "prepay_id=" + root$ten.element("prepay_id").getText());
//					map1.put("signType", "MD5");
//					map1.put("timeStamp", map1.get("timestamp"));
//					map1.put("paySign", DigestUtils.md5Hex(sbclient.toString()).toUpperCase());
//					res.setResult("0");
//					res.setObject(map1);
//				} catch (Exception e) {
//					logger.error("请求处理异常：11751" );
//					e.printStackTrace();
//					logger.error("获取微信支付参数失败，失败原因：" + e.getMessage());
//					res.setResultNote("获取微信支付参数失败");
//					return res;
//				}
//			}else{
//				Element errdes = root$ten.element("err_code_des");
//				logger.error("支付失败++++++++++++++++++"+errdes);
//				res.setResultNote("发起支付失败:"+errdes+"，请联系技术人员！");
//				return res;
//			}
//		} catch (DocumentException e) {
//			logger.error("线下支付失败++++++++++++++++++");
//			res.setResultNote("发起线下支付失败，请联系技术人员！");
//			return res;
//		}
//		return res;
//	}
//
//	/**
//	 * 支付宝线下扫码支付
//	 * @param amount
//	 * @param communityId
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	public ResJson createAliScanPay(GetPayDetailReq req, HttpServletRequest request){
//		ResJson res = new ResJson();
//		if(new BigDecimal(req.getAmount()).compareTo(new BigDecimal("0"))<=0){
//			res.setResultNote("发起线下支付失败，支付金额有问题！");
//			return res;
//		}
//		Community c = communityService.get(req.getCommunityid());
//		// 生成订单号
//		String ordernum = new WXpayCg().UNLINE_ORDER_NO;
//		OrderType ot = new OrderType();
//		ot.setId(IdGen.uuid());
//		ot.setUid(req.getOpenid());
//		ot.setType("3");
//		ot.setState("0");
//		ot.setMoney(req.getAmount());
//		ot.setOrdernum(ordernum);
//		ot.setCommunityid(req.getCommunityid());
//		orderTypeMapper.insert(ot);
//
//		// 支付宝支付
//		try {
//			// 实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型），为了取得预付订单信息
//			AlipayClient alipayClient = new DefaultAlipayClient(AlipayCg.URL, AlipayCg.APPID,
//					AlipayCg.RSA_PRIVATE_KEY, AlipayCg.FORMAT, AlipayCg.CHARSET, AlipayCg.ALIPAY_PUBLIC_KEY,
//					AlipayCg.SIGNTYPE);
//			// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
//			AlipayTradeCreateRequest ali_request = new AlipayTradeCreateRequest();
//
//
//			// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式
//			AlipayTradeCreateModel model = new AlipayTradeCreateModel();
//
//			// 业务参数传入,可以传很多，参考API
//			// model.setPassbackParams(URLEncoder.encode(request.getBody().toString()));
//			// //公用参数（附加数据）
//			model.setBody(c.getShopname1()+"线下扫码支付"); // 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
//			model.setSubject(c.getShopname1()+"--线下扫码"); // 商品名称
//			model.setOutTradeNo(ordernum); // 商户订单号(自动生成)
//			model.setTimeoutExpress("30m"); // 交易超时时间
//			model.setTotalAmount(req.getAmount() + ""); // 支付金额
//			model.setStoreId(c.getAlistoreid());
//			ali_request.setNotifyUrl(AlipayCg.NOTIFYURL);
//			Map<String,String> biz = Maps.newHashMap();
//			biz.put("out_trade_no", ordernum);
////			biz.put("seller_id", AlipayCg.UID);
//			biz.put("total_amount", req.getAmount());
//			biz.put("subject", c.getShopname1()+"--线下扫码");
//			biz.put("body", c.getShopname1()+"线下扫码支付");
//			biz.put("store_id", c.getAlistoreid());
////			biz.put("buyer_logon_id", req.getOpenid());
//			biz.put("buyer_id", req.getOpenid());
//			biz.put("timeout_express", "30m");
//
//			System.out.println(JSONObject.toJSONString(biz));
//
//			ali_request.setBizContent(JSONObject.toJSONString(biz));
//			// 这里和普通的接口调用不同，使用的是sdkExecute
//			AlipayTradeCreateResponse alipayPayResponse = alipayClient.execute(ali_request); // 返回支付宝订单信息(预处理)
////			String body = alipayPayResponse.getBody();// 就是orderString 可以直接给APP请求，无需再做处理。
//			res.setResult("0");
////			res.setObject(body);
//			res.setModel(alipayPayResponse.getTradeNo());
//		} catch (Exception e) {
//			logger.error("请求处理异常：13176" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 支付宝线下扫码支付查询确认
//	 * @param amount
//	 * @param communityId
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	public ResJson queryAliScanPay(GetPayDetailReq req, HttpServletRequest request){
//		ResJson res = new ResJson();
//		try {
//			AlipayClient alipayClient = new DefaultAlipayClient(AlipayCg.URL, AlipayCg.APPID,
//					AlipayCg.RSA_PRIVATE_KEY, AlipayCg.FORMAT, AlipayCg.CHARSET, AlipayCg.ALIPAY_PUBLIC_KEY,
//					AlipayCg.SIGNTYPE);
//			AlipayTradeQueryRequest ali_request = new AlipayTradeQueryRequest();
//			AlipayTradeQueryModel model = new AlipayTradeQueryModel();
//
//			model.setOutTradeNo(req.getOrderNum()); // 商户订单号(自动生成)
//			Map<String,String> biz = Maps.newHashMap();
//			biz.put("trade_no", req.getOrderNum());
//			ali_request.setBizContent(JSONObject.toJSONString(biz));
//			AlipayTradeQueryResponse alipayPayResponse = alipayClient.execute(ali_request); // 返回支付宝订单信息(预处理)
//			if(alipayPayResponse.isSuccess()){
//				res.setResult("0");
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：13176" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 绑定支付
//	 * @return
//	 */
//	public ResJson codeBindingPay() {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		try {
//			Map<String,String> map =new HashMap<>();
//			map.put("app_id", AlipayCg.APPID);
//			map.put("private_key", AlipayCg.RSA_PRIVATE_KEY);
//			res.setObject(map);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		}catch (Exception e) {
//			logger.error("请求处理异常：11791" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 小区店铺 订单（2确认收货，6取消订单）
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson getVillageShopOrder(GetVillageShopReq req) {
//		AddGoodsOrderRes res = new AddGoodsOrderRes();
//		res.setResultNote("获取失败");
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户ID不能为空");
//			return res;
//		}
//
//		try {
//			// 判断用户状态
//			Tuser tuser = tuserService.get(req.getUid());
//
//			if (null == tuser) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(tuser.getStatus())) {
//				res.setResultNote("用户已被禁用");
//				return res;
//			}
//			Community c = communityService.get(tuser.getCommunityid());
//			if (null == c) {
//				res.setResultNote("商家不存在");
//				return res;
//			}
//			if (!"0".equals(c.getState())) {
//				res.setResultNote("该商家暂时不能下单");
//				return res;
//			}
//			/*if(StringUtils.isBlank(req.getOrderState())) {
//				res.setResultNote("订单状态为空");
//				return res;
//			}*/
//			if("2".equals(req.getOrderState())) {
//				shopOrderService.execUpdateValueSql("UPDATE t_shop_order SET status='5' WHERE ordernum='"+req.getOrderNum()+"'");
//				//增加余额
//				shopOrderService.execUpdateValueSql("UPDATE t_community_shop a,t_shop_order b,t_shop_orderlist c set a.balance = a.balance + IFNULL(c.shopprice*c.shopcount,0),b.isaccount = 1"
//						+ " where a.id = b.shopid and b.ordernum = c.ordernum and b.ordernum = '"+req.getOrderNum()+"' and b.isaccount = 0");
//
//				// 插入零钱明细
//				ShopOrder shop = shopOrderService.gets(req.getOrderNum());
//				CommunityShop cs = communityShopService.findUniqueByProperty("id", shop.getShopId());
//				UserMoney sd = new UserMoney();
//				sd.setId(IdGen.uuid());
//				sd.setUid(shop.getShopId());
//				sd.setTitle("订单完成");
//				sd.setMoney("+" + shop.getPayPrice());
//				sd.setTransactionId(shop.getOrderNum());
//				sd.setBalance(cs.getBalance());
//				sd.setType("0");
//				sd.setHtype("2");
//				sd.setSign(Base64Utils.byte2Base64(AESUtils.encryptAES(cs.getBalance().getBytes(),
//						AESUtils.loadKeyAES(KeyUtil.AES_KEY), AESUtils.loadIvAES(KeyUtil.AES_KEY))));
//				sd.setAdtime(new Date());
//				usermoneyService.addUserMoney(sd);
//			}else if("6".equals(req.getOrderState())){
//				Map<String,Object> map = shopOrderService.execSelectSqlEntityObjMap("SELECT COUNT(1) AS count FROM t_shop_order WHERE status='1' and ordernum='"+req.getOrderNum()+"'");
//				if(null == map||null==map.get("count")){
//					res.setResultNote("订单不存在或者已付款");
//					return res;
//				}
//				shopOrderService.execUpdateValueSql("UPDATE t_shop_order SET status='6' WHERE status='1' and ordernum='"+req.getOrderNum()+"'");
//			}else {
//				  List<Map<String,String>> Listmap=shopOrderService.execSelectSqlMap("SELECT s.id AS shopId,s.ordernum AS orderNum,s.status AS orderState,s.payprice AS payPrice,DATE_FORMAT(s.paytime,'%Y-%m-%d %h:%i') AS payTime,"
//			        		+ "o.shopname AS serviceName,CONCAT('"+filePath+"',o.shopimage) AS serviceImg,o.shopprice AS servicePrice,DATE_FORMAT(s.athometime,'%Y-%m-%d %h:%i') as atHomeTime,"
//			        				+ "o.shopcount AS serviceCount,o.shopgoodsid AS serviceId,ROUND(o.discountprice*o.shopcount,2) as discountPrice " +
//			        		"FROM t_shop_order s LEFT JOIN t_shop_orderlist o ON s.ordernum=o.ordernum WHERE s.uid='"+tuser.getId()+"' AND s.status !='6' AND s.del_flag='0' ORDER BY s.paytime DESC");
//				  res.setDataList(Listmap);
//			}
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：小区店铺订单" );
//			e.printStackTrace();
//		}
//
//		return res;
//	}
//
//	/**
//	 * 小区店铺支付
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson submitVillageShopPayment(GetVillageShopReq req, HttpServletRequest request) {
//		ResJson res = new ResJson();
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户的id不可空");
//			return res;
//		}
//
//		// 判断用户状态
//		Tuser tuser = tuserService.get(req.getUid());
//		if (null == tuser) {
//			res.setResultNote("用户不存在");
//			return res;
//		} else if (!"0".equals(tuser.getStatus())) {
//			res.setResultNote("用户已被禁用");
//			return res;
//		}
//		Community c = communityService.get(tuser.getCommunityid());
//		if (null == c) {
//			res.setResultNote("商家不存在");
//			return res;
//		}
//		if (!"0".equals(c.getState())) {
//			res.setResultNote("该商家暂时不能下单");
//			return res;
//		}
//
//		BigDecimal price = new BigDecimal(0);
//		BigDecimal discountprice = new BigDecimal(0);
//		BigDecimal count = new BigDecimal(0);
//		BigDecimal payMoney = new BigDecimal(0);
//		String orderNum = req.getOrderNum();
//		String shopid = "";
//		if(StringUtils.isBlank(orderNum)){
//			CommunityShopGoods shopGoods=communityShopService.getShopGoodsByGoodsId(req.getServiceId());
//			if(null == shopGoods) {
//				res.setResultNote("店铺商品没有该商品");
//				return res;
//			}
//			price = new BigDecimal(shopGoods.getPrice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//			if("1".equals(shopGoods.getDiscountflag())){
//				discountprice = new BigDecimal(shopGoods.getDiscountprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//			}
//			count = new BigDecimal(req.getCount()).setScale(2, BigDecimal.ROUND_HALF_UP);
//			payMoney = price.multiply(count).setScale(2, BigDecimal.ROUND_HALF_UP);
//			shopid = shopGoods.getShopid();
//			// 更改订单状态
//			if (payMoney.doubleValue() <= 0) {
//				res.setResultNote("商品价格异常，请联系商家再购买");
//				return res;
//			}
//
//			orderNum = StringUtil.getVillageShopOrder();
//			try {
//				// 获取收货地址
//				Address address = addressService.get(req.getAddressId());
//				if (null == address) {
//					res.setResult("2");//没有添加收货地址
//					res.setResultNote("收货地址不存在");
//					return res;
//				}
//				// 库存足够创建订单
//				ShopOrder o = new ShopOrder();
//				o.setId(IdGen.uuid());
//				o.setUid(req.getUid());
//				o.setCommunityId(tuser.getCommunityid());
//				o.setShopId(shopGoods.getShopid());
//				o.setUserName(tuser.getNickname());
//				o.setUserPhone(tuser.getPhone());
//				o.setShopPhone(shopGoods.getShopphone());
//				o.setUserCity(address.getCity());
//				o.setUserAddress(address.getAddress());
//				o.setPayPrice(payMoney.doubleValue()+"");
//				if("1".equals(shopGoods.getIsathome()))
//					o.setAtHomeTime(DateUtils.parseDate(req.getAtHomeTime()));
//				o.setStatus("1");
//				o.setIsaccount("0");
//				o.setMessage(req.getMessage());
//				o.setOrderNum(orderNum);
//
//				ShopOrderlist userOrderlist = new ShopOrderlist();
//				userOrderlist.setId(IdGen.uuid());
//				userOrderlist.setOrdernum(orderNum);
//				userOrderlist.setGoodsid(shopGoods.getId());
//				userOrderlist.setGoodstitle(shopGoods.getName());
//				userOrderlist.setGoodsnum(req.getCount());
//				userOrderlist.setGoodsimage(shopGoods.getImage());
//				userOrderlist.setGoodsprice(Double.valueOf(shopGoods.getPrice()));
//				userOrderlist.setPurchaseprice(Double.valueOf(StringUtils.isBlank(shopGoods.getPurprice())?shopGoods.getPrice():shopGoods.getPurprice()));
//				if("1".equals(shopGoods.getDiscountflag())){
//					userOrderlist.setDiscountprice(discountprice.toString());
//				}
//				userOrderlist.setOriginalprice(Double.valueOf(shopGoods.getPrice()));
//				// 生成订单
//				shopOrderService.save(o, userOrderlist);
//
//				// 生成订单号
//				OrderType ot = new OrderType();
//				ot.setId(IdGen.uuid());
//				ot.setUid(req.getUid());
//				ot.setType("2");
//				ot.setState("2");//0未支付1已支付2锁定支付
//				ot.setOrdernum(orderNum);
//				orderTypeMapper.insert(ot);
//				req.setOrderNum(orderNum);
//				communityShopService.executeUpdateSql("UPDATE t_community_shop_goods SET sallnum = sallnum + "+req.getCount()+" WHERE id = '"+shopGoods.getId()+"'" );
//				/*res.setObjects(orderNum);*/
//			} catch (Exception e) {
//				logger.error("请求处理异常：小区店铺生成订单12296" );
//				e.printStackTrace();
//				res.setResultNote("生成订失败，请联系管理员！");
//				return res;
//			}
//		}else{
//			//TODO 订单已经支付或者正在支付中判断
////			OrderType ordertype = orderTypeMapper.gets(orderNum);
////			if("2".equals(ordertype.getState())||"1".equals(ordertype.getState())){
////				res.setResultNote("订单已经支付或者正在支付中");
////				return res;
////			}
//			Map<String,Object> o = shopOrderService.execSelectSqlEntityObjMap("SELECT a.ordernum,a.shopid,a.payprice,b.shopgoodsid "
//					+ "from t_shop_order a,t_shop_orderlist b where a.ordernum = b.ordernum and a.ordernum='"+orderNum+"'");
//			payMoney = new BigDecimal(o.get("payprice").toString().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//			shopid = o.get("shopid").toString();
//			CommunityShopGoods shopGoods=communityShopService.getShopGoodsByGoodsId(o.get("shopgoodsid").toString());
//			if(null == shopGoods) {
//				res.setResultNote("该商品已失效！");
//				return res;
//			}
//			price = new BigDecimal(shopGoods.getPrice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//			if("1".equals(shopGoods.getDiscountflag())){
//				discountprice = new BigDecimal(shopGoods.getDiscountprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP);
//			}
//		}
//		try {
//			Map<String, Object> map = new HashMap<>();
//			if("0".equals(req.getPayType())){
//
//				if(!csc.validateBalance(tuser,"0")){
//					res.setResultNote("个人信息有异常，请更换其他支付方式");
//					res.setOrderNum(orderNum);
//					return res;
//				}
//				if(discountprice.compareTo(new BigDecimal(0))>0)//如果有逗邻币专享价
//					payMoney = discountprice;
//				tuser.setBalance(payMoney.doubleValue());
//				int i = tuserService.deductBalance(tuser);
//				if(i==0){
//					res.setResult("3");//余额不足
//					res.setResultNote("余额不足，请选择其他支付方式");
//					res.setOrderNum(orderNum);
//					return res;
//				}
//				tuser = tuserService.get(req.getUid());
//				BigDecimal bd = new BigDecimal(tuser.getBalance());
//				Double getBalance = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//				// 插入零钱明细
//				UserMoney sd = new UserMoney();
//				sd.setId(IdGen.uuid());
//				sd.setUid(req.getUid());
//				sd.setTitle("购买商品");
//				sd.setMoney("-" + payMoney.doubleValue());
//				sd.setBalance(getBalance + "");
//				sd.setTransactionId(orderNum);
//				sd.setHtype("0");
//				sd.setType("0");
//				sd.setAdtime(new Date());
//				try {
//					sd.setSign(Base64Utils.byte2Base64(AESUtils.encryptAES(
//														String.valueOf(tuser.getBalance()).getBytes(),
//														AESUtils.loadKeyAES(KeyUtil.AES_KEY),
//														AESUtils.loadIvAES(KeyUtil.AES_KEY))));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				usermoneyService.addUserMoney(sd);
//				OrderType ot = orderTypeMapper.gets(orderNum);
//				ot.setState("1");
//				orderTypeMapper.update(ot);
//				ShopOrder uo = shopOrderService.gets(orderNum);
//				uo.setStatus("2");
//				uo.setPayTime(new Date());
//				uo.setUpdateTime(new Date());
//				uo.setPayType("0");
//				uo.setPayPrice(payMoney.toString());//逗邻币支付需要更新支付价格
//				shopOrderService.update(uo);
//				try {// 给商家发推送
//					if(!Global.isDevelopMode()){
//						Map<String,Object> map1=shopOrderService.execSelectSqlEntityObjMap("SELECT s.shopphone AS shopPhone,s.username AS userName,s.userphone AS userPhone,o.shopcount AS shopCount, "
//								+ " a.`name` AS shopName,a.phones as phones FROM t_community_shop a,t_shop_order s " +
//								"LEFT JOIN t_shop_orderlist o ON s.ordernum=o.ordernum WHERE a.id = s.shopid AND s.ordernum='"+orderNum+"'");
//						if(StringUtils.isBlank(map1.get("phones").toString()))
//							SMSVerificationCode.getRequest3(map1.get("shopPhone").toString(),map1.get("userName").toString(), map1.get("shopCount").toString(), map1.get("shopName").toString(), map1.get("userPhone").toString(),tuser.getCommunityName());
//						else{
//							String[] phones = map1.get("phones").toString().replaceAll("，", ",").split(",");
//							for(String s:phones){
//								SMSVerificationCode.getRequest3(s,map1.get("userName").toString(), map1.get("shopCount").toString(), map1.get("shopName").toString(), map1.get("userPhone").toString(),tuser.getCommunityName());
//							}
//						}
//					}
//					String title = "来新订单啦！";
////					#name#购买#count#件#goods#,电话:#phone# 地址:#address#,请您及时联系
//					String content = "您有一个新订单：" + orderNum + "！";
//					Msg m = new Msg();
//					m.setType("3");
//					m.setHtype("1");
//					m.setUid(shopid);
//					int unread = msgService.getUnReadNum(m);
//					new PushExample().registerTitle_shop2(title, content, shopid, orderNum,unread+1);
//					m.setId(IdGen.uuid());
//					m.setTitle(title);
//					m.setContent(content);
//					m.setUrl(orderNum);
//					m.setStatus("");
//					m.setAdtime(new Date());
//					msgService.addMsg(m);
//					res.setOrderNum(orderNum);
//					res.setResult("0");
//					res.setResultNote("逗邻币支付成功");
//					return res;
//				} catch (Exception e) {
//					logger.error("请求处理异常：12365" );
//					e.printStackTrace();
//				}
//			}else if ("1".equals(req.getPayType())) {// 支付宝支付
//
//				// 实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型），为了取得预付订单信息
//				AlipayClient alipayClient = new DefaultAlipayClient(AlipayCg.URL, AlipayCg.APPID,
//						AlipayCg.RSA_PRIVATE_KEY, AlipayCg.FORMAT, AlipayCg.CHARSET, AlipayCg.ALIPAY_PUBLIC_KEY,
//						AlipayCg.SIGNTYPE);
//
//				// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
//				AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
//
//				// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式
//				AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
//
//				// 业务参数传入,可以传很多，参考API
//				// model.setPassbackParams(URLEncoder.encode(request.getBody().toString()));
//				// //公用参数（附加数据）
//				model.setBody("订单支付"); // 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
//				model.setSubject("店铺商品"); // 商品名称
//				model.setOutTradeNo(orderNum); // 商户订单号(自动生成)
//				model.setTimeoutExpress("30m"); // 交易超时时间
//				model.setTotalAmount(payMoney+""); // 支付金额
//				model.setProductCode("QUICK_MSECURITY_PAY"); // 销售产品码（固定值）
//				ali_request.setNotifyUrl(AlipayCg.NOTIFYURL);
//				ali_request.setBizModel(model);
//				// 这里和普通的接口调用不同，使用的是sdkExecute
//				AlipayTradeAppPayResponse alipayTradeAppPayResponse = alipayClient.sdkExecute(ali_request); // 返回支付宝订单信息(预处理)
//				String body = alipayTradeAppPayResponse.getBody();// 就是orderString 可以直接给APP请求，无需再做处理。
//				map.put("body", body);
//
//			} else if ("2".equals(req.getPayType())) {// 微信支付
//				// 获取用户ip
//				String ip = request.getHeader("x-forwarded-for");
//				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//					ip = request.getHeader("Proxy-Client-IP");
//				}
//				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//					ip = request.getHeader("WL-Proxy-Client-IP");
//				}
//				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//					ip = request.getRemoteAddr();
//				}
//				if (ip.contains(",")) {
//					ip = ip.split(",")[0];
//				}
//
//				List<Map<String, String>> param = new ArrayList<>();
//				Map<String, String> mapPay = new HashMap<>();
//				if(null!=req.getType()&&"2".equals(req.getType())){//小程序
//					mapPay.put("appid", WXpayCg.MINI_APP_ID);
//					mapPay.put("trade_type", WXpayCg.TRADE_TYPE_JS);// 小程序支付类型
//					mapPay.put("openid", req.getOpenid());
//				}else{//APP
//					mapPay.put("appid", WXpayCg.APP_ID);
//					mapPay.put("trade_type", WXpayCg.TRADE_TYPE_APP);// APP支付类型
//				}
//
//				// 商品简单描述，该字段请按照规范传递
//				mapPay.put("body", "逗邻");
//				mapPay.put("mch_id", WXpayCg.MCH_ID);// 商户id号
//				// 随机字符串==随机字符串，不长于32位
//				mapPay.put("nonce_str", RandomStringUtils.randomAlphabetic(32));
//				mapPay.put("notify_url", WXpayCg.NOTIFYURL);
//				// 交易金额默认为人民币交易，接口中参数支付金额单位为【分】，参数值不能带小数，上面的1000.00指的是元
//				payMoney = payMoney.multiply(new BigDecimal(100));
//				mapPay.put("total_fee", payMoney.stripTrailingZeros().toPlainString());
//				// 商户订单号==商户系统内部的订单号,32个字符内、可包含字母
//				mapPay.put("out_trade_no", orderNum);
//
//
//				// APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。不是必填项
//				mapPay.put("spbill_create_ip", ip);
//				mapPay = MD5.sortMapByKey(mapPay);// 排序
//				param.add(mapPay);
//				StringBuilder sb = new StringBuilder();
//				// 主动创建document对象.
//				Document document = DocumentHelper.createDocument();
//				Element root = document.addElement("xml");
//				for (int i = 0; i < param.size(); i++) {
//					Map<String, String> pair = param.get(i);
//					for (Entry<String, String> vo : pair.entrySet()) {
//						sb.append(vo.getKey()).append("=").append(vo.getValue()).append("&");
//						root.addElement(vo.getKey()).addText(vo.getValue());
//					}
//
//				}
//				sb.append("key=").append(WXpayCg.KEY);
//				// map.put("sign", DigestUtils.md5Hex(sb.toString()).toUpperCase());
//				root.addElement("sign").addText(DigestUtils.md5Hex(sb.toString()).toUpperCase());
//				// String aa = root.asXML();
//				String tenR = HttpPostXML.post(WXpayCg.TENPAYURL, root.asXML());
//				StringBuilder sbclient = new StringBuilder();
//				Map<String, String> map1 = new HashMap<>();
//				try {
//					Document doc = DocumentHelper.parseText(tenR);
//					Element root$ten = doc.getRootElement();
//					Element returnCode = root$ten.element("return_code");
//					Element resultCode = root$ten.element("result_code");
//					if (returnCode.getText().equals("FAIL")) {
//						// log.error(root$ten.element("return_msg").getText());
//					} else if (returnCode.getText().equals("SUCCESS")&&resultCode.getText().equals("SUCCESS")) {
//						try {
//							// map.put("appid", root$ten.element("appid").getText());
//							// 微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
//							map1.put("timestamp", System.currentTimeMillis() / 1000 + "");
//							map1.put("nonce_str", RandomStringUtils.randomAlphabetic(32));
//							if (null != req.getType() && ("1".equals(req.getType())||"2".equals(req.getType()))) {//小程序，公众号
//								sbclient.append("appId=").append(root$ten.element("appid").getText());
//								sbclient.append("&nonceStr=").append(map1.get("nonce_str"));
//								sbclient.append("&package=")
//										.append("prepay_id=" + root$ten.element("prepay_id").getText());
//								sbclient.append("&signType=").append("MD5");
//								sbclient.append("&timeStamp=").append(map1.get("timestamp"));
//								sbclient.append("&key=").append(WXpayCg.KEY);
//								if ("2".equals(req.getType())) {//小程序支付
//									map1.put("appId", WXpayCg.MINI_APP_ID);
//								}else{//公众号支付
//									map1.put("appId", WXpayCg.MP_APP_ID);
//								}
//								map1.put("nonceStr", map1.get("nonce_str"));
//								map1.put("package", "prepay_id=" + root$ten.element("prepay_id").getText());
//								map1.put("signType", "MD5");
//								map1.put("timeStamp", map1.get("timestamp"));
//								map1.put("paySign", DigestUtils.md5Hex(sbclient.toString()).toUpperCase());
//							} else {//APP
//								sbclient.append("appid=").append(root$ten.element("appid").getText());
//								sbclient.append("&noncestr=").append(map1.get("nonce_str"));
//								sbclient.append("&package=").append("Sign=WXPay");
//								sbclient.append("&partnerid=").append(root$ten.element("mch_id").getText());
//								sbclient.append("&prepayid=").append(root$ten.element("prepay_id").getText());
//								sbclient.append("&timestamp=").append(map1.get("timestamp"));
//								sbclient.append("&key=").append(WXpayCg.KEY);
//								map1.put("appid", WXpayCg.APP_ID);
//								map1.put("mch_id", WXpayCg.MCH_ID);
//								map1.put("prepay_id", root$ten.element("prepay_id").getText());
//								map1.put("sign", DigestUtils.md5Hex(sbclient.toString()).toUpperCase());
//							}
//							map.put("mapwx", map1);
//						} catch (Exception e) {
//							logger.error("请求处理异常：小区店铺支付" );
//							e.printStackTrace();
//							logger.error("获取微信支付参数失败，失败原因：" + e.getMessage());
//							return res;
//						}
//					}else{
//						Element errdes = root$ten.element("err_code_des");
//						logger.error("支付失败++++++++++++++++++"+errdes);
//						res.setResult("1");
//						res.setResultNote("发起支付失败:"+errdes+"，请联系技术人员！");
//						return res;
//					}
//				} catch (DocumentException e) {
//					logger.error("请求处理异常：小区店铺支付" );
//					e.printStackTrace();
//					logger.error("获取微信支付参数失败，失败原因：" + e.getMessage());
//					return res;
//				}
//			}
//			res.setOrderNum(orderNum);
//			res.setObject(map);
//			res.setResult("0");
//			res.setResultNote("立即支付");
//		} catch (Exception e) {
//			logger.error("请求处理异常：小区店铺支付" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 支付失败解锁订单
//	 * @param req
//	 * @return
//	 */
//	public ResJson codeUnLockOrder(GetVillageShopReq req, HttpServletRequest request) {
//		GetDictTypeRes res = new GetDictTypeRes();
//		if (StringUtils.isBlank(req.getOrderNum())) {
//			res.setResultNote("订单编号不能为空");
//		}
//		try {
//			OrderType ot = orderTypeMapper.gets(req.getOrderNum());
//			if("2".equals(ot.getState())){
//				orderTypeMapper.execUpdateSql("UPDATE t_order_type set state='0' WHERE ordernum='"+req.getOrderNum()+"'");
//			}
//			res.setResult("0");
//			res.setResultNote("取消支付成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：13741" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 验签 1.03版本
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecAttestation(GetDictTypeReq req) {
//		GetDictTypeRes res = new GetDictTypeRes();
//		if (StringUtils.isBlank(req.getType())) {
//			res.setResultNote("验签类型不能为空");
//		}
//		try {
//			List<Map<String, String>> list = new ArrayList<>();
//			Map<String, String> map = new HashMap<String, String>();
//
//			/* String value = DictUtils.getDictValue("验签码", req.getType(), null); */
//			String value = csc.selectDictTypeValue(req.getType());
//			map.put("value", value);
//			map.put("label", "验签码");
//			list.add(map);
//			res.setDataList(list);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//
//		} catch (Exception e) {
//			logger.error("请求处理异常：11821" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.9 小区店铺
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec20(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
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
//			// 获取轮播
//			BannerServices bs = new BannerServices();
//			bs.setType(5);
//			List<BannerServices> list0 = bannerServiceService.findList(bs);
//			List<Map<String, String>> bannerList = new ArrayList<Map<String, String>>();
//			if (list0 != null && list0.size() > 0) {
//				for (BannerServices bss : list0) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("topImgUrl", filePath + bss.getImage());
//					map.put("topImgDetailUrl", filePath + bss.getUrl());
//					map.put("topImgDetailUrlState", bss.getStatus());
//					bannerList.add(map);
//				}
//			}
//			res.setBannerList(bannerList);
//			CommunityShop cs = new CommunityShop();
//			cs.setCommunityId(req.getCommunityId());
//			if (!StringUtils.isBlank(req.getContent())) {
//				cs.setName(req.getContent());
//			}
//			List<CommunityShop> list = communityShopService.findList(cs);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (list != null && list.size() > 0) {
//				for (CommunityShop gcc : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("shopId", gcc.getId());
//					map.put("shopName", gcc.getName());
//					map.put("status", gcc.getShopType());
//					map.put("shopImg", filePath + gcc.getImage());
//					map.put("shopDesc", gcc.getShopdesc());
//					map.put("shopPrice", gcc.getPrice());
//					map.put("discountflag", gcc.getDiscountflag());
//					dataList.add(map);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：11905" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.9 服务首页banner
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecB(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取服务首页失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
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
//
//			// 获取轮播
//			BannerServices bs = new BannerServices();
//			if(null==req.getType()||!StringUtils.isNumeric(req.getType())){
//				res.setResultNote("非法获取数据TYPE");
//				return res;
//			}
//			bs.setType(Integer.valueOf(req.getType()));
//			// TODO 按社区获取服务banner
//			bs.setCommunityid1(req.getCommunityId());
//			List<BannerServices> list0 = bannerServiceService.findListForCommunity(bs);
//			List<Map<String, String>> bannerList = new ArrayList<Map<String, String>>();
//			if (list0 != null && list0.size() > 0) {
//				for (BannerServices bss : list0) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("imgUrl", filePath + bss.getImage());
//					if("3".equals(bss.getUsed())){
//						map.put("detailUrl", filePath + bss.getUrl()+"&communityId="+req.getCommunityId()+"&uid="+req.getUid());
//					}else if("0".equals(bss.getUsed()))
//						map.put("detailUrl", filePath + bss.getUrl());
//					else
//						map.put("detailUrl", bss.getUrl());
//					map.put("detailUrlState", bss.getStatus());
//					map.put("jumpType", bss.getUsed());
//					bannerList.add(map);
//				}
//			}
//			res.setBannerList(bannerList);
//			res.setProportion(list0.get(0).getRemarks());
//			res.setResult("0");
//			res.setResultNote("获取店铺banner成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：13910" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.9 小区店铺黄页
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecCC(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
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
//			// 获取轮播
//			CommunityContact cc = new CommunityContact();
//			cc.setCommunityId(req.getCommunityId());
//			List<CommunityContact> list0 = communityContactService.findList(cc);
//			List<Map<String, String>> contactList = new ArrayList<Map<String, String>>();
//			if (list0 != null && list0.size() > 0) {
//				for (CommunityContact ccs : list0) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("contactName", ccs.getName());
//					map.put("contactPhone",ccs.getPhone());
//					contactList.add(map);
//				}
//			}
//			res.setDataList(contactList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：13903" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.91 小区店铺服务页图标
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecCSSI(GetServicePageIcon req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		if(StringUtils.isBlank(req.getCommunityId())) {
//			res.setResultNote("社区id为空");
//			return res;
//		}
//		try {
//			Category c = new Category();
//			c.setId("0");
//			c.setHtype("3");
//			c.setStatus("0");
//			List<Category> list = categoryService.findList(c);
//
//            List<Map<String,Object>> dataList = new ArrayList<>();
//            if(null != list && list.size()>0) {
//            	for (Category icon2 : list) {
//					Map<String,Object> map = new HashMap<>();
//					map.put("iconName", icon2.getName());
//					map.put("iconImage",filePath +icon2.getImage());
//					map.put("iconId", icon2.getId());
//					dataList.add(map);
//				}
//            }
//            res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常13341：小区店铺服务页图标" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.92 小区店铺服务页图标中的商品
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecCSSG(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getIconId())) {
//				res.setResultNote("分类ID不能为空");
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
//
//			CommunityShopGoods c = new CommunityShopGoods();
//			c.setCommunityId(user.getCommunityid());
//			c.setCategoryid(req.getIconId());
//
//			List<CommunityShopGoods> csl = communityShopService.findCategoryGoodsList(c);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//
//			if (csl != null && csl.size() > 0) {
//				for (CommunityShopGoods csg : csl) {
//					Map<String, String> map1 = new HashMap<String, String>();
//					map1.put("serviceId", csg.getId());
//					map1.put("serviceName", csg.getName());
//					map1.put("serviceImg", filePath + csg.getImage());
//					map1.put("serviceDesc", csg.getGoodsdesc());
//					map1.put("servicePrice", csg.getPrice());
//					map1.put("serviceSpec", null==csg.getSpec()?"":csg.getSpec());
//					map1.put("isAtHome", csg.getIsathome());
//					map1.put("status", csg.getStatus());
//					map1.put("shopId", csg.getShopid());
//					map1.put("shopName", csg.getShopname());
//					if("1".equals(csg.getDiscountflag()))
//						map1.put("discountPrice", new BigDecimal(csg.getDiscountprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
//					dataList.add(map1);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：11974" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.10 小区店铺详情
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec21(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getShopId())) {
//				res.setResultNote("店铺ID不能为空");
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
//			CommunityShop cs = communityShopService.get(req.getShopId());
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("shopName", cs.getName());
//			map.put("shopDesc", cs.getShopdesc());
//			map.put("shopPrice", cs.getPrice());
//			map.put("shopAddress", cs.getAddress());
//			map.put("status", cs.getShopType());
//			map.put("shopPhone", StringUtils.isBlank(cs.getServicephone())?cs.getPhone():cs.getServicephone());
//			map.put("shopTime", cs.getShoptime());
//			List<String> img = new ArrayList<String>();
//			if (!StringUtils.isBlank(cs.getImage1())) {
//				img.add(filePath + cs.getImage1());
//			}
//			if (!StringUtils.isBlank(cs.getImage2())) {
//				img.add(filePath + cs.getImage2());
//			}
//			if (!StringUtils.isBlank(cs.getImage3())) {
//				img.add(filePath + cs.getImage3());
//			}
//			map.put("shopImgUrl", img);
//			res.setObject(map);
//			if (cs.getCommunityShopGoodsList() != null && cs.getCommunityShopGoodsList().size() > 0) {
//				List<CommunityShopGoods> list = cs.getCommunityShopGoodsList();
//				for (CommunityShopGoods csg : list) {
//					Map<String, String> map1 = new HashMap<String, String>();
//					map1.put("serviceId", csg.getId());
//					map1.put("serviceName", csg.getName());
//					map1.put("serviceImg", filePath + csg.getImage());
//					map1.put("serviceDesc", csg.getGoodsdesc());
//					map1.put("servicePrice", csg.getPrice());
//					map1.put("serviceSpec", null==csg.getSpec()?"":csg.getSpec());
//					map1.put("isAtHome", csg.getIsathome());
//					if("1".equals(csg.getDiscountflag()))
//						map1.put("discountPrice", new BigDecimal(csg.getDiscountprice().replaceAll(",", "")).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
//					dataList.add(map1);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：11974" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.100小区店铺商品介绍详情
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codeGSGD(GetCommunityReq req) {
//		ResJson res = new ResJson();
//		res.setResultNote("获取失败");
//		if (StringUtils.isBlank(req.getGoodsid())) {
//			res.setResultNote("商品ID不可为空");
//			return res;
//		}
//		CommunityShopGoods goods = communityShopService.getShopGoodsByGoodsId(req.getGoodsid());
//		Map<String, Object> map = new HashMap<>();
//		if (null != goods) {
//			map.put("serviceId", goods.getId());
//			map.put("serviceName", goods.getName());
//			map.put("shopId", goods.getShopid());
//			map.put("shopName", goods.getShopname());
//			map.put("serviceImg", filePath + goods.getImage());
//			map.put("servicePrice", goods.getPrice());
//			map.put("serviceSpec", null==goods.getSpec()?"":goods.getSpec());
//			map.put("serviceSallnum", goods.getSallnum() + "");
//			map.put("serviceDesc", goods.getGoodsdesc());
//			map.put("servicePhone", goods.getServicephone());
//			map.put("isAtHome", goods.getIsathome());
//			map.put("status", goods.getStatus());
//			if("1".equals(goods.getDiscountflag()))
//				map.put("discountPrice", goods.getDiscountprice());
//			res.setObjects(map);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} else {
//			res.setResult("1");
//			res.setResultNote("该商品已下架，请选择其他服务！");
//		}
//		return res;
//	}
//
//	/**
//	 * 3.101小区店铺推荐商品
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codecRSG(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
//				return res;
//			}
//
//			CommunityShopGoods m = new CommunityShopGoods();
//			m.setCommunityId(req.getCommunityId());
//			m.setType(req.getType());
////			m.setUid(req.getUid());
//			Page<CommunityShopGoods> page = new Page<CommunityShopGoods>(req.getNowPage(), req.getPageCount());
//			Page<CommunityShopGoods> listPage = communityShopService.sellShopGoodsPage(page,m);
//			List<CommunityShopGoods> list = listPage.getList();
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (null != list && list.size() > 0) {
//				// 查询该商品是否已存在购物车内
////				List<UserCart> cartList = userCartService.findList1(req.getUid());
//				for (CommunityShopGoods gcc : list) {
//					Map<String, Object> map = new HashMap<String, Object>();
//					map.put("serviceId", gcc.getId());
//					map.put("serviceName", gcc.getName());
//					map.put("shopId", gcc.getShopid());
//					map.put("shopName", gcc.getShopname());
//					map.put("serviceImg", filePath + gcc.getImage().replace("/images/", "/_thumbs/images/"));
//					map.put("servicePrice", gcc.getPrice());
//					map.put("serviceDesc", gcc.getGoodsdesc());
//					map.put("serviceSpec", null==gcc.getSpec()?"":gcc.getSpec());
//					map.put("serviceSallnum", gcc.getSallnum() + "");
//					map.put("status", gcc.getStatus());
//					map.put("isAtHome", gcc.getIsathome());
//					if("1".equals(gcc.getDiscountflag())){
//						map.put("discountPrice",gcc.getDiscountprice());
//					}
//					map.put("discountPrice",gcc.getDiscountprice());
//					dataList.add(map);
//				}
//			}
//			res.setTotalPage(listPage.getTotalPage());
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取推荐商品成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：13868" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.11 优选商品
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec19(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
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
//			GoodsCommunity gc = new GoodsCommunity();
//			gc.setCommunityid(req.getCommunityId());
//			gc.setOptimizationid(req.getOptimizationId());
//			gc.setDataScope(" and g.state=0 and a.shelves='0'");
//			gc.setUid(req.getUid());
//			List<GoodsCommunity> list = goodsCommunityService.findList(gc);
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			if (list != null && list.size() > 0) {
//
//				// 查询该商品是否已存在购物车内
////				List<UserCart> cartList = userCartService.findList1(req.getUid());
//
//				for (GoodsCommunity gcc : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("goodsId", gcc.getGoodsid());
//					map.put("goodsName", gcc.getGoodsname());
//					map.put("goodsImg", filePath + gcc.getGoodsimg().replace("/images/", "/_thumbs/images/"));
//					map.put("goodsPrice", gcc.getGoodsprice());
//					map.put("goodsCuprice", gcc.getGoodscuprice());
//					map.put("goodsDesc", gcc.getGoodsdesc());
//					map.put("goodsSpecification", gcc.getSpecification());
//					map.put("goodsSallnum", gcc.getSallnum() + "");
//					map.put("optimizationId", req.getOptimizationId());
//					map.put("activityType", gcc.getActivityType());
//					map.put("goodsStock", "1".equals(gcc.getType()) ? "0" : gcc.getStock() + "");
//					if ("0".equals(gcc.getType())) {
//						map.put("goodsType", "2");
//					} else if ("2".equals(gcc.getType())) {
//						map.put("goodsType", "0");
//					} else {
//						map.put("goodsType", "1");
//					}
//                    map.put("categoryId", gcc.getCategoryid());
//                    map.put("count", gcc.getCount());// 老版本
//					map.put("goodsNum", gcc.getCount());// 新版本
////					if (null != cartList && !cartList.isEmpty()) {// 存在就进行数量相加
////						for (UserCart userCart : cartList) {
////
////							if (userCart.getGoodsid().equals(gcc.getGoodsid())) {
////								map.put("count", userCart.getCount() + "");// 老版本
////								map.put("goodsNum", userCart.getCount() + "");// 新版本
////								break;
////							}
////
////						}
////					}
//
//					dataList.add(map);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：12058" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.11 优选商品
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec19New(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
//		try {
//			if (StringUtils.isBlank(req.getUid())) {
//				res.setResultNote("用户ID不能为空");
//				return res;
//			}
//			if (StringUtils.isBlank(req.getCommunityId())) {
//				res.setResultNote("社区ID不能为空");
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
//			GoodsCommunity gc = new GoodsCommunity();
//			gc.setCommunityid(req.getCommunityId());
//			gc.setOptimizationid(req.getOptimizationId());
//			gc.setDataScope(" and g.state=0 and a.shelves='0'");
//			gc.setUid(req.getUid());
//			List<GoodsCommunity> list = goodsCommunityService.findListNew(gc);
//			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//			if (list != null && list.size() > 0) {
//				for (GoodsCommunity gcc : list) {
//					Map<String, Object> map = new HashMap<String, Object>();
//					map.put("goodsId", gcc.getGoodsid());
//					map.put("goodsName", gcc.getGoodsname());
//					map.put("goodsImg", filePath + gcc.getGoodsimg().replace("/images/", "/_thumbs/images/"));
//					map.put("goodsPrice", gcc.getGoodsprice());
//					map.put("goodsCuprice", gcc.getGoodscuprice());
//					map.put("goodsDesc", gcc.getGoodsdesc());
//					map.put("goodsSpecification", gcc.getSpecification());
//					map.put("goodsSallnum", gcc.getSallnum() + "");
//					map.put("optimizationId", req.getOptimizationId());
//					map.put("activityType", gcc.getActivityType());
//					map.put("goodsStock", "1".equals(gcc.getType()) ? "0" : gcc.getStock() + "");
//					if ("0".equals(gcc.getType())) {
//						map.put("goodsType", "2");
//					} else if ("2".equals(gcc.getType())) {
//						map.put("goodsType", "0");
//					} else {
//						map.put("goodsType", "1");
//					}
//					map.put("categoryId", gcc.getCategoryid());
//					map.put("count", gcc.getCount());// 老版本
//					map.put("goodsNum", gcc.getCount());// 新版本
//					if(Integer.valueOf(gcc.getIds())>1){
//						gc.setUnifierid(gcc.getGoodsid());
//						gc.setFilePath(filePath);
//						List<Map<String,String>> goods = goodsCommunityService.findGoodsListByUnifier(gc);
//						map.put("subGoods", goods);
//					}
//					dataList.add(map);
//				}
//			}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：12058" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.12 任务
//	 *
//	 * @param request
//	 * @param req
//	 * @return
//	 */
//	public ResJson codec22(GetCommunityReq req) {
//		FindListeRes res = new FindListeRes();
//		res.setResultNote("获取失败");
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
//			// 查询影响力
//			res.setAllEffectNum(user.getEffectnum() + "");
//			List<Object> listt = taskService
//					.executeSelectSql("select ifnull(sum(score),0) from t_score_detail where uid='" + req.getUid()
//							+ "' and adtime>CURDATE()");
//			res.setDayEffectNum(listt.get(0).toString());
//			Task gc = new Task();
//			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//			List<Task> list = taskService.findList(gc);
//			if (list != null && list.size() > 0) {
//				for (Task t : list) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("taskId", t.getId());
//					map.put("taskTitle", t.getTitle());
//					map.put("effectNum", t.getEffectnum() + "");
//					if ("1".equals(t.getId())) {// 每日签到
//						Sign s = new Sign();
//						s.setUid(req.getUid());
//						s = signService.isSign(s);
//						map.put("isFinishTask", s.getUid());
//					} else if ("3".equals(t.getId())) {// 发布活动
//						List<Object> list1 = taskService.executeSelectSql("select count(1) from t_activity where uid='"
//								+ req.getUid() + "' and adtime>CURDATE()");
//						map.put("isFinishTask", list1.get(0).toString());
//					} else if ("4".equals(t.getId())) {// 发布动态
//						List<Object> list1 = taskService.executeSelectSql(
//								"select count(1) from t_dynamic where uid='" + req.getUid() + "' and adtime>CURDATE()");
//						map.put("isFinishTask", list1.get(0).toString());
//					} else if ("5".equals(t.getId())) {// 完善资料
//						if ("1".equals(user.getIsperfect())) {
//							map.put("isFinishTask", "1");
//							res.setPerfect("100");
//						} else {
//							map.put("isFinishTask", "0");
//							res.setPerfect(csc.getperfect(req.getUid()) + "");
//						}
//					} else if ("6".equals(t.getId())) {// 认证用户
//						if ("2".equals(user.getAuthentication())) {
//							map.put("isFinishTask", "1");
//						} else {
//							map.put("isFinishTask", "0");
//						}
//					}
//					dataList.add(map);
//				}
//			}
////			List<Object> list2 = taskService
////					.executeSelectSql("select count(1) from t_user where binvitenum='" + user.getInvitenum() + "'");
//			// Map<String, String> map = new HashMap<String, String>();
//			// map.put("taskId", "2");
//			// map.put("taskTitle", "邀请好友");
//			// map.put("effectNum", "100");
//			// map.put("isFinishTask", list2.get(0).toString());
//			// dataList.add(map);
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：12145" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 3.13 查看商家是否设置休息时间
//	 */
//	public ResJson codecRest1(GetMerchantRestReq req) {
//		RestRes res = new RestRes();
//		res.setResultNote("获取失败");
//		if (StringUtils.isBlank(req.getCommunityid())) {
//			res.setResultNote("社区id为空");
//			return res;
//		}
//		try {
//			String endTimeList = communityService.execSelectSqlString("SELECT m.endTime FROM t_merchant_rest m WHERE"
//					+ " m.communityid = '" + req.getCommunityid() + "' AND m.state='0' AND m.startTime <='"+DateUtils.getDateTime()+"'");
//			if ( endTimeList == null || "".equals(endTimeList)) {
//				res.setState("2");
//			} else {
//				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				Date endTime = formatter.parse(endTimeList.toString());
//				Date currentDate = new Date();
//				if (endTime.getTime() < currentDate.getTime()) {
//					res.setState("1");
//				} else {
//					String end = endTimeList.toString();
//					res.setState("0");
//					res.setResult("0");
//					res.setResultNote("商家休息," + end.substring(0, end.length() - 2) + "后营业");
//					return res;
//				}
//			}
//			String note = csc.shopRest();
//			if(StringUtils.isNotBlank(note)){
//				res.setResultNote(note);
//				res.setState("0");
//				res.setResult("0");
//				return res;
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：12183" );
//			e.printStackTrace();
//		}
//		res.setResult("0");
//		res.setResultNote("获取成功");
//		return res;
//	}
//
//	/**
//	 * 3.14查询当前位置与社区的距离
//	 */
//	public ResJson codecDistance(GetDistance req) {
//		RestRes res = new RestRes();
//		res.setResultNote("获取失败");
//		boolean disflag = true;
//		if (StringUtils.isBlank(req.getLnglat())) {
//			disflag = false;
//		}
//		try {
//			Community community = new Community();
//			community.setPoint(req.getLnglat());
//			community.setName1(req.getCommunityName());
//			List<Map<String,Object>> list = communityService.findListByPoint(community);
//			for(int i=0;i<list.size();i++){
//				Map<String,Object> map = list.get(i);
//				if(!Global.isDevelopMode()){
//					if("f40a174cf6f1439386e50a3a195f4fc9".equals(map.get("id").toString())){
//						list.remove(map);
//						i--;
//						continue;
//					}
//				}
//				if(disflag)
//					map.put("distance", Double.parseDouble(map.get("distance").toString())>1000
//											?String.format("%.2f", Math.round(Double.parseDouble(map.get("distance").toString())/10)*0.01d)+"公里"
//											:map.get("distance").toString()+"米");
//				else
//					map.put("distance", "");
//			}
//			res.setDataList(list);
//		} catch (Exception e) {
//			logger.error("请求处理异常：12183" );
//			e.printStackTrace();
//		}
//		res.setResult("0");
//		res.setResultNote("获取成功");
//		return res;
//	}
//
//	/**
//	 * 信息登陆
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson getWeiXinLogin(HttpServletRequest request, UserRegisterReq req) {
//		UserLoginRes res = new UserLoginRes();
//		try {
//			// 判断微信openI和手机号是否已注册绑定过手机号
//			List<Object> tu = tuserService
//					.executeSelectSql("SELECT id FROM t_user WHERE openId = '" + req.getOpenId() + "'");
//
//			if (null != tu && tu.size() > 0) {
//				Tuser tuser = tuserService.get(tu.get(0).toString());
//				if (null != tuser.getPhone() && !"".equals(tuser.getPhone())) {
//					if (!"0".equals(tuser.getStatus())) {
//						res.setResultNote("该用户已被禁用");
//						return res;
//					} else {
//						res.setUid(tuser.getId());
//						res.setCommunityId(tuser.getCommunityid());
//						res.setCommunityName(tuser.getCommunityName());
//						res.setNickName(tuser.getNickname());
//						res.setAvatra(tuser.getIcon());
//						res.setRytoken(tuser.getRytoken());
//						res.setPhone(tuser.getPhone());
//						res.setIswanshan(StringUtils.isBlank(tuser.getCommunityid()) ? "0" : "1");
//						res.setToken(JwtToken.createToken(request, tuser));
//					}
//
//					// 登录成功后修改token
//					if (StringUtils.isNotBlank(req.getToken())) {
//						tuserService.updateToken(tuser.getId(), req.getToken());
//					}
//					res.setState("0");
//					res.setResult("0");
//					res.setResultNote("登陆成功");
//					return res;
//				}
//			}
//		} catch (Exception e) {
//			logger.error("请求处理异常：15859" );
//			e.printStackTrace();
//		}
//		res.setResult("0");
//		res.setResultNote("请绑定手机号");
//		res.setState("1");
//		return res;
//	}
//
//	/**
//	 * 微信登陆完善信息
//	 */
//	public ResJson getWeiXinLoginMessage(HttpServletRequest request, UserRegisterReq req) {
//		UserLoginRes res = new UserLoginRes();
//		try {
//			Tuser u = new Tuser();
//			if (null != req.getType() && "1".equals(req.getType())) {// 微信公众号
//				u.setId(req.getUid());
//				u = tuserService.get(u);
//			} else {
//				if (StringUtils.isBlank(req.getPhone())) {
//					res.setResultNote("手机号为空");
//					return res;
//				}
//				if (StringUtils.isBlank(req.getOpenId())) {
//					res.setResultNote("微信id不能为空");
//					return res;
//				}
//				u.setPhone(req.getPhone());
//				u = tuserService.selectOpenId(u);
//			}
//
//			if (null == u) {
//				// 创建用户
//				u = new Tuser();
//				String id = IdGen.uuid();
//				u.setId(id);// id
//				u.setPhone(req.getPhone());// 手机号
//				u.setNickname(req.getNickname());// 昵称
//				u.setSex(req.getSex());
//				u.setIcon(req.getIcon());
//				String random = String.valueOf(Math.random());
//				String code = random.substring(random.length() - 8);
//				u.setBalance(0d);
//				u.setToken(req.getToken());
//				u.setInvitenum(code);
//				u.setBirthday(req.getBirthday());
//				u.setEffectnum(0);
//				u.setDynamicnum(0);
//				u.setAttennum(0);
//				u.setFansnum(0);
//				u.setReportnum(0);
//				u.setIntegralnum(0);
//				u.setHometown(req.getHometown());
//				u.setAuthentication("0");
//				u.setIsapply("0");
//				u.setIsperfect("0");
//				u.setBinvitenum(req.getUserInviteCode());// 邀请人
//				u.setStatus("0");// 状态 0正常 1禁用
//				u.setAdtime(new Date());
//				u.setCommunityid(req.getCommunityId());
//				u.setOpenId(req.getOpenId());
//				int result = tuserService.addUser(u);
//				//TODO 取消默认地址生成
////				//默认地址
////				Address address = new Address();
////				address.setId(IdGen.uuid());
////				address.setUid(u.getId());
////				address.setUsername(u.getNickname());
////				address.setUserphone(u.getPhone());
////				address.setCity("郑州市");
////				String communityName = StringUtils.isBlank(u.getCommunityName()) ? "" : u.getCommunityName();
////				String doornumber = StringUtils.isBlank(u.getDoornumber()) ? "" : u.getDoornumber();
////				String unitName = StringUtils.isBlank(u.getUnitName()) ? "" : u.getUnitName();
////				address.setCommunityName(communityName);
////				address.setAddress(unitName + doornumber);
////				address.setIsdefault("0");
////				address.setAdtime(new Date());
////				addressService.addAddress(address);
//				if (result > 0) {
//					// 赠送积分
//					if (StringUtils.isNotBlank(req.getUserInviteCode())) {
//						try {
//							Tuser uu = tuserService.findUniqueByProperty("invitenum", req.getUserInviteCode());
//							tuserService.updateScore(uu.getId(), 20, 0,"邀请好友");
//						} catch (Exception e) {
//							logger.error("请求处理异常：15944" );
//							e.printStackTrace();
//						}
//
//					}
//				}
//				//添加用户指定的天数
//				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//				// 查看是否有特定优惠劵
//				List<Coupon> coupon = couponService.selectSpecificCoupon(req.getCommunityId(), "1");
//				List<Map<String, String>> dataList = new ArrayList<>();
//				if (null != coupon && coupon.size() > 0) {
//					for (Coupon coupon2 : coupon) {
//						UserCoupon uc = new UserCoupon();
//						String startDays = DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getStartCouponDay()));
//						String endDays= DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getEndCouponDay())?
//								0:StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getEndCouponDay())+Integer.valueOf(coupon2.getStartCouponDay()));
//						uc.setUid(u.getId());
//						uc.setCouponid(coupon2.getId());
//						List<UserCoupon> list = userCouponService.findList(uc);
//						if (list != null && list.size() > 0) {
//							res.setResultNote("不能重复领取");
//							return res;
//						}
//						uc.setCommunityid(coupon2.getCommunityid());
//						uc.setCommunityname(coupon2.getCommunityname());
//						uc.setAllmoney(coupon2.getAllmoney());
//						uc.setAmount(coupon2.getAmount());
//						uc.setType(coupon2.getType());
//						uc.setStartdate(sf.parse(startDays));
//						uc.setEnddate(sf.parse(endDays));
//						uc.setStatus("0");
//						uc.setAdtime(new Date());
//						userCouponService.save(uc);// 插入到我的优惠劵表
//
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("securitiesid", coupon2.getId());
//						map.put("communityId", coupon2.getCommunityid());
//						map.put("communityName", coupon2.getCommunityname());
//						map.put("securitiesMoney", coupon2.getAllmoney() + "");
//						map.put("securitiesType", coupon2.getType());
//						map.put("securitiesName", coupon2.getName());
//						map.put("securitiesImg", filePath + coupon2.getImage());
//						map.put("securitiesPrice", coupon2.getAmount() + "");
//						map.put("securitiesStartTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(startDays)));
//						map.put("securitiesEndTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(endDays)));
//						dataList.add(map);
//
//					}
//					res.setDataList(dataList);
//				}
//
////				// 网易云信添加新用户
////				String token = Wangyiyunxin.getToken(id);
////				// System.out.println("getToken: " + token);
////				u.setRytoken(token);
////				tuserService.updateUser(u);
////				res.setRytoken(token);
////
////				// 网易云信添加客服为好友
////				Wangyiyunxin.addfriend(id, "admin");
////				Wangyiyunxin.updateuser(id, u.getNickname(), u.getIcon());
//			} else {
//				if (null != req.getType() && "1".equals(req.getType())) {// 微信公众号
//
//					// 创建用户
//					if (null == u.getNickname() || "".equals(u.getNickname()))
//						u.setNickname(req.getNickname());// 昵称
//					if (null == u.getSex() || "".equals(u.getSex()))
//						u.setSex(req.getSex());
//					if (null == u.getIcon() || "".equals(u.getIcon()))
//						u.setIcon(req.getIcon());
//					String random = String.valueOf(Math.random());
//					String code = random.substring(random.length() - 8);
//					if (null == u.getInvitenum() || "".equals(u.getInvitenum()))
//						u.setInvitenum(code);
//					u.setStatus("0");// 状态 0正常 1禁用
//					if (null == u.getCommunityid() || "".equals(u.getCommunityid()))
//						u.setCommunityid(req.getCommunityId());
//					if (null == u.getUnitid() || "".equals(u.getUnitid()))
//						u.setUnitid(req.getUnitNumber());
//					if (null == u.getDoornumber() || "".equals(u.getDoornumber()))
//						u.setDoornumber(req.getHouseNumber());
//					if (null == u.getOpenId() || "".equals(u.getOpenId()))
//						u.setOpenId(req.getOpenId());
//					u.setAdtime(new Date());
//					//TODO 取消默认地址生成
////					Address address = new Address();
////					List<Object> comName = communityService.executeSelectSql(
////							"SELECT name1 FROM t_community WHERE id = '" + req.getCommunityId() + "'");
////					if (null != comName && comName.size() > 0) {
////						address.setCommunityName(comName.toString());
////					}
////					address.setAddress(req.getUnitNumber() + req.getHouseNumber());
////					address.setId(IdGen.uuid());
////					address.setUid(u.getId());
////					address.setUsername(u.getNickname());
////					address.setCity("郑州");
////					address.setIsdefault("0");
////					address.setUserphone(u.getPhone());
////					address.setAdtime(new Date());
////					addressService.addAddress(address);
//					tuserService.updateJSAPI(u);
//				}
//			}
//			res.setUid(u.getId());
//			res.setCommunityId(u.getCommunityid());
//			res.setCommunityName(u.getCommunityName());
//			res.setNickName(u.getNickname());
//			res.setAvatra(u.getIcon());
//			res.setRytoken(u.getRytoken());
//			res.setIswanshan(StringUtils.isBlank(u.getCommunityid()) ? "0" : "1");
//			res.setToken(JwtToken.createToken(request, u));
//			// 登录成功后修改token
//			if (StringUtils.isNotBlank(req.getToken())) {
//				tuserService.updateToken(u.getId(), req.getToken());
//			}
//			tuserService.executeUpdateSql(
//					"UPDATE t_user u SET u.openId = '" + req.getOpenId() + "' WHERE u.id='" + u.getId() + "'");
//		} catch (Exception e) {
//			logger.error("请求处理异常：16061" );
//			e.printStackTrace();
//		}
//		res.setResult("0");
//		res.setResultNote("登陆成功");
//		return res;
//	}
//
//	/**
//	 * 微信登陆完善信息
//	 */
//	public ResJson getWeiXinLoginMessageVerify(HttpServletRequest request, UserRegisterReq req) {
//		UserLoginRes res = new UserLoginRes();
//		try {
//			Tuser u = new Tuser();
//			if (null != req.getType() && "1".equals(req.getType())) {// 微信公众号
//				u.setId(req.getUid());
//				u = tuserService.get(u);
//			} else {
//				if (StringUtils.isBlank(req.getPhone())) {
//					res.setResultNote("手机号为空");
//					return res;
//				}
//				if (StringUtils.isBlank(req.getOpenId())) {
//					res.setResultNote("微信id不能为空");
//					return res;
//				}
//				u.setPhone(req.getPhone());
//				u = tuserService.selectOpenId(u);
//			}
//
//			if (null == u) {
//				if (StringUtils.isBlank(req.getPhone())) {
//					res.setResultNote("手机号不能为空");
//					return res;
//				}
//				if (!StringUtils.isBlank(req.getCode())) {
//					String ip = request.getRemoteAddr();// 获取ip
//					String authCode = csc.codeBoolean(req.getPhone(), req.getCodeType(), req.getCode(), ip);// 短信验证码验证
//					if ("1".equals(authCode)) {
//						res.setResultNote("验证码不正确");
//						return res;
//					} else if ("2".equals(authCode)) {
//						res.setResultNote("验证码过期");
//						return res;
//					}
//					// 成功后删除存储的验证码
//					CacheUtils.remove("code" + req.getPhone(), req.getCodeType());
//					CacheUtils.remove("ip" + ip, req.getCodeType());
//					CacheUtils.remove("dateTime" + ip, req.getCodeType());
//				}
//				// 创建用户
//				u = new Tuser();
//				String id = IdGen.uuid();
//				u.setId(id);// id
//				u.setPhone(req.getPhone());// 手机号
//				u.setNickname(req.getNickname());// 昵称
//				u.setSex(req.getSex());
//				u.setIcon(req.getIcon());
//				String random = String.valueOf(Math.random());
//				String code = random.substring(random.length() - 8);
//				u.setBalance(0d);
////				u.setToken(req.getToken());
//				u.setInvitenum(code);
//				u.setBirthday(req.getBirthday());
//				u.setEffectnum(0);
//				u.setDynamicnum(0);
//				u.setAttennum(0);
//				u.setFansnum(0);
//				u.setReportnum(0);
//				u.setIntegralnum(0);
////				u.setHometown(req.getHometown());
//				u.setAuthentication("0");
//				u.setIsapply("0");
//				u.setIsperfect("0");
//				u.setBinvitenum(req.getUserInviteCode());// 邀请人
//				u.setStatus("0");// 状态 0正常 1禁用
//				u.setAdtime(new Date());
//				if(!StringUtils.isBlank(req.getCommunityId())){
//					u.setCommunityid(req.getCommunityId());
//				}
//				u.setOpenId(req.getOpenId());
//				int result = tuserService.addUser(u);
//				//TODO 取消默认地址生成
////				//默认地址
////				Address address = new Address();
////				address.setId(IdGen.uuid());
////				address.setUid(u.getId());
////				address.setUsername(u.getNickname());
////				address.setUserphone(u.getPhone());
////				address.setCity("郑州市");
////				String communityName = StringUtils.isBlank(u.getCommunityName()) ? "" : u.getCommunityName();
////				String doornumber = StringUtils.isBlank(u.getDoornumber()) ? "" : u.getDoornumber();
////				String unitName = StringUtils.isBlank(u.getUnitName()) ? "" : u.getUnitName();
////				address.setCommunityName(communityName);
////				address.setAddress(unitName + doornumber);
////				address.setIsdefault("0");
////				address.setAdtime(new Date());
////				addressService.addAddress(address);
//
//				if (result > 0) {
//					// 赠送积分
//					if (StringUtils.isNotBlank(req.getUserInviteCode())) {
//						try {
//							Tuser uu = tuserService.findUniqueByProperty("invitenum", req.getUserInviteCode());
//							tuserService.updateScore(uu.getId(), 20, 0,"邀请好友");
//						} catch (Exception e) {
//							logger.error("请求处理异常：16163" );
//							e.printStackTrace();
//						}
//
//					}
//				}
//
//				//添加用户指定的天数
//				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//				// 查看是否有特定优惠劵
//				List<Coupon> coupon = couponService.selectSpecificCoupon(req.getCommunityId(), "1");
//				List<Map<String, String>> dataList = new ArrayList<>();
//				if (null != coupon && coupon.size() > 0) {
//					for (Coupon coupon2 : coupon) {
//						UserCoupon uc = new UserCoupon();
//						String startDays = DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getStartCouponDay()));
//						String endDays= DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getEndCouponDay())?
//								0:StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getEndCouponDay())+Integer.valueOf(coupon2.getStartCouponDay()));
//						uc.setUid(u.getId());
//						uc.setCouponid(coupon2.getId());
//						List<UserCoupon> list = userCouponService.findList(uc);
//						if (list != null && list.size() > 0) {
//							res.setResultNote("不能重复领取");
//							return res;
//						}
//						uc.setCommunityid(coupon2.getCommunityid());
//						uc.setCommunityname(coupon2.getCommunityname());
//						uc.setAllmoney(coupon2.getAllmoney());
//						uc.setAmount(coupon2.getAmount());
//						uc.setType(coupon2.getType());
//						uc.setStartdate(sf.parse(startDays));
//						uc.setEnddate(sf.parse(endDays));
//						uc.setStatus("0");
//						uc.setAdtime(new Date());
//						userCouponService.save(uc);// 插入到我的优惠劵表
//
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("securitiesid", coupon2.getId());
//						map.put("communityId", coupon2.getCommunityid());
//						map.put("communityName", coupon2.getCommunityname());
//						map.put("securitiesMoney", coupon2.getAllmoney() + "");
//						map.put("securitiesType", coupon2.getType());
//						map.put("securitiesName", coupon2.getName());
//						map.put("securitiesImg", filePath + coupon2.getImage());
//						map.put("securitiesPrice", coupon2.getAmount() + "");
//						map.put("securitiesStartTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(startDays)));
//						map.put("securitiesEndTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(endDays)));
//						dataList.add(map);
//
//					}
//					res.setDataList(dataList);
//				}
//
//				// 网易云信添加新用户
////				String token = Wangyiyunxin.getToken(id);
////				// System.out.println("getToken: " + token);
////				u.setRytoken(token);
////				tuserService.updateUser(u);
////				res.setRytoken(token);
//
//				// 网易云信添加客服为好友
////				Wangyiyunxin.addfriend(id, "admin");
////				Wangyiyunxin.updateuser(id, u.getNickname(), u.getIcon());
//			} else {
//				if (null != req.getType() && "1".equals(req.getType())) {// 微信公众号
//
//					// 创建用户
//					if (null == u.getNickname() || "".equals(u.getNickname()))
//						u.setNickname(req.getNickname());// 昵称
//					if (null == u.getSex() || "".equals(u.getSex()))
//						u.setSex(req.getSex());
//					if (null == u.getIcon() || "".equals(u.getIcon()))
//						u.setIcon(req.getIcon());
//					String random = String.valueOf(Math.random());
//					String code = random.substring(random.length() - 8);
//					if (null == u.getInvitenum() || "".equals(u.getInvitenum()))
//						u.setInvitenum(code);
//					u.setStatus("0");// 状态 0正常 1禁用
//					if (null == u.getCommunityid() || "".equals(u.getCommunityid()))
//						u.setCommunityid(req.getCommunityId());
//					if (null == u.getUnitid() || "".equals(u.getUnitid()))
//						u.setUnitid(req.getUnitNumber());
//					if (null == u.getDoornumber() || "".equals(u.getDoornumber()))
//						u.setDoornumber(req.getHouseNumber());
//					if (null == u.getOpenId() || "".equals(u.getOpenId()))
//						u.setOpenId(req.getOpenId());
//					u.setAdtime(new Date());
////					Address address = new Address();
////					List<Object> comName = communityService.executeSelectSql(
////							"SELECT name1 FROM t_community WHERE id = '" + req.getCommunityId() + "'");
////					if (null != comName && comName.size() > 0) {
////						address.setCommunityName(comName.toString());
////					}
////					address.setAddress(req.getUnitNumber() + req.getHouseNumber());
////					address.setId(IdGen.uuid());
////					address.setUid(u.getId());
////					address.setUsername(u.getNickname());
////					address.setCity("郑州");
////					address.setIsdefault("0");
////					address.setUserphone(u.getPhone());
////					address.setAdtime(new Date());
////					addressService.addAddress(address);
//					tuserService.updateJSAPI(u);
//				}else {
//					if(null != u.getNickname() && null != u.getPhone() && u.getNickname().length()==6 && u.getPhone().length()==11
//							&& u.getNickname().substring(0,2).equals("用户") && u.getNickname().substring(2).equals(u.getPhone().substring(7))) {
//						u.setNickname(req.getNickname());
//					}
//
//					if(null ==u.getIcon() || "".equals(u.getIcon()) || "/wisdom/userfiles/1/files/user/icon/default.png".equals(u.getIcon())) {
//						u.setIcon(req.getIcon());
//					}
//					if(null != req.getSex() && req.getSex().length()>0) {
//						u.setSex(req.getSex());
//					}
//					if(null != u.getIcon() && u.getIcon().length()>0) {
//						tuserService.executeUpdateSql("UPDATE t_user SET nickname='"+u.getNickname()+"',"
//								+ "icon='"+u.getIcon()+"',sex='"+u.getSex()+"' WHERE id='"+u.getId()+"'");
//					}
//				}
//			}
//			res.setUid(u.getId());
//			res.setCommunityId(u.getCommunityid());
//			res.setCommunityName(u.getCommunityName());
//			res.setNickName(u.getNickname());
//			res.setAvatra(u.getIcon());
//			res.setRytoken(u.getRytoken());
//			res.setIswanshan(StringUtils.isBlank(u.getCommunityid()) ? "0" : "1");
//			res.setToken(JwtToken.createToken(request, u));
//			// 登录成功后修改token
//			if (StringUtils.isNotBlank(req.getToken())) {
//				tuserService.updateToken(u.getId(), req.getToken());
//			}
//			tuserService.executeUpdateSql(
//					"UPDATE t_user u SET u.openId = '" + req.getOpenId() + "' WHERE u.id='" + u.getId() + "'");
//		} catch (Exception e) {
//			logger.error("请求处理异常：16297" );
//			e.printStackTrace();
//		}
//		res.setResult("0");
//		res.setResultNote("登陆成功");
//		return res;
//	}
//
//	/**
//	 * 4.271用户端退出登录
//	 *
//	 * @param req
//	 * @return
//	 */
//	public ResJson codeUserQuit(UserLoginReq req) {
//
//		ResJson res = new ResJson();
//		res.setResultNote("退出失败");
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户id不可为空");
//			return res;
//		}
//		try {
//			tuserService.executeUpdateSql("UPDATE t_user SET token = NULL WHERE id='"+req.getUid()+"'");
//			res.setResult("0");
//			res.setResultNote("退出成功");
//		} catch (Exception e) {
//			logger.error("请求处理异常：14797" );
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	public ResJson codecSmall(HttpServletRequest request, ThirdLoginReq req) throws Exception {
//		UserLoginRes res = new UserLoginRes();
//		res.setResultNote("登录失败");
//
//		if (StringUtils.isBlank(req.getXcxCode())&&StringUtils.isBlank(req.getOpenid())) {
//			res.setResultNote("请重新授权,无法获取code");
//			return res;
//		}
//		Tuser tuser =null;
//		if(StringUtils.isBlank(req.getOpenid())){
//			JSONObject wxUserInfo=WeixinUtils.getSmallOpenId(req.getXcxCode());
//			if(wxUserInfo.containsKey("openid")){
//				res.setOpenid(wxUserInfo.get("openid").toString());
//			}else{
//				res.setResultNote("请重新授权,无法获取openid");
//				return res;
//			}
//			if(wxUserInfo.containsKey("unionid")){
//				tuser=tuserService.getUserByOpenId(wxUserInfo.getString("unionid").toString());
//				if(null==tuser){
//					if(StringUtils.isBlank(req.getPhone())){
//						res.setResultNote("请填写手机号");
//						res.setUnionid(wxUserInfo.getString("unionid").toString());
//						res.setOpenid(wxUserInfo.get("openid").toString());
//						return res;
//					}else{
//						tuser = tuserService.getUserByPhone(req.getPhone());
//						if(null!=tuser&&StringUtils.isBlank(tuser.getOpenId())){
//							tuser.setOpenId(wxUserInfo.getString("unionid").toString());
//							tuser.setAdtime(new Date());
//							tuserService.updateJSAPI(tuser);
//						}
//					}
//				}
//			}else{
//				res.setResultNote("请重新授权,无法获取unionid");
//				return res;
//			}
//		}else{
//			if(!StringUtils.isBlank(req.getPhone())){
//				tuser = tuserService.getUserByPhone(req.getPhone());
//				if(null!=tuser&&StringUtils.isBlank(tuser.getOpenId())){
//					tuser.setOpenId(req.getUnionid());
//					tuser.setAdtime(new Date());
//					tuserService.updateJSAPI(tuser);
//				}
//			}else{
//				res.setResultNote("请填写手机号");
//				res.setUnionid(req.getUnionid());
//				res.setOpenid(req.getOpenid());
//				return res;
//			}
//		}
//
//		String ip = request.getRemoteAddr();
//		if (null == tuser) {
//			if (!StringUtils.isBlank(req.getCode())&&!req.getPhone().equals("15093268552")&&!req.getPhone().equals("17737505837")) {
//				String authCode = csc.codeBoolean(req.getPhone(), req.getCodeType(), req.getCode(), ip);// 短信验证码验证
//				if ("1".equals(authCode)) {
//					res.setResultNote("验证码不正确");
//					return res;
//				} else if ("2".equals(authCode)) {
//					res.setResultNote("验证码过期");
//					return res;
//				}
//				// 成功后删除存储的验证码
//				CacheUtils.remove("code" + req.getPhone(), req.getCodeType());
//				CacheUtils.remove("ip" + ip, req.getCodeType());
//				CacheUtils.remove("dateTime" + ip, req.getCodeType());
//			}
//			// 创建用户
//			Tuser u = new Tuser();
//			String id = IdGen.uuid();
//			u.setId(id);// id
//			u.setPhone(req.getPhone());// 手机号
//			u.setPassword(req.getPassword());// 登录密码
//			u.setNickname(req.getPhone().length() > 4 ? "邻友" + req.getPhone().substring(req.getPhone().length() - 4)
//					: "邻友0000");// 昵称
//			u.setIcon(req.getIcon());//获取微信头像路径 并下载到服务器
//			u.setSex("1");
//			String random = String.valueOf(Math.random());
//			String code = random.substring(random.length() - 8);
//			u.setBalance(0d);
//			u.setToken(req.getToken());
//			u.setInvitenum(code);
//			u.setEffectnum(0);
//			u.setDynamicnum(0);
//			u.setAttennum(0);
//			u.setFansnum(0);
//			u.setReportnum(0);
//			u.setHometown("");
//			u.setOpenId(req.getUnionid());//获取用户的unionid
//			u.setAuthentication("0");
//			u.setIsapply("0");
//			u.setIsperfect("0");
//			u.setStatus("0");// 状态 0正常 1禁用
//			u.setAdtime(new Date());
//			tuserService.addUser(u);
//			res.setUid(u.getId());
//			res.setToken(JwtToken.createToken(request, u));
//			/*try {// 网易云信添加新用户
//				String token = Wangyiyunxin.getToken(id);
//				// System.out.println("getToken: " + token);
//				u.setRytoken(token);
//				tuserService.updateUser(u);
//				res.setRytoken(token);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}*/
//			// 新用户未完善信息
//			res.setIswanshan("0");
//			/*try {// 网易云信添加客服为好友
//				Wangyiyunxin.addfriend(id, "admin");
//				Wangyiyunxin.updateuser(id, u.getNickname(), filePath + u.getIcon());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}*/
//			tuser = u;
//		} else if (!"0".equals(tuser.getStatus())) {
//			res.setResultNote("该用户已被禁用");
//			return res;
//		} else {
//			res.setUid(tuser.getId());
//			res.setCommunityId(tuser.getCommunityid());
//			res.setCommunityName(tuser.getCommunityName());
//			res.setRytoken(tuser.getRytoken());
//			res.setOpenid(tuser.getOpenId());
//			res.setUnionid(tuser.getOpenId());
//			res.setPhone(tuser.getPhone());
//			res.setIswanshan(StringUtils.isBlank(tuser.getCommunityid()) ? "0" : "1");
//			res.setToken(JwtToken.createToken(request, tuser));
//			// 验证通过删除缓存
//			if("15093081262".equals(req.getPhone()) || "17630766869".equals(req.getPhone())) {
//
//
//			}else {
//				  CacheUtils.remove("code" + req.getPhone(), req.getCodeType());
//				  CacheUtils.remove("ip" + ip, req.getCodeType());
//				  CacheUtils.remove("dateTime" + ip,req.getCodeType());
//			}
//		}
//		Map<String,Object>ordernum = couponService.execSelectSqlEntityObjMap("SELECT COUNT(1) as num FROM t_user_order a where a.uid='"+tuser.getId()+"' AND a.`status`!='12'");
//		if(Double.valueOf(ordernum.get("num").toString())==0&&StringUtils.isNotBlank(tuser.getCommunityid())){//未购买过的用户并且有小区
//			//添加用户指定的天数
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//			// 查看是否有特定优惠劵
//			List<Coupon> coupon = couponService.selectSpecificCoupon(tuser.getCommunityid(), "1");
//			List<Map<String, String>> dataList = new ArrayList<>();
//			if (null != coupon && coupon.size() > 0) {
//				for (Coupon coupon2 : coupon) {
//					UserCoupon uc = new UserCoupon();
//					String startDays = DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getStartCouponDay()));
//					String endDays= DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getEndCouponDay())?
//							0:StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getEndCouponDay())+Integer.valueOf(coupon2.getStartCouponDay()));
//					uc.setUid(tuser.getId());
//					uc.setCouponid(coupon2.getId());
//					List<UserCoupon> list = userCouponService.findList(uc);
//					if (list != null && list.size() > 0) {
//	//					res.setResultNote("不能重复领取");
//	//					return res;
//						continue;
//					}
//					uc.setCommunityid(coupon2.getCommunityid());
//					uc.setCommunityname(coupon2.getCommunityname());
//					uc.setAllmoney(coupon2.getAllmoney());
//					uc.setAmount(coupon2.getAmount());
//					uc.setType(coupon2.getType());
//					uc.setStartdate(sf.parse(startDays));
//					uc.setEnddate(sf.parse(endDays));
//					uc.setStatus("0");
//					uc.setAdtime(new Date());
//					userCouponService.save(uc);// 插入到我的优惠劵表
//
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("securitiesid", coupon2.getId());
//					map.put("communityId", coupon2.getCommunityid());
//					map.put("communityName", coupon2.getCommunityname());
//					map.put("securitiesMoney", coupon2.getAllmoney() + "");
//					map.put("securitiesType", coupon2.getType());
//					map.put("securitiesName", coupon2.getName());
//					map.put("securitiesImg", filePath + coupon2.getImage());
//					map.put("securitiesPrice", coupon2.getAmount() + "");
//					map.put("securitiesStartTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(startDays)));
//					map.put("securitiesEndTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(endDays)));
//					dataList.add(map);
//
//				}
//				res.setDataList(dataList);
//			}
//		}
////		try {
////			// 登录成功后修改token
////			if (StringUtils.isNotBlank(req.getToken()) && req.getToken().length() < 30) {
////				tuserService.updateToken(tuser.getId(), req.getToken());
////			}
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
//		res.setResult("0");
//		res.setResultNote("登录成功");
//		return res;
//	}
//
//	//传Type 和 社区id
//	public ResJson activitycode(HttpServletRequest request,  ActivityListReq  req){
//		ResJson res=new ResJson();
//		//TODO 本处不再判断用户是否登录
//		if (StringUtils.isNotBlank(req.getUid())) {
//			Tuser user = tuserService.get(req.getUid());
//			if (null == user) {
//				res.setResultNote("用户不存在");
//				return res;
//			} else if (!"0".equals(user.getStatus())) {
//				res.setResultNote("用户被禁用");
//				return res;
//			}
//		}
//		res.setResultNote("获取数据失败");
//		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//		List<Activitylist> activity=activitylistMapper.apiAvtivityList(req);
//		if(activity!=null&&activity.size()>0){
//			for(Activitylist at:activity){
//				if(at.getCommunityid().equals("1")||at.getCommunityid().contains(req.getCommunityid())){
//					Map<String,Object> map =new HashMap<>();
//					map.put("activityid", at.getId());
//					map.put("title", at.getTitle());
//					map.put("type", at.getType());
//					map.put("typeName", at.getTypeName());
//					dataList.add(map);
//				}
//			}
//			if(dataList.isEmpty()){
//				return res;
//			}else{
//				res.setDataList(dataList);
//				res.setResult("0");
//				res.setResultNote("获取数据成功");
//			}
//		}
//		return res;
//	}
//	//传入活动id和活动Type
//	public ResJson activityListcode(HttpServletRequest request,  ActivityListReq  req){
//		/*ActivityGoodsRes res= new ActivityGoodsRes();*/
//		ResJson res=new ResJson();
//		if (StringUtils.isBlank(req.getUid())) {
//			res.setResultNote("用户id不可为空");
//			return res;
//		}
//		res.setResultNote("获取数据失败");
//		//Type==2是秒杀
//			if(StringUtils.isBlank(req.getActivityid())){
//				return res;
//			}else{
//					List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
//					String activityid=req.getActivityid();
//						if(req.getType().equals("2")){
//							List<ActivityListTime> alt=	activitylistMapper.selectActivityListTime(activityid);
//							if(alt!=null&&alt.size()>0){
//								for(ActivityListTime alTime:alt){
//									alTime.getId();
//									Map<String,Object> map =new HashMap<>();
//									map.put("activityid", activityid);
//									map.put("activitytimeid", alTime.getId());
//									map.put("communityid", req.getCommunityid());
//									List<Map<String,Object>>listgoods=goodsMapper.selectActivitylistGoods(map);
//									map.clear();
//									map.put("id", alTime.getId());
//									map.put("state", alTime.getState());
//									map.put("stateName", alTime.getStateName());
//									map.put("starttime",alTime.getStarttime() );
//									map.put("endtime", alTime.getEndtime());
//									map.put("listgoods", listgoods);
//									dataList.add(map);
//								}
//							}
//							//Type==1是团购
//						}else if(req.getType().equals("1")){
//							Map<String,Object> map =new HashMap<>();
//							map.put("activityid", activityid);
//							map.put("uid", req.getUid());
//							map.put("communityid", req.getCommunityid());
//							List<ActivityGoods>listgoods=goodsMapper.tuanActivityList(map);
//							if(listgoods!=null&&listgoods.size()>0){
//								for(ActivityGoods ay:listgoods){
//									Map<String,Object> mapinfo =new HashMap<>();
//									mapinfo.put("id", ay.getId());
//									mapinfo.put("type", ay.getType());
//									mapinfo.put("categoryid", ay.getCategoryid());
//									mapinfo.put("goodsName", ay.getTitle());
//									mapinfo.put("goodsImg", ay.getImage());
//									mapinfo.put("specification", ay.getSpecification());
//									mapinfo.put("goodsdesc", ay.getGoodsdesc());
//									mapinfo.put("goodsContent", ay.getContent());
//									mapinfo.put("goodsPrice", ay.getPrice());
//									mapinfo.put("activityprice", ay.getActivityprice());
//									mapinfo.put("state", ay.getState());
//									mapinfo.put("categoryname", ay.getCategoryname());
//									mapinfo.put("adtime", ay.getAdtime());
//									mapinfo.put("flag", ay.getFlag());
//									mapinfo.put("unifierid", ay.getUnifierid());
//									mapinfo.put("uid",ay.getUid());
//									mapinfo.put("activityid", ay.getActivityid());
//									mapinfo.put("sallnum", ay.getSallnum());
//									mapinfo.put("count", ay.getCount());
//									mapinfo.put("goodsStock", ay.getGoodsStock());
//									if(Integer.valueOf(ay.getTypenum().toString())>1){
//										map.put("unifierid", ay.getUnifierid());
//										List<Map<String,Object>>goodsinfo=goodsMapper.selectTuanTypes(map);
//										mapinfo.put("goodsinfo", goodsinfo);
//									}
//									dataList.add(mapinfo);
//								}
//							}
//					}else{
//						return res;
//					}
//			res.setDataList(dataList);
//			res.setResult("0");
//			res.setResultNote("获取数据成功");
//		}
//		return res;
//	};

}
