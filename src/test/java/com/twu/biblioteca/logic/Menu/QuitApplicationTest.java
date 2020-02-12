package com.twu.biblioteca.logic.Menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class QuitApplicationTest {
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    @BeforeEach
    void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printWriter = mock(PrintWriter.class);
    }

    @Test
    void shouldReturnQuitApplicationDescription() {
        MenuItem quitApplication = new QuitApplication("Quit Application", bufferedReader, printWriter);
        String expectedOutput = "Quit Application";

        String actualOutput = quitApplication.description();

        assertEquals(expectedOutput, actualOutput);
    }
}