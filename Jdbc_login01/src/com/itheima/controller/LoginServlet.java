package com.itheima.controller;

import com.itheima.dao.Userdao;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/users")
public class LoginServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        String method = req.getParameter("method");

        if(method.equalsIgnoreCase("login")){

            login(req,resp);

        }
//        super.service(req, res);
    }

    public void login(HttpServletRequest req,HttpServletResponse resp){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //执行校验登陆逻辑
        Userdao userdao = new Userdao();
        boolean flag = userdao.findByUsernameAndPassword(username, password);
        if(flag){
            //System.out.println("登陆成功");
            try {
                req.getRequestDispatcher("/findall").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
