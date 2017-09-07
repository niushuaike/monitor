package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.Threshold;
import com.micropower.manager.model.po.User;
import com.micropower.manager.service.ThresholdService;
import com.micropower.manager.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by oliver on 2017/9/4.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Override
    public Integer delete(Integer id) {
        return manager.deleteByID(namespace+"delete",id);
    }
}
