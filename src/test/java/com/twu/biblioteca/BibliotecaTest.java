package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    @Test
    void shouldReturnWelcomeMessage() {
        Biblioteca biblioteca = new Biblioteca();
        String expectedOutput = Message.WELCOME;

        String actualOutput = biblioteca.welcomeMessage();

        assertEquals(expectedOutput, actualOutput);
    }
}