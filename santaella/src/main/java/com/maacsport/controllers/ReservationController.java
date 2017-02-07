package com.maacsport.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.maacsport.form.ReservationForm;
import com.maacsport.model.Person;
import com.maacsport.model.Reservation;
import com.maacsport.service.PersonService;
import com.maacsport.service.ReservationService;

@Controller("reservationController")
//@Scope("session")
@RequestMapping("/reservation")
@Transactional
public class ReservationController {
	
	public List<Reservation> diction=new ArrayList<Reservation>();
	
    @Autowired
    private ReservationService myService;

    @RequestMapping(value = {"/listReservations" })
    public String listBooks(Map<String, Object> map) {

           map.put("reservation", new Reservation());

           map.put("getList", myService.getList());

           return "/reservation/listReservations";
    }
   
    @RequestMapping(value="/reservationByDay2" , method=RequestMethod.GET)
    public String reservationByDay2(@RequestParam(value="day", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Calendar fromDate, Map<String, Object> map) {
    	 
        if (fromDate==null) {
        	fromDate=Calendar.getInstance();
        }
        
        List<Reservation>tt=myService.reservationByDay(fromDate);
        map.put("getList", tt);
        
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(fromDate.getTime());
        map.put("day", formatted);
        
        
        return "/reservation/reservationByDay";
    }
    
    @RequestMapping(value="/reservationByDay" , method=RequestMethod.GET)
    public ModelAndView reservationByDay(HttpServletRequest request,@RequestParam(value="day", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Calendar fromDate, Map<String, Object> map) {
    	 
        if (fromDate==null) {
        	fromDate=Calendar.getInstance();
        }
        
        ReservationForm tt= new ReservationForm();
        
        tt.setReservations(myService.reservationByDay(fromDate));
        tt.setReservationsOri(tt.getReservations());
        
        //map.put("reservationForm", tt);

  
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted1 = format1.format(fromDate.getTime());
        //map.put("day", formatted1);
        
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String formatted = format.format(fromDate.getTime());
        //map.put("day1", formatted);
        
        //map.put("recinto", 1);
        
        HttpSession session= request.getSession();
        session.setAttribute("reservationOri", tt.getReservationsOri());
        //map.put("reservation", new Reservation());
        
        ModelAndView model = new ModelAndView("reservationByDay");
        
        model.addObject("reservationForm", tt);
        model.addObject("day", formatted1);
        model.addObject("day1", formatted);
        model.addObject("recinto", 1);
        model.addObject("reservation", new Reservation());
        
        return model;
        
       // return "/reservation/reservationByDay";
    }
    
    @RequestMapping(value = { "/", "/reservationFilter2" })
    public String reservationByFilter2(Map<String, Object> map) {

          

           map.put("getList", myService.reservationByFilter());

           return "/reservation/listReservations";
    }
    
    @RequestMapping(value = { "/", "/reservationByFilter" })
    public String reservationByFilter(Map<String, Object> map) {

          ReservationForm tt= new ReservationForm();
          
          tt.setReservations(myService.reservationByFilter());

           map.put("reservationForm", tt);

           return "/reservation/listReservations";
    }

    @RequestMapping("/get/{elementId}")
    public String getElement(@PathVariable Long elementId, Map<String, Object> map) {

    	Reservation element = myService.getElement(elementId);

           map.put("reservation", element);

           return "/reservation/reservationDetailForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("reservation") Reservation element, BindingResult result) {

           myService.save(element);

           /*
            * Note that there is no slash "/" right after "redirect:"
            * So, it redirects to the path relative to the current path
            */
           return "redirect:/reservation/listReservations";
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/saveReservations", method = RequestMethod.POST)
    public ModelAndView saveReservations(HttpServletRequest request,@ModelAttribute("reservationForm") ReservationForm element, BindingResult result) {

    	
    	element.setReservationsOri((List<Reservation> )request.getSession().getAttribute("reservationOri"));
        myService.save(element.getReservations());

        /*
         * Note that there is no slash "/" right after "redirect:"
         * So, it redirects to the path relative to the current path
         */
        
        ModelAndView model = new ModelAndView("reservationSucess");
        
        
        return model;
        //return "redirect:/reservation/reservationSucess";
 }
 
    

    @RequestMapping("/delete/{elementId}")
    public String deleteBook(@PathVariable("elementId") Long id) {

           myService.delete(id);

           /*
            * redirects to the path relative to the current path
            */
           // return "redirect:../listBooks";

           /*
            * Note that there is the slash "/" right after "redirect:"
            * So, it redirects to the path relative to the project root path
            */
           return "redirect:/reservation/listReservations";
    }
    
   

}

