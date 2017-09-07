/**
 * Copyright 2016-2017 com.nanf.cross.api
 * All rights reserved.
 * 
 * @project
 * @author jackey
 * @version 1.0
 * @date 2016年11月24日
 */
package com.micropower.manager.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.pagehelper.Page;
import com.github.pagehelper.StringUtil;

public class LastGoodsPage extends Page<Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LastGoodsPage() {
		this(getRequest());
	}
	
	public LastGoodsPage(int pageNum) {
		this(20, pageNum);
	}
	
	public LastGoodsPage(int pageSize, int pageNum) {
		this(pageSize, pageNum, null);
	}
	
	public LastGoodsPage(int pageSize, int pageNum, String sortField) {
		this(pageSize, pageNum, sortField, null);
	}
	
	public LastGoodsPage(int pageSize, int pageNum, String sortField, String sortOrder) {
		if (StringUtil.isNotEmpty(sortField)) {
			if (StringUtil.isEmpty(sortOrder)) sortOrder = "asc";
			
			setPages(pageSize, pageNum, sortField.toUpperCase().concat(" ").concat(sortOrder));
		} else {
			setPages(pageSize, pageNum, null);
		}
	}

	public LastGoodsPage(HttpServletRequest request) {
		String page = request.getParameter("page");
		int pageNum = 1;
		if (StringUtil.isNotEmpty(page)) {
			pageNum = new Integer(page).intValue();
		}
		
		String pageSize = request.getParameter("pageSize");
		int ps = 4;
		if (StringUtil.isNotEmpty(pageSize)) {
			ps = Integer.valueOf(pageSize);
		}
		
		
		setPages(ps, pageNum, null);
	}
	
	private void setPages(int pageSize, int pageNum, String orderBy) {
		this.setPageSize(pageSize);
		this.setPageNum(pageNum);
		this.setOrderBy(orderBy);
	}
	
	private static HttpServletRequest getRequest() {
		
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
}
