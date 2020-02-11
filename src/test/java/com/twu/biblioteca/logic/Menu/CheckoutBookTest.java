package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CheckoutBookTest {

    @Test
    void shouldReturnCheckoutBookDescription() {
        MenuItem checkoutBook = new CheckoutBook("Checkout Book");
        String expectedOutput = "Checkout Book";

        String actualOutput = checkoutBook.description();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldCallLibraryCheckout() throws IOException {
        MenuItem checkoutBook = new CheckoutBook("Checkout Book");
        Library libraryMock = mock(Library.class);
        BufferedReader bufferedReaderMock = mock(BufferedReader.class);
        PrintWriter printWriterMock = mock(PrintWriter.class);

        checkoutBook.action(libraryMock, bufferedReaderMock, printWriterMock);

        verify(libraryMock, times(1)).checkoutBook(null);
    }
}