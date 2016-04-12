/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Interfaces;

import ServiceLayer.Entity.Customer;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public interface CustomerMapperInterface {

    boolean createCustomer(Customer customer);

    ArrayList<Customer> getAllUsers(Customer customer);

    int getBuildingFirmId(Customer customer);

    String getCustomer(Customer customer);

    int getCustomerId(Customer customer);

    String getFirm(Customer customer);
    
}
