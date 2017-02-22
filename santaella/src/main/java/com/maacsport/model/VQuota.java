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
@Table(name="V_quota")
@org.hibernate.annotations.DynamicInsert  // To disable generation of INSERT and UPDATE SQL statements on startup
@org.hibernate.annotations.DynamicUpdate
//@org.hibernate.annotations.Immutable

public class VQuota implements Serializable {

	private static final long serialVersionUID = 2L;
	
	
	@Id
	@GeneratedValue
	@Column(name = "id",  unique=true, nullable = false)
	long id;
	
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "quota_date")
	Calendar quotaDate;
	
	@Column(name = "creation_date", insertable = false, updatable = false)
	Calendar creation;
	
	@Column(name = "update_date", insertable = false, updatable = false)
	Calendar update;
	
	//@Access(AccessType.PROPERTY) // para en runtime al acesso ser a traces de get y set
		@Column(name = "amount")
		@NotNull 	
		Double amount;

    //@Access(AccessType.PROPERTY) // para en runtime al acesso ser a traces de get y set
	@Column(name = "name")
	@NotNull 
	@Size(
            min = 2,
            max = 20,
            message = "Nombre is required, maximum 20 characters."
        )
	String name;
	
	@Column(name = "concept")
	@NotNull 
	@Size(
            max = 45,
            message = "Concept is required, maximum 45 characters."
        )
	String concept;
	
	@Column(name = "discount")
	@NotNull 	
	Double discount;
	
	@Column(name = "token")
	@NotNull 
	String token;

	
	
	@Column(name = "amount_char")
	String amountChar;
	
	
	@Column(name = "description")
	@Size(
            
            max = 45,
            message = "Description, maximum 45 characters."
        )
	String description;
	

	 @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = MERGE)
		// @ManyToOne(optional = false)
		 @JoinColumn(name = "v_person_id", referencedColumnName = "id") // Actually the default name
		private VPerson vPerson;
	
	 @Column(name = "typeName")
		@NotNull 
		String typeName;
    

	 @Column(name = "ano")

		int ano;
	 
	public int getAno() {
		return ano;
	}



	public void setAno(int ano) {
		this.ano = ano;
	}



	public String getTypeName() {
		return typeName;
	}



	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	public long getId() {
		return id;
	}
	
	

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public Calendar getCreation() {
		return creation;
	}

	public void setCreation(Calendar creation) {
		this.creation = creation;
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



	public Calendar getQuotaDate() {
		return quotaDate;
	}



	public void setQuotaDate(Calendar quotaDate) {
		this.quotaDate = quotaDate;
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public String getConcept() {
		return concept;
	}



	public void setConcept(String concept) {
		this.concept = concept;
	}



	public Double getDiscount() {
		return discount;
	}



	public void setDiscount(Double discount) {
		this.discount = discount;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public String getAmountChar() {
		return amountChar;
	}



	public void setAmountChar(String amountChar) {
		this.amountChar = amountChar;
	}



	public VPerson getvPerson() {
		return vPerson;
	}



	public void setvPerson(VPerson vPerson) {
		this.vPerson = vPerson;
	}

	
	


}
