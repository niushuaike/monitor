package com.micropower.manager.controller;

import com.github.pagehelper.StringUtil;
import com.micropower.manager.model.po.Device;
import com.micropower.manager.model.po.User;
import com.micropower.manager.model.po.Warnstyle;
import com.micropower.manager.model.po.Warntimeperiod;
import com.micropower.manager.service.DeviceService;
import com.micropower.manager.service.UserService;
import com.micropower.manager.service.WarnStyleService;
import com.micropower.manager.service.WarntimeperiodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by oliver on 2017/9/4.
 */
@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private WarntimeperiodService warntimeperiodservice;
    @Autowired
    private WarnStyleService warnStyleService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/list")
    public List<Map<String, Object>> list() {
        List<Map<String, Object>> list = deviceService.list();
        Stream<Map<String, Object>> stream = list.stream();
        stream.forEach((Map<String, Object> devicemap) -> {
            devicemap.put("devicestatus", "链接呵呵");
            devicemap.put("pingstatus", "ping:o_o");

            Device devicebase = (Device) devicemap.get("devicebase");

            Integer timeperiod = devicebase.getTimeperiod();
            Warntimeperiod warntimeperiod = warntimeperiodservice.queryById(timeperiod);
            devicemap.put("warntimeperiod", warntimeperiod.getTimeperiodname());
            //告警方式

            String warnstyleid = devicebase.getWarnstyleid();
            String[] split = warnstyleid.split(",");
            StringBuilder strwarnstyle = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                Warnstyle warnstyle = warnStyleService.queryById(Integer.parseInt(split[i]));
                if (i == 0) {
                    strwarnstyle.append(warnstyle.getWarnstylename());
                } else {
                    strwarnstyle.append("," + warnstyle.getWarnstylename());
                }
            }
            devicemap.put("warnstyle", strwarnstyle);
            //通知用户
            String users = devicebase.getUsers();
            if (!StringUtil.isEmpty(users)) {
                String[] split1 = users.split(",");
                StringBuilder strusers = new StringBuilder();
                for (int i = 0; i < split1.length; i++) {
                    User user = userService.queryById(Integer.parseInt(split1[i]));
                    if (i == 0) {
                        strusers.append(user.getRealname());
                    } else {
                        strusers.append("," + user.getRealname());
                    }
                }
                devicemap.put("users", strusers);
            }
            //告警状态
            if (devicebase.getIspause()!=null && devicebase.getIspause() == 1){
                devicemap.put("intervaltime", "冻结至" + devicebase.getEndpausetime());
            } else{
                String intervaltime = devicebase.getIntervaltime();
                if ("-1".equals(intervaltime)) {
                    devicemap.put("intervaltime", "当前禁止告警");
                } else if ("0".equals(intervaltime)) {
                    devicemap.put("intervaltime", "只告警一次");
                } else {
                    devicemap.put("intervaltime", "每" + intervaltime + "分钟告警");
                }
            }
        });
        return list;
    }

    @ResponseBody
    @RequestMapping("/toadd")
    public List<Warntimeperiod> toadd() {
        return warntimeperiodservice.list();
    }

    @RequestMapping("/saveadd")
    public String saveadd(Device device) {
        Integer integer = deviceService.create(device);
        return "keySet";
    }

    @ResponseBody
    @RequestMapping("/toedit")
    public List<Warntimeperiod> toedit() {
        return warntimeperiodservice.list();
    }

    @RequestMapping("/saveEdit")
    public String saveEdit(Device device) {
        Device device1 = deviceService.queryById(device.getId());
        if (device1 != null)
            deviceService.update(device1);
        else
            deviceService.create(device1);
        return "keySet";
    }

    @ResponseBody
    @RequestMapping("/pauseDeviceWarnConfig")
    public Integer pauseDeviceWarnConfig(Integer id, Integer time) {
        Device device1 = deviceService.queryById(id);
        Date date = new Date();
        long l = date.getTime() + time * 60 * 1000;
        date.setTime(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = dateFormat.format(date);
        device1.setIspause(1);
        device1.setEndpausetime(format1);
        return deviceService.update(device1);
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        return "keySet";
    }
}
