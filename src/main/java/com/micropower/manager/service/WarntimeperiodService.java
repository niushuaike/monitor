package com.micropower.manager.service;

import com.micropower.manager.model.po.User;
import com.micropower.manager.model.po.Warntimeperiod;
import com.micropower.manager.model.pojo.WarntimeperiodPojo;

import java.util.List;

/**
 * Created by oliver on 2017/9/4.
 */
public interface WarntimeperiodService extends BaseService<Warntimeperiod> {

    Integer delete(Integer id);

    List<WarntimeperiodPojo> listpojo();

    List<Warntimeperiod> list();
}
