/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.DBConnector;
import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Floor;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author philliphbrink
 */
public class FloorMapper {

    public void addFloor(Building building, Floor floor) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO building_floors (floor_building_id, floor_size, floor_arpartments, floor_rooms) VALUES (?, ?, ?, ?);");
            pstmt.setInt(1, building.getBuilding_id());
            pstmt.setInt(2, floor.getFloor_size());
            pstmt.setString(3, floor.getFloor_arpartments());
            pstmt.setString(4, floor.getFloor_rooms());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }    
    }
    
}
