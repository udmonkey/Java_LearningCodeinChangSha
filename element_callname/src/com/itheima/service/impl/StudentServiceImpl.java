package com.itheima.service.impl;

import com.itheima.domain.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> findAll() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_core_config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sessionFactory.openSession(true);
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> list = mapper.findAll();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
