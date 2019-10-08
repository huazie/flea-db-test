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
public class StudentSqlTemplateTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentSqlTemplateTest.class);

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        LOGGER.debug("ApplicationContext={}", applicationContext);
    }

    @Test
    public void testInsertSqlTemplateForJPA() throws Exception{
        IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");

        Student student = new Student();
        student.setStuName("王老五");
        student.setStuAge(35);
        student.setStuSex(1);
        student.setStuState(1);

        int ret = studentSV.insert("insert", student);
        LOGGER.debug("result = {}", ret);
    }


}
