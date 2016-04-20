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
class Room {
    //Lejligheds id,
    private int apartmentId;
    //The size of the room
    private int roomSize;
    //Which room you are in EX: kichten, living room, WC.
    private String roomUsages;
    //This is page 2 "Skade og reparation
    //Any comments either comment or non comments
    private String comments;
    //This is the yes/no in report 
    private String anyDamages;
    // This is the "Hvornår" 
    private String dateOfDamage;
    //This is the "Hvor"
    private String placeOfDamage;
    //This is the "Hvad er der sket"
    private String damageHappend;
    //This is the "Hvad er repareret"
    private String damageReplaced;
    //This is "Skade" only fill with "Fugt, Råd og Svamp, Skimmel, Brand, Anden skade"
    private String theDamage;
    //This is the "Vægge"
    private String commentsInnerWall;
    private String innerwall;
    //This is the "Loft"
    private String commentsInnerRoof;
    private String innerRoof;
    //This is the "Gulv"
    private String commentsInnerFloor;
    private String innerFloor;
    //This is the "Vindue"
    private String commentsWindow;
    private String window;
    //This is the "Døre"
    private String commentsDoors;
    private String doors;
    //This is Fugtscanning shuold be filled with yes or no
    private String moistureScanning;
    //This is the date og "FugtScanning"
    private String moistureScanningDate;
    //This is the "Målepunkt"
    private String measurinPoint;
    //This is the "Anbefaling"
    private String recommendations;

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public String getRoomUsages() {
        return roomUsages;
    }

    public void setRoomUsages(String roomUsages) {
        this.roomUsages = roomUsages;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAnyDamages() {
        return anyDamages;
    }

    public void setAnyDamages(String anyDamages) {
        this.anyDamages = anyDamages;
    }

    public String getDateOfDamage() {
        return dateOfDamage;
    }

    public void setDateOfDamage(String dateOfDamage) {
        this.dateOfDamage = dateOfDamage;
    }

    public String getPlaceOfDamage() {
        return placeOfDamage;
    }

    public void setPlaceOfDamage(String placeOfDamage) {
        this.placeOfDamage = placeOfDamage;
    }

    public String getDamageHappend() {
        return damageHappend;
    }

    public void setDamageHappend(String damageHappend) {
        this.damageHappend = damageHappend;
    }

    public String getDamageReplaced() {
        return damageReplaced;
    }

    public void setDamageReplaced(String damageReplaced) {
        this.damageReplaced = damageReplaced;
    }

    public String getTheDamage() {
        return theDamage;
    }

    public void setTheDamage(String theDamage) {
        this.theDamage = theDamage;
    }

    public String getCommentsInnerWall() {
        return commentsInnerWall;
    }

    public void setCommentsInnerWall(String commentsInnerWall) {
        this.commentsInnerWall = commentsInnerWall;
    }

    public String getInnerwall() {
        return innerwall;
    }

    public void setInnerwall(String innerwall) {
        this.innerwall = innerwall;
    }

    public String getCommentsInnerRoof() {
        return commentsInnerRoof;
    }

    public void setCommentsInnerRoof(String commentsInnerRoof) {
        this.commentsInnerRoof = commentsInnerRoof;
    }

    public String getInnerRoof() {
        return innerRoof;
    }

    public void setInnerRoof(String innerRoof) {
        this.innerRoof = innerRoof;
    }

    public String getCommentsInnerFloor() {
        return commentsInnerFloor;
    }

    public void setCommentsInnerFloor(String commentsInnerFloor) {
        this.commentsInnerFloor = commentsInnerFloor;
    }

    public String getInnerFloor() {
        return innerFloor;
    }

    public void setInnerFloor(String innerFloor) {
        this.innerFloor = innerFloor;
    }

    public String getCommentsWindow() {
        return commentsWindow;
    }

    public void setCommentsWindow(String commentsWindow) {
        this.commentsWindow = commentsWindow;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public String getCommentsDoors() {
        return commentsDoors;
    }

    public void setCommentsDoors(String commentsDoors) {
        this.commentsDoors = commentsDoors;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getMoistureScanning() {
        return moistureScanning;
    }

    public void setMoistureScanning(String moistureScanning) {
        this.moistureScanning = moistureScanning;
    }

    public String getMoistureScanningDate() {
        return moistureScanningDate;
    }

    public void setMoistureScanningDate(String moistureScanningDate) {
        this.moistureScanningDate = moistureScanningDate;
    }

    public String getMeasurinPoint() {
        return measurinPoint;
    }

    public void setMeasurinPoint(String measurinPoint) {
        this.measurinPoint = measurinPoint;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }


   
}
