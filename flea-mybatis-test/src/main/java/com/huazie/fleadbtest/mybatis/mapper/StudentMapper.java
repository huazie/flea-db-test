package com.huazie.fleadbtest.mybatis.mapper;

import com.huazie.fleadbtest.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 接口类 和 映射文件放在同一个目录下，并且文件名要一致
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
public interface StudentMapper {

    List<Student> selectAll();

    Student queryById(Long id);

    @Select("select stu_id as stuId, " +
            "stu_name as stuName, " +
            "stu_age as stuAge, " +
            "stu_sex as stuSex, " +
            "stu_state as stuState " +
            "from student where stu_id = #{id}")
    Student selectByIdNew(Long mId);

}
