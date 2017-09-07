/**
 * Copyright 2016-2017 com.nanf.cross.api
 * All rights reserved.
 * 
 * @project
 * @author jackey
 * @version 1.0
 * @date 2016年11月25日
 */
package com.micropower.manager.common.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.pagehelper.StringUtil;
import com.lycheeframework.core.common.cookie.CookieManager;
import com.lycheeframework.core.common.util.encrypt.MD5;
import com.lycheeframework.core.common.util.encrypt.SHA256;
import com.micropower.manager.common.enums.UserEnums;

public class UserHelper {
	
	/**
	 * 获取账号名称
	 * @return
	 */
	public static String getAccount(){
		
		return getManager().getValue(UserEnums._USER.getName(), UserEnums._USER_ACCOUNT.getName(), true);
	}
	
	/**
	 * 获取昵称
	 * @return
	 */
	public static String getNickName(){
		
		return getManager().getValue(UserEnums._USER.getName(), UserEnums._USER_NICKNAME.getName(),true);
	}

	/**
	 * 获取ID
	 * @return
	 */
	public static Integer getId(){
		String id = getManager().getValue(UserEnums._USER.getName(), UserEnums._USER_ID.getName(),true);
	
		return StringUtil.isEmpty(id) ? null : Integer.parseInt(id);
	}
	
	public static HttpServletRequest getRequest() {
		
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public static HttpServletResponse getResponse() {
		
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	private static CookieManager getManager(){
		
		return new CookieManager(getRequest());
	}
	
	
	public static void cleanAll(){
		CookieManager manager = getManager();
		manager.cleanAll(getResponse(), UserEnums._USER.getName(), true);
	}
	
	public static String getEntryPasswd(String passwd){
		passwd = SHA256.encrypt(passwd);
		
		return MD5.encryptMD5(passwd);
	}
	
	public static void main(String[] args) {
		System.out.println(getEntryPasswd("123456"));
	}
}
