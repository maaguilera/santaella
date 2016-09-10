package com.maacsport.form;

import java.util.List;

import com.maacsport.model.Reservation;

public class ReservationForm {
	
	private List<Reservation> reservations;
	private List<Reservation> reservationsOri;

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Reservation> getReservationsOri() {
		return reservationsOri;
	}

	public void setReservationsOri(List<Reservation> reservationsOri) {
		this.reservationsOri = reservationsOri;
	}

}
