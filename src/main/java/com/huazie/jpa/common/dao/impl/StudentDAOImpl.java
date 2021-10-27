package com.huazie.jpa.common.dao.impl;

import com.huazie.frame.common.exception.CommonException;
import com.huazie.frame.common.util.StringUtils;
import com.huazie.frame.db.jpa.common.FleaJPAQuery;
import com.huazie.jpa.common.FleaJpaDAOImpl;
import com.huazie.jpa.common.dao.interfaces.IStudentDAO;
import com.huazie.jpa.common.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p> 学生DAO层实现类 </p>
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository("studentDAO")
@SuppressWarnings(value = "unchecked")
public class StudentDAOImpl extends FleaJpaDAOImpl<Student> implements IStudentDAO {

    @Override
    public List<Student> getStudentList(String name, Integer sex, Integer minAge, Integer maxAge, int pageNum, int pageCount) throws CommonException {
        FleaJPAQuery query = initQuery(name, sex, minAge, maxAge, null);

        List<Student> studentList;

        if (pageNum > 0 && pageCount > 0) {
            studentList = query.getResultList((pageNum - 1) * pageCount, pageCount);
        } else {
            studentList = query.getResultList();
        }

        return studentList;
    }

    @Override
    public long getStudentCount(String name, Integer sex, Integer minAge, Integer maxAge) throws CommonException {
        Object result = initQuery(name, sex, minAge, maxAge, Long.class).count().getSingleResult();
        return Long.parseLong(StringUtils.valueOf(result));
    }

    private FleaJPAQuery initQuery(String name, Integer sex, Integer minAge, Integer maxAge, Class<?> result) throws CommonException {
        return getQuery(result)
                .like("stuName", name) // 根据姓名 模糊查询, attrName 为 实体类 成员变量名，并非表字段名
                .equal("stuSex", sex) // 查询性别
                .ge("stuAge", minAge) // 查询年龄范围 (大于等于)
                .le("stuAge", maxAge); // 查询年龄范围 (小于等于)
    }
}