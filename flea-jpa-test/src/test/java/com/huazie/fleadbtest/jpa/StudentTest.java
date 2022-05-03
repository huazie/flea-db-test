package com.huazie.fleadbtest.jpa;

import com.huazie.fleadbtest.jpa.common.entity.Student;
import com.huazie.fleadbtest.jpa.common.service.interfaces.IStudentSV;
import com.huazie.fleaframework.common.exception.CommonException;
import com.huazie.fleaframework.common.slf4j.impl.FleaLoggerProxy;
import com.huazie.fleaframework.common.util.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
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
public class StudentTest {

    private static final Logger LOGGER = FleaLoggerProxy.getProxyInstance(StudentTest.class);

    @Resource(name = "studentSV")
    private IStudentSV studentSV;

    @Test
    public void testInsertStudent() throws CommonException {
        Student student = new Student();
        student.setStuName("杜甫");
        student.setStuAge(35);
        student.setStuSex(1);
        student.setStuState(1);
        studentSV.save(student);
        LOGGER.debug("Student = {}", student);
    }

    @Test
    public void testStudentUpdate() throws CommonException {
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
    }

    @Test
    public void testStudentDelete() throws CommonException {
        long stuId = 1L;
        studentSV.removeStudentByStuId(stuId);
        // 最后再根据主键查询学生信息
        Student student = studentSV.query(stuId);
        LOGGER.error("After : {}", student);
    }

    @Test
    public void testStudentDelete1() throws CommonException {
        long stuId = 1L;
        // 在事物中的查询，然后删除
        studentSV.removeStudentByStuId1(stuId);
        // 最后再根据主键查询学生信息
        Student student = studentSV.query(stuId);
        LOGGER.error("After : {}", student);
    }

    @Test
    public void testStudentDelete2() throws CommonException {
        long stuId = 1L;
        // 根据主键查询学生信息
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("stuId", stuId);
        // 当前无事物的查询
        List<Student> studentList = studentSV.query(paramMap);
        if (CollectionUtils.isNotEmpty(studentList)) {
            Student student = studentList.get(0);
            // 删除学生信息
            studentSV.remove(student);
        }
        // 最后再根据主键查询学生信息
        Student student = studentSV.query(stuId);
        LOGGER.error("After : {}", student);
    }

    @Test
    public void testStudentQueryPage() throws CommonException {
        List<Student> studentList = studentSV.getStudentList("张三", 1, 18, 20, 1, 5);
        LOGGER.debug("Student List = {}", studentList);
    }

    @Test
    public void testStudentQueryCount() throws CommonException {
        long count = studentSV.getStudentCount("张三", 1, 18, 20);
        LOGGER.debug("Student Count = {}", count);
    }

}
