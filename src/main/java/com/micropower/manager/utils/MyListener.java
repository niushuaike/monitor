package com.micropower.manager.utils;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.io.FileInputStream;
import java.io.IOException;
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
        ServletContext servletContext = event.getServletContext();
        servletContext.setAttribute("main_control_ip",properties.getProperty("main_control_ip"));
        servletContext.setAttribute("labor_data_path",properties.getProperty("labor_data_path"));
        servletContext.setAttribute("cabinet_data_path",properties.getProperty("cabinet_data_path"));
    }
}
