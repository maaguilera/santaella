/**
 * 
 */
package com.maacsport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.dom4j.IllegalAddException;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author maaguilera
 *
 */
@Entity
@Table(name="Person")
@org.hibernate.annotations.DynamicInsert  // To disable generation of INSERT and UPDATE SQL statements on startup
@org.hibernate.annotations.DynamicUpdate
//@org.hibernate.annotations.Immutable

public class Person implements Serializable {

	private static final long serialVersionUID = 2L;
	
	@Id
	@Column(name = "person_id",  unique=true, nullable = false)
	String personId;
	
	

    //@Access(AccessType.PROPERTY) // para en runtime al acesso ser a traces de get y set
	@Column(name = "person_name")
	@NotNull 
	@Size(
            min = 5,
            max = 40,
            message = "Name is required, maximum 40 characters."
        )
	String name;
	
	@Column(name = "person_email")
	@Email
	String email;
	
	@Column(name = "person_tfo")
	String tfo;
	

	@Column(name = "person_creation", insertable = false, updatable = false)
	Calendar creation;
	
	@Column(name = "person_dropout")
	String dropOut;
	
	@Column(name = "person_description")
	String description;
	

	@Column(name = "person_update", insertable = false, updatable = false)
	Calendar update;
	
	@Column(name = "person_status")
	boolean status;
	
	@Column(name = "person_ismale")
	boolean isMale;
	
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "person_borndate")
	Calendar bornDate;
	
	@Column(name = "person_dni")
	String dni;
	
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinTable(name="category_has_person",
        joinColumns = {@JoinColumn(name="person_person_id", referencedColumnName="person_id")},
        inverseJoinColumns = {@JoinColumn(name="Category_catetegory_id", referencedColumnName="catetegory_id")}
    )
    private Category category;
	
	
	
	
	
	
	@org.hibernate.annotations.Formula(
	        "substr(person_name, 1, 4) || '...'"
	    )
	    protected String shortDescription;

	    @org.hibernate.annotations.Formula(
	        "(select count(b.person_person_id) from reservation b where b.person_person_id = person_Id)"
	    )
	    protected BigDecimal averageBidAmount;
	    
	    
	

	 @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private Set<Reservation> reservations = new HashSet<Reservation>();
   
	public Set<Reservation> getReservations() {
        return reservations;
}
    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
}
    
    
    public void addReservation(Reservation reservation) {
        if (reservation == null)
            throw new NullPointerException("Can't add null reservation");
        
        if (reservation.getPerson() != null)   throw new IllegalAddException ("eeeee");
        
        getReservations().add(reservation);
        
        reservation.setPerson(this);
    }
    
    

	public String getPersonId() {
		return personId;
	}
	
	

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTfo() {
		return tfo;
	}

	public void setTfo(String tfo) {
		this.tfo = tfo;
	}

	public Calendar getCreation() {
		return creation;
	}

	public void setCreation(Calendar creation) {
		this.creation = creation;
	}

	public String getDropOut() {
		return dropOut;
	}

	public void setDropOut(String dropOut) {
		this.dropOut = dropOut;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getUpdate() {
		return update;
	}

	public void setUpdate(Calendar update) {
		this.update = update;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isIsMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public Calendar getBornDate() {
		return bornDate;
	}

	public void setBornDate(Calendar bornDate) {
		this.bornDate = bornDate;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	
	
	 public String getShortDescription() {
	        return shortDescription;
	    }

	    public BigDecimal getAverageBidAmount() {
	        return averageBidAmount;
	    }
	
	
	    public Category getCategory() {
	        return category;
	    }
	 
	    public void setRole(Category category) {
	        this.category = category;
	    }   
	
	


}
