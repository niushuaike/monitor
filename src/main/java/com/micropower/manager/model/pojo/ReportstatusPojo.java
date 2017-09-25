package com.micropower.manager.model.pojo;

import com.micropower.manager.model.po.Device;
import com.micropower.manager.model.po.Reportstatus;
import com.micropower.manager.model.po.Warnlog;

import java.util.List;
import java.util.Map;

/**
 * Created by niushuaike on 2017/9/20.
 */
public class ReportstatusPojo extends Reportstatus{

    private List<WarnlogPojo> warnlogList;

    private List<Map> devicestatuslistmap;

    public List<WarnlogPojo> getWarnlogList() {
        return warnlogList;
    }

    public void setWarnlogList(List<WarnlogPojo> warnlogList) {
        this.warnlogList = warnlogList;
    }

    public List<Map> getDevicestatuslistmap() {
        return devicestatuslistmap;
    }

    public void setDevicestatuslistmap(List<Map> devicestatuslistmap) {
        this.devicestatuslistmap = devicestatuslistmap;
    }
}
