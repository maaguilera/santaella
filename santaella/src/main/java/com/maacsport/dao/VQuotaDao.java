/**
 * 
 */
package com.maacsport.dao;


import java.util.List;

import org.hibernate.Session;

import com.maacsport.model.VQuota;
import com.maacsport.model.VView1;

/**
 * @author maaguilera
 *
 */
public interface VQuotaDao extends GenericDAO<VQuota, String>{


    List<VQuota> getList(int ano,String typeName, String dni);

    public void persist2(VQuota p) ;
    

    public int insertQuotas1();

    public void insertQuotas3(List<VQuota> elements);
    public void insertQuotas2(List<VQuota> elements);
}
