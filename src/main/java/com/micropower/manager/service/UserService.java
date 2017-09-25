package com.micropower.manager.service;

import com.micropower.manager.model.po.Threshold;
import com.micropower.manager.model.po.User;
import com.micropower.manager.model.pojo.UserPojo;

import java.util.List;

/**
 * Created by oliver on 2017/9/4.
 */
public interface UserService extends BaseService<User> {

    Integer delete(Integer id);

    List<User> list();

    List<UserPojo> listpojo();

    User login(User user);
}
