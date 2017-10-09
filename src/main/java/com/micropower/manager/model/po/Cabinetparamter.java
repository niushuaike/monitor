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
public class Cabinetparamter implements IPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *  主键 mid
	 */
	private Long mid;

	/**
	 * 温度设定值
	 */
	private String tempSetting;

	/**
	 * 温度回差
	 */
	private String tempDifference;

	/**
	 * 库温探头校正
	 */
	private String probeCorrection;

	/**
	 * 环境控制温度
	 */
	private String envlControlTemperature;

	/**
	 * 环境控制回差
	 */
	private String envControlBacklash;

	/**
	 * 环境探头校正
	 */
	private String envProbeCorrection;

	/**
	 * 压缩机连续开机时间
	 */
	private String comConStratTime;

	/**
	 * 压缩机保护时间
	 */
	private String comProtectionTime;

	/**
	 * 内外循环切换延时时间
	 */
	private String iaeDelayTime;

	/**
	 * 温度传感器故障开机时间
	 */
	private String temFaultStartTime;

	/**
	 * 温度传感器故障停机时间
	 */
	private String temFaultEndTime;

	/**
	 * 开门温度
	 */
	private String openTem;

	/**
	 * 开门回差
	 */
	private String openDifference;

	/**
	 * 控制方式
	 */
	private String controlMode;

	/**
	 * 压缩机1电流上限
	 */
	private String comCurrentOneTop;

	/**
	 * 压缩机1电流下限
	 */
	private String comCurrentOneDown;

	/**
	 * 压缩机2电流上限
	 */
	private String comCurrentTwoTop;

	/**
	 * 压缩机2电流下限
	 */
	private String comCurrentTwoDown;

	/**
	 * 离心风机1电流上限
	 */
	private String cenCurrentOneTop;

	/**
	 * 离心风机1电流下限
	 */
	private String cenCurrentOneDown;

	/**
	 * 离心风机2电流上限
	 */
	private String cenCurrentTwoTop;

	/**
	 * 离心风机2电流下限
	 */
	private String cenCurrentTwoDown;

	/**
	 * 散热风机电流上限
	 */
	private String dissipateCurrentTop;

	/**
	 * 散热风机电流下限
	 */
	private String dissipateCurrentDown;

	/**
	 * 循环风机电流上限
	 */
	private String loopCurrentTop;

	/**
	 * 循环风机电流下限
	 */
	private String loopCurrentDown;

	/**
	 * 通讯地址
	 */
	private String address;

	/**
	 * 参数类型：0，设置值；1，恢复默认设置值
	 */
	private String parametertype;


	public Long getMid() {
		return mid;
	}
	
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public String getTempSetting() {
		return tempSetting;
	}
	
	public void setTempSetting(String tempSetting) {
		this.tempSetting = tempSetting;
	}
	public String getTempDifference() {
		return tempDifference;
	}
	
	public void setTempDifference(String tempDifference) {
		this.tempDifference = tempDifference;
	}
	public String getProbeCorrection() {
		return probeCorrection;
	}
	
	public void setProbeCorrection(String probeCorrection) {
		this.probeCorrection = probeCorrection;
	}
	public String getEnvlControlTemperature() {
		return envlControlTemperature;
	}
	
	public void setEnvlControlTemperature(String envlControlTemperature) {
		this.envlControlTemperature = envlControlTemperature;
	}
	public String getEnvControlBacklash() {
		return envControlBacklash;
	}
	
	public void setEnvControlBacklash(String envControlBacklash) {
		this.envControlBacklash = envControlBacklash;
	}
	public String getEnvProbeCorrection() {
		return envProbeCorrection;
	}
	
	public void setEnvProbeCorrection(String envProbeCorrection) {
		this.envProbeCorrection = envProbeCorrection;
	}
	public String getComConStratTime() {
		return comConStratTime;
	}
	
	public void setComConStratTime(String comConStratTime) {
		this.comConStratTime = comConStratTime;
	}
	public String getComProtectionTime() {
		return comProtectionTime;
	}
	
	public void setComProtectionTime(String comProtectionTime) {
		this.comProtectionTime = comProtectionTime;
	}
	public String getIaeDelayTime() {
		return iaeDelayTime;
	}
	
	public void setIaeDelayTime(String iaeDelayTime) {
		this.iaeDelayTime = iaeDelayTime;
	}
	public String getTemFaultStartTime() {
		return temFaultStartTime;
	}
	
	public void setTemFaultStartTime(String temFaultStartTime) {
		this.temFaultStartTime = temFaultStartTime;
	}
	public String getTemFaultEndTime() {
		return temFaultEndTime;
	}
	
	public void setTemFaultEndTime(String temFaultEndTime) {
		this.temFaultEndTime = temFaultEndTime;
	}
	public String getOpenTem() {
		return openTem;
	}
	
	public void setOpenTem(String openTem) {
		this.openTem = openTem;
	}
	public String getOpenDifference() {
		return openDifference;
	}
	
	public void setOpenDifference(String openDifference) {
		this.openDifference = openDifference;
	}
	public String getControlMode() {
		return controlMode;
	}
	
	public void setControlMode(String controlMode) {
		this.controlMode = controlMode;
	}
	public String getComCurrentOneTop() {
		return comCurrentOneTop;
	}
	
	public void setComCurrentOneTop(String comCurrentOneTop) {
		this.comCurrentOneTop = comCurrentOneTop;
	}
	public String getComCurrentOneDown() {
		return comCurrentOneDown;
	}
	
	public void setComCurrentOneDown(String comCurrentOneDown) {
		this.comCurrentOneDown = comCurrentOneDown;
	}
	public String getComCurrentTwoTop() {
		return comCurrentTwoTop;
	}
	
	public void setComCurrentTwoTop(String comCurrentTwoTop) {
		this.comCurrentTwoTop = comCurrentTwoTop;
	}
	public String getComCurrentTwoDown() {
		return comCurrentTwoDown;
	}
	
	public void setComCurrentTwoDown(String comCurrentTwoDown) {
		this.comCurrentTwoDown = comCurrentTwoDown;
	}
	public String getCenCurrentOneTop() {
		return cenCurrentOneTop;
	}
	
	public void setCenCurrentOneTop(String cenCurrentOneTop) {
		this.cenCurrentOneTop = cenCurrentOneTop;
	}
	public String getCenCurrentOneDown() {
		return cenCurrentOneDown;
	}
	
	public void setCenCurrentOneDown(String cenCurrentOneDown) {
		this.cenCurrentOneDown = cenCurrentOneDown;
	}
	public String getCenCurrentTwoTop() {
		return cenCurrentTwoTop;
	}
	
	public void setCenCurrentTwoTop(String cenCurrentTwoTop) {
		this.cenCurrentTwoTop = cenCurrentTwoTop;
	}
	public String getCenCurrentTwoDown() {
		return cenCurrentTwoDown;
	}
	
	public void setCenCurrentTwoDown(String cenCurrentTwoDown) {
		this.cenCurrentTwoDown = cenCurrentTwoDown;
	}
	public String getDissipateCurrentTop() {
		return dissipateCurrentTop;
	}
	
	public void setDissipateCurrentTop(String dissipateCurrentTop) {
		this.dissipateCurrentTop = dissipateCurrentTop;
	}
	public String getDissipateCurrentDown() {
		return dissipateCurrentDown;
	}
	
	public void setDissipateCurrentDown(String dissipateCurrentDown) {
		this.dissipateCurrentDown = dissipateCurrentDown;
	}
	public String getLoopCurrentTop() {
		return loopCurrentTop;
	}
	
	public void setLoopCurrentTop(String loopCurrentTop) {
		this.loopCurrentTop = loopCurrentTop;
	}
	public String getLoopCurrentDown() {
		return loopCurrentDown;
	}
	
	public void setLoopCurrentDown(String loopCurrentDown) {
		this.loopCurrentDown = loopCurrentDown;
	}
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getParametertype() {
		return parametertype;
	}

	public void setParametertype(String parametertype) {
		this.parametertype = parametertype;
	}
}