package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BibliotecaTest {

    @Test
    void shouldReturnWelcomeMessage() {
        Biblioteca biblioteca = new Biblioteca();
        String expectedOutput = Message.WELCOME;

        String actualOutput = biblioteca.welcomeMessage();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldReturnMenu() {
        Biblioteca biblioteca = new Biblioteca();
        String expectedOutput = "1.  View Books" + "\n" + "2.  Checkout Book" + "\n" + "3.  Return Book"
                + "\n" + "4.  Quit Application" + "\n";

        String actualOutput = biblioteca.displayMenu().toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldReturnEnterBookNameMessage() {
        Biblioteca biblioteca = new Biblioteca();
        String expectedOutput = Message.ENTER_BOOK_NAME;

        String actualOutput = biblioteca.printEnterBookNameMessage();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldReturnTheBookNameEnteredByUser() {
        Biblioteca biblioteca = new Biblioteca();
        String expectedOutput = "Data Structures";

        biblioteca.setBookNameEnteredByUser("Data Structures");
        String actualOutput = biblioteca.getBookNameEnteredByUser();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldCallOnOptionSelectOfMenu() {
        Library libraryMock = mock(Library.class);
        Menu menuMock = mock(Menu.class);
        Biblioteca biblioteca = new Biblioteca(menuMock, libraryMock);

        biblioteca.execute(0);

        verify(menuMock, times(1)).onOptionSelect(0, libraryMock, biblioteca);
    }

    @Test
    void shouldReturnUnSuccessfulCheckoutStatus() {
        Library libraryMock = mock(Library.class);
        Menu menuMock = mock(Menu.class);
        Biblioteca biblioteca = new Biblioteca(menuMock, libraryMock);
        when(libraryMock.checkInCheckoutBooks("The Notebook")).thenReturn(null);
        String expectedOutput = Message.UNSUCCESSFUL_CHECKOUT;

        String actualOutput = biblioteca.printCheckoutStatus();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldReturnUnSuccessfulReturnStatus() {
        Library libraryMock = mock(Library.class);
        Menu menuMock = mock(Menu.class);
        Biblioteca biblioteca = new Biblioteca(menuMock, libraryMock);
        when(libraryMock.checkInCheckoutBooks("The Notebook")).thenReturn(null);
        String expectedOutput = Message.UNSUCCESSFUL_RETURN;

        String actualOutput = biblioteca.printReturnStatus();
        assertEquals(expectedOutput, actualOutput);
    }
}