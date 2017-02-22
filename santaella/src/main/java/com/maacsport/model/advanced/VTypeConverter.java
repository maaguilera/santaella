package com.maacsport.model.advanced;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.maacsport.dao.VTypeDao;
import com.maacsport.model.VType;

@Component 
public class VTypeConverter implements Converter<String,VType>{
	
    @Autowired
    private VTypeDao vTypeDao;
    
    @Override
    public VType convert(String text){
        VType vType = null;
        
        try {
            Long id = Long.parseLong(text);
            vType = vTypeDao.findById(id);
            System.out.println("Department name:" + vType.getName());
        } catch (NumberFormatException ex) {
            System.out.println("Department will be null");
        }
        
        return vType;
    }
}