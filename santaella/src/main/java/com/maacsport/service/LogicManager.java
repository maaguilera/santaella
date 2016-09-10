package com.maacsport.service;


import java.io.Serializable;
import java.util.List;

import com.maacsport.model.Reservation;



public interface LogicManager extends Serializable {

    //RESERVATION
	
	public void increasePrice(int percentage);
    
	public void setReservations (List<Reservation> reservations);
    
	public List<Reservation> getReservations();

}