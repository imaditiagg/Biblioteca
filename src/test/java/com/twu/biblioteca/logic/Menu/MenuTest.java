package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.consoleUI.BibliotecaApp;
import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.Exception.InvalidMenuOption;
import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.logic.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MenuTest {
    Menu menu;
    ArrayList<MenuItem> defaultMenuItems = new ArrayList<>();
    ArrayList<MenuItem> customerMenuItems = new ArrayList<>();
    ArrayList<MenuItem> librarianMenuItems = new ArrayList<>();
    BibliotecaApp bibliotecaAppMock;
    Library libraryMock;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    User userMock;

    @BeforeEach
    void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printWriter = mock(PrintWriter.class);
    }

    @Test
    void shouldDisplayDefaultMenuItems() {
        MenuItem menuItemOne = new ViewBooks("View Books", bufferedReader, printWriter);
        MenuItem menuItemTwo = new CheckoutBook("Checkout Book", bufferedReader, printWriter);
        MenuItem menuItemThree = new ReturnBook("Return Book", bufferedReader, printWriter);
        MenuItem menuItemFour = new QuitApplication("Quit Application", bufferedReader, printWriter);
        defaultMenuItems = new ArrayList<>();
        defaultMenuItems.add(menuItemOne);
        defaultMenuItems.add(menuItemTwo);
        defaultMenuItems.add(menuItemThree);
        defaultMenuItems.add(menuItemFour);
        menu = new Menu(defaultMenuItems, customerMenuItems, librarianMenuItems);
        String expectedOutput = "1.  View Books" + "\n" + "2.  Checkout Book" + "\n" + "3.  Return Book"
                + "\n" + "4.  Quit Application" + "\n";
        String actualOutput = menu.display().toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldDisplayCustomerMenuItems() {
        MenuItem menuItemOne = new ViewBooks("View Books", bufferedReader, printWriter);
        MenuItem menuItemTwo = new CheckoutBook("Checkout Book", bufferedReader, printWriter);
        MenuItem menuItemThree = new ReturnBook("Return Book", bufferedReader, printWriter);
        MenuItem menuItemFour = new QuitApplication("Quit Application", bufferedReader, printWriter);
        MenuItem menuItemFive = new ViewMovies("View Movies", bufferedReader, printWriter);
        MenuItem menuItemSix = new CheckoutMovie("Checkout Movie", bufferedReader, printWriter);
        MenuItem menuItemSeven = new ReturnMovie("Return Movie", bufferedReader, printWriter);
        MenuItem menuItemEight = new Logout("Logout", bufferedReader, printWriter);
        customerMenuItems = new ArrayList<>();
        customerMenuItems.add(menuItemOne);
        customerMenuItems.add(menuItemTwo);
        customerMenuItems.add(menuItemThree);
        customerMenuItems.add(menuItemFour);
        customerMenuItems.add(menuItemFive);
        customerMenuItems.add(menuItemSix);
        customerMenuItems.add(menuItemSeven);
        customerMenuItems.add(menuItemEight);

        menu = new Menu(defaultMenuItems, customerMenuItems, librarianMenuItems);
        String expectedOutput = "1.  View Books\n" +
                "2.  Checkout Book\n" +
                "3.  Return Book\n" +
                "4.  Quit Application\n" +
                "5.  View Movies\n" +
                "6.  Checkout Movie\n" +
                "7.  Return Movie\n" +
                "8.  Logout\n";

        String actualOutput = menu.customerDisplay().toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldDisplayLibrarianMenuItems() {
        MenuItem menuItemOne = new ViewBooks("View Books", bufferedReader, printWriter);
        MenuItem menuItemTwo = new CheckoutBook("Checkout Book", bufferedReader, printWriter);
        MenuItem menuItemThree = new ReturnBook("Return Book", bufferedReader, printWriter);
        MenuItem menuItemFour = new QuitApplication("Quit Application", bufferedReader, printWriter);
        MenuItem menuItemFive = new ViewMovies("View Movies", bufferedReader, printWriter);
        MenuItem menuItemSix = new CheckoutMovie("Checkout Movie", bufferedReader, printWriter);
        MenuItem menuItemSeven = new ReturnMovie("Return Movie", bufferedReader, printWriter);
        MenuItem menuItemTen = new ViewProfile("View Profile", bufferedReader, printWriter);
        MenuItem menuItemEight = new Logout("Logout", bufferedReader, printWriter);
        MenuItem menuItemNine = new ViewCheckoutDetails("View Checkout details of users", bufferedReader, printWriter);
        librarianMenuItems = new ArrayList<>();
        librarianMenuItems.add(menuItemOne);
        librarianMenuItems.add(menuItemTwo);
        librarianMenuItems.add(menuItemThree);
        librarianMenuItems.add(menuItemFour);
        librarianMenuItems.add(menuItemFive);
        librarianMenuItems.add(menuItemSix);
        librarianMenuItems.add(menuItemSeven);
        librarianMenuItems.add(menuItemTen);
        librarianMenuItems.add(menuItemNine);
        librarianMenuItems.add(menuItemEight);
        menu = new Menu(defaultMenuItems, customerMenuItems, librarianMenuItems);
        String expectedOutput = "1.  View Books\n" +
                "2.  Checkout Book\n" +
                "3.  Return Book\n" +
                "4.  Quit Application\n" +
                "5.  View Movies\n" +
                "6.  Checkout Movie\n" +
                "7.  Return Movie\n" +
                "8.  View Profile\n" +
                "9.  View Checkout details of users\n" +
                "10.  Logout\n";

        String actualOutput = menu.librarianDisplay().toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldCallViewBooksAction() throws IOException, InvalidMenuOption {
        MenuItem viewBookMenuItemMock = mock(ViewBooks.class);
        defaultMenuItems = new ArrayList<>();
        defaultMenuItems.add(viewBookMenuItemMock);
        menu = new Menu(defaultMenuItems, customerMenuItems, librarianMenuItems);
        bibliotecaAppMock = mock(BibliotecaApp.class);
        Book bookMock = mock(Book.class);
        libraryMock = mock(Library.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookMock);
        when(libraryMock.books()).thenReturn(books);

        menu.onOptionSelect(0, libraryMock, null);

        verify(viewBookMenuItemMock, times(1)).action(libraryMock);
    }

    @Test
    void shouldNotAllowInvalidMenuOption() {
        Library libraryMock = mock(Library.class);
        MenuItem viewBookMenuItemMock = mock(ViewBooks.class);
        MenuItem checkoutBookMenuItemMock = mock(CheckoutBook.class);
        MenuItem returnBookMenuItemMock = mock(ReturnBook.class);
        MenuItem quitApplicationMock = mock(QuitApplication.class);
        defaultMenuItems = new ArrayList<>();
        defaultMenuItems.add(viewBookMenuItemMock);
        defaultMenuItems.add(checkoutBookMenuItemMock);
        defaultMenuItems.add(returnBookMenuItemMock);
        defaultMenuItems.add(quitApplicationMock);
        menu = new Menu(defaultMenuItems, customerMenuItems, librarianMenuItems);


        assertThrows(InvalidMenuOption.class, () -> menu.onOptionSelect(7, libraryMock, null));
    }
}
