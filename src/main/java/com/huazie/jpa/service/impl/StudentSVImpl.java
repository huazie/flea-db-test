package com.huazie.jpa.service.impl;

import com.huazie.jpa.dao.interfaces.IStudentDAO;
import com.huazie.jpa.entity.Student;
import com.huazie.jpa.service.interfaces.IStudentSV;
import com.huazie.frame.db.jpa.dao.interfaces.IAbstractFleaJPADAO;
import com.huazie.frame.db.jpa.service.impl.AbstractFleaJPASVImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
    protected IAbstractFleaJPADAO<Student> getDAO() {
        return studentDao;
    }
}