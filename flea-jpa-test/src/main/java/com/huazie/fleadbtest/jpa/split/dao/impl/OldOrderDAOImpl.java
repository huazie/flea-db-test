package com.huazie.fleadbtest.jpa.split.dao.impl;

import com.huazie.fleadbtest.jpa.split.FleaOrderJPADAOImpl;
import com.huazie.fleadbtest.jpa.split.dao.interfaces.IOldOrderDAO;
import com.huazie.fleadbtest.jpa.split.entity.OldOrder;
import org.springframework.stereotype.Repository;

/**
 * flea旧订单DAO层实现类
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@Repository("oldOrderDAO")
public class OldOrderDAOImpl extends FleaOrderJPADAOImpl<OldOrder> implements IOldOrderDAO {
}