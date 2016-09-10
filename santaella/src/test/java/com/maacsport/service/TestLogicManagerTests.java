/**
 * 
 */
package com.maacsport.service;



import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maacsport.model.Person;
import com.maacsport.model.Reservation;
import com.maacsport.dao.PersonDao;
import com.maacsport.dao.ReservationDao;

/**
 * @author maaguilera
 *
 */

public class TestLogicManagerTests {

    private LogicManagerImpl logicManager;
    
    
    private List<Reservation> reservations;
    
    private static int RESERVATION_COUNT = 2;
    
    private static Double UNO_PRICE = new Double(20.50);
    private static long UNO_ID = 0;//666;
    

    private static Double DOS_PRICE = new Double(150.10); 
    private static long DOS_ID = 0;//667;
    
    private static int POSITIVE_PRICE_INCREASE = 10; 
    
    private ApplicationContext context;
    private ReservationDao itemDao2;
    private PersonDao itemDao;
    
    @Before
    public void setUp() throws Exception {
    	logicManager = new LogicManagerImpl();
    	context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
          itemDao2 = (ReservationDao) context.getBean("reservationDao");
          itemDao = (PersonDao) context.getBean("personDao");
    	
    	 reservations = new ArrayList<Reservation>();
         
    	 List<Person> items = itemDao.getList();
    	 
         // stub up a list of products
    	 Person person=items.get(0);
    
         Reservation product = new Reservation(person);
         //product.setReservationId(UNO_ID);
         product.setReservationPrice(UNO_PRICE);
         reservations.add(product);
         
         product = new Reservation(person);
        // product.setReservationId(DOS_ID);
         product.setReservationPrice(DOS_PRICE);
         reservations.add(product);
         
         logicManager.setReservations(reservations);
    }

    @Test
    public void testGetReservationsWithNoReservations() {
    	logicManager = new LogicManagerImpl();
        assertNull(logicManager.getReservations());
    }
    
    @Test
    public void testGetReservations() {
        List<Reservation> reservations = logicManager.getReservations();
        assertNotNull(reservations);        
        assertEquals(RESERVATION_COUNT, logicManager.getReservations().size());
    
        Reservation reservation = reservations.get(0);
        assertEquals(UNO_ID, reservation.getReservationId());
        //assertEquals(UNO_PRICE, reservation.getReservationPrice());
        assertEquals(UNO_PRICE, new Double(reservation.getReservationPrice()));
        
        reservation = reservations.get(1);
        assertEquals(DOS_ID, reservation.getReservationId());
       // assertEquals(DOS_PRICE, reservation.getReservationPrice());  
        assertEquals(DOS_PRICE, new Double(reservation.getReservationPrice()));
    }
    
    
    
    
    @Test
    public void testIncreasePriceWithNullListOfReservations() {
        try {
            logicManager = new LogicManagerImpl();
            logicManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch(NullPointerException ex) {
            fail("Reservations list is null.");
        }
    }

    @Test
    public void testIncreasePriceWithEmptyListOfReservations() {
        try {
        	logicManager = new LogicManagerImpl();
        	//logicManager.setReservations(new ArrayList<Reservation>());
        	logicManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch(Exception ex) {
            fail("Reservations list is empty.");
        }           
    }
    
    @Test
    public void testIncreasePriceWithPositivePercentage() {
    	logicManager.increasePrice(POSITIVE_PRICE_INCREASE);
        double expectedChairPriceWithIncrease = 22.55;
        double expectedTablePriceWithIncrease = 165.11;
        
        List<Reservation> products = logicManager.getReservations();      
        Reservation product = products.get(0);
        assertEquals(expectedChairPriceWithIncrease, product.getReservationPrice(), 0);
        
        product = products.get(1);      
        assertEquals(expectedTablePriceWithIncrease, product.getReservationPrice(), 0);       
    }
}
