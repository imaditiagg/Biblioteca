package com.twu.biblioteca.logic;

import com.twu.biblioteca.constants.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MovieTest {
    @Test
    void shouldGetMovieName() {
        Movie movie = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");
        String expectedOutput = "Uri: The Surgical Strike";

        String actualOutput = movie.name();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldEquateABookWithItself() {
        Movie movie = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");

        assertEquals(movie, movie);
    }


    @Test
    void shouldEquateTwoSameBooks() {
        Movie movieOne = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");
        Movie movieTwo = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");

        assertEquals(movieOne, movieTwo);
    }


    @Test
    void shouldNotEquateTwoDifferentBooks() {
        Movie movieOne = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");
        Movie movieTwo = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "8");

        assertNotEquals(movieOne, movieTwo);
    }

    @Test
    void shouldNotEquateBookWithDifferentKindOfObject() {
        Movie movie = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");
        String string = " ";

        assertNotEquals(movie, string);
    }

    @Test
    void shouldDisplayBookDetails() {
        Movie movie = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");
        String expectedOutput = "Uri: The Surgical Strike ;   Aditya Dhar ;  2019 ;  9\n";

        String actualOutput = movie.display(Message.MOVIES_LIST_FORMAT);

        assertEquals(expectedOutput, actualOutput);
    }
}