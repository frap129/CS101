/* PrintArrayT.java
* Anderson, Franceschi
*/

public class PrintArrayT extends Thread
{
  PathClient p1;

  public PrintArrayT( PathClient pc )
  {
    p1 = pc;
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
      p1.startActivity( );
    }
  }
}
