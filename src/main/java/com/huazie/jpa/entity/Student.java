package com.huazie.jpa.entity;

import com.huazie.frame.common.FleaEntity;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <p> 学生表对应的实体类 </p>
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Table(name = "student")
public class Student extends FleaEntity {

    private static final long serialVersionUID = 1267943552214677159L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "STUDENT_SEQ")
    @SequenceGenerator(name = "STUDENT_SEQ")
    @Column(name = "stu_id", unique = true, nullable = false)
    private Long stuId; // 学生编号

    @Column(name = "stu_name", nullable = false)
    private String stuName; // 学生姓名

    @Column(name = "stu_age", nullable = false)
    private Integer stuAge; // 学生年龄

    @Column(name = "stu_sex", nullable = false)
    private Integer stuSex; // 学生性别（1：男 2：女）

    @Column(name = "stu_state", nullable = false)
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