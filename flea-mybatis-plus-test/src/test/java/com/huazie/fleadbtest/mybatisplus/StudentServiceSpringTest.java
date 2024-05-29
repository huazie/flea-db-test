package com.huazie.fleadbtest.mybatisplus;

import com.huazie.fleadbtest.mybatisplus.service.interfaces.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentServiceSpringTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentSpringTest.class);

    @Resource(name = "studentServiceImpl")
    private IStudentService studentService;

    @Test
    public void testCursorQuery() {
        LOGGER.debug("StudentService = {}", studentService);
        studentService.scan(10);
    }

    @Test
    public void testSpringMybatisPlusTransaction() throws RuntimeException {
        studentService.service();
    }

}
