/*
  Joe Maples
  Coffee Sales Software
  CS101
  Oct 12th, 2017
*/

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class CoffeePurchase
{
/* 
 CoffeePurchase Algorithm

 main(args)
   initialize BAG_PRICE
   initialize LARGE_BOX_PRICE
   initialize MED_BOX_PRICE
   initialize SMALL_BOX_PRICE
   initialize BAGS_IN_LARGE
   initialize BAGS_IN_MED
   initialize BAGS_IN_SMALL
   read customerName using JOptionPane showInputDialog
   read dayEntry
   read monthEntry
   read yearEntry
   day <-  convert dayEntry to int (using Integer.parseInt)
   month <- convert monthEntry to int
   year <- convert yearEntry to int
   purchaseDate <- SimpleDate object from month, day,  year
   deliveryDate <- SimpleDate object from month, day,  year
   deliveryDate.nextDay()
   deliveryDate.nextDay()
   deliveryDate.nextDay()
   deliveryDate.nextDay()
   deliveryDate.nextDay()
   deliveryDate.nextDay()
   deliveryDate.nextDay()
   read poundsCoffeeEntry
   poundsCoffeeDouble <- convert poundsCoffeeEntry to double
   poundsCoffeeDouble <- ceiling of poundsCoffeeDouble
   poundsCoffee <- convert poundsCoffeeDouble to int
   bagsCoffee <- (poundsCoffee + 1)/2
   coffeeCost <- bagsCoffee * BAG_PRICE
   currentBags <- bagsCoffee
   numberLargeBoxes <- currentBags / BAGS_IN_LARGE
   currentBags <- currentBags % BAGS_IN_LARGE
   numberMedBoxes <- currentBags / BAGS_IN_MED
   currentBags <- currentBags % BAGS_IN_MED
   numberSmallBoxes <- (currentBags + 2) / BAGS_IN_SMALL
   largeBoxCost <- numberLargeBoxes * LARGE_BOX_PRICE
   medBoxCost <- numberMedBoxes * MED_BOX_PRICE
   smallBoxCost <- numberSmallBoxes * SMALL_BOX_PRICE
   initialize MONEY_FORMAT
   priceFormat <- construct DecimalFormat object from MONEY_FORMAT
   totalBoxCost <- largeBoxCost + medBoxCost + smallBoxCost
   totalCostOfOrder <- coffeeCost + totalBoxCost
   coffeeCostDisplay <- format coffeeCost  using priceFormat
   lgBoxDisplay <- format largeBoxCost  using priceFormat 
   medBoxDisplay <- format medBoxCost  using priceFormat 
   smBoxDisplay <- format smallBoxCost  using priceFormat 
   totalCostDisplay <- format totalCostOfOrder  using priceFormat 
   purchaseOrder <- concatenate with labels all of customerName,
       purchaseDate, deliveryDate, bagsCoffee, coffeeCostDisplay,
       numberLargeBoxes, lgBoxDisplay, numberMedBoxes,
       medBoxDisplay, numberSmallBoxes, smBoxDisplay, totalCostDisplay
   print purchaseOrder using JOptionPane showMessageDialog
*/
       
/* 
 CoffeePurchase Data Table for main(args)
 

 Variable           Type          Purpose
 args               String []     parameter, unused
 BAG_PRICE          double        current charge for 2 lb. Bag
 LARGE_BOX_PRICE    double        current charge for large box
 MED_BOX_PRICE      double        current charge for large box
 SMALL_BOX_PRICE    double        current charge for large box
 BAGS_IN_LARGE      int           number of bags in large box
 BAGS_IN_MED        int           number of bags in medium box
 BAGS_IN_SMALL      int           number of bags in small box
 customerName       String        name of customer
 dayEntry           String        input of day
 day                int           numeric day
 monthEntry         String        input of month
 month              int           numeric month
 yearEntry          String        input of year
 year               int           numeric year
 purchaseDate       SimpleDate    record today’s date
 deliveryDate       SimpleDate    date order delivered to customer
 poundsCoffeeEntry  String        input of amount purchased
 poundsCoffeeDouble double        numeric amount purchased
 poundsCoffee       int           integer amount requested
 bagsCoffee         int           number of bags purchased
 coffeeCost         double        cost of coffee
 currentBags        int           remaining bags, needed for box calculation
 numberLargeBoxes   int           number of large boxes needed
 numberMedBoxes     int           number of medium boxes needed
 numberSmallBoxes   int           number of small boxes needed
 largeBoxCost       double        cost of large boxes
 medBoxCost         double        cost of medium boxes
 smallBoxCost       double        cost of small boxes
 MONEY_FORMAT       String        “$#,##0.00” for standard money format
 priceFormat        DecimalFormat object to format double to money String
 totalBoxCost       double        total cost of boxes
 totalCostOfOrder   double        total cost of order (coffee and boxes)
 coffeeCostDisplay  String        cost of coffee as money String
 lgBoxDisplay       String        cost of large boxes as money String
 medBoxDisplay      String        cost of medium boxes as money String
 smBoxDisplay       String        cost of small boxes as money String
 totalCostDisplay   String        totalCostOfOrder as money String
 purchaseOrder      String        String containing entire purchase ord
*/
   public static void main(String [] args)
   {
      // Define constant prices and sizes of coffee
      final double BAG_PRICE = 2.33;
      final double LARGE_BOX_PRICE = 1.51;
      final double MED_BOX_PRICE = 0.96;
      final double SMALL_BOX_PRICE = 0.57;
      final int BAGS_IN_LARGE = 12;
      final int BAGS_IN_MED = 6;
      final int BAGS_IN_SMALL = 3;   
      
      // Collect customer information
      String customerName = JOptionPane.showInputDialog(null, "What is your name?");
      String dayEntry = JOptionPane.showInputDialog(null, "What day is it?");
      String monthEntry = JOptionPane.showInputDialog(null, "What month is it?");
      String yearEntry = JOptionPane.showInputDialog(null, "What year is it?");
      
      // Convert date from Strings to ints
      int day = Integer.parseInt(dayEntry);
      int month = Integer.parseInt(monthEntry);
      int year = Integer.parseInt(yearEntry);
      
      // Declare purchase and delivery date SimpleDate Objects
      SimpleDate purchaseDate = new SimpleDate(month, day, year);
      SimpleDate deliveryDate = new SimpleDate(month, day, year);
      
      // Increment day 7 times to get delivery date
      deliveryDate.nextDay();
      deliveryDate.nextDay();
      deliveryDate.nextDay();
      deliveryDate.nextDay();
      deliveryDate.nextDay();
      deliveryDate.nextDay();
      deliveryDate.nextDay();
      
      // Ask how much the customer wants, convert to double
      String poundsCoffeeEntry = JOptionPane.showInputDialog(null, "How many "
      + "poundswould you like?");
      double poundsCoffeeDouble = Double.parseDouble(poundsCoffeeEntry);
      
      // Round up weight and cast to int
      poundsCoffeeDouble = Math.ceil(poundsCoffeeDouble);
      int poundsCoffee = (int)poundsCoffeeDouble;
      
      // Find the number of bags and their cost
      int bagsCoffee = ++poundsCoffee / 2;
      double coffeeCost = bagsCoffee * BAG_PRICE;
      
      // Another bags variable to actively work with
      // when calculating the needed boxes
      int currentBags = bagsCoffee;
      
      // Find the number of large boxes we need and see how many are left over
      int numberLargeBoxes = currentBags / BAGS_IN_LARGE;
      currentBags = currentBags % BAGS_IN_LARGE;
      
      // Find the number of medium boxes from left over bags, update left overs
      int numberMedBoxes = currentBags / BAGS_IN_MED;
      currentBags = currentBags % BAGS_IN_MED;
      
      // Fit the rest into small boxes
      int numberSmallBoxes = (currentBags + 2) / BAGS_IN_SMALL;
      
      // Find the cost of all the boxes
      double largeBoxCost = numberLargeBoxes * LARGE_BOX_PRICE;
      double medBoxCost = numberMedBoxes * MED_BOX_PRICE;
      double smallBoxCost = numberSmallBoxes * SMALL_BOX_PRICE;
   
      // Create DecimalFormat object for price formatting
      final String MONEY_FORMAT = "$#,##0.00";   
      DecimalFormat priceFormat = new DecimalFormat(MONEY_FORMAT);
      
      // Total costs
      double totalBoxCost = largeBoxCost + medBoxCost + smallBoxCost;
      double totalCostOfOrder = coffeeCost + totalBoxCost;
      
      // Format all cost variables in price format
      String coffeeCostDisplay = priceFormat.format(coffeeCost);
      String lgBoxDisplay = priceFormat.format(largeBoxCost);
      String medBoxDisplay = priceFormat.format(medBoxCost);
      String smBoxDisplay = priceFormat.format(smallBoxCost);
      String totalCostDisplay = priceFormat.format(totalCostOfOrder);
      
      // Format final information display
      String purchaseOrder = "Customer Name:     " + customerName + "\n"
                           + "Date of Order:      " + purchaseDate + "\n"
                           + "Date of Arrival:    " + deliveryDate + "\n"
                           + "Number of Bags Ordered: " + bagsCoffee
                           + " . . . " + coffeeCostDisplay + "\n"
                           + "Boxes Used:\n"
                           + "                     " + numberLargeBoxes + " Large"
                           + " . . . . . . . .  " + lgBoxDisplay + "\n"
                           + "                     " + numberMedBoxes + " Medium" 
                           + " . . . . . .   " + medBoxDisplay + "\n"
                           + "                     " + numberSmallBoxes + " Small"
                           + " . . . . . . . .  " + smBoxDisplay + "\n"
                           + "Total Order Cost: . . . . . . . . . .  "
                           + totalCostDisplay + "\n"
                           + "Thank you for your JavaLumen Corporation coffee" 
                           + " purchase!";
      
      // Print all order information
      JOptionPane.showMessageDialog(null, purchaseOrder);
      
   }//main
}//class CoffeePurchase