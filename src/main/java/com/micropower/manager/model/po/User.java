/**
 * Copyright 2014-2017 com.lycheeframework.mapping
 * All rights reserved.
 * 
 * @project
 * @author oliver
 * @version 1.0
 * @date 2017-09-04
 */
package com.micropower.manager.model.po;


import com.lycheeframework.core.model.IPO;

/**
 * 
 * @author oliver
 *
 */
public class User implements IPO {

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
	private Integer role;

	/**
	 * 用户名称
	 */
	private String username;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 真是姓名
	 */
	private String realname;

	/**
	 * 邮箱地址
	 */
	private String email;

	/**
	 * 联系电话
	 */
	private String phone;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRole() {
		return role;
	}
	
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}