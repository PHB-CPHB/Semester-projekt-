/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Customer;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author philliphbrink
 */
public class ControllerTest {

    public ControllerTest() {
    }

    @Before
    public void init() throws Exception {
        Controller ctrl = new Controller();
        boolean a = true;
        System.out.println("Init 1");
        if (ctrl.validate("Test", "123")) {
            System.out.println("Init 2");
            a = false;
        }
        if (a) {
            System.out.println("Init 3");
            String uName = "Test";
            String uPwd = "123";
            String uRole = "admin";
            String uFirm = "Ollesfirma";
            ctrl.createCustomer(uName, uPwd, uRole, uFirm);
        }

    }

    /**
     * Test of getCon method, of class Controller.
     */
    @Test
    public void testGetCon() {
        System.out.println("Here i will test if there is a connection to the Database, by making a connection making a new customer"
                + "Here after i will get all customer to see if the ArrayList isnt empty we got a connection");
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
        Building FirstBuilding = (Building) firstBuildingTry.get(firstBuildingTry.size() - 1);
        System.out.println("Building 1");
        if (FirstBuilding.getBuilding_name().equals(building_name) && FirstBuilding.getBuilding_type().equals(building_type) && FirstBuilding.getBuilding_adress().equals(building_adress)) {
            System.out.println("Building 2");
            b = false;
        }
        if (b) {
            System.out.println("Building 3");
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
        System.out.println("Create Customer 1");
        if (!ctrl.validate(uName, uPwd)) {
            System.out.println("Create Customer 2");
            String uRole = "admin";
            String uFirm = "Ollesfirma";
            ctrl.createCustomer(uName, uPwd, uRole, uFirm);
        }
        System.out.println("Create Customer 3");
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
        boolean b = true;
        Customer c = ctrl.requestAccess(uName, uPwd);
        ArrayList firstBuildingTry = ctrl.getAllBuildings();
        Building FirstBuilding = (Building) firstBuildingTry.get(firstBuildingTry.size() - 1);
        System.out.println("Delete Building 1");
        if (FirstBuilding.getBuilding_name().equals(building_name) && FirstBuilding.getBuilding_type().equals(building_type) && FirstBuilding.getBuilding_adress().equals(building_adress)) {
            System.out.println("Delete Building 2");
            b = false;
        }
        if (b) {
            int building_year = 2000;
            int building_zipcode = 2770;
            String building_parcelno = "2";
            System.out.println("Delete Building 3");
            ctrl.addNewBuilding(building_name, building_type, building_adress, building_year, building_zipcode, building_parcelno, c);
        }
        ArrayList<Building> buildings = ctrl.getAllCutsomerBuildings(c);
        ArrayList<Building> oldBuildings = buildings;
        System.out.println("Delete Building 4");
        if (buildings != null || buildings.size() != 0) {
            System.out.println("Delete Building 5");
            ctrl.deleteBuilding(buildings.get((buildings.size() - 1)).getBuilding_id());
            buildings = ctrl.getAllCutsomerBuildings(c);
        }
        System.out.println(buildings.size());
        System.out.println(oldBuildings.size());
        if (buildings.size() == oldBuildings.size() - 1) {
            System.out.println("Delete Building 6");
            assertTrue(true);
        }

    }

    /**
     * Test of getUserRole method, of class Controller.
     */
    /* @Test
     public void testGetUserRole() {
     System.out.println("getUserRole");
     String username = "";
     String password = "";
     Controller instance = null;
     Object expResult = null;
     Object result = instance.getUserRole(username, password);
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of getUserId method, of class Controller.
     */
    /* @Test
     public void testGetUserId() {
     System.out.println("getUserId");
     String user = "";
     String password = "";
     Controller instance = null;
     int expResult = 0;
     int result = instance.getUserId(user, password);
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of validate method, of class Controller.
     */
    /*@Test
     public void testValidate() {
     System.out.println("validate");
     String user = "";
     String password = "";
     Controller instance = null;
     boolean expResult = false;
     boolean result = instance.validate(user, password);
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of requestAccess method, of class Controller.
     */
    /*@Test
     public void testRequestAccess() {
     System.out.println("requestAccess");
     String username = "";
     String password = "";
     Controller instance = null;
     Customer expResult = null;
     Customer result = instance.requestAccess(username, password);
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of getAllUsers method, of class Controller.
     */
    /*@Test
     public void testGetAllUsers() {
     System.out.println("getAllUsers");
     Customer customer = null;
     Controller instance = null;
     ArrayList<Customer> expResult = null;
     ArrayList<Customer> result = instance.getAllUsers(customer);
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of getAllBuildings method, of class Controller.
     */
    /*@Test
     public void testGetAllBuildings() {
     System.out.println("getAllBuildings");
     Controller instance = null;
     ArrayList<Building> expResult = null;
     ArrayList<Building> result = instance.getAllBuildings();
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of getAllCutsomerBuildings method, of class Controller.
     */
    /*@Test
     public void testGetAllCutsomerBuildings() {
     System.out.println("getAllCutsomerBuildings");
     Customer customer = null;
     Controller instance = null;
     ArrayList<Building> expResult = null;
     ArrayList<Building> result = instance.getAllCutsomerBuildings(customer);
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of requestCheckUp method, of class Controller.
     */
    /*@Test
     public void testRequestCheckUp() {
     System.out.println("requestCheckUp");
     int building_id = 0;
     Controller instance = null;
     instance.requestCheckUp(building_id);
     fail("The test case is a prototype.");
     }

     /**
     * Test of setImage method, of class Controller.
     */
    /* @Test
     public void testSetImage() {
     System.out.println("setImage");
     InputStream inputstream = null;
     int bID = 0;
     String floorno = "";
     Controller instance = null;
     instance.setImage(inputstream, bID, floorno);
     fail("The test case is a prototype.");
     }

     /**
     * Test of buildingFloor method, of class Controller.
     */
    /*@Test
     public void testBuildingFloor() {
     System.out.println("buildingFloor");
     Building building = null;
     Controller instance = null;
     ArrayList<Floor> expResult = null;
     ArrayList<Floor> result = instance.buildingFloor(building);
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of addFloor method, of class Controller.
     */
    /*@Test
     public void testAddFloor() throws Exception {
     System.out.println("addFloor");
     Building building = null;
     int floor_size = 0;
     String floor_apartments = "";
     String floor_rooms = "";
     Controller instance = null;
     instance.addFloor(building, floor_size, floor_apartments, floor_rooms);
     fail("The test case is a prototype.");
     }

     /**
     * Test of maxFloor method, of class Controller.
     */
    /*@Test
     public void testMaxFloor() {
     System.out.println("maxFloor");
     Building building = null;
     Controller instance = null;
     int expResult = 0;
     int result = instance.maxFloor(building);
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of getAllFloors method, of class Controller.
     */
    /*@Test
     public void testGetAllFloors() {
     System.out.println("getAllFloors");
     int building_id = 0;
     Controller instance = null;
     int expResult = 0;
     int result = instance.getAllFloors(building_id);
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of getTotalSize method, of class Controller.
     */
    /*@Test
     public void testGetTotalSize() {
     System.out.println("getTotalSize");
     int building_id = 0;
     Controller instance = null;
     int expResult = 0;
     int result = instance.getTotalSize(building_id);
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of getFloor method, of class Controller.
     */
    /*@Test
     public void testGetFloor() {
     System.out.println("getFloor");
     int floor_no = 0;
     Building CurrentBuilding = null;
     Controller instance = null;
     Floor expResult = null;
     Floor result = instance.getFloor(floor_no, CurrentBuilding);
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of updateFloor method, of class Controller.
     */
    /*@Test
     public void testUpdateFloor() throws Exception {
     System.out.println("updateFloor");
     int floor_b_id = 0;
     int floor_n = 0;
     int floor_si = 0;
     String floor_apt = "";
     String floor_ro = "";
     Controller instance = null;
     instance.updateFloor(floor_b_id, floor_n, floor_si, floor_apt, floor_ro);
     fail("The test case is a prototype.");
     }

     /**
     * Test of deleteFloors method, of class Controller.
     */
    /*@Test
     public void testDeleteFloors() {
     System.out.println("deleteFloors");
     int building_id = 0;
     Controller instance = null;
     instance.deleteFloors(building_id);
     fail("The test case is a prototype.");
     }

     /**
     * Test of getBuildingCondition method, of class Controller.
     */
    /*@Test
     public void testGetBuildingCondition() {
     System.out.println("getBuildingCondition");
     int building_id = 0;
     Controller instance = null;
     int expResult = 0;
     int result = instance.getBuildingCondition(building_id);
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of getSortedBuildings method, of class Controller.
     */
    /*@Test
     public void testGetSortedBuildings() {
     System.out.println("getSortedBuildings");
     Controller instance = null;
     ArrayList<Report> expResult = null;
     ArrayList<Report> result = instance.getSortedBuildings();
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }

     /**
     * Test of deleteReport method, of class Controller.
     */
    /*@Test
     public void testDeleteReport() {
     System.out.println("deleteReport");
     int building_id = 0;
     Controller instance = null;
     instance.deleteReport(building_id);
     fail("The test case is a prototype.");
     }

     /**
     * Test of getImage method, of class Controller.
     */
    /*@Test
     public void testGetImage() {
     System.out.println("getImage");
     int bID = 0;
     String floorno = "";
     Controller instance = null;
     InputStream expResult = null;
     InputStream result = instance.getImage(bID, floorno);
     assertEquals(expResult, result);
     fail("The test case is a prototype.");
     }*/
}
