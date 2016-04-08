/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Interfaces;

/**
 *
 * @author philliphbrink
 */
public interface AdminMapperInterface {

    boolean createCustomer(String username, String password, String user_role, String user_firm);

    boolean createFirm(int user_id, String user_firm);

    void deleteCustomer(int user_id);
    
}
