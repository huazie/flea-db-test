package com.huazie.fleadbtest.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huazie.fleadbtest.mybatisplus.entity.Student;
import com.huazie.fleadbtest.mybatisplus.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentSpringTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentSpringTest.class);

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelectAllByMapper() {
        List<Student> students = studentMapper.selectAll();
        LOGGER.debug("Student List = {}", students);
    }

    @Test
    public void testQueryByIdByMapper() {
        Student student = studentMapper.queryById(1L);
        LOGGER.debug("Student = {}", student);
    }

    @Test
    public void testSelectByIdNewByMapper() {
        Student student = studentMapper.selectByIdNew(1L);
        LOGGER.debug("Student = {}", student);
    }

    @Test
    public void testInsert() {
        Student student = new Student();
        student.setStuName("华仔");
        student.setStuAge(18);
        student.setStuSex(1);
        student.setStuState(1);
        int result = studentMapper.insert(student);
        LOGGER.debug("Result = {}", result);
    }

    @Test
    public void testUpdate() {
        Student student = new Student();
        student.setStuAge(19);
        student.setStuState(2);

//        QueryWrapper<Student> wrapper = new QueryWrapper<>();
//        queryWrapper.eq("stu_name", "华仔");

        UpdateWrapper<Student> wrapper = new UpdateWrapper<>();
        wrapper.eq("stu_name", "华仔");

        int result = studentMapper.update(student, wrapper);
        LOGGER.debug("Result = {}", result);
    }

    @Test
    public void testUpdate1() {
        Student student = new Student();
        student.setStuAge(18);
        student.setStuState(1);

        LambdaUpdateWrapper<Student> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(Student::getStuName, "华仔");
        int result = studentMapper.update(student, lambdaUpdateWrapper);
        LOGGER.debug("Result = {}", result);
    }

    @Test
    public void testDelete() {
        Student student1 = new Student();
        student1.setStuName("华仔");
        student1.setStuAge(18);
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(student1);
        int result = studentMapper.delete(queryWrapper);
        LOGGER.debug("Result = {}", result);
    }

    @Test
    public void testDelete1() {
        int result = studentMapper.deleteById(1L);
        LOGGER.debug("Result = {}", result);
    }

    @Test
    public void testSelectById() {
        Student student = studentMapper.selectById(1L);
        LOGGER.debug("Student = {}", student);
    }

    @Test
    public void testSelectAll() {
        List<Student> studentList = studentMapper.selectList(null);
        LOGGER.debug("Student List = {}", studentList);
    }

    @Test
    public void testSelectOne() {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getStuName, "华仔");
        Student student = studentMapper.selectOne(wrapper);
        LOGGER.debug("Student = {}", student);
    }

    @Test
    public void testSelectPage() {
        Page<Student> page = new Page<>(1, 2);

        LambdaQueryWrapper<Student> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Student::getStuAge, 18);
        studentMapper.selectPage(page, wrapper);
        LOGGER.debug("Student Total = {}", page.getTotal());
        LOGGER.debug("Student List = {}", page.getRecords());
    }

    @Test
    public void testSelectMapsPage() {
        Page<Map<String, Object>> page = new Page<>(1, 2);
        LambdaQueryWrapper<Student> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Student::getStuAge, 18);
        studentMapper.selectMapsPage(page, wrapper);
        LOGGER.debug("Student Total = {}", page.getTotal());
        LOGGER.debug("Student List = {}", page.getRecords());
    }

    // DynamicTableNameInnerInterceptor 动态表名
}
