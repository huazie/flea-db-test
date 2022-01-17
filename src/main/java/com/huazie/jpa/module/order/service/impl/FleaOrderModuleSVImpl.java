package com.huazie.jpa.module.order.service.impl;

import com.huazie.fleaframework.common.exception.CommonException;
import com.huazie.fleaframework.common.util.DateUtils;
import com.huazie.fleaframework.common.util.ObjectUtils;
import com.huazie.fleaframework.db.jpa.transaction.FleaTransactional;
import com.huazie.jpa.module.order.service.interfaces.IFleaOrderModuleSV;
import com.huazie.jpa.split.entity.Order;
import com.huazie.jpa.split.entity.OrderAttr;
import com.huazie.jpa.split.service.interfaces.IOrderAttrSV;
import com.huazie.jpa.split.service.interfaces.IOrderSV;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@Service("fleaOrderModuleSV")
public class FleaOrderModuleSVImpl implements IFleaOrderModuleSV {

    private IOrderSV orderSV;

    private IOrderAttrSV orderAttrSV;

    @Resource(name = "orderSV")
    public void setOrderSV(IOrderSV orderSV) {
        this.orderSV = orderSV;
    }

    @Resource(name = "orderAttrSV")
    public void setOrderAttrSV(IOrderAttrSV orderAttrSV) {
        this.orderAttrSV = orderAttrSV;
    }

    @Override
    @FleaTransactional(value = "fleaOrderTransactionManager", unitName = "fleaorder")
    public void orderTransaction(Long orderId) throws CommonException {
        // 查询订单
        Order order = orderSV.getOrderById(orderId);
        if (ObjectUtils.isNotEmpty(order)) {
            // 更新订单
            order.setOrderName("修改订单【事物】");
            order.setOrderPrice(10000L);
            order.setOrderState(2);
            orderSV.update(order);

            // 新增订单属性
            OrderAttr orderAttr = new OrderAttr();
            orderAttr.setOrderId(orderId);
            orderAttr.setAttrCode("order");
            orderAttr.setAttrValue("transaction");
            orderAttr.setCreateDate(DateUtils.getCurrentTime());
            orderAttr.setRemarks("test");
            orderAttrSV.save(orderAttr);
        }

        // 抛出自定义的异常
        //ExceptionUtils.throwFleaException(FleaException.class, "主动抛出异常");
    }
}
