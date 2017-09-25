package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.Alarmthreshold;
import com.micropower.manager.model.po.Cabinetparamter;
import com.micropower.manager.service.AlarmthresholdService;
import com.micropower.manager.service.CabinetSetService;
import com.micropower.manager.utils.OxConvertUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oliver on 2017/9/4.
 */
@Service
public class CabinetSetServiceImpl extends BaseServiceImpl<Cabinetparamter> implements CabinetSetService {


    @Override
    public Cabinetparamter queryOnlyOne() {
        List<Cabinetparamter> list = (List<Cabinetparamter>) manager.list(namespace + "queryOnlyOne");
        return (Cabinetparamter) list.get(0);
    }

    @Override
    public Integer recoverDeafult() {
        Cabinetparamter cabinetparamter = OxConvertUtil.properties2bean("/cabinet_set_default.properties", Cabinetparamter.class);
        return update(cabinetparamter);
    }
}
