/* Path.java
* Anderson, Franceschi
*/

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Path
{

 private int inputScore;        // the score
 private String codeResult;     // Over Par or Par or less
 private String correctness;    // correct or incorrect
 private String verb;           // is (correct) or was (incorrect)

 private int startX = 50;
 private int startY = 25;
 private int startXFace = 425;
 private int startYFace = 125;

 private double c = 0.5;        // coefficient for the size of the happy/unhappy faces

 private final Color GREENISH = new Color( 127, 255, 212 );
 private Color leftSideColor;
 private Color rightSideColor;

 private Color overParColor;
 private Color parColor;
 private Color belowParColor;

 public Path( )
 {
    inputScore = -1;
    codeResult = "unknown";
    correctness = "unknown";
    verb = "unknown";
 }

 public void setInputScore( int is )
 {
      inputScore = is;
 }

 public void setCodeResult( String cr )
 {
    codeResult = cr;
 }

 public void setCorrectness( )
 {
   if (inputScore > 72 && codeResult.equalsIgnoreCase( "over par" ) )
   {
      correctness = "correct";
      verb = "is";
   }
   else if ( inputScore < 72 && codeResult.equalsIgnoreCase( "below par" ) )
   {
      correctness = "correct";
      verb = "is";
   }
   else if ( inputScore == 72 && codeResult.equalsIgnoreCase( "par" ) )
   {
      correctness = "correct";
      verb = "is";
   }
   else
   {
      correctness = "incorrect";
      verb = "was";
   }
 }

 public void setSideColors( )
 {
   if ( inputScore > 72 && correctness.equals( "correct" ) )
   {
         leftSideColor = GREENISH;
         rightSideColor = Color.LIGHT_GRAY;
   }
   else if ( inputScore <= 72 && correctness.equals( "correct" ) )
   {
         rightSideColor = GREENISH;
         leftSideColor = Color.LIGHT_GRAY;
   }
   else if ( inputScore > 72 && correctness.equals( "incorrect" ) )
   {
         leftSideColor = GREENISH;
         rightSideColor = Color.LIGHT_GRAY;
   }
   else
   {
         rightSideColor = GREENISH;
         leftSideColor = Color.LIGHT_GRAY;
   }
 }

 public void setSideCorrectColors( )
 {
   parColor = Color.LIGHT_GRAY;
   overParColor = Color.LIGHT_GRAY;
   belowParColor = Color.LIGHT_GRAY;

   if ( inputScore > 72 )
   {
         overParColor = GREENISH;
   }
   else if ( inputScore == 72 )
   {
         parColor = GREENISH;
   }
   else
   {
         belowParColor = GREENISH;
   }
 }

 public void draw( Graphics g )
 {
    // set correctness value
    setCorrectness( );
    // draw Face
    drawFace( g );
    // draw right path (correct path according to input)
    drawCorrectPath( g );
    // draw code inside rectangles
    drawCode2( g );
    // draw a String representing the score entered
    drawScore( g );
    // draw a String representing the result given by the code
    drawCodeResult( g );
    // draw a String representing whether the result is correct or incorrect
    drawResultCorrectness( g );
    // draw Headers
    drawHeaders( g );
 }

 public void drawCorrectPath( Graphics g )
 {
    g.setColor( GREENISH );

    // entry line to "> 72 ?"
    g.fillRect( startX + 100, startY + 50, 3, 25 );

    // "> 72 ?"
    g.fillRoundRect( startX + 50, startY + 75, 100, 40, 10, 10 );

    // "continue"
    g.fillRoundRect( startX + 50, startY + 355, 100, 40, 10, 10 );

    // "continue" to out
    g.fillRect( startX + 100, startY + 395, 3, 25 );

    ///////// over par path drawing //////////////////////////////////
    g.setColor( overParColor );

    // line to "over par" assignment
    g.drawLine( startX + 100, startY + 115, startX + 20, startY + 165 );
    g.drawLine( startX + 99, startY + 115, startX + 19, startY + 165 );
    g.drawLine( startX + 101, startY + 115, startX + 21, startY + 165 );

    // "over par" assignment
    g.fillRoundRect( startX - 30, startY + 165, 100, 40, 10, 10 );

    // straight line from "over par" assignment
    g.drawLine( startX + 20, startY + 205, startX + 20, startY + 305 );
    g.drawLine( startX + 19, startY + 205, startX + 19, startY + 305 );
    g.drawLine( startX + 21, startY + 205, startX + 21, startY + 305 );

    // left line to continue
    g.drawLine( startX + 20, startY + 305, startX + 100, startY + 355 );
    g.drawLine( startX + 19, startY + 305, startX + 99, startY + 355 );
    g.drawLine( startX + 21, startY + 305, startX + 101, startY + 355 );

    ///////// par and below par path drawing /////////////////////////
    if ( inputScore <= 72 )
        g.setColor( GREENISH );
    else
        g.setColor( Color.LIGHT_GRAY );
    // line to test for == 72
    g.drawLine( startX + 100, startY + 115, startX + 180, startY + 165 );
    g.drawLine( startX + 99, startY + 115, startX + 179, startY + 165 );
    g.drawLine( startX + 101, startY + 115, startX + 181, startY + 165 );

    // test for == 72
    g.fillRoundRect( startX + 130, startY + 165, 100, 40, 10, 10 );

    ///////// par path drawing ///////////////////////////////////////
    g.setColor( parColor );

    // line to "par" assignment
    g.drawLine( startX + 180, startY + 205, startX + 100, startY + 255 );
    g.drawLine( startX + 179, startY + 205, startX + 99, startY + 255 );
    g.drawLine( startX + 181, startY + 205, startX + 101, startY + 255 );

    // "par" assignment
    g.fillRoundRect( startX + 50, startY + 255, 100, 40, 10, 10 );

    // straight line from "par" assignment to continue
    g.drawLine( startX + 100, startY + 295, startX + 100, startY + 355 );
    g.drawLine( startX + 99, startY + 295, startX + 99, startY + 355 );
    g.drawLine( startX + 101, startY + 295, startX + 101, startY + 355 );

    ///////// below par path drawing /////////////////////////////////
    g.setColor( belowParColor );

    // line to "below par" assignment
    g.drawLine( startX + 180, startY + 205, startX + 260, startY + 255 );
    g.drawLine( startX + 179, startY + 205, startX + 259, startY + 255 );
    g.drawLine( startX + 181, startY + 205, startX + 261, startY + 255 );

    // "below par" assignment
    g.fillRoundRect( startX + 210, startY + 255, 100, 40, 10, 10 );

    // line from "below par" assignment to continue
    g.drawLine( startX + 260, startY + 295, startX + 100, startY + 355 );
    g.drawLine( startX + 259, startY + 295, startX + 99, startY + 355 );
    g.drawLine( startX + 261, startY + 295, startX + 101, startY + 355 );
 }

 public void drawFace( Graphics g )
 {
   if ( correctness.equals( "correct" ) )
        drawHappyFace( g );
   else
        drawUnHappyFace( g );
 }

 public void drawHappyFace( Graphics g )
 {
   // draw happy face
   // ep xface sub 125,expression yface add 175

   g.setColor( Color.YELLOW );
   g.fillOval( startXFace, startYFace, (int) ( c * 150 ), (int) ( c * 150 ) );

   // draw eyes
   g.setColor( Color.BLACK );
   g.drawLine( (int) ( startXFace + 35 * c ), (int) ( startYFace + 50 * c ),
              (int) ( startXFace + 35 * c + c * 25 ), (int) ( startYFace + 50 * c ) );
   g.drawLine( (int) ( startXFace + 85 * c ), (int) ( startYFace + 50 * c ),
              (int) (startXFace + 85 * c + c * 25 ), (int) ( startYFace + 50 * c ) );

   // draw nose
   g.drawLine( (int) ( startXFace + 72 * c ), (int) ( startYFace + 70 * c ),
              (int) ( startXFace + 72 * c ), (int) ( startYFace + 70 * c + 20 * c ) );

   // draw mouth
   g.drawArc( (int) ( startXFace + 35 * c ), (int) ( startYFace + 50 * c ),
             (int) ( 75 * c ), (int) ( 75 * c ), 0, -180 );
 }

 public void drawUnHappyFace( Graphics g )
 {
   // draw unhappy face

   g.setColor( Color.YELLOW );
   g.fillOval( startXFace, startYFace, (int) (150*c), (int) (150*c));

   // draw eyes
   g.setColor( Color.BLACK );
   g.drawLine( (int) (startXFace + 35*c), (int) (startYFace + 25*c), (int) (startXFace + 60*c), (int) (startYFace + 25*c) );
   g.drawLine( (int) (startXFace + 85*c), (int) (startYFace + 25*c), (int) (startXFace + 110*c), (int) (startYFace + 25*c) );

   // draw nose
   g.drawLine( (int) (startXFace + 72*c), (int) (startYFace + 45*c), (int) (startXFace + 72*c), (int) (startYFace + 65*c) );

   // draw mouth
   g.drawArc( (int) (startXFace + 35*c), (int) (startYFace + 75*c), (int) (75*c), (int) (50*c), 0, 180 );

   // draw tear

   //  center to right - down
   g.drawArc( (int) (startXFace + 48*c), (int) (startYFace + 23*c), (int) (10*c), (int) (20*c), -90, -105 );

   // center to left - down
   g.drawArc( (int) (startXFace + 33*c), (int) (startYFace + 20*c), (int) (15*c), (int) (25*c), 0, -45 );

   // circle
   g.drawArc( (int) (startXFace + 43*c), (int) (startYFace + 40*c), (int) (10*c), (int) (10*c), 30, -270 );
 }

 public void drawScore( Graphics g )
 {
   g.setFont( new Font( "Serif", Font.BOLD, 18 ) );
   g.setColor( Color.BLACK );
   g.drawString( "The score was " + inputScore, startX, startY + 450 );
 }

 public void drawCodeResult( Graphics g )
 {
   g.setFont( new Font( "Serif", Font.BOLD, 18 ) );
   g.setColor( Color.BLACK );
   g.drawString( "The result given by your code is ", startX, startY + 500 );
   g.setColor( Color.BLUE );
   g.drawString( codeResult, startX + 250, startY + 500 );
   g.setColor( Color.BLACK );
 }

 public void drawResultCorrectness( Graphics g )
 {
   g.setFont( new Font( "Serif", Font.BOLD, 18 ) );
   g.setColor( Color.BLACK );
   g.drawString( "The result given by your code is ", startX, startY + 550 );
   if (correctness.equals( "correct" ) )
        g.setColor( Color.BLUE );
   else
        g.setColor( Color.RED );
   g.drawString( correctness.toUpperCase(), startX + 250, startY + 550 );
   g.setColor( Color.BLACK );
 }

 public void drawHeaders( Graphics g )
 {
   g.setColor( Color.RED );
   g.setFont( new Font( "Serif", Font.BOLD, 18 ) );
   g.drawString( "The correct path " + verb, startX + 20, startY + 25 );
 }

 public void drawCode2( Graphics g )
 {
   g.setColor( Color.BLACK );
   g.drawString( "    score > 72 ?", startX + 60, startY + 90 );
   g.drawString( "Yes: left No: right", startX + 56, startY + 110 );

   g.drawString( "true:", startX + 10, startY + 180 );
   g.drawString( "result = over par", startX - 20, startY + 200 );

   g.drawString( "false: score = 72 ?", startX + 130, startY + 180 );
   g.drawString( "Yes: left No: right", startX + 130, startY + 200 );

   g.drawString( "true:", startX + 85, startY + 270 );
   g.drawString( "result = par", startX + 70, startY + 290 );

   g.drawString( "false:", startX + 245, startY + 270 );
   g.drawString( "result = below par", startX + 210, startY + 290 );

   g.drawString( "Continue", startX + 70, startY + 380 );
 }
}
