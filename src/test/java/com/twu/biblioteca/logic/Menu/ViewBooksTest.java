package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.consoleUI.BibliotecaApp;
import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.Library;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ViewBooksTest {

    @Test
    void shouldCallPrintForBothBooks() throws IOException {
        BufferedReader bufferedReaderMock = mock(BufferedReader.class);
        PrintWriter printWriterMock = mock(PrintWriter.class);
        Book bookMock1 = mock(Book.class);
        Book bookMock2 = mock(Book.class);
        MenuItem viewBooks = new ViewBooks("View Books");
        Library libraryMock = mock(Library.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookMock1);
        books.add(bookMock2);
        when(libraryMock.books()).thenReturn(books);

        viewBooks.action(libraryMock, bufferedReaderMock,printWriterMock);

        verify(bookMock1, times(1)).display();
        verify(bookMock2, times(1)).display();
    }

    @Test
    void shouldReturnViewBooksDescription() {
        MenuItem viewBooks = new ViewBooks("View Books");
        String expectedOutput = "View Books";

        String actualOutput = viewBooks.description();

        assertEquals(expectedOutput, actualOutput);
    }
}