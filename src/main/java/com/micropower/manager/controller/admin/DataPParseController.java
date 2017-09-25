package com.micropower.manager.controller.admin;

import com.micropower.manager.service.DataPParseservice;
import com.micropower.manager.service.DataParseservice;
import com.micropower.manager.service.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oliver on 2017/9/5.
 */

@Controller
@RequestMapping("/datap")
public class DataPParseController {

    @Autowired
    private DataPParseservice dataPParseservice;

    @ResponseBody
    @RequestMapping("/getRecentOneP")
    public Map<String,String> getRecentOneP(){
        return dataPParseservice.getRecentJZData();
    }

   @ResponseBody
    @RequestMapping("/getJiZuTHinfo")
    public Map<String,List> getJiZuTHinfo(Integer requestFlag){
        Map<String,List> map = new HashMap<>();
        if (requestFlag==1){
            map = dataPParseservice.getJiZuSumT(7);
        }else if (requestFlag>1){
            map = dataPParseservice.getJiZuSumT(7);
        }
        return map;
    }

    /* @Autowired
    ScheduleTask scheduleTask;

    @ResponseBody
    @RequestMapping("/schedule")
    public String schedule(Integer requestFlag){
       scheduleTask.bTask();
        return "";
    }*/
}
