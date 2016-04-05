/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.DBConnector;
import ServiceLayer.Entity.Building;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public class BuildingMapper {
    
    public static ArrayList<Building> getAllCustomersBuildings(int user_id) {
        try {
            ArrayList<Building> list = new ArrayList<>();
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("select * FROM buildings Where building_firm_id = ?");
            pstmt.setInt(1 , user_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Building(rs.getInt("building_id"),
                        rs.getString("building_adress"),
                        rs.getString("building_name"),
                        rs.getInt("building_zipcode"),
                        rs.getString("building_city"),
                        rs.getString("building_status"),
                        rs.getString("building_firm")));
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public static void deleteBuilding(int building_id) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("DELETE FROM buildings WHERE building_id = ?");
            pstmt.setInt(1 , building_id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void addBuilding(String building_name, String building_type, String building_adress, String building_year, String building_zipcode, String building_areasize, String building_parcelno, String building_floor) {
        try {
       PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO buildings (building_name, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcelno, building_floor) VALUES ('?', '?', '?', '?', '?', ?, '?', '?')");
       pstmt.setString(1, building_name);
       pstmt.setString(2, building_type);
       pstmt.setString(3, building_adress);
       pstmt.setString(4, building_year);
       pstmt.setString(5, building_zipcode);
       pstmt.setString(6, building_areasize);
       pstmt.setString(7, building_parcelno);
       pstmt.setString(8, building_floor);
       pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
