package com.micropower.manager.service;

import com.micropower.manager.model.po.RawData;
import com.micropower.manager.utils.ParseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by oliver on 2017/9/5.
 */
@Service
public class DataParseservice {

    @Autowired
    private ServletContext servletContext;

    private SimpleDateFormat formatHM;

    public DataParseservice() {
        formatHM = new SimpleDateFormat("hh:mm");
    }

    public Map<String, String> getAllInfo() {
        Map<String, String> map = new HashMap<String, String>();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String fileName = dateFormat.format(date);
        try {
            RawData rawData = ParseDataUtil.parseRecentOneData((String) servletContext.getAttribute("cabinet_data_path"));
            map = ParseDataUtil.getDeviceStatus(rawData);


        } catch (Exception e) {
            map.put("error", "数据解析异常，或者文件未找到！");
        }
        return map;
    }

    public Map<String, List> getSumTH(int dataNum) {
        Map<String, List> map = new HashMap<>();
        List<RawData> list = null;
        try {
            list = ParseDataUtil.parseRecentListData(dataNum, (String) servletContext.getAttribute("cabinet_data_path"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> time = new ArrayList<>();
        List<Float> temperature = new ArrayList<>();
        List<Float> humidity = new ArrayList<>();
        for (int i = (list.size()-1); i>=0; i--) {
            time.add(formatHM.format(list.get(i).getDate()));
            temperature.add(Float.parseFloat(list.get(i).getTemperature()));
            humidity.add(Float.parseFloat(list.get(i).getHumidity()));
        }
        map.put("time",time);
        map.put("temperature",temperature);
        map.put("humidity",humidity);
        return map;
    }
}
