package com.twu.biblioteca;

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
    void shouldDisplayBookDetails(){
        Book book = new Book("Operating system", 1998, "Galvin");
        String expectedOutput = "Operating system"+" ; "+"Galvin"+" ; "+"1998";

        String actualOutput = book.display();

        assertEquals(expectedOutput,actualOutput);
    }
}