package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class ViewBooksTest {

    @Test
    void shouldCallPrintForBothBooks() {
        Book bookMock1 = mock(Book.class);
        Book bookMock2 = mock(Book.class);
        MenuItem viewBooks = new ViewBooks("View Books");
        Library libraryMock = mock(Library.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookMock1);
        books.add(bookMock2);
        when(libraryMock.books()).thenReturn(books);

        viewBooks.action(libraryMock);

        verify(bookMock1, times(1)).print();
        verify(bookMock2, times(1)).print();
    }
}