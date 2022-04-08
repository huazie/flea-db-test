package com.huazie.fleadbtest.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 学生表对应的实体类
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@TableName("student")
public class Student {

    @TableId(value = "stu_id", type = IdType.AUTO)
    private Long stuId; // 学生编号

    @TableField(value = "stu_name")
    private String stuName; // 学生姓名

    @TableField(value = "stu_age")
    private Integer stuAge; // 学生年龄

    @TableField(value = "stu_sex")
    private Integer stuSex; // 学生性别（1：男 2：女）

    @TableField(value = "stu_state")
    private Integer stuState; // 学生状态（0：删除 1：在用）

}