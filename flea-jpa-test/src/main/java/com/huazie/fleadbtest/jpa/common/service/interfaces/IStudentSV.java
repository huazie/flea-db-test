package com.huazie.fleadbtest.jpa.common.service.interfaces;

import com.huazie.fleadbtest.jpa.common.entity.Student;
import com.huazie.fleaframework.common.exception.CommonException;
import com.huazie.fleaframework.db.jpa.service.interfaces.IAbstractFleaJPASV;

import java.util.List;

/**
 * <p> 学生SV层接口定义 </p>
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IStudentSV extends IAbstractFleaJPASV<Student> {

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

    /**
     * 删除学生
     *
     * @param stuId 学生编号
     * @throws CommonException 通用异常
     * @since 1.0.0
     */
    void removeStudentByStuId(Long stuId) throws CommonException;

    /**
     * 删除学生
     *
     * @param stuId 学生编号
     * @throws CommonException 通用异常
     * @since 1.0.0
     */
    void removeStudentByStuId1(Long stuId) throws CommonException;

}