/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import ServiceLayer.Entity.Building;
import ServiceLayer.Entity.Customer;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ejer
 */
public class DBFacadeTest {
    DBFacade DB = DBFacade.getInstance();
    public DBFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class DBFacade.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DBFacade expResult = null;
        DBFacade result = DBFacade.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCutsomerBuildings method, of class DBFacade.
     */
    @Test
    public void testGetAllCutsomerBuildings() {
        System.out.println("getAllCutsomerBuildings");
        int user_id = 0;
        DBFacade instance = null;
        ArrayList<Building> expResult = null;
        ArrayList<Building> result = instance.getAllCutsomerBuildings(user_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBuilding method, of class DBFacade.
     */
    @Test
    public void testDeleteBuilding() {
        System.out.println("deleteBuilding");
        int building_id = 0;
        DBFacade instance = null;
        instance.deleteBuilding(building_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAllBuildings method, of class DBFacade.
     */
    @Test
    public void testDeleteAllBuildings() {
        System.out.println("deleteAllBuildings");
        String building_firm = "";
        DBFacade instance = null;
        instance.deleteAllBuildings(building_firm);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBuilding method, of class DBFacade.
     */
    @Test
    public void testAddBuilding() {
        System.out.println("addBuilding");
        String building_name = "";
        String building_type = "";
        String building_adress = "";
        int building_year = 0;
        int building_zipcode = 0;
        int building_areasize = 0;
        String building_parcelno = "";
        String building_floor = "";
        String username = "";
        DBFacade instance = null;
        instance.addBuilding(building_name, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcelno, building_floor, username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUsers method, of class DBFacade.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        String username = "";
        DBFacade instance = null;
        ArrayList<Customer> expResult = null;
        ArrayList<Customer> result = instance.getAllUsers(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validate method, of class DBFacade.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        String username = "";
        String password = "";
        DBFacade instance = null;
        boolean expResult = false;
        boolean result = instance.validate(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserRole method, of class DBFacade.
     */
    @Test
    public void testGetUserRole() {
        System.out.println("getUserRole");
        String username = "";
        DBFacade instance = null;
        String expResult = "";
        String result = instance.getUserRole(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCustomer method, of class DBFacade.
     */
    @Test
    public void testCreateCustomer() {
        System.out.println("createCustomer");
        String username = "";
        String password = "";
        String user_role = "";
        String user_firm = "";
        DBFacade instance = null;
        boolean expResult = false;
        boolean result = instance.createCustomer(username, password, user_role, user_firm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCustomer method, of class DBFacade.
     */
    @Test
    public void testDeleteCustomer() {
        System.out.println("deleteCustomer");
        int user_id = 0;
        DBFacade instance = null;
        instance.deleteCustomer(user_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createFirm method, of class DBFacade.
     */
    @Test
    public void testCreateFirm() {
        System.out.println("createFirm");
        int user_id = 0;
        String user_firm = "";
        DBFacade instance = null;
        boolean expResult = false;
        boolean result = instance.createFirm(user_id, user_firm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBuildingId method, of class DBFacade.
     */
    @Test
    public void testGetBuildingId() {
        System.out.println("getBuildingId");
        int user_id = 0;
        int expResult = 2;
        int result = DB.getUserId("Tim", "1234");
        //int result = DB.getBuildingId(user_id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCity method, of class DBFacade.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        int building_zipcode = 0;
        DBFacade instance = null;
        String expResult = "";
        String result = instance.getCity(building_zipcode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirm method, of class DBFacade.
     */
    @Test
    public void testGetFirm() {
        System.out.println("getFirm");
        String username = "";
        DBFacade instance = null;
        String expResult = "";
        String result = instance.getFirm(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBuildingFirmId method, of class DBFacade.
     */
    @Test
    public void testGetBuildingFirmId() {
        System.out.println("getBuildingFirmId");
        String username = "";
        DBFacade instance = null;
        int expResult = 0;
        int result = instance.getBuildingFirmId(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class DBFacade.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        String username = "";
        DBFacade instance = null;
        String expResult = "";
        String result = instance.getCustomer(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerId method, of class DBFacade.
     */
    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        String username = "";
        DBFacade instance = null;
        int expResult = 0;
        int result = instance.getCustomerId(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class DBFacade.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        String user = "";
        String password = "";
        DBFacade instance = null;
        int expResult = 0;
        int result = instance.getUserId(user, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
