import java.util.*;

/*
        Data Table for Class Set
Variable or Constant	Type	Purpose
set	                    int[]	A set of numbers
*/
public class Set {
    private int[] set;
    
    /*
    Set() 
        setSet(new int[0])
    */
    public Set(){
       setSet(new int[0]);
    }
    
    public int[] getSet(){
        return set;
    }
    
    /*
    setSet([] set) 
        this.set equals set
    */
    /*
            Data Table for setSet(set:int[])		
    Variable or Constant	Type	Purpose
    set                 	int[]	A set of numbers
    set	                    int[]	A new set of numbers
    */
    private void setSet(int[] set){
        this.set = set;
    }
    
    /*
    makeEmpty() 
        for element equals set.length - 1 loop till element is greater than or equal to 0 by element - 1 each step 
            remove(set[element])
    */
    /*
            Data Table for makeEmpty()		
    Variable or Constant	Type	Purpose
    element	                int	    An index of the set
    */
    public void makeEmpty(){
        for(int element = set.length - 1; element >= 0; element--){
            remove(set[element]);
        }
    }
    
    /*
    isEmpty() 
        if (set.length equals 0)
            return true
        return false
    */
    public boolean isEmpty(){
        if(set.length == 0)
            return true;
        return false;
    }
    
    /*
    add(add) 
        if (NOT elementOf(add))
            added equals [set.length + 1]
            for element equals 0 loop till element is less than set.length by element + 1 each step 
                added[element] equals set[element]
            added[set.length] equals add
            setSet(added)
            added equals null
    */
    /*
            Data Table for add(add:int)		
    Variable or Constant	Type	Purpose
    add	                    int	    Number to add to set
    added	                int[]	The current set plus the added number
    element	                int	    An index of the set
    */
    public void add(int add){
        if (!elementOf(add)) {
            int[] added = new int[set.length + 1];
            for(int element = 0; element < set.length; element++){
                added[element] = set[element];
            }
            added[set.length] = add;         
            setSet(added);
            added = null;
        }
    }
    
    /*
    remove(rem) 
        if (elementOf(rem))
            Set removed equals new Set()
            for element equals 0 loop till element is less than set.length by element + 1 each step 
                if (set[element] does not equal rem)
                    removed.add(set[element])
            setSet(removed.getSet())
            removed equals null
    */
    /*
            Data Table for remove(rem:int)		
    Variable or Constant	Type	Purpose
    rem	                    int	    Number to remove from set
    removed	                Set	    Set that contains the current set without rem
    element	                int	    An index of the set
    */
    public void remove(int rem){
        if(elementOf(rem)){
            Set removed = new Set();
            for(int element = 0; element < set.length; element++){
                if(set[element] != rem)
                    removed.add(set[element]);
            }
            setSet(removed.getSet());
            removed = null;
        }
    }
    
    /*
    elementOf(value) 
        for element equals 0 loop till element is less than set.length by element + 1 each step 
            if (set[element] equals value)
                return true
        return false
    */
    /*
            Data Table for elementOf(value:int)		
    Variable or Constant	Type	Purpose
    element	                int	    An index of the set
    value	                int	    Value to check for in set
    */
    public boolean elementOf(int value){
        for(int element = 0; element < set.length; element++){
            if(set[element] == value)
                return true;    
        }
        return false;
    }
    
    /*
    size() 
        return set.length
    */
    public int size(){
        return set.length;
    }
    
    /*
    union(Set join) 
        Set newSet equals new Set()
        for element equals 0 loop till element is less than join.size() by element + 1 each step 
            if (NOT elementOf(join.getSet()[element]))
                newSet.add(join.getSet()[element])
        for element equals 0 loop till element is less than set.length by element + 1 each step 
            newSet.add(set[element])
        return newSet
    */
    /*
            Data Table for union(join:Set)		
    Variable or Constant	Type	Purpose
    newSet	                Set	    Set to add union to
    join	                Set	    Set to join with current set
    element	                int	    An index of the set
    */
    public Set union(Set join){
        Set newSet = new Set();
        for(int element = 0; element < join.size(); element++){
            if (!elementOf(join.getSet()[element]))
                newSet.add(join.getSet()[element]);
        }
        for(int element = 0; element < set.length; element++){
                newSet.add(set[element]);
        }
        return newSet;
    }
    
    /*
    intersection(Set intersect) 
        Set newSet equals new Set()
        for element equals 0 loop till element is less than intersect.size() by element + 1 each step 
            if (elementOf(intersect.getSet()[element]))
                newSet.add(intersect.getSet()[element])
        return newSet
    */
    /*
            Data Table for intersection(intersect:Set)		
    Variable or Constant	Type	Purpose
    newSet	                Set	    Set to add intersection to
    intersect              	Set	    Set to intersect with current set
    element	                int	    An index of the set
    */
    public Set intersection(Set intersect){
        Set newSet = new Set();
        for(int element = 0; element < intersect.size(); element++){
            if(elementOf(intersect.getSet()[element]))
                newSet.add(intersect.getSet()[element]);
        }
        return newSet;
    }
    
    /*
    setDifference(Set diff) 
        Set newSet equals new Set()
        for element equals 0 loop till element is less than set.length by element + 1 each step 
            if (NOT diff.elementOf(set[element]))
                newSet.add(set[element])
        return newSet
    */
    /*
            Data Table for setDifference(diff:Set)		
    Variable or Constant	Type	Purpose
    newSet	                Set	    Set to add difference to
    diff	                Set	    Set to find difference with current set
    element	                int	    An index of the set
    */
    public Set setDifference(Set diff){
        Set newSet = new Set();
        for(int element = 0; element < set.length; element++){
               if(!diff.elementOf(set[element]))
                    newSet.add(set[element]);
        }
        return newSet;
    }
    
    /*
    toString() 
        String setString equals "{"
        if not isEmpty
            setString += set[0]
        for element equals 1 loop till element is less than set.length by element + 1 each step 
            setString += "," + set[element]
        setString += "}"
        return setString
    */
    /*
            Data Table for toString()		
    Variable or Constant	Type	Purpose
    setString	            String	The current set as a string
    element	                int	    An index of the set
    */
    public String toString(){
        String setString = "{";
        if (!isEmpty())
             setString += set[0];
        for(int element = 1; element < set.length; element++){
            setString += "," + set[element];
        }
        setString += "}";
        return setString;
    }
}