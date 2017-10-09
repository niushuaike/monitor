package com.micropower.manager.utils;

import com.lycheeframework.core.common.util.SpringUtil;
import com.micropower.manager.service.impl.DeviceServiceImpl;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by niushuaike on 2017/9/21.
 */
public class MyListener extends ContextLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        System.out.println("开始使用我的listener！！！");
        Properties properties = new Properties();
        try {
            properties.load(MyListener.class.getResourceAsStream("/config_var.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String returnstr = "";
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "SELECT id,maincontrolip FROM device WHERE device_type=1";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                returnstr = resultSet.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        ServletContext servletContext = event.getServletContext();
        servletContext.setAttribute("main_control_ip",returnstr);
        servletContext.setAttribute("labor_data_path",properties.getProperty("labor_data_path"));
        servletContext.setAttribute("cabinet_data_path",properties.getProperty("cabinet_data_path"));
        servletContext.setAttribute("ysjOneStartTime",properties.getProperty("ysjOneStartTime"));
        servletContext.setAttribute("ysjTwoStartTime",properties.getProperty("ysjTwoStartTime"));
    }
}
