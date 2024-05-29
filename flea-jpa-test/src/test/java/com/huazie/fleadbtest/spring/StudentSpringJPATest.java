package com.huazie.fleadbtest.spring;

import com.huazie.fleadbtest.jpa.repository.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Spring Data Jpa
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentSpringJPATest {

    @Resource(name = "studentService")
    private StudentService studentService;

    @Test
    public void testSpringJPATransaction() throws Exception {
        studentService.service();
    }
}
