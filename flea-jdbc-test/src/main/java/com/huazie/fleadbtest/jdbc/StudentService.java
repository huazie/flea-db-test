package com.huazie.fleadbtest.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional("jdbcTransactionManager")
    public void service() throws RuntimeException {

        // 插入一条记录
        String sql = "insert into student(stu_name, stu_age, stu_sex, stu_state) values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, "LGH", "18", 1, 1);

        sql = "update student set stu_state = ? where stu_name = ?";
        jdbcTemplate.update(sql, 0, "LGH");

        //throwEx();
    }

    private void throwEx() throws RuntimeException {
        throw new RuntimeException("Test Exception");
    }
}
