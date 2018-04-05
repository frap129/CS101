import java.util.*;
import java.io.*;

public class ReadFromFile {
    public static void main(String [] args) throws Exception
    {
       File inFile = new File(args[0]);
       Scanner fileScan = new Scanner(inFile);
       final int SENTINEL = 0;
       
       int num = fileScan.nextInt();
       
       while (num != SENTINEL) {
           System.out.println(num);
           num = fileScan.nextInt();

       }
    }
}