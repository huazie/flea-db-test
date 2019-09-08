package com.huazie.jpa;

import com.huazie.jpa.entity.Student;
import com.huazie.jpa.service.interfaces.IStudentSV;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>  </p>
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
public class StudentTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTest.class);

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
            student.setStuName("李四");
            student.setStuAge(19);
            student.setStuSex(1);
            student.setStuState(1);
            studentSV.save(student);
        } catch (Exception e) {
            LOGGER.error("Exception : ", e);
        }
    }

    @Test
    public void testStudentQuery() {
        try {
            IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");

        } catch (Exception e) {
            LOGGER.error("Exception : ", e);
        }
    }
}
