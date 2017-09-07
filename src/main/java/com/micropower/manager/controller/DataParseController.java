package com.micropower.manager.controller;

import com.lycheeframework.core.cmp.api.http.GsonData;
import com.lycheeframework.core.cmp.api.http.GsonResponse;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.model.po.Device;
import com.micropower.manager.service.DataParseservice;
import com.micropower.manager.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Map<String,String> allinfo(){
        return service.getAllInfo();
    }


}
