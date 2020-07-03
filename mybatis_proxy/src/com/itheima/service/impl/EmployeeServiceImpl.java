package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.EmployeeDao;
import com.itheima.pojo.Employee;
import com.itheima.service.EmployeeService;
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

public class EmployeeServiceImpl implements EmployeeService {
    //测试
    public static void main(String[] args) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        //查询所有
        List<Employee> employees = employeeService.selectAll();
     //   PageInfo<Object> info = new PageInfo<>();
       // PageHelper.startPage(1,3);
        for (Employee e : employees) {
            System.out.println(e);
        }
        //PageInfo<Employee> info = new PageInfo<Employee>(employees);
        //System.out.println("-------------"+info.getList());
        //增加一个
//        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
//        Date ddd = null;
//        try {
//            ddd = sdf.parse("2020-10-30");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(ddd);
//        Employee e01 = new Employee(123, "彭飞鸿", "全栈工程师", ddd, 12000.0, 0.0, 30);
//        Boolean isChanged = employeeService.addOne(e01);
//        System.out.println(isChanged);

        //改变
//        Employee employee = new Employee();
//        employee.setEmpno(123);
//        employee.setSal(14000.0);
//        employee.setJob("java架构师");
//        Boolean isChanged = employeeService.changeOne(employee);
//        System.out.println(isChanged);
    }
    //获取SqlSession对象
    public EmployeeDao getEmployeeMapper(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_core_config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            return mapper;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //查询所有
    @Override
    public List<Employee> selectAll() {
        EmployeeDao mapper = getEmployeeMapper();
        PageHelper.startPage(1,3);
        //PageHelper.startPage(2,3);
        //PageHelper.startPage(3,3);

        List<Employee> employeeList = mapper.selectAll();
        return employeeList;
    }
    //添加一个
    @Override
    public Boolean addOne(Employee employee) {
        EmployeeDao mapper = getEmployeeMapper();
        Integer modifyNum = mapper.addOne(employee);
        if(modifyNum!=null&&modifyNum==1){
            return true;
        }else{
            return false;
        }
    }
    //改变一个
    @Override
    public Boolean changeOne(Employee employee) {
        EmployeeDao mapper = getEmployeeMapper();
        Integer modifyNum = mapper.changeOne(employee);
        if(modifyNum!=null&&modifyNum==1){
            return true;
        }else{
            return false;
        }
    }
    //删除
    @Override
    public Boolean delete(Integer empno) {
        return null;
    }


}
