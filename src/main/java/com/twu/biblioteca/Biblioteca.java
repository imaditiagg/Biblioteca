package com.twu.biblioteca;

import java.util.ArrayList;

class Biblioteca {
    Library library;

    Biblioteca() {
        Book book = new Book("The Notebook", 1996, "Nicholas Sparks");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        library = new Library(books);
    }

    public String welcomeMessage() {
        return Message.WELCOME;
    }
}
