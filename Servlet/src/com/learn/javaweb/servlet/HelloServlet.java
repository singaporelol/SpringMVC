package com.learn.javaweb.servlet;

import bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class HelloServlet extends HttpServlet {

//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("sevice的方法执行了~~");
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        String username=request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println(username);
//        System.out.println(password);
//        User user= new User(username, password);
//        request.getSession().setAttribute("user",user);
//        String user1 = this.getInitParameter("user");
//        out.print("hello,你好");
//
//
//
//
//
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do get方法执行了");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<h1>deGet</h1>");
        // 创建Cookie对象
        Cookie cookie = new Cookie("productid", "12345645623145612");
        Cookie cookie2 = new Cookie("username", "zhangsan");
        cookie.setPath(request.getContextPath());
        cookie2.setPath(request.getContextPath());
        // 将cookie响应到浏览器
        response.addCookie(cookie);
        response.addCookie(cookie2);
        out.print("<h1>Cookie保存了！</h1>");
    }
}
