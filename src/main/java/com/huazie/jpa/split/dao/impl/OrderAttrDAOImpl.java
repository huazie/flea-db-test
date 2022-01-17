package com.huazie.jpa.split.dao.impl;

import com.huazie.jpa.split.FleaOrderDAOImpl;
import com.huazie.jpa.split.dao.interfaces.IOrderAttrDAO;
import com.huazie.jpa.split.entity.OrderAttr;
import org.springframework.stereotype.Repository;

/**
 * flea订单属性DAO层实现类
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@Repository("orderAttrDAO")
public class OrderAttrDAOImpl extends FleaOrderDAOImpl<OrderAttr> implements IOrderAttrDAO {
}