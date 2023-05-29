package com.tomtao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理登录请求
 * 1.继承HttpServlet,才能够处理HTTP请求
 * 2.使用@WebServlet注解,指定访问路径
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet ----");
        doGet(req, resp);
    }

    @Override
    /**
     * @param HttpServletRequest req  请求对象: 用来获取客户端发送的数据
     * @param HttpServletResponse resp 响应对象: 用来给客户端返回数据
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost ----");
        // 1.获取客户端发送的数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username: " + username + ", password: " + password);
        // 2.判断
        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        if ("123".equals(username) && "456".equals(password)) {
            // 登录成功
            // 3.给客户端返回数据
            resp.getWriter().write("login success");
        } else {
            // 登录失败
            resp.getWriter().write("login failed");
        }
    }
}
