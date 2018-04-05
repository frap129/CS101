import java.util.Scanner;

public class Methods {
    public static void main (String [] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String name = letterSwap(line);
        System.out.println(name);
    }
    
    public static String letterSwap(String name) {
        String fnfl = name.substring(0, 1);
        String fnrl = name.substring(1, name.indexOf(" "));
        String lnfl = name.substring(name.indexOf(" ") + 1, name.indexOf(" ") + 2);
        String lnrl = name.substring(name.indexOf(" ") + 2);
        String swapped = lnfl + fnrl + " " + fnfl + lnrl;
        
        return swapped;
    }
}
    
    