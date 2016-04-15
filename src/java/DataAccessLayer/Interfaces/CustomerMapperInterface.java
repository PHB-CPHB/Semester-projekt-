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

    //Made by Oliver - Corrected by Phillip
    boolean createCustomer(Customer c);

    // Made by Oliver corrected by Phillip
    //Returns an ArrayList of all the users
    ArrayList<Customer> getAllUsers(Customer c);

    //Made by Phillip - Gets customer firm id by thier user id
    int getBuildingFirmId(Customer customer);

    //Made by Phillip - gets customers firm by thier username
    String getCustomer(Customer c);

    //Made by Phillip - Gets customers id by thier Username and Password
    int getCustomerId(Customer c);

    //Made by Phillip - Return the customer firm by thier name
    String getFirm(Customer c);
    
}
