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
     * Test file built using the same encryption type and password. 
     * Script for building files omitted from GitHub since they aren't part of the 
     * software.
    */
    @Test
    public void test1UserFactory() {
        User.UserFactory(true, "testName1", "password1!");
        String expResult = "testName1";
        String resultName = User.getUserName();
        assertEquals(expResult, resultName);
    } 

    /**
     * Test 2 of UserFactory method, of class User.
     * Test file built using the same encryption type and password. 
     * Script for building files omitted from GitHub since they aren't part of the 
     * software.
    */
    @Test
    public void test2UserFactory() {
        User.UserFactory(true, "testName1", "password1!");
        String expResult = "Board1";
        String resultBoardName = User.getRootBoard().getName();
        assertEquals(expResult, resultBoardName);
    } 
    
    /**
     * Test 3 of UserFactory method, of class User.
     * Test file built using the same encryption type and password. 
     * Script for building files omitted from GitHub since they aren't part of the 
     * software.
    */
    @Test
    public void test3UserFactory() {
        User.UserFactory(true, "testName1", "password1!");
        String expResult = "Board2";
        String resultBoardName = ((Board)User.getRootBoard().getNext()).getName();
        assertEquals(expResult, resultBoardName);
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
        Board expResult = null;
        Board result = User.getRootBoard();
        assertEquals(expResult, result);
    }

    /**
     * Test of addBoard method, of class User.
     */
    @Test
    public void testAddBoard() {
        Board newBoard = new Board("testBoard");
        // User with name "testName2" and password "password2!" exists in the 
        // login data file but its User save file is empty indicating they 
        // have not saved any data.
        User instance = User.UserFactory(true, "testName2", "password2!");
        instance.addBoard(newBoard);
        Board expResult = newBoard;
        Board result = (Board)User.getRootBoard().getNext();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeBoard method, of class User.
     */
    @Test
    public void testRemoveBoard() {
        // User with name "testName2" and password "password2!" exists in the 
        // login data file but its User save file is empty indicating they
        // havve not saved any data.
        User instance = User.UserFactory(true, "testName2", "password2!");
        Board expResult = User.getRootBoard();
        // remove rootBoard from User
        instance.removeBoard(User.getRootBoard());
        Board result = User.getRootBoard();
        assertNotEquals(expResult, result);
    }

}
