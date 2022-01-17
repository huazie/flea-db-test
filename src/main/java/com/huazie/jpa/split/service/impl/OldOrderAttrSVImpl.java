package com.huazie.jpa.split.service.impl;

import com.huazie.fleaframework.db.jpa.dao.interfaces.IAbstractFleaJPADAO;
import com.huazie.fleaframework.db.jpa.service.impl.AbstractFleaJPASVImpl;
import com.huazie.jpa.split.dao.interfaces.IOldOrderAttrDAO;
import com.huazie.jpa.split.entity.OldOrderAttr;
import com.huazie.jpa.split.service.interfaces.IOldOrderAttrSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * flea旧订单属性SV层实现类
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@Service("oldOrderAttrSV")
public class OldOrderAttrSVImpl extends AbstractFleaJPASVImpl<OldOrderAttr> implements IOldOrderAttrSV {

    private IOldOrderAttrDAO oldOrderAttrDao;

    @Autowired
    @Qualifier("oldOrderAttrDAO")
    public void setOldOrderAttrDao(IOldOrderAttrDAO oldOrderAttrDao) {
        this.oldOrderAttrDao = oldOrderAttrDao;
    }

    @Override
    protected IAbstractFleaJPADAO<OldOrderAttr> getDAO() {
        return oldOrderAttrDao;
    }
}