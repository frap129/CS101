/*
        Data Table for Class Person		
Variable or Constant	Type	Purpose
name                	String	Persons name
address             	String	Persons address
phoneNumber         	String	Persons number
email	                String	Persons email
date 	                Date	A critical date
*/
public class Person {
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected String email;
    protected Date date;

    /*
        Data Table for Person(name:String, address:String, phoneNumber:String, email:String, date:Date)		
    Variable or Constant	Type	Purpose
    name	                String	Persons name
    address	                String	Persons address
    phoneNumber         	String	Persons number
    email	                String	Persons email
    date 	                Date	A critical date
    */
    public Person(String name, String address, String phoneNumber, String email, Date date){
        setName(name);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setDate(date);
    }
    
    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public String getEmail(){
        return email;
    }
    
    public Date getDate(){
        return date;
    }
    
    /*
        Data Table for setName()		
    Variable or Constant	Type	Purpose
    name                	int 	Persons name
    */
    protected void setName(String name){
        this.name = name;
    }
    
    /*
        Data Table for setAddress()		
    Variable or Constant	Type	Purpose
    address             	String	Persons address
    */
    protected void setAddress(String address){
        this.address = address;
    }

    /*
        Data Table for setPhoneNumber()		
    Variable or Constant	Type	Purpose
    phoneNumber         	String	Persons number
    */
    protected void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    /*
        Data Table for setEmail()		
    Variable or Constant	Type	Purpose
    email	                String	Persons email
    */
    protected void setEmail(String email){
        this.email = email;
   }
    
   /*
       Data Table for setDate()		
    Variable or Constant	Type	Purpose
    date 	                Date	A critical date
    */ 
    protected void setDate(Date date){
        this.date = date;
    }

    /*
        Data Table for toString()		
    Variable or Constant	Type	Purpose
    person              	String	The object as a string
    */
    /*
    toString() 
        String person
        person equals "\tname: " + name + "\n"
        person += "\taddress: " + address + "\n"
        person += "\tphone number: " + phoneNumber + "\n"
        person += "\temail: " + email + "\n"
        return person
    */
    public String toString(){
        String person;
        person = "\tname: " + name + "\n";
        person += "\taddress: " + address + "\n";
        person += "\tphone number: " + phoneNumber + "\n";
        person += "\temail: " + email + "\n";
        return person;
    }
}