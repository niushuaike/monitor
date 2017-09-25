package com.micropower.manager.utils;

import com.alibaba.fastjson.JSON;
import com.lycheeframework.core.common.util.SpringUtil;
import com.micropower.manager.model.po.Device;
import com.micropower.manager.model.po.RawData;
import com.micropower.manager.model.po.Warnlog;
import com.micropower.manager.service.DeviceService;
import com.micropower.manager.service.ReportstatusService;
import com.micropower.manager.service.WarnLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by niushuaike on 2017/9/19.
 */
@Component
public class ScheduleSaveRunnable implements Runnable {

    /**
     * 定时保存设置
     */
    @Autowired
    private ReportstatusService statusService;
    @Autowired
    private WarnLogService warnLogService;

    @Autowired
    ServletContext servletContext;

    @Autowired
    private DeviceService deviceService;

    private Integer saveHourFrequency = 1;

    @Override
    public void run() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        Date date = new Date();
        String filedateformat = dateFormat.format(date) + ".data";
        String statusno = dateFormat2.format(date);
        RawData rawData;
        try {
            rawData = ParseDataUtil.parseRecentOneData((String) servletContext.getAttribute("cabinet_data_path"));
            Map<String, String> deviceStatus = ParseDataUtil.getDeviceStatus(rawData);
            deviceStatus.put("frontgate", deviceStatus.get("frontGate"));
            deviceStatus.put("backgate", deviceStatus.get("backGate"));
            deviceStatus.put("statusno", statusno);
            deviceStatus.put("devicestatus", getDeviceStatus());
            deviceStatus.put("warninfo", getRecentOneHourWarnlog());
            Integer integer = statusService.addStatus(deviceStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getDeviceStatus() {
        List<Device> keyDevices = deviceService.getKeyDevice();
        List<Map<String,String>> keyDeviceStatuss = new ArrayList<>();
        for(Device device:keyDevices){
            Map<String,String> keyDeviceStatus = new HashMap<>();
            keyDeviceStatus.put("devicename",device.getDeviceName());
            keyDeviceStatus.put("pingstatus","无法检测");
            keyDeviceStatus.put("hardware","无法检测");
            keyDeviceStatuss.add(keyDeviceStatus);
        }
        return JSON.toJSONString(keyDeviceStatuss);
    }

    private String getRecentOneHourWarnlog() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date beforeSumHour = new Date(new Date().getTime() - saveHourFrequency * 60 * 60 * 1000);
        List<Warnlog> warnlogs = warnLogService.listWarnlog();
        String warnlogids = "";
        for (Warnlog warnlog : warnlogs) {
            if (warnlog.getWarnTime().after(beforeSumHour)) {
                warnlogids += warnlog.getId() + ",";
            }
        }
        return warnlogids;
    }
}
