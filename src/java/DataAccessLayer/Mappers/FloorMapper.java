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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public class FloorMapper {
    
    public void addFloor(Floor floor) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO building_floors (floor_building_id, floor_no, floor_size, floor_arpartments, floor_rooms) VALUES (?, ?, ?, ?, ?);");
            pstmt.setInt(1, floor.getFloor_building_id());
            pstmt.setInt(2, floor.getFloor_no());
            pstmt.setInt(3, floor.getFloor_size());
            pstmt.setString(4, floor.getFloor_arpartments());
            pstmt.setString(5, floor.getFloor_rooms());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }        
    }
    
    public int getAllFloors(Floor floor) {
        int floor_no = 0;
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT floor_no FROM building_floors WHERE floor_building_id = ?");
            pstmt.setInt(1, floor.getFloor_building_id());
            ResultSet rs = pstmt.executeQuery();
            rs.last();
            floor_no = rs.getInt("floor_no");
            return floor_no;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println("FAIL");
        return floor_no;
    }
    
    public ArrayList<Floor> getTotalSize(Floor floor) {
        try {
            ArrayList<Floor> list = new ArrayList<>();
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM building_floors WHERE floor_building_id = ?");
            pstmt.setInt(1, floor.getFloor_building_id());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Floor(rs.getInt("floor_no"),
                        rs.getInt("floor_size"),
                        rs.getString("floor_arpartments"),
                        rs.getString("floor_rooms")));
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }        
    }

    public Floor getFloor(Floor floor) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT floor_size, floor_arpartments, floor_rooms from building_floors WHERE floor_no = ? and floor_building_id = ?");
            pstmt.setInt(1, floor.getFloor_no());
            pstmt.setInt(2, floor.getFloor_building_id());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
             Floor newFloor = new Floor(rs.getInt("floor_size"),
                        rs.getString("floor_arpartments"),
                        rs.getString("floor_rooms"));
            
            return newFloor;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        } 
    }

    public void updateFloor(Floor editFloor) {
       try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("UPDATE building_floors set floor_size = ?, floor_arpartments = ?, floor_rooms = ? WHERE floor_no = ? and floor_building_id = ?;");
            pstmt.setInt(1, editFloor.getFloor_size());
            pstmt.setString(2, editFloor.getFloor_arpartments());
            pstmt.setString(3, editFloor.getFloor_rooms());
            pstmt.setInt(4, editFloor.getFloor_no());
            pstmt.setInt(5, editFloor.getFloor_building_id());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }

    public void deleteFloor(Floor floor) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("DELETE FROM building_floors WHERE floor_building_id = ?;");
            pstmt.setInt(1, floor.getFloor_building_id());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
