package com.sms.service;

import com.github.pagehelper.Page;
import com.sms.domain.Student;

public interface StudentService {

    Page<Student> selectByPage(Integer currentPage,Integer pageSize);

    Integer addStu(Student stu);

    Integer update(Student stu);

    Integer delete(String number);
}
