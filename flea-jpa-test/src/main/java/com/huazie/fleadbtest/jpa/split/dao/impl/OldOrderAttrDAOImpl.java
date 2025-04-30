package com.huazie.fleadbtest.jpa.split.dao.impl;

import com.huazie.fleadbtest.jpa.split.FleaOrderJPADAOImpl;
import com.huazie.fleadbtest.jpa.split.dao.interfaces.IOldOrderAttrDAO;
import com.huazie.fleadbtest.jpa.split.entity.OldOrderAttr;
import org.springframework.stereotype.Repository;

/**
 * flea旧订单属性DAO层实现类
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@Repository("oldOrderAttrDAO")
public class OldOrderAttrDAOImpl extends FleaOrderJPADAOImpl<OldOrderAttr> implements IOldOrderAttrDAO {
}