package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public Page<Student> findAll(Integer pageNum,Integer pageSize) {
        SqlSession sqlSession =null;
        InputStream is =null;
        try {
            is=Resources.getResourceAsStream("mybatis_core_config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sessionFactory.openSession(true);
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //分页
            Page<Student> list = PageHelper.startPage(pageNum, pageSize);

            mapper.findAll();
            System.out.println("StudentServiceImpl.findAll.list.size====="+list.size());
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
