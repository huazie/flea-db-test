package com.huazie.jpa;

import com.huazie.fleaframework.common.slf4j.FleaLogger;
import com.huazie.fleaframework.common.slf4j.impl.FleaLoggerProxy;
import com.huazie.jpa.common.service.interfaces.IStudentSV;
import com.huazie.jpa.concurrency.InsertTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
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
