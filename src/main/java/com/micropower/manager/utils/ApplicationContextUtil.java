/**
 * Project Name:backgroundManagementSystem
 * File Name:ApplicationContextUtil.java
 * Package Name:com.micropower.common
 * Date:Jun 19, 20165:32:30 PM
 * Copyright (c) 2016, 1173499611@qq.com All Rights Reserved.
 *
*/

package com.micropower.manager.utils;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ClassName:ApplicationContextUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     Jun 19, 2016 5:32:30 PM <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */

public class ApplicationContextUtil implements ApplicationContextAware {  
    
    private static ApplicationContext context;//声明一个静态变量保存  
    @Override  
    public void setApplicationContext(ApplicationContext applicationContext)  
            throws BeansException {  
        this.context=applicationContext;  
    }  
  
    public static ApplicationContext getContext(){  
          return context;  
    }  
}  

