package com.doulin.entity.shop;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.doulin.entity.TShopHomeBaseInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
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
@Data
@Slf4j
public class ShopImport implements Serializable {
 private String p0_cmd = "Mchinlet";//	固定值：Mchinlet（大小写敏感）
 private String p1_plat_id;//合作方ID (由平台分配)
 private String p2_mch_id;//	是	商户号 (需为手机号格式)
 private String p3_mch_name;//	商户名称
 private String p4_mch_name_short;//	否		商户简称
 private String p5_province;//省份，如 福建。
 private String p6_city;    //城市，如 福州
 /**
  * 区/县，如 鼓楼区  注：特区如：北京市东城区，请按以下传：
  * p5_province=北京
  * p6_city=北京
  * p7_district=东城区
  */
 private String p7_district;

 private String p8_address;//联系地址
 private String p9_mobile;//	联系手机
 private String p10_email;//	邮箱 否
 private String p11_service_phone;//	否		服务电话
 private String p12_contact_man;//	是/否	联系人姓名
 private String p13_id_card_no;//	是/否    联系人身份证号
 /**
  * 营业执照注册号（商户类型为个体、企业必填)
  */
 private String p14_license_num;
 /**
  * 营业执照经营范围（个体、企业必填)
  */
 private String p15_license_scope;//
 /**
  * 是/否 营业执照有效期开始日期，如20150130（商户类型为个体、企业必填)
  */
 private String p16_license_start_date;//
 /**
  * 营业执照有效期结束日期，如20150130,长期有效的请输入: 长期有效（商户类型为个体、企业必填)
  */
 private String p17_license_end_date;//	是/否
 /**
  * 商户营业执照类型，三选一,
  * 0:营业执照,
  * 1:营业执（多证合一)，
  * 2:事业单位法人证书
  * （商户类型为个体、企业必填)
  */
 private int p18_license_type;//是/否
 /**
  * 经营类目字典下载：http://a.xfpay.cn/model/经营类目-数据字典.xls
  */
 private String p19_category_no;//	经营类目编号
 /**
  * 行业类别字典下载：http://a.xfpay.cn/model/行业类别-数据字典.xls
  */
 private String p20_industry_no;//	否	行业类别编号

 private String p21_wechatno;//否 	微信号（用来验证用的）
 /**
  * Add:添加商户
  * Update:更新商户
  * （大小写敏感)
  */
 private String p22_act;//	是	添加还是更新

 /**
  * 联行号数据字典下载：
  * http://a.xfpay.cn/model/联行号-数据字典.zip
  */
 private String p23_bank_no;//是/否	结算银行卡联行号
 /**
  * 1:对公
  * 2:对私
  */
 private int p24_bank_type = 2;//	是/否	结算银行卡类型

 private String p25_bank_account;//	是/否		结算卡卡号
 private String p26_bank_owner;//	是/否		银结算行卡开户人姓名
 private String p27_bank_idcard;//	是/否	String(15、18）	结算银行卡开户人身份证号
 private String p28_bank_mobile;//	是/否	String(11)	结算银行卡预留手机号
 /**
  * 1:个人
  * 2:个体
  * 3:企业
  * 4:事业
  */
 private int p29_mch_type;//	是/否	int	商户类型

 /**
  * 该商户绑定给的员工帐号，如为空则默认绑定给该渠道商默认的用户。
  * (有些渠道商因业务原因会限制绑定用户，具体咨询客服）
  */
 private String p30_username;//	是/否	String(20)
 /**
  * 如果为空，则添加模式下为默认密码;修改模式下不修改原有密码。
  */
 private String p31_pwd;//	否		商家密码(md5加密,大写)
 /**
  * 开关配置,共有下面6项：
  * 1.交易结果通知商户微信
  * 2.交易结果通知消费(公众号交易)
  * 3.启用云打印
  * 4.启用云喇叭
  * 5.启用APP语音播报
  * 6.启用短信通知
  * 某项要开启用1表示，关闭用0表示，(修改模式下当某项不改则用2表示）最后按顺序组成字符串，每项之间用小写逗号隔开。如：
  * 1,1,0,0,1,0
  */
 private String p32_config;//	否	String(11)

 /**
  * 法人身份证有效期开始日期，如20150130
  */
 private String p33_id_card_start_date;//	是/否	String(8)
 /**
  * 法人身份证有效期结束日期，如20350130.  长期有效传：长期有效
  */
 private String p34_id_card_end_date;//	是/否	String(8)
 /**
  * 是否允许商家在网页端发起结算申请 ：
  * 0：不允许
  * 1：允许
  * 默认：0
  */
 private int p35_settleLimit;//是/否	Int
 /**
  * 微信行业类别编号
  * 微信行业类别字典下载：http://a.xfpay.cn/model/微信行业类别-数据字典.xls
  */
 private String p38_industry_no_weixin;//	否	String(15)
 /**
  * 法人姓名(如为空，将用p12_contact_man代替)
  */
 private String p39_legal_man;//否	String(2,4)
 /**
  * 法人身份证号(如为空，将用p13_id_card_no代替)
  */
 private String p40_legal_man_id_card_no;//	否	String(15、18)
 /**
  * 1：实体特约商户,
  * 2：网络特约商户,
  * 3：实体兼网络特约商户
  */
 private int p41_BusinessType;//	否	Int	商户经营类型
 private String nonceStr;//	是	String(32)	随机字符串
 private String hmac;//	是	String(32)	加密校验串

 /**
  * 添加或修改参数
  * @param thbif
  * @param oper  Add OrUpdate
  * @param cmd
  * @return
  */
 public static String getParamAddOrUpdate(TShopHomeBaseInfo thbif, String cmd, String oper) {
  ShopImport sp = new ShopImport();
  sp.setP0_cmd(cmd);
  sp.setP1_plat_id(thbif.getPlatId());
  sp.setP2_mch_id(thbif.getLoginNo());
  sp.setP3_mch_name(thbif.getShopHomeName());
  sp.setP4_mch_name_short(thbif.getShopHomeCode());
  sp.setP5_province(thbif.getShopProvinceName());
  sp.setP6_city(thbif.getShopCityName());
  sp.setP7_district(thbif.getShopDistrictName());
  sp.setP8_address(thbif.getShopAddress());
  sp.setP9_mobile(thbif.getTelePhone());
  sp.setP10_email(thbif.getCompanyEmail());
  sp.setP11_service_phone(thbif.getTelePhone());
  sp.setP12_contact_man(thbif.getLoginName());
//  sp.setP13_id_card_no();
  sp.setP14_license_num(thbif.getSocialCreditCode());
  sp.setP15_license_scope(thbif.getBusinessScope());
  sp.setP16_license_start_date(getTimeStr(thbif.getFoundDt()));
  String p17 = thbif.getPeriodOfValidity();
  if (!p17.contains("长期")) {
   p17 = getTimeStr(getTimeStr(p17));
  }
  sp.setP17_license_end_date(p17);
  sp.setP18_license_type(0);
//  sp.setP19_category_no();
//  sp.setP20_industry_no();
//  sp.setP21_wechatno();
  sp.setP22_act(oper);
  sp.setP23_bank_no(thbif.getLegalPersonBankCardL());
  sp.setP24_bank_type(1);
  sp.setP25_bank_account(thbif.getLegalPersonBankCard());
  sp.setP26_bank_owner(thbif.getLegalPersonCardName());
  sp.setP27_bank_idcard(thbif.getLegalPersonBankCard());
  sp.setP28_bank_mobile(thbif.getTelePhone());
  sp.setP29_mch_type(2);
  sp.setP30_username(thbif.getLoginName());
//  sp.setP31_pwd();
//  sp.setP32_config();
  String time = thbif.getLegalPersonCardTime();
  String time1 = time.substring(0, time.lastIndexOf('-'));
  sp.setP33_id_card_start_date(getTimeStr(time1));
  String time2 = time.substring(time.lastIndexOf('-', time.length()) + 1);
  sp.setP34_id_card_end_date(getTimeStr(time2));
  sp.setP35_settleLimit(0);
  sp.setP39_legal_man(thbif.getLegalPersonCardName());
  sp.setP40_legal_man_id_card_no(thbif.getLegalPersonBankCard());
  sp.setNonceStr(String.valueOf(System.currentTimeMillis()));
  JSONObject jsonObject = JSONUtil.parseObj(sp);
//   sp.setHmac();
  return md5Str(jsonObject, sp.getP2_mch_id());

 }
/**
 * 3.1.4	商户证件资料上传
  * @param thbif
  * @return
  */
 public static String getParamMchCertUpload(TShopHomeBaseInfo thbif,String http) {

  // [
  //{ "certType": "id_card","imgContent": "字节流","imgType": "jpg"," imgContentType":"0" },
  //{ "certType ": "id_f_card", "imgContent": "字节流","imgType": "png"," imgContentType":"0" },
  //{ "certType ": "business_card", "imgContent": " http://a.xfpay.cn/temp/wxxcx/d9773df44df20981.jpg ","imgType": "jpg"," imgContentType":"1" }
  //]
  //certType：证件类型代码，如下所示：（大小写敏感)
  //id_card：法人身份证正面
  //id_f_card：法人身份证反面
  //handed_idCard：法人手持身份证
  //license ：营业执照
  //mer_logo：商户Logo
  //s_business_card：特殊行业许可证
  //storefront：门头照
  //interior_1：内景照1
  //interior_2：内景照2
  //interior_3：内景照3
  //industryLicenseImg:开户许可证
  //bankCardImg银行卡照片
  //AUTHORIZATION_FOR_SETTLEMENT 结算帐户指定书
  //AUTHORIZATION_FOR_UNLEGAL 非法人结算授权函
  //HANDHELD_OF_BANK_CARD结算人手持结算卡照
  //SETTLE_FRONT_OF_ID_CARD结算人身份证正面（不传则用法人身份证正面照代替)
  //SETTLE_BACK_OF_ID_CARD结算人身份证反面（不传则用法人手持身份证反面照代替)
  //HANDHELD_OF_ID_CARD 结算人手持身份证（不传则用法人手持身份证照代替)
  //CHECKSTAND收银台照
  //AcquiringAgreementPhoto  商户受理书(承诺函)
  //imgContentType:指定图片内容类型：
  //0：字节流，采用Base64编码（默认)
  //1：图片公网url
  //imgContent：
  //imgContentType=0时为图片的字节流，采用Base64编码;
  //imgContentType=1时为图片所对应的公网url;
  //
  //注意：
  //1. 当imgContentType=0时，imgContent值因为base64过了，所以需urlencode后在发送。(但参与md5计算时是不需要urlencode)的
  //2.如同时上传多张，只要有一张不合规，则都不会上传。
  //3.每张图片大小不能超过512KB

  String[] indoorimg = thbif.getShopIndoorPhoto().split(",");
  Map<String, Object> map = new HashMap<>();
  map.put("id_card", thbif.getLegalPersonCardZ());//法人身份证正面
  map.put("id_f_card", thbif.getLegalPersonCardF());//：法人身份证反面
  map.put("handed_idCard", thbif.getLegalPersonCardP());//：法人手持身份证
  map.put("license", thbif.getBusinessLicenseImage());//：营业执照
  map.put("mer_logo", thbif.getShopLogo());//商户Logo
  map.put("storefront", thbif.getShopTitleImage());//门头照
  map.put("interior_1", indoorimg[0]);//内景照1
  map.put("interior_2", indoorimg[1]);//内景照2
  map.put("interior_3", indoorimg[2]);//内景照3
  map.put("bankCardImg", thbif.getLegalPersonBankImage());//银行卡照片
  map.put("AUTHORIZATION_FOR_SETTLEMENT", thbif.getShopSettlementBookImg());// 结算帐户指定书
  map.put("HANDHELD_OF_BANK_CARD", thbif.getLegalPersonBankHandImage());//结算人手持结算卡照
  map.put("CHECKSTAND", thbif.getAshierPhoto());//收银台照
//  map.put("s_business_card",thbif.getShopLogo());//特殊行业许可证
//  map.put("industryLicenseImg",);//开户许可证
//  map.put("AUTHORIZATION_FOR_UNLEGAL",);//非法人结算授权函
//  SETTLE_FRONT_OF_ID_CARD结算人身份证正面（不传则用法人身份证正面照代替)
//  SETTLE_BACK_OF_ID_CARD结算人身份证反面（不传则用法人手持身份证反面照代替)
//  HANDHELD_OF_ID_CARD 结算人手持身份证（不传则用法人手持身份证照代替)
//  AcquiringAgreementPhoto  商户受理书(承诺函)
  List<Map<String, Object>> content = new ArrayList<>();
  for (Map.Entry<String, Object> c : map.entrySet()) {
   Map<String, Object> mapz = new HashMap<>();
   mapz.put("certType", c.getKey());
   mapz.put("imgContent", http+c.getValue());
   mapz.put("imgType", "jpg");
   mapz.put("imgContentType", "1");
   content.add(mapz);
  }
  String p0_cmd = "MchCertUpload",//固定值：MchCertUpload（大小写敏感）
          p1_plat_id = thbif.getPlatId(),//	是	String(9)	合作方ID (由平台分配)
          p2_mch_id = thbif.getLoginNo(),//	是	string (11)	商户号
          p3_cert_content;//是	string
  p3_cert_content = JSONUtil.parseObj(content).toString();
  Map<String, Object> param = new LinkedHashMap<>();
  param.put("p0_cmd", p0_cmd);
  param.put("p1_plat_id", p1_plat_id);
  param.put("p2_mch_id", p2_mch_id);
  param.put("p3_cert_content", p3_cert_content);

  JSONObject jsonObject = JSONUtil.parseObj(param);
  return md5Str(jsonObject, thbif.getLoginNo());
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

 private static String md5Str(Object sp, String key) {
  JSONObject jsonObject = JSONUtil.parseObj(sp);
  StringBuilder str = new StringBuilder();
  for (Map.Entry<String, Object> jstr : jsonObject.entrySet()) {
   str.append(jstr.getKey());
   str.append("=");
   str.append(jstr.getValue());
   str.append("&");
  }
  str.append("key=");
  str.append(key);
  String md5 = upppercaseMd5(str.toString());
  str.append("&hmac=");
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
