package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.Student;
import com.itheima.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("studentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req,resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        StudentServiceImpl studentService = new StudentServiceImpl();
        List<Student> list = studentService.findAll();
        ObjectMapper om = new ObjectMapper();
        String jsonStr = om.writeValueAsString(list);
        resp.getWriter().write(jsonStr);
    }
}
