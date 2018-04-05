/*
        Data Table for Class Staff		
Variable or Constant	Type	Purpose
supervisor	            String	Employee’s supervisor
*/
public class Staff extends Employee {
    private String supervisor;

    /*
        Data Table for Staff(name:String, address:String, phoneNumber:String, email:String, date:Date, title:String, office:String, salary:double, supervisor:String)		
    Variable or Constant	Type	Purpose
    name	                String	Persons name
    address             	String	Persons address
    phoneNumber         	String	Persons number
    email	                String	Persons email
    hiringDate           	Date	Date employee was hired
    title	                String	Job title
    office	                String	The office they work in
    salary	                double	Employee’s salary
    supervisor          	String	Employee’s supervisor
    */
    public Staff(String name, String address, String title, String phoneNumber, String email,
                        String office, double salary, Date hiringDate, String supervisor){
        super(name, address, phoneNumber, email, office, salary, hiringDate, title);
        setSupervisor(supervisor);
    }
    
    public String getSupervisor(){
        return supervisor;
    }
    
    /*
        Data Table for setSupervisor()		
    Variable or Constant	Type	Purpose
    supervisor          	String	Employee’s supervisor
    */
    private void setSupervisor(String supervisor){
        this.supervisor = supervisor;
    }
    
    /*
        Data Table for toString()		
    Variable or Constant	Type	Purpose
    staff	                String	The object as a string
    */
    /*
    toString() 
        String faculty equals "Faculty\n"
        faculty += super.toString()
        faculty += "\toffice hours: " + officeHours + "\n"
        return faculty
    */
    public String toString(){
        String staff = "Staff\n";
        staff += super.toString();
        staff += "\tsupervisor: " + supervisor + "\n";
        return staff;
    }
}