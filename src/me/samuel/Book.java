package me.samuel;

import java.util.ArrayList;

public class Book {
    private String title;
    private String isbn;
    private Author author;

    // 1 to 1
    //Does not need array list of authors because each book will have only one author, not two.

    //This is the constructor.
    public Book(){

    }

    //"Instantiating" means creating an instance of a class, and then allocates that instance into memory.
    //In the Main class, we instantiate the Book class to create the object Book with the following properties title, isbn, and author.
    public Book(String title, String isbn, Author author){
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(ArrayList<Author> author) {

    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
