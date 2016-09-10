package com.maacsport.repository;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maacsport.dao.PersonDao;
import com.maacsport.model.Person;
import com.maacsport.model.Reservation;



public class JPAPersonDaoTests {

    private ApplicationContext context;
    private PersonDao itemDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        itemDao = (PersonDao) context.getBean("personDao");
    }

    @Test
    public void testGetList() {
        List<Person> items = itemDao.getList();
        assertEquals(items.size(), 5, 0);	   
    }
    
    @Test
    public void testGetID() {
        Person items = itemDao.findById("11111H");
        assertEquals(items.getDni(), "30823652H", 0);	   
    }

    @Test
    public void testSave() {
        List<Person> items = itemDao.getList();

        Person p = items.get(0);
        Set<Reservation> tt= p.getReservations();
        
        String price = p.getName();
        p.setName("Ppito 200.12");
        
        itemDao.save(p);

        List<Person> updatedProducts = itemDao.getList();
        
        Person p2 = updatedProducts.get(0);
        assertEquals(p2.getName(), "Ppito 200.12");
        p2.setName(price);
        itemDao.save(p2);
    }
    
    @Test
    public void testSaveOne() {
       
        Person p = new Person();
        p.setDni("344eed");
       p.setPersonId("555557656H");
        p.setName("Ppito 200.12");
        p.setCreation(Calendar.getInstance());
        itemDao.save(p);

        List<Person> items = itemDao.getList();
        
       
        assertEquals(items.size(), 5, 0);	   

    }
}