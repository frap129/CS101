import java.util.*;
public class Oct17th {

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 3 values: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        String sorted;
        
        if (a < b) {
            if (a < c) 
                if (b < c)
                    sorted = a + " " + b + " " + c;
                else 
                    sorted = a + " " + c + " " + b;
             else
                sorted = c + " " + a + " " + b;
            
        } else {
            if (a < c)
                sorted = b + " " + a + " " + c;
            else
                if (b < c)
                    sorted = b + " " + c + " " + a;
                else 
                    sorted = c + " " + b + " " + a;
        }
        System.out.println(sorted);
    }
    
}