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

    private int buildingId;
    private int roomId;
    private int roomSize;
    private String adress;
    private String buildingName;
    private int zipCode;
    private String city;
    private String buildingStatus;

    public Building(int buildingId, int roomId, int roomSize, String adress, String buildingName, int zipCode, String city, String buildingStatus) {
        this.buildingId = buildingId;
        this.roomId = roomId;
        this.roomSize = roomSize;
        this.adress = adress;
        this.buildingName = buildingName;
        this.zipCode = zipCode;
        this.city = city;
        this.buildingStatus = buildingStatus;
    }
    
    public Building (int buildingId, String adress, String buildingName, int zipCode, String city, String buildingStatus) {
        this.buildingId = buildingId;
        this.adress = adress;
        this.buildingName = buildingName;
        this.zipCode = zipCode;
        this.city = city;
        this.buildingStatus = buildingStatus;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getBuildingStatus() {
        return buildingStatus;
    }

    public void setBuildingStatus(String buildingStatus) {
        this.buildingStatus = buildingStatus;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    
}
