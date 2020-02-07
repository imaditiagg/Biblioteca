package com.twu.biblioteca;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

class Biblioteca {
    Library library;

    Biblioteca() {
        library = new Library();
    }

    private void printWelcomeMessage() {
        System.out.println(Message.WELCOME);
    }

    private void printListOfBooks() {
        ArrayList<Book> books = library.books();
        for (Book book : books) {
            System.out.println(book.name() + "  " + book.author() + "  " + book.publicationYear());
        }
    }

    private void printMenu() {
        System.out.println("         ---------------- MENU --------------        ");
        System.out.println("         1. View Books                               ");
        System.out.println("         2. Quit Application                         ");
        System.out.println("         3. Checkout Book                            ");
    }

    private void printInvalidOptionMessage() {
        System.out.println(Message.INVALID_OPTION);
    }

    private void quit() {
        System.exit(0);
    }

    private void checkoutBook() {
        String bookName = "Operating Systems";
        library.checkout(bookName);
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.printWelcomeMessage();
        biblioteca.printMenu();
        System.out.println("\n");
        System.out.println("         Enter your choice :  ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                biblioteca.printListOfBooks();
                break;
            case 2:
                biblioteca.quit();
            case 3:
                biblioteca.checkoutBook();
            default:
                biblioteca.printInvalidOptionMessage();
        }
    }
}
