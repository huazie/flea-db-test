package com.huazie.fleadbtest.jpa.repository;

import com.huazie.fleadbtest.jpa.common.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用于访问Student实体相关的数据库操作的接口
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
