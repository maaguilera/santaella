/**
 * 
 */
package com.maacsport.dao;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maacsport.model.VPerson;
import com.maacsport.model.VQuota;
import com.maacsport.model.VView1;

import antlr.StringUtils;


/**
 * @author maaguilera
 *
 */
@Repository(value = "vquotaDao")

public class JPAVQuotaDaoImpl  extends GenericDAOImpl<VQuota, String> implements  VQuotaDao {
	

    protected JPAVQuotaDaoImpl() {
		super(VQuota.class);
		
	}
    
  
    @PersistenceContext
	private EntityManager em = null;
  
    //@Autowired
    //private SessionFactory sessionFactory;
    
   
  //  private TransactionManager tm = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
        
    }
    
    @Override
    
    public void persist2(VQuota p) {
        em.persist(p);
    }

    @Override
    public int insertQuotas1() {
      	
      	Session session = (Session) em.getDelegate();  
  
      	Transaction tx = session.beginTransaction();

      	String hqlInsert = "insert into v_quota (amount,name,v_person_id,ano,typeName,concept,discount,token,amount_char,description) select amount,name,id,year,typeName,'concept',0,'token','','' from view1;";
      	int result = session.createQuery( hqlInsert ).executeUpdate();
      	tx.commit();
      	session.close();
  		
  		session.flush();
  		session.clear();
  		
  		return result;
  		
  	}
    
    @Override
    public void insertQuotas2(List<VQuota> elements) {
      	
      	Session session = (Session) em.getDelegate();  
  
      	Transaction tx = session.beginTransaction();

      
      	for (VQuota element: elements) {
      	 
      	   
      	    session.save(element);
      	}
      	tx.commit();
      	session.close();
  
  	}
    
    @Override
    public void insertQuotas3(List<VQuota> elements) {
      	
      	Session session = (Session) em.getDelegate();  
  
      	Transaction tx = session.beginTransaction();

      
      	for (VQuota element: elements) {
      	    
      	    session.save(element);
      	}
      	tx.commit();
      	session.close();
  		

  		
  	}
  


    
    @Override
    public List<VQuota> getList(int ano,String typeName, String dni) {

        
    	
    	CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); //1
        CriteriaQuery<VQuota> criteriaQuery = criteriaBuilder.createQuery(VQuota.class); //1
        
        Root<VQuota> root = criteriaQuery.from(em.getMetamodel().entity(VQuota.class)); //criteriaQuery.from(Person.class); //2

        
        criteriaQuery.select(root); //Paso 3
        List<Predicate> predicates = new ArrayList();
        
        //Ano
        if (ano>0) {
        	Predicate preAno= criteriaBuilder.equal(root.get("ano"),ano); //Paso 4
        	predicates.add(preAno);
        }
        
        //TypeName
        if (typeName!=null && typeName.trim().length()>0) {
        	Predicate preTypeName = criteriaBuilder.like(root.<String>get("typeName"),"%"+typeName+"%"); //Paso 4
        	predicates.add(preTypeName);
        }
        
        //DNI
        if (dni!=null && dni.trim().length()>0) {
        	Predicate preDni = criteriaBuilder.equal(root.get("dni"),dni); //Paso 4
        	predicates.add(preDni);
        }
        
        // AND ...
       
        Predicate[] pre = predicates.toArray(new Predicate[predicates.size()]);
        Predicate preAnd = criteriaBuilder.and(pre); //Paso 4
        		
        criteriaQuery.where(preAnd); //Paso 5
        
        
        Query qry = em.createQuery(criteriaQuery);
        
        List<VQuota> results = qry.getResultList(); //Paso 6
        
        return results;
        
    }

	
    
 


  

}
