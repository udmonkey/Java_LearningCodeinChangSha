package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public Page<User> findAll(String pageNum, String pageSize) {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_core_config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sessionFactory.openSession(true);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int i = Integer.parseInt(pageNum);
            int j = Integer.parseInt(pageSize);

            Page<User> pageList = PageHelper.startPage(i, j);

            List<User> all = mapper.findAll();
            return pageList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
