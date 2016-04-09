/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.Interfaces.BuildingMapperInterface;
import DataAccessLayer.DBConnector;
import ServiceLayer.Entity.Building;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author philliphbrink
 */
public class BuildingMapper implements BuildingMapperInterface  {

    
    
    public ArrayList<Building> getAllCustomersBuildings(int user_id) {
        try {
            ArrayList<Building> list = new ArrayList<>();
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("select buildings.building_id, buildings.building_status, buildings.building_type, buildings.building_year, buildings.building_areasize, buildings.building_name, buildings.building_adress, buildings.building_floor, buildings.building_zipcode, firm.firm_name FROM buildings INNER JOIN firm ON buildings.building_firm_id = firm.firm_id Where building_firm_id = ?");
            pstmt.setInt(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Building(rs.getInt("building_id"),
                        rs.getString("building_status"),
                        rs.getString("building_type"),
                        rs.getInt("building_year"),
                        rs.getInt("building_areasize"),
                        rs.getString("building_name"),
                        rs.getString("building_adress"),
                        rs.getString("building_floor"),
                        rs.getInt("building_zipcode"),
                        rs.getString("firm_name")));
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    
    @Override
    public void deleteBuilding(int building_id) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("DELETE FROM buildings WHERE building_id = ?");
            pstmt.setInt(1, building_id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
// Made by Michael
    
    @Override
    public void deleteAllBuildings(String building_firm) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("delete from buildings where building_firm = ?");
            pstmt.setString(1, building_firm);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    
    
    public void addBuilding(Building b) {
        String building_status = "Ikke klar i nu";
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcel_no, building_floor, building_firm_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, b.getBuilding_name());
            pstmt.setString(2, building_status);
            pstmt.setString(3, b.getBuilding_type());
            pstmt.setString(4, b.getBuilding_adress());
            pstmt.setInt(5, b.getBuilding_year());
            pstmt.setInt(6, b.getBuilding_zipcode());
            pstmt.setInt(7, b.getBuilding_areasize());
            pstmt.setString(8, b.getBuilding_parcel_no());
            pstmt.setString(9, b.getBuilding_floor());
            pstmt.setInt(10, b.getBuilding_firm_id());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    
    @Override
    public String getCity(int building_zipcode) {
        String city = "";
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM Zip WHERE zipcode = ?");
            pstmt.setInt(1, building_zipcode);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            city = rs.getString("city");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return city;
    }

    
    @Override
    public String getFirm(String username) {
        String building_firm = "";
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM firm WHERE firm_is = ?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            building_firm = rs.getString("firm_name");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return building_firm;
    }

    
    @Override
    public int getBuildingId(int user_id) {
        int building_id = 0;
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT firm.firm_id FROM firm INNER JOIN login ON login.user_id = firm.firm_id WHERE login.username = ?");
            //pstmt.setString(1, );
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            building_id = rs.getInt("firm_id");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return building_id;
    }

}
