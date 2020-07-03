package com.itheima.dao;

import com.itheima.domain.SearchParam;
import com.itheima.domain.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.sql.Connection;
import java.util.List;

/**
 * 用户的持久层接口
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();



    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    @Select("select * from user where uid=#{uid}")
    User findById(String uid);

    /**
     * 添加
     * @param user
     */
    void save(User user);


    @Update("update  user set ucode= #{ucode},username=#{username},loginname=#{loginname},password=#{password},gender=#{gender},birthday=#{birthday},dutydate=#{dutydate} where uid=#{uid} ")
    void update(User user);

    /**
     * 根据id删除
     * @param uid
     */
    @Delete("delete user where uid =#{uid]")
    void delete(String uid);


    @Select("SELECT * FROM user WHERE loginname=#{loginname} AND password=#{password}")
    User findByLoginNameAndPassword(User u);


    /**
     * 支持事务的添加
     * @param user
     */
    void save(Connection connection, User user);
}
