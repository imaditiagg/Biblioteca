package com.twu.biblioteca.consoleUI;

import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.Exception.InvalidMenuOption;
import com.twu.biblioteca.logic.Library;
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

    public BibliotecaApp(Menu menu, Library library) {
        this.library = library;
        this.menu = menu;
    }

    public String welcomeMessage() {
        return Message.WELCOME;
    }

    public StringBuilder displayMenu() {
        return menu.display();
    }

    public void execute(int index) throws IOException {
        try {
            menu.onOptionSelect(index, library);
        } catch (InvalidMenuOption exception) {
            printWriter.println(Message.INVALID_OPTION);
        }
    }

    public static void main(String[] args) throws IOException {
        Menu menu = buildMenu();
        Library library = buildLibrary();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(menu, library);

        printWriter.println(bibliotecaApp.welcomeMessage());
        char wantToContinue;
        do {
            printWriter.println(Message.MENU_HEADER);
            printWriter.println(bibliotecaApp.displayMenu());
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
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        return new Library(books);
    }

    private static Menu buildMenu() {
        MenuItem menuItemOne = new ViewBooks("View Books", bufferedReader, printWriter);
        MenuItem menuItemTwo = new CheckoutBook("Checkout Book", bufferedReader, printWriter);
        MenuItem menuItemThree = new ReturnBook("Return Book", bufferedReader, printWriter);
        MenuItem menuItemFour = new QuitApplication("Quit Application", bufferedReader, printWriter);
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(menuItemOne);
        menuItems.add(menuItemTwo);
        menuItems.add(menuItemThree);
        menuItems.add(menuItemFour);
        return new Menu(menuItems);
    }
}
