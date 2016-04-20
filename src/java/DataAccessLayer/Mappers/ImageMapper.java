/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.Interfaces.ImageMapperInterface;
import DataAccessLayer.DBConnector;
import ServiceLayer.Entity.Image;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oliver
 */
public class ImageMapper implements ImageMapperInterface {
    @Override
    public void setImage(InputStream inputstream) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("INSERT INTO images (image_name, Photo, image_id) values (?, ?, ?)");
            pstmt.setString(1, "1");
            pstmt.setBlob(2, inputstream);
            pstmt.setInt(3, 001);
            pstmt.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public InputStream getImage(InputStream inputstream) throws
            IllegalArgumentException, SQLException, ClassNotFoundException {

        Connection connection = DBConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        InputStream binaryStream = null;

        try {

            preparedStatement = connection.prepareStatement("SELECT photo FROM images WHERE image_id=?");
            preparedStatement.setString(1, "3");
            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {
                binaryStream = resultset.getBinaryStream("photo");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return binaryStream;
    }
}
