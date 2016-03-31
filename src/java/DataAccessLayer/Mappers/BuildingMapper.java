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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public class BuildingMapper {
    
    public ArrayList<Building> getAllCustomersBuildings(int customers_id) {
        try {
            ArrayList<Building> list = new ArrayList<>();
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("select * from buildings where customers_id = ?");
            pstmt.setInt(1 , customers_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Building(rs.getInt("building_id"),
                        rs.getString("building_adress"),
                        rs.getString("building_name"),
                        rs.getInt("building_zipcode"),
                        rs.getString("building_city"),
                        rs.getString("building_status")));
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }
}
