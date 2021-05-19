package com.doulin.entity.shop;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.image.ImgDoConfig;
import com.doulin.entity.util.EntityDateUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @className 商家上传资料
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/26 11:25
 * @Version 1.0
 */
@Slf4j
public class ShopImport implements Serializable {

 /**
  * 添加或修改参数
  * @param thbif
  * @param oper  Add OrUpdate
  * @param cmd
  * @return
  */
 public static String getParamAddOrUpdate(TShopHomeBaseInfo thbif,TShopHomeBaseInfo db, String cmd,SykUtil sykUtil, String oper) {
  Map<String, Object> map = new LinkedHashMap<>();
  //方法名
  map.put("p0_cmd", cmd);
  //企业编号
  map.put("p1_plat_id", thbif.getPlatId());
  //商户账号
  map.put("p2_mch_id", thbif.getLoginNo());
  //公司名称
  String commoneyname = StrUtil.isEmpty(thbif.getCompanyName()) ? db.getCompanyName() : thbif.getCompanyName();
  //商户名称
  map.put("p3_mch_name", commoneyname);
  String password = upppercaseMd5("123456");
  map.put("p31_pwd", password);
  //商户简称 支付时显示的名称
  String shortName = StrUtil.isEmpty(thbif.getShopHomeName()) ? db.getShopHomeName() : thbif.getShopHomeName();
  map.put("p4_mch_name_short", shortName);
  map.put("p5_province", StrUtil.isEmpty(thbif.getShopProvinceName()) ? db.getShopProvinceName() : thbif.getShopProvinceName());
  map.put("p6_city", StrUtil.isEmpty(thbif.getShopCityName()) ? db.getShopCityName() : thbif.getShopCityName());
  map.put("p7_district", StrUtil.isEmpty(thbif.getShopDistrictName()) ? db.getShopDistrictName() : thbif.getShopDistrictName());
  String address=StrUtil.isEmpty(thbif.getShopAddress()) ? db.getShopAddress() : thbif.getShopAddress();
  map.put("p8_address", address);
  String telePhone = StrUtil.isEmpty(thbif.getTelePhone()) ? db.getTelePhone() : thbif.getTelePhone();
  map.put("p9_mobile", telePhone);
  map.put("p12_contact_man", StrUtil.isEmpty(thbif.getLoginName()) ? db.getLoginName() : thbif.getLoginName());
  String BankCard = StrUtil.isEmpty(thbif.getLegalPersonBankCard()) ? db.getLegalPersonBankCard() : thbif.getLegalPersonBankCard();
  String legal_person_card_num = StrUtil.isEmpty(thbif.getLegalPersonCardNum()) ? db.getLegalPersonCardNum() : thbif.getLegalPersonCardNum();
  map.put("p13_id_card_no", legal_person_card_num);
  map.put("p14_license_num", StrUtil.isEmpty(thbif.getSocialCreditCode()) ? db.getSocialCreditCode() : thbif.getSocialCreditCode());

  map.put("p15_license_scope", StrUtil.isEmpty(thbif.getBusinessScope()) ? db.getBusinessScope() : thbif.getBusinessScope());
  String fountDt = StrUtil.isEmpty(thbif.getFoundDt()) ? db.getFoundDt() : thbif.getFoundDt();
  map.put("p16_license_start_date", getTimeStr(fountDt));
  String p17 = StrUtil.isEmpty(thbif.getPeriodOfValidity()) ? db.getPeriodOfValidity() : thbif.getPeriodOfValidity();
  if (!p17.contains("长期")) {
   p17 = getTimeStr(getTimeStr(p17));
  } else {
   Integer num = (Integer.valueOf(getTimeStr(fountDt)) + 600000);
   p17 = num.toString();
  }
  map.put("p17_license_end_date", p17);
  map.put("p18_license_type", 0);
  String category_no = StrUtil.isEmpty(thbif.getCategoryNo()) ? db.getCategoryNo() : thbif.getCategoryNo();
  //经营类目
  map.put("p19_category_no", category_no);
  //行业类别编号
  String industry_no = StrUtil.isEmpty(thbif.getIndustryNo()) ? db.getIndustryNo() : thbif.getIndustryNo();
  map.put("p20_industry_no", industry_no);
  map.put("p22_act", oper);
  String LegalPersonBankCardL = StrUtil.isEmpty(thbif.getLegalPersonBankCardL()) ? db.getLegalPersonBankCardL() : thbif.getLegalPersonBankCardL();
  map.put("p23_bank_no", LegalPersonBankCardL.replace(" ", ""));
  map.put("p24_bank_type", 1);
  String LegalPersonBankCard = StrUtil.isEmpty(thbif.getLegalPersonBankCard()) ? db.getLegalPersonBankCard() : thbif.getLegalPersonBankCard();
  map.put("p25_bank_account", LegalPersonBankCard.replace(" ", ""));
  String LegalPersonCardName = StrUtil.isEmpty(thbif.getLegalPersonCardName()) ? db.getLegalPersonCardName() : thbif.getLegalPersonCardName();
  String commanyClass = StrUtil.isEmpty(thbif.getCompanyClass()) ? db.getCompanyClass() : thbif.getCompanyClass();

  //企业
  Integer type = 3;
  if (commanyClass.contains("有限责任")) {
  } else {
   //个体
   type = 2;
   commoneyname = LegalPersonCardName;
  }
  //持卡人姓名
  map.put("p26_bank_owner", commoneyname);
  map.put("p27_bank_idcard", legal_person_card_num);
  map.put("p28_bank_mobile", telePhone);
  map.put("p29_mch_type", type);
  String time = StrUtil.isEmpty(thbif.getLegalPersonCardTime()) ? db.getLegalPersonCardTime() : thbif.getLegalPersonCardTime();
  String time1 = time.substring(0, time.lastIndexOf('-'));
  map.put("p33_id_card_start_date", getTimeStr(time1));
  String time2 = time.substring(time.lastIndexOf('-', time.length()) + 1);
  if (!"长期".equals(time2)) {
   time2 = getTimeStr(time2);
  } else {
   time2 = "长期有效";
  }
  map.put("p34_id_card_end_date", time2);
  map.put("p35_settleLimit", 0);
  String industry_no_weixin = StrUtil.isEmpty(thbif.getIndustryNoWeixin()) ? db.getIndustryNoWeixin() : thbif.getIndustryNoWeixin();
  map.put("p38_industry_no_weixin", industry_no_weixin);
  map.put("p39_legal_man", LegalPersonCardName);
  map.put("p40_legal_man_id_card_no", legal_person_card_num);
  map.put("p41_BusinessType", 1);
  map.put("nonceStr", String.valueOf(System.currentTimeMillis()));
  return md5Str(map, sykUtil.getApiKey());
 }
/**
 * 3.1.4	商户证件资料上传
  * @param thbif
  * @return
  */
 public static String getParamMchCertUpload(TShopHomeBaseInfo thbif,TShopHomeBaseInfo db, ImgDoConfig http, String key) throws UnsupportedEncodingException {

  String ShopIndoorPhoto=StrUtil.isEmpty(thbif.getShopIndoorPhoto())?db.getShopIndoorPhoto():thbif.getShopIndoorPhoto();
  String[] indoorimg = ShopIndoorPhoto.split(",");
  Map<String, Object> map = new HashMap<>();
  String LegalPersonCardZ=StrUtil.isEmpty(thbif.getLegalPersonCardZ())?db.getLegalPersonCardZ():thbif.getLegalPersonCardZ();
  map.put("id_card", LegalPersonCardZ);//法人身份证正面
  String LegalPersonCardF=StrUtil.isEmpty(thbif.getLegalPersonCardF())?db.getLegalPersonCardF():thbif.getLegalPersonCardF();
  map.put("id_f_card", LegalPersonCardF);//：法人身份证反面
  String LegalPersonCardP=StrUtil.isEmpty(thbif.getLegalPersonCardP())?db.getLegalPersonCardP():thbif.getLegalPersonCardP();
  map.put("handed_idCard",LegalPersonCardP);//：法人手持身份证
  String BusinessLicenseImage=StrUtil.isEmpty(thbif.getBusinessLicenseImage())?db.getBusinessLicenseImage():thbif.getBusinessLicenseImage();
  map.put("license", BusinessLicenseImage);//：营业执照
  String ShopLogo=StrUtil.isEmpty(thbif.getShopLogo())?db.getShopLogo():thbif.getShopLogo();
  map.put("mer_logo", ShopLogo);//商户Logo
  String ShopTitleImage=StrUtil.isEmpty(thbif.getShopTitleImage())?db.getShopTitleImage():thbif.getShopTitleImage();
  map.put("storefront", ShopTitleImage);//门头照
  map.put("interior_1", indoorimg[0]);//内景照1
  map.put("interior_2", indoorimg[1]);//内景照2
  map.put("interior_3", indoorimg[2]);//内景照3
  String shopAcceptanceLetterImg=StrUtil.isEmpty(thbif.getShopAcceptanceLetterImg())?db.getShopAcceptanceLetterImg():thbif.getShopAcceptanceLetterImg();
  if(!StrUtil.isEmpty(shopAcceptanceLetterImg)) {
   map.put("industryLicenseImg", shopAcceptanceLetterImg);//开户许可证
  }
  String LegalPersonBankImage=StrUtil.isEmpty(thbif.getLegalPersonBankImage())?db.getLegalPersonBankImage():thbif.getLegalPersonBankImage();
  map.put("bankCardImg", LegalPersonBankImage);//银行卡照片
  String ShopSettlementBookImg=StrUtil.isEmpty(thbif.getShopSettlementBookImg())?db.getShopSettlementBookImg():thbif.getShopSettlementBookImg();
  map.put("AUTHORIZATION_FOR_SETTLEMENT",ShopSettlementBookImg);// 结算帐户指定书
  String LegalPersonBankHandImage=StrUtil.isEmpty(thbif.getLegalPersonBankHandImage())?db.getLegalPersonBankHandImage():thbif.getLegalPersonBankHandImage();
  map.put("HANDHELD_OF_BANK_CARD", LegalPersonBankHandImage);//结算人手持结算卡照
  String AshierPhoto=StrUtil.isEmpty(thbif.getAshierPhoto())?db.getAshierPhoto():thbif.getAshierPhoto();
  map.put("CHECKSTAND",AshierPhoto);//收银台照
  List<Map<String, Object>> content = new ArrayList<>();
  for (Map.Entry<String, Object> c : map.entrySet()) {
   Map<String, Object> mapz = new HashMap<>();
   mapz.put("certType", c.getKey());
   String path=c.getValue().toString();
   path=path.replace("/files/",http.getFilePath());
   String base64= EntityDateUtil.getImgStr(path);
   mapz.put("imgContent",base64);
   mapz.put("imgType", "jpg");
   mapz.put("imgContentType", "0");
   content.add(mapz);
  }
  String p0_cmd = "MchCertUpload",//固定值：MchCertUpload（大小写敏感）
          p1_plat_id = thbif.getPlatId(),//	是	String(9)	合作方ID (由平台分配)
          p2_mch_id = thbif.getLoginNo(),//	是	string (11)	商户号
          p3_cert_content,
          nonceStr=String.valueOf(System.currentTimeMillis());//是	string
  p3_cert_content=JSONUtil.toJsonStr(JSONUtil.parseArray(content));


  Map<String, Object> param = new LinkedHashMap<>();
  param.put("p0_cmd", p0_cmd);
  param.put("p1_plat_id", p1_plat_id);
  param.put("p2_mch_id", p2_mch_id);
  //参与md5计算时是不需要urlencode
  param.put("p3_cert_content", p3_cert_content);
  param.put("nonceStr", nonceStr);
  //计算MD5
  StringBuilder str = new StringBuilder();
  for (Map.Entry<String, Object> jstr : param.entrySet()) {
   str.append(jstr.getKey());
   str.append("=");
   str.append(jstr.getValue());
   str.append("&");
  }
  String md5 = upppercaseMd5(str.toString()+"key="+key);

  //拼接参数
  Map<String, Object> paramreq = new LinkedHashMap<>();
  paramreq.put("p0_cmd", p0_cmd);
  paramreq.put("p1_plat_id", p1_plat_id);
  paramreq.put("p2_mch_id", p2_mch_id);
  paramreq.put("p3_cert_content", URLEncoder.encode((p3_cert_content),"UTF-8"));
  paramreq.put("nonceStr", nonceStr);
  StringBuilder strre = new StringBuilder();
  for (Map.Entry<String, Object> jstr : paramreq.entrySet()) {
   strre.append(jstr.getKey());
   strre.append("=");
   strre.append(jstr.getValue());
   strre.append("&");
  }
  strre.append("hmac=");
  strre.append(md5);
  return strre.toString();
 }

 /**
  * 3.7.2	固定二维码添加/修改
  * @param planId 合作方ID (由平台分配)
  * @param oper  0:添加   1:修改
  * @param sykQrCodeId  固维编号(添加时不用传，由系统自动生成,修改时必传)
  * @param merSn  绑定商户号，  p4_bBind为1 需传此值  添加模式下必传
  * @param apiKey 接口key
  * @return
  */
 public static String qrcode(String planId,int oper,String sykQrCodeId,String merSn,String apiKey) {

  Map<String, Object> map = new LinkedHashMap<>();
  /**
   * 是	string	固定值：UpdateQrcode（大小写敏感）
   */
  map.put("p0_cmd", "UpdateQrcode");
  /**
   *   是	String(9)	合作方ID (由平台分配)
   */
  map.put("p1_plat_id", planId);
  /**
   *  是	int	操作类型： 0:添加   1:修改   (预生成的二维码不能添加，统一批量生成)
   */
  map.put("p2_act", oper);
  if (1 == oper) {
   /**
    *是/否	String(10)	固维编号(添加时不用传，由系统自动生成,修改时必传)
    */
   map.put("p3_qrcode_ids", sykQrCodeId);
  }
  /**
   * 否	int	类型：   0.扫码和快捷  1.仅扫码  2.仅快捷     默认1
   */
  map.put("p4_type", 1);
  /**
   * 是	int	是否绑定了商户:0.未绑定  1.已绑定  添加模式更好固定为1.已绑定
   */
  map.put("p5_bBind", 1);
  /**
   * 是	Int	状态：0:正常;  1:禁用
   */
  map.put("p6_bLock", 0);
  /**
   * 	是/否	String(30)	绑定商户号，  p4_bBind为1 需传此值  添加模式下必传
   */
  map.put("p7_merSn", merSn);
  /**
   * 否	String(30)	渠道名称(暂不用，保留）
   */
//  map.put("p8_channelName",);
//p9_channelID	否	Int	渠道id  (p7_channelName和p8_channelID不可同时为空，p8_channelID优先级大于p7_channelName) (暂不用，保留）
//  p10_userName	否	int	归属员工帐号
//  p11_userID	否	int	归属员工帐号id Id优先级大于帐号
//  p12_noticeMobile	否	String(11)	交易通知手机号
//  p13_moneyType	否	Int	支付金额类型  0.固定金额 1.手输金额 默认1手输金额
//  p14_fixMoney	否	Decimal	固定交易金额值，p12_moneyType为0是，需传此值
//  p15_operatorID	否	Int	所绑定的商户操作员帐号id，如不为空则p7_merSn不能为空。
//  p16_bShowMerName	否	Int	是否显示商家名称  0.不显示 1.显示
//  p17_title	否	String(50)	商品描述
//  p18_operator_userName	否	String(30)	所绑定的商户操作员帐号名，如不为空则p7_merSn不能为空。（p15_operatorID和p18_operator_userName如都有值，p15_operatorID优先)
  /**
   *   nonceStr	是	String(32)	随机字符串
   */
  map.put("nonceStr", String.valueOf(System.currentTimeMillis()));

//  hmac	是	String(32)	加密校验串
  return md5Str(map, apiKey);
 }

 /**
  * 3.3	下单并支付接口(付款码支付,微信刷脸交易)
  * @return
  */
 public static String payZhiFu(String shopAccount, BigDecimal payMoney,String payId,String barCode,String productCode,String apiKey) {
  Map<String, Object> map = new LinkedHashMap<>();
  /**
   * 必选 固定值：CreateAndPay（大小写敏感）
   */
  map.put("p0_Cmd", "CreateAndPay");
  /**
   * 必选	string		商户帐号(PC端)
   */
  map.put("p1_Account", shopAccount);
  /**
   * 必选Number	该笔订单的资金总额，取值范围[0.01,100000000]，精确到小数点后2位,单位元
   */
  map.put("p2_Amt", payMoney);
  /**
   * 必选String32动态ID(即付码值或声波值(声波值仅支付宝支付才有))  刷脸支付时传获取到的facecode
   */
  map.put("p3_Did", payId);
  /**
   * 付款码类型
   * 支付宝支付目前支持(两者选一)：
   * wave_code：声波
   * bar_code：条码
   *
   * 微信支付、银联、翼支付固定选:
   * bar_code：条码
   * 刷脸支付固定选： face_code
   *
   * 不清楚就传bar_code
   */
  map.put("p4_DidType", barCode);
  /**
   * 必选String	32	用来区分是哪种业务类型的下单。
   * 支付宝支付目前支持(两者选一)：
   * BARCODE_PAY_OFFLINE：条码支付 SOUNDWAVE_PAY_OFFLINE：声波支付
   * 微信支付、银联、翼支付固定选:
   * BARCODE_PAY_OFFLINE：条码支付
   * 刷脸支付
   * FACE_PAY_OFFLINE
   *
   * 刷脸支付且p9_plat为1999一定要选：
   * FACE_PAY_OFFLINE
   */
  map.put("p5_ProductCode", productCode);
  return md5Str(map, apiKey);
 }


 /**
  *
  * 3.5	预下单接口(二维码支付(扫码支付))
  *
  */
 public static String peCreate(String account,BigDecimal payMoney,String payType,String returnUrl,String orderNo,String apiKey){
  Map<String,Object> map=new LinkedHashMap<>();
  /**
   * 必选string固定值：PreCreate（大小写敏感）
   */
  map.put("p0_Cmd","PreCreate");
  /**
   * 必选string	商户账号(PC端)
   */
  map.put("p1_Account",account);
  /**
   * 必选Number该笔订单的资金总额，取值范围[0.01,100000000]，精确到小数点后2位，单位：元
   */
  map.put("p2_Amt",payMoney);
  /**
   * 必选String32	用来区分是哪种业务类型的下单
   * 线下场景传：QR_CODE_OFFLINE
   * 公众号场景传：PAY_ONLINE
   * 小程序场景传：PAY_MINI
   * APP场景传：PAY_APP
   * H5场景传：PAY_H5
   * 请根据使用场景选择一个。
   * （用于后期辅助智能检测通道使用）
   */
  map.put("p3_ProductCode",payType);

  /**
   * 智能检测=1999    可选	Int	2	详见接口的支付平台值 默认1(官方支付宝)
   */
  map.put("p7_plat",1999);
  /**
   * 可选 	Int	2
   * 1为PC端收银，
   * 2为手机端收银,
   * 3为POS端收银，
   * 4为固定二维码交易，
   * 5为线上端(第三方合作方)收银，
   * 6民生商户APP，
   * 7微信小程序，
   * 8扫脸设备
   * 9支付宝小程序。默认1
   */
  map.put("p8_Channel",7);
/**
 * 可选	String	256
 * 本订单支付成功后，服务器主动通知商户指定的页面http路径。
 * 通知url必须为直接可访问的url，不能携带参数。
 * 如：http://api.test.alipay.net/atinterface/receive_notify.htm具体见：异步通知说明
 *  http:// www.xxx.com/notify.html?
 *  attach=恭喜发财&data={"trade_no":"A60701220214249470002850",
 *  "total_fee":"2.00","send_pay_date":"2016-07-01 22:02:14",
 *  "buyer_logon_id":"","plat":"1"}&hmac=783CB6620921E70D843F3559E0F90757
 */
  map.put("p9_Notify_Url",returnUrl);
  /**
   * 可选string	50	商户端订单号，请商户方自行保证唯一性，只能数字或字母。
   */
  map.put("p11_MerOrderNo",orderNo);
/**
 * 返回示例
 * {
 *     "result": "100",
 *     "data": {
 *         "result_code": "0000",
 *         "detail_error_code": "",
 *         "detail_error_des": "",
 *         "trade_no": "",//官方订单号
 *         "out_trade_no": "A01015121908619280002002",//商云客订单号
 *         "total_fee": "0.02",
 *         "subject": "福州福铁网络科技有限公司",
 *         "qr_code": "",
 *         "pic_url": "",
 *         "small_pic_url": "",
 *         "big_pic_url": "",
 *         "plat": "38",
 *         "js_prepay_info": "'timeStamp':'1602735533','package':'prepay_id=wx1512185314321353ce851ed5d289050000','paySign':'iQaBr//rhjq+EsgStdxyu6UZ2NRiLTJ2RPT5CmfLHzeb2qEBUply0IXPKPGgZUiTDDziTQS+knrlvKoDdWGR1RdgVyyQZso2YLkpo5mT35lcF7+KRM4JDAtBTS9m97NVyGRBvj9j9qYhMKf1Kko5ivKN0IYeGl/wWPuuAqSdRw6/xMLb5miuDD9cUlYH5rNwR9WMHA7mYAfPHwVrxxKKnvfTRK521llU6UDYduuCMbplHiOl7Zs2zH7Kg2WqG8hGgyRLYCZ3Sq+sJz8UTMkEZC5+lu65pYoDVSdCqK/XqTgt55UxqxIt8feSYu0gYMH+60yKK/egQXStXw5caEL44g==','appId':'wx67bac6f76bd5a54d','signType':'RSA','nonceStr':'u6HKo9FB5KsRvQlHYa67EIIrjvd6JBZk'",
 *         "app_prepay_info": "",
 *         "mweb_url": "",
 *         "parent_trade_no": "20101512185277270581113",//渠道订单号（间连通道和点金计划同步回调参数out_trade_no一致）
 *         "mer_order_no": "bYbbeJ6GRgEUeSPRW3"//商家自定义订单号
 *     }
 * }
 */
  return md5Str(map, apiKey);
 }


 /**
  * 3.2	交易记录查询接口
  *
  */
 public static String getOrder(String account,String pwd,
                               String startDate,String endDate,
                               int page,int size,int orderType,String apiKey) {
  Map<String, Object> map = new LinkedHashMap<>();
  /**
   * 必选 固定值：GetOrder（大小写敏感）
   */
  map.put("p0_Cmd", "GetOrder");
  /**
   * 必选string	商户账号(PC端)
   */
  map.put("p1_Account", account);
  /**
   * 必选string商家密码（md5加密）
   */
  map.put("p2_pwd", pwd);
//  P3_startDate	可选	DateTime	开始日期 yyyy-MM-dd 格式
//  p4_endDate  	可选	DateTime	结束日期 yyyy-MM-dd 格式
  map.put("P3_startDate", startDate);
  map.put("p4_endDate", endDate);
//  P5_pageIndex	可选	int	页码，如为空则默认为1
  map.put("P5_pageIndex", page);
//  P6_pageSize	可选	int	请求记录数，如为空,则默认为20
  map.put("P6_pageSize", size);
  //可选	String	商户的操作员ID,一般为收银员工号,为空则不限制.如果传递的操作员身份非收银员，则查询其所属门店下所有收银员的订单。
//  p7_operator_id
//  p8_QrcodeIDS	可选	String	固定二维码的编号，此参数是非空，则返回该固定二维码的订单

  /**
   * 可选int １为全部订单（成功及退款)，2为成功的订单，3为退款的订单，默认１
   */
  map.put("P9_OrderType", orderType);
//  P10_out_trade_no	可选	string	本平台内部订单号(A开头的那个)
//  p11_PayMode	可选	int	支付方式(1条码，2声波，3扫码，4二维码固定金额,5二维码手输金额，6会员卡，7现金，8无卡支付，9刷卡),为空则不限。
//  p12_shopSn	可选	String(8)	门店编号
//  hmac	必选	string	加密校验串
  return md5Str(map, apiKey);
 }

 /**
  * 3.6	订单撤销接口
  * @param account 商户账号
  * @param pwd  商户密码
  * @param orderNo 本系统内部订单号
  * @param tradeNo 平台商订单号
  * @param apiKey 接口key值
  * @return
  * http://localhost:602/api/ApiHandler.ashx?
  *     p0_Cmd=CancelOrder&p1_Account=406576729@qq.com&p2_out_trade_no=A150116224218715465859371880&
  *     p3_trade_no=&hmac=70EEA7D603FE00CF990BD3852B0551A1 6
  * http://localhost:602/api/ApiHandler.ashx?
  *  random=091707496&clientversion=3.0.4&p0_Cmd= CancelOrder &p1_Account=lhh%40xfpay.me&
  *  p2_out_trade_no=A20151206103130769796519&p3_trade_no=2015120621001004490283087854&hmac=6ff8d195a36c04b21a6849bb7cc1b1e2
  *
  *  {
  *     "result": "100",
  *     "data": {
  *         "result_code": "SUCCESS",
  *         "detail_error_code": "",
  *         "detail_error_des": "",
  *         "trade_no": "2015060921001004490040449731",
  *         "out_trade_no": "A150116224218715465859371880",
  *         "retry_flag": "",
  *         "action": "",
  *         "plat": "1"
  *     }
  * }
  */
 public static String cancelOrder(String account,String pwd,String orderNo,String tradeNo,String apiKey) {
  Map<String, Object> map = new LinkedHashMap<>();
  //必选string固定值：CancelOrder（大小写敏感）
  map.put("p0_Cmd", "CancelOrder");
  //必选string商户账号
  map.put("p1_Account", account);
  //必选/可选	string	64	本系统内部订单号
  map.put("p2_out_trade_no", orderNo);
  //可选	String	32	平台商订单号
  map.put("p3_trade_no", tradeNo);
  //必选/可选 商户端订单号  p2_out_trade_no和p4_mer_order_no两个必须传一个，两者同传取p2_out_trade_no。
//  map.put("p4_mer_order_no",tradeNo);
  //必选  订单所属商家的密码（32位md5加密串）
  map.put("p5_pwd", pwd);
//  hmac	必选	string		加密校验串
  return md5Str(map, apiKey);
 }

 /**
  *  3.7	订单退款接口HTTP请求方式：GET
  * @param account
  * @param pwd
  * @param outTradeNo
  * @param refundAmount
  * @param refundReason
  * @param apiKey
  * @return
  * http://localhost:602/api/ApiHandler.ashx?p0_Cmd=Refund&p1_Account=406576729@qq.com&
  *    p2_out_trade_no=A20150609184952785188375&p3_trade_no=&p4_refund_amount=0.01&hmac=03CB932779467B274CDB0A9AC2309795
  *
  * HTTP请求方式：GET
  */
 public static String refund(String account,String pwd,
                             String outTradeNo,BigDecimal refundAmount,
                             String refundReason,String apiKey) {
  Map<String, Object> map = new LinkedHashMap<>();
  //必选 固定值：Refund（大小写敏感）
  map.put("p0_Cmd", "Refund");
  //必选 商户账号
  map.put("p1_Account", account);
  //必选/可选 本系统内部订单号 （A或B开头的)
  map.put("p2_out_trade_no", outTradeNo);
//  p3_trade_no	可选	String	32	平台商或上游订单号
  //必选退款金额，取值范围[0.01,订单总额]，精确到小数点后2位,单位元
  map.put("p4_refund_amount", refundAmount);
  //必选/可选商户端订单号
  //p2_out_trade_no和p5_mer_order_no、p3_trade_no三个必须传一个，优先级：p2_out_trade_no>p5_mer_order_no>p3_trade_no
  //map.put("p5_mer_order_no","");
  //必选订单所属商家的密码（32位md5加密串）
  map.put("p6_pwd", pwd);
  //p7_refund_reason退款原因
  map.put("p7_refund_reason", refundReason);
  /**
   * (不是所有通道都支持分帐，具体咨询客服，分帐帐户一定要正确!!!!)
   * 2）分帐订单退款规则口串
   * [{
   * 	"splitBillAccount": "123@qq.com", //分帐帐户，为商户进件的邮箱
   * 	"refundAmount": 0.01 //退款额，最多保留两位小数，单位元
   * }, {
   * 	"splitBillAccount": "12345@qq.com",
   * 	"refundAmount ": 0.01
   * }]
   */
//  map.put("p8_ruleJson",);
//  hmac	必选	string		加密校验串
  return md5Str(map, apiKey);
 }

 /**
  * 3.8	订单退款查询接口(某些支付通道查询不支持退款查询，具体以接口返回为准)
  * @param account
  * @param outTradeNo
  * @param apiKey
  * @return
  *请求地址：http://localhost:602/api/ApiHandler.ashx?
  *     p0_Cmd=RefundQuery&p1_Account=406576729@qq.com&
  *     p2_out_trade_no=A20150609184952785188375&p3_out_refund_no=&hmac=xxxs
  * HTTP请求方式：GET
  * return结果
  * {
  *     "result": "100",
  *     "data": {
  *         "result_code": "SUCCESS",
  *         "detail_error_code": "",
  *         "detail_error_des": "",
  *         "trade_no": "2015060921001004490040449739",
  *         "out_trade_no": "A20150609184952785188375",
  *         "refund_amount": "0.01",
  *         "refund_fee": "0.01",
  *         "out_refund_no": "12430479022015060921130380",
  *         "plat": "1"
  *     }
  * }
  */
 public static String refundQuery(String account,String outTradeNo,String apiKey) {
  Map<String, Object> map = new LinkedHashMap<>();
  //必选固定值：RefundQuery（大小写敏感）
  map.put("p0_Cmd", "RefundQuery");
  //必选商户账号
  map.put("p1_Account", account);
  //必选 本系统内部订单号A开头的那个
  map.put("p2_out_trade_no", outTradeNo);
  //可选 退款流水号，如为空则查询本笔订单最后一次退款的请求，否则查询本字段指定的退款请求
  //  map.put("p3_out_refund_no",outTradeNo);
  //  hmac	必选	string		加密校验串
  return md5Str(map, apiKey);
 }

 /**
  * 3.9	创建和修改、删除固定二维码
  * 请求地址范例：
  *    http://apihost/api/ApiHandler.ashx?
  *      p0_Cmd=DoQrcode&p1_Account=406576729@qq.com&p2_pwd=82EB874528F725BE9714847E30898DCC&p3_Act=Update&
  *      p4_QrcodeType=1&p5_Discount=1.9&p6_ImgSize=5&p7_bShowMerName=1&p8_operator_id=a&
  *      p9_NoticeMobile=15859369160&p10_QrcodeSn=BBN286L60&p11_QrcodeTitle=测试二维码&hmac=xx
  * @param account
  * @param pwd
  * @param oper
  * @param qrCodeType
  * @param discount
  * @param toPhone
  * @param qrCodeSn
  * @param apiKey
  * @return
  * {
  *     "result": "100",
  *     "data": {
  *         "detail_error_code": "",
  *         "detail_error_des": "",
  *         "sn": "BBN286L60",
  *         "ImgUrl": "a.xfpay.cn/Qrcode/20/BBN286L60.jpg"
  *     }
  * }
  */
 public static String doQrCode(String account,String pwd,String oper,int qrCodeType,
                              BigDecimal discount,String toPhone,
                              String qrCodeSn,String qrcodeTitle,String apiKey) {
  Map<String, Object> map = new LinkedHashMap<>();
  //必选固定值：DoQrcode（大小写敏感）
  map.put("p0_Cmd", "DoQrcode");
  //必选 商户账号
  map.put("p1_Account", account);
  //必选商家密码（md5加密）
  map.put("p2_pwd", pwd);
/**
 * 创建:Add
 * 修改:Update
 * 删除:Del
 */
  map.put("P3_Act", oper);
/**
 * 可选
 * 固定金额：0
 * 手输金额：1
 * 默认手输金额1
 */
  map.put("p4_QrcodeType", qrCodeType);
  //可选	p4_QrcodeType为固定金额时，需传入固定金额值
  map.put("P5_Discount", discount);
// P6_ImgSize	可选	int	取值范围1-10,越大生成的二维码图像越大,默认5
// p7_bShowMerName	可选	int	是否显示商户名称，0不显示，1显示,默认1显示
// p8_Operator_id	可选	String	交易查看员工帐号(登录名)
//可选		交易通知手机号
  map.put("p9_NoticeMobile", toPhone);
  if ("Update".equals(oper) || "Del".equals(oper)) {
   //可选 当P3_Act为Update和Del时，请传入要操作的的二维码序号
   map.put("p10_QrcodeSn", qrCodeSn);
  }
  // 	可选	String	固定二维码项目名称
  map.put("p11_QrcodeTitle", qrcodeTitle);
// hmac	必选	string	加密校验串
  return md5Str(map, apiKey);
 }

 /**
  * 3.13	现金支付
  * 请求地址范例：
  *  ApiHandler.ashx? p0_Cmd=CashPay&p1_Account=406576729%40qq.com&
  *      p2_Amt=11.00&p4_operator_id=10002&p5_operator_name=%e5%bc%a0%e4%b8%89&p6_pwd=XXX&p7_Channel=1&hmac=xxxx
  * @param account
  * @param pwd
  * @param amt
  * @param subject
  * @param channel
  * @param apiKey
  * @return
  *{
  *     "result": "100",
  *     "data": {
  *         "result_code": "SUCCESS",
  *         "detail_error_code": "SUCESS",
  *         "detail_error_des": "现金交易成功",
  *         "out_trade_no": "C60704123921714160002415",
  *         "total_fee": "11.00",
  *         "subject": "",
  *         "plat": "0"
  *     }
  * }
  *
  */
 public static String cashPay(String account,
                             String pwd,
                             BigDecimal amt,
                             String subject,
                             int channel,
                             String apiKey) {
 Map<String, Object> map = new LinkedHashMap<>();
 //必选 固定值：（大小写敏感）
 map.put("p0_Cmd", "CashPay");
 //必选 商户账号(PC端)
 map.put("p1_Account", account);
 //必选 该笔订单的资金总额，取值范围[0.01,100000000]，精确到小数点后2位，单位：元
 map.put("p2_Amt", amt);
 //必选 商品的标题/交易标题/订单标题/订单关键字等。 (如为空系统会自动用业务类型代替)
 map.put("p3_Subject", subject);
// p4_operator_id	可选	String	28	商户的操作员ID,一般为收银员工号
// p5_operator_name	可选	String	28	商户的操作员姓名,一般为收银员工姓名
 //必选商家密码（md5加密）
 map.put("p6_pwd", pwd);
 /**
  * 可选
  * 1为PC端收银，
  * 2为手机端收银,
  * 3为POS端收银，
  * 4为固定二维码交易，
  * 5为线上端(第三方合作方)收银，
  * 6 民生商户APP，
  * 7微信小程序，
  * 8扫脸设备
  * 9支付宝小程序。默认1
  */
 map.put("p7_Channel", channel);
// hmac	必选	string		加密校验串
 return md5Str(map, apiKey);
}








 public static String autoGenericCode(String code, int num) {
  String result = "";
  // 保留num的位数
  // 0 代表前面补充0
  // num 代表长度为4
  // d 代表参数为正数型
  result = String.format("%0" + num + "d", Integer.parseInt(code));

  return result;
 }

 private static String md5Str(Map<String,Object> sp, String key) {
  StringBuilder str = new StringBuilder();
  for (Map.Entry<String, Object> jstr : sp.entrySet()) {
   str.append(jstr.getKey());
   str.append("=");
   str.append(jstr.getValue());
   str.append("&");
  }
//  str.append("key=");
//  str.append(key);
  String md5 = upppercaseMd5(str.toString()+"key="+key);
  str.append("hmac=");
  str.append(md5);

  return str.toString();
 }


 private static String getTimeStr(String time) {
  String regEx = "[^0-9]";
  Pattern p = Pattern.compile(regEx);
  Matcher m = p.matcher(time);
  return m.replaceAll("").trim();
 }

 private static String replaceStr(String str) {
  Pattern pattern = Pattern.compile("^,+|&+$");
  Matcher matcher = pattern.matcher(str);
  return matcher.replaceAll("");
 }

 /**
  * 大写MD5加密
  *
  * @param str
  * @return
  */
 private static String upppercaseMd5(String str) {
  byte[] digest = null;
  try {
   MessageDigest md5 = MessageDigest.getInstance("MD5");
   digest = md5.digest(str.getBytes("utf-8"));
  } catch (NoSuchAlgorithmException e) {
   log.error(e.getMessage());
  } catch (UnsupportedEncodingException e) {
   log.error(e.getMessage());
  }
  //16是表示转换为16进制数
  String md5Str = new BigInteger(1, digest).toString(16);
  return md5Str.toUpperCase();
 }
// public static void main(String[] args) {
//  Map<String,Object> map=new HashMap<>();
//  map.put("cmd","login");
//  map.put("p1","v1");
//  map.put("p2","v2");
//  map.put("p3","v3");
//  map.put("p4","v4");
//  map.put("p5","v5");
//  System.out.println(replaceStr(md5Str(map)));
//  System.out.println(upppercaseMd5(replaceStr(md5Str(map))));
//  String a="2019/02/03-2039/02/03";
// String time1=a.substring(0,a.lastIndexOf('-'));
//  System.out.println(time1);
//  System.out.println(getTimeStr(time1));
//  String time2=a.substring(a.lastIndexOf('-',a.length())+1);
//  System.out.println(time2);
//  System.out.println(getTimeStr(time2));
// }
}
