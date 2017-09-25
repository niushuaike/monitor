/**
 * Copyright 2014-2017 com.lycheeframework.mapping
 * All rights reserved.
 * 
 * @project
 * @author niushuaike
 * @version 1.0
 * @date 2017-09-18
 */
package com.micropower.manager.model.po;


import com.lycheeframework.core.model.IPO;

/**
 * 
 * @author niushuaike
 *
 */
public class Reportstatus implements IPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *  主键 id
	 */
	private Integer id;

	/**
	 * 格式：年月日-时分
	 */
	private String statusno;

	/**
	 * 
	 */
	private String temperature;

	/**
	 * 
	 */
	private String humidity;

	/**
	 * 
	 */
	private String frontgate;

	/**
	 * 
	 */
	private String backgate;

	/**
	 * 
	 */
	private String smoke;

	/**
	 * 
	 */
	private String flood;

	/**
	 * 
	 */
	private String infrared;

	/**
	 * json数组存储
	 */
	private String devicestatus;

	/**
	 * 
	 */
	private String warninfo;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatusno() {
		return statusno;
	}
	
	public void setStatusno(String statusno) {
		this.statusno = statusno;
	}
	public String getTemperature() {
		return temperature;
	}
	
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getFrontgate() {
		return frontgate;
	}
	
	public void setFrontgate(String frontgate) {
		this.frontgate = frontgate;
	}
	public String getBackgate() {
		return backgate;
	}
	
	public void setBackgate(String backgate) {
		this.backgate = backgate;
	}
	public String getSmoke() {
		return smoke;
	}
	
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	public String getFlood() {
		return flood;
	}
	
	public void setFlood(String flood) {
		this.flood = flood;
	}
	public String getInfrared() {
		return infrared;
	}
	
	public void setInfrared(String infrared) {
		this.infrared = infrared;
	}
	public String getDevicestatus() {
		return devicestatus;
	}
	
	public void setDevicestatus(String devicestatus) {
		this.devicestatus = devicestatus;
	}
	public String getWarninfo() {
		return warninfo;
	}
	
	public void setWarninfo(String warninfo) {
		this.warninfo = warninfo;
	}
}