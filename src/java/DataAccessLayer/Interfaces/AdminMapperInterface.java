/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Interfaces;

import ServiceLayer.Entity.Customer;

/**
 *
 * @author philliphbrink
 */
public interface AdminMapperInterface {

    boolean createCustomer(Customer customer);

    boolean createFirm(Customer customer);

    void deleteCustomer(Customer customer);
    
    int getBuildingId(Customer customer);
    
    String getFirm(Customer customer);
    
}
