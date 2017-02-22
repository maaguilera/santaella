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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

import org.dom4j.IllegalAddException;

/**
 * @author maaguilera
 *
 */
@Entity
@Table(name="v_type")
@org.hibernate.annotations.DynamicInsert  // To disable generation of INSERT and UPDATE SQL statements on startup
@org.hibernate.annotations.DynamicUpdate
//@org.hibernate.annotations.Immutable

public class VType implements Serializable {

	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue
	@Column(name = "id",  unique=true, nullable = false)
	Long id;
	//long id;
	
	

    @Access(AccessType.PROPERTY) // para en runtime al acesso ser a traces de get y set
	@Column(name = "name")
	@NotNull 
	String name;
    
    @Access(AccessType.PROPERTY) // para en runtime al acesso ser a traces de get y set
   	@Column(name = "description")
   	@NotNull 
   	String description;
    
    @Access(AccessType.PROPERTY) // para en runtime al acesso ser a traces de get y set
   	@Column(name = "amount")
   	Double amount;
    
    @Column(name = "creation_date", insertable = false, updatable = false)
	Calendar creation;
	
	@Column(name = "update_date", insertable = false, updatable = false)
	Calendar update;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public Calendar getCreation() {
		return creation;
	}

	public void setCreation(Calendar creation) {
		this.creation = creation;
	}

	public Calendar getUpdate() {
		return update;
	}

	public void setUpdate(Calendar update) {
		this.update = update;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	


}
