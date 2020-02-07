package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Book> checkoutBooks;

    public Library() {
        books = new ArrayList<>();
        checkoutBooks = new ArrayList<>();
    }

    public Library(ArrayList<Book> books) {
        checkoutBooks = new ArrayList<>();
        this.books = books;
    }

    public ArrayList<Book> books() {
        return books;
    }

    public void checkout(String bookName) {
        for (Book book : books) {
            if (book.name().equals(bookName)) {
                checkoutBooks.add(book);
                books.remove(book);
            }
        }
    }
}
