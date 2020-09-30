/*
 * Author: Darren Foster
 * Filename: DiceStatisticsTest.java
 */
package foster.dicerolling;
import org.junit.Test;
import static org.junit.Assert.*;

public class DiceStatisticsTest {
    
    public DiceStatisticsTest() {
    }

    /**
     * Test of addDice method, of class DiceStatistics.
     */
    @Test
    public void testAddDice() {
        DiceStatistics diceStats = new DiceStatistics();
        Dice diceOne = new Dice(6);
        diceOne.roll();
        diceStats.addDice(diceOne);
        Dice expectedDice = diceStats.getDiceArrayList().get(0);
        
        assertEquals(expectedDice, diceOne);
    }
    
    /**
     * Test of rollTheDice method, of class DiceStatistics.
     */
    @Test
    public void testRollTheDice() {
        DiceStatistics diceStats = new DiceStatistics();
        Dice diceOne = new Dice(6);
        diceStats.addDice(diceOne);
        diceStats.rollTheDice(1);
        int num = diceOne.getNumberShowing();
        int expectVal = 1;
        int actualVal = diceStats.getTotalArrayList().get(num-1);
        
        assertEquals(expectVal, actualVal);
    }
    
}
