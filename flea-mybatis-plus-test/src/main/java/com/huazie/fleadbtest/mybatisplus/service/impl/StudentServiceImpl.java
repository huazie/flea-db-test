package com.huazie.fleadbtest.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huazie.fleadbtest.mybatisplus.entity.Student;
import com.huazie.fleadbtest.mybatisplus.mapper.StudentMapper;
import com.huazie.fleadbtest.mybatisplus.service.interfaces.IStudentService;
import org.apache.ibatis.cursor.Cursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 学生服务层实现类
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@Service("studentServiceImpl")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    @Transactional("dataSourceTransactionManager")
    public void scan(int limit) {
        Cursor<Student> cursor = baseMapper.scan(limit);
        cursor.forEach(student -> LOGGER.debug("Student = {}", student));
    }

    @Override
    @Transactional("dataSourceTransactionManager")
    public void service() throws RuntimeException {
        Student student = new Student();
        student.setStuName("李白");
        student.setStuAge(25);
        student.setStuSex(1);
        student.setStuState(1);

        baseMapper.insert(student);

        student.setStuState(0);

        baseMapper.updateById(student);

        //throwEx();
    }

    private void throwEx() throws RuntimeException {
        throw new RuntimeException("Test Exception");
    }

}
