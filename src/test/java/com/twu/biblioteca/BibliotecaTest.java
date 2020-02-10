package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}