/**
 * @author ryan
 * Test Class for Class Node. Very basic functionality tests.
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

public class NodeTest {
    
    public NodeTest() {
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
     * Test of setNext method, of class Node.
     */
    @Test
    public void testSetNext() {
        Node newNext = new Node();
        Node instance = new Node();
        instance.setNext(newNext);
    }

    /**
     * Test of setPrev method, of class Node.
     */
    @Test
    public void testSetPrev() {
        Node newPrev = null;
        Node instance = new Node();
        instance.setPrev(newPrev);
    }

    /**
     * Test of hasNext method, of class Node.
     */
    @Test
    public void testHasNext() {
        Node instance = new Node();
        boolean result = instance.hasNext();
        assertFalse(result);
    }

    /**
     * Test of getNext method, of class Node.
     */
    @Test
    public void testGetNext() {
        Node instance = new Node();
        Node result = instance.getNext();
        assertNull(result);
    }

    /**
     * Test of hasPrev method, of class Node.
     */
    @Test
    public void testHasPrev() {
        Node instance = new Node();
        boolean result = instance.hasPrev();
        assertFalse(result);
    }

    /**
     * Test of getPrev method, of class Node.
     */
    @Test
    public void testGetPrev() {
        Node instance = new Node();
        Node result = instance.getPrev();
        assertNull(result);
    }
    
}
