/**
 * 
 */
package com.maacsport.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;



import com.maacsport.model.VPerson;

/**
 * @author maaguilera
 *
 */
public interface VPersonDao extends GenericDAO<VPerson, String>{


    //public List<Person> getList();

    //public void save(Person item);
    
    //List<VPerson> findAll(boolean withBids);
    List<VPerson> getList(String name,String dni,Calendar dateMe,Calendar dateMa);
   List<VPerson> getList(String name,String dni,Date dateMe,Date dateMa);
    
    public VPerson getUser(String dni) ;
    public void persist2(VPerson p) ;
    
}
