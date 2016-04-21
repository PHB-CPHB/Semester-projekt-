/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer.Entity;

import java.util.ArrayList;

/**
 *
 * @author philliphbrink
 */
public class Report {
    private int reportId;
    private int buildingCondition;
    private String outerRoof;
    private String outerWall;
    private String usageOfBuilding;
    private String thePolygonEmployee;
    private String theBuildingManager;
    private Building building;
    private ArrayList<Room> rooms = new ArrayList();

    public Report(int reportId, String outerRoof, String outerWall, String usageOfBuilding, String theBuildingManager, int buildingCondition) {
        this.reportId = reportId;
        this.outerRoof = outerRoof;
        this.outerWall = outerWall;
        this.usageOfBuilding = usageOfBuilding;
        this.theBuildingManager = theBuildingManager;
        this.buildingCondition = buildingCondition;
        
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getBuildingCondition() {
        return buildingCondition;
    }

    public void setBuildingCondition(int buildingCondition) {
        this.buildingCondition = buildingCondition;
    }

    public String getOuterRoof() {
        return outerRoof;
    }

    public void setOuterRoof(String outerRoof) {
        this.outerRoof = outerRoof;
    }

    public String getOuterWall() {
        return outerWall;
    }

    public void setOuterWall(String outerWall) {
        this.outerWall = outerWall;
    }

    public String getUsageOfBuilding() {
        return usageOfBuilding;
    }

    public void setUsageOfBuilding(String usageOfBuilding) {
        this.usageOfBuilding = usageOfBuilding;
    }

    public String getThePolygonEmployee() {
        return thePolygonEmployee;
    }

    public void setThePolygonEmployee(String thePolygonEmployee) {
        this.thePolygonEmployee = thePolygonEmployee;
    }

    public String getTheBuildingManager() {
        return theBuildingManager;
    }

    public void setTheBuildingManager(String theBuildingManager) {
        this.theBuildingManager = theBuildingManager;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
    
    public void addRoom(Room room) {
        rooms.add(room);
    }
    
    
}
