package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.Warnlog;
import com.micropower.manager.service.WarnLogService;
import org.springframework.stereotype.Service;

/**
 * Created by oliver on 2017/9/5.
 */
@Service
public class WarnLogServiceImpl extends BaseServiceImpl<Warnlog> implements WarnLogService {
    @Override
    public Integer delete(Integer id) {
        return manager.deleteByID("delete",id);
    }
}
