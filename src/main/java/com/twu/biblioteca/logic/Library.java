package com.twu.biblioteca.logic;

import java.util.ArrayList;

//Job: To Represent Library
public class Library {
    private final ArrayList<Movie> movies;
    private ArrayList<Book> books;
    private ArrayList<Book> checkoutBooks = new ArrayList<>();

    public Library(ArrayList<Book> books, ArrayList<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }

    public ArrayList<Book> books() {
        return books;
    }

    public void checkoutBook(String bookName) {
        for (Book book : books) {
            if (book.name().equals(bookName)) {
                checkoutBooks.add(book);
                books.remove(book);
                break;
            }
        }
    }

    public Book findInCheckoutBooks(String bookName) {
        for (Book book : checkoutBooks) {
            if (book.name().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public void returnBook(String bookName) {
        Book book = findInCheckoutBooks(bookName);
        if (book != null) {
            checkoutBooks.remove(book);
            books.add(book);
        }
    }

    public ArrayList<Movie> movies() {
        return movies;
    }
}
