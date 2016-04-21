/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Interfaces;

import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Customer;
import ServiceLayer.Entity.Floor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public interface BuildingMapperInterface {

    //Made by Phillip - Add a building to the customer firm
    void addBuilding(Building b) throws SQLException;

    void deleteAllBuildings(Building b);

    //Made by Phillip deletes a building on building id
    void deleteBuilding(Building b);
    // Made by Michael - deletes buildings on customer firm name

    ArrayList<Building> getAllBuilding();

    //Made by Phillip - Return an Arraylist with only the customers building by thier user id
    ArrayList<Building> getAllCustomersBuildings(Customer c) throws SQLException;

    //Made by Phillip - Returns the city of the zipcode
    String getCity(Building b);

    ArrayList<Floor> getFloor(Building building) throws SQLException;

    void requestCheckUp(Building building);
    
}
