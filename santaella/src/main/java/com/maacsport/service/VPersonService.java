package com.maacsport.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.maacsport.model.VPerson;

public interface VPersonService {
	
    /*
     * CREATE and UPDATE 
     */
    public void save(VPerson element);

    /*
     * READ
     */
    public List<VPerson> getList();

    public List<VPerson> getList(String name, String id, Calendar dateMe, Calendar dateMa);
    public List<VPerson> getList(String name, String id, Date dateMe, Date dateMa);
    public VPerson getElement(String id);

    /*
     * DELETE
     */
    public void delete(String id);
    
    
    public VPerson getUser(String id);

}
