package com.micropower.manager.controller.admin;

import com.micropower.manager.service.DataParseservice;
import com.micropower.manager.service.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
@RequestMapping("/data")
public class DataParseController {

    @Autowired
    private DataParseservice service;

    @ResponseBody
    @RequestMapping("/allinfo")
    public Map<String,String> allinfo(HttpServletRequest request){
        return service.getAllInfo();
    }

    @ResponseBody
    @RequestMapping("/getTHinfo")
    public Map<String,List> getTHinfo(Integer requestFlag){
        Map<String,List> map = new HashMap<>();
        if (requestFlag==1){
            map = service.getSumTH(7);
        }else if (requestFlag>1){
            map = service.getSumTH(7);
        }
        return map;
    }

    @Autowired
    ScheduleTask scheduleTask;

    @ResponseBody
    @RequestMapping("/schedule")
    public String schedule(Integer requestFlag){
       scheduleTask.bTask();
        return "";
    }
}
