
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

    public static boolean createCustomer(String username, String password, String user_role, String user_firm) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO login (username, password, user_role, user_firm) VALUES(?, ?, ?, ?)");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, user_role);
            pstmt.setString(4, user_firm);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static void deleteCustomer(int user_id) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("DELETE FROM login WHERE user_id = ?");
            pstmt.setInt(1, user_id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
