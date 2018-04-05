/*
    Data Table for Class Faculty		
Variable or Constant	Type	Purpose
officeHours         	String	Hours in office
*/
public class Faculty extends Employee {
    private String officeHours;

    /*
        Data Table for Faculty(name:String, address:String, phoneNumber:String, email:String, date:Date, title:String, office:String, salary:double, officeHours:String)		
    Variable or Constant	Type	Purpose
    name                	String	Persons name
    address             	String	Persons address
    phoneNumber         	String	Persons number
    email	                String	Persons email
    hiringDate           	Date	Date employee was hired
    title	                String	Job title
    office	                String	The office they work in
    salary	                double	Employee’s salary
    officeHours         	String	Hours in office
    */
    public Faculty(String name, String address, String phoneNumber, String email,
                        String office, double salary, Date hiringDate, String title, String officeHours){
        super(name, address, phoneNumber, email, office, salary, hiringDate, title);
        setOfficeHours(officeHours);
    }
    
    public String getOfficeHours(){
        return officeHours;
    }
    
    /*
        Data Table for setOfficeHours()		
    Variable or Constant	Type	Purpose
    officeHours         	String	Hours in office
    */
    private void setOfficeHours(String officeHours){
        this.officeHours = officeHours;
    }
    
    /*
        Data Table for toString()		
    Variable or Constant	Type	Purpose
    faculty	                String	The object as a string
    */
    /*
    toString() 
        String staff equals "Staff\n"
        staff += super.toString()
        staff += "\tsupervisor: " + supervisor + "\n"
        return staff
    */
    public String toString(){
        String faculty = "Faculty\n";
        faculty += super.toString();
        faculty += "\toffice hours: " + officeHours + "\n";
        return faculty;
    }
}