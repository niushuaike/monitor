package com.micropower.manager.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtil {
	private static HttpServletRequest getHttpRequest(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	private static HttpSession getSession(){
		return getHttpRequest().getSession();
	}
	
	public static void setAttribute(String attrName, Object attr){
		HttpSession httpSession = getSession();
	    httpSession.setAttribute(attrName, attr);
	}
	
	public static Object getAttribute(String attrName){
	    HttpSession httpSession = getSession();
	    return httpSession.getAttribute(attrName);
	}
	
	public static void destroySession(){
		getSession().invalidate();
	}
	

}
