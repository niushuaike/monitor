package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.Role;
import com.micropower.manager.model.po.User;
import com.micropower.manager.model.pojo.UserPojo;
import com.micropower.manager.service.RoleService;
import com.micropower.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliver on 2017/9/4.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private RoleService roleService;

    @Override
    public Integer delete(Integer id) {
        return manager.deleteByID(namespace+"delete",id);
    }

    @Override
    public List<User> list() {
        return (List<User>) manager.list(namespace+"list");
    }

    @Override
    public List<UserPojo> listpojo() {
        List<UserPojo> listpojos = new ArrayList<>();
        List<User> list = list();
        for(User user:list){
            UserPojo userPojo = new UserPojo();
            userPojo.setUser(user);
            Role role = roleService.queryById(user.getRole());
            userPojo.setRole(role);
            listpojos.add(userPojo);
        }
        return listpojos;
    }

    @Override
    public User login(User user) {
        User user1 = manager.getSqlSessionTemplate().selectOne("getUser", user.getUsername());
        if (user1!=null&&user.getPassword().equals(user1.getPassword())){

            return user1;
        }
        return null;
    }
}
