/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.Interfaces.CustomerMapperInterface;
import DataAccessLayer.DBConnector;
import ServiceLayer.Entity.Customer;
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
public class CustomerMapper implements CustomerMapperInterface {


    @Override
    public String getCustomer(String username) {
        String user_firm = "";
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM login WHERE username = '?'");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            user_firm = rs.getString("user_firm");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user_firm;
    }

    @Override
    public int getCustomerId(String username) {
        int user_id = 0;
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM login WHERE username = ?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            user_id = rs.getInt("user_id");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user_id;
    }

    @Override
    public boolean createCustomer(String username, String password, String user_role, String user_firm) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO login (username, password, user_role, user_firm) VALUES ('?', '?', ?, '?', '?')");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, user_role);
            pstmt.setString(4, user_firm);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    // Made by Oliver corrected by Phillip
    @Override
    public ArrayList<Customer> getAllUsers(String user_firm) {

        try {
            ArrayList<Customer> list = new ArrayList<>();
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("select * from login");
            //pstmt.setInt(1, user_firm);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getString("username"),
                        rs.getInt("user_id"),
                        rs.getString("user_role"),
                        rs.getString("user_firm")));
            }
            return list;
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public String getFirm(String username) {
        String user_firm = "";
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM login WHERE username = ?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            user_firm = rs.getString("user_firm");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user_firm;
    }

    @Override
    public int getBuildingFirmId(Customer customer) {
      int building_firm_id = 0;
      try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT firm.firm_id FROM firm INNER JOIN login ON login.user_id = firm.firm_id WHERE login.user_id = ?");
            pstmt.setInt(1, customer.getUser_id());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            building_firm_id = rs.getInt("firm_id");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return building_firm_id;
    }
}
