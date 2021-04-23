package com.doulin;

import com.doulin.common.Base64Utils;
import com.doulin.common.encrymlbgo.AESUtils;
import com.doulin.common.encrymlbgo.HttpEncryptUtil;
import com.doulin.common.encrymlbgo.KeyUtil;
import com.doulin.common.util.PropertiesLoader;
import com.sun.glass.ui.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestHttpEncrypt {
	
	private static PropertiesLoader loader = new PropertiesLoader("/properties/client.properties");
//	@Test
//	public void testGenerateKeyPair() throws Exception{
//		//生成RSA公钥和私钥，并Base64编码
//		KeyPair keyPair = RSAUtils.getKeyPair();
//		String publicKeyStr = RSAUtils.getPublicKey(keyPair);
//		String privateKeyStr = RSAUtils.getPrivateKey(keyPair);
////		System.out.println("RSA公钥Base64编码:" + publicKeyStr);
////		System.out.println("RSA私钥Base64编码:" + privateKeyStr);
//	}

	//测试  APP加密请求内容,服务器解密
	@Test
	public void testAppEncrypt() throws Exception{
		//请求的实际内容
//		String content = "{\"tenantid\":\"1\", \"account\":\"13015929018\", \"pwd\":\"123456\"}";
		String content = "{\"codeType\": \"6\", \"phone\": \"15638836857\"}";
		String result = HttpEncryptUtil.appEncrypt(content);
		System.out.println("APPEncryptpostsss请求原文:"+content);
		System.out.println("APPEncryptpost请求加密:"+result);
		System.out.println("ServerEncrypt服务器解密:"+HttpEncryptUtil.serverDecrypt(result));
	}

	//测试 服务器加密响应给APP的内容，APP解密
	@Test
	public void testserverEncrypt() throws Exception{
		String aesKeyStr = KeyUtil.AES_KEY;
		String content = "{\"retcode\":\"200\"}";
//		System.out.println("ServerEncryptsss:"+content);
//		System.out.println("ServerEncrypt:"+HttpEncryptUtil.serverEncrypt(aesKeyStr, content));
//		System.out.println("AppDecrypt:"+HttpEncryptUtil.appDecrypt(aesKeyStr, "{\"ct\" : \"OuwmqqAj/D3Vvr8GY6hRCurRfYdi9jM+NQiq3fbk1AU40vjSyvaZgepYUpbZm2gKLO9J0z0xTeqXvtelxad7hxSbEJzbc/vMgEMs8chb5Yt4sLtD87SLDiFPalKVpaUP/2pGJYGQONddBswai4isdGUnoNLzNQEX7RRv335Capk=\"}"));
		System.out.println("AppDecrypt:"+HttpEncryptUtil.appDecrypt(aesKeyStr, "{\"ct\":\"DosTsjjJ7OMrYJdY/E126qQ2Ai72sRhekSzn168i0Bw97pLYl9p8C/23LxlGxIi4gLCvJfhPrcO5B+olKRhM7y9p6lbQtBGTwWCTJWptQU7xNzo6XY3IZxTCHSuMYcXX\"}"));
		System.out.println(Base64Utils.byte2Base64(AESUtils.encryptAES(
				"55.50".getBytes(), 
				AESUtils.loadKeyAES(KeyUtil.AES_KEY), 
				AESUtils.loadIvAES(KeyUtil.AES_KEY))));
	}
}
