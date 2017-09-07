package com.micropower.manager.service;

import com.micropower.manager.model.po.RawData;
import com.micropower.manager.utils.ParseDataUtil;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by oliver on 2017/9/5.
 */
@Service
public class DataParseservice {

    public Map<String, String> getAllInfo() {
        Map<String, String> map = new HashMap<String, String>();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = dateFormat.format(date);
        try {
            RawData rawData = ParseDataUtil.parseRecentOneData(20170811 + ".data");

            if ("0".equals(rawData.getFrontGate())) {
                map.put("frontGate", "关");
            } else if ("1".equals(rawData.getFrontGate())) {
                map.put("frontGate", "开");
            }
            if ("0".equals(rawData.getBackGate())) {
                map.put("backGate", "关");
            } else if ("1".equals(rawData.getBackGate())) {
                map.put("backGate", "开");
            }

            if ("0".equals(rawData.getSmoke())) {
                map.put("smoke", "正常");
            } else if ("1".equals(rawData.getSmoke())) {
                map.put("smoke", "告警");
            }
            if ("0".equals(rawData.getInfrared())) {
                map.put("infrared", "正常");
            } else if ("1".equals(rawData.getInfrared())) {
                map.put("infrared", "告警");
            }
            if ("0".equals(rawData.getFlood())) {
                map.put("flood", "正常");
            } else if ("1".equals(rawData.getFlood())) {
                map.put("flood", "告警");
            }
            map.put("temperature",rawData.getTemperature()+"℃");
            map.put("humidity",rawData.getHumidity()+"%");
            map.put("voltage",rawData.getVoltage()+"V");
            map.put("current1",rawData.getCurrent1()+"A");



        } catch (Exception e) {
            map.put("error", "数据解析异常，或者文件未找到！");
        }
        return map;
    }
}
