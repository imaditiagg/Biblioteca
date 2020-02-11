package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {

    public static final int NO_OF_MENU_ITEMS = 4;
    Menu menu;
    ArrayList<MenuItem> menuItems;

    @Test
    void shouldAddAllMenuItemsToMenu() {
        MenuItem menuItemOne = new ViewBooks("View Books");
        MenuItem menuItemTwo = new CheckoutBook("Checkout Book");
        MenuItem menuItemThree = new ReturnBook("Return Book");
        MenuItem menuItemFour = new QuitApplication("Quit Application");
        menuItems = new ArrayList<>();
        menuItems.add(menuItemOne);
        menuItems.add(menuItemTwo);
        menuItems.add(menuItemThree);
        menuItems.add(menuItemFour);

        menu = new Menu(menuItems);

        assertEquals(NO_OF_MENU_ITEMS, menu.noOfMenuItems());
    }

    @Test
    void shouldDisplayMenuItems() {
        MenuItem menuItemOne = new ViewBooks("View Books");
        MenuItem menuItemTwo = new CheckoutBook("Checkout Book");
        MenuItem menuItemThree = new ReturnBook("Return Book");
        MenuItem menuItemFour = new QuitApplication("Quit Application");
        menuItems = new ArrayList<>();
        menuItems.add(menuItemOne);
        menuItems.add(menuItemTwo);
        menuItems.add(menuItemThree);
        menuItems.add(menuItemFour);
        menu = new Menu(menuItems);
        String expectedOutput = "1.  View Books" + "\n" + "2.  Checkout Book" + "\n" + "3.  Return Book"
                + "\n" + "4.  Quit Application" + "\n";
        String actualOutput = menu.display().toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldCallViewBooksAction() {
        MenuItem viewBookMenuItemMock = mock(ViewBooks.class);
        menuItems = new ArrayList<>();
        menuItems.add(viewBookMenuItemMock);
        menu = new Menu(menuItems);
        Biblioteca bibliotecaMock = mock(Biblioteca.class);
        Book bookMock = mock(Book.class);
        Library libraryMock = mock(Library.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookMock);
        when(libraryMock.books()).thenReturn(books);

        menu.onOptionSelect(0, libraryMock, bibliotecaMock);

        verify(viewBookMenuItemMock, times(1)).action(libraryMock, bibliotecaMock);
    }

    @Test
    void shouldCallCheckoutBookAction() {
        MenuItem viewBookMenuItemMock = mock(ViewBooks.class);
        MenuItem checkoutBookMenuItemMock = mock(CheckoutBook.class);
        menuItems = new ArrayList<>();
        menuItems.add(viewBookMenuItemMock);
        menuItems.add(checkoutBookMenuItemMock);
        menu = new Menu(menuItems);
        Biblioteca bibliotecaMock = mock(Biblioteca.class);
        Book bookMock = mock(Book.class);
        Library libraryMock = mock(Library.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookMock);
        when(libraryMock.books()).thenReturn(books);

        menu.onOptionSelect(1, libraryMock, bibliotecaMock);

        verify(checkoutBookMenuItemMock, times(1)).action(libraryMock, bibliotecaMock);
    }

    @Test
    void shouldCallReturnBookAction() {
        MenuItem viewBookMenuItemMock = mock(ViewBooks.class);
        MenuItem checkoutBookMenuItemMock = mock(CheckoutBook.class);
        MenuItem returnBookMenuItemMock = mock(ReturnBook.class);
        menuItems = new ArrayList<>();
        menuItems.add(viewBookMenuItemMock);
        menuItems.add(checkoutBookMenuItemMock);
        menuItems.add(returnBookMenuItemMock);
        menu = new Menu(menuItems);
        Biblioteca bibliotecaMock = mock(Biblioteca.class);
        Book bookMock = mock(Book.class);
        Library libraryMock = mock(Library.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookMock);
        when(libraryMock.books()).thenReturn(books);

        menu.onOptionSelect(2, libraryMock, bibliotecaMock);

        verify(returnBookMenuItemMock, times(1)).action(libraryMock, bibliotecaMock);
    }

    @Test
    void shouldCallQuitApplicationAction() {
        MenuItem viewBookMenuItemMock = mock(ViewBooks.class);
        MenuItem checkoutBookMenuItemMock = mock(CheckoutBook.class);
        MenuItem returnBookMenuItemMock = mock(ReturnBook.class);
        MenuItem quitApplicationMock = mock(QuitApplication.class);
        menuItems = new ArrayList<>();
        menuItems.add(viewBookMenuItemMock);
        menuItems.add(checkoutBookMenuItemMock);
        menuItems.add(returnBookMenuItemMock);
        menuItems.add(quitApplicationMock);
        menu = new Menu(menuItems);
        Biblioteca bibliotecaMock = mock(Biblioteca.class);
        Book bookMock = mock(Book.class);
        Library libraryMock = mock(Library.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookMock);
        when(libraryMock.books()).thenReturn(books);

        menu.onOptionSelect(3, libraryMock, bibliotecaMock);

        verify(quitApplicationMock, times(1)).action(libraryMock, bibliotecaMock);
    }

    @Test
    void shouldReturnThatThereAreFourMenuItemsCurrently() {
        MenuItem menuItemOne = new ViewBooks("View Books");
        MenuItem menuItemTwo = new CheckoutBook("Checkout Book");
        MenuItem menuItemThree = new ReturnBook("Return Book");
        MenuItem menuItemFour = new QuitApplication("Quit Application");
        menuItems = new ArrayList<>();
        menuItems.add(menuItemOne);
        menuItems.add(menuItemTwo);
        menuItems.add(menuItemThree);
        menuItems.add(menuItemFour);
        menu = new Menu(menuItems);

        int actualOutput = menu.noOfMenuItems();

        assertEquals(NO_OF_MENU_ITEMS, actualOutput);
    }
}
