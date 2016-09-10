package com.maacsport.controllers;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;


import com.maacsport.service.LogicManager;
import com.maacsport.service.LogicManagerImpl;

public class TestLogicControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
    	LogicController controller = new LogicController();
    	controller.setLogicManager(new LogicManagerImpl());
    	
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("reservations", modelAndView.getViewName());
        
       	
        //assertEquals("WEB-INF/views/hello.jsp", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        
       
        assertNotNull(nowValue);
    }

}