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

    public void checkoutBook(String bookName) {
        for (Book book : books) {
            if (book.name().equals(bookName)) {
                checkoutBooks.add(book);
                books.remove(book);
                break;
            }
        }
    }

    public Book checkInCheckoutBooks(String bookName) {
        for (Book book : checkoutBooks) {
            if (book.name().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public void returnBook(String bookName) {
        if (checkInCheckoutBooks(bookName) != null) {
            for (Book book : checkoutBooks) {
                if (book.name().equals(bookName)) {
                    checkoutBooks.remove(book);
                    books.add(book);
                    break;
                }
            }
        }
    }
}
