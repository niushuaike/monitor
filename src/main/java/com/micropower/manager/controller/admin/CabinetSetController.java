package com.micropower.manager.controller.admin;

import com.micropower.manager.model.po.Alarmthreshold;
import com.micropower.manager.model.po.Cabinetparamter;
import com.micropower.manager.service.AlarmthresholdService;
import com.micropower.manager.service.CabinetSetService;
import com.micropower.manager.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by niushuaike on 2017/9/16.
 */
@Controller
@RequestMapping("/bjm/cabinetSet")
public class CabinetSetController {

    @Autowired
    private CabinetSetService cabinetSetService;

    @ResponseBody
    @RequestMapping("/queryParameterByType")
    public Cabinetparamter queryParameterByType(String parametertype) {
        return cabinetSetService.queryParameterByType(parametertype);
    }


    @ResponseBody
    @RequestMapping("/updateCabinetByType")
    public Integer updateCabinetByType(Cabinetparamter cabinetparamter) {
        return cabinetSetService.update(cabinetparamter);
    }

    @ResponseBody
    @RequestMapping("/updateCabinet1")
    public Integer updateAlarmThreshold1(String data) {
        Cabinetparamter cabinetparamter = (Cabinetparamter) JsonUtils.jsonToObject(Cabinetparamter.class, data);
        return cabinetSetService.update(cabinetparamter);
    }

    @ResponseBody
    @RequestMapping("/recoverDefault")
    public Integer recoverDefault() {
        return cabinetSetService.recoverDeafult();
    }

}
