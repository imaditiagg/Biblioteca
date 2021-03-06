package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.logic.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

//Job: To Represent CheckoutBook Menu Item
public class CheckoutBook extends MenuItem {

    public CheckoutBook(String description, BufferedReader bufferedReader, PrintWriter printWriter) {
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
        printWriter.println(Message.ENTER_BOOK_NAME);
        String bookName = bufferedReader.readLine();
        if (library.findInCheckoutBooks(bookName) != null) {
            printWriter.println(Message.UNSUCCESSFUL_CHECKOUT_BOOK);
        } else {
            library.checkoutBook(bookName);
            if (library.findInCheckoutBooks(bookName) != null) {
                printWriter.println(Message.SUCCESSFUL_CHECKOUT_BOOK);
            } else {
                printWriter.println(Message.UNSUCCESSFUL_CHECKOUT_BOOK);
            }
        }
    }
}
