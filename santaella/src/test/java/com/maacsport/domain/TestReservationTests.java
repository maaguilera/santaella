package com.maacsport.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maacsport.dao.PersonDao;
import com.maacsport.dao.ReservationDao;
import com.maacsport.model.Person;
import com.maacsport.model.Reservation;

import org.junit.Before;
import org.junit.Test;

public class TestReservationTests {

    private Reservation reservation;
    
    private ApplicationContext context;
    private ReservationDao itemDao2;
    private PersonDao itemDao;

    @Before
    public void setUp() throws Exception {
    	
    	context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        itemDao2 = (ReservationDao) context.getBean("reservationDao");
        itemDao = (PersonDao) context.getBean("personDao");
        
        List<Person> items = itemDao.getList();
        List<Reservation> items2 = itemDao2.getList();
        // stub up a list of products
   	    Person person=items.get(0);
   	 
        reservation = new Reservation(person);
  	
    }

    @Test
    public void testSetAndGetId() {
        long reservationId = 0;//666;
        //assertNull(reservation.getReservationId());
        //reservation.setReservationId(reservationId);
        assertEquals(reservationId, reservation.getReservationId(),0);
    }

    @Test
    public void testSetAndGetPrice() {
        Double testPrice = 100.00;
        assertEquals(0, 0, 0);    
        reservation.setReservationPrice(testPrice.doubleValue());
        assertEquals(testPrice, new Double(reservation.getReservationPrice()));
    }
}