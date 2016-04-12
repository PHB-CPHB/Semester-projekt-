/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Interfaces;

import ServiceLayer.Entity.Building;

/**
 *
 * @author philliphbrink
 */
public interface BuildingMapperInterface {

    void deleteAllBuildings(Building building);

    void deleteBuilding(Building Building);
    // Made by Michael

    void requestCheckUp(Building building);
    
    String getCity(Building Building);

}
