package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

//Job: To represent QuitApplication Menu Item
public class QuitApplication implements MenuItem {
    private final String description;

    public QuitApplication(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void action(Library library, BufferedReader bufferedReader, PrintWriter printWriter) throws IOException {
        bufferedReader.close();
        printWriter.close();
        System.exit(0);
    }
}
