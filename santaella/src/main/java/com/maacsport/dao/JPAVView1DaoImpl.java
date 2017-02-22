/**
 * 
 */
package com.maacsport.dao;




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maacsport.model.Reservation;
import com.maacsport.model.VView1;
import com.maacsport.model.VView1Group;




/**
 * @author maaguilera
 *
 */
@Repository(value = "vview1Dao")

public class JPAVView1DaoImpl  extends GenericDAOImpl<VView1,  String> implements VView1Dao {
	

    protected JPAVView1DaoImpl() {
		super(VView1.class);
		
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
    
    //@Transactional(readOnly = true)
   
    public List<VView1Group> getListByGroup2() {
    	
    	
       
    	TypedQuery<Object[]> q= em.createQuery("SELECT m.typename as typeName, COUNT(m) AS numero , sum(m.amount) as amount FROM View1 AS m GROUP BY m.typename", Object[].class);
        
    	List<Object[]> results= q.getResultList();
        List<VView1Group> lista = new ArrayList<VView1Group>();
        
         for (Object[] result : results) {
        	 VView1Group temp =new VView1Group(); 
        	 temp.setTypeName((String) result[0]);
        	 temp.setNumero((Long) result[1]);
        	 temp.setAmount((Double) result[2]);
        	 lista.add(temp);
        	}
        
        return lista;
    }
    
   
    
    public List<VView1Group> getListByGroup ()  
    {  
    	Session session = (Session) em.getDelegate();  
    	
    /*
    	Criteria criteria = session.createCriteria(VView1.class);
    	
    	criteria.setResultTransformer(Transformers.aliasToBean(VView1Group.class));
    	
    	criteria.setProjection(Projections.projectionList()
                .add(Projections.property("typeName"), "typeName")
                .add(Projections.rowCount(), "numero")
                .add(Projections.sum("amount"),"amount"));
                //.add(Projections.groupProperty("typeName")));
    	
    	 @SuppressWarnings("unchecked") 
    	List<VView1Group> results=criteria.list();
    	*/
    	
    	
    	
        @SuppressWarnings("unchecked") 
        List<VView1Group> results=session.createCriteria(VView1.class)
        		.setProjection(Projections.projectionList().add(Projections.groupProperty("typeName"), "typeName")
        												   .add(Projections.rowCount(), "numero")
        												   .add(Projections.sum("amount"),"amount"))
 
                .setResultTransformer(Transformers.aliasToBean(VView1Group.class))  
                .list();  
          
        return results;  
    } 
 
    

}
