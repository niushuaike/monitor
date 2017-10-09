/**
 * Copyright 2014-2017 com.lycheeframework.mapping
 * All rights reserved.
 * 
 * @project
 * @author oliver
 * @version 1.0
 * @date 2017-09-05
 */
package com.micropower.manager.model.po;

import java.util.Date;

import com.lycheeframework.core.model.IPO;

/**
 * 
 * @author oliver
 *
 */
public class Warnlog implements IPO {

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
	private Integer warnType;

	/**
	 * 告警描述
	 */
	private String warnDescription;

	/**
	 * 图片地址
	 */
	private String pictureUrl;

	/**
	 * 告警时间
	 */
	private Date warnTime;

	/**
	 * 告警状态
	 */
	private Integer warnState;

	/**
	 * 
	 */
	private String operationDetail;

	/**
	 *
	 */
	private String completeTime;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getWarnType() {
		return warnType;
	}
	
	public void setWarnType(Integer warnType) {
		this.warnType = warnType;
	}
	public String getWarnDescription() {
		return warnDescription;
	}
	
	public void setWarnDescription(String warnDescription) {
		this.warnDescription = warnDescription;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public Date getWarnTime() {
		return warnTime;
	}
	
	public void setWarnTime(Date warnTime) {
		this.warnTime = warnTime;
	}
	public Integer getWarnState() {
		return warnState;
	}
	
	public void setWarnState(Integer warnState) {
		this.warnState = warnState;
	}
	public String getOperationDetail() {
		return operationDetail;
	}
	
	public void setOperationDetail(String operationDetail) {
		this.operationDetail = operationDetail;
	}

	public String getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(String completeTime) {
		this.completeTime = completeTime;
	}
}