package com.sms.mapper;

import com.sms.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

    @Select("select * from student")
    List<Student> findAll();

    @Insert("insert into student values (#{number},#{name},#{birthday},#{address})")
    Integer addStu(Student stu);

    @Update("update student set number=#{number},name=#{name},birthday=#{birthday},address=#{address} where number=#{number}")
    Integer updateStu(Student stu);

    @Delete("delete from student where number = #{number}")
    Integer deleteStu(String number);
}
