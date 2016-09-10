package com.maacsport.repository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maacsport.dao.PersonDao;
import com.maacsport.dao.ReservationDao;
import com.maacsport.model.Person;
import com.maacsport.model.Reservation;
import com.maacsport.service.ReservationService;


public class JPAReservationDaoTests {

    private ApplicationContext context;
    private ReservationDao itemDao;
    private PersonDao itemDao2;
private ReservationService myService;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        itemDao = (ReservationDao) context.getBean("reservationDao");
        itemDao2 = (PersonDao) context.getBean("personDao");
        myService = (ReservationService) context.getBean("reservationService");
    }

    @Test
    public void testGetReservationList() {
        List<Reservation> items = itemDao.getReservationList();
        assertEquals(items.size(), 33, 0);	   
    }
    
    @Test
    public void testGetReservationById() {
       Reservation items = itemDao.findById((long)50);
        assertEquals(items.getPerson().getPersonId(), "11111H");	   
    }

    @Test
    public void testSaveReservation() {
        List<Reservation> items = itemDao.getReservationList();

        Reservation p = items.get(0);
        Double price = p.getReservationPrice();
        p.setReservationPrice(200.12);
        itemDao.save(p);

        List<Reservation> updatedProducts = itemDao.getReservationList();
        Reservation p2 = updatedProducts.get(0);
        assertEquals(p2.getReservationPrice(), 200.12, 0);

        p2.setReservationPrice(price);
        itemDao.save(p2);
    }
    
    
    @Test
    public void testSaveReservationOne() {
     
    	 List<Reservation> updatedProducts = itemDao.getReservationList();
    	 int numero = updatedProducts.size();
    	 List<Person> items = itemDao2.getList();

         Person pe = items.get(1);
         
        Reservation p =  new Reservation(pe);
     
        
        p.setReservationPrice(0.0);
        p.setRecintoId(1);
        p.setReservated(true);
        p.setReservationStatus(1);
        p.setReservationDay(20160903);
        p.setDay("20160903");
        
        itemDao.save(p);
        myService.save(p);

        List<Reservation> updatedProducts2 = itemDao.getReservationList();
        
        assertEquals(numero, updatedProducts2.size(), 0);

        
    }
    
    @Test
    public void testSaveReservationList() {
     
    	 List<Reservation> updatedProducts = itemDao.getReservationList();
    	 
    	 List<Reservation> element = new ArrayList<Reservation> ();
    	 
    	 int numero = updatedProducts.size();
    	 List<Person> items = itemDao2.getList();

         Person pe = items.get(1);
         
        Reservation p =  new Reservation(pe);
     
        
        p.setReservationPrice(0.0);
        p.setRecintoId(1);
        p.setReservated(true);
        p.setReservationStatus(1);
        p.setReservationDay(20160903);
        p.setDay("20160903");
        
        element.add(p);
        
        Reservation p2 =  new Reservation(pe);
     
        
        p2.setReservationPrice(0.0);
        p2.setRecintoId(1);
        p2.setReservated(true);
        p2.setReservationStatus(1);
        p2.setReservationDay(20160903);
        p2.setDay("20160903");
        
        element.add(p2);
        
        myService.save(element);

        List<Reservation> updatedProducts2 = itemDao.getReservationList();
        
        assertEquals(numero, updatedProducts2.size(), 0);

        
    }
}