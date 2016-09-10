package com.maacsport.dao;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


public abstract class GenericDAOImpl<T, ID extends Serializable>
    implements GenericDAO<T, ID> {

    @PersistenceContext
    protected EntityManager em;

    protected final Class<T> entityClass;

    protected GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public T findById(ID id) {
        return findById(id, LockModeType.NONE);
    }

    public T findById(ID id, LockModeType lockModeType) {
        return em.find(entityClass, id, lockModeType);
    }

    public T findReferenceById(ID id) {
        return em.getReference(entityClass, id);
    }

    public List<T> findAll() {
        CriteriaQuery<T> c =
            em.getCriteriaBuilder().createQuery(entityClass);
        c.select(c.from(entityClass));
        return em.createQuery(c).getResultList();
    }
    
    public List<T> getList() {
        CriteriaQuery<T> c =
            em.getCriteriaBuilder().createQuery(entityClass);
        c.select(c.from(entityClass));
        return em.createQuery(c).getResultList();
    }

    public Long getCount() {
        CriteriaQuery<Long> c =
           em.getCriteriaBuilder().createQuery(Long.class);
        c.select(em.getCriteriaBuilder().count(c.from(entityClass)));
        return em.createQuery(c).getSingleResult();
    }

     
    public T save(T instance) { //makePersistent
        // merge() handles transient AND detached instances
        return em.merge(instance);
    }
    
    
    public void persist(T instance) { //makePersistent
        // merge() handles transient AND detached instances
         em.persist(instance);
    }

    public void delete(T instance) { //makeTransient
        em.remove(instance);
    }
    
    public void delete(ID id) { //makeTransient
    	
    	T instance= findById( id); 
        em.remove(instance);
    }

    public void checkVersion(T entity, boolean forceUpdate) {
        em.lock(
            entity,
            forceUpdate
                ? LockModeType.OPTIMISTIC_FORCE_INCREMENT
                : LockModeType.OPTIMISTIC
        );
    }
}
