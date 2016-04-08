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

    boolean createCustomer(String username, String password, String user_role, String user_firm);

    ArrayList<Customer> getAllUsers(String user_firm);

    int getBuildingFirmId(String username);

    String getCustomer(String username);

    int getCustomerId(String username);

    String getFirm(String username);
    
}
