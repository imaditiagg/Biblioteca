package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CheckoutBookTest {
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    @BeforeEach
    void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printWriter = mock(PrintWriter.class);
    }

    @Test
    void shouldReturnCheckoutBookDescription() {
        MenuItem checkoutBook = new CheckoutBook("Checkout Book", bufferedReader, printWriter);
        String expectedOutput = "Checkout Book";

        String actualOutput = checkoutBook.description();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldCallLibraryCheckout() throws IOException {
        MenuItem checkoutBook = new CheckoutBook("Checkout Book", bufferedReader, printWriter);
        Library libraryMock = mock(Library.class);

        checkoutBook.action(libraryMock);

        verify(libraryMock, times(1)).checkoutBook(null);
    }

    @Test
    void shouldCallFindInCheckoutBooksInLibrary() throws IOException {
        MenuItem checkoutBook = new CheckoutBook("Checkout Book", bufferedReader, printWriter);
        Library libraryMock = mock(Library.class);

        checkoutBook.action(libraryMock);

        verify(libraryMock, times(1)).findInCheckoutBooks(null);
    }
}