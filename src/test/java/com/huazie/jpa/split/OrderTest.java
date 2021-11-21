package com.huazie.jpa.split;

import com.huazie.fleaframework.common.slf4j.impl.FleaLoggerProxy;
import com.huazie.fleaframework.common.util.DateUtils;
import com.huazie.fleaframework.db.jpa.aspect.FleaTransactionalAspect;
import com.huazie.fleaframework.db.jpa.persistence.FleaEntityManager;
import com.huazie.jpa.split.entity.Order;
import com.huazie.jpa.split.service.interfaces.IOrderSV;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;

/**
 * @author huazie
 * @version 1.2.0
 * @since 1.2.0
 */
public class OrderTest {

    private static final Logger LOGGER = FleaLoggerProxy.getProxyInstance(OrderTest.class);

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        LOGGER.debug("ApplicationContext={}", applicationContext);
    }

    @Test
    public void testEntityManager() throws Exception {
        EntityManager entityManager = FleaEntityManager.getEntityManager("fleaorder2", "fleaOrderTransactionManager2");
        LOGGER.debug("EntityManager={}", entityManager);
    }

    @Test
    public void testFleaTransactionalAspect() {
        FleaTransactionalAspect fleaTransactionalAspect = applicationContext.getBean(FleaTransactionalAspect.class);
        LOGGER.debug("FleaTransactionalAspect={}", fleaTransactionalAspect);
    }

    @Test
    public void testInsertOrder() throws Exception {

        IOrderSV orderSV = (IOrderSV) applicationContext.getBean("orderSV");

        Order order = new Order();
        order.setOrderName("测试订单");
        order.setOrderPrice(0L);
        order.setOrderState(0);
        order.setOrderDate(DateUtils.getCurrentTime());

        Long orderId = (Long) orderSV.getFleaNextValue(null);
        order.setOrderId(orderId);

        orderSV.save(order);
    }

    @Test
    public void testQueryOrder() throws Exception {

        IOrderSV orderSV = (IOrderSV) applicationContext.getBean("orderSV");

        Order order = new Order();
        order.setOrderId(1000000000L);

        order = orderSV.queryNew(1000000000L, order);

        LOGGER.debug("Order={}", order);
    }

    @Test
    public void testUpdateOrder() throws Exception {

        IOrderSV orderSV = (IOrderSV) applicationContext.getBean("orderSV");

        Order order = new Order();
        order.setOrderId(1000000001L);

        order = orderSV.queryNew(1000000001L, order);

        LOGGER.debug("Before : {}", order);

        order.setOrderName("修改订单");
        order.setOrderPrice(100L);
        order.setOrderState(1);

        orderSV.update(order);

        Order order1 = new Order();
        order1.setOrderId(1000000001L);

        order1 = orderSV.queryNew(1000000001L, order1);

        LOGGER.debug("After : {}", order1);
    }

    @Test
    public void testDeleteOrder() throws Exception {
        IOrderSV orderSV = (IOrderSV) applicationContext.getBean("orderSV");

        Order order = new Order();
        order.setOrderId(1000000001L);

        Order order1 = orderSV.queryNew(1000000001, order);
        LOGGER.error("Before : {}", order1);

        orderSV.removeNew(1000000001L, order);

        Order order2 = orderSV.queryNew(1000000001, order);
        LOGGER.error("After : {}", order2);
    }
}
