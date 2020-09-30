/*
 * Author: Darren Foster
 * Filename: FosterMain.java
 */
package foster.dicerolling;

public class FosterMain {
    
    static int NUMBER_OF_ROLLS = 1000;

    /**
     * rollOneDice() simulates the roll of a singular dice 100,000 times, counts the number of times
     * each value is rolled, and stores them in the valueArray array
     */
    public static void rollOneDice() {
        
        int numOfSides = 6;
        int[] valueArray = new int[numOfSides];
        
        Dice dice = new Dice(numOfSides); //Instantiate a new Dice object
        
        int localNumOfRolls = 1; //Initialize a local variable to count the number of times a Dice is rolled
        
        while (localNumOfRolls <= NUMBER_OF_ROLLS) {
            
            dice.roll(); //Call to the roll() method within the Dice class
            System.out.println("You rolled a: " + dice.getNumberShowing());
            valueArray[dice.getNumberShowing() - 1]++; //Call to updateValueArray() to update the number of each roll
            localNumOfRolls++;
        }
        
        System.out.println("\nArray of Values:");
        for (int idx = 0; idx < numOfSides; idx++) {
            int idxPlusOne = idx + 1;
            System.out.println("The amount of " + idxPlusOne + "'s = " + valueArray[idx]);
        }
    }
    
    /**
     * rollTwoDice() simulates the roll of two dice 100,000 times, adds the two values 
     * together to form a sum, counts the number of times this sum has been rolled, and stores
     * them in a local valueTotals array
     */
    public static void rollTwoDice() {
        
        int numSides = 4;

        Dice diceOne = new Dice();
        Dice diceTwo = new Dice(numSides);
        
        int totalNumSides = diceOne.getNumberOfSides() + diceTwo.getNumberOfSides();
        int[] valueTotals = new int[totalNumSides]; //Set an array to hold the total set of sum values
        System.out.println("The length of the array is: " + valueTotals.length);
        
        int localNumOfRolls = 1; //Initialize a local variable to count the number of times the Dice are rolled
        
        while (localNumOfRolls <= NUMBER_OF_ROLLS) {
            
            diceOne.roll();
            System.out.println("\nDice 1 rolled: " + diceOne.getNumberShowing());
            diceTwo.roll();
            System.out.println("Dice 2 rolled: " + diceTwo.getNumberShowing());

            int sum = diceOne.getNumberShowing() + diceTwo.getNumberShowing(); //Get a sum of the two dice objects number showing
            System.out.println("\n*THE SUM = " + sum + "*");

            valueTotals[sum - 1]++; //Update the valueTotals array
            localNumOfRolls++;
        }
        System.out.println("\nArray Totals:");
        for (int idx = 0; idx < totalNumSides; idx++) {
            int idxPlusOne = idx + 1;
            System.out.println("Total number of " + idxPlusOne + "'s = " + valueTotals[idx]);
        }  
    }
    /**
     * rollManyDice() simulates the rolling and summing of many dice.
     * Once new Dice objects and a DiceStatistics object are instantiated, the method prints
     * out each of the values in the totalArrayList to present the number of times the summed 
     * value has been rolled, and the percentage of the occurrence.
     */
    public static void rollManyDice() {
        
        int NUMBER_OF_DICE = 3;
        int NUM_OF_ROLLS = 150;
        int numSides = 6;
        
        DiceStatistics diceStats = new DiceStatistics(NUMBER_OF_DICE);
        Dice dice = new Dice(numSides);
        
        for (int x = 1; x <= NUMBER_OF_DICE; x++) {
            diceStats.addDice(dice);
        }
        
        diceStats.rollTheDice(NUM_OF_ROLLS);

        for (int idx = 0; idx < diceStats.getTotalArrayList().size(); idx++) {
            
            int idxPlusOne = idx + 1;
            int value = diceStats.getTotalArrayList().get(idx);
            double percentage = ((double) value / NUM_OF_ROLLS) * 100;
            double roundedPercentage = Math.round(percentage * 100.0) / 100.0;
            System.out.println("The total number of " + idxPlusOne + "'s = " + diceStats.getTotalArrayList().get(idx) + " | " + roundedPercentage + "%");
            System.out.println();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        rollManyDice();//call to rollManyDice()
//        rollOneDice(); //call to rollOneDice()
//        rollTwoDice();  //call to rollTwoDice()
        
    }
    
}
