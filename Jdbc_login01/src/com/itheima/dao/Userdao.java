package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Userdao {
    public static void main(String[] args) {
        Userdao userdao = new Userdao();
        userdao.findByUsernameAndPassword("zhangsan","123");
    }

    public boolean findByUsernameAndPassword(String username,String password){
        try {
            Connection con = JdbcUtil.getcon();
            String sql = "select * from user where username = ? and password =? ";
            PreparedStatement psttm = con.prepareStatement(sql);
            psttm.setString(1,username);
            psttm.setString(2,password);
            ResultSet rs = psttm.executeQuery();
            //System.out.println(rs.next());
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> findall(){
        List<User> list = new ArrayList<User>();
        try {
            Connection con = JdbcUtil.getcon();
            String sql = "select * from user";
            PreparedStatement psttm = con.prepareStatement(sql);
            ResultSet rs = psttm.executeQuery();
            while (rs.next()){
                User user = new User();

                user.setUid( rs.getInt("uid"));
                user.setUsername( rs.getString("username"));
                user.setPassword( rs.getString("password"));
                list.add(user);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
