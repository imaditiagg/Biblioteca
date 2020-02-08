package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

class Biblioteca {
    Library library;

    Biblioteca() {
        Book book = new Book("The Notebook", 1996, "Nicholas Sparks");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        library = new Library(books);
    }

    private void printWelcomeMessage() {
        System.out.println(Message.WELCOME);
    }

    private void printListOfBooks() {
        ArrayList<Book> books = library.books();
        System.out.println("Name             " + "Author             " + "Publication year ");
        for (Book book : books) {
            System.out.println(book.name() + "     " + book.author() + "    " + book.publicationYear());
        }
    }

    private void printMenu() {
        System.out.println("         ---------------- MENU --------------        ");
        System.out.println("         1. View Books                               ");
        System.out.println("         2. Quit Application                         ");
        System.out.println("         3. Checkout Book                            ");
        System.out.println("         4. Return a Book                            ");
    }

    private void printInvalidOptionMessage() {
        System.out.println(Message.INVALID_OPTION);
    }

    private void quit() {
        System.exit(0);
    }

    private void checkoutBook() {
        System.out.println("Enter book name to checkout : ");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        library.checkoutBook(bookName);
        System.out.println("hello");
        if (library.checkInCheckoutBooks(bookName) != null) {
            System.out.println(Message.SUCCESSFUL_CHECKOUT);
        } else {
            System.out.println(Message.UNSUCCESSFUL_CHECKOUT);
        }
    }

    private void returnBook() {
        System.out.println("Enter book name to return : ");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        if (library.checkInCheckoutBooks(bookName) != null) {
            library.returnBook(bookName);
            System.out.println(Message.SUCCESSFUL_RETURN);
        } else {
            System.out.println(Message.UNSUCCESSFUL_RETURN);
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.printWelcomeMessage();
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        char wantToContinue;
        do {
            biblioteca.printMenu();
            System.out.println("Enter your choice :  ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    biblioteca.printListOfBooks();
                    break;
                case 2:
                    biblioteca.quit();
                    break;
                case 3:
                    biblioteca.checkoutBook();
                    break;
                case 4:
                    biblioteca.returnBook();
                    break;
                default:
                    biblioteca.printInvalidOptionMessage();
                    break;
            }
            System.out.println("Do you want to continue? (Y/N) ");
            wantToContinue = scanner.next().charAt(0);
        }
        while (wantToContinue == 'Y' || wantToContinue == 'y');
    }
}
