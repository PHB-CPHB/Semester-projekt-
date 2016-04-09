/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccessLayer.DBFacade;
import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Customer;

/**
 *
 * @author philliphbrink
 */
public class Controller {
    private static Controller con;
    private final DBFacade DBF = DBFacade.getInstance();
    
    private Controller() {
    
    }
    
    public static Controller getCon() {
        if (con == null) {
            return con = new Controller();
        } else
        return con;
    }
    public void addNewBuilding(String building_name,  String building_type, String building_adress, int building_year, int building_zipcode, int building_areasize, String building_parcelno, String building_floor, String username, int user_id) {
        Customer c = new Customer(username, user_id);
        int building_firm_id = DBF.getBuildingFirmId(c);
        Building b = new Building(building_name, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcelno, building_floor, building_firm_id);
        DBF.addBuilding(b);
        
    }
}
