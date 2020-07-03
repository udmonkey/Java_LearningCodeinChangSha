package com.itheima.mapper;

import com.itheima.pojo.Classes;
import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age"),
            @Result(
                    property = "c",
                    javaType = Classes.class,
                    column = "cid",
                    many=@Many(select = "com.itheima.mapper.ClassesMapper.findById")
            )
    })
    List<Student> findAll();
}
