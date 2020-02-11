package com.twu.biblioteca.consoleUI;

import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.logic.Menu.*;
import com.twu.biblioteca.logic.Message;
import com.twu.biblioteca.logic.UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//Job: To provide functionality to the client
public class BibliotecaApp implements UserInterface {
    private final Library library;
    private final Menu menu;

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

    public void execute(int index, BufferedReader bufferedReader, PrintWriter printWriter) throws IOException {
        menu.onOptionSelect(index, library, bufferedReader,printWriter);
    }

    public static void main(String[] args) throws IOException {
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

        Book book = new Book("The Notebook", 1996, "Nicholas Sparks");
        Book another = new Book("abc", 1980,"def");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        books.add(another);
        Library library= new Library(books);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(menu,library);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter= new PrintWriter(System.out,true);

        System.out.println(bibliotecaApp.welcomeMessage());
        System.out.println("----------MENU-----------");
        Scanner scanner = new Scanner(System.in);
        char wantToContinue;
        do {
            System.out.println(bibliotecaApp.displayMenu());
            System.out.println("Enter your choice :  ");
            int choice = scanner.nextInt();
            bibliotecaApp.execute(choice-1,bufferedReader,printWriter);
            System.out.println("Do you want to continue? (Y/N) ");
            wantToContinue = scanner.next().charAt(0);
        }
        while (wantToContinue == 'Y' || wantToContinue == 'y');
    }
}
