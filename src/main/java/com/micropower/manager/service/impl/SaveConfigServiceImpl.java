package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.Saveconfig;
import com.micropower.manager.service.SaveConfigService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oliver on 2017/9/4.
 */
@Service
public class SaveConfigServiceImpl extends BaseServiceImpl<Saveconfig> implements SaveConfigService {
    @Override
    public List<Saveconfig> list() {
        return (List<Saveconfig>) manager.list(namespace+"list");
    }
}
