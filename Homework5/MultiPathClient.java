/* MultiPathClient.java
   Anderson, Franceschi, Maples
*/

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MultiPathClient extends JFrame
{
   private final int SIZE = 6;

   public static boolean [] array;
   private static int count1 = 0;
   private static int current1 = -1;

   private boolean firstTime = true;

   private int key;
   private MultiPath mp;

   public MultiPathClient( )
   {
    super( "Illustrating switch .. case" );

    array = new boolean[SIZE];

    // fill with values false
    for ( int i = 0; i < array.length; i++ )
        array[i] =  false;

    mp = new MultiPath( array, count1, current1 );

    setSize( 500, 600 );
    setVisible( true );
   }

   // ***** 1. student writes this method
   public void workWithSwitch( int value )
   {
    //
    // Student code starts here
    //
    
    switch(value) {
        case 0:
            animate(0, value);
            break;
        case 1:
            animate(1, value);
            break;
        case 2:
            animate(2, value);
            break;
        case 3:
            animate(3, value);
            break;
        case 4:
            animate(4, value);
            break;
        default:
            animate(-1, value);
    }

    //
    // Student code ends here
    //

    mp.setControl( false );
    mp.resetPath( );
    mp.setCount( 0 );
    mp.setCurrent( -1 );

   }
   // end of workWithSwitch

   public void startActivity( )
   {
      boolean goodInput = false;
      while ( !goodInput )
      {
        try
        {
            String answer = JOptionPane.showInputDialog( null, "Enter an integer" );

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
        firstTime = false;
        mp.setControl( true );
        workWithSwitch( key );
      }
   }

   public static int getCount1( )
   {
      return count1;
   }

   public static int getCurrent1( )
   {
      return current1;
   }

   public static boolean [] getArray( )
   {
      return array;
   }

   private void animate( int index, int value )
   {
      try
      {
        mp.setCurrent( value );
        mp.setPath( index, true );
        mp.addToCount( );
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
        mp.draw( g );
   }

   public static void main( String [] args )
   {
      MultiPathClient app = new MultiPathClient( );
      app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      PrintArrayT t = new PrintArrayT( app );
      t.start( );
   }
}
