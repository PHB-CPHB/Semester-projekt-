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
    public void setImage(InputStream inputstream,int bID,String floor_no) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("UPDATE building_floors SET Photo=? where floor_building_id=? and floor_no=?");
            pstmt.setBlob(1, inputstream);
            pstmt.setInt(2,bID );
            pstmt.setString(3, floor_no);
            pstmt.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public InputStream getImage(int bID,String floorno) {

        Connection connection = DBConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        InputStream binaryStream = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT photo FROM building_floors WHERE floor_building_id=? and floor_no=?");
            preparedStatement.setInt(1, bID);
            preparedStatement.setString(2, floorno);
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
