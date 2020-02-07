package com.twu.biblioteca;

public class Biblioteca {
    Book book;

    public void init() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.init();
    }

    public void addBook(Book book) {
        this.book = book;
    }

    public String viewBook() {
        return this.book.getName();
    }
}
