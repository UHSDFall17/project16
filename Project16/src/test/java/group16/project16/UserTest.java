/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group16.project16;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;

/**
 *
 * @author ryan
 */
public class UserTest {
    
    public UserTest() {
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
        User.LogOutFactory(false);
    }

    /**
     * Test of getUser method, of class User.
     */
    @Test
    public void testGetUser() {
        User expResult = null;
        User result = User.getUser();
        assertNotEquals(expResult, result);
    }
    
    /**
     * Test of getUserName method, of class User.
     */
    @Test
    public void testGetUserName() {
        User expResult = null;
        String result = User.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test 1 of UserFactory method, of class User.
    */
    @Test
    public void test1UserFactory() {
        User.UserFactory(true, "testName1", "password1!");
        String expResult = "testName1";
        String resultName = User.getUserName();
        assertEquals(expResult, resultName);
    } 

    /**
     * Test of LogOutFactory method, of class User.
    */ 
    @Test
    public void testLogOutFactory() {
        User.UserFactory(true, "testName1", "password1!");
        User.LogOutFactory(true);
        assertEquals(null, User.getRootBoard());
    }

    /**
     * Test of getRootBoard method, of class User.
     */
    @Test
    public void testGetRootBoard() {
        User instance = User.getUser();
        Board expResult = null;
        Board result = instance.getRootBoard();
        assertEquals(expResult, result);
    }

    /**
     * Test of addBoard method, of class User.
     */
    @Test(expected = NullPointerException.class)
    public void testAddBoard() {
        Board newBoard = null;
        User instance = null;
        instance.addBoard(newBoard);
    }

    /**
     * Test of removeBoard method, of class User.
     */
    @Test(expected = NullPointerException.class)
    public void testRemoveBoard() {
        Board oldBoard = null;
        User instance = null;
        instance.removeBoard(oldBoard);
    }

}
