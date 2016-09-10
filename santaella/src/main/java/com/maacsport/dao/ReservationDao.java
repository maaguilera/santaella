/**
 * 
 */
package com.maacsport.dao;

import java.util.Calendar;
import java.util.List;


import com.maacsport.model.Reservation;

/**
 * @author maaguilera
 *
 */
public interface ReservationDao extends GenericDAO<Reservation, Long>{


    public List<Reservation> getReservationList();
    public List<Reservation> reservationByDay(Calendar fromDate);
    public List<Reservation> reservationByFilter();

    //public void saveReservation(Reservation item);
    
}
