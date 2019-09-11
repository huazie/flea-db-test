package com.huazie.jpa.dao.impl;

import com.huazie.frame.common.util.ObjectUtils;
import com.huazie.frame.common.util.StringUtils;
import com.huazie.frame.db.common.exception.DaoException;
import com.huazie.frame.db.jpa.common.FleaJPAQuery;
import com.huazie.jpa.FleaJpaDAOImpl;
import com.huazie.jpa.dao.interfaces.IStudentDAO;
import com.huazie.jpa.entity.Student;
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
public class StudentDAOImpl extends FleaJpaDAOImpl<Student> implements IStudentDAO {

    @Override
    @SuppressWarnings(value = "unchecked")
    public List<Student> getStudentList(String name, Integer sex, Integer minAge, Integer maxAge, int pageNum, int pageCount) throws DaoException {
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
    @SuppressWarnings(value = "unchecked")
    public long getStudentCount(String name, Integer sex, Integer minAge, Integer maxAge) throws DaoException {
        FleaJPAQuery query = initQuery(name, sex, minAge, maxAge, Long.class);
        query.countDistinct();
        Object result = query.getSingleResult();
        return Long.parseLong(StringUtils.valueOf(result));
    }

    private FleaJPAQuery initQuery(String name, Integer sex, Integer minAge, Integer maxAge, Class<?> result) throws DaoException {
        FleaJPAQuery query = getQuery(result);

        // 拼接 查询条件
        // 根据姓名 模糊查询, attrName 为 实体类 成员变量名，并非表字段名
        if (StringUtils.isNotBlank(name)) {
            query.like("stuName", name);
        }

        // 查询性别
        if (ObjectUtils.isNotEmpty(sex)) {
            query.equal("stuSex", sex);
        }

        // 查询年龄范围
        if (ObjectUtils.isNotEmpty(minAge)) {
            // 大于等于
            query.ge("stuAge", minAge);
        }

        if (ObjectUtils.isNotEmpty(maxAge)) {
            // 小于等于
            query.le("stuAge", maxAge);
        }
        return query;
    }
}