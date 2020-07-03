package com.itheima.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtil {
    public static void main(String[] args) {


        Connection con = DruidUtil.getcon();


        String sql="select * from USER ";
        PreparedStatement psstm =null;
        try {
            psstm = con.prepareStatement(sql);
            ResultSet rs = psstm.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("username"));
                System.out.println(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtil.close(con,psstm,rs);
        }

    }
    public DruidUtil() {
    }

    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    private static Connection con=null;
    private static PreparedStatement psttm=null;
    private static ResultSet rs=null;

    private  static DataSource ds =null;

    static {
        InputStream is = DruidUtil.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop =new Properties();
        try {
            prop.load(is);
            driverClass = prop.getProperty("driverClass");
            url         = prop.getProperty("url");
            username    = prop.getProperty("username");
            password    = prop.getProperty("password");

            Class.forName(driverClass);


            ds = new DruidDataSourceFactory().createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Connection getcon(){
        try {
            Connection con = ds.getConnection();
            return  con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void  close(Connection con,PreparedStatement psttm,ResultSet rs){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(psttm!=null){
            try {
                psttm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
