package com.bm.filter;

import com.bm.entity.SysUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2016/9/13.
 */
public class SystemLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("sysUser");
        if(sysUser==null){
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            response.sendRedirect("/goLogin");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
