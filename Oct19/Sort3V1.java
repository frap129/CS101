import java.util.*;

public class Sort3V1 {
    public static void main (String [] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[3];
        a[0] = in.nextInt();
        a[1] = in.nextInt();
        a[2] = in.nextInt();
        
        Arrays.sort(a);
                
        System.out.print(a[0] + " " + a [1] + " " + a[2]);
    }
}