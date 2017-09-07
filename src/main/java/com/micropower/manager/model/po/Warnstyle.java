/**
 * Copyright 2014-2017 com.lycheeframework.mapping
 * All rights reserved.
 * 
 * @project
 * @author niushuaike
 * @version 1.0
 * @date 2017-09-07
 */
package com.micropower.manager.model.po;


import com.lycheeframework.core.model.IPO;

/**
 * 告警类型
 * @author niushuaike
 *
 */
public class Warnstyle implements IPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *  主键 id
	 */
	private Integer id;

	/**
	 * 告警名称
	 */
	private String warnstylename;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWarnstylename() {
		return warnstylename;
	}
	
	public void setWarnstylename(String warnstylename) {
		this.warnstylename = warnstylename;
	}
}