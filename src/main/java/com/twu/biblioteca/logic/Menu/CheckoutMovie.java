package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.logic.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

//Job: To represent CheckoutMovie Menu Item
public class CheckoutMovie extends MenuItem {

    public CheckoutMovie(String description, BufferedReader bufferedReader, PrintWriter printWriter) {
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
        printWriter.println(Message.ENTER_MOVIE_NAME);
        String movieName = bufferedReader.readLine();
        if (library.findInCheckoutBooks(movieName) != null) {
            printWriter.println(Message.UNSUCCESSFUL_CHECKOUT_BOOK);
        } else {
            library.checkoutMovie(movieName);
            if (library.findInCheckoutMovies(movieName) != null) {
                printWriter.println(Message.SUCCESSFUL_CHECKOUT_MOVIE);
            } else {
                printWriter.println(Message.UNSUCCESSFUL_CHECKOUT_MOVIE);
            }
        }
    }
}
