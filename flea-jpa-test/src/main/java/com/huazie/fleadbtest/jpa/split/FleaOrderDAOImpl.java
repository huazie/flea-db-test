package com.huazie.fleadbtest.jpa.split;

import com.huazie.fleaframework.common.exceptions.CommonException;
import com.huazie.fleaframework.db.jpa.dao.impl.AbstractFleaJPADAOImpl;
import com.huazie.fleaframework.db.jpa.transaction.FleaTransactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * FleaOrder数据源DAO层父类
 *
 * @author huazie
 * @version 1.2.0
 * @since 1.2.0
 */
public class FleaOrderDAOImpl<T> extends AbstractFleaJPADAOImpl<T> {

    @PersistenceContext(unitName="fleaorder")
    private EntityManager entityManager;

    @Override
    @FleaTransactional("fleaOrderTransactionManager")
    public Number getFleaNextValue(T entity) throws CommonException {
        return super.getFleaNextValue(entity);
    }

    @Override
    @FleaTransactional(value = "fleaOrderTransactionManager", unitName = "fleaorder")
    public boolean remove(long entityId) throws CommonException {
        return super.remove(entityId);
    }

    @Override
    @FleaTransactional(value = "fleaOrderTransactionManager", unitName = "fleaorder")
    public boolean remove(String entityId) throws CommonException {
        return super.remove(entityId);
    }

    @Override
    @FleaTransactional("fleaOrderTransactionManager")
    public boolean remove(T entity) throws CommonException {
        return super.remove(entity);
    }

    @Override
    @FleaTransactional("fleaOrderTransactionManager")
    public boolean remove(long entityId, T entity) throws CommonException {
        return super.remove(entityId, entity);
    }

    @Override
    @FleaTransactional("fleaOrderTransactionManager")
    public boolean remove(String entityId, T entity) throws CommonException {
        return super.remove(entityId, entity);
    }

    @Override
    @FleaTransactional("fleaOrderTransactionManager")
    public T update(T entity) throws CommonException {
        return super.update(entity);
    }

    @Override
    @FleaTransactional("fleaOrderTransactionManager")
    public List<T> batchUpdate(List<T> entities) throws CommonException {
        return super.batchUpdate(entities);
    }

    @Override
    @FleaTransactional("fleaOrderTransactionManager")
    public void save(T entity) throws CommonException {
        super.save(entity);
    }

    @Override
    @FleaTransactional("fleaOrderTransactionManager")
    public void batchSave(List<T> entities) throws CommonException {
        super.batchSave(entities);
    }

    @Override
    @FleaTransactional("fleaOrderTransactionManager")
    public int insert(String relationId, T entity) throws CommonException {
        return super.insert(relationId, entity);
    }

    @Override
    @FleaTransactional("fleaOrderTransactionManager")
    public int update(String relationId, T entity) throws CommonException {
        return super.update(relationId, entity);
    }

    @Override
    @FleaTransactional("fleaOrderTransactionManager")
    public int delete(String relationId, T entity) throws CommonException {
        return super.delete(relationId, entity);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}