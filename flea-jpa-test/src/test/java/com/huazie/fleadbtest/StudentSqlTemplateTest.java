package com.huazie.fleadbtest;

import com.huazie.fleadbtest.jpa.common.entity.Student;
import com.huazie.fleadbtest.jpa.common.service.interfaces.IStudentSV;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource(name = "studentSV")
    private IStudentSV studentSV;

    @Test
    public void testInsertSqlTemplateFromJPA() throws Exception {
        Student student = new Student();
        student.setStuName("王老五");
        student.setStuAge(35);
        student.setStuSex(1);
        student.setStuState(1);

        int ret = studentSV.insert("insert", student);
        LOGGER.debug("Result = {}", ret);
    }

    @Test
    public void testQuerySqlTemplateFromJPA() throws Exception {
        Student student = new Student();
        student.setStuName("%老%");
        student.setStuSex(1);
        student.put("minAge", 20);
        student.put("maxAge", 40);

        LOGGER.debug("Student List = {}", studentSV.queryAll("select", student));
    }

    @Test
    public void testUpdateSqlTemplateFromJPA() throws Exception {
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
    public void testDeleteSqlTemplateFromJPA() throws Exception {
        Student student = new Student();
        student.setStuName("%王老五%");
        student.setStuState(1);
        student.setStuSex(1);
        student.put("minAge", 20);
        student.put("maxAge", 40);

        LOGGER.debug("Result = {}", studentSV.delete("delete", student));
    }

    @Test
    public void testQueryPageSqlTemplateFromJPA() throws Exception {
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
    public void testQueryCountSqlTemplateFromJPA() throws Exception {
        Student student = new Student();
        student.setStuName("%张三%");
        student.setStuSex(1);
        student.put("minAge", 18);
        student.put("maxAge", 20);

        LOGGER.debug("Student Count = {}", studentSV.querySingle("select_2", student));
    }

    @Test
    public void testQuerySumSqlTemplateFromJPA() throws Exception {
        LOGGER.debug("Student Age = {}", studentSV.querySingle("select_3", new Student()));
    }

    @Test
    public void testQueryAvgSqlTemplateFromJPA() throws Exception {
        LOGGER.debug("Student Age = {}", studentSV.querySingle("select_4", new Student()));
    }

    @Test
    public void testQueryMaxSqlTemplateFromJPA() throws Exception {
        LOGGER.debug("Student Age = {}", studentSV.querySingle("select_5", new Student()));
    }

    @Test
    public void testQueryMinSqlTemplateFromJPA() throws Exception {
        LOGGER.debug("Student Age = {}", studentSV.querySingle("select_6", new Student()));
    }

}
