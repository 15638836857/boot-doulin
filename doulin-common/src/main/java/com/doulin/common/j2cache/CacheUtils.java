/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.doulin.common.j2cache;

/**
 * Cache工具类
 * @author jeeplus
 * @version 2017-1-19
 */
public class CacheUtils {
	

	private static final String SYS_REGION = "sysCache";

	
	
	/**
	 * 获取SYS_CACHE缓存
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		return get(SYS_REGION, key);
	}
	
	/**
	 * 写入SYS_CACHE缓存
	 * @param key
	 * @return
	 */
	public static void put(String key, Object value) {
		put(SYS_REGION, key, value);
	}
	/**
	 * 写入SYS_CACHE缓存并设置过期时间
	 * @param key
	 * @return
	 */
	public static void put(String key, Object value, int expireInSec) {
		put(SYS_REGION, key, value, expireInSec);
	}
	
	/**
	 * 从SYS_CACHE缓存中移除
	 * @param key
	 * @return
	 */
	public static void remove(String key) {
		remove(SYS_REGION, key);
	}
	
	/**
	 * 获取缓存
	 * @param key
	 * @return
	 */
	public static Object get(String region, String key) {
		CacheObject object = J2Cache.getChannel().get(region ,key);
		return object==null?null:object.getValue();
	}
	/**
	 * 获取自增变量
	 * @param key
	 * @return
	 */
	public static Long incr(String region, String key, Integer expireInSec) {
		if(null == region || "".equals(region)){
			region = "userLoginFlag";
		}
		if(null == expireInSec || 0 == expireInSec){
			expireInSec = 300;
		}
		return J2Cache.getChannel().incr(region ,key,expireInSec);
	}
	/**
	 * 写入缓存
	 * @param region
	 * @param key
	 * @param value
	 */
	public static void put(String region, String key, Object value) {
		J2Cache.getChannel().set(region, key, value);
	}
	/**
	 * 写入缓存 并设置过期时间
	 * @param region
	 * @param key
	 * @param value
	 */
	public static void put(String region, String key, Object value, Integer expireInSec) {
		J2Cache.getChannel().set(region, key, value, expireInSec);
	}

	/**
	 * 从缓存中移除
	 * @param region
	 * @param key
	 */
	public static void remove(String region, String key) {
		J2Cache.getChannel().evict(region, key);
	}

	
}
