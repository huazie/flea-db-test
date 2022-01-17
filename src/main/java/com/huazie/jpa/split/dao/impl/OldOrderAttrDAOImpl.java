package com.huazie.jpa.split.dao.impl;

import com.huazie.jpa.split.FleaOrderDAOImpl;
import com.huazie.jpa.split.dao.interfaces.IOldOrderAttrDAO;
import com.huazie.jpa.split.entity.OldOrderAttr;
import org.springframework.stereotype.Repository;

/**
 * flea旧订单属性DAO层实现类
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@Repository("oldOrderAttrDAO")
public class OldOrderAttrDAOImpl extends FleaOrderDAOImpl<OldOrderAttr> implements IOldOrderAttrDAO {
}