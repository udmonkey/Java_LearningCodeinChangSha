package com.itheima.mapper;

import com.itheima.domain.SearchParam;
import com.itheima.domain.User;

import java.util.List;

public interface UserSearchDao {
    //尝试sql构造 实现动态sql
    //@Select("SELECT * FROM USER WHERE username LIKE '%pfh%' AND birthday BETWEEN '1956-10-21' AND '2010-12-21'")
    List<User> findByCondition(SearchParam sp);
}
