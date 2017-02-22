package com.maacsport.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maacsport.dao.PersonDao;
import com.maacsport.dao.ReservationDao;
import com.maacsport.model.Person;
import com.maacsport.model.Reservation;

@Service
public class PersonServiceImpl implements PersonService {
	
	  @Autowired
      private PersonDao elementDao;

	  
      public void save(Person book) {
		  book.setPersonId(book.getDni());
		  book.setCreation(Calendar.getInstance());
    	  elementDao.save(book);
      }

      @Transactional( readOnly = true)
      public List<Person> getList() {
             return elementDao.getList();
      }
      
      @Transactional( readOnly = true)
      public List<Person> getList(String name,String dni,Calendar dateMe,Calendar dateMa) {
             return elementDao.getList(name,dni,dateMe,dateMa);
      }
      
      @Transactional( readOnly = true)
      public List<Person> getList(String name,String dni,Date dateMe,Date dateMa) {
             return elementDao.getList(name,dni,dateMe,dateMa);
      }

      @Transactional( readOnly = true)
      public Person getElement(String id) {
             return elementDao.findById(id);
      }

      @Transactional
      public void delete(String id) {
    	  elementDao.delete(id);

      }

	@Override
	public Person getUser(String dni) {
		 return elementDao.getUser(dni);
	}

}
