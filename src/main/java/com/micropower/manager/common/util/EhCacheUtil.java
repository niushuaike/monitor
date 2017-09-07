package com.micropower.manager.common.util;

import com.lycheeframework.core.common.util.SpringUtil;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * EhCache
 * 
 * @author li.hui
 *
 */
public class EhCacheUtil {
	
	private static Ehcache ehCache;
	
	static {
		if (ehCache == null) ehCache = SpringUtil.getBean(Ehcache.class);
	}
	
	public static void put(String key, Object value) {
		Element element = new Element(key, value);
		ehCache.put(element);
	}
	
	public static Object get(String key) {
		Element element = ehCache.get(key);
		
		return (element == null)?null:element.getObjectValue();
	}
}