package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;

import java.io.IOException;

// Represent MenuItem
public interface MenuItem {
    String description();

    void action(Library library) throws IOException;
}
