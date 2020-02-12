package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReturnBookTest {
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    @BeforeEach
    void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printWriter = mock(PrintWriter.class);
    }

    @Test
    void shouldReturnReturnBookDescription() {
        MenuItem returnBook = new ReturnBook("Return Book", bufferedReader, printWriter);
        String expectedOutput = "Return Book";

        String actualOutput = returnBook.description();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldCallLibraryReturnBook() throws IOException {
        MenuItem returnBook = new ReturnBook("Return Book", bufferedReader, printWriter);
        Library libraryMock = mock(Library.class);

        returnBook.action(libraryMock);

        verify(libraryMock, times(1)).returnBook(null);
    }

    @Test
    void shouldCallFindInCheckoutBooksInLibrary() throws IOException {
        MenuItem returnBook = new ReturnBook("Return Book", bufferedReader, printWriter);
        Library libraryMock = mock(Library.class);

        returnBook.action(libraryMock);

        verify(libraryMock, times(1)).findInCheckoutBooks(null);
    }
}