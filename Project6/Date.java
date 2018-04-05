/*
    Data Table for Class Date		
Variable or Constant	Type	Purpose
day 	                int 	The day
month               	int	    The month
year	                int	    The year
*/
public class Date {
    private int day;
    private int month;
    private int year;
    
    public Date(String date){
        setDay(date.substring(3, 5));
        setMonth(date.substring(0,2));
        setYear(date.substring(6));
    }
    
    public int getDay(){
        return day;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getYear(){
        return year;
    }
    
    private void setDay(String day){
        this.day = Integer.parseInt(day);
    }
    
    private void setMonth(String month){
        this.month = Integer.parseInt(month);
    }
    
    private void setYear(String year){
        this.year = Integer.parseInt(year);
    }
    
    public int compareTo(Date date){
        if (year != date.getYear())
            return year - date.getYear();
        else if (month != date.getMonth())
            return month - date.getMonth();
        else
            return day - date.getDay();
    }
    
    /*
            Data Table for toString()		
    Variable or Constant	Type	Purpose
    date	                String	The date object as a string
    */
    /*
    toString() 
        String date
        switch (month) :
            case 1:
                date equals "January "
                break
            case 2:
                date equals "February "
                break
            case 3:
                date equals "March "
                break
            case 4:
                date equals "April "
                break
            case 5:
                date equals "May "
                break
            case 6:
                date equals "June "
                break
            case 7:
                date equals "July "
                break
            case 8:
                date equals "August "
                break
            case 9:
                date equals "September "
                break
            case 10:
                date equals "October "
                break
            case 11:
                date equals "November "
                break
            case 12:
                date equals "December "
                break
            default:
                return "Invalid month!"
        date += day + ", " + year
        return date

    */
    public String toString(){
        String date;
        
        switch(month){
            case 1:
                date = "January ";
                break;
            case 2:
                date = "February ";
                break;
            case 3:
                date = "March ";
                break;
            case 4:
                date = "April ";
                break;
            case 5:
                date = "May ";
                break;
            case 6:
                date = "June ";
                break;
            case 7:
                date = "July ";
                break;
            case 8:
                date = "August ";
                break;
            case 9:
                date = "September ";
                break;
            case 10:
                date = "October ";
                break;
            case 11:
                date = "November ";
                break;
            case 12:
                date = "December ";
                break;
            default:
                return "Invalid month!";
        }
        
        date += day + ", " + year;
        return date;
    }
}