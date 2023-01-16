package com.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //是否登陆过判断
        if(request.getSession().getAttribute("users")==null){
            request.setAttribute("msg","没登录，去登录");
            request.getRequestDispatcher("/admin/login.jsp").forward(request,response);
            return false;
        }


        return true;
    }
}
