/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Interfaces;

import ServiceLayer.Entity.Customer;
import ServiceLayer.Entity.Firm;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public interface AdminMapperInterface {

    // Made by Oliver
    boolean createCustomer(Customer c);

    //Made by Phillip - creates a firm based on the customers id and firm.
    boolean createFirm(Customer c);

    //Made by Michael - Deletes a customer on user_id
    void deleteCustomer(Customer c);

    ArrayList<Firm> getAllFirms();

    //Made by Phillip - Get building id form the customers user id
    int getBuildingId(Customer c);

    //Made by Phillip - Return firm of the customer
    String getFirm(Customer c);
    
}
