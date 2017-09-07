package com.micropower.manager.utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

/**
 * Created by oliver on 2017/9/5.
 */
public class NetUtils {


    public static void main(String[] args) {
        JSch jSch = new JSch();
        try {
            Session session = jSch.getSession("root", "192.168.199.137", 22);
            session.setPassword("");
            session.connect();

        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

}

class MyUserInfo implements UserInfo{


    @Override
    public String getPassphrase() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean promptPassword(String s) {
        return false;
    }

    @Override
    public boolean promptPassphrase(String s) {
        return false;
    }

    @Override
    public boolean promptYesNo(String s) {
        return false;
    }

    @Override
    public void showMessage(String s) {

    }
}
