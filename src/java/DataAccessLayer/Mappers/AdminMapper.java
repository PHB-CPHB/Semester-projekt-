
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.Interfaces.AdminMapperInterface;
import DataAccessLayer.DBConnector;
import ServiceLayer.Entity.Customer;
import ServiceLayer.Entity.Firm;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oliver
 */
public class AdminMapper implements AdminMapperInterface {

    // Made by Oliver

    @Override
    public boolean createCustomer(Customer c) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO login (login.username, login.password, login.user_role, login.user_firm) VALUES(?, ?, ?, ?)");
            pstmt.setString(1, c.getUsername());
            pstmt.setString(2, c.getPassword());
            pstmt.setString(3, c.getUser_role());
            pstmt.setString(4, c.getUser_firm());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    //Made by Michael - Deletes a customer on user_id

    @Override
    public void deleteCustomer(Customer c) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("DELETE FROM login WHERE user_id = ?");
            pstmt.setInt(1, c.getUser_id());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Made by Phillip - creates a firm based on the customers id and firm.

    @Override
    public boolean createFirm(Customer c) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO firm (firm_name, firm_leader_id) VALUES(?, ?)");
            pstmt.setString(1, c.getUser_firm());
            pstmt.setInt(2, c.getUser_id());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    //Made by Phillip - Get building id form the customers user id

    @Override
    public int getBuildingId(Customer c) {
        int building_id = 0;
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(
                    "SELECT buildings.building_id FROM buildings "
                    + "INNER JOIN firm ON buildings.building_firm_id = firm.firm_id "
                    + "INNER JOIN login ON firm.firm_leader_id = login.user_id "
                    + "WHERE user_id = ?;"
            );
            pstmt.setInt(1, c.getUser_id());
            ResultSet rs = pstmt.executeQuery();
            rs.last();
            building_id = rs.getInt("building_id");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return building_id;
    }

    //Made by Phillip - Return firm of the customer

    @Override
    public String getFirm(Customer c) {
        String building_firm = "";
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM firm WHERE firm_name = ?");
            pstmt.setString(1, c.getUser_firm());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            building_firm = rs.getString("firm_name");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return building_firm;
    }

    @Override
    public ArrayList<Firm> getAllFirms() {
        try {
            ArrayList<Firm> firm = new ArrayList<>();
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM firm");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                firm.add(new Firm(rs.getString("firm_name"),
                        rs.getInt("firm_leader_id"),
                        rs.getInt("firm_id")));
            }
            return firm;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

}
