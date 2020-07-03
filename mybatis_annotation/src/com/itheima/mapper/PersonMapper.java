package com.itheima.mapper;

import com.itheima.pojo.Person;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {
    @Select("select name,age from person where id=#{pid}")
    Person findById(Integer pid);
}
