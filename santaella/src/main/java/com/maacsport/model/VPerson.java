/**
 * 
 */
package com.maacsport.model;

import static javax.persistence.CascadeType.MERGE;

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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
@Table(name="V_Person")
@org.hibernate.annotations.DynamicInsert  // To disable generation of INSERT and UPDATE SQL statements on startup
@org.hibernate.annotations.DynamicUpdate
//@org.hibernate.annotations.Immutable

public class VPerson implements Serializable {

	private static final long serialVersionUID = 2L;
	
	@Id
	@Column(name = "id",  unique=true, nullable = false)
	@NotNull 
	@Size(
            min = 8,
            max = 10,
            message = "DNI is required, minimum 8 maximum 10 characters."
        )
	String id;
	
	

    //@Access(AccessType.PROPERTY) // para en runtime al acesso ser a traces de get y set
	@Column(name = "name")
	@NotNull 
	@Size(
            min = 2,
            max = 20,
            message = "Nombre is required, maximum 20 characters."
        )
	String name;
	
	
	@Column(name = "surname")
	@NotNull 
	@Size(
            min = 2,
            max = 30,
            message = "Apellido is required, maximum 30 characters."
        )
	String surname;
	
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "borndate")
	Calendar bornDate;
	
	@Column(name = "iswoman")
	boolean isWoman;
	
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "join_date")
	Calendar joinDate;
	
	
	@Column(name = "email")
	@Size(
            
            max = 45,
            message = "EMail, maximum 45 characters."
        )
	@Email
	String email;
	
	@Column(name = "tfo")
	@Size(
            
            max = 13,
            message = "TFO, maximum 13 characters."
        )
	String tfo;
	
	@Column(name = "city")
	@Size(
            
            max = 20,
            message = "City, maximum 20 characters."
        )
	String city;
	
	@Column(name = "cp")
	@Size(
            
            max = 8,
            message = "CP, maximum 8 characters."
        )
	String cp;
	
	@Column(name = "address")
	@Size(
            
            max = 45,
            message = "Address, maximum 45 characters."
        )
	String address;

	@Column(name = "creation_date", insertable = false, updatable = false)
	Calendar creation;
	
	@Column(name = "update_date", insertable = false, updatable = false)
	Calendar update;
	
	@Column(name = "description")
	@Size(
            
            max = 80,
            message = "Description, maximum 80 characters."
        )
	String description;
	
	@Column(name = "status")
	boolean status;
	
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dropout_date")
	Calendar dropOut;
	

	 @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = MERGE)
		// @ManyToOne(optional = false)
		 @JoinColumn(name = "v_type_id", referencedColumnName = "id") // Actually the default name
		private VType vType;
	


    

	public String getId() {
		return id;
	}
	
	

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public boolean isWoman() {
		return isWoman;
	}
	public void setWoman(boolean isWoman) {
		this.isWoman = isWoman;
	}
	public Calendar getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Calendar joinDate) {
		this.joinDate = joinDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public VType getvType() {
		return vType;
	}
	public void setvType(VType vType) {
		this.vType = vType;
	}
	public Calendar getBornDate() {
		return bornDate;
	}

	public void setBornDate(Calendar bornDate) {
		this.bornDate = bornDate;
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

	public Calendar getDropOut() {
		return dropOut;
	}

	public void setDropOut(Calendar dropOut) {
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

	public boolean isIsWoman() {
		return isWoman;
	}

	public void setIsWoman(boolean isWoman) {
		this.isWoman = isWoman;
	}

	


}
