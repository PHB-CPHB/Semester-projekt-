/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer.Interfaces;

import ServiceLayer.Entity.Customer;

/**
 *
 * @author philliphbrink
 */
public interface IController {

    void addNewBuilding(String building_name, String building_type, String building_adress, int building_year, int building_zipcode, String building_parcelno, Customer c);

    void createCustomer(String uName, String uPwd, String uRole, String uFirm);

    void deleteBuilding(int building_id);

    void deleteCustomer(String username, int user_id);

    int getUserId(String user, String password);

    Object getUserRole(String username, String password);

    Customer requestAccess(String username, String password);

    boolean validate(String user, String password);
    
}
