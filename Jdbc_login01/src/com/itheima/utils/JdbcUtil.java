package com.itheima.utils;

import com.mysql.jdbc.JDBC4Connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    public static void main(String[] args) {
        Connection con = JdbcUtil.getcon();
        System.out.println("连接对象="+con);
    }
    public JdbcUtil() {}

    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;



    static{
        try {
            InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("config.properties");
            Properties prop = new Properties();
            prop.load(is);
            driverClass =prop.getProperty("driverClass");
            url =prop.getProperty("url");
            username =prop.getProperty("username");
            password =prop.getProperty("password");

            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getcon(){

        Connection con =null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Connection con,PreparedStatement psttm,ResultSet rs){
        try {
            if(con!=null){
                con.close();
            }
            if(psttm!=null){
                psttm.close();
            }
            if(rs!=null){
                rs.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void close(Connection con,PreparedStatement psttm){
        JdbcUtil.close(con,psttm,null);
    }
}
