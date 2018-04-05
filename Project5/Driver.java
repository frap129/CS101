import java.util.*;
import java.io.*;

/*
        Data Table for Class Driver		
Variable or Constant	Type	    Purpose
sets	                Set[]	    The 100 sets the driver handles
file	                Scanner 	Scan the input file
printer	                PrintStream	Write to the output file
*/
public class Driver {
    public static Set[] sets;
    public static PrintStream printer;
    public static Scanner file;
    
    /*
    main(String[] args) throws Exception 
        File inFile equals new File(args[0])
        File outFile equals new File(args[1])
        file equals new Scanner(inFile)
        printer equals new PrintStream(outFile)
        sets equals Set[0..98]
        while (file.hasNext()) 
            nextCommand()
    */
    /*
            Data table for main(args:String [])		
    Variable or Constant	Type	    Purpose
    inFile	                File	    input file
    outFile	                File	    output file
    file	                Scanner	    Scan the input file
    printer	                PrintStream	Write to the output file
    */
    public static void main(String [] args) throws Exception {
         File inFile = new File(args[0]);
         File outFile = new File(args[1]);
         file = new Scanner(inFile);
         printer = new PrintStream(outFile);
         sets = new Set[100];       
         while (file.hasNext()){
            nextCommand();
         }
    }
    
    /*
    nextCommand() 
        String first equals file.next()
        cmd equals first.charAt(0)
        switch (cmd) :
            case 'C':
                construct()
                break
            case 'I':
                isEmpty()
                break
            case 'S':
                size()
                break
            case 'X':
                empty()
                break
            case 'A':
                add()
                break
            case 'R':
                remove()
                break
            case 'F':
                find()
                break
            case 'U':
                union()
                break
            case 'N':
                intersect()
                break
            case 'D':
                difference()
                break
            case 'P':
                print()
                break
            case 'M':
                create()
                break
            case '#':
                message(first)
                break
            default:
                print to file ("Invalid command!")
    */
    /*
            Data Table for nextCommand()		
    Variable or Constant	Type	Purpose
    first	                String	The first string of a command
    cmd	                    char	The first letter of the command string
    */
    public static void nextCommand() {
        String first = file.next();
        char cmd = first.charAt(0);
        switch(cmd){
            case 'C':
                construct();
                break;
            case 'I':
                isEmpty();
                break;
            case 'S':
                size();
                break;
            case 'X':
                empty();
                break;
            case 'A':
                add();
                break;
            case 'R':
                remove();
                break;
            case 'F':
                find();
                break;
            case 'U':
                union();
                break;
            case 'N':
                intersect();
                break;
            case 'D':
                difference();
                break;
            case 'P':
                print();
                break;
            case 'M':
                create();
                break;
            case '#':
                message(first);
                break;
            default:
                printer.println("Invalid command!");
            }
    }
    
    /*
    construct() 
        slot equals file.nextInt()
        sets[slot] equals new Set()
        print to file ("Set " plus slot plus " has been constructed.")
    */
    /*
            Data Table for construct()		
    Variable or Constant	Type	Purpose
    slot	                int	    Slot (index) in the sets array
    sets	                Set[]	The 100 sets the driver handles
    */
    public static void construct(){
        int slot = file.nextInt();
        sets[slot] = new Set();
        printer.println("Set " + slot + " has been constructed.");
        
    }
    
    /*
    isEmpty() 
        slot equals file.nextInt()
        if (sets[slot] equals null)
            print to file ("Set " plus slot plus " does not exist!")
        else if (sets[slot].isEmpty())
            print to file ("Set " plus slot plus " is empty.")
        else
            print to file ("Set " plus slot plus " is not empty.")
    */
    /*
            Data Table for isEmpty()		
    Variable or Constant	Type	Purpose
    slot	                int	    Slot (index) in the sets array
    */
    public static void isEmpty(){
        int slot = file.nextInt();
        if (sets[slot] == null)
            printer.println("Set " + slot + " does not exist!");
        else if (sets[slot].isEmpty())
            printer.println("Set " + slot + " is empty.");
        else
            printer.println("Set " + slot + " is not empty.");
    }
    
    /*
    size() 
        slot equals file.nextInt()
        if (sets[slot] equals null)
            print to file ("Set " plus slot plus " does not exist, it has no size.")
        else if (sets[slot].isEmpty())
            print to file ("Set " plus slot plus " is empty.")
        else
            print to file ("Set " plus slot plus " is " plus sets[slot].size() plus " elements long.")
    */
    /*
            Data Table for size()		
    Variable or Constant	Type	Purpose
    slot                	int 	Slot (index) in the sets array
    */
    public static void size(){
        int slot = file.nextInt();
        if (sets[slot] == null)
            printer.println("Set " + slot + " does not exist, it has no size.");
        else
            printer.println("Set " + slot + " is " + sets[slot].size() + " elements long.");
    }

    /*
    empty() 
        slot equals file.nextInt()
        if (sets[slot] equals null)
            print to file ("Cannot empty set " plus slot plus " that doesn't exsit!")
        else
            sets[slot].makeEmpty()
            print to file ("Set " plus slot plus " has been emptied.")
    */
    /*
           Data Table for empty()		
    Variable or Constant	Type	Purpose
    slot	                int	    Slot (index) in the sets array
    */
    public static void empty(){
        int slot = file.nextInt();
        if (sets[slot] == null)
            printer.println("Cannot empty set " + slot + " that doesn't exsit!");
        else {
            sets[slot].makeEmpty();
            printer.println("Set " + slot + " has been emptied.");
        }
    }
    
    /*
    add() 
        slot equals file.nextInt()
        element equals file.nextInt()
        if (sets[slot] equals null)
            print to file ("No set to add value to!")
        else
            sets[slot].add(element)
    */
    /*
            Data Table for add()		
    Variable or Constant	Type	Purpose
    slot                	int	    Slot (index) in the sets array
    element             	int	    Element inside the selected set
    */
    public static void add(){
        int slot = file.nextInt();
        int element = file.nextInt();
        if (sets[slot] == null)
            printer.println("No set to add value to!");
        else
            sets[slot].add(element);
    }
    
    /*
    remove() 
        slot equals file.nextInt()
        element equals file.nextInt()
        if (sets[slot] equals null)
            print to file ("No set to remove value from!")
        else
            sets[slot].remove(element)
    */
    /*
            Data Table for remove()		
    Variable or Constant	Type	Purpose
    slot	                int	    Slot (index) in the sets array
    element	                int	    Element inside the selected set
    */
    public static void remove(){
        int slot = file.nextInt();
        int element = file.nextInt();
        if (sets[slot] == null)
            printer.println("No set to remove value from!");
        else
        sets[slot].remove(element);
    }
    
    /*
    find() 
        slot equals file.nextInt()
        element equals file.nextInt()
        if (sets[slot] equals null)
            print to file ("No set in which to find value.")
        else if (sets[slot].elementOf(element))
            print to file (element plus " is a part of set " plus slot)
        else
            print to file (element plus " is not a part of set " plus slot)
    */
    /*
            Data Table for find()		
    Variable or Constant	Type	Purpose
    slot	                int	    Slot (index) in the sets array
    element	                int	    Element inside the selected set
    */
    public static void find(){
        int slot = file.nextInt();
        int element = file.nextInt();
        if (sets[slot] == null)
            printer.println("No set in which to find value.");
        else if (sets[slot].elementOf(element))
            printer.println(element + " is a part of set " + slot);
        else
            printer.println(element + " is not a part of set " + slot);
    }
    
    /*
    union() 
        set1 equals file.nextInt()
        set2 equals file.nextInt()
        set3 equals file.nextInt()
        if (sets[set1] equals null OR sets[set2] equals null)
            print to file ("Cannot join a nonexistent set!")
        else
            sets[set3] equals sets[set1].union(sets[set2])
    */
    /*
            Data Table for union()		
    Variable or Constant	Type	Purpose
    set1                	int	    First set to join
    set2                	int	    Second set to join
    set3                 	int	    Set to contain the union
    sets                	Set[]	The 100 sets the driver handles
    */
    public static void union(){
        int set1 = file.nextInt();
        int set2 = file.nextInt();
        int set3 = file.nextInt();
        if (sets[set1] == null || sets[set2] == null)
            printer.println("Cannot join a nonexistent set!");
        else
            sets[set3] = sets[set1].union(sets[set2]);            
    }
    
    /*
    intersect() 
        set1 equals file.nextInt()
        set2 equals file.nextInt()
        set3 equals file.nextInt()
        if (sets[set1] equals null OR sets[set2] equals null)
            print to file ("Cannot intersect a nonexistent set!")
        else
            sets[set3] equals sets[set1].intersection(sets[set2])
    */
    /*
            Data Table for intersect()		
    Variable or Constant	Type	Purpose
    set1                	int	    First set to intersect
    set2                	int	    Second set to intersect
    set3                 	int	    Set to contain the intersection
    sets                	Set[]	The 100 sets the driver handles
    */
    public static void intersect(){
        int set1 = file.nextInt();
        int set2 = file.nextInt();
        int set3 = file.nextInt();
        if (sets[set1] == null || sets[set2] == null)
            printer.println("Cannot intersect a nonexistent set!");
        else
            sets[set3] = sets[set1].intersection(sets[set2]);            
    }
    
    /*
    difference() 
        set1 equals file.nextInt()
        set2 equals file.nextInt()
        set3 equals file.nextInt()
        if (sets[set1] equals null OR sets[set2] equals null)
            print to file ("Cannot find difference a nonexistent set!")
        else
            sets[set3] equals sets[set1].setDifference(sets[set2])
    */
    /*
        Data Table for difference()		
    Variable or Constant	Type	Purpose
    set1	                int	    First set to find difference
    set2	                int	    Second set to find difference
    set3 	                int	    Set to contain the differences
    sets	                Set[]	The 100 sets the driver handles
    */
    public static void difference(){
        int set1 = file.nextInt();
        int set2 = file.nextInt();
        int set3 = file.nextInt();
        if (sets[set1] == null || sets[set2] == null)
            printer.println("Cannot find difference a nonexistent set!");
        else
            sets[set3] = sets[set1].setDifference(sets[set2]);            
    }
    
    /*
    print() 
        slot equals file.nextInt()
        if (sets[slot] equals null)
            print to file ("Cannot print set " plus slot plus " that does not exist!")
        else
            print to file (sets[slot].toString())
    */
    /*
            Data Table for print()		
    Variable or Constant	Type	Purpose
    slot                	int	    Slot (index) in the sets array
    */
    public static void print(){
        int slot = file.nextInt();
        if (sets[slot] == null)
            printer.println("Cannot print set " + slot + " that does not exist!");
        else
            printer.println(sets[slot].toString());
    }
    
    /*
    create() 
        slot equals file.nextInt()
        sets[slot] equals new Set()
        while (file.hasNextInt()) 
            sets[slot].add(file.nextInt())
    */
    /*
            Data Table for is create()		
    Variable or Constant	Type	Purpose
    slot                	int	    Slot (index) in the sets array
    sets                	Set[]	The 100 sets the driver handles
    */
    public static void create(){
        int slot = file.nextInt();    
        sets[slot] = new Set();
        while (file.hasNextInt()){
          sets[slot].add(file.nextInt());
        }
    }
    
    /*
    message(String first) 
        print to file (first plus file.nextLine())
    */
    /*
            Data Table for message(first:String)		
    Variable or Constant	Type	Purpose
    first	                String	First part of message
    */
    public static void message(String first){
        printer.println(first + file.nextLine());
    }
}