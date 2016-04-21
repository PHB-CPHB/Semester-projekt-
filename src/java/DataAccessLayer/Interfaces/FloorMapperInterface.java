/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Interfaces;

import ServiceLayer.Entity.Floor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public interface FloorMapperInterface {

    void addFloor(Floor floor) throws SQLException;

    void deleteFloor(Floor floor);

    int getAllFloors(Floor floor);

    Floor getFloor(Floor floor);

    ArrayList<Floor> getTotalSize(Floor floor);

    void updateFloor(Floor editFloor) throws SQLException;
    
}
