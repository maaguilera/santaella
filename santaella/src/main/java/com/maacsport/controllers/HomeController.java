package com.maacsport.controllers;



import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value="/welcome.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("Returning hello view");
        
        String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);

        return new ModelAndView("welcome", "now", now);

    
    }
    
    @RequestMapping(value="/home.htm", method=RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home");
	}
    
    @RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView homePage() {
		return new ModelAndView("myHome"); //home
	}
	
	@RequestMapping(value={"/myHome.html","/index.html"}, method=RequestMethod.GET)
	public ModelAndView indexPage() {
		return new ModelAndView("myHome");
	}
	
	@RequestMapping(value="/sec/moderation", method=RequestMethod.GET)
	public ModelAndView moderatorPage() {
		return new ModelAndView("moderation");
	}
	
	@RequestMapping(value="/admin/first", method=RequestMethod.GET)
	public ModelAndView firstAdminPage() {
		return new ModelAndView("admin-first");
	}
	
	@RequestMapping(value="/admin/second", method=RequestMethod.GET)
	public ModelAndView secondAdminPage() {
		return new ModelAndView("admin-second");
	}
	
	@RequestMapping(value="/informationGeneric", method=RequestMethod.GET)
	public ModelAndView informationGeneric() {
		return new ModelAndView("informationGeneric");
	}
}