package com.itheima.service;

import com.github.pagehelper.Page;
import com.itheima.domain.Student;

public interface StudentService {
    Page<Student> findAll(Integer pageNum, Integer pageSize);
}
