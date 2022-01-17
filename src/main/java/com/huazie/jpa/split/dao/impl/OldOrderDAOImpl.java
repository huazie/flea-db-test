package com.huazie.jpa.split.dao.impl;

import com.huazie.jpa.split.FleaOrderDAOImpl;
import com.huazie.jpa.split.dao.interfaces.IOldOrderDAO;
import com.huazie.jpa.split.entity.OldOrder;
import org.springframework.stereotype.Repository;

/**
 * flea旧订单DAO层实现类
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@Repository("oldOrderDAO")
public class OldOrderDAOImpl extends FleaOrderDAOImpl<OldOrder> implements IOldOrderDAO {
}