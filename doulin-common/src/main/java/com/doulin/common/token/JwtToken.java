package com.doulin.common.token;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.doulin.common.Base64Utils;
import com.doulin.common.encrymlbgo.AESUtils;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.TUser;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.doulin.common.token.JwtTokenGet.getOldPw;

/**
 * APP登录Token的生成和解析
 */
@Slf4j
public class JwtToken {

	/** token秘钥，请勿泄露，请勿随便修改 */
	public static final String SECRET = "A6TCkFkU3K83OtiQxrgUUQ==";
	/** token 过期时间: 10天 */
	public static final int calendarField = Calendar.DATE;
	public static final int calendarInterval = 90;
	public static final String DEFAULT_KEYNAME_ALG = "alg";
	public static final String DEFAULT_KEYVALUE_ALG = "HS256";
	public static final String DEFAULT_KEYNAME_TYPE = "type";
	public static final String DEFAULT_KEYVALUE_TYPE = "JWT";
	public static final String DEFAULT_ISSUER = "DoulinService";
	public static final String DEFAULT_AUDIENCE = "APP";
	public static final String DEFAULT_KEYNAME_PHONE_ID = "puid";
	public static final String DEFAULT_KEYNAME_USER_PW = "pw";
	public static final String DEFAULT_KEYNAME_USER_ID = "sub";
	public static final String DEFAULT_FAIL_MSG = "token已失效";
	/**
	 * 根据Token获取user_id
	 * @param token
	 * @return user_id
	 */
	public static String getAppUID(String token) throws Exception {
		Map<String, Claim> claims = verifyToken(token);
		Claim user_id_claim = claims.get(DEFAULT_KEYNAME_USER_ID);
		if (null == user_id_claim || StrUtil.isEmpty(user_id_claim.asString())) {
			return DEFAULT_FAIL_MSG;
			// token 校验失败, 抛出Token验证非法异常
		}
		return decrypt(user_id_claim.asString());
	}
	/**
	 * 解密Token
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Claim> verifyToken(String token) {
		DecodedJWT jwt = null;
		try {
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
			jwt = verifier.verify(token);
		} catch (Exception e) {
			Map failMap = Maps.newHashMap();
			failMap.put("failMsg", DEFAULT_FAIL_MSG);
			return failMap;
		}
		return jwt.getClaims();
	}
	/**
	 * 创建TOKEN
	 * @param request
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static String createToken(HttpServletRequest request, TShopHomeBaseInfo user) throws Exception {
		Date iatDate = new Date();
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(calendarField, calendarInterval);
		Date expiresDate = nowTime.getTime();
		Map<String, Object> map = new HashMap<>();
		map.put(DEFAULT_KEYNAME_ALG, DEFAULT_KEYVALUE_ALG);
		map.put(DEFAULT_KEYNAME_TYPE, DEFAULT_KEYVALUE_TYPE);
		String token = JWT.create().withHeader(map) //header
				.withIssuer(DEFAULT_ISSUER) //签发者
				.withAudience(DEFAULT_AUDIENCE)//接收方
				.withSubject(encrypt(user.getId().toString()))//面向的用户
				.withClaim(DEFAULT_KEYNAME_USER_PW, user.getPassword()==null?"":encrypt(user.getPassword()))
				.withClaim(DEFAULT_KEYNAME_PHONE_ID, encrypt(request.getHeader(DEFAULT_KEYNAME_PHONE_ID)))
//				.withJWTId(J2Cache.getChannel());
				.withIssuedAt(iatDate) //签发时间
				.withExpiresAt(expiresDate) //过期时间
				.sign(Algorithm.HMAC256(SECRET)); // signature
		return token;
	}
	public static String createToken(TUser user) throws Exception {
		Date iatDate = new Date();
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(calendarField, calendarInterval);
		Date expiresDate = nowTime.getTime();
		Map<String, Object> map = new HashMap<>();
		map.put(DEFAULT_KEYNAME_ALG, DEFAULT_KEYVALUE_ALG);
		map.put(DEFAULT_KEYNAME_TYPE, DEFAULT_KEYVALUE_TYPE);
		String token = JWT.create().withHeader(map) //header
				.withIssuer(DEFAULT_ISSUER) //签发者
				.withAudience(DEFAULT_AUDIENCE)//接收方
				.withSubject(user.getId().toString())//面向的用户
				.withClaim(DEFAULT_KEYNAME_USER_PW, user.getPassword()==null?"":user.getPassword())
				.withClaim(DEFAULT_KEYNAME_PHONE_ID, "1111")
//				.withJWTId(J2Cache.getChannel());
				.withIssuedAt(iatDate) //签发时间
				.withExpiresAt(expiresDate) //过期时间
				.sign(Algorithm.HMAC256(SECRET)); // signature
		return token;
	}
	//加密
	public  static String encrypt(String ss){
		try {
			if(null!=ss && !"".equals(ss)){
				SecretKey aesKey = AESUtils.loadKeyAES(SECRET.substring(0, 16));
				IvParameterSpec ivAes = AESUtils.loadIvAES(SECRET.substring(0, 16));
				return new String(Base64Utils.byte2Base64(AESUtils.encryptAES(ss.getBytes(), aesKey, ivAes)));
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return "";
	}

	/**
	 * 解密
	 * @param ss
	 * @return
	 */
	public static String decrypt(String ss){
		try {
			SecretKey aesKey = AESUtils.loadKeyAES(SECRET.substring(0, 16));
			IvParameterSpec ivAes = AESUtils.loadIvAES(SECRET.substring(0, 16));
			return new String(AESUtils.decryptAES(Base64Utils.base642Byte(ss), aesKey, ivAes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 验证Token
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static boolean validateToken(String token,String passWord) {
		try {
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
			verifier.verify(token);
			String uid = getAppUID(token);
			String pw =passWord;
			if (!pw.equals(getOldPw(token))) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

//	public static void main(String[] args) throws Exception {
//		Tuser user = new Tuser();
//		user.setId("00228c2f6b6a445db7bfdd5f1e6f0251");
//		String token = createToken(user);
//		getToken("eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYiLCJ0eXAiOiJKV1QifQ.eyJhdWQiOiJBUFAiLCJzdWIiOiI1OGE0OTEyMGUxNzI0ZjUyODYwMWI4MTg1ZDk2MjY3ZiIsInB1aWQiOiIxMzc3MUU0MC03OEJDLTQ2MEUtOUI4NC05Mzg3Nzc4MEU4NjUiLCJwdyI6IiIsImlzcyI6IkRvdWxpblNlcnZpY2UiLCJleHAiOjE1NDk0NDQ1NjcsImlhdCI6MTU0ODU4MDU2N30.gv95l2SnEqywciz8Fl-uMrFw71GTMSzH4vYZbFtwOwY");
//		if(!validateToken(token)){
//			System.out.println(DEFAULT_FAIL_MSG);
//		}else{
//			System.out.println(token);
//			System.out.println(getAppUID(token));
//			System.out.println(getOldPw(token));
//		}
//		System.out.println(encrypt("aaasdfasdf"));
//		System.out.println(decrypt(encrypt("aaasdfasdf")));
//	}
}
