/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.Interfaces.LoginMapperInterface;
import DataAccessLayer.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thesoap
 */
public class LoginMapper implements LoginMapperInterface {
    //Tim
    @Override
    public boolean validate(String username, String password) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("select * from login where username=? and password=?");
            pstmt.setString(1, username);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // If no next, it is because we did not find a match in the database
        } catch (SQLException ex) {
            return false;
        }
    }
    //Tim
    @Override
    public String getUserRole(String username) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("select user_role from login where username=?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getString("user_role");
        } catch (SQLException ex) {
            return "guest";
        }
    }

    public int getUserId(String user, String password) {
        int user_id = 0;
    try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("select * from login where username=? and password=?");
            pstmt.setString(1, user);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            user_id = rs.getInt("user_id");
        } catch (SQLException ex) {
            return 0;
        }
    return user_id;
    }
}
