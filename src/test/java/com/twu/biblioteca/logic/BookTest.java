package com.twu.biblioteca.logic;

import com.twu.biblioteca.constants.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookTest {

    @Test
    void shouldGetBookName() {
        Book book = new Book("Operating system", 1998, "Galvin");
        String expectedOutput = "Operating system";

        String actualOutput = book.name();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldEquateABookWithItself() {
        Book book = new Book("Operating system", 1998, "Galvin");

        assertEquals(book, book);
    }


    @Test
    void shouldEquateTwoSameBooks() {
        Book bookOne = new Book("Operating system", 1998, "Galvin");
        Book bookTwo = new Book("Operating system", 1998, "Galvin");

        assertEquals(bookOne, bookTwo);
    }


    @Test
    void shouldNotEquateTwoDifferentBooks() {
        Book bookOne = new Book("Operating system", 1998, "Galvin");
        Book bookTwo = new Book("Operating system", 2000, "Galvin");

        assertNotEquals(bookOne, bookTwo);
    }

    @Test
    void shouldNotEquateBookWithDifferentKindOfObject() {
        Book bookOne = new Book("Operating system", 1998, "Galvin");
        String string = " ";

        assertNotEquals(bookOne, string);
    }

    @Test
    void shouldDisplayBookDetails() {
        Book book = new Book("Operating system", 1998, "Galvin");
        String expectedOutput = "Operating system" + " ;  " + "Galvin" + " ;  " + "1998" + "\n";

        String actualOutput = book.display(Message.BOOKS_LIST_FORMAT);

        assertEquals(expectedOutput, actualOutput);
    }
}