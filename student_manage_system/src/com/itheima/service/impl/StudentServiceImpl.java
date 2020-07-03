package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.StudentDao;
import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生的业务层实现类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> findAll(HttpServletRequest req, HttpServletResponse resp) {
        ArrayList<Student> list = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try{
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);

            //4.获取StudentDao接口的实现类对象
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);

            HttpSession session = req.getSession();
            PageInfo<Student> pageinfo = (PageInfo<Student>)session.getAttribute("pageinfo");
            System.out.println("findall()---分页对象"+pageinfo);
            PageHelper.startPage(1,3);
            try{
                    System.out.println("findall()---当前页"+pageinfo.getPageNum());
                    PageHelper.startPage(pageinfo.getPageNum(),3);
            }catch (NullPointerException e){

            }finally {
                list = mapper.findAll();
                PageInfo<Student> info = new PageInfo<>(list);
                System.out.println("findall()---更新的分页对象"+info);
                session.setAttribute("pageinfo",info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //7.返回结果
        return list;
    }

    @Override
    public Student findById(Integer sid) {
        Student stu = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try{
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);

            //4.获取StudentDao接口的实现类对象
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);

            //5.调用实现类对象的方法，接收结果
            stu = mapper.findById(sid);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //7.返回结果
        return stu;
    }

    @Override
    public void save(Student student) {
        SqlSession sqlSession = null;
        InputStream is = null;
        try{
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);

            //4.获取StudentDao接口的实现类对象
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);

            //5.调用实现类对象的方法，接收结果
            mapper.insert(student);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Student student) {
        SqlSession sqlSession = null;
        InputStream is = null;
        try{
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);

            //4.获取StudentDao接口的实现类对象
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);

            //5.调用实现类对象的方法，接收结果
            mapper.update(student);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(Integer sid) {
        SqlSession sqlSession = null;
        InputStream is = null;
        try{
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);

            //4.获取StudentDao接口的实现类对象
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);

            //5.调用实现类对象的方法，接收结果
            mapper.delete(sid);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
