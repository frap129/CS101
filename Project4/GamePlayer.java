import java.util.*;

/*
        Data Table for Class GamePlayer		
Variable or Constant	Type	        Purpose
guessingGame	        GuessingGame	Current guessingGame object
player	                Scanner	        Get user input

*/
public class GamePlayer
{
    private GuessingGame guessingGame;
    private Scanner player;

    public GuessingGame getGuessingGame(){
        return guessingGame;
    }
    
    /*
        Data Table for setGuessingGame(guessingGame:GuessingGame)		
    Variable or Constant	Type	        Purpose
    guessingGame    	    GuessingGame	Current guessingGame object
    guessingGame    	    GuessingGame	Parameter, new object

    */
    /*
    setGuessingGame(GuessingGame guessingGame) 
        this.guessingGame equals guessingGame
    */
    private void setGuessingGame(GuessingGame guessingGame){
        this.guessingGame = guessingGame;
    }
    
    public Scanner getPlayer(){
        return player;
    }
    
    /*
        Data Table for setPlayer(player:Scanner)		
    Variable or Constant	Type	Purpose
    player	                Scanner	Current Scanner object
    player	                Scanner	Parameter, new object
    */
    /*
     setPlayer(Scanner player) 
        this.player equals player
    */
    private void setPlayer(Scanner player){
        this.player = player;
    }

    /*
        Data Table for GamePlayer(ScannerPlayer)		
    Variable or Constant	Type	        Purpose
    player	                Scanner	        Get user input
    option	                int	User        selected menu option
    difficulty	            boolean	        User selected game difficulty
    upperBound	            int	User        selected highest number
    guessingGame        	GuessingGame    Object to play game
    */
    /*
        Algorithms for GamePlayer Constructor
    GamePlayer(Scanner player) 
        setPlayer(player)
        option equals 0
        difficulty equals GuessingGame.EASY_GAME
        upperBound equals GuessingGame.DEFAULT_MAXIMUM_RANGE
        while (option does not equal 3) 
            print "Select a menu option:\n1. choose difficulty level\n2. pick upper bound for guess\n3. play game"
            option equals player.nextInt()
            switch (option) :
                case 1:
                    print "Choose game difficulty: easy or difficult"
                    if (player.next().toLowerCase().contains("d"))
                        difficulty equals GuessingGame.DIFFICULT_GAME
                    break
                case 2:
                    print "Set the highest number you want to guess:"
                    upperBound equals player.nextInt()
                    break
                case 3:
                    print "Starting game"
                    break
                default:
                    print "Invalid option"
                    break
        guessingGame equals new GuessingGame(upperBound, difficulty)
    */
    public GamePlayer(Scanner player){
        setPlayer(player);
        int option = 0;
        boolean difficulty = GuessingGame.EASY_GAME;
        int upperBound = GuessingGame.DEFAULT_MAXIMUM_RANGE;
        while (option != 3){
            System.out.println("Select a menu option:\n1. choose difficulty level\n2. pick upper bound for guess\n3. play game");
            option = player.nextInt();
            switch (option){
                case 1:
                    System.out.println("Choose game difficulty: easy or difficult");
                    if (player.next().toLowerCase().contains("d"))
                        difficulty = GuessingGame.DIFFICULT_GAME;                  
                    break;
                case 2:
                    System.out.println("Set the highest number you want to guess:");
                    upperBound = player.nextInt();
                    break;
                case 3:
                    System.out.println("Starting game");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
                }
        }
        guessingGame = new GuessingGame(upperBound, difficulty);
    }
    
    /*
        Data Table for play()		
    Variable or Constant	Type	Purpose
    option	                int	    User selected menu option
    */
    /*
    		Algorithm for play()
    play() 		
        option equals 0		
        while (option does not equal 4) 		
            print "Select a menu option:" + "\n1. make a guess" + "\n2. get a hint" + "\n3. print statistics" + "\n4. quit this game"		
            option equals player.nextInt()		
            switch (option) :		
                case 1:		
                    print "Make a guess:"		
                
                   guessingGame.makeGuess(player.nextInt())		
                    if (GuessingGame.GAME_IN_PROGRESS does not equal guessingGame.getGameState())		
                        print guessingGame.toString()		
                    break		
                case 2:		
                    print guessingGame.hint()		
                    break		
                case 3:		
                    print guessingGame.toString()		
                    break		
                case 4:		
                    guessingGame.makeGuess(player.nextInt())		
                    if (GuessingGame.GAME_IN_PROGRESS does not equal guessingGame.getGameState())		
                        guessingGame.quit()		
                    print guessingGame.toString()		
                    break		
                default:		
                    print "Invalid option"		
                    break
    */
    public void play(){
        int option = 0;
        while (option != 4){
            System.out.println("Select a menu option:"
            + "\n1. make a guess"
            + "\n2. get a hint"
            + "\n3. print statistics"
            + "\n4. quit this game");
            option = player.nextInt();
            switch (option){
                case 1:
                    System.out.println("Make a guess:");
                    guessingGame.makeGuess(player.nextInt());
                    if (GuessingGame.GAME_IN_PROGRESS != guessingGame.getGameState()){
                        System.out.println(guessingGame.toString());
                    }
                    break;
                case 2:
                    System.out.println(guessingGame.hint());
                    break;
                case 3:
                    System.out.println(guessingGame.toString());
                    break;
                case 4:
                    if (GuessingGame.GAME_IN_PROGRESS != guessingGame.getGameState()){
                        guessingGame.quit();
                    }
                    System.out.println(guessingGame.toString());
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }   
    }
}