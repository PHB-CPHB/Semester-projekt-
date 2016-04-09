/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import DataAccessLayer.Interfaces.AdminMapperInterface;
import DataAccessLayer.Interfaces.BuildingMapperInterface;
import DataAccessLayer.Interfaces.CustomerMapperInterface;
import DataAccessLayer.Interfaces.LoginMapperInterface;
import DataAccessLayer.Mappers.AdminMapper;
import DataAccessLayer.Mappers.BuildingMapper;
import DataAccessLayer.Mappers.CustomerMapper;
import DataAccessLayer.Mappers.LoginMapper;
import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Customer;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public class DBFacade implements AdminMapperInterface, BuildingMapperInterface, CustomerMapperInterface, LoginMapperInterface {

    private static DBFacade instance;
    private BuildingMapper BMapper = new BuildingMapper();
    private CustomerMapper CMapper = new CustomerMapper();
    private AdminMapper AMapper = new AdminMapper();
    private LoginMapper LMapper = new LoginMapper();

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
    public ArrayList<Building> getAllCutsomerBuildings(int user_id) {
        return BMapper.getAllCustomersBuildings(user_id);
    }

    // This method is for 
    @Override
    public void deleteBuilding(int building_id) {
        BMapper.deleteBuilding(building_id);
    }

    // Made by Michael
    @Override
    public void deleteAllBuildings(String building_firm) {
        BMapper.deleteAllBuildings(building_firm);
    }

    public void addBuilding(Building building) {
        BMapper.addBuilding(building);
     }

    @Override
    public ArrayList<Customer> getAllUsers(String username) {
        String user_firm = CMapper.getCustomer(username);
        return CMapper.getAllUsers(user_firm);
    }

    @Override
    public boolean validate(String username, String password) {
        return LMapper.validate(username, password);
    }

    @Override
    public String getUserRole(String username) {
        return LMapper.getUserRole(username);
    }

    @Override
    public boolean createCustomer(String username, String password, String user_role, String user_firm) {
        if (AMapper.createCustomer(username, password, user_role, user_firm) == true) {
            int user_id = CMapper.getCustomerId(username);
            return AMapper.createFirm(user_id, user_firm);
        }
        return false;
    }

    @Override
    public void deleteCustomer(int user_id) {
//        ArrayList<Building> array = BMapper.getAllCustomersBuildings(user_id);
//        for(int i = 0; i < array.size(); i++){
//            BMapper.getBuildingId(user_id);
//            BMapper.deleteBuilding(user_id);
//        }
        AMapper.deleteCustomer(user_id);

    }

    @Override
    public boolean createFirm(int user_id, String user_firm) {
        return AMapper.createFirm(user_id, user_firm);
    }

    @Override
    public int getBuildingId(int user_id) {
        return BMapper.getBuildingId(user_id);
    }

    @Override
    public String getCity(int building_zipcode) {
        return BMapper.getCity(building_zipcode);
    }

    @Override
    public String getFirm(String username) {
        return BMapper.getFirm(username);
    }

    @Override
    public int getBuildingFirmId(Customer customer) {
        return CMapper.getBuildingFirmId(customer);
    }

    @Override
    public String getCustomer(String username) {
        return CMapper.getCustomer(username);
    }

    @Override
    public int getCustomerId(String username) {
        return CMapper.getCustomerId(username);
    }

    public int getUserId(String user, String password) {
        return LMapper.getUserId(user, password);
    }

}
