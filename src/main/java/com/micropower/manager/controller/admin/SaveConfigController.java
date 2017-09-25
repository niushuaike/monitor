package com.micropower.manager.controller.admin;

import com.lycheeframework.core.cmp.api.http.GsonData;
import com.lycheeframework.core.cmp.api.http.GsonResponse;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.model.po.Saveconfig;
import com.micropower.manager.service.SaveConfigService;
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
@RequestMapping("/jm/saveconfig")
public class SaveConfigController {

    @Autowired
    private SaveConfigService service;

    @ResponseBody
    @RequestMapping("/page")
    public GsonData page(EasyPage page){
        return GsonResponse.toData(service.getPages(null,page));
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<Saveconfig> list(){
        return service.list();
    }

    @RequestMapping("/toEditUI")
    public String toEditUI(Integer id, Model model){
        Saveconfig saveconfig = service.queryById(id);
        model.addAttribute("saveconfig",saveconfig);
        return "";
    }

    @ResponseBody
    @RequestMapping("/update")
    public Integer update(Saveconfig saveconfig){
        Saveconfig saveconfig1 = service.queryById(saveconfig.getId());
        if(saveconfig1!=null)
            return service.update(saveconfig);
        else
            return service.create(saveconfig);
    }

}
