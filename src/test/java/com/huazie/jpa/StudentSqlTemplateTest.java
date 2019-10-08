package com.huazie.jpa;

import com.huazie.frame.db.common.DBSystemEnum;
import com.huazie.frame.db.jdbc.FleaJDBCHelper;
import com.huazie.frame.db.jdbc.config.FleaJDBCConfig;
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
    public void testInsertSqlTemplateFromJPA() throws Exception{
        IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");

        Student student = new Student();
        student.setStuName("王老五");
        student.setStuAge(35);
        student.setStuSex(1);
        student.setStuState(1);

        int ret = studentSV.insert("insert", student);
        LOGGER.debug("Result = {}", ret);
    }

    @Test
    public void testInsertSqlTemplateFromJDBC() throws Exception {

        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        Student student = new Student();
        student.setStuName("钱老六");
        student.setStuAge(30);
        student.setStuSex(1);
        student.setStuState(1);

        int ret = FleaJDBCHelper.insert("insert", student);
        LOGGER.debug("Result = {}", ret);
    }

    @Test
    public void testQuerySqlTemplateFromJPA() throws Exception {
        IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");

        Student student = new Student();
        student.setStuName("%老%");
        student.setStuSex(1);
        student.put("minAge", 20);
        student.put("maxAge", 40);

        LOGGER.debug("Student List = {}", studentSV.query("select", student));
    }

    @Test
    public void testQuerySqlTemplateFromJDBC() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        Student student = new Student();
        student.setStuName("%老%");
        student.setStuSex(1);
        student.put("minAge", 20);
        student.put("maxAge", 40);

        LOGGER.debug("Student List = {}", FleaJDBCHelper.query("select", student));
    }

    @Test
    public void testUpdateSqlTemplateFromJPA() throws Exception {
        IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");

        Student student = new Student();
        student.setStuName("王老五1");
        student.setStuAge(40);
        student.setStuState(1);
        student.setStuSex(1);
        student.put("sName", "%王老五%");
        student.put("minAge", 20);
        student.put("maxAge", 40);

        LOGGER.debug("Result = {}", studentSV.update("update", student));
    }

    @Test
    public void testUpdateSqlTemplateFromJDBC() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        Student student = new Student();
        student.setStuName("钱老六1");
        student.setStuAge(35);
        student.setStuState(1);
        student.setStuSex(1);
        student.put("sName", "%钱老六%");
        student.put("minAge", 20);
        student.put("maxAge", 40);

        LOGGER.debug("Result = {}", FleaJDBCHelper.update("update", student));
    }

    @Test
    public void testDeleteSqlTemplateFromJPA() throws Exception {
        IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");

        Student student = new Student();
        student.setStuName("%王老五%");
        student.setStuState(1);
        student.setStuSex(1);
        student.put("minAge", 20);
        student.put("maxAge", 40);

        LOGGER.debug("Result = {}", studentSV.delete("delete", student));
    }

    @Test
    public void testDeleteSqlTemplateFromJDBC() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        Student student = new Student();
        student.setStuName("%钱老六%");
        student.setStuState(1);
        student.setStuSex(1);
        student.put("minAge", 20);
        student.put("maxAge", 40);

        LOGGER.debug("Result = {}", FleaJDBCHelper.delete("delete", student));
    }
}
