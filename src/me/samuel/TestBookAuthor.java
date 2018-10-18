package me.samuel;

import java.util.ArrayList;
import java.util.Scanner;

public class TestBookAuthor {
    public static void main(String[] args) {
        //Create array list only for author.
        //Book usually has 1 author, but an author can have many books.
        Scanner sc = new Scanner(System.in);
        ArrayList<Author> authors = new ArrayList<>();
        String response = "";

        //Create Book object.
        Book aBook = new Book();
        aBook.setTitle("Snow White");

        //Create Author object.
        Author anAuthor = new Author();
        anAuthor.setFirstName("Brothers");
        anAuthor.setLastName("Grimm");
        authors.add(anAuthor);

        //Add these to each other.
        anAuthor.addABook(aBook);
        aBook.setAuthor(anAuthor);

        do {
            //Re-instantiate Author object in this loop.
            anAuthor = new Author();
            System.out.println("Enter an author's first name: ");
            anAuthor.setFirstName(sc.nextLine());
            System.out.println("Enter an author's last name: ");
            anAuthor.setLastName(sc.nextLine());

            //Same for Book object.
            aBook = new Book();
            System.out.println("Enter the title of an author's book: ");
            aBook.setTitle(sc.nextLine());

            //Add these to each other.
            anAuthor.addABook(aBook);
            aBook.setAuthor(anAuthor);

            System.out.println("Add another author's info?");
            response = sc.nextLine();
        }while(response.equalsIgnoreCase("yes"));

        for (Author eachAuthors:authors){
            for (Book eachBook:eachAuthors.getBooks()) {
                System.out.println(eachAuthors.getFirstName()+ " " +eachAuthors.getLastName()+" wrote " +eachBook.getTitle());
            }
        }
    }
}