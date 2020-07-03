package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.mapper.UserSearchDao;
import com.itheima.domain.SearchParam;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.JDBCUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * 用户的业务层实现类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = null;

    //获取sqlSession方法
    public SqlSession getSqlSession(){
        try {
            InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            return sqlSession;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<User> findAll() {
        SqlSession sqlSession = getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> list = mapper.findAll();
        return list;
    }

    @Override
    public List<User> findByCondition(SearchParam sp) {

        SqlSession sqlSession = getSqlSession();
        UserSearchDao mapper = sqlSession.getMapper(UserSearchDao.class);
        List<User> list = mapper.findByCondition(sp);
        return list;
    }

    @Override
    public User findById(String uid) {

        SqlSession sqlSession = getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User u = mapper.findById(uid);
        return u;
    }

    @Override
    public void save(User user) {
        //1.创建ID,并把UUID中的-替换没
        String uid = UUID.randomUUID().toString().replace("-","").toUpperCase();
        //2.给user的uid赋值
        user.setUid(uid);
        //3.生成员工编号
        user.setUcode(uid);
        //3.保存
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        SqlSession sqlSession = getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.update(user);
    }

    @Override
    public void delete(String uid) {
        SqlSession sqlSession = getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.delete(uid);
    }

    @Override
    public User login(User u) {
        SqlSession sqlSession = getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.findByLoginNameAndPassword(u);
        //1.调用持久层查询
        //User user = userDao.findByLoginNameAndPassword(loginName,password);
        //2.返回
        return user;
    }

    /*
        事务要控制在此处
     */
    @Override
    public void batchAdd(List<User> users) {
        //获取数据库连接对象
        Connection con = JDBCUtils.getConnection();
        try {
            //开启事务
            con.setAutoCommit(false);

            for (User user : users) {
                //1.创建ID,并把UUID中的-替换
                String uid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
                //2.给user的uid赋值
                user.setUid(uid);
                //3.生成员工编号
                user.setUcode(uid);

                //出现异常
                //int n = 1 / 0;

                //4.保存
                userDao.save(con,user);
            }

            //提交事务
            con.commit();

        }catch (Exception e){
            //回滚事务
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(con,null);
        }
    }
}
