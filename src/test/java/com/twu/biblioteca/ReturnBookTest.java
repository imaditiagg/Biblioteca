package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

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
    void shouldCallLibraryReturnBook() {
        MenuItem returnBook = new ReturnBook("Return Book");
        Library libraryMock = mock(Library.class);
        Biblioteca bibliotecaMock = mock(Biblioteca.class);
        when(bibliotecaMock.getBookNameEnteredByUser()).thenReturn("Harry Potter");

        returnBook.action(libraryMock, bibliotecaMock);

        verify(libraryMock, times(1)).returnBook("Harry Potter");
    }
}