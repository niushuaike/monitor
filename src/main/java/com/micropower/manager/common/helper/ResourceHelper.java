/**
 * Copyright 2014-2015 www.hzchanges.com
 * All rights reserved.
 * 
 * @project
 * @author li.hui
 * @version 1.0
 * @date 2015-11-23
 */
package com.micropower.manager.common.helper;

import com.lycheeframework.core.common.util.MapUtil;
import com.lycheeframework.core.common.util.StringUtil;
import com.micropower.manager.common.util.EhCacheUtil;
import com.micropower.manager.model.po.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 资源帮助类型
 * @author pro
 *
 */
public class ResourceHelper {
	
	/**
	 * 根据资源ID获取显示的值
	 * @param id
	 * @return
	 */
	public static String getDisplayValue(int id) {
		Resource resource = getResource(id);
		if (resource == null) return null;
		
		return resource.getDisplayValue();
	}
	
	/**
	 * 根据ID查询资源对象
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Resource getResource(int id) {
		if (id <=0) return null;
		
		Map<Integer, Resource> resourceMap = (Map<Integer, Resource>) EhCacheUtil.get("resourceMap");
		if (MapUtil.isEmpty(resourceMap)) return null;
		
		return resourceMap.get(id);
	}
	
	/**
	 * 根据资源的key查询资源列表
	 * @param resKey
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Resource> listResource(String resKey){
		if(StringUtil.isEmpty(resKey))return null;
		
		List<Resource> allList = (List<Resource>) EhCacheUtil.get("resourceList");
		Map<String,List<Resource>> data = new HashMap<String,List<Resource>>();
		for(Resource resource : allList){
			List<Resource> list = data.get(resource.getResourceKey());
			if(list == null){
				list = new ArrayList<Resource>();
			}
			
			list.add(resource);
			data.put(resource.getResourceKey(), list);
		}
		
		return data.get(resKey);
	}
}