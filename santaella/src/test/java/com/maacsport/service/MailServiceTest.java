package com.maacsport.service;



import org.junit.Test;

import javax.annotation.Resource;

import junit.framework.Assert;
 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maacsport.dao.ReservationDao;
 
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/test-context.xml"})
public class MailServiceTest {
	
	private static final Log log = LogFactory.getLog(MailServiceTest.class);
	private ApplicationContext context;
 
	@Resource
	private MailService mailService;
	


	/**
	 * Probamos el envío
	 */
	@Test
	public void cantSendMails() {
		
		context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		mailService = (MailService) context.getBean("mailService");
		try {
			mailService.send("jmsanchez@autentiaf.com", "Test de envío de email.", "Prueba del envío de correo electrónico.");
			Assert.fail("No debería realizar el envío puesto que el host no está correctamente configurado en el entorno de test.");
		}
		catch(Exception e){
			log.trace("Excepción controlada, normal en el entorno de test",e);
		}
	}
	
	/*@Test
	public void cantSendMails2() {
		
		context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		mailService = (MailService) context.getBean("mailService");
		try {
			mailService.send("kordoves@gmail.com", "kordoves@gmail.com", "prueba email", "fileNameyLocation");
			//mailService.send("jmsanchez@autentiaf.com", "Test de envío de email.", "Prueba del envío de correo electrónico.");
			Assert.fail("No debería realizar el envío puesto que el host no está correctamente configurado en el entorno de test.");
		}
		catch(Exception e){
			log.trace("Excepción controlada, normal en el entorno de test",e);
		}
	}*/
  	
}
