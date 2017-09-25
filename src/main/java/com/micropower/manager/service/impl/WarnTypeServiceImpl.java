package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.Device;
import com.micropower.manager.model.po.Warntype;
import com.micropower.manager.service.WarnTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by niushuaike on 2017/9/7.
 */
@Service
public class WarnTypeServiceImpl extends BaseServiceImpl<Warntype> implements WarnTypeService {
    @Override
    public List<Warntype> list() {
        return (List<Warntype>) manager.list(namespace+"list");
    }
}
