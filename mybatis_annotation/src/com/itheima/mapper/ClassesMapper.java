package com.itheima.mapper;

import com.itheima.pojo.Classes;
import org.apache.ibatis.annotations.Select;

public interface ClassesMapper {
    @Select("select * from classes where id=#{id}")
    Classes findById(Integer id);
}
