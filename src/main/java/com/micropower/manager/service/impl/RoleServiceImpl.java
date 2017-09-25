package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.Role;
import com.micropower.manager.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oliver on 2017/9/4.
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    @Override
    public List<Role> list() {
        return (List<Role>) manager.list(namespace+"list");
    }
}
