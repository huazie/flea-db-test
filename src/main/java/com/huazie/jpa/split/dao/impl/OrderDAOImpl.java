package com.huazie.jpa.split.dao.impl;

import com.huazie.jpa.split.FleaOrderDAOImpl;
import com.huazie.jpa.split.dao.interfaces.IOrderDAO;
import com.huazie.jpa.split.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * <p> flea订单DAO层实现类 </p>
 *
 * @author huazie
 * @version 1.2.0
 * @since 1.2.0
 */
@Repository("orderDAO")
public class OrderDAOImpl extends FleaOrderDAOImpl<Order> implements IOrderDAO {
}