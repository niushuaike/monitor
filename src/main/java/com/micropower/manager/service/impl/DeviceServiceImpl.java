package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.Device;
import com.micropower.manager.model.po.User;
import com.micropower.manager.model.po.Warnstyle;
import com.micropower.manager.model.po.Warntimeperiod;
import com.micropower.manager.model.pojo.DevicePojo;
import com.micropower.manager.service.DeviceService;
import com.micropower.manager.service.UserService;
import com.micropower.manager.service.WarnStyleService;
import com.micropower.manager.service.WarntimeperiodService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by oliver on 2017/9/4.
 */
@Service
public class DeviceServiceImpl extends BaseServiceImpl<Device> implements DeviceService {

    @Autowired
    private UserService userService;

    @Autowired
    private WarntimeperiodService warntimeperiodService;

    @Autowired
    private WarnStyleService warnStyleService;

    @Override
    public List<Map<String, Object>> list() {
        List<Device> list = (List<Device>) manager.list(namespace + "list");
        List<Map<String, Object>> listmap = new ArrayList<>();
        for (Device device : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("devicebase", device);
            listmap.add(map);
        }
        return listmap;
    }

    @Override
    public Integer delete(Integer id) {
        return manager.deleteByID(namespace + "delete", id);
    }

    @Override
    public DevicePojo getDevicePojo(Integer id) {
        DevicePojo devicePojo = new DevicePojo();

        Device device = queryById(id);
        if (!StringUtils.isEmpty(device.getUsers())) {
            String[] split = device.getUsers().split(",");
            List<User> users = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                User user = userService.queryById(Integer.parseInt(split[i]));
                users.add(user);
            }
            devicePojo.setUsersList(users);
        }
        devicePojo.setDevice(device);
        return devicePojo;
    }

    @Override
    public List<DevicePojo> getDevicePojoList() {
        List<DevicePojo> listdevicepojo = new ArrayList<>();
        List<Device> list = (List<Device>) manager.list(namespace + "list");
        for (Device device : list) {
            DevicePojo devicePojo = new DevicePojo();
            devicePojo.setDevice(device);

            Integer timeperiod = device.getTimeperiod();
            String warnstyleid = device.getWarnstyleid();
            String users = device.getUsers();
            if (timeperiod != null) {
                Warntimeperiod warntimeperiod = warntimeperiodService.queryById(timeperiod);
                devicePojo.setWarntimeperiod(warntimeperiod);
            }
            if (!StringUtils.isEmpty(warnstyleid)) {
                Warnstyle warnstyle = warnStyleService.queryById(Integer.parseInt(warnstyleid));
                devicePojo.setWarnstyle(warnstyle);
            }
            if (!StringUtils.isEmpty(users)) {
                String[] split = users.split(",");
                List<User> userList = new ArrayList<>();
                for (int i = 0; i < split.length; i++) {
                    User user = userService.queryById(Integer.parseInt(split[i]));
                    userList.add(user);
                }
                devicePojo.setUsersList(userList);
            }
            listdevicepojo.add(devicePojo);
        }
        return listdevicepojo;
    }

    @Override
    public List<DevicePojo> getDevicePojoSelfList() {
        List<DevicePojo> listdevicepojo = new ArrayList<>();
        List<Device> list = (List<Device>) manager.list(namespace + "list2");
        for (Device device : list) {
            DevicePojo devicePojo = new DevicePojo();
            devicePojo.setDevice(device);

            Integer timeperiod = device.getTimeperiod();
            String warnstyleid = device.getWarnstyleid();
            String users = device.getUsers();
            if (timeperiod != null) {
                Warntimeperiod warntimeperiod = warntimeperiodService.queryById(timeperiod);
                devicePojo.setWarntimeperiod(warntimeperiod);
            }
            if (!StringUtils.isEmpty(warnstyleid)) {
                Warnstyle warnstyle = warnStyleService.queryById(Integer.parseInt(warnstyleid));
                devicePojo.setWarnstyle(warnstyle);
            }
            if (!StringUtils.isEmpty(users)) {
                String[] split = users.split(",");
                List<User> userList = new ArrayList<>();
                for (int i = 0; i < split.length; i++) {
                    User user = userService.queryById(Integer.parseInt(split[i]));
                    userList.add(user);
                }
                devicePojo.setUsersList(userList);
            }
            listdevicepojo.add(devicePojo);
        }
        return listdevicepojo;
    }

    @Override
    public Device querySelfDevice(int i) {
        return (Device) manager.query(namespace+"querySelfDevice",i);
    }

    @Override
    public List<Device> getKeyDevice() {
        return (List<Device>) manager.list(namespace+"getKeyDevice");
    }

    @Override
    public Integer updateAddr(String deviceAddress) {
        return manager.getSqlSessionTemplate().update(namespace+"updateAddr",deviceAddress);
    }
}
