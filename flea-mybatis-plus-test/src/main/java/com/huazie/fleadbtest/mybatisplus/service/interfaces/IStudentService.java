package com.huazie.fleadbtest.mybatisplus.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huazie.fleadbtest.mybatisplus.entity.Student;

/**
 * 学生服务层接口类
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
public interface IStudentService extends IService<Student> {

    /**
     * 流式查询演示
     *
     * @param limit 查询条数
     * @since 2.0.0
     */
    void scan(int limit);

    void service() throws RuntimeException;
}
