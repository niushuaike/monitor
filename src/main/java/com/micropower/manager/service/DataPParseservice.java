package com.micropower.manager.service;

import com.micropower.manager.model.po.RawData;
import com.micropower.manager.model.po.RawDataP;
import com.micropower.manager.utils.OxConvertUtil;
import com.micropower.manager.utils.PParseDataUtil;
import com.micropower.manager.utils.ParseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by oliver on 2017/9/5.
 */
@Service
public class DataPParseservice {

    @Autowired
    private ServletContext servletContext;

    private SimpleDateFormat formatHM;

    private SimpleDateFormat formatT;

    public DataPParseservice() {
        formatHM = new SimpleDateFormat("hh:mm");
        formatT = new SimpleDateFormat("yyyyMMddhhmmSS");
    }

    public Map<String,String> getRecentJZData() {
        RawDataP rawDataP = null;
        RawData rawData = null;
        try {
            rawDataP = PParseDataUtil.parseRecentOneData((String) servletContext.getAttribute("labor_data_path"));
            rawData = ParseDataUtil.parseRecentOneData((String) servletContext.getAttribute("cabinet_data_path"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> map = OxConvertUtil.obj2Map(rawDataP);
        if (rawData!=null){
            map.put("xnwd",rawData.getTemperature());
        }
        rawDataP.getSbktzt().contains("0");
        if (rawDataP!=null){
            if (rawDataP.getSbktzt().contains("0")){
                map.put("sbktztstatus","停止");
            }else {
                map.put("sbktztstatus","运转");
            }
            if (rawDataP.getGzzt().contains("0")){
                map.put("gzztstatus","异常");
            }else {
                map.put("gzztstatus","正常");
            }
        }
        return map;
    }

    public Map<String, List> getJiZuSumT(int dataNum) {
        Map<String, List> map = new HashMap<>();
        List<RawDataP> list = null;
        try {
            list = PParseDataUtil.parseRecentListData(dataNum, (String) servletContext.getAttribute("cabinet_data_path"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> time = new ArrayList<>();
        List<Float> temperature = new ArrayList<>();
        Collections.reverse(list);
        for (RawDataP rawDataP:list){
            Date date = null;
            try {
                date = formatT.parse(rawDataP.getDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            time.add(formatHM.format(date));
            temperature.add(Float.parseFloat(rawDataP.getXnwd()));
        }
        map.put("time",time);
        map.put("temperature",temperature);
        return map;
    }

}
