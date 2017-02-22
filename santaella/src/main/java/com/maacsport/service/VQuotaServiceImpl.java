package com.maacsport.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maacsport.dao.VQuotaDao;

import com.maacsport.model.VQuota;


@Service
public class VQuotaServiceImpl implements VQuotaService {
	
	  @Autowired
      private VQuotaDao elementDao;

	  
      public void save(VQuota element) {
		  element.setId(element.getId());
    	  elementDao.save(element);
      }
      
      @Transactional( readOnly = true)
      public List<VQuota> getList(int ano, String typeName, String dni) {
             return elementDao.getList(ano,  typeName,  dni);
      }
      

      @Transactional
      public void delete(String id) {
    	  elementDao.delete(id);

      }

}
