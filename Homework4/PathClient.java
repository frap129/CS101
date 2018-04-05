/* PathClient.java
*  Anderson, Franceschi, Maples
*/

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PathClient extends JFrame
{
  private boolean firstTime = true;

  private int key;             // input from the user
  private Path pathObject;

  public PathClient( )
  {
    super( "Illustrating if .. else" );

    pathObject = new Path( );

    setSize( 600, 600 );
    setVisible( true );
  }

  public void workWithIfElse( int score )
  {
    String result = "???";
    // ***** Student code starts here
    // If score is greater than 72, assign "over par" to result
    // If score is equal to 72, assign "par" to result
    // If score is less than 72, assign "below par" to result
    //
    if (score > 72)
        result = "over par";
    else if (score == 72)
        result = "par";
    else if (score < 72)
        result = "below par";
        

    //
    // Student code ends here
    //

    firstTime = false;
    animate( score, result );
  }
  // end of workWithIfElse

  public void startActivity( )
  {
    boolean goodInput = false;
    while ( !goodInput )
    {
      try
      {
          String answer = JOptionPane.showInputDialog( null,
                                           "Enter your golf score" );

          if ( answer != null )
          {
            key = Integer.parseInt( answer );
            goodInput = true;
          }
          else
          {
            System.exit( 0 );
          }
      }
      catch( Exception e )
      {}
    }
    if ( goodInput )
    {
      workWithIfElse( key );
    }
  }

  private void animate( int score, String result )
  {
    pathObject.setInputScore( score );
    pathObject.setCodeResult( result );
    pathObject.setSideCorrectColors( );
    pathObject.setSideColors( );
    try
    {
      repaint( );
      Thread.sleep( 100 );
    }
    catch ( InterruptedException e )
    {
      System.out.println( "IE Exception " + e.getMessage( ) );
      System.out.println( e.toString( ) );
    }
  }

  public void paint( Graphics g )
  {
    super.paint( g );
    if ( !firstTime )
        pathObject.draw( g );
  }

  public static void main( String [] args )
  {
    PathClient app = new PathClient( );
    app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    PrintArrayT t = new PrintArrayT( app );
    t.start( );
  }
}