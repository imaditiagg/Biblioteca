package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class ViewCheckoutDetails extends MenuItem {

    public ViewCheckoutDetails(String description, BufferedReader bufferedReader, PrintWriter printWriter) {
        this.description = description;
        this.bufferedReader = bufferedReader;
        this.printWriter = printWriter;
    }

    @Override
    String description() {
        return description;
    }

    @Override
    void action(Library library) {
        StringBuilder result = library.obtainCheckoutDetails();
        printWriter.println(result);
    }
}
