/**
 * 
 */
package com.maacsport.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;

/**
 * @author maaguilera
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import static javax.persistence.CascadeType.MERGE;

@Entity
@Table(name="Reservation")
@org.hibernate.annotations.DynamicInsert 
@org.hibernate.annotations.DynamicUpdate
//@org.hibernate.annotations.Immutable
public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "reservation_id", unique = true, nullable = false)
	 @GeneratedValue(strategy=GenerationType.AUTO)
   // @GenericGenerator(name = "gen", strategy = "foreign", parameters = { @Parameter(name = "property", value = "employee") })
	private long reservationId;
	
	@Column(name = "reservation_start")
	private Calendar reservationStart;
	
	@Column(name = "reservation_end")
	private Calendar reservationEnd;
	
	@Column(name = "reservation_price")
	private double reservationPrice;
	
	@Column(name = "reservation_paid")
	private boolean reservationPaid;
	
	@Column(name = "reservation_creation")
	private Calendar reservationCreate;
	
	@Column(name = "reservation_update")
	private Calendar reservationUpdate;
	
	//@Column(name = "person_person_id")
	//private String personId;
	
	@Column(name = "recinto_recinto_id")
	private long recintoId;
	
	@Column(name = "reservation_day")
	private int reservationDay;
	
	@Column(name = "reservation_status")
	private int reservationStatus;
	
	 @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = MERGE)
	// @ManyToOne(optional = false)
	 @JoinColumn(name = "person_person_id", referencedColumnName = "person_id") // Actually the default name
	private Person person;
	 

	 
	 @Transient
	 private String day;
	 
	 @Transient
	 private boolean reservatedOri;
	 
	 
	 @Transient
	 private boolean reservated;
	
	 public Reservation() {
		 
	 }
	
	public Reservation(Person item) {
        this.person = item;
        //item.getReservations().add(this);
}
	
    public Person getPerson() {
        return person;
}
    public void setPerson(Person person) {
        this.person = person;
}
	
	public long getReservationId() {
		return reservationId;
	}
	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}
	public Calendar getReservationStart() {
		return reservationStart;
	}
	public void setReservationStart(Calendar reservationStart) {
		this.reservationStart = reservationStart;
	}
	public Calendar getReservationEnd() {
		return reservationEnd;
	}
	public void setReservationEnd(Calendar reservationEnd) {
		this.reservationEnd = reservationEnd;
	}
	public double getReservationPrice() {
		return reservationPrice;
	}
	public void setReservationPrice(double reservationPrice) {
		this.reservationPrice = reservationPrice;
	}
	public boolean isReservationPaid() {
		return reservationPaid;
	}
	public void setReservationPaid(boolean reservationPaid) {
		this.reservationPaid = reservationPaid;
	}
	public Calendar getReservationCreate() {
		return reservationCreate;
	}
	public void setReservationCreate(Calendar reservationCreate) {
		this.reservationCreate = reservationCreate;
	}
	public Calendar getReservationUpdate() {
		return reservationUpdate;
	}
	public void setReservationUpdate(Calendar reservationUpdate) {
		this.reservationUpdate = reservationUpdate;
	}
	/*
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}*/
	public long getRecintoId() {
		return recintoId;
	}
	public void setRecintoId(long recintoId) {
		this.recintoId = recintoId;
	}
	
	
	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("reservationId: " + reservationId + ";");
        //buffer.append("personId: " + personId);
        return buffer.toString();
    }

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public boolean isReservated() {
		return reservated;
	}

	public void setReservated(boolean reservated) {
		this.reservated = reservated;
	}

	public int getReservationDay() {
		return reservationDay;
	}

	public void setReservationDay(int reservationDay) {
		this.reservationDay = reservationDay;
	}

	
	public boolean isReservatedOri() {
		return reservatedOri;
	}

	public void setReservatedOri(boolean reservatedOri) {
		this.reservatedOri = reservatedOri;
	}

	public int getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(int reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	
}
