/**
                        * The Library class represents a library management system with functionalities
                        * for managing opening hours, book collections, borrowing, and returning books.
                        * This class supports the implementation of a multisite library system, where Graham
                        * Library and King Library share the same building, and Cincinnati Library is located
                        * on a different site.
                        * 
                        * @author Cole Lingo
                        */

                        import java.util.ArrayList;
                        import java.util.Scanner;

                        public class Library 
                        {
                            // Instance Fields
                            int openingHour;
                            int closingHour;

                            //ArrayList to hold the books in the Library
                            ArrayList<String> books = new ArrayList<>();

                            // Static method to print a welcome message for library visitors
                            static void welcome()
                            {
                                //Welcoming people to the library 
                                System.out.println("\t\t\tWelcome to the library, Enjoy your reading experience!");
                            }
                            // Constructor method to initialize instance fields, openingHour and closingHour
                            Library (int openingHour, int closingHour)
                            {
                                //takes the opening and closing hours
                                this.openingHour = openingHour;
                                this.closingHour = closingHour;
                            }
                            // Copy constructor for shallow copy
                            Library (Library Graham)
                            {
                                //This constructs the shallow copies for Graham and King
                                 this.openingHour = Graham.openingHour;
                                 this.closingHour = Graham.closingHour;
                                 this.books = Graham.books;
                            }
                            // Copy constructor for deep copy
                            Library DeepCopy()
                            {
                                //This creates a deep copy for the cinci library 
                                Library temp = new Library(this);


                                temp.books = new ArrayList<>(this.books);
                                
                                 return temp;
                            }
                            // Instance method to print the library operation hours
                            void LibraryHours()
                            {
                                //prints out the open and closin hours that where gotten from the constructor 
                                System.out.println(openingHour + "am to " + closingHour + "pm.");
                            }
                            // Instance method to update library operation hours
                            void updatedLibraryHours (int updatedOpeningHour, int updatedClosingHour)
                            {
                                //this takes new open and closing hours for libraries
                                this.openingHour = updatedOpeningHour;
                                this.closingHour = updatedClosingHour;
                            }
                            // Instance method to add a book to the library
                            void addBook (ArrayList temp)
                            {
                                //this takes the temp arrays for the book titles and adds them to the main library catalog
                                books.addAll(temp);
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
                            // Instance method to return a borrowed book to the library
                            void ReturnBook (String book)
                            {
                                //method to return book
                                books.add(book);
                            }
                            // Instance method to print the titles of available books in the library
                             void availabileBooks()
                            {
                                //loop to print the available books
                                for (int i = 0; i < books.size(); i++)
                                {
                                    System.out.println(books.get(i));
                                }
                            }
                            // Instance method to search for a book title in the library with certain keyword
                            void SearchBook (String keyWord)
                            {
                                //goes through the catalog of books and looks for keywords 
                                for (int i = 0; i < books.size(); i++)
                                {
                                    if(books.get(i).contains(keyWord))
                                    {
                                        System.out.println(books.get(i));
                                    }
                                }
                            }
                            // -------------------------------- Main Method -------------------------------- //
                            public static void main(String[] args) 
                            {
                                
                                // Call the proper method to welcome readers

                                //calls method to welcome people 
                                Library.welcome();
                                // Create a library instance (object) called GrahamLibrary and initialize the openation hours 9 am - 5 pm

                                //creates new instance and gives opening and closing hours
                                Library GrahamLibrary = new Library (9,5);
                                // Call the proper method to add a set of 4 books through the Graham library

                                //tells person to input books and sends it to a temp array list to then send it to the main 
                                System.out.println("Graham Libray: A librarian is adding four books ...!");
                                
                                //temp Arraylist to store library
                                 ArrayList<String> temp = new ArrayList<>();

                                 //takes in keyboard inputs
                                 Scanner keyboard = new Scanner (System.in);

                                 //adding the four books 
                                 System.out.print("Type a book title: ");
                                 //takes in the next line of text aka book titles
                                 String book = keyboard.nextLine();
                                 //adds to temp arraylist
                                 temp.add(book);
                                 
                                 System.out.print("Type a book title: ");
                                 //takes in the next line of text aka book titles
                                 book = keyboard.nextLine();
                                 //adds to temp arraylist
                                 temp.add(book);

                                 System.out.print("Type a book title: ");
                                 //takes in the next line of text aka book titles
                                 book = keyboard.nextLine();
                                 //adds to temp arraylist
                                 temp.add(book);

                                 System.out.print("Type a book title: ");
                                 //takes in the next line of text aka book titles
                                 book = keyboard.nextLine();
                                 //adds to temp arraylist
                                 temp.add(book);

                                 //send the temp arraylist to the main arraylist
                                 GrahamLibrary.addBook(temp);

                                // Create a library instance (object) called KingLibrary as a shallow copy of GrahamLibrary

                                //creates new instance for king library
                                Library KingLibrary = new Library (GrahamLibrary);

                                // Call the proper method to print the operation hours of King library
                                System.out.print("\nGraham Library Hours: ");
                                //prints out graham library hours
                                GrahamLibrary.LibraryHours();

                                // Call the proper method to add a set of 4 books through the King library
                                System.out.println("\nKing Libray: A librarian is adding four books ...!");

                                //new temp arraylist to hold king library inventory
                                  ArrayList<String> temp2 = new ArrayList<>();
                                  
                                  //adding all four books
                                  System.out.print("Type a book title: ");
                                  //takes in the next line of text aka book titles
                                  String bookKing = keyboard.nextLine();
                                  //adds to temp arraylist
                                  temp2.add(bookKing);

                                  System.out.print("Type a book title: ");
                                  //takes in the next line of text aka book titles
                                  bookKing = keyboard.nextLine();
                                  //adds to temp arraylist
                                  temp2.add(bookKing);

                                  System.out.print("Type a book title: ");
                                  //takes in the next line of text aka book titles
                                  bookKing = keyboard.nextLine();
                                  //adds to temp arraylist
                                  temp2.add(bookKing);

                                  System.out.print("Type a book title: ");
                                  //takes in the next line of text aka book titles
                                  bookKing = keyboard.nextLine();
                                  //adds to temp arraylist
                                  temp2.add(bookKing);

                                  //send the temp arraylist to the main arraylist
                                  KingLibrary.addBook(temp2);

                                // Call the proper method to borrow 'The Explorer's Odyssey' from Graham library
                                System.out.print("\nSomeone requested \'The Explorer's Odyssey\' from Graham library: ");
                                //borrow a book
                                GrahamLibrary.borrowBook("The Explorer's Odyssey");

                                // Call the proper method to borrow 'Adventures in the Unknown' from King library
                                System.out.print("\nSomeone requested \'Adventures in the Unknown\' from King library: ");
                                //borrow a book
                                KingLibrary.borrowBook("Adventures in the Unknown");

                                // Call the proper method to borrow 'Mysteries of the Wilderness' from Graham and King libraries
                                System.out.print("\nSomeone requested \'Mysteries of the Wilderness\' from Graham library: ");
                                //borrow a book
                                GrahamLibrary.borrowBook("Mysteries of the Wilderness");

                                System.out.print("\nSomeone requested \'Mysteries of the Wilderness\' from King library: ");
                                //borrow a book
                                KingLibrary.borrowBook("Mysteries of the Wilderness");
                                
                                // Call the proper method to return 'The Explorer's Odyssey' to Graham library
                                System.out.println("\nSomeone returned \'The Explorer's Odyssey\' to Graham library ...");
                                //return a book
                                GrahamLibrary.ReturnBook("The Explorer's Odyssey");

                                // Call the proper method to print the titles of all available books for King librarian
                                System.out.println("\nKing Library: A librarian has requested to display all available books ...");
                                //checks the inventory of King Library
                                KingLibrary.availabileBooks();

                                // Call the proper method to update operation hours of Graham Library (8am - 6pm)
                                System.out.println("\nGraham library has just requested to update opening hours to 8am - 6pm");
                                //changing the opening and closing hours
                                GrahamLibrary.updatedLibraryHours(8, 6);
                                
                                // Call the proper method to display the operation hours of King library
                                System.out.print("\nKing Library Hours: ");
                                //print hours
                                KingLibrary.LibraryHours();
                                
                                // Create 'CincinnatiLibrary' object as a deep copy of Graham Library
                                //creating the instance of deep copy
                                Library CincinnatiLibrary = GrahamLibrary.DeepCopy();

                                // Call the proper method to add 'Arts Of Life' to the Cincinnati library
                                System.out.println("\nCincinnati Library: A librarian is adding a book titled 'Epic Expeditions: A Saga of Adventure' ...");
                                //add new book to Cinci Library
                                CincinnatiLibrary.ReturnBook("Epic Expeditions: A Saga of Adventure");

                                // Call the proper method to search for books containing the keyword 'Lord' in Cincinnati library
                                System.out.println("\nSearching in Cincinnati library for book titles containing the keyword 'Adventure':");
                                //Using search for keyword
                                CincinnatiLibrary.SearchBook("Adventure");

                                // Call the proper method to print the titles of all available books for Graham librarian
                                System.out.println("\nGraham Library: A librarian has requested to display all available books ...");
                                //priny availabile books
                                GrahamLibrary.availabileBooks();

                                // Call the proper method to update operation hours of Cincinnati Library to 7am - 7pm
                                System.out.println("\nCincinnati library has just requested to update opening hours to 7am - 7pm");
                                //update hours
                                CincinnatiLibrary.updatedLibraryHours(7, 7);

                                // Call the proper method to display the operation hours of Cincinnati library
                                System.out.print("Cincinnati Library Hours: ");
                                //print new hours
                                CincinnatiLibrary.LibraryHours();

                                // Call the proper method to display the operation hours of Graham library
                                System.out.print("\nGraham Library Hours: ");
                                //Print hours
                                GrahamLibrary.LibraryHours();

                                // Close the 'keyboard' object to avoid resource leak
                                keyboard.close();
                            }
                        }
                        