import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Assignment {

    public static void main(String [] args) {
        final String MONEY_FORMAT = "$#,##0.00";
        
        // Collect Data
        String name = JOptionPane.showInputDialog(null, "What is your name?");
        String ageString = JOptionPane.showInputDialog(null, "What is your age?");
        String salaryString = JOptionPane.showInputDialog(null, "What is your salary? (Do not use a $)");
        
        //Convert age and salary to numerics and apply increases
        Integer age = Integer.valueOf(ageString) + 10;
        Double salary = Double.valueOf(salaryString) * 1.1;

        // Format salary correctly  
        DecimalFormat money = new DecimalFormat(MONEY_FORMAT);
        salaryString = money.format(salary);
        
        JOptionPane.showMessageDialog(null, "In 10 years, you will be " + age + ", and with a 10% raise you will make " + salaryString);
    }
}