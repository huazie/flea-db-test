package com.huazie.fleadbtest.jpa.split.service.impl;

import com.huazie.fleadbtest.jpa.split.dao.interfaces.IOrderDAO;
import com.huazie.fleadbtest.jpa.split.entity.Order;
import com.huazie.fleadbtest.jpa.split.service.interfaces.IOrderSV;
import com.huazie.fleaframework.common.exception.CommonException;
import com.huazie.fleaframework.common.util.CollectionUtils;
import com.huazie.fleaframework.db.jpa.dao.interfaces.IAbstractFleaJPADAO;
import com.huazie.fleaframework.db.jpa.service.impl.AbstractFleaJPASVImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * flea订单SV层实现类
 *
 * @author huazie
 * @version 1.2.0
 * @since 1.2.0
 */
@Service("orderSV")
public class OrderSVImpl extends AbstractFleaJPASVImpl<Order> implements IOrderSV {

    private IOrderDAO orderDao;

    @Autowired
    @Qualifier("orderDAO")
    public void setOrderDao(IOrderDAO orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order getOrderById(Long orderId) throws CommonException {
        Order order = new Order();
        order.setOrderId(orderId);

        Set<String> attrNames = new HashSet<>();
        attrNames.add("orderId");
        List<Order> orderList = this.query(attrNames, order);

        Order order1 = null;
        if (CollectionUtils.isNotEmpty(orderList)) {
            order1 = orderList.get(0);
        }
        return order1;
    }

    @Override
    protected IAbstractFleaJPADAO<Order> getDAO() {
        return orderDao;
    }
}