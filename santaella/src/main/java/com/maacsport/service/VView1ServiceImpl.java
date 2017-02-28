package com.maacsport.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maacsport.dao.VPersonDao;
import com.maacsport.dao.VView1Dao;
import com.maacsport.model.VPerson;
import com.maacsport.model.VView1;
import com.maacsport.model.VView1All;
import com.maacsport.model.VView1Group;


@Service
public class VView1ServiceImpl implements VView1Service {
	
	  @Autowired
      private VView1Dao elementDao;
	  @Autowired
      private VPersonDao elementDao2;
      
      @Transactional( readOnly = true)
      public VView1All getVView1All() {
    	     
    	  VView1All temp = new VView1All();
    	  
    	  // get all hermanos que han pasado a terner mas de 18
    	  List<VPerson> vPersons= elementDao2.getHermanosPasanMayores();
    	  
    	  // update tipo dos hermanos que pasaron a mayores de 18 años.
    	  int updates=elementDao2.updateTipoHermano();
    	  
    	  temp.setPerson18(vPersons);
    	  temp.setUpdate18(updates);
    	  temp.setPhonesList(elementDao.getList());
    	  temp.setvView1Group(elementDao.getListByGroup());
    	  
    	  return temp;
      }
      

}
