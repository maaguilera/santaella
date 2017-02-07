package com.maacsport.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maacsport.dao.PersonDao;
import com.maacsport.dao.ReservationDao;
import com.maacsport.model.Person;
import com.maacsport.model.Reservation;
import com.maacsport.util.Util;
import com.maacsport.util.UtilDate;

@Service("reservationService")

public class ReservationServiceImpl implements ReservationService {
	
	  @Autowired
      private ReservationDao elementDao;
	  @Autowired
      private PersonDao personDao;

      @Transactional
      public void save(Reservation book) {
    	  elementDao.save(book);
      }
      @Override
      @Transactional
      public void save(List<Reservation> book) {
    	  
    	  //List<Reservation> bookdao = new ArrayList<Reservation> ();
    	  //TODO: descomentar
    	  /*Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    	  String username="";
    	  if (principal instanceof UserDetails) {
    	     username = ((UserDetails)principal).getUsername();
    	  } else {
    	     username = principal.toString();
    	  }
    	  */
    	  String username="11111H";
    	  for (Reservation temp:book) {
    		  
    		  // verificamos si reservationId = -1 entao descartar
        	  // verificamos si tiene id y reservated = false entao reservation_status= 0
    		  /*if (!temp.isReservated() && temp.getReservationId()>0) bookdao.add(temp);
    		  else if (temp.isReservated() && temp.getReservationId()<=0) bookdao.add(temp);
    		  */
    		  if (!temp.isReservated() && temp.getReservationId()>0) {
    			  temp.setReservationStatus(0);
    			  try {	
     				 Calendar fecha= Calendar.getInstance();
     				
     				 fecha.setTime(Util.getDateWithFormat(temp.getReservationDay()+temp.getDay()));
     				 temp.setReservationStart(fecha); 
     			  } catch (Exception e) {
     				  
     			  }
    			  elementDao.save(temp);
    		  }
    		  else if (temp.isReservated() && temp.getReservationId()<=0) {
    			  temp.setReservationStatus(1);
    			 
    			  temp.setPerson(personDao.findById(username));
    			 
    			  Calendar fecha=Calendar.getInstance();
    			
    			String gg= temp.getReservationDay()+temp.getDay();
    			try {	
    				 fecha.setTime(Util.getDateWithFormat(gg));
    				  
    			  } catch (Exception e) {
    				  
    			  }
    			 
    			  
    			  
    			 // fecha.set(2016, (short)9, (short)5, (short)9, 30);;
    			  temp.setReservationStart(fecha);
    			  elementDao.persist(temp);
    		  }
    		  
    		  
    	  }
   	  
    	  
      }
      

      @Transactional( readOnly = true)
      public List<Reservation> getList() {
             return elementDao.getList();
      }
      
      @Transactional( readOnly = true)
      public List<Reservation> reservationByDay(Calendar fromDate) {
    	  List<Reservation> result = new ArrayList<Reservation>(); 
    	  
    	  int [] horas = {900,930,1000,1030,1100,1130,1200,1230,1300,1330,1400,1430,1500,1530,1600,1630,1700,1730,1800,1830,1900,1930,2000,2030,2100,2130,2200,2230};
    	 
    	  Hashtable<String,Reservation> ht = new Hashtable<String, Reservation>();
    	  
    	   List<Reservation> reservas = elementDao.reservationByDay(fromDate);
    	   
    	   for (Reservation t : reservas){
				String hh= Util.getPadL(t.getReservationStart().get(Calendar.HOUR),2);
				String mm= Util.getPadL(t.getReservationStart().get(Calendar.MINUTE),2);
				String hora =hh+mm;
				
				t.setDay(hora);
				t.setReservated(true);
				
				if (hasElement(horas,hora )) ht.put(Util.getPadL(hora,4), t);
			}
			
			for (int temp: horas) {
				
					if (ht.containsKey(Util.getPadL(temp,4))) {
						
						result.add(ht.get(Util.getPadL(temp,4)));
					} else {
						Reservation novo = new Reservation();
						//novo.setPerson(personDao.findById("11111H"));
						novo.setDay(Util.getPadL(temp,4));
						result.add(novo);
					}
				
			}

             return result;
      }
      
      @Transactional( readOnly = true)
      public List<Reservation> reservationByFilter() {
             return elementDao.reservationByFilter();
      }

      @Transactional( readOnly = true)
      public Reservation getElement(Long id) {
             return elementDao.findById(id);
      }
      
     

      @Transactional
      public void delete(Long id) {
    	  elementDao.delete(id);

      }
      
      @Transactional( readOnly = true)
      public void delete (Reservation element) {
              elementDao.delete(element);
      }

      public static boolean hasElement(int[] arr, String targetValue) {
  		for(int s: arr){
  			if(s==Integer.parseInt(targetValue))
  				return true;
  		}
  		return false;
  	}

}
