/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.Interfaces.LoginMapperInterface;
import DataAccessLayer.DBConnector;
import ServiceLayer.Entity.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thesoap
 */
public class LoginMapper implements LoginMapperInterface {

    //Made by Tim - Returns true if the user is in the database
    @Override
    public boolean validate(Customer c) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("select * from login where username=? and password=?");
            pstmt.setString(1, c.getUsername());
            pstmt.setString(2, c.getPassword());
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // If no next, it is because we did not find a match in the database
        } catch (SQLException ex) {
            return false;
        }
    }

    //Made by Tim - Returns the customers role
    @Override
    public String getUserRole(Customer c) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("select user_role from login where username=?");
            pstmt.setString(1, c.getUsername());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            String user_role = rs.getString("user_role");
            return user_role;
        } catch (SQLException ex) {
            return "guest";
        }
    }

    //Made by Phillip - Returns customers id by Username and Password
    @Override
    public int getUserId(Customer c) {
        int user_id = 0;
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("select * from login where username=? and password=?");
            pstmt.setString(1, c.getUsername());
            pstmt.setString(2, c.getPassword());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            user_id = rs.getInt("user_id");
        } catch (SQLException ex) {
            return 0;
        }
        return user_id;
    }

    //Made by Phillip - Returns the Customer/Admin how is logged in
    @Override
    public Customer requestAccessRole(Customer customer) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("select * from login where username=? and password =?");
            pstmt.setString(1, customer.getUsername());
            pstmt.setString(2, customer.getPassword());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            String username = rs.getString("username");
            int user_id = rs.getInt("user_id");
            String user_role = rs.getString("user_role");
            String user_firm = rs.getString("user_firm");
            Customer LoggedInCustomer = new Customer(username, user_id, user_role, user_firm);
            return LoggedInCustomer;
        } catch (SQLException ex) {
            return null;
        }
    }
}
