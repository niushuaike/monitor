package com.micropower.manager.model.po;

import java.util.Date;

/**
 * Created by oliver on 2017/9/1.
 */
public class RawData {

    private Date date;

    /**
     * 电压
     */
    private String voltage;

    /**
     * 电流
     */
    private String current1;

    private String current2;
    /**
     * 温度
     */
    private String temperature;
    /**
     * 湿度
     */
    private String humidity;
    /**
     * 高压
     */
    private String voltageHigh;
    /**
     * 低压
     */
    private String voltageLow;

    private String current1High;

    private String current2High;
    /**
     * 高温
     */
    private String temperatureHigh;
    /**
     * 高湿度
     */
    private String humidityHigh;
    /**
     * 前门
     * 0：关
     * 1：开
     */
    private String frontGate;

    /**
     * 水浸
     * 0：正常
     * 1：告警
     */
    private String flood;

    /**
     * 红外线
     * 0：正常
     * 1：告警
     */
    private String infrared;

    /**
     * 烟
     * 0：正常
     * 1：告警
     */
    private String smoke;

    /**
     * 后门
     * 0：关
     * 1：开
     */
    private String backGate;


    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getCurrent1() {
        return current1;
    }

    public void setCurrent1(String current1) {
        this.current1 = current1;
    }

    public String getCurrent2() {
        return current2;
    }

    public void setCurrent2(String current2) {
        this.current2 = current2;
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

    public String getVoltageHigh() {
        return voltageHigh;
    }

    public void setVoltageHigh(String voltageHigh) {
        this.voltageHigh = voltageHigh;
    }

    public String getVoltageLow() {
        return voltageLow;
    }

    public void setVoltageLow(String voltageLow) {
        this.voltageLow = voltageLow;
    }

    public String getCurrent1High() {
        return current1High;
    }

    public void setCurrent1High(String current1High) {
        this.current1High = current1High;
    }

    public String getCurrent2High() {
        return current2High;
    }

    public void setCurrent2High(String current2High) {
        this.current2High = current2High;
    }

    public String getTemperatureHigh() {
        return temperatureHigh;
    }

    public void setTemperatureHigh(String temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    public String getHumidityHigh() {
        return humidityHigh;
    }

    public void setHumidityHigh(String humidityHigh) {
        this.humidityHigh = humidityHigh;
    }

    public String getFrontGate() {
        return frontGate;
    }

    public void setFrontGate(String frontGate) {
        this.frontGate = frontGate;
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

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getBackGate() {
        return backGate;
    }

    public void setBackGate(String backGate) {
        this.backGate = backGate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RawData{" +
                "voltage='" + voltage + '\'' +
                ", current1='" + current1 + '\'' +
                ", current2='" + current2 + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", voltageHigh='" + voltageHigh + '\'' +
                ", voltageLow='" + voltageLow + '\'' +
                ", current1High='" + current1High + '\'' +
                ", current2High='" + current2High + '\'' +
                ", temperatureHigh='" + temperatureHigh + '\'' +
                ", humidityHigh='" + humidityHigh + '\'' +
                ", frontGate='" + frontGate + '\'' +
                ", flood='" + flood + '\'' +
                ", infrared='" + infrared + '\'' +
                ", smoke='" + smoke + '\'' +
                ", backGate='" + backGate + '\'' +
                '}';
    }
}
