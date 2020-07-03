package com.itheima.service.impl;

import com.itheima.mapper.CardMapper;
import com.itheima.pojo.Card;
import com.itheima.service.CardService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CardServiceImpl implements CardService {
    @Override
    public List<Card> findall() {
        SqlSession sqlSession =null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_core_config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
             sqlSession = sessionFactory.openSession(true);
            CardMapper mapper = sqlSession.getMapper(CardMapper.class);
            List<Card> list = mapper.findall();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return null;
    }
}
