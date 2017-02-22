/**
 * 
 */
package com.maacsport.dao;


import java.util.List;




import com.maacsport.model.VQuota;

/**
 * @author maaguilera
 *
 */
public interface VQuotaDao extends GenericDAO<VQuota, String>{


    List<VQuota> getList(int ano,String typeName, String dni);

    public void persist2(VQuota p) ;
    
}
