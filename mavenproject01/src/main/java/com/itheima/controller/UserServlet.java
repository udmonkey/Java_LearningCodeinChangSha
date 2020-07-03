package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/item/findAll")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String pageNum=req.getParameter("currentPage");
        String pageSize=req.getParameter("pageSize");
        UserServiceImpl userService = new UserServiceImpl();
        Page<User> pagelist = userService.findAll(pageNum, pageSize);
        PageInfo<User> userPageInfo = new PageInfo<>(pagelist);
        System.out.println(userPageInfo);
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(userPageInfo);
        resp.getWriter().write(json);
    }
}
