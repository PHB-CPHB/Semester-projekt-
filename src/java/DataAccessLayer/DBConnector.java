/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jboss.logging.Logger;

/**
 *
 * @author philliphbrink
 */
public class DBConnector {
//Dette er hvor vi opretter selve forbindelse (Phillip)
    public static String driver = "com.mysql.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/polygon";
    public static String ID = "root";
    public static String PW = "12345";
    public static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            try {
                connection = DriverManager.getConnection(URL, ID, PW);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Logger.Level.FATAL, null, ex);
            }
        }
        return connection;
    }
}
