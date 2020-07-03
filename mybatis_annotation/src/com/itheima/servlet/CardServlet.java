package com.itheima.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.Card;
import com.itheima.service.impl.CardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cardServlet")
public class CardServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req,resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet启动");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        CardServiceImpl cardService = new CardServiceImpl();
        List<Card> list = cardService.findall();

        ObjectMapper om = new ObjectMapper();
        String jsonStr = om.writeValueAsString(list);

        resp.getWriter().write(jsonStr);
    }
}
