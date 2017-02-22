package com.maacsport.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.maacsport.model.Person;

public interface PersonService {
	
    /*
     * CREATE and UPDATE
     */
    public void save(Person element);

    /*
     * READ
     */
    public List<Person> getList();
    public List<Person> getList(String name, String dni, Calendar dateMe, Calendar dateMa);
    public List<Person> getList(String name, String dni, Date dateMe, Date dateMa);
    public Person getElement(String id);

    /*
     * DELETE
     */
    public void delete(String id);
    
    
    public Person getUser(String dni);

}
