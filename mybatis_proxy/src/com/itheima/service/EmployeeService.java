package com.itheima.service;

import com.itheima.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    public abstract List<Employee> selectAll();
    public abstract Boolean addOne(Employee employee);
    public abstract Boolean changeOne(Employee employee);
    public abstract Boolean delete(Integer empno);
}
