package com.huazie.fleadbtest.jpa.module.order.service.interfaces;

import com.huazie.fleaframework.common.exceptions.CommonException;

/**
 * 订单模块服务接口类
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
public interface IFleaOrderModuleSV {

    /**
     * 测试订单事物
     *
     * @param orderId 订单编号
     * @throws CommonException 通用异常
     */
    void orderTransaction(Long orderId) throws CommonException;

    /**
     * 测试旧订单事物
     *
     * @param orderId 订单编号
     * @throws CommonException 通用异常
     */
    void oldOrderTransaction(Long orderId) throws CommonException;
}
