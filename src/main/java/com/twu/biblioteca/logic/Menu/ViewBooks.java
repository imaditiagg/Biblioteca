package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.Library;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

//Job: To Represent ViewBooks Menu Item
public class ViewBooks extends MenuItem {

    public ViewBooks(String description, BufferedReader bufferedReader, PrintWriter printWriter) {
        this.description = description;
        this.bufferedReader = bufferedReader;
        this.printWriter = printWriter;
    }


    @Override
    public String description() {
        return description;
    }

    @Override
    public void action(Library library) {
        StringBuilder booksList = new StringBuilder();
        ArrayList<Book> books = library.books();
        for (Book book : books) {
            booksList.append(book.display(Message.BOOKS_LIST_FORMAT));
        }
        if (booksList.length() != 0) {
            printWriter.println(Message.BOOKS_LIST);
            printWriter.println(booksList.toString());
        } else {
            printWriter.println(Message.NO_BOOK_AVAILABLE);
        }
    }
}
