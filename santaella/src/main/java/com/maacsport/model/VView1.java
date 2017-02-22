/**
 * 
 */
package com.maacsport.model;



import java.io.Serializable;
import java.util.Calendar;

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

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author maaguilera
 *
 */
@Entity
@Table(name="view1")
@org.hibernate.annotations.DynamicInsert  // To disable generation of INSERT and UPDATE SQL statements on startup
@org.hibernate.annotations.DynamicUpdate
//@org.hibernate.annotations.Immutable

public class VView1 implements Serializable {

	private static final long serialVersionUID = 2L;
	
	@Id
	@Column(name = "id",  insertable = false, updatable = false)
	@NotNull 
	String id;

	@Column(name = "name", insertable = false, updatable = false)
	@NotNull 
	String name;
	
	
	@Column(name = "surname", insertable = false, updatable = false)
	@NotNull 
	String surname;
	
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "borndate", insertable = false, updatable = false)
	Calendar bornDate;
	
	
	@Column(name = "typeName", insertable = false, updatable = false)
	String typeName;
	
	@Column(name = "amount", insertable = false, updatable = false)
	Double amount;
	
	@Column(name = "typeId", insertable = false, updatable = false)
	int typeId;
	
	@Column(name = "year", insertable = false, updatable = false)
	int year;
	
	@Column(name = "creation_date", insertable = false, updatable = false)
	Calendar creationDate;
	

    

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



	public Calendar getBornDate() {
		return bornDate;
	}



	public void setBornDate(Calendar bornDate) {
		this.bornDate = bornDate;
	}



	public String getTypeName() {
		return typeName;
	}



	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public int getTypeId() {
		return typeId;
	}



	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public Calendar getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	

	


}
