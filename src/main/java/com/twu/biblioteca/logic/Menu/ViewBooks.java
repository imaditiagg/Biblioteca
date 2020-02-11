package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.Library;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

//Job: To Represent ViewBooks Menu Item
public class ViewBooks implements MenuItem {
    private final String description;

    public ViewBooks(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void action(Library library, BufferedReader bufferedReader, PrintWriter printWriter) {
        String booksList = "";
        ArrayList<Book> books = library.books();
        for (Book book : books) {
            booksList = booksList + book.display();
        }
        printWriter.print(booksList);
    }
}
