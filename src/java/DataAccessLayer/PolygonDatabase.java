/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Oliver
 */
public class PolygonDatabase {
      Connection con;

    public PolygonDatabase() throws ClassNotFoundException, SQLException {
        Class.forName(DBConnector.driver);
        con = DriverManager.getConnection(DBConnector.URL, DBConnector.ID, DBConnector.PW);
    }

    public boolean validate(String username, String password) {
        try {
            Statement stmt = con.createStatement();
            String query = "select * from login where username='" + username + "' and password='" + password + "'";
            ResultSet rs = stmt.executeQuery(query);
            return rs.next(); // If no next, it is because we did not find a match in the database
        } catch (SQLException ex) {
            return false;
        }
    }

    public String getUserRole(String username) {
        try {
            Statement stmt = con.createStatement();
            String query = "select user_role from login where username='" + username + "'";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            return rs.getString("user_role");
        } catch (SQLException ex) {
            return "guest";
        }
    }
    
}
