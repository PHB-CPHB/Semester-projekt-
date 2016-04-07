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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author philliphbrink
 */
public class BuildingMapper {

    public static ArrayList<Building> getAllCustomersBuildings(int user_id) {
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

    public static void deleteBuilding(int building_id) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("DELETE FROM buildings WHERE building_id = ?");
            pstmt.setInt(1, building_id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void addBuilding(String building_name, String building_type, String building_adress, int building_year, int building_zipcode, int building_areasize, String building_parcelno, String building_floor, int building_firm_id) {
        String building_status = "Not Ready";
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcel_no, building_floor, building_firm_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, building_name);
            pstmt.setString(2, building_status);
            pstmt.setString(3, building_type);
            pstmt.setString(4, building_adress);
            pstmt.setInt(5, building_year);
            pstmt.setInt(6, building_zipcode);
            pstmt.setInt(7, building_areasize);
            pstmt.setString(8, building_parcelno);
            pstmt.setString(9, building_floor);
            pstmt.setInt(10, building_firm_id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static String getCity(int building_zipcode) {
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

    public static String getFirm(String username) {
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

}

//KIG HERE DU SKAL RETTE "CREATE USER" SÅDAN SÅ AT NÅR MAN LAVER ET FIRM KOMMER DET OGSÅ NED I FIRM I DATABASEN OG FÅR ID!
//Forbind bygning_id med rapport_id oprret rapport i databasen, lav knap inde ved delete til view rapport.
//Sørg for at hvis en bygning bliver slette bliver rapport overført til arkiv med nyt id...