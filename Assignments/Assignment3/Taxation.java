package Assignment3;
//make sure the text works uppercase and lowercase
import java.util.Scanner;

 public class Taxation 
{   
    // A non-instance method to check the value of taxReturn and print a message accordingly
                            
     // Main method
    public static void main(String[] args) 
{
     /*
    The method performs the following tasks:
                                                                        
    - Creates a new Scanner object named keyboard to read user input from the console.
                                    
    - Enters an infinite loop to continuously prompt the user for input.
     //while true loop

    //use break to break loop

    - Asks the user to choose a state for tax operations: California, New York, or Texas.
     //multi way if statement

    - Based on the user's choice of state:
    - Creates an instance of the StateTax class with the appropriate tax rates.
    - Prompts the user to enter their income, property value, and expenses.
    - Calculates and displays income tax, property tax, deductions, and tax return using the TaxCalculator class. 
    //taxation and taxcalculator are sharing info
                                        
    - Asks the user if they want to calculate tax for another state. If the input is 'N', the loop breaks, ending the program execution.
    - Closes the Scanner object to release system resources.
    */

    //makes it so we can use the scanner class
    Scanner keyboard = new Scanner (System.in);

    //inifite loop until the user wants to break it
    while (true) 
    {
        //ask the user to put in a state to check their taxes
        System.out.print("Type [C: California, N: New York, T: Texas] to perform tax operation: ");
        
        //creates but does not initalize 
        StateTax stateTax;

        //takes in the user input
        switch (keyboard.next().toUpperCase())
        {
            //california 
        case "C":
            //all tax rates for california
            stateTax = new StateTax("California", .093, .0725, .0075, .175);
            break;

            //new york
        case "N":
            //all tax rates for new york
            stateTax = new StateTax("New York", .0685, .04, .01, .20);
            break;

            //Texas
        case "T":
            //all tax rates for texas
            stateTax = new StateTax("Texas", 0, .0625, .0181, .15);
            break;

            //default case
        default:
            continue;
        }

        // ask user for income over the year
        System.out.print("Enter your income [e.g., 50000]: ");
        double income = keyboard.nextDouble();

        // ask user for property value 
        System.out.print("Enter your property value [e.g., 250000]: ");
        double propertyValue = keyboard.nextDouble();

        // ask user for expenes this year
        System.out.print("Enter your expenses [e.g., 20000]: ");
        double expenses = keyboard.nextDouble();

        //sends the users income to a method in 'Tax Calculator' then returns the tax numbers to print out 
        double incomeTax = TaxCalculator.calculateIncomeTax(income, stateTax);
        System.out.println("Income tax in " + stateTax.getStateName() + ": $" + incomeTax);

        //sends the users property value to a method in 'Tax Calculator' then returns the tax numbers to print out 
        double propertyTax = TaxCalculator.calculatePropertyTax(propertyValue, stateTax);
        System.out.println("Property tax in " + stateTax.getStateName() + ": $" + propertyTax);

        // adds both number gotten from the methods to see total taxes payed
        double totalTax = TaxCalculator.calculateTotalTax(income, propertyValue, stateTax);

        //sends the users expenses to a method in 'Tax Calculator' then returns the tax numbers to print out 
        double taxDeduction = TaxCalculator.calculateTaxDeductions(expenses, stateTax);
        System.out.println("Tax deductions: $" + taxDeduction);

        //checks if the user owes money or gets money back
        double taxReturn = TaxCalculator.calculateTaxReturn(totalTax, taxDeduction);

            //if negitave they owe money
            if (taxReturn < 0) 
            {
                System.out.println("You owe additional taxes of $" + Math.abs(taxReturn));
            } 
            //if postive they get money back
            else 
            {
                System.out.println("You will receive a tax return of $" + Math.abs(taxReturn));
            }
            
            //ask the user if they need to see their taxes for another state
            System.out.print("Do you want to calculate tax for another state? [Y/N]: ");
            if (keyboard.next().equalsIgnoreCase("N")) 
            {
                break;
            }
            
    }
        keyboard.close();
}
}
                        
                    
