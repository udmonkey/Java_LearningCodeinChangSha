package com.sms.service.impl;

import com.sms.domain.User;
import com.sms.mapper.UserMapper;
import com.sms.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String username, String password) {
        User u = new User();
        InputStream is =null;
        SqlSession sqlSession =null;
        try {
            is = Resources.getResourceAsStream("mybatis_core_config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);


            u = mapper.login(new User(null,username,password));
            return u;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return u;
    }
}
