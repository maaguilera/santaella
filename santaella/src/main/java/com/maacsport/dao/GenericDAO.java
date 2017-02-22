package com.maacsport.dao;

import javax.persistence.LockModeType;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

/**
 * An interface shared by all business data access objects.
 * <p>
 * All CRUD (create, read, update, delete) basic data access operations are
 * isolated in this interface and shared across all DAO implementations.
 * The current design is for a state-management oriented persistence layer
 * (for example, there is no UPDATE statement function) which provides
 * automatic transactional dirty checking of business objects in persistent
 * state.
 */
public interface GenericDAO<T, ID extends Serializable> {

    T findById(ID id);

    T findById(ID id, LockModeType lockModeType);

    T findReferenceById(ID id);

    List<T> findAll();
    
    List<T> getList();
   
    Long getCount();

    T save(T entity);//makePersistent
    
    void persist(T entity);

    void delete(T entity);//makeTransient
    
    void delete(ID id);//makeTransient

    void checkVersion(T entity, boolean forceUpdate);

}
