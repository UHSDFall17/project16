/**
 * @author ryan
 * Test Class for Class Card. Very basic functionality tests.
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
        String cardText = "card text";
        Card instance = new Card(cardText);
        String result = instance.getText();
        assertEquals(cardText, result);
    }

    /**
     * Test of changeText method, of class Card.
     */
    @Test
    public void testChangeText() {
        String originalText = "original";
        String newText = "new";
        Card instance = new Card(originalText);
        instance.changeText(newText);
        assertNotEquals(originalText, instance.getText());
    }
    
}
