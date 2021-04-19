package com.doulin.common.encrymlbgo;

import com.doulin.common.Base64Utils;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * AES加密工具类
 * 
 * @author Administrator
 *
 */
@Slf4j
public class AESUtils {

	// public static final String IV = "0807060504030201";

	// 生成AES秘钥，然后Base64编码
	public static String genKeyAES(String strKey) throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(new SecureRandom(strKey.getBytes()));
		SecretKey key = keyGen.generateKey();
		String base64Str = Base64Utils.byte2Base64(key.getEncoded());
		return base64Str;
	}
	// 生成AES秘钥，然后Base64编码
	public static String genKeyAES() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey key = keyGen.generateKey();
		String base64Str = Base64Utils.byte2Base64(key.getEncoded());
		return base64Str;
	}

	// 将Base64编码后的AES秘钥转换成SecretKey对象
	public static SecretKey loadKeyAES(String base64Key) throws Exception {
//		byte[] bytes = Base64Utils.base642Byte(base64Key);
//		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
//		keyGen.init(new SecureRandom(base64Key.getBytes()));
//		SecretKey key = keyGen.generateKey();
//		byte[] key = asBin(base64Key);
//		byte[] enCodeFormat = base64Key.getBytes();
//      SecretKeySpec key = new SecretKeySpec(enCodeFormat, AES);
		SecretKeySpec key = new SecretKeySpec(base64Key.getBytes(), "AES");
//		SecretKeySpec key = new SecretKeySpec(bytes, "AES");
		return key;
	}
	// 将Base64编码后的AES秘钥转换成SecretKey对象
	public static IvParameterSpec loadIvAES(String base64Key) throws Exception {
		byte[] initParam = base64Key.getBytes();
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
		return ivParameterSpec;
	}

	// 加密
	public static byte[] encryptAES(byte[] source, SecretKey key,IvParameterSpec ivAes) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key,ivAes);
		return cipher.doFinal(source);
	}

	// 解密
	public static byte[] decryptAES(byte[] source, SecretKey key,IvParameterSpec ivAes) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key,ivAes);
		return cipher.doFinal(source);
	}
}
