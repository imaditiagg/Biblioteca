package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.consoleUI.BibliotecaApp;
import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.Exception.InvalidMenuOption;
import com.twu.biblioteca.logic.Library;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MenuTest {

    public static final int NO_OF_MENU_ITEMS = 4;
    Menu menu;
    ArrayList<MenuItem> menuItems;
    BufferedReader bufferedReaderMock;
    PrintWriter printWriterMock;
    BibliotecaApp bibliotecaAppMock;
    Library libraryMock;

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
    void shouldCallViewBooksAction() throws IOException, InvalidMenuOption {
        MenuItem viewBookMenuItemMock = mock(ViewBooks.class);
        menuItems = new ArrayList<>();
        menuItems.add(viewBookMenuItemMock);
        menu = new Menu(menuItems);
        bibliotecaAppMock = mock(BibliotecaApp.class);
        bufferedReaderMock = mock(BufferedReader.class);
        printWriterMock = mock(PrintWriter.class);
        Book bookMock = mock(Book.class);
        libraryMock = mock(Library.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookMock);
        when(libraryMock.books()).thenReturn(books);

        menu.onOptionSelect(0, libraryMock, bufferedReaderMock, printWriterMock);

        verify(viewBookMenuItemMock, times(1)).action(libraryMock, bufferedReaderMock, printWriterMock);
    }

    @Test
    void shouldCallCheckoutBookAction() throws IOException, InvalidMenuOption {
        MenuItem viewBookMenuItemMock = mock(ViewBooks.class);
        MenuItem checkoutBookMenuItemMock = mock(CheckoutBook.class);
        menuItems = new ArrayList<>();
        menuItems.add(viewBookMenuItemMock);
        menuItems.add(checkoutBookMenuItemMock);
        menu = new Menu(menuItems);
        bibliotecaAppMock = mock(BibliotecaApp.class);
        bufferedReaderMock = mock(BufferedReader.class);
        printWriterMock = mock(PrintWriter.class);
        Book bookMock = mock(Book.class);
        libraryMock = mock(Library.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookMock);
        when(libraryMock.books()).thenReturn(books);

        menu.onOptionSelect(1, libraryMock, bufferedReaderMock, printWriterMock);

        verify(checkoutBookMenuItemMock, times(1)).action(libraryMock, bufferedReaderMock, printWriterMock);
    }

    @Test
    void shouldCallReturnBookAction() throws IOException, InvalidMenuOption {
        MenuItem viewBookMenuItemMock = mock(ViewBooks.class);
        MenuItem checkoutBookMenuItemMock = mock(CheckoutBook.class);
        MenuItem returnBookMenuItemMock = mock(ReturnBook.class);
        menuItems = new ArrayList<>();
        menuItems.add(viewBookMenuItemMock);
        menuItems.add(checkoutBookMenuItemMock);
        menuItems.add(returnBookMenuItemMock);
        menu = new Menu(menuItems);
        bibliotecaAppMock = mock(BibliotecaApp.class);
        bufferedReaderMock = mock(BufferedReader.class);
        printWriterMock = mock(PrintWriter.class);
        Book bookMock = mock(Book.class);
        libraryMock = mock(Library.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookMock);
        when(libraryMock.books()).thenReturn(books);

        menu.onOptionSelect(2, libraryMock, bufferedReaderMock, printWriterMock);

        verify(returnBookMenuItemMock, times(1)).action(libraryMock, bufferedReaderMock, printWriterMock);
    }

    @Test
    void shouldCallQuitApplicationAction() throws IOException, InvalidMenuOption {
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
        bibliotecaAppMock = mock(BibliotecaApp.class);
        bufferedReaderMock = mock(BufferedReader.class);
        printWriterMock = mock(PrintWriter.class);
        Book bookMock = mock(Book.class);
        libraryMock = mock(Library.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookMock);
        when(libraryMock.books()).thenReturn(books);

        menu.onOptionSelect(3, libraryMock, bufferedReaderMock, printWriterMock);

        verify(quitApplicationMock, times(1)).action(libraryMock, bufferedReaderMock, printWriterMock);
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

    @Test
    void shouldNotAllowInvalidMenuOption() {
        Library libraryMock = mock(Library.class);
        BufferedReader bufferedReaderMock = mock(BufferedReader.class);
        PrintWriter printWriterMock = mock(PrintWriter.class);
        Menu menu = new Menu(menuItems);

        assertThrows(InvalidMenuOption.class, () -> menu.onOptionSelect(7, libraryMock, bufferedReaderMock, printWriterMock));
    }
}
