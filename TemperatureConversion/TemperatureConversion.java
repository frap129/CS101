/* Temperature Conversion
   Anderson, Franceschi, Maples
*/

public class TemperatureConversion {
    public static void main( String [] args ) {
       //***** 1. declare any constants here      
      	
            
       //***** 2.  declare temperature in Fahrenheit as an int 
	   int fahrenheitTemp = 210;
	  		
       //***** 3. calculate equivalent Celsius temperature	
	   int celsiusTemp = (int) getCelsius(fahrenheitTemp);
	  		
       //***** 4. output the temperature in Celsius
       System.out.println("Celsius: " + celsiusTemp);
												  
       //***** 5. convert Celsius temperature back to Fahrenheit
       fahrenheitTemp = (int) getFahrenheit(celsiusTemp);
				
       //***** 6. output Fahrenheit temperature to check correctness 
	   System.out.println("Farenheit: " + fahrenheitTemp);
				
    }
    
    public static double getCelsius(int fahrenheit) {
       double celsius = ((fahrenheit - 32) * 5) / 9;
      
       return celsius;
    }
   
    public static double getFahrenheit(int celsius) {
       double fahrenheit = ((celsius * 9) / 5) + 32;
       
       return fahrenheit;
    }
}