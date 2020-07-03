package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Student;
import com.itheima.service.impl.StudentServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req,resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Integer pageNum=Integer.parseInt(req.getParameter("pageNum"));
        Integer pageSize=Integer.parseInt(req.getParameter("pageSize"));

        System.out.println("pageNum"+pageNum);
        System.out.println("pageSize"+pageSize);

        StudentServiceImpl studentService = new StudentServiceImpl();
        List<Student> list = studentService.findAll(pageNum,pageSize);

//        PageInfo<Student> pageinfo = new PageInfo<>(list);
//        HttpSession session = req.getSession();
//        session.setAttribute("pageinfo",pageinfo);

        ObjectMapper om = new ObjectMapper();
        String listJson = om.writeValueAsString(list);

        resp.getWriter().write(listJson);
    }
}
