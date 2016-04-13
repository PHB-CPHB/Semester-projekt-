/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer.Entity;

/**
 *
 * @author Oliver
 */
public class Image {
    private int image_id;
    private String image_name;

    public Image(int image_id, String image_name) {
        this.image_id = image_id;
        this.image_name = image_name;
    }
        public Image(String image_name) {
        this.image_name = image_name;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }
}
