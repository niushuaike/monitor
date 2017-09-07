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
 * 
 * @author niushuaike
 *
 */
public class Warntype implements IPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *  主键 id
	 */
	private Integer id;

	/**
	 * 告警类型
	 */
	private String warntypename;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWarntypename() {
		return warntypename;
	}
	
	public void setWarntypename(String warntypename) {
		this.warntypename = warntypename;
	}
}