package com.twu.biblioteca;

import java.util.ArrayList;

public class ViewBooks implements MenuItem {
    private final String description;

    ViewBooks(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void action(Library library) {
        ArrayList<Book> books = library.books();
        for (Book book : books) {
            book.print();
        }
    }
}
