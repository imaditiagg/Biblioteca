package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.Message.*;

public class Biblioteca {
    private final Library library;
    private final Menu menu;
    private String bookNameEnteredByUser;
    private String booksList;

    public Biblioteca() {
        this(buildMenu(), buildLibrary());
    }

    Biblioteca(Menu menu, Library library) {
        this.library = library;
        this.menu = menu;
    }

    public String getBooksList() {
        return booksList;
    }

    public void setBooksList(String booksList) {
        this.booksList = booksList;
    }

    public String welcomeMessage() {
        return WELCOME;
    }

    public StringBuilder displayMenu() {
        return menu.display();
    }

    public void execute(int index) {
        menu.onOptionSelect(index, library, this);
    }

    public void setBookNameEnteredByUser(String bookName) {
        bookNameEnteredByUser = bookName;
    }

    public String getBookNameEnteredByUser() {
        return bookNameEnteredByUser;
    }

    public String printEnterBookNameMessage() {
        return ENTER_BOOK_NAME;
    }

    public String printCheckoutStatus() {
        if (library.checkInCheckoutBooks(bookNameEnteredByUser) != null) {
            return SUCCESSFUL_CHECKOUT;
        } else {
            return UNSUCCESSFUL_CHECKOUT;
        }
    }

    public String printReturnStatus() {
        if (library.checkInCheckoutBooks(bookNameEnteredByUser) != null) {
            return SUCCESSFUL_RETURN;
        } else {
            return UNSUCCESSFUL_RETURN;
        }
    }

    private static Library buildLibrary() {
        Book book = new Book("The Notebook", 1996, "Nicholas Sparks");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        return new Library(books);
    }

    private static Menu buildMenu() {
        MenuItem menuItemOne = new ViewBooks("View Books");
        MenuItem menuItemTwo = new CheckoutBook("Checkout Book");
        MenuItem menuItemThree = new ReturnBook("Return Book");
        MenuItem menuItemFour = new QuitApplication("Quit Application");
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(menuItemOne);
        menuItems.add(menuItemTwo);
        menuItems.add(menuItemThree);
        menuItems.add(menuItemFour);
        return new Menu(menuItems);
    }

    public void quit() {
        System.exit(0);
    }
}
