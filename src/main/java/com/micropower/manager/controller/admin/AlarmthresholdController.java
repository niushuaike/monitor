package com.micropower.manager.controller.admin;

import com.alibaba.fastjson.JSON;
import com.lycheeframework.core.common.util.JSONUtil;
import com.micropower.manager.model.po.Alarmthreshold;
import com.micropower.manager.model.po.Device;
import com.micropower.manager.service.AlarmthresholdService;
import com.micropower.manager.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by niushuaike on 2017/9/16.
 */
@Controller
@RequestMapping("/bjm/alarmthreshold")
public class AlarmthresholdController {

    @Autowired
    private AlarmthresholdService alarmthresholdService;

    @ResponseBody
    @RequestMapping("/queryByThresholdtype")
    public Alarmthreshold queryByThresholdtype(String thresholdtype) {
        return alarmthresholdService.queryByThresholdtype(thresholdtype);
    }


    @ResponseBody
    @RequestMapping("/updateAlarmThreshold")
    public Integer updateAlarmThreshold(Alarmthreshold alarmthreshold) {
        return alarmthresholdService.update(alarmthreshold);
    }

    @ResponseBody
    @RequestMapping("/updateAlarmThreshold1")
    public Integer updateAlarmThreshold1(String data) {
        Alarmthreshold alarmthreshold = (Alarmthreshold) JsonUtils.jsonToObject(Alarmthreshold.class,data);
        return alarmthresholdService.update(alarmthreshold);
    }

    @ResponseBody
    @RequestMapping("/recoverDefault")
    public Integer recoverDefault() {
        return alarmthresholdService.recoverDeafult();
    }

}
