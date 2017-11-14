/**
 * @author ryan
 * Test Class for Class Board. Very basic functionality tests.
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

public class BoardTest {
    
    public BoardTest() {
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
     * Test of getName method, of class Board.
     */
    @Test
    public void testGetName() {
        String boardName = "name";
        Board instance = new Board(boardName);
        String result = instance.getName();
        assertEquals(boardName, result);
    }

    /**
     * Test of setName method, of class Board.
     */
    @Test
    public void testSetName() {
        String originalName = "original";
        Board instance = new Board(originalName);
        String newName = "new";
        instance.setName(newName);
    }

    /**
     * Test of addList method, of class Board.
     */
    @Test
    public void testAddList() {
        List newList = new List();
        Board instance = new Board("name");
        instance.addList(newList);
    }

    /**
     * Test of removeList method, of class Board.
     */
    @Test
    public void testRemoveList() {
        List oldList = new List();
        Board instance = new Board("testBoard");
        instance.addList(oldList);
        instance.removeList(oldList);
    }
    
    /**
     * Test of getHead method, of class Board.
     */
    @Test
    public void testGetHead() {
        Board instance = new Board("name");
        List result = instance.getHead();
        assertNull(result);
    }

    /**
     * Test of getTail method, of class Board.
     */
    @Test
    public void testGetTail() {
        Board instance = new Board("name");
        List result = instance.getTail();
        assertNull(result);
    }
    
}
