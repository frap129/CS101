/*
  Joe Maples
  Number Guessing Game
  CS101
  Oct 24th, 2017
*/

import java.util.*;

public class GuessingGame {

    /*
        		Algorithm for main(args)
        main(args)		
        	playAgain ← false	
        	Do 	
        	  playAgain ← startTheGame()	
        	While playAgain is true	

    */
    /*
                Data Table for main(args)		
        Variable or Constant	Type	    Purpose
        args	                String []	parameter, unused
        playAgain	            boolean	    Condition for playing multiple games

    */
    // Method that loops the game method to handle "play again"
    public static void main(String [] args){
        // Boolean to control playing multiple games
        boolean playAgain = false;
        do {
            // Assign return value of a game to playAgain
            playAgain = startTheGame();
        } while(playAgain);
    }
    
    /*
            	Algorithm for startTheGame()
        startTheGame()		
        	Instantiate in with System.in argument	
        	Ask for the highest number	
        	upperBound ← in.nextInt()	
        	If upperBound is less than ten	
        	  upperBound ← 10	
        	  Print that the upperBound must be greater than 10.	
        	Instantiate rand	
        	correctNumber ← rand.nextInt(upperBound) + 1	
        	guessAgain ← false	
        	numGuesses ← 0	
        	Do	
        	  guessAgain ← guessTheNumber(correctNumber, in)	
        	  Increment numGuesses	
        	While guessAgain is true	
        	Print how many guesses it took and ask if they want to play again	
        	playAgainStr ← in.next().toLowerCase()	
        	if playAgainStr contains “y”	
        	  return true	
        	else	
        	  return false	
    */
    /*
            Data Table for startTheGame()		
        Variable or Constant	Type	    Purpose
        in	                    Scanner	    Read user input
        upperBound	            int	        Highest number to guess
        numGuesses	            int	        Number of guesses the user used
        rand	                Random	    Generate random numbers
        correctNumber	        int	        The number the user needs to guess
        guessAgain	            boolean	    Condition for guessing multiple times

    */
    // Method that asks for the upper bound, calculates the correct
    // number and startes user guesses
    public static boolean startTheGame(){
    
        // Instantiate the input scanner
        Scanner in = new Scanner(System.in);
    
        // Ask for and read the upper bound
        System.out.println("What's the highest number? (Min 10)");
        int upperBound = in.nextInt();
        
        // Make sure upperBound is more than 10
        if (upperBound < 10) {
            upperBound = 10; 
            System.out.println("Number can't be lower than 10.");
        }
        
        // Generate the correct guess randomly
        Random rand = new Random();
        int correctNumber = rand.nextInt(upperBound) + 1;
        
        // Initialize the boolean to control guesses and the guess
        // counter
        boolean guessAgain = false;
        int numGuesses = 0;
        
        // Guess, increment counter, and guess again if requested
        do {
            guessAgain = guessTheNumber(correctNumber, in);
            numGuesses++;
        } while (guessAgain); 
        
        // Tell count and ask to play again if they give up or win
        System.out.println("Game over after " + numGuesses 
                        + " guesses! Play again? [y/N]");

        // Check if they want to play again, accept all values
        // containing "Y"
        String playAgainStr = in.next().toLowerCase();
        if (playAgainStr.contains("y"))
            return true;
        else
            return false;
    }
    
    /*
        		Algorithm for guessTheNumber(num, in)
        guessTheNumber(num, in)		
        	Ask the user for a guess	
        	if in.nextInt() equals  num	
        	  Print correct	
        	  return false	
        	else	
        	  Print incorrect, ask if they want to guess again	
        	guessAgainStr ← in.next().toLowerCase()	
        	if guessAgainStr contains “y”	
        	  return true	
        	else	
        	  return false	
    */
    /*
                Data Table for guessTheNumber(num, in)		
        Variable or Constant	Type	    Purpose
        num	                    int	        The number of guesses to validate
        in	                    Scanner	    Read user input
    */
    // Method that allows user to guess, checks the guess, and
    // asks them to try again.
    public static boolean guessTheNumber(int correctNum, Scanner in) {
        // Tell them to guess
        System.out.println("Guess a number: ");
        
        // Check if they guessed right, return if they did
        if (in.nextInt() == correctNum) {
            System.out.println("Correct!");
            return false;
        } else if (in.nextInt() > correctNum)
            System.out.println("Too high! Try again? [y/N] ");
        else
            System.out.println("Too low! Try again? [y/N] ");
        
        // Check if they want to guess again, accept all values
        // containing "Y"
        String guessAgainStr = in.next().toLowerCase();
        if (guessAgainStr.contains("y"))
            return true;
        else
            return false; 
    }
    
    //main
}//class GuessingGame   ggg