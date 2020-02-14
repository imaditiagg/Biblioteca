package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ViewProfileTest {
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    @BeforeEach
    void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printWriter = mock(PrintWriter.class);
    }

    @Test
    void shouldReturnLoginDescription() {
        MenuItem viewProfile = new ViewProfile("View Profile", bufferedReader, printWriter);
        String expectedOutput = "View Profile";

        String actualOutput = viewProfile.description();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldObtainUserDetails() throws IOException {
        MenuItem viewProfile = new ViewProfile("View Profile", bufferedReader, printWriter);
        Library libraryMock = mock(Library.class);

        viewProfile.action(libraryMock);

        verify(libraryMock, times(1)).obtainUserDetails();
    }
}