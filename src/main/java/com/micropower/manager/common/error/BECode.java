/**
 * Copyright 2016-2017 com.changeshz.nursing
 * All rights reserved.
 * 
 * @project
 * @author li.hui
 * @version 1.0
 * @date 2016-11-18
 */
package com.micropower.manager.common.error;

import com.lycheeframework.core.cmp.api.error.IECode;
import com.lycheeframework.core.common.util.StringUtil;
import com.lycheeframework.core.cmp.api.annotation.Error;

/**
 * 
 * @author li.hui
 *
 */
public enum BECode implements IECode {
	
	/**
	 * 账户
	 */
	@Error(message="登陆参数不正确！")
	user_100000(100000), 
	@Error(message="账号密码不正确！")
	user_100001(100001), 
	@Error(message="账号不能为空！")
	user_100002(100002), 
	@Error(message="密码不能为空！")
	user_100003(100003), 
	@Error(message="昵称不能为空！")
	user_100004(100004), 
	@Error(message="账号已经被注册，请更改后重试！")
	user_100005(100005), 
	
	@Error(message="资金流水记录不存在！")
	capital_403001(402001),
	@Error(message="资金账户不存在！")
	capital_403002(402002),
	@Error(message="资金账户不足！")
	capital_403003(402003),
	
	
	@Error(message="商品编码不正确，请确认后再提交！")
	ware_803001(802001),
	@Error(message="寄货单不存在！")
	ware_803002(802002),
	@Error(message="修改库存失败！")
	ware_803003(802003),
	@Error(message="寄货单状态不正确！")
	ware_803004(802004),
	@Error(message="移货单不存在！")
	ware_803005(802005),
	
	
	/**
	 * 全局
	 */
	@Error(message="手机格式不正确！")
	global_900000(900000), 
	@Error(message="传入的参数为空！")
	global_900001(900001), 
	@Error(message="上传失败！")
	global_900002(900002),
	@Error(message="获取图片地址失败！")
	global_900003(900003), 
	@Error(message="数据不存在！")
	global_900004(900004), 
	@Error(message="数据转换错误！")
	global_900005(900005), 
	@Error(message="省市区不存在！")
	global_900006(900006),
	@Error(message="备注长度过长！")
	global_900007(900007),
	@Error(message="请先登录")
	global_900008(900008),
	@Error(message="该图片地址路径不正确！")
	global_900009(900009),
	@Error(message="系统错误！")
	global_900010(900010), 
	@Error(message="删除失败！")
	global_900011(900011),
	@Error(message="图片文件不存在！")
	global_900012(900012);
	
	private int code;
	
	BECode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		
		return code;
	}
	
	private String getName() {
		
		return this.name();
	}
	
	public String getMessage() {
		Error error = null;
		try {
			error = this.getClass().getField(getName()).getAnnotation(Error.class);
		} catch (Exception e) {
			
			return null;
		}
		
		return error.message();
	}
	
	@Override
	public String toString() {
		String message = this.getMessage();

		return String.valueOf(this.getCode()).concat(SPLIT_CHAR).concat((StringUtil.isBlank(message)?"":message));
	}

	public String toDynamicString(Object... parameters) {
		
		return String.format(this.toString(), parameters);
	}
}