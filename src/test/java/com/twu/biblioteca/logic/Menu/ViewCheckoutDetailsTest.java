package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ViewCheckoutDetailsTest {
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    @BeforeEach
    void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printWriter = mock(PrintWriter.class);
    }

    @Test
    void shouldReturnLoginDescription() {
        MenuItem login = new Login("Login", bufferedReader, printWriter);
        String expectedOutput = "Login";

        String actualOutput = login.description();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldObtainCheckoutDetails() throws IOException {
        MenuItem viewCheckoutDetails = new ViewCheckoutDetails("View Checkout Details", bufferedReader, printWriter);
        Library libraryMock = mock(Library.class);

        viewCheckoutDetails.action(libraryMock);

        verify(libraryMock, times(1)).obtainCheckoutDetails();
    }
}