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
    //Dette er hvor vi kan kalde forbindelse og skrive hvad vi vil hente fra Databasen (Phillip)
    public static DBFacade getInstance() {
        if(instance == null)
            instance = new DBFacade();
        return instance;
    }
    
    /*Efter denne kommentar kan vi begynde at skrive kode som enten 
      kan hente fra databasen eller ligge nye ting ned i databasen.
    */
}
