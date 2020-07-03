package com.itheima.service;

import com.itheima.domain.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 学生的业务层接口
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public interface StudentService {

    /**
     * 查询所有学生
     * @return
     */
    List<Student> findAll(HttpServletRequest req, HttpServletResponse resp);

    /**
     * 根据id查询学生
     * @param sid
     * @return
     */
    Student findById(Integer sid);

    /**
     * 保存
     * @param student
     */
    void save(Student student);

    /**
     * 更新
     * @param student
     */
    void update(Student student);

    /**
     * 根据id删除
     * @param sid
     */
    void delete(Integer sid);
}
