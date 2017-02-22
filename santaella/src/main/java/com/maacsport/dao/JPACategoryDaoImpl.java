/**
 * 
 */
package com.maacsport.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maacsport.model.Category;
import com.maacsport.model.Person;


/**
 * @author maaguilera
 *
 */
@Repository(value = "CategoryDao")
public class JPACategoryDaoImpl  extends GenericDAOImpl<Category, Long> implements CategoryDao{

    protected JPACategoryDaoImpl() {
		super(Category.class);
		
	}
    
  
    @PersistenceContext
	private EntityManager em = null;
    
   
  //  private TransactionManager tm = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
        
    }
    
  
  
   
   
	public Category getCategory(long id) {
    	Category role = this.findById(id);
        return role;
    }

}
