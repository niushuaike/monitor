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
 * 定时保存设置
 * @author oliver
 *
 */
public class Saveconfig implements IPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *  主键 id
	 */
	private Integer id;

	/**
	 * 定时保存名称
	 */
	private String saveConfigTitle;

	/**
	 * 起始时间
	 */
	private String starttime;

	/**
	 * 结束时间
	 */
	private String endtime;

	/**
	 * 间隔时间
	 */
	private String deltatime;

	/**
	 * 最近保存时间
	 */
	private String lasttime;

	/**
	 * 最近数据
	 */
	private String lastdata;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSaveConfigTitle() {
		return saveConfigTitle;
	}
	
	public void setSaveConfigTitle(String saveConfigTitle) {
		this.saveConfigTitle = saveConfigTitle;
	}
	public String getStarttime() {
		return starttime;
	}
	
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getDeltatime() {
		return deltatime;
	}
	
	public void setDeltatime(String deltatime) {
		this.deltatime = deltatime;
	}
	public String getLasttime() {
		return lasttime;
	}
	
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	public String getLastdata() {
		return lastdata;
	}
	
	public void setLastdata(String lastdata) {
		this.lastdata = lastdata;
	}
}