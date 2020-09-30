/*
 * Author: Darren Foster
 * Filename: DiceStatistics.java
 */
package foster.dicerolling;
import java.util.ArrayList;
import java.util.Collections;

public class DiceStatistics {
    
    //DiceStatistics Data Members
    private int numberOfDice;
    private int numberOfSides;
    private int numberOfRolls;
    private ArrayList<Integer> totalArrayList = new ArrayList<Integer>(Collections.nCopies(500, 0));
    private ArrayList<Dice> diceArrayList = new ArrayList<>(numberOfDice);
    
    //Default Constructor that sets the numberOfDice to 2 
    public DiceStatistics() {
        this.numberOfDice = 2;
    }
    /**
     * Constructor that will take the number of dice as a parameter and set
     * numberOfDice equal to that number
     * @param inNumOfDice
     */
    public DiceStatistics(int inNumOfDice) {
        this.numberOfDice = inNumOfDice;
    }
    /**
     * addDice() will get the number of sides from an incoming dice, and add the dice 
     * object into the diceArrayList
     * @param incomingDice
     */
    public void addDice(Dice incomingDice) {
        numberOfSides = numberOfSides + incomingDice.getNumberOfSides();
        diceArrayList.add(incomingDice);
    } 
    /**
     * rollTheDice() loops through each of the dice stored in the diceArrayList, rolls each dice the specified
     * number of times received as the parameter, then adds those values together form a sum.
     * The position in the totalArrayList is then incremented each time this value appears.
     * @param numberOfRolls
     */
    public void rollTheDice(int numberOfRolls) {
        this.numberOfRolls = numberOfRolls;
        for (int idx1 = 0; idx1 < numberOfRolls; idx1++) {
            int totalValue = 0;
            for (int idx2 = 0; idx2 < diceArrayList.size(); idx2++) {
                Dice dice = diceArrayList.get(idx2);
                dice.roll();
                System.out.println("You rolled a: " + dice.getNumberShowing());
                totalValue = totalValue + dice.getNumberShowing();
            }
            System.out.println();
            System.out.println("The total is: " + totalValue);
            int idxPosition = totalValue - 1;
            int numRolls = totalArrayList.get(idxPosition);
            int increment = numRolls + 1;
            totalArrayList.set(idxPosition, increment);
            System.out.println();
        }
    }
    /*
     * toString() a String representation of a DiceStatistics object
    */
    @Override
    public String toString() {
        return "DiceStatistics{" + "numberOfDice=" + numberOfDice + ", numberOfSides=" + numberOfSides + ", numberOfRolls=" + numberOfRolls + ", totalArrayList=" + totalArrayList + ", diceArrayList=" + diceArrayList + '}';
    }
    
    //Accessor Methods
    /**
     * @return diceArrayList
     */
    public ArrayList<Dice> getDiceArrayList() {
        return diceArrayList;
    }
    /**
     * @return totalArrayList
     */
    public ArrayList<Integer> getTotalArrayList() {
        return totalArrayList;
    }
    /**
     * @return numberOfDice
     */
    public int getNumberOfDice() {
        return numberOfDice;
    }
    /**
     * @return numberOfSides
     */
    public int getNumberOfSides() {
        return numberOfSides;
    }
    /**
     * @return numberOfRolls
     */
    public int getNumberOfRolls() {
        return numberOfRolls;
    }
}
