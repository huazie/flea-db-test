package com.huazie.fleadbtest.jpa;

import com.huazie.fleadbtest.jpa.common.service.interfaces.IStudentSV;
import com.huazie.fleadbtest.jpa.concurrency.InsertTest;
import com.huazie.fleaframework.common.slf4j.FleaLogger;
import com.huazie.fleaframework.common.slf4j.impl.FleaLoggerProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 已验证
 *
 * @author huazie
 * @version 1.2.0
 * @since 1.2.0
 */
public class StudentConcurrencyTest {

    private static final FleaLogger LOGGER = FleaLoggerProxy.getProxyInstance(StudentConcurrencyTest.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        LOGGER.debug("ApplicationContext={}", applicationContext);

        IStudentSV studentSV = (IStudentSV) applicationContext.getBean("studentSV");

        ExecutorService executorService = Executors.newCachedThreadPool();

        InsertTest.testInsert(executorService, studentSV);
    }
}
