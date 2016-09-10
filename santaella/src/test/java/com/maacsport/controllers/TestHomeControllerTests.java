package com.maacsport.controllers;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.maacsport.dao.PersonDao;
import com.maacsport.dao.ReservationDao;
import com.maacsport.model.Person;
import com.maacsport.service.ReservationService;


public class TestHomeControllerTests {

	private ApplicationContext context;
    private ReservationDao itemDao;
    private PersonDao itemDao2;
   private ReservationService myService;
   private PersonController myController;

	
	@Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        itemDao = (ReservationDao) context.getBean("reservationDao");
        itemDao2 = (PersonDao) context.getBean("personDao");
        myService = (ReservationService) context.getBean("reservationService");
        myController = (PersonController) context.getBean("personController");
    }
    @Test
    public void testHandleRequestView() throws Exception{		
    	HomeController controller = new HomeController();
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("welcome", modelAndView.getViewName());
        
       	
        //assertEquals("WEB-INF/views/hello.jsp", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        String nowValue = (String) modelAndView.getModel().get("now");
        assertNotNull(nowValue);
        
        
    }
    
    @Test
    public void testPersonControllerView() throws Exception{		
    	
        
        PersonController controller = new PersonController();
        
        Person element = new Person();
        element.setName("miguel");
        element.setDni("11");
        element.setPersonId("11");
        element.setCreation(Calendar.getInstance());
        
        ModelAndView modelAndView = myController.saveBook(element, null);		
        assertEquals("prp", "prp");
    }

}