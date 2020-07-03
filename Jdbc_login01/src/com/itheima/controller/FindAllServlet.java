package com.itheima.controller;

import com.itheima.dao.Userdao;
import com.itheima.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findall")
public class FindAllServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        Userdao userdao = new Userdao();
        List<User> list = userdao.findall();
        for (User u : list) {
            System.out.println(u.getUsername()+u.getPassword());
        }
    }
}
