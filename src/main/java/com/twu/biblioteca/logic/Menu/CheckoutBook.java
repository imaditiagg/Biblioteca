package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.logic.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

//Job: To Represent CheckoutBook Menu Item
public class CheckoutBook implements MenuItem {
    private final String description;

    public CheckoutBook(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void action(Library library, BufferedReader bufferedReader, PrintWriter printWriter) throws IOException {
        printWriter.println(Message.ENTER_BOOK_NAME);
        printWriter.flush();
        String bookName = bufferedReader.readLine();
        library.checkoutBook(bookName);
        if (library.findInCheckoutBooks(bookName) != null) {
            printWriter.write(Message.SUCCESSFUL_CHECKOUT);
        } else {
            printWriter.write(Message.UNSUCCESSFUL_CHECKOUT);
        }
        printWriter.flush();
    }
}
