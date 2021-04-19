package com.doulin.common.encrymlbgo;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.doulin.common.Base64Utils;
import com.doulin.common.content.SysContent;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA+AES组合工具类
 * 
 * @author Administrator
 *
 */

public class HttpEncryptUtil {
	// APP加密请求内容
	public static String appEncrypt(String content) throws Exception {
		// 将Base64编码后的Server公钥转换成PublicKey对象
		PublicKey serverPublicKey = RSAUtils.string2PublicKey(KeyUtil.SERVER_PUBLIC_KEY);
		// 每次都随机生成AES秘钥
//		String aesKeyStr = AESUtils.genKeyAES();
		SecretKey aesKey = AESUtils.loadKeyAES(KeyUtil.AES_KEY);
		IvParameterSpec ivAes = AESUtils.loadIvAES(KeyUtil.AES_KEY);
		// 用Server公钥加密AES秘钥
		byte[] encryptAesKey = RSAUtils.publicEncrypt(KeyUtil.AES_KEY.getBytes(), serverPublicKey);
		// 用AES秘钥加密请求内容
		byte[] encryptRequest = AESUtils.encryptAES(content.getBytes(), aesKey,ivAes);

		JSONObject result = new JSONObject();
		result.set("ak", Base64Utils.byte2Base64(encryptAesKey).replaceAll("\r\n", ""));
		result.set("ct", Base64Utils.byte2Base64(encryptRequest).replaceAll("\r\n", ""));
		return result.toString();
	}

	// APP解密服务器的响应内容
	public static String appDecrypt(String aesKeyStr, String content) throws Exception {
		JSONObject result = JSONUtil.parseObj(content);
		String encryptContent = (String) result.get("ct");
		// 用AES秘钥解密请求内容
		SecretKey aesKey = AESUtils.loadKeyAES(aesKeyStr);
		IvParameterSpec ivAes = AESUtils.loadIvAES(aesKeyStr);
		byte[] response = AESUtils.decryptAES(Base64Utils.base642Byte(encryptContent), aesKey, ivAes);

		return new String(response);
	}

	// 服务器加密响应给APP的内容
	public static String serverEncrypt(String aesKeyStr, String content) throws Exception {
		// 将Base64编码后的AES秘钥转换成SecretKey对象
		SecretKey aesKey = AESUtils.loadKeyAES(aesKeyStr);
		IvParameterSpec ivAes = AESUtils.loadIvAES(aesKeyStr);
		// 用AES秘钥加密响应内容
		byte[] encryptContent = AESUtils.encryptAES(content.getBytes(), aesKey, ivAes);

		JSONObject result = new JSONObject();
		result.set("ct", Base64Utils.byte2Base64(encryptContent).replaceAll("\r\n", ""));
		return result.toString();
	}

	// 服务器解密APP的请求内容
	public static Map<String,Object> serverDecrypt(String content) throws Exception {
		JSONObject result= JSONUtil.parseObj(content);
		if(!result.containsKey(SysContent.AK)||!result.containsKey(SysContent.CT)){
//			return content;
			throw new Exception(SysContent.ERROR_APP_REQUEST);
		}
		String encryptAesKeyStr = result.getStr(SysContent.AK);
		String encryptContent = result.getStr(SysContent.CT);

		// 将Base64编码后的Server私钥转换成PrivateKey对象
		PrivateKey serverPrivateKey = RSAUtils.string2PrivateKey(KeyUtil.SERVER_PRIVATE_KEY);
		// 用Server私钥解密AES秘钥
		byte[] aesKeyBytes = RSAUtils.privateDecrypt(Base64Utils.base642Byte(encryptAesKeyStr), serverPrivateKey);
		// 用AES秘钥解密APP公钥
		SecretKey aesKey = AESUtils.loadKeyAES(new String(aesKeyBytes));
		IvParameterSpec ivAes = AESUtils.loadIvAES(new String(aesKeyBytes));
		// 用AES秘钥解密请求内容
		byte[] request = AESUtils.decryptAES(Base64Utils.base642Byte(encryptContent), aesKey, ivAes);

		Map<String,Object> map=new HashMap<>();
		map.put("ak", new String(aesKeyBytes));
		map.put("ct", new String(request));
		return map;
	}
}