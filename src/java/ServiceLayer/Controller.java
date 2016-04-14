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
import ServiceLayer.Entity.Floor;
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
    public void addNewBuilding(String building_name, String building_type, String building_adress, int building_year, int building_zipcode, String building_parcelno, Customer c) {
        int building_firm_id = DBF.getBuildingFirmId(c);
        String building_floor = "0";
        int building_size = 0;
        Building b = new Building(building_name, building_type, building_adress, building_year, building_zipcode, building_size, building_parcelno, building_floor, building_firm_id);
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

    public void setImage(InputStream inputstream) {
        System.out.println(inputstream);
        DBF.setImage(inputstream);
    }

    public ArrayList<Floor> buildingFloor(Building building) {
        return DBF.getFloors(building);
    }

    public void addFloor(Building building, int floor_size, String floor_apartments, String floor_rooms) {
        int floor_no = maxFloor(building);
        Floor floor = new Floor(floor_no, floor_size, floor_apartments, floor_rooms);
        floor.setFloor_building_id(building.getBuilding_id());
        DBF.addFloor(floor);
    }
    public int maxFloor(Building building){
        Floor floor = new Floor(building.getBuilding_id());
        int currentFloor = DBF.getAllFloors(floor);
        int newFloor = currentFloor + 1;
        return newFloor;
      }
    
    public int getAllFloors(int building_id){
        Floor floor = new Floor(building_id);
        return DBF.getAllFloors(floor);
    }
    
    public int getTotalSize(int building_id){
        int totalBuildingSize = 0;
        Floor buildingfloor = new Floor(building_id);
        ArrayList<Floor> floors = DBF.getTotalSize(buildingfloor);
        for (Floor floor : floors) {
            totalBuildingSize = totalBuildingSize + floor.getFloor_size();
        }
        return totalBuildingSize;
    }

    public Floor getFloor(int floor_no, Building CurrentBuilding) {
        Floor floor = new Floor(CurrentBuilding.getBuilding_id(), floor_no);
        return DBF.getFloor(floor);
    }

    public void updateFloor(int floor_b_id, int floor_n, int floor_si, String floor_apt, String floor_ro) {
        Floor editFloor = new Floor(floor_b_id, floor_n, floor_si, floor_apt, floor_ro);
        DBF.updateFloor(editFloor);
    }
}
