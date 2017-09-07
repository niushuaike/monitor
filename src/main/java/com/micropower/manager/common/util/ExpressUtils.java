/**
 * Copyright 2016-2017 com.nanf.cross.api
 * All rights reserved.
 * 
 * @project
 * @author jackey
 * @version 1.0
 * @date 2016年11月25日
 */
package com.micropower.manager.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressUtils extends com.lycheeframework.core.common.util.ExpressUtil {

	/**
	 * 校验邮箱格式
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(email);
		
		return matcher.matches();
	}

	/**
	 * 验证手机号码
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean checkMobileNumber(String mobileNumber) {
		Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
		Matcher matcher = regex.matcher(mobileNumber);
		
		return matcher.matches();
	}
}
