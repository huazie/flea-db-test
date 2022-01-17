package com.huazie.jpa.split.service.impl;

import com.huazie.fleaframework.db.jpa.dao.interfaces.IAbstractFleaJPADAO;
import com.huazie.fleaframework.db.jpa.service.impl.AbstractFleaJPASVImpl;
import com.huazie.jpa.split.dao.interfaces.IOrderAttrDAO;
import com.huazie.jpa.split.entity.OrderAttr;
import com.huazie.jpa.split.service.interfaces.IOrderAttrSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * flea订单属性SV层实现类
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@Service("orderAttrSV")
public class OrderAttrSVImpl extends AbstractFleaJPASVImpl<OrderAttr> implements IOrderAttrSV {

    private IOrderAttrDAO orderAttrDao;

    @Autowired
    @Qualifier("orderAttrDAO")
    public void setOrderAttrDao(IOrderAttrDAO orderAttrDao) {
        this.orderAttrDao = orderAttrDao;
    }

    @Override
    protected IAbstractFleaJPADAO<OrderAttr> getDAO() {
        return orderAttrDao;
    }
}