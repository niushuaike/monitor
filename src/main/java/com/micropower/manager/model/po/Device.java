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

import java.util.Date;

import com.lycheeframework.core.model.IPO;

/**
 * 
 * @author oliver
 *
 */
public class Device implements IPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *  主键 id
	 */
	private Integer id;

	/**
	 * 主机名
	 */
	private String deviceName;

	/**
	 * IP地址
	 */
	private String deviceIp;

	/**
	 * 主机端口
	 */
	private String devicePort;

	/**
	 * 告警时段id
	 */
	private Integer timeperiod;

	/**
	 * 告警方式ID
	 */
	private String warnstyleid;

	/**
	 * 通知用户
	 */
	private String users;

	/**
	 * 告警间隔时间
	 */
	private String intervaltime;

	/**
	 * 
	 */
	private Integer ispause;

	/**
	 * 
	 */
	private String endpausetime;

	/**
	 * 设备类型
	 */
	private Integer deviceType;

	/**
	 * 
	 */
	private String loginName;

	/**
	 * 
	 */
	private String loginPasswd;

	/**
	 * 
	 */
	private String lastStyle;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeviceName() {
		return deviceName;
	}
	
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceIp() {
		return deviceIp;
	}
	
	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}
	public String getDevicePort() {
		return devicePort;
	}
	
	public void setDevicePort(String devicePort) {
		this.devicePort = devicePort;
	}
	public Integer getTimeperiod() {
		return timeperiod;
	}
	
	public void setTimeperiod(Integer timeperiod) {
		this.timeperiod = timeperiod;
	}
	public String getWarnstyleid() {
		return warnstyleid;
	}
	
	public void setWarnstyleid(String warnstyleid) {
		this.warnstyleid = warnstyleid;
	}
	public String getUsers() {
		return users;
	}
	
	public void setUsers(String users) {
		this.users = users;
	}
	public String getIntervaltime() {
		return intervaltime;
	}
	
	public void setIntervaltime(String intervaltime) {
		this.intervaltime = intervaltime;
	}
	public Integer getIspause() {
		return ispause;
	}
	
	public void setIspause(Integer ispause) {
		this.ispause = ispause;
	}
	public String getEndpausetime() {
		return endpausetime;
	}
	
	public void setEndpausetime(String endpausetime) {
		this.endpausetime = endpausetime;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPasswd() {
		return loginPasswd;
	}
	
	public void setLoginPasswd(String loginPasswd) {
		this.loginPasswd = loginPasswd;
	}
	public String getLastStyle() {
		return lastStyle;
	}
	
	public void setLastStyle(String lastStyle) {
		this.lastStyle = lastStyle;
	}
}