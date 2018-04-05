/* MultiPath
* Anderson, Franceschi
*/

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class MultiPath
{
 // array path keeps track of the path
 private boolean [] path = { false, false, false, false, false, false };

 // count counts how many times the method animate was called
 // therefore deducting when the code hits the first break statement
 private int count = 0;

 // current is the value of test in MultiPathClient
 private int current;

 // makes sure we only draw once
 private boolean control = true;

 // 2 seconds of pause between the 2 images
 private static int animationPause = 2;

 public MultiPath( )
 {
 }

 public MultiPath( boolean [] p, int c1, int c2 )
 {
  setPath( p );
  count = c1;
  current = c2;
 }

 public void resetPath( )
 {
  for ( int i = 0; i < path.length; i++ )
  {
    path[i] = false;
  }
 }

 public void setPath( boolean [] p )
 {
  for ( int i = 0; i < path.length; i++ )
  {
    path[i] = p[i];
  }
 }

 public void setPath( int i, boolean b )
 {
  if ( i >= 0 && i < path.length )
        path[i] = true;
  else
        path[path.length - 1] = true;
 }

 public void setCount( int c )
 {
  count = c;
 }

 public int getCount( )
 {
  return count;
 }

 public void setCurrent( int c )
 {
  current = c;
 }

 public void setControl( boolean b )
 {
  control = b;
 }

 public void addToCount( )
 {
  count ++;
 }

 public int firstIndexTrue( )
 {
  int temp = -1;
  for ( int i = 0; i < path.length; i++ )
  {
     if ( path[i] )
     {
      return i;
     }
  }
  return temp;
 }

 public int lastIndexTrue( )
 {
  return ( firstIndexTrue( ) + count - 1 );
 }

 public void displayCountAndIndexes( )
 {
  int firstIndex = firstIndexTrue( );
  System.out.print( "count = " + count );
  System.out.print( "\tfirstIndex = " + firstIndex );
  System.out.println( "\tlastIndex true = " + ( firstIndex + count - 1 ) );
 }

 public void draw( Graphics g )
 {
  // displayCountAndIndexes( );
  if ( control )
    drawPath( g );
 }

 public void drawPath( Graphics g )
 {
  int startX = 100, startY = 25;
  g.setColor( new Color( 127,255,212 ) );
  // vertical entry line (1st line)
  // g.drawLine(startX, startY, startX, startY + 25);
  g.fillRect( startX - 2, startY, 5, 25 );
  // entry rectangle (1st rectangle)
  g.fillRoundRect( startX - 50, startY + 25, 100, 40, 10, 10 );
  // 2nd vertical line
  // g.drawLine(startX, startY + 65, startX, startY + 90);
  g.fillRect( startX - 2, startY + 65, 5, 25 );
  // 2nd rectangle
  g.fillRoundRect( startX - 50, startY + 90, 100, 40, 10, 10);
  // 8th right line
  g.drawLine( startX + 250, startY + 430, startX + 250, startY + 480 );
  // last rectangle
  g.fillRoundRect( startX + 200, startY + 480, 100, 40, 10, 10 );
  // last line
  // g.drawLine(startX + 250, startY + 520, startX + 250, startY + 545);
  g.fillRect( startX + 248, startY + 520, 5, 25 );
  //////////////////////////////////////////
  // NOW select drawing color depending on objects to draw and path

  // left rectangles
  g.setColor( Color.LIGHT_GRAY );
  for ( int i = 1; i < path.length; i++ )
  {
   if ( i <= firstIndexTrue( ) )
        g.setColor( new Color( 127, 255, 212 ) );
   else
        g.setColor( Color.LIGHT_GRAY );
   g.fillRoundRect(startX - 50, startY + 90 + (65 * i), 100, 40, 10, 10 );
  }

  // left vertical lines
  g.setColor( Color.LIGHT_GRAY );
  for ( int i = 0; i < path.length -  1; i++ )
  {
   if ( i < firstIndexTrue( ) )
        g.setColor( new Color( 127, 255, 212 ) );
   else
        g.setColor( Color.LIGHT_GRAY );
   g.fillRect( startX - 2, startY + 130 + (65 * i), 5, 25);
  }

  // middle vertical lines
  g.setColor( Color.LIGHT_GRAY );
  for ( int i = 0; i < path.length -  1; i++ )
  {
   if ( i >= firstIndexTrue( ) && i < lastIndexTrue( ) )
        g.setColor( new Color( 127, 255, 212 ) );
   else
        g.setColor(Color.lightGray);
   g.fillRect(startX + 148, startY + 130 + (65 * i), 5, 25);
  }

  // right vertical lines
  g.setColor(Color.lightGray);
  for ( int i = 0; i < path.length; i++ )
  {
   if ( i >= lastIndexTrue( ) )
        g.setColor( new Color( 127, 255, 212 ) );
   else
        g.setColor( Color.LIGHT_GRAY );
   g.fillRect( startX + 248, startY + 110 + (65 * i), 5, 65 );
  }

  // left horizontal lines
  g.setColor( Color.LIGHT_GRAY );
  for ( int i = 0; i < path.length; i++ )
  {
   if ( i == firstIndexTrue( ) )
        g.setColor( new Color( 127, 255, 212 ) );
   else
        g.setColor( Color.LIGHT_GRAY );
   g.fillRect( startX + 50, startY + 110 + (65 * i), 50, 5 );
  }

  // 2nd right rectangles
  g.setColor(Color.lightGray);
  for ( int i = 0; i < path.length; i++ )
  {
   if ( i >= firstIndexTrue( ) && i <= lastIndexTrue( ) )
        g.setColor( new Color( 127, 255, 212 ) );
   else
        g.setColor( Color.LIGHT_GRAY );
   g.fillRoundRect( startX + 100, startY + 90 + (65 * i), 100, 40, 10, 10 );
  }

  // right horizontal lines
  g.setColor( Color.LIGHT_GRAY );
  for ( int i = 0; i < path.length; i++ )
  {
   if ( i == lastIndexTrue( ) )
        g.setColor( new Color( 127, 255, 212 ) );
   else
        g.setColor( Color.LIGHT_GRAY );
   g.fillRect( startX + 200, startY + 110 + (65 * i), 48,5 );
  }

  g.setColor( Color.BLACK );
  g.drawString( "switch(test)", startX - 35, startY + 50 );
  g.drawString( "case(0) ?", startX - 35, startY + 115 );
  g.drawString( "case(1) ?", startX - 35, startY + 180 );
  g.drawString( "case(2) ?", startX - 35, startY + 245 );
  g.drawString( "case(3) ?", startX - 35, startY + 310 );
  g.drawString( "case(4) ?", startX - 35, startY + 375 );
  g.drawString( "default", startX - 35, startY + 440 );

  g.drawString( "Value is 0", startX + 115, startY + 115 );
  g.drawString( "Value is 1", startX + 115, startY + 180 );
  g.drawString( "Value is 2", startX + 115, startY + 245 );
  g.drawString( "Value is 3", startX + 115, startY + 310 );
  g.drawString( "Value is 4", startX + 115, startY + 375 );
  g.drawString( "Not a valid value", startX + 105, startY + 440 );

  g.drawString( "Continue", startX + 225, startY + 505 );

  g.setFont( new Font( "Serif", Font.BOLD, 18 ) );
  g.setColor( Color.RED );
  g.drawString( "Value of test is " + current, startX + 110, startY + 50 );

 }
}
