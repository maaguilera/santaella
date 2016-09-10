package com.maacsport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maacsport.dao.CategoryDao;
import com.maacsport.dao.PersonDao;
import com.maacsport.dao.ReservationDao;
import com.maacsport.model.Category;
import com.maacsport.model.Person;
import com.maacsport.model.Reservation;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	  @Autowired
      private CategoryDao elementDao;

     


	@Override
	public Category getCategory(long id) {
		return elementDao.findById(id);
	}

}
