package com.huazie.fleadbtest.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huazie.fleadbtest.mybatisplus.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;

/**
 * 学生 Mapper 代理接口
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> selectAll();

    Student queryById(Long id);

    @Select("select stu_id as stuId, " +
            "stu_name as stuName, " +
            "stu_age as stuAge, " +
            "stu_sex as stuSex, " +
            "stu_state as stuState " +
            "from student where stu_id = #{id}")
    Student selectByIdNew(Long mId);

    @Select("select stu_id as stuId, " +
            "stu_name as stuName, " +
            "stu_age as stuAge, " +
            "stu_sex as stuSex, " +
            "stu_state as stuState " +
            "from student limit #{limit}")
    Cursor<Student> scan(@Param("limit") int limit);
}
