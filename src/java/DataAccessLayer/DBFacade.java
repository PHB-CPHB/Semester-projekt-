/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import DataAccessLayer.Mappers.BuildingMapper;
import DataAccessLayer.Mappers.CustomerMapper;
import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Customer;
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
    // This method is for 
    public void deleteBuilding (int building_id) {
        BMapper.deleteBuilding(building_id);
    }

    public void addBuilding(String building_name, String building_type, String building_adress, String building_year, String building_zipcode, String building_city, String building_areasize, String building_parcelno, String building_floor) {
        BMapper.addBuilding(building_name, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcelno, building_floor);
    }
    
   public ArrayList<Customer> getAllUsers(String username) {
       int customers_id = CMapper.getCustomer(username);
       return CMapper.getAllUsers(customers_id);
   }
}
