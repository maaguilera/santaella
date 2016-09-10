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
import org.springframework.transaction.annotation.Transactional;

import com.maacsport.model.Person;


/**
 * @author maaguilera
 *
 */
@Repository(value = "personDao")

public class JPAPersonDaoImpl  extends GenericDAOImpl<Person, String> implements PersonDao {
	

    protected JPAPersonDaoImpl() {
		super(Person.class);
		
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
    
    public void persist2(Person p) {
        em.persist(p);
    }

    
   /* private Session openSession() {
        return sessionFactory.getCurrentSession();
    }*/
    
   /* @PersistenceContext
    public void setTransactionManager(TransactionManager em) {
        this.tm = em;
        
        
    }*/

   /* @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Person> getList() {
        //return em.createQuery("select p from Reservation p order by p.reservation_id").getResultList();
        return em.createQuery("select p from Person p order by p.personId").getResultList();
    }*/

   /* @Transactional(readOnly = false)
    public void save(Person item) {
        //// solo esto originalmente --> em.merge(item);
    	
    	em.merge(item);

    }*/
    
    @Override
    public List<Person> findAll(boolean withBids) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = cb.createQuery(Person.class);
        Root<Person> i = criteria.from(Person.class);
        criteria.select(i)
            .distinct(true) // In-memory "distinct"!
            .orderBy(cb.asc(i.get("name")));
        if (withBids)
            i.fetch("reservations", JoinType.LEFT);
        return em.createQuery(criteria).getResultList();
    }



public Person getUser(String dni) {
	return this.findById(dni);
}
    
    /*public Person getUser(String dni) {
        List<Person> userList = new ArrayList<Person>();
        org.hibernate.Query query = openSession().createQuery("from Person u where u.personId = :dni");
        query.setParameter("dni", dni);
        userList = query.list();
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;    
    }*/

}
