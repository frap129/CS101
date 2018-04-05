/** Divider
*   Anderson, Franceschi
*/

import java.awt.Graphics;
import java.awt.Color;
import java.text.DecimalFormat;

public class Divider extends Item
{
 public Divider( double p )
 {
   super( p );
 }

 public void draw( Graphics g, int startX, int endX, int y, Color eraseColor )
 {

  DecimalFormat money = new DecimalFormat( "$0.00");

  for ( int x = startX; x < endX; x += 5 )
  {

   g.setColor( Color.YELLOW );
   g.fillRoundRect( x, y - 20, 63, 18, 5, 5 );
   g.setColor( Color.BLACK );
   g.drawRoundRect( x, y - 20, 63, 18, 5, 5 );
   g.drawString("Thank you!", x + 2, y - 5 );
   try
   {
     Thread.sleep( ( int )( 100 ) );
   }
   catch ( InterruptedException e )
   {
     e.printStackTrace( );
   }
   // erase
   g.setColor( eraseColor );
   g.fillRect( x, y - 70, 65, 70 );
  }
 }
}