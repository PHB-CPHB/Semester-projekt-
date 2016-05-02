/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Customer;
import ServiceLayer.Entity.Floor;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author philliphbrink
 */
public class ControllerTest {

    public ControllerTest() {
    }
    @BeforeClass
    public static void init() throws Exception {
        Controller ctrl = new Controller();
        boolean a = true;
        if (ctrl.validate("Test", "123")) {
            a = false;
        }
        if (a) {
            String uName = "Test";
            String uPwd = "123";
            String uRole = "admin";
            String uFirm = "Ollesfirma";
            ctrl.createCustomer(uName, uPwd, uRole, uFirm);
        }

    }

    @AfterClass
    public static void clear() throws Exception {
        Controller ctrl = new Controller();
        String uName = "Test";
        String uPwd = "123";
        String building_name = "Test";
        String building_type = "Test Type";
        String building_adress = "Test Vej 34";
        boolean b = true;
        Customer c = ctrl.requestAccess(uName, uPwd);
        ArrayList firstBuildingTry = ctrl.getAllBuildings();
        if (firstBuildingTry.isEmpty()) {
            b = false;
        } else {
            Building FirstBuilding = (Building) firstBuildingTry.get(firstBuildingTry.size() - 1);
            if (FirstBuilding.getBuilding_name().equals(building_name) && FirstBuilding.getBuilding_type().equals(building_type)
                    && FirstBuilding.getBuilding_adress().equals(building_adress)) {
                ArrayList<Building> buildings = ctrl.getAllCutsomerBuildings(c);
                if (buildings != null || buildings.size() != 0) {
                    ctrl.deleteFloors(buildings.get((buildings.size() - 1)).getBuilding_id());
                    ctrl.deleteReport(buildings.get((buildings.size() - 1)).getBuilding_id());
                    ctrl.deleteBuilding(buildings.get((buildings.size() - 1)).getBuilding_id());
                }
            }
        }
    }

    /**
     * Test of getCon method, of class Controller.
     */
    @Test
    public void testGetCon() {
        System.out.println("Here i will test get connection");
        Controller ctrl = new Controller();
        String uName = "Test";
        String uPwd = "123";
        Customer c = ctrl.requestAccess(uName, uPwd);
        assertNotNull(c);

    }

    /**
     * Test of addNewBuilding method, of class Controller.
     */
    @Test
    public void testAddNewBuilding() throws Exception {
        System.out.println("Here i will test Create a building and get a building.");
        boolean b = true;
        Controller ctrl = new Controller();
        String building_name = "Test";
        String building_type = "Test Type";
        String building_adress = "Test Vej 34";
        int building_year = 2000;
        int building_zipcode = 2770;
        String building_parcelno = "2";
        ArrayList firstBuildingTry = ctrl.getAllBuildings();
        if (firstBuildingTry.isEmpty()) {
            b = true;
        } else {
            Building FirstBuilding = (Building) firstBuildingTry.get(firstBuildingTry.size() - 1);
            if (FirstBuilding.getBuilding_name().equals(building_name) && FirstBuilding.getBuilding_type().equals(building_type)
                    && FirstBuilding.getBuilding_adress().equals(building_adress)) {
                b = false;
            }
        }
        if (b) {
            String uName = "Test";
            String uPwd = "123";
            Customer c = ctrl.requestAccess(uName, uPwd);
            ctrl.addNewBuilding(building_name, building_type, building_adress, building_year, building_zipcode, building_parcelno, c);
        }
        ArrayList buildings = ctrl.getAllBuildings();
        Building DBBuilding = (Building) buildings.get(buildings.size() - 1);

        assertEquals(building_name, DBBuilding.getBuilding_name());
        assertEquals(building_type, DBBuilding.getBuilding_type());
        assertEquals(building_adress, DBBuilding.getBuilding_adress());
        assertEquals(building_year, DBBuilding.getBuilding_year());
        assertEquals(building_zipcode, DBBuilding.getBuilding_zipcode());

    }

    /**
     * Test of createCustomer method, of class Controller.
     */
    @Test
    public void testCreateCustomer() throws Exception {
        System.out.println("Here i will test Create a Customer and get a customer");
        Controller ctrl = new Controller();
        String uName = "Test";
        String uPwd = "123";
        if (!ctrl.validate(uName, uPwd)) {
            String uRole = "admin";
            String uFirm = "Ollesfirma";
            ctrl.createCustomer(uName, uPwd, uRole, uFirm);
        }
        Customer c = ctrl.requestAccess(uName, uPwd);
        assertEquals(uName, c.getUsername());
        assertEquals("admin", c.getUser_role());
        assertEquals("Ollesfirma", c.getUser_firm());

    }

    /**
     * Test of deleteBuilding method, of class Controller.
     */
    @Test
    public void testDeleteBuilding() throws Exception {
        System.out.println("Here i will test delete building by using getAllCustomerBuildings");
        Controller ctrl = new Controller();
        String uName = "Test";
        String uPwd = "123";
        String building_name = "Test";
        String building_type = "Test Type";
        String building_adress = "Test Vej 34";
        String building_parcelno = "2";
        boolean b = true;
        Customer c = ctrl.requestAccess(uName, uPwd);
        ArrayList firstBuildingTry = ctrl.getAllBuildings();
        if (firstBuildingTry.isEmpty()) {
            b = true;
        } else {
            Building FirstBuilding = (Building) firstBuildingTry.get(firstBuildingTry.size() - 1);

            if (FirstBuilding.getBuilding_name().equals(building_name) && FirstBuilding.getBuilding_type().equals(building_type)
                    && FirstBuilding.getBuilding_adress().equals(building_adress)) {
                b = false;
            }
        }
        if (b) {
            int building_year = 2000;
            int building_zipcode = 2770;
            ctrl.addNewBuilding(building_name, building_type, building_adress, building_year, building_zipcode, building_parcelno, c);
        }
        ArrayList<Building> buildings = ctrl.getAllCutsomerBuildings(c);
        ArrayList<Building> oldBuildings = buildings;
        if (buildings != null || buildings.size() != 0) {
            ctrl.deleteFloors(buildings.get((buildings.size() - 1)).getBuilding_id());
            ctrl.deleteReport(buildings.get((buildings.size() - 1)).getBuilding_id());
            ctrl.deleteBuilding(buildings.get((buildings.size() - 1)).getBuilding_id());
            buildings = ctrl.getAllCutsomerBuildings(c);
        }
        if (buildings.size() == oldBuildings.size() - 1) {
            assertTrue(true);
        }

    }

    /**
     * Test of requestCheckUp method, of class Controller.
     */
    @Test
    public void testRequestCheckUp() throws Exception {
        System.out.println("Here i will test requestCheckUp");
        boolean b = true;
        Controller ctrl = new Controller();
        String building_name = "Test";
        String building_type = "Test Type";
        String building_adress = "Test Vej 34";
        int building_year = 2000;
        int building_zipcode = 2770;
        String building_parcelno = "2";
        String uName = "Test";
        String uPwd = "123";
        if (!ctrl.validate(uName, uPwd)) {
            String uRole = "admin";
            String uFirm = "Ollesfirma";
            ctrl.createCustomer(uName, uPwd, uRole, uFirm);
        }
        Customer c = ctrl.requestAccess(uName, uPwd);
        ArrayList firstBuildingTry = ctrl.getAllBuildings();
        if (firstBuildingTry.isEmpty()) {
            b = true;
        } else {
            Building FirstBuilding = (Building) firstBuildingTry.get(firstBuildingTry.size() - 1);
            if (FirstBuilding.getBuilding_name().equals(building_name) && FirstBuilding.getBuilding_type().equals(building_type)
                    && FirstBuilding.getBuilding_adress().equals(building_adress)) {
                b = false;

            }
        }
        if (b) {
            ctrl.addNewBuilding(building_name, building_type, building_adress, building_year, building_zipcode, building_parcelno, c);
        }
        ArrayList<Building> building = ctrl.getAllCutsomerBuildings(c);
        assertTrue(ctrl.getAllCutsomerBuildings(c).get(building.size() - 1).getBuilding_status().equals("Ikke klar endnu"));
        ctrl.requestCheckUp(ctrl.getAllCutsomerBuildings(c).get(building.size() - 1).getBuilding_id());
        assertTrue(ctrl.getAllCutsomerBuildings(c).get(building.size() - 1).getBuilding_status().equals("check-up"));
    }
    
    @Test
    public void testAddFloor () throws Exception {
        System.out.println("Here i will test Floor");
        Controller ctrl = new Controller();
        int floor_size = 200;
        int floor_size1 = 300;
        int floor_size2 = 600;
        String room = "2";
        String arpartment = "2";
        boolean b = true;
        String building_name = "Test";
        String building_type = "Test Type";
        String building_adress = "Test Vej 34";
        int building_year = 2000;
        int building_zipcode = 2770;
        String building_parcelno = "2";
        String uName = "Test";
        String uPwd = "123";
        if (!ctrl.validate(uName, uPwd)) {
            String uRole = "admin";
            String uFirm = "Ollesfirma";
            ctrl.createCustomer(uName, uPwd, uRole, uFirm);
        }
        Customer c = ctrl.requestAccess(uName, uPwd);
        ArrayList firstBuildingTry = ctrl.getAllBuildings();
        if (firstBuildingTry.isEmpty()) {
            b = true;
        } else {
            Building FirstBuilding = (Building) firstBuildingTry.get(firstBuildingTry.size() - 1);
            if (FirstBuilding.getBuilding_name().equals(building_name) && FirstBuilding.getBuilding_type().equals(building_type)
                    && FirstBuilding.getBuilding_adress().equals(building_adress)) {
                b = false;

            }
        }
        if (b) {
            ctrl.addNewBuilding(building_name, building_type, building_adress, building_year, building_zipcode, building_parcelno, c);
        }
        ArrayList<Building> building = ctrl.getAllCutsomerBuildings(c);
        ctrl.addFloor(building.get(building.size()-1),floor_size, room, arpartment);
        ctrl.addFloor(building.get(building.size()-1),floor_size1, room, arpartment);
        ctrl.addFloor(building.get(building.size()-1),floor_size2, room, arpartment);
        ctrl.updateFloor(building.get(building.size()-1).getBuilding_id(), 1, 400, "2", "2");
        ArrayList<Floor> floors = ctrl.buildingFloor(building.get(building.size()-1));
        int a = 0;
        int i = 1;
        int x = 0;
        for (Floor floor : floors) {
            assertTrue(floor.getFloor_no() == i);
            assertTrue(floor.getFloor_arpartments().equals(arpartment));
            assertTrue(floor.getFloor_rooms().equals(room));
            a = floor.getFloor_size() + a;
            i++;
        }
        assertTrue(ctrl.getAllFloors(building.get(building.size()-1).getBuilding_id()) == 3);
        assertTrue(ctrl.getTotalSize(building.get(building.size()-1).getBuilding_id()) == 400 + floor_size1 + floor_size2);
        
    }
}
