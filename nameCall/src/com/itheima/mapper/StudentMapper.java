package com.itheima.mapper;

import com.itheima.domain.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    List<Student> findAll();

}
