package com.sms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sms.domain.Student;
import com.sms.mapper.StudentMapper;
import com.sms.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private InputStream is =null;
    private SqlSession sqlSession = null;

    public void getSqlSession(){
        try {
            is = Resources.getResourceAsStream("mybatis_core_config.xml");
            SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sql.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutDown(InputStream is,SqlSession sqlSession){
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

    @Override
    public Page<Student> selectByPage(Integer currentPage, Integer pageSize) {
        getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //分页
        Page<Student> pagelist = PageHelper.startPage(currentPage, pageSize);
        mapper.findAll();

        return pagelist;
    }

    @Override
    public Integer addStu(Student stu) {
        getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Integer successNum = mapper.addStu(stu);
        return successNum;
    }

    @Override
    public Integer update(Student stu) {
        getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Integer successNum = mapper.updateStu(stu);
        return successNum;
    }

    @Override
    public Integer delete(String number) {
        getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Integer successNum = mapper.deleteStu(number);
        return successNum;
    }
}
