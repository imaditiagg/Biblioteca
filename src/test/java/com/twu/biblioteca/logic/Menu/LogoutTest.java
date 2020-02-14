package com.twu.biblioteca.logic.Menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class LogoutTest {
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    @BeforeEach
    void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printWriter = mock(PrintWriter.class);
    }

    @Test
    void shouldReturnLoginDescription() {
        MenuItem logout = new Logout("Logout", bufferedReader, printWriter);
        String expectedOutput = "Logout";

        String actualOutput = logout.description();

        assertEquals(expectedOutput, actualOutput);
    }
}