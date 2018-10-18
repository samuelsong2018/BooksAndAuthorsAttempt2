package me.samuel;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Author> allAuthors = new ArrayList<>();
        ArrayList<Book> allBooks = new ArrayList<>();
        String response = "";

        //Creating object 'Author' and adding 'angelou' to the array list 'allAuthors'.
        //'angelou' used to be 'anAuthor'.
        Author angelou = new Author("Maya", "Angelou", "email@email.com", "111-111-1111");
        allAuthors.add(angelou);

        //Creating object 'Book' and adding 'cagedBird' to the array list 'allBooks'.
        //'cagedBird' used to be 'aBook'.
        Book cagedBird = new Book("I Know Why the Caged Bird Sings", "123", angelou);
        allBooks.add(cagedBird);

        int numberChoice = 0;
        Scanner keyboard = new Scanner(System.in);
        do {
            //Listing menu options; prompt user to pick one by entering the corresponding number.
            System.out.println("\nSelect an option number to continue: \n1.Add an author\n2.Add a book" +
                    "\n3.List authors\n4.List books\n5.Add book to pre-existing author\n6.Quit");
            numberChoice = keyboard.nextInt();
            keyboard.nextLine();
            switch (numberChoice) {
                case 1:
                    System.out.println("Add an author");

                    String firstName;
                    String lastName;
                    String email;
                    String phoneNumber;
                    System.out.println("Enter the author's first name: ");
                    firstName = keyboard.nextLine();
                    System.out.println("Enter the author's last name: ");
                    lastName = keyboard.nextLine();
                    System.out.println("Enter author's email: ");
                    email = keyboard.nextLine();
                    System.out.println("Enter author's phone number: ");
                    phoneNumber = keyboard.nextLine();
                    allAuthors.add(new Author(firstName, lastName, email, phoneNumber));
                    break;
                case 2:
                    System.out.println("Add a book: ");

                    String title;
                    String isbn;

                    //The line below identifies the author variable as the object Author.
                    //The author variable needs to be instantiated in each case as so.
                    Author author = new Author();

                    System.out.println("Enter the book's title: ");
                    title = keyboard.nextLine();
                    System.out.println("Enter the book's ISBN: ");
                    isbn = keyboard.nextLine();

                    System.out.println("Would you like to enter the author's information?");
                    response = keyboard.nextLine();

                    //The following prompts for input will follow the the constructor for the Author object.
                    //Always use nextLine after using next, if the user will press the enter key.

                    //You put a semi colon here! Look out!
                    if (response.equals("yes")){
                        System.out.println("Enter the book author's first name: ");
                        author.setFirstName(keyboard.nextLine());
                        keyboard.nextLine();

                        System.out.println("Enter the book author's last name: ");
                        author.setLastName(keyboard.nextLine());
                        keyboard.nextLine();

                        System.out.println("Enter the book author's email address: ");
                        author.setEmail(keyboard.nextLine());
                        keyboard.nextLine();

                        System.out.println("Enter the book author's phone number: ");
                        author.setPhoneNumber(keyboard.nextLine());
                        keyboard.nextLine();
                    }

                    //'author' in this instance will pass in the entire author class.
                    allBooks.add(new Book(title, isbn, author));
                    break;
                case 3:
                    System.out.println("List of authors: ");
                    for(Author bookAuthor : allAuthors){
                        System.out.printf("First Name: %s\nLast Name: %s\nEmail:%s\n Phone Number: %s\n",
                                bookAuthor.getFirstName(), bookAuthor.getLastName(), bookAuthor.getEmail(), bookAuthor.getPhoneNumber());
                    }
                    break;
                case 4:
                    System.out.println("List of books: ");
                    for (Book book : allBooks){
                        System.out.printf("Title: %s\nISBN: %s\nAuthor: %s\n",
                                book.getTitle(), book.getIsbn(), book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
                    }
                    break;
                case 5:
                    System.out.println("Add book to pre-existing author: ");
                    System.out.println("Enter the author's last name: ");
                    lastName = keyboard.nextLine();
                    Author toFind = findAuthorByLastName(lastName, allAuthors);
                    addBookToAuthor(keyboard, toFind);
                    break;
                case 6:
                    System.out.println("Quit");
                    break;
                default:
                    System.out.println("Enter a valid option number.");
            }
        }while (numberChoice!=6);
    }

    //Method 'findAuthorByLastName'.
    private static Author findAuthorByLastName(String lastName, ArrayList<Author> lookHere){
        Author foundAuthor = null;
        for (Author eachAuthor:lookHere){
            if(lastName.equals(eachAuthor.getLastName())){
                foundAuthor=eachAuthor;
            }
        }return foundAuthor;
    }

    private static void addBookToAuthor(Scanner keyboard, Author existingAuthor) {
        System.out.println("Add a book to this author?\nEnter 'yes' to proceed, or 'no' to return to the main menu. ");
        String response = keyboard.nextLine();
        if(response.equalsIgnoreCase("yes")){

            //Instance of new book.
            Book newBook = new Book();

            System.out.println("Enter the book's title: ");
            String newBookTitle = keyboard.nextLine();
            newBook.setTitle(newBookTitle);

            System.out.println("Enter the book's ISBN: ");
            String newBookIsbn = keyboard.nextLine();
            newBook.setIsbn(newBookIsbn);

            //Add book to pre-existing author.
            existingAuthor.addABook(newBook);
        }
    }
}
