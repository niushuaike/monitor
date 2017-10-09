package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.*;
import com.micropower.manager.service.*;
import com.micropower.manager.utils.OxConvertUtil;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by oliver on 2017/9/4.
 */
@Service
public class AlarmthresholdServiceImpl extends BaseServiceImpl<Alarmthreshold> implements AlarmthresholdService {



    @Override
    public Integer recoverDeafult() {
        Alarmthreshold alarmthreshold1 = queryByThresholdtype("1");
        alarmthreshold1.setThresholdtype("0");
        return update(alarmthreshold1);
    }

    @Override
    public Alarmthreshold queryByThresholdtype(String thresholdtype) {
        Alarmthreshold alarmthreshold = (Alarmthreshold) manager.query(namespace+"queryByThresholdtype",thresholdtype);
        return alarmthreshold;
    }
}
