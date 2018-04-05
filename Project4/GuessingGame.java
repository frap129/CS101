import java.util.*;

/*
    Data Table for Class GuessingGame		
Variable or Constant	Type    	Purpose
EASY_GAME	            boolean	    Default to easy game
DIFFICULT_GAME	        boolean	    Difficult game
DEFAULT_MAXIMUM_RANGE	int	        Default to 10 as largest number
GAME_WON	            int	        The game state value that is winning
GAME_LOST	            int	        The game state value that is losing
GAME_IN_PROGRESS    	int	        Value of the in progress game state
gameState	            int	        The current state of the game
numberToGuess	        int	        The number to guess
numberOfGuesses	        int	        The number of times the user has guessed
largestPossibleNumber	int	        The largest number to guess
maximumNumberOfGuesses	int	        Max number of times the user can guess
currentMinimumRange	    int	        Lowest number in guessing range
currentMaximumRange	    int	        Current largest number in guessing range
guessTooLow	            boolean	    Guess is lower than numberToGuess
easyGame	            boolean	    Game difficulty level
*/
public class GuessingGame {
    public static final boolean EASY_GAME = true;
    public static final boolean DIFFICULT_GAME = false;
    public static final int DEFAULT_MAXIMUM_RANGE = 10;
    public static final int GAME_WON = 2;
    public static final int GAME_LOST = 1;
    public static final int GAME_IN_PROGRESS = 0;
    private int gameState;
    private int numberToGuess;
    private int numberOfGuesses;
    private int largestPossibleNumber;
    private int maximumNumberOfGuesses;
    private int currentMinimumRange;
    private int currentMaximumRange;
    private boolean guessTooLow;
    private boolean easyGame;
    
    /*
        Data Table for GuessingGame(largestPossibleNumber:int, difficulty:boolean)		
    Variable or Constant	Type	Purpose
    largestPossibleNumber	int	    The largest number to guess
    difficulty	            boolean	Easy or difficult
    rand	                Random	Generate random number
    */
    /*
    		Algorithms for GuessingGame Constructors
    GuessingGame(largestPossibleNumber, difficulty) 		
        setLargestPossibleNumber(largestPossibleNumber)		
        setEasyGame(difficulty)		
        Random rand equals new Random()		
        setCurrentMaximumRange(largestPossibleNumber)		
        setCurrentMinimumRange(0)		
        setNumberToGuess(rand.nextInt(largestPossibleNumber))		
        setMaximumNumberOfGuesses(computeMaxNumberOfGuesses())		
    */
    public GuessingGame(int largestPossibleNumber, boolean difficulty){
        setLargestPossibleNumber(largestPossibleNumber);
        setEasyGame(difficulty);
        Random rand = new Random();
        setCurrentMaximumRange(largestPossibleNumber);
        setCurrentMinimumRange(0);
        setNumberToGuess(rand.nextInt(largestPossibleNumber));
        setMaximumNumberOfGuesses(computeMaxNumberOfGuesses());
        setGameState(GAME_IN_PROGRESS);
    }
    
    /*
        Data Table for GuessingGame(largestPossibleNumber:int)		
    Variable or Constant	Type	Purpose
    largestPossibleNumber	int	The largest number to guess
    EASY_GAME	            boolean	Default to easy game
    */
    /*
     GuessingGame(largestPossibleNumber) 
        this(largestPossibleNumber, EASY_GAME)
    */
    public GuessingGame(int largestPossibleNumber){
        this(largestPossibleNumber, EASY_GAME);
    }
    
    /*
        Data Table for GuessingGame(difficulty:boolean)		
    Variable or Constant	Type	Purpose
    DEFAULT_MAXIMUM_RANGE	int	    Default to 10 as largest number
    difficulty	            boolean	Easy or difficult
    */
    /*
     GuessingGame(difficulty) 
        this(DEFAULT_MAXIMUM_RANGE, difficulty)
    */
    public GuessingGame(boolean difficulty){
        this(DEFAULT_MAXIMUM_RANGE, difficulty);
    }
    
    /*
        Data Table for GuessingGame()		
    Variable or Constant	Type	Purpose
    DEFAULT_MAXIMUM_RANGE	int	    Default to 10 as largest number
    EASY_GAME	            boolean	Default to easy game
    */
    /*
     GuessingGame() 
        this(DEFAULT_MAXIMUM_RANGE, EASY_GAME)
    */
    public GuessingGame(){
        this(DEFAULT_MAXIMUM_RANGE, EASY_GAME);
    }
    
    
    public int getGameState(){
        return this.gameState;
    }
    
    /*
        Data Table for setGameState(gameState:int)		
    Variable or Constant	Type	Purpose
    gameState	            int	    Current game state
    gameState	            int	    Parameter, new state
    */
    /*
     setGameState(gameState) 
        this.gameState equals gameState
    */
    private void setGameState(int gameState){
        this.gameState = gameState;
    }
    
    public int getNumberToGuess(){
        return this.numberToGuess;
    }
    
    /*
        Data Table for setNumberToGuess(numberToGuess:int)		
    Variable or Constant	Type	Purpose
    numberToGuess	        int	    The number to guess
    numberToGuess	        int	    Parameter, new number to guess
    */
    /*
     setNumberToGuess(numberToGuess) 
        this.numberToGuess equals numberToGuess
    */
    private void setNumberToGuess(int numberToGuess){
        this.numberToGuess = numberToGuess;
    }
    
    public int getNumberOfGuesses(){
        return this.numberOfGuesses;
    }
    
    /*
        Data Table for setNumberOfGuesses(numberOfGuesses:int)		
    Variable or Constant	Type	Purpose
    numberOfGuesses	        int	    The number of times the user has guessed
    numberOfGuesses	        int	    Parameters, the new number of times the user has guessed
    */
    /*
     setNumberOfGuesses(numberOfGuesses) 
        this.numberOfGuesses equals numberOfGuesses
    */
    private void setNumberOfGuesses(int numberOfGuesses){
        this.numberOfGuesses = numberOfGuesses;
    }
    
    /*
        Data Table for getLargestPossibleNumber()		
    Variable or Constant	Type	Purpose
    largestPossibleNumber	int	    The largest number to guess
    */
    /*
     getLargestPossibleNumber() 
        return this.largestPossibleNumber
    */
    public int getLargestPossibleNumber(){
        return this.largestPossibleNumber;
    }
    
    /*
        Data Table for setLargestPossibleNumber(largestPossibleNumber:int)		
    Variable or Constant	Type	Purpose
    largestPossibleNumber	int	    The largest number to guess
    largestPossibleNumber	int	    Parameter, new largest number
    */
    /*
     setLargestPossibleNumber(number) 
        this.largestPossibleNumber equals Math.max(number, DEFAULT_MAXIMUM_RANGE)
    */
    private void setLargestPossibleNumber(int number){
        this.largestPossibleNumber = Math.max(number, DEFAULT_MAXIMUM_RANGE);
    }
    
    public int getMaximumNumberOfGuesses(){
        return this.maximumNumberOfGuesses;
    }
    
    /*
        Data Table for setMaximumNumberOfGuesses(maximumNumberOfGuesses:int)		
    Variable or Constant	Type	Purpose
    maximumNumberOfGuesses	int	    Max number of times the user can guess
    maximumNumberOfGuesses	int	    Parameter, new max number of guesses
    */
    /*
     setMaximumNumberOfGuesses(maximumNumberOfGuesses) 
        this.maximumNumberOfGuesses equals maximumNumberOfGuesses
    */
    private void setMaximumNumberOfGuesses(int maximumNumberOfGuesses){
        this.maximumNumberOfGuesses = maximumNumberOfGuesses;
    }
    
    public int getCurrentMinimumRange(){
        return this.currentMinimumRange;
    }
    
    /*
        Data Table for setCurrentMinimumRange(currentMinimumRange:int)		
    Variable or Constant	Type	Purpose
    currentMinimumRange	    int	    Lowest number in guessing range
    currentMinimumRange	    int	    Parameter, new lowest number in range
    */
    /*
     setCurrentMinimumRange(min) 
        if (min is greater than currentMinimumRange)
            currentMinimumRange equals min
    */
    private void setCurrentMinimumRange(int min){
        if (min > currentMinimumRange)
            currentMinimumRange = min;
    }
    
    public int getCurrentMaximumRange(){
        return this.currentMaximumRange;
    }
    
    /*
        Data Table for setCurrentMaximumRange(currentMaximumRange:int)		
    Variable or Constant	Type	Purpose
    currentMaximumRange	    int	    Current largest number in guessing range
    currentMaximumRange	    int	    Parameter, new largest number in range
    */
    /*
     setCurrentMaximumRange(max) 
        if (max is less than currentMaximumRange)
            currentMaximumRange equals max
        else
            currentMaximumRange equals largestPossibleNumber
    */
    private void setCurrentMaximumRange(int max){
        if (max < currentMaximumRange)
            currentMaximumRange = max;
        else
            currentMaximumRange = largestPossibleNumber;
    }
   
    public boolean getGuessTooLow(){
        return this.guessTooLow;
    }
    
    /*
        Data Table for setGuessTooLow(guessTooLow:boolean)		
    Variable or Constant	Type	Purpose
    guessTooLow	            boolean	Guess is lower than numberToGuess
    guessTooLow         	boolean	Parameter, new guess is too low
    */
    /*
     setGuessTooLow(tooLow) 
        this.guessTooLow equals guessTooLow
    */
    private void setGuessTooLow(boolean tooLow){
        this.guessTooLow = guessTooLow;
    }
    
    private boolean getEasyGame(){
        return this.easyGame;
    }
    
    /*
        Data Table for setEasyGame(easyGame:boolean)		
    Variable or Constant	Type	Purpose
    easyGame	            boolean	Current game difficulty level
    easyGame	            boolean	Parameter, new difficulty level
    */
    /*
     setEasyGame(difficulty) 
        this.easyGame equals difficulty
    */
    private void setEasyGame(boolean difficulty){
        this.easyGame = difficulty; 
    }
       
    /*
        Data Table for computeMaxNumberOfguesses()		
    Variable or Constant	Type	Purpose
    easyGame	            boolean	Game difficulty level
    iterations	            int	    Number of times that the computation loop iterates
    maxGuessFactor	        int	    Number that will be modified to convert largestPossibleNumber to the max number of guesses
    largestPossibleNumber	int	    The largest number to guess
    */
    /*
    		Algorithm for computeMaxNumberOfGuesses()
    computeMaxNumberOfGuesses() 		
        if (easyGame)		
            return Math.ceil(largestPossibleNumber divided by 2.0)		
        else		
            iterations equals 0		
            maxGuessFactor equals largestPossibleNumber		
            while (maxGuessFactor is greater than 1) 		
                maxGuessFactor equals maxGuessFactor divided by 2		
                iterations plus 1		
            iterations plus 1		
            return iterations		
    */
    private int computeMaxNumberOfGuesses(){
        if (easyGame)
            return (int)Math.ceil(largestPossibleNumber / 2.0);
        else {
            int iterations = 0;
            int maxGuessFactor = largestPossibleNumber; 
            while (maxGuessFactor > 1){
                maxGuessFactor = maxGuessFactor / 2;
                iterations++;
            }
            iterations++;
            return iterations;
        }    
    }
    
    /*
        Data Table for makeGuess(guess:int)		
    Variable or Constant	Type	Purpose
    guess	                int	    The number the user guessed
    numberOfGuesses	        int	    Number of times the user has guessed
    numberToGuess	        int	    The number the user needs to guess
    GAME_WON	            int     The game state value that is winning
    gameState	            int 	The current state of the game
    GAME_LOST	            int	    The game state value that is losing
    */
    /*
    		Algorithm for hint()
     makeGuess(guess) 		
        numberOfGuesses plus 1		
        if (guess is equal to numberToGuess)		
            setGameState(GAME_WON)		
        else if (guess is less than numberToGuess)		
            setGuessTooLow(true)		
            setCurrentMinimumRange(guess)		
        else if (guess is greater than numberToGuess)		
            setGuessTooLow(false)		
            setCurrentMaximumRange(guess)		
        if (numberOfGuesses is equal to 0 AND NOT (gameState is equal to GAME_WON))		
            setGameState(GAME_LOST)	
    */
    public void makeGuess(int guess){
        numberOfGuesses++;
            
        if (guess == numberToGuess)
            setGameState(GAME_WON);
        else if (guess < numberToGuess){
            setGuessTooLow(true);
            setCurrentMinimumRange(guess);
        }
        else if (guess > numberToGuess){
            setGuessTooLow(false);
            setCurrentMaximumRange(guess);
        }
        
        if (numberOfGuesses == 0 && !(gameState == GAME_WON))
            setGameState(GAME_LOST);
    }
    
    /*
        Data Table for hint()		
    Variable or Constant	Type	Purpose
    hint	                String	The users hint
    currentMinimumRange	    int	    The lowest number in guessing range
    currentMaximumRange	    int	    The highest number in guessing range
    */
    /*
    		Algorithm for hint()
     hint() 		
        String hint equals "Guess a number between " + currentMinimumRange + " and " + currentMaximumRange		
        return hint		
		
    */
    public String hint(){
        String hint = "Guess a number between " + currentMinimumRange + " and " + currentMaximumRange;
        return hint;
    }
         
    /*
        Data Table for quit()		
    Variable or Constant	Type	Purpose
    GAME_LOST	            int	    Value of the losing game state
    */
    /*
    		Algorithm for quit()
    quit() 		
        setGameState(GAME_LOST)	
    */
    public void quit(){
       setGameState(GAME_LOST);
    }
    
    /*
        Data Table for toString()		
    Variable or Constant	Type	Purpose
    guessingGame        	String	The object as a string
    gameState	            int	    The current game state
    GAME_IN_PROGRESS    	int	    Value of the in progress game state
    maximumNumberOfGuesses	int	    number of guesses the user is allowed
    numberOfGuesses	        int	    Number of times the user has guessed
    GAME_WON	            int	    Value of the winning game state
    numberToGuess	        int	    The number the user needs to guess
    */
    /*
    		Algorithm for toString()
    toString() 		
        String guessingGame		
        if (gameState is equal to GAME_IN_PROGRESS)		
            guessingGame equals "You have " + (maximumNumberOfGuesses - numberOfGuesses) + " guesses remaining."		
        else if (gameState is equal to GAME_WON)		
            guessingGame equals "It took " + numberOfGuesses + " guesses to get " + numberToGuess + ". Congratulations!"		
        else		
            guessingGame equals "You used all " + numberOfGuesses + " guesses. The correct number was " + numberToGuess + "."		
        return guessingGame		
    */
    public String toString(){
        String guessingGame;
        if (gameState == GAME_IN_PROGRESS)
           guessingGame = "You have " + (maximumNumberOfGuesses - numberOfGuesses) + " guesses remaining.";
        else if (gameState == GAME_WON)
           guessingGame = "It took " + numberOfGuesses + " guesses to get " + numberToGuess + ". Congratulations!";
        else
           guessingGame = "You used all " + numberOfGuesses + " guesses. The correct number was " + numberToGuess + ".";

        return guessingGame;
   }
}