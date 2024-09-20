 /**
                        * MainLibrary class represents a library system with features such as book management, borrowing, and availability checks.
                        * The library has specific opening hours, addresses, and campuses. Books can be added, borrowed, and returned, and their
                        * availability can be checked. This class serves as the main entry point for the library system.
                        *
                        * @author Cole Lingo
                        */
    
import java.util.ArrayList;
    
                        public class MainLibrary 
                        {
                            // Instance Fields
                            private String address;
                            private String campus;
    
                            // Static field
                            public static ArrayList <String> books = new ArrayList<String> ();
                            
                            // Constructor method to initialize instance field
                            MainLibrary(String address, String campus)
                            {
                                //assigning the fields with a value
                                this.address = address;
                                this.campus = campus;
                            }
    
                            // A static method to print the library opening hours
                            static void openingHours()
                            {
                                //open hours
                                System.out.println("Open Hours: Libraries are open daily from 9am to 5pm.");
                            }
    
                            // Instance method to print the library address
                            void libraryAddress ()
                            {
                                //print out address and campus
                            System.out.println(this.address + this.campus);
                            }
                            // Instance method to add a book to the library
                            void addBook (String book)
                            {
                                //method to add book
                                books.add(book);
                            }
                            // Instance method to borrow a book from the library
                            void borrowBook (String book)
                            {
                                //if book is available in the library
                                if(books.contains (book))
                               {
                                    books.remove(book);
                                    System.out.println (book + " is currently available and ready to get picked");
                               }
                               //if its not available 
                               else
                               {
                                    System.out.println (book + " is not currently available");
                               }
                            }
    
                            // Instance method to print the titles of available books in the library
                            void availabileBooks()
                            {
                                //loop to print the available books
                                for (int i = 0; i < 5; i++)
                                {
                                    System.out.println(books.get(i));
                                }
                            }
    
                            // Main method
                            public static void main(String[] args) 
                            {
                                // Create two libraries (objects) called OxfordLibrary and HamiltonLibrary
                                //sending to the address and caqmpus 
                                MainLibrary OxfordLibrary = new MainLibrary("10 Main St.,", " Oxford OH");
                                MainLibrary HamiltonLibrary = new MainLibrary("228 Liberty St.,", " Hamilton OH");
                                
                                // Call the propoer method to print opening hours
                                //prints open hours
                                MainLibrary.openingHours();
    
                                // Call the proper method to print the addresses
                                //prints out the address and campus
                                OxfordLibrary.libraryAddress();
                                HamiltonLibrary.libraryAddress();

                                // Call the method repeatedly to add four books through the Oxford librarian
                                System.out.println("Oxford librarian is adding four books ...!");
                                //adds books
                                OxfordLibrary.addBook("The Da Vinci Code");
                                OxfordLibrary.addBook("Le Petite Prince");
                                OxfordLibrary.addBook("A Tale of Two Cities");
                                OxfordLibrary.addBook("The Lord of the Rings");
                                
    
                                // Call the proper method repeatedly to add three books through the Hamilton librarian 
                                System.out.println("Hamilton librarian is adding three books ...!");
                                //adds books
                                HamiltonLibrary.addBook("The Lord of the Rings");
                                HamiltonLibrary.addBook("Kill a Mockingbird");
                                HamiltonLibrary.addBook("Pride and Prejudice");
    
                                // Call the proper method to borrow The Lords of the Rings from Oxford library
                                System.out.print("\nSomeone requested \'The Lord of the Rings\' from Oxford library: ");
                                //borrow book
                                OxfordLibrary.borrowBook("The Lord of the Rings");
    
                                // Call the proper method to borrow The Lords of the Rings from Hamilton library
                                System.out.print("\nSomeone requested \'The Lord of the Rings\' from Hamilton library: ");
                                //borrow book
                                 HamiltonLibrary.borrowBook("The Lord of the Rings");

                                // Call the proper method to borrow The Hobbit from the Hamilton library
                                System.out.print("\nSomeone requested \'The Hobbit\' from Hamilton library: ");
                                //borrow book we dont have
                                HamiltonLibrary.borrowBook("The Hobbit");
    
                                // Call the proper method to print the titles of all available books for Oxford librarian
                                System.out.println("\nOxford librarian has requested to display all available books ...");
                                //display all books
                                OxfordLibrary.availabileBooks();
    
                                // Call the proper method to return The Lords of the Rings to the Oxford library
                                System.out.println("\nSomeone returned \'The Lord of the Rings\' to Oxford library ...");
                                //add borrowed book
                                OxfordLibrary.addBook("The Lord of the Rings");
    
                                // Call the proper method to borrow A Tale of Two Cities from the Hamilton library
                                System.out.print("\nSomeone requested \'A Tale of Two Cities\' from Hamilton library: ");
                                //borrow book
                                  HamiltonLibrary.borrowBook("A Tale of Two Cities");
    
                                // Call the proper method to print the titles of available books for Oxford librarian
                                System.out.println("\nOxford librarian has requested to display all available books ...");
                                //print available books 
                                OxfordLibrary.availabileBooks();
                            }
                        }