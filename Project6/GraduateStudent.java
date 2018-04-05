/*
    Data Table for Class GraduateStudent		
Variable or Constant	Type	Purpose
assistantshipType     	char	Students assistantship
*/
public class GraduateStudent extends Student {
    private char assistantshipType;

    /*
        Data Table for GraduateStudent(name:String, address:String, phoneNumber:String, email:String, date:Date, status:char. AssistantshipType:char)		
    Variable or Constant	Type	Purpose
    name	                String	Persons name
    address             	String	Persons address
    phoneNumber         	String	Persons number
    email	                String	Persons email
    birthDate           	Date	A critical date
    status	                char	Students status
    assistantshipType   	char	Students assistantship
    */
    public GraduateStudent(String name, String address, Date birthDate, String phoneNumber, String email,
                                char status, char assistantshipType){
        super(name, address, phoneNumber, email, birthDate, status);
        setAssistantshipType(assistantshipType);
    }
    
    public char getAssistantshipType(){
        return assistantshipType;
    }
    
    /*
        Data Table for setAssistantshipType(assistantshipType:String)		
    Variable or Constant	Type	Purpose
    assistantshipType   	String	Students assistantship
    */
    private void setAssistantshipType(char assistantshipType){
        this.assistantshipType = assistantshipType;
    }
    
    /*
        Data Table for toString()		
    Variable or Constant	Type	Purpose
    student             	String	The object as a string
    assistantshipString 	String	Students assistantship as a full word
    */
    /*
    toString() 
        String assistantshipString
        switch (assistantshipType) :
            case 't':
                assistantshipString equals "teaching"
                break
            case 'r':
                assistantshipString equals "research"
                break
            default:
                assistantshipString equals "Invalid status!"
        String graduate equals "Graduate student\n"
        graduate += super.toString()
        graduate += "\tassistantship type: " + assistantshipString + "\n"
        return graduate

    */
    /*
    toString() 
        NumberFormat money equals NumberFormat.getCurrencyInstance()
        String employee
        employee equals super.toString()
        employee += "\ttitle: " + title + "\n"
        employee += "\toffice: " + office + "\n"
        employee += "\tsalary: " + money.format(salary) + "\n"
        employee += "\thiring date: " + date.toString() + "\n"
        return employee

    */
    public String toString(){
        String assistantshipString;
        switch(assistantshipType){
            case 't':
                assistantshipString = "teaching";
                break;
            case 'r':
                assistantshipString = "research";
                break;
            default:
                assistantshipString = "Invalid status!";
        }
        String graduate = "Graduate student\n";
        graduate += super.toString();
        graduate += "\tassistantship type: " + assistantshipString + "\n";
        return graduate;
    }
}