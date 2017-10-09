package com.micropower.manager.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.micropower.manager.common.util.SessionUtil;
import com.micropower.manager.model.po.User;
import org.apache.commons.lang.StringUtils;

public class RequestFilter implements Filter {

    private boolean filterEnabled = true;

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if (true == filterEnabled) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            String ctxPath = httpRequest.getContextPath();            //������������·��,���� : /park
            String requestUri = httpRequest.getRequestURI();        //�����ȫ·��,����:		 	/park/app/controller/Main.js
            String uri = requestUri.substring(ctxPath.length());//ȫ·����ȥctxPath,���磺	/app/controller/Main.js
            String tarUri = uri.trim();
            String reference = ((HttpServletRequest) request).getHeader("referer");
            String s = "";
            if (reference!=null){
            String[] split = reference.split("/");
                s = split[2];
            }
            String main_control_ip = (String) request.getServletContext().getAttribute("main_control_ip");

            Object userObj = SessionUtil.getAttribute("user");
            boolean loginFlag = false;
            if (!StringUtils.isEmpty(s) && main_control_ip.contains(s)) {
                chain.doFilter(request, response);
                SessionUtil.setAttribute("user", new User());
            } else {
                if (null != userObj && userObj instanceof User) {
                    loginFlag = true;
                    chain.doFilter(request, response);
                } else {
                    httpResponse.sendRedirect(ctxPath + "/monitorno/logo");
                }

            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        String filterEnabledStr = config.getInitParameter("filterEnabled");
        if (filterEnabledStr != null && !filterEnabledStr.trim().isEmpty()) {
            if (filterEnabledStr.trim().equals("false")) {
                filterEnabled = false;
            }
        }
    }

}
