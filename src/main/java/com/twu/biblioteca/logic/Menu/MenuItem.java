package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

// Represent MenuItem
public interface MenuItem {
    String description();

    void action(Library library, BufferedReader bufferedReader, PrintWriter printWriter) throws IOException;
}
