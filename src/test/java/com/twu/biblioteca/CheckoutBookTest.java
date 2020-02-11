package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

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
    void shouldCallLibraryCheckout() {
        MenuItem checkoutBook = new CheckoutBook("Checkout Book");
        Library libraryMock = mock(Library.class);
        Biblioteca bibliotecaMock = mock(Biblioteca.class);
        when(bibliotecaMock.getBookNameEnteredByUser()).thenReturn("Harry Potter");

        checkoutBook.action(libraryMock, bibliotecaMock);

        verify(libraryMock, times(1)).checkoutBook("Harry Potter");
    }
}