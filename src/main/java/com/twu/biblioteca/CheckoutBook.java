package com.twu.biblioteca;

public class CheckoutBook implements MenuItem {
    private final String description;

    CheckoutBook(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void action(Library library, Biblioteca biblioteca) {
        String bookName = biblioteca.getBookNameEnteredByUser();
        library.checkoutBook(bookName);
    }
}
