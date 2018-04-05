public class UndergraduateStudent extends Student {

    /*
        Data Table for UndergraduateStudent(name:String, address:String, phoneNumber:String, email:String, date:Date, status:char)		
    Variable or Constant	Type	Purpose
    name	                String	Persons name
    address             	String	Persons address
    phoneNumber         	String	Persons number
    email	                String	Persons email
    birthDate            	Date	A critical date
    status	                char	Students status
    */
    public UndergraduateStudent(String name, String address, String phoneNumber, String email,
                                    Date birthDate, char status){
        super(name, address, phoneNumber, email, birthDate, status);
    }
    
    /*
        Data Table for toString()		
    Variable or Constant	Type	Purpose
    student             	String	The object as a string
    */
    /*
    toString() 
        String undergrad equals "Undergraduate Student\n"
        undergrad += super.toString()
        return undergrad
    */
    public String toString(){
        String undergrad = "Undergraduate Student\n";
        undergrad += super.toString();
        return undergrad;
    }
}