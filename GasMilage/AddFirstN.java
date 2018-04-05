public class AddFirstN {
   // fuck psudocode
   
   public static void  main(String[] args) {
      int n = 8;
      int sum = 0;
   
      for(int i = 1; i <= n; i++) {
         sum = sum + i;
      }
      
      System.out.print("Sum of first " + n + " numbers: " + sum);
   }
}