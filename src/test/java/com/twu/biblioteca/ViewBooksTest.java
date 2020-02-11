package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ViewBooksTest {

    @Test
    void shouldCallPrintForBothBooks() {
        Biblioteca bibliotecaMock = mock(Biblioteca.class);
        Book bookMock1 = mock(Book.class);
        Book bookMock2 = mock(Book.class);
        MenuItem viewBooks = new ViewBooks("View Books");
        Library libraryMock = mock(Library.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookMock1);
        books.add(bookMock2);
        when(libraryMock.books()).thenReturn(books);

        viewBooks.action(libraryMock, bibliotecaMock);

        verify(bookMock1, times(1)).print();
        verify(bookMock2, times(1)).print();
    }

    @Test
    void shouldReturnViewBooksDescription() {
        MenuItem viewBooks = new ViewBooks("View Books");
        String expectedOutput = "View Books";

        String actualOutput = viewBooks.description();

        assertEquals(expectedOutput, actualOutput);
    }
}