package com.huazie.fleadbtest.common.dao.interfaces;

import com.huazie.fleaframework.common.exception.CommonException;
import com.huazie.fleaframework.db.jpa.dao.interfaces.IAbstractFleaJPADAO;
import com.huazie.fleadbtest.common.entity.Student;

import java.util.List;

/**
 * <p> 学生DAO层接口 </p>
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IStudentDAO extends IAbstractFleaJPADAO<Student> {

    /**
     * <p> 学生信息列表 (分页) </p>
     *
     * @param name      学生姓名，可以模糊查询
     * @param sex       性别
     * @param minAge    最小年龄
     * @param maxAge    最大年龄
     * @param pageNum   查询页
     * @param pageCount 每页总数
     * @return 学生信息列表
     * @throws CommonException 通用异常
     * @since 1.0.0
     */
    List<Student> getStudentList(String name, Integer sex, Integer minAge, Integer maxAge, int pageNum, int pageCount) throws CommonException;

    /**
     * <p> 学生总数 </p>
     *
     * @param name   学生姓名，可以模糊查询
     * @param sex    性别
     * @param minAge 最小年龄
     * @param maxAge 最大年龄
     * @return 学生总数
     * @throws CommonException 通用异常
     * @since 1.0.0
     */
    long getStudentCount(String name, Integer sex, Integer minAge, Integer maxAge) throws CommonException;

}