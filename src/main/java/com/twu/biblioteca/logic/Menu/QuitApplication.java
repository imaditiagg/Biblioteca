package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

//Job: To represent QuitApplication Menu Item
public class QuitApplication implements MenuItem {
    private final String description;
    private final BufferedReader bufferedReader;
    private final PrintWriter printWriter;

    public QuitApplication(String description, BufferedReader bufferedReader, PrintWriter printWriter) {
        this.description = description;
        this.bufferedReader = bufferedReader;
        this.printWriter = printWriter;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void action(Library library) throws IOException {
        bufferedReader.close();
        printWriter.close();
        System.exit(0);
    }
}
