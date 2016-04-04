/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.DBConnector;
import static DataAccessLayer.DBConnector.getConnection;
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

    public boolean createCustomer(String username, String password, String user_role) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO login (login.username, login.password, login.user_role) VALUES(?, ?, ?, ?)");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, user_role);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
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
