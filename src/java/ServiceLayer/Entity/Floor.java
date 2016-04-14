/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer.Entity;

/**
 *
 * @author philliphbrink
 */
public class Floor {
    private int floor_building_id;
    private int floor_no;
    private int floor_size;
    private String floor_arpartments;
    private String floor_rooms;

    public Floor(int floor_building_id, int floor_no, int floor_size, String floor_arpartments, String floor_rooms) {
        this.floor_building_id = floor_building_id;
        this.floor_no = floor_no;
        this.floor_size = floor_size;
        this.floor_arpartments = floor_arpartments;
        this.floor_rooms = floor_rooms;
    }

    public Floor(int floor_no, int floor_size, String floor_arpartments, String floor_rooms) {
        this.floor_no = floor_no;
        this.floor_size = floor_size;
        this.floor_arpartments = floor_arpartments;
        this.floor_rooms = floor_rooms;
    }

    public Floor(int floor_size, String floor_arpartments, String floor_rooms) {
        this.floor_size = floor_size;
        this.floor_arpartments = floor_arpartments;
        this.floor_rooms = floor_rooms;
    }

    public Floor(int floor_building_id) {
        this.floor_building_id = floor_building_id;
    }

    public int getFloor_building_id() {
        return floor_building_id;
    }

    public void setFloor_building_id(int floor_building_id) {
        this.floor_building_id = floor_building_id;
    }

    public int getFloor_no() {
        return floor_no;
    }

    public void setFloor_no(int floor_no) {
        this.floor_no = floor_no;
    }

    public int getFloor_size() {
        return floor_size;
    }

    public void setFloor_size(int floor_size) {
        this.floor_size = floor_size;
    }

    public String getFloor_arpartments() {
        return floor_arpartments;
    }

    public void setFloor_arpartments(String floor_arpartments) {
        this.floor_arpartments = floor_arpartments;
    }

    public String getFloor_rooms() {
        return floor_rooms;
    }

    public void setFloor_rooms(String floor_rooms) {
        this.floor_rooms = floor_rooms;
    }
    
    
}
