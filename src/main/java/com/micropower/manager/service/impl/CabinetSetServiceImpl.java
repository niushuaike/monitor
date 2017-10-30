package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.Cabinetparamter;
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
    public Integer recoverDeafult() {
        Cabinetparamter cabinetparamter1 = queryParameterByType("1");
        cabinetparamter1.setParametertype("2");
        cabinetparamter1.setIsupdate("1");
        return update(cabinetparamter1);
    }

    @Override
    public Cabinetparamter queryParameterByType(String parametertype) {
        Cabinetparamter cabinetSet = (Cabinetparamter) manager.query(namespace + "queryParameterByType", parametertype);
        return cabinetSet;
    }
}
