package com.huazie.fleadbtest.mybatis;

import com.huazie.fleadbtest.mybatis.mapper.StudentMapper;
import com.huazie.fleadbtest.mybatis.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
public class TestStudent {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestStudent.class);

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "flea/db/mybatis/flea-mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSelectAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Student> students = session.selectList("com.huazie.fleadbtest.mybatis.mapper.StudentMapper.selectAll");
            LOGGER.debug("Student List = {}", students);
        }
    }

    @Test
    public void testQueryById() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Student student = session.selectOne("com.huazie.fleadbtest.mybatis.mapper.StudentMapper.queryById", 9);
            LOGGER.debug("Student = {}", student);
        }
    }

    @Test
    public void testSelectAllByMapper() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            List<Student> students = mapper.selectAll();
            LOGGER.debug("Student List = {}", students);
        }
    }

    @Test
    public void testSelectByIdByMapper() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = mapper.queryById(9L);
            LOGGER.debug("Student = {}", student);
        }
    }

    @Test
    public void testSelectByIdNewByMapper() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = mapper.selectByIdNew(9L);
            LOGGER.debug("Student = {}", student);
        }
    }
}
