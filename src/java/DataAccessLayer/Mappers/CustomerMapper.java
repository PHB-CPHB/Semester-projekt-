/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

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
public class CustomerMapper {


    public static String getCustomer(String username) {
        System.out.println(username);
        String user_firm = "";
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM login WHERE username = '?'");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            user_firm = rs.getString("user_firm");
            System.out.println(user_firm);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user_firm;
    }


    public static boolean createCustomer(String username, String password, String user_role) {
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

    public static ArrayList<Customer> getAllUsers(String user_firm) {

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
}
