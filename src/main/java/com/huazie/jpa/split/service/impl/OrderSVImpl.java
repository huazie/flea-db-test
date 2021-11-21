package com.huazie.jpa.split.service.impl;

import com.huazie.jpa.split.dao.interfaces.IOrderDAO;
import com.huazie.jpa.split.entity.Order;
import com.huazie.jpa.split.service.interfaces.IOrderSV;
import com.huazie.fleaframework.db.jpa.dao.interfaces.IAbstractFleaJPADAO;
import com.huazie.fleaframework.db.jpa.service.impl.AbstractFleaJPASVImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
    protected IAbstractFleaJPADAO<Order> getDAO() {
        return orderDao;
    }
}