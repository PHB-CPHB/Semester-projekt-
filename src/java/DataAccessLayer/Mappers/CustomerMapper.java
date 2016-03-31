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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author philliphbrink
 */
public class CustomerMapper {
    
    public int getCustomer(String customer_name) {
        int customer_id = 0;
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM customer WHERE customer_name = ?");
            pstmt.setString(1, customer_name);
            ResultSet rs = pstmt.executeQuery();
                rs.next();
              customer_id = rs.getInt("customer_id");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return customer_id;
        }
    }

