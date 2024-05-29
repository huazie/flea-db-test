package com.huazie.fleadbtest.jpa.repository;

import com.huazie.fleadbtest.jpa.common.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用于访问Student实体相关的数据库操作的接口
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional("fleaJpaTransactionManager")
    public void service() throws RuntimeException {

        Student student = new Student();
        student.setStuName("杜甫");
        student.setStuAge(35);
        student.setStuSex(1);
        student.setStuState(1);

        studentRepository.save(student);

        student.setStuState(0);
        studentRepository.save(student);

        //throwEx();
    }

    private void throwEx() throws RuntimeException {
        throw new RuntimeException("Test Exception");
    }
}
