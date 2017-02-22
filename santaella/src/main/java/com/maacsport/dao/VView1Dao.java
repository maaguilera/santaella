/**
 * 
 */
package com.maacsport.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import com.maacsport.model.VView1;
import com.maacsport.model.VView1Group;

/**
 * @author maaguilera
 *
 */
public interface VView1Dao extends GenericDAO<VView1, String>{

	
	//@Query(value = "select new VView1Group(m.typename, COUNT(m) AS numero , sum(m.amount) as amount) FROM view1 AS m GROUP BY m.typename ORDER BY m.typename ASC")
    //List<VView1Group> getListByGroup();
	
	 public List<VView1Group> getListByGroup();
    
}
