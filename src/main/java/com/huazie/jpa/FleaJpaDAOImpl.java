package com.huazie.jpa;

import com.huazie.frame.db.jpa.dao.impl.AbstractFleaJPADAOImpl;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * <p> FleaJpa数据源DAO层父类 </p>
 *
 * @author huazie
 * @version 1.0.0
 * @since 1.0.0
 */
public class FleaJpaDAOImpl<T> extends AbstractFleaJPADAOImpl<T> {

    @PersistenceContext(unitName="fleajpa")
    protected EntityManager entityManager;

    @Override
    @Transactional("fleaJpaTransactionManager")
    public T queryNew(long entityId, T entity) throws Exception {
        return super.queryNew(entityId, entity);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public T queryNew(String entityId, T entity) throws Exception {
        return super.queryNew(entityId, entity);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public boolean remove(long entityId) throws Exception {
        return super.remove(entityId);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public boolean remove(String entityId) throws Exception {
        return super.remove(entityId);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public boolean removeNew(long entityId, T entity) throws Exception {
        return super.removeNew(entityId, entity);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public boolean removeNew(String entityId, T entity) throws Exception {
        return super.removeNew(entityId, entity);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public T update(T entity) throws Exception {
        return super.update(entity);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public List<T> batchUpdate(List<T> entities) throws Exception {
        return super.batchUpdate(entities);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public void save(T entity) throws Exception {
        super.save(entity);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public void batchSave(List<T> entities) throws Exception {
        super.batchSave(entities);
    }

    @Override
    public List<T> query(String relationId, T entity) throws Exception {
        return super.query(relationId, entity);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public int insert(String relationId, T entity) throws Exception {
        return super.insert(relationId, entity);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public int update(String relationId, T entity) throws Exception {
        return super.update(relationId, entity);
    }

    @Override
    @Transactional("fleaJpaTransactionManager")
    public int delete(String relationId, T entity) throws Exception {
        return super.delete(relationId, entity);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}