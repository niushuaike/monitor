/**
 * Copyright 2014-2016 com.lycheeframework.mapping
 * All rights reserved.
 * 
 * @project
 * @author Administrator
 * @version 1.0
 * @date 2016-12-03
 */
package com.micropower.manager.model.po;

import java.util.Date;

import com.lycheeframework.core.model.IPO;

/**
 * 
 * @author Administrator
 *
 */
public class Resource implements IPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *  主键 ID
	 */
	private Integer id;

	/**
	 * 资源Key
	 */
	private String resourceKey;

	/**
	 * 显示名
	 */
	private String displayValue;

	/**
	 *  父节点ID
	 */
	private Integer parentId;

	/**
	 * 排序
	 */
	private Integer orderIndex;

	/**
	 * 拥有者 P_USER.ID
	 */
	private Integer ownerId;

	/**
	 * 是否删除 y 是 | n 否
	 */
	private String isDeleted;

	/**
	 *  创建时间
	 */
	private Date gmtCreate;

	/**
	 *  修改时间
	 */
	private Date gmtModified;

	/**
	 *  属性扩展
	 */
	private String resExt;

	/**
	 *  资源编码
	 */
	private String code;


	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getResourceKey() {
		return resourceKey;
	}
	
	public void setResourceKey(String resourceKey) {
		this.resourceKey = resourceKey;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getOrderIndex() {
		return orderIndex;
	}
	
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

	public Integer getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}
	
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}
	
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getResExt() {
		return resExt;
	}
	
	public void setResExt(String resExt) {
		this.resExt = resExt;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}