/**
 * Copyright 2014-2015 www.hzchanges.com
 * All rights reserved.
 * 
 * @project
 * @author li.hui
 * @version 1.0
 * @date 2016年12月3日
 */
package com.micropower.manager.common.enums;

public enum UserEnums {
	
	_USER("user"),
	_USER_ID("userId"),
	_USER_ACCOUNT("account"),
	_USER_NICKNAME("nickName");

	private String name;
	
	UserEnums(String name){
		this.name = name;
	}
	
	public String getName(){
		
		return name;
	}
}
