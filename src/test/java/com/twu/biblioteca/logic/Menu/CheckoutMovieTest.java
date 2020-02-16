package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CheckoutMovieTest {
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    @BeforeEach
    void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printWriter = mock(PrintWriter.class);
    }

    @Test
    void shouldReturnCheckoutMovieDescription() {
        MenuItem checkoutMovie = new CheckoutMovie("Checkout Movie", bufferedReader, printWriter);
        String expectedOutput = "Checkout Movie";

        String actualOutput = checkoutMovie.description();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldCallLibraryCheckout() throws IOException {
        MenuItem checkoutMovie = new CheckoutMovie("Checkout Movie", bufferedReader, printWriter);
        Library libraryMock = mock(Library.class);

        checkoutMovie.action(libraryMock);

        verify(libraryMock, times(1)).checkoutMovie(null);
    }

    @Test
    void shouldCallFindInCheckoutMoviesInLibrary() throws IOException {
        MenuItem checkoutMovie = new CheckoutMovie("Checkout Movie", bufferedReader, printWriter);
        Library libraryMock = mock(Library.class);

        checkoutMovie.action(libraryMock);

        verify(libraryMock, times(2)).findInCheckoutMovies(null);
    }
}