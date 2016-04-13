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

    String getUserRole(Customer customer);

    boolean validate(Customer customer);

}
