/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer.Interfaces;

import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Customer;
import ServiceLayer.Entity.Floor;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public interface IController {

    void addFloor(Building building, int floor_size, String floor_apartments, String floor_rooms) throws SQLException;

    void addNewBuilding(String building_name, String building_type, String building_adress, int building_year, int building_zipcode, String building_parcelno, Customer c) throws SQLException;

    ArrayList<Floor> buildingFloor(Building building);

    void createCustomer(String uName, String uPwd, String uRole, String uFirm);

    void deleteBuilding(int building_id);

    void deleteCustomer(String username, int user_id);

    void deleteFloors(int building_id);

    ArrayList<Building> getAllBuildings();

    ArrayList<Building> getAllCutsomerBuildings(Customer customer);

    int getAllFloors(int building_id);

    ArrayList<Customer> getAllUsers(Customer customer);

    Floor getFloor(int floor_no, Building CurrentBuilding);

    int getTotalSize(int building_id);

    int getUserId(String user, String password);

    Object getUserRole(String username, String password);

    int maxFloor(Building building);

    Customer requestAccess(String username, String password);

    void requestCheckUp(int building_id);

    void setImage(InputStream inputstream,int bID,String floor_no);

    void updateFloor(int floor_b_id, int floor_n, int floor_si, String floor_apt, String floor_ro) throws SQLException;

    boolean validate(String user, String password);
    
    InputStream getImage(int bID,String floorno);

    void report(int reportId, String outerRoof, String outerWall, String usageOfBuilding, String theBuildingManager, int buildingCondition);
    
}
