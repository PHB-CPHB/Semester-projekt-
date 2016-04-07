/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import DataAccessLayer.Mappers.AdminMapper;
import DataAccessLayer.Mappers.BuildingMapper;
import DataAccessLayer.Mappers.CustomerMapper;
import DataAccessLayer.Mappers.LoginMapper;
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

    private DBFacade() {
    }

    //Dette er hvor vi kan kalde forbindelse og skrive hvad vi vil hente fra Databasen (Phillip)
    public static DBFacade getInstance() {
        if (instance == null) {
            instance = new DBFacade();
        }
        return instance;
    }

    /*Efter denne kommentar kan vi begynde at skrive kode som enten 
     kan hente fra databasen eller ligge nye ting ned i databasen.
     */
    public ArrayList<Building> getAllCutsomerBuildings(String username) {
        int user_id = CustomerMapper.getCustomerId(username);
        return BuildingMapper.getAllCustomersBuildings(user_id);
    }

    // This method is for 
    public void deleteBuilding(int building_id) {
        BuildingMapper.deleteBuilding(building_id);
    }

    // Made by Michael
    public void deleteAllBuildings(String building_firm) {
        BuildingMapper.deleteAllBuildings(building_firm);
    }

    public void addBuilding(String building_name, String building_type, String building_adress, int building_year, int building_zipcode, int building_areasize, String building_parcelno, String building_floor, String username) {
        int building_firm_id = CustomerMapper.getBuildingFirmId(username);
        BuildingMapper.addBuilding(building_name, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcelno, building_floor, building_firm_id);
    }

    public ArrayList<Customer> getAllUsers(String username) {
        String user_firm = CustomerMapper.getCustomer(username);
        return CustomerMapper.getAllUsers(user_firm);
    }

    public boolean validate(String username, String password) {
        return LoginMapper.validate(username, password);
    }

    public String getUserRole(String username) {
        return LoginMapper.getUserRole(username);
    }

    public boolean createCustomer(String username, String password, String user_firm, String user_role) {
        if (AdminMapper.createCustomer(username, password, user_role, user_firm) == true) {
        int user_id = CustomerMapper.getCustomerId(username);
        return AdminMapper.createFirm(user_id, user_firm);
        }
        return false;
    }

    public void deleteCustomer(int user_id) {
//        ArrayList<Building> array = BuildingMapper.getAllCustomersBuildings(user_id);
//        for(int i = 0; i < array.size(); i++){
//            BuildingMapper.getBuildingId(user_id);
//            BuildingMapper.deleteBuilding(user_id);
//        }
        AdminMapper.deleteCustomer(user_id);
        

    }
}
