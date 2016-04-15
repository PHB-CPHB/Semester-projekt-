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
public interface LoginMapperInterface {

    //Made by Phillip - Returns customers id by Username and Password
    int getUserId(Customer c);

    //Tim
    String getUserRole(Customer c);

    //Made by Phillip - Returns the Customer/Admin how is logged in
    Customer requestAccessRole(Customer customer);

    //Tim
    boolean validate(Customer c);
    
}
