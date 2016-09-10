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
@Table(name="category")
@org.hibernate.annotations.DynamicInsert  // To disable generation of INSERT and UPDATE SQL statements on startup
@org.hibernate.annotations.DynamicUpdate
//@org.hibernate.annotations.Immutable

public class Category implements Serializable {

	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue
	@Column(name = "catetegory_id",  unique=true, nullable = false)
	Integer id;
	
	

    @Access(AccessType.PROPERTY) // para en runtime al acesso ser a traces de get y set
	@Column(name = "category_name")
	@NotNull 
	String name;
	
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="person_has_person", 
        joinColumns = {@JoinColumn(name="Category_catetegory_id", referencedColumnName="catetegory_id")},
        inverseJoinColumns = {@JoinColumn(name="person_person_id", referencedColumnName="person_id")}
    )
    private Set<Person> personRoles;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Set<Person> getUserRoles() {
        return personRoles;
    }
 
    public void setUserRoles(Set<Person> personRoles) {
        this.personRoles = personRoles;
    }
	
	


}
