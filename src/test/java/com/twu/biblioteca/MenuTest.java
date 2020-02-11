package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {

    @Test
    void shouldAddAllMenuItemsToMenu() {
        MenuItem menuItemOne = new ViewBooks("View Books");
        MenuItem menuItemTwo = new CheckoutBook("Checkout Book");
        MenuItem menuItemThree = new ReturnBook("Return Book");
        MenuItem menuItemFour = new QuitApplication("Quit Application");
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(menuItemOne);
        menuItems.add(menuItemTwo);
        menuItems.add(menuItemThree);
        menuItems.add(menuItemFour);

        Menu menu = new Menu(menuItems);

        assertEquals(4, menu.noOfMenuItems());
    }

    @Test
    void shouldDisplayMenuItems() {
        MenuItem menuItemOne = new ViewBooks("View Books");
        MenuItem menuItemTwo = new CheckoutBook("Checkout Book");
        MenuItem menuItemThree = new ReturnBook("Return Book");
        MenuItem menuItemFour = new QuitApplication("Quit Application");
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(menuItemOne);
        menuItems.add(menuItemTwo);
        menuItems.add(menuItemThree);
        menuItems.add(menuItemFour);
        Menu menu = new Menu(menuItems);
        String expectedOutput = "1.  View Books" + "\n" + "2.  Checkout Book" + "\n" + "3.  Return Book"
                + "\n" + "4.  Quit Application" + "\n";
        String actualOutput = menu.display().toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldCallViewBooksAction() {
        MenuItem viewBookMenuItemMock = mock(ViewBooks.class);
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(viewBookMenuItemMock);
        Menu menu = new Menu(menuItems);
        Biblioteca bibliotecaMock = mock(Biblioteca.class);
        Book bookMock = mock(Book.class);
        Library libraryMock = mock(Library.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookMock);
        when(libraryMock.books()).thenReturn(books);

        menu.onOptionSelect(0, libraryMock, bibliotecaMock);

        verify(viewBookMenuItemMock, times(1)).action(libraryMock, bibliotecaMock);
    }
}
