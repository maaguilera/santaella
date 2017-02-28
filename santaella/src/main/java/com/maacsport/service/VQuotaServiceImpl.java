package com.maacsport.service;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.codec.Base64;
import com.maacsport.dao.VPersonDao;
import com.maacsport.dao.VQuotaDao;
import com.maacsport.dao.VView1Dao;
import com.maacsport.model.VPerson;
import com.maacsport.model.VQuota;
import com.maacsport.model.VView1;
import com.maacsport.util.MyItext;
import com.maacsport.util.NumeroToLetra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class VQuotaServiceImpl implements VQuotaService {
	
	  @Autowired
      private VQuotaDao elementDao;
	  @Autowired
      private VPersonDao elementDao2;
	  @Autowired
      private VView1Dao elementDao3;
	  
      public void save(VQuota element) {
		  element.setId(element.getId());
    	  elementDao.save(element);
      }
      
      
      
      @Transactional
      public boolean  createQuotas(int ano,String path){
    	  
    	  
    	
    	  
    	  // insert quotas from view1.
    	  List<VView1> elements=elementDao3.findAll();
    	  NumeroToLetra n2l= new NumeroToLetra();
    	  
    	  for (VView1 element: elements) {
    	      	 
         	    VQuota temp = new VQuota();
         	    
         	    temp.setAmount(element.getAmount());
         	    temp.setAmountChar(n2l.convertirLetras(element.getAmount()).toUpperCase() + " EUROS");
         	    temp.setAno(ano);
         	    temp.setConcept("CUOTA "+ano + " - "+ element.getTypeName().toUpperCase());
         	    temp.setDescription("");
         	    temp.setDiscount(0.0);
         	    temp.setName(element.getSurname().toUpperCase()+", "+element.getName().toUpperCase());
         	    temp.setTypeName(element.getTypeName());
         	    String textoCod="jacko-" + element.getAmount() + "-" + element.getSurname()+"-"+element.getName();
         	    temp.setToken(Base64.encodeBytes(textoCod.getBytes()));
         	    temp.setvPerson(elementDao2.findById(element.getId()));
         	    
        	    elementDao.save(temp);
          }
    	  MyItext my =new MyItext();
    			  
    	  try {
    		  String nome=path+"/quotas_"+ano+"_"+new Date().getTime();
    		 
    		  my.create(nome,elementDao.getList(),path);
    		  my.createIndividual(nome,elementDao.getList(),path);
    		  
			} catch (IOException | DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	  
    	  return true;
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
