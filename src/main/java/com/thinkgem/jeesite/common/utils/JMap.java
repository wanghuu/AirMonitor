package com.thinkgem.jeesite.common.utils;

import java.util.HashMap;
import java.util.Map;

import com.thinkgem.jeesite.common.mapper.JsonMapper;

/**
 * JMap ---> JFinal Map 
 * 参数或者返回值封装，常用于业务层传参与返回值
 * 
 * Example：
 * 1：JMap para = JMap.create("id", 123);
 *    User user = user.findFirst(getSqlPara("find", para));
 * 
 * 2：return JMap.fail("msg", "用户名或密码错误");	// 登录失败返回
 *   return JMap.ok("loginUser", user);			// 登录成功返回
 * 
 * 3：JMap map = loginService.login(...);
 *   renderJson(map);
 */
@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class JMap extends HashMap {

	private static final String STATUS_OK = "isOk";
	private static final String STATUS_FAIL = "isFail";
	
	public JMap() {
	}
	
	public static JMap ok() {
		return new JMap().setOk();
	}
	
	public static JMap ok(Object key, Object value) {
		return ok().set(key, value);
	}
	
	public static JMap fail() {
		return new JMap().setFail();
	}
	
	public static JMap fail(Object key, Object value) {
		return fail().set(key, value);
	}
	
	public static JMap create() {
		return new JMap();
	}
	
	public static JMap create(Object key, Object value) {
		return new JMap().set(key, value);
	}
	
	public JMap setOk() {
		super.put(STATUS_OK, Boolean.TRUE);
		super.put(STATUS_FAIL, Boolean.FALSE);
		return this;
	}
	
	public JMap setFail() {
		super.put(STATUS_OK, Boolean.FALSE);
		super.put(STATUS_FAIL, Boolean.TRUE);
		return this;
	}
	
	public boolean isOk() {
		Boolean isOk = (Boolean)get(STATUS_OK);
		return isOk != null && isOk;
	}
	
	public boolean isFail() {
		Boolean isFail = (Boolean)get(STATUS_FAIL);
		return isFail != null && isFail;
	}
	
	public JMap set(Object key, Object value) {
		super.put(key, value);
		return this;
	}
	
	public JMap set(Map map) {
		super.putAll(map);
		return this;
	}
	
	public JMap set(JMap jMap) {
		super.putAll(jMap);
		return this;
	}
	
	public JMap delete(Object key) {
		super.remove(key);
		return this;
	}
	
	public <T> T getAs(Object key) {
		return (T)get(key);
	}
	
	public String getStr(Object key) {
		return (String)get(key);
	}

	public Integer getInt(Object key) {
		return (Integer)get(key);
	}

	public Long getLong(Object key) {
		return (Long)get(key);
	}

	public Boolean getBoolean(Object key) {
		return (Boolean)get(key);
	}
	
	/**
	 * key 存在，并且 value 不为 null
	 */
	public boolean notNull(Object key) {
		return get(key) != null;
	}
	
	/**
	 * key 不存在，或者 key 存在但 value 为null
	 */
	public boolean isNull(Object key) {
		return get(key) == null;
	}
	
	/**
	 * key 存在，并且 value 为 true，则返回 true
	 */
	public boolean isTrue(Object key) {
		Object value = get(key);
		return (value instanceof Boolean && ((Boolean)value == true));
	}
	
	/**
	 * key 存在，并且 value 为 false，则返回 true
	 */
	public boolean isFalse(Object key) {
		Object value = get(key);
		return (value instanceof Boolean && ((Boolean)value == false));
	}
	
	public String toJson() {
		return JsonMapper.toJsonString(this);
	}
	
	public boolean equals(Object jMap) {
		return jMap instanceof JMap && super.equals(jMap);
	}
}


