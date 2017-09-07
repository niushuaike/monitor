package com.micropower.manager.controller;

import com.lycheeframework.core.cmp.api.http.GsonData;
import com.lycheeframework.core.cmp.api.http.GsonResponse;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.model.po.User;
import com.micropower.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by oliver on 2017/9/4.
 */
@Controller
@RequestMapping("/labor")
public class LaborController {

    @Autowired
    private UserService service;

    @ResponseBody
    @RequestMapping("/page")
    public GsonData page(EasyPage page){
        return GsonResponse.toData(service.getPages(null,page));
    }


    @ResponseBody
    @RequestMapping("/add")
    public Integer add(User user){
        return service.create(user);
    }

    @RequestMapping("/toEditUI")
    public String toEditUI(Integer id, Model model){
        User user = service.queryById(id);
        model.addAttribute("user",user);
        return "";
    }

    @ResponseBody
    @RequestMapping("/saveEdit")
    public Integer saveEdit(User user){
        User user1 = service.queryById(user.getId());
        if(user1!=null)
            return service.update(user);
        else
            return service.create(user);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Integer delete(Integer id){
       return service.delete(id);
    }

}
