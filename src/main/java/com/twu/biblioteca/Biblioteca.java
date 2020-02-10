package com.twu.biblioteca;

import java.util.ArrayList;

class Biblioteca {
    private final Library library;
    private final Menu menu;

    Biblioteca() {
        Book book = new Book("The Notebook", 1996, "Nicholas Sparks");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        library = new Library(books);
        MenuItem menuItemOne = new ViewBooks("View Books");
        MenuItem menuItemTwo = new CheckoutBook("Checkout Book");
        MenuItem menuItemThree = new ReturnBook("Return Book");
        MenuItem menuItemFour = new QuitApplication("Quit Application");
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(menuItemOne);
        menuItems.add(menuItemTwo);
        menuItems.add(menuItemThree);
        menuItems.add(menuItemFour);
        menu = new Menu(menuItems);
    }

    public String welcomeMessage() {
        return Message.WELCOME;
    }

    public StringBuilder displayMenu() {
        return menu.display();
    }
}
