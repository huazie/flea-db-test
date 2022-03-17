package com.huazie.fleadbtest.jpa.split.service.impl;

import com.huazie.fleaframework.db.jpa.dao.interfaces.IAbstractFleaJPADAO;
import com.huazie.fleaframework.db.jpa.service.impl.AbstractFleaJPASVImpl;
import com.huazie.fleadbtest.jpa.split.dao.interfaces.IOldOrderDAO;
import com.huazie.fleadbtest.jpa.split.entity.OldOrder;
import com.huazie.fleadbtest.jpa.split.service.interfaces.IOldOrderSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * flea旧订单SV层实现类
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@Service("oldOrderSV")
public class OldOrderSVImpl extends AbstractFleaJPASVImpl<OldOrder> implements IOldOrderSV {

    private IOldOrderDAO oldOrderDao;

    @Autowired
    @Qualifier("oldOrderDAO")
    public void setOldOrderDao(IOldOrderDAO oldOrderDao) {
        this.oldOrderDao = oldOrderDao;
    }

    @Override
    protected IAbstractFleaJPADAO<OldOrder> getDAO() {
        return oldOrderDao;
    }
}