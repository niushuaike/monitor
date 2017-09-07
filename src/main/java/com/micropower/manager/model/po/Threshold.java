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
 * 阈值
 * @author oliver
 *
 */
public class Threshold implements IPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *  主键 id
	 */
	private Integer id;

	/**
	 * 阈值code
	 */
	private String code;

	/**
	 * 阈值名称
	 */
	private String thresholdname;

	/**
	 * 最小值
	 */
	private Integer min;

	/**
	 * 最大值
	 */
	private Integer max;

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
	public String getThresholdname() {
		return thresholdname;
	}
	
	public void setThresholdname(String thresholdname) {
		this.thresholdname = thresholdname;
	}
	public Integer getMin() {
		return min;
	}
	
	public void setMin(Integer min) {
		this.min = min;
	}
	public Integer getMax() {
		return max;
	}
	
	public void setMax(Integer max) {
		this.max = max;
	}
}