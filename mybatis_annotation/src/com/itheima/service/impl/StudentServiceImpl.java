package com.itheima.service.impl;

import com.itheima.mapper.CardMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.Card;
import com.itheima.pojo.Student;
import com.itheima.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() {
        SqlSession sqlSession =null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_core_config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sessionFactory.openSession(true);
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> list = mapper.findAll();
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
