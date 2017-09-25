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
 * 告警时段设置
 * @author oliver
 *
 */
public class Warntimeperiod implements IPO {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *  主键 id
     */
    private Integer id;

    /**
     *
     */
    private String timeperiodname;

    /**
     * 周日
     */
    private String sunday;

    /**
     * 周一
     */
    private String monday;

    /**
     * 周二
     */
    private String tuesday;

    /**
     * 周三
     */
    private String wednesday;

    /**
     * 周四
     */
    private String thursday;

    /**
     * 周五
     */
    private String friday;

    /**
     * 周六
     */
    private String saturday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimeperiodname() {
        return timeperiodname;
    }

    public void setTimeperiodname(String timeperiodname) {
        this.timeperiodname = timeperiodname;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }
}