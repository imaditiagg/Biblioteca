package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Biblioteca;
import com.twu.biblioteca.logic.Library;

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
    public void action(Library library, Biblioteca biblioteca) {
        String bookName = biblioteca.getBookNameEnteredByUser();
        library.checkoutBook(bookName);
    }
}
