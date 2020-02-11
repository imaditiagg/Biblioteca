package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Biblioteca;
import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.Library;

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
    public void action(Library library, Biblioteca biblioteca) {
        ArrayList<Book> books = library.books();
        for (Book book : books) {
            biblioteca.setBooksList(book.display());
        }
    }
}
