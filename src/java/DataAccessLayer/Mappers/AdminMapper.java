
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.Interfaces.AdminMapperInterface;
import DataAccessLayer.DBConnector;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oliver
 */
public class AdminMapper implements AdminMapperInterface {
    // Made by Oliver
    @Override
    public boolean createCustomer(String username, String password, String user_role, String user_firm) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO login (login.username, login.password, login.user_role, login.user_firm) VALUES(?, ?, ?, ?)");
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

    @Override
    public void deleteCustomer(int user_id) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("DELETE FROM login WHERE user_id = ?");
            pstmt.setInt(1, user_id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public boolean createFirm(int user_id, String user_firm) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO firm (firm.firm_name, firm.firm_leader_id) VALUES(?, ?)");
            pstmt.setString(1, user_firm);
            pstmt.setInt(2, user_id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

}
