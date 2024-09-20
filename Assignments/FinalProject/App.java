package FinalProject;

/********************************************************** 
 * This class is used for loading/creating user data, as 
 * well as signing up for the bank and logging in.
 * 
 @author cole.lingo 
 * 
***********************************************************/
//imported so the program can get file paths
import java.io.File;
//imported so if there is a wrong file path it can handle that
import java.io.IOException;
//imported to store user data during runtime of to program
import java.util.ArrayList;
//imported to randomly make a routing number
import java.util.Random;
//imported to read the input file 
import java.util.Scanner;
//importred to send the outputs to the new file
import java.io.PrintWriter;

public class App {
    // these are gobal varibales that will stay the same during the run time of the
    // program so thats why they are static
    static ArrayList<User> users = new ArrayList<>();
    static Scanner keyboard = new Scanner(System.in);
    static Random random = new Random();
    static String filePath = "bankData.csv";
    static File file = new File(filePath);

    /***************************************
     * This method loads user data from a
     * csv file or makes the csv file if one
     * didnt exist already
     ****************************************/
    private static void loadUserData() {
        try {
            // setup the file reader to use later
            Scanner fileReader = new Scanner(file);

            // if the file does not exist already then make it
            if (!file.exists()) {
                file.createNewFile();
            }

            // reads the file
            while (fileReader.hasNextLine()) {
                try {
                    // the userdata is stored in a array and is split the commas
                    String[] userData = fileReader.nextLine().split(",");
                    // then the data in the array is sent to the gobal arraylist so it can be used
                    // in other methods
                    users.add(new RegularUser(userData[0], userData[1], userData[2], userData[3], userData[4], Double.parseDouble(userData[5]), Double.parseDouble(userData[6])));
                }
                // if the arrays cant store data it will go to this catch method and print...
                catch (Exception e) {
                    System.out.println("Error: Could not read data ... problem with arrays.");

                }
            }
            // closes the filereader
            fileReader.close();

        }
        // if file path is wrong then it will go to this catch method and print...
        catch (IOException e) {
            System.out.println("Error: Could not read data ... problem with file path.");
        }

    }

    /**********************************************
     * This method saves the userdata into the csv
     * file, it uses the getter methods from Class
     * User to get the data.
     ***********************************************/
    private static void saveUserData() 
    {
        try {
            // this will print out to the file path given
            PrintWriter output = new PrintWriter(file);

            // for loop that goes through all the data for user
            for (User user : users) {
                // assigns the the getter method variable to variables that are usable in the
                // method
                String fullName = user.getFullName() + ",";
                String userName = user.getUserName() + ",";
                String password = user.getPassword() + ",";
                String email = user.getEmail() + ",";
                String routingNumber = user.getRoutingNumber() + ",";
                String checkingBalance = Double.toString(user.getCheckingBalance()) + ",";
                String savingBalance = Double.toString(user.getSavingBalance());

                // then outputs those the csv file
                output.println(
                        fullName + userName + password + email + routingNumber + checkingBalance + savingBalance);
            }
            // closes the printwriter
            output.close();
        }
        // if the printwriter has the wrong filepath it will catch it and print this
        // method out
        catch (IOException e) {
            System.out.print("Error : Data could not be saved!");
        }

    }

    /******************************************
     * Makes the routing number for the account,
     * then checks if its already in use
     ******************************************/
    private static String generateRoutingNumber() {
        String routingNumber = "";
        boolean exist;

        // use do-while loop to loop the process to check the routing number
        do {
            exist = false;
            // loops through users to see if routing number matches
            for (User user : users) {
                if (user.getRoutingNumber().equals(routingNumber)) {
                    exist = true;
                    break;
                }
            }
            // will make a new routing number if it already exist or is empty
            if (exist || routingNumber.isEmpty()) {
                routingNumber = "";
                for (int i = 0; i < 9; i++) {
                    int randNumber = random.nextInt(10);
                    routingNumber = routingNumber + Integer.toString(randNumber);
                }
            }
        } while (exist || routingNumber.isEmpty());

        // returns to where you called the method
        return routingNumber;

    }

    /****************************************************
     * This method allows the user to sign up for the bank
     * then it calls the method saveUserData to save the
     * info the user just put in
     *****************************************************/
    private static void signUp() 
    {
        // takes inputs and puts them in variables
        System.out.print("Enter your full name: ");
        String fullName = keyboard.nextLine();
        System.out.print("Enter a username: ");
        String username = keyboard.nextLine();
        System.out.print("Enter a password: ");
        String password = keyboard.nextLine();

        // takes the user input for email and checjs if it alreadt exist or follow the
        // email template
        System.out.print("Enter your email address (YOUR_USERNAME@fictionalBank.com): ");
        String email = keyboard.nextLine();

        // loops through user data
        for (User user : users) 
        {
            // if the user inputed email is already used it will tell the user to make a new
            // email
            if (user.getEmail().equals(email)) {
                System.out.print("Email already in uses. Make a new email with the format of ...(YOUR_USERNAME@fictionalBank.com):");
                email = keyboard.nextLine();
            }
            // if the email does not follow the template then it will tell the user to try
            // again
            else if (!email.contains("@fictionalBank.com")) {
                System.out.print("Enter a valid email (YOUR_USERNAME@fictionalBank.com):");
                email = keyboard.nextLine();
            }
            // if it passes both then it will break and we will have the email
            else 
            {
                break;
            }

        }

        // calls method generateRoutingNumber
        String routingNumber = generateRoutingNumber();
        System.out.println("Routing Number:" + routingNumber);

        // takes in the amount of money they are putting into the account
        System.out.print("Enter your initial deposit amount: $");
        Double initialDeposit = keyboard.nextDouble();

        // takes 98% of the money put in and puts that into the checking acount and
        // takes 2% and puts into savings, then adds everything to the arraylist holding
        // everthing
        users.add(new RegularUser(fullName, username, password, email, routingNumber, initialDeposit * .98,
                initialDeposit * .02));
        System.out.println("Account created successfully.");
    }

    /**************************************************
     * This allows already create accounts to log in
     * and gives them a menu on what they can do with
     * their account.
     * 
     ***************************************************/
    public static void logIn() 
    {

        // takes in the username and password
        System.out.print("Enter your username: ");
        String username = keyboard.nextLine();

        System.out.print("Enter your password: ");
        String password = keyboard.nextLine();

        User currentUser = null;
        boolean found = true;

        // then compares them to others in the userdata
        for (User user : users) 
        {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) 
            {
                currentUser = user;
                System.out.println("Login successful....");

                while (true) {
                    System.out.println("*********Main Menu**********");
                    System.out.println("Enter your choice: (H)ome");
                    System.out.println("Enter your choice: (D)eposit");
                    System.out.println("Enter your choice: (W)ithdraw");
                    System.out.println("Enter your choice: (U)pdate");
                    System.out.println("Enter your choice: (T)ransfer");
                    System.out.println("Enter your choice: (C)ancel");
                    System.out.println("Enter your choice: (L)ogOut");
                    System.out.println("***************************");

                    String userInput = keyboard.nextLine();
                    userInput = userInput.toUpperCase();

                    // later I will add bank methods in this switch statement
                    switch (userInput) 
                    {
                        case "H":
                            currentUser.home();
                            break;
                        case "D":
                            currentUser.deposit();
                            break;
                        case "W":
                            currentUser.withdraw();
                            break;
                        case "U":
                            currentUser.update();
                            break;
                        case "T":
                            currentUser.transfer();
                            break;
                        case "C":
                            currentUser.cancel(users);
                            return;
                        case "L":
                            return;
                        default:
                            System.out.println("Please type in valid input");
                    }
                
                }

            }

            // if they put in incorrect info it will ask them to try again
        }
        found = false;
        if (found == false) 
        {
            System.out.println("Incorrect log-in info, try again!");
        }
        
    }

    public static void main(String[] args) 
    {
        // calls the loadUserData method to get the data or create the csv file
        loadUserData();
        String action;

        char choice;

        while (true) 
        {
            System.out.println("*******Fictional Bank Page********");
            System.out.println("***** Enter your choice: (S)ign Up");
            System.out.println("***** Enter your choice: (L)ogIn");
            System.out.println("***** Enter your choice: (E)xit");
            System.out.println("*********************************");

            choice = Character.toUpperCase(choice = keyboard.next().charAt(0));
            keyboard.nextLine();
            saveUserData();

            if(choice == 'S' )
            {
                signUp();
            } 
            else if (choice == 'L') 
            {
                logIn();
            } 
            else if (choice == 'E') 
            {
                break;
            }
        } 

        saveUserData();
        keyboard.close();
    }

}
