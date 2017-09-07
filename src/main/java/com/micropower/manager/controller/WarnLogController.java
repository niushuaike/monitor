package com.micropower.manager.controller;

import com.lycheeframework.core.cmp.api.http.GsonData;
import com.lycheeframework.core.cmp.api.http.GsonResponse;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.model.po.User;
import com.micropower.manager.model.po.Warnlog;
import com.micropower.manager.service.WarnLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by oliver on 2017/9/5.
 */
@Controller
@RequestMapping("/warnlog")
public class WarnLogController {
    @Autowired
    private WarnLogService service;


    @ResponseBody
    @RequestMapping("/page")
    public GsonData page(EasyPage page){
        return GsonResponse.toData(service.getPages(null,page));
    }

    @RequestMapping("/toRepairUI")
    public String toRepairUI(Integer id, Model model){
        Warnlog warnlog = service.queryById(id);
        model.addAttribute("warnlog",warnlog);
        return "";
    }

    @ResponseBody
    @RequestMapping("/saveRepair")
    public Integer saveRepair(Warnlog warnlog){
        Warnlog warnlog1 = service.queryById(warnlog.getId());
        if(warnlog1!=null)
            return service.update(warnlog1);
        else
            return service.create(warnlog1);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Integer delete(Integer id){
        return service.delete(id);
    }

}
