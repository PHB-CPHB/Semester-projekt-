/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Interfaces;

import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Image;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public interface BuildingMapperInterface {

    
    void deleteAllBuildings(Building building);

    void deleteBuilding(Building Building);
    // Made by Michael

    String getCity(Building Building);
    
    
}
