package com.huazie.jpa;

import com.huazie.fleaframework.common.slf4j.impl.FleaLoggerProxy;
import com.huazie.jpa.common.entity.Student;
import com.huazie.jpa.common.service.interfaces.IStudentSV;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * <p>  </p>
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
public class StudentTest {

    private static final Logger LOGGER = FleaLoggerProxy.getProxyInstance(StudentTest.class);

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        LOGGER.debug("ApplicationContext={}", applicationContext);
    }

    @Test
    public void testInsertStudent() {
        try {
            IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");
            Student student = new Student();
            student.setStuName("张三4");
            student.setStuAge(18);
            student.setStuSex(1);
            student.setStuState(1);
            studentSV.save(student);
            LOGGER.debug("Student = {}", student);
        } catch (Exception e) {
            LOGGER.error("Exception : ", e);
        }
    }

    @Test
    public void testStudentUpdate() {
        try {
            IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");
            // 根据主键查询学生信息
            Student student = studentSV.query(1L);
            LOGGER.error("Before : {}", student);
            student.setStuName("LGH");
            student.setStuAge(18);
            // 更新学生信息
            studentSV.update(student);
            // 最后再根据主键查询学生信息
            student = studentSV.query(1L);
            LOGGER.error("After : {}", student);
        } catch (Exception e) {
            LOGGER.error("Exception : ", e);
        }
    }

    @Test
    public void testStudentDelete() {
        try {
            IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");
            long stuId = 1L;
            studentSV.removeStudentByStuId(stuId);
            // 最后再根据主键查询学生信息
            Student student = studentSV.query(stuId);
            LOGGER.error("After : {}", student);
        } catch (Exception e) {
            LOGGER.error("Exception : ", e);
        }
    }

    @Test
    public void testStudentDelete1() {
        try {
            IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");
            long stuId = 1L;
            studentSV.removeStudentByStuId1(stuId);
            // 最后再根据主键查询学生信息
            Student student = studentSV.query(stuId);
            LOGGER.error("After : {}", student);
        } catch (Exception e) {
            LOGGER.error("Exception : ", e);
        }
    }

    @Test
    public void testStudentQueryPage() {
        try {
            IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");
            List<Student> studentList = studentSV.getStudentList("张三", 1, 18, 20, 1, 5);
            LOGGER.debug("Student List = {}", studentList);
        } catch (Exception e) {
            LOGGER.error("Exception : ", e);
        }
    }

    @Test
    public void testStudentQueryCount() {
        try {
            IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");
            long count = studentSV.getStudentCount("张三", 1, 18, 20);
            LOGGER.debug("Student Count = {}", count);
        } catch (Exception e) {
            LOGGER.error("Exception : ", e);
        }
    }

}
