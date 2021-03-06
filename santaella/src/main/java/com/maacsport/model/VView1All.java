/**
 * 
 */
package com.maacsport.model;



import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

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


public class VView1All implements Serializable {

	
   
	 List<VView1Group> vView1Group;
	
     List<VView1> phonesList;
     
 	 List<VPerson> person18;
 	
 	 int update18;
 	
     public List<VPerson> getPerson18() {
		return person18;
	}

	public void setPerson18(List<VPerson> person18) {
		this.person18 = person18;
	}



	public List<VView1Group> getvView1Group() {
		return vView1Group;
	}

	public void setvView1Group(List<VView1Group> vView1Group) {
		this.vView1Group = vView1Group;
	}

	public List<VView1> getPhonesList() {
		return phonesList;
	}

	public void setPhonesList(List<VView1> phonesList) {
		this.phonesList = phonesList;
	}

	public int getUpdate18() {
		return update18;
	}

	public void setUpdate18(int update18) {
		this.update18 = update18;
	}

	

	


}
