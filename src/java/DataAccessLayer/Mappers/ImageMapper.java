/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.DBConnector;
import ServiceLayer.Entity.Image;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oliver
 */
public class ImageMapper {
    public void setImage(InputStream inputstream) {
        try {
            System.out.println("mapper start");
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO images values (?)");
            pstmt.setBlob(1, inputstream);
            System.out.println("mapper før execute");
            pstmt.executeUpdate();
            System.out.println("mapper slut");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void getImage(InputStream inputstream) {
        
    }
}