package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Library library;

    @Test
    void shouldGetBookOneAvailableInLibrary() {
        Book bookOne = new Book("Operating Systems", 1990, "Galvin");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        library = new Library(books);

        ArrayList<Book> actualBooks = library.books();

        assertIterableEquals(books, actualBooks);
    }

    @Test
    void shouldGetAllBooksAvailableInLibrary() {
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        library = new Library(books);

        ArrayList<Book> actualBooks = library.books();

        assertIterableEquals(books, actualBooks);
    }

    @Test
    void shouldCheckOutBookOneFromLibrary() {
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        library = new Library(books);
        String bookName = "Operating Systems";

        library.checkoutBook(bookName);

        assertFalse(library.books().contains(bookOne));
    }

    @Test
    void shouldCheckForSuccessfulCheckout() {
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        library = new Library(books);
        String bookName = "Operating Systems";

        library.checkoutBook(bookName);

        assertNotEquals(null, library.checkInCheckoutBooks(bookName));
    }

    @Test
    void shouldNotCheckoutBookFromLibrary() {
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        library = new Library(books);
        String bookName = "Operating";

        library.checkoutBook(bookName);

        assertNull(library.checkInCheckoutBooks(bookName));
    }

    @Test
    void shouldReturnBookToTheLibrary() {
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        library = new Library(books);
        String bookName = "Operating Systems";
        library.checkoutBook(bookName);

        library.returnBook(bookName);

        assertTrue(library.books().contains(bookOne));
    }

    @Test
    void shouldNotAllowToReturnABookThatIsNotCheckoutYet() {
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        library = new Library(books);
        String bookName = "Operating Systems";

        library.returnBook(bookName);

        assertNull(library.checkInCheckoutBooks(bookName));
    }
}
