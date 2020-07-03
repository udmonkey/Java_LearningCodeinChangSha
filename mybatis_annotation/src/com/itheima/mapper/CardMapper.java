package com.itheima.mapper;

import com.itheima.pojo.Card;
import com.itheima.pojo.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CardMapper {
    @Select("select * from card")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "number", property = "number"),
            @Result(property = "p",
                    javaType = Person.class,
                    column = "pid",
                    one = @One(select = "com.itheima.mapper.PersonMapper.findById"))
    })

    List<Card> findall ();
}
