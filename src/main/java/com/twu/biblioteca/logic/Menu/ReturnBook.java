package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.logic.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

//Job: To Represent ReturnBook Menu Item
public class ReturnBook implements MenuItem {
    private final String description;

    public ReturnBook(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void action(Library library, BufferedReader bufferedReader, PrintWriter printWriter) throws IOException {
        printWriter.println(Message.ENTER_BOOK_NAME);
        String bookName = bufferedReader.readLine();
        if (library.findInCheckoutBooks(bookName) != null) {
            printWriter.println(Message.SUCCESSFUL_RETURN);
        } else {
            printWriter.println(Message.UNSUCCESSFUL_RETURN);
        }
        library.returnBook(bookName);
    }
}

