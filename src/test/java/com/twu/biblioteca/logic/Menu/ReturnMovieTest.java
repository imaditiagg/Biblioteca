package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class ReturnMovieTest {
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    @BeforeEach
    void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printWriter = mock(PrintWriter.class);
    }

    @Test
    void shouldReturnReturnMovieDescription() {
        MenuItem returnMovie = new ReturnMovie("Return Movie", bufferedReader, printWriter);
        String expectedOutput = "Return Movie";

        String actualOutput = returnMovie.description();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldCallLibraryReturnBook() throws IOException {
        MenuItem returnMovie = new ReturnMovie("Return Movie", bufferedReader, printWriter);
        Library libraryMock = mock(Library.class);

        returnMovie.action(libraryMock);

        verify(libraryMock, times(1)).returnMovie(null);
    }

    @Test
    void shouldCallFindInCheckoutBooksInLibrary() throws IOException {
        MenuItem returnMovie = new ReturnMovie("Return Movie", bufferedReader, printWriter);
        Library libraryMock = mock(Library.class);

        returnMovie.action(libraryMock);

        verify(libraryMock, times(1)).findInCheckoutMovies(null);
    }
}