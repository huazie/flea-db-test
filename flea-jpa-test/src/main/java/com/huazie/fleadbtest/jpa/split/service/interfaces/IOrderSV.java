package com.huazie.fleadbtest.jpa.split.service.interfaces;

import com.huazie.fleadbtest.jpa.split.entity.Order;
import com.huazie.fleaframework.common.exception.CommonException;
import com.huazie.fleaframework.db.jpa.service.interfaces.IAbstractFleaJPASV;

/**
 * flea订单SV层接口定义
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IOrderSV extends IAbstractFleaJPASV<Order> {

    /**
     * 根据订单编号，调用FleaJPAQuery获取订单数据
     *
     * @param orderId 订单编号
     * @return 获取订单数据
     * @throws CommonException 通用订单
     * @since 1.0.0
     */
    Order getOrderById(Long orderId) throws CommonException;
}