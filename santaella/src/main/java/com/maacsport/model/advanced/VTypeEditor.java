package com.maacsport.model.advanced;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maacsport.dao.VTypeDao;
import com.maacsport.model.VType;

@Component
public class VTypeEditor extends PropertyEditorSupport {

	//@Autowired
    private VTypeDao vTypeDao;
    
    public VTypeEditor(){
       
    }

    public VTypeEditor(VTypeDao vTypeDao){
        this.vTypeDao = vTypeDao;
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        VType vType = null;
        try {
            Long id = Long.parseLong(text);
            vType = this.vTypeDao.findById(id);
            System.out.println("Department name:" + vType.getName());
        } catch (NumberFormatException ex) {
            System.out.println("Department will be null");
        } catch (Exception e) {
        	  vType = new VType();
        	  vType.setId(new Long(1));
        	  vType.setName("name");
        	  
        	  
        }
        
        setValue(vType);
    }
    
    @Override
    public String getAsText () {
    	String text="";
    	VType vType = (VType)getValue();
    	if (vType!=null) {
    		text= vType.getName();
    	} 
    	
    	return text;
    }
}