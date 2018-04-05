import java.util.*;

public class PlayGame{ 

    /*
        Data Table for main(args)		
    Variable or Constant	Type    	Purpose
    args	                String []	parameter, unused
    scan	                Scanner	    Read user input
    playAgain	            boolean 	Whether the user wants to play again
    games	                int	        Number of games the user has played
    player	                GamePlayer	GamePlayer object for playing the game
    */
    /*
    		Algorithm for main(args)
     main(String[] args) 		
        instantiate Scanner scan		
        playAgain equals false		
        games equals 0		
        do 		
            player equals new GamePlayer(scan)		
            player.play()		
            games plus 1		
            print "Would you like to play again? [y/N]"		
            playAgain equals scan.next().toLowerCase().contains("y")		
        while (playAgain)		
        if (games equals 1)		
            print "Thanks for playing!"		
        else		
            print "Thanks for playing " + games + " times!"
    */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean playAgain = false;
        int games = 0;
        do {
           GamePlayer player = new GamePlayer(scan);
           player.play();
           games++;
           System.out.println("Would you like to play again? [y/N]");
           playAgain = scan.next().toLowerCase().contains("y");
        } while (playAgain);
        if (games == 1)
           System.out.println("Thanks for playing!");
        else
           System.out.println("Thanks for playing " + games + " times!");
     }
}