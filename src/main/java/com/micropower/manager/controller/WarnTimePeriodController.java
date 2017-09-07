package com.micropower.manager.controller;

import com.lycheeframework.core.cmp.api.http.GsonData;
import com.lycheeframework.core.cmp.api.http.GsonResponse;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.model.po.User;
import com.micropower.manager.model.po.Warntimeperiod;
import com.micropower.manager.service.UserService;
import com.micropower.manager.service.WarntimeperiodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by oliver on 2017/9/4.
 */
@Controller
@RequestMapping("/warntimeperiod")
public class WarnTimePeriodController {

    @Autowired
    private WarntimeperiodService service;

    @ResponseBody
    @RequestMapping("/page")
    public GsonData page(EasyPage page){
        return GsonResponse.toData(service.getPages(null,page));
    }

    @ResponseBody
    @RequestMapping("/add")
    public Integer add(Warntimeperiod warntimeperiod){
        return service.create(warntimeperiod);
    }

    @RequestMapping("/toEditUI")
    public String toEditUI(Integer id, Model model){
        Warntimeperiod warntimeperiod = service.queryById(id);
        model.addAttribute("user",warntimeperiod);
        return "";
    }

    @ResponseBody
    @RequestMapping("/saveEdit")
    public Integer saveEdit(User user){
        Warntimeperiod warntimeperiod = service.queryById(user.getId());
        if(warntimeperiod!=null)
            return service.update(warntimeperiod);
        else
            return service.create(warntimeperiod);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Integer delete(Integer id){
       return service.delete(id);
    }

}
