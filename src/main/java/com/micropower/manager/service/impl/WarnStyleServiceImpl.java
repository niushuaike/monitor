package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.Warnstyle;
import com.micropower.manager.model.po.Warntimeperiod;
import com.micropower.manager.model.po.Warntype;
import com.micropower.manager.service.WarnStyleService;
import com.micropower.manager.service.WarnTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by niushuaike on 2017/9/7.
 */
@Service
public class WarnStyleServiceImpl extends BaseServiceImpl<Warnstyle> implements WarnStyleService {
    @Override
    public List<Warntimeperiod> list() {
        return (List<Warntimeperiod>) manager.list(namespace+"list");
    }
}
