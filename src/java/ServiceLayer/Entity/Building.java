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
public class Building {

    private int roomId;
    private int roomSize;
    private int building_id;
    private String building_name;
    private String building_status;
    private String building_type;
    private String building_adress;
    private int building_year;
    private int building_zipcode;
    private String building_city;
    private int building_areasize;
    private String building_parcel_no;
    private String building_floor;
    private String building_firm;
    private int building_firm_id;

    public Building(int roomId, int roomSize, int building_id, String buildingName, String buildingStatus, String building_type, String building_adress, int building_year, int building_zipcode, String building_city, int building_areasize, String building_parcel_no, String building_floor, String building_firm, int building_firm_id) {
        this.roomId = roomId;
        this.roomSize = roomSize;
        this.building_id = building_id;
        this.building_name = buildingName;
        this.building_status = buildingStatus;
        this.building_type = building_type;
        this.building_adress = building_adress;
        this.building_year = building_year;
        this.building_zipcode = building_zipcode;
        this.building_city = building_city;
        this.building_areasize = building_areasize;
        this.building_parcel_no = building_parcel_no;
        this.building_floor = building_floor;
        this.building_firm = building_firm;
        this.building_firm_id = building_firm_id;
    }

    public Building(int building_id, String building_status, String building_type, int building_year, int building_areasize, String building_name, String building_adress, String building_floor, int building_zipcode, String building_firm) {
        this.building_id = building_id;
        this.building_status = building_status;
        this.building_type = building_type;
        this.building_year = building_year;
        this.building_areasize = building_areasize;
        this.building_name = building_name;
        this.building_adress = building_adress;
        this.building_type = building_type;
        this.building_floor = building_floor;
        this.building_zipcode = building_zipcode;
        this.building_firm = building_firm;
    }
    
    

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }

    public String getBuilding_status() {
        return building_status;
    }

    public void setBuilding_status(String building_status) {
        this.building_status = building_status;
    }

    public String getBuilding_type() {
        return building_type;
    }

    public void setBuilding_type(String building_type) {
        this.building_type = building_type;
    }

    public String getBuilding_adress() {
        return building_adress;
    }

    public void setBuilding_adress(String building_adress) {
        this.building_adress = building_adress;
    }

    public int getBuilding_year() {
        return building_year;
    }

    public void setBuilding_year(int building_year) {
        this.building_year = building_year;
    }

    public int getBuilding_zipcode() {
        return building_zipcode;
    }

    public void setBuilding_zipcode(int building_zipcode) {
        this.building_zipcode = building_zipcode;
    }

    public String getBuilding_city() {
        return building_city;
    }

    public void setBuilding_city(String building_city) {
        this.building_city = building_city;
    }

    public int getBuilding_areasize() {
        return building_areasize;
    }

    public void setBuilding_areasize(int building_areasize) {
        this.building_areasize = building_areasize;
    }

    public String getBuilding_parcel_no() {
        return building_parcel_no;
    }

    public void setBuilding_parcel_no(String building_parcel_no) {
        this.building_parcel_no = building_parcel_no;
    }

    public String getBuilding_floor() {
        return building_floor;
    }

    public void setBuilding_floor(String building_floor) {
        this.building_floor = building_floor;
    }

    public String getBuilding_firm() {
        return building_firm;
    }

    public void setBuilding_firm(String building_firm) {
        this.building_firm = building_firm;
    }

    public int getBuilding_firm_id() {
        return building_firm_id;
    }

    public void setBuilding_firm_id(int building_firm_id) {
        this.building_firm_id = building_firm_id;
    }

    
    
}
