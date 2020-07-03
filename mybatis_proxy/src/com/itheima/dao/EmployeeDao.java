package com.itheima.dao;

import com.itheima.pojo.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface EmployeeDao {
    //查询所有
    public abstract List<Employee> selectAll();
    //增
    public abstract Integer addOne(Employee employee);
    //改
    public abstract Integer changeOne(Employee employee);
    //查
    public abstract Integer delete(Integer empno);
}
