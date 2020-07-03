package com.sms.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.sms.domain.Student;
import com.sms.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
    StudentServiceImpl studentService=new StudentServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String method = req.getParameter("method");

        if(method.equalsIgnoreCase("selectByPage")){
            selectByPage(req,resp);
        }else if(method.equalsIgnoreCase("addStu")){
            addStu(req,resp);
        }else if(method.equalsIgnoreCase("updateStu")){
            updateStu(req,resp);
        }else if(method.equalsIgnoreCase("deleteStu")){
            deleteStu(req,resp);
        }
    }

    //删除
    //修改
    //添加
    //分页展示
   private void deleteStu(HttpServletRequest req, HttpServletResponse resp) {
       String number = req.getParameter("number");
       Integer successNum = studentService.delete(number);
       if(successNum==1){
           selectByPage(req, resp);
       }else{
           System.out.println("删除错误");
       }
   }
    private void updateStu(HttpServletRequest req, HttpServletResponse resp) {
        Student student = new Student();

        student.setNumber(req.getParameter("number"));
        student.setName(req.getParameter("name"));
        student.setAddress(req.getParameter("address"));
        String birthdayStr = req.getParameter("birthday");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(birthdayStr);
            student.setBirthday(new java.sql.Date(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer successNum = studentService.update(student);

        if(successNum==1){
            selectByPage(req, resp);
        }else{
            System.out.println("修改错误");
        }
    }

    private void addStu(HttpServletRequest req, HttpServletResponse resp) {
        Student student = new Student();

        student.setNumber(req.getParameter("number"));
        student.setName(req.getParameter("name"));
        student.setAddress(req.getParameter("address"));
        String birthdayStr = req.getParameter("birthday");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(birthdayStr);
            student.setBirthday(new java.sql.Date(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Integer successNum = studentService.addStu(student);
        if(successNum==1){
            selectByPage(req, resp);
        }else{
            System.out.println("添加错误");
        }


    }


    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) {

        Integer currentPage = Integer.parseInt(req.getParameter("currentPage"));
        Integer pageSize = Integer.parseInt(req.getParameter("pageSize"));

        Page<Student> pagelist = studentService.selectByPage(currentPage, pageSize);
        //封装
        PageInfo<Student> pageInfo = new PageInfo<>(pagelist);

        ObjectMapper om = new ObjectMapper();
        try {
            String pageInfoJson = om.writeValueAsString(pageInfo);
            resp.getWriter().write(pageInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
