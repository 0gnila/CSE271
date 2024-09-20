package Assignment3;
class StateTax 
 {
     // // Declare instance fields - state name, income tax rate, sales tax rate, property tax rate, and deduction rate - and make them accessible from within this class only 
     //make all field private
     private String stateName;
     private double incomeTaxRate;
     private double saleTaxRate;
     private double propertyTaxRate;
     private double deductionRate;
     // Constructor method to initiliaze all the instance fields
   StateTax (String stateName, double incomeTaxRate, double saleTaxRate, double propertyTaxRate, double deductionRate)
   {
    //constructor for the given data from 'Taxation'
    this.stateName = stateName;
    this.incomeTaxRate = incomeTaxRate;
    this.saleTaxRate = saleTaxRate;
    this.propertyTaxRate = propertyTaxRate;
    this.deductionRate = deductionRate;
   }
     // Define getter methods for all the instance fields but the ones who are accessible from anywhere
     public String getStateName() {return this.stateName;}
     public double getIncomeTaxRate() {return this.incomeTaxRate;}
     public double getSaleTaxRate() {return this.saleTaxRate;}
     public double getPropertyTaxRate() {return this.propertyTaxRate;}
     public double getDeductionRate() {return this.deductionRate;}
 }

