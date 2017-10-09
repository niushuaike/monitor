package com.micropower.manager.service.impl;

import com.alibaba.fastjson.JSON;
import com.lycheeframework.core.cmp.kit.Pages;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.model.po.Reportstatus;
import com.micropower.manager.model.pojo.ReportstatusPojo;
import com.micropower.manager.model.pojo.WarnlogPojo;
import com.micropower.manager.service.ReportstatusService;
import com.micropower.manager.service.WarnLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by oliver on 2017/9/4.
 */
@Service
public class ReportstatusServiceImpl extends BaseServiceImpl<Reportstatus> implements ReportstatusService {

    @Autowired
    private WarnLogService warnLogService;

    @Override
    public Integer addStatus(Map<String, String> deviceStatus) {
        return manager.getSqlSessionTemplate().insert(namespace+"add",deviceStatus);
    }

    @Override
    public Pages<List<Reportstatus>> list(Map<String, String> paramesMapMy, EasyPage page) {
        String starttime = paramesMapMy.get("starttime");
        String endtime = paramesMapMy.get("endtime");
        if(endtime!=null&&endtime.equals(starttime)){
            starttime=endtime;
            paramesMapMy.put("starttime",starttime);
            paramesMapMy.put("endtime","");
        }
        Pages<List<Reportstatus>> pages = getPages(paramesMapMy, page);
        return getPages(paramesMapMy, page);
    }

    @Override
    public Reportstatus queryByStatusno(String statusno) {
        return (Reportstatus) manager.query(namespace+"queryByStatusno",statusno);
    }

    @Override
    public ReportstatusPojo queryPojoByStatusno(String statusno) {
        return (ReportstatusPojo) manager.query(namespace+"queryPojoByStatusno",statusno);
    }

    @Override
    public ReportstatusPojo queryDevicePojosByStatusno(String statusno) {
        ReportstatusPojo reportstatusPojo = queryPojoByStatusno(statusno);
        //处理设备连接状态
        String devicestatus = reportstatusPojo.getDevicestatus();
        List<Map> maps = JSON.parseArray(devicestatus, Map.class);
        reportstatusPojo.setDevicestatuslistmap(maps);
        //处理异常信息
        List<WarnlogPojo> warnlogs = new ArrayList<>();
        String warninfo = reportstatusPojo.getWarninfo();
        String[] split = warninfo.split(",");
        for (int i = 0; i < split.length; i++) {
            if (!StringUtils.isEmpty(split[i])){
                WarnlogPojo warnlogPojo = warnLogService.queryWarnPojo(Integer.parseInt(split[i]));
                warnlogs.add(warnlogPojo);
            }
        }
        reportstatusPojo.setWarnlogList(warnlogs);
        return reportstatusPojo;
    }

    @Override
    public Integer delete(Integer id) {
        return manager.deleteByID(namespace+"delete",id);
    }
}
