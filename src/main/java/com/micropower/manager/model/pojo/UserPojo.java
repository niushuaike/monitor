package com.micropower.manager.model.pojo;

import com.micropower.manager.model.po.Role;
import com.micropower.manager.model.po.User;

/**
 * Created by oliver on 2017/9/11.
 */
public class UserPojo {
    private User user;
    private Role role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
