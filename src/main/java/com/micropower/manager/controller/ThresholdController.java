package com.micropower.manager.controller;

import com.lycheeframework.core.cmp.api.http.GsonData;
import com.lycheeframework.core.cmp.api.http.GsonResponse;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.model.po.Threshold;
import com.micropower.manager.service.ThresholdService;
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
@RequestMapping("/threshold")
public class ThresholdController {

    @Autowired
    private ThresholdService service;

    @ResponseBody
    @RequestMapping("/page")
    public GsonData page(EasyPage page){
        return GsonResponse.toData(service.getPages(null,page));
    }


    @RequestMapping("/toEditUI")
    public String toEditUI(Integer id, Model model){
        Threshold threshold = service.queryById(id);
        model.addAttribute("threshold",threshold);
        return "";
    }

    @ResponseBody
    @RequestMapping("/saveEdit")
    public Integer saveEdit(Threshold threshold){
        Threshold threshold1 = service.queryById(threshold.getId());
        if(threshold1!=null)
            return service.update(threshold);
        else
            return service.create(threshold);
    }

    @ResponseBody
    @RequestMapping("/recoverDefault")
    public Integer recoverDefault(Integer thresholdid){
        Threshold threshold = service.queryById(thresholdid);
        if(thresholdid==1){
            threshold.setMin( 0);
            threshold.setMax( 43);
        }else{
            threshold.setMin( 10);
            threshold.setMax( 75);
        }

        return service.update(threshold);
    }

}
