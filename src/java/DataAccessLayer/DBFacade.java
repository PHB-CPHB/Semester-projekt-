/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import DataAccessLayer.Interfaces.AdminMapperInterface;
import DataAccessLayer.Interfaces.BuildingMapperInterface;
import DataAccessLayer.Interfaces.CustomerMapperInterface;
import DataAccessLayer.Interfaces.FloorMapperInterface;
import DataAccessLayer.Interfaces.ImageMapperInterface;
import DataAccessLayer.Interfaces.LoginMapperInterface;
import DataAccessLayer.Mappers.AdminMapper;
import DataAccessLayer.Mappers.BuildingMapper;
import DataAccessLayer.Mappers.CustomerMapper;
import DataAccessLayer.Mappers.FloorMapper;
import DataAccessLayer.Mappers.ImageMapper;
import DataAccessLayer.Mappers.LoginMapper;
import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Customer;
import ServiceLayer.Entity.Firm;
import ServiceLayer.Entity.Floor;
import ServiceLayer.Entity.Image;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public class DBFacade implements AdminMapperInterface, BuildingMapperInterface, CustomerMapperInterface, LoginMapperInterface, FloorMapperInterface, ImageMapperInterface {

    private static DBFacade instance;
    private BuildingMapper BMapper = new BuildingMapper();
    private CustomerMapper CMapper = new CustomerMapper();
    private AdminMapper AMapper = new AdminMapper();
    private LoginMapper LMapper = new LoginMapper();
    private ImageMapper IMapper = new ImageMapper();
    private FloorMapper FloorMapper = new FloorMapper();

    private DBFacade() {

    }

    public static DBFacade getInstance() {
        if (instance == null) {
            instance = new DBFacade();
        }
        return instance;
    }

    //Made by Phillip
    public ArrayList<Building> getAllCutsomerBuildings(Customer customer) throws SQLException {
        return BMapper.getAllCustomersBuildings(customer);
    }

    public ArrayList<Building> getAllBuildings() {
        return BMapper.getAllBuilding();
    }

    // Made by Phillip 
    @Override
    public void deleteBuilding(Building building) {
        BMapper.deleteBuilding(building);
    }

    // Made by Michael
    @Override
    public void deleteAllBuildings(Building building) {
        BMapper.deleteAllBuildings(building);
    }

    //Made by Phillip
    @Override
    public void addBuilding(Building building) throws SQLException {
        BMapper.addBuilding(building);
    }

    //Made by Oliver
    @Override
    public ArrayList<Customer> getAllUsers(Customer customer) {
        return CMapper.getAllUsers(customer);
    }

    //Made by Tim
    @Override
    public boolean validate(Customer customer) {
        return LMapper.validate(customer);
    }

    //Made by Tim
    @Override
    public String getUserRole(Customer customer) {
        return LMapper.getUserRole(customer);
    }

    //Made by Oliver
    @Override
    public boolean createCustomer(Customer customer) {
        if (AMapper.createCustomer(customer) == true) {
            Customer c = new Customer(customer.getUsername(), getCustomerId(customer), customer.getUser_role(), customer.getUser_firm());
            return AMapper.createFirm(c);
        }
        return false;
    }

    //Made by Michael corrected by Phillip
    @Override
    public void deleteCustomer(Customer customer) {
//        ArrayList<Building> array = BMapper.getAllCustomersBuildings(user_id);
//        for(int i = 0; i < array.size(); i++){
//            BMapper.getBuildingId(user_id);
//            BMapper.deleteBuilding(user_id);
//        }
        AMapper.deleteCustomer(customer);

    }

    //Made by Phillip
    @Override
    public boolean createFirm(Customer customer) {
        return AMapper.createFirm(customer);
    }

    //Made by Phillip
    @Override
    public int getBuildingId(Customer customer) {
        return AMapper.getBuildingId(customer);
    }

    //Made by Phillip
    @Override
    public String getCity(Building building) {
        return BMapper.getCity(building);
    }

    //Made by Phillip
    @Override
    public String getFirm(Customer customer) {
        return AMapper.getFirm(customer);
    }

    //Made by Phillip
    @Override
    public int getBuildingFirmId(Customer customer) {
        return CMapper.getBuildingFirmId(customer);
    }

    //Made by Phillip
    @Override
    public String getCustomer(Customer customer) {
        return CMapper.getCustomer(customer);
    }

    //Made by Phillip
    @Override
    public int getCustomerId(Customer customer) {
        return CMapper.getCustomerId(customer);
    }

    //Made by Phillip
    @Override
    public int getUserId(Customer customer) {
        return LMapper.getUserId(customer);
    }

    //Made by Phillip
    public Customer requestAccessWithRole(Customer customer) {
        return LMapper.requestAccessRole(customer);
    }

    @Override
    public void setImage(InputStream inputstream) {
        System.out.println(inputstream);
        IMapper.setImage(inputstream);
    }

    @Override
    public void requestCheckUp(Building building) {
        BMapper.requestCheckUp(building);
    }

    public ArrayList<Floor> getFloors(Building building) {
        return BMapper.getFloor(building);
    }

    @Override
    public void addFloor(Floor floor) {
        FloorMapper.addFloor(floor);
    }

    @Override
    public int getAllFloors(Floor floor) {
        return FloorMapper.getAllFloors(floor);
    }

    @Override
    public ArrayList<Floor> getTotalSize(Floor floor) {
        return FloorMapper.getTotalSize(floor);
    }

    @Override
    public Floor getFloor(Floor floor) {
        return FloorMapper.getFloor(floor);
    }

    @Override
    public void updateFloor(Floor editFloor) {
        FloorMapper.updateFloor(editFloor);
    }

    @Override
    public void deleteFloor(Floor floor) {
        FloorMapper.deleteFloor(floor);
    }

    @Override
    public ArrayList<Firm> getAllFirms() {
        return AMapper.getAllFirms();
    }

    @Override
    public ArrayList<Building> getAllBuilding() {
        return BMapper.getAllBuilding();
    }

    @Override
    public ArrayList<Building> getAllCustomersBuildings(Customer c) throws SQLException {
        return BMapper.getAllCustomersBuildings(c);
    }

    @Override
    public ArrayList<Floor> getFloor(Building building) {
        return BMapper.getFloor(building);
    }

    @Override
    public Customer requestAccessRole(Customer customer) {
        return LMapper.requestAccessRole(customer);
    }

    @Override
    public void getImage(InputStream inputstream) {
        IMapper.getImage(inputstream);
    }
}
