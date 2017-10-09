package com.micropower.manager.service;

import com.micropower.manager.model.po.Alarmthreshold;
import com.micropower.manager.model.po.Device;
import com.micropower.manager.model.pojo.DevicePojo;

import java.util.List;
import java.util.Map;

/**
 * Created by oliver on 2017/9/4.
 */
public interface AlarmthresholdService extends BaseService<Alarmthreshold> {

    Integer recoverDeafult();

    Alarmthreshold queryByThresholdtype(String thresholdtype);
}
