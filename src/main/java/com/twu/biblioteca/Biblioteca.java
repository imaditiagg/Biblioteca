package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

class Biblioteca {

    private void printWelcomeMessage() {
        System.out.println(Message.WELCOME);
    }

    private void printListOfBooks() {
        Library library = new Library();
        ArrayList<Book> books = new ArrayList<>(library.books());
        for (Book book : books) {
            System.out.println(book.name() + "  " + book.author() + "  " + book.publicationYear());
        }
    }

    private void printMenu() {
        System.out.println("         ---------------- MENU --------------        ");
        System.out.println("         1. View Books                               ");
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
            default:
                System.out.println(Message.INVALID_OPTION);
        }
    }
}
