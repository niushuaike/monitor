package com.micropower.manager.model.po;

/**
 * Created by niushuaike on 2017/9/21.
 */
public class RawDataP {
    /**
     * 时间
     */
    private String date;

    /**
     * 压缩机1电流
     */
    private String ysjOne;

    /**
     * 压缩机2电流
     */
    private String ysjTwo;

    /**
     * 离心风机1电流
     */
    private String lxfjOne;

    /**
     * 离心风机2电流
     */
    private String lxfjTwo;

    /**
     * 散热风机电流
     */
    private String srfj;

    /**
     * 循环风机电流
     */
    private String xhfj;

    /**
     * 环境控制温度
     */
    private String hjkz;

    /**
     * 箱内温度
     */
    private String xnwd;

    /**
     * 故障状态
     */
    private String gzzt;

    /**
     * 设备开停状态
     */
    private String sbktzt;

    public String getXnwd() {
        return xnwd;
    }

    public void setXnwd(String xnwd) {
        this.xnwd = xnwd;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYsjOne() {
        return ysjOne;
    }

    public void setYsjOne(String ysjOne) {
        this.ysjOne = ysjOne;
    }

    public String getYsjTwo() {
        return ysjTwo;
    }

    public void setYsjTwo(String ysjTwo) {
        this.ysjTwo = ysjTwo;
    }

    public String getLxfjOne() {
        return lxfjOne;
    }

    public void setLxfjOne(String lxfjOne) {
        this.lxfjOne = lxfjOne;
    }

    public String getLxfjTwo() {
        return lxfjTwo;
    }

    public void setLxfjTwo(String lxfjTwo) {
        this.lxfjTwo = lxfjTwo;
    }

    public String getSrfj() {
        return srfj;
    }

    public void setSrfj(String srfj) {
        this.srfj = srfj;
    }

    public String getXhfj() {
        return xhfj;
    }

    public void setXhfj(String xhfj) {
        this.xhfj = xhfj;
    }

    public String getHjkz() {
        return hjkz;
    }

    public void setHjkz(String hjkz) {
        this.hjkz = hjkz;
    }

    public String getGzzt() {
        return gzzt;
    }

    public void setGzzt(String gzzt) {
        this.gzzt = gzzt;
    }

    public String getSbktzt() {
        return sbktzt;
    }

    public void setSbktzt(String sbktzt) {
        this.sbktzt = sbktzt;
    }
}
