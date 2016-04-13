/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import ServiceLayer.Interfaces.IController;
import DataAccessLayer.DBFacade;
import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Customer;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public class Controller implements IController {

    private static Controller con;
    private final DBFacade DBF = DBFacade.getInstance();

    private Controller() {

    }

    public static Controller getCon() {
        if (con == null) {
            return con = new Controller();
        } else {
            return con;
        }
    }

    @Override
    public void addNewBuilding(String building_name, String building_type, String building_adress, int building_year, int building_zipcode, int building_areasize, String building_parcelno, String building_floor, Customer c) {
        int building_firm_id = DBF.getBuildingFirmId(c);
        Building b = new Building(building_name, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcelno, building_floor, building_firm_id);
        DBF.addBuilding(b);

    }

    @Override
    public void deleteCustomer(String username, int user_id) {
        Customer customer = new Customer(username, user_id);
        DBF.deleteCustomer(customer);
    }

    @Override
    public void createCustomer(String uName, String uPwd, String uRole, String uFirm) {
        Customer customer = new Customer(uName, uPwd, uRole, uFirm);
        DBF.createCustomer(customer);
    }

    @Override
    public void deleteBuilding(int building_id) {
        Building building = new Building(building_id);
        DBF.deleteBuilding(building);
    }

    @Override
    public Object getUserRole(String username, String password) {
        Customer customer = new Customer(username, password);
        return DBF.getUserRole(customer);
    }

    @Override
    public int getUserId(String user, String password) {
        Customer customer = new Customer(user, password);
        return DBF.getUserId(customer);
    }

    @Override
    public boolean validate(String user, String password) {
        Customer customer = new Customer(user, password);
        return DBF.validate(customer);
    }

    @Override
    public Customer requestAccess(String username, String password) {
        Customer customer = new Customer(username, password);
        return DBF.requestAccessWithRole(customer);
    }

    public ArrayList<Customer> getAllUsers(Customer customer) {
        return DBF.getAllUsers(customer);
    }

    public ArrayList<Building> getAllBuildings() {
        return DBF.getAllBuildings();
    }

    public ArrayList<Building> getAllCutsomerBuildings(Customer customer) {
        return DBF.getAllCutsomerBuildings(customer);
    }

    public void requestCheckUp(int building_id) {
        Building building = new Building(building_id);
        DBF.requestCheckUp(building);
    }

    public InputStream setImage(InputStream inputstream) {
        System.out.println("controller");
        return inputstream;
    }
}
