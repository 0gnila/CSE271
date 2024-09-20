package Assignment3;
class TaxCalculator 
{
 //all public static
 // Method to calculate income tax
public static double calculateIncomeTax(double income, StateTax StateTax)
{
    //formula for income
    double incomeTax = income * StateTax.getIncomeTaxRate();
    //returns value to 'Taxation'
    return incomeTax;
}
 // Method to calculate property tax
public static double calculatePropertyTax (double propertyValue, StateTax StateTax)
{
    //formula for property tax
    double propertyTax = propertyValue * StateTax.getPropertyTaxRate();
    //returns value to 'Taxation'
    return propertyTax;
}
// Method to calculate total tax for a given income and property value
public static double calculateTotalTax(double income, double propertyValue, StateTax StateTax)
{
    //formula for the total taxes payed
    double totalTax = (income * StateTax.getIncomeTaxRate()) + (propertyValue * StateTax.getPropertyTaxRate());
    //returns value to 'Taxation'
    return totalTax;
}                      
// Method to calculate tax deductions based on expenses
public static double calculateTaxDeductions (double expenses, StateTax StateTax) 
{
    //formula for deductions
    double taxDeduction = expenses * (StateTax.getDeductionRate());
    //returns value to 'Taxation'
    return taxDeduction;
}
// Method to calculate tax return
public static double calculateTaxReturn (double totalTax, double taxDeduction)
{
    //formula for if you owe or get money back
    double taxReturn =  totalTax - taxDeduction;
    //returns value to 'Taxation'
    return taxReturn;
}                      
}
                    

