/**
 * Copyright 2014-2017 com.lycheeframework.mapping
 * All rights reserved.
 * 
 * @project
 * @author oliver
 * @version 1.0
 * @date 2017-09-11
 */
package com.micropower.manager.model.po;


import com.lycheeframework.core.model.IPO;

/**
 * 角色表
 * @author oliver
 *
 */
public class Role implements IPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *  主键 id
	 */
	private Integer id;

	/**
	 * 角色code
	 */
	private String code;

	/**
	 * 角色名称
	 */
	private String rolename;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getRolename() {
		return rolename;
	}
	
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}