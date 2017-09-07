package com.micropower.manager.common.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import com.lycheeframework.core.cmp.api.error.IECode;
import com.lycheeframework.core.common.util.StringUtil;

public enum MECode implements IECode {
	
	account_3000004(3000004)
	;
	
	private int code;
	
	MECode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		
		return code;
	}
	
	public String getMessage() {
		
		return new RequestContext(this.request()).getMessage(String.valueOf(this.getCode()));
	}
	
	public String toString() {
		String message = this.getMessage();

		return String.valueOf(this.getCode()).concat(SPLIT_CHAR).concat((StringUtil.isEmpty(message)?"":message));
	}

	public String toDynamicString(Object... parameters) {
		
		return String.format(this.toString(), parameters);
	}
	
	private HttpServletRequest request() {
		
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
}