package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.consoleUI.BibliotecaApp;
import com.twu.biblioteca.logic.Library;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReturnBookTest {
    @Test
    void shouldReturnReturnBookDescription() {
        MenuItem returnBook = new ReturnBook("Return Book");
        String expectedOutput = "Return Book";

        String actualOutput = returnBook.description();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldCallLibraryReturnBook() throws IOException {
        MenuItem returnBook = new ReturnBook("Return Book");
        Library libraryMock = mock(Library.class);
        BufferedReader bufferedReaderMock = mock(BufferedReader.class);
        PrintWriter printWriterMock = mock(PrintWriter.class);

        returnBook.action(libraryMock, bufferedReaderMock,printWriterMock);

        verify(libraryMock, times(1)).returnBook(null);
    }
}