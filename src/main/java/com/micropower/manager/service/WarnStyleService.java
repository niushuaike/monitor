package com.micropower.manager.service;

import com.micropower.manager.model.po.Warnstyle;
import com.micropower.manager.model.po.Warntimeperiod;
import com.micropower.manager.model.po.Warntype;

import java.util.List;

/**
 * Created by niushuaike on 2017/9/7.
 */
public interface WarnStyleService extends BaseService<Warnstyle> {
    List<Warntimeperiod> list();
}
