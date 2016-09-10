package com.maacsport.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maacsport.model.*;

@Service
public class LogicManagerImpl  implements LogicManager {

	

    private static final long serialVersionUID = 1L;
    
    private List<Reservation> reservations;

    public List<Reservation> getReservations() {
    	return reservations;       
    }

    public void increasePrice(int percentage) {
    	 if (reservations != null) {
             for (Reservation product : reservations) {
                 double newPrice = product.getReservationPrice() * 
                                     (100 + percentage)/100;
                 product.setReservationPrice(newPrice);
             }
         }         
	}

	
	public void setReservations(List<Reservation> reservations) {
		this.reservations=reservations;
		
	}
	
   
}
