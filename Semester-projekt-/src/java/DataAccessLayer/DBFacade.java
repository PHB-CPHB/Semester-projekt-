/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

/**
 *
 * @author philliphbrink
 */
public class DBFacade {
    private static DBFacade instance;
    private DBFacade() {
    }
    
    public static DBFacade getInstance() {
        if(instance == null)
            instance = new DBFacade();
        return instance;
    }
}
