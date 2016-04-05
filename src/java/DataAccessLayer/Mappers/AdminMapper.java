
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.DBConnector;
import static DataAccessLayer.DBConnector.getConnection;
import ServiceLayer.Entity.Customer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Oliver
 */
public class AdminMapper {

    public static boolean createCustomer(Customer newCustomer) {
        try {
            System.out.println("3");
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO login (username, password, user_role, user_firm) VALUES(?, ?, ?, ?)");
            pstmt.setString(1, newCustomer.getUsername());
            pstmt.setString(2, newCustomer.getPassword());
            pstmt.setString(3, newCustomer.getUser_role());
            pstmt.setString(4, newCustomer.getUser_firm());
            pstmt.executeUpdate();
            System.out.println("update");
        } catch (SQLException ex) {
            Logger.getLogger(AdminMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        System.out.println("4");
        return true;
    }

    public void deleteCustomer(String userToRemove) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("DELETE FROM login WHERE" + userToRemove + " = ?");
            pstmt.setString(1 , userToRemove);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
}
}