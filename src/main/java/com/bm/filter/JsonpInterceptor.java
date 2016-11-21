package com.bm.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;

/**
 * Created by Administrator on 2016/11/20.
 */
public class JsonpInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.printf("before request handle...");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        System.out.printf("handle...");
        boolean jsonP = false;
        String cb = request.getParameter("callback");
        if (cb != null) {
            jsonP = true;
            response.setContentType("text/javascript");
        } else {
            response.setContentType("application/x-json");
        }
        Writer out = response.getWriter();

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.printf("after...");

    }
}
