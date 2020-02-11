package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Biblioteca;
import com.twu.biblioteca.logic.Library;

// Represent MenuItem
public interface MenuItem {
    String description();

    void action(Library library, Biblioteca biblioteca);
}
