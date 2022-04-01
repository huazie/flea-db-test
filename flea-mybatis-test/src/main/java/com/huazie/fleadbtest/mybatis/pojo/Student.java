package com.huazie.fleadbtest.mybatis.pojo;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 学生表对应的实体类
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
public class Student {

    private Long stuId; // 学生编号

    private String stuName; // 学生姓名

    private Integer stuAge; // 学生年龄

    private Integer stuSex; // 学生性别（1：男 2：女）

    private Integer stuState; // 学生状态（0：删除 1：在用）

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public Integer getStuSex() {
        return stuSex;
    }

    public void setStuSex(Integer stuSex) {
        this.stuSex = stuSex;
    }

    public Integer getStuState() {
        return stuState;
    }

    public void setStuState(Integer stuState) {
        this.stuState = stuState;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}