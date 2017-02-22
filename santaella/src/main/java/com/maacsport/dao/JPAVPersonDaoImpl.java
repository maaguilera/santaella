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

import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.maacsport.model.VPerson;



/**
 * @author maaguilera
 *
 */
@Repository(value = "vpersonDao")

public class JPAVPersonDaoImpl  extends GenericDAOImpl<VPerson, String> implements VPersonDao {
	

    protected JPAVPersonDaoImpl() {
		super(VPerson.class);
		
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
    
    public void persist2(VPerson p) {
        em.persist(p);
    }

  
   
  
    
    @Override
    public List<VPerson> getList(String name,String id,Calendar dateMe,Calendar dateMa) {
    	
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date startDate = dateMe.getTime();
        java.util.Date endDate = dateMa.getTime();

        
    	
    	CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); //1
        CriteriaQuery<VPerson> criteriaQuery = criteriaBuilder.createQuery(VPerson.class); //1
        
        Root<VPerson> root = criteriaQuery.from(em.getMetamodel().entity(VPerson.class)); //criteriaQuery.from(Person.class); //2

        
        criteriaQuery.select(root); //Paso 3
        List<Predicate> predicates = new ArrayList();
        
        //Name
        if (name!=null && name.trim().length()>0) {
        	Predicate preName = criteriaBuilder.like(root.<String>get("name"),"%"+name+"%"); //Paso 4
        	predicates.add(preName);
        }
        
        //DNI
        if (id!=null && id.trim().length()>0) {
        	Predicate preDni = criteriaBuilder.equal(root.get("id"),id); //Paso 4
        	predicates.add(preDni);
        }
        
        //DateMe
        ParameterExpression<Calendar> parameter1 = criteriaBuilder.parameter(Calendar.class);
        
        Predicate preDateBorn1= criteriaBuilder.greaterThanOrEqualTo(root.get("bornDate").as(Calendar.class),parameter1); //Paso 4
        
        //DateMa
        ParameterExpression<Calendar> parameter2 = criteriaBuilder.parameter(Calendar.class);
        
        Predicate preDateBorn2= criteriaBuilder.lessThanOrEqualTo(root.get("bornDate").as(Calendar.class),parameter2); //Paso 4
        
        // AND ...
       
        Predicate[] pre = predicates.toArray(new Predicate[predicates.size()]);
        Predicate preAnd = criteriaBuilder.and(pre); //Paso 4
        		
        criteriaQuery.where(preAnd); //Paso 5
        
        
        Query qry = em.createQuery(criteriaQuery);
        qry.setParameter(parameter1, dateMe, TemporalType.DATE);//Paso 6
        qry.setParameter(parameter2, dateMa, TemporalType.DATE);//Paso 6
        
        List<VPerson> results = qry.getResultList(); //Paso 6
        
        return results;
        
    }

    
 public List<VPerson> getList(String name,String id,Date dateMe,Date dateMa) {
    
        
    	
    	CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); //1
        CriteriaQuery<VPerson> criteriaQuery = criteriaBuilder.createQuery(VPerson.class); //1
        
        Root<VPerson> root = criteriaQuery.from(em.getMetamodel().entity(VPerson.class)); //criteriaQuery.from(Person.class); //2

        
        criteriaQuery.select(root); //Paso 3
        List<Predicate> predicates = new ArrayList<Predicate>();
        
       
        
        //Name
        if (name!=null && name.trim().length()>0) {
        	Predicate preName = criteriaBuilder.equal(root.get("name"),name); //Paso 4
        	predicates.add(preName);
        }
        
        //DNI
        if (id!=null && id.trim().length()>0) {
        	Predicate preDni = criteriaBuilder.equal(root.get("id"),id); //Paso 4
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
        
        List<VPerson> results = qry.getResultList(); //Paso 6
        
        return results;
        
    }


public VPerson getUser(String dni) {
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
