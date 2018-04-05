import java.util.*;
public class NumSum {
    public static void main(String [] args){
        int inputSum = 0;
        int currentNumber = 0;
        int counter = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Gimme some numbers, yo");
        do {
            currentNumber = in.nextInt();
            inputSum += currentNumber;
            counter++;
        } while(currentNumber != -1);
        
        System.out.println("Sum: " + inputSum);
        System.out.println("Average: " + (inputSum/counter));
    }
}