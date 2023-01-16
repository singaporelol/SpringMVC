package com.learn.javaweb.servlet;

import bean.User;
import com.sun.istack.internal.Nullable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getSessionServlet")
public class GetSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getSessionServlet的doGet方法执行了");
        Object user = request.getSession().getAttribute("user");
        PrintWriter out = response.getWriter();
        if (user != null) {
            User user1= (User) user;
            System.out.println("存在session的用户：");
            System.out.println(user1);
        }else {
            System.out.println("seesion对象是空");
        }

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            // 遍历数组
            for (Cookie cookie : cookies) {
                // 获取cookie的name和value
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name + "=" + value);
            }
        }

    }
}
