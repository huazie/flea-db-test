package com.huazie.fleadbtest.jpa.concurrency;

import com.huazie.fleadbtest.jpa.common.entity.Student;
import com.huazie.fleadbtest.jpa.common.service.interfaces.IStudentSV;
import com.huazie.fleaframework.common.exceptions.CommonException;
import com.huazie.fleaframework.common.slf4j.FleaLogger;
import com.huazie.fleaframework.common.slf4j.impl.FleaLoggerProxy;

import java.util.concurrent.ExecutorService;

/**
 * 测试 EntityManager 并发 persist
 *
 * @author huazie
 * @version 1.2.0
 * @since 1.2.0
 */
public class InsertTest {
    
    private static final FleaLogger LOGGER = FleaLoggerProxy.getProxyInstance(InsertTest.class);

    public static void testInsert(ExecutorService executorService, IStudentSV studentSV) {
        executorService.execute(new FleaInsertRunable0(studentSV));
        executorService.execute(new FleaInsertRunable1(studentSV));
        executorService.execute(new FleaInsertRunable2(studentSV));
    }

    static class FleaInsertRunable0 implements Runnable {

        IStudentSV studentSV;

        FleaInsertRunable0(IStudentSV studentSV) {
            this.studentSV = studentSV;
        }

        @Override
        public void run() {
            try {
                Student student = new Student();
                student.setStuName("张三4");
                student.setStuAge(18);
                student.setStuSex(1);
                student.setStuState(1);
                studentSV.save(student);
            } catch (CommonException e) {
                LOGGER.error("Exception = {}", e);
            }
        }
    }

    static class FleaInsertRunable1 implements Runnable {

        IStudentSV studentSV;

        FleaInsertRunable1(IStudentSV studentSV) {
            this.studentSV = studentSV;
        }

        @Override
        public void run() {
            try {
                Student student = new Student();
                student.setStuName("李四4");
                student.setStuAge(19);
                student.setStuSex(1);
                student.setStuState(1);
                studentSV.save(student);
            } catch (CommonException e) {
                LOGGER.error("Exception = {}", e);
            }
        }
    }

    static class FleaInsertRunable2 implements Runnable {

        IStudentSV studentSV;

        FleaInsertRunable2(IStudentSV studentSV) {
            this.studentSV = studentSV;
        }

        @Override
        public void run() {
            try {
                Student student = new Student();
                student.setStuName("王二麻子4");
                student.setStuAge(20);
                student.setStuSex(1);
                student.setStuState(1);
                studentSV.save(student);
            } catch (CommonException e) {
                LOGGER.error("Exception = {}", e);
            }
        }
    }
}
