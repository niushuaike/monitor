package com.micropower.manager.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by niushuaike on 2017/9/11.
 */
public class BaseController {

    public Map<String, String> getParamesMapMy(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();

        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        Map<String,String> map = new HashMap<>();
        for (Map.Entry<String, String[]> entry:entries){
            map.put(entry.getKey(),""+entry.getValue()[0]);
        }
        return map;
    }
}
