package com.itheima.service;

import com.github.pagehelper.Page;
import com.itheima.domain.User;

public interface UserService {

    Page<User> findAll(String pageNum,String pageSize);
}
