package com.micropower.manager.utils;

import com.micropower.manager.model.po.Device;
import com.micropower.manager.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by niushuaike on 2017/9/30.
 */
@Component
public class ScheduleMonitorDeviceStatusRunnable implements Runnable{

    @Autowired
    ServletContext servletContext;

    @Autowired
    DeviceService deviceService;

    @Override
    public void run() {
        //判断关键设备状态
        List<Device> keyDevice = deviceService.getKeyDevice();
        String flag2 = "正常";
        for (int i = 0; i < keyDevice.size(); i++) {
            String normal = isNormal(keyDevice.get(i).getDeviceIp());
            if ("异常".equals(normal)){
                flag2="异常";
            }
        }
        servletContext.setAttribute("deviceStatus", flag2);
    }

    private String isNormal(String keyDeviceIp){
        try {
            Process exec = Runtime.getRuntime().exec("ping -c 4 "+keyDeviceIp);
            InputStream inputStream = exec.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
            String returnStr="";
            while (input.read() > 0) {
                returnStr+=input.readLine();
            }
            if (returnStr.contains("无法访问目标主机") || returnStr.contains("Destination Host Unreachable")) {
                return "异常";
            } else {
                return "正常";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "异常";
        }

    }
}
