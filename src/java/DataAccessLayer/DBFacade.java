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
    public ArrayList<Building> getAllCutsomerBuildings(Customer customer) {
        return BMapper.getAllCustomersBuildings(customer);
    }

    // This method is for 
    @Override
    public void deleteBuilding(Building building) {
        BMapper.deleteBuilding(building);
    }

    // Made by Michael
    @Override
    public void deleteAllBuildings(Building building) {
        BMapper.deleteAllBuildings(building);
    }

    public void addBuilding(Building building) {
        BMapper.addBuilding(building);
     }

    @Override
    public ArrayList<Customer> getAllUsers(Customer customer) {
        return CMapper.getAllUsers(customer);
    }

    @Override
    public boolean validate(Customer customer) {
        return LMapper.validate(customer);
    }

    @Override
    public String getUserRole(Customer customer) {
        return LMapper.getUserRole(customer);
    }

    @Override
    public boolean createCustomer(Customer customer) {
        if (AMapper.createCustomer(customer) == true) {
            return AMapper.createFirm(customer);
        }
        return false;
    }

    @Override
    public void deleteCustomer(Customer customer) {
//        ArrayList<Building> array = BMapper.getAllCustomersBuildings(user_id);
//        for(int i = 0; i < array.size(); i++){
//            BMapper.getBuildingId(user_id);
//            BMapper.deleteBuilding(user_id);
//        }
        AMapper.deleteCustomer(customer);

    }

    @Override
    public boolean createFirm(Customer customer) {
        return AMapper.createFirm(customer);
    }

    @Override
    public int getBuildingId(Customer customer) {
        return AMapper.getBuildingId(customer);
    }

    @Override
    public String getCity(Building building) {
        return BMapper.getCity(building);
    }

    @Override
    public String getFirm(Customer customer) {
        return AMapper.getFirm(customer);
    }

    @Override
    public int getBuildingFirmId(Customer customer) {
        return CMapper.getBuildingFirmId(customer);
    }

    @Override
    public String getCustomer(Customer customer) {
        return CMapper.getCustomer(customer);
    }

    @Override
    public int getCustomerId(Customer customer) {
        return CMapper.getCustomerId(customer);
    }

    public int getUserId(Customer customer) {
        return LMapper.getUserId(customer);
    }

    public Customer requestAccessWithRole(Customer customer) {
        return LMapper.requestAccessRole(customer);
    }

}
