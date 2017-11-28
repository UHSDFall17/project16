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

/**
 *
 * @author ryan
 */
public class CorporationTest {
    
    public CorporationTest() {
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
     * Test of premiumStatus method, of class Corporation.
     */
    @Test
    public void testPremiumStatus() {
        Corporation instance = new Corporation();
        boolean expResult = true;
        boolean result = instance.premiumStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPremium method, of class Corporation.
     */
    @Test
    public void testSetPremium() {
        Corporation instance = new Corporation();
        instance.setPremium();
        assertEquals(true, instance.premiumStatus());
    }

    /**
     * Test of revokePremium method, of class Corporation.
     */
    @Test
    public void testRevokePremium() {
        Corporation instance = new Corporation();
        instance.revokePremium();
        assertEquals(false, instance.premiumStatus());
    }

    /**
     * Test of changePasswordTrue method, of class Corporation.
     */
    @Test
    public void testChangePasswordTrue() {
        String oldPassProvided = "oldpass";
        String newPassword = "newpass";
        Corporation instance = new Corporation("name", oldPassProvided);
        boolean expResult = true;
        boolean result = instance.changePassword(oldPassProvided, newPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of changePasswordFalse method, of class Corporation.
     */
    @Test
    public void testChangePasswordFalse() {
        String oldPassProvided = "notNull";
        String newPassword = "newpass";
        Corporation instance = new Corporation();
        boolean expResult = false;
        boolean result = instance.changePassword(oldPassProvided, newPassword);
        assertEquals(expResult, result);
    }    

    /**
     * Test of verifyPasswordTrue method, of class Corporation.
     */
    @Test
    public void testVerifyPasswordTrue() {
        String passProvided = "password";
        Corporation instance = new Corporation("name", passProvided);
        boolean expResult = true;
        boolean result = instance.verifyPassword(passProvided);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of verifyPasswordFalse method, of class Corporation.
     */
    @Test
    public void testVerifyPasswordFalse() {
        String passProvided = "anything";
        Corporation instance = new Corporation();
        boolean expResult = false;
        boolean result = instance.verifyPassword(passProvided);
        assertEquals(expResult, result);
    }
}
