package com.sms.mapper;

import com.sms.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;

public interface UserMapper {


    @Select("select * from user where username = #{username} and password = #{password}")
    User login(User u);
}
