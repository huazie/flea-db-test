package com.huazie.fleadbtest;

import com.huazie.fleadbtest.jpa.common.entity.Student;
import com.huazie.fleadbtest.jpa.common.service.interfaces.IStudentSV;
import com.huazie.fleaframework.db.common.DBSystemEnum;
import com.huazie.fleaframework.db.jdbc.FleaJDBCHelper;
import com.huazie.fleaframework.db.jdbc.config.FleaJDBCConfig;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

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
    public void testInsertSqlTemplateFromJPA() throws Exception {
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

        LOGGER.debug("Student List = {}", studentSV.queryAll("select", student));
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

    @Test
    public void testQueryPageSqlTemplateFromJPA() throws Exception {
        IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");

        Student student = new Student();
        student.setStuName("%张三%");
        student.setStuSex(1);
        student.put("minAge", 18);
        student.put("maxAge", 20);
        int pageNum = 1;   // 第一页
        int pageCount = 5; // 每页5条记录
        student.put("pageStart", (pageNum - 1) * pageCount);
        student.put("pageCount", pageCount);

        List<Student> studentList = studentSV.queryAll("select_1", student);
        LOGGER.debug("Student List = {}", studentList);
        LOGGER.debug("Student Count = {}", studentList.size());
    }

    @Test
    public void testQueryPageSqlTemplateFromJDBC() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        Student student = new Student();
        student.setStuName("%李四%");
        student.setStuSex(1);
        student.put("minAge", 18);
        student.put("maxAge", 20);
        int pageNum = 1;   // 第一页
        int pageCount = 5; // 每页5条记录
        student.put("pageStart", (pageNum - 1) * pageCount);
        student.put("pageCount", pageCount);

        List<Map<String, Object>> studentList = FleaJDBCHelper.query("select_1", student);
        LOGGER.debug("Student List = {}", studentList);
        LOGGER.debug("Student Count = {}", studentList.size());
    }

    @Test
    public void testQueryCountSqlTemplateFromJPA() throws Exception {
        IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");

        Student student = new Student();
        student.setStuName("%张三%");
        student.setStuSex(1);
        student.put("minAge", 18);
        student.put("maxAge", 20);

        LOGGER.debug("Student Count = {}", studentSV.querySingle("select_2", student));
    }

    @Test
    public void testQueryCountSqlTemplateFromJDBC() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        Student student = new Student();
        student.setStuName("%李四%");
        student.setStuSex(1);
        student.put("minAge", 18);
        student.put("maxAge", 20);

        LOGGER.debug("Student Count = {}", FleaJDBCHelper.querySingle("select_2", student));
    }

    @Test
    public void testQuerySumSqlTemplateFromJPA() throws Exception {
        IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");
        LOGGER.debug("Student Age = {}", studentSV.querySingle("select_3", new Student()));
    }

    @Test
    public void testQuerySumSqlTemplateFromJDBC() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");
        LOGGER.debug("Student Age = {}", FleaJDBCHelper.querySingle("select_3", new Student()));
    }

    @Test
    public void testQueryAvgSqlTemplateFromJPA() throws Exception {
        IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");
        LOGGER.debug("Student Age = {}", studentSV.querySingle("select_4", new Student()));
    }

    @Test
    public void testQueryAvgSqlTemplateFromJDBC() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");
        LOGGER.debug("Student Age = {}", FleaJDBCHelper.querySingle("select_4", new Student()));
    }

    @Test
    public void testQueryMaxSqlTemplateFromJPA() throws Exception {
        IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");
        LOGGER.debug("Student Age = {}", studentSV.querySingle("select_5", new Student()));
    }

    @Test
    public void testQueryMaxSqlTemplateFromJDBC() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");
        LOGGER.debug("Student Age = {}", FleaJDBCHelper.querySingle("select_5", new Student()));
    }

    @Test
    public void testQueryMinSqlTemplateFromJPA() throws Exception {
        IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");
        LOGGER.debug("Student Age = {}", studentSV.querySingle("select_6", new Student()));
    }

    @Test
    public void testQueryMinSqlTemplateFromJDBC() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");
        LOGGER.debug("Student Age = {}", FleaJDBCHelper.querySingle("select_6", new Student()));
    }
}
