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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maacsport.model.Person;

import antlr.StringUtils;


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

    @Override
    public List<Person> getList(String name,String dni,Calendar dateMe,Calendar dateMa) {
    	
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date startDate = dateMe.getTime();
        java.util.Date endDate = dateMa.getTime();

        
    	
    	CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); //1
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class); //1
        
        Root<Person> root = criteriaQuery.from(em.getMetamodel().entity(Person.class)); //criteriaQuery.from(Person.class); //2

        
        criteriaQuery.select(root); //Paso 3
        List<Predicate> predicates = new ArrayList();
        
        //Name
        if (name!=null && name.trim().length()>0) {
        	Predicate preName = criteriaBuilder.equal(root.get("person_name"),name); //Paso 4
        	predicates.add(preName);
        }
        
        //DNI
        if (dni!=null && dni.trim().length()>0) {
        	Predicate preDni = criteriaBuilder.equal(root.get("person_dni"),dni); //Paso 4
        	predicates.add(preDni);
        }
        
        //DateMe
        ParameterExpression<Calendar> parameter1 = criteriaBuilder.parameter(Calendar.class);
        
        Predicate preDateBorn1= criteriaBuilder.greaterThanOrEqualTo(root.get("person_bornDate").as(Calendar.class),parameter1); //Paso 4
        
        //DateMa
        ParameterExpression<Calendar> parameter2 = criteriaBuilder.parameter(Calendar.class);
        
        Predicate preDateBorn2= criteriaBuilder.lessThanOrEqualTo(root.get("person_bornDate").as(Calendar.class),parameter2); //Paso 4
        
        // AND ...
       
        Predicate[] pre = predicates.toArray(new Predicate[predicates.size()]);
        Predicate preAnd = criteriaBuilder.and(pre); //Paso 4
        		
        criteriaQuery.where(preAnd); //Paso 5
        
        
        Query qry = em.createQuery(criteriaQuery);
        qry.setParameter(parameter1, dateMe, TemporalType.DATE);//Paso 6
        qry.setParameter(parameter2, dateMa, TemporalType.DATE);//Paso 6
        
        List<Person> results = qry.getResultList(); //Paso 6
        
        return results;
        
    }

    
 public List<Person> getList(String name,String dni,Date dateMe,Date dateMa) {
    
        
    	
    	CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); //1
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class); //1
        
        Root<Person> root = criteriaQuery.from(em.getMetamodel().entity(Person.class)); //criteriaQuery.from(Person.class); //2

        
        criteriaQuery.select(root); //Paso 3
        List<Predicate> predicates = new ArrayList<Predicate>();
        
       
        
        //Name
        if (name!=null && name.trim().length()>0) {
        	Predicate preName = criteriaBuilder.equal(root.get("name"),name); //Paso 4
        	predicates.add(preName);
        }
        
        //DNI
        if (dni!=null && dni.trim().length()>0) {
        	Predicate preDni = criteriaBuilder.equal(root.get("person_dni"),dni); //Paso 4
        	predicates.add(preDni);
        }
        
        //DateMe
        ParameterExpression<Date> parameter1=null;
        if (dateMe!=null) {
        	parameter1 = criteriaBuilder.parameter(Date.class);
        
        	Predicate preDateBorn1= criteriaBuilder.greaterThanOrEqualTo(root.get("bornDate").as(Date.class),parameter1); //Paso 4
        	predicates.add(preDateBorn1);
        	
 		}
        //DateMa
        ParameterExpression<Date> parameter2=null;
        if (dateMa!=null) {
	         parameter2= criteriaBuilder.parameter(Date.class);
	        
	        Predicate preDateBorn2= criteriaBuilder.lessThanOrEqualTo(root.get("bornDate").as(Date.class),parameter2); //Paso 4
	        predicates.add(preDateBorn2);
	        
        }
        // AND ...
       
        if (predicates.size()>0) {
	        
        	Predicate[] pre = predicates.toArray(new Predicate[predicates.size()]);
	        Predicate preAnd = criteriaBuilder.and(pre); //Paso 4
	        		
	        criteriaQuery.where(preAnd); //Paso 5
        }
        
        
        Query qry = em.createQuery(criteriaQuery);
        
        if (parameter1!=null) qry.setParameter(parameter1, dateMe, TemporalType.DATE);//Paso 6
        if (parameter2!=null) qry.setParameter(parameter2, dateMa, TemporalType.DATE);//Paso 6
        
        List<Person> results = qry.getResultList(); //Paso 6
        
        return results;
        
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
