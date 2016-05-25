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

    //Made by Phillip - gets customers firm by thier username
    @Override
    public String getCustomer(Customer c) {
        String user_firm = "";
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM login WHERE username = '?'");
            pstmt.setString(1, c.getUsername());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            user_firm = rs.getString("user_firm");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user_firm;
    }

    //Made by Phillip - Gets customers id by thier Username and Password
    @Override
    public int getCustomerId(Customer c) {
        int user_id = 0;
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT user_id FROM login WHERE username = ? and password = ?");
            pstmt.setString(1, c.getUsername());
            pstmt.setString(2, c.getPassword());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            user_id = rs.getInt("user_id");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user_id;
    }

    //Made by Oliver - Corrected by Phillip
    @Override
    public boolean createCustomer(Customer c) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO login (username, password, user_role, user_firm) VALUES ('?', '?', ?, '?', '?')");
            pstmt.setString(1, c.getUsername());
            pstmt.setString(2, c.getPassword());
            pstmt.setString(3, c.getUser_role());
            pstmt.setString(4, c.getUser_firm());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    // Made by Oliver corrected by Phillip
    //Returns an ArrayList of all the users
    @Override
    public ArrayList<Customer> getAllUsers(Customer c) {

        try {
            ArrayList<Customer> list = new ArrayList<>();
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("select * from login");
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

    //Made by Phillip - Return the customer firm by thier name
    @Override
    public String getFirm(Customer c) {
        String user_firm = "";
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM login WHERE username = ?");
            pstmt.setString(1, c.getUsername());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            user_firm = rs.getString("user_firm");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user_firm;
    }

    //Made by Phillip - Gets customer firm id by thier user id
    @Override
    public int getBuildingFirmId(Customer customer) {
        int building_firm_id = 0;
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(
                    "SELECT firm.firm_id FROM firm "
                    + "INNER JOIN login ON login.user_id = firm.firm_id "
                    + "WHERE login.user_id = ?"
            );
            pstmt.setInt(1, customer.getUser_id());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            building_firm_id = rs.getInt("firm_id");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return building_firm_id;
    }
}
