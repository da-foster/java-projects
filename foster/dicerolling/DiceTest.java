/*
 * Author: Darren Foster
 * Filename: DiceTest.java
 */
package foster.dicerolling;
import org.junit.Test;
import static org.junit.Assert.*;

public class DiceTest {
    
    public DiceTest() {
    }
    
    /**
     * Test of roll method, of class Dice. Expected to pass.
     */
    @Test
    public void testRoll() {
        
        Dice dice = new Dice();
        int expectedVal = dice.roll();
        int actualVal = dice.getNumberShowing();
        
        assertEquals(expectedVal, actualVal);
    }
  
    /**
     * Test 2 of roll method, of class Dice. Expected result should yield true.
     */
    @Test
    public void testRoll2() {
        
        int defaultSides = 6;
        Dice dice = new Dice(); //default constructor (6 sides)
        dice.roll();
        boolean value = (dice.getNumberShowing() >= 1 && dice.getNumberShowing() <= defaultSides);
        
        assertTrue(value);
    }
    /**
     * Test 3 of roll method, of class Dice. Expected result should yield true.
     */
    @Test
    public void testRoll3() {
        int numSides = 12;
        Dice dice = new Dice(numSides); //creates 12 sided dice
        dice.roll();
        
        boolean value = (dice.getNumberShowing() >= 1 && dice.getNumberShowing() <= numSides);
        
        assertTrue(value);
    }
    
}
