/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import DataAccessLayer.Mappers.BuildingMapper;
import DataAccessLayer.Mappers.CustomerMapper;
import ServiceLayer.Entity.Building;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public class DBFacade {
    private static DBFacade instance;
    private BuildingMapper BMapper;
    private CustomerMapper CMapper;
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
    
    public ArrayList<Building> getAllCutsomerBuildings(String customers_name) {
        int customers_id = CMapper.getCustomer(customers_name);
        return BMapper.getAllCustomersBuildings(customers_id);
    }
    
    public void deleteBuilding (int building_id) {
        BMapper.deleteBuilding(building_id);
    }
}
