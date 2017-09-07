/**
 * Project Name:backgroundManagementSystem
 * File Name:HttpGetUtil.java
 * Package Name:com.micropower.common
 * Date:Jun 12, 20166:30:34 PM
 * Copyright (c) 2016, 1173499611@qq.com All Rights Reserved.
 *
*/

package com.micropower.manager.common;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;


/**
 * ClassName:HttpGetUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     Jun 12, 2016 6:30:34 PM <br/>
 * @author   lihui
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class HttpGetUtil {
	
	public static String get(String url) {
		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod(url);
		get.getParams().setContentCharset("utf-8");
		// 发送http请求
		String replyData = null;
		try {
			client.executeMethod(get);
			replyData = get.getResponseBodyAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return replyData;

	}
	public static void main(String[] args) {
		String url;
		try {
			String s = get("http://localhost:8080/nbcqjym/userAction/getUserByOpenId.action?openId=1111");
			System.out.println(s);
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	

}

