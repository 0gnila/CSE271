package FinalProject;

/************************************************
 * This is class is used for storing the methods
 * that you can use after you login to the bank
 * 
 * @author: cole.lingo
 ***********************************************/

 //importing the necessary libraries for the program
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



/*******************************************************
 * This class is used for storing user methods and 
 * has the getter and setter methods for the user so we
 * can reference them in the main class and other methods
 * 
 * 
 * @author: cole.lingo
************************************************/
public class User 
{
   //initializing the variables for the user
   private String fullName;
   private String userName;
   private String password;
   private String email;
   private String routingNumber;
   private Double checkingBalance;
   private Double savingBalance;
   static Scanner reader = new Scanner(System.in);

   //constructor for the user
   User(String fullName, String userName, String password, String email, String routingNumber, Double checkingBalance,Double savingBalance) 
   {
      this.fullName = fullName;
      this.userName = userName;
      this.password = password;
      this.email = email;
      this.routingNumber = routingNumber;
      this.checkingBalance = checkingBalance;
      this.savingBalance = savingBalance;
   }

   //getter and setter methods for the user
   public String getFullName() 
   {
      return fullName;
   }

   public String getUserName() 
   {
      return userName;
   }

   public String getPassword() 
   {
      return password;
   }

   public String getEmail() 
   {
      return email;
   }

   public String getRoutingNumber()
   {
      return routingNumber;
   }

   public Double getCheckingBalance() 
   {
      return checkingBalance;
   }

   public Double getSavingBalance() 
   {
      return savingBalance;
   }

   public void setFullName(String fullName) 
   {
      this.fullName = fullName;
   }

   public void setUsername(String userName) 
   {
      this.userName = userName;
   }

   public void setPassword(String password) 
   {
      this.password = password;
   }

   public void setEmail(String email) 
   {
      this.email = email;
   }

   public void setCheckingBalance(double balance) 
   {
      this.checkingBalance = balance;
   }

   public void setSavingBalance(double balance) 
   {
      this.savingBalance = balance;
   }

   /********************************************** 
    * This method is used to display the user's 
    * info when they log in to the bank
    *
    * @author: cole.lingo
   ************************************************/
   public void home()
   {
      // gets the user's info and displays it
      System.out.println("Full name: " + this.fullName);
      System.out.println("Username: " + this.userName);
      System.out.println("Password: " + this.password);
      System.out.println("Email: " + this.email);
      System.out.println("Routing number: " + this.routingNumber);
      System.out.println("Checking account balance: $" + this.checkingBalance);
      System.out.println("Saving account balance: $" + this.savingBalance);
   }

   /****************************************************** 
    * This allows the user to deposit money into their
    * account. The user can choose which account to send
    * the money to and the amount they want to deposit
    *
    * @author: cole.lingo
   *******************************************************/
   public void deposit() 
   {
      //try catch block to catch any errors
      try {
         //displays the options for the user to choose from
         System.out.println("Which account would you like to deposit into?");
         System.out.println("1. Checking account");
         System.out.println("2. Saving account");
         System.out.print("Enter your choice: ");
         int input = reader.nextInt();

         //gets the amount the user wants to deposit
         System.out.print("Enter the amount to deposit: $");
         double amount = reader.nextDouble();

         //switch statement to determine which account to deposit into
         switch (input)
         {
            //if the user chooses the checking account it will deposit 98% of the amount into the checking account and 2% into the saving account
            case 1:
               this.setCheckingBalance(this.getCheckingBalance() + amount * 0.98);
               this.setSavingBalance(this.getSavingBalance() + amount * 0.02);
               System.out.println("Deposit successful. New checking account balance: $" + this.getCheckingBalance());
               break;
            //if the user chooses the saving account it will deposit the full amount into the saving account
            case 2:
               this.setSavingBalance(this.getSavingBalance() + amount);
               System.out.println("Deposit successful. New saving account balance: $" + this.getSavingBalance());
               break;
            //if the user chooses an invalid option it will display an error message
            default:
               System.out.println("Invalid choice.");

         }
      }
      //catches any errors
      catch (Exception e) 
      {
         System.out.println("Error: Invalid input.");
      }
   }

   /******************************************************
   * withdraw method to allow the user to withdraw money 
   * from their account
   * 
   * @auther: cole.lingo
   ******************************************************/
   public void withdraw() 
   {
      //try catch block to catch any errors
      try {
         //displays the options for the user to choose from
         System.out.println("Which account would you like to withdraw from?");

         System.out.println("1. Checking account");

         System.out.println("2. Saving account");

         System.out.print("Enter your choice: ");
         int input = reader.nextInt();

         //gets the amount the user wants to withdraw
         System.out.print("Enter the amount to withdraw: $");
         double amount = reader.nextDouble();

         //switch statement to determine which account to withdraw from
         switch (input) 
         {
            //if the user chooses the checking account it will withdraw the amount from the checking account
            case 1:
               //if the amount is greater than the checking account balance it will display an error message
               if (amount > this.getCheckingBalance()) 
               {
                  System.out.println("Insufficient funds in checking account.");
               } 
               //if the amount is less than the checking account balance it will withdraw the amount from the checking account
               else 
               {
                  this.setCheckingBalance(this.getCheckingBalance() - amount);
                  System.out.println("Withdrawal successful. New checking account balance: $" + this.getCheckingBalance());
               }
               break;
            case 2:
               //we have a withdrawl fee of 5% for the saving account
               double Fee = amount * 0.05;
               //if the amount is greater than the saving account balance it will display an error message
               if (amount + Fee > this.getSavingBalance()) {
                  System.out.println("Insufficient funds in saving account.");
               } 
               //if the amount is less than the saving account balance it will withdraw the amount from the saving account
               else 
               {
                  this.setSavingBalance(this.getSavingBalance() - (amount + Fee));
                  System.out.println("Withdrawal successful. New saving account balance: $" + this.savingBalance);
                  System.out.println("Withdrawal fee of $" + Fee + " has been deducted.");
               }
               break;
            //if the user chooses an invalid option it will display an error message
            default:
               System.out.println("Invalid choice.");
         }
      } 
      //catches any errors
      catch (Exception e) 
      {
         System.out.println("Error: Invalid input.");
      }
   }

   //update method to allow the user to update their profile
   public void update() 
   {
      //try catch block to catch any errors
      try {
         reader.reset();
         System.out.println("Updating profile...");

         //gets the user's new info
         System.out.print("Enter your new full name: ");
         this.setFullName(reader.nextLine());

         //gets the user's new password
         System.out.print("Enter your new password: ");
         this.setPassword(reader.nextLine());

         System.out.println("Profile updated successfully!");
      } 
      //catches any errors
      catch (Exception e) 
      {
         System.out.println("Error: Invalid input.");
      }
   }

   /**************************************
    * transfer method to allow the user 
    * to transfer money to another account
    *
    * @auther: cole.lingo
    **************************************/
   public void transfer () 
   {
      try {
         //gets the user's checking account balance
         System.out.println("Users can transfer money only to accounts associated with the same bank (internal accounts)!");

         //gets the recipient's email
         System.out.print("Enter the recipient's email: ");
         String recieverEmail = reader.next();


         checkingBalance = this.getCheckingBalance();
         boolean found = false;
      
      //loops through the users to find the recipient
      for (User user : App.users)
      {
         //if the recipient is found it will transfer the money
         if (user.getEmail().equals(recieverEmail)) 
         {
            System.out.print("Enter the amount to transfer: $");
            double amount = reader.nextDouble();

            //if the amount is greater than the checking account balance it will display an error message
            if (amount > checkingBalance) 
            {
               System.out.println("Insufficient funds in checking account.");
               found = true;
               break;
            } 
            //if the amount is less than the checking account balance it will transfer that amount to the recipient
            else 
            {
               this.setCheckingBalance(this.getCheckingBalance() - amount);
               user.setCheckingBalance(user.getCheckingBalance() + amount);
               System.out.println("Transfer successful. New checking account balance: $" + this.getCheckingBalance());
               found = true;
               break;
            }
         }
      }

      //if the recipient is not found it will display an error message
      if (found == false) 
      {
         System.out.println("Recipient not found.");
      }
   }
   //catches any errors
   catch (Exception e) 
   {
      System.out.println("Error: Invalid input.");
   }

   }

   /********************************************************** 
   * cancel method to allow the user to delete their account
   *
   * @auther: cole.lingo
   ***********************************************************/
   public void cancel(ArrayList<User> users) 
   {
      //try catch block to catch any errors
      try {
         //makes sure the user wants to delete their account
         reader.reset();
         System.out.print("Would you like to delete your account? Y/N: ");
         String answer = reader.nextLine();
         
         //if the user chooses yes it will delete their account
         if (answer.equalsIgnoreCase( "Y")) 
         {
            //gets the user's username and password
            System.out.print("Enter your username: ");
            String username = reader.nextLine();
            System.out.print("Enter your password: ");
            String password = reader.nextLine();

            //if the username and password match it will delete the account
            if (this.getUserName().equals(username) && this.getPassword().equals(password)) 
            {
               users.remove(this);
               System.out.println("Your account has been deleted successfully!");
            }
            return;
         }
      } 
      //catches any errors
      catch (Exception e) 
      {
         System.out.println("Error: Invalid input.");
      }
   }


}
//makes a sub-class of the user class
class RegularUser extends User 
{
   //constructor for the regular user
   RegularUser(String fullName, String userName, String password, String email, String routingNumber,Double checkingBalance, Double savingBalance) 
   {
      super(fullName, userName, password, email, routingNumber, checkingBalance, savingBalance);
   }
}
