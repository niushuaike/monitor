package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.User;
import com.micropower.manager.model.po.Warntimeperiod;
import com.micropower.manager.service.UserService;
import com.micropower.manager.service.WarntimeperiodService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oliver on 2017/9/4.
 */
@Service
public class WarntimeperiodServiceImpl extends BaseServiceImpl<Warntimeperiod> implements WarntimeperiodService {
    @Override
    public Integer delete(Integer id) {
        return manager.deleteByID(namespace+"delete",id);
    }

    @Override
    public List<Warntimeperiod> list() {
        return (List<Warntimeperiod>) manager.list(namespace+"list");
    }
}
