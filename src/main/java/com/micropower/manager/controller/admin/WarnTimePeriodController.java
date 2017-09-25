package com.micropower.manager.controller.admin;

import com.lycheeframework.core.cmp.api.http.GsonData;
import com.lycheeframework.core.cmp.api.http.GsonResponse;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.model.po.User;
import com.micropower.manager.model.po.Warntimeperiod;
import com.micropower.manager.model.pojo.WarntimeperiodPojo;
import com.micropower.manager.service.UserService;
import com.micropower.manager.service.WarntimeperiodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by oliver on 2017/9/4.
 */
@Controller
@RequestMapping("/jm/warntimeperiod")
public class WarnTimePeriodController {

    @Autowired
    private WarntimeperiodService service;

    @ResponseBody
    @RequestMapping("/listpojo")
    public List<WarntimeperiodPojo> listpojo(){
        return service.listpojo();
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<Warntimeperiod> list(){
        return service.list();
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
    public Integer saveEdit(WarntimeperiodPojo warntimeperiodPojo){
        Warntimeperiod warntimeperiod = service.queryById(warntimeperiodPojo.getId());
        Warntimeperiod warntimeperiod1 = warntimeperiodPojo.toWarntimeperiod();
        if(warntimeperiod!=null)
            return service.update(warntimeperiod1);
        else
            return service.create(warntimeperiod1);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Integer delete(Integer id){
       return service.delete(id);
    }

}
