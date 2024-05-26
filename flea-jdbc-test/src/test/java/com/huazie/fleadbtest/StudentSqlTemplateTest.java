package com.huazie.fleadbtest;

import com.huazie.fleadbtest.entity.Student;
import com.huazie.fleaframework.db.common.DBSystemEnum;
import com.huazie.fleaframework.db.jdbc.FleaJDBCHelper;
import com.huazie.fleaframework.db.jdbc.config.FleaJDBCConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * 已验证
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentSqlTemplateTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentSqlTemplateTest.class);

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
    public void testQuerySumSqlTemplateFromJDBC() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");
        LOGGER.debug("Student Age = {}", FleaJDBCHelper.querySingle("select_3", new Student()));
    }

    @Test
    public void testQueryAvgSqlTemplateFromJDBC() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");
        LOGGER.debug("Student Age = {}", FleaJDBCHelper.querySingle("select_4", new Student()));
    }

    @Test
    public void testQueryMaxSqlTemplateFromJDBC() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");
        LOGGER.debug("Student Age = {}", FleaJDBCHelper.querySingle("select_5", new Student()));
    }

    @Test
    public void testQueryMinSqlTemplateFromJDBC() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");
        LOGGER.debug("Student Age = {}", FleaJDBCHelper.querySingle("select_6", new Student()));
    }
}
