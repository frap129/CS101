import java.text.NumberFormat;

/*
    Data Table for Class Employee		
Variable or Constant	Type	Purpose
title	                String	Job title
office	                String	The office they work in
salary	                double	Employee’s salary
*/
public class Employee extends Person {
    private String title;
    private String office;
    private double salary;
    
    /*
        Data Table for Employee(name:String, address:String, phoneNumber:String, email:String, date:Date, title:String, office:String, salary:double)		
    Variable or Constant	Type	Purpose
    name                	String	Persons name
    address             	String	Persons address
    phoneNumber         	String	Persons number
    email	                String	Persons email
    hiringDate           	Date	Date employee was hired
    title	                String	Job title
    office	                String	The office they work in
    salary	                double	Employee’s salary
    */
    public Employee(String name, String address, String phoneNumber, String email,
                        String office, double salary, Date hiringDate, String title){
        super(name, address, phoneNumber, email, hiringDate);
        setTitle(title);
        setOffice(office);
        setSalary(salary);
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getOffice(){
        return office;
    }
    
    public double getSalary(){
        return salary;
    }
    
    /*
        Data Table for setTitle()		
    Variable or Constant	Type	Purpose
    title               	String	Job title
    */
    private void setTitle(String title){
        this.title = title;
    }
    
    /*
        Data Table for setOffice()		
    Variable or Constant	Type	Purpose
    office	                String	The office they work in
    */
    private void setOffice(String office){
        this.office = office;
    }
    
    /*
        Data Table for setSalary()		
    Variable or Constant	Type	Purpose
    salary              	double	Employee’s salary
    */
    private void setSalary(double salary){
        this.salary = salary;
    }
    
    /*
        Data Table for toString()		
    Variable or Constant	Type	Purpose
    employee	            String	The object as a string
    money	                NumberFormat	To format the salary
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
        return employe
    */
    public String toString(){
        NumberFormat money = NumberFormat.getCurrencyInstance();
        String employee;
        employee = super.toString();
        employee += "\ttitle: " + title + "\n";
        employee += "\toffice: " + office + "\n";
        employee += "\tsalary: " + money.format(salary) + "\n";
        employee += "\thiring date: " + date.toString() + "\n";
        return employee;
    }
}