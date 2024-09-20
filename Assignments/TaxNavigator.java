/************************************************************
 * This code is suppose to take in Tax Data and use equations
 * to calculate different numbers then output the numbers into
 * another file 
 * @author cole.lingo
*************************************************************/                  
// Import all required classes to complete this task

//imported this so I can get file paths
import java.io.File;
//imported this to make sure if there is a wrong file path
import java.io.FileNotFoundException;
//imported this to read the input file 
import java.util.Scanner;
//importred this to send the outputs to the new file
import java.io.PrintWriter;

// Define a superclass representing State Tax information
class StateTax 
{
    // Instance fields: stateName, incomeTaxRate, propertyTaxRate, and deductionRate
    protected String stateName;
    protected double incomeTaxRate;
    protected double propertyTaxRate;
    protected double deductionTaxRate;

    // Constructor to initialize StateTax objects with specific tax rates
    StateTax (String stateName, double incomeTaxRate, double propertyTaxRate, double deductionTaxRate)
    {
    //constructor
        this.stateName = stateName;
        this.incomeTaxRate = incomeTaxRate;
        this.propertyTaxRate = propertyTaxRate;
        this.deductionTaxRate = deductionTaxRate;
    }

    // Getter methods to access state tax information
    public String getStateName() {return this.stateName;}
    public double getIncomeTaxRate() {return this.incomeTaxRate;}
    public double getPropertyTaxRate() {return this.propertyTaxRate;}
    public double getDeductionTaxRate() {return this.deductionTaxRate;}

    // Method to calculate income tax based on income
    public double calculateIncomeTax(double income)
    {
        //formula for income
        double incomeTax = (income * incomeTaxRate);
        //returns value
        return incomeTax;
    }

    // Method to calculate property tax based on property value
    public double calculatePropertyTax (double propertyValue)
    {
        //formula for property tax
        double propertyTax = (propertyValue * propertyTaxRate);
        //returns value
        return propertyTax;
    }

    // Method to calculate total tax for a given income and property value
    public double calculateTotalTax (double income, double propertyValue)
    {
        //formula for the total taxes payed
        double totalTax = ((income * incomeTaxRate) + (propertyValue * propertyTaxRate));
        //returns value
        return totalTax;
    }                                  
    // Method to calculate tax return based on total tax paid and deductions
    public double calculateTaxReturn (double totalTax, double expenses)
    {
        //formula for if you owe or get money back
        double taxReturn =  (totalTax - (expenses * deductionTaxRate));
        //returns value
        return taxReturn;
    }              
}

//subclass of 'StateTax'
class CaliforniaTax extends StateTax
{
    //uses the constructor from the superclass to initalize the values for California
    CaliforniaTax (String stateName, double incomeTaxRate, double propertyTaxRate, double deductionTaxRate)
    {
        super("California", .093, .0725, .175);
    }

    //method to calucate tax with-holding
    public double calculateTaxWithholding (double grossIncome, int allowances)
    {
        //formula for tax with-holding 
        double taxWithholding = (grossIncome * incomeTaxRate) - (allowances * 100);
        //returns value
        return taxWithholding;
    }
}


// Define a subclass representing New York State Tax, inheriting from StateTax
class NewYorkTax extends StateTax
{
    //uses the superclasses constructor to initalize the values for New York
    public NewYorkTax (String stateName, double incomeTaxRate, double propertyTaxRate, double deductionTaxRate)
    {
        super("New York", .0685, .04, .20) ;
    }

    //Method for tax with-holding
    public double calculateTaxWithholding (double grossIncome)
    {
        //formula for tax with-holding
        double taxWithholding = (grossIncome * incomeTaxRate) - 500;
        //returns value
        return taxWithholding;
    }
}

// Define a main class for navigating tax information
public class TaxNavigator
{
    public static void main(String[] args)
    {
        // Defines the file input
        File fileIn = new File ("/Users/cole.lingo/Desktop/CSE271/Assignments/TaxData.csv");

        //Defines the file output 
        File fileOut = new File ("/Users/cole.lingo/Desktop/CSE271/Assignments/TaxOutputData.csv");
        
        //tries to see if the file paths work
        try
        {
            //The scanner takes in a .csv file
            Scanner reader = new Scanner (fileIn);

            //The printwritter outputs to a .csv file
            PrintWriter output = new PrintWriter (fileOut);

            //skips the header of the .csv file
            reader.nextLine();

            //adds new header for the output file 
            output.println("StateOption,Income,PropertyValue,Expenses,IncomeTax,PropertyTax,TotalTax,Deductions,TaxReturn,TaxWithholding");
            
            //will loop while the file will has a line to read
            while (reader.hasNextLine())
            {
                //initalizes the deduction value
                Double deductions;

                //scanner puts the current line it is reading into a string
                String line = reader.nextLine();

                //takes the string and splits it by a comma into an array
                String[] TaxData = line.split(",");
                
                //takes data from array and puts it into a string 
                String stateName = TaxData[0];

                //takes data from array and puts it into a double 
                double income = Double.parseDouble(TaxData[1]);

                //takes data from array and puts it into a double 
                double propertyValue = Double.parseDouble(TaxData[2]);

                //takes data from array and puts it into a double 
                double expenses = Double.parseDouble(TaxData[3]);

                //if stateName is 'Califoria' it will use the California tax rates
                if (stateName.equals("California"))
                {
                    //creates an instance of CaliforniaTax
                    CaliforniaTax Cali = new CaliforniaTax(stateName, income, propertyValue, expenses);

                    //calls method calculateIncomeTax
                    double incomeTax = Cali.calculateIncomeTax(income);

                    //calls method calculatepropertyTax
                    double propertyTax = Cali.calculatePropertyTax(propertyValue);

                    //calls method calculateTotalTax
                    double taxTotal = Cali.calculateTotalTax(income,propertyValue);

                    //uses variable deductions and uses expenses and getDeductionTaxRate to calculate tax deductions 
                    deductions = expenses * Cali.getDeductionTaxRate();

                    //calls method calculateTaxReturn
                    double taxReturn = Cali.calculateTaxReturn(taxTotal,expenses);

                    //calls method calculateTaxWithholding
                    double TaxWithholding = Cali.calculateTaxWithholding (income, 2);

                    //sned all the values to fill a row in the output file
                    output.println(stateName + "," + income + "," + propertyValue + "," + expenses + "," + incomeTax + "," + propertyTax + "," + taxTotal + "," + deductions + "," + taxReturn + "," + TaxWithholding);
                    
                }
                // if the stateName is 'New York' it will use the New York tax rates
                else if (stateName.equals("New York"))
                {
                    //creates an instance of NewYorkTax
                    NewYorkTax NewYork = new NewYorkTax(stateName, income, propertyValue, expenses);

                    ////calls method calculateIncomeTax
                    double incomeTax = NewYork.calculateIncomeTax(income);

                    //calls method calculatePropertyTax
                    double propertyTax = NewYork.calculatePropertyTax(propertyValue);

                    //calls method calculateTotalTax
                    double taxTotal = NewYork.calculateTotalTax(income,propertyValue);

                    //uses variable deductions and uses expenses and getDeductionTaxRate to calculate tax deductions 
                    deductions = expenses * NewYork.getDeductionTaxRate();

                    //calls method calculateTaxReturn
                    double taxReturn = NewYork.calculateTaxReturn(taxTotal,expenses);

                    //calls method calculateTaxWithholding
                    double TaxWithholding = NewYork.calculateTaxWithholding (income);

                    //send all the values to fill a row in the output file
                    output.println(stateName + "," + income + "," + propertyValue + "," + expenses + "," + incomeTax + "," + propertyTax + "," + taxTotal + "," + deductions + "," + taxReturn + "," + TaxWithholding);
                }
                //if the stateName does not match
                else
                {
                    System.out.println("Please input valid state ('California' or 'New York')");
                }
            }

            //stops taking outputs 
            output.close();

            //stop taking in data from the scanner
            reader.close();
        }

        //if the file path is wrong
        catch (FileNotFoundException wrongFilePath) 
        {
            wrongFilePath.printStackTrace();
        }
    }
}
                    
