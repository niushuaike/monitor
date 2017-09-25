package com.micropower.manager.utils;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by niushuaike on 2017/9/17.
 */
public class OxConvertUtil {

    public  static <T> T properties2bean(String propertiesPath, Class<T> cls) {
        Properties properties = new Properties();
        T t;
        try {
            InputStream resourceAsStream = OxConvertUtil.class.getResourceAsStream(propertiesPath);
            properties.load(resourceAsStream);
            Enumeration<?> enumeration = properties.propertyNames();
            t = cls.newInstance();
            Field[] declaredFields = cls.getDeclaredFields();
            while (enumeration.hasMoreElements()) {
                String o = (String) enumeration.nextElement();
                for (int i = 0; i < declaredFields.length; i++) {
                    Field declaredField = declaredFields[i];
                    String fieldName = declaredField.getName();
                    if (o.equals(fieldName)) {
                        Method method = cls.getDeclaredMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), String.class);
                        method.invoke(t, new Object[]{properties.getProperty(fieldName)});
                    }
                }
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> obj2Map(Object obj) {

        Map<String, String> map = new HashMap<String, String>();
        // System.out.println(obj.getClass());
        // 获取f对象对应类中的所有属性域
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
            varName = varName.toLowerCase();//将key置为小写，默认为对象的属性
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o = fields[i].get(obj);
                if (o != null)
                    map.put(varName, o.toString());
                // System.out.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }

}
