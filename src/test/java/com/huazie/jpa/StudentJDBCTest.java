package com.huazie.jpa;

import com.huazie.fleaframework.db.common.DBSystemEnum;
import com.huazie.fleaframework.db.jdbc.FleaJDBCHelper;
import com.huazie.fleaframework.db.jdbc.config.FleaJDBCConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>  </p>
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
public class StudentJDBCTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTest.class);

    @Test
    public void testStudentInsert() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        String sql = "insert into student(stu_name, stu_age, stu_sex, stu_state) values(?, ?, ?, ?)";

        List<Object> paramList = new ArrayList<Object>();
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

        List<Object> paramList = new ArrayList<Object>();
        paramList.add(1);

        LOGGER.debug("RESULT LIST = {}", FleaJDBCHelper.query(sql, paramList));
    }

    @Test
    public void testStudentSingleQuery() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        String sql = "select count(*) from student where stu_state = ?";

        List<Object> paramList = new ArrayList<Object>();
        paramList.add(1);

        LOGGER.debug("COUNT = {}", FleaJDBCHelper.querySingle(sql, paramList));
    }

    @Test
    public void testStudentUpdate() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        String sql = "update student set stu_state = ? where stu_name = ?";

        List<Object> paramList = new ArrayList<Object>();
        paramList.add(2);
        paramList.add("huazie");

        int ret = FleaJDBCHelper.update(sql, paramList);

        LOGGER.debug("RESULT = {}", ret);
    }

    @Test
    public void testStudentDelete() throws Exception {
        FleaJDBCConfig.init(DBSystemEnum.MySQL.getName(), "fleajpatest");

        String sql = "delete from student where stu_name = ? and stu_state = ? ";

        List<Object> paramList = new ArrayList<Object>();
        paramList.add("huazie");
        paramList.add(2);

        int ret = FleaJDBCHelper.delete(sql, paramList);

        LOGGER.debug("RESULT = {}", ret);
    }
}
