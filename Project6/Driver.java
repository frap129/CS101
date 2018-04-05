import java.util.*;
import java.io.*;
  
public class Driver {  

   /*
           Data table for main(args:String [])		
    Variable or Constant	Type	Purpose
    inFile              	File	input file
    outFile             	File	output file
    fileScan	            Scanner	Scan the input file
    printer	                PrintStream	Write to the output file
    getLines            	Scanner	Scanner to get the number of lines in inFile
    lines	                int 	Number of lines in inFile
    people	                Person[] The array of persons
    index	                int   	The index of people to set
    line	                String	The current line of input
    data 	                String[] The line of input with each piece of data as a different element
   */
   /*
   main(String[] args) throws IOException 
        File inFile equals new File(args[0])
        Scanner fileScan equals new Scanner(inFile)
        File outFile equals new File(args[1])
        PrintStream printer equals new PrintStream(outFile)
        Scanner getLines equals new Scanner(inFile)
        lines equals 0
        while (getLines.hasNextLine()) 
            lines+ 1
            getLines.nextLine()
        Person[] people equals Person[lines]
        index equals 0
        print to out file ("Project 6")
        print to out file ("Joseph Maples, Computing & Algorithms CS 101-02")
        print to out file ("The next group of outlines is an echo print of the input file\n")
        while (fileScan.hasNextLine()) 
            String line equals fileScan.nextLine()
            print to out file (line)
            String[] data equals line.split("#")
            switch (data[0].charAt(0)) :
                case 'u':
                    people[index] equals new UndergraduateStudent(data[1], data[2], data[3], data[4], new Date(data[5]), data[6].charAt(0))
                    index+ 1
                    break
                case 'g':
                    people[index] equals new GraduateStudent(data[1], data[2], new Date(data[3]), data[4], data[5], data[6].charAt(0), data[7].charAt(0))
                    index+ 1
                    break
                case 'f':
                    people[index] equals new Faculty(data[1], data[2], data[3], data[4], data[5], Double.parseDouble(data[6]), new Date(data[7]), data[8], data[9])
                    index+ 1
                    break
                case 's':
                    people[index] equals new Staff(data[1], data[2], data[3], data[4], data[5], data[6], Double.parseDouble(data[7]), new Date(data[8]), data[9])
                    index+ 1
                    break
        print to out file ("")
        print to out file ("Entire database, sorted by name")
        sortByName(people)
        for index equals 0 loop till index is less than people.length by index+ 1 each step 
            print to out file (people[index].toString())
        print to out file ("Entire staff, sorted by date")
        sortByDate(people)
        for index equals 0 loop till index is less than people.length by index+ 1 each step 
            if (people[index] instanceof Staff)
                print to out file (people[index].toString())
        print to out file ("Every Employee, sorted by salary")
        sortBySalary(people)
        for index equals 0 loop till index is less than people.length by index+ 1 each step 
            if (people[index] instanceof Employee)
                print to out file (people[index].toString())
        print to out file ("Every Graduate student, sorted by address")
        sortByAddress(people)
        for index equals 0 loop till index is less than people.length by index+ 1 each step 
            if (people[index] instanceof GraduateStudent)
                print to out file (people[index].toString())
   */
   public static void main (String [] args)  throws IOException{  
      File inFile = new File(args[0]);
      Scanner fileScan = new Scanner(inFile);
      File outFile = new File(args[1]);
      PrintStream printer = new PrintStream(outFile);
      Scanner getLines = new Scanner(inFile);
      int lines = 0;
      while(getLines.hasNextLine()){
          lines++;
          getLines.nextLine();
      }
      Person[] people = new Person[lines];
      int index = 0;
      printer.println("Project 6");
      printer.println("Joseph Maples, Computing & Algorithms CS 101-02");
      printer.println("The next group of outlines is an echo print of the input file\n");
      while(fileScan.hasNextLine()){
         String line = fileScan.nextLine();
         printer.println(line);
         String[] data = line.split("#");
         
         switch(data[0].charAt(0)){
            case 'u':
               people[index] = new UndergraduateStudent(data[1], data[2], data[3], data[4], new Date(data[5]), data[6].charAt(0));
               index++;
               break;
               
            case 'g':
               people[index] = new GraduateStudent(data[1], data[2], new Date(data[3]), data[4], data[5], data[6].charAt(0), data[7].charAt(0));
               index++;
               break;
            case 'f':
               people[index] = new Faculty(data[1], data[2], data[3], data[4], data[5], Double.parseDouble(data[6]), new Date(data[7]), data[8], data[9]);
               index++;
               break;
            case 's':
               people[index] = new Staff(data[1], data[2], data[3], data[4], data[5], data[6], Double.parseDouble(data[7]), new Date(data[8]), data[9]);
               index++;
               break;
         }
      }

      printer.println("");
      printer.println("Entire database, sorted by name");
      sortByName(people);
      for (index = 0; index < people.length; index++){   
         printer.println(people[index].toString());
      }  
      
      printer.println("Entire staff, sorted by date");
      sortByDate(people);
      for (index = 0; index < people.length; index++){   
         if (people[index] instanceof Staff){  
            printer.println(people[index].toString());
         }  
      }  
      
      printer.println("Every Employee, sorted by salary");
      sortBySalary(people);
      for (index = 0; index < people.length; index++){   
         if (people[index] instanceof Employee){  
            printer.println(people[index].toString());
         }    
      }  
      
      printer.println("Every Graduate student, sorted by address");
      sortByAddress(people);
      for (index = 0; index < people.length; index++){ 
        if (people[index] instanceof GraduateStudent){  
            printer.println(people[index].toString()); 
        } 
      } 
   }
   
   /*
           Data Table for sortByName(array: Person[])		
    Variable or Constant	Type    	Purpose
    array                  	Person[]	The array of persons
    size	                int	        Size of the array
    index               	int	        The index of people to check
    minIndex            	int	        index of the lowest element
    index2	                int	        The index of people to check in inner for loop
    temp	                Person	    Person to swap
   */
   /*
   sortByName(Person[] array) 
        size equals array.length
        for index equals 0 loop till index is less than size - 1 by index+ 1 each step 
            minIndex equals index
            for index2 equals index + 1 loop till index2 is less than size by index2+ 1 each step 
                if (array[index2].getName().compareTo(array[minIndex].getName()) is less than 0)
                    minIndex equals index2
            Person temp equals array[minIndex]
            array[minIndex] equals array[index]
            array[index] equals temp
    */
   public static void sortByName(Person[] array){
      int size = array.length;
      for (int index = 0; index < size-1; index++){
          int minIndex = index;
          for (int index2 = index+1; index2 < size; index2++)
              if (array[index2].getName().compareTo(array[minIndex].getName()) < 0)
                  minIndex = index2;
          Person temp = array[minIndex];
          array[minIndex] = array[index];
          array[index] = temp;
      }
   }
   
   /*
           Data Table for sortByDate(array: Person[])		
    Variable or Constant	Type	Purpose
    array	            Person[]	The array of persons
    size	                int 	Size of the array
    index	                int 	The index of people to check
    minIndex	            int 	index of the lowest element
    index2	                int	    The index of people to check in inner for loop
    temp	                Person	Person to swap
   */
   /*
   sortByDate(Person[] array) 
        size equals array.length
        for index equals 0 loop till index is less than size - 1 by index+ 1 each step 
            minIndex equals index
            for index2 equals index + 1 loop till index2 is less than size by index2+ 1 each step 
                if (array[index2].getDate().compareTo(array[minIndex].getDate()) is less than 0)
                    minIndex equals index2
            Person temp equals array[minIndex]
            array[minIndex] equals array[index]
            array[index] equals temp

   */
   public static void sortByDate(Person[] array){
      int size = array.length;
      for (int index = 0; index < size-1; index++){
          int minIndex = index;
          for (int index2 = index+1; index2 < size; index2++)
              if (array[index2].getDate().compareTo(array[minIndex].getDate()) < 0)
                  minIndex = index2;
          Person temp = array[minIndex];
          array[minIndex] = array[index];
          array[index] = temp;
      }
   }
   
   /*
           Data Table for sortBySalary(array: Person[])		
    Variable or Constant	Type	Purpose
    array               Person[]	The array of persons
    employees	            int[]	Array containing the indexes of people that are employees
    index	                int	    The index of people to check
    minIndex	            int	    index of the lowest element
    index2	                int 	The index of people to check in inner for loop
    temp	                Person	Person to swap
   */
   /*
   sortBySalary(Person[] array) 
        [] employees equals employeeIndicies(array)
        for index equals 0 loop till index is less than employees.length - 1 by index+ 1 each step 
            minIndex equals employees[index]
            for index2 equals index + 1 loop till index2 is less than employees.length by index2+ 1 each step 
                if (((Employee) array[employees[index2]]).getSalary() is less than ((Employee) array[minIndex]).getSalary())
                    minIndex equals employees[index2]
            Person temp equals array[minIndex]
            array[minIndex] equals array[employees[index]]
            array[employees[index]] equals temp

   */
   public static void sortBySalary(Person[] array){
      int[] employees = employeeIndicies(array);
      for (int index = 0; index < employees.length-1; index++){
          int minIndex = employees[index];
          for (int index2 = index+1; index2 < employees.length; index2++)
              if (((Employee) array[employees[index2]]).getSalary() < ((Employee) array[minIndex]).getSalary())
                  minIndex = employees[index2];
          Person temp = array[minIndex];
          array[minIndex] = array[employees[index]];
          array[employees[index]] = temp;
      }
   }
   /*
           Data Table for sortByAddress(array: Person[])		
    Variable or Constant	Type	Purpose
    array           	Person[]	The array of persons
    size	                int	    Size of the array
    index               	int	    The index of people to check
    minIndex            	int	    index of the lowest element
    index2	                int	    The index of people to check in inner for loop
    temp	                Person	Person to swap
   */
   /*
   sortByAddress(Person[] array) 
        size equals array.length
        for index equals 0 loop till index is less than size - 1 by index+ 1 each step 
            minIndex equals index
            for index2 equals index + 1 loop till index2 is less than size by index2+ 1 each step 
                if (array[index2].getAddress().compareTo(array[minIndex].getAddress()) is less than 0)
                    minIndex equals index2
            Person temp equals array[minIndex]
            array[minIndex] equals array[index]
            array[index] equals temp
   */
   public static void sortByAddress(Person[] array){
      int size = array.length;
      for (int index = 0; index < size-1; index++){
          int minIndex = index;
          for (int index2 = index+1; index2 < size; index2++)
              if (array[index2].getAddress().compareTo(array[minIndex].getAddress()) < 0)
                  minIndex = index2;
          Person temp = array[minIndex];
          array[minIndex] = array[index];
          array[index] = temp;
      }
   }
   
   /*
           Data Table for employeeIndicies(array: Person[])		
    Variable or Constant	Type	Purpose
    array           	Person[]	The array of persons
    indexString	            String	String that contains all indicies that are employees
    index	                int 	The index of people to check
    indicies	        String[]	Array that contains all indicies that are employees
    element	                int	    The index of people to check
    employees	            int[]	Array that contains all indicies that are employees
   */
   /*
   employeeIndicies(Person[] array) 
        String indexString equals ""
        for index equals 0 loop till index is less than array.length by index+ 1 each step 
            if (array[index] instanceof Employee)
                indexString += index + ","
        String[] indicies equals indexString.split(",")
        [] employees equals [0..indicies.length-1]
        for element equals 0 loop till element is less than indicies.length by element+ 1 each step 
            employees[element] equals Integer.parseInt(indicies[element])
        return employees
   */
   public static int[] employeeIndicies(Person[] array){
      String indexString = "";
      for (int index = 0; index < array.length; index++){   
         if (array[index] instanceof Employee){  
            indexString += index + ",";
         }    
      }
      String[] indicies = indexString.split(",");
      int[] employees = new int[indicies.length];
      for (int element = 0; element < indicies.length; element++){    
         employees[element] = Integer.parseInt(indicies[element]);
      }
      return employees;
   }
}

