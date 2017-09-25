package com.micropower.manager.service;

import com.micropower.manager.model.po.Device;
import com.micropower.manager.model.pojo.DevicePojo;

import java.util.List;
import java.util.Map;

/**
 * Created by oliver on 2017/9/4.
 */
public interface DeviceService extends BaseService<Device> {
        List<Map<String, Object>> list();
        Integer delete(Integer id);

        DevicePojo getDevicePojo(Integer id);

    List<DevicePojo> getDevicePojoList();

    List<DevicePojo> getDevicePojoSelfList();

    Device querySelfDevice(int i);

    List<Device> getKeyDevice();

    Integer updateAddr(String deviceAddress);
}
