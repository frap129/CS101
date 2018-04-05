/*
    Data Table for Class Student		
Variable or Constant	Type	Purpose
status              	Date	Students status
*/
public class Student extends Person {
    private char status;
    
    /*
        Data Table for Student(name:String, address:String, phoneNumber:String, email:String, date:Date, status:char)		
    Variable or Constant	Type	Purpose
    name                	String	Persons name
    address             	String	Persons address
    phoneNumber         	String	Persons number
    email	                String	Persons email
    birthDate           	Date	A critical date
    status	                char	Students status
    */
    public Student(String name, String address, String phoneNumber,
                         String email, Date birthDate, char status){
        super(name, address, phoneNumber, email, birthDate);
        setStatus(status);
    }
    
    public char getStatus(){
        return status;
    }
    
    /*
        Data Table for setStatus()		
    Variable or Constant	Type	Purpose
    status	                char	Students status
    */
    private void setStatus(char status){
        this.status = status;
    }

    /*
    Data Table for toString()		
    Variable or Constant	Type	Purpose
    student	                String	The object as a string
    statusString	        String	Status as a full word
    */
    /*
    toString() 
        String student
        String statusString
        switch (status) :
            case 'f':
                statusString equals "freshmen"
                break
            case 's':
                statusString equals "sophomore"
                break
            case 'j':
                statusString equals "junior"
                break
            case 'r':
                statusString equals "senior"
                break
            case 'm':
                statusString equals "masters"
                break
            case 'd':
                statusString equals "doctorate"
                break
            default:
                statusString equals "Invalid status!"
        student equals super.toString()
        student += "\tbirth date: " + date.toString() + "\n"
        student += "\tstatus: " + statusString + "\n"
        return student

    */
    public String toString(){
        String student;
        String statusString;
        switch(status){
            case 'f':
                statusString = "freshmen";
                break;
            case 's':
                statusString = "sophomore";
                break;
            case 'j':
                statusString = "junior";
                break;
            case 'r':
                statusString = "senior";
                break;
            case 'm':
                statusString = "masters";
                break;
            case 'd':
                statusString = "doctorate";
                break;
            default:
                statusString = "Invalid status!";
        }
        student = super.toString();
        student += "\tbirth date: " + date.toString() + "\n";
        student += "\tstatus: " + statusString + "\n";
        return student;
    }    
}