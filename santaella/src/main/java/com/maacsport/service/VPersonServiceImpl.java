package com.maacsport.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maacsport.dao.VPersonDao;

import com.maacsport.model.VPerson;


@Service
public class VPersonServiceImpl implements VPersonService {
	
	  @Autowired
      private VPersonDao elementDao;

	  
      public void save(VPerson element) {
		  element.setStatus(true);
		  element.setCreation(Calendar.getInstance());
    	  elementDao.save(element);
      }

      @Transactional( readOnly = true) 
      public List<VPerson> getList() {
             return elementDao.getList();
      }
      
      @Transactional( readOnly = true)
      public List<VPerson> getList(String name,String id,Calendar dateMe,Calendar dateMa) {
             return elementDao.getList(name,id,dateMe,dateMa);
      }
      
      @Transactional( readOnly = true)
      public List<VPerson> getList(String name,String id,Date dateMe,Date dateMa) {
             return elementDao.getList(name,id,dateMe,dateMa);
      }

      @Transactional( readOnly = true)
      public VPerson getElement(String id) {
             return elementDao.findById(id);
      }

      @Transactional
      public void delete(String id) {
    	  elementDao.delete(id);

      }

	@Override
	public VPerson getUser(String id) {
		 return elementDao.getUser(id);
	}

	

}
