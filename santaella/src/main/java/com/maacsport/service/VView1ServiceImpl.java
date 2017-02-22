package com.maacsport.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maacsport.dao.VView1Dao;

import com.maacsport.model.VView1;
import com.maacsport.model.VView1All;
import com.maacsport.model.VView1Group;


@Service
public class VView1ServiceImpl implements VView1Service {
	
	  @Autowired
      private VView1Dao elementDao;

	  
      
      @Transactional( readOnly = true)
      public VView1All getVView1All() {
    	     
    	  VView1All temp = new VView1All();
    	  temp.setPhonesList(elementDao.getList());
    	  temp.setvView1Group(elementDao.getListByGroup());
    	  
    	  return temp;
      }
      

}
