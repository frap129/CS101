/*
  Joe Maples
  Number Guessing Game
  CS101
  Oct 20th, 2017
*/

import java.util.*;

public class GuessingGame {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("What's the highest number? (Min 10)");
        int upperBound = in.nextInt();
        if (upperBound < 10) {
            upperBound = 10; 
            System.out.println("Number can't be lower than 10.");
        }
        System.out.println("How many guesses do you want? (Max 4)");
        int numGuesses = validateNumGuesses(in.nextInt());
        Random rand = new Random();
        int correctNumber = rand.nextInt(upperBound - 1) + 1;
        System.out.print("Guess a number:");
        if (in.nextInt() == correctNumber)
            System.out.print("\nCorrect!");
        else if (numGuesses > 1)
            System.out.print("\nTry again:");
        
        if (numGuesses >= 2 && in.nextInt() == correctNumber)
            System.out.print("\nCorrect!");
        else if (numGuesses > 2)
            System.out.print("\nTry again:");
        
        if (numGuesses >= 3 && in.nextInt() == correctNumber)
            System.out.print("\nCorrect!");
        else if (numGuesses > 3)
            System.out.print("\nTry again:");
            
        if (numGuesses = 4 && in.nextInt() == correctNumber)
            System.out.print("\nCorrect!");
        else
            System.out.print("\nGame Over!");
            
    }
    
    public static int validateNumGuesses(int num) {
        if (num > 4){
            num = 4;
            System.out.println("You only get 4 guesses.");
        } else if (num < 1) {
            num = 1;
            System.out.println("You can't guess less than once.");
        }
        
        return num;
    }
    //main
}//class GuessingGame