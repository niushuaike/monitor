package com.micropower.manager.service;

import com.micropower.manager.model.po.Device;

import java.util.List;
import java.util.Map;

/**
 * Created by oliver on 2017/9/4.
 */
public interface DeviceService extends BaseService<Device> {
        List<Map<String, Object>> list();
        Integer delete(Integer id);
}
