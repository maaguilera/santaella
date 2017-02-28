package com.maacsport.service;


import java.util.List;


import com.maacsport.model.VQuota;

public interface VQuotaService {
	
    /*
     * CREATE and UPDATE
     */
    public void save(VQuota element);
    
    public boolean  createQuotas(int ano,String path);

    /*
     * READ
     */
    public List<VQuota> getList(int ano, String typeName, String dni);
  


    /*
     * DELETE
     */
    public void delete(String id);
    
  

}
