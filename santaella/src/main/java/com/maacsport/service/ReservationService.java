package com.maacsport.service;

import java.util.Calendar;
import java.util.List;

import com.maacsport.model.Reservation;

public interface ReservationService {

	/*
     * CREATE and UPDATE
     */
    public void save(Reservation element);
    public void save(List<Reservation> element);

    
    
    /*
     * READ
     */
    public List<Reservation> getList();
    public List<Reservation> reservationByDay(Calendar fromDate);
    public List<Reservation> reservationByFilter();
    public Reservation getElement(Long id);
   
    
    
    /*
     * DELETE
     */
    public void delete(Long id);
    public void delete(Reservation element);
}
