/**
 * 
 */
package com.maacsport.dao;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maacsport.model.Person;
import com.maacsport.model.Reservation;

/**
 * @author maaguilera
 *
 */
@Repository(value = "reservationDao")
public class JPAReservationDao extends GenericDAOImpl<Reservation, Long> implements ReservationDao {

	
	
    private EntityManager em = null;
   // private TransactionManager tm = null;

    
    protected JPAReservationDao() {
 		super(Reservation.class);
 		
 	}
    
    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
   /* @PersistenceContext
    public void setTransactionManager(TransactionManager em) {
        this.tm = em;
        
        
    }*/

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Reservation> getReservationList() {
        //return em.createQuery("select p from Reservation p order by p.reservation_id").getResultList();
        return em.createQuery("select p from Reservation p order by p.reservationId").getResultList();
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Reservation> reservationByDay(Calendar fromDate) {
    	SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
    	String formatted = format1.format(fromDate.getTime());
    	int reservationDay = Integer.parseInt(formatted);
    	
        //return em.createQuery("select p from Reservation p order by p.reservation_id").getResultList();
        Query q= em.createQuery("select p from Reservation p  where reservationDay= :reservationDay order by p.reservationStart");
        q.setParameter("reservationDay", reservationDay);
        
        return q.getResultList();
    }
    
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Reservation> reservationByFilter() {
        //return em.createQuery("select p from Reservation p order by p.reservation_id").getResultList();
        return em.createQuery("select p from Reservation p order by p.reservationId").getResultList();
    }
    
    

   /* @Transactional(readOnly = false)
    public void saveReservation(Reservation item) {
        //// solo esto originalmente --> em.merge(item);
    	
    	em.merge(item);

    }*/

}
