package me.samuel;

import java.util.ArrayList;

public class Author {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    //1 to many: one author has many books
    private ArrayList<Book> books;

    //This is the constructor.
    public Author(){
        books = new ArrayList<>();
    }

    // This step identifies the variables for the object Author.
    public Author(String firstName, String lastName, String email, String phoneNumber){
        books = new ArrayList<>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        books = new ArrayList<>();
    }

    //Add a book. method.
    public void addABook (Book aBook){
        books.add(aBook);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
