package com.micropower.manager.model.pojo;

import com.micropower.manager.model.po.*;
import com.micropower.manager.service.UserService;
import com.micropower.manager.service.impl.UserServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niushuaike on 2017/9/10.
 */
public class DevicePojo {

    Device device;
    List<User> usersList;
    Warnstyle warnstyle;
    Warntimeperiod warntimeperiod;
    String usersname = "";

    public String getUsersname() {
        return usersname;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
        for (User user : usersList) {
            usersname += user.getUsername() + ",";
        }
    }

    public Warnstyle getWarnstyle() {
        return warnstyle;
    }

    public void setWarnstyle(Warnstyle warnstyle) {
        this.warnstyle = warnstyle;
    }

    public Warntimeperiod getWarntimeperiod() {
        return warntimeperiod;
    }

    public void setWarntimeperiod(Warntimeperiod warntimeperiod) {
        this.warntimeperiod = warntimeperiod;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }


    public List<User> getUsersList() {
        return usersList;
    }

}
