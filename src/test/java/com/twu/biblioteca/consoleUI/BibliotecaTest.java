package com.twu.biblioteca.consoleUI;

import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.logic.Menu.Menu;
import com.twu.biblioteca.logic.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BibliotecaTest {
    Library libraryMock;
    Menu menuMock;

    @BeforeEach
    public void setUp() {
        libraryMock = mock(Library.class);
        menuMock = mock(Menu.class);
    }

    @Test
    void shouldReturnWelcomeMessage() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(menuMock, libraryMock);
        String expectedOutput = Message.WELCOME;

        String actualOutput = bibliotecaApp.welcomeMessage();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldReturnMenu() {
        BibliotecaApp biblioteca = new BibliotecaApp(menuMock, libraryMock);
        StringBuilder menu = new StringBuilder("1.  View Books" + "\n" + "2.  Checkout Book" + "\n" + "3.  Return Book"
                + "\n" + "4.  Quit Application" + "\n");
        when(menuMock.display()).thenReturn(menu);
        String expectedOutput = "1.  View Books" + "\n" + "2.  Checkout Book" + "\n" + "3.  Return Book"
                + "\n" + "4.  Quit Application" + "\n";

        String actualOutput = biblioteca.displayMenu().toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldCallOnOptionSelectOfMenu() throws IOException {
        Library libraryMock = mock(Library.class);
        Menu menuMock = mock(Menu.class);
        BufferedReader bufferedReaderMock = mock(BufferedReader.class);
        PrintWriter printWriterMock = mock(PrintWriter.class);
        BibliotecaApp biblioteca = new BibliotecaApp(menuMock, libraryMock);

        biblioteca.execute(0, bufferedReaderMock, printWriterMock);

        verify(menuMock, times(1)).onOptionSelect(0, libraryMock, bufferedReaderMock, printWriterMock);
    }
}