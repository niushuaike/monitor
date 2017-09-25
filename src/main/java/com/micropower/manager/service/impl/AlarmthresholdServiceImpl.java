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
    public Alarmthreshold queryOnlyOne() {
        List<Alarmthreshold> list = (List<Alarmthreshold>) manager.list(namespace + "queryOnlyOne123");
        return (Alarmthreshold) list.get(0);
    }

    @Override
    public Integer recoverDeafult() {
        Alarmthreshold alarmthreshold = OxConvertUtil.properties2bean("/threshold_default.properties", Alarmthreshold.class);
        return update(alarmthreshold);
    }
}
