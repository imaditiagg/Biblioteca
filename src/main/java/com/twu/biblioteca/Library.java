package com.twu.biblioteca;

public class Library {
    Book book;

    public void addBook(Book book) {
        this.book = book;
    }

    public String viewBook() {
        return this.book.getName();
    }
}
