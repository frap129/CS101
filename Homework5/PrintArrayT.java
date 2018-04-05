/* PrintArrayT
* Anderson, Franceschi
*/

public class PrintArrayT extends Thread
{
 boolean [] arr;
 MultiPathClient mp1;

 public PrintArrayT( MultiPathClient m )
 {
  arr = MultiPathClient.array;
  mp1 = m;
 }

 public void run( )
 {
  while( true )
  {
   try
   {
    Thread.sleep( 500 );
   }
   catch( Exception e )
   {}
   mp1.startActivity( );
  }
 }
}