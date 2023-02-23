package com.huazie.fleadbtest.spring;

import com.huazie.fleadbtest.jpa.StudentConcurrencyTest;
import com.huazie.fleadbtest.jpa.module.order.service.interfaces.IFleaOrderModuleSV;
import com.huazie.fleadbtest.jpa.split.entity.OldOrder;
import com.huazie.fleaframework.common.slf4j.FleaLogger;
import com.huazie.fleaframework.common.slf4j.impl.FleaLoggerProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
public class SpringTest {

    private static final FleaLogger LOGGER = FleaLoggerProxy.getProxyInstance(StudentConcurrencyTest.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        LOGGER.debug("ApplicationContext={}", applicationContext);

        OldOrder oldOrder = (OldOrder) applicationContext.getBean("order");
        LOGGER.debug("OldOrder={}", oldOrder);

        IFleaOrderModuleSV fleaOrderModuleSV = (IFleaOrderModuleSV) applicationContext.getBean("fleaOrderModuleSV");
        LOGGER.debug("IFleaOrderModuleSV={}", fleaOrderModuleSV);
        // 注册钩子程序
        ((ClassPathXmlApplicationContext) applicationContext).registerShutdownHook();

        // 停止 Spring服务
        //((ClassPathXmlApplicationContext) applicationContext).stop();
    }
}
