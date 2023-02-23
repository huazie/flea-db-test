package com.huazie.fleadbtest.jpa.common.service.impl;

import com.huazie.fleadbtest.jpa.common.dao.interfaces.IStudentDAO;
import com.huazie.fleadbtest.jpa.common.entity.Student;
import com.huazie.fleadbtest.jpa.common.service.interfaces.IStudentSV;
import com.huazie.fleaframework.common.exceptions.CommonException;
import com.huazie.fleaframework.common.util.CollectionUtils;
import com.huazie.fleaframework.db.jpa.dao.interfaces.IAbstractFleaJPADAO;
import com.huazie.fleaframework.db.jpa.service.impl.AbstractFleaJPASVImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> 学生SV层实现类 </p>
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("studentSV")
public class StudentSVImpl extends AbstractFleaJPASVImpl<Student> implements IStudentSV {

    private IStudentDAO studentDao;

    @Autowired
    @Qualifier("studentDAO")
    public void setStudentDao(IStudentDAO studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getStudentList(String name, Integer sex, Integer minAge, Integer maxAge, int pageNum, int pageCount) throws CommonException {
        return studentDao.getStudentList(name, sex, minAge, maxAge, pageNum, pageCount);
    }

    @Override
    public long getStudentCount(String name, Integer sex, Integer minAge, Integer maxAge) throws CommonException {
        return studentDao.getStudentCount(name, sex, minAge, maxAge);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public void removeStudentByStuId(Long stuId) throws CommonException {
        // 根据主键查询学生信息
        Student student = this.query(stuId);
        // 删除学生信息
        this.remove(student);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public void removeStudentByStuId1(Long stuId) throws CommonException {
        // 根据主键查询学生信息
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("stuId", stuId);
        List<Student> studentList = this.query(paramMap);
        if (CollectionUtils.isNotEmpty(studentList)) {
            Student student = studentList.get(0);
            // 删除学生信息
            this.remove(student);
        }
    }

    @Override
    protected IAbstractFleaJPADAO<Student> getDAO() {
        return studentDao;
    }
}