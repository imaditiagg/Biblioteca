package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public ArrayList<Book> books() {
        return books;
    }
}
