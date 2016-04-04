/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.DBConnector;
import ServiceLayer.Entity.Building;
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
public class CustomerMapper {

    public int getCustomer(String username) {

        int customer_id = 0;
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM customer WHERE username = ?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            customer_id = rs.getInt("customer_id");

            customer_id = rs.getInt("user_id");

        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer_id;
    }

    public boolean createCustomer(String username, String password, String user_role) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO login (username, password, user_role) VALUES ('?', '?', ?, '?')");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(4, user_role);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Customer> getAllUsers(int user_id) {
        try {
            ArrayList<Customer> list = new ArrayList<>();
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("select * from login where user_id = ?");
            pstmt.setInt(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getString("username"),
                        rs.getInt("user_id"),
                        rs.getString("user_role")));
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
