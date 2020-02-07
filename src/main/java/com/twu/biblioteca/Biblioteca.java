package com.twu.biblioteca;

import java.util.ArrayList;

class Biblioteca {

    void printListOfBooks() {
        Library library = new Library();
        ArrayList<Book> books = library.books();
        for (Book book : books) {
            System.out.println(book.name() + "  " + book.author() + "  " + book.publicationYear());
        }
    }

    void printWelcomeMessage() {
        System.out.println(Message.WELCOME);
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.printWelcomeMessage();
        biblioteca.printListOfBooks();
    }
}
