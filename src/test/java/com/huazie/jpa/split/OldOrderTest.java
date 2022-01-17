package com.huazie.jpa.split;

import com.huazie.fleaframework.common.slf4j.impl.FleaLoggerProxy;
import com.huazie.fleaframework.common.util.CollectionUtils;
import com.huazie.fleaframework.common.util.DateUtils;
import com.huazie.fleaframework.db.common.util.FleaLibUtil;
import com.huazie.jpa.module.order.service.interfaces.IFleaOrderModuleSV;
import com.huazie.jpa.split.entity.OldOrder;
import com.huazie.jpa.split.service.interfaces.IOldOrderSV;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huazie
 * @version 1.2.0
 * @since 1.2.0
 */
public class OldOrderTest {

    private static final Logger LOGGER = FleaLoggerProxy.getProxyInstance(OldOrderTest.class);

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        LOGGER.debug("ApplicationContext={}", applicationContext);
    }

    @Test
    public void testInsertOldOrder() throws Exception {

        IOldOrderSV oldOrderSV = (IOldOrderSV) applicationContext.getBean("oldOrderSV");

        OldOrder oldOrder = new OldOrder();
        oldOrder.setOrderName("测试旧订单1");
        oldOrder.setOrderPrice(200L);
        oldOrder.setOrderState(0);
        oldOrder.setOrderDate(DateUtils.getCurrentTime());

        Long orderId = (Long) oldOrderSV.getFleaNextValue(null);
        oldOrder.setOrderId(orderId);

        // 设置分库序列值
        FleaLibUtil.setSplitLibSeqValue("SEQ", orderId);

        oldOrderSV.save(oldOrder);
    }

    @Test
    public void testQueryOldOrder() throws Exception {

        IOldOrderSV oldOrderSV = (IOldOrderSV) applicationContext.getBean("oldOrderSV");

        long orderId = 1000000000L;
        OldOrder oldOrder = new OldOrder();
        //oldOrder.setOrderId(orderId);

        // 设置分库序列值
        FleaLibUtil.setSplitLibSeqValue("SEQ", orderId);

        // 分库场景，需要实体类，为了后续从中获取默认库名
        oldOrder = oldOrderSV.query(orderId, oldOrder);

        LOGGER.debug("Order = {}", oldOrder);
    }

    @Test
    public void testUpdateOldOrder() throws Exception {

        IOldOrderSV oldOrderSV = (IOldOrderSV) applicationContext.getBean("oldOrderSV");

        long orderId = 1000000000L;

        // 设置分库序列值
        FleaLibUtil.setSplitLibSeqValue("SEQ", orderId);

        OldOrder oldOrder = new OldOrder();
        oldOrder.setOrderId(orderId);

        Set<String> attrNames = new HashSet<>();
        attrNames.add("orderId");
        List<OldOrder> oldOrderList = oldOrderSV.query(attrNames, oldOrder);

        if (CollectionUtils.isNotEmpty(oldOrderList)) {
            oldOrder = oldOrderList.get(0);

            LOGGER.debug("Before : {}", oldOrder);

            oldOrder.setOrderName("修改旧订单1");
            oldOrder.setOrderPrice(200L);
            oldOrder.setOrderState(2);

            oldOrderSV.update(oldOrder);
        }

        OldOrder oldOrder1 = new OldOrder();
        //oldOrder1.setOrderId(orderId);

        oldOrder1 = oldOrderSV.query(orderId, oldOrder1);

        LOGGER.debug("After : {}", oldOrder1);
    }

    @Test
    public void testDeleteOldOrder() throws Exception {
        IOldOrderSV oldOrderSV = (IOldOrderSV) applicationContext.getBean("oldOrderSV");

        long orderId = 1000000001L;

        // 设置分库序列值
        FleaLibUtil.setSplitLibSeqValue("SEQ", orderId);

        OldOrder oldOrder = new OldOrder();
        oldOrder.setOrderId(orderId);

        Set<String> attrNames = new HashSet<>();
        attrNames.add("orderId");
        List<OldOrder> orderList = oldOrderSV.query(attrNames, oldOrder);

        if (CollectionUtils.isNotEmpty(orderList)) {
            OldOrder oldOrder1 = orderList.get(0);
            LOGGER.error("Before : {}", oldOrder1);
            oldOrderSV.remove(oldOrder1);
        }

        OldOrder oldOrder2 = new OldOrder();
        oldOrder2 = oldOrderSV.query(orderId, oldOrder2);
        LOGGER.error("After : {}", oldOrder2);
    }

    @Test
    public void testTransaction() throws Exception {

        IFleaOrderModuleSV fleaOrderModuleSV = (IFleaOrderModuleSV) applicationContext.getBean("fleaOrderModuleSV");

        Long orderId = 1000000000L;

        // 设置分库序列值
        FleaLibUtil.setSplitLibSeqValue("SEQ", orderId);

    }
}
