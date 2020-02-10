package com.twu.biblioteca;

public class ReturnBook implements MenuItem {
    private final String description;

    ReturnBook(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void action(Library library, Biblioteca biblioteca) {
        String bookName = biblioteca.getBookNameEnteredByUser();
        library.returnBook(bookName);
    }
}
