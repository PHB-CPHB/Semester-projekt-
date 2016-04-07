/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Interfaces;

import ServiceLayer.Entity.Building;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public interface BuildingMapperInterface {

    
    void deleteAllBuildings(String building_firm);

    void deleteBuilding(int building_id);
    // Made by Michael

    int getBuildingId(int user_id);

    String getCity(int building_zipcode);

    String getFirm(String username);
    
}
