/*
 * Test Class for Class Card. Very basic functionality tests.
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
public class CardTest {
    
    public CardTest() {
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
     * Test of getText method, of class Card.
     */
    @Test
    public void testGetText() {
        System.out.println("getText");
        Card instance = new Card();
        String expResult = "";
        String result = instance.getText();
        assertEquals(expResult, result);
    }

    /**
     * Test of changeText method, of class Card.
     */
    @Test
    public void testChangeText() {
        System.out.println("changeText");
        String newText = "";
        Card instance = new Card();
        instance.changeText(newText);
        String result = instance.getText();
        assertEquals(newText, result);
    }

    /**
     * Test of setNext method, of class Card.
     */
    @Test
    public void testSetNext() {
        System.out.println("setNext");
        Card nCard = new Card();
        Card instance = new Card();
        instance.setNext(nCard);
        Card result = (Card)instance.getNext();
        assertEquals(nCard, result);
    }

    /**
     * Test of setPrev method, of class Card.
     */
    @Test
    public void testSetPrev() {
        System.out.println("setPrev");
        Card pCard = new Card();
        Card instance = new Card();
        instance.setPrev(pCard);
        Card result = (Card)instance.getPrev();
        assertEquals(pCard, result);
    }

    /**
     * Test of hasNext method, of class Card.
     */
    @Test
    public void testHasNext() {
        System.out.println("hasNext");
        Card instance = new Card();
        boolean expResult = false;
        boolean result = instance.hasNext();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNext method, of class Card.
     */
    @Test
    public void testGetNext() {
        System.out.println("getNext");
        Card instance = new Card();
        Card expResult = null;
        Card result = (Card)instance.getNext();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasPrev method, of class Card.
     */
    @Test
    public void testHasPrev() {
        System.out.println("hasPrev");
        Card instance = new Card();
        boolean expResult = false;
        boolean result = instance.hasPrev();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrev method, of class Card.
     */
    @Test
    public void testGetPrev() {
        System.out.println("getPrev");
        Card instance = new Card();
        Card expResult = null;
        Card result = (Card)instance.getPrev();
        assertEquals(expResult, result);
    }
    
}
