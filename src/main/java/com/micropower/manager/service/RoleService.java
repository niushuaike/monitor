package com.micropower.manager.service;

import com.micropower.manager.model.po.Role;

import java.util.List;

/**
 * Created by oliver on 2017/9/4.
 */
public interface RoleService extends BaseService<Role> {
    List<Role> list();
}
