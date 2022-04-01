package com.huazie.fleadbtest.jpa.split;

import com.huazie.fleadbtest.jpa.module.order.service.interfaces.IFleaOrderModuleSV;
import com.huazie.fleadbtest.jpa.split.entity.Order;
import com.huazie.fleadbtest.jpa.split.service.interfaces.IOrderSV;
import com.huazie.fleaframework.common.slf4j.impl.FleaLoggerProxy;
import com.huazie.fleaframework.common.util.CollectionUtils;
import com.huazie.fleaframework.common.util.DateUtils;
import com.huazie.fleaframework.db.common.util.FleaLibUtil;
import com.huazie.fleaframework.db.jpa.aspect.FleaTransactionalAspect;
import com.huazie.fleaframework.db.jpa.persistence.FleaEntityManager;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        long orderId = 1000000000L;
        Order order = new Order();
        order.setOrderId(orderId);

        order = orderSV.query(orderId, order);

        LOGGER.debug("Order = {}", order);
    }

    @Test
    public void testUpdateOrder() throws Exception {

        IOrderSV orderSV = (IOrderSV) applicationContext.getBean("orderSV");

        long orderId = 1000000000L;
        Order order = new Order();
        order.setOrderId(orderId);

        Set<String> attrNames = new HashSet<>();
        attrNames.add("orderId");
        List<Order> orderList = orderSV.query(attrNames, order);

        if (CollectionUtils.isNotEmpty(orderList)) {
            order = orderList.get(0);

            LOGGER.debug("Before : {}", order);

            order.setOrderName("修改订单");
            order.setOrderPrice(100L);
            order.setOrderState(1);

            orderSV.update(order);
        }

        Order order1 = new Order();
        order1.setOrderId(orderId);

        order1 = orderSV.query(orderId, order1);

        LOGGER.debug("After : {}", order1);
    }

    @Test
    public void testDeleteOrder() throws Exception {
        IOrderSV orderSV = (IOrderSV) applicationContext.getBean("orderSV");

        long orderId = 1000000000L;
        Order order = new Order();
        order.setOrderId(orderId);

        Set<String> attrNames = new HashSet<>();
        attrNames.add("orderId");
        List<Order> orderList = orderSV.query(attrNames, order);

        if (CollectionUtils.isNotEmpty(orderList)) {
            Order order1 = orderList.get(0);
            LOGGER.error("Before : {}", order1);

            orderSV.remove(order1);
        }

        Order order2 = orderSV.query(orderId, order);
        LOGGER.error("After : {}", order2);
    }

    @Test
    public void testTransaction() throws Exception {

        IFleaOrderModuleSV fleaOrderModuleSV = (IFleaOrderModuleSV) applicationContext.getBean("fleaOrderModuleSV");

        long orderId = 1000000000L;

        // 设置分库序列值
        FleaLibUtil.setSplitLibSeqValue("SEQ", orderId);

        fleaOrderModuleSV.orderTransaction(orderId);
    }
}
