package com.itheima.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3p0Util {
    public static void main(String[] args) {
        C3p0Util c3p0Util = new C3p0Util();
        Connection con = c3p0Util.getcon();
        String sql = "select * from user";
        try {
            PreparedStatement psttm = con.prepareStatement(sql);
            ResultSet rs = psttm.executeQuery();
            if(rs!=null){
                while (rs.next()){
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    System.out.println(username+":"+password);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Connection getcon(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            Connection con = ds.getConnection();
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
