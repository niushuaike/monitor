package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.Device;
import com.micropower.manager.service.DeviceService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by oliver on 2017/9/4.
 */
@Service
public class DeviceServiceImpl extends BaseServiceImpl<Device> implements DeviceService {

    @Override
    public List<Map<String, Object>> list() {
        List<Device> list = (List<Device>) manager.list(namespace + "list");
        List<Map<String, Object>> listmap = new ArrayList<>();
        for (Device device:list){
            Map<String,Object> map = new HashMap<>();
            map.put("devicebase",device);
            listmap.add(map);
        }
        return listmap;
    }

    @Override
    public Integer delete(Integer id) {
        return manager.deleteByID(namespace+"delete",id);
    }
}
