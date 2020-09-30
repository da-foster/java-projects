/*
 * Author: Darren Foster
 * Filename: Dice.java
 */
package foster.dicerolling;
import java.util.Random;

public class Dice {
    
    //Dice data members
    private static Random randomNumber = new Random();
    private int numberShowing;
    private int numberOfSides;
    
    //Default empty constructor w/ numberOfSides initialized to 6
    public Dice() {
        numberOfSides = 6;
    }
    //Constructor w/ numberOfSides as a parameter
    public Dice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }
    
    /*
     * roll() method contains the logic to generate a random number and "roll" the dice.
     * The value returned is stored in the numberShowing attribute
    */ 
    public int roll() {
        this.numberShowing = randomNumber.nextInt(numberOfSides) + 1;
        return numberShowing;
    }
    
    /*
     * toString() a String representation of a Dice object
    */
    @Override
    public String toString() {
        return "Dice{" + "numberShowing=" + numberShowing + ", numberOfSides=" + numberOfSides + '}';
    }
   
    //Accessor Methods
    //@return numberShowing
    public int getNumberShowing() {
            return numberShowing;
    }
    //@return randomNumber
    public Random getRandomNumber() {
            return randomNumber;
    }
    //@return numberOfSides
    public int getNumberOfSides() {
            return numberOfSides;
    }
}
