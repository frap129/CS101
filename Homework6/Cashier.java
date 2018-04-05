/* Cashier class
   Anderson, Franceschi, Maples
*/
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class Cashier extends JFrame
{
  private Cart cart;
  private Item previousItem;
  private double currentTotal;

  public Cashier( )
  {
   super( "Chapter 6 Programming Activity 1" );
   cart = new Cart( );
   previousItem = null;
   currentTotal = 0.0;
   getContentPane( ).setBackground( cart.getBackground( ) );
   setSize( 300, 300 );
   setVisible( true );
  }

  public void checkout( )
  {

   /* ***** Student writes the body of this method ***** */
   //
   //  Using a while loop, calculate the total price
   //  of the groceries
   //
   // The getNext method (in this Cashier class) returns the
   // next item on the conveyor belt, which is an Item object
   // (we do not know which item and we do not know how many items
   // are in the cart - this is randomly generated).
   // getNext does not take any arguments. Its API is:
   //       Item getNext( )
   //
   // Right after you update the current subtotal,
   // you should call the animate method.
   // The animate method takes one parameter: a double,
   // which is your current subtotal
   // For example, if the name of your variable representing
   // the current subtotal is total, your call to the animate
   // method should be:
   //    animate( total );
   //
   // The instance method getPrice of the Item class
   // returns the price of the Item object.
   // The method getPrice does not take any arguments.
   // Its API is:
   //         double getPrice( )
   //
   // The cart is empty when the getNext method returns
   // the divider Item.
   // You detect the divider item because its price
   // is -0.99. So an Item with a price of -0.99
   // is the sentinel value for the loop.
   //
   // After you scan the divider, display the total
   // for the cart in a dialog box.
   
   final String MONEY_FORMAT = "$#,##0.00";
   DecimalFormat priceFormat = new DecimalFormat(MONEY_FORMAT);
   boolean moreItems = true;
   double total = 0.00;
   Item newItem = getNext();
   double itemPrice = newItem.getPrice();
   while(moreItems){
      if (itemPrice < 0.00)
        moreItems = false;
      else {
        total = total + itemPrice;
        animate(total);
        newItem = getNext();
        itemPrice = newItem.getPrice();
      }
   }
   JOptionPane.showMessageDialog(null, "The total price is " + priceFormat.format(total));

    
   //
   //  End of student code
   //
  }

  public Item getNext( )
  {
   // get next item
   // if the first item is the divider, that is ok - the cart is empty
   int number = ( (int) (Math.random( ) * cart.getItemSize( ) ) );
   cart.setCurrentItem( number );

   // update previousItem so that we can keep track of the current total
   previousItem = cart.getItems( )[cart.getCurrentItem( )];

   // update currentTotal
   if ( ( previousItem != null ) && ( previousItem.getPrice( ) >= 0 ) )
    currentTotal += previousItem.getPrice( );
   cart.setExactTotal( currentTotal );

   // animate divider if necessary
   if ( number == 3 )
      animate( cart.getTotal( ) );
   return ( cart.getItems( ) )[cart.getCurrentItem( )];
  }

  public void animate( double subtotal )
  {
   cart.updateTotal( subtotal );

   repaint( );
   try {
       Thread.sleep( 3000 );  // wait for the animation to finish
   }
   catch ( Exception e )
   {
   }
  }

  public void paint( Graphics g )
  {
    super.paint( g );
    cart.draw( g );
  }

  public static void main( String [] args )
  {
   Cashier app = new Cashier( );
   app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   app.checkout( );
  }
}