package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Biblioteca;
import com.twu.biblioteca.logic.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class QuitApplicationTest {

    @Test
    void shouldReturnQuitApplicationDescription() {
        MenuItem quitApplication = new QuitApplication("Quit Application");
        String expectedOutput = "Quit Application";

        String actualOutput = quitApplication.description();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldCallQuit() {
        Library libraryMock = mock(Library.class);
        Biblioteca bibliotecaMock = mock(Biblioteca.class);
        MenuItem menuItem = new QuitApplication("Quit Application");

        menuItem.action(libraryMock, bibliotecaMock);

        verify(bibliotecaMock, times(1)).quit();
    }
}