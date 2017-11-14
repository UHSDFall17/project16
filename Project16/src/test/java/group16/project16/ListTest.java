/**
 * @author ryan
 * Test Class for Class List. Very basic functionality tests.
 * More realistic test case(s) will be generated to test multiple classes when 
 * each class has been proven by a basic test. 
 */
package group16.project16;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListTest {
    
    public ListTest() {
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
     * Test of getName method, of class List.
     */
    @Test
    public void testGetName() {
        String listName = "name";
        List instance = new List(listName);
        String result = instance.getName();
        assertEquals(listName, result);
    }

    /**
     * Test of editName method, of class List.
     */
    @Test
    public void testEditName() {
        String originalName = "original";
        String newName = "";
        List instance = new List(originalName);
        instance.editName(newName);
        String result = instance.getName();
        assertNotEquals(originalName, result);
    }

    /**
     * Test of addCard method, of class List.
     */
    @Test
    public void testAddCard() {
        Card newCard = new Card();
        List instance = new List();
        instance.addCard(newCard);
    }

    /**
     * Test of removeCard method, of class List.
     */
    @Test
    public void testRemoveCard() {
        Card oldCard = new Card();
        List instance = new List();
        instance.addCard(oldCard);
        instance.removeCard(oldCard);
    }

    /**
     * Test of getHead method, of class List.
     */
    @Test
    public void testGetHead() {
        List instance = new List();
        Card result = instance.getHead();
        assertNotNull(result);
    }

    /**
     * Test of getTail method, of class List.
     */
    @Test
    public void testGetTail() {
        List instance = new List();
        Card result = instance.getTail();
        assertNotNull(result);
    }
    
}
