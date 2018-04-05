/* MetricLength - converts inches to centimeters
   Anderson, Franceschi, Maples
*/

public class MetricLength

{
   public static void main( String [] args )
   {

       /***** 1. What data values do we know?
       * We know that there are 2.54 centimeters in an inch.
       * Declare a double constant named CM_PER_INCH.
       * Assign CM_PER_INCH the value 2.54.
       */
   	    final double CM_PER_INCH = 2.54;


       /***** 2.	What other data does the program require?
       * For this program, we require the number of inches.
       * Declare a double variable named inches.
       * Assign any desired value to this variable.
       */
   	    final double INCHES = 10;


       /***** 3. Calculation: convert inches to centimeters
       * Declare a double variable named centimeters.
       * Multiply inches by CM_PER_INCH
       * and store the result in centimeters.
       */
   	    double CM = INCHES * CM_PER_INCH;


       /***** 4. Output
       * Write one or two statements that output
       * the original inches and the equivalent centimeters.
       * Try to mathc the sample output in Figure 2.6.
       */
   	    System.out.println("Inches: " + INCHES);
   	    System.out.println("Centimeters: " + CM);
   }
}
