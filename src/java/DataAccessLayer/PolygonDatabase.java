/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Oliver
 */
public class PolygonDatabase {
      Connection con;

    public JDBCWebDatabase() throws ClassNotFoundException, SQLException {
        Class.forName(DB.driver);
        con = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);
    }

    public boolean validate(String username, String password) {
        try {
            Statement stmt = con.createStatement();
            String query = "select * from userInfo where name='" + username + "' and pwd='" + password + "'";
            ResultSet rs = stmt.executeQuery(query);
            return rs.next(); // If no next, it is because we did not find a match in the database
        } catch (SQLException ex) {
            return false;
        }
    }

    public String getUserRole(String username) {
        try {
            Statement stmt = con.createStatement();
            String query = "select userrole from userInfo where name='" + username + "'";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            return rs.getString("userrole");
        } catch (SQLException ex) {
            return "guest";
        }
    }

    public ArrayList<UserInfo> getAllUsers() {
        try {
            ArrayList<UserInfo> list = new ArrayList<>();
            Statement stmt = con.createStatement();
            String query = "select * from userInfo";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(new UserInfo(rs.getString("name"),
                        rs.getString("pwd"),
                        rs.getString("email"),
                        rs.getString("userrole")));
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean addUser(UserInfo newUser) {
        try {
            String update = "insert into userInfo (name, pwd, email, userrole) "
                    + "values (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(update);
            stmt.setString(1, newUser.getUserName() );
            stmt.setString(2, newUser.getPassword() );
            stmt.setString(3, newUser.getEmail() );
            stmt.setString(4, newUser.getUserRole() );
            System.out.println("Tries to add user");
            int res = stmt.executeUpdate();
            System.out.println("We changed: " + res);
            return res > 0;
        } catch (SQLException ex) {
            System.out.println("Add user failed: " + ex);
            do {
                System.out.println("Ex: " + ex + " - " + ex.getMessage() );
                ex = ex.getNextException();
            } while( ex != null);
            
            return false;
        }
    }

    public void removeUser(String userToRemove) {
        try {
            String sql = "DELETE FROM userInfo WHERE name='"+ userToRemove + "'";
            Statement stmt = con.createStatement(  );
            int res = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            
        }
        
    }

}

}
