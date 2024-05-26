package com.huazie.fleadbtest.jdbc;

import com.huazie.fleaframework.db.common.DBSystemEnum;
import com.huazie.fleaframework.db.jdbc.FleaJDBCHelper;
import com.huazie.fleaframework.db.jdbc.config.FleaJDBCConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 已验证
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
public class StudentJDBCTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentJDBCTest.class);

    @Test
    public void testStudentInsert() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        String sql = "insert into student(stu_name, stu_age, stu_sex, stu_state) values(?, ?, ?, ?)";

        List<Object> paramList = new ArrayList<>();
        paramList.add("huazie");
        paramList.add(25);
        paramList.add(1);
        paramList.add(1);

        int ret = FleaJDBCHelper.insert(sql, paramList);

        LOGGER.debug("RESULT = {}", ret);
    }

    @Test
    public void testStudentQuery() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        String sql = "select * from student where stu_state = ?";

        List<Object> paramList = new ArrayList<>();
        paramList.add(1);

        LOGGER.debug("RESULT LIST = {}", FleaJDBCHelper.query(sql, paramList));
    }

    @Test
    public void testStudentSingleQuery() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        String sql = "select count(*) from student where stu_state = ?";

        List<Object> paramList = new ArrayList<>();
        paramList.add(1);

        LOGGER.debug("COUNT = {}", FleaJDBCHelper.querySingle(sql, paramList));
    }

    @Test
    public void testStudentUpdate() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        String sql = "update student set stu_state = ? where stu_name = ?";

        List<Object> paramList = new ArrayList<>();
        paramList.add(2);
        paramList.add("huazie");

        int ret = FleaJDBCHelper.update(sql, paramList);

        LOGGER.debug("RESULT = {}", ret);
    }

    @Test
    public void testStudentDelete() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        String sql = "delete from student where stu_name = ? and stu_state = ? ";

        List<Object> paramList = new ArrayList<>();
        paramList.add("huazie");
        paramList.add(2);

        int ret = FleaJDBCHelper.delete(sql, paramList);

        LOGGER.debug("RESULT = {}", ret);
    }

    @Test
    public void testJDBCTransaction() throws Exception {
        // flea-config.xml 中配置
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            conn = FleaJDBCConfig.getConfig().getConnection();
            // 关闭自动提交
            conn.setAutoCommit(false);

            // 执行第一条SQL语句
            String sql1 = "UPDATE student SET stu_age = stu_age-10 WHERE stu_name='huazie'";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.executeUpdate();

            LOGGER.debug("执行第一条SQL语句");
            // 模拟异常
            //throwEx();

            // 执行第二条SQL语句
            String sql2 = "UPDATE student SET stu_age = stu_age+12 WHERE stu_name='huazie'";
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.executeUpdate();

            LOGGER.debug("执行第二条SQL语句");
            // 提交事务
            conn.commit();

            LOGGER.debug("提交事物");
        } catch (SQLException e) {
            if (null != conn) {
                try {
                    // 回滚事务
                    conn.rollback();
                    LOGGER.debug("回滚事物");
                } catch (SQLException ex) {
                }
            }
        } finally {
            // 关闭资源
            if (null != pstmt2) pstmt2.close();
            if (null != pstmt1) pstmt1.close();
            if (null != conn) conn.close();
        }

    }

    private void throwEx() throws SQLException {
        throw new SQLException("Test Exception");
    }

}
