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
public interface LoginMapperInterface {

    String getUserRole(String username);

    boolean validate(String username, String password);
    
}
