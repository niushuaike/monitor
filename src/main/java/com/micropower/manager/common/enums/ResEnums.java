/**
 * Copyright 2016-2017 com.nanf.cross.api
 * All rights reserved.
 * 
 * @project
 * @author jackey
 * @version 1.0
 * @date 2016年11月25日
 */
package com.micropower.manager.common.enums;

public enum ResEnums {
	
	_RES_ART("工艺","GOODS_ART","5"),
	_RES_USAGE("用途","GOODS_USAGE","3"),
	_RES_COLOR("颜色","GOODS_COLOR","4"),
	_RES_STYLE("风格","GOODS_STYLE","2"),
	_RES_CATEGORY("分类","GOODS_CATEGORY","1"),
	_RES_MATERIA("材料","GOODS_MATERIA","6");

	private String name;
	
	private String key;
	
	private String type;
	
	ResEnums(String name,String key,String type){
		this.name = name;
		this.key = key;
		this.type = type;
	}
	
	public String getName(){
		
		return name;
	}
	
	public String getType(){
		
		return type;
	}
	
	public String getKey(){
		
		return key;
	}
}
