package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.logic.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ViewMoviesTest {
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    @BeforeEach
    void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printWriter = mock(PrintWriter.class);
    }

    @Test
    void shouldCallPrintForBothMovies() throws IOException {
        Movie movieMock1 = mock(Movie.class);
        Movie movieMock2 = mock(Movie.class);
        MenuItem viewMovies = new ViewMovies("View Movies", bufferedReader, printWriter);
        Library libraryMock = mock(Library.class);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movieMock1);
        movies.add(movieMock2);
        when(libraryMock.movies()).thenReturn(movies);

        viewMovies.action(libraryMock);

        verify(movieMock1, times(1)).display(Message.MOVIES_LIST_FORMAT);
        verify(movieMock1, times(1)).display(Message.MOVIES_LIST_FORMAT);
    }

    @Test
    void shouldReturnViewMoviesDescription() {
        MenuItem viewMovies = new ViewMovies("View Movies", bufferedReader, printWriter);
        String expectedOutput = "View Movies";

        String actualOutput = viewMovies.description();

        assertEquals(expectedOutput, actualOutput);
    }
}