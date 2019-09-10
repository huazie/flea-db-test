package com.huazie.jpa.service.impl;

import com.huazie.frame.db.common.exception.DaoException;
import com.huazie.jpa.dao.interfaces.IStudentDAO;
import com.huazie.jpa.entity.Student;
import com.huazie.jpa.service.interfaces.IStudentSV;
import com.huazie.frame.db.jpa.dao.interfaces.IAbstractFleaJPADAO;
import com.huazie.frame.db.jpa.service.impl.AbstractFleaJPASVImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 学生SV层实现类 </p>
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("studentSV")
public class StudentSVImpl extends AbstractFleaJPASVImpl<Student> implements IStudentSV {

    @Autowired
    @Qualifier("studentDAO")
    private IStudentDAO studentDao;

    @Override
    public List<Student> getStudentList(String name, Integer sex, Integer minAge, Integer maxAge, int pageNum, int pageCount) throws DaoException {
        return studentDao.getStudentList(name, sex, minAge, maxAge, pageNum, pageCount);
    }

    @Override
    public long getStudentCount(String name, Integer sex, Integer minAge, Integer maxAge) throws DaoException {
        return studentDao.getStudentCount(name, sex, minAge, maxAge);
    }

    @Override
    protected IAbstractFleaJPADAO<Student> getDAO() {
        return studentDao;
    }
}