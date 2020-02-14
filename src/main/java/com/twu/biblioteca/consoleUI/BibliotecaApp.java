package com.twu.biblioteca.consoleUI;

import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.logic.*;
import com.twu.biblioteca.logic.Exception.InvalidMenuOption;
import com.twu.biblioteca.logic.Menu.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

//Job: To provide contract to the client
public class BibliotecaApp {
    private final Library library;
    private final Menu menu;
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(System.out, true);
    static User currentUser;

    public BibliotecaApp(Menu menu, Library library) {
        this.library = library;
        this.menu = menu;
    }

    public String welcomeMessage() {
        return Message.WELCOME;
    }

    public StringBuilder displayDefaultMenu() {
        return menu.display();
    }

    public StringBuilder displayCustomerMenu() {
        return menu.customerDisplay();
    }

    public StringBuilder displayLibrarianMenu() {
        return menu.librarianDisplay();
    }


    public void execute(int index) throws IOException {
        try {
            menu.onOptionSelect(index, library, currentUser);
        } catch (InvalidMenuOption exception) {
            printWriter.println(Message.INVALID_OPTION);
        }
    }

    public static void main(String[] args) throws IOException {
        Menu menu = buildMenu();
        Library library = buildLibrary();
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("101-2020", "12345", false));
        library.addCustomers(customers);
        library.addLibrarian(new Librarian("202-2020", "12345", false));
        BibliotecaApp bibliotecaApp = new BibliotecaApp(menu, library);

        printWriter.println(bibliotecaApp.welcomeMessage());
        char wantToContinue;
        do {
            printWriter.println(Message.MENU_HEADER);
            currentUser = library.checkLoggedInUser();
            if (currentUser == null) {
                printWriter.println(bibliotecaApp.displayDefaultMenu());
            } else if (currentUser.getClass() == Customer.class) {
                printWriter.println(bibliotecaApp.displayCustomerMenu());
            } else {
                printWriter.println(bibliotecaApp.displayLibrarianMenu());
            }
            printWriter.println(Message.ENTER_CHOICE);
            String input = bufferedReader.readLine();
            try {
                int choice = Integer.parseInt(input);
                bibliotecaApp.execute(choice - 1);
            } catch (NumberFormatException exception) {
                printWriter.println(Message.INVALID_OPTION);
            }
            printWriter.println(Message.WANT_TO_CONTINUE);
            wantToContinue = bufferedReader.readLine().charAt(0);
        }
        while (wantToContinue == 'Y' || wantToContinue == 'y');

        bufferedReader.close();
        printWriter.close();
    }

    private static Library buildLibrary() {
        Book bookOne = new Book("The Notebook", 1996, "Nicholas Sparks");
        Book bookTwo = new Book("Harry Potter", 2000, "J. K. Rowling");
        Book bookThree = new Book("Operating System", 1980, "Galvin");
        Movie movie = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        movies.add(movie);
        return new Library(books, movies);
    }

    private static Menu buildMenu() {
        MenuItem menuItemOne = new ViewBooks("View Books", bufferedReader, printWriter);
        MenuItem menuItemTwo = new CheckoutBook("Checkout Book", bufferedReader, printWriter);
        MenuItem menuItemThree = new ReturnBook("Return Book", bufferedReader, printWriter);
        MenuItem menuItemFour = new QuitApplication("Quit Application", bufferedReader, printWriter);
        MenuItem menuItemFive = new ViewMovies("View Movies", bufferedReader, printWriter);
        MenuItem menuItemSix = new CheckoutMovie("Checkout Movie", bufferedReader, printWriter);
        MenuItem menuItemSeven = new ReturnMovie("Return Movie", bufferedReader, printWriter);
        MenuItem menuItemEight = new Login("Login", bufferedReader, printWriter);
        ArrayList<MenuItem> defaultMenuItems = new ArrayList<>();
        ArrayList<MenuItem> customerMenuItems = new ArrayList<>();
        ArrayList<MenuItem> userMenuItems = new ArrayList<>();
        defaultMenuItems.add(menuItemOne);
        defaultMenuItems.add(menuItemFive);
        defaultMenuItems.add(menuItemEight);

        customerMenuItems.add(menuItemOne);
        customerMenuItems.add(menuItemTwo);
        customerMenuItems.add(menuItemThree);
        customerMenuItems.add(menuItemFive);
        customerMenuItems.add(menuItemSix);
        customerMenuItems.add(menuItemSeven);
        customerMenuItems.add(menuItemFour);

        userMenuItems.add(menuItemOne);
        userMenuItems.add(menuItemTwo);
        userMenuItems.add(menuItemThree);
        userMenuItems.add(menuItemFive);
        userMenuItems.add(menuItemSix);
        userMenuItems.add(menuItemSeven);
        userMenuItems.add(menuItemFour);


        return new Menu(defaultMenuItems, customerMenuItems, userMenuItems);
    }
}
