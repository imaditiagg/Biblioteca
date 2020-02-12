package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

// Represent MenuItem
public abstract class MenuItem {
    protected String description;
    protected BufferedReader bufferedReader;
    protected PrintWriter printWriter;

    abstract String description();

    abstract void action(Library library) throws IOException;
}
