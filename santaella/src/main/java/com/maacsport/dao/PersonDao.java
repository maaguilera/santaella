/**
 * 
 */
package com.maacsport.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;



import com.maacsport.model.Person;

/**
 * @author maaguilera
 *
 */
public interface PersonDao extends GenericDAO<Person, String>{


    //public List<Person> getList();

    //public void save(Person item);
    
    List<Person> findAll(boolean withBids);
    List<Person> getList(String name,String dni,Calendar dateMe,Calendar dateMa);
   List<Person> getList(String name,String dni,Date dateMe,Date dateMa);
    
    public Person getUser(String dni) ;
    public void persist2(Person p) ;
    
}
