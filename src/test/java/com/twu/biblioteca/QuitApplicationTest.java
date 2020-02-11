package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuitApplicationTest {

    @Test
    void shouldReturnQuitApplicationDescription() {
        MenuItem quitApplication = new QuitApplication("Quit Application");
        String expectedOutput = "Quit Application";

        String actualOutput = quitApplication.description();

        assertEquals(expectedOutput, actualOutput);
    }
}