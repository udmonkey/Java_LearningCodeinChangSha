package com.itheima.dao;

import com.itheima.pojo.Employee;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EmloyeeDao {
    public static void main(String[] args) {
        //新增测试
        EmloyeeDao emloyeeDao = new EmloyeeDao();
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
        Date ddd = null;
        try {
            ddd = sdf.parse("2020-10-30");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(ddd);


        Employee employee = new Employee(123, "彭飞鸿", "全栈工程师", ddd, 12000.0, 0.0, 30);
        Boolean isSuccess = emloyeeDao.addOne(employee);

        System.out.println(isSuccess);
        //改 测试

    }

    public SqlSession getSqlSession() {

        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis_core_config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }

    //查询
    public List<Employee> findAll() {
        SqlSession sqlSession = getSqlSession();
        List<Employee> resultList = sqlSession.selectList("employee_mapping.selectAll");

        for (Employee e : resultList) {
            System.out.println(e);
        }

        sqlSession.close();
        return null;
    }

    //新增
    public Boolean addOne(Employee employee) {
        SqlSession sqlSession = getSqlSession();
        Integer modifyNum = sqlSession.insert("employee_mapping.addOne", employee);
        System.out.println("modifyNum=" + modifyNum);
        if (modifyNum != null && modifyNum == 1) {
            return true;
        } else {
            return false;
        }

    }

    //改
    public Boolean changeOne(Employee employee) {
        SqlSession sqlSession = getSqlSession();
        Integer modifyNum = sqlSession.update("employee_mapping.changeOne", employee);
        if (modifyNum != null && modifyNum == 1) {
            return true;
        } else {
            return false;
        }
    }

    //删除
    public Boolean delete(Integer empno) {
        SqlSession sqlSession = getSqlSession();
        Integer modifyNum = sqlSession.delete("employee_mapping.delete", empno);
        if (modifyNum != null && modifyNum == 1) {
            return true;
        } else {
            return false;
        }
    }
}
