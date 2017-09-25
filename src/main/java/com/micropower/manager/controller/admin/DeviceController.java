package com.micropower.manager.controller.admin;

import com.github.pagehelper.StringUtil;
import com.lycheeframework.core.common.util.SpringUtil;
import com.micropower.manager.model.po.Device;
import com.micropower.manager.model.po.User;
import com.micropower.manager.model.po.Warnstyle;
import com.micropower.manager.model.po.Warntimeperiod;
import com.micropower.manager.model.pojo.DevicePojo;
import com.micropower.manager.service.DeviceService;
import com.micropower.manager.service.UserService;
import com.micropower.manager.service.WarnStyleService;
import com.micropower.manager.service.WarntimeperiodService;
import com.micropower.manager.utils.OxConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by oliver on 2017/9/4.
 */
@Controller
@RequestMapping("/jm/device")
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

    /**
     * 初始化弹窗添加
     * @return
     */
    @ResponseBody
    @RequestMapping("/toadd")
    public Map<String,List<Warntimeperiod>> toadd() {
        Map<String,List<Warntimeperiod>> map = new HashMap<>();
        map.put("warntimeperiod",warntimeperiodservice.list());
        map.put("warnstyle",warnStyleService.list());
        return map;
    }

    /**
     * 保存设备
     * @param device
     * @return
     */
    @ResponseBody
    @RequestMapping("/saveadd")
    public Integer saveadd(Device device) {

        Integer integer = deviceService.create(device);
        int i=1;
        return integer;
    }

    @ResponseBody
    @RequestMapping("/getDeviceById")
    public DevicePojo getDeviceById(Integer id) {
        DevicePojo devicePojo = deviceService.getDevicePojo(id);
        return devicePojo;
    }

    @ResponseBody
    @RequestMapping("/querySelfDevice")
    public Map<String, String> querySelfDevice(Integer deviceType) {
        Device device = deviceService.querySelfDevice(deviceType);
        Map<String, String> map = OxConvertUtil.obj2Map(device);
        String deviceAddress = device.getDeviceAddress();
        String[] split = deviceAddress.split(" ");
        if (split.length>3){
            map.put("provice",split[0]);
            map.put("city",split[1]);
            map.put("county",split[2]);
            map.put("detail",split[3]);
        }

        return map;
    }

    @ResponseBody
    @RequestMapping("/getdevicepojolist")
    public List<DevicePojo> getdevicepojolist() {
        List<DevicePojo> devicePojos = deviceService.getDevicePojoList();
        return devicePojos;
    }

    @ResponseBody
    @RequestMapping("/getdevicepojoselflist")
    public List<DevicePojo> getdevicepojoselflist() {
        List<DevicePojo> devicePojos = deviceService.getDevicePojoSelfList();
        return devicePojos;
    }

    @ResponseBody
    @RequestMapping("/saveedit")
    public Integer saveedit(Device device) {
        Device device1 = deviceService.queryById(device.getId());
        if (device1 != null)
            return deviceService.update(device);
        else
            return deviceService.create(device);
    }

    @ResponseBody
    @RequestMapping("/pauseDeviceWarnConfig")
    public Integer pauseDeviceWarnConfig(Integer id, Integer intervaltime) {
        Device device1 = deviceService.queryById(id);
        Date date = new Date();
        long l = date.getTime() + intervaltime * 60 * 1000;
        date.setTime(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = dateFormat.format(date);
        device1.setIspause(1);
        device1.setEndpausetime(format1);
        return deviceService.update(device1);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Integer delete(Integer id) {
        return deviceService.delete(id);
    }@ResponseBody
    @RequestMapping("/updateAddr")
    public Integer updateAddr(String deviceAddress) {
        return deviceService.updateAddr(deviceAddress);
    }
}
