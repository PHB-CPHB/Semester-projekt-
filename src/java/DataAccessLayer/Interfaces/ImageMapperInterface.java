/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Interfaces;

import java.io.InputStream;

/**
 *
 * @author philliphbrink
 */
public interface ImageMapperInterface {

    InputStream getImage(int bID, String floorno);

    void setImage(InputStream inputstream,int bID, String floorno);
    
}
