package com.maacsport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

	@RequestMapping(value="/user-login", method=RequestMethod.GET)
    public ModelAndView loginForm() {
       // return new ModelAndView("login-form");
        return new ModelAndView("login");
    }
     
    @RequestMapping(value="/error-login", method=RequestMethod.GET)
    public ModelAndView invalidLogin() {
        //ModelAndView modelAndView = new ModelAndView("login-form");
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("error", true);
        return modelAndView;
    }
     
    @RequestMapping(value="/success-login", method=RequestMethod.GET)
    public ModelAndView successLogin() {
    	
        return new ModelAndView("success-login");
    }
    
}
