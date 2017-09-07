package com.micropower.manager.common.util;

import java.util.Date;

import com.lycheeframework.core.common.util.DateUtil;

public class DateUtils extends DateUtil{

	private final static String sdf_paypal="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	
	/**
	 * 获取PayPal查询所需的日期格式
	 * @param date
	 * @return
	 */
	public static String formatToPayPal(Date date){
		return formatDateTime(date, sdf_paypal);
	}
	
	/**
	 * 获取指定几分钟差距的时间
	 * @return
	 */
	public static Date getDiffMinDate(Date date,int min){
		
		return new Date(date.getTime()+min*1000*60);
	}
}
